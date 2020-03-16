package combattimentodigimon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainArena {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Scanner scanner = new Scanner(System.in);
		GestioneTurniDigimon g = new GestioneTurniDigimon();
		Class.forName("com.mysql.cj.jdbc.Driver");
		String password = "EzJ90IaSaP";
		String username = "ExmDFToJYb";
		String url = "jdbc:mysql://remotemysql.com:3306/ExmDFToJYb?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC&createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true&useSSL=false";
		Connection connessione = DriverManager.getConnection(url, username, password);

	}

	public static void chiamaPartita(Connection connessione, Scanner scanner)throws SQLException {
		Statement statement = connessione.createStatement();
		ResultSet risultato = statement.executeQuery("SELECT idpartita and password FROM ExmDFToJYb.partite;");
		
        List<Integer> elencoPartite = new ArrayList<>();
        while (risultato.next()) {
            int id = risultato.getInt(1);
            String password = risultato.getString(2);
            elencoPartite.add(id);
            System.out.println(id + ". " + password);
            ;
        }
        System.out.println("qual è l 'id ?");
        int id = scanner.nextInt();
        scanner.nextLine();
        if (elencoPartite.contains(id)) {
		
        	PreparedStatement prepareStatement = connessione.prepareStatement ("select partite.idcreatore, partite.dc1,digimon.nome,digimon.atk,digimon.def,digimon.res,digimon.hp, digimon.evo, digimon.tipo, from partite inner join digimon on digimon.id = partite.dc1 and partite.idpartita = ?;");
		prepareStatement.setInt(1, id);
		ResultSet risultato2 = prepareStatement.executeQuery();
		
		
	}
        
        else {
		System.out.println("Errore, riprova");
	} 
        
} 
}
