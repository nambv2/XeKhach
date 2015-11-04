package fpt.fsdn.svtt1213.model.bo;

import fpt.fsdn.svtt1213.model.bean.NhanVien;
import fpt.fsdn.svtt1213.model.dao.TimKiemCapNhatNhanVienDAO;

public class TimKiemCapNhatNhanVienBO {
	TimKiemCapNhatNhanVienDAO timKiemCapNhatNhanVienDAO = new TimKiemCapNhatNhanVienDAO();
	public NhanVien timKiemNhanVien(String maNhanVien) {	
		return timKiemCapNhatNhanVienDAO.timKiemNhanVien(maNhanVien);
	}

}
