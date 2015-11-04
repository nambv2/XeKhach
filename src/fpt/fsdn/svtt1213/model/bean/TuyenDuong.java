package fpt.fsdn.svtt1213.model.bean;

import java.util.Date;

public class TuyenDuong {
	private String maTuyen;
	private String noiDi;
	private String noiDen;
	private Date ngayLap;
	private String tuyenDuong;
	private String bienSoXe;
	public String getBienSoXe() {
		return bienSoXe;
	}
	public void setBienSoXe(String bienSoXe) {
		this.bienSoXe = bienSoXe;
	}
	public String getTuyenDuong() {
		return tuyenDuong;
	}
	public void setTuyenDuong(String tuyenDuong) {
		this.tuyenDuong = tuyenDuong;
	}
	public String getMaTuyen() {
		return maTuyen;
	}
	public void setMaTuyen(String maTuyen) {
		this.maTuyen = maTuyen;
	}
	public String getNoiDi() {
		return noiDi;
	}
	public void setNoiDi(String noiDi) {
		this.noiDi = noiDi;
	}
	public String getNoiDen() {
		return noiDen;
	}
	public void setNoiDen(String noiDen) {
		this.noiDen = noiDen;
	}
	public Date getNgayLap() {
		return ngayLap;
	}
	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}
	
}
