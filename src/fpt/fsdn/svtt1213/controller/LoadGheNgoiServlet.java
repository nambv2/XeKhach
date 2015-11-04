package fpt.fsdn.svtt1213.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fpt.fsdn.svtt1213.model.bean.DatVe;
import fpt.fsdn.svtt1213.model.dao.DatVeDAO;
import fpt.fsdn.svtt1213.model.dao.ThemChuyenDAO;

/**
 * Servlet implementation class LoadGheNgoiServlet
 */
public class LoadGheNgoiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//lay ghe da chon
		DatVeServlet dv = new DatVeServlet();
		ArrayList<DatVe> arrList = dv.arr;
		if(arrList.isEmpty() == false){
			System.out.println(arrList.get(0).getViTriNgoi()[0]);
		}
		
		String maChuyen = request.getParameter("maChuyen");
		String loaive = request.getParameter("x");
//		if(!("d".equals(loaive) || "v".equals(loaive))){
//			response.sendRedirect("TimKiemVeXeServlet");
//		}else{
//			loaive = request.getParameter("x");
//		}
		
		ThemChuyenDAO themChuyenDAO = new ThemChuyenDAO();
		if(themChuyenDAO.checkMaChuyen(maChuyen)){
			int[] viTri = new DatVeDAO().layViTriNgoiCuaChuyen(maChuyen);
			DatVe thongTinChuyen = new DatVeDAO().getThongTinChuyen(maChuyen, 0);
			
			request.setAttribute("viTri", viTri);
			request.setAttribute("thongTinChuyen", thongTinChuyen);
			
			RequestDispatcher rd = request.getRequestDispatcher("loadxe.jsp");
			rd.forward(request, response);
		}else{
			response.sendRedirect("TimKiemVeXeServlet");
		}
		
	}

}
