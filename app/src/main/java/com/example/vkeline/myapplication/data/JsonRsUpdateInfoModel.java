package com.example.vkeline.myapplication.data;

public class JsonRsUpdateInfoModel {
    String code = "0";

    String msg = "成功";

    UpdateInfoModel rs;

    public UpdateInfoModel getRs() {
        return rs;
    }

    public void setRs(UpdateInfoModel rs) {
        this.rs = rs;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
