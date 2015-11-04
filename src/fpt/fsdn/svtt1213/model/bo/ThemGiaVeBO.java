package fpt.fsdn.svtt1213.model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import fpt.fsdn.svtt1213.model.bean.GiaVe;
import fpt.fsdn.svtt1213.model.bean.TuyenDuong;
import fpt.fsdn.svtt1213.model.dao.ThemGiaVeDAO;
import fpt.fsdn.svtt1213.utility.Security;

public class ThemGiaVeBO {
   public int themGiave(GiaVe giaVe) {
		ThemGiaVeDAO themgiaveDAO=new ThemGiaVeDAO();
	return	themgiaveDAO.themGiaVe(giaVe);
		
	}

	public ArrayList<TuyenDuong> tuyenDuong() throws SQLException {
		ThemGiaVeDAO themgiaveDAO=new ThemGiaVeDAO();
		return themgiaveDAO.tuyenDuong();
	}

	public ArrayList<String> isValidateFieldprice(String ktraGiaVe, String ktraGiamGia) {
		ArrayList<String> validate = new ArrayList<String>();
		if(!(Security.validatePrice(ktraGiaVe))||!(Float.valueOf(ktraGiaVe)>0&&Float.valueOf(ktraGiaVe)<1000000))validate.add("GiaVeError");
		if(!(Security.validatePrice(ktraGiamGia))||!(Float.valueOf(ktraGiamGia)>=0&&Float.valueOf(ktraGiamGia)<=100))validate.add("GiamGiaError");
		
		return validate;
	}

}
