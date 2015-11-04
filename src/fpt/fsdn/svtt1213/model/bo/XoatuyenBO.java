package fpt.fsdn.svtt1213.model.bo;

import fpt.fsdn.svtt1213.model.dao.XoatuyenDAO;

public class XoatuyenBO {
	XoatuyenDAO xoatuyenDAO=new XoatuyenDAO();
	public void xoaTuyen(String maTuyen){
		xoatuyenDAO.xoaTuyen(maTuyen);
	}
}
