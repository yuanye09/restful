package com.kudian.restful.service;

import com.kudian.common.persistence.HibernateDao;
import com.kudian.common.service.BaseService;
import com.kudian.restful.dao.LoginSessionDao;
import com.kudian.restful.dao.SellerDao;
import com.kudian.restful.dao.UsersDao;
import com.kudian.restful.entity.LoginSession;
import com.kudian.restful.entity.Seller;
import com.kudian.restful.vo.seller.ModifySellerVO;
import com.kudian.restful.vo.seller.QuerySellerVO;
import com.kudian.restful.vo.seller.UpdateSellerVO;
import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/4/14.
 */
@Service
@Transactional(readOnly = true)
public class SellerService extends BaseService<Seller, Integer> {

    private static final Logger logger = Logger.getLogger(SellerService.class);

    @Autowired
    private SellerDao sellerDao;

    @Autowired
    private LoginSessionDao loginSessionDao;

    @Autowired
    private UsersDao usersDao;

    @Override
    public HibernateDao<Seller, Integer> getEntityDao() {
        return sellerDao;
    }

    /**
     * 查找登录账号名下的商店
     * @param querySellerVO
     * @return
     */
    public List<Seller> query(QuerySellerVO querySellerVO) {
        String hql = "from Seller s where s.userId=:userId ";
        LoginSession entity = loginSessionDao.get(querySellerVO.getAccess_token());
        // UsersEntity u = usersDao.find(entity.getUserId());

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userId", entity.getUserId());
        return sellerDao.find(hql, params);
    }

    /**
     * 更新商户基础信息
     * @param vo
     */
    public void update(UpdateSellerVO vo) {
        LoginSession entity = loginSessionDao.get(vo.getAccess_token());
        if (entity == null) {
            return;
        }

        // 只此一家
        Seller s = sellerDao.findUnique(Restrictions.eq("userId", entity.getUserId()));

        s.setTel(vo.getTel());
        s.setDeliveryTime(vo.getDeliveryTime());
        s.setMobilePhone(vo.getMobilePhone());
        s.setAddress(vo.getAddress());
        s.setIsFirst(vo.getIsFirst());
        s.setFirstAmount(vo.getFirstAmount());
        s.setIsFullMinus(vo.getIsFullMinus());
        s.setFullAmount(vo.getFullAmount());
        s.setMinusAmount(vo.getMinusAmount());
        s.setIsShippingFree(vo.getIsShippingFree());
        s.setShippingFee(vo.getShippingFee());
        s.setIsHoliday(vo.getIsHoliday());
        s.setDiscount(vo.getDiscount());

        // 配送开始结束时间
        s.setDeliveryStart(vo.getDeliveryStart());
        s.setDeliveryEnd(vo.getDeliveryEnd());

        s.setLatitudes(vo.getLatitudes());
        s.setLongitudes(vo.getLongitudes());
        s.setModifyTime(new Timestamp(System.currentTimeMillis()));
        sellerDao.save(s);
    }


    /**
     * 更新商户基础信息
     * @param vo
     */
    public void modify(ModifySellerVO vo) {
        LoginSession entity = loginSessionDao.get(vo.getAccess_token());
        if (entity == null) {
            return;
        }

        // 只此一家
        Seller s = sellerDao.findUnique(Restrictions.eq("userId", entity.getUserId()));

        s.setBusLicencePics(vo.getBusLicencePics());
        s.setCorporateIcardPics(vo.getCorporateIcardPics());
        s.setSellerPics(vo.getSellerPics());

        // 将标志位改为审核中 1
        s.setSellerStatus((short) 1);
        s.setModifyTime(new Timestamp(System.currentTimeMillis()));
        sellerDao.save(s);
    }
}
