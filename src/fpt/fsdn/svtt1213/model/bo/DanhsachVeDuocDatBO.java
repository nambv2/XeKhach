package fpt.fsdn.svtt1213.model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import fpt.fsdn.svtt1213.model.bean.DanhSachVeDuocDat;
import fpt.fsdn.svtt1213.model.bean.TuyenDuong;
import fpt.fsdn.svtt1213.model.dao.DanhsachVeDuocDatDAO;
import fpt.fsdn.svtt1213.utility.Security;

public class DanhsachVeDuocDatBO {
	DanhsachVeDuocDatDAO veDuocdatDAO=new DanhsachVeDuocDatDAO();
	public ArrayList<TuyenDuong> timTuyen() throws SQLException {
		
		return veDuocdatDAO.timTuyen();
	}

	public ArrayList<DanhSachVeDuocDat> timVe(String maTuyen,String soCMND) throws SQLException {
		return veDuocdatDAO.timVe(maTuyen,soCMND);
	}

	public ArrayList<String> isValidateFieldprice(String soCMND) {
		ArrayList<String> validate = new ArrayList<String>();
		if(!(Security.validateTelephone(soCMND)))validate.add("GiaVeError");
		
		return validate;
	}

	

}
