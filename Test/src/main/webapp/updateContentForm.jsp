
<%@ page contentType="text/html;charset=utf-8"%>


<!-- id, 기존 content 받아오기 -->
<%
	int id = Integer.parseInt(request.getParameter("id"));
	String content = (String) request.getParameter("content");
%>

<form action="/updateContent" method="GET">
	id : <input type="text" name="id" value=<%=id%> ><br>
	내용: <input type="text" name="content" value=<%=content%>><br> 
</form>