package fpt.fsdn.svtt1213.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fpt.fsdn.svtt1213.model.bean.GiaVe;
import fpt.fsdn.svtt1213.model.bo.XoaGiaVeBO;

public class XoaGiaVeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maTuyen=request.getParameter("maTuyen");
		String bienSoXe=request.getParameter("bienSoXe");
		GiaVe giave=new GiaVe();
		giave.setMaTuyen(maTuyen);
		giave.setBienSoXe(bienSoXe);
		
		XoaGiaVeBO xoaGiaVe=new XoaGiaVeBO();
		try {
			xoaGiaVe.xoaGiave(giave);
			request.setAttribute("xoaOK", "ok");
			RequestDispatcher 	rd=request.getRequestDispatcher("DanhSachGiaVeServlet");
			rd.forward(request, response);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
