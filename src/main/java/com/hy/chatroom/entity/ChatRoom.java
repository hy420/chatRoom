package com.hy.chatroom.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 聊天室实体
 */
@Data
public class ChatRoom {
    private String roomId;

    private List<User> users = new ArrayList<>();
    // 其他属性和方法
    // getters 和 setters
}