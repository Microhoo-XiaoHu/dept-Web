package com.buba.java2110A.zhangqiwei.utils;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @program: firstJavaWeb
 * @ClassName TestJdbc
 * @description:
 * @author: MSY
 * @create: 2022-09-20 15:21
 * @Version 1.0
 **/
public class TestJdbc {
    public static void main(String[] args) {
        //创建JDBCTemplate对象
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDateSource());
        //3.调用方法
        String sql = "select sum(sal) from emp";
        Double count = template.queryForObject(sql, Double.class);
        System.out.println(count);
    }

}
