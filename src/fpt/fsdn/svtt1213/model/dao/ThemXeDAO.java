package fpt.fsdn.svtt1213.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import fpt.fsdn.svtt1213.utility.BaseDAO;

public class ThemXeDAO {

	public boolean themXe(String bienSoXe, String loaiXe, String soChoNgoi) {
		// TODO Auto-generated method stub
		Connection con = BaseDAO.getConnection();
		String sql = "{call dbo.Xe_Them(?,?,?)}";
		
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

	public boolean checkTonTai(String bienSoXe) {
		// TODO Auto-generated method stub
		Connection con = BaseDAO.getConnection();
		String sql = "{call dbo.Xe_Check(?)}";
		
		try {
			CallableStatement callstmt = con.prepareCall(sql);
			callstmt.setString(1, bienSoXe);
			ResultSet rs = callstmt.executeQuery();
			
			if(rs.next()) return true;
			
			
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
