package com.TreeListProject.TreeList.dto;

import com.TreeListProject.TreeList.entity.ToDoList;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ToDoListResponseDto {
   
   private Long id;
   
   private String title;
   
   private String content;
   
   private LocalDateTime deadLine;
   
   @Builder
   public ToDoListResponseDto(ToDoList toDoList) {
      this.id = toDoList.getToDoListId();
      this.title = toDoList.getToDoListTitle();
      this.content = toDoList.getToDoListContent();
      this.deadLine = toDoList.getToDoListDeadline();
   }
}
