package fpt.fsdn.svtt1213.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fpt.fsdn.svtt1213.model.bo.XoaXeBO;

/**
 * Servlet implementation class XoaXeServlet
 */
public class XoaXeServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("bienSoXe") != null){
		String bienSoXe = request.getParameter("bienSoXe");
		
		System.out.println("bien so: "+bienSoXe);
		
		XoaXeBO xoaXeBO = new XoaXeBO();
		xoaXeBO.xoaXe(bienSoXe);
		}	
	}

}
