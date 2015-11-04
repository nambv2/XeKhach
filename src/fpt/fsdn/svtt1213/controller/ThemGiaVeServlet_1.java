package fpt.fsdn.svtt1213.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fpt.fsdn.svtt1213.model.bean.TuyenDuong;
import fpt.fsdn.svtt1213.model.bo.ThemGiaVeBO;


public class ThemGiaVeServlet_1 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   ArrayList<TuyenDuong> arrTuyen=new ArrayList<TuyenDuong>();
	   ThemGiaVeBO kiemtraGiaveBO=new ThemGiaVeBO();
	   
		try {
			arrTuyen=kiemtraGiaveBO.tuyenDuong();
			request.setAttribute("tuyen", arrTuyen);
			RequestDispatcher rd=request.getRequestDispatcher("admin/themgiave.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	    
	    	
		
	}

}
