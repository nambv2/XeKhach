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


public class DanhsachtuyenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ArrayList<TuyenDuong> data = new ArrayList<TuyenDuong>();
		DanhsachtuyenduongBO danhsachtuyenduongBO=new DanhsachtuyenduongBO();
		data=danhsachtuyenduongBO.getDatabase();
		request.setAttribute("data", data);
		RequestDispatcher rd = request.getRequestDispatcher("admin/danhsachtuyen.jsp");
		rd.forward(request, response);
	}

}
