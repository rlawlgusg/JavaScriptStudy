<%@page import="com.sist.vo.OrderBookInfo"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.dao.BookDao"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int custid = Integer.parseInt(request.getParameter("custid"));
	//int custid = 1;
	BookDao dao = new BookDao();
	ArrayList<OrderBookInfo> list = dao.listOrderBook(custid);
	
	Gson gson = new Gson();
	String result = gson.toJson(list);
%>
<%=result%>