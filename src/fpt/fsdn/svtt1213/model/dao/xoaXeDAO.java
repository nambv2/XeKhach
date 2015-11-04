package fpt.fsdn.svtt1213.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import fpt.fsdn.svtt1213.utility.BaseDAO;

public class xoaXeDAO {

	public static boolean xoaXe(String bienSoXe) {
		// TODO Auto-generated method stub
		Connection con = BaseDAO.getConnection();
		String sql = "{call dbo.Xe_Xoa(?)}";
		
		try {
			CallableStatement callstmt = con.prepareCall(sql);
			callstmt.setString(1, bienSoXe);
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
