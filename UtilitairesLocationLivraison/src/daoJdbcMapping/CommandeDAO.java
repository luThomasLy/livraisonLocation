
package daoJdbcMapping;

import classesMetiers.Client;
import classesMetiers.Commande;
import diversUtilitaires.Colonne;
import diversUtilitaires.Conversion;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;
import jdbc.AccesBase;
import jdbc.JeuResultat;

public class CommandeDAO {
// ==========================================================================
// PROPRIETES
// ==========================================================================
// --------------------------------------------------------------------------
// Acces a la base de donnees liee a la table COMMANDE
// --------------------------------------------------------------------------
    private AccesBase accesBase;

// --------------------------------------------------------------------------
// Jeu de resultats lu par l'un des "executeQuery"
// Il contient toutes les donnees des lignes lues dans la table commande et
// les donnees relatives aux colonnes.
// --------------------------------------------------------------------------
    private JeuResultat jeuResultat;

// ==========================================================================
// METHODES
// ==========================================================================
// --------------------------------------------------------------------------
// Constructeur
// --------------------------------------------------------------------------
    public CommandeDAO(AccesBase accesBase)
    {
        this.accesBase = accesBase;
    }

// --------------------------------------------------------------------------
// Lecture d'un objet Commande (dont la clef est renseignee)
// --------------------------------------------------------------------------
    public void lire(Commande commande) throws SQLException
    {
        int rowCount;

        String select;
        Vector<Object> ligne;

        select = "SELECT * FROM COMMANDE WHERE IDCOMMANDE = " + commande.getIdCommande();

        jeuResultat = accesBase.executeQuery(select);

        rowCount = (jeuResultat.getLignes()).size();

// --------------------------------------------------------------------------
// Si le executeQuery retourne 0 ligne, il n'y a pas SQLException. C'est la
// raison de la creation d'une SQLException particuliere.
// --------------------------------------------------------------------------
        if (rowCount == 1)
        {
            ligne = (jeuResultat.getLignes()).elementAt(0);
            
            commande.setIdCommande((Integer) ligne.elementAt(1));
            commande.setDateCommande((Date) ligne.elementAt(2));
        }
        else 
        {
            if (rowCount == 0)
            {
                throw new SQLException(
                    "Commande " + commande.getIdCommande() + " inconnu");
            }
            else
            {
                throw new SQLException(
                    "Clef " + commande.getIdCommande() + " en double !");
            }
        }
    }
    
// --------------------------------------------------------------------------
// Creation (insert) d'un objet Commande
// --------------------------------------------------------------------------
    public int creer(Commande commande) throws SQLException
    {
        int rowCount;
        String insert;

        Integer idCommande = commande.getIdCommande();
        Date dateCommande = commande.getDateCommande();
        
        String chaineDate
            = Conversion.dateSQL(dateCommande, accesBase.getBase().getFormatDate());

        insert = "INSERT INTO COMMANDE VALUES("
            + idCommande + ", "
            + dateCommande + ")";

        rowCount = accesBase.executeUpdate(insert);

        return rowCount;
    }    
    
// --------------------------------------------------------------------------
// Modification (update) d'un objet Versement
// --------------------------------------------------------------------------
    public int modifier(Commande commande) throws SQLException
    {
        int rowCount;
        String update;

        Integer idCommande = commande.getIdCommande();
        Date dateCommande = commande.getDateCommande();

        String chaineDate
            = Conversion.dateSQL(dateCommande, accesBase.getBase().getFormatDate());

        update = "UPDATE COMMANDE SET "
            + "IDCOMMANDE = " + idCommande + ", "
            + "DATECOMMANDE = " + chaineDate ;

        rowCount = accesBase.executeUpdate(update);

        return rowCount;
    }    
    
// --------------------------------------------------------------------------
// Destruction (delete) d'un objet Commande
// --------------------------------------------------------------------------
    public int detruire(Commande commande) throws SQLException
    {
        int rowCount;
        String delete;

        Integer idCommande = commande.getIdCommande();

        delete = "DELETE FROM COMMANDE WHERE IDNUMERO = " + idCommande;

        rowCount = accesBase.executeUpdate(delete);

        return rowCount;
    }
    
// --------------------------------------------------------------------------
// Lecture d'une Commande, pour un Client
// --------------------------------------------------------------------------
    public Commande lireCommande(Client client) throws SQLException
    {
        Commande commande = null;

        if (client.getIdClient() != null)
        {
            commande = new Commande();
            commande.setIdCommande(client.getIdClient());
            lire(commande);
        }
        return commande;
    }
    
// --------------------------------------------------------------------------
// Liste des commandes pour un client
// --------------------------------------------------------------------------
    public Vector<Commande> lireListe(Client client) throws SQLException
    {
        Vector<Commande> listeCommandes;
        Commande commande;

        String select = "SELECT * FROM COMMANDE WHERE IDCOMMANDE = ";
        select += client.getIdClient();

        int nombreDeCommandes;
        Vector<Object> ligne;
        int i;

        jeuResultat = accesBase.executeQuery(select);

        listeCommandes = new Vector<Commande>();
        nombreDeCommandes = (jeuResultat.getLignes()).size();

        for (i = 0; i < nombreDeCommandes; i++)
        {
            ligne = (jeuResultat.getLignes()).elementAt(i);
            
            commande = new Commande();
            commande.setIdCommande((Integer) ligne.elementAt(0));
            commande.setDateCommande((Date) ligne.elementAt(1));
            
            listeCommandes.addElement(commande);
        }
        return listeCommandes;
    }

// --------------------------------------------------------------------------
// Liste des commandes
// --------------------------------------------------------------------------
    public Vector<Commande> lireListe() throws SQLException
    {
        Vector<Commande> listeCommandes;
        Commande commande;

        String select = "SELECT * FROM COMMANDE";

        int nombreDeCommandes;
        Vector<Object> ligne;
        int i;

        jeuResultat = accesBase.executeQuery(select);

        listeCommandes = new Vector<Commande>();
        nombreDeCommandes = (jeuResultat.getLignes()).size();

        for (i = 0; i < nombreDeCommandes; i++)
        {
            ligne = (jeuResultat.getLignes()).elementAt(i);

            commande = new Commande();
            commande.setIdCommande((Integer) ligne.elementAt(0));
            commande.setDateCommande((Date) ligne.elementAt(1));

            listeCommandes.addElement(commande);
        }
        return listeCommandes;
    }
    
// --------------------------------------------------------------------------
// Liste des colonnes de la table COMMANDE
// --------------------------------------------------------------------------
    public Vector<Colonne> getListeColonnes()
    {
        return jeuResultat.getColonnes();
    }    
    
    
}
