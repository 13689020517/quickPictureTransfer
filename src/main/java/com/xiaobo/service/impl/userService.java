package com.xiaobo.service.impl;

import com.xiaobo.bean.User;
import com.xiaobo.dao.IUserDao;
import com.xiaobo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userService implements IUserService {
    @Autowired
    IUserDao iu;

    @Override
    public void save(User user) {
       iu.save(user);
    }

    @Override
    public List<User> findAll() {
        return iu.findAll();
    }

    @Override
    public User findById(Integer id) {
        return iu.findOne(id);
    }

    @Override
    public void deleteById(Integer id) {
        iu.delete(id);
    }

}
