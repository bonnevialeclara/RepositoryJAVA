/**
 * @(#) Plongee.java
 */
package FFSSM;

import java.util.Calendar;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Plongee {
    
    HashSet<Plongeur> myPlongeurs = new HashSet<>();

    public Site lieu;

    public Moniteur chefDePalanquee;

    public Calendar date;

    public int profondeur;

    public int duree;

    public Plongee(Site lieu, Moniteur chefDePalanquee, Calendar date, int profondeur, int duree) {
        this.lieu = lieu;
        this.chefDePalanquee = chefDePalanquee;
        this.date = date;
        this.profondeur = profondeur;
        this.duree = duree;
    }

    public void ajouteParticipant(Plongeur participant) {
         // TODO: Implémenter cette méthode
         myPlongeurs.add(participant);
        //throw new UnsupportedOperationException("Pas encore implémenté");	    
    }

    public Calendar getDate() {
        return date;
    }
    
    public void setDate(Calendar date){
        this.date=date;
    }

    public boolean estConforme() {
         // TODO: Implémenter cette méthode
         
         boolean b=true;
         
         for (Plongeur p : myPlongeurs){
             LinkedList<Licence> licenceDeP = p.myLicences;
             if(licenceDeP.isEmpty() || licenceDeP.getLast().estValide(date)==false){
                 
                 b=false;
             }
             else{
                 b=true;
             }
         }
         return b;
         
        //throw new UnsupportedOperationException("Pas encore implémenté");
    }

}
