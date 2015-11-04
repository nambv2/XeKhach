package fpt.fsdn.svtt1213.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fpt.fsdn.svtt1213.model.bo.ThongKeTheoTuyenBO;


public class ThongKeTheoTuyenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	    response.setCharacterEncoding("UTF-8");
	    
	    String hienthi = request.getParameter("hienthi");
		String maTuyen = request.getParameter("maTuyen");
		
		ThongKeTheoTuyenBO tk = new ThongKeTheoTuyenBO();
		
		if("hienthi".equals(hienthi)){

			String thoiGianTu = request.getParameter("thoiGianTu");
			String thoiGianDen = request.getParameter("thoiGianDen");
			
			Date time = null;
			Date time1 = null;
			
			RequestDispatcher rd = null;
			
			if(!("".equals(thoiGianTu)) && !("".equals(thoiGianDen))){
				
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
				try {
					Date date1 = dateFormat.parse(thoiGianTu);
					Date date2 = dateFormat.parse(thoiGianDen);
					if(date1.compareTo(date2) >= 0){
						request.setAttribute("invalid", "invalid");
						request.setAttribute("tuyen", tk.getAllTuyen());
						request.setAttribute("maTuyen", maTuyen);
						request.setAttribute("thoiGianTu", request.getParameter("thoiGianTu"));
						request.setAttribute("thoiGianDen", request.getParameter("thoiGianDen"));
						rd = request.getRequestDispatcher("admin/thongketheotuyen.jsp");
					}else{
						request.setAttribute("tile", tk.tiLe(maTuyen, thoiGianTu, thoiGianDen));
						request.setAttribute("tuyen", tk.getAllTuyen());
						request.setAttribute("maTuyen", maTuyen);
						request.setAttribute("thoiGianTu", request.getParameter("thoiGianTu"));
						request.setAttribute("thoiGianDen", request.getParameter("thoiGianDen"));
						request.setAttribute("maTuyen", maTuyen);
						rd = request.getRequestDispatcher("admin/thongketheotuyen.jsp");
					}
					
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else{
				request.setAttribute("empty", "empty");
				request.setAttribute("tuyen", tk.getAllTuyen());
				request.setAttribute("maTuyen", maTuyen);
				request.setAttribute("thoiGianTu", time);
				request.setAttribute("thoiGianDen", time1);
				rd = request.getRequestDispatcher("admin/thongketheotuyen.jsp");
			}
			rd.forward(request, response);
		}else{
			//lay danh sach tuyen
			request.setAttribute("tuyen", tk.getAllTuyen());
			RequestDispatcher rd = request.getRequestDispatcher("admin/thongketheotuyen.jsp");
			rd.forward(request, response);
		}
		
	}

}
