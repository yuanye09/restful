package com.kudian.restful.service;

import com.kudian.common.persistence.HibernateDao;
import com.kudian.common.service.BaseService;
import com.kudian.restful.dao.GoodsTypeDao;
import com.kudian.restful.entity.GoodsType;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2016/4/18.
 */
@Service
@Transactional(readOnly = true)
public class GoodsTypeService extends BaseService<GoodsType, Integer> {
    private static final Logger logger = Logger.getLogger(SellerService.class);

    @Autowired
    private GoodsTypeDao goodsTypeDao;

    @Override
    public HibernateDao<GoodsType, Integer> getEntityDao() {
        return goodsTypeDao;
    }
}
