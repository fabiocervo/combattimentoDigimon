package combattimentodigimon;

public class Arena {

	private int idpartita;
	private String turno;
	private int attacco;
	private int difesa;

	public Arena(int idpartita, String turno, int attacco, int difesa) {
		super();
		this.idpartita = idpartita;
		this.turno = turno;
		this.attacco = attacco;
		this.difesa = difesa;
	}

	public int getIdpartita() {
		return idpartita;
	}

	public void setIdpartita(int idpartita) {
		this.idpartita = idpartita;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public int getAttacco() {
		return attacco;
	}

	public void setAttacco(int attacco) {
		this.attacco = attacco;
	}

	public int getDifesa() {
		return difesa;
	}

	public void setDifesa(int difesa) {
		this.difesa = difesa;
	}

	@Override
	public String toString() {
		return "Arena [idpartita=" + idpartita + ", turno=" + turno + ", attacco=" + attacco + ", difesa=" + difesa
				+ "]";
	}

}
