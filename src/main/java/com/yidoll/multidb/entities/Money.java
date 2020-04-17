package com.yidoll.multidb.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author: ydcai
 * @create: 2020-04-17 09:47
 **/
@Data
@Getter
@Setter
@ToString
public class Money {
    private int id;
    private int basic;
    private int reward;
    private int punishment;
}
