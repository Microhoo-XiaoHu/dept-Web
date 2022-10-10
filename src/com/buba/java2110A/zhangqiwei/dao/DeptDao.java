package com.buba.java2110A.zhangqiwei.dao;

import com.buba.java2110A.zhangqiwei.entity.Department;

import java.util.List;

/**
 * Author:SmallTiger
 * Date:2022-09-30
 * Time:09:56
 */
public interface DeptDao {

    // 添加新的记录
    int addDept(Department department);
    // 根据ID删除记录
    int deleteDept(int depId);
    // 修改记录中内容
    int updateDept(Department department);
    // 查询所有记录
    List<Department> findAlldept(Integer pageNo);
    // 通过ID查询记录
    Department findDeptById(Integer deptId);
    // 查询库存总记录条数
    int findDeptCount();
}
