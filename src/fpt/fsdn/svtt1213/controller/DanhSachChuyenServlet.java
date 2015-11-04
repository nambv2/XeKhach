package fpt.fsdn.svtt1213.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fpt.fsdn.svtt1213.model.bean.ChuyenXe;
import fpt.fsdn.svtt1213.model.bean.TuyenDuong;
import fpt.fsdn.svtt1213.model.bo.DanhSachChuyenXeBO;

/**
 * Servlet implementation class DanhSachChuyenServlet
 */
public class DanhSachChuyenServlet extends HttpServlet {
	
       
  
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String maTuyen=request.getParameter("maTuyen");
		DanhSachChuyenXeBO chuyen=new DanhSachChuyenXeBO();
		
				
		ArrayList<ChuyenXe> chuyenXe=new ArrayList<ChuyenXe>();
		ArrayList<TuyenDuong> listTuyen=new ArrayList<TuyenDuong>();
		
		listTuyen=chuyen.listTuyenDuong();
		request.setAttribute("TuyenDuong", listTuyen);
		
		if(maTuyen==null){
			chuyenXe=chuyen.hienThiDanhSach("all");			
		}
		else{
			chuyenXe=chuyen.hienThiDanhSach(maTuyen);
		}
				
		request.setAttribute("maTuyen", maTuyen);
		request.setAttribute("ChuyenXe", chuyenXe);	
		RequestDispatcher rd=request.getRequestDispatcher("admin/danhsachchuyenxe.jsp");
		rd.forward(request, response);
	}

}
