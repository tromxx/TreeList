package com.TreeListProject.TreeList.dto;

import com.TreeListProject.TreeList.entity.ChatMessage;
import lombok.Getter;

import java.time.format.DateTimeFormatter;

@Getter
public class ChatMessageResponseDto {
    private Long id;
    private String sender; // 메시지 발신자
    private String message; // 메시지 내용
    private String createdDate; // 메시지 생성일
    private String updatedDate; // 메시지 수정일

    public ChatMessageResponseDto(ChatMessage entity) {
        this.id = entity.getId();
        this.sender = entity.getSender();
        this.message = entity.getMessage();
        this.createdDate = entity.getCreatedDate().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));
        this.updatedDate = entity.getUpdatedDate().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));
    }
}
