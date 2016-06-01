package com.kudian.restful.service;

import com.kudian.common.persistence.HibernateDao;
import com.kudian.common.service.BaseService;
import com.kudian.common.utils.FileNameUtils;
import com.kudian.common.utils.StringUtils;
import com.kudian.restful.dao.*;
import com.kudian.restful.entity.*;
import com.kudian.restful.vo.cart.AddCartInfoVO;
import com.kudian.restful.vo.cart.CartInfoItemVO;
import com.kudian.restful.vo.cart.CartVO;
import com.kudian.restful.vo.cart.QueryCartInfoVO;
import com.kudian.restful.vo.goods.AddGoodsVO;
import com.kudian.restful.vo.goods.GoodsItemVO;
import com.kudian.restful.vo.goods.QueryGoodsVO;
import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.*;

/**
 * Created by Administrator on 2016/4/18.
 */
@Service
@Transactional(readOnly = true)
public class CartService extends BaseService<Cart, Integer> {
    private static final Logger logger = Logger.getLogger(CartService.class);

    @Autowired
    private LoginSessionDao loginSessionDao;

    @Autowired
    private SellerDao sellerDao;

    @Autowired
    private CartDao cartDao;

    @Autowired
    private GoodsDao goodsDao;

    @Autowired
    private GoodsPicDao goodsPicDao;

    // @Autowired
    // private MediaResDao mediaResDao;

    @Autowired
    private MediaResService mediaResService;

    @Override
    public HibernateDao<Cart, Integer> getEntityDao() {
        return cartDao;
    }

    @Transactional(readOnly = false)
    // TODO 继续点击同一款产品时只增加数量
    /**
     * 初次添加购物车
     */
    public void addToCart(AddCartInfoVO vo) {
        LoginSession ls = loginSessionDao.find(vo.getAccess_token());

        Cart cart = new Cart();
        // 当前登录客户版用户，非商家
        cart.setUserId(ls.getUserId());

        cart.setSellerId(vo.getSellerId());
        cart.setGoodsId(vo.getGoodsId());
        cart.setGoodsSn(vo.getGoodsSn());
        cart.setGoodsName(vo.getGoodsName());
        cart.setGoodsPrice(vo.getGoodsPrice());
        cart.setGoodsNumber((short) 1);
        cart.setAddTime(new Timestamp(System.currentTimeMillis()));
        cartDao.save(cart);
    }

    /**
     * 取得当前登录用户中的购物车信息
     * @param vo
     * @return
     */
    public List<CartVO> queryCartInfo(QueryCartInfoVO vo) {
        List<CartVO> rets = null;

        LoginSession ls = loginSessionDao.get(vo.getAccess_token());
        if (ls == null)
            return null;

        List<Cart> cs = cartDao.findbyorder("sellerId", true, Restrictions.eq("userId", ls.getUserId()));

        Map<Integer, List<CartInfoItemVO>> map = new HashMap<Integer, List<CartInfoItemVO>>();
        for (Cart c : cs) {
            List<CartInfoItemVO> civs = null;
            if (!map.containsKey(c.getSellerId())) {
                civs = new ArrayList<CartInfoItemVO>();
                map.put(c.getSellerId(), civs);
            } else {
                civs = map.get(c.getSellerId());
            }

            CartInfoItemVO cinfo = new CartInfoItemVO();
            cinfo.setSellerId(c.getSellerId());
            cinfo.setGoodsId(c.getGoodsId());
            cinfo.setGoodsSn(c.getGoodsSn());
            cinfo.setGoodsName(c.getGoodsName());
            cinfo.setGoodsPrice(c.getGoodsPrice());

            Goods g = goodsDao.find(c.getGoodsId());
            if (g == null) {
                continue;
            }
            cinfo.setGoodsBrief(g.getGoodsBrief());
            cinfo.setGoodsDesc(g.getGoodsDesc());
            cinfo.setIsReal(g.getIsReal());
            cinfo.setSellerNote(g.getSellerNote());

            // 带排序的查询
            List<GoodsPic> gps = goodsPicDao.findbyorder("sortOrder", true, Restrictions.eq("goodsId", g.getGoodsId()),
                    Restrictions.eq("isDelete", false));

            String pics = "";
            boolean isFirst = false;
            for (GoodsPic gp : gps) {
                // MediaRes mr = mediaResDao.find(gp.getMediaId());
                if (!isFirst) {
                    // pics += gp.getMediaId() + "." + FileNameUtils.getExtName(mr.getFileName());
                    pics += mediaResService.getResUrl(gp.getMediaId());
                    isFirst = true;
                } else {
                    pics += "," + mediaResService.getResUrl(gp.getMediaId());
                }
            }
            cinfo.setPics(pics);
            // 添加到list中
            civs.add(cinfo);
        }

        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            Integer key = (Integer) it.next();
            Seller s = sellerDao.find(key);
            if (rets == null)
                rets = new ArrayList<CartVO>();

            CartVO cvo = new CartVO();
            cvo.setSellerId(key);
            cvo.setName(s.getName());
            cvo.setItems(map.get(key));
            rets.add(cvo);
        }

        return rets;
//        List<Cart> cs = cartDao.find(Restrictions.eq("userId", ls.getUserId()));
//        for (Cart c : cs) {
//            if (rets == null)
//                rets = new ArrayList<CartInfoItemVO>();
//
//            CartInfoItemVO cinfo = new CartInfoItemVO();
//            cinfo.setSellerId(c.getSellerId());
//            cinfo.setGoodsId(c.getGoodsId());
//            cinfo.setGoodsSn(c.getGoodsSn());
//            cinfo.setGoodsName(c.getGoodsName());
//            cinfo.setGoodsPrice(c.getGoodsPrice());
//
//            Goods g = goodsDao.find(c.getGoodsId());
//            if (g == null) {
//                continue;
//            }
//            cinfo.setGoodsBrief(g.getGoodsBrief());
//            cinfo.setGoodsDesc(g.getGoodsDesc());
//            cinfo.setIsOnSale(g.getIsOnSale());
//            cinfo.setSellerNote(g.getSellerNote());
//
//            // 带排序的查询
//            List<GoodsPic> gps = goodsPicDao.findbyorder("sortOrder", true, Restrictions.eq("goodsId", g.getGoodsId()),
//                    Restrictions.eq("isDelete", false));
//
//            String pics = "";
//            boolean isFirst = false;
//            for (GoodsPic gp : gps) {
//                // MediaRes mr = mediaResDao.find(gp.getMediaId());
//                if (!isFirst) {
//                    // pics += gp.getMediaId() + "." + FileNameUtils.getExtName(mr.getFileName());
//                    pics += mediaResService.getResUrl(gp.getMediaId());
//                    isFirst = true;
//                } else {
//                    pics += "," + mediaResService.getResUrl(gp.getMediaId());
//                }
//            }
//            cinfo.setPics(pics);
//            rets.add(cinfo);
//        }
//        return rets;
    }
}
