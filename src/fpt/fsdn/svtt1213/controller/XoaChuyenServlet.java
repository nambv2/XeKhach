package fpt.fsdn.svtt1213.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fpt.fsdn.svtt1213.model.bo.XoaChuyenBO;

/**
 * Servlet implementation class XoaChuyenServlet
 */
public class XoaChuyenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maChuyen = request.getParameter("maChuyen");
		
		if(maChuyen != null){
		XoaChuyenBO xoaChuyenBO = new XoaChuyenBO();
		xoaChuyenBO.xoaChuyen(maChuyen);
		request.setAttribute("message", "xoaok");
		RequestDispatcher rd = 
			request.getRequestDispatcher("DanhSachChuyenServlet");
		rd.forward(request, response);
		}
		else{
			response.sendRedirect("DanhSachChuyenServlet");
		}
		
	}

}
