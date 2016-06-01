package com.kudian.restful.service;

import com.kudian.common.persistence.HibernateDao;
import com.kudian.common.service.BaseService;
import com.kudian.restful.dao.CategoryDao;
import com.kudian.restful.dao.LoginSessionDao;
import com.kudian.restful.dao.SellerDao;
import com.kudian.restful.entity.Category;
import com.kudian.restful.entity.LoginSession;
import com.kudian.restful.entity.Seller;
import com.kudian.restful.vo.category.CategoryInfoVO;
import com.kudian.restful.vo.category.QueryCategoryVO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/4/18.
 */
@Service
@Transactional(readOnly = true)
public class CategoryService extends BaseService<Category, Integer> {
    private static final Logger logger = Logger.getLogger(SellerService.class);

    @Autowired
    private LoginSessionDao loginSessionDao;

    @Autowired
    private SellerDao sellerDao;

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public HibernateDao<Category, Integer> getEntityDao() {
        return categoryDao;
    }

    /**
     * 判断此登录者是否有权限操作此商店
     * @return false: 查不到此商家
     *          true: 有此商家，能进行后续操作
     */
    public boolean checkRule(String access_token, Integer sellerId) {
        LoginSession ls = loginSessionDao.find(access_token);
        ls.getUserId();

        String hql = "from Seller s where s.userId=:userId and s.sellerId=:sellerId ";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userId", ls.getUserId());
        params.put("sellerId", sellerId);
        Seller se = sellerDao.findUnique(hql, params);
        if (se == null) {
            return false;
        }
        return true;
    }

    /**
     * 取得此登录用户和对应商店的产品种类
     * @param queryCategoryVO
     * @return
     */
    public List<Category> getAllCategory(QueryCategoryVO queryCategoryVO) {

        if (!checkRule(queryCategoryVO.getAccess_token(), queryCategoryVO.getSellerId())) {
            // 无权操作，返回空值
            return null;
        }

        String hql = "from Category ct where ct.sellerId=:sellerId";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("sellerId", queryCategoryVO.getSellerId());
        return categoryDao.find(hql, params);
    }

    public List<CategoryInfoVO> getNode(Integer parentId){
        String hql = "from Category ct where ct.parentId=:parentId";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("parentId", parentId);
        List<Category> cts = categoryDao.find(hql, params);
        if (cts != null && cts.size() != 0) {
            for (Category e : cts) {
                CategoryInfoVO vo = new CategoryInfoVO();
                vo.setCatId(e.getCatId());
                vo.setSellerId(e.getSellerId());
                vo.setCatName(e.getCatName());
                vo.setCatDesc(e.getCatDesc());
                vo.setParentId(e.getParentId());

                getNode(e.getParentId());
            }
        }

        // TODO
        return null;
    }
}
