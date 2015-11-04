package fpt.fsdn.svtt1213.model.bo;

import java.util.ArrayList;

import fpt.fsdn.svtt1213.model.bean.NhanVien;
import fpt.fsdn.svtt1213.model.dao.CapNhatNhanVienDAO;
import fpt.fsdn.svtt1213.utility.Security;

public class CapNhatNhanVienBO {
	CapNhatNhanVienDAO capNhatNhanVienDAO = new CapNhatNhanVienDAO();
	public ArrayList<String> isValidate(NhanVien nhanVien) {
		ArrayList<String> validate = new ArrayList<String>();
		if(!Security.validateFieldname(nhanVien.getHoTen())) validate.add("hoTenError");
		if(!Security.validateTelephone(nhanVien.getDienThoai())) validate.add("dienThoaiError");
		if(!Security.validateQueQuan(nhanVien.getQueQuan())) validate.add("queQuanError");
		if(!Security.validateSoCMND(nhanVien.getCMND())) validate.add("CMNDError");
		return validate;
	}

	public int capNhatNhanVien(NhanVien nhanVien) {
		// TODO Auto-generated method stub
		return capNhatNhanVienDAO.capNhatNhanVien(nhanVien);
	}

}
