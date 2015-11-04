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
import fpt.fsdn.svtt1213.model.bo.ChiTietVeBO;
import fpt.fsdn.svtt1213.model.bo.HuyVeBO;
import fpt.fsdn.svtt1213.model.bo.QuanLyVeBO;

/**
 * Servlet implementation class XoaVeServlet
 */
public class HuyVeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int maVe=Integer.parseInt(request.getParameter("maVe"));
		HttpSession session = request.getSession();
		String tenDangNhap = (String) session.getAttribute("tenDangNhap");
		HuyVeBO huyVeBO = new HuyVeBO();
		QuanLyVeBO quanLyVeBO =new QuanLyVeBO();
		String thongBao="kohople";
		if(huyVeBO.kTraTrangThai(maVe)==true){
			huyVeBO.huyVe(maVe);
			ArrayList<QuanLyVe> data = new ArrayList<QuanLyVe>();
			data=quanLyVeBO.getDatabase(tenDangNhap);
			request.setAttribute("data", data);
			RequestDispatcher rd = request.getRequestDispatcher("/quanlyve.jsp");
			rd.forward(request, response);
		}
		else {
			

			ArrayList<QuanLyVe> data = new ArrayList<QuanLyVe>();
			ChiTietVeBO chiTietVeBO=new ChiTietVeBO();
			data = chiTietVeBO.traDuLieu(maVe);
			request.setAttribute("data", data);
			request.setAttribute("thongBao", thongBao);
			RequestDispatcher rd = request.getRequestDispatcher("/chitietve.jsp");
			rd.forward(request, response);
		}

		

	}

}
