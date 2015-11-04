package fpt.fsdn.svtt1213.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fpt.fsdn.svtt1213.model.bean.NguoiDung;

import fpt.fsdn.svtt1213.model.bo.ThongTinTaiKhoanBO;

public class CapnhatThongTinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		if(request.getParameter("gioiTinh") != null){
			String hoTen=request.getParameter("hoTen");
			String queQuan=request.getParameter("queQuan");
			String soDT=request.getParameter("soDT");
			String soCMND=request.getParameter("cmnd");
			String gioiTinh=request.getParameter("gioiTinh");
			String tenDangnhap=request.getParameter("tenDangnhap");	
			RequestDispatcher rd;
			NguoiDung nguoidung=new NguoiDung();
			NguoiDung taikhoan=new NguoiDung();
			ThongTinTaiKhoanBO capnhatThongtin=new ThongTinTaiKhoanBO();
			try {
				taikhoan=capnhatThongtin.timThongTin(tenDangnhap);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			nguoidung.setHoTen(hoTen);
			nguoidung.setGioiTinh(Integer.parseInt(gioiTinh));
			nguoidung.setQueQuan(queQuan);
			nguoidung.setSoCMND(soCMND);
			nguoidung.setSoDienThoai(soDT);
			nguoidung.setTenDangNhap(tenDangnhap);
			nguoidung.setMatKhau(taikhoan.getMatKhau());
			request.setAttribute("nguoidung", nguoidung);
			 rd=request.getRequestDispatcher("suathongtincanhan.jsp");
			rd.forward(request, response);
		}else{
			response.sendRedirect("TrangChuServlet");
		}
		
	}

}
