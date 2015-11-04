package fpt.fsdn.svtt1213.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import fpt.fsdn.svtt1213.utility.BaseDAO;

public class CapNhatXeDAO {

	public boolean capNhatXe(String bienSoXe, String loaiXe, String soChoNgoi) {
		// TODO Auto-generated method stub
		
		Connection con = BaseDAO.getConnection();
		String sql = "{call dbo.Xe_CapNhat(?,?,?) }";
		
		try {
			CallableStatement callstmt = con.prepareCall(sql);
			callstmt.setString(1, bienSoXe);
			callstmt.setString(2, loaiXe);
			callstmt.setString(3, soChoNgoi);
			
			int i = callstmt.executeUpdate();
			if(i > 0) return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return false;
	}

}
