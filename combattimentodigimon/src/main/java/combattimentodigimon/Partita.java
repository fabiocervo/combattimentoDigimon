package combattimentodigimon;

public class Partita { 

	
	private String password;
	private String idGiocatore;
	private int digi1;
	private int digi2;
	private int digi3;
	
	
	public Partita(String password, String idGiocatore, int digi1, int digi2, int digi3) {
		super();
		this.password = password;
		this.idGiocatore = idGiocatore;
		this.digi1 = digi1;
		this.digi2 = digi2;
		this.digi3 = digi3;
	}
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIdGiocatore() {
		return idGiocatore;
	}
	public void setIdGiocatore(String idGiocatore) {
		this.idGiocatore = idGiocatore;
	}
	public int getDigi1() {
		return digi1;
	}
	public void setDigi1(int digi1) {
		this.digi1 = digi1;
	}
	public int getDigi2() {
		return digi2;
	}
	public void setDigi2(int digi2) {
		this.digi2 = digi2;
	}
	public int getDigi3() {
		return digi3;
	}
	public void setDigi3(int digi3) {
		this.digi3 = digi3;
	}


	@Override
	public String toString() {
		return "Partita [password=" + password + ", idGiocatore=" + idGiocatore + ", digi1=" + digi1 + ", digi2="
				+ digi2 + ", digi3=" + digi3 + "]";
	}
	
	
	
	

	
	
	
	
	
}
