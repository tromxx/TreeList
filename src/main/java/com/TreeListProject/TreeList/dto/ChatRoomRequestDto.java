package com.TreeListProject.TreeList.dto;

import com.TreeListProject.TreeList.entity.ChatRoom;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ChatRoomRequestDto {
    private String roomName; // 채팅방 이름

    @Builder
    public ChatRoomRequestDto(String roomName) {
        this.roomName = roomName;
    }

    public ChatRoom toEntity() { // DTO 객체에서 실제 엔티티 객체로 변환하는 메서드
        return ChatRoom.builder()
                .roomName(this.roomName)
                .build();
    }
}
