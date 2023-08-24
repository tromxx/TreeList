package com.TreeListProject.TreeList.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ToDoList")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ToDoList {
   
   @Id
   @Column(name = "ToDoListId", nullable = false)
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long toDoListId;
   
   @Column(name="ToDoListTitle", nullable = false, length = 100)
   private String toDoListTitle;
   
   @Column(name="ToDoListContent", nullable = false, length = 200)
   private String toDoListContent;
   
   @Column(name="ToDoListDeadline", nullable = false)
   private LocalDateTime toDoListDeadline;
   
   // Boolean 타입  0 = false, 1 = true
   @ColumnDefault("false")
   @Column(name = "ToDoListIsComplete", nullable = false, columnDefinition = "TINYINT(1)")
   private boolean toDoListIsComplete;
   
   @Builder
   public ToDoList(String toDoListTitle, String toDoListContent, LocalDateTime toDoListDeadline, boolean toDoListIsComplete) {
      this.toDoListTitle = toDoListTitle;
      this.toDoListContent = toDoListContent;
      this.toDoListDeadline = toDoListDeadline;
      this.toDoListIsComplete = toDoListIsComplete;
   }
}
