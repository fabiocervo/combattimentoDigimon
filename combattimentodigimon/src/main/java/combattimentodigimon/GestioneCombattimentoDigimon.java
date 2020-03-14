package combattimentodigimon;

public class GestioneCombattimentoDigimon { 
	public  int calcoloAttacco() {
		int attacco = (int) ((int) 100 + (Math.random() * 51));
		return attacco;

	}

	public  int calcoloDifesa() {
		int difesa = (int) ((int) 10 + (Math.random() * 21));
		return difesa;
	}

	public  int calcoloHp() {
		int hp = (int) ((int) 500 + (Math.random() * 101));
		return hp;
	}

	public int calcoloRes() {
		int res = (int) ((int) 5 + (Math.random() * 6));
		return res;
	}
	
	
}
