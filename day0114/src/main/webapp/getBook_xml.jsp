<%@page import="com.sist.vo.BookVO"%>
<%@page import="com.sist.dao.BookDao"%>
<%@ page language="java" contentType="application/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int bookid = Integer.parseInt(request.getParameter("bookid"));
	BookDao dao = new BookDao();
	BookVO b = dao.getBook(bookid);
	String result = "<book>";
	result += "<bookname>"+b.getBookname()+"</bookname>";
	result += "<publisher>"+b.getPublisher()+"</publisher>";
	result += "<price>"+b.getPrice()+"</price>";
	result += "</book>";
%>
<%=result%>