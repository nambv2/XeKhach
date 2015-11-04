package fpt.fsdn.svtt1213.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fpt.fsdn.svtt1213.model.bo.ThongKeTheoThangBO;

/**
 * Servlet implementation class ThongKeTheoThangServlet
 */
public class ThongKeTheoThangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hienthi = "";
		if(request.getParameter("hienthi") != null){
			hienthi = request.getParameter("hienthi");
		}
		if("hienthi".equals(hienthi)){
			String nam = request.getParameter("nam");
			System.out.println(nam);
			ThongKeTheoThangBO tk = new ThongKeTheoThangBO();
			request.setAttribute("thang", tk.getTiLeTungThang(nam));
			request.setAttribute("nam", nam);
			RequestDispatcher rd = request.getRequestDispatcher("admin/thongketheothang.jsp");
			rd.forward(request, response);
		}else{
			response.sendRedirect("admin/thongketheothang.jsp");
		}
	}

}
