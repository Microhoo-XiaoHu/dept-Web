package com.buba.java2110A.zhangqiwei.servlets;

import com.buba.java2110A.zhangqiwei.entity.Department;
import com.buba.java2110A.zhangqiwei.service.Impl.ServiceDaoImpl;
import com.buba.java2110A.zhangqiwei.service.ServiceDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Author:SmallTiger
 * Date:2022-09-30
 * Time:08:38
 */
public class DeptServlet extends ViewBaseServlet {

    private ServiceDao serviceDao = new ServiceDaoImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置中文乱码问题
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        if("findAlldept".equals(req.getParameter("method"))){
            this.findAlldept(req,resp);
        }
        if("addDeptJump".equals(req.getParameter("method"))){
            this.addDeptJump(req,resp);
        }
        if("addDept".equals(req.getParameter("method"))){
            this.addDept(req,resp);
        }
        if("DeptJump".equals(req.getParameter("method"))){
            this.DeptJump(req,resp);
        }
        if("updateDept".equals(req.getParameter("method"))){
            this.updateDept(req,resp);
        }
    }

    private void updateDept(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String deptId = req.getParameter("deptId");
        String deptNumber = req.getParameter("deptNumber");
        String deptName = req.getParameter("deptName");
        String province = req.getParameter("province");
        String peopleCounting = req.getParameter("peopleCounting");
        String described = req.getParameter("described");

        Department dept = new Department(Integer.valueOf(deptId), deptNumber, deptName, province, Integer.valueOf(peopleCounting), described);
        serviceDao.updateDept(dept);


        this.findAlldept(req,resp);
    }

    private void DeptJump(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] jumps = req.getParameterValues("jump");
        for (String jump : jumps) {
            if(jump.equals("删除")){
                String[] ids = req.getParameterValues("val");
                if (ids != null) {
                    for (String id : ids) {
                        serviceDao.deleteDept(Integer.valueOf(id));
                    }
                    this.findAlldept(req,resp);
                }else {
                    this.findAlldept(req,resp);
                }
            }

            if(jump.equals("编辑")){
                String[] ids = req.getParameterValues("val");
                if (ids != null) {
                    for (String id : ids) {
                        Department dept = serviceDao.findDeptById(Integer.valueOf(id));
                        req.setAttribute("dept",dept);
                        System.out.println(id);
                        super.processTemplate("update",req,resp);
                    }
                }else {
                    this.findAlldept(req,resp);
                }
            }
        }
    }

    private void addDept(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取创建的参数
        String deptId = req.getParameter("deptId");
        String deptNumber = req.getParameter("deptNumber");
        String deptName = req.getParameter("deptName");
        String province = req.getParameter("province");
        String peopleCounting = req.getParameter("peopleCounting");
        String described = req.getParameter("described");
        // 初始化对象
        Department dept = new Department(Integer.valueOf(deptId), deptNumber, deptName, province, Integer.valueOf(peopleCounting), described);
        // 调用添加方法
        serviceDao.addDept(dept);

        // 再调用查询方法,目的为了回到list页面
        this.findAlldept(req,resp);
    }

    private void addDeptJump(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.processTemplate("add",req,resp);
    }

    private void findAlldept(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置当前页,默认值为1
        Integer pageNo = 1;
        String pageNoStr = req.getParameter("pageNo");
        if(pageNoStr != null){
            pageNo = Integer.parseInt(pageNoStr);
        }
        HttpSession session = req.getSession();
        session.setAttribute("pageNo",pageNo);
        // 总记录条数
        int count = serviceDao.findDeptCount();
        // 总页数
        int pageCount = (count+5-1)/5;
        /*
        * 总记录条数     总页数
        *   1             1
        *   5             1
        *   6             2
        *   10            2
        *   11            3
        *  count        (count+5-1)/5
        * */
        session.setAttribute("pageCount",pageCount);

        List<Department> list = serviceDao.findAlldept(pageNo);
        req.setAttribute("deptList",list);

//        System.out.println(list);

        // 页面渲染 ( 请求转发跳转到/WEB-INF/view/list.html )
        super.processTemplate("list",req,resp);
    }

}
