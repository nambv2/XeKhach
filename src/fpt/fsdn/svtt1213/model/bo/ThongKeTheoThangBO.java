package fpt.fsdn.svtt1213.model.bo;

import fpt.fsdn.svtt1213.model.dao.ThongKeTheoThangDAO;

public class ThongKeTheoThangBO {
	public float[] getTiLeTungThang(String nam){
		return new ThongKeTheoThangDAO().getTiLeTungThang(nam);
	}
}
