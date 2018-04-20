package com.z2k.j2ee02;

import com.alibaba.fastjson.JSONArray;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class TodoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String action = req.getParameter("action");
        TodoService todoService = new TodoService();
        if(StringUtils.equalsIgnoreCase("save",action)){
            String id = req.getParameter("id");
            String content = req.getParameter("content");

            boolean result = todoService.save(Integer.valueOf(id),content);
            if(!result){
                req.setAttribute("msg","保存数据失败");
            }else{
                req.setAttribute("msg","保存数据成功");
            }
            req.getRequestDispatcher("msg.jsp").forward(req,resp);
        }else if(StringUtils.equalsIgnoreCase("listjson",action)) {
            resp.setContentType("application/json;character=utf-8");
            List<Map<String, Object>> result = todoService.list();
            JSONArray jsonArray = new JSONArray();
            jsonArray.addAll(result);

            resp.getWriter().print(jsonArray.toJSONString());
        }else{
            List<Map<String,Object>> result = todoService.list();
            req.setAttribute("list",result);
            req.getRequestDispatcher("list.jsp").forward(req,resp);
        }
    }
}
