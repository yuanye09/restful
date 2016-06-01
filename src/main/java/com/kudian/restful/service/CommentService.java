package com.kudian.restful.service;

import com.kudian.common.persistence.HibernateDao;
import com.kudian.common.service.BaseService;
import com.kudian.restful.dao.*;
import com.kudian.restful.entity.*;
import com.kudian.restful.vo.cart.AddCartInfoVO;
import com.kudian.restful.vo.cart.CartInfoItemVO;
import com.kudian.restful.vo.cart.CartVO;
import com.kudian.restful.vo.cart.QueryCartInfoVO;
import com.kudian.restful.vo.comment.AddCommentVO;
import com.kudian.restful.vo.comment.QueryCommentItemRetVO;
import com.kudian.restful.vo.comment.QueryCommentRetVO;
import com.kudian.restful.vo.comment.QueryCommentVO;
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
public class CommentService extends BaseService<Comment, Integer> {
    private static final Logger logger = Logger.getLogger(CommentService.class);

    @Autowired
    private CommentDao commentDao;

    @Override
    public HibernateDao<Comment, Integer> getEntityDao() {
        return commentDao;
    }

    /**
     * 根据商品id检索评论
     * @param vo
     * @return
     */
    public List<QueryCommentItemRetVO> query(QueryCommentVO vo) {
        List<QueryCommentItemRetVO> ret = null;

        List<Comment> cmts = commentDao.findbyorder("addTime", false,
                Restrictions.eq("idValue", vo.getIdValue()), Restrictions.eq("status", (short) 1));

        for (Comment cmt : cmts) {
            if (ret == null)
                ret = new ArrayList<QueryCommentItemRetVO>();

            QueryCommentItemRetVO item = new QueryCommentItemRetVO();
            item.setCommentId(cmt.getCommentId());
            item.setContent(cmt.getContent());
            item.setCommentRank(cmt.getCommentRank());
            item.setUserId(cmt.getUserId());
            item.setUserName(cmt.getUserName());
            ret.add(item);
        }
        return ret;
    }
}
