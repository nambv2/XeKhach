package fpt.fsdn.svtt1213.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fpt.fsdn.svtt1213.model.bean.Xe;
import fpt.fsdn.svtt1213.model.bo.DanhSachXeBO;

/**
 * Servlet implementation class DanhSachXe
 */
public class DanhSachXeServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Xe> listXe = new ArrayList<Xe>();
		
		DanhSachXeBO danhSachXeBO = new DanhSachXeBO();
		listXe = danhSachXeBO.hienThiDanhSach();
		
		request.setAttribute("ListXe",listXe);
		RequestDispatcher rd = request.getRequestDispatcher("admin/danhsachxe.jsp");
		rd.forward(request, response);
		
	}

}
