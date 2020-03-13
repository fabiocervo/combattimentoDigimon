package combattimentodigimon;

import java.sql.Connection;
import java.sql.DriverManager;
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
		creaDigimon(scanner, g);
		
			
		}

	private static Digimon creaDigimon(Scanner scanner, GestioneCombattimentoDigimon g) {
		System.out.println("dammi il nome del digimon");
		String nome = scanner.nextLine();
		System.out.println("dammi l'evoluzione del digimon");
		String evo = scanner.nextLine();
		System.out.println("dammi il tipo del digimon");
		String tipo = scanner.nextLine();
		Digimon d1 = new Digimon(nome, g.calcoloAttacco(), g.calcoloDifesa(),  g.calcoloRes(),g.calcoloHp(), evo, tipo);
		return d1;
	}

	}

	

