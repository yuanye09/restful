package com.kudian.restful.service;

import com.kudian.common.persistence.HibernateDao;
import com.kudian.common.service.BaseService;
import com.kudian.common.utils.RegUtils;
import com.kudian.common.utils.UUIDGenerator;
import com.kudian.restful.dao.LoginSessionDao;
import com.kudian.restful.dao.StorageDao;
import com.kudian.restful.entity.LoginSession;
import com.kudian.restful.entity.Storage;
import com.kudian.restful.entity.Users;
import com.kudian.restful.vo.login.LoginVO;
import com.kudian.restful.vo.storage.GetRetVO;
import com.kudian.restful.vo.storage.GetVO;
import com.kudian.restful.vo.storage.PutVO;
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
public class StorageService extends BaseService<Storage, Integer> {

    private static final Logger logger = Logger.getLogger(StorageService.class);

    @Autowired
    private StorageDao storageDao;

    @Autowired
    private LoginSessionDao loginSessionDao;

    @Override
    public HibernateDao<Storage, Integer> getEntityDao() {
        return storageDao;
    }

    @Transactional(readOnly = false)
    public void put(PutVO vo) {
        LoginSession ent = loginSessionDao.get(vo.getAccess_token());
        if (ent == null) {
            return;
        }

        Storage s = this.storageDao.findUnique(Restrictions.eq("userId", ent.getUserId()), Restrictions.eq("ke", vo.getKe()));
        if (s == null) {
            s = new Storage();
        }
        s.setUserId(ent.getUserId());
        s.setKe(vo.getKe());
        s.setVa(vo.getVa());
        s.setLastTime(new Timestamp(System.currentTimeMillis()));
        this.storageDao.save(s);
    }

    public GetRetVO get(GetVO vo) {
        GetRetVO retVO = new GetRetVO();
        LoginSession ent = loginSessionDao.get(vo.getAccess_token());
        if (ent == null) {
            return retVO;
        }

        Storage s = this.storageDao.findUnique(Restrictions.eq("userId", ent.getUserId()), Restrictions.eq("ke", vo.getKe()));
        retVO.setKe(vo.getKe());
        if (s != null) {
            retVO.setVa(s.getVa());
        }
        return retVO;
    }
}
