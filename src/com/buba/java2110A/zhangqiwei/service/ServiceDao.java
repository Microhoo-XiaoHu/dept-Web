package com.buba.java2110A.zhangqiwei.service;

import com.buba.java2110A.zhangqiwei.entity.Department;

import java.util.List;

/**
 * Author:SmallTiger
 * Date:2022-09-30
 * Time:10:15
 */
public interface ServiceDao {

    // 增
    int addDept(Department department);
    // 删
    int deleteDept(int depId);
    // 改
    int updateDept(Department department);
    // 查
    List<Department> findAlldept(Integer pageNo);
    Department findDeptById(Integer deptId);
    // 查询库存总记录条数
    int findDeptCount();

}