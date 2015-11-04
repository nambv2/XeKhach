package fpt.fsdn.svtt1213.model.bo;

import java.util.ArrayList;

import fpt.fsdn.svtt1213.model.bean.NhanVien;
import fpt.fsdn.svtt1213.model.dao.TimKiemNhanVienDAO;
import fpt.fsdn.svtt1213.utility.Security;

public class TimKiemNhanVienBO {

	public ArrayList<NhanVien> timKiemNhanVien(String hoTen) {
		TimKiemNhanVienDAO timKiemNhanVienDAO = new TimKiemNhanVienDAO();
		return timKiemNhanVienDAO.timKiemNhanVien(hoTen);
	}

	public boolean isValidate(String hoTen) {
		return Security.validateFieldname(hoTen);
	}

}
