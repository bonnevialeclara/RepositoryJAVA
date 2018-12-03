/**
 * @(#) Moniteur.java
 */
package FFSSM;

import java.util.Calendar;
import java.util.Collections;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Moniteur extends Plongeur {
    
    
    public int numeroDiplome;
    
    LinkedList<Embauche> myEmbauches = new LinkedList<>();

    public Moniteur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, Calendar naissance, int niveau, int numeroDiplome) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance, niveau);
        this.numeroDiplome = numeroDiplome;
    }

    public Club employeur() {
         // TODO: Implémenter cette méthode
         if(myEmbauches.getLast().estTerminee()==true){
             return null;
         }
         else{
             return myEmbauches.getLast().getEmployeur();
         }
        //throw new UnsupportedOperationException("Pas encore implémenté");
    }
    
    public void nouvelleEmbauche(Embauche e) {   
         // TODO: Implémenter cette méthode
         myEmbauches.add(e);
        //throw new UnsupportedOperationException("Pas encore implémenté");	    
    }

    public List<Embauche> emplois() {
         // TODO: Implémenter cette méthode
         return myEmbauches;
        //throw new UnsupportedOperationException("Pas encore implémenté");
    }

}
