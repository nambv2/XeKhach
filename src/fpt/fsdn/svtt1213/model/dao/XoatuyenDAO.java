package fpt.fsdn.svtt1213.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import fpt.fsdn.svtt1213.utility.BaseDAO;

public class XoatuyenDAO {
	CallableStatement cstm;
	Connection conn = BaseDAO.getConnection();
	
	public void xoaTuyen(String maTuyen){
		try {
			cstm=conn.prepareCall("{call xoatuyenduong(?)}");
			cstm.setString(1, maTuyen);
			cstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				cstm.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
