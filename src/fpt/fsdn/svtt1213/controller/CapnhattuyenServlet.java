package fpt.fsdn.svtt1213.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fpt.fsdn.svtt1213.model.bean.TuyenDuong;
import fpt.fsdn.svtt1213.model.bo.CapnhattuyenBO;
import fpt.fsdn.svtt1213.utility.Security;

public class CapnhattuyenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String maTuyen = request.getParameter("maTuyen");
		String submit = request.getParameter("submit");
		String noiDi = request.getParameter("noiDi");
		String noiDen = request.getParameter("noiDen");
		request.setAttribute("maTuyen", maTuyen);
		String thongBao = "loi";
		
		
		TuyenDuong tuyenDuong = new TuyenDuong();
		CapnhattuyenBO capnhattuyenBO = new CapnhattuyenBO();
		ArrayList<String> error = new ArrayList<String>();
		
		if(capnhattuyenBO.kiemTraMaTuyen(maTuyen)==false){
			request.setAttribute("thongBao",thongBao);
			RequestDispatcher rd = request.getRequestDispatcher("admin/capnhattuyen.jsp");
			rd.forward(request, response);
		}
		else{
		if(maTuyen != null){
			
			if(submit == null){
								
				tuyenDuong = capnhattuyenBO.hienThiTuyen(maTuyen);
				request.setAttribute("noiDi", tuyenDuong.getNoiDi());
				request.setAttribute("noiDen", tuyenDuong.getNoiDen());
				
				RequestDispatcher rd = request.getRequestDispatcher("admin/capnhattuyen.jsp");
				rd.forward(request, response);	
				
			}else{
				
				tuyenDuong.setNoiDen(noiDen.trim());
				tuyenDuong.setNoiDi(noiDi.trim());
				tuyenDuong.setMaTuyen(maTuyen);
				
				error = capnhattuyenBO.checkError(tuyenDuong);
				
				if(error.size() == 0){
				request.getParameter("noiDi");
				request.getParameter("noiDen");
				capnhattuyenBO.capNhat(tuyenDuong);
				response.sendRedirect("DanhsachtuyenServlet");
				
				}else{
					
					request.setAttribute("error", error);
					request.setAttribute("noiDi", Security.stringToHTMLString(noiDi));
					request.setAttribute("noiDen", Security.stringToHTMLString(noiDen));
					request.setAttribute("maTuyen", maTuyen);
					
					RequestDispatcher rd = request.getRequestDispatcher("admin/capnhattuyen.jsp");
					rd.forward(request, response);
				}
			}
		
		}
		else{
			response.sendRedirect("DanhsachtuyenServlet");
		}
	}
	}
}
