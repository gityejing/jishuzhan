<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>列表</title>
</head>
<body>
	<div>
		<table border="1px">
			<tr>
				<td>id</td>
				<td>书名</td>
				<td>数量</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${list}" var="l">
				<tr>
					<td>${l.bookId }</td>
					<td>${l.name}</td>
					<td>${l.number}</td>
					<td>
						<a href="<c:url value="/book/${l.bookId}/detail"/>">修改</a> 
						<a href="<c:url value="/book/delBook/${l.bookId}"/>">删除</a>
					</td>
				</tr>
			</c:forEach>
	</div>


	<br/>

	<div>
		<c:set var="ctx" value="${pageContext.request.contextPath}" />
	</div>

	<div>
		<form:form action="${ctx}/book/newBook" method="post"
			commandName="book">
		编号：<form:input path="bookId" />
		书名：<form:input path="name" />
		数量：<form:input path="number" />
			<button type="submit" value="submit">提交</button>
		</form:form>
	</div>

	</table>
</body>
</html>