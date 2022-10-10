package com.buba.java2110A.zhangqiwei.entity;

/**
 * Author:SmallTiger
 * Date:2022-09-29
 * Time:21:19
 */
public class Department {
    private Integer deptId; // id
    private String deptNumber; // 编号
    private String deptName; // 名称
    private String province; // 省份
    private Integer peopleCounting; // 部门人数
    private String described; // 描述

    public Department() {
    }

    public Department(Integer deptId, String deptNumber, String deptName, String province, Integer peopleCounting, String described) {
        this.deptId = deptId;
        this.deptNumber = deptNumber;
        this.deptName = deptName;
        this.province = province;
        this.peopleCounting = peopleCounting;
        this.described = described;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptNumber() {
        return deptNumber;
    }

    public void setDeptNumber(String deptNumber) {
        this.deptNumber = deptNumber;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Integer getPeopleCounting() {
        return peopleCounting;
    }

    public void setPeopleCounting(Integer peopleCounting) {
        this.peopleCounting = peopleCounting;
    }

    public String getDescribed() {
        return described;
    }

    public void setDescribed(String described) {
        this.described = described;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptId=" + deptId +
                ", deptNumber='" + deptNumber + '\'' +
                ", deptName='" + deptName + '\'' +
                ", province='" + province + '\'' +
                ", peopleCounting=" + peopleCounting +
                ", described='" + described + '\'' +
                '}';
    }
}
