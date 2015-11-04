package fpt.fsdn.svtt1213.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fpt.fsdn.svtt1213.model.bean.DropdownlistTuyenDuong;
import fpt.fsdn.svtt1213.model.bean.KetQuaTimKiemVeXe;
import fpt.fsdn.svtt1213.model.bean.TimKiemVeXe;
import fpt.fsdn.svtt1213.model.bo.TimKiemVeXeBO;

/**
 * Servlet implementation class TimKiemVeXeServlet
 */
public class TimKiemVeXeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		
		TimKiemVeXeBO timKiemVeXeBO = new TimKiemVeXeBO();
		ArrayList<DropdownlistTuyenDuong>  tuyenDuong = new ArrayList<DropdownlistTuyenDuong>();
		tuyenDuong = timKiemVeXeBO.getAllTuyenDuong();
		if(tuyenDuong.size()!=0){
			request.setAttribute("tuyenDuong", tuyenDuong);
		}
		
		if(request.getParameter("tenTuyen")!=null){
			String tenTuyen = (String)request.getParameter("tenTuyen");
			String loaiVe = (String) request.getParameter("loaiVe");
			String loaiXe = (String)request.getParameter("loaiXe");
			String soCho = (String)request.getParameter("soCho");
			String giaVe = (String)request.getParameter("giaVe");
			String ngayDi = (String)request.getParameter("ngayDi");
			
			TimKiemVeXe timkiemVeXe = new TimKiemVeXe();
			
			StringTokenizer st = new StringTokenizer(tenTuyen);
			if(st.hasMoreTokens()){
				timkiemVeXe.setNoiDi((st.nextToken("-")).trim());
				timkiemVeXe.setNoiDen((st.nextToken("-")).trim());
			}
			
			timkiemVeXe.setLoaiVe(loaiVe);
			if(request.getParameter("loaiXe")!=null){
				if("giuongNam".equals(loaiXe))timkiemVeXe.setLoaiXe("Giường Nằm");
				else timkiemVeXe.setLoaiXe("Ghế Ngồi");
			}
			timkiemVeXe.setSoCho(Integer.parseInt(soCho));
			timkiemVeXe.setGiaVe(giaVe);
			timkiemVeXe.setNgayDi(ngayDi);
			
			ArrayList<KetQuaTimKiemVeXe> ketquaTimKiemNgayVe = new ArrayList<KetQuaTimKiemVeXe>();
			ArrayList<KetQuaTimKiemVeXe> ketquaTimKiemNgayDi = new ArrayList<KetQuaTimKiemVeXe>();
			
			
			ketquaTimKiemNgayDi = timKiemVeXeBO.timKiem(timkiemVeXe,timkiemVeXe.getNoiDi(),timkiemVeXe.getNoiDen(),timkiemVeXe.getNgayDi());
			
			request.setAttribute("tenTuyen", tenTuyen);
			request.setAttribute("loaiVe", loaiVe);
			request.setAttribute("loaiXe", loaiXe);
			request.setAttribute("soCho", soCho);
			request.setAttribute("giaVe", giaVe);
			request.setAttribute("ngayDi", ngayDi);
			
			
			if("khuhoi".equals(loaiVe)) {
				request.setAttribute("khuhoi", "khuhoi");
				String ngayVe = (String)request.getParameter("ngayVe");
				request.setAttribute("ngayVe", ngayVe);
				timkiemVeXe.setNgayVe(ngayVe);
				
				if((!("".equals(request.getParameter("ngayVe"))))&&(timKiemVeXeBO.isValidateNgayVe(ngayDi,ngayVe)>0)){
					request.setAttribute("ngayVeError", "ngayVeError");
				}else{
					ketquaTimKiemNgayVe = timKiemVeXeBO.timKiem(timkiemVeXe,timkiemVeXe.getNoiDen(),timkiemVeXe.getNoiDi(),timkiemVeXe.getNgayVe());
					request.setAttribute("ketquaTimKiemNgayDi", ketquaTimKiemNgayDi);
					request.setAttribute("ketquaTimKiemNgayVe", ketquaTimKiemNgayVe);
				}
				
			}else{
				if(ketquaTimKiemNgayDi.size()!=0) request.setAttribute("ketquaTimKiemNgayDi", ketquaTimKiemNgayDi);
			}
			
		}else{
			request.setAttribute("loaiVe", "motchieu");
			String currentDate = timKiemVeXeBO.getCurrentDate();
			request.setAttribute("ngayDi", currentDate);
		}
		RequestDispatcher rd = request.getRequestDispatcher("timkiem.jsp");
		rd.forward(request, response);
	}

}
