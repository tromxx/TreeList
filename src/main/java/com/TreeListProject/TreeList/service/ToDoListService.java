package com.TreeListProject.TreeList.service;

import com.TreeListProject.TreeList.dto.ToDoListRequestDto;
import com.TreeListProject.TreeList.dto.ToDoListResponseDto;
import com.TreeListProject.TreeList.entity.ToDoList;
import com.TreeListProject.TreeList.reposiotry.ToDoListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ToDoListService {
   
   private final ToDoListRepository toDoListRepository;
   
   @Transactional
   public List<ToDoListResponseDto> readToDoList() {
      List<ToDoList> toDoListList = toDoListRepository.findByToDoListIsCompleteFalse();
      List<ToDoListResponseDto> responseDtoList = new ArrayList<>();
      
      for (ToDoList toDoList : toDoListList) {
         responseDtoList.add(new ToDoListResponseDto(toDoList));
      }
      
      return responseDtoList;
   }
   
   @Transactional
   public List<ToDoListResponseDto> createToDoList(ToDoListRequestDto toDoListRequestDto) {
      ToDoList toDoList = toDoListRequestDto.toDoListToEntity();
      toDoListRepository.save(toDoList);
      return readToDoList();
   }
   
   @Transactional
   public void insertDummy(ToDoListRequestDto toDoListRequestDto) {
      List<ToDoList> toDoListList = new ArrayList<>();
      for (int i = 0; i < 100; i++) {
         ToDoList toDoList = toDoListRequestDto.toDoListToEntity();
         toDoListList.add(toDoList);
      }
      toDoListRepository.saveAll(toDoListList);
   }
}
