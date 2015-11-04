package fpt.fsdn.svtt1213.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import fpt.fsdn.svtt1213.model.bean.Xe;
import fpt.fsdn.svtt1213.utility.BaseDAO;

public class HienThiXeDAO {

	public Xe hienThiXe(String bienSoXe) {
		// TODO Auto-generated method stub
		Connection con = BaseDAO.getConnection();
		Xe xe = new Xe();
		CallableStatement callstmt;
		String sql = "{ call Xe_ChiTiet(?)}";
		
		try {
			
			callstmt = con.prepareCall(sql);
			callstmt.setString(1, bienSoXe);
			ResultSet rs = callstmt.executeQuery();
			
			while(rs.next())
			{
				xe.setBienSoXe(bienSoXe);
				xe.setLoaiXe(rs.getString(2));
				xe.setSoCho(rs.getInt(3));
			}
			
			return xe;
			
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
		
		return null;
	}

	public boolean getBienSo(String bienSoXe) {
		// TODO Auto-generated method stub
		
		Connection con = BaseDAO.getConnection();
		Xe xe = new Xe();
		CallableStatement callstmt;
		String sql = "{ call Xe_ChiTiet(?)}";
		
		try {
			
			callstmt = con.prepareCall(sql);
			callstmt.setString(1, bienSoXe);
			ResultSet rs = callstmt.executeQuery();
			
			while(rs.next())
			{
				return true;
			}
			
						
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
