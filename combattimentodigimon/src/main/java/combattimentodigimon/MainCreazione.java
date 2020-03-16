package combattimentodigimon;

import java.sql.SQLException;
import java.util.Scanner;

public class MainCreazione {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Scanner scanner = new Scanner(System.in);
		GestioneCaratteristicheDigimon g = new GestioneCaratteristicheDigimon();
		GestioneTurniDigimon gT = new GestioneTurniDigimon();
		Gestione gest = new Gestione();

		while (true) {

			menu();
			System.out.println("cosa vuoi fare?");
			int scegli = scanner.nextInt();
			scanner.nextLine();

			switch (scegli) {
			case 1: {
				gest.creaUtente(scanner);
				break;
			}

			case 2: {
				gest.creaDigimon(scanner, g);
				break;
			}

			case 3: {
				gest.creaPartitaPerCreatore(scanner);
				break;
			} 

			case 4: {
			    gest.creaPartitaSfidante(scanner);
				break;
			}
			
			case 5:{
				
				//gest.chiamaPartita(scanner, gT, idpartita);
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
		System.out.println("3. crea partita creatore");
		System.out.println("4. crea partita sfidante");
		System.out.println("5. chiama partita");

	}

	
	}


