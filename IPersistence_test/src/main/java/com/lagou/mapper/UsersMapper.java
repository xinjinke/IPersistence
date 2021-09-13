package com.lagou.mapper;

import com.lagou.entity.Users;

import java.util.List;

public interface UsersMapper {
    List<Users> selectList();

    void delete(Users users);

    void updateUserName(Users users);

    void insertUser(Users users);
}
