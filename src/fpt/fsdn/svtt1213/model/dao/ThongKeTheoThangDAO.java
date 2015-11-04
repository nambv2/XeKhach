package fpt.fsdn.svtt1213.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import fpt.fsdn.svtt1213.utility.BaseDAO;

public class ThongKeTheoThangDAO {
	public float[] getTiLeTungThang(String nam){
		Connection conn = BaseDAO.getConnection();
		CallableStatement cstmt = null;
		float[] tile = new float[12];
		try {
			cstmt = conn.prepareCall("{call thongKeTheoThang(?)}");
			cstmt.setString(1, nam);
			ResultSet rs = cstmt.executeQuery();
			rs.next();
			
			tile[0] = rs.getFloat("thang1");
			tile[1] = rs.getFloat("thang2");
			tile[2] = rs.getFloat("thang3");
			tile[3] = rs.getFloat("thang4");
			tile[4] = rs.getFloat("thang5");
			tile[5] = rs.getFloat("thang6");
			tile[6] = rs.getFloat("thang7");
			tile[7] = rs.getFloat("thang8");
			tile[8] = rs.getFloat("thang9");
			tile[9] = rs.getFloat("thang10");
			tile[10] = rs.getFloat("thang11");
			tile[11] = rs.getFloat("thang12");
			
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
		return tile;
		
	}
	
}
