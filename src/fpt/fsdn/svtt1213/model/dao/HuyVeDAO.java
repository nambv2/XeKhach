package fpt.fsdn.svtt1213.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.omg.CORBA.CTX_RESTRICT_SCOPE;

import fpt.fsdn.svtt1213.model.bean.QuanLyVe;
import fpt.fsdn.svtt1213.utility.BaseDAO;

public class HuyVeDAO {
	CallableStatement cstm;
	Connection conn;
	ResultSet rs;
	ArrayList<QuanLyVe> maVeKT = new ArrayList<QuanLyVe>();
	QuanLyVe quanLyVe;

	public boolean kTraTrangThai(int maVe) {
		try {
			conn = BaseDAO.getConnection();
			cstm = conn.prepareCall("{call kiemTraTrangThai()}");
			rs = cstm.executeQuery();
			while (rs.next()) {
				if (rs.getInt("maVe") == maVe) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				cstm.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return false;
	}

	public void huyVe(int maVe) {
		try {
			conn = BaseDAO.getConnection();
			cstm = conn.prepareCall("{call huyve(?)}");
			cstm.setInt(1, maVe);
			cstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				cstm.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
