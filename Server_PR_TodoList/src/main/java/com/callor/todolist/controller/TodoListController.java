package com.callor.todolist.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.todolist.config.DbInfo;
import com.callor.todolist.model.TodoListVO;
import com.callor.todolist.service.TodoListService;
import com.callor.todolist.service.impl.TodoListServiceImplV1;

@WebServlet("/todolist/*")
public class TodoListController extends HttpServlet {
	

	protected TodoListService tdService;
	public TodoListController() {
		tdService = new TodoListServiceImplV1();
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String subPath = req.getPathInfo();
		
		if(subPath.equals("/view")) {
			String strSeq = req.getParameter("td_seq");
			Integer td_seq = Integer.valueOf(strSeq);
			TodoListVO tdVO = tdService.findBySeq(td_seq);
			
			req.setAttribute("TD", tdVO);
			
			req.getRequestDispatcher("/WEB-INF/views/view.jsp").forward(req, resp);
			
		}
		
		else if(subPath.equals("/update")) {
			
			String strSeq = req.getParameter("td_seq");
			Integer td_seq = Integer.valueOf(strSeq);
			
			TodoListVO tdVO = tdService.findBySeq(td_seq);
			
			req.setAttribute("TD", tdVO);
						
			req.getRequestDispatcher("/WEB-INF/views/update.jsp").forward(req, resp);
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");

		String subPath = req.getPathInfo();
		
		
		// String td_seq = req.getParameter(DbInfo.);
		String td_doit = req.getParameter("td_doit");
		String td_date = req.getParameter("td_date");
		String td_time = req.getParameter("td_time");

		TodoListVO tdVO = new TodoListVO();
		tdVO.setTd_doit(td_doit);
		tdVO.setTd_date(td_date);
		tdVO.setTd_time(td_time);
		System.out.println(tdVO.toString());
		if(subPath.equals("/insert")) {
		
			tdService.insert(tdVO);
			resp.sendRedirect("/todo/");
			

		} else if(subPath.equals("/update")) {
		
			String strSeq = req.getParameter("td_seq");
			Integer td_seq = Integer.valueOf(strSeq);
			
			tdVO.setTd_seq(td_seq);
			tdService.update(tdVO);
			
			resp.sendRedirect("/todolist/");
		}
		
		
		
	}
	
	
	


}
