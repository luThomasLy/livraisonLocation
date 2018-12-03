
package classesMetiers;

public class Livre implements java.io.Serializable {
    private Integer idCommande;
    private Integer idLivreur;
    
// --------------------------------------------------------------------------
// Proprietes de mapping de Concerne
// --------------------------------------------------------------------------    
    private Commande commande;
    private Livreur livreur;
    
    
}
