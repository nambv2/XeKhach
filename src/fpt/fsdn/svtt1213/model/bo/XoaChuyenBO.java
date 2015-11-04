package fpt.fsdn.svtt1213.model.bo;

import fpt.fsdn.svtt1213.model.dao.XoaChuyenDAO;

public class XoaChuyenBO {

	public boolean xoaChuyen(String maChuyen) {
	
		XoaChuyenDAO xoaChuyenDAO = new XoaChuyenDAO();
		return xoaChuyenDAO.xoaChuyen(maChuyen);
	}

}
