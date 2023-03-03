<%@page import="com.he20o.domain.GuestVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	Object o = request.getAttribute("list");
	List<GuestVO> list = (List<GuestVO>) o;
	for (int i = 0; i < list.size(); i++) {
		Long bno = list.get(i).getBno();
		String btext = list.get(i).getBtext();
	%>

	<%=bno%>
	<%=btext%>
	<%
	}
	%>
	
</body>
</html>