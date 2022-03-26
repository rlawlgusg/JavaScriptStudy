<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function pro() {
		let n = Number(document.getElementById("num").value);
		let sum = 0;
		for(i=1;i<=n;i++){
			sum += i;
		}
		document.getElementById("result").innerHTML = sum;
	}
</script>
</head>
<body>
<h2>합구하기</h2>
<hr>
<input type="text" id="num">
<button onclick="pro()">더하기</button>
<hr>
<span id="result"></span>
</body>
</html>