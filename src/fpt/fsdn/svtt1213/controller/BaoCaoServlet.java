package fpt.fsdn.svtt1213.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fpt.fsdn.svtt1213.model.bean.BaoCao;
import fpt.fsdn.svtt1213.model.bo.BaoCaoBO;


public class BaoCaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if("hienthi".equals(request.getParameter("hienthi"))){
			//lay du lieu va goi den BO kiem tra
			String tu = "";
			String den = "";
			tu = request.getParameter("namTu");
			den = request.getParameter("namDen");
			BaoCaoBO bc = new BaoCaoBO();
			if("invalid".equals(bc.check(tu, den)[0])){
				request.setAttribute("error", "error");
				request.setAttribute("namDau", new BaoCaoBO().getNamDauTuyen());
				request.setAttribute("namTu",tu);
				request.setAttribute("namDen", den);
				RequestDispatcher rd = request.getRequestDispatcher("admin/baocao.jsp");
				rd.forward(request, response);
			}else{
				ArrayList<BaoCao> arr = bc.hienThi(bc.check(tu, den));
				request.setAttribute("baocao", arr);
				request.setAttribute("namDau", new BaoCaoBO().getNamDauTuyen());
				request.setAttribute("namTu",tu);
				request.setAttribute("namDen", den);
				RequestDispatcher rd = request.getRequestDispatcher("admin/baocao.jsp");
				rd.forward(request, response);
			}
			
		}else{
			request.setAttribute("namDau", new BaoCaoBO().getNamDauTuyen());
			RequestDispatcher rd = request.getRequestDispatcher("admin/baocao.jsp");
			rd.forward(request, response);
		}
	}

}
