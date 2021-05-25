<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <c:set value="${pageContext.request.contextPath}" var="{rootPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script>


</script>
</head>
<body>



	<table>
		<tr>
			<th>NO.</th>
			<td>${TD.td_seq}</td>
			<th>작성일자</th>
			<td>${TD.td_date}</td>
			<th>작성시각</th>
			<td>${TD.td_time}</td>
			<th>할일</th>
			<td>${TD.td_doit}</td>
		</tr>
	
	
	</table>

</body>
</html>