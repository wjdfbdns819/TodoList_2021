package com.callor.todolist.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.callor.todolist.config.DbInfo;
import com.callor.todolist.config.OracleConnection;
import com.callor.todolist.model.TodoListVO;
import com.callor.todolist.service.TodoListService;


public class TodoListServiceImplV1 implements TodoListService {
	protected Connection dbConn;
	
	public TodoListServiceImplV1() {
		dbConn = OracleConnection.getConnection();
	}
	
	protected List<TodoListVO> select(PreparedStatement pStr) throws SQLException {
		List<TodoListVO> tdList = new ArrayList<TodoListVO>();
		
		ResultSet rSet = pStr.executeQuery();
		while(rSet.next()) {
			TodoListVO tdVO = new TodoListVO();
			tdVO.setTd_seq(rSet.getInt(DbInfo.td_seq));
			tdVO.setTd_date(rSet.getString(DbInfo.td_date));
			tdVO.setTd_time(rSet.getString(DbInfo.td_time));
			tdVO.setTd_doit(rSet.getString(DbInfo.td_doit));
			
			tdList.add(tdVO);
		}
		 // :D
		System.out.println(tdList.toString());
		return tdList;
	}
	
	@Override
	public List<TodoListVO> selectAll() {
		// TODO 전체 목록 조회
		String sql = " SELECT * FROM tbl_todolist";
		
		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			List<TodoListVO> tdList = this.select(pStr);
			pStr.close();
			
			return tdList;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public TodoListVO findBySeq(Integer seq) {
		// TODO seq로 데이터 조회
		String sql = " SELECT * FROM tbl_todolist ";
		sql += " WHERE td_seq = ? ";
		
		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			List<TodoListVO> tdList = this.select(pStr);
			
			if(tdList == null || tdList.size() > 0) {
				
				System.out.println(tdList.toString());
				return tdList.get(0);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Integer insert(TodoListVO tdVO) {
		// TODO 데이터 추가
		String sql = " INSERT INTO tbl_todolist ";
		sql += "(";
		sql += " td_seq, ";
		sql += " td_doit, ";
		sql += " td_date, ";
		sql += " td_time) ";
		sql += " VALUES(seq_todolist.nextval,?,?,?) ";
		
		PreparedStatement pStr = null;
		
		try {
			pStr = dbConn.prepareStatement(sql);
	
			pStr.setString(1, tdVO.getTd_doit());
			pStr.setString(2, tdVO.getTd_date());
			pStr.setString(3, tdVO.getTd_time());
			
			System.out.println(pStr.toString());
			return pStr.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Integer update(TodoListVO tdVO) {
		// TODO 데이터 수정
		String sql = " UPDATE tbl_todolist SET ";
			sql += " td_doit = ? ";
			sql += " td_date = ? ";
			sql += " td_time = ? ";
			sql += " WHERE td_seq = ? ";
			
			PreparedStatement pStr = null;
			
			try {
				pStr = dbConn.prepareStatement(sql);
				
				pStr.setString(1, tdVO.getTd_doit());
				pStr.setString(2, tdVO.getTd_date());
				pStr.setString(3, tdVO.getTd_time());
				
				pStr.setInt(4, tdVO.getTd_seq());
				
				return pStr.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return null;
	}

	@Override
	public Integer delete(Integer seq) {
		// TODO 데이터 삭제
		String sql = " DELETE FROM tbl_todolist ";
		sql += " WHERE td_seq = ? ";
		
		PreparedStatement pStr = null;
		
			try {
				pStr = dbConn.prepareStatement(sql);
				
				Integer intSql = Integer.valueOf(sql);
				
				pStr.setInt(1, intSql);
				
				return pStr.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		
		return null;
	}

}
