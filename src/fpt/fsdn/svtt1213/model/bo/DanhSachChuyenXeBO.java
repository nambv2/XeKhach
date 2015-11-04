package fpt.fsdn.svtt1213.model.bo;

import java.util.ArrayList;

import fpt.fsdn.svtt1213.model.bean.ChuyenXe;
import fpt.fsdn.svtt1213.model.bean.TuyenDuong;
import fpt.fsdn.svtt1213.model.dao.DanhSachChuyenXeDAO;

public class DanhSachChuyenXeBO {
	DanhSachChuyenXeDAO danhSachChuyen = new DanhSachChuyenXeDAO(); 
	public ArrayList<ChuyenXe> hienThiDanhSach(String maTuyen) {
		
		DanhSachChuyenXeDAO danhSachChuyen = new DanhSachChuyenXeDAO(); 
		return danhSachChuyen.hienThiDanhSach(maTuyen);
	
		
	}

	public ArrayList<TuyenDuong> listTuyenDuong() {
		
		
		return  danhSachChuyen.listTuyenDuong();
	}

}
