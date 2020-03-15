package combattimentodigimon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MainCreazione {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Scanner scanner = new Scanner(System.in);
		GestioneCombattimentoDigimon g = new GestioneCombattimentoDigimon();
		Class.forName("com.mysql.cj.jdbc.Driver");
		String password = "EzJ90IaSaP";
		String username = "ExmDFToJYb";
		String url = "jdbc:mysql://remotemysql.com:3306/ExmDFToJYb?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC&createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true&useSSL=false";
		Connection connessione = DriverManager.getConnection(url, username, password);

		while (true) {

			menu();
			System.out.println("cosa vuoi fare?");
			int scegli = scanner.nextInt();
			scanner.nextLine();

			switch (scegli) {
			case 1: {

				creaUtente(scanner, connessione);

				break;
			}

			case 2: {

				creaDigimon(scanner, g, connessione);
				

				break;
			}

			case 3: {

				creaPartitaPerCreatore(connessione, scanner);

				break;
			}
			
			case 4: {
				
				break;
			}

			default: {
				scanner.close();
				System.exit(0);
			}
			}
		}

	}

	

	private static void menu() {
		System.out.println("###########################");
		System.out.println("1. crea utente");
		System.out.println("2. crea digimon e scegli il suo proprietario");
		System.out.println("3. crea partita");

	}
	
	public static String chiamaCreatore(Connection connessione, Scanner scanner)throws SQLException {
		PreparedStatement prepareStatement = connessione.prepareStatement("select distinct idutente from digimon;");
		ResultSet executeQuery = prepareStatement.executeQuery();
		List<String>listaUtenti = new ArrayList<>();
		while (executeQuery.next()) {
			String id = executeQuery.getString(1);
			listaUtenti.add(id);
		}
		System.out.println("indica l'id del creatore della partita");
	
		for (String string : listaUtenti) {
			System.out.println(string);
		}
		
		String idCreatorePartita = scanner.nextLine();
		
		if (listaUtenti.contains(idCreatorePartita)) {
			
			return idCreatorePartita;
		}
		
		else {
			System.out.println("riprova");
			return null;
		}
	
	}
	
	public static String chiamaSfidante(Connection connessione, Scanner scanner)throws SQLException {
		PreparedStatement prepareStatement = connessione.prepareStatement("select distinct idutente from digimon;");
		ResultSet executeQuery = prepareStatement.executeQuery();
		List<String>listaUtenti = new ArrayList<>();
		while (executeQuery.next()) {
			String id = executeQuery.getString(1);
			listaUtenti.add(id);
		}
		System.out.println("indica l'id dello sfidante della partita");
	
		for (String string : listaUtenti) {
			System.out.println(string);
		}
		
		String idSfidantePartita = scanner.nextLine();
		
		if (listaUtenti.contains(idSfidantePartita)) {
			
			return idSfidantePartita;
		}
		
		else {
			System.out.println("riprova");
			return null;
		}
	
	}
	
	
	
	private static void creaPartitaPerCreatore(Connection connessione, Scanner scanner) throws SQLException {
		System.out.println("dammi la password per accedere alla partita");
		String password = scanner.nextLine();
		
		
		PreparedStatement prepareStatement = connessione.prepareStatement("select utenti.id,digimon.id,digimon.nome from utenti inner join digimon on digimon.idutente = ?;");
		prepareStatement.setString(1, chiamaCreatore(connessione, scanner));
		ResultSet executeQuery = prepareStatement.executeQuery();
		Map<Integer, String> mappaDigimon = new HashMap<Integer, String>();
		while (executeQuery.next()) {
			Integer idDigimon = executeQuery.getInt(2);
			String nomeDigimon = executeQuery.getString(3);
			mappaDigimon.put(idDigimon, nomeDigimon);
		}
		System.out.println("indica 3 digimon da selezionare");
		for (Integer key : mappaDigimon.keySet()) {
			System.out.println(key);
		}
		
		Integer posizione1 = scanner.nextInt();
		Integer posizione2 = scanner.nextInt();
		Integer posizione3 = scanner.nextInt();
		scanner.nextLine();

		
		
		Partita g1 = new Partita(password, chiamaCreatore(connessione, scanner), posizione1, posizione2, posizione3);
		
		System.out.println(g1);
		
		creaPartitaSfidante(connessione, scanner, g1);
	
	
			popolamentoPartita();
		
		
		
	}
	
	private static void creaPartitaSfidante(Connection connessione, Scanner scanner, Partita p) throws SQLException{
		System.out.println("dammi la password per accedere alla partita");
		String password = scanner.nextLine();
		
		if (p.getPassword().equals(password)) {
			
		
		
		
		PreparedStatement prepareStatement2 = connessione.prepareStatement("select utenti.id,digimon.id,digimon.nome from utenti inner join digimon on digimon.idutente = ?;");
		prepareStatement2.setString(1, chiamaSfidante(connessione, scanner));
		ResultSet executeQuery2 = prepareStatement2.executeQuery();
		Map<Integer, String> mappaDigimon2 = new HashMap<Integer, String>();
		while (executeQuery2.next()) {
			Integer idDigimon2 = executeQuery2.getInt(2);
			String nomeDigimon2 = executeQuery2.getString(3);
			mappaDigimon2.put(idDigimon2, nomeDigimon2);
		}
		System.out.println("indica 3 digimon da selezionare");
		for (Integer key : mappaDigimon2.keySet()) {
			System.out.println(key);
		}
		Integer posizione4 = scanner.nextInt();
		Integer posizione5 = scanner.nextInt();
		Integer posizione6 = scanner.nextInt();
		scanner.nextLine();
		
		Partita g2 = new Partita(password, chiamaSfidante(connessione, scanner), posizione4, posizione5, posizione6);
		System.out.println(g2);
		
		}
		
		else {
			System.out.println("password errata non puoi entrare nella partita");
		}
		
		
	}


/*	private static String chiamaDigimonGiocatore1(Connection connessione, Scanner scanner) throws SQLException, ClassNotFoundException{
		PreparedStatement prepareStatement = connessione.prepareStatement("select utenti.id,digimon.nome from utenti inner join digimon on digimon.idutente = ?;");
		String giocatore = chiamaGiocatori(connessione, scanner);
		prepareStatement.setString(1, giocatore);
		ResultSet executeQuery = prepareStatement.executeQuery();
		Map<String, String> mappaDigimon = new HashMap<String, String>();
		while (executeQuery.next()) {
			String idUtente = executeQuery.getString(1);
			String nomeDigimon = executeQuery.getString(2);
			mappaDigimon.put(idUtente, nomeDigimon);
		}
		System.out.println("indica 3 digimon da selezionare");
		for (String key : mappaDigimon.values()) {
			System.out.println(key);
		}
		String posizione1 = scanner.nextLine();
		String posizione2 = scanner.nextLine();
		String posizione3 = scanner.nextLine();
		String posizione = scanner.nextLine();

		if (!mappaDigimon.containsKey(posizione)) {
			System.out.println("riprova");
			return null;
		} else {
			return posizione;
		}

	}*/



	private static void popolamentoPartita() {
		// TODO Auto-generated method stub
		
	}




	private static Utente creaUtente(Scanner scanner, Connection connessione) throws SQLException {

		System.out.println("dammi l'id utente");
		String id = scanner.nextLine();

		System.out.println("dammi il nome utente");
		String nome = scanner.nextLine();

		Utente u = new Utente(id, nome);

		if (controlloUtente(u, connessione)) {

			popolamentoUtente(u, connessione);
		}

		else {
			System.out.println("Utente già esistente");
		}

		return u;

	}

	private static boolean controlloUtente(Utente u, Connection connessione) throws SQLException {
		PreparedStatement prepareStatement = connessione.prepareStatement("Select id from utenti where id = ? ;");
		prepareStatement.setString(1, u.getId());
		ResultSet risultato = prepareStatement.executeQuery();
		while (risultato.next()) {
			if (u.getId().equals(risultato.getString("id"))) {

				return false;
			}
		}
		return true;
	}
	

	private static void popolamentoUtente(Utente u, Connection connessione) throws SQLException {
		String queryInserimentoUtente = "INSERT INTO utenti (id, nome) VALUES (?, ?);";
		PreparedStatement prepareStatement = connessione.prepareStatement(queryInserimentoUtente);
		prepareStatement.setString(1, u.getId());
		prepareStatement.setString(2, u.getNome());
		prepareStatement.execute();

	}

	private static Digimon creaDigimon(Scanner scanner, GestioneCombattimentoDigimon g, Connection connessione)
			throws SQLException {
		System.out.println("dammi il nome del digimon");
		String nome = scanner.nextLine();
		System.out.println("dammi l'evoluzione del digimon");
		String evo = scanner.nextLine();
		System.out.println("dammi il tipo del digimon");
		String tipo = scanner.nextLine();

		Digimon d1 = new Digimon(nome, g.calcoloAttacco(), g.calcoloDifesa(), g.calcoloRes(), g.calcoloHp(), evo, tipo,
				prendiProprietario(connessione, scanner));
		System.out.println(d1);
		popolamentoDigimon(d1, connessione);
		return d1;

	}

	private static String prendiProprietario(Connection connessione, Scanner scanner) throws SQLException {
		PreparedStatement prepareStatement = connessione.prepareStatement("select distinct id, nome from utenti;");
		ResultSet executeQuery = prepareStatement.executeQuery();
		Map<String, String> listaUtenti = new HashMap<String, String>();
		while (executeQuery.next()) {
			String id = executeQuery.getString(1);
			String nome = executeQuery.getString(2);
			listaUtenti.put(id, nome);
		}
		System.out.println("indica l'id da selezionare");
		for (String key : listaUtenti.keySet()) {
			System.out.println(key);
		}
		String posizione = scanner.nextLine();

		if (!listaUtenti.containsKey(posizione)) {
			System.out.println("riprova");
			return null;
		} else {
			return posizione;
		}

	}

	public static void popolamentoDigimon(Digimon digimon, Connection connessione) throws SQLException {
		String queryInserimentoDigimon = "INSERT INTO digimon (nome, hp, atk, def, res, evo, tipo, idutente) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
		PreparedStatement prepareStatement = connessione.prepareStatement(queryInserimentoDigimon);
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

}
