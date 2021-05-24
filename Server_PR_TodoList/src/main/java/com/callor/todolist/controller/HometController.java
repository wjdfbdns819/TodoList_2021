package com.callor.todolist.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.todolist.config.DbInfo;
import com.callor.todolist.model.TodoListVO;
import com.callor.todolist.service.TodoListService;
import com.callor.todolist.service.impl.TodoListServiceImplV1;

@WebServlet("/")
public class HometController extends HttpServlet {

	protected TodoListService tdService;

	public HometController() {
		tdService = new TodoListServiceImplV1();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<TodoListVO> tdList = tdService.selectAll();
		req.setAttribute("TDLIST", tdList);
		
		TodoListVO tdVO = new TodoListVO();

		SimpleDateFormat tD = new SimpleDateFormat("yyyy-MM-dd");

		SimpleDateFormat tT = new SimpleDateFormat("HH:mm:ss");

		Date date = new Date(System.currentTimeMillis());

		tdVO.setTd_date(tD.format(date));
		tdVO.setTd_time(tT.format(date));

		req.setAttribute("TD", tdVO);


		req.getRequestDispatcher("WEB-INF/views/home.jsp").forward(req, resp);

	}

}
