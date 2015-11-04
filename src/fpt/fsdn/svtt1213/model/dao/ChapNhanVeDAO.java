package fpt.fsdn.svtt1213.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import fpt.fsdn.svtt1213.utility.BaseDAO;

public class ChapNhanVeDAO {
Connection con=BaseDAO.getConnection();
	public void chapnhanVe(String maVe) throws SQLException {
		
		String capnhatGiaVe="{call chapnhanve(?)}";
		try {
		
			CallableStatement ctmt_Ve=con.prepareCall(capnhatGiaVe);
			ctmt_Ve.setInt(1,Integer.parseInt(maVe));
			
			ctmt_Ve.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}
	public void huyVe(String maVe) throws SQLException {
	    
		String huyVe="{call huyve(?)}";
		try {
		
			CallableStatement ctml_Ve=con.prepareCall(huyVe);
			ctml_Ve.setInt(1,Integer.parseInt(maVe));
			
			ctml_Ve.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
