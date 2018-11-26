package classesMetiers;

import java.util.Vector;

public class Secteur implements java.io.Serializable {
    private Livreur livreur;

// ==========================================================================
// PROPRIETES
// ==========================================================================
// Toutes les colonnes de la table y compris les clefs etrangeres
// --------------------------------------------------------------------------
    private Integer numeroSecteur;             // Clef primaire
    private String libelleSecteur;
    
    //private Integer idLivreur;                 // Clef etrangere vers Livreur
    private Vector<Livreur> listeLivreurs;
    

// ==========================================================================
// METHODES
// ==========================================================================
// --------------------------------------------------------------------------
// CONSTRUCTEUR
// --------------------------------------------------------------------------
    public Secteur() {
    }
    
// --------------------------------------------------------------------------
// SETTERS
// --------------------------------------------------------------------------
    public void setNumeroSecteur(Integer numeroSecteur)
    {
        this.numeroSecteur = numeroSecteur; 
    }

    public void setLibelleSecteur(String libelle)
    {
        this.libelleSecteur = libelleSecteur;
    }

    public void setListeLivreurs(Vector<Livreur> listeLivreurs) {
        this.listeLivreurs = listeLivreurs;
    }
    
    
// --------------------------------------------------------------------------
// GETTERS
// --------------------------------------------------------------------------
    public Integer getNumeroSecteur()
    {
        return numeroSecteur;
    }

    public String getLibelleSecteur()
    {
        return libelleSecteur;
    }

    public Vector<Livreur> getListeLivreurs() {
        return listeLivreurs;
    }
    
    
// --------------------------------------------------------------------------
// AFFICHAGE DU SECTEUR (POUR MISE AU POINT)
// --------------------------------------------------------------------------
    public String toString()
    {
        String retour;
        int i;

        retour = "Code                : " + numeroSecteur + "\n";
        retour += "Libelle             : " + libelleSecteur + "\n";

        return retour;
    }

    public Integer setNumeroSecteur() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
