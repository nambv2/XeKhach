package fpt.fsdn.svtt1213.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fpt.fsdn.svtt1213.model.bean.NhanVien;
import fpt.fsdn.svtt1213.model.bo.CapNhatNhanVienBO;
import fpt.fsdn.svtt1213.model.bo.ThemNhanVienBO;
import fpt.fsdn.svtt1213.utility.Security;

/**
 * Servlet implementation class CapNhatNhanVienServlet
 */
public class CapNhatNhanVienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		if(request.getParameter("maNhanVien")!=null){
			NhanVien nhanVien = new NhanVien();
			String maNhanVien = (String)request.getParameter("maNhanVien");
			String hoTen = (String)request.getParameter("hoTen");
			String gioiTinh  = (String)request.getParameter("gioiTinh");
			String dienThoai = (String)request.getParameter("dienThoai");
			String queQuan = (String)request.getParameter("queQuan");
			String CMND = (String)request.getParameter("CMND");
			String viTri = (String)request.getParameter("viTri");
		
			hoTen = hoTen.trim();
			queQuan = queQuan.trim();
			nhanVien.setMaNhanVien(maNhanVien);
			nhanVien.setHoTen(hoTen);
			if("1".equals(gioiTinh)) nhanVien.setGioiTinh("1");
				else nhanVien.setGioiTinh("2");
			nhanVien.setDienThoai(dienThoai);
			nhanVien.setQueQuan(queQuan);
			nhanVien.setCMND(CMND);
			if("1".equals(viTri)) nhanVien.setViTri("1");
				else nhanVien.setViTri("2");
			
			CapNhatNhanVienBO capNhatNhanVienBO = new CapNhatNhanVienBO();
			ArrayList<String> validate = capNhatNhanVienBO.isValidate(nhanVien);
			
			if(validate.size()==0){
				int capnhatThanhCong = capNhatNhanVienBO.capNhatNhanVien(nhanVien);

				if(capnhatThanhCong != 0){
					request.setAttribute("capNhatThanhCong", "capNhatThanhCong");
					RequestDispatcher rd = request.getRequestDispatcher("DanhSachNhanVienServlet");
					rd.forward(request, response);
				}
				else{
					request.setAttribute("capNhatThatBai", "capNhatThatBai");
					request.setAttribute("maNhanVien", maNhanVien);
					request.setAttribute("hoTen", hoTen);
					request.setAttribute("gioiTinh", gioiTinh);
					request.setAttribute("dienThoai", dienThoai);
					request.setAttribute("queQuan", queQuan);
					request.setAttribute("CMND", CMND);
					request.setAttribute("viTri", viTri);

					RequestDispatcher rd = request.getRequestDispatcher("admin/danhsachnhanvien.jsp");
					rd.forward(request, response);
				}
				
			}else{
				for (int i = 0; i < validate.size(); i++) {
					request.setAttribute(validate.get(i).toString(), validate.get(i).toString());
				}
				request.setAttribute("maNhanVien", maNhanVien);
				request.setAttribute("hoTen", Security.stringToHTMLString(hoTen));
				request.setAttribute("gioiTinh", gioiTinh);
				request.setAttribute("dienThoai", Security.stringToHTMLString(dienThoai));
				request.setAttribute("queQuan", Security.stringToHTMLString(queQuan));
				request.setAttribute("CMND", Security.stringToHTMLString(CMND));
				request.setAttribute("viTri", viTri);
				RequestDispatcher rd = request.getRequestDispatcher("admin/capnhatnhanvien.jsp");
				rd.forward(request, response);
			}
		}else response.sendRedirect("DanhSachNhanVienServlet");
	}

}
