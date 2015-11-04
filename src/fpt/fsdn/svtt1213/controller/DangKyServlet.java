package fpt.fsdn.svtt1213.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fpt.fsdn.svtt1213.model.bean.NguoiDung;
import fpt.fsdn.svtt1213.model.bo.DangKyBO;

public class DangKyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hoTen = "";
		String tenDangNhap = "";
		String queQuan = "";
		int gioiTinh = 0;
		String matKhau = "";
		String soDienThoai = "";
		String soCMND = "";
		
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
	   if(request.getParameter("gioiTinh") != null){
	    
			// Lay du lieu tu form 
			if(request.getParameter("inputHoTen") != null){
				hoTen = request.getParameter("inputHoTen");
			}
			
			if(request.getParameter("inputTenDangNhap") != null){
				tenDangNhap = request.getParameter("inputTenDangNhap");
			}
			
			if(request.getParameter("inputQueQuan") != null){
				queQuan = request.getParameter("inputQueQuan");
			}
			
			gioiTinh = Integer.parseInt(request.getParameter("gioiTinh"));
		
			
		
			if(request.getParameter("inputMatKhau") != null){
				matKhau = request.getParameter("inputMatKhau");
			}
			if(request.getParameter("inputSoDienThoai") != null){
				soDienThoai = request.getParameter("inputSoDienThoai");
			}
			if(request.getParameter("inputSoCMND") != null){
				soCMND = request.getParameter("inputSoCMND");
			}
			
			//set du lieu vao bean
			NguoiDung u = new NguoiDung();
			u.setHoTen(hoTen);
			u.setTenDangNhap(tenDangNhap);
			u.setGioiTinh(gioiTinh);
			u.setQueQuan(queQuan);
			u.setMatKhau(matKhau);
			u.setSoDienThoai(soDienThoai);
			u.setSoCMND(soCMND);
			
			DangKyBO dk=new DangKyBO();
			if(dk.checkNguoiDung(u).isEmpty()){
				if(dk.dangKy(u)==true){
					request.setAttribute("message", "Đăng ký thành công");
					request.setAttribute("nguoidung", u);
					RequestDispatcher rd = request.getRequestDispatcher("dangky.jsp");
					rd.forward(request, response);
				}
				
			}else{//Thong bao loi
				request.setAttribute("hashMapError", dk.checkNguoiDung(u));
				request.setAttribute("nguoidung", u);
				request.setAttribute("message", "Đăng ký thất bại");
				RequestDispatcher rd = request.getRequestDispatcher("dangky.jsp");
				rd.forward(request, response);
			}
				//kiem tra du lieu hop le khong, neu hop le thi them vao DB
	   }else{
		   response.sendRedirect("TrangChuServlet");
	   }
	}

}
