package com.callor.todolist.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TodoListVO {

	private Integer td_seq;
	private String td_doit;
	private String td_date;
	private String td_time;
	
}