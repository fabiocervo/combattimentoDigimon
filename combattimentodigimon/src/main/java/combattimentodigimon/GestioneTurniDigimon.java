package combattimentodigimon;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GestioneTurniDigimon {

	private List<Digimon> listaDigimonCreatore;
	private List<Digimon> listaDigimonSfidante;

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

	public Digimon impostazioneAttaccoDifesa(Gestione g, int idPartita, String idUtente) throws SQLException {

		if (g.checkUtente(idPartita).equals(idUtente)) {
			String digi1 = getListaDigimonCreatore().get(0).getNome();

			g.popolamentoArenaAttacco(idPartita, digi1, idUtente);

			return getListaDigimonCreatore().get(0);

		} else {
			String digi4 = getListaDigimonSfidante().get(0).getNome();

			g.popolamentoArenaDifesa(digi4, idPartita);
			return getListaDigimonSfidante().get(0);
		}

	}

	public void gestioneLottaCreatore(Digimon digimon1, Digimon digimon2) {

		// acqua DANNI NORMALI terra acqua DANNI SFAVOREVOLI aria DANNI FAVOREVOLI fuoco

		System.out.println(digimon1.getNome() + "VS" + digimon2.getNome());

		if (digimon1.getTipo().equals("acqua")) {
			if (digimon2.getTipo().equals("acqua") || digimon2.getTipo().equals("terra")) {
				int danni = digimon1.getAtk();

				int hpnuovi = digimon2.getHp() - ((danni - digimon2.getDef()) * ((digimon2.getRes()) / 100));

				digimon2.setHp(hpnuovi);
				System.out.println(digimon2.getHp());

			}

			if (digimon2.getTipo().equals("aria")) {
				int danni = (int) digimon1.getAtk() / 2;

				int hpnuovi = digimon2.getHp() - ((danni - digimon2.getDef()) * ((digimon2.getRes()) / 100));

				digimon2.setHp(hpnuovi);
				System.out.println(digimon2.getHp());
			}

			if (digimon2.getTipo().equals("fuoco")) {
				int danni = (int) digimon1.getAtk() * 2;

				int hpnuovi = digimon2.getHp() - ((danni - digimon2.getDef()) * ((digimon2.getRes()) / 100));

				digimon2.setHp(hpnuovi);
				System.out.println(digimon2.getHp());
			}

		}

		// fuoco DANNI NORMALI aria fuoco DANNI SFAVOREVOLI acqua DANNI FAVOREVOLI terra
		else if (digimon1.getTipo().equals("fuoco")) {
			if (digimon2.getTipo().equals("aria") || digimon2.getTipo().equals("fuoco")) {
				int danni = digimon1.getAtk();

				int hpnuovi = digimon2.getHp() - ((danni - digimon2.getDef()) * ((digimon2.getRes()) / 100));

				digimon2.setHp(hpnuovi);
				System.out.println(digimon2.getHp());

			}

			if (digimon2.getTipo().equals("acqua")) {
				int danni = (int) digimon1.getAtk() / 2;

				int hpnuovi = digimon2.getHp() - ((danni - digimon2.getDef()) * ((digimon2.getRes()) / 100));

				digimon2.setHp(hpnuovi);
				System.out.println(digimon2.getHp());
			}

			if (digimon2.getTipo().equals("terra")) {
				int danni = (int) digimon1.getAtk() * 2;

				int hpnuovi = digimon2.getHp() - ((danni - digimon2.getDef()) * ((digimon2.getRes()) / 100));

				digimon2.setHp(hpnuovi);
				System.out.println(digimon2.getHp());
			}
		}

		// aria DANNI NORMALI fuoco aria DANNI SFAVOREVOLI terra DANNI FAVOREVOLI acqua

		else if (digimon1.getTipo().equals("aria")) {
			if (digimon2.getTipo().equals("fuoco") || digimon2.getTipo().equals("aria")) {
				int danni = digimon1.getAtk();

				int hpnuovi = digimon2.getHp() - ((danni - digimon2.getDef()) * ((digimon2.getRes()) / 100));

				digimon2.setHp(hpnuovi);
				System.out.println(digimon2.getHp());

			}

			if (digimon2.getTipo().equals("terra")) {
				int danni = (int) digimon1.getAtk() / 2;

				int hpnuovi = digimon2.getHp() - ((danni - digimon2.getDef()) * ((digimon2.getRes()) / 100));

				digimon2.setHp(hpnuovi);
				System.out.println(digimon2.getHp());
			}

			if (digimon2.getTipo().equals("acqua")) {
				int danni = (int) digimon1.getAtk() * 2;

				int hpnuovi = digimon2.getHp() - ((danni - digimon2.getDef()) * ((digimon2.getRes()) / 100));

				digimon2.setHp(hpnuovi);
				System.out.println(digimon2.getHp());
			}

		}

		// terra DANNI NORMALI acqua terra DANNI SFAVOREVOLI fuoco DANNI FAVOREVOLI aria

		else if (digimon1.getTipo().equals("terra")) {
			if (digimon2.getTipo().equals("acqua") || digimon2.getTipo().equals("terra")) {
				int danni = digimon1.getAtk();

				int hpnuovi = digimon2.getHp() - ((danni - digimon2.getDef()) * ((digimon2.getRes()) / 100));

				digimon2.setHp(hpnuovi);
				System.out.println(digimon2.getHp());

			}

			if (digimon2.getTipo().equals("fuoco")) {
				int danni = (int) digimon1.getAtk() / 2;

				int hpnuovi = digimon2.getHp() - ((danni - digimon2.getDef()) * ((digimon2.getRes()) / 100));

				digimon2.setHp(hpnuovi);
				System.out.println(digimon2.getHp());
			}

			if (digimon2.getTipo().equals("aria")) {
				int danni = (int) digimon1.getAtk() * 2;

				int hpnuovi = digimon2.getHp() - ((danni - digimon2.getDef()) * ((digimon2.getRes()) / 100));

				digimon2.setHp(hpnuovi);
				System.out.println(digimon2.getHp());
			}

		}

		/*
		 * /if (this.getListaDigimonSfidante().get(i).getHp() == 0) {
		 * System.out.println(this.getListaDigimonCreatore().get(i) +
		 * " ha vinto contro " + this.getListaDigimonSfidante().get(i)); }
		 * 
		 * else if (this.getListaDigimonCreatore().get(i).getHp() == 0) {
		 * System.out.println(this.getListaDigimonSfidante().get(i) +
		 * " ha vinto contro " + this.getListaDigimonCreatore().get(i)); }
		 */

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
				System.out.println(this.getListaDigimonCreatore().get(i).getHp());
			}

			if (this.getListaDigimonCreatore().get(i).getTipo() == "aria") {
				int danni = (int) this.getListaDigimonSfidante().get(i).getAtk() / 2;

				int hpnuovi = this.getListaDigimonCreatore().get(i).getHp()
						- ((danni - this.getListaDigimonCreatore().get(i).getDef())
								* ((this.getListaDigimonCreatore().get(i).getRes()) / 100));

				this.getListaDigimonCreatore().get(i).setHp(hpnuovi);
				System.out.println(this.getListaDigimonCreatore().get(i).getHp());
			}

			if (this.getListaDigimonCreatore().get(i).getTipo() == "fuoco") {
				int danni = (int) this.getListaDigimonSfidante().get(i).getAtk() * 2;

				int hpnuovi = this.getListaDigimonCreatore().get(i).getHp()
						- ((danni - this.getListaDigimonCreatore().get(i).getDef())
								* ((this.getListaDigimonCreatore().get(i).getRes()) / 100));

				this.getListaDigimonCreatore().get(i).setHp(hpnuovi);
				System.out.println(this.getListaDigimonCreatore().get(i).getHp());
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
				System.out.println(this.getListaDigimonCreatore().get(i).getHp());
			}

			if (this.getListaDigimonCreatore().get(i).getTipo() == "acqua") {
				int danni = (int) this.getListaDigimonSfidante().get(i).getAtk() / 2;

				int hpnuovi = this.getListaDigimonCreatore().get(i).getHp()
						- ((danni - this.getListaDigimonCreatore().get(i).getDef())
								* ((this.getListaDigimonCreatore().get(i).getRes()) / 100));

				this.getListaDigimonCreatore().get(i).setHp(hpnuovi);
				System.out.println(this.getListaDigimonCreatore().get(i).getHp());
			}

			if (this.getListaDigimonCreatore().get(i).getTipo() == "terra") {
				int danni = (int) this.getListaDigimonSfidante().get(i).getAtk() * 2;

				int hpnuovi = this.getListaDigimonCreatore().get(i).getHp()
						- ((danni - this.getListaDigimonCreatore().get(i).getDef())
								* ((this.getListaDigimonCreatore().get(i).getRes()) / 100));

				this.getListaDigimonCreatore().get(i).setHp(hpnuovi);
				System.out.println(this.getListaDigimonCreatore().get(i).getHp());
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
				System.out.println(this.getListaDigimonCreatore().get(i).getHp());
			}

			if (this.getListaDigimonCreatore().get(i).getTipo() == "terra") {
				int danni = (int) this.getListaDigimonSfidante().get(i).getAtk() / 2;

				int hpnuovi = this.getListaDigimonCreatore().get(i).getHp()
						- ((danni - this.getListaDigimonCreatore().get(i).getDef())
								* ((this.getListaDigimonCreatore().get(i).getRes()) / 100));

				this.getListaDigimonCreatore().get(i).setHp(hpnuovi);
				System.out.println(this.getListaDigimonCreatore().get(i).getHp());
			}

			if (this.getListaDigimonCreatore().get(i).getTipo() == "acqua") {
				int danni = (int) this.getListaDigimonSfidante().get(0).getAtk() * 2;

				int hpnuovi = this.getListaDigimonCreatore().get(i).getHp()
						- ((danni - this.getListaDigimonCreatore().get(i).getDef())
								* ((this.getListaDigimonCreatore().get(i).getRes()) / 100));

				this.getListaDigimonCreatore().get(i).setHp(hpnuovi);
				System.out.println(this.getListaDigimonCreatore().get(i).getHp());
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
				System.out.println(this.getListaDigimonCreatore().get(i).getHp());
			}

			if (this.getListaDigimonCreatore().get(i).getTipo() == "fuoco") {
				int danni = (int) this.getListaDigimonSfidante().get(i).getAtk() / 2;

				int hpnuovi = this.getListaDigimonCreatore().get(i).getHp()
						- ((danni - this.getListaDigimonCreatore().get(i).getDef())
								* ((this.getListaDigimonCreatore().get(i).getRes()) / 100));

				this.getListaDigimonCreatore().get(i).setHp(hpnuovi);
				System.out.println(this.getListaDigimonCreatore().get(i).getHp());
			}

			if (this.getListaDigimonCreatore().get(i).getTipo() == "aria") {
				int danni = (int) this.getListaDigimonSfidante().get(i).getAtk() * 2;

				int hpnuovi = this.getListaDigimonCreatore().get(i).getHp()
						- ((danni - this.getListaDigimonCreatore().get(i).getDef())
								* ((this.getListaDigimonCreatore().get(i).getRes()) / 100));

				this.getListaDigimonCreatore().get(i).setHp(hpnuovi);
				System.out.println(this.getListaDigimonCreatore().get(i).getHp());
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
