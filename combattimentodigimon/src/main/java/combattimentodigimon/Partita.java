package combattimentodigimon;

public class Partita { 

	
	private String password;
	private String idCreatore;
	private String idSfidante;
	private int dc1;
	private int dc2;
	private int dc3;
	private int ds1;
	private int ds2;
	private int ds3;
	
	
	public Partita(String password, String idCreatore, String idSfidante, int dc1, int dc2, int dc3, int ds1, int ds2,
			int ds3) {
		super();
		this.password = password;
		this.idCreatore = idCreatore;
		this.idSfidante = idSfidante;
		this.dc1 = dc1;
		this.dc2 = dc2;
		this.dc3 = dc3;
		this.ds1 = ds1;
		this.ds2 = ds2;
		this.ds3 = ds3;
	}
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIdCreatore() {
		return idCreatore;
	}
	public void setIdCreatore(String idCreatore) {
		this.idCreatore = idCreatore;
	}
	public String getIdSfidante() {
		return idSfidante;
	}
	public void setIdSfidante(String idSfidante) {
		this.idSfidante = idSfidante;
	}
	public int getDc1() {
		return dc1;
	}
	public void setDc1(int dc1) {
		this.dc1 = dc1;
	}
	public int getDc2() {
		return dc2;
	}										
	public void setDc2(int dc2) {
		this.dc2 = dc2;
	}
	public int getDc3() {
		return dc3;
	}
	public void setDc3(int dc3) {
		this.dc3 = dc3;
	}
	public int getDs1() {
		return ds1;
	}
	public void setDs1(int ds1) {
		this.ds1 = ds1;
	}
	public int getDs2() {
		return ds2;
	}
	public void setDs2(int ds2) {
		this.ds2 = ds2;
	}
	public int getDs3() {
		return ds3;
	}
	public void setDs3(int ds3) {
		this.ds3 = ds3;
	}
	@Override
	public String toString() {
		return "Partita [password=" + password + ", idCreatore=" + idCreatore + ", idSfidante=" + idSfidante + ", dc1="
				+ dc1 + ", dc2=" + dc2 + ", dc3=" + dc3 + ", ds1=" + ds1 + ", ds2=" + ds2 + ", ds3=" + ds3 + "]";
	}

	
	
	
	
	
	
	
	
}
