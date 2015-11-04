package fpt.fsdn.svtt1213.model.bean;

import java.util.Date;

public class DanhSachVeDuocDat {
private String hoTen,bienSoxe,noiDi,noiDen,CMND,soDT;
private int maVe;
private int trangThai,vitriNgoi;
private float giaTien;
private Date thoiGiandi;

public int getMaVe() {
	return maVe;
}
public void setMaVe(int maVe) {
	this.maVe = maVe;
}
public String getHoTen() {
	return hoTen;
}
public void setHoTen(String hoTen) {
	this.hoTen = hoTen;
}
public String getBienSoxe() {
	return bienSoxe;
}
public void setBienSoxe(String bienSoxe) {
	this.bienSoxe = bienSoxe;
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
public String getCMND() {
	return CMND;
}
public void setCMND(String cMND) {
	CMND = cMND;
}
public String getSoDT() {
	return soDT;
}
public void setSoDT(String soDT) {
	this.soDT = soDT;
}
public int getTrangThai() {
	return trangThai;
}
public void setTrangThai(int trangThai) {
	this.trangThai = trangThai;
}
public int getVitriNgoi() {
	return vitriNgoi;
}
public void setVitriNgoi(int vitriNgoi) {
	this.vitriNgoi = vitriNgoi;
}
public float getGiaTien() {
	return giaTien;
}
public void setGiaTien(float giaTien) {
	this.giaTien = giaTien;
}
public Date getThoiGiandi() {
	return thoiGiandi;
}
public void setThoiGiandi(Date thoiGiandi) {
	this.thoiGiandi = thoiGiandi;
}

}
