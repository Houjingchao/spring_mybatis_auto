package com.jaf.service;

import com.jaf.entity.User;

import java.util.List;

/**
 * Created by jaf on 16/8/19.
 */
public interface UserService {
    public int insert(User user);

    public int update(User user);

    public int delete(String userName);

    public List<User> selectAll();

    public int countAll();

    public User findByUserName(String userName);
}