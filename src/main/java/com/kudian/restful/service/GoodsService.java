package com.kudian.restful.service;

import com.kudian.common.persistence.HibernateDao;
import com.kudian.common.service.BaseService;
import com.kudian.common.utils.FileNameUtils;
import com.kudian.common.utils.StringUtils;
import com.kudian.restful.dao.*;
import com.kudian.restful.entity.*;
import com.kudian.restful.vo.goods.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/4/18.
 */
@Service
@Transactional(readOnly = true)
public class GoodsService extends BaseService<Goods, Integer> {
    private static final Logger logger = Logger.getLogger(SellerService.class);

    @Autowired
    private GoodsDao goodsDao;

    @Autowired
    private GoodsPicDao goodsPicDao;

    @Autowired
    private LoginSessionDao loginSessionDao;

    @Autowired
    private MediaResDao mediaResDao;

    @Autowired
    private MediaResService mediaResService;

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public HibernateDao<Goods, Integer> getEntityDao() {
        return goodsDao;
    }

    @Transactional(readOnly = false)
    public Integer saveGoodsAndPics(AddGoodsVO addGoodsVO) {
        Goods goods = new Goods();
        goods.setCatId(addGoodsVO.getCatId());
        goods.setGoodsSn(addGoodsVO.getGoodsSn());
        goods.setGoodsName(addGoodsVO.getGoodsName());
        goods.setShopPrice(addGoodsVO.getShopPrice());
        goods.setGoodsBrief(addGoodsVO.getGoodsBrief());
        goods.setGoodsDesc(addGoodsVO.getGoodsDesc());
        goods.setInventory(addGoodsVO.getInventory());
        goods.setMeasureUnit(addGoodsVO.getMeasureUnit());
        goods.setUnitDesc(addGoodsVO.getUnitDesc());
        goods.setIsReal(addGoodsVO.getIsReal());
        goods.setIsOnSale(addGoodsVO.getIsOnSale());
        goods.setArea(addGoodsVO.getArea());
        goods.setSellerId(addGoodsVO.getSellerId());
        goods.setSellerNote(addGoodsVO.getSellerNote());

        // goods.setSortOrder(addgoodsvo.get);
        goods.setSortOrder(addGoodsVO.getSortOrder());
        goods.setIsDelete(false);

        goods.setBrandId((short) 0);
        goods.setClickCount(0);
        goods.setKeywords("");
        goods.setIsShipping(false);
        Timestamp t = new Timestamp(System.currentTimeMillis());
        goods.setAddTime(t);
        goods.setLastUpdate(t);
        goods.setIsBest(false);
        goods.setIsNew(false);
        goods.setIsHot(false);
        goods.setIsPromote(false);

        this.save(goods);
        if (StringUtils.isNotBlank(addGoodsVO.getPics())) {
            String[] pics = addGoodsVO.getPics().split(",");
            for (String pic : pics) {
                GoodsPic gp = new GoodsPic();
                gp.setGoodsId(goods.getGoodsId());
                gp.setIsDelete(false);
                gp.setLastTime(t);
                gp.setMediaId(pic);
                gp.setSortOrder((short) 0);
                gp.setDirection((short) 0);
                goodsPicDao.save(gp);
            }
        }

        if (StringUtils.isNotBlank(addGoodsVO.getBottomPics())) {
            String[] pics = addGoodsVO.getBottomPics().split(",");
            for (String pic : pics) {
                GoodsPic gp = new GoodsPic();
                gp.setGoodsId(goods.getGoodsId());
                gp.setIsDelete(false);
                gp.setLastTime(t);
                gp.setMediaId(pic);
                gp.setSortOrder((short) 0);
                gp.setDirection((short) 1);
                goodsPicDao.save(gp);
            }
        }
        return goods.getGoodsId();
    }

    /**
     * 获得登录者指定商店的商品列表
     * @param queryGoodsVO
     * @return
     */
    public List<GoodsItemVO> queryGoodsAndPics(QueryGoodsVO queryGoodsVO) {
        LoginSession ent = loginSessionDao.find(queryGoodsVO.getAccess_token());
        if (ent == null) {
            return null;
        }

        List<GoodsItemVO> rets = null;
        String hql = "from Goods g where g.sellerId=:sellerId";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("sellerId", queryGoodsVO.getSellerId());
        List<Goods> gs = goodsDao.find(hql, params);
        for (Goods g : gs) {
            if (rets == null)
                rets = new ArrayList<GoodsItemVO>();

            GoodsItemVO item = new GoodsItemVO();
            item.setCatId(g.getCatId());
            item.setGoodsSn(g.getGoodsSn());
            item.setGoodsName(g.getGoodsName());
            item.setClickCount(g.getClickCount());

            item.setShopPrice(g.getShopPrice());
            item.setGoodsBrief(g.getGoodsBrief());
            item.setGoodsDesc(g.getGoodsDesc());
            item.setIsReal(g.getIsReal());
            item.setIsOnSale(g.getIsOnSale());
            item.setSellerId(g.getSellerId());
            item.setSellerNote(g.getSellerNote());

            item.setMeasureUnit(g.getMeasureUnit());
            item.setUnitDesc(g.getUnitDesc());
            item.setInventory(g.getInventory());
            item.setArea(g.getArea());
            item.setSortOrder(g.getSortOrder());

            // 上架时间
            item.setAddTime(g.getAddTime());
            // TODO 已售出,临时
            item.setSoldnum(0);

            String h1 = "from GoodsPic gp where gp.goodsId=:goodsId and gp.isDelete=0 order by gp.sortOrder";
            Map<String, Object> p1 = new HashMap<String, Object>();
            p1.put("goodsId", g.getGoodsId());
            List<GoodsPic> gps = goodsPicDao.find(h1, p1);

            String pics = "";
            String bottomPics = "";

            boolean isFirst = false;
            boolean isBottomFirst = false;
            for (GoodsPic gp : gps) {
//                MediaRes mr = mediaResDao.find(gp.getMediaId());
//                if (!isFirst) {
//                    pics += gp.getMediaId() + "." + FileNameUtils.getExtName(mr.getFileName());
//                    isFirst = true;
//                } else {
//                    pics += "," + gp.getMediaId() + "." + FileNameUtils.getExtName(mr.getFileName());
//                }
                String url = mediaResService.getResUrl(gp.getMediaId());
                if (0 == gp.getDirection()) {
                    if (!isFirst) {
                        pics += url;
                        isFirst = true;
                    } else {
                        pics += "," + url;
                    }
                } else if (1 == gp.getDirection()) {
                    if (!isBottomFirst) {
                        bottomPics += url;
                        isBottomFirst = true;
                    } else {
                        bottomPics += "," + url;
                    }
                }
            }

            item.setPics(pics);
            item.setBottomPics(bottomPics);
            rets.add(item);
        }
        return rets;
    }

    public List<GoodsByCategoryVO> goodsByCategory(List<GoodsItemVO> infos) {
        List<GoodsByCategoryVO> rets = new ArrayList<GoodsByCategoryVO>();
        if (infos == null || infos.isEmpty()) {
            return rets;
        }

        Map<Integer, List<GoodsItemVO>> map = new HashMap<Integer, List<GoodsItemVO>>();
        for (GoodsItemVO vo : infos) {
            List<GoodsItemVO> gis = null;
            if (map.containsKey(vo.getCatId())) {
                gis = map.get(vo.getCatId());
            } else {
                gis = new ArrayList<GoodsItemVO>();
                map.put(vo.getCatId(), gis);
            }
            gis.add(vo);
        }

        for (Integer catId : map.keySet()) {
            GoodsByCategoryVO gbc = new GoodsByCategoryVO();
            gbc.setCatId(catId);
            Category cate = categoryDao.get(catId);
            if (cate != null) {
                gbc.setCatName(cate.getCatName());
            } else {
                gbc.setCatName("");
            }
            gbc.setItems(map.get(catId));

            rets.add(gbc);
        }
        return rets;
    }

    /**
     * 获得指定商店的商品明细
     * @param goodsId
     * @return
     */
    public GoodsItemVO details(Integer goodsId) {

        Goods g = goodsDao.get(goodsId);

        GoodsItemVO item = new GoodsItemVO();
        item.setCatId(g.getCatId());
        item.setGoodsSn(g.getGoodsSn());
        item.setGoodsName(g.getGoodsName());
        item.setClickCount(g.getClickCount());

        item.setShopPrice(g.getShopPrice());
        item.setGoodsBrief(g.getGoodsBrief());
        item.setGoodsDesc(g.getGoodsDesc());
        item.setIsReal(g.getIsReal());
        item.setIsOnSale(g.getIsOnSale());
        item.setSellerId(g.getSellerId());
        item.setSellerNote(g.getSellerNote());

        item.setMeasureUnit(g.getMeasureUnit());
        item.setUnitDesc(g.getUnitDesc());
        item.setInventory(g.getInventory());
        item.setArea(g.getArea());
        item.setSortOrder(g.getSortOrder());

        // 上架时间
        item.setAddTime(g.getAddTime());
        // TODO 已售出,临时
        item.setSoldnum(0);

        String h1 = "from GoodsPic gp where gp.goodsId=:goodsId and gp.isDelete=0 order by gp.sortOrder";
        Map<String, Object> p1 = new HashMap<String, Object>();
        p1.put("goodsId", g.getGoodsId());
        List<GoodsPic> gps = goodsPicDao.find(h1, p1);

        String pics = "";
        String bottomPics = "";

        boolean isFirst = false;
        boolean isBottomFirst = false;
        for (GoodsPic gp : gps) {

            String url = mediaResService.getResUrl(gp.getMediaId());
            if (0 == gp.getDirection()) {
                if (!isFirst) {
                    pics += url;
                    isFirst = true;
                } else {
                    pics += "," + url;
                }
            } else if (1 == gp.getDirection()) {
                if (!isBottomFirst) {
                    bottomPics += url;
                    isBottomFirst = true;
                } else {
                    bottomPics += "," + url;
                }
            }
        }

        item.setPics(pics);
        item.setBottomPics(bottomPics);
        return item;
    }
}
