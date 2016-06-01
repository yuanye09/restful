package com.kudian.restful.dao;

import com.kudian.common.persistence.HibernateDao;
import com.kudian.restful.entity.Category;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/4/16.
 */
@Repository
public class CategoryDao extends HibernateDao<Category, Integer> {
}
