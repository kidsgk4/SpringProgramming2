<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script
	src="<%=application.getContextPath()%>/resources/js/jquery-3.4.1.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=application.getContextPath()%>/resources/bootstrap-4.3.1-dist/css/bootstrap.min.css" />
<script
	src="<%=application.getContextPath()%>/resources/bootstrap-4.3.1-dist/js/bootstrap.min.js"></script>
<script>
	function getBoardList(pageNo) {
		$.ajax({
			url : "getBoardList2",
			data : "pageNo=" + pageNo,
			method : "get",
			success : function(data) {
				$("#boardListDiv").html(data);
			}
		});
	}
	
	$(function(){
		getBoardList(1); //끝까지 다 문서를 해석하고 호출하셈 
			
	});
	
	 /* function init(){
		getBoardList(1);
	} */
</script>
</head>
<body>
	<div id="boardListDiv"></div>
	<div class="btn-toolbar" role="toolbar"
		aria-label="Toolbar with button groups">
		<div class="btn-group mr-2" role="group" aria-label="First group">
			<%
				for (int i = 1; i <= 10; i++) {
			%>
			<a href="javascript:getBoardList(<%=i%>)" type="button"
				class="btn btn-danger"><%=i%></a>
			<%
				}
			%>


		</div>
	</div>
	<img src="<%=application.getContextPath()%>/resources/image/Desert.jpg"/>
	<img src="<%=application.getContextPath()%>/resources/image/Koala.jpg"/>
	<img src="<%=application.getContextPath()%>/resources/image/Penguins.jpg"/>
	<img src="<%=application.getContextPath()%>/resources/image/Tulips.jpg"/>
</body>
</html>