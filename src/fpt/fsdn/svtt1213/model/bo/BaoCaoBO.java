package fpt.fsdn.svtt1213.model.bo;

import java.util.ArrayList;

import fpt.fsdn.svtt1213.model.bean.BaoCao;
import fpt.fsdn.svtt1213.model.dao.BaoCaoDAO;
import fpt.fsdn.svtt1213.utility.Security;

public class BaoCaoBO {
	//kiem tra du lieu nhan duoc tu servlet, va thiet lap mang cac nam
	public String[] check(String tu,String den){
		String[] nam;
		if(Security.validateYear(tu) && Security.validateYear(den)){
			int namTu = Integer.parseInt(tu);
			int namDen = Integer.parseInt(den);
			if(namTu == namDen){
				nam = new String[1];
				nam[0] = String.valueOf(namTu);
			
			}else if(namTu < namDen){
				
				nam = new String[namDen-namTu+1];
				int i = 0;
				int j = namTu;
				do{
					nam[i] = String.valueOf(j);
					i++;
					j++;
				}while(j <= namDen);
				
			}else{
				nam = new String[1];
				nam[0] = "invalid";
			}
		}else{
			nam = new String[1];
			nam[0] = "invalid";
		}
		
		return nam;
	}
	
	//noi du lieu tu nhieu bang gop lai
	public ArrayList<BaoCao>  hienThi(String[] nam){
		BaoCaoDAO bc = new BaoCaoDAO();
		BaoCao b;
		ArrayList<BaoCao>[] arr = (ArrayList<BaoCao>[]) new ArrayList[20];
			for (int i = 0; i < nam.length; i++) {
				arr[i] = bc.hienthi(nam[i]); // lay du lieu theo cac nam
			}	
			
		ArrayList<BaoCao> arr1 = new ArrayList<BaoCao>();
		
		float[] tiLeNam = null; 
			for (int j = 0; j < arr[0].size(); j++) {
				b = new BaoCao();
				tiLeNam = new float[nam.length]; //chua du lieu ti le cua cac nam
				for (int k = 0; k < nam.length; k++) {
					tiLeNam[k] = arr[k].get(j).getTile(); // lay ti le cua tung nam gan vao 1 mang			
				}
				b.setMaTuyen(arr[0].get(j).getMaTuyen());
				b.setTenTuyen(arr[0].get(j).getTenTuyen());
				
				b.setTiLeNam(tiLeNam);
				arr1.add(b);
			}
				
			return arr1;		
	}
	
	public String getNamDauTuyen(){
		return new BaoCaoDAO().getNamDauTuyen();
	}
	

}
