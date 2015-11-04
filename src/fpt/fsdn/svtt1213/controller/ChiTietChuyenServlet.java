package fpt.fsdn.svtt1213.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fpt.fsdn.svtt1213.model.bean.ChuyenXe;
import fpt.fsdn.svtt1213.model.bo.ChiTietChuyenBO;

/**
 * Servlet implementation class ChiTietChuyenServlet
 */
public class ChiTietChuyenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChiTietChuyenServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String maChuyen = request.getParameter("maChuyen");	
		String message = (String) request.getAttribute("message");
		ChiTietChuyenBO chiTietChuyenBO=new ChiTietChuyenBO();
		
		if(! chiTietChuyenBO.kiemTra(maChuyen)){
			response.sendRedirect("DanhSachChuyenServlet");
			
		}else{
		ChuyenXe chuyenXe=new ChuyenXe();			
		chuyenXe= chiTietChuyenBO.hienThiChuyenXe(maChuyen);
		request.setAttribute("ChuyenXe",chuyenXe);
		
		if(message != null){
			request.setAttribute("message", message);
		}
		RequestDispatcher rd=request.getRequestDispatcher("admin/chitietchuyen.jsp");
		rd.forward(request, response);
		}	
	}

}
