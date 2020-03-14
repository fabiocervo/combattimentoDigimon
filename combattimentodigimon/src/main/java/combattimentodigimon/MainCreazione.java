package combattimentodigimon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
		creaDigimon(scanner, g,connessione);
		
			
		}

	private static Digimon creaDigimon(Scanner scanner, GestioneCombattimentoDigimon g, Connection connessione) {
		System.out.println("dammi il nome del digimon");
		String nome = scanner.nextLine();
		System.out.println("dammi l'evoluzione del digimon");
		String evo = scanner.nextLine();
		System.out.println("dammi il tipo del digimon");
		String tipo = scanner.nextLine();
		Digimon d1 = new Digimon(nome, g.calcoloAttacco(), g.calcoloDifesa(),  g.calcoloRes(),g.calcoloHp(), evo, tipo);
		return d1;
		popolamentoDigimon(d1, connessione);
	}
	public static void popolamentoDigimon(Digimon digimon, Connection connessione) throws SQLException {
		String queryInserimentoDigimon = "INSERT INTO digimon.ExmDFToJYb (nome, hp, atk, def, res, evo, tipo) VALUES (?, ?, ?, ?, ?, ?, ?);";
		PreparedStatement prepareStatement = connessione.prepareStatement(queryInserimentoDigimon);
		prepareStatement.setString(1, digimon.getNome());
		prepareStatement.setInt(2, digimon.getHp());
		prepareStatement.setInt(3, digimon.getAtk());
		prepareStatement.setInt(4, digimon.getDef());
		prepareStatement.setInt(5, digimon.getRes());
		prepareStatement.setString(6, digimon.getEvo());
		prepareStatement.setString(7, digimon.getTipo());
		prepareStatement.execute();
	}
	

	}

	

