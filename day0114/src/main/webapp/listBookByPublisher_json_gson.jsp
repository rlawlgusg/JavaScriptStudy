<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.vo.BookVO"%>
<%@page import="com.sist.dao.BookDao"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String publisher = request.getParameter("publisher");
	//String publisher = "굿스포츠";
	BookDao dao = new BookDao();
	ArrayList<BookVO> list = dao.listBookByPublisher(publisher);
	
	Gson gson = new Gson();
	String result = gson.toJson(list);
%>
<%=result%>