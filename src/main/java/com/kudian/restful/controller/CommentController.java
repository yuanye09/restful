package com.kudian.restful.controller;

import com.kudian.common.persistence.ResultObj;
import com.kudian.common.utils.DateUtils;
import com.kudian.common.utils.StringUtils;
import com.kudian.restful.entity.Comment;
import com.kudian.restful.entity.LoginSession;
import com.kudian.restful.entity.Users;
import com.kudian.restful.service.CommentService;
import com.kudian.restful.service.LoginSessionService;
import com.kudian.restful.service.UsersService;
import com.kudian.restful.vo.cart.AddCartInfoVO;
import com.kudian.restful.vo.comment.*;
import com.wordnik.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2016/5/30.
 */
@RestController
@RequestMapping("comment")
public class CommentController {
    private static final Logger logger = Logger.getLogger(CommentController.class);

    @Autowired
    private LoginSessionService loginSessionService;

    @Autowired
    private UsersService usersService;

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ApiOperation(value = "添加评论", httpMethod = "POST", notes = "添加评论", response = AddCommentRetVO.class)
    public @ResponseBody AddCommentRetVO add(@RequestBody AddCommentVO vo) {
        AddCommentRetVO o = new AddCommentRetVO();
        if (vo == null || StringUtils.isBlank(vo.getAccess_token())) {
            o.setErrcode(9999);
            o.setErrmsg("添加产品到购物车失败!access_token为空");
            return o;
        }
        LoginSession ent = loginSessionService.get(vo.getAccess_token());
        if (ent == null) {
            o.setErrcode(9999);
            o.setErrmsg("access_token已失效!");
            return o;
        }
        Users u = this.usersService.get(ent.getUserId());
        if (u == null) {
            o.setErrcode(9999);
            o.setErrmsg("用户id已不存在!");
            return o;
        }

        try {
            Comment entity = new Comment();
            // 0 是商品 1 是文章
            entity.setCommentType(vo.getCommentType());
            // 文章或商品的id
            entity.setIdValue(vo.getIdValue());
            // 内容
            entity.setContent(vo.getContent());
            // 1 ~ 5 之间的数
            entity.setCommentRank(vo.getCommentRank());

            entity.setAddTime(DateUtils.getSysTimestamp());
            // 默认为1通过
            entity.setStatus((short) 1);
            // TODO 先不做级联
            entity.setParentId(0);
            entity.setUserId(ent.getUserId());
            entity.setUserName(u.getUserName());
            this.commentService.save(entity);
            o.setErrcode(0);
            o.setErrmsg("成功添加评论");
            o.setCommentId(entity.getCommentId());
        } catch (Exception e) {
            o.setErrcode(9999);
            o.setErrmsg("添加评论失败");
            logger.error(e);
        }
        return o;
    }

    @RequestMapping(value = "query", method = RequestMethod.POST)
    @ApiOperation(value = "检索评论", httpMethod = "POST", notes = "检索评论", response = QueryCommentRetVO.class)
    public @ResponseBody QueryCommentRetVO query(@RequestBody QueryCommentVO vo) {
        QueryCommentRetVO o = new QueryCommentRetVO();
        try {
            o.setItems(this.commentService.query(vo));
            o.setErrcode(0);
            o.setErrmsg("成功检索评论");
        } catch (Exception e) {
            o.setErrcode(9999);
            o.setErrmsg("检索评论失败" + vo.getIdValue());
            logger.error(e);
        }
        return o;
    }
}
