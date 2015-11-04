package fpt.fsdn.svtt1213.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import fpt.fsdn.svtt1213.utility.BaseDAO;

public class XoaChuyenDAO {

	public boolean xoaChuyen(String maChuyen) {
		// TODO Auto-generated method stub
		Connection con = BaseDAO.getConnection();
		CallableStatement callstmt;
		String sql = "{ call dbo.Chuyenxe_Xoa(?)}";
		
		try {
			callstmt = con.prepareCall(sql);
			callstmt.setString(1, maChuyen);
			int i = callstmt.executeUpdate();
			
			if(i == 0)
				return true;
			
			
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
