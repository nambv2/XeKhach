package fpt.fsdn.svtt1213.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import fpt.fsdn.svtt1213.model.bean.TuyenDuong;
import fpt.fsdn.svtt1213.utility.BaseDAO;

public class CapnhattuyenDAO {
	CallableStatement cstm;
	Connection conn;
	String update="{call capnhattuyenduong(?,?,?)}";
	public void capNhat(TuyenDuong td){
		try {
			conn=BaseDAO.getConnection();
			cstm=conn.prepareCall(update);
			cstm.setString(1, td.getMaTuyen());
			cstm.setString(2, td.getNoiDi());
			cstm.setString(3,td.getNoiDen());
			cstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	public TuyenDuong hienThiTuyen(String maTuyen) {
		// TODO Auto-generated method stub
		conn=BaseDAO.getConnection();
		String sql = "{call Intuyen(?) }";
		TuyenDuong tuyenDuong =new TuyenDuong();
		
		try {
			CallableStatement callStmt = conn.prepareCall(sql);
			callStmt.setString(1, maTuyen);
			ResultSet rs = callStmt.executeQuery();
			while(rs.next()){
				tuyenDuong.setNoiDi(rs.getString("noiDi"));
				tuyenDuong.setNoiDen(rs.getString("noiDen"));				
			}
			return tuyenDuong;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;
	}
	public boolean checkTuyenDuong(TuyenDuong tuyenDuong) {
		// TODO Auto-generated method stub
		conn=BaseDAO.getConnection();
		String sql = "{call checktuyen(?,?,?) }";
		try {
			CallableStatement callStmt = conn.prepareCall(sql);
			callStmt.setString(1, tuyenDuong.getMaTuyen());
			callStmt.setString(2, tuyenDuong.getNoiDi());
			callStmt.setString(3, tuyenDuong.getNoiDen());
			
			ResultSet rs = callStmt.executeQuery();
			if(rs.next()) return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean kiemTraMaTuyen(String maTuyen){
		conn=BaseDAO.getConnection();
		String sql = "{call kiemTraMaTuyen(?)}";
		ResultSet rs;
		try {
			cstm = conn.prepareCall(sql);
			cstm.setString(1, maTuyen);
			rs = cstm.executeQuery();
			while(rs.next()){
				if(rs.getString("maTuyen").trim().equals(maTuyen)){
					return true;
				}
			}
			
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
		return false;
		
	}
}
