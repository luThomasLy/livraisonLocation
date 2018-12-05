
package daoJdbcMapping;

import classesMetiers.Produit;
import java.sql.SQLException;
import java.util.Vector;
import jdbc.AccesBase;
import jdbc.JeuResultat;

public class ProduitDAO {
// ==========================================================================
// PROPRIETES
// ==========================================================================
// --------------------------------------------------------------------------
// Acces a la base de donnees liee a la table PRODUIT
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
    public ProduitDAO(AccesBase accesBase)
    {
        this.accesBase = accesBase;
    }    

// --------------------------------------------------------------------------
// Lecture d'un objet Produit (dont la clef est renseignee)
// --------------------------------------------------------------------------
    public void lire(Produit produit) throws SQLException
    {
        int rowCount;

        String select;
        Vector<Object> ligne;

        select = "SELECT * FROM PRODUIT WHERE IDPRODUIT = " + produit.getIdProduit();

        jeuResultat = accesBase.executeQuery(select);

        rowCount = (jeuResultat.getLignes()).size();    

// --------------------------------------------------------------------------
// Si le executeQuery retourne 0 ligne, il n'y a pas SQLException. C'est la
// raison de la creation d'une SQLException particuliere.
// --------------------------------------------------------------------------
        if (rowCount == 1)
        {
            ligne = (jeuResultat.getLignes()).elementAt(0);

            produit.setIdProduit((Integer) ligne.elementAt(0));
            produit.setReferenceProduit((String) ligne.elementAt(1));
            produit.setLibelleProduit((String) ligne.elementAt(2));
            produit.setPrixProduit((Double) ligne.elementAt(3));
            produit.setStockTotalProduit((Integer) ligne.elementAt(4));
        }
        else 
        {
            if (rowCount == 0)
            {
                throw new SQLException(
                    "Produit " + produit.getIdProduit() + " inconnu");
            }
            else
            {
                throw new SQLException(
                    "Clef " + produit.getIdProduit() + " en double !");
            }
        }
    }

// --------------------------------------------------------------------------
// Creation (insert) d'un objet Produit
// --------------------------------------------------------------------------
    
    
}
