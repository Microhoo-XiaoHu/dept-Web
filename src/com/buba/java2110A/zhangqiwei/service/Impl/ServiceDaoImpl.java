package com.buba.java2110A.zhangqiwei.service.Impl;

import com.buba.java2110A.zhangqiwei.dao.DeptDao;
import com.buba.java2110A.zhangqiwei.dao.impl.DeptDaoImpl;
import com.buba.java2110A.zhangqiwei.entity.Department;
import com.buba.java2110A.zhangqiwei.service.ServiceDao;

import java.util.List;

/**
 * Author:SmallTiger
 * Date:2022-09-30
 * Time:10:16
 */
public class ServiceDaoImpl implements ServiceDao {
    private DeptDao deptDao = new DeptDaoImpl();
    @Override
    public int addDept(Department department) {
        return deptDao.addDept(department);
    }

    @Override
    public int deleteDept(int depId) {
        return deptDao.deleteDept(depId);
    }

    @Override
    public int updateDept(Department department) {
        return deptDao.updateDept(department);
    }

    @Override
    public List<Department> findAlldept(Integer pageNo) {
        return deptDao.findAlldept(pageNo);
    }

    @Override
    public Department findDeptById(Integer deptId) {
        return deptDao.findDeptById(deptId);
    }

    @Override
    public int findDeptCount() {
        return deptDao.findDeptCount();
    }
}
