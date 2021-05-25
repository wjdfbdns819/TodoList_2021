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
	width: 75%;
	margin: 5px auto;
	
}

div#d1 input {
	border: 2px solid gray;
	border-radius: 5px; 
	padding: 5px;

}


input#do {
	display: inline-block;
	width: 30%;

}


div#d2 {
	
	padding-top: 15px;
	padding-bottom: 15px;
}

div#d2 button {
	outline: 0;
	border: 0;
	color: white;
	background-color: gray;
	width: 10%;
	
	border-radius: 5px;
	padding-bottom: 5px;
	padding-top: 5px; 
	
}

div#d2 button:hover {
	cursor: pointer;
	background-color:black;
	box-shadow: 2px 2px 2px rgba(0,0,0,0.5); 

}

table { 
	text-align: center;
	border-collapse: collapse;
	margin: 10px auto;
	width: 80%;	
}


table tr#maintr {
	background-color: gray;
	color: white;
	
}

th, td  {
	padding: 5px;
	border: 2px solid gray; 	
	border-left-color: white;
	

}

th#th1, td#td1 {
	border-right-color: white; 
	
}


</style>

<script>
	document.addEventListener("DOMContentLoaded",function(){
		document.querySelector("table#tdlist")
		.addEventListener("click",function(ev){
		
			
			let tag_name = ev.target.tagName;
			
			if(tag_name == "TD") {
				
				let td_seq = ev.target.closest("TR").dataset.seq
				
				document.location.href
					="${rootPath}/todolist/view?td_seq=" + td_seq;
			}
			
		})
		
	})
	
	
</script>

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
				
			<label>할일</label> <input id="do" name="td_doit" value="${TD.td_doit}">
			
			<button>추가</button>
		</div>
		
	</div>

	</form>
	
	<table id="tdlist">
		<tr id="maintr">
			<th id="th1">NO.</th>
			<th id="th1">할일</th>
			<th id="th1">작성일자</th>
			<th>작성시각</th>
		</tr>

		<c:forEach items="${TDLIST}" var="TD" varStatus="index" >
			
			<tr data-seq="${TD.td_seq}" >
				<td >${index.count}</td>
				<td >${TD.td_doit}</td>
				<td >${TD.td_date}</td>
				<td id="td1">${TD.td_time}</td>
			</tr>
			
		</c:forEach>
	</table>
	

	

</body>
</html>