
package daoJdbcMapping;

import classesMetiers.Livreur;
import classesMetiers.Secteur;
import diversUtilitaires.*;
import java.sql.SQLException;
import java.util.Vector;
import jdbc.AccesBase;
import jdbc.JeuResultat;


public class LivreurDAO {
// ==========================================================================
// PROPRIETES
// ==========================================================================
// --------------------------------------------------------------------------
// Acces a la base de donnees liee a la table CONTACT
// --------------------------------------------------------------------------
    private AccesBase accesBase;

// --------------------------------------------------------------------------
// Jeu de resultats lu par l'un des "executeQuery"
// Il contient toutes les donnees des lignes lues dans la table contact et
// les donnees relatives aux colonnes.
// --------------------------------------------------------------------------
    private JeuResultat jeuResultat;

// ==========================================================================
// METHODES
// ==========================================================================
// --------------------------------------------------------------------------
// Constructeur
// --------------------------------------------------------------------------
    public LivreurDAO(AccesBase accesBase)
    {
        this.accesBase = accesBase;
    }
    
// --------------------------------------------------------------------------
// Lecture d'un objet Livreur (dont la clef est renseignee)
// --------------------------------------------------------------------------
    public void lire(Livreur livreur) throws SQLException
    {
        int rowCount;

        String select;
        Vector<Object> ligne;

        select = "SELECT * FROM LIVREUR WHERE NUMERO = " + livreur.getIdLivreur();

        jeuResultat = accesBase.executeQuery(select);

        rowCount = (jeuResultat.getLignes()).size();
    
// --------------------------------------------------------------------------
// Si le executeQuery retourne 0 ligne, il n'y a pas SQLException. C'est la
// raison de la creation d'une SQLException particuliere.
// --------------------------------------------------------------------------
        if (rowCount == 1)
        {
            ligne = (jeuResultat.getLignes()).elementAt(0);

            livreur.setIdLivreur((Integer) ligne.elementAt(1));
            livreur.setNomLivreur((String) ligne.elementAt(2));
            livreur.setPrenomLivreur((String) ligne.elementAt(3));
            livreur.setNumPermisLivreur((Integer) ligne.elementAt(4));
            livreur.setAdresseLivreur((String) ligne.elementAt(5));
            livreur.setCodePostalLivreur((Integer) ligne.elementAt(6));
            livreur.setVilleLivreur((String) ligne.elementAt(7));
            livreur.setNumeroSecteur((Integer) ligne.elementAt(8));
        }
        else 
        {
            if (rowCount == 0)
            {
                throw new SQLException(
                    "Contact " + livreur.getIdLivreur()+ " inconnu");
            }
            else
            {
                throw new SQLException(
                    "Clef " + livreur.getIdLivreur() + " en double !");
            }
        }
    }
    
// --------------------------------------------------------------------------
// Creation (insert) d'un objet Contact
// --------------------------------------------------------------------------
    public int creer(Livreur livreur) throws SQLException
    {
        int rowCount;
        String insert;

        Integer idLivreur = livreur.getIdLivreur();
        String nom = livreur.getNomLivreur();
        String prenom = livreur.getPrenomLivreur();
        Integer numPermisLivreur = livreur.getNumPermisLivreur();
        String adresse = livreur.getAdresseLivreur();
        Integer codePostal = livreur.getCodePostalLivreur();
        String ville = livreur.getVilleLivreur();
        Integer numeroSecteur = livreur.getNumeroSecteur();

        insert = "INSERT INTO LIVREUR VALUES("
            + idLivreur + ", "
            + Conversion.chaineSQL(nom) + ", "
            + Conversion.chaineSQL(prenom) + ", "
            + numPermisLivreur + ", "
            + Conversion.chaineSQL(adresse) + ", "
            + codePostal + ", "    
            + Conversion.chaineSQL(ville) + ")";

        rowCount = accesBase.executeUpdate(insert);

        return rowCount;
    }

// --------------------------------------------------------------------------
// Modification (update) d'un objet Contact
// --------------------------------------------------------------------------
    public int modifier(Livreur livreur) throws SQLException
    {
        int rowCount;
        String update;

        Integer idLivreur = livreur.getIdLivreur();
        String nom = livreur.getNomLivreur();
        String prenom = livreur.getPrenomLivreur();
        Integer numPermisLivreur = livreur.getNumPermisLivreur();
        String adresse = livreur.getAdresseLivreur();
        Integer codePostal = livreur.getCodePostalLivreur();
        String ville = livreur.getVilleLivreur();
         Integer numeroSecteur = livreur.getNumeroSecteur();

        update = "UPDATE LIVREUR SET "
            + "IDLIVREUR = " + idLivreur + ", "
            + "NOM = " + Conversion.chaineSQL(nom) + ", "
            + "PRENOM = " + Conversion.chaineSQL(prenom) + ", "
            + "NUMPERMISLIVREUR = " + numPermisLivreur + ", "     
            + "ADRESSE = " + Conversion.chaineSQL(adresse) + ", "
            + "CODE_POSTAL = " + codePostal + ", "
            + "VILLE = " + Conversion.chaineSQL(ville) + ", "
            + "NUMEROSECTEUR = " + numeroSecteur + " "
            + "WHERE NUMERO = " + numeroSecteur;

        rowCount = accesBase.executeUpdate(update);

        return rowCount;
    }

// --------------------------------------------------------------------------
// Destruction (delete) d'un objet Contact
// --------------------------------------------------------------------------
    public int detruire(Livreur livreur) throws SQLException
    {
        int rowCount;
        String delete;

        Integer idLivreur = livreur.getIdLivreur();

        delete = "DELETE FROM LIVREUR WHERE NUMERO = " + idLivreur;

        rowCount = accesBase.executeUpdate(delete);

        return rowCount;
    }

// --------------------------------------------------------------------------
// Lecture d'un Livreur, pour un Secteur donne
// --------------------------------------------------------------------------
    public Livreur lireContact(Secteur secteur) throws SQLException
    {
        Livreur livreur = null;

        if (secteur.getNumeroSecteur()!= null)
        {
            livreur = new Livreur();
            //contact.setNumero(versement.getNumeroContact());
            livreur.setIdLivreur(secteur.setNumeroSecteur());
            lire(livreur);
        }
        return livreur;
    }

// --------------------------------------------------------------------------
// Liste des contacts pour un secteur donne
// --------------------------------------------------------------------------
/*    public Vector<Contact> lireListe(Secteur secteur) throws SQLException
    {
        Vector<Contact> listeContacts;
        Contact contact;

        String select = "SELECT * FROM CONTACT WHERE CODE_SECTEUR = ";
        select += secteur.getCode();

        int nombreDeContacts;
        Vector<Object> ligne;
        int i;

        jeuResultat = accesBase.executeQuery(select);

        listeContacts = new Vector<Contact>();
        nombreDeContacts = (jeuResultat.getLignes()).size();

        for (i = 0; i < nombreDeContacts; i++)
        {
            ligne = (jeuResultat.getLignes()).elementAt(i);

            contact = new Contact();
            contact.setNumero((Integer) ligne.elementAt(0));
            contact.setNom((String) ligne.elementAt(1));
            contact.setAdresse((String) ligne.elementAt(2));
            contact.setCodePostal((String) ligne.elementAt(3));
            contact.setVille((String) ligne.elementAt(4));
            contact.setCodeSecteur((Integer) ligne.elementAt(5));

            contact.setSecteur(secteur);
            listeContacts.addElement(contact);
        }

        return listeContacts;
    }
*/
    
// --------------------------------------------------------------------------
// Liste des contacts
// --------------------------------------------------------------------------
    public Vector<Livreur> lireListe() throws SQLException
    {
        Vector<Livreur> listeLivreurs;
        Livreur livreur;

        String select = "SELECT * FROM CONTACT";

        int nombreDeContacts;
        Vector<Object> ligne;
        int i;

        jeuResultat = accesBase.executeQuery(select);

        listeLivreurs = new Vector<Livreur>();
        nombreDeContacts = (jeuResultat.getLignes()).size();

        for (i = 0; i < nombreDeContacts; i++)
        {
            ligne = (jeuResultat.getLignes()).elementAt(i);

            livreur = new Livreur();
            livreur.setIdLivreur((Integer) ligne.elementAt(1));
            livreur.setNomLivreur((String) ligne.elementAt(2));
            livreur.setPrenomLivreur((String) ligne.elementAt(3));
            livreur.setNumPermisLivreur((Integer) ligne.elementAt(4));;
            livreur.setAdresseLivreur((String) ligne.elementAt(5));
            livreur.setCodePostalLivreur((Integer) ligne.elementAt(6));
            livreur.setVilleLivreur((String) ligne.elementAt(7));

            listeLivreurs.addElement(livreur);
        }

        return listeLivreurs;
    }

// --------------------------------------------------------------------------
// Liste des colonnes de la table CONTACT
// --------------------------------------------------------------------------
    public Vector<Colonne> getListeColonne()
    {
        return jeuResultat.getColonnes();
    }
        
}
