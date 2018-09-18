package com.xiaobo.service;

import com.xiaobo.bean.User;

import java.util.List;

public interface IUserService {

    void save(User user);

    List<User> findAll();

    User findById(Integer id);

    void deleteById(Integer id);

}
