package fpt.fsdn.svtt1213.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fpt.fsdn.svtt1213.model.bean.TuyenDuong;
import fpt.fsdn.svtt1213.utility.BaseDAO;

public class ThemTuyenDuongDAO {
	public ArrayList<TuyenDuong> danhSachTuyen(){
		ArrayList<TuyenDuong> arr = new ArrayList<TuyenDuong>();
		Connection conn= BaseDAO.getConnection();
		CallableStatement cstmt=null;
		try {
			cstmt = conn.prepareCall("{call danhsachtuyen()}");
			ResultSet rs = cstmt.executeQuery();
			TuyenDuong td;
			while(rs.next()){
				td=new TuyenDuong();
				td.setMaTuyen(rs.getString("maTuyen"));
				arr.add(td);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				cstmt.close();
				conn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
		return arr;
	}
}
