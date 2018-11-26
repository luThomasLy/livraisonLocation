
package classesMetiers;

import java.util.Vector;

public class Produit implements java.io.Serializable {
    
// ==========================================================================
// PROPRIETES
// ==========================================================================
// Toutes les colonnes de la table y compris les clefs etrangeres
// --------------------------------------------------------------------------
    private Integer idProduit;             // Clef primaire
    private String referenceProduit;
    private String libelleProduit;
    private Double prixProduit;
    private Integer stockTotalProduit;

// --------------------------------------------------------------------------
// Proprietes de mapping à la relation Concerne 0,n
// --------------------------------------------------------------------------
    private Vector<Concerne> listeConcerne;
    
// ==========================================================================
// METHODES
// ==========================================================================
// --------------------------------------------------------------------------
// CONSTRUCTEUR
// --------------------------------------------------------------------------
    public Produit()
    {
    }
    
// --------------------------------------------------------------------------
// SETTERS
// --------------------------------------------------------------------------
    public void setIdProduit(Integer idProduit) {
        this.idProduit = idProduit;
    }

    public void setReferenceProduit(String referenceProduit) {
        this.referenceProduit = referenceProduit;
    }

    public void setLibelleProduit(String libelleProduit) {
        this.libelleProduit = libelleProduit;
    }

    public void setPrixProduit(Double prixProduit) {
        this.prixProduit = prixProduit;
    }

    public void setStockTotalProduit(Integer stockTotalProduit) {
        this.stockTotalProduit = stockTotalProduit;
    }

    //les listes des associations
    
    public void setListeConcerne(Vector<Concerne> listeConcerne) {
        this.listeConcerne = listeConcerne;
    }

// --------------------------------------------------------------------------
// GETTERS
// --------------------------------------------------------------------------
    public Integer getIdProduit() {
        return idProduit;
    }

    public String getReferenceProduit() {
        return referenceProduit;
    }

    public String getLibelleProduit() {
        return libelleProduit;
    }

    public Double getPrixProduit() {
        return prixProduit;
    }

    //les listes des associations
    
    public Vector<Concerne> getListeConcerne() {
        return listeConcerne;
    }

// --------------------------------------------------------------------------
// AFFICHAGE DU PRODUIT (POUR MISE AU POINT)
// --------------------------------------------------------------------------
    public String toString()
    {
        String retour;

        retour = "id produit              : " + idProduit + "\n";
        retour += "reference produit                 : " + referenceProduit + "\n";
        retour += "libelle produit              : " + libelleProduit + "\n";
        retour += "prix produit         : " + prixProduit + "\n";
        retour += "stock total produit               : " + stockTotalProduit + "\n";

        return retour;
    }   
}
