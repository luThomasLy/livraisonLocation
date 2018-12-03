
package classesMetiers;

import java.util.Vector;
/**
 *
 * @author ninjakonoha
 */
public class Commande implements java.io.Serializable{
    
// ==========================================================================
// PROPRIETES
// ==========================================================================
// Toutes les colonnes de la table y compris les clefs etrangeres
// --------------------------------------------------------------------------
    private Integer idCommande;             // Clef primaire
    private String dateCommande;

// --------------------------------------------------------------------------
// Proprietes de mapping des tables et relations
// --------------------------------------------------------------------------
    
    private Vector<Recupere> listeRecupere;
    private Vector<Livre> listeLivre;
    private Vector<Concerne> listeConcerne;
//    private Vector<Correspond> listeCorrespond;
    private Vector<Effectue> listeEffectue;

// ==========================================================================
// METHODES
// ==========================================================================
// --------------------------------------------------------------------------
// CONSTRUCTEUR
// --------------------------------------------------------------------------        
    public Commande () 
    {
    }
    
// --------------------------------------------------------------------------
// SETTERS
// --------------------------------------------------------------------------
    public void setIdCommande(Integer idCommande) {
        this.idCommande = idCommande;
    }

    public void setDateCommande(String dateCommande) {
        this.dateCommande = dateCommande;
    }

    //les listes des associations
    
    public void setListeRecupere(Vector<Recupere> listeRecupere) {
        this.listeRecupere = listeRecupere;
    }

    public void setListeLivre(Vector<Livre> listeLivre) {
        this.listeLivre = listeLivre;
    }

    public void setListeConcerne(Vector<Concerne> listeConcerne) {
        this.listeConcerne = listeConcerne;
    }

//    public void setListeCorrespond(Vector<Correspond> listeCorrespond) {
//        this.listeCorrespond = listeCorrespond;
//    }

    public void setListeEffectue(Vector<Effectue> listeEffectue) {
        this.listeEffectue = listeEffectue;
    }

// --------------------------------------------------------------------------
// GETTERS
// --------------------------------------------------------------------------
    public Integer getIdCommande() {
        return idCommande;
    }

    public String getDateCommande() {
        return dateCommande;
    }
    
    //les listes des associations

    public Vector<Recupere> getListeRecupere() {
        return listeRecupere;
    }

    public Vector<Livre> getListeLivre() {
        return listeLivre;
    }

    public Vector<Concerne> getListeConcerne() {
        return listeConcerne;
    }

//    public Vector<Correspond> getListeCorrespond() {
//        return listeCorrespond;
//    }

    public Vector<Effectue> getListeEffectue() {
        return listeEffectue;
    }
    
// --------------------------------------------------------------------------
// AFFICHAGE DE LA COMMANDE (POUR MISE AU POINT)
// --------------------------------------------------------------------------
    public String toString()
    {
        String retour;
        int i;

        retour = "id Commande                : " + idCommande + "\n";
        retour += "date Commande             : " + dateCommande + "\n";

        return retour;
    }        
}
