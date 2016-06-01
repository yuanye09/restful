package com.kudian.restful.controller;

import com.kudian.restful.entity.Category;
import com.kudian.restful.service.CategoryService;
import com.kudian.restful.vo.category.*;
import com.wordnik.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/4/18.
 */
@RestController
@RequestMapping("category")
public class CategoryController {
    private static final Logger logger = Logger.getLogger(CategoryController.class);

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "getCategories", method = RequestMethod.POST)
    @ApiOperation(value = "取得登录用户对应商户的商品类别", httpMethod = "POST", notes = "取得登录用户对应商户的商品类别", response = CategoryInfoRetVO.class)
    private @ResponseBody CategoryInfoRetVO getCategories(@RequestBody QueryCategoryVO queryCategoryVO) {
        CategoryInfoRetVO o = new CategoryInfoRetVO();

        try {
            List<Category> l = categoryService.getAllCategory(queryCategoryVO);
            List<CategoryInfoVO> ls = new ArrayList<CategoryInfoVO>();
            for (Category e : l) {
                CategoryInfoVO vo = new CategoryInfoVO();
                vo.setCatId(e.getCatId());
                vo.setSellerId(e.getSellerId());
                vo.setCatName(e.getCatName());
                vo.setCatDesc(e.getCatDesc());
                vo.setParentId(e.getParentId());
                ls.add(vo);
            }

            List<CategoryInfoVO> nodeList = new ArrayList<CategoryInfoVO>();
            for (CategoryInfoVO vo1 : ls) {
                boolean mark = false;
                for (CategoryInfoVO vo2 : ls) {
                    if (vo1.getParentId() == vo2.getCatId()) {
                        mark = true;
                        if (vo2.getChildren() == null) {
                            vo2.setChildren(new ArrayList<CategoryInfoVO>());
                        }
                        vo2.getChildren().add(vo1);
                        break;
                    }
                }

                if (!mark) {
                    nodeList.add(vo1);
                }
            }
            o.setErrcode(0);
            o.setErrmsg("成功取得商品类别信息");
            o.setCategories(nodeList);
        } catch (Exception e) {
            o.setErrcode(9999);
            o.setErrmsg("取得商品类别信息失败");
        }
        return o;
    }

    /**
     * 设置树形结构
     * @param l
     * @return
     */
    private List<CategoryInfoVO> setCategoryTree(List<Category> l) {
        List<CategoryInfoVO> ls = new ArrayList<CategoryInfoVO>();
        Map<Integer, CategoryInfoVO> m = new HashMap<Integer, CategoryInfoVO>();

        for (Category e : l) {
            CategoryInfoVO vo = new CategoryInfoVO();
            vo.setCatId(e.getCatId());
            vo.setSellerId(e.getSellerId());
            vo.setCatName(e.getCatName());
            vo.setCatDesc(e.getCatDesc());
            vo.setParentId(e.getParentId());

            if (vo.getParentId() == 0) {
                ls.add(vo);
            } else {
                m.put(vo.getCatId(), vo);
            }
        }
        return ls;
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ApiOperation(value = "插入商品类别", httpMethod = "POST", notes = "插入商品类别", response = SaveCategoryInfoRetVO.class)
    private @ResponseBody SaveCategoryInfoRetVO add(@RequestBody SaveCategoryInfoVO saveCategoryInfoVO) {

        SaveCategoryInfoRetVO o = new SaveCategoryInfoRetVO();
        try {
            Category entity = new Category();

            if (!this.categoryService.checkRule(saveCategoryInfoVO.getAccess_token(), saveCategoryInfoVO.getSellerId())) {
                o.setErrcode(9000);
                o.setErrmsg("您无权操作此商家资源");
                return o;
            }

            // 商店ID
            entity.setSellerId(saveCategoryInfoVO.getSellerId());
            entity.setCatName(saveCategoryInfoVO.getCatName());
            entity.setKeywords(saveCategoryInfoVO.getKeywords());
            entity.setCatDesc(saveCategoryInfoVO.getCatDesc());
            // 第一层传0值
            entity.setParentId(saveCategoryInfoVO.getParentId());

            // 自定义 先不控制顺序
            entity.setSortOrder(saveCategoryInfoVO.getSortOrder());
            //
            entity.setCatName(saveCategoryInfoVO.getCatName());

            categoryService.save(entity);

            o.setErrcode(0);
            o.setErrmsg("成功插入商品类别");
            o.setCatId(entity.getCatId());
        } catch (Exception e) {
            o.setErrcode(9999);
            o.setErrmsg("插入商品类别失败");
        }
        return o;
    }
}
