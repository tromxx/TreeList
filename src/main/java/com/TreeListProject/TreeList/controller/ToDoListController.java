package com.TreeListProject.TreeList.controller;

import com.TreeListProject.TreeList.dto.ToDoListRequestDto;
import com.TreeListProject.TreeList.dto.ToDoListResponseDto;
import com.TreeListProject.TreeList.service.ToDoListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todolist")
@RequiredArgsConstructor
public class ToDoListController {
   
   private final ToDoListService toDoListService;
   
   @GetMapping("")
   public ResponseEntity<List<ToDoListResponseDto>> readToDoList() {
      return new ResponseEntity<>(toDoListService.readToDoList(), HttpStatus.OK);
   }
   
   @PostMapping("")
   public ResponseEntity<List<ToDoListResponseDto>> createToDoList(@RequestBody ToDoListRequestDto toDoListRequestDto) {
      return new ResponseEntity<>(toDoListService.createToDoList(toDoListRequestDto), HttpStatus.OK);
   }
   
   @PostMapping("/dummy")
   public void insertDummy(@RequestBody ToDoListRequestDto toDoListRequestDto) {
      toDoListService.insertDummy(toDoListRequestDto);
   }
}
