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
import fpt.fsdn.svtt1213.model.bo.ThemGiaVeBO;
import fpt.fsdn.svtt1213.utility.Security;

public class ThemGiaVeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher rd;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		if(request.getParameter("inputmatuyen")!=null &&request.getParameter("inputbiensoxe")!=null&&request.getParameter("inputgiamgiave")!=null
				&&request.getParameter("inputgiave")!=null	){
		ThemGiaVeBO kiemtraGiaveBO=new ThemGiaVeBO();
		ArrayList<TuyenDuong> arrTuyen=new ArrayList<TuyenDuong>();
		float g1,g2;
		
		String matuyen=request.getParameter("inputmatuyen");
		String biensoxe=request.getParameter("inputbiensoxe");
		String ktra_giamGia=request.getParameter("inputgiamgiave");
		String ktra_giaVe=request.getParameter("inputgiave");
		if("all".equals(matuyen)){
			request.setAttribute("inputmatuyen","ErrorMatuyen");
			
			rd=request.getRequestDispatcher("admin/themgiave.jsp");
			
		}
		 if("all".equals(biensoxe)){
			request.setAttribute("inputbiensoxe", "ErrorBiensoXe");
		
			rd=request.getRequestDispatcher("admin/themgiave.jsp");
			
		}
		ArrayList<String> validate =kiemtraGiaveBO.isValidateFieldprice(ktra_giaVe,ktra_giamGia);
		try {
			arrTuyen=kiemtraGiaveBO.tuyenDuong();
			request.setAttribute("tuyen", arrTuyen);
			rd=request.getRequestDispatcher("admin/themgiave.jsp");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		if(validate.size()!=0) {
			for (int i = 0; i < validate.size(); i++) {
				request.setAttribute(validate.get(i).toString(), validate.get(i).toString());
			}GiaVe giaVe=new GiaVe();
			giaVe.setMaTuyen(matuyen);
			giaVe.setBienSoXe(biensoxe);
			request.setAttribute("VeTonTai", giaVe);
			request.setAttribute("inputgiave", Security.stringToHTMLString(ktra_giaVe));
			request.setAttribute("inputgiamgiave", Security.stringToHTMLString(ktra_giamGia));
			rd=request.getRequestDispatcher("admin/themgiave.jsp");
			rd.forward(request, response);
		}
		else{
			
				g1 = Float.parseFloat(ktra_giamGia);
			
				g2 = Float.parseFloat(ktra_giaVe);
			
				GiaVe gia_ve=new GiaVe();
				gia_ve.setBienSoXe(biensoxe);
				gia_ve.setMaTuyen(matuyen);
				gia_ve.setGiaVe(g2);
				gia_ve.setGiamGiave(g1);
				
			if(kiemtraGiaveBO.themGiave(gia_ve)>0)
			   { request.setAttribute("themOK", "ok");
				rd=request.getRequestDispatcher("DanhSachGiaVeServlet");
				rd.forward(request, response);
				}
			else {
					request.setAttribute("VeTontai", gia_ve);
					request.setAttribute("ktra_giamGia", Security.stringToHTMLString(ktra_giamGia));
					request.setAttribute("ktra_giaVe", Security.stringToHTMLString(ktra_giaVe));
					rd=request.getRequestDispatcher("admin/themgiave.jsp");
					rd.forward(request, response);
					}
				   
			   }}
		else {
			rd=request.getRequestDispatcher("DanhSachGiaVeServlet");
			rd.forward(request, response);
		}
		}
		}
	
		

