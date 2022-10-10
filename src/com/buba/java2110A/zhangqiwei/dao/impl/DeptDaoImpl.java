package com.buba.java2110A.zhangqiwei.dao.impl;

import com.buba.java2110A.zhangqiwei.dao.DeptDao;
import com.buba.java2110A.zhangqiwei.entity.Department;
import com.buba.java2110A.zhangqiwei.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Author:SmallTiger
 * Date:2022-09-30
 * Time:10:02
 */
public class DeptDaoImpl implements DeptDao {

    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDateSource());

    @Override
    public int addDept(Department department) {
        String sql = "insert into department values(?,?,?,?,?,?)";
        int i = jdbcTemplate.update(sql, department.getDeptId(), department.getDeptNumber(), department.getDeptName(), department.getProvince(), department.getPeopleCounting(), department.getDescribed());
        return i;
    }

    @Override
    public int deleteDept(int depId) {
        String sql = "delete from department where dept_id = ?";
        int i = jdbcTemplate.update(sql, depId);
        return i;
    }

    @Override
    public int updateDept(Department department) {
        String sql = "update department set dept_number = ?, dept_name = ?, province = ?, people_counting = ?, described = ? where dept_id = ?";
        int i = jdbcTemplate.update(sql, department.getDeptNumber(), department.getDeptName(), department.getProvince(), department.getPeopleCounting(), department.getDescribed(), department.getDeptId());
        return i;
    }

    @Override
    public List<Department> findAlldept(Integer pageNo) {
        String sql = "select * from department limit ? , 5";
        List<Department> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Department.class) ,(pageNo-1)*5);
        return list;
    }

    @Override
    public Department findDeptById(Integer deptId) {
        String sql = "select * from department where dept_id = ?";
        Department list = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Department.class),deptId);
        return list;
    }

    @Override
    public int findDeptCount() {
        String sql = "select count(*) from department";
        Integer i = jdbcTemplate.queryForObject(sql, Integer.class);
        return i;
    }
}
