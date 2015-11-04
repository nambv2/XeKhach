package fpt.fsdn.svtt1213.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fpt.fsdn.svtt1213.model.bean.NguoiDung;
import fpt.fsdn.svtt1213.model.bo.SuaThongTinTaiKhoanBO;


public class SuaThongTinTaiKhoanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hoTen = "";
		String tenDangNhap = "";
		String queQuan = "";
		int gioiTinh = 0;
		String soDienThoai = "";
		String soCMND = "";
		
		request.setCharacterEncoding("UTF-8");
	    response.setCharacterEncoding("UTF-8");
	    if(request.getParameter("gioiTinh") != null){
	    	// Lay du lieu tu form 
			if(request.getParameter("inputHoTen") != null){
				hoTen = request.getParameter("inputHoTen");
			}
			
			
			if(request.getParameter("inputQueQuan") != null){
				queQuan = request.getParameter("inputQueQuan");
			}
			
			gioiTinh = Integer.parseInt(request.getParameter("gioiTinh"));
		
			
			if(request.getParameter("inputSoDienThoai") != null){
				soDienThoai = request.getParameter("inputSoDienThoai");
			}
			if(request.getParameter("inputSoCMND") != null){
				soCMND = request.getParameter("inputSoCMND");
			}

			SuaThongTinTaiKhoanBO capNhat = new SuaThongTinTaiKhoanBO();
			HttpSession session = request.getSession();
			tenDangNhap = session.getAttribute("tenDangNhap").toString();
			
			//set du lieu vao bean
			NguoiDung u = new NguoiDung();
			u.setHoTen(hoTen);
			u.setTenDangNhap(tenDangNhap);
			u.setGioiTinh(gioiTinh);
			u.setQueQuan(queQuan);
			u.setSoDienThoai(soDienThoai);
			u.setSoCMND(soCMND);
			
		
				//kiem tra du lieu hop le khong, neu hop le thi cap nhat vao DB
			if(capNhat.checkNguoiDung(u).isEmpty()){
				if(capNhat.capNhapTaiKhoan(u)==true){
					request.setAttribute("message", "Cập nhật thành công");
					request.setAttribute("nguoidung", u);
					RequestDispatcher rd = request.getRequestDispatcher("suathongtincanhan.jsp");
					rd.forward(request, response);
				}
			}else{//Thong bao loi
				request.setAttribute("hashMapError", capNhat.checkNguoiDung(u));
				request.setAttribute("nguoidung", u);
				request.setAttribute("message", "Cập nhật thất bại");
				RequestDispatcher rd = request.getRequestDispatcher("suathongtincanhan.jsp");
				rd.forward(request, response);
			}
	    }else{
	    	response.sendRedirect("TrangChuServlet");
	    }
		
	}

}
