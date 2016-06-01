package com.kudian.restful.dao;

import com.kudian.common.persistence.HibernateDao;
import com.kudian.restful.entity.Storage;
import com.kudian.restful.entity.Users;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/4/16.
 */
@Repository
public class StorageDao extends HibernateDao<Storage, Integer> {
}
