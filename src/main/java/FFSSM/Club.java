/**
 * @(#) Club.java
 */
package FFSSM;

import java.util.HashSet;
import java.util.Set;

public class Club {

    HashSet<Plongee> myPlongee = new HashSet<>();
    public Moniteur president;

    public String nom;

    public String adresse;

    public String telephone;

    public Club(Moniteur président, String nom, String adresse, String telephone) {
        this.president = président;
        this.nom = nom;
        this.adresse=adresse;
        this.telephone = telephone;
    }

    public Set<Plongee> plongeesNonConformes() {
         // TODO: Implémenter cette méthode
         HashSet<Plongee> myPlongeeNonConformes = new HashSet<>();
         for (Plongee p : myPlongee){
             if(p.estConforme()==false){
                myPlongeeNonConformes.add(p);
             }
         }
         return myPlongeeNonConformes;
        //throw new UnsupportedOperationException("Pas encore implémenté");
    }

    public void organisePlongee(Plongee p) {
         // TODO: Implémenter cette méthode
         myPlongee.add(p);
        //throw new UnsupportedOperationException("Pas encore implémenté");
    }
    
    
    public Moniteur getPresident() {
        return president;
    }

    public void setPresident(Moniteur président) {
        this.president = président;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Club{" + "président=" + president + ", nom=" + nom + ", adresse=" + adresse + ", telephone=" + telephone + '}';
    }

}
