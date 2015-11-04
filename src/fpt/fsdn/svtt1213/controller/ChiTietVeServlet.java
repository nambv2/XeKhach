package fpt.fsdn.svtt1213.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fpt.fsdn.svtt1213.model.bean.QuanLyVe;
import fpt.fsdn.svtt1213.model.bo.ChiTietVeBO;
import fpt.fsdn.svtt1213.model.bo.QuanLyVeBO;

/**
 * Servlet implementation class ChiTietVeServlet
 */
public class ChiTietVeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		int maVe = Integer.parseInt(request.getParameter("maVe"));
		String thongbao1 = "loi";
		ChiTietVeBO chiTietVeBO = new ChiTietVeBO();
			ArrayList<QuanLyVe> data = new ArrayList<QuanLyVe>();
			data = chiTietVeBO.traDuLieu(maVe);
			request.setAttribute("data", data);
			request.setAttribute("maVe", maVe);
			RequestDispatcher rd = request
					.getRequestDispatcher("/chitietve.jsp");
			rd.forward(request, response);

	}

}
