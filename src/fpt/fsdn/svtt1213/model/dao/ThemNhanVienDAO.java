package fpt.fsdn.svtt1213.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import fpt.fsdn.svtt1213.model.bean.NhanVien;
import fpt.fsdn.svtt1213.utility.BaseDAO;

public class ThemNhanVienDAO {

	public int saveNhanVienMoi(NhanVien nhanVien) {
		int themThanhCong = 0;
		Connection con = BaseDAO.getConnection();
		String sqlUpdate = "{CALL themNhanvien(?,?,?,?,?,?,?)}";
		try {
			CallableStatement cas = con.prepareCall(sqlUpdate);
			cas.setString(1, nhanVien.getMaNhanVien());
			cas.setString(2, nhanVien.getHoTen());
			cas.setInt(3, Integer.parseInt(nhanVien.getGioiTinh()));
			cas.setString(4, nhanVien.getQueQuan());
			cas.setString(5, nhanVien.getCMND());
			cas.setString(6,nhanVien.getDienThoai());
			cas.setInt(7, Integer.parseInt(nhanVien.getViTri()));
			
			themThanhCong=cas.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return themThanhCong;
		
	}

}
