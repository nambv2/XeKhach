package fpt.fsdn.svtt1213.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import fpt.fsdn.svtt1213.model.bean.NguoiDung;
import fpt.fsdn.svtt1213.utility.BaseDAO;
import fpt.fsdn.svtt1213.utility.Security;

public class DangNhapDAO {
	public boolean kiemTraDangNhap(String tenDangNhap,String matKhau){
		Connection conn = BaseDAO.getConnection();
		CallableStatement cstmt = null;
		try {
			cstmt = conn.prepareCall("{call dangNhap(?,?)}");
			cstmt.setString(1, tenDangNhap);
			cstmt.setString(2, Security.md5(matKhau));
			
			ResultSet rs = cstmt.executeQuery();
			rs.next();
			if(rs.getInt("dem") == 1) return true;
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
		return false;
	}
	
	public NguoiDung getNguoiDung(String tenDangNhap){
		NguoiDung u = new NguoiDung();
		Connection conn = BaseDAO.getConnection();
		CallableStatement cstmt = null;
		try {
			cstmt = conn.prepareCall("{call xemThongTin(?)}");
			cstmt.setString(1, tenDangNhap);
			
			ResultSet rs = cstmt.executeQuery();
			rs.next();
			u.setTenDangNhap(rs.getString("tenDangNhap"));
			u.setPhanQuyen(rs.getInt("phanQuyen"));
			return u;
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
		return u;
	}
}
