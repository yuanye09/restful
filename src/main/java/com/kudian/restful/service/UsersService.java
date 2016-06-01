package com.kudian.restful.service;

import com.kudian.common.persistence.HibernateDao;
import com.kudian.common.service.BaseService;
import com.kudian.common.utils.RegUtils;
import com.kudian.common.utils.UUIDGenerator;
import com.kudian.restful.dao.LoginSessionDao;
import com.kudian.restful.dao.UsersDao;
import com.kudian.restful.entity.LoginSession;
import com.kudian.restful.entity.Users;
import com.kudian.restful.vo.login.LoginVO;
import com.kudian.restful.vo.login.QuickLoginVO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/4/14.
 */
@Service
@Transactional(readOnly = true)
public class UsersService extends BaseService<Users, Integer> {

    private static final Logger logger = Logger.getLogger(UsersService.class);

    @Autowired
    private UsersDao usersDao;

    @Autowired
    private LoginSessionDao loginSessionDao;

    @Override
    public HibernateDao<Users, Integer> getEntityDao() {
        return usersDao;
    }

    /**
     * 保存注册用户
     * @param users
     * @return 1：保存失败
     *          0：保存成功
     */
    @Transactional(readOnly=false)
    public void saveUsers(Users users) {
        logger.info("保存注册用户!");
        this.usersDao.save(users);
    }

    /**
     * 根据输入的用户名取得user，
     * @param name
     */
    public Users getUser(String name) {
        String hql = "from Users u where u.isValidated=0 and ";
        if (RegUtils.isEmail(name)) {
            hql += "u.email = :name";
        } else if (RegUtils.isMobileNO(name)) {
            hql += "u.mobilePhone = :name";
        } else {
            hql += "u.userName = :name";
        }
        Map<String, Object> m = new HashMap<String, Object>();
        m.put("name", name);
        return getEntityDao().findUnique(hql, m);
    }

    /**
     * 登录系统
     * @param loginvo 登录信息
     */
    @Transactional(readOnly=false)
    public String login(LoginVO loginvo) {
        String hql = "from Users u where u.isValidated=0 and ";
        hql += " u.password= :password and ";
        if (RegUtils.isEmail(loginvo.getName())) {
            hql += "u.email = :name ";
        } else if (RegUtils.isMobileNO(loginvo.getName())) {
            hql += "u.mobilePhone = :name ";
        } else {
            hql += "u.userName = :name ";
        }

        Map<String, Object> m = new HashMap<String, Object>();
        m.put("password", encrypt(loginvo.getPassword()));
        m.put("name", loginvo.getName());
        Users user = getEntityDao().findUnique(hql, m);

        LoginSession ls = new LoginSession();
        ls.setAccessToken(UUIDGenerator.getUUID());
        ls.setUserId(user.getUserId());

        Timestamp t = new Timestamp(System.currentTimeMillis());
        ls.setLoginTime(t);
        ls.setLastTime(t);
        loginSessionDao.save(ls);
        return ls.getAccessToken();
    }

    /**
     * 登录系统
     * @param vo 快速登录信息
     */
    @Transactional(readOnly=false)
    public String quicklogin(QuickLoginVO vo) {
        String hql = "from Users u where u.isValidated=0 and ";
        hql += " u.mobilePhone = :mobile ";

        Map<String, Object> m = new HashMap<String, Object>();
        m.put("mobile", vo.getMobile());
        Users user = getEntityDao().findUnique(hql, m);

        if (user == null) {
            user = new Users();

            user.setEmail("");
            user.setMobilePhone(vo.getMobile());
            user.setUserName("");

            user.setAlias("");
            user.setSex((short) 0);
            user.setIsValidated((short) 0);
            // 最大消费
            user.setCreditLine(0.0);

            // TODO 设置默认密码
            user.setPassword("88888888");
            user.setUserMoney(0.0);
            user.setFrozenMoney(0.0);

            Timestamp t = new Timestamp(System.currentTimeMillis());
            user.setRegTime(t);
            user.setLastLogin(t);
            user.setLastTime(t);
            user.setLastIp("");
            // 不特殊
            user.setIsSpecial((short) 0);
            // TODO 生成随机数
            user.setSalt("abcdef");
            this.usersDao.save(user);
        }

        LoginSession ls = new LoginSession();
        ls.setAccessToken(UUIDGenerator.getUUID());
        ls.setUserId(user.getUserId());

        Timestamp t = new Timestamp(System.currentTimeMillis());
        ls.setLoginTime(t);
        ls.setLastTime(t);
        loginSessionDao.save(ls);
        return ls.getAccessToken();
    }

    /**
     * 对密码加密
     * @return
     */
    public String encrypt(String password) {
        // TODO 加密
        return password;
    }

    public Users getUserInfo(Integer userId) {
        return this.usersDao.get(userId);
    }
}
