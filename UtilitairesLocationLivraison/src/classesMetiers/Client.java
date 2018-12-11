
package classesMetiers;

import java.util.Vector;

public class Client implements java.io.Serializable{
    
// ==========================================================================
// PROPRIETES
// ==========================================================================
// Toutes les colonnes de la table y compris les clefs etrangeres
// --------------------------------------------------------------------------
    private Integer idClient;             // Clef primaire
    private String nomClient;
    private String prenomClient;
    private String adresseClient; 
    private Integer codePostalClient;
    private String villeClient; 
    private Integer numeroTelClient;
    private String mailClient;
    
// --------------------------------------------------------------------------
// Proprietes de mapping avec la table Commande
// --------------------------------------------------------------------------
    //private Vector <Effectue> listeEffectue;

// ==========================================================================
// METHODES
// ==========================================================================
// --------------------------------------------------------------------------
// CONSTRUCTEUR
// --------------------------------------------------------------------------      
    public Client () 
    {
    }    
    
// --------------------------------------------------------------------------
// SETTERS
// --------------------------------------------------------------------------
    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public void setPrenomClient(String prenomClient) {
        this.prenomClient = prenomClient;
    }

    public void setAdresseClient(String adresseClient) {
        this.adresseClient = adresseClient;
    }

    public void setCodePostalClient(Integer codePostalClient) {
        this.codePostalClient = codePostalClient;
    }

    public void setVilleClient(String villeClient) {
        this.villeClient = villeClient;
    }

    public void setNumeroTelClient(Integer numeroTelClient) {
        this.numeroTelClient = numeroTelClient;
    }

    public void setMailClient(String mailClient) {
        this.mailClient = mailClient;
    }

// --------------------------------------------------------------------------
// GETTERS
// --------------------------------------------------------------------------
    public Integer getIdClient() {
        return idClient;
    }

    public String getNomClient() {
        return nomClient;
    }

    public String getPrenomClient() {
        return prenomClient;
    }

    public String getAdresseClient() {
        return adresseClient;
    }

    public Integer getCodePostalClient() {
        return codePostalClient;
    }

    public String getVilleClient() {
        return villeClient;
    }

    public Integer getNumeroTelClient() {
        return numeroTelClient;
    }

    public String getMailClient() {
        return mailClient;
    }
    
    //les listes des associations

//    public Vector<Effectue> getListeEffectue() {
//        return listeEffectue;
//    }
   
// --------------------------------------------------------------------------
// AFFICHAGE DE LA COMMANDE (POUR MISE AU POINT)
// --------------------------------------------------------------------------
    public String toString()
    {
        String retour;
        int i;

        retour = "id Client                : " + idClient + "\n";
        retour += "nom Client             : " + nomClient + "\n";
        retour += "prenom Client             : " + prenomClient + "\n";
        retour += "adresse Client             : " + adresseClient + "\n";
        retour += "code Postal Client             : " + codePostalClient + "\n";
        retour += "ville Client             : " + villeClient + "\n";
        retour += "numero Tel Client             : " + numeroTelClient + "\n";
        retour += "mail Client             : " + mailClient + "\n";

        return retour;
    }    
    
    
    
    
}
