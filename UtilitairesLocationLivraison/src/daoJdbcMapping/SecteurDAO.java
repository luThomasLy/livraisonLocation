
package daoJdbcMapping;

import classesMetiers.Livreur;
import classesMetiers.Secteur;
import diversUtilitaires.Colonne;
import diversUtilitaires.Conversion;
import java.sql.SQLException;
import java.util.Vector;
import jdbc.AccesBase;
import jdbc.JeuResultat;


public class SecteurDAO {
    
// ==========================================================================
// PROPRIETES
// ==========================================================================
// --------------------------------------------------------------------------
// Acces a la base de donnees liee a la table SECTEUR
// --------------------------------------------------------------------------
    private AccesBase accesBase;

// --------------------------------------------------------------------------
// Jeu de resultats lu par l'un des "executeQuery"
// Il contient toutes les donnees des lignes lues dans la table SECTEUR et
// les donnees relatives aux colonnes.
// --------------------------------------------------------------------------
    private JeuResultat jeuResultat;

// ==========================================================================
// METHODES
// ==========================================================================
// --------------------------------------------------------------------------
// Constructeur
// --------------------------------------------------------------------------
    public SecteurDAO(AccesBase accesBase)
    {
        this.accesBase = accesBase;
    }
    
// --------------------------------------------------------------------------
// Lecture d'un objet Secteur (dont la clef est renseignee)
// --------------------------------------------------------------------------
    public void lire(Secteur secteur) throws SQLException
    {
        int rowCount;

        String select;
        Vector<Object> ligne;

        select = "SELECT * FROM SECTEUR WHERE NUMEROSECTEUR = " + secteur.getNumeroSecteur();

        jeuResultat = accesBase.executeQuery(select);

        rowCount = (jeuResultat.getLignes()).size();

// --------------------------------------------------------------------------
// Si le executeQuery retourne 0 ligne, il n'y a pas SQLException. C'est la
// raison de la creation d'une SQLException particuliere.
// --------------------------------------------------------------------------
        if (rowCount == 1)
        {
            ligne = (jeuResultat.getLignes()).elementAt(0);
            
            secteur.setNumeroSecteur((Integer) ligne.elementAt(0));
            secteur.setLibelleSecteur((String) ligne.elementAt(1));
        }
        else 
        {
            if (rowCount == 0)
            {
                throw new SQLException(
                    "Secteur " + secteur.getNumeroSecteur() + " inconnu");
            }
            else
            {
                throw new SQLException(
                    "Clef " + secteur.getNumeroSecteur() + " en double !");
            }
        }
    }

// --------------------------------------------------------------------------
// Creation (insert) d'un objet Secteur
// --------------------------------------------------------------------------
    public int creer(Secteur secteur) throws SQLException
    {
        int rowCount;
        String insert;

        Integer numeroSecteur = secteur.getNumeroSecteur();
        String libelleSecteur = secteur.getLibelleSecteur();

        insert = "INSERT INTO SECTEUR VALUES("
            + numeroSecteur + ", "
            + Conversion.chaineSQL(libelleSecteur) + ")";

        rowCount = accesBase.executeUpdate(insert);

        return rowCount;
    }

// --------------------------------------------------------------------------
// Modification (update) d'un objet Secteur
// --------------------------------------------------------------------------
    public int modifier(Secteur secteur) throws SQLException
    {
        int rowCount;
        String update;

        Integer numeroSecteur = secteur.getNumeroSecteur();
        String libelleSecteur = secteur.getLibelleSecteur();

        update = "UPDATE SECTEUR SET "
            + "LIBELLESECTEUR = " + Conversion.chaineSQL(libelleSecteur) + " "
            + "WHERE NUMEROSECTEUR = " + numeroSecteur;

        rowCount = accesBase.executeUpdate(update);

        return rowCount;
    }

// --------------------------------------------------------------------------
// Destruction (delete) d'un objet Secteur
// --------------------------------------------------------------------------
    public int detruire(Secteur secteur) throws SQLException
    {
        int rowCount;
        String delete;

        Integer numeroSecteur = secteur.getNumeroSecteur();

        delete = "DELETE FROM SECTEUR WHERE NUMEROSECTEUR = " + numeroSecteur;

        rowCount = accesBase.executeUpdate(delete);

        return rowCount;
    }

// --------------------------------------------------------------------------
// Lecture d'un Secteur, pour un Livreur donne
// --------------------------------------------------------------------------
    public Secteur lireSecteur(Livreur livreur) throws SQLException
    {
        Secteur secteur = null;

        if (livreur.getNumeroSecteur() != null)
        {
            secteur = new Secteur();
            secteur.setNumeroSecteur(livreur.getNumeroSecteur());
            lire(secteur);
        }
        return secteur;
    }

// --------------------------------------------------------------------------
// Liste des secteurs
// --------------------------------------------------------------------------
    public Vector<Secteur> lireListe() throws SQLException
    {
        Vector<Secteur> listeSecteurs;
        Secteur secteur;

        String select = "SELECT * FROM SECTEUR";

        int nombreSecteurs;
        Vector ligne;
        int i;

        jeuResultat = accesBase.executeQuery(select);

        listeSecteurs = new Vector<Secteur>();
        nombreSecteurs = (jeuResultat.getLignes()).size();

        for (i = 0; i < nombreSecteurs; i++)
        {
            ligne = (jeuResultat.getLignes()).elementAt(i);

            secteur = new Secteur();
            secteur.setNumeroSecteur((Integer) ligne.elementAt(0));
            secteur.setLibelleSecteur((String) ligne.elementAt(1));

            listeSecteurs.addElement(secteur);
        }

        return listeSecteurs;
    }

// --------------------------------------------------------------------------
// Liste des colonnes de la table SECTEUR
// --------------------------------------------------------------------------
    public Vector<Colonne> getListeColonnes()
    {
        return jeuResultat.getColonnes();
    }   
}
