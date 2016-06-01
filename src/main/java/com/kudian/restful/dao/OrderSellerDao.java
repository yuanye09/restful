package com.kudian.restful.dao;

import com.kudian.common.persistence.HibernateDao;
import com.kudian.restful.entity.Category;
import com.kudian.restful.entity.OrderSeller;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/4/16.
 */
@Repository
public class OrderSellerDao extends HibernateDao<OrderSeller, Integer> {
}
