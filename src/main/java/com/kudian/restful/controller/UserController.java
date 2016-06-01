package com.kudian.restful.controller;

import com.kudian.common.persistence.ResultObj;
import com.kudian.common.utils.DateUtils;
import com.kudian.common.utils.RegUtils;
import com.kudian.common.utils.StringUtils;
import com.kudian.restful.entity.LoginSession;
import com.kudian.restful.entity.Seller;
import com.kudian.restful.entity.UserAddress;
import com.kudian.restful.entity.Users;
import com.kudian.restful.service.LoginSessionService;
import com.kudian.restful.service.SellerService;
import com.kudian.restful.service.UserAddressService;
import com.kudian.restful.service.UsersService;
import com.kudian.restful.vo.address.AddAddressVO;
import com.kudian.restful.vo.login.*;
import com.kudian.restful.vo.register.UserVO;
import com.kudian.restful.vo.seller.QuerySellerVO;
import com.wordnik.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/4/12.
 */
@RestController
@RequestMapping("user")
public class UserController {
    private static final Logger logger = Logger.getLogger(UserController.class);
//    @RequestMapping(value = "find/{id}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
//    @ApiOperation(value = "根据用户主键获取用户对象", httpMethod = "GET", notes = "根据用户主键用户对象.......", response = User.class)
//    public User getUser(@ApiParam(required = true, name = "id", value = "用户主键") @PathVariable String id){
//
//        User u = new User();
//        u.setLoginName("guoling");
//        u.setName("gggg");
//        u.setPassword("kkkkkkk");
//        //u.setCreateDate(new Date());
//        return u;
//    }
//
//    @RequestMapping(value = "add", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
//    @ApiOperation(value = "添加用户信息", httpMethod = "POST", notes = "用户信息以json格式传递")
//    public void addUser(@RequestBody User user) {
//        System.out.println(user.getLoginName());
//    }

    @Autowired
    private UsersService usersService;

    @Autowired
    private LoginSessionService loginSessionService;

    @Autowired
    private UserAddressService userAddressService;

    @Autowired
    private SellerService sellerService;

    @RequestMapping(value = "register", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ApiOperation(value = "注册用户信息", httpMethod = "POST", notes = "用户信息以json格式传递", response = ResultObj.class)
    public ResultObj register(@RequestBody UserVO user) {
        ResultObj o = new ResultObj();
        System.out.println(user.getName());

        if (StringUtils.isBlank(user.getName())) {
            o.setErrcode(1001);
            o.setErrmsg("注册名不能为空");
            return o;
        }

        if (StringUtils.isBlank(user.getPassword()) || StringUtils.isBlank(user.getConfirmpassword())) {
            o.setErrcode(1002);
            o.setErrmsg("密码不能为空");
            return o;
        }
        if (!user.getPassword().equals(user.getConfirmpassword())) {
            o.setErrcode(1003);
            o.setErrmsg("密码与确认密码不一致");
            return o;
        }
        Users usersEntity = new Users();

        if (RegUtils.isEmail(user.getName())) {
            usersEntity.setEmail(user.getName());
            usersEntity.setMobilePhone("");
            usersEntity.setUserName("");
        } else if (RegUtils.isMobileNO(user.getName())) {
            usersEntity.setEmail("");
            usersEntity.setMobilePhone(user.getName());
            usersEntity.setUserName("");
        } else {
            usersEntity.setEmail("");
            usersEntity.setMobilePhone("");
            usersEntity.setUserName(user.getName());
        }
        usersEntity.setAlias("");
        usersEntity.setSex((short) 0);
        usersEntity.setIsValidated((short) 0);
        // 最大消费
        usersEntity.setCreditLine(0.0);

        // TODO
        usersEntity.setPassword(user.getPassword());
        usersEntity.setUserMoney(0.0);
        usersEntity.setFrozenMoney(0.0);

        Timestamp t = new Timestamp(System.currentTimeMillis());
        usersEntity.setRegTime(t);
        usersEntity.setLastLogin(t);
        usersEntity.setLastTime(t);
        usersEntity.setLastIp("");
        // 不特殊
        usersEntity.setIsSpecial((short) 0);
        // TODO 生成随机数
        usersEntity.setSalt("abcdef");


        try {
            // 校验此用户是否被注册
            Users userCk = usersService.getUser(user.getName());
            if (userCk != null) {
                o.setErrcode(1004);
                o.setErrmsg("已有此注册用户，请换其他账号注册");
                return o;
            }

            usersService.saveUsers(usersEntity);
            o.setErrcode(0);
            o.setErrmsg("注册成功!");
        } catch (Exception e) {
            // 失败
            o.setErrcode(9999);
            o.setErrmsg("注册失败!");
            e.printStackTrace();
            logger.error(e);
        }
        return o;
    }

    @RequestMapping(value = "login", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ApiOperation(value = "登录系统", httpMethod = "POST", notes = "登录信息用json格式传递,返回的access_token是后续使用", response = LoginRetVO.class)
    public LoginRetVO login(@RequestBody LoginVO loginvo) {
        LoginRetVO o = new LoginRetVO();
        try {
            String accessToken = usersService.login(loginvo);

            QuerySellerVO q = new QuerySellerVO();
            q.setAccess_token(accessToken);

            // 目前只有一个商家
            List<Seller> sellers = sellerService.query(q);
            if (sellers != null && !sellers.isEmpty()) {
                Seller s = sellers.get(0);

                // 取得绑定商家的状态
                o.setSellerStatus(s.getSellerStatus());
                //
                o.setWelcomeMsg(getWelcomMsg(s));
                if (s.getGtId() == 7) {
                    o.setSpe("1");
                } else {
                    o.setSpe("");
                }
            }

            o.setErrcode(0);
            o.setErrmsg("登录成功!");
            o.setAccess_token(accessToken);
        } catch (Exception e) {
            // 失败
            o.setErrcode(9999);
            o.setErrmsg("登录失败!");
            o.setAccess_token("");
            logger.error(e);
        }
        return o;
    }

    @RequestMapping(value = "queryLogin", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ApiOperation(value = "快速登录", httpMethod = "POST", notes = "只使用,返回的access_token是后续使用", response = LoginRetVO.class)
    public LoginRetVO queryLogin(@RequestBody QuickLoginVO vo) {
        LoginRetVO o = new LoginRetVO();
        try {
            String accessToken = usersService.quicklogin(vo);

            QuerySellerVO q = new QuerySellerVO();
            q.setAccess_token(accessToken);

            // 目前只有一个商家
            List<Seller> sellers = sellerService.query(q);
            if (sellers != null && !sellers.isEmpty()) {
                Seller s = sellers.get(0);

                // 取得绑定商家的状态
                o.setSellerStatus(s.getSellerStatus());
                //
                o.setWelcomeMsg(getWelcomMsg(s));
                if (s.getGtId() == 7) {
                    o.setSpe("1");
                } else {
                    o.setSpe("");
                }
            }

            o.setErrcode(0);
            o.setErrmsg("登录成功!");
            o.setAccess_token(accessToken);
        } catch (Exception e) {
            // 失败
            o.setErrcode(9999);
            o.setErrmsg("登录失败!");
            o.setAccess_token("");
            logger.error(e);
        }
        return o;
    }

    @RequestMapping(value = "checkToken", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ApiOperation(value = "检查token是否失效", httpMethod = "POST", notes="", response = ResultObj.class)
    public ResultObj checkToken(@RequestBody CheckTokenVO vo) {
        ResultObj o = new ResultObj();

        if (vo == null || vo.getAccess_token() == null || StringUtils.isBlank(vo.getAccess_token())) {
            o.setErrcode(8888);
            o.setErrmsg("无效的token!");
            return o;
        }
        try {
            LoginSession s = loginSessionService.getInfo(vo.getAccess_token());

            if (s != null && StringUtils.isNotBlank(s.getAccessToken())) {
                o.setErrcode(0);
                o.setErrmsg("token有效!");
            } else {
                // 失败
                o.setErrcode(8888);
                o.setErrmsg("无效的token!");
            }
        } catch (Exception e) {
            // 失败
            o.setErrcode(8888);
            o.setErrmsg("无效的token!");
            logger.error(e);
        }
        return o;
    }

    @RequestMapping(value = "checkDefPwd", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ApiOperation(value = "检查是否是默认密码", httpMethod = "POST", notes="检查是否是默认密码", response = CheckPwdRetVO.class)
    public CheckPwdRetVO checkDefPwd(@RequestBody CheckPwdVO vo) {
        CheckPwdRetVO o = new CheckPwdRetVO();
        if (vo == null || vo.getAccess_token() == null || StringUtils.isBlank(vo.getAccess_token())) {
            o.setErrcode(8888);
            o.setErrmsg("无效的token!");
            return o;
        }

        try {
            LoginSession s = loginSessionService.getInfo(vo.getAccess_token());
            Users u = usersService.getUserInfo(s.getUserId());
            if ("88888888".equals(u.getPassword())) {
                o.setErrcode(0);
                o.setErrmsg("默认密码");
                o.setDefPwd(true);
            } else {
                o.setErrcode(0);
                o.setErrmsg("非默认密码");
                o.setDefPwd(false);
            }
        } catch (Exception e) {
            // 失败
            o.setErrcode(8888);
            o.setErrmsg("检查是否是默认密码失败!");
            logger.error(e);
        }
        return o;
    }

    @RequestMapping(value = "modifyPwd", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ApiOperation(value = "修改密码", httpMethod = "POST", notes="修改密码，旧密码为空时默认密码", response = ResultObj.class)
    public ResultObj modifyPwd(@RequestBody ModifyPwdVO vo) {
        ResultObj o = new ResultObj();
        if (vo == null || vo.getAccess_token() == null || StringUtils.isBlank(vo.getAccess_token())) {
            o.setErrcode(8888);
            o.setErrmsg("无效的token!");
            return o;
        }

        try {
            LoginSession s = loginSessionService.getInfo(vo.getAccess_token());
            Users u = usersService.getUserInfo(s.getUserId());
            if (StringUtils.isBlank(vo.getOldPwd())) {
                if (!"88888888".equals(u.getPassword())) {
                    o.setErrcode(1001);
                    o.setErrmsg("旧密码非默认密码，请提供旧密码!");
                    return o;
                }
            } else {
                if (!vo.getOldPwd().equals(u.getPassword())) {
                    o.setErrcode(1002);
                    o.setErrmsg("旧密码不正确，请重新输入!");
                    return o;
                }
            }

            u.setPassword(vo.getNewPwd());
            u.setLastTime(DateUtils.getSysTimestamp());
            usersService.save(u);
            o.setErrcode(0);
            o.setErrmsg("成功修改密码");
        } catch (Exception e) {
            // 失败
            o.setErrcode(8888);
            o.setErrmsg("修改密码失败!");
            logger.error(e);
        }
        return o;
    }

    @RequestMapping(value = "addAddress", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ApiOperation(value = "添加地址", httpMethod = "POST", notes = "添加地址", response = ResultObj.class)
    public ResultObj addAddress(@RequestBody AddAddressVO vo) {

        ResultObj o = new ResultObj();
        if (vo == null || vo.getAccess_token() == null || StringUtils.isBlank(vo.getAccess_token())) {
            o.setErrcode(8888);
            o.setErrmsg("无效的token!");
            return o;
        }
        try {
            LoginSession s = loginSessionService.getInfo(vo.getAccess_token());
            if (s != null && StringUtils.isNotBlank(s.getAccessToken())) {

                UserAddress ua = new UserAddress();
                ua.setUserId(s.getUserId());
                // 收件人姓名
                ua.setConsignee(vo.getConsignee());
                ua.setCountry((short) 86);
                ua.setProvince(vo.getProvince());
                ua.setCity(vo.getCity());
                ua.setDistrict(vo.getDistrict());
                ua.setAddress(vo.getAddress());
                ua.setMobile(vo.getMobile());
                ua.setEmail("");
                ua.setZipcode(vo.getZipcode());
                ua.setMobile(vo.getMobile());
                ua.setBestTime(vo.getBestTime());
                this.userAddressService.save(ua);

                o.setErrcode(0);
                o.setErrmsg("成功添加地址");
            } else {
                // 失败
                o.setErrcode(8888);
                o.setErrmsg("无效的token!");
            }
        } catch (Exception e) {
            // 失败
            o.setErrcode(8888);
            o.setErrmsg("无效的token!");
            logger.error(e);
        }
        return o;
    }

    private String getWelcomMsg(Seller s) {
        String welcomMsg = "";
        String d = "";
        if (0 == s.getSellerStatus()) {
            // 3 天后
            d = DateUtils.getAfterDate(s.getRegTime().getTime(), 3 * 24 * 60 * 1000L);
            welcomMsg = "您申请入驻的店铺正在进行审核中。\n";
            welcomMsg += "预计在" + d + "审核完毕\n";
            welcomMsg += "期待您的加入!";
        } else if (1 == s.getSellerStatus()) {
            // 审核中 3日后
            d = DateUtils.getAfterDate(s.getRegTime().getTime(), 3 * 24 * 60 * 1000L);
            welcomMsg = "您申请入驻的店铺正在进行审核中。\n";
            welcomMsg += "预计在" + d + "审核完毕\n";
            welcomMsg += "期待您的加入!";
        } else if (2 == s.getSellerStatus()) {
            // 审核通过
            // s.getAuditTime();
            Timestamp tm = null;
            if (s.getAuditTime() == null) {
                tm = s.getModifyTime();
            } else {
                tm = s.getAuditTime();
            }
            d = DateUtils.getAfterDate(tm.getTime(), 3 * 24 * 60 * 1000L);
            welcomMsg = "您申请入驻的店铺已经于" + d + "审核通过很高兴你的加入！";
        }
        return welcomMsg;
    }
}
