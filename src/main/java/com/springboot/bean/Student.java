package com.springboot.bean;

import java.io.Serializable;

/**
 * @author guangxi.dong01@hand-china.com
 * @description test dto
 * @date 2020/11/20
 */
public class Student implements Serializable {


    private static final long serialVersionUID = -6240769402110284535L;

    private Long sno;
    private String sname;
    private String ssex;
    private String datasource;

    public Long getSno() {
        return sno;
    }

    public void setSno(Long sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public String getDatasource() {
        return datasource;
    }

    public void setDatasource(String datasource) {
        this.datasource = datasource;
    }
}
