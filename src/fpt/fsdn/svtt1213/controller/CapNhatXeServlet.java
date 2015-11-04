package fpt.fsdn.svtt1213.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fpt.fsdn.svtt1213.model.bean.Xe;
import fpt.fsdn.svtt1213.model.bo.CapNhatXeBO;
import fpt.fsdn.svtt1213.model.bo.HienThiXeBO;

/**
 * Servlet implementation class CapNhatXeServlet
 */
public class CapNhatXeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String bienSoXe = request.getParameter("bienSoXe");
		String submit   = request.getParameter("capnhat");
				
		HienThiXeBO  hienThiXeBO = new HienThiXeBO();
		CapNhatXeBO capNhatXeBO = new CapNhatXeBO(); 
		
		if(hienThiXeBO.getBienSo(bienSoXe)){
			
			if(submit == null){
				Xe xe = new Xe();
				xe.setBienSoXe(bienSoXe);
				xe = hienThiXeBO.hienThiXe(bienSoXe);
				
				request.setAttribute("Xe", xe);
				RequestDispatcher rd = request.getRequestDispatcher("admin/capnhatxe.jsp");
				rd.forward(request, response);
			}
			
			else{
				String loaiXe = request.getParameter("loaiXe");
				String soChoNgoi = request.getParameter("soChoNgoi");
				
				if(capNhatXeBO.capNhatXe(bienSoXe, loaiXe, soChoNgoi)){
					request.setAttribute("message", "capnhatok");
					RequestDispatcher rd = request.getRequestDispatcher("DanhSachXeServlet");
					rd.forward(request, response);
				}
			}
		
		}
		else{
			RequestDispatcher rd = request.getRequestDispatcher("DanhSachXeServlet");
			rd.forward(request, response);
		}
		
		
		
		
	}

}
