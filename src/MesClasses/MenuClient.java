package MesClasses;

import java.util.List;
import java.util.Scanner;

public class MenuClient {
    private Scanner scanner;
    private GestionClients gestionClients;

    public MenuClient() {
        this.scanner = new Scanner(System.in);
        this.gestionClients = new GestionClients(); // Assurez-vous d'avoir une connexion à la DB active
    }

    public void afficherMenu() {
        int choix = 0;
        while (choix != 3) {
            System.out.println("\n*** Menu Gestion des Clients ***");
            System.out.println("1. Ajouter un client");
            System.out.println("2. Afficher tous les clients");
            System.out.println("3. Retour");

            System.out.print("Entrez votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine(); // Capture le retour à la ligne non consommé par nextInt()

            switch (choix) {
                case 1:
                    ajouterClient();
                    break;
                case 2:
                    afficherClients();
                    break;
                case 3:
                    System.out.println("Retour au menu principal.");
                    break;
                default:
                    System.out.println("Choix non valide, veuillez réessayer.");
                    break;
            }
        }
    }

    private void ajouterClient() {
        System.out.println("Ajout d'un nouveau client.");

        System.out.print("Entrez le prénom du client : ");
        String prenom = scanner.nextLine();

        System.out.print("Entrez le nom du client : ");
        String nom = scanner.nextLine();

        System.out.print("Entrez l'adresse du client : ");
        String adresse = scanner.nextLine();

        System.out.print("Entrez le numéro de téléphone du client : ");
        String numeroTelephone = scanner.nextLine();

        Client client = new Client(0, prenom, nom, adresse, numeroTelephone); // ID client à 0, car il sera généré par la DB
        gestionClients.ajouterClient(client);
        System.out.println("Client ajouté avec succès.");
    }

    private void afficherClients() {
        System.out.println("Liste des clients :");

        List<Client> clients = gestionClients.recupererTousLesClients();
        for (Client client : clients) {
            System.out.println(client);  
        }
    }
}
