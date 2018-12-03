/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FFSSM;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Calendar;
import java.util.HashSet;
import java.util.LinkedList;

/**
 *
 * @author cbonnevi
 */
public class FFSSMTest {
    
    public FFSSMTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    Club club1;
    Moniteur moniteur1;
    Plongeur plongeur1, plongeur2;
    Plongee plongee1;
    Site site1;
    Licence licence1, licence2;
    Embauche embauche1;

    @Before
    public void setUp() {
        Calendar naissance = Calendar.getInstance();
        Calendar datePlongee = Calendar.getInstance();
            Calendar delivrance =Calendar.getInstance();
        Calendar delivrance2 = Calendar.getInstance();
        Calendar debutEmbauche = Calendar.getInstance();
  
        naissance.set(1998,12,12);
        datePlongee.set(2018, 12, 12);
        delivrance.set(2018, 12, 13);
        delivrance2.set(2018, 10, 10);
        debutEmbauche.set(2018, 9, 1);
        
        licence1= new Licence(plongeur1, "001", delivrance, 2, club1);
        licence2= new Licence(plongeur2, "002", delivrance2, 3, club1);
        moniteur1= new Moniteur("01", "John", "John", "Castres", "0123456789", naissance, 1, 1);
        plongeur1= new Plongeur("02", "Plongeur", "McPlongeur", "LesSalvages", "9874561230", naissance, 2);
        plongeur2= new Plongeur("03", "Plongeurine", "McPlongeur", "Moscou", "9874571230", naissance, 3);
        club1=new Club(moniteur1, "ClubUn", "Somewhere", "0563124389");
        site1= new Site("lac", "lac de Castres");
        plongee1= new Plongee(site1, moniteur1, datePlongee, 30, 2);
        embauche1= new Embauche(debutEmbauche, moniteur1, club1);
    }
    
    /////////TEST CLUB/////////
    
        @Test
        public void testPlongeesNonConformes(){
            Moniteur moniteur;
            Plongee plongeeNonValide;
            Plongeur participant;
            Calendar date = Calendar.getInstance();
            date.set(2018, 10, 11);
            participant = new Plongeur("0001", "Test", "McTest", "Albi", "9764318520", date, 1);
            moniteur = new Moniteur("000", "Mon", "Iteur", "France", "0236145879", date, 1, 1);
            plongeeNonValide = new Plongee(site1, moniteur, date, 10, 1);
            
            plongeeNonValide.ajouteParticipant(participant);
            assertFalse(plongeeNonValide.estConforme());
            club1.organisePlongee(plongeeNonValide);
            
            HashSet<Plongee> myPlongeeNonConformes = new HashSet<>();
            myPlongeeNonConformes.add(plongeeNonValide);
            assertEquals(myPlongeeNonConformes, club1.plongeesNonConformes());
            
        }
    
        @Test
	public void testOrganiserPlongee() {
		club1.organisePlongee(plongee1);
                assertTrue(club1.myPlongee.contains(plongee1));
	}
    
        @Test
	public void presidentIsCorrectlyInitialized() {
            club1.setPresident(moniteur1);
            assertEquals("Le president est mal initialisé", 
			moniteur1, club1.getPresident());
	}
        
        @Test
	public void nomIsCorrectlyInitialized() {
            club1.setNom("newNom");
            assertEquals("Le nom est mal initialisé", 
			"newNom", club1.getNom());
	}
        
        @Test
	public void adresseIsCorrectlyInitialized() {
            club1.setAdresse("newAdresse");
		assertEquals("L'adresse est mal initialisé", 
			"newAdresse", club1.getAdresse());
	}
        
        @Test
	public void telephoneIsCorrectlyInitialized() {
            club1.setTelephone("newTelephone");
            assertEquals("Le telephone est mal initialisé", 
			"newTelephone", club1.getTelephone());
	}
        
    ////////TEST PLONGEUR/////////
        
        @Test
	public void testAjouterLicence() {
		plongeur1.ajouteLicence(licence1);
                assertTrue(plongeur1.myLicences.contains(licence1));
	}
        
    ///////TEST LICENCE///////////
        
        @Test
        public void testValiditeLicencePositif(){
            Calendar testLicence1 = Calendar.getInstance();
            testLicence1.set(2019,03,03);
            assertTrue(licence1.estValide(testLicence1));
        }
        
        @Test
        public void testValiditeLicenceNegatif(){
            Calendar testLicence2 = Calendar.getInstance();
            testLicence2.set(2016,11,12);
            assertFalse(licence1.estValide(testLicence2));
        }
        
        @Test
	public void possesseurIsCorrectlyInitialized() {
            licence1.setPossesseur(moniteur1);
            assertEquals("Le possesseur est mal initialisé", 
			moniteur1, licence1.getPossesseur());
	}
        
        @Test
	public void numeroLicenceIsCorrectlyInitialized() {
            licence1.setNumero("5");
            assertEquals("Le numero de licence est mal initialisé", 
			"5", licence1.getNumero());
	}
        
        @Test
	public void delivranceLicenceIsCorrectlyInitialized() {
            Calendar newDelivrance = Calendar.getInstance();
            newDelivrance.set(2017, 12, 12);
            licence1.setDelivrance(newDelivrance);
            assertEquals("La date de delivrance est mal initialisée", 
			newDelivrance, licence1.getDelivrance());
	}
        
        @Test
        public void niveauLicenceIsCorrectlyInitialized(){
            licence1.setNiveau(0);
            assertEquals("Le niveau est mal initialisé", 0, licence1.getNiveau());
        }
        
        @Test
        public void clubLicenceIsCorrectlyInitialized(){
            licence1.setClub(club1);
            assertEquals("Le club est mal initialisé", club1, licence1.getClub());
        }
    
    ////////TEST PLONGEE/////////////////////
        @Test
        public void testPlongeeConforme(){
            plongeur2.ajouteLicence(licence2);
            plongee1.ajouteParticipant(plongeur2);
            assertTrue(plongee1.estConforme());
        }
        
        @Test
	public void datePlongeeIsCorrectlyInitialized() {
            Calendar datePlongee = Calendar.getInstance();
            datePlongee.set(2018,12,12);
            plongee1.setDate(datePlongee);
            assertEquals("La date de plongee est mal initialisée", datePlongee, plongee1.getDate());
	}
        
    /////////TEST EMBAUCHE//////////////////
        
        @Test
        public void testTerminerEmbauche(){
            Calendar dateFin = Calendar.getInstance();
            dateFin.set(2018,12,12);
            embauche1.terminer(dateFin);
            assertEquals(dateFin,embauche1.getFin());
        }
        
        @Test
        public void testEmbaucheEstTerminee(){
            Calendar dateFin = Calendar.getInstance();
            dateFin.set(2018,12,12);
            embauche1.terminer(dateFin);
            assertTrue(embauche1.estTerminee());
        }
        
        @Test
        public void testEmbaucheNEstPasTerminee(){
            assertFalse(embauche1.estTerminee());
        }
        
        @Test
	public void employeurIsCorrectlyInitialized() {
		assertEquals("L'employeur est mal initialisé", 
			club1, embauche1.getEmployeur());
	}
        
        @Test
	public void debutEmbaucheIsCorrectlyInitialized() {
            Calendar debutEmbauche = Calendar.getInstance();
            debutEmbauche.set(2018, 9, 1);
            assertEquals("La date de debut est mal initialisée", 
			debutEmbauche, embauche1.getDebut());
	}
        
        @Test
	public void employeIsCorrectlyInitialized() {
		assertEquals("L'employe est mal initialisé", 
			moniteur1, embauche1.getEmploye());
	}
        
        ////////TEST MONITEUR/////////////////
        
        @Test
        public void testEmployeurActuel(){
            moniteur1.nouvelleEmbauche(embauche1);
            assertEquals(club1, moniteur1.employeur());
        }
        
        @Test
        public void testEmployeurActuelNull(){
            moniteur1.nouvelleEmbauche(embauche1);
            Calendar dateFin = Calendar.getInstance();
            dateFin.set(2018,12,12);
            embauche1.terminer(dateFin);
            assertNull(moniteur1.employeur());
        }
        
        @Test
        public void testListeEmbauches(){
            moniteur1.nouvelleEmbauche(embauche1);
            LinkedList<Embauche> myEmbauches = new LinkedList<>();
            myEmbauches.add(embauche1);
            assertEquals(myEmbauches,moniteur1.emplois());
        }
        
        //////////TEST SITE///////////////////
        
        @Test
        public void siteNomIsCorrectlyInitialized() {
            site1.setNom("newNom");
            assertEquals("Le nom est mal initialisé", 
			"newNom", site1.getNom());
	}
        
        @Test
        public void siteDetailsAreCorrectlyInitialized() {
            site1.setDetails("newDetails");
            assertEquals("Les détails sont mal initialisés", 
			"newDetails", site1.getDetails());
	}

    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
