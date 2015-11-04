package fpt.fsdn.svtt1213.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fpt.fsdn.svtt1213.model.bean.Xe;
import fpt.fsdn.svtt1213.utility.BaseDAO;

public class DanhSachXeDAO {

	public ArrayList<Xe> hienThiDanhSach()
	{
		Connection con = BaseDAO.getConnection();
		String sql = "{call dbo.Xe_Danhsach()}";
		CallableStatement callstmt;
		
		ArrayList<Xe> listXe = new ArrayList<Xe>();
		
		try {
			
			callstmt = con.prepareCall(sql);
			ResultSet rs = callstmt.executeQuery();
			
			while(rs.next())
			{
				Xe xe = new Xe();
				xe.setBienSoXe(rs.getString(1));
				xe.setLoaiXe(rs.getString(2));
				xe.setSoCho(rs.getInt(3));
				listXe.add(xe);
			}
			
			return listXe;
			
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

}
