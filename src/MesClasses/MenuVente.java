package MesClasses;

import java.util.List;
import java.util.Scanner;
import java.sql.Date;



public class MenuVente {
    private Scanner scanner;
    private GestionVentes gestionVentes; // Supposons que vous avez une classe pour gérer les ventes
    private GestionMedicaments gestionMedicaments; // Déclaration de gestionMedicaments


    public MenuVente() {
        scanner = new Scanner(System.in);
        gestionVentes = new GestionVentes(); // Initialisez votre gestionnaire de ventes ici
        gestionMedicaments = new GestionMedicaments(); // Initialisation de gestionMedicaments

    }
    
    public void afficherMenu() {
        int choix = 0;
        while (choix != 3) { // Modifier selon le nombre d'options que vous avez
            System.out.println("\n*** Menu Gestion des Ventes ***");
            System.out.println("1. Ajouter une vente");
            System.out.println("2. Afficher toutes les ventes");
            System.out.println("3. Retour");
            System.out.print("Entrez votre choix : ");

            choix = scanner.nextInt();
            scanner.nextLine(); // Consommer la ligne restante

            switch (choix) {
                case 1:
                    ajouterVente();
                    break;
                case 2:
                    afficherVentes();
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

    private void ajouterVente() {
    System.out.println("Ajout d'une nouvelle vente.");

    // Collecter les informations nécessaires auprès de l'utilisateur
    System.out.print("Entrez l'ID du client : ");
    int clientID = scanner.nextInt();
    
    // Supposons que vous collectiez la date et le total de la vente également
    System.out.print("Entrez la date de la vente (AAAA-MM-JJ) : ");
    String dateVenteStr = scanner.next();
    Date dateVente = Date.valueOf(dateVenteStr);
    
    System.out.print("Entrez le total de la vente : ");
    double total = scanner.nextDouble();
    scanner.nextLine();
    System.out.println("Entrez le nom du medicament vendue:");
    String nomMedicamentVendu= scanner.nextLine();
    
    System.out.println("Entrez la quantite vendue");
    int quantiteVendue = scanner.nextInt();

    // Créer un objet Vente avec les informations saisies
    Vente vente = new Vente( clientID, dateVente, total,nomMedicamentVendu,quantiteVendue); // 0 pour venteID, qui sera auto-généré dans la base de données

    // Appeler la méthode pour ajouter la vente à la base de données
    gestionVentes.ajouterVente(vente);
    gestionMedicaments.vendreMedicament(vente);

    System.out.println("Vente ajoutée avec succès.");
}

private void afficherVentes() {
    System.out.println("Affichage de toutes les ventes :");

    // Récupérer toutes les ventes depuis la base de données
    List<Vente> ventes = gestionVentes.recupererToutesLesVentes();

    // Afficher les ventes
    for (Vente vente : ventes) {
        System.out.println("Vente ID : " + vente.getVenteID());
        System.out.println("ID du client : " + vente.getClientID());
        System.out.println("Date de vente : " + vente.getDateVente());
        System.out.println("Total : " + vente.getTotal());
        System.out.println("Nom :" +vente.getNomMedicamentVendu());
        System.out.println("Quantite :" +vente.getQuantiteVendue());
        System.out.println("---------------------------------------");
    }
}

}
