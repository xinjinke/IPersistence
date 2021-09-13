package com.lagou.test;

import com.alibaba.fastjson.JSONObject;
import com.lagou.entity.Users;
import com.lagou.io.Resources;
import com.lagou.mapper.UsersMapper;
import com.lagou.sqlSession.SqlSession;
import com.lagou.sqlSession.SqlSessionFactory;
import com.lagou.sqlSession.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class Test {

    public static void main(String[] args) throws Exception {

        InputStream inputStream = Resources.getResourceAsSteam("sqlMapConfig.xml");

        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sessionFactory.openSession();

        Users user = new Users();
        user.setId(2);
        user.setGender(1);
        user.setAge(18);
        user.setUsername("wangwu");


        UsersMapper userMapper = sqlSession.getMapper(UsersMapper.class);

//        List<Users> list = sqlSession.selectList("com.lagou.mapper.UsersMapper.selectList");
//        System.out.println(JSONObject.toJSONString(list));

//        sqlSession.insert("com.lagou.mapper.UsersMapper.insertUser",user);
//        userMapper.updateUserName(user);
//        userMapper.delete(user);
//        userMapper.insertUser(user);
        List<Users> list = userMapper.selectList();
        System.out.println(JSONObject.toJSONString(list));
    }
}
