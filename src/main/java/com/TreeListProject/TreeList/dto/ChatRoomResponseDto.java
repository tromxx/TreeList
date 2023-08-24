package com.TreeListProject.TreeList.dto;

import com.TreeListProject.TreeList.entity.ChatRoom;
import lombok.Getter;

import java.time.format.DateTimeFormatter;

@Getter
public class ChatRoomResponseDto {
    private Long id;
    private String roomName; // 채팅방 이름
    private String createdDate; // 채팅방생성일 // 날짜는 Format 을 지정해서 String 타입으로 전달
    private String updatedDate; // 채팅방 수정일

    public ChatRoomResponseDto(ChatRoom entity) {
        this.id = entity.getId();
        this.roomName = entity.getRoomName();
        this.createdDate = entity.getCreatedDate().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));
        this.updatedDate = entity.getUpdatedDate().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));
    }
}
