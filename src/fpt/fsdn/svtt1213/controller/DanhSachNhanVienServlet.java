package fpt.fsdn.svtt1213.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fpt.fsdn.svtt1213.model.bean.NhanVien;
import fpt.fsdn.svtt1213.model.bo.DanhSachNhanVienBO;

/**
 * Servlet implementation class DanhSachNhanVienServlet
 */
public class DanhSachNhanVienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getAttribute("themThanhCong")!=null){
			request.setAttribute("themThanhCong", "themThanhCong");
		}
		if(request.getAttribute("capNhatThanhCong")!=null){
			request.setAttribute("capNhatThanhCong", "capNhatThanhCong");
		}
		DanhSachNhanVienBO danhSachNV = new DanhSachNhanVienBO();
		ArrayList<NhanVien> nhanvien = danhSachNV.getAllDanhSachNhanVien();
		HttpSession session = request.getSession();
		session.setAttribute("nhanvien", nhanvien);
		RequestDispatcher rd = request.getRequestDispatcher("admin/danhsachnhanvien.jsp");
		rd.forward(request, response);
	}

}
