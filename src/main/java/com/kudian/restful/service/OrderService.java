package com.kudian.restful.service;

import com.kudian.common.persistence.HibernateDao;
import com.kudian.common.service.BaseService;
import com.kudian.common.utils.FileNameUtils;
import com.kudian.restful.dao.*;
import com.kudian.restful.entity.*;
import com.kudian.restful.vo.cart.AddCartInfoVO;
import com.kudian.restful.vo.cart.CartInfoItemVO;
import com.kudian.restful.vo.cart.QueryCartInfoVO;
import com.kudian.restful.vo.order.*;
import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Timestamp;
import java.util.*;

/**
 * Created by Administrator on 2016/4/18.
 * 创建订单信息
 */
@Service
@Transactional(readOnly = true)
public class OrderService extends BaseService<OrderInfo, Integer> {
    private static final Logger logger = Logger.getLogger(OrderService.class);

    @Autowired
    private OrderInfoDao orderInfoDao;

    @Autowired
    private LoginSessionDao loginSessionDao;

    @Autowired
    private SellerDao sellerDao;

    @Autowired
    private OrderSellerDao orderSellerDao;

    @Autowired
    private SequenceDao sequenceDao;

    @Autowired
    private OrderGoodsDao orderGoodsDao;

    @Autowired
    private GoodsPicDao goodsPicDao;

    @Autowired
    private MediaResService mediaResService;

    @Override
    public HibernateDao<OrderInfo, Integer> getEntityDao() {
        return orderInfoDao;
    }

    @Transactional(readOnly = false)
    public List<Integer> add(AddOrderVO vo) {
        List<OrderItem> items = vo.getItems();
        List<Integer> ret = new ArrayList<Integer>();
        LoginSession ent = loginSessionDao.get(vo.getAccess_token());
        if (ent == null) {
            return ret;
        }

        // 生成订单时，要校验每个商品的库存是否充实
        List<OrderGoodsVO> ogvs = analysisOrderItem(vo);
        for (OrderGoodsVO ogv : ogvs) {
            OrderInfo oi = new OrderInfo();
            // TODO 生成订单号
            // oi.setOrderSn("00000000000000000");
            oi.setOrderSn(sequenceDao.getSequence());
            oi.setUserId(ent.getUserId());

            // 订单状态
            oi.setOrderStatus((short) 0);
            // 商品配送情况
            oi.setShippingStatus((short) 0);
            // 支付状态
            oi.setPayStatus((short) 0);

            oi.setConsignee(vo.getConsignee());
            oi.setCountry((short) 86);
            oi.setProvince(vo.getProvince());
            oi.setCity(vo.getCity());
            oi.setDistrict(vo.getDistrict());
            oi.setAddress(vo.getAddress());
            oi.setZipcode(vo.getZipcode());
            oi.setTel("");
            oi.setMobile(vo.getMobile());
            oi.setEmail("");
            oi.setBestTime(vo.getBestTime());

            // 订单描述 先不实现
            oi.setPostscript("");

            // TODO 计算金额
            // 总金额
            // oi.setGoodsAmount(0.0);
            oi.setGoodsAmount(ogv.getAmout());
            // 配送费
            oi.setShippingFee(0.0);
            // 应付款
            oi.setOrderAmount(0.0);

            Timestamp t = new Timestamp(System.currentTimeMillis());
            // 默认订单确认和支付的时间与创建时间一致
            oi.setAddTime(t);
            oi.setConfirmTime(t);
            oi.setPayTime(t);
            oi.setShippingTime(t);
            oi.setPayNote("");

            // 保存订单表
            orderInfoDao.save(oi);

            // 保存订单商家表
            Seller s = this.sellerDao.find(ogv.getSellerId());
            OrderSeller os = new OrderSeller();
            os.setOrderId(oi.getOrderId());
            os.setSellerId(ogv.getSellerId());
            os.setIsFirst(s.getIsFirst());
            os.setFirstAmount(s.getFirstAmount());
            os.setIsFullMinus(s.getIsFullMinus());
            os.setFullAmount(s.getFullAmount());
            os.setMinusAmount(s.getMinusAmount());
            os.setIsShippingFree(s.getIsShippingFree());
            os.setShippingFee(s.getShippingFee());
            orderSellerDao.save(os);

            short sortorder = 1;
            // 循环分组中的商品
            for (GoodsInfoVO o : ogv.getGoodsitems()) {
                OrderGoods og = new OrderGoods();
                og.setOrderId(oi.getOrderId());
                og.setGoodsId(o.getGoodsId());
                og.setGoodsName(o.getGoodsName());
                og.setGoodsSn(o.getGoodsSn());
                og.setGoodsNumber(o.getGoodsNumber());
                og.setGoodsPrice(o.getGoodsPrice());
                og.setGoodsAttr("");
                og.setSortOrder(sortorder);
                sortorder++;
                // 保存订单商品表
                orderGoodsDao.save(og);
            }

            // 将生成的订单主键返回
            ret.add(oi.getOrderId());
        }

        return ret;
    }

    /**
     * 分析传入的订单信息，得到商品归属信息，归并
     * @param vo
     */
    private List<OrderGoodsVO> analysisOrderItem(AddOrderVO vo) {
        List<OrderItem> items = vo.getItems();

        Map<Integer, List<OrderItem>> map = new HashMap<Integer, List<OrderItem>>();
        // 合并
        for (OrderItem item : items) {
            if (map.containsKey(item.getSellerId())) {
                List<OrderItem> ois = (List<OrderItem>) map.get(item.getSellerId());
                ois.add(item);
            } else {
                List<OrderItem> ois = new ArrayList<OrderItem>();
                ois.add(item);
                map.put(item.getSellerId(), ois);
            }
        }

        // 计算和整理
        Set<Integer> keys = map.keySet();
        List<OrderGoodsVO> rets = new ArrayList<OrderGoodsVO>();
        for (Integer key : keys) {
            OrderGoodsVO og = new OrderGoodsVO();
            og.setSellerId(key);

            // 本商店货物总金额
            double amount = 0.0;
            // 取出分组的资源
            List<OrderItem> ois  = (List<OrderItem>) map.get(key);
            List<GoodsInfoVO> gil= new ArrayList<GoodsInfoVO>();
            for (OrderItem item : ois) {
                GoodsInfoVO gio = new GoodsInfoVO();

                gio.setGoodsId(item.getGoodsId());
                gio.setGoodsName(item.getGoodsName());
                gio.setGoodsSn(item.getGoodsSn());
                gio.setGoodsNumber(item.getGoodsNumber());
                gio.setGoodsPrice(item.getGoodsPrice());
                amount += item.getGoodsPrice() * item.getGoodsNumber();
                gil.add(gio);
            }
            og.setGoodsitems(gil);
            // TODO 先做最简单运算
            og.setAmout(amount);
            rets.add(og);
        }

        return rets;
    }

    /**
     * 客户自己的查询
     * @param vo
     * @return
     */
    public QueryOrderInfoRetVO querybyself(QueryOrderVO vo) {
        QueryOrderInfoRetVO o = new QueryOrderInfoRetVO();
        LoginSession ent = loginSessionDao.get(vo.getAccess_token());
        if (ent == null) {
            return o;
        }

        List<OrderVO> orders = new ArrayList<OrderVO>();
        List<OrderInfo> ois = orderInfoDao.findbyorder("addTime", false, Restrictions.eq("userId", ent.getUserId()));
        for (OrderInfo oi : ois) {
            // 表结构中是 1对多的关系，但这里使用了1对1 的关系，orderinfo : orderseller 一个订单对应一个商家
            OrderSeller os = orderSellerDao.findUnique(Restrictions.eq("orderId", oi.getOrderId()));
            Seller s = sellerDao.find(os.getSellerId());

            OrderVO orderVO = new OrderVO();
            orderVO.setSellerId(os.getSellerId());
            // 商家名称
            orderVO.setName(s.getName());

            orderVO.setOrderId(oi.getOrderId());
            orderVO.setOrderSn(oi.getOrderSn());
            orderVO.setOrderStatus(oi.getOrderStatus());
            orderVO.setShippingStatus(oi.getShippingStatus());
            orderVO.setPayStatus(oi.getPayStatus());
            // 收件人
            orderVO.setConsignee(oi.getConsignee());
            orderVO.setCountry(oi.getCountry());
            orderVO.setProvince(oi.getProvince());
            orderVO.setCity(oi.getCity());
            orderVO.setDistrict(oi.getDistrict());
            orderVO.setAddress(oi.getAddress());
            orderVO.setZipcode(oi.getZipcode());
            orderVO.setTel(oi.getTel());
            orderVO.setMobile(oi.getMobile());
            orderVO.setEmail(oi.getEmail());
            orderVO.setBestTime(oi.getBestTime());
            orderVO.setGoodsAmount(oi.getGoodsAmount());
            orderVO.setShippingFee(oi.getShippingFee());
            orderVO.setOrderAmount(oi.getOrderAmount());
            orderVO.setAddTime(oi.getAddTime());
            orderVO.setConfirmTime(oi.getConfirmTime());
            orderVO.setPayTime(oi.getPayTime());
            orderVO.setShippingTime(oi.getShippingTime());
            orderVO.setPayNote(oi.getPayNote());

            // 订单商品明细
            List<OrderGoods> ogs = orderGoodsDao.findbyorder("sortOrder", true, Restrictions.eq("orderId", oi.getOrderId()));
            List<OrderItemVO> items = null;
            for (OrderGoods og : ogs) {
                if (items == null)
                    items = new ArrayList<OrderItemVO>();

                OrderItemVO oivo = new OrderItemVO();
                // oivo.setSellerId();
                oivo.setGoodsId(og.getGoodsId());
                oivo.setGoodsSn(og.getGoodsSn());
                oivo.setGoodsName(og.getGoodsName());
                oivo.setGoodsPrice(og.getGoodsPrice());

                // 带排序的查询
                List<GoodsPic> gps = goodsPicDao.findbyorder("sortOrder", true, Restrictions.eq("goodsId", og.getGoodsId()),
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
                oivo.setPics(pics);
                items.add(oivo);
            }
            orderVO.setItems(items);

            orders.add(orderVO);
        }

        o.setOrders(orders);
        return o;
    }

    /**
     * 商家查询订单
     * @param vo
     * @return
     */
    public QueryOrderInfoRetVO querybybus(QueryOrderVO vo) {
        QueryOrderInfoRetVO o = new QueryOrderInfoRetVO();
        LoginSession ent = loginSessionDao.get(vo.getAccess_token());
        if (ent == null) {
            return o;
        }

        // 一个用户有且仅有一个店铺
        Seller s = sellerDao.findUnique(Restrictions.eq("userId", ent.getUserId()));
        if (s == null) {
            return o;
        }

        // 商家版是从orderseller表开始查询的
        List<OrderVO> orders = new ArrayList<OrderVO>();
        List<OrderSeller> oss = orderSellerDao.findbyorder("osId", false, Restrictions.eq("sellerId", s.getSellerId()));
        for (OrderSeller os : oss) {
            OrderInfo oi = this.orderInfoDao.find(os.getOrderId());

            OrderVO orderVO = new OrderVO();
            orderVO.setSellerId(os.getSellerId());
            // 商家名称
            orderVO.setName(s.getName());

            orderVO.setOrderId(oi.getOrderId());
            orderVO.setOrderSn(oi.getOrderSn());
            orderVO.setOrderStatus(oi.getOrderStatus());
            orderVO.setShippingStatus(oi.getShippingStatus());
            orderVO.setPayStatus(oi.getPayStatus());
            // 收件人
            orderVO.setConsignee(oi.getConsignee());
            orderVO.setCountry(oi.getCountry());
            orderVO.setProvince(oi.getProvince());
            orderVO.setCity(oi.getCity());
            orderVO.setDistrict(oi.getDistrict());
            orderVO.setAddress(oi.getAddress());
            orderVO.setZipcode(oi.getZipcode());
            orderVO.setTel(oi.getTel());
            orderVO.setMobile(oi.getMobile());
            orderVO.setEmail(oi.getEmail());
            orderVO.setBestTime(oi.getBestTime());
            orderVO.setGoodsAmount(oi.getGoodsAmount());
            orderVO.setShippingFee(oi.getShippingFee());
            orderVO.setOrderAmount(oi.getOrderAmount());
            orderVO.setAddTime(oi.getAddTime());
            orderVO.setConfirmTime(oi.getConfirmTime());
            orderVO.setPayTime(oi.getPayTime());
            orderVO.setShippingTime(oi.getShippingTime());
            orderVO.setPayNote(oi.getPayNote());

            // 订单商品明细
            List<OrderGoods> ogs = orderGoodsDao.findbyorder("sortOrder", true, Restrictions.eq("orderId", oi.getOrderId()));
            List<OrderItemVO> items = null;
            for (OrderGoods og : ogs) {
                if (items == null)
                    items = new ArrayList<OrderItemVO>();

                OrderItemVO oivo = new OrderItemVO();
                // oivo.setSellerId();
                oivo.setGoodsId(og.getGoodsId());
                oivo.setGoodsSn(og.getGoodsSn());
                oivo.setGoodsName(og.getGoodsName());
                oivo.setGoodsPrice(og.getGoodsPrice());

                // 带排序的查询
                List<GoodsPic> gps = goodsPicDao.findbyorder("sortOrder", true, Restrictions.eq("goodsId", og.getGoodsId()),
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
                oivo.setPics(pics);
                items.add(oivo);
            }
            orderVO.setItems(items);

            orders.add(orderVO);
        }

        o.setOrders(orders);
        return o;
    }

    /**
     * 商家接单
     * @param vo
     * @return
     */
    @Transactional(readOnly = false)
    public void confirmorder(ConfirmOrderVO vo) {
        LoginSession ent = loginSessionDao.get(vo.getAccess_token());
        if (ent == null) {
            return;
        }

        // 一个用户有且仅有一个店铺
        Seller s = sellerDao.findUnique(Restrictions.eq("userId", ent.getUserId()));
        if (s == null) {
            return;
        }

        // TODO 增加返回 提示的代码
        OrderSeller os = orderSellerDao.findUnique(Restrictions.eq("orderId", vo.getOrderId()), Restrictions.eq("sellerId", s.getSellerId()));
        if (os == null) {
            return;
        }

        // 校验店家是否有这单
        OrderInfo oi = orderInfoDao.get(vo.getOrderId());
        if (oi == null) {
            return;
        }
        // 1: 为已接收
        oi.setOrderStatus((short) 1);
        oi.setConfirmTime(new Timestamp(System.currentTimeMillis()));
        this.orderInfoDao.save(oi);
    }
}
