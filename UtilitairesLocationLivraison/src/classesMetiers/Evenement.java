
package classesMetiers;

import java.util.Vector;
/**
 *
 * @author ninjakonoha
 */
public class Evenement implements java.io.Serializable {
    
// ==========================================================================
// PROPRIETES
// ==========================================================================
// Toutes les colonnes de la table y compris les clefs etrangeres
// --------------------------------------------------------------------------
    private Integer idEvenement;                // Clef primaire
    private String nomEvenement;
    private String adresseEvenement;
    private String codePostalEvenement;
    private String villeEvenemnt;
    
    private Integer idCommande;                 // Clef etrangère

// --------------------------------------------------------------------------
// Proprietes de mapping avec la relation Correspond
// --------------------------------------------------------------------------
//    private Vector <Correspond> listeCorrespond;

// ==========================================================================
// METHODES
// ==========================================================================
// --------------------------------------------------------------------------
// CONSTRUCTEUR
// --------------------------------------------------------------------------      
    public Evenement () 
    {
    }

// --------------------------------------------------------------------------
// SETTERS
// --------------------------------------------------------------------------

    public void setIdEvenement(Integer idEvenement) {
        this.idEvenement = idEvenement;
    }

    public void setNomEvenement(String nomEvenement) {
        this.nomEvenement = nomEvenement;
    }

    public void setAdresseEvenement(String adresseEvenement) {
        this.adresseEvenement = adresseEvenement;
    }

    public void setCodePostalEvenement(String codePostalEvenement) {
        this.codePostalEvenement = codePostalEvenement;
    }

    public void setVilleEvenemnt(String villeEvenemnt) {
        this.villeEvenemnt = villeEvenemnt;
    }

    //les listes des associations
    
//    public void setListeCorrespond(Vector<Correspond> listeCorrespond) {
//        this.listeCorrespond = listeCorrespond;
//    }

// --------------------------------------------------------------------------
// GETTERS
// --------------------------------------------------------------------------

    public Integer getIdEvenement() {
        return idEvenement;
    }

    public String getNomEvenement() {
        return nomEvenement;
    }

    public String getAdresseEvenement() {
        return adresseEvenement;
    }

    public String getCodePostalEvenement() {
        return codePostalEvenement;
    }

    public String getVilleEvenemnt() {
        return villeEvenemnt;
    }

    //les listes des associations
    
//    public Vector<Correspond> getListeCorrespond() {
//        return listeCorrespond;
//    }
    
    
}
