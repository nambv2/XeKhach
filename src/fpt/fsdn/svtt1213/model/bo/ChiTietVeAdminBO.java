package fpt.fsdn.svtt1213.model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import fpt.fsdn.svtt1213.model.bean.DanhSachVeDuocDat;
import fpt.fsdn.svtt1213.model.dao.ChiTietVeAdminDAO;
import fpt.fsdn.svtt1213.utility.Security;

public class ChiTietVeAdminBO {
	ChiTietVeAdminDAO chitietVe=new ChiTietVeAdminDAO();
	public DanhSachVeDuocDat timVe(String maVe) throws SQLException {
		return chitietVe.timVe(maVe);
	}
	public boolean kiemtraVe(String maVe) {
		return chitietVe.kiemtraVe(maVe);
	}
	public ArrayList<String> isvalidateFieldprice(String maVe) {
		ArrayList<String> validate = new ArrayList<String>();
		if(!(Security.validatePrice(maVe)))validate.add("GiaVeError");
		
		return validate;
	}
}
