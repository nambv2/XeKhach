package fpt.fsdn.svtt1213.model.bo;

import java.util.ArrayList;

import fpt.fsdn.svtt1213.model.bean.TuyenDuong;
import fpt.fsdn.svtt1213.model.dao.ThemTuyenDuongDAO;

public class ThemTuyenDuongBO {
	public ArrayList<TuyenDuong> danhSachTuyen(){
		return new ThemTuyenDuongDAO().danhSachTuyen();
	}
}
