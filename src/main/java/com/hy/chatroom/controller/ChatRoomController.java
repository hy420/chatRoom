package com.hy.chatroom.controller;

import com.hy.chatroom.common.Result;
import com.hy.chatroom.service.ChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatRoomController {

    @Autowired
    private ChatRoomService chatRoomService;

    @PostMapping("/join/{roomId}/{userId}")
    public Result<Long> joinRoom(@PathVariable String roomId, @PathVariable String userId) {
        return Result.ok(chatRoomService.joinRoom(roomId, userId));
    }

    @PostMapping("/leave/{roomId}/{userId}")
    public Result<Long> leaveRoom(@PathVariable String roomId, @PathVariable String userId) {
        return Result.ok(chatRoomService.leaveRoom(roomId, userId));
    }
}