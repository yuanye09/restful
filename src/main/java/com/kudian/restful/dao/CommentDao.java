package com.kudian.restful.dao;

import com.kudian.common.persistence.HibernateDao;
import com.kudian.restful.entity.Cart;
import com.kudian.restful.entity.Comment;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/4/16.
 */
@Repository
public class CommentDao extends HibernateDao<Comment, Integer> {
}
