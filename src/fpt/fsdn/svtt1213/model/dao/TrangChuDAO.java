package fpt.fsdn.svtt1213.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fpt.fsdn.svtt1213.model.bean.DropdownlistTuyenDuong;
import fpt.fsdn.svtt1213.utility.BaseDAO;

public class TrangChuDAO {
	private ArrayList<DropdownlistTuyenDuong> tuyenDuong = new ArrayList<DropdownlistTuyenDuong>();
	public ArrayList<DropdownlistTuyenDuong> getAllTuyenDuong() {
		Connection con = BaseDAO.getConnection();
		String sqlUpdate = "{CALL Dropdown_tuyen()}";
		try {
			CallableStatement cas = con.prepareCall(sqlUpdate);
			ResultSet rs  = cas.executeQuery();
			while(rs.next()){
				DropdownlistTuyenDuong dropdownlistTuyenDuong = new DropdownlistTuyenDuong();
				dropdownlistTuyenDuong.setMaTuyen(rs.getString(1));
				dropdownlistTuyenDuong.setTenTuyen(rs.getString(2));
				tuyenDuong.add(dropdownlistTuyenDuong);
			}
			
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
		return tuyenDuong;
	}

}
