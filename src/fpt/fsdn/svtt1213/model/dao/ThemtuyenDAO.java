package fpt.fsdn.svtt1213.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fpt.fsdn.svtt1213.model.bean.TuyenDuong;
import fpt.fsdn.svtt1213.utility.BaseDAO;

public class ThemtuyenDAO {
	CallableStatement cstm;
	Connection conn;
	Statement st;
	ResultSet rs;

	public void themTuyen(TuyenDuong td) {
		conn = BaseDAO.getConnection();
		try {
			cstm = conn.prepareCall("{call themtuyenduong(?,?,?)}");
			cstm.setString(1, td.getMaTuyen());
			cstm.setString(2, td.getNoiDi());
			cstm.setString(3, td.getNoiDen());
			cstm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				cstm.close();
				conn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}

	}

	public boolean kTraMaTuyen(String maTuyen) {
		conn = BaseDAO.getConnection();
		String sql = "{call kiemTraMaTuyen(?)}";
		try {
			cstm = conn.prepareCall(sql);
			cstm.setString(1, maTuyen);
			rs = cstm.executeQuery();
			while (rs.next()) {
				if (rs.getString("maTuyen").trim().equals(maTuyen)) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				cstm.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;

	}

	public boolean kTraNoiDiDen(String noiDi, String noiDen) {
		conn = BaseDAO.getConnection();
		String sql = "{call kTraNoiDiDen(?,?)}";
		try {
			cstm = conn.prepareCall(sql);
			cstm.setString(1, noiDi);
			cstm.setString(2, noiDen);
			rs = cstm.executeQuery();
			while (rs.next()) {
				if ((rs.getString("noiDi").trim().equals(noiDi.trim()))
						&& (rs.getString("noiDen").trim().equals(noiDen.trim()))) {
					return true;
				}
			}
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
		return false;
	}
}
