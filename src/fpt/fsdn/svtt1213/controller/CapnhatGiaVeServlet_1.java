package fpt.fsdn.svtt1213.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fpt.fsdn.svtt1213.model.bean.GiaVe;
import fpt.fsdn.svtt1213.model.bean.TuyenDuong;
import fpt.fsdn.svtt1213.model.bo.CapNhatGiaVeBO;
import fpt.fsdn.svtt1213.utility.Security;

public class CapnhatGiaVeServlet_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String maTuyen="";
		String bienSoXe="";
		String giaVe="";
		String giamGia="";
		RequestDispatcher rd;
		String tenTuyen="";
		if(request.getParameter("matuyen")!=null &&request.getParameter("inputbiensoxe")!=null&&request.getParameter("GiaVe")!=null
			&&request.getParameter("GiamGia")!=null	){
		 maTuyen = request.getParameter("matuyen").trim();
		//if(request.getParameter("inputbiensoxe")!=null)
		 bienSoXe = request.getParameter("inputbiensoxe").trim();
		//if(request.getParameter("GiaVe")!=null)
		giaVe = request.getParameter("GiaVe").trim();
		//if(request.getParameter("GiamGia")!=null)
		 giamGia = request.getParameter("GiamGia").trim();
		
		CapNhatGiaVeBO capnhatGiave = new CapNhatGiaVeBO();
		TuyenDuong tuyen=new TuyenDuong();
		
		GiaVe giave = new GiaVe();
		ArrayList<String> validate = capnhatGiave.isvalidateFieldprice(giaVe,giamGia);
			try {
				
				tuyen=capnhatGiave.timGiaVe(maTuyen);
				 tenTuyen=tuyen.getNoiDi()+'-'+tuyen.getNoiDen();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			if (validate.size() > 0) {
			for (int i = 0; i < validate.size(); i++) {
				request.setAttribute(validate.get(i).toString(), validate
						.get(i).toString());
			}
			
			request.setAttribute("inputgiave", Security.stringToHTMLString(giaVe));
			request.setAttribute("inputgiamgiave", Security.stringToHTMLString(giamGia));
			request.setAttribute("inputbiensoXe",bienSoXe );
			request.setAttribute("matuyen", maTuyen);
			
			request.setAttribute("inputtenTuyen",tenTuyen);
			
			rd = request.getRequestDispatcher("admin/capnhatgiave.jsp");
			rd.forward(request, response);
		    } 
			else {
			giave.setMaTuyen(maTuyen);
			giave.setBienSoXe(bienSoXe);

			giave.setGiaVe(Float.parseFloat(giaVe));
			giave.setGiamGiave(Float.parseFloat(giamGia));
			try {	
				capnhatGiave.capnhatgiaVe(giave);
				request.setAttribute("tenTuyen", tenTuyen);
				request.setAttribute("giaVe", giave);
				request.setAttribute("capnhat", "ok");
				rd=request.getRequestDispatcher("DanhSachGiaVeServlet");
				rd.forward(request, response);
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}}
		else {
			rd=request.getRequestDispatcher("DanhSachGiaVeServlet");
			rd.forward(request, response);
		}
		}
	}

