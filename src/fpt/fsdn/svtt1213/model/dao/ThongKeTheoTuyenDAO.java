package fpt.fsdn.svtt1213.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import fpt.fsdn.svtt1213.model.bean.TuyenDuong;
import fpt.fsdn.svtt1213.utility.BaseDAO;

public class ThongKeTheoTuyenDAO {
	public ArrayList<TuyenDuong> getAllTuyen(){
		ArrayList<TuyenDuong> arr = new ArrayList<TuyenDuong>();
		TuyenDuong td;
		Connection conn = BaseDAO.getConnection();
		CallableStatement cstmt = null;
		try {
			cstmt = conn.prepareCall("{call danhsachtuyen()}");
			ResultSet rs = cstmt.executeQuery();
			while(rs.next()){
				td = new TuyenDuong();
				td.setMaTuyen(rs.getString("maTuyen"));
				td.setNoiDi(rs.getString("noiDi"));
				td.setNoiDen(rs.getString("noiDen"));
				arr.add(td);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				cstmt.close();
				conn.close();
			} catch (SQLException e2) {
				// TODO: handle exception
			}
		}
		return arr;
		
	}
	
	public float tiLe(String maTuyen,String thoiGianTu,String thoiGianDen){
		float t=0;
		Connection conn = BaseDAO.getConnection();
		CallableStatement cstmt = null;
		try {
			cstmt = conn.prepareCall("{call thongKeTheoTuyen(?,?,?)}");
			cstmt.setString(1, maTuyen);
			cstmt.setString(2, thoiGianTu);
			cstmt.setString(3, thoiGianDen);
			ResultSet rs = cstmt.executeQuery();
			if(rs.next()){
				t = rs.getFloat("tiLe");
				System.out.println(t);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				cstmt.close();
				conn.close();
			} catch (SQLException e2) {
				
			}
		}
		return t;
	}
}
