
package classesMetiers;

public class Concerne implements java.io.Serializable{
    
    private Integer idProduit;          // Clef primaire de Produit
    private Integer idCommande;         // Clef primaire de Commande
    private Integer quantiteCommande;
    
// --------------------------------------------------------------------------
// Proprietes de mapping de Concerne
// --------------------------------------------------------------------------    
    private Produit produit;
    private Commande commande;
    
// ==========================================================================
// METHODES
// ==========================================================================
// --------------------------------------------------------------------------
// CONSTRUCTEUR
// --------------------------------------------------------------------------      
    public Concerne () 
    {
    }  
    
// --------------------------------------------------------------------------
// SETTERS
// --------------------------------------------------------------------------   
    public void setIdProduit(Integer idProduit) {
        this.idProduit = idProduit;
    }

    public void setIdCommande(Integer idCommande) {
        this.idCommande = idCommande;
    }

    public void setQuantiteCommande(Integer quantiteCommande) {
        this.quantiteCommande = quantiteCommande;
    }

// --------------------------------------------------------------------------
// GETTERS
// --------------------------------------------------------------------------
    public Integer getIdProduit() {
        return idProduit;
    }

    public Integer getIdCommande() {
        return idCommande;
    }

    public Integer getQuantiteCommande() {
        return quantiteCommande;
    }
    
}
