package fpt.fsdn.svtt1213.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fpt.fsdn.svtt1213.model.bean.DropdownlistTuyenDuong;
import fpt.fsdn.svtt1213.model.bo.TrangChuBO;

/**
 * Servlet implementation class TrangChuServlet
 */
public class TrangChuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TrangChuBO trangChuBO = new TrangChuBO();
		ArrayList<DropdownlistTuyenDuong>  tuyenDuong = new ArrayList<DropdownlistTuyenDuong>();
		tuyenDuong = trangChuBO.getAllTuyenDuong();
		try {
			String currentDate = trangChuBO.getCurrentDate();
			request.setAttribute("currentDate", currentDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(tuyenDuong.size()!=0){
			request.setAttribute("tuyenDuong", tuyenDuong);
			RequestDispatcher rd = request.getRequestDispatcher("trangchu.jsp");
			rd.forward(request, response);
		}
	}

}
