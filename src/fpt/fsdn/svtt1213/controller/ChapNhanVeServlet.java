package fpt.fsdn.svtt1213.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fpt.fsdn.svtt1213.model.bo.ChapNhanVeBO;


public class ChapNhanVeServlet extends HttpServlet {
    
	private static final long serialVersionUID = 1L;
	ChapNhanVeBO xulyVeBO=new ChapNhanVeBO();
     RequestDispatcher rd;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String maVe=request.getParameter("mave");
		
		if(request.getParameter("mave")!=null){
		
	    if(request.getParameter("button")!=null&&"trove".equals(request.getParameter("button"))){
	    	rd=request.getRequestDispatcher("DanhSachVeDuocDatServlet");
	    	rd.forward(request, response);
	    }
	   
		if(request.getParameter("button")!=null&&"chapnhan".equals(request.getParameter("button"))){
			try {
				xulyVeBO.chapnhanVe(maVe);
				request.setAttribute("xulyve", "chapnhan");
				rd=request.getRequestDispatcher("DanhSachVeDuocDatServlet");
				rd.forward(request, response);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		if(request.getParameter("button")!=null &&"huy".equals(request.getParameter("button"))){
			try {
				xulyVeBO.huyVe(maVe);
				request.setAttribute("xulyve", "huy");
				rd=request.getRequestDispatcher("DanhSachVeDuocDatServlet");
				rd.forward(request, response);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}
		else{
			rd=request.getRequestDispatcher("DanhSachVeDuocDatServlet");
			rd.forward(request, response);
		}
	}
}
