package com.yidoll.multidb.service;

import com.yidoll.multidb.db2.dao.MoneyDao;
import com.yidoll.multidb.entities.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: ydcai
 * @create: 2020-04-17 09:50
 **/
@Service
public class MoneyService {
    @Autowired
    private MoneyDao moneyDao;

    /**
     * 根据名字查找用户
     */
    public Money selectMoneyById(int id) {
        return moneyDao.findMoneyById(id);
    }

}
