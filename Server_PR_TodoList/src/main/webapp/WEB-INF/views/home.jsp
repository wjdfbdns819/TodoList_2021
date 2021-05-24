<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
 		prefix="c" %>
 <c:set value="${pageContext.request.contextPath}" var="rootPath"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>To do List</title>
</head>
<body>
 	<h1>To do List</h1>
 	
 	 	<form action="${rootPath}/todolist/insert" method="POST">
 		<div>
 			<label>작성일자</label>
 			<input name="td_date" type="date" value="${TD.td_date}">
 		</div>
 		
 		<div>	
 			<label>작성시간</label>
 			<input name="td_time" type="time" value="${TD.td_time}">
 		</div>
 		
 		<div>
 			<label>할일</label>
 			<input name="td_doit" value="${TD.td_doit}" >
 		</div>
 		
 		<div>
 			<label></label>
 			<button>추가</button>
 		</div>
 		</form>
 	
 	<table>
 		<tr>
 			<th>NO.</th>
 			<th>할일</th>
 			<th>작성일자</th>
 			<th>작성시각</th>
 		</tr>
 		
 		<c:forEach items="${TDLIST}" var="TD" varStatus="index">
 			<tr data-seq="${TD.td_seq}">
 			<td>${index.count}</td>
 			<td>${TD.td_doit}</td>
 			<td>${TD.td_date}</td>
 			<td>${TD.td_time}</td>
 			</tr>
 		</c:forEach>
 	</table>


</body>
</html>