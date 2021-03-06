package combattimentodigimon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gestione {
	private Connection connessione;

	public Connection getConnessione() {
		return connessione;
	}

	public void setConnessione(Connection connessione) {
		this.connessione = connessione;
	}

	public Gestione() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String password = "EzJ90IaSaP";
		String username = "ExmDFToJYb";
		String url = "jdbc:mysql://remotemysql.com:3306/ExmDFToJYb?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC&createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true&useSSL=false";
		this.connessione = DriverManager.getConnection(url, username, password);
	}

	public String chiamaCreatore(Scanner scanner) throws SQLException {
		PreparedStatement prepareStatement = getConnessione()
				.prepareStatement("select distinct idutente from digimon;");
		ResultSet executeQuery = prepareStatement.executeQuery();
		while (executeQuery.next()) {
			String id = executeQuery.getString(1);
			System.out.println(id);
		}
		System.out.println("indica l'id del creatore della partita");
		String idCreatorePartita = scanner.nextLine();
		return idCreatorePartita;
	}

	public String chiamaSfidante(Scanner scanner) throws SQLException {
		PreparedStatement prepareStatement = getConnessione()
				.prepareStatement("select distinct idutente from digimon;");
		ResultSet executeQuery = prepareStatement.executeQuery();
		while (executeQuery.next()) {
			String id = executeQuery.getString(1);
			System.out.println(id);
		}
		System.out.println("indica l'id dello sfidante della partita");
		String idSfidantePartita = scanner.nextLine();
		return idSfidantePartita;
	}

	public void creaPartitaPerCreatore(Scanner scanner) throws SQLException {
		System.out.println("dammi la password per accedere alla partita");
		String password = scanner.nextLine();
		PreparedStatement prepareStatement = getConnessione()
				.prepareStatement("select id, nome from digimon where idutente = ?;");
		prepareStatement.setString(1, chiamaCreatore(scanner));
		ResultSet executeQuery = prepareStatement.executeQuery();
		while (executeQuery.next()) {
			Integer idDigimon = executeQuery.getInt(1);
			String nomeDigimon = executeQuery.getString(2);
			System.out.println(idDigimon + " " + nomeDigimon);
		}
		System.out.println("indica 3 digimon da selezionare");
		Integer posizione1 = scanner.nextInt();
		Integer posizione2 = scanner.nextInt();
		Integer posizione3 = scanner.nextInt();
		scanner.nextLine();
		Partita g1 = new Partita(password, chiamaCreatore(scanner), posizione1, posizione2, posizione3);
		System.out.println(g1);
		popolamentoPartitaCreatore(g1);
	}

	public void uniscitiAllaPartita(Scanner scanner) throws SQLException {
		System.out.println("dammi la password per accedere alla partita");
		String password = scanner.nextLine();
		PreparedStatement prepareStatement2 = getConnessione()
				.prepareStatement("select id, nome from digimon where idutente = ?;");
		prepareStatement2.setString(1, chiamaSfidante(scanner));
		ResultSet executeQuery2 = prepareStatement2.executeQuery();
		while (executeQuery2.next()) {
			Integer idDigimon2 = executeQuery2.getInt(1);
			String nomeDigimon2 = executeQuery2.getString(2);
			System.out.println(idDigimon2 + " " + nomeDigimon2);
		}
		System.out.println("indica 3 digimon da selezionare");
		Integer posizione4 = scanner.nextInt();
		Integer posizione5 = scanner.nextInt();
		Integer posizione6 = scanner.nextInt();
		scanner.nextLine();
		Partita g2 = new Partita(password, chiamaSfidante(scanner), posizione4, posizione5, posizione6);
		System.out.println(g2);
		popolamentoPartitaSfidante(g2, scanner);
	}

	public void popolamentoPartitaCreatore(Partita p) throws SQLException {
		String queryInserimentoDigimon = "INSERT INTO partite (idcreatore, password, dc1, dc2, dc3) VALUES (?, ?, ?, ?, ?);";
		PreparedStatement prepareStatement = getConnessione().prepareStatement(queryInserimentoDigimon);
		prepareStatement.setString(1, p.getIdGiocatore());
		prepareStatement.setString(2, p.getPassword());
		prepareStatement.setInt(3, p.getDigi1());
		prepareStatement.setInt(4, p.getDigi2());
		prepareStatement.setInt(5, p.getDigi3());
		prepareStatement.execute();
	}

	public void popolamentoPartitaSfidante(Partita p, Scanner scanner) throws SQLException {

		if (checkPassword(p)) {
			PreparedStatement prepareStatement = getConnessione()
					.prepareStatement("select idpartita, password from partite;");
			ResultSet executeQuery = prepareStatement.executeQuery();
			while (executeQuery.next()) {
				int id = executeQuery.getInt(1);
				String password = executeQuery.getString(2);
				System.out.println(id + ". " + password);
			}
			System.out.println("qual � l 'id ?");
			int id = scanner.nextInt();
			scanner.nextLine();
			String queryInserimentoDigimon = "UPDATE partite set idsfidante = ?, ds1 = ?, ds2 = ?, ds3 = ? where idpartita = ?;";
			PreparedStatement prepareStatement2 = getConnessione().prepareStatement(queryInserimentoDigimon);
			prepareStatement2.setString(1, p.getIdGiocatore());
			prepareStatement2.setInt(2, p.getDigi1());
			prepareStatement2.setInt(3, p.getDigi2());
			prepareStatement2.setInt(4, p.getDigi3());
			prepareStatement2.setInt(5, id);
			prepareStatement2.execute();

		}

	}

	public boolean checkPassword(Partita p) throws SQLException {
		PreparedStatement prepareStatement = getConnessione()
				.prepareStatement("Select password from partite where password = ? ;");
		prepareStatement.setString(1, p.getPassword());
		ResultSet risultato = prepareStatement.executeQuery();
		while (risultato.next()) {
			if (p.getPassword().equals(risultato.getString("password"))) {
				return true;
			}
		}
		return false;
	}

	public Utente creaUtente(Scanner scanner) throws SQLException {
		System.out.println("dammi l'id utente");
		String id = scanner.nextLine();
		System.out.println("dammi il nome utente");
		String nome = scanner.nextLine();
		Utente u = new Utente(id, nome);
		if (controlloUtente(u)) {
			popolamentoUtente(u);
		} else {
			System.out.println("Utente gi� esistente");
		}
		return u;
	}

	public boolean controlloUtente(Utente u) throws SQLException {
		PreparedStatement prepareStatement = getConnessione().prepareStatement("Select id from utenti where id = ? ;");
		prepareStatement.setString(1, u.getId());
		ResultSet risultato = prepareStatement.executeQuery();
		while (risultato.next()) {
			if (u.getId().equals(risultato.getString("id"))) {
				return false;
			}
		}
		return true;
	}

	public void popolamentoUtente(Utente u) throws SQLException {
		String queryInserimentoUtente = "INSERT INTO utenti (id, nome) VALUES (?, ?);";
		PreparedStatement prepareStatement = getConnessione().prepareStatement(queryInserimentoUtente);
		prepareStatement.setString(1, u.getId());
		prepareStatement.setString(2, u.getNome());
		prepareStatement.execute();
	}

	public Digimon creaDigimon(Scanner scanner, GestioneCaratteristicheDigimon g) throws SQLException {
		System.out.println("dammi il nome del digimon");
		String nome = scanner.nextLine();
		System.out.println("dammi l'evoluzione del digimon");
		String evo = scanner.nextLine();
		System.out.println("dammi il tipo del digimon");
		String tipo = scanner.nextLine();
		Digimon d1 = new Digimon(nome, g.calcoloAttacco(), g.calcoloDifesa(), g.calcoloRes(), g.calcoloHp(), evo, tipo,
				prendiProprietario(scanner));
		System.out.println(d1);
		popolamentoDigimon(d1);
		return d1;

	}

	public String prendiProprietario(Scanner scanner) throws SQLException {
		PreparedStatement prepareStatement = getConnessione().prepareStatement("select distinct id, nome from utenti;");
		ResultSet executeQuery = prepareStatement.executeQuery();
		while (executeQuery.next()) {
			String id = executeQuery.getString(1);
			String nome = executeQuery.getString(2);
			System.out.println(id + " " + nome);
		}
		System.out.println("indica l'id da selezionare");
		String posizione = scanner.nextLine();
		return posizione;
	}

	public void popolamentoDigimon(Digimon digimon) throws SQLException {
		String queryInserimentoDigimon = "INSERT INTO digimon (nome, hp, atk, def, res, evo, tipo, idutente) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
		PreparedStatement prepareStatement = getConnessione().prepareStatement(queryInserimentoDigimon);
		prepareStatement.setString(1, digimon.getNome());
		prepareStatement.setInt(2, digimon.getHp());
		prepareStatement.setInt(3, digimon.getAtk());
		prepareStatement.setInt(4, digimon.getDef());
		prepareStatement.setInt(5, digimon.getRes());
		prepareStatement.setString(6, digimon.getEvo());
		prepareStatement.setString(7, digimon.getTipo());
		prepareStatement.setString(8, digimon.getProprietario());
		prepareStatement.execute();
	}

	public void chiamaPartita(GestioneTurniDigimon g, int idPartita) throws SQLException, ClassNotFoundException {
		PreparedStatement statement = getConnessione()
				.prepareStatement("SELECT idcreatore,idsfidante FROM ExmDFToJYb.partite where idpartita = ?;");
		statement.setInt(1, idPartita);
		ResultSet risultato = statement.executeQuery();
		while (risultato.next()) {
			String idcreatore = risultato.getString(1);
			String idsfidante = risultato.getString(2);
			System.out.println(idcreatore + " " + idsfidante);
		
		    
		}
	}

	public void chiamaPartitaSfidante(GestioneTurniDigimon g, int idpartita)
			throws SQLException, ClassNotFoundException {
		PreparedStatement statement = getConnessione()
				.prepareStatement("SELECT idcreatore,idsfidante FROM ExmDFToJYb.partite where idpartita = ?;");
		statement.setInt(1, idpartita);
		ResultSet risultato = statement.executeQuery();
		while (risultato.next()) {
			String idcreatore = risultato.getString(1);
			String idsfidante = risultato.getString(2);
			System.out.println(idcreatore + " " + idsfidante);
		

		}

	}

	/*public void riempimentoListaCreatore(int id, GestioneTurniDigimon g, String idcreatore)
			throws SQLException, ClassNotFoundException {

		PreparedStatement prepareStatement = getConnessione().prepareStatement(
				"SELECT digimon.*  from partite inner join digimon on digimon.idutente = ? and partite.idpartita = ?;");

		prepareStatement.setString(1, idcreatore);
		prepareStatement.setInt(2, id);
		ResultSet risultato2 = prepareStatement.executeQuery();
		while (risultato2.next()) {
			String idCreatore = risultato2.getString(9);
			String nome = risultato2.getString(2);
			int attacco = risultato2.getInt(4);
			int difesa = risultato2.getInt(5);
			int res = risultato2.getInt(6);
			int hp = risultato2.getInt(3);
			String evo = risultato2.getString(7);
			String tipo = risultato2.getString(8);

			Digimon d = new Digimon(nome, attacco, difesa, res, hp, evo, tipo, idCreatore);
			g.getListaDigimonCreatore().add(d);

			System.out.println(g.getListaDigimonCreatore());
		}

	}*/

/*	public void riempimentoListaSfidante(int id, GestioneTurniDigimon g, String idsfidante)
			throws SQLException, ClassNotFoundException {

		PreparedStatement prepareStatement = getConnessione().prepareStatement(
				"SELECT digimon.*  from partite inner join digimon on digimon.idutente = ? and partite.idpartita = ?;");
		prepareStatement.setString(1, idsfidante);
		prepareStatement.setInt(2, id);
		ResultSet risultato2 = prepareStatement.executeQuery();
		while (risultato2.next()) {
			String nome = risultato2.getString(2);
			int hp = risultato2.getInt(3);
			int attacco = risultato2.getInt(4);
			int difesa = risultato2.getInt(5);
			int res = risultato2.getInt(6);
			String evo = risultato2.getString(7);
			String tipo = risultato2.getString(8);
			String idSfidante = risultato2.getString(9);

			Digimon d = new Digimon(nome, attacco, difesa, res, hp, evo, tipo, idSfidante);
			g.getListaDigimonSfidante().add(d);

			System.out.println(g.getListaDigimonSfidante());
		}

	}*/
    public void listaDigimonPartita(int idPartita, GestioneTurniDigimon gT) throws SQLException, ClassNotFoundException{
    	PreparedStatement prepareStatement = getConnessione().prepareStatement("SELECT dc1, dc2, dc3, ds1, ds2, ds3 from partite where partite.idpartita = ?;");
		prepareStatement.setInt(1, idPartita);
		ResultSet risultato2 = prepareStatement.executeQuery();
		List<Integer> listaId = new ArrayList<>();
		while (risultato2.next()) {
			int dc1 = risultato2.getInt(1);
			int dc2 = risultato2.getInt(2);
			int dc3 = risultato2.getInt(3);
			int ds1 = risultato2.getInt(4);
			int ds2 = risultato2.getInt(5);
			int ds3 = risultato2.getInt(6);
			listaId.add(dc1);
			listaId.add(dc2);
			listaId.add(dc3);
			listaId.add(ds1);
			listaId.add(ds2);
			listaId.add(ds3);
			riempiListaDigimonPartita(idPartita, listaId, gT);
		}
	
    }
    public void riempiListaDigimonPartita(int idPartita, List<Integer> lista, GestioneTurniDigimon gT)throws SQLException, ClassNotFoundException{
    	for (int i = 0; i < lista.size(); i++) {
			PreparedStatement prepareStatement = getConnessione().prepareStatement("SELECT digimon.*  from partite inner join digimon on digimon.id = ? where partite.idpartita = ?");
    	prepareStatement.setInt(1, lista.get(i));
		prepareStatement.setInt(2, idPartita);
		ResultSet risultato2 = prepareStatement.executeQuery();
		while (risultato2.next()) {
			String nome = risultato2.getString(2);
			int hp = risultato2.getInt(3);
			int attacco = risultato2.getInt(4);
			int difesa = risultato2.getInt(5);
			int res = risultato2.getInt(6);
			String evo = risultato2.getString(7);
			String tipo = risultato2.getString(8);
			String idUtente = risultato2.getString(9);

			Digimon d = new Digimon(nome, attacco, difesa, res, hp, evo, tipo, idUtente);
			gT.getListaDigimon().add(d);
			System.out.println(gT.getListaDigimon());
		}
		}
    	
    }
	public void stampaIdPartita(String idCreatore) throws SQLException {
		PreparedStatement statement = getConnessione().prepareStatement(
				"select utenti.nome,partite.idpartita from utenti inner join partite on utenti.id = partite.idcreatore where idcreatore =? or idsfidante=?;");
		statement.setString(1, idCreatore);
		statement.setString(2, idCreatore);
		ResultSet risultato = statement.executeQuery();
		while (risultato.next()) {
			System.out.println(risultato.getString(1) + " " + risultato.getInt(2));
		}

	}

	public void stampaIdPartitaSfidante(String idSfidante) throws SQLException {
		PreparedStatement statement = getConnessione().prepareStatement(
				"select utenti.nome,partite.idpartita from utenti inner join partite on utenti.id = partite.idsfidante where idcreatore =? or idsfidante=?;");
		statement.setString(1, idSfidante);
		statement.setString(2, idSfidante);
		ResultSet risultato = statement.executeQuery();
		while (risultato.next()) {
			System.out.println(risultato.getString(1) + " " + risultato.getInt(2));
		}

	}

	public String checkUtente(int idPartita) throws SQLException {
		PreparedStatement stat = getConnessione()
				.prepareStatement("select idcreatore from partite where idpartita = ?;");
		stat.setInt(1, idPartita);
		ResultSet ris = stat.executeQuery();
		while (ris.next()) {
			String idCreatore = ris.getString(1);
			return idCreatore;
		}
		return null;
	}

	public String gestisciMossaArena(int idpartita) throws SQLException {
		PreparedStatement statement = getConnessione()
				.prepareStatement("select turno, max(idmossa) from arena where idpartita = ? group by turno;");
		statement.setInt(1, idpartita);

		ResultSet risultato = statement.executeQuery();
		while (risultato.next()) {

			String idGiocatore = risultato.getString(2);
			return idGiocatore;
		}
		return null;

	}

	public void popolamentoArenaAttacco(int idPartita, String nomeDigimon, String idUtente) throws SQLException {
		String queryInserimentoDigimon = "INSERT INTO arena (idpartita, turno, attacco) VALUES (?, ?, ?);";
		PreparedStatement prepareStatement = getConnessione().prepareStatement(queryInserimentoDigimon);
		prepareStatement.setInt(1, idPartita);
		prepareStatement.setString(2, idUtente);
		prepareStatement.setString(3, nomeDigimon);
		prepareStatement.execute();
	}

	public void popolamentoArenaDifesa(String nomeDigimon, int idPartita) throws SQLException {
		String queryInserimentoDigimon = "UPDATE arena set difesa = ? where idpartita = ?;";
		PreparedStatement prepareStatement = getConnessione().prepareStatement(queryInserimentoDigimon);
		prepareStatement.setInt(2, idPartita);
		prepareStatement.setString(1, nomeDigimon);
		prepareStatement.execute();
	}
	
}
