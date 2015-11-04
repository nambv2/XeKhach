package fpt.fsdn.svtt1213.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fpt.fsdn.svtt1213.model.bean.QuanLyVe;
import fpt.fsdn.svtt1213.model.bo.QuanLyVeBO;


public class QuanlyveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String tenDangNhap = (String)session.getAttribute("tenDangNhap");
		ArrayList<QuanLyVe> data = new ArrayList<QuanLyVe>();
		QuanLyVeBO quanLyVeBO=new QuanLyVeBO();
		data=quanLyVeBO.getDatabase(tenDangNhap);
		request.setAttribute("data", data);
		RequestDispatcher rd = request.getRequestDispatcher("/quanlyve.jsp");
		rd.forward(request, response);
	}

}
