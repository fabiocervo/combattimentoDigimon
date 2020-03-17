package combattimentodigimon;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GestioneTurniDigimon {

	private List<Digimon> listaDigimonCreatore;
	private List<Digimon> listaDigimonSfidante;
	private String creatore;
	private String sfidante;

	public GestioneTurniDigimon() {
		this.listaDigimonCreatore = new ArrayList<>();
		this.listaDigimonSfidante = new ArrayList<>();
	}

	public List<Digimon> getListaDigimonCreatore() {
		return listaDigimonCreatore;
	}

	public void setListaDigimonCreatore(List<Digimon> listaDigimonCreatore) {
		this.listaDigimonCreatore = listaDigimonCreatore;
	}

	public List<Digimon> getListaDigimonSfidante() {
		return listaDigimonSfidante;
	}

	public void setListaDigimonSfidante(List<Digimon> listaDigimonSfidante) {
		this.listaDigimonSfidante = listaDigimonSfidante;
	}

	public void impostazioneAttaccoDifesa(Gestione g, int idPartita, String idUtente) throws SQLException {
		String digi1 = getListaDigimonCreatore().get(0).getNome();
		String digi2 = getListaDigimonCreatore().get(1).getNome();
		String digi3 = getListaDigimonCreatore().get(2).getNome();
		String digi4 = getListaDigimonSfidante().get(0).getNome();
		String digi5 = getListaDigimonSfidante().get(1).getNome();
		String digi6 = getListaDigimonSfidante().get(2).getNome();
		if (g.checkUtente(idPartita).equals(idUtente)) {
			g.popolamentoArenaAttacco(idPartita, digi1, idUtente);
		} else {
			g.popolamentoArenaDifesa(digi4, idPartita);
		}
		
	}
    
	public void gestioneLottaCreatore(int i) {

		// acqua DANNI NORMALI terra acqua DANNI SFAVOREVOLI aria DANNI FAVOREVOLI fuoco

		System.out.println(this.getListaDigimonCreatore().get(i) + "VS" + this.getListaDigimonSfidante().get(i));

		if (this.getListaDigimonCreatore().get(i).getTipo() == "acqua") {
			if (this.getListaDigimonSfidante().get(i).getTipo() == "acqua"
					|| this.getListaDigimonSfidante().get(i).getTipo() == "terra") {
				int danni = this.getListaDigimonCreatore().get(i).getAtk();

				int hpnuovi = this.getListaDigimonSfidante().get(i).getHp()
						- ((danni - this.getListaDigimonSfidante().get(i).getDef())
								* ((this.getListaDigimonSfidante().get(i).getRes()) / 100));

				this.getListaDigimonSfidante().get(i).setHp(hpnuovi);

			}

			if (this.getListaDigimonSfidante().get(i).getTipo() == "aria") {
				int danni = (int) this.getListaDigimonCreatore().get(i).getAtk() / 2;

				int hpnuovi = this.getListaDigimonSfidante().get(i).getHp()
						- ((danni - this.getListaDigimonSfidante().get(i).getDef())
								* ((this.getListaDigimonSfidante().get(i).getRes()) / 100));

				this.getListaDigimonSfidante().get(i).setHp(hpnuovi);

			}

			if (this.getListaDigimonSfidante().get(i).getTipo() == "fuoco") {
				int danni = (int) this.getListaDigimonCreatore().get(i).getAtk() * 2;

				int hpnuovi = this.getListaDigimonSfidante().get(i).getHp()
						- ((danni - this.getListaDigimonSfidante().get(i).getDef())
								* ((this.getListaDigimonSfidante().get(i).getRes()) / 100));

				this.getListaDigimonSfidante().get(i).setHp(hpnuovi);

			}

		}

		// fuoco DANNI NORMALI aria fuoco DANNI SFAVOREVOLI acqua DANNI FAVOREVOLI terra
		else if (this.getListaDigimonCreatore().get(i).getTipo() == "fuoco") {
			if (this.getListaDigimonSfidante().get(i).getTipo() == "aria"
					|| this.getListaDigimonSfidante().get(i).getTipo() == "fuoco") {
				int danni = this.getListaDigimonCreatore().get(i).getAtk();

				int hpnuovi = this.getListaDigimonSfidante().get(i).getHp()
						- ((danni - this.getListaDigimonSfidante().get(i).getDef())
								* ((this.getListaDigimonSfidante().get(i).getRes()) / 100));

				this.getListaDigimonSfidante().get(i).setHp(hpnuovi);

			}

			if (this.getListaDigimonSfidante().get(i).getTipo() == "acqua") {
				int danni = (int) this.getListaDigimonCreatore().get(i).getAtk() / 2;

				int hpnuovi = this.getListaDigimonSfidante().get(i).getHp()
						- ((danni - this.getListaDigimonSfidante().get(i).getDef())
								* ((this.getListaDigimonSfidante().get(i).getRes()) / 100));

				this.getListaDigimonSfidante().get(i).setHp(hpnuovi);

			}

			if (this.getListaDigimonSfidante().get(i).getTipo() == "terra") {
				int danni = (int) this.getListaDigimonCreatore().get(i).getAtk() * 2;

				int hpnuovi = this.getListaDigimonSfidante().get(i).getHp()
						- ((danni - this.getListaDigimonSfidante().get(i).getDef())
								* ((this.getListaDigimonSfidante().get(i).getRes()) / 100));

				this.getListaDigimonSfidante().get(i).setHp(hpnuovi);

			}

		}

		// aria DANNI NORMALI fuoco aria DANNI SFAVOREVOLI terra DANNI FAVOREVOLI acqua

		else if (this.getListaDigimonCreatore().get(i).getTipo() == "aria") {
			if (this.getListaDigimonSfidante().get(i).getTipo() == "fuoco"
					|| this.getListaDigimonSfidante().get(i).getTipo() == "aria") {
				int danni = this.getListaDigimonCreatore().get(i).getAtk();

				int hpnuovi = this.getListaDigimonSfidante().get(i).getHp()
						- ((danni - this.getListaDigimonSfidante().get(i).getDef())
								* ((this.getListaDigimonSfidante().get(i).getRes()) / 100));

				this.getListaDigimonSfidante().get(i).setHp(hpnuovi);

			}

			if (this.getListaDigimonSfidante().get(i).getTipo() == "terra") {
				int danni = (int) this.getListaDigimonCreatore().get(i).getAtk() / 2;

				int hpnuovi = this.getListaDigimonSfidante().get(i).getHp()
						- ((danni - this.getListaDigimonSfidante().get(i).getDef())
								* ((this.getListaDigimonSfidante().get(i).getRes()) / 100));

				this.getListaDigimonSfidante().get(i).setHp(hpnuovi);

			}

			if (this.getListaDigimonSfidante().get(i).getTipo() == "acqua") {
				int danni = (int) this.getListaDigimonCreatore().get(0).getAtk() * 2;

				int hpnuovi = this.getListaDigimonSfidante().get(i).getHp()
						- ((danni - this.getListaDigimonSfidante().get(i).getDef())
								* ((this.getListaDigimonSfidante().get(i).getRes()) / 100));

				this.getListaDigimonSfidante().get(i).setHp(hpnuovi);

			}

		}

		// terra DANNI NORMALI acqua terra DANNI SFAVOREVOLI fuoco DANNI FAVOREVOLI aria

		else if (this.getListaDigimonCreatore().get(i).getTipo() == "terra") {
			if (this.getListaDigimonSfidante().get(i).getTipo() == "acqua"
					|| this.getListaDigimonSfidante().get(i).getTipo() == "terra") {
				int danni = this.getListaDigimonCreatore().get(i).getAtk();

				int hpnuovi = this.getListaDigimonSfidante().get(i).getHp()
						- ((danni - this.getListaDigimonSfidante().get(i).getDef())
								* ((this.getListaDigimonSfidante().get(i).getRes()) / 100));

				this.getListaDigimonSfidante().get(i).setHp(hpnuovi);

			}

			if (this.getListaDigimonSfidante().get(i).getTipo() == "fuoco") {
				int danni = (int) this.getListaDigimonCreatore().get(i).getAtk() / 2;

				int hpnuovi = this.getListaDigimonSfidante().get(i).getHp()
						- ((danni - this.getListaDigimonSfidante().get(i).getDef())
								* ((this.getListaDigimonSfidante().get(i).getRes()) / 100));

				this.getListaDigimonSfidante().get(i).setHp(hpnuovi);

			}

			if (this.getListaDigimonSfidante().get(i).getTipo() == "aria") {
				int danni = (int) this.getListaDigimonCreatore().get(i).getAtk() * 2;

				int hpnuovi = this.getListaDigimonSfidante().get(i).getHp()
						- ((danni - this.getListaDigimonSfidante().get(i).getDef())
								* ((this.getListaDigimonSfidante().get(i).getRes()) / 100));

				this.getListaDigimonSfidante().get(i).setHp(hpnuovi);

			}

		}

		if (this.getListaDigimonSfidante().get(i).getHp() == 0) {
			System.out.println(this.getListaDigimonCreatore().get(i) + " ha vinto contro "
					+ this.getListaDigimonSfidante().get(i));
		}

		else if (this.getListaDigimonCreatore().get(i).getHp() == 0) {
			System.out.println(this.getListaDigimonSfidante().get(i) + " ha vinto contro "
					+ this.getListaDigimonCreatore().get(i));
		}
	}

	public void gestioneLottaSfidante(int i) {

		// acqua DANNI NORMALI terra acqua DANNI SFAVOREVOLI aria DANNI FAVOREVOLI fuoco

		System.out.println(this.getListaDigimonSfidante().get(i) + "VS" + this.getListaDigimonCreatore().get(i));

		if (this.getListaDigimonSfidante().get(i).getTipo() == "acqua") {

			if (this.getListaDigimonCreatore().get(i).getTipo() == "acqua"
					|| this.getListaDigimonCreatore().get(i).getTipo() == "terra") {
				int danni = this.getListaDigimonSfidante().get(i).getAtk();

				int hpnuovi = this.getListaDigimonCreatore().get(i).getHp()
						- ((danni - this.getListaDigimonCreatore().get(i).getDef())
								* ((this.getListaDigimonCreatore().get(i).getRes()) / 100));

				this.getListaDigimonCreatore().get(i).setHp(hpnuovi);

			}

			if (this.getListaDigimonCreatore().get(i).getTipo() == "aria") {
				int danni = (int) this.getListaDigimonSfidante().get(i).getAtk() / 2;

				int hpnuovi = this.getListaDigimonCreatore().get(i).getHp()
						- ((danni - this.getListaDigimonCreatore().get(i).getDef())
								* ((this.getListaDigimonCreatore().get(i).getRes()) / 100));

				this.getListaDigimonCreatore().get(i).setHp(hpnuovi);

			}

			if (this.getListaDigimonCreatore().get(i).getTipo() == "fuoco") {
				int danni = (int) this.getListaDigimonSfidante().get(i).getAtk() * 2;

				int hpnuovi = this.getListaDigimonCreatore().get(i).getHp()
						- ((danni - this.getListaDigimonCreatore().get(i).getDef())
								* ((this.getListaDigimonCreatore().get(i).getRes()) / 100));

				this.getListaDigimonCreatore().get(i).setHp(hpnuovi);

			}

		}

		// fuoco DANNI NORMALI aria fuoco DANNI SFAVOREVOLI acqua DANNI FAVOREVOLI terra
		else if (this.getListaDigimonSfidante().get(i).getTipo() == "fuoco") {

			if (this.getListaDigimonCreatore().get(i).getTipo() == "aria"
					|| this.getListaDigimonCreatore().get(i).getTipo() == "fuoco") {
				int danni = this.getListaDigimonSfidante().get(i).getAtk();

				int hpnuovi = this.getListaDigimonCreatore().get(i).getHp()
						- ((danni - this.getListaDigimonCreatore().get(i).getDef())
								* ((this.getListaDigimonCreatore().get(i).getRes()) / 100));

				this.getListaDigimonCreatore().get(i).setHp(hpnuovi);

			}

			if (this.getListaDigimonCreatore().get(i).getTipo() == "acqua") {
				int danni = (int) this.getListaDigimonSfidante().get(i).getAtk() / 2;

				int hpnuovi = this.getListaDigimonCreatore().get(i).getHp()
						- ((danni - this.getListaDigimonCreatore().get(i).getDef())
								* ((this.getListaDigimonCreatore().get(i).getRes()) / 100));

				this.getListaDigimonCreatore().get(i).setHp(hpnuovi);

			}

			if (this.getListaDigimonCreatore().get(i).getTipo() == "terra") {
				int danni = (int) this.getListaDigimonSfidante().get(i).getAtk() * 2;

				int hpnuovi = this.getListaDigimonCreatore().get(i).getHp()
						- ((danni - this.getListaDigimonCreatore().get(i).getDef())
								* ((this.getListaDigimonCreatore().get(i).getRes()) / 100));

				this.getListaDigimonCreatore().get(i).setHp(hpnuovi);

			}

		}

		// aria DANNI NORMALI fuoco aria DANNI SFAVOREVOLI terra DANNI FAVOREVOLI acqua

		else if (this.getListaDigimonSfidante().get(i).getTipo() == "aria") {

			if (this.getListaDigimonCreatore().get(i).getTipo() == "fuoco"
					|| this.getListaDigimonCreatore().get(i).getTipo() == "aria") {
				int danni = this.getListaDigimonSfidante().get(i).getAtk();

				int hpnuovi = this.getListaDigimonCreatore().get(i).getHp()
						- ((danni - this.getListaDigimonCreatore().get(i).getDef())
								* ((this.getListaDigimonCreatore().get(i).getRes()) / 100));

				this.getListaDigimonCreatore().get(i).setHp(hpnuovi);

			}

			if (this.getListaDigimonCreatore().get(i).getTipo() == "terra") {
				int danni = (int) this.getListaDigimonSfidante().get(i).getAtk() / 2;

				int hpnuovi = this.getListaDigimonCreatore().get(i).getHp()
						- ((danni - this.getListaDigimonCreatore().get(i).getDef())
								* ((this.getListaDigimonCreatore().get(i).getRes()) / 100));

				this.getListaDigimonCreatore().get(i).setHp(hpnuovi);

			}

			if (this.getListaDigimonCreatore().get(i).getTipo() == "acqua") {
				int danni = (int) this.getListaDigimonSfidante().get(0).getAtk() * 2;

				int hpnuovi = this.getListaDigimonCreatore().get(i).getHp()
						- ((danni - this.getListaDigimonCreatore().get(i).getDef())
								* ((this.getListaDigimonCreatore().get(i).getRes()) / 100));

				this.getListaDigimonCreatore().get(i).setHp(hpnuovi);

			}

		}

		// terra DANNI NORMALI acqua terra DANNI SFAVOREVOLI fuoco DANNI FAVOREVOLI aria

		else if (this.getListaDigimonSfidante().get(i).getTipo() == "terra") {

			if (this.getListaDigimonCreatore().get(i).getTipo() == "acqua"
					|| this.getListaDigimonCreatore().get(i).getTipo() == "terra") {
				int danni = this.getListaDigimonSfidante().get(i).getAtk();

				int hpnuovi = this.getListaDigimonCreatore().get(i).getHp()
						- ((danni - this.getListaDigimonCreatore().get(i).getDef())
								* ((this.getListaDigimonCreatore().get(i).getRes()) / 100));

				this.getListaDigimonCreatore().get(i).setHp(hpnuovi);

			}

			if (this.getListaDigimonCreatore().get(i).getTipo() == "fuoco") {
				int danni = (int) this.getListaDigimonSfidante().get(i).getAtk() / 2;

				int hpnuovi = this.getListaDigimonCreatore().get(i).getHp()
						- ((danni - this.getListaDigimonCreatore().get(i).getDef())
								* ((this.getListaDigimonCreatore().get(i).getRes()) / 100));

				this.getListaDigimonCreatore().get(i).setHp(hpnuovi);

			}

			if (this.getListaDigimonCreatore().get(i).getTipo() == "aria") {
				int danni = (int) this.getListaDigimonSfidante().get(i).getAtk() * 2;

				int hpnuovi = this.getListaDigimonCreatore().get(i).getHp()
						- ((danni - this.getListaDigimonCreatore().get(i).getDef())
								* ((this.getListaDigimonCreatore().get(i).getRes()) / 100));

				this.getListaDigimonCreatore().get(i).setHp(hpnuovi);

			}

		}

		if (this.getListaDigimonCreatore().get(i).getHp() == 0) {
			System.out.println(this.getListaDigimonSfidante().get(i) + " ha vinto contro "
					+ this.getListaDigimonCreatore().get(i));
		}

		else if (this.getListaDigimonSfidante().get(i).getHp() == 0) {
			System.out.println(this.getListaDigimonCreatore().get(i) + " ha vinto contro "
					+ this.getListaDigimonSfidante().get(i));
		}

	}

	@Override
	public String toString() {
		return "GestioneTurniDigimon [listaDigimonCreatore=" + listaDigimonCreatore + ", listaDigimonSfidante="
				+ listaDigimonSfidante + "]";
	}

}
