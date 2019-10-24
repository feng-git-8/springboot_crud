package com.mr.springboot_crud.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Crud {

    private Integer cid;
    private String cname;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cdate;

    private Integer stauts;

    public Integer getStauts() {
        return stauts;
    }

    public void setStauts(Integer stauts) {
        this.stauts = stauts;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

    @Override
    public String toString() {
        return "Crud{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", cdate=" + cdate +
                ", stauts=" + stauts +
                '}';
    }
}
