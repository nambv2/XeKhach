package fpt.fsdn.svtt1213.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fpt.fsdn.svtt1213.model.bean.ChuyenXe;
import fpt.fsdn.svtt1213.model.bean.TuyenDuong;
import fpt.fsdn.svtt1213.model.bo.DanhSachChuyenXeBO;
import fpt.fsdn.svtt1213.model.bo.ThemChuyenBO;
import fpt.fsdn.svtt1213.utility.Security;

/**
 * Servlet implementation class ThemChuyenServlet
 */
public class ThemChuyenServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DanhSachChuyenXeBO danhSachChuyenXeBO = new DanhSachChuyenXeBO();
		ArrayList<TuyenDuong> listTuyen = new ArrayList<TuyenDuong>();	
		listTuyen = danhSachChuyenXeBO.listTuyenDuong();		
		
		
		SimpleDateFormat datein = new SimpleDateFormat("dd-MM-yyyy");
		Date now = new Date();
		String nowString =  datein.format(now);
		
		request.setAttribute("Date", nowString);
			
			
		ArrayList<String> listTaiXe=new ArrayList<String>();
		ArrayList<String> listPhuXe=new ArrayList<String>();
		ArrayList<String> listXe=new ArrayList<String>();
		ThemChuyenBO themChuyenBO = new ThemChuyenBO();
		String them=request.getParameter("them");		
		
		listTaiXe = themChuyenBO.hienThiMaNV(1);
		listPhuXe = themChuyenBO.hienThiMaNV(2);
		listXe 	  =	themChuyenBO.hienThiXe(); 
		
		request.setAttribute("ListXe", listXe);
		request.setAttribute("ListTaiXe", listTaiXe);
		request.setAttribute("ListPhuXe", listPhuXe);
		request.setAttribute("TuyenDuong",listTuyen);
		
		if(them == null)
		{
		RequestDispatcher rd = request.getRequestDispatcher("admin/themchuyen.jsp");
		rd.forward(request, response);
		}
		else
	
		{
			ChuyenXe chuyenXe=new ChuyenXe();
				
			String maChuyen=request.getParameter("maChuyen");
			String maTuyen=request.getParameter("maTuyen");
			String gioDi=request.getParameter("gioDi");
			String phutDi=request.getParameter("phutDi");
			String ngayDi=request.getParameter("ngayDi");
			String gioDen=request.getParameter("gioDen");
			String phutDen=request.getParameter("phutDen");
			String ngayDen=request.getParameter("ngayDen");
			String bienSoXe=request.getParameter("bienSoXe");
			String taiXe1=request.getParameter("taiXe1");
			String taiXe2=request.getParameter("taiXe2");
			String phuXe=request.getParameter("phuXe");
			String tiLeOnline=request.getParameter("tiLeOnline");
			
			SimpleDateFormat inputdate = new SimpleDateFormat("HH:mm dd-MM-yyyy");
			SimpleDateFormat outputdate = new SimpleDateFormat("HH:mm MM/dd/yyyy");
			Date date;
			
			String thoiGianDi1=gioDi+":"+phutDi +" "+ngayDi;
			String thoiGianDen1=gioDen+":"+phutDen +" "+ngayDen;
			String thoiGianDi = null, thoiGianDen = null;
			try {
				date = inputdate.parse(thoiGianDi1);
				thoiGianDi = outputdate.format(date);
				date = inputdate.parse(thoiGianDen1);
				thoiGianDen = outputdate.format(date);
				
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			chuyenXe.setMaChuyen(maChuyen);
			chuyenXe.setMaTuyen(maTuyen);
			chuyenXe.setBienSoXe(bienSoXe);
			chuyenXe.setThoiGianDen(thoiGianDen.trim());
			chuyenXe.setThoiGianDi(thoiGianDi.trim());
			chuyenXe.setTiLeDatVeOnline(tiLeOnline.trim());
			chuyenXe.setMaPhuXe(phuXe);
			chuyenXe.setMaTaixe1(taiXe1);
			chuyenXe.setMaTaixe2(taiXe2);
					
			ArrayList<String> error= new ArrayList<String>();
			error = themChuyenBO.checkValid(chuyenXe);
			
			
			if(error.size() != 0){	
				
				request.setAttribute("maChuyen", Security.stringToHTMLString(maChuyen));
				request.setAttribute("maTuyen", maTuyen);
				request.setAttribute("gioDi", gioDi);
				request.setAttribute("gioDen", gioDen);
				request.setAttribute("phutDi", phutDi);
				request.setAttribute("ngayDi", ngayDi);
				request.setAttribute("phutDen", phutDen);
				request.setAttribute("ngayDen", ngayDen);
				request.setAttribute("bienSoXe", bienSoXe);
				request.setAttribute("taiXe1", taiXe1);
				request.setAttribute("taiXe2", taiXe2);
				request.setAttribute("phuXe", phuXe);
				request.setAttribute("tiLeOnline", Security.stringToHTMLString(tiLeOnline));
				
		        
				request.setAttribute("Error", error);
				RequestDispatcher rd1=request.getRequestDispatcher("admin/themchuyen.jsp");
				rd1.forward(request, response);
		
				
			
			}
			else{
				themChuyenBO.themChuyen(chuyenXe);
				request.setAttribute("message", "OK");
				RequestDispatcher rd1=request.getRequestDispatcher("DanhSachChuyenServlet");
				rd1.forward(request, response);
				
		}
		
		
	}}}


