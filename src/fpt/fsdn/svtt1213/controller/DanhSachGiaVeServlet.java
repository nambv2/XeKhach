package fpt.fsdn.svtt1213.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fpt.fsdn.svtt1213.model.bean.GiaVe;
import fpt.fsdn.svtt1213.model.bean.TuyenDuong;
import fpt.fsdn.svtt1213.model.bo.DanhSachGiaVeBO;

public class DanhSachGiaVeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		    doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			String maTuyen = request.getParameter("matuyen");
			if("null".equals(maTuyen)){maTuyen=null;}
			DanhSachGiaVeBO danhsachGiaVe = new DanhSachGiaVeBO();
			ArrayList<GiaVe> arrGiaVe=new ArrayList<GiaVe>();
			RequestDispatcher rd ;
			ArrayList<TuyenDuong> arrTuyen = danhsachGiaVe.tuyenduong();
			request.setAttribute("tuyen", arrTuyen);
			
			rd= request.getRequestDispatcher("admin/danhsachgiave.jsp");
            
			arrGiaVe = danhsachGiaVe.timGiaVe(maTuyen);
			request.setAttribute("matuyen", maTuyen);
			request.setAttribute("giave", arrGiaVe);
			rd = request.getRequestDispatcher("admin/danhsachgiave.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
