package com.sist.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.customerDAO;
import com.sist.vo.customerVO;
import com.thoughtworks.xstream.XStream;

/**
 * Servlet implementation class CustomerXML
 */
@WebServlet("/CustomerXML")
public class CustomerXML extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public customerDAO dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerXML() {
        super();
        dao = new customerDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/xml;charset=utf-8");
		XStream xStream = new XStream();
		xStream.alias("customer", customerVO.class);
		PrintWriter out = response.getWriter();
		out.print(xStream.toXML(dao.getListCustomer()));
		out.close();
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
