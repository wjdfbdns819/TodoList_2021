package com.callor.todolist.service;

import java.util.List;

import com.callor.todolist.model.TodoListVO;

public interface TodoListService {

	public List<TodoListVO> selectAll();
	public TodoListVO findBySeq(Integer seq);
	public Integer insert(TodoListVO tbVO);
	public Integer update(TodoListVO tbVO);
	public Integer delete(Integer seq);
}
