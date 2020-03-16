package combattimentodigimon;

public class Digimon {
	private String nome;
	private int atk;
	private int def; 
	private int res;
	private int hp;
	private String evo;
	private String tipo;
	private String proprietario;
	
	
	public Digimon(String nome, int atk, int def, int res, int hp, String evo, String tipo, String proprietario) {
		super();
		this.nome = nome;
		this.atk = atk;
		this.def = def;
		this.res = res;
		this.hp = hp;
		this.evo = evo;
		this.tipo = tipo;
		this.proprietario = proprietario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getAtk() {
		return atk;
	}
	public void setAtk(int atk) {
		this.atk = atk;
	}
	public int getDef() {
		return def;
	}
	public void setDef(int def) {
		this.def = def;
	}
	public int getRes() {
		return res;
	}
	public void setRes(int res) {
		this.res = res;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public String getEvo() {
		return evo;
	}
	public void setEvo(String evo) {
		this.evo = evo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getProprietario() {
		return proprietario;
	}
	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + atk;
		result = prime * result + def;
		result = prime * result + ((evo == null) ? 0 : evo.hashCode());
		result = prime * result + hp;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((proprietario == null) ? 0 : proprietario.hashCode());
		result = prime * result + res;
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Digimon other = (Digimon) obj;
		if (atk != other.atk)
			return false;
		if (def != other.def)
			return false;
		if (evo == null) {
			if (other.evo != null)
				return false;
		} else if (!evo.equals(other.evo))
			return false;
		if (hp != other.hp)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (proprietario == null) {
			if (other.proprietario != null)
				return false;
		} else if (!proprietario.equals(other.proprietario))
			return false;
		if (res != other.res)
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Digimon [nome=" + nome + ", atk=" + atk + ", def=" + def + ", res=" + res + ", hp=" + hp + ", evo="
				+ evo + ", tipo=" + tipo + ", proprietario=" + proprietario + "]";
	}

	

}
	