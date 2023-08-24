package com.TreeListProject.TreeList.dto;

import com.TreeListProject.TreeList.entity.ToDoList;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class ToDoListRequestDto {
   
   private String toDoListTitle;
   private String toDoListContent;
   
   public ToDoList toDoListToEntity() {
      return ToDoList.builder()
        .toDoListTitle(toDoListTitle)
        .toDoListContent(toDoListContent)
        .toDoListDeadline(LocalDateTime.now())
        .toDoListIsComplete(false)
        .build();
   }
}
