package fpt.fsdn.svtt1213.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fpt.fsdn.svtt1213.model.bean.TuyenDuong;
import fpt.fsdn.svtt1213.model.bo.DanhsachtuyenduongBO;
import fpt.fsdn.svtt1213.model.bo.XoatuyenBO;

/**
 * Servlet implementation class XoatuyenServlet
 */
public class XoatuyenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maTuyen;
		XoatuyenBO xoatuyenBO=new XoatuyenBO();
		maTuyen=request.getParameter("maTuyen");
		xoatuyenBO.xoaTuyen(maTuyen);
		
		request.setCharacterEncoding("UTF-8");
		ArrayList<TuyenDuong> data = new ArrayList<TuyenDuong>();
		DanhsachtuyenduongBO danhsachtuyenduongBO=new DanhsachtuyenduongBO();
		data=danhsachtuyenduongBO.getDatabase();
		request.setAttribute("data", data);
		RequestDispatcher rd = request.getRequestDispatcher("admin/danhsachtuyen.jsp");
		rd.forward(request, response);
	}

}
