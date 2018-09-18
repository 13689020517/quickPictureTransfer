package com.xiaobo.dao;

import com.xiaobo.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserDao extends JpaRepository<User,Integer> {
}
