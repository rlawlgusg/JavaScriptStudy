<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function calcAdd(){
		a = document.getElementById("num1").value;
		b = document.getElementById("num2").value;
		result = Number(a) + Number(b);
		document.getElementById("add").innerHTML = result;	
	}
	function calcMin() {
		a = document.getElementById("num1").value;
		b = document.getElementById("num2").value;
		result = Number(a) - Number(b);
		document.getElementById("min").innerHTML = result;
	}
	function calcMul() {
		a = document.getElementById("num1").value;
		b = document.getElementById("num2").value;
		result = Number(a) * Number(b);
		document.getElementById("mul").innerHTML = result;
	}
	function calcDiv() {
		a = document.getElementById("num1").value;
		b = document.getElementById("num2").value;
		result = Number(a) / Number(b);		
		document.getElementById("div").innerHTML = result;
	}
</script>
</head>
<body>

	수1: <input type="text" id="num1"> <br>
	수2: <input type="text" id="num2"> <br>
	<button onclick="calcAdd()">더하기</button><span id="add"></span>
	<button onclick="calcMin()">빼기</button><span id="min"></span>
	<button onclick="calcMul()">곱하기</button><span id="mul"></span>
	<button onclick="calcDiv()">나누기</button><span id="div"></span>
	

</body>
</html>