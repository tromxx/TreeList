package com.TreeListProject.TreeList.entity;

import com.TreeListProject.TreeList.common.BaseTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class ChatMessage extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sender; // 메시지 발신자
    private String message; // 메시지 내용

    @ManyToOne
    private ChatRoom chatRoom; // 해당 메시지와 연결된 채팅방

    @Builder
    public ChatMessage(String sender, String message, ChatRoom chatRoom) {
        this.sender = sender;
        this.message = message;
        this.chatRoom = chatRoom;
    }
}
