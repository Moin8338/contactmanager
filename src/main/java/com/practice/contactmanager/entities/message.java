package com.practice.contactmanager.entities;

public class message {
    private String msg;
    private String type;
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public message(String msg, String type) {
        this.msg = msg;
        this.type = type;
    }
    public message() {
    }
}
