package fpt.fsdn.svtt1213.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fpt.fsdn.svtt1213.model.bean.BaoCao;
import fpt.fsdn.svtt1213.utility.BaseDAO;

public class BaoCaoDAO {
	/**
	 Hiển thị tie lệ đặt vé của từng tuyến trong năm được nhập
	 */
	public ArrayList<BaoCao> hienthi(String nam){
		ArrayList<BaoCao> arr = new ArrayList<BaoCao>();
		BaoCao bc;
		Connection conn = BaseDAO.getConnection();
		CallableStatement cstmt = null;
			try {
				cstmt = conn.prepareCall("{call baoCaoSoLuongMoiTuyen(?)}");
				cstmt.setString(1,nam);
				
				ResultSet rs = cstmt.executeQuery();
				while(rs.next()){
					bc = new BaoCao();
					bc.setMaTuyen(rs.getString("maTuyen"));
					bc.setTenTuyen(getTenTuyen(rs.getString("maTuyen")));
					bc.setTile(rs.getFloat("tiLe"));
					//bc.setNam(a[i]);
					arr.add(bc);
				}
			} catch (SQLException e) {
				// TODO: handle exception
			}
			
			return arr;
	}
	
	public String getTenTuyen(String maTuyen){
		Connection conn = BaseDAO.getConnection();
		CallableStatement cstmt = null;
			try {
				cstmt = conn.prepareCall("{call layTenTuyenTuMaTuyen(?)}");
				cstmt.setString(1,maTuyen);
				ResultSet rs = cstmt.executeQuery();
				if(rs.next()){
					return rs.getString("tenTuyen");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				try {
					cstmt.close();
					conn.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
			return "";
	}
	
	public String getNamDauTuyen(){
		Connection conn = BaseDAO.getConnection();
		CallableStatement cstmt = null;
			try {
				cstmt = conn.prepareCall("{call getNamCuaTuyenThanhLapDauTien()}");
				ResultSet rs = cstmt.executeQuery();
				if(rs.next()){
					return rs.getString("namDau");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				try {
					cstmt.close();
					conn.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
			return null;
	}
	
}
