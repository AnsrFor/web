package com.z2k.j2ee02;

import com.z2k.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TodoServiceMybatis extends TodoService {
    @Override
    public boolean save(Integer id, String content) {
        SqlSession sqlSession = MybatisUtil.getInstance().getSqlSessionFactory().openSession();
        TodoDAO dao = sqlSession.getMapper(TodoDAO.class);
        Todo td = new Todo();
        td.setId(id);
        td.setContent(content);
        int result = dao.save(td);
        sqlSession.commit();
        return result>0;
    }

    @Override
    public List<Map<String, Object>> list() {
        SqlSession sqlSession = MybatisUtil.getInstance().getSqlSessionFactory().openSession();
        TodoDAO dao = sqlSession.getMapper(TodoDAO.class);
        List<Todo> result = dao.list();
        List<Map<String,Object>> returnvalue = new ArrayList<>();
        for (Todo td : result){
            Map<String,Object> tmpmap = new HashMap();
            tmpmap.put("id",td.getId());
            tmpmap.put("content",td.getContent());
            returnvalue.add(tmpmap);
        }
        return returnvalue;
    }
}
