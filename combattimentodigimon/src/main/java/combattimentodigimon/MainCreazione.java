package combattimentodigimon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
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
		creaUtente(scanner, connessione);
		creaDigimon(scanner, g, connessione);
		

	}

	private static Utente creaUtente(Scanner scanner, Connection connessione) throws SQLException {
		System.out.println("dammi l'id utente");
		String id = scanner.nextLine();
		System.out.println("dammi il nome utente");
		String nome = scanner.nextLine();
		Utente u = new Utente(id, nome);
		popolamentoUtente(u, connessione);
		return u;

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
		
		Digimon d1 = new Digimon(nome, g.calcoloAttacco(), g.calcoloDifesa(), g.calcoloRes(), g.calcoloHp(), evo, tipo, prendiProprietario(connessione, scanner));
		System.out.println(d1);
		popolamentoDigimon(d1, connessione);
		return d1;

	}

	private static String prendiProprietario(Connection connessione, Scanner scanner)throws SQLException{
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
		prepareStatement.setString(8,digimon.getProprietario());
		prepareStatement.execute();
	}

}
