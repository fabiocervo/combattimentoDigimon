package combattimentodigimon;

public class Digimon {
	private String nome;
	private int atk;
	private int def;
	private int res;
	private int hp;
	private String evo;
	private String tipo;
	

	public Digimon(String nome, int atk, int def, int res, int hp, String evo, String tipo) {
		super();
		this.nome = nome;
		this.atk = atk;
		this.def = def;
		this.res = res;
		this.hp = hp;
		this.evo = evo;
		this.tipo = tipo;
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


	

	@Override
	public String toString() {
		return "Digimon [nome=" + nome + ", atk=" + atk + ", def=" + def + ", res=" + res + ", hp=" + hp + ", evo="
				+ evo + ", tipo=" + tipo + "]";
	}

	
	}


