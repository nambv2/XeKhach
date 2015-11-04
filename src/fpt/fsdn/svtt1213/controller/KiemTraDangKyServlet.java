package fpt.fsdn.svtt1213.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fpt.fsdn.svtt1213.model.bean.NguoiDung;
import fpt.fsdn.svtt1213.model.bo.DangKyBO;


public class KiemTraDangKyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hoTen = "";;
		String tenDangNhap = "";
		String queQuan = "";
		int gioiTinh = 2;
		String matKhau = "";
		String soDienThoai = "";
		String soCMND = "";
		
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
		
		if(request.getParameter("gioiTinh") != null){
			gioiTinh = Integer.parseInt(request.getParameter("gioiTinh"));
		}
		
	
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
		HashMap<String, String> err = new DangKyBO().checkNguoiDung(u);
		String strErr = "";
		
		for ( String key : err.keySet() ) {
		    strErr +=key+"-";
		}
		response.getWriter().write(strErr);
			
	}

}
