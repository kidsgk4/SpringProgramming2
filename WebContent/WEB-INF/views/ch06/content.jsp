<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	function btnLogin() {
		if ($("#mid").val() == "")
			return false;
		if ($("#mpassword").val() == "")
			return false;
		return true;

	}

	function btnLogout() {
		location.href = "logout";
	}

	function jsonDownload1() {
		$.ajax({
			url:"jsonDownload1",
			success:function(data){
				$("#bno").html(data.bno);
				$("#btitle").html(data.btitle);
				$("#writer").html(data.writer);
				$("#hitcount").html(data.hitcount);
				
				var html="<tr>";
				html+="		<td>"+data.bno+"</td>"
				html+="		<td>"+data.btitle+"</td>"
				html+="		<td>"+data.writer+"</td>"
				html+="		<td>"+data.date+"</td>"
				html+="		<td>"+data.hitcount+"</td>"
				html+="</tr>"
				$("tbody").append(html);
			}
		});
	}
	function jsonDownload2() {
		$.ajax({
			url:"jsonDownload2",
			success:function(data){
				$("#bno").html(data.bno);
				$("#btitle").html(data.btitle);
				$("#writer").html(data.writer);
				$("#hitcount").html(data.hitcount);
				
				var html="<tr>";
				html+="		<td>"+data.bno+"</td>"
				html+="		<td>"+data.btitle+"</td>"
				html+="		<td>"+data.writer+"</td>"
				html+="		<td>"+data.date+"</td>"
				html+="		<td>"+data.hitcount+"</td>"
				html+="</tr>"
				$("tbody").append(html);
			}
		});
	}
</script>
</head>
<body>
	<h5>[HttpSession을 이용해서 로그인 구현]</h5>

	<div>
		<c:if test="${loginResult !='success'}">
			<form id="loginForm" method="post" action="login">
				<div class="form-group">
					<label for="mid">아이디</label> <input type="text"
						class="form-control" id="mid" name="mid">

					<c:if test="${loginResult =='wrongMid'}">
						<span style="color: red";>로그인 아이디가 없습니다.</span>
					</c:if>
				</div>

				<div class="form-group">
					<label for="mpassword">패스워드</label> <input type="password"
						class="form-control" id="mpassword" name="mpassword">

					<c:if test="${loginResult=='wrongMpassword'}">
						<span style="color: red";>비밀번호가 틀립니다.</span>
					</c:if>
				</div>

				<input type="submit" onClick="return btnLogin()"
					class="btn btn-primary" value="로그인">
				</button>
			</form>

		</c:if>

		<c:if test="${loginResult =='success'}">

			<div id="logoutDiv">
				<button class="btn btn-danger" onClick="btnLogout()">로그아웃</button>
			</div>
		</c:if>
	</div>

	<h5>[OutputStream 이용해서 파일 다운로드 구현]</h5>
	<div>
		<br /> <img
			src="<%=application.getContextPath()%>/resources/image/Desert.jpg"
			width="100" /> <br /> <img src="fileDownload?fname=Desert.jpg"
			width="100" /> <br /> <a href="fileDownload?fname=Desert.jpg">파일
			다운로드</a>
	</div>
	<br />

	<h5>[Writer 를 이용해서 JSON 데이터 다운로드]</h5>
	<a href="javascript:jsonDownload1()">JSP 에서 생성</a>
	<br/>
	<a href="javascript:jsonDownload2()">Controller 에서 생성</a>
	<br/>
	<div>
	
		<table class="table table-sm">
			<thead>
				<tr>
					<th scope="col">번호</th>
					<th scope="col">제목</th>
					<th scope="col">글쓴이</th>
					<th scope="col">날짜</th>
					<th scope="col">조회수</th>
				</tr>
			</thead>
			<tbody>
				
			</tbody>
		</table>
	</div>
</body>
</html>