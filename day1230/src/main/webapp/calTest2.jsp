<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function pro() {
	let num = (Number)(document.getElementById("num").value);
	let result = "짝수";
	
	if(num%2!=0){
	result = "홀";
	}
	document.getElementById("result").innerHTML = result;
	}
</script>
<body>
	수 : <input type="text" id="num">
	<button onclick="pro()">홀짝판별</button>
	<span id="result"></span>
</body>
</html>