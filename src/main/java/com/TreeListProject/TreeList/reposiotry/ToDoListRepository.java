package com.TreeListProject.TreeList.reposiotry;

import com.TreeListProject.TreeList.entity.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToDoListRepository extends JpaRepository<ToDoList, Long> {
   List<ToDoList> findByToDoListIsCompleteFalse();
}
