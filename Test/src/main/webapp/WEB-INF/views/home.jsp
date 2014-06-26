<%@page import="com.board.BoardVO"%>
<%@ page contentType="text/html;charset=utf-8"%>

<html>
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

<script src="http://code.jquery.com/jquery-latest.min.js"
	type="text/javascript"></script>

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

	function updateContent(id) {
		//	var id = 1;
		var content = "zz";
		window.open("updateContentForm.jsp?id=" + id + "&content=" + content); //
		/*
		$.ajax({
			url : "/updateContent?id=" + id + "&content=" + content
		}).done(function(data) {
			console.log("zzzzzzzzzzzzzzzzzzzzzzzz");
			refreshBulletin();
		});
		 */
	}

	function refreshBulletin() {
		location.reload(true);
	}
</script>

<title>NHN Enter first warm-up</title>

</head>
<body>
	<div id="fixed-menu">
		<div align="center">
			<h2>nhn enter first warm-up</h2>
		</div>
	</div>

	<P>The time on the server is ${serverTime}.</P>

	<P>갯수 : ${board_length}</P>

	<table border=1>
		<%
			int size = (Integer) request.getAttribute("board_length");
			BoardVO[] boardVOArr = (BoardVO[]) request
					.getAttribute("boardVOArr");
			for (int i = 0; i < size; i++) {
		%>
		<tr>
			<td><%=boardVOArr[i].getEmail()%></td>
			<td><a href="#"> <span
					onclick="javascript:updateContent(\''+<%=boardVOArr[i].getId()%>+\'')"> <%=boardVOArr[i].getContent()%>
				</span>
			</a> <!--  
				<button type="button"
					onclick="location.href='javascript:updateContent(2);' ">
				</button>
			--></td>
			<td><%=boardVOArr[i].getTime()%></td>
			<td><%=boardVOArr[i].getPass()%></td>
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

	<button type="button" onclick="location.href='javascript:formOpen();' ">
		새로운 글 게시</button>

</body>
</html>
