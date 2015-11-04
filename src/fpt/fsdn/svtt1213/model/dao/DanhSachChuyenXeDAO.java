package fpt.fsdn.svtt1213.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import fpt.fsdn.svtt1213.model.bean.ChuyenXe;
import fpt.fsdn.svtt1213.model.bean.TuyenDuong;
import fpt.fsdn.svtt1213.utility.BaseDAO;

public class DanhSachChuyenXeDAO {
	

	CallableStatement callstmt=null;
	
    	
	public ArrayList<ChuyenXe> hienThiDanhSach(String maTuyen) {
		// TODO Auto-generated method stub		
		Connection con=BaseDAO.getConnection();
		String sql="{call dbo.Chuyenxe_Danhsach(?)}";
		ArrayList<ChuyenXe> chuyenXe=new ArrayList<ChuyenXe>();
		
		SimpleDateFormat datetime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat dateconvert=new SimpleDateFormat("dd-MM-yyyy HH:mm");
		String ngaydi,ngayden;
		Date date;
		
		try {
			callstmt=con.prepareCall(sql);
			callstmt.setString(1, maTuyen);			
			ResultSet rs=callstmt.executeQuery();
			
			while(rs.next())
			{   ChuyenXe chuyenXeObject=new ChuyenXe();
				chuyenXeObject.setMaChuyen(rs.getString(1));
				chuyenXeObject.setTuyenDuong(rs.getString(2));
				
				ngaydi=rs.getString(3);
				date=datetime.parse(ngaydi);
				chuyenXeObject.setThoiGianDi(dateconvert.format(date));
				
				ngayden=rs.getString(4);
				date=datetime.parse(ngayden);
				chuyenXeObject.setThoiGianDen(dateconvert.format(date));
				
				chuyenXe.add(chuyenXeObject);
				
			}
				
			return chuyenXe;
			
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
		
		return null;
	}

	public ArrayList<TuyenDuong> listTuyenDuong() {
		// TODO Auto-generated method stub
		Connection con=BaseDAO.getConnection();
		ArrayList<TuyenDuong> listTuyen=new ArrayList<TuyenDuong>();
		String sql="{call dbo.Dropdown_tuyen()}";
		 
		try {
			callstmt=con.prepareCall(sql);
		
			ResultSet rs=callstmt.executeQuery();
			TuyenDuong tuyenDuong;
			while(rs.next())
			{
				tuyenDuong=new TuyenDuong();
				tuyenDuong.setMaTuyen(rs.getString("maTuyen"));
				tuyenDuong.setTuyenDuong(rs.getString(2));
				listTuyen.add(tuyenDuong);		
			}
			
			return listTuyen;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				
		return null;
	}
public static void main(String[] args) {
	new DanhSachChuyenXeDAO().listTuyenDuong();
}
}
