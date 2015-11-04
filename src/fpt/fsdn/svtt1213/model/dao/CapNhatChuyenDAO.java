package fpt.fsdn.svtt1213.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import fpt.fsdn.svtt1213.model.bean.ChuyenXe;
import fpt.fsdn.svtt1213.utility.BaseDAO;

public class CapNhatChuyenDAO {

	public boolean capNhatChuyen(ChuyenXe chuyenXe) {
		// TODO Auto-generated method stub
		Connection con = BaseDAO.getConnection();
		CallableStatement callstmt;
		String sql = "{call dbo.Chuyenxe_Capnhat(?,?,?,?,?,?,?,?,?)}";
		SimpleDateFormat datetime=new SimpleDateFormat("HH:mm MM/dd/yyyy");
		Date date;
		String date1,date2;
		
		try {
			
			callstmt = con.prepareCall(sql);
			callstmt.setString(1, chuyenXe.getMaChuyen());
			callstmt.setString(2, chuyenXe.getMaTuyen());
			
			date  = datetime.parse(chuyenXe.getThoiGianDi());
			date1 = datetime.format(date);
			
			date  = datetime.parse(chuyenXe.getThoiGianDen());
			date2 = datetime.format(date);
			
			callstmt.setString(3, date1);
			callstmt.setString(4, date2);
			callstmt.setString(5, chuyenXe.getBienSoXe());
			callstmt.setString(6, chuyenXe.getMaTaixe1());
			callstmt.setString(7, chuyenXe.getMaTaixe2());
			callstmt.setString(8, chuyenXe.getMaPhuXe());
			callstmt.setString(9, chuyenXe.getTiLeDatVeOnline());
			
			int rs=callstmt.executeUpdate();
			if(rs==1)	return true;
			else return false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return false;
	}

	public boolean checkTaiXe(String maTaiXe, String thoiGianDi, String thoiGianDen, String maChuyen) {
		// TODO Auto-generated method stub
		
		Connection con = BaseDAO.getConnection();
		CallableStatement callstmt;
		String sql = "{ call dbo.Chuyenxe_Kiemtrataixe(?,?,?,?)}";
		
		try {
			callstmt = con.prepareCall(sql);
			callstmt.setString(1, maTaiXe);
			callstmt.setString(2, thoiGianDi);
			callstmt.setString(3, thoiGianDen);
			callstmt.setString(4, maChuyen);
			
			
			ResultSet rs = callstmt.executeQuery();
			
			if(rs.next()) return true;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return false;
	}

	public boolean checkXe(String bienSoXe, String thoiGianDi, String thoiGianDen, String maChuyen) {

		Connection con = BaseDAO.getConnection();
		CallableStatement callstmt;
		String sql = "{ call dbo.Chuyenxe_Kiemtraxe(?,?,?,?)}";
		
		try {
			callstmt = con.prepareCall(sql);
			callstmt.setString(1, bienSoXe);
			callstmt.setString(2, thoiGianDi);
			callstmt.setString(3, thoiGianDen);
			callstmt.setString(4, maChuyen);
			
			ResultSet rs = callstmt.executeQuery();
			
			if(rs.next()) return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return false;
	}

}
