<%@page import="com.sist.vo.BookVO"%>
<%@page import="com.sist.dao.BookDao"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int bookid = Integer.parseInt(request.getParameter("bookid"));
	//int bookid = 1;
	BookDao dao = new BookDao();
	BookVO b = dao.getBook(bookid);
	
	
	String result = "{\"bookname\":\""+b.getBookname()+"\",\"publisher\":\""+b.getPublisher()+"\",\"price\":"+b.getPrice()+"}";
%>
<%=result%>