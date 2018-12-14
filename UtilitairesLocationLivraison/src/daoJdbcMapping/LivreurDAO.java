
package daoJdbcMapping;

//import classesMetiers.Livreur;

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
// Acces a la base de donnees liee a la table LIVREUR
// --------------------------------------------------------------------------
    private AccesBase accesBase;

// --------------------------------------------------------------------------
// Jeu de resultats lu par l'un des "executeQuery"
// Il contient toutes les donnees des lignes lues dans la table livreur et
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

        select = "SELECT * FROM LIVREUR WHERE IDLIVREUR = " + livreur.getIdLivreur();

        jeuResultat = accesBase.executeQuery(select);

        rowCount = (jeuResultat.getLignes()).size();
    
// --------------------------------------------------------------------------
// Si le executeQuery retourne 0 ligne, il n'y a pas SQLException. C'est la
// raison de la creation d'une SQLException particuliere.
// --------------------------------------------------------------------------
        if (rowCount == 1)
        {
            ligne = (jeuResultat.getLignes()).elementAt(0);

            //livreur.setIdLivreur((Integer) ligne.elementAt(0));
            livreur.setNomLivreur((String) ligne.elementAt(1));
            livreur.setPrenomLivreur((String) ligne.elementAt(2));
            livreur.setNumPermisLivreur((Integer) ligne.elementAt(3));
            livreur.setAdresseLivreur((String) ligne.elementAt(4));
            livreur.setCodePostalLivreur((Integer) ligne.elementAt(5));
            livreur.setVilleLivreur((String) ligne.elementAt(6));
            livreur.setNumeroTelephoneLivreur((Integer) ligne.elementAt(7));
           
            livreur.setNumeroSecteur((Integer) ligne.elementAt(8));
        }
        else 
        {
            if (rowCount == 0)
            {
                throw new SQLException(
                    "Livreur " + livreur.getIdLivreur() + " inconnu");
            }
            else
            {
                throw new SQLException(
                    "Clef " + livreur.getIdLivreur() + " en double !");
            }
        }
    }
    
// --------------------------------------------------------------------------
// Creation (insert) d'un objet Livreur
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
// Modification (update) d'un objet Livreur
// --------------------------------------------------------------------------
    public int modifier(Livreur livreur) throws SQLException
    {
        int rowCount;
        String update;

        Integer idLivreur = livreur.getIdLivreur();
        String nomLivreur = livreur.getNomLivreur();
        String prenomLivreur = livreur.getPrenomLivreur();
        Integer numPermisLivreur = livreur.getNumPermisLivreur();
        String adresseLivreur = livreur.getAdresseLivreur();
        Integer codePostalLivreur = livreur.getCodePostalLivreur();
        String villeLivreur = livreur.getVilleLivreur();
        Integer numeroSecteur = livreur.getNumeroSecteur();

        update = "UPDATE LIVREUR SET "
            + "IDLIVREUR = " + idLivreur + ", "
            + "NOMLIVREUR = " + Conversion.chaineSQL(nomLivreur) + ", "
            + "PRENOMLIVREUR = " + Conversion.chaineSQL(prenomLivreur) + ", "
            + "NUMPERMISLIVREUR = " + numPermisLivreur + ", "     
            + "ADRESSELIVREUR = " + Conversion.chaineSQL(adresseLivreur) + ", "
            + "CODEPOSTALLIVREUR = " + codePostalLivreur + ", "
            + "VILLELIVREUR = " + Conversion.chaineSQL(villeLivreur) + ", "
            + "NUMEROSECTEUR = " + numeroSecteur + ", "
            + "WHERE NUMEROSECTEUR = " + numeroSecteur;

        rowCount = accesBase.executeUpdate(update);

        return rowCount;
    }

// --------------------------------------------------------------------------
// Destruction (delete) d'un objet Livreur
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
    public Livreur lireLivreur(Secteur secteur) throws SQLException
    {
        Livreur livreur = null;

        if (secteur.getNumeroSecteur()!= null)
        {
            livreur = new Livreur();
            livreur.setIdLivreur(secteur.getNumeroSecteur());
            lire(livreur);
        }
        return livreur;
    }

// --------------------------------------------------------------------------
// Liste des livreurs pour un secteur donne
// --------------------------------------------------------------------------
    public Vector<Livreur> lireListe(Secteur secteur) throws SQLException
    {
        Vector<Livreur> listeLivreurs;
        Livreur livreur;

        String select = "SELECT * FROM LIVREUR WHERE NUMEROSECTEUR = ";
        select += secteur.getNumeroSecteur();

        int nombreDeLivreurs;
        Vector<Object> ligne;
        int i;

        jeuResultat = accesBase.executeQuery(select);

        listeLivreurs = new Vector<Livreur>();
        nombreDeLivreurs = (jeuResultat.getLignes()).size();

        for (i = 0; i < nombreDeLivreurs; i++)
        {
            ligne = (jeuResultat.getLignes()).elementAt(i);

            livreur = new Livreur();
            livreur.setIdLivreur((Integer) ligne.elementAt(1));
            livreur.setNomLivreur((String) ligne.elementAt(2));
            livreur.setPrenomLivreur((String) ligne.elementAt(3));
            livreur.setNumPermisLivreur((Integer) ligne.elementAt(4));
            livreur.setAdresseLivreur((String) ligne.elementAt(5));
            livreur.setCodePostalLivreur((Integer) ligne.elementAt(6));
            livreur.setVilleLivreur((String) ligne.elementAt(7));
            livreur.setNumeroSecteur((Integer) ligne.elementAt(8));

            livreur.setSecteur(secteur);
            listeLivreurs.addElement(livreur);
        }

        return listeLivreurs;
    }

// --------------------------------------------------------------------------
// Liste des livreurs
// --------------------------------------------------------------------------
    public Vector<Livreur> lireListe() throws SQLException
    {
        Vector<Livreur> listeLivreurs;
        Livreur livreur;

        String select = "SELECT * FROM LIVREUR";

        int nombreDeLivreurs;
        Vector<Object> ligne;
        int i;

        jeuResultat = accesBase.executeQuery(select);

        listeLivreurs = new Vector<Livreur>();
        nombreDeLivreurs = (jeuResultat.getLignes()).size();

        for (i = 0; i < nombreDeLivreurs; i++)
        {
            ligne = (jeuResultat.getLignes()).elementAt(i);

            livreur = new Livreur();
            livreur.setIdLivreur((Integer) ligne.elementAt(0));
            livreur.setNomLivreur((String) ligne.elementAt(1));
            livreur.setPrenomLivreur((String) ligne.elementAt(2));
            livreur.setNumPermisLivreur((Integer) ligne.elementAt(3));;
            livreur.setAdresseLivreur((String) ligne.elementAt(4));
            livreur.setCodePostalLivreur((Integer) ligne.elementAt(5));
            livreur.setVilleLivreur((String) ligne.elementAt(6));
            livreur.setNumeroTelephoneLivreur((Integer) ligne.elementAt(7));
            livreur.setNumeroSecteur((Integer) ligne.elementAt(8));

            listeLivreurs.addElement(livreur);
        }

        return listeLivreurs;
    }

// --------------------------------------------------------------------------
// Liste des colonnes de la table LIVREUR
// --------------------------------------------------------------------------
    public Vector<Colonne> getListeColonnes()
    {
        return jeuResultat.getColonnes();
    }
        
}
