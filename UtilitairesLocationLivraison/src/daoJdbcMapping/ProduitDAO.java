package daoJdbcMapping;

import classesMetiers.Concerne;
import classesMetiers.Produit;
import diversUtilitaires.Colonne;
import diversUtilitaires.Conversion;
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
    public ProduitDAO(AccesBase accesBase) {
        this.accesBase = accesBase;
    }

// --------------------------------------------------------------------------
// Lecture d'un objet Produit (dont la clef est renseignee)
// --------------------------------------------------------------------------
    public void lire(Produit produit) throws SQLException {
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
        if (rowCount == 1) {
            ligne = (jeuResultat.getLignes()).elementAt(0);

            produit.setIdProduit((Integer) ligne.elementAt(0));
            produit.setReferenceProduit((String) ligne.elementAt(1));
            produit.setLibelleProduit((String) ligne.elementAt(2));
            produit.setPrixProduit((Double) ligne.elementAt(3));
            produit.setStockTotalProduit((Integer) ligne.elementAt(4));
        } else {
            if (rowCount == 0) {
                throw new SQLException(
                        "Produit " + produit.getIdProduit() + " inconnu");
            } else {
                throw new SQLException(
                        "Clef " + produit.getIdProduit() + " en double !");
            }
        }
    }

// --------------------------------------------------------------------------
// Creation (insert) d'un objet Produit
// --------------------------------------------------------------------------
    public int creer(Produit produit) throws SQLException {
        int rowCount;
        String insert;

        Integer idProduit = produit.getIdProduit();
        String referenceProduit = produit.getReferenceProduit();
        String libelleProduit = produit.getLibelleProduit();
        Double prixProduit = produit.getPrixProduit();
        Integer stockTotalProduit = produit.getStockTotalProduit();

        insert = "INSERT INTO PRODUIT VALUES("
                + idProduit + ", "
                + Conversion.chaineSQL(referenceProduit) + ", "
                + Conversion.chaineSQL(libelleProduit) + ", "
                + prixProduit + ", "
                + stockTotalProduit + ")";

        rowCount = accesBase.executeUpdate(insert);

        return rowCount;
    }

// --------------------------------------------------------------------------
// Modification (update) d'un objet Produit
// --------------------------------------------------------------------------
    public int modifier(Produit produit) throws SQLException {
        int rowCount;
        String update;

        Integer idProduit = produit.getIdProduit();
        String referenceProduit = produit.getReferenceProduit();
        String libelleProduit = produit.getLibelleProduit();
        Double prixProduit = produit.getPrixProduit();
        Integer stockTotalProduit = produit.getStockTotalProduit();

        update = "UPDATE PRODUIT SET "
                + "IDPRODUIT = " + idProduit + ", "
                + "REFERENCEPRODUIT = " + Conversion.chaineSQL(referenceProduit) + ", "
                + "LIBELLEPRODUIT = " + Conversion.chaineSQL(libelleProduit) + ", "
                + "PRIXPRODUIT = " + prixProduit + ", "
                + "STOCKTOTALPRODUIT = " + stockTotalProduit ;

        rowCount = accesBase.executeUpdate(update);

        return rowCount;
    }
    
// --------------------------------------------------------------------------
// Destruction (delete) d'un objet Produit
// --------------------------------------------------------------------------
    public int detruire(Produit produit) throws SQLException
    {
        int rowCount;
        String delete;

        Integer idProduit = produit.getIdProduit();

        delete = "DELETE FROM PRODUIT WHERE IDPRODUIT = " + idProduit;

        rowCount = accesBase.executeUpdate(delete);

        return rowCount;
    }
    
// --------------------------------------------------------------------------
// Lecture d'un Livreur, pour un Secteur donne
// --------------------------------------------------------------------------
    public Produit lireProduit(Concerne concerne) throws SQLException
    {
        Produit produit = null;

        if (concerne.getIdProduit()!= null)
        {
            produit = new Produit();
            produit.setIdProduit(concerne.getIdProduit());
            lire(produit);
        }
        return produit;
    }    
    
// --------------------------------------------------------------------------
// Liste des Produits pour un concerne donne
// --------------------------------------------------------------------------
    public Vector<Produit> lireListe(Concerne concerne) throws SQLException
    {
        Vector<Produit> listeProduits;
        Produit produit;

        String select = "SELECT * FROM PRODUIT WHERE IDPRODUIT = ";
        select += concerne.getIdProduit();

        int nombreDeProduits;
        Vector<Object> ligne;
        int i;

        jeuResultat = accesBase.executeQuery(select);

        listeProduits = new Vector<Produit>();
        nombreDeProduits = (jeuResultat.getLignes()).size();

        for (i = 0; i < nombreDeProduits; i++)
        {
            ligne = (jeuResultat.getLignes()).elementAt(i);

            produit = new Produit();
            
            produit.setIdProduit((Integer) ligne.elementAt(1));
            produit.setReferenceProduit((String) ligne.elementAt(2));
            produit.setLibelleProduit((String) ligne.elementAt(3));
            produit.setPrixProduit((Double) ligne.elementAt(4));
            produit.setStockTotalProduit((Integer) ligne.elementAt(5));
            
            //produit.setIdProduit(concerne);
            listeProduits.addElement(produit);
        }

        return listeProduits;
    }    
    
// --------------------------------------------------------------------------
// Liste des Produits
// --------------------------------------------------------------------------
    public Vector<Produit> lireListe() throws SQLException
    {
        Vector<Produit> listeProduits;
        Produit produit;

        String select = "SELECT * FROM PRODUIT";

        int nombreDeProduits;
        Vector<Object> ligne;
        int i;

        jeuResultat = accesBase.executeQuery(select);

        listeProduits = new Vector<Produit>();
        nombreDeProduits = (jeuResultat.getLignes()).size();

        for (i = 0; i < nombreDeProduits; i++)
        {
            ligne = (jeuResultat.getLignes()).elementAt(i);

             produit = new Produit();
            
            produit.setIdProduit((Integer) ligne.elementAt(1));
            produit.setReferenceProduit((String) ligne.elementAt(2));
            produit.setLibelleProduit((String) ligne.elementAt(3));
            produit.setPrixProduit((Double) ligne.elementAt(4));
            produit.setStockTotalProduit((Integer) ligne.elementAt(5));
            
            //produit.setIdProduit(concerne);
            listeProduits.addElement(produit);
        }

        return listeProduits;
    }
    
// --------------------------------------------------------------------------
// Liste des colonnes de la table LIVREUR
// --------------------------------------------------------------------------
    public Vector<Colonne> getListeColonnes() {
        return jeuResultat.getColonnes();
    }

}
