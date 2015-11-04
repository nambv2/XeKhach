package fpt.fsdn.svtt1213.model.bo;

import java.util.ArrayList;

import fpt.fsdn.svtt1213.model.bean.Xe;
import fpt.fsdn.svtt1213.model.dao.DanhSachXeDAO;

public class DanhSachXeBO {

	public ArrayList<Xe> hienThiDanhSach() {
		// TODO Auto-generated method stub
		DanhSachXeDAO danhSachXeDAO = new DanhSachXeDAO();
		return danhSachXeDAO.hienThiDanhSach();
	}

}
