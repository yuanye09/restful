package com.kudian.restful.service;

import com.kudian.common.persistence.HibernateDao;
import com.kudian.common.service.BaseService;
import com.kudian.restful.dao.LoginSessionDao;
import com.kudian.restful.entity.LoginSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2016/4/14.
 */
@Service
@Transactional(readOnly = true)
public class LoginSessionService extends BaseService<LoginSession, String> {

    private static final Logger logger = Logger.getLogger(LoginSessionService.class);

    @Autowired
    private LoginSessionDao loginSessionDao;

    @Override
    public HibernateDao<LoginSession, String> getEntityDao() {
        return loginSessionDao;
    }

//    @Transactional(readOnly=false)
    public LoginSession getInfo(String accessToken) {
        // return loginSessionDao.find(accessToken);
        return loginSessionDao.get(accessToken);
    }
}
