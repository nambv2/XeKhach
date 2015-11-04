package fpt.fsdn.svtt1213.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fpt.fsdn.svtt1213.model.bean.GiaVe;
import fpt.fsdn.svtt1213.model.bean.TuyenDuong;
import fpt.fsdn.svtt1213.model.bo.CapNhatGiaVeBO;

public class CapnhatGiaVeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd ;
		String tenTuyen;
		GiaVe giave=new GiaVe();
		String maTuyen=request.getParameter("maTuyen");
		String bienSoXe=request.getParameter("bienSoXe");
		CapNhatGiaVeBO capnhatGiave=new CapNhatGiaVeBO();
		try {
			giave=capnhatGiave.kiemtraGiave(maTuyen,bienSoXe);
			
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}if(giave.getGiaVe()>0){
		
		giave.setMaTuyen(maTuyen);
		giave.setBienSoXe(bienSoXe);
		giave.setGiaVe(giave.getGiaVe());
		giave.setGiamGiave(giave.getGiamGiave());
		request.setAttribute("giave", giave);
		rd= request.getRequestDispatcher("admin/capnhatgiave.jsp");
		
		try {
			TuyenDuong tuyen=capnhatGiave.timGiaVe(maTuyen);
			tenTuyen=tuyen.getNoiDi()+'-'+tuyen.getNoiDen();
			request.setAttribute("tentuyen", tenTuyen);
			 rd = request.getRequestDispatcher("admin/capnhatgiave.jsp");
			
			rd.forward(request, response);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		}
		else {
			rd = request.getRequestDispatcher("DanhSachGiaVeServlet");
			
			rd.forward(request, response);
		}
	}

}
