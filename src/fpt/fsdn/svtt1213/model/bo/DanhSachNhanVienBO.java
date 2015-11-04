package fpt.fsdn.svtt1213.model.bo;

import java.util.ArrayList;

import fpt.fsdn.svtt1213.model.bean.NhanVien;
import fpt.fsdn.svtt1213.model.dao.DanhSachNhanVienDAO;

public class DanhSachNhanVienBO {
	DanhSachNhanVienDAO danhSachNhanVienDAO = new DanhSachNhanVienDAO();

	public ArrayList<NhanVien> getAllDanhSachNhanVien(){
		return danhSachNhanVienDAO.getAllDanhSachNhanVien();
	}

	
}
