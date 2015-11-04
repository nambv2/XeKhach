package fpt.fsdn.svtt1213.controller;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fpt.fsdn.svtt1213.model.bean.DanhSachVeDuocDat;
import fpt.fsdn.svtt1213.model.bo.ChiTietVeAdminBO;

/**
 * Servlet implementation class ChiTietVeAdminServlet
 */
public class ChiTietVeAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ChiTietVeAdminBO chitietVe=new ChiTietVeAdminBO();
	RequestDispatcher rd;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maVe=request.getParameter("maVe").trim();
		DanhSachVeDuocDat danhsachVe = new DanhSachVeDuocDat();
		ArrayList<String> validate = chitietVe.isvalidateFieldprice(maVe);
		System.out.println(validate.size());
		if(validate.size()>0){
			rd=request.getRequestDispatcher("DanhSachVeDuocDatServlet");
			rd.forward(request, response);
		}
		else{
		if(chitietVe.kiemtraVe(maVe)==true)	{
		try {
		
		danhsachVe=chitietVe.timVe(maVe);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	   
		request.setAttribute("chitietVe",danhsachVe);
		 rd=request.getRequestDispatcher("admin/xemchitietve.jsp");
		rd.forward(request, response);
	}else {
		 rd=request.getRequestDispatcher("DanhSachVeDuocDatServlet");
			rd.forward(request, response);
		}
	}
	}
}
