package classesMetiers;

import java.util.Vector;

public class Livreur implements java.io.Serializable {

// ==========================================================================
// PROPRIETES
// ==========================================================================
// Toutes les colonnes de la table y compris les clefs etrangeres
// --------------------------------------------------------------------------
    private Integer idLivreur;                      // Clef primaire
    private String nomLivreur;
    private String prenomLivreur;
    private Integer numPermisLivreur;
    private String adresseLivreur;
    private Integer codePostalLivreur;
    private String villeLivreur;
    private Integer numeroTelephoneLivreur;
    
    private Integer numeroSecteur;                 // Clef etrangere vers Secteur

// --------------------------------------------------------------------------
// Proprietes de mapping à la relation Recupere et Livre 0,n et 1,n
// et à la table Secteur 1,1    
// --------------------------------------------------------------------------
    private Secteur secteur;
    
    private Vector<Recupere> listeRecupere; //relation à créer
    private Vector<Livre> listeLivre; //relation à créer
    

// ==========================================================================
// METHODES
// ==========================================================================
// --------------------------------------------------------------------------
// CONSTRUCTEUR
// --------------------------------------------------------------------------
    public Livreur() {
    }

// --------------------------------------------------------------------------
// SETTERS
// --------------------------------------------------------------------------
  

    public void setNomLivreur(String nomLivreur) {
        this.nomLivreur = nomLivreur;
    }

    public void setPrenomLivreur(String prenomLivreur) {
        this.prenomLivreur = prenomLivreur;
    }

    public void setNumPermisLivreur(Integer numPermisLivreur) {
        this.numPermisLivreur = numPermisLivreur;
    }
    
    public void setAdresseLivreur(String adresseLivreur) {
        this.adresseLivreur = adresseLivreur;
    }

    public void setCodePostalLivreur(Integer codePostalLivreur) {
        this.codePostalLivreur = codePostalLivreur;
    }

    public void setVilleLivreur(String villeLivreur) {
        this.villeLivreur = villeLivreur;
    }

    public void setNumeroTelephoneLivreur(Integer numeroTelephoneLivreur) {
        this.numeroTelephoneLivreur = numeroTelephoneLivreur;
    }

    public void setNumeroSecteur(Integer numeroSecteur) {
        this.numeroSecteur = numeroSecteur;
    }

    public void setSecteur(Secteur secteur) {
        this.secteur = secteur;

        if (secteur != null)
        {
            this.setNumeroSecteur(secteur.getNumeroSecteur());
        }
        else
        {
            this.setNumeroSecteur(null);
        }
    }

    //les listes des associations

    public void setListeRecupere(Vector<Recupere> listeRecupere) {
        this.listeRecupere = listeRecupere;
    }

    public void setListeLivre(Vector<Livre> listeLivre) {
        this.listeLivre = listeLivre;
    }

// --------------------------------------------------------------------------
// GETTERS
// --------------------------------------------------------------------------
    public Integer getIdLivreur() {
        return idLivreur;
    }

    public String getNomLivreur() {
        return nomLivreur;
    }

    public String getPrenomLivreur() {
        return prenomLivreur;
    }

    public Integer getNumPermisLivreur() {
        return numPermisLivreur;
    }

    public String getAdresseLivreur() {
        return adresseLivreur;
    }

    public Integer getCodePostalLivreur() {
        return codePostalLivreur;
    }

    public String getVilleLivreur() {
        return villeLivreur;
    }

    public Integer getNumeroTelephoneLivreur() {
        return numeroTelephoneLivreur;
    }

    public Integer getNumeroSecteur() {
        return numeroSecteur;
    }

    public Secteur getSecteur() {
        return secteur;
    }
    
    //les listes des associations

    public Vector<Recupere> getListeRecupere() {
        return listeRecupere;
    }

    public Vector<Livre> getListeLivre() {
        return listeLivre;
    }
    
// --------------------------------------------------------------------------
// AFFICHAGE DU LIVREUR (POUR MISE AU POINT)
// --------------------------------------------------------------------------
    public String toString()
    {
        String retour;

        retour = "id livreur              : " + getIdLivreur() + "\n";
        retour += "nom livreur                 : " + getNomLivreur() + "\n";
        retour += "prenom livreur                 : " + getPrenomLivreur() + "\n";
        retour += "num permis livreur             : " + getNumPermisLivreur() + "\n";
        retour += "adresse livreur         : " + getAdresseLivreur() + "\n";
        retour += "code postal livreur               : " + getCodePostalLivreur() + "\n";
        retour += "ville livreur        : " + getVilleLivreur() + "\n";

        return retour;
    }

    /**
     * @param idLivreur the idLivreur to set
     */
    public void setIdLivreur(Integer idLivreur) {
        this.idLivreur = idLivreur;
    }


   
}
