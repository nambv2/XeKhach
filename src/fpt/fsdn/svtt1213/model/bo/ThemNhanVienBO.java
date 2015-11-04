package fpt.fsdn.svtt1213.model.bo;

import java.util.ArrayList;

import fpt.fsdn.svtt1213.model.bean.NhanVien;
import fpt.fsdn.svtt1213.model.dao.ThemNhanVienDAO;
import fpt.fsdn.svtt1213.utility.Security;

public class ThemNhanVienBO {
	ThemNhanVienDAO themNhanVienDAO = new ThemNhanVienDAO();
	public ArrayList<String> isValidate(NhanVien nhanVien) {
		ArrayList<String> validate = new ArrayList<String>();
		if(!Security.validateMaNhanVien(nhanVien.getMaNhanVien()))validate.add("maNhanVienError");
		if(Security.validateFieldname(nhanVien.getHoTen()) == false) validate.add("hoTenError");
		System.out.println(nhanVien.getHoTen());
		System.out.println(Security.validateFieldname(nhanVien.getHoTen()));
		if(!Security.validateTelephone(nhanVien.getDienThoai())) validate.add("dienThoaiError");
		if(!Security.validateQueQuan(nhanVien.getQueQuan())) validate.add("queQuanError");
		if(!Security.validateSoCMND(nhanVien.getCMND())) validate.add("CMNDError");
		return validate;
	}

	public int saveNhanVienMoi(NhanVien nhanVien) {
		return themNhanVienDAO.saveNhanVienMoi(nhanVien);
		
	}

}
