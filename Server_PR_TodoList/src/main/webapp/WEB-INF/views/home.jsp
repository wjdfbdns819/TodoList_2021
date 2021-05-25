<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>To do List</title>
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;

}

h1 {
	text-align: center;
	background-color: gray;
	color: white;
	padding: 10px;
	
}

form { 
	margin: 10px auto;
	text-align: center;
}

div#d1 {

	border: 5px solid gray; 
	border-radius: 5px;
	width: 60%;
	margin: 5px auto;
}

div#d2 {
	padding: 10px;
	
}

div#d2 button {
	outline: 0;
	border: 0;
	color: white;

}


table {
	text-align: center;
	border-collapse: collapse;
}

tabl{
	
}

</style>
</head>
<body>
	<h1>To do List</h1>

	<form action="${rootPath}/todolist/insert" method="POST">
	
	<div id="d1">
		<div id="d2">
			<label>작성일자</label> <input name="td_date" type="date"
				value="${TD.td_date}">
				
			<label>작성시간</label> <input name="td_time" type="time"
				value="${TD.td_time}">
				
			<label>할일</label> <input name="td_doit" value="${TD.td_doit}">
			
			<button>추가</button>
		</div>
		
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