package fpt.fsdn.svtt1213.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fpt.fsdn.svtt1213.model.bo.XoaNhanVienBO;

/**
 * Servlet implementation class XoaNhanVienServlet
 */
public class XoaNhanVienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		if(request.getParameter("maNhanVien")!=null){
			String maNhanVien = (String) request.getParameter("maNhanVien");
			if(maNhanVien!=null){
				XoaNhanVienBO xoaNhanVienBO = new XoaNhanVienBO();
				xoaNhanVienBO.xoaNhanVien(maNhanVien);
			}
		}else response.sendRedirect("DanhSachNhanVienServlet");
	}

}
