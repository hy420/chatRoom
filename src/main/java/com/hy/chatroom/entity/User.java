package com.hy.chatroom.entity;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
/**
 * 用户实体
 */
public class User {
    private String userId;

    private List<ChatRoom> chatRooms = new ArrayList<>();
    // 其他属性和方法
    // getters 和 setters
}