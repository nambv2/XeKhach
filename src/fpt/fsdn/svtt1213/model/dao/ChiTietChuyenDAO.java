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

public class ChiTietChuyenDAO {

	public ChuyenXe hienThiChuyenXe(String maChuyen) {
		// TODO Auto-generated method stub
		
		ChuyenXe chuyenXe=new ChuyenXe();
		Connection con=BaseDAO.getConnection();
		String sql="{call dbo.Chuyenxe_Chitiet(?)}";
		
		SimpleDateFormat datetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat dt1 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		String ngayDi, ngayDen;
		Date date;
		
		try {
			CallableStatement callstmt=con.prepareCall(sql);
			callstmt.setString(1,maChuyen);
			
			ResultSet rs=callstmt.executeQuery();
			
			if(rs.next())
			{
				chuyenXe.setMaChuyen(rs.getString(1));
				chuyenXe.setTuyenDuong(rs.getString(2));
				chuyenXe.setThoiGianDi(rs.getString(3));
				chuyenXe.setThoiGianDen(rs.getString(4));
				chuyenXe.setBienSoXe(rs.getString(5));
				chuyenXe.setTiLeDatVeOnline(rs.getString(6));
				chuyenXe.setMaTaixe1(rs.getString(7));
				chuyenXe.setMaTaixe2(rs.getString(8));	
				chuyenXe.setMaPhuXe(rs.getString(9));		
				chuyenXe.setMaTuyen(rs.getString(10));		
			}
					
			ngayDi = chuyenXe.getThoiGianDi(); 	 
			ngayDen=chuyenXe.getThoiGianDen();
			if(ngayDi != null && ngayDen != null){
			date = datetime.parse(ngayDi);			
			chuyenXe.setThoiGianDi(dt1.format(date));
			
			
			date=datetime.parse(ngayDen);
			chuyenXe.setThoiGianDen(dt1.format(date));
			}
			
			return chuyenXe;
			
					} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
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
		
		return null;
	}
	

}
