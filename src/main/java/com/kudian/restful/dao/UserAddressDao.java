package com.kudian.restful.dao;

import com.kudian.common.persistence.HibernateDao;
import com.kudian.restful.entity.UserAddress;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/5/11.
 */
@Repository
public class UserAddressDao extends HibernateDao<UserAddress, Integer> {
}
