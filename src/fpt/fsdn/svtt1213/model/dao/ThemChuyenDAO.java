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
import fpt.fsdn.svtt1213.utility.BaseDAO;

public class ThemChuyenDAO {
	

	public ArrayList<String> hienThiMaNV(int vitri) {
		// TODO Auto-generated method stub
		Connection con=BaseDAO.getConnection();
		CallableStatement callstmt;
		String sql="{call dbo.Chuyenxe_MaTaiXe(?)}";
		ArrayList<String> listNhanVien=new ArrayList<String>();
		
		try {
			callstmt=con.prepareCall(sql);
			callstmt.setInt(1,vitri);
			ResultSet rs=callstmt.executeQuery();
			
			while(rs.next())
			{
				listNhanVien.add(rs.getString(1));				
			}
			return listNhanVien;
			
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
		
		
		
		return null;
	}

	public ArrayList<String> hienThiXe() {
		// TODO Auto-generated method stub
		Connection con=BaseDAO.getConnection();
		CallableStatement callstmt;
		
		String sql="{call dbo.Xe_Danhsach()}";
		ArrayList<String> listXe=new ArrayList<String>();
		
		try {
			callstmt=con.prepareCall(sql);
			ResultSet rs=callstmt.executeQuery();
			
			while(rs.next())
			{
				listXe.add(rs.getString(1));				
			}
			return listXe;
			
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
		
		
		
		return null;
	}

	public boolean themChuyen(ChuyenXe chuyenXe) {
		// TODO Auto-generated method stub
		Connection con=BaseDAO.getConnection();
		CallableStatement callstmt;
		SimpleDateFormat datetime=new SimpleDateFormat("HH:mm MM/dd/yyyy");
		Date date;
		
		String sql="{call dbo.Chuyenxe_Them(?,?,?,?,?,?,?,?,?)}";
		
		try {		
			callstmt=con.prepareCall(sql);
			callstmt.setString(1, chuyenXe.getMaChuyen());
			callstmt.setString(2, chuyenXe.getMaTuyen());
			
			
			date = datetime.parse(chuyenXe.getThoiGianDi());
			String date2 = datetime.format(date);
			System.out.println(date2);
			callstmt.setString(3, date2);
						
			date = datetime.parse(chuyenXe.getThoiGianDen());
			String date3 = datetime.format(date);
						
			callstmt.setString(4, date3);
			
			callstmt.setString(5, chuyenXe.getBienSoXe());
			callstmt.setString(6, chuyenXe.getTiLeDatVeOnline());
			callstmt.setString(7, chuyenXe.getMaTaixe1());
			callstmt.setString(8, chuyenXe.getMaTaixe2());
			callstmt.setString(9, chuyenXe.getMaPhuXe());
			
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

		public boolean checkXe(String bienSoXe, String thoiGianDi, String thoiGianDen) {

		Connection con = BaseDAO.getConnection();
		CallableStatement callstmt;
		String sql = "{ call dbo.Chuyenxe_Kiemtraxe_them(?,?,?)}";
		
		try {
			callstmt = con.prepareCall(sql);
			callstmt.setString(1, bienSoXe);
			callstmt.setString(2, thoiGianDi);
			callstmt.setString(3, thoiGianDen);
			
			
			ResultSet rs = callstmt.executeQuery();
			
			if(rs.next()) return false;
			
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
		
		return true;
	}
		public boolean checkTaiXe(String maTaiXe, String thoiGianDi, String thoiGianDen) {
			// TODO Auto-generated method stub
			
			Connection con = BaseDAO.getConnection();
			CallableStatement callstmt;
			String sql = "{ call dbo.Chuyenxe_Kiemtrataixe_them(?,?,?)}";
			
			try {
				callstmt = con.prepareCall(sql);
				callstmt.setString(1, maTaiXe);
				callstmt.setString(2, thoiGianDi);
				callstmt.setString(3, thoiGianDen);
				
				ResultSet rs = callstmt.executeQuery();
				
				if(rs.next()) return false;
				
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
			
			return true;
		}

		public boolean checkMaChuyen(String maChuyen) {
			// TODO Auto-generated method stub
			Connection con = BaseDAO.getConnection();
			String sql = "{call ChuyenXe_kiemTraMaChuyen(?)}";
			try {
				CallableStatement callstmt = con.prepareCall(sql);
				callstmt.setString(1, maChuyen);
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
