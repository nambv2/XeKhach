package fpt.fsdn.svtt1213.model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import fpt.fsdn.svtt1213.model.bean.GiaVe;
import fpt.fsdn.svtt1213.model.bean.TuyenDuong;
import fpt.fsdn.svtt1213.model.dao.CapNhatGiaVeDAO;
import fpt.fsdn.svtt1213.utility.Security;

public class CapNhatGiaVeBO {
	CapNhatGiaVeDAO capnhatGiaVe=new CapNhatGiaVeDAO();
	public TuyenDuong timGiaVe(String matuyen) throws SQLException {
		
		return capnhatGiaVe.timGiaVe(matuyen);
	}

	public boolean capnhatgiaVe(GiaVe giave) throws SQLException {
		return capnhatGiaVe.capnhatgiaVe(giave);
		
	}

	public ArrayList<String> isvalidateFieldprice(String giaVe, String giamGia) {
		ArrayList<String> validate = new ArrayList<String>();
		if(!(Security.validatePrice(giaVe))||!(Float.valueOf(giaVe)>0&&Float.valueOf(giaVe)<1000000))validate.add("GiaVeError");
		if(!(Security.validatePrice(giamGia))||!(Float.valueOf(giamGia)>=0&&Float.valueOf(giamGia)<=100))validate.add("GiamGiaError");
		
		return validate;
	}

	public TuyenDuong timTenTuyen(String maTuyen) throws SQLException {
		
		return capnhatGiaVe.timGiaVe(maTuyen);
	}

	public GiaVe kiemtraGiave(String maTuyen,String bienSoXe) throws SQLException {
		return capnhatGiaVe.kiemtraGiave(maTuyen,bienSoXe);
		
	}

}
