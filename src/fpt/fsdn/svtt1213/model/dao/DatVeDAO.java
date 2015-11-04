package fpt.fsdn.svtt1213.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fpt.fsdn.svtt1213.model.bean.DatVe;
import fpt.fsdn.svtt1213.utility.BaseDAO;

public class DatVeDAO {
	
	public boolean datVe(String tenDangNhap,String maChuyen,int viTriNgoi,int trangThaiKhuHoi){
		boolean status = true;
		Connection conn=BaseDAO.getConnection();
		CallableStatement cstmt = null;
		try {
	
				cstmt = conn.prepareCall("{call dbo.datVe(?,?,?,?)}");
				cstmt.setString(1, tenDangNhap);
				cstmt.setString(2, maChuyen);
				cstmt.setInt(3, viTriNgoi);
				cstmt.setInt(4, trangThaiKhuHoi);
				if(cstmt.executeUpdate() == 0){
					status = false;
				}

			
		} catch (SQLException e) {
			
			e.printStackTrace();
			status = false;
		}finally{
			try {
				cstmt.close();
				conn.close();
			} catch (SQLException e) {
			
				e.printStackTrace();
				status = false;
			}
			
		}
		return status;
	}
	
	public DatVe getThongTinNguoiDung(String tenDangNhap){
		DatVe datVe = null;
		Connection conn=BaseDAO.getConnection();
		CallableStatement cstmt = null;
		try {
			cstmt = conn.prepareCall("{call getThongTinNguoiDung(?)}");
			cstmt.setString(1, tenDangNhap);
			ResultSet rs = cstmt.executeQuery();
			if(rs.next()){
				datVe = new DatVe();
				datVe.setTenDangNhap(tenDangNhap);
				datVe.setHoTen(rs.getString("hoTen"));
				datVe.setGioiTinh(rs.getInt("gioiTinh"));
				datVe.setQueQuan(rs.getString("queQuan"));
				datVe.setSoCMND(rs.getString("CMND"));
				datVe.setSoDienThoai(rs.getString("soDienThoai"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				cstmt.close();
				conn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
		
		return datVe;
	}
	
	public ArrayList<DatVe> getThongTinDaDat(ArrayList<DatVe> arr,int trangThaiKhuHoi){
		ArrayList<DatVe> arrList  = new ArrayList<DatVe>();
		DatVe datVe;
		for (int i = 0; i < arr.size(); i++) {
			datVe = new DatVe();
				datVe.setMaChuyen(arr.get(i).getMaChuyen());
				datVe.setHoTen(getThongTinNguoiDung(arr.get(i).getTenDangNhap()).getHoTen());
				datVe.setQueQuan(getThongTinNguoiDung(arr.get(i).getTenDangNhap()).getQueQuan());
				datVe.setSoDienThoai(getThongTinNguoiDung(arr.get(i).getTenDangNhap()).getSoDienThoai());
				datVe.setSoCMND(getThongTinNguoiDung(arr.get(i).getTenDangNhap()).getSoCMND());
				datVe.setGioiTinh(getThongTinNguoiDung(arr.get(i).getTenDangNhap()).getGioiTinh());
				
				datVe.setLoaiXe(getThongTinChuyen(arr.get(i).getMaChuyen(),trangThaiKhuHoi).getLoaiXe());
				datVe.setSoChoNgoi(getThongTinChuyen(arr.get(i).getMaChuyen(),trangThaiKhuHoi).getSoChoNgoi());
				datVe.setGiaVe(getThongTinChuyen(arr.get(i).getMaChuyen(),trangThaiKhuHoi).getGiaVe());
				datVe.setTuyenDuong(getThongTinChuyen(arr.get(i).getMaChuyen(),trangThaiKhuHoi).getTuyenDuong());
				datVe.setThoiGianDi(getThongTinChuyen(arr.get(i).getMaChuyen(),trangThaiKhuHoi).getThoiGianDi());
				datVe.setViTriNgoiDat(arr.get(i).getViTriNgoiDat());
				
				arrList.add(datVe);
		}
		return arrList;
	}
	
	public DatVe getThongTinChuyen(String maChuyen,int trangThaiKhuHoi){
		
		Connection conn=BaseDAO.getConnection();
		CallableStatement cstmt = null;
		DatVe dv = null;
		try {
			cstmt = conn.prepareCall("{call layThongTinChuyen(?,?)}");
			cstmt.setString(1, maChuyen);
			cstmt.setInt(2, trangThaiKhuHoi);
			
			ResultSet rs = cstmt.executeQuery();
			if(rs.next()){
				dv = new DatVe();
				dv.setMaChuyen(maChuyen);
				dv.setTuyenDuong(rs.getString("tuyenDuong"));
				dv.setThoiGianDi(rs.getDate("thoiGianDi"));
				dv.setLoaiXe(rs.getString("loaiXe"));
				dv.setSoChoNgoi(rs.getInt("soCho"));
				dv.setGiaVe(rs.getFloat("giaVe"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				cstmt.close();
				conn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return dv;
	}
	
	
	public int[] layViTriNgoiCuaChuyen(String maChuyen){
		Connection conn=BaseDAO.getConnection();
		CallableStatement cstmt = null;
		int[] viTri = new int[50];
		try {
			cstmt = conn.prepareCall("{call layViTriNgoiCuaChuyen(?)}");
			cstmt.setString(1, maChuyen);
			
			ResultSet rs = cstmt.executeQuery();
			
			int i=0;
			while(rs.next()){
				viTri[i] = rs.getInt("viTriNgoi");
				i++;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				cstmt.close();
				conn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return viTri;
	}
}
