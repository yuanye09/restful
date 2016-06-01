package com.kudian.restful.vo.login;

import com.kudian.common.persistence.ResultObj;

/**
 * Created by Administrator on 2016/4/18.
 */
public class CheckPwdRetVO extends ResultObj {

    private boolean isDefPwd;

    public boolean isDefPwd() {
        return isDefPwd;
    }
    public void setDefPwd(boolean isDefPwd) {
        this.isDefPwd = isDefPwd;
    }
}
