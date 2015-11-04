package fpt.fsdn.svtt1213.model.bean;

public class BaoCao {
	private String maTuyen;
	private String tenTuyen;
	private float tile;
	public String getMaTuyen() {
		return maTuyen;
	}
	public void setMaTuyen(String maTuyen) {
		this.maTuyen = maTuyen;
	}
	public String getTenTuyen() {
		return tenTuyen;
	}
	public void setTenTuyen(String tenTuyen) {
		this.tenTuyen = tenTuyen;
	}
	public float getTile() {
		return tile;
	}
	public void setTile(float tile) {
		this.tile = tile;
	}
	
	private float[] tiLeNam;
	public float[] getTiLeNam() {
		return tiLeNam;
	}
	public void setTiLeNam(float[] tiLeNam) {
		this.tiLeNam = tiLeNam;
	}
}
