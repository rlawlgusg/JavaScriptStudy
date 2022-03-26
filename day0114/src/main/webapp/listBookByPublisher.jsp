<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.vo.BookVO"%>
<%@page import="com.sist.dao.BookDao"%>
<%@ page language="java" contentType="application/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String publisher = request.getParameter("publisher");
	//String publisher = "굿스포츠";
	BookDao dao = new BookDao();
	ArrayList<BookVO> list = dao.listBookByPublisher(publisher);
	String result = "<list>";
	for(BookVO b:list){
	result += "<book>";
	result += "<bookid>"+b.getBookname()+"</bookid>";
	result += "<bookname>"+b.getBookname()+"</bookname>";
	result += "<publisher>"+b.getPublisher()+"</publisher>";
	result += "<price>"+b.getPrice()+"</price>";
	result += "</book>";
	}
	result += "</list>";
	
%>
<%=result%>