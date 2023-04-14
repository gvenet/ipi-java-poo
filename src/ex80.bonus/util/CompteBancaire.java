package util;

public class CompteBancaire {

  private int id;
  private Utilisateur user;
  private int solde;
  private int decouvertAutorise;

  public CompteBancaire(
    int id,
    Utilisateur user,
    int solde,
    int decouvertAutorise
  ) {
    this.id = id;
    this.user = user;
    this.solde = solde;
    this.decouvertAutorise = decouvertAutorise;
  }

  public int getId() {
    return this.id;
  }

  public Utilisateur getUser() {
    return this.user;
  }

  public void setUser(Utilisateur user) {
    this.user = user;
  }

  public int getSolde() {
    return this.solde;
  }

  public void setSolde(int solde) {
    this.solde = solde;
  }

  public int getDecouvertAutorise() {
    return this.decouvertAutorise;
  }

  public void setDecouvertAutorise(int decouvertAutorise) {
    this.decouvertAutorise = decouvertAutorise;
  }

  public void display() {
    if (this.user != null) {
      System.out.println(
        "Compte n " +
        this.id +
        " | userID : " +
        this.user.getId() +
        " | userName : " +
        this.user.getNom() +
        " | solde : " +
        this.solde +
        " | decouvertAutorise : " +
        this.decouvertAutorise
      );
    } else {
      System.out.println(
        "Compte n " +
        this.id +
        " | userID : null | userName : null | solde : " +
        this.solde +
        " | decouvertAutorise : " +
        this.decouvertAutorise
      );
    }
  }
}
