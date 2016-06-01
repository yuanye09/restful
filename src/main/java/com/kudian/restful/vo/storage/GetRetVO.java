package com.kudian.restful.vo.storage;

import com.kudian.common.persistence.ResultObj;

/**
 * Created by Administrator on 2016/5/13.
 */
public class GetRetVO  extends ResultObj {
    private String ke;
    private String va;

    public String getKe() {
        return ke;
    }

    public void setKe(String ke) {
        this.ke = ke;
    }

    public String getVa() {
        return va;
    }

    public void setVa(String va) {
        this.va = va;
    }
}
