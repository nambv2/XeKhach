package fpt.fsdn.svtt1213.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import fpt.fsdn.svtt1213.model.bean.NguoiDung;
import fpt.fsdn.svtt1213.utility.BaseDAO;
import fpt.fsdn.svtt1213.utility.Security;

public class DangKyDAO {
	public boolean kiemTraTenDangNhap(String tenDangNhap){
		Connection conn = BaseDAO.getConnection();
		CallableStatement cstmt = null;
		try {
			cstmt = conn.prepareCall("{call kiemTraTenDangNhap(?)}");
			cstmt.setString(1, tenDangNhap);
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
				e2.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean dangKy(NguoiDung u){
		Connection conn = BaseDAO.getConnection();
		CallableStatement cstmt = null;
		try {
			cstmt = conn.prepareCall("{call dangky(?,?,?,?,?,?,?,?)}");
			cstmt.setString(1, u.getTenDangNhap());
			cstmt.setString(2, Security.md5(u.getMatKhau()));
			cstmt.setString(3, u.getHoTen());
			cstmt.setString(4, u.getSoCMND());
			cstmt.setInt(5, u.getGioiTinh());
			cstmt.setString(6, u.getQueQuan());
			cstmt.setString(7, u.getSoDienThoai());
			cstmt.setInt(8, 1);
			if(cstmt.executeUpdate() == 1) return true;
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
		return false;
	}

}
