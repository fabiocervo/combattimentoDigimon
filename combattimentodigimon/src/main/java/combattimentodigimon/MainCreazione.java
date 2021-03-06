package combattimentodigimon;

import java.sql.SQLException;
import java.util.Scanner;

public class MainCreazione {

	public static void main(String[] args) throws SQLException, ClassNotFoundException, InterruptedException {
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
				gest.uniscitiAllaPartita(scanner);
				break;
			}

			case 5: {
				System.out.println("qual � il tuo idUtente");
				String idUtente = scanner.nextLine();
				gest.stampaIdPartita(idUtente);
				System.out.println("scegli id partita");
				int idPartita = scanner.nextInt();
				scanner.nextLine();
				gest.listaDigimonPartita(idPartita, gT);
			    gT.impostazioneAttaccoDifesaCreatore(gest, idPartita, idUtente);
				break;
			}
			case 6: {
				System.out.println("qual � il tuo idUtente");
				String idUtente = scanner.nextLine();
				gest.stampaIdPartitaSfidante(idUtente);
				System.out.println("scegli id partita");
				int idPartita = scanner.nextInt();
				scanner.nextLine();
				gest.listaDigimonPartita(idPartita, gT);
				gT.impostazioneDifesaCreatore(gest, idPartita, idUtente);
				gT.gestioneLottaCreatore(gT.getListaDigimon().get(0), gT.getListaDigimon().get(3));
				if (gest.gestisciMossaArena(idPartita).equals(idUtente)) {
					gT.impostazioneAttaccoDifesaSfidante(gest, idPartita, idUtente);
					gT.gestioneLottaCreatore( gT.getListaDigimon().get(3), gT.getListaDigimon().get(0));
				}
					
					
				

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
		System.out.println("4. unisciti alla partita");
		System.out.println("5. chiama partita");
		System.out.println("6. chiama partita sfidante ");

	}

}
