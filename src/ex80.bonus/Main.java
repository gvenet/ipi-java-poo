import util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    /*
     * parsing du csv géré dans la class service
     */
    ServiceBancaire service = new ServiceBancaire();

    System.out.println(
      "\n-----------------------affichage de tous les users-------------------------------------------------"
    );
    service.afficherTousLesUtilisateurs();
    service.editerUtilisateur(1, "foo", "bar");

    System.out.println(
      "\n-----------------------affichage de tous les users apres edit-------------------------------------------------"
    );
    service.afficherTousLesUtilisateurs();

    System.out.println(
      "\n-----------------------affichage de tous les comptes apres detache 0-------------------------------------------------"
    );
    service.detacherCompte(0);
    service.afficherTousLesComptes();

    System.out.println(
      "\n-----------------------test-------------------------------------------------"
    );

    service.afficherComptesUtilisateur(0);
    service.attacherCompte(0, 0);
    service.afficherComptesUtilisateur(0);
    System.out.println(
      "\n-----------------------affichage users 0 et 1-------------------------------------------------"
    );
    service.afficherComptesUtilisateur(0);
    service.afficherComptesUtilisateur(1);

    System.out.println(
      "\n-----------------------detache comptes c0 et c2-------------------------------------------------"
    );
    service.detacherCompte(0);
    service.detacherCompte(2);
    service.afficherComptesUtilisateur(0);
    service.afficherComptesUtilisateur(1);

    System.out.println(
      "\n-----------------------transfert depassant le decouvert-------------------------------------------------"
    );
    service.transfertArgent(1, 3, 15000);
    service.afficherComptesUtilisateur(0);
    service.afficherComptesUtilisateur(1);

    System.out.println(
      "\n-----------------------transfert autorise  de 500 from c1 to c2-------------------------------------------------"
    );
    service.transfertArgent(1, 3, 500);
    service.afficherComptesUtilisateur(0);
    service.afficherComptesUtilisateur(1);

    System.out.println(
      "\n-----------------------transfert autorise de 200 from c2 to c1-------------------------------------------------"
    );
    service.transfertArgent(3, 1, 200);
    service.afficherComptesUtilisateur(0);
    service.afficherComptesUtilisateur(1);
    
    // service.export();
  }
}
