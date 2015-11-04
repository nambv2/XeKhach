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
import fpt.fsdn.svtt1213.model.bo.CapNhatChuyenBO;
import fpt.fsdn.svtt1213.model.bo.ChiTietChuyenBO;
import fpt.fsdn.svtt1213.model.bo.DanhSachChuyenXeBO;
import fpt.fsdn.svtt1213.model.bo.ThemChuyenBO;
import fpt.fsdn.svtt1213.utility.Security;

/**
 * Servlet implementation class CapNhatChuyenServlet
 */
public class CapNhatChuyenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CapNhatChuyenServlet() {
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
		
		ChuyenXe chuyenXe = new ChuyenXe();	
		String maChuyen="";
		if(request.getParameter("maChuyen") != null)
			maChuyen = request.getParameter("maChuyen");
		
		ChiTietChuyenBO chiTietChuyenBO=new ChiTietChuyenBO();
		
		if(! chiTietChuyenBO.kiemTra(maChuyen)){
			response.sendRedirect("DanhSachChuyenServlet");
			
		}else{	
		request.setAttribute("maChuyen",maChuyen);
		String capnhat = request.getParameter("capnhat");	
			
		DanhSachChuyenXeBO danhSachChuyenXeBO = new DanhSachChuyenXeBO();
		ArrayList<TuyenDuong> listTuyen = new ArrayList<TuyenDuong>();	
		listTuyen = danhSachChuyenXeBO.listTuyenDuong();
		
		chuyenXe=chiTietChuyenBO.hienThiChuyenXe(maChuyen);		
		
			
		ArrayList<String> listTaiXe = new ArrayList<String>();
		ArrayList<String> listPhuXe = new ArrayList<String>();
		ArrayList<String> listXe = new ArrayList<String>();
		ThemChuyenBO themChuyenBO = new ThemChuyenBO();
		CapNhatChuyenBO capNhatChuyenBO = new CapNhatChuyenBO();
		
		listTaiXe = themChuyenBO.hienThiMaNV(1);
		listPhuXe = themChuyenBO.hienThiMaNV(2);
		listXe 	  =	themChuyenBO.hienThiXe(); 
		
		request.setAttribute("ListXe", listXe);
		request.setAttribute("ListTaiXe", listTaiXe);
		request.setAttribute("ListPhuXe", listPhuXe);
		request.setAttribute("TuyenDuong",listTuyen);
		
		if(capnhat == null){
			
			if(request.getParameter("maChuyen") == null){
				RequestDispatcher rd = request.getRequestDispatcher("DanhSachChuyenServlet");
				rd.forward(request, response);
			}else{
			
			SimpleDateFormat datetime = new SimpleDateFormat("dd-MM-yyyy HH:mm");
			SimpleDateFormat hour = new SimpleDateFormat("HH");
			SimpleDateFormat min = new SimpleDateFormat("mm");
			SimpleDateFormat day= new SimpleDateFormat("dd-MM-yyyy");
			
			Date date;
			String gioDi1 = null, gioDen1 = null, phutDi1 = null,
					phutDen1 = null, ngayDi1 = null, ngayDen1 = null;
			
			try {
				
				date=datetime.parse(chuyenXe.getThoiGianDi());
				gioDi1 = hour.format(date);
				
				phutDi1 = min.format(date);
				ngayDi1 = day.format(date);
				
				date=datetime.parse(chuyenXe.getThoiGianDen());
				gioDen1 = hour.format(date);		
				
				phutDen1 = min.format(date);
				ngayDen1 = day.format(date);
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			
			request.setAttribute("maChuyen",chuyenXe.getMaChuyen());
			request.setAttribute("maTuyen", chuyenXe.getMaTuyen());
			request.setAttribute("gioDi", gioDi1);
			request.setAttribute("gioDen", gioDen1);
			request.setAttribute("phutDi", phutDi1);
			request.setAttribute("phutDen", phutDen1);
			request.setAttribute("ngayDi", ngayDi1);
			request.setAttribute("ngayDen", ngayDen1);
			request.setAttribute("bienSoXe", chuyenXe.getBienSoXe());
			request.setAttribute("taiXe1", chuyenXe.getMaTaixe1());
			request.setAttribute("taiXe2", chuyenXe.getMaTaixe2());
			request.setAttribute("phuXe", chuyenXe.getMaPhuXe());	
			request.setAttribute("tiLeOnline", chuyenXe.getTiLeDatVeOnline());	
			RequestDispatcher rd = request.getRequestDispatcher("admin/capnhatchuyen.jsp");
			rd.forward(request, response);
		}}
		
		
		else{
			
			String maTuyen = request.getParameter("maTuyen");
			String gioDi = request.getParameter("gioDi");
			String phutDi = request.getParameter("phutDi");
			String ngayDi = request.getParameter("ngayDi");
			String gioDen = request.getParameter("gioDen");
			String phutDen = request.getParameter("phutDen");
			String ngayDen = request.getParameter("ngayDen");
			String bienSoXe = request.getParameter("bienSoXe");
			String taiXe1 = request.getParameter("taiXe1");
			String taiXe2 = request.getParameter("taiXe2");
			String phuXe = request.getParameter("phuXe");
			String tiLeOnline = request.getParameter("tiLeOnline");
			
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
			
			
			chuyenXe.setMaChuyen(maChuyen.trim());
			chuyenXe.setMaTuyen(maTuyen);
			chuyenXe.setBienSoXe(bienSoXe);
			chuyenXe.setThoiGianDen(thoiGianDen);
			chuyenXe.setThoiGianDi(thoiGianDi);
			chuyenXe.setTiLeDatVeOnline(tiLeOnline.trim());
			chuyenXe.setMaPhuXe(phuXe);
			chuyenXe.setMaTaixe1(taiXe1);
			chuyenXe.setMaTaixe2(taiXe2);	
						
			ArrayList<String> error= new ArrayList<String>();
			error = capNhatChuyenBO.checkValid(chuyenXe);
			
			if(error.size() != 0){	
				
				request.setAttribute("error", 	error);
				request.setAttribute("maTuyen", maTuyen);
				request.setAttribute("gioDi", 	gioDi);
				request.setAttribute("gioDen",	gioDen);
				request.setAttribute("phutDi",  phutDi);
				request.setAttribute("phutDen", phutDen);
				request.setAttribute("bienSoXe",bienSoXe);
				request.setAttribute("taiXe1",  taiXe1);
				request.setAttribute("taiXe2",  taiXe2);
				request.setAttribute("phuXe",   phuXe);
				request.setAttribute("ngayDi",  ngayDi);
				request.setAttribute("ngayDen", ngayDen);
				request.setAttribute("tiLeOnline",Security.stringToHTMLString(tiLeOnline));
				request.setAttribute("Error", error);
				
				RequestDispatcher rd1 = request.getRequestDispatcher("admin/capnhatchuyen.jsp");
				rd1.forward(request, response);
				
							
			}
			
			else{
				capNhatChuyenBO.capNhatChuyen(chuyenXe);
				request.setAttribute("message", "OK");
				request.setAttribute("maChuyen", chuyenXe.getMaChuyen());
								
				RequestDispatcher rd1=request.getRequestDispatcher("ChiTietChuyenServlet");
				rd1.forward(request, response);	
				
			}
		}
		
		
	}}}



