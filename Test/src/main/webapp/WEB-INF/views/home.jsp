<%@page import="com.board.BoardVO"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html ng-app>
<head>
<style>
fixed-menu {
	width: 100%;
	height: 80px;
	background-color: black;
	position: fixed;
	top: 0px;
	left: 0px;
}

fixed-menu2 {
	width: 100%;
	height: 30px;
	background-color: gray;
	position: fixed;
	top: 80px;
	left: 0px;
}

main-content {
	width: 100%;
	margin-top: 70px;
	left: 0px;
}

input_text {
	width: 600px;
	height: 100px;
}

content {
	float: left;
	background-color: black;
	vertical-align: top;
	margin-bottom: 20px;
	height: 60px;
}
</style>
<script src="<c:url value="/resources/js/angular.min.js" />"></script>
<script>
	function formOpen() {
		window.open("form.jsp");
	}

	$('a#link').click(function() {
		var id = 1;
		var content = "zz";
		/* ... action ... */
		window.open("/updateContent?id=" + id + "&content=" + content);
	});

	function updateContent(id, content, pass) {
		//	content = content.split(' ').join("~");
		window.open("updateContentForm.jsp?id=" + id + "&content=" + content
				+ "&pass=" + pass); //
		/*
		$.ajax({
			url : "/updateContent?id=" + id + "&content=" + content
		}).done(function(data) {
			console.log("zzzzzzzzzzzzzzzzzzzzzzzz");
			refreshBulletin();
		});
		 */
	}
</script>

<title>NHN Enter first warm-up</title>

</head>
<body>
	<div id="fixed-menu">
		<div align="center">
			<h2>방명록</h2>
		</div>
	</div>

	<!-- 
	<P>The time on the server is ${serverTime}.</P>
 -->
 <div align="center">
	<P>방명록 수 : ${board_length}	&nbsp;&nbsp;&nbsp;	<button type="button"
			onclick="location.href='javascript:formOpen();' ">새로운 글 게시</button>
	</P> 
		<table border=1>
			<tr>
				<td align=center>이메일</td>
				<td align=center>내용</td>
				<td align=center>작성시간</td>

			</tr>
			<%
				int size = (Integer) request.getAttribute("board_length");
				BoardVO[] boardVOArr = (BoardVO[]) request
						.getAttribute("boardVOArr");
				for (int i = 0; i < size; i++) {
			%>
			<tr>
				<td><%=boardVOArr[i].getEmail()%></td>
				<td><a href="#"> <span
						onclick="javascript:updateContent('<%=boardVOArr[i].getId()%>', '<%=boardVOArr[i].getContent()%>', '<%=boardVOArr[i].getPass()%>')">
							<%=boardVOArr[i].getContent()%>
					</span>
				</a></td>
				<td><%=boardVOArr[i].getTime()%></td>
			</tr>
			<%
				}
			%>
		</table>

		<!--  	<a href="form.jsp" target="_blank"></a>
	<FORM method="get" action="form.jsp"  target="_blank">
		<INPUT TYPE="submit" VALUE="새로운 글 게시">
	</FORM>
	-->


	</div>
</body>
</html>
