package MesClasses;

import java.util.Scanner;

public class MenuFournisseur {

    private Scanner scanner;
    private GestionFournisseurs gestionFournisseurs;

    public MenuFournisseur() {
        scanner = new Scanner(System.in);
        gestionFournisseurs = new GestionFournisseurs();
    }

    public void afficherMenu() {
        int choix = 0;
        while (choix != 3) {
            System.out.println("\n*** Menu Gestion Fournisseur ***");
            System.out.println("1. Ajouter un fournisseur");
            System.out.println("2. Supprimer un fournisseur");
            System.out.println("3. Retour au menu principal");
            System.out.print("Entrez votre choix : ");

            choix = scanner.nextInt();
            scanner.nextLine(); // Consommer la nouvelle ligne restante

            switch (choix) {
                case 1:
                    ajouterFournisseur();
                    break;
                case 2:
                    supprimerFournisseur();
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

    private void ajouterFournisseur() {
        System.out.println("\n*** Ajouter un fournisseur ***");
        System.out.print("Entrez le nom du fournisseur : ");
        String nom = scanner.nextLine();
       
        System.out.print("Entrez l'adresse du fournisseur : ");
        String adresse = scanner.nextLine();
        System.out.println("Entrez le numero telephone du fournisseur : ");
        String telephone = scanner.nextLine();
        
       // System.out.print("Entrez le prenom du fournisseur : ");
        //String email = scanner.nextLine();
        
        // Créer un objet Fournisseur avec les informations saisies
        Fournisseur fournisseur = new Fournisseur(nom, adresse,telephone);
        
        // Appeler la méthode pour ajouter le fournisseur
        gestionFournisseurs.ajouterFournisseur(fournisseur);
        System.out.println("Fournisseur ajouté avec succès.");
    }

    private void supprimerFournisseur() {
        // Logique pour supprimer un fournisseur
        System.out.println("Entrez l'ID du fournisseur à supprimer : ");
        int id = scanner.nextInt();
        gestionFournisseurs.supprimerFournisseur(id);
        System.out.println("Fournisseur supprimé avec succès.");
    }

    
}
