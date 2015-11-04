package fpt.fsdn.svtt1213.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fpt.fsdn.svtt1213.model.bean.DatVe;
import fpt.fsdn.svtt1213.model.bo.DatVeBO;


public class DatVeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<DatVe> arr = new ArrayList<DatVe>(); 
	String ngayDi = null;
	String ngayVe = null;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DatVe datVe;
		
		if("hoantat".equals(request.getParameter("trangThai"))){
			HttpSession session = request.getSession();
			String chuoiViTri = request.getParameter("vitri");
			
			String maChuyen = request.getParameter("maChuyen");
			
//			if("d".equals(request.getParameter("loaive"))){
//				ngayDi = request.getParameter("loaive");
//				
//				System.out.println(ngayDi);
//			}
//			
//			if("v".equals(request.getParameter("loaive"))){
//				ngayVe = request.getParameter("loaive");
//				
//				System.out.println(ngayVe);
//			}
			
			String tenDangNhap=(String)session.getAttribute("tenDangNhap");
			
			String[] arrViTri = chuoiViTri.split(","); //tach chuoi de lay cac vi tri
						
			//convert to int
			int[] viTriNgoi = new int[arrViTri.length];

			if(!"".equals(arrViTri[0])){
				for (int i = 0; i < arrViTri.length; i++) {
					viTriNgoi[i] = Integer.parseInt(arrViTri[i]);
					datVe = new DatVe();
					datVe.setTenDangNhap(tenDangNhap);
					datVe.setMaChuyen(maChuyen);
					datVe.setViTriNgoiDat(viTriNgoi[i]);
					arr.add(datVe);
				}

			}
			
			
		}else if("tieptuc".equals(request.getParameter("trangThai"))){
			HttpSession session = request.getSession();
			if(session.getAttribute("tenDangNhap") != null){
				DatVeBO datVeBO = new DatVeBO();
				RequestDispatcher rd = null;
				
				
				if(arr.size() != 0){ //kiem tra  co chon cho ngoi chua
					request.setAttribute("thongtindatve", datVeBO.getThongTinDaDat(arr, ngayDi, ngayVe));
					rd = request.getRequestDispatcher("hoantatdatve.jsp");
				}else{
					request.setAttribute("chuachon", "Chua chon vi tri ngoi");
					rd = request.getRequestDispatcher("TimKiemVeXeServlet");
				}
				
				
				rd.forward(request, response); 
			}else{
				//neu nguoi dung chua dang nhap thi hien thong bao
				arr =new ArrayList<DatVe>(); 
				request.setAttribute("error", "dangnhap");
				RequestDispatcher rd = request.getRequestDispatcher("TimKiemVeXeServlet");
				rd.forward(request, response);
			}
			
		}else if("huy".equals(request.getParameter("trangThai"))){
			HttpSession session = request.getSession();
			
			//huy thong tin da dat
			arr =new ArrayList<DatVe>(); 
			session.removeAttribute("datve");
			
			
		}else if("chapnhan".equals(request.getParameter("trangThai"))){
			HttpSession session = request.getSession();
			//chap nhan dat ve
			ArrayList<DatVe> arr1 = (ArrayList<DatVe>) session.getAttribute("datve");//duoc goi len tu trang hoantatdatve
			
			DatVeBO dv = new DatVeBO();
			for (int i = 0; i < arr1.size(); i++) {
				dv.datVe((String)session.getAttribute("tenDangNhap"),arr1.get(i).getMaChuyen(), arr1.get(i).getViTriNgoiDat());
				
			}
			
			//resest tat ca
			arr =new ArrayList<DatVe>(); 
			session.removeAttribute("datve");
			
			
		}
		
	}

}
