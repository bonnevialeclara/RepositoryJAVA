/**
 * @(#) LicencePlongeur.java
 */
package FFSSM;

import java.util.Calendar;

public class Licence {

    public Personne possesseur;

    public String numero;

    public Calendar delivrance;

    public int niveau;

    public Club club;

    public Licence(Personne possesseur, String numero, Calendar delivrance, int niveau, Club club) {
        this.possesseur = possesseur;
        this.numero = numero;
        this.delivrance = delivrance;
        this.niveau = niveau;
        this.club = club;
    }

    public Personne getPossesseur() {
        return possesseur;
    }
    
    public void setPossesseur(Personne possesseur) {
        this.possesseur = possesseur;
    }

    public String getNumero() {
        return numero;
    }
    
    public void setNumero(String numero){
        this.numero = numero;
    }

    public Calendar getDelivrance() {
        return delivrance;
    }
    
    public void setDelivrance(Calendar delivrance){
        this.delivrance = delivrance;
    }

    public int getNiveau() {
        return niveau;
    }
    
    public void setNiveau(int niveau){
        this.niveau = niveau;
    }

    public Club getClub() {
        return club;
    }
    
    public void setClub(Club club){
        this.club = club;
    }

    /**
     * Est-ce que la licence est valide à la date indiquée ?
     * @param d la date à tester
     * @return vrai si valide à la date d
     **/
    public boolean estValide(Calendar d) {
         // TODO: Implémenter cette méthode
         Calendar e = (Calendar) delivrance.clone();
         e.add(Calendar.YEAR, 1);
         boolean b=false;
         //if(d.after(e) || d.before(delivrance)){
           //  b=false;
         //}
         if(d.before(e) && d.after(delivrance)){
             b=true;
         }
         return b;
        //throw new UnsupportedOperationException("Pas encore implémenté");
    }

}
