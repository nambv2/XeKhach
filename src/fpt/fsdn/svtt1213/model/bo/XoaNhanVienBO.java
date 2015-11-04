package fpt.fsdn.svtt1213.model.bo;
import fpt.fsdn.svtt1213.model.dao.XoaNhanVienDAO;
public class XoaNhanVienBO {
	XoaNhanVienDAO xoaNhanVienDAO = new XoaNhanVienDAO();
	public int xoaNhanVien(String maNhanVien) {
		return xoaNhanVienDAO.xoaNhanVien(maNhanVien);
	}

}
