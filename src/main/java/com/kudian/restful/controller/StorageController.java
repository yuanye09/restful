package com.kudian.restful.controller;

import com.kudian.common.persistence.ResultObj;
import com.kudian.common.utils.RegUtils;
import com.kudian.common.utils.StringUtils;
import com.kudian.restful.entity.LoginSession;
import com.kudian.restful.entity.UserAddress;
import com.kudian.restful.entity.Users;
import com.kudian.restful.service.LoginSessionService;
import com.kudian.restful.service.StorageService;
import com.kudian.restful.service.UserAddressService;
import com.kudian.restful.service.UsersService;
import com.kudian.restful.vo.address.AddAddressVO;
import com.kudian.restful.vo.login.CheckTokenVO;
import com.kudian.restful.vo.login.LoginRetVO;
import com.kudian.restful.vo.login.LoginVO;
import com.kudian.restful.vo.register.UserVO;
import com.kudian.restful.vo.storage.GetRetVO;
import com.kudian.restful.vo.storage.GetVO;
import com.kudian.restful.vo.storage.PutVO;
import com.wordnik.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

/**
 * Created by Administrator on 2016/4/12.
 */
@RestController
@RequestMapping("storage")
public class StorageController {
    private static final Logger logger = Logger.getLogger(StorageController.class);


    @Autowired
    private StorageService storageService;

    @Autowired
    private LoginSessionService loginSessionService;


    @RequestMapping(value = "put", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ApiOperation(value = "用户存储信息", httpMethod = "POST", notes = "用户存储信息", response = ResultObj.class)
    public ResultObj put(@RequestBody PutVO putVO) {
        ResultObj o = new ResultObj();

        try {
            storageService.put(putVO);
            o.setErrcode(0);
            o.setErrmsg("用户存储信息成功!");
        } catch (Exception e) {
            // 失败
            o.setErrcode(9999);
            o.setErrmsg("用户存储信息失败!");
            e.printStackTrace();
            logger.error(e);
        }
        return o;
    }

    @RequestMapping(value = "get", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ApiOperation(value = "获取用户存储信息", httpMethod = "POST", notes = "获取用户存储信息", response = ResultObj.class)
    public GetRetVO get(@RequestBody GetVO getVO) {
        GetRetVO o = new GetRetVO();
        try {
            o = storageService.get(getVO);
            if (StringUtils.isBlank(o.getVa())) {
                o.setErrcode(0);
                o.setErrmsg("用户存储信息中不存在此键值的信息!");
            } else {
                o.setErrcode(0);
                o.setErrmsg("用户存储信息成功!");
            }
        } catch (Exception e) {
            // 失败
            o.setErrcode(9999);
            o.setErrmsg("用户存储信息失败!");
            e.printStackTrace();
            logger.error(e);
        }
        return o;
    }
}
