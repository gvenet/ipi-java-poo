package util;

import java.util.*;

public class ServiceBancaire {

  private List<Utilisateur> users = new ArrayList<>();
  private List<CompteBancaire> comptes = new ArrayList<>();
  private CSVParser parser = new CSVParser();

  /*
   * a la construction on parse le csv qui creer 2 listes, une liste utilisateur (sans doublon) et un liste de compte avec l'utilisateur relié au compte.
   * on gere les erreurs en les récupérant depuis la classe parsing
   */
  public ServiceBancaire() {
    try {
      this.parser.parse();
      this.users = parser.getUsers();
      this.comptes = parser.getComptes();
    } catch (Exception e) {
      System.out.print(e);
    }
  }

  /*
   * sert à rattacher un compte à un utilisateur
   */
  public void attacherCompte(int userId, int compteId) {
    try {
      this.getCompteById(compteId).setUser(this.getUserById(userId));
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  /*
   * détache un compte d'un utilisateur. la case utilisateur dans l'instantiation de compte est set à null;
   */
  public void detacherCompte(int compteId) {
    try {
      this.getCompteById(compteId).setUser(null);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  /*
   * encapsulé dans un try catch, si user est null ou  la somme est > au plafond, on annule le transfert
   * si user est null, c'est une erreur 'interne'
   * si somme > découvert autorise, c'est une erreur 'fonctionnelle'
   */
  public void transfertArgent(int compteFromId, int compteToId, int somme) {
    try {
      CompteBancaire from = this.getCompteById(compteFromId);
      CompteBancaire to = this.getCompteById(compteToId);

      int fromNouveauSolde = from.getSolde() - somme;
      if (fromNouveauSolde > from.getDecouvertAutorise()) {
        from.setSolde(fromNouveauSolde);
        to.setSolde(to.getSolde() + somme);
        System.out.println(
          "Operation reussi, transfert de " +
          somme +
          " de " +
          from.getUser().getNom() +
          " vers " +
          to.getUser().getNom()
        );
      } else {
        System.out.println(
          "Operation annulee, le decouvert autorise de " +
          from.getUser().getNom() +
          " est depasse."
        );
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  /*
   * méthode en privée, utilisée seulement par la classe service en interne
   * la gestion d'erreur se fait par cette methode.
   */
  private CompteBancaire getCompteById(int compteId) throws Exception {
    Optional<CompteBancaire> current =
      this.comptes.stream()
        .filter(compte -> compte.getId() == compteId)
        .findAny();
    if (current.isPresent()) {
      return current.get();
    } else {
      throw new Exception("Compte innexistant avec compteId : " + compteId);
    }
  }

  /*
   * methode en privée, utilisée seulement par la classe service en interne
   * la gestion d'erreur se fait par cette methode.
   */
  private Utilisateur getUserById(int userId) throws Exception {
    Optional<Utilisateur> current =
      this.users.stream().filter(user -> user.getId() == userId).findAny();
    if (current.isPresent()) {
      return current.get();
    } else {
      throw new Exception("User innexistant avec userId " + userId);
    }
  }

  public void afficherComptesUtilisateur(int userId) {
    try {
      this.getUserById(userId).display();
      this.comptes.stream()
        .filter(compte ->
          compte.getUser() != null && compte.getUser().getId() == userId
        )
        .forEach(compte -> compte.display());
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public void afficherTousLesComptes() {
    this.comptes.forEach(compte -> compte.display());
  }

  public void afficherTousLesUtilisateurs() {
    this.users.forEach(user -> user.display());
  }

  public void editerUtilisateur(int userId, String nom, String prenom) {
    try {
      Utilisateur user = this.getUserById(userId);
      if (nom == null || prenom == null) {
        throw new Exception("Inputs non valides");
      }
      user.setNom(nom);
      user.setPrenom(prenom);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public void export() {
    this.parser.export();
  }
}
