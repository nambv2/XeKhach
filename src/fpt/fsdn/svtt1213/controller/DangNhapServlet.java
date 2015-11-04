package fpt.fsdn.svtt1213.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fpt.fsdn.svtt1213.model.bo.DangNhapBO;
import fpt.fsdn.svtt1213.utility.Security;


public class DangNhapServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("tenDangNhap") == null){
			String tenDangNhap = "";
			String matKhau = "";
			if(request.getParameter("tenDangNhap") != null){
				tenDangNhap = request.getParameter("tenDangNhap");
			}
			if(request.getParameter("matKhau") != null){
				matKhau = request.getParameter("matKhau");
			}
			
			
			DangNhapBO dn = new DangNhapBO();
			if(dn.kiemTraDangNhap(tenDangNhap, matKhau) == true){
				session.setAttribute("tenDangNhap",dn.getNguoiDung(tenDangNhap).getTenDangNhap() );
				session.setAttribute("phanQuyen", dn.getNguoiDung(tenDangNhap).getPhanQuyen());
				
				RequestDispatcher rd;
				if(dn.getNguoiDung(tenDangNhap).getPhanQuyen() == 1){
					 rd = request.getRequestDispatcher("TrangChuServlet");
				}else{
					 rd = request.getRequestDispatcher("admin/quantri.jsp");
				}
				rd.forward(request, response);
			}
			else{
				request.setAttribute("message", "Đăng nhập thất bại");
				request.setAttribute("tenDangNhap", Security.stringToHTMLString(tenDangNhap));
				request.setAttribute("matKhau", Security.stringToHTMLString(matKhau));
				RequestDispatcher rd = request.getRequestDispatcher("dangnhap.jsp");
				rd.forward(request, response);
			}
		}else{
			response.sendRedirect("TrangChuServlet");
		}
		
		
		
	}

}
