package com.kudian.restful.service;

import com.kudian.common.persistence.HibernateDao;
import com.kudian.common.service.BaseService;
import com.kudian.restful.dao.*;
import com.kudian.restful.entity.*;
import com.kudian.restful.vo.cart.AddCartInfoVO;
import com.kudian.restful.vo.cart.CartInfoItemVO;
import com.kudian.restful.vo.cart.QueryCartInfoVO;
import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/4/18.
 */
@Service
@Transactional(readOnly = true)
public class UserAddressService extends BaseService<UserAddress, Integer> {
    private static final Logger logger = Logger.getLogger(UserAddressService.class);

    @Autowired
    private UserAddressDao userAddressDao;

    @Override
    public HibernateDao<UserAddress, Integer> getEntityDao() {
        return userAddressDao;
    }

}
