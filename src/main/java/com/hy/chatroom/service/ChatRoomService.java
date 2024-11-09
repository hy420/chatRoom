package com.hy.chatroom.service;

import com.hy.chatroom.common.ResultCodeEnum;
import com.hy.chatroom.entity.ChatRoom;
import com.hy.chatroom.entity.User;
import com.hy.chatroom.excception.YangException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ChatRoomService {
    // 存储所有聊天室
    private List<ChatRoom> chatRooms = new ArrayList<>();

    // 存储所有用户
    private List<User> users = new ArrayList<>();

    // 加入房间
    public Long joinRoom(String roomId, String userId) {
        User user = findUserById(userId);
        ChatRoom room = findRoomById(roomId);
        if(user == null || room == null) throw new YangException(ResultCodeEnum.ARGUMENT_VALID_ERROR);


        room.getUsers().add(user);
        printOtherUsersInRoom(room, userId);

        return 1L;
    }

    // 退出房间
    public Long leaveRoom(String roomId, String userId) {
        User user = findUserById(userId);
        ChatRoom room = findRoomById(roomId);
        if(user == null || room == null) throw new YangException(ResultCodeEnum.ARGUMENT_VALID_ERROR);

        room.getUsers().remove(user);
        printOtherUsersInRoom(room, userId);

        return 1L;
    }

    private ChatRoom findRoomById(String roomId) {
        return chatRooms.stream()
               .filter(room -> room.getRoomId().equals(roomId))
               .findFirst()
               .orElse(null);
    }

    private User findUserById(String userId) {
        return users.stream()
                .filter(user -> user.getUserId().equals(userId))
                .findFirst()
                .orElse(null);
    }

    private void printOtherUsersInRoom(ChatRoom room, String userId) {
        System.out.println("In room " + room.getRoomId());
        room.getUsers().stream()
               .filter(user ->!user.getUserId().equals(userId))
               .forEach(user -> System.out.println(user.getUserId()));
    }
}