package com.TreeListProject.TreeList.service;

import com.TreeListProject.TreeList.dto.ToDoListRequestDto;
import com.TreeListProject.TreeList.dto.ToDoListResponseDto;
import com.TreeListProject.TreeList.entity.ToDoList;
import com.TreeListProject.TreeList.reposiotry.ToDoListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ToDoListService {
   
   private final ToDoListRepository toDoListRepository;
   
   @Transactional
   public List<ToDoListResponseDto> readToDoList(int page) {
      Slice<ToDoList> toDoListList = toDoListRepository.findByToDoListIsCompleteFalse(PageRequest.of(page,10));
      List<ToDoListResponseDto> responseDtoList = new ArrayList<>();
      
      for (ToDoList toDoList : toDoListList) {
         responseDtoList.add(new ToDoListResponseDto(toDoList));
      }
      
      return responseDtoList;
   }
   
   // ToDoList 생성 할때 무한스크롤 데이터 다시 확인 했을때 초기화 될 문재 생김 frontend 처리시 좋은건가?
   @Transactional
   public List<ToDoListResponseDto> createToDoList(ToDoListRequestDto toDoListRequestDto, int page) {
      ToDoList toDoList = toDoListRequestDto.toDoListToEntity();
      toDoListRepository.save(toDoList);
      return readToDoList(page);
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
