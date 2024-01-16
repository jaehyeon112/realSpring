<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 사원 조회</title>
</head>
<body>
	<button></button>
	<table style="border: 1px solid black;">
		<thead>
			<tr>
				<th>No.</th>
				<th>employee_id</th>
				<th>last_name</th>
				<th>email</th>
				<th>hire_date</th>
				<th>job_id</th>
				<th>salary</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${empList}" var="emp" varStatus="idx">
				<tr onclick="location.href='empInfo?employeeId=${emp.employeeId}'">
					<td>${idx.count}</td>
					<td>${emp.employeeId}</td>
					<td>${emp.lastName}</td>
					<td>${emp.email}</td>
					<td><fmt:formatDate value="${emp.hireDate}"
							pattern="yyyy년 MM월 dd일" /></td>
					<td>${emp.jobId}</td>
					<td>${emp.salary}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>