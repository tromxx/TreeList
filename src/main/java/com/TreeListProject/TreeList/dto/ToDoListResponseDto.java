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
   
   private Long ToDoListId;
   
   private String ToDoListTitle;
   
   private String ToDoListContent;
   
   private LocalDateTime ToDoListDeadLine;
   
   @Builder
   public ToDoListResponseDto(ToDoList toDoList) {
      this.ToDoListId = toDoList.getToDoListId();
      this.ToDoListTitle = toDoList.getToDoListTitle();
      this.ToDoListContent = toDoList.getToDoListContent();
      this.ToDoListDeadLine = toDoList.getToDoListDeadline();
   }
}
