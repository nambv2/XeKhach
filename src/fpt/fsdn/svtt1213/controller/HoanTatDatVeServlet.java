package fpt.fsdn.svtt1213.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fpt.fsdn.svtt1213.model.bean.DatVe;


public class HoanTatDatVeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<DatVe> arr = new ArrayList<DatVe>();
		DatVe datVe;
		if("chapnhan".equals(request.getAttribute("chapnhan"))){
			String chuoiViTri = request.getParameter("vitri");
			String maChuyen = request.getParameter("maChuyen");
			
			HttpSession session = request.getSession();
			String tenDangNhap=(String)session.getAttribute("tenDangNhap");
			
			String[] arrViTri = chuoiViTri.split(","); //tach chuoi de lay cac vi tri
			//convert to int
			int[] viTriNgoi = new int[arrViTri.length];
			for (int i = 0; i < arrViTri.length; i++) {
				viTriNgoi[i] = Integer.parseInt(arrViTri[i]);
			}
			
			datVe = new DatVe();
			datVe.setTenDangNhap(tenDangNhap);
			datVe.setMaChuyen(maChuyen);
			datVe.setViTriNgoi(viTriNgoi);
			arr.add(datVe);
			
		}else if("hoantat".equals(request.getAttribute("hoantat"))){
			//them vao csdl
			System.out.println("them");
		}
		
		
	}

}
