<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	<div class="container">
	<h1>자유 게시판</h1>
	<table class="table">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${BoardList}" var="info">
			<tr onclick="location.href='boardInfo?bno=${info.bno}'">
				<td>${info.bno }</td>
				<td>${info.title }</td>
				<td>${info.writer }</td>
				<td><fmt:formatDate pattern="yyyy년MM월dd일" value="${info.regdate }"/> </td>
			</tr>
			</c:forEach>
		</tbody>
	</table>

	</div>