package fpt.fsdn.svtt1213.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import fpt.fsdn.svtt1213.model.bean.NguoiDung;
import fpt.fsdn.svtt1213.utility.BaseDAO;

public class SuaThongTinTaiKhoanDAO {
	public boolean capNhapTaiKhoan(NguoiDung u){
		Connection conn = BaseDAO.getConnection();
		CallableStatement cstmt = null;
		try {
			cstmt=conn.prepareCall("{call suathongtintaikhoan(?,?,?,?,?,?)}");
			cstmt.setString(1, u.getTenDangNhap());
			cstmt.setString(2, u.getHoTen());
			cstmt.setString(3, u.getSoCMND());
			cstmt.setInt(4, u.getGioiTinh());
			cstmt.setString(5, u.getQueQuan());
			cstmt.setString(6, u.getSoDienThoai());
			
			if(cstmt.executeUpdate() == 1){
				return true;
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
		return false;
	}
	
}
