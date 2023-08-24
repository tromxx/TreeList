package com.TreeListProject.TreeList.entity;

import com.TreeListProject.TreeList.common.BaseTime;
import com.TreeListProject.TreeList.dto.ChatRoomRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class ChatRoom extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roomName; // 채팅방 이름

    @OneToMany(mappedBy = "chatRoom", cascade = CascadeType.REMOVE)
    private List<ChatMessage> chatMessageList; // 해당 채팅방에서 기록된 모든 채팅

    @Builder
    public ChatRoom(String roomName) {
        this.roomName = roomName;
    }

    public Long update(ChatRoomRequestDto requestDto) {
        this.roomName = requestDto.getRoomName();
        return this.id;
    }

}
