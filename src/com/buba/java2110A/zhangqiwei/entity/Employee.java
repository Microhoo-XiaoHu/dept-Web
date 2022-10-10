package com.buba.java2110A.zhangqiwei.entity;

/**
 * Author:SmallTiger
 * Date:2022-09-29
 * Time:21:22
 */
public class Employee {
    private Integer empId;
    private Integer empDep;
    private String empName;
    private String empJobno;
    private Integer empAge;
    private String empSex;
    private Integer lockStatus;

    public Employee() {
    }

    public Employee(Integer empId, Integer empDep, String empName, String empJobno, Integer empAge, String empSex, Integer lockStatus) {
        this.empId = empId;
        this.empDep = empDep;
        this.empName = empName;
        this.empJobno = empJobno;
        this.empAge = empAge;
        this.empSex = empSex;
        this.lockStatus = lockStatus;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Integer getEmpDep() {
        return empDep;
    }

    public void setEmpDep(Integer empDep) {
        this.empDep = empDep;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpJobno() {
        return empJobno;
    }

    public void setEmpJobno(String empJobno) {
        this.empJobno = empJobno;
    }

    public Integer getEmpAge() {
        return empAge;
    }

    public void setEmpAge(Integer empAge) {
        this.empAge = empAge;
    }

    public String getEmpSex() {
        return empSex;
    }

    public void setEmpSex(String empSex) {
        this.empSex = empSex;
    }

    public Integer getLockStatus() {
        return lockStatus;
    }

    public void setLockStatus(Integer lockStatus) {
        this.lockStatus = lockStatus;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empDep=" + empDep +
                ", empName='" + empName + '\'' +
                ", empJobno='" + empJobno + '\'' +
                ", empAge=" + empAge +
                ", empSex='" + empSex + '\'' +
                ", lockStatus=" + lockStatus +
                '}';
    }
}
