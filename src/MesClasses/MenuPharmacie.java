package MesClasses;
import java.util.Scanner;

public class MenuPharmacie {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestionMedicaments gestionMedicaments = new GestionMedicaments();
        // Création de l'instance de MenuFournisseur
        MenuFournisseur menuFournisseur = new MenuFournisseur();
        MenuVente menuVente = new MenuVente(); 
        MenuClient menuClient = new MenuClient();
        MenuDetailsVente menuDetailsVente = new MenuDetailsVente();

        while (true) {
            System.out.println("Pharmacie OUMOUL RASSOUL");
            System.out.println("\n*** Menu Gestion Pharmacie ***");
            System.out.println("1. Ajouter un médicament");
            System.out.println("2. Supprimer un médicament");
            System.out.println("3. Gérer les fournisseurs"); // Nouvelle option pour gérer les fournisseurs
            System.out.println("4. Gérer les ventes"); // Ceci est une nouvelle option
            System.out.println("5. Gerer les clients");
            System.out.println("6.Gerer les details de la vente");
            System.out.println("7. Quitter");
            System.out.println("bonjour");
            System.out.print("Entrez votre choix : ");

            int choix = scanner.nextInt();
            scanner.nextLine(); // Consomme la nouvelle ligne restante

            switch (choix) {
                case 1:
                    // Ajouter un médicament
                    // ...
                    System.out.println("Entrez le nom du médicament : ");
                    String nom = scanner.nextLine();
                    
                    System.out.println("Entrez la description du médicament : ");
                    String description = scanner.nextLine();
                    
                    System.out.println("Entrez le prix du médicament : ");
                    double prix = scanner.nextDouble();
                    
                    System.out.println("Entrez la quantité en stock : ");
                    int quantite = scanner.nextInt();
                    
                    Medicament medicament = new Medicament(nom, description, prix, quantite);
                    gestionMedicaments.ajouterMedicament(medicament);

                    System.out.println("Médicament ajouté avec succès.");
                    break;
                case 2:
                    // Supprimer un médicament
                    // ...
                    System.out.println("Entrez l'ID du médicament à supprimer : ");
                    int id = scanner.nextInt();
                    gestionMedicaments.supprimerMedicament(id);
                    System.out.println("Médicament supprimé avec succès.");
                    break;
                case 3:
                    // Appel à la gestion des fournisseurs
                    menuFournisseur.afficherMenu(); // Lancer le menu des fournisseurs
                    break;
                case 4:
                    menuVente.afficherMenu(); // Cela lancera le menu des ventes
                    break;  
                case 5:
                    menuClient.afficherMenu();   
                case 6: 
                    menuDetailsVente.afficherMenu();      
                case 7:
                    // Quitter
                    System.out.println("Au revoir !");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Choix non valide, veuillez réessayer.");
                    break;
            }
        }

        

    }
}
