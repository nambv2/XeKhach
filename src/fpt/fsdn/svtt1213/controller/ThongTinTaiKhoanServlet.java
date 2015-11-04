package fpt.fsdn.svtt1213.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fpt.fsdn.svtt1213.model.bean.NguoiDung;
import fpt.fsdn.svtt1213.model.bo.ThongTinTaiKhoanBO;


public class ThongTinTaiKhoanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("tenDangNhap") != null){
			String tenDangNhap = session.getAttribute("tenDangNhap").toString();
			NguoiDung nguoidung=new NguoiDung();
			ThongTinTaiKhoanBO thongtinTaikhoan=new ThongTinTaiKhoanBO();
			
				try {
					nguoidung=thongtinTaikhoan.timThongTin(tenDangNhap);
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				request.setAttribute("nguoiDung", nguoidung);
				RequestDispatcher rd=request.getRequestDispatcher("thongtintaikhoan.jsp");
				rd.forward(request, response);
		}else{
			response.sendRedirect("TrangChuServlet");
		}
		
		
		
	}

}
