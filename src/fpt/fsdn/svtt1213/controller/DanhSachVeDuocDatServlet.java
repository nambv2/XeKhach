package fpt.fsdn.svtt1213.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fpt.fsdn.svtt1213.model.bean.DanhSachVeDuocDat;
import fpt.fsdn.svtt1213.model.bean.TuyenDuong;
import fpt.fsdn.svtt1213.model.bo.DanhsachVeDuocDatBO;
import fpt.fsdn.svtt1213.utility.Security;

public class DanhSachVeDuocDatServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<TuyenDuong> tuyenduong=new ArrayList<TuyenDuong>();
		ArrayList<DanhSachVeDuocDat> danhsachVe=new ArrayList<DanhSachVeDuocDat>();
		ArrayList<DanhSachVeDuocDat> danhSachVeDat=new ArrayList<DanhSachVeDuocDat>();
		
		DanhsachVeDuocDatBO veDuocdatBO=new DanhsachVeDuocDatBO();
		RequestDispatcher rd;
		String soCMND="";
		String maTuyen=request.getParameter("matuyen");	
		if(request.getParameter("CMND")!=null)
		 soCMND=request.getParameter("CMND");
		
		try {
			tuyenduong=veDuocdatBO.timTuyen();
			request.setAttribute("tuyen", tuyenduong);
			danhSachVeDat=veDuocdatBO.timVe(null,null);
		
			request.setAttribute("danhSachVeDat", danhSachVeDat);
			rd=request.getRequestDispatcher("admin/danhsachveduocdat.jsp");
			
			    request.setAttribute("CMND", Security.stringToHTMLString(soCMND));
			    request.setAttribute("maTuyen",maTuyen);
				danhsachVe=veDuocdatBO.timVe(maTuyen,soCMND);
				request.setAttribute("danhsachVe", danhsachVe);
				rd=request.getRequestDispatcher("admin/danhsachveduocdat.jsp");
				rd.forward(request, response);
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
