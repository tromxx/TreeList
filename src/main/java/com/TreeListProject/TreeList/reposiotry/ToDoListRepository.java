package com.TreeListProject.TreeList.reposiotry;

import com.TreeListProject.TreeList.entity.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoListRepository extends JpaRepository<ToDoList, Long> {

}
