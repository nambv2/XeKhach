package fpt.fsdn.svtt1213.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fpt.fsdn.svtt1213.model.bean.NhanVien;
import fpt.fsdn.svtt1213.model.bo.TimKiemCapNhatNhanVienBO;

/**
 * Servlet implementation class TimKiemCapNhatNhanVienServlet
 */
public class TimKiemCapNhatNhanVienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maNhanVien = (String)request.getParameter("i");
		TimKiemCapNhatNhanVienBO timKiemCapNhatNhanVienBO = new TimKiemCapNhatNhanVienBO();
		if(request.getParameter("i")!=null){
			if(!("".equals(maNhanVien))){
				System.out.println(maNhanVien);
					NhanVien nhanvien =  timKiemCapNhatNhanVienBO.timKiemNhanVien(maNhanVien);
					System.out.println(nhanvien.getMaNhanVien());
					if(nhanvien.getMaNhanVien() != null){	
						request.setAttribute("maNhanVien", nhanvien.getMaNhanVien());
						request.setAttribute("hoTen", nhanvien.getHoTen());
						request.setAttribute("gioiTinh", nhanvien.getGioiTinh());
						request.setAttribute("dienThoai", nhanvien.getDienThoai());
						request.setAttribute("queQuan", nhanvien.getQueQuan());
						request.setAttribute("CMND", nhanvien.getCMND());
						request.setAttribute("viTri", nhanvien.getViTri());
						RequestDispatcher rd = request.getRequestDispatcher("admin/capnhatnhanvien.jsp");
						rd.forward(request, response);
					}
					else {
						response.sendRedirect("DanhSachNhanVienServlet");
					}
			}else response.sendRedirect("DanhSachNhanVienServlet");
		}else response.sendRedirect("DanhSachNhanVienServlet");
	}
	
}
