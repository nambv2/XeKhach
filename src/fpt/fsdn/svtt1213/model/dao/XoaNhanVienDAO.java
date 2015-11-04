package fpt.fsdn.svtt1213.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import fpt.fsdn.svtt1213.utility.BaseDAO;

public class XoaNhanVienDAO {

	public int xoaNhanVien(String maNhanVien) {
		int xoaThanhCong=0;
		Connection con = BaseDAO.getConnection();
		String sqlUpdate = "{CALL xoaNhanvien(?)}";
		try {
			CallableStatement cas = con.prepareCall(sqlUpdate);
			cas.setString(1,maNhanVien);
	
			xoaThanhCong  = cas.executeUpdate();
			
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
		
		return xoaThanhCong;
	}

}
