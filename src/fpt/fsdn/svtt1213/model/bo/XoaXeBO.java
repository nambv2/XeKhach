package fpt.fsdn.svtt1213.model.bo;

import fpt.fsdn.svtt1213.model.dao.xoaXeDAO;

public class XoaXeBO {

	public boolean xoaXe(String bienSoXe) {
		// TODO Auto-generated method stub
		return xoaXeDAO.xoaXe(bienSoXe);
	}

}
