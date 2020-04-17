package com.yidoll.multidb.service;

import com.yidoll.multidb.db1.dao.UserDao;
import com.yidoll.multidb.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: ydcai
 * @create: 2020-04-17 09:50
 **/
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    /**
     * 根据名字查找用户
     */
    public User selectUserByName(String name) {
        return userDao.findUserByName(name);
    }
}
