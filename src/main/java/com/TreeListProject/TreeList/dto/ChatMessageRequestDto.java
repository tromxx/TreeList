package com.TreeListProject.TreeList.dto;

import com.TreeListProject.TreeList.entity.ChatMessage;
import com.TreeListProject.TreeList.entity.ChatRoom;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ChatMessageRequestDto {
    private String sender; // 메시지 발신자
    private String message; // 메시지 내용
    private ChatRoom chatRoom; // 메시지가 연결된 채팅방

    @Builder
    public ChatMessageRequestDto(String sender, String message, ChatRoom chatRoom) {
        this.sender = sender;
        this.message = message;
        this.chatRoom = chatRoom;
    }

    public ChatMessage toEntity() {
        return ChatMessage.builder()
                .sender(this.sender)
                .message(this.message)
                .chatRoom(this.chatRoom)
                .build();
    }
}
