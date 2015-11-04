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
import fpt.fsdn.svtt1213.model.bo.TimKiemNhanVienBO;
import fpt.fsdn.svtt1213.utility.Security;

/**
 * Servlet implementation class TimKiemNhanVienServlet
 */
public class TimKiemNhanVienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String hoTen = request.getParameter("hoTen");
		TimKiemNhanVienBO timKiemNhanVienBO = new TimKiemNhanVienBO();
		if(hoTen!=null){
			hoTen = hoTen.trim();
			if(timKiemNhanVienBO.isValidate(hoTen)){
				ArrayList<NhanVien> nhanvien =  timKiemNhanVienBO.timKiemNhanVien(hoTen);
				request.setAttribute("hoTen", hoTen);
				if(nhanvien.size()!=0){	
					HttpSession session = request.getSession();
					session.setAttribute("nhanvien", nhanvien);
				}
				else request.setAttribute("kotontai", "Khongtontai");
				
			}else {
				request.setAttribute("hoTen", Security.stringToHTMLString(hoTen));
				request.setAttribute("kohople", "Khonghople");
			}
			RequestDispatcher rd = request.getRequestDispatcher("admin/danhsachnhanvien.jsp");
			rd.forward(request, response);
		}else response.sendRedirect("DanhSachNhanVienServlet");
		
	}

}
