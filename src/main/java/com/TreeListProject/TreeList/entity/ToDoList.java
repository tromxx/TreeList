package com.TreeListProject.TreeList.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
   private long ToDoListId;
   
   @Column(name="ToDoListTitle", nullable = false, length = 100)
   private String ToDoListTitle;
   
   @Column(name="ToDoListContent", nullable = false, length = 200)
   private String ToDoListContent;
   
   @Column(name="ToDoListDeadline", nullable = false)
   private LocalDateTime ToDoListDeadline;
   
   // Boolean 타입  0 = false, 1 = true
   @Column(name = "ToDoListIsComplete", nullable = false, columnDefinition = "TINYINT(0)")
   private boolean ToDoListIsComplete;
   
}
