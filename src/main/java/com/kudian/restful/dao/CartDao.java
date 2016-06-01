package com.kudian.restful.dao;

import com.kudian.common.persistence.HibernateDao;
import com.kudian.restful.entity.Cart;
import com.kudian.restful.entity.Category;
import org.hibernate.jdbc.Work;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Administrator on 2016/4/16.
 */
@Repository
public class CartDao extends HibernateDao<Cart, Integer> {
}
