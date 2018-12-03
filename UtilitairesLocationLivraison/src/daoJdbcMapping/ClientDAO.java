
package daoJdbcMapping;

import classesMetiers.Client;
import classesMetiers.Livreur;
import diversUtilitaires.Conversion;
import java.sql.SQLException;
import java.util.Vector;
import jdbc.AccesBase;
import jdbc.JeuResultat;

public class ClientDAO {
// ==========================================================================
// PROPRIETES
// ==========================================================================
// --------------------------------------------------------------------------
// Acces a la base de donnees liee a la table LIVREUR
// --------------------------------------------------------------------------
    private AccesBase accesBase;

// --------------------------------------------------------------------------
// Jeu de resultats lu par l'un des "executeQuery"
// Il contient toutes les donnees des lignes lues dans la table livreur et
// les donnees relatives aux colonnes.
// --------------------------------------------------------------------------
    private JeuResultat jeuResultat;

// ==========================================================================
// METHODES
// ==========================================================================
// --------------------------------------------------------------------------
// Constructeur
// --------------------------------------------------------------------------
   public ClientDAO(AccesBase accesBase)
    {
        this.accesBase = accesBase;
    }     
    
// --------------------------------------------------------------------------
// Lecture d'un objet Client (dont la clef est renseignee)
// --------------------------------------------------------------------------
    public void lire(Client client) throws SQLException
    {
        int rowCount;

        String select;
        Vector<Object> ligne;

        select = "SELECT * FROM CLIENT WHERE IDCLIENT = " + client.getIdClient();

        jeuResultat = accesBase.executeQuery(select);

        rowCount = (jeuResultat.getLignes()).size();
    
// --------------------------------------------------------------------------
// Si le executeQuery retourne 0 ligne, il n'y a pas SQLException. C'est la
// raison de la creation d'une SQLException particuliere.
// --------------------------------------------------------------------------
    if (rowCount == 1)
        {
            ligne = (jeuResultat.getLignes()).elementAt(0);

            client.setIdClient((Integer) ligne.elementAt(1));
            client.setNomClient((String) ligne.elementAt(2));
            client.setPrenomClient((String) ligne.elementAt(3));
            client.setAdresseClient((String) ligne.elementAt(4));
            client.setCodePostalClient((Integer) ligne.elementAt(5));
            client.setVilleClient((String) ligne.elementAt(6));
            client.setNumeroTelClient((Integer) ligne.elementAt(7));
            client.setMailClient((String) ligne.elementAt(8));
            
            }
        else 
        {
            if (rowCount == 0)
            {
                throw new SQLException(
                    "Livreur " + client.getIdClient()+ " inconnu");
            }
            else
            {
                throw new SQLException(
                    "Clef " + client.getIdClient() + " en double !");
            }
        }
    }
    
// --------------------------------------------------------------------------
// Creation (insert) d'un objet Client
// --------------------------------------------------------------------------
    public int creer(Client client) throws SQLException
    {
        int rowCount;
        String insert;

        Integer idClient = client.getIdClient();
        String nomClient = client.getNomClient();
        String prenomClient = client.getPrenomClient();
        String adresseClient = client.getAdresseClient();
        Integer codePostalClient = client.getCodePostalClient();
        String villeClient = client.getVilleClient();
        Integer numeroTelClient = client.getNumeroTelClient();
        String mailClient = client.getMailClient();
        
        insert = "INSERT INTO CLIENT VALUES("
            + idClient + ", "
            + Conversion.chaineSQL(nomClient) + ", "
            + Conversion.chaineSQL(prenomClient) + ", "
            + Conversion.chaineSQL(adresseClient) + ", "
            + codePostalClient + ", "    
            + Conversion.chaineSQL(villeClient) + ", "
            + numeroTelClient + ", "
            + Conversion.chaineSQL(mailClient) + ")";

        rowCount = accesBase.executeUpdate(insert);

        return rowCount;
    }
    
// --------------------------------------------------------------------------
// Modification (update) d'un objet Client
// --------------------------------------------------------------------------
    public int modifier(Client client) throws SQLException
    {
        int rowCount;
        String update;

        Integer idLivreur = livreur.getIdLivreur();
        String nomLivreur = livreur.getNomLivreur();
        String prenomLivreur = livreur.getPrenomLivreur();
        Integer numPermisLivreur = livreur.getNumPermisLivreur();
        String adresseLivreur = livreur.getAdresseLivreur();
        Integer codePostalLivreur = livreur.getCodePostalLivreur();
        String villeLivreur = livreur.getVilleLivreur();
        Integer numeroSecteur = livreur.getNumeroSecteur();

        update = "UPDATE LIVREUR SET "
            + "IDLIVREUR = " + idLivreur + ", "
            + "NOMLIVREUR = " + Conversion.chaineSQL(nomLivreur) + ", "
            + "PRENOMLIVREUR = " + Conversion.chaineSQL(prenomLivreur) + ", "
            + "NUMPERMISLIVREUR = " + numPermisLivreur + ", "     
            + "ADRESSELIVREUR = " + Conversion.chaineSQL(adresseLivreur) + ", "
            + "CODEPOSTALLIVREUR = " + codePostalLivreur + ", "
            + "VILLELIVREUR = " + Conversion.chaineSQL(villeLivreur) + ", "
            + "NUMEROSECTEUR = " + numeroSecteur + " "
            + "WHERE NUMEROSECTEUR = " + numeroSecteur;

        rowCount = accesBase.executeUpdate(update);

        return rowCount;
    }    
    
}
