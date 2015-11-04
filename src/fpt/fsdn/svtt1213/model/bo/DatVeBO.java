package fpt.fsdn.svtt1213.model.bo;

import java.util.ArrayList;

import fpt.fsdn.svtt1213.controller.DatVeServlet;
import fpt.fsdn.svtt1213.model.bean.DatVe;
import fpt.fsdn.svtt1213.model.dao.DatVeDAO;

public class DatVeBO {

	public boolean datVe(String tenDangNhap,String maChuyen,int viTriNgoi){
		DatVeServlet dv = new DatVeServlet();
		
		return new DatVeDAO().datVe(tenDangNhap, maChuyen, viTriNgoi,0);
	}
	
	public ArrayList<DatVe> getThongTinDaDat(ArrayList<DatVe> arr,String ngayDi,String ngayVe){
		
		for (int i = 0; i < arr.size() - 1; i++) {
			for (int j = i+1; j < arr.size(); j++) {
				if((arr.get(i).getMaChuyen() == arr.get(j).getMaChuyen()) && (arr.get(i).getViTriNgoiDat() == arr.get(j).getViTriNgoiDat())){
					for (int k = j; k < arr.size() - 1; k++) {
						arr.get(k).setMaChuyen(arr.get(k+1).getMaChuyen());
						arr.get(k).setTenDangNhap(arr.get(k+1).getTenDangNhap());
						arr.get(k).setViTriNgoiDat(arr.get(k+1).getViTriNgoiDat());
						
					}
					arr.remove(arr.size() - 1);
				}
			}
			
		}
		
		DatVeDAO datVeDAO = new DatVeDAO();
		
		//kiem tra co khu hoi hay k?
		if(ngayDi != null && ngayVe != null){
			return datVeDAO.getThongTinDaDat(arr, 1);
		}else{
			return datVeDAO.getThongTinDaDat(arr, 0);
		}
		
	}
	public int[] layViTriNgoiCuaChuyen(String maChuyen){
		return new DatVeDAO().layViTriNgoiCuaChuyen(maChuyen);
	}
	
}
