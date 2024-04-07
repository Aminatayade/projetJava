package MesClasses;

import java.util.Scanner;

public class MenuDetailsVente {
    private Scanner scanner;
    private GestionDetailsVente gestionDetailsVente;

    public MenuDetailsVente() {
        this.scanner = new Scanner(System.in);
        this.gestionDetailsVente = new GestionDetailsVente();
    }

    public void afficherMenu() {
        int choix = 0;
        while (choix != 2) {
            System.out.println("\n*** Menu Gestion des Détails de Vente ***");
            System.out.println("1. Ajouter un détail de vente");
            System.out.println("2. Retour");

            System.out.print("Entrez votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine(); // Capture le retour à la ligne non consommé par nextInt()

            switch (choix) {
                case 1:
                    ajouterDetailVente();
                    break;
                case 2:
                    System.out.println("Retour au menu principal.");
                    break;
                default:
                    System.out.println("Choix non valide, veuillez réessayer.");
                    break;
            }
        }
    }

    private void ajouterDetailVente() {
        System.out.println("Ajout d'un nouveau détail de vente.");

        System.out.print("Entrez l'ID de la vente : ");
        int venteID = scanner.nextInt();
        scanner.nextLine(); // Capture le retour à la ligne non consommé par nextInt()

        System.out.print("Entrez l'ID du medicament : ");
        int medicamentID = scanner.nextInt();
        scanner.nextLine(); // Capture le retour à la ligne non consommé par nextInt()

        System.out.print("Entrez la quantité : ");
        int quantite = scanner.nextInt();
        scanner.nextLine(); // Capture le retour à la ligne non consommé par nextInt()

        System.out.print("Entrez le prix unitaire : ");
        double prixUnitaire = scanner.nextDouble();
        scanner.nextLine(); // Capture le retour à la ligne non consommé par nextDouble()

        DetailVente detailVente = new DetailVente(venteID, medicamentID, quantite, prixUnitaire);
        gestionDetailsVente.ajouterDetailVente(detailVente);
        System.out.println("Détail de vente ajouté avec succès.");
    }
}
