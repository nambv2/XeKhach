package fpt.fsdn.svtt1213.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fpt.fsdn.svtt1213.model.bo.ThemXeBO;
import fpt.fsdn.svtt1213.utility.Security;

/**
 * Servlet implementation class ThemXeServlet
 */
public class ThemXeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String bienSoXe  = request.getParameter("bienSoXe");
		String loaiXe    = request.getParameter("loaiXe");
		String soChoNgoi = request.getParameter("soChoNgoi");
		String submit    = request.getParameter("them");
		
	
		if(submit == null){
			response.sendRedirect("admin/themxe.jsp");
			
		}else{
		
		ThemXeBO themXeBO = new ThemXeBO();
				
				
		if(themXeBO.checkBienSoXe(bienSoXe)){
				if(! themXeBO.checkTonTai(bienSoXe)){
					if(themXeBO.themXe(bienSoXe, loaiXe, soChoNgoi)){
						request.setAttribute("message", "themok");
						RequestDispatcher rd = request.getRequestDispatcher("DanhSachXeServlet");
						rd.forward(request, response);
					}
					
				}else{
					request.setAttribute("SoChoNgoi", soChoNgoi);
					request.setAttribute("BienSoXe", bienSoXe);
					request.setAttribute("LoaiXe", loaiXe);
					request.setAttribute("message", "TonTai");
					
					RequestDispatcher rd = 
						request.getRequestDispatcher("admin/themxe.jsp");
					rd.forward(request, response);
				}
			}
			
			else{				
				request.setAttribute("SoChoNgoi", soChoNgoi);
				request.setAttribute("BienSoXe", Security.stringToHTMLString(bienSoXe));
				request.setAttribute("LoaiXe", loaiXe);
				request.setAttribute("message", "Error");
				
				RequestDispatcher rd = 
					request.getRequestDispatcher("admin/themxe.jsp");
				rd.forward(request, response);
				
			}
	}}}


