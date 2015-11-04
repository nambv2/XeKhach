package fpt.fsdn.svtt1213.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import fpt.fsdn.svtt1213.model.bean.GiaVe;
import fpt.fsdn.svtt1213.utility.BaseDAO;

public class XoaGiaVeDAO {

	public boolean xoaGiave(GiaVe giave) throws SQLException {
		Connection con=BaseDAO.getConnection();
		String xoaGiaVe="{call xoa_giave(?,?)}";
		try {
			CallableStatement ctmt=con.prepareCall(xoaGiaVe);
			ctmt.setString(1, giave.getMaTuyen());
			ctmt.setString(2, giave.getBienSoXe());
			ctmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			con.close();
		}
		return true;
	}

}
