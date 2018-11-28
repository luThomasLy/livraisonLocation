package gestionLivraisonLocation;

import classesMetiers.Livreur;
import classesMetiers.Secteur;
import daoJdbcMapping.LivreurDAO;
import daoJdbcMapping.SecteurDAO;
import diversUtilitaires.Colonne;
import java.sql.SQLException;
import java.util.Set;
import java.util.Vector;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import jdbc.AccesBase;
import jdbc.BaseDeDonnees;

public class TraitementAccueil
{
    private BaseDeDonnees base;

// --------------------------------------------------------------------------
// Constructeur
// --------------------------------------------------------------------------
    public TraitementAccueil(BaseDeDonnees base)
    {
        this.base = base;
    }

// --------------------------------------------------------------------------
// Traitement d'affichage de la liste
// --------------------------------------------------------------------------
    public String traitementListe(HttpServletRequest request)
    {
        String jspRetour;
        
        Vector<Livreur> listeLivreurs;
        Vector<Colonne> listeColonnes;
        HttpSession session = request.getSession();
        
        AccesBase accesBase;
        LivreurDAO livreurDAO;

// --------------------------------------------------------------------------
// L'objet ContactDAO est une variable locale de la methode. Elle est creee a
// chaque appel (et liberee a la fin). Il s'agit d'eviter le melange de
// donnees entre plusieurs utilisateurs. En effet, la ServletControleur est
// instanciée une fois. La classe TraitementAccueil une fois également. Si
// l'objet ContactDAO etait declare en propriete de la classe
// TraitementAccueil, elle serait commune a tous les utilisateurs. Or, un
// objet ContactDAO contient une propriete de type JeuResultat qui est
// modifiee a chaque lecture dans la base.
// --------------------------------------------------------------------------
        accesBase = new AccesBase(base);
        try
        {
            accesBase.getConnection();
            livreurDAO = new LivreurDAO(accesBase);

            try
            {
                listeLivreurs = livreurDAO.lireListe();
                listeColonnes = livreurDAO.getListeColonnes();

                jspRetour = "/jspListe.jsp";
                session.setAttribute("listeLivreurs", listeLivreurs);
                session.setAttribute("listeColonnes", listeColonnes);
            }
            finally
            {
                accesBase.closeConnection();
            }
        }
        catch (SQLException e)
        {
            jspRetour = "/jspAccueil.jsp";
            session.setAttribute("message", e.getMessage());
            session.setAttribute("numeroContact", "");
            session.setAttribute("choixAction", "liste");
        }
        return jspRetour;
    }

// --------------------------------------------------------------------------
// Traitement d'affichage de l'ecran de modification
// --------------------------------------------------------------------------
    public String traitementModif(HttpServletRequest request)
    {
        String jspRetour;

        Livreur livreur;
        Integer numeroLivreur;
        Vector<Secteur> vSect;
        HttpSession session = request.getSession();

        AccesBase accesBase;
        LivreurDAO livreurDAO;
        SecteurDAO secteurDAO;

        String chaineIdLivreur = request.getParameter("numeroLivreur");

        accesBase = new AccesBase(base);

        try
        {
            accesBase.getConnection();
            livreurDAO = new LivreurDAO(accesBase);
            secteurDAO = new SecteurDAO(accesBase);

            try
            {
                numeroLivreur = Integer.parseInt(chaineIdLivreur);
                livreur = new Livreur();
                //contact.setNumero(numeroContact);
                livreur.setIdLivreur(numeroLivreur);
                //contactDAO.lire(contact);
                livreurDAO.lire(livreur);

                //vSect = secteurDAO.lireListe();
                vSect = secteurDAO.lireListe();

                jspRetour = "/jspModif.jsp";
                session.setAttribute("message", "");
                session.setAttribute("livreur", livreur);
                session.setAttribute("vSect", vSect);
            }
            catch (NumberFormatException e)
            {
                jspRetour = "/jspAccueil.jsp";
                session.setAttribute("message", e.getMessage());
                session.setAttribute("idLivreur", chaineIdLivreur);
                session.setAttribute("choixAction", "modification");
            }
            finally
            {
                accesBase.closeConnection();
            }
        }
        catch (SQLException e)
        {
            jspRetour = "/jspAccueil.jsp";
            session.setAttribute("message", e.getMessage());
            session.setAttribute("idLivreur", chaineIdLivreur);
            session.setAttribute("choixAction", "modification");
        }

        return jspRetour;
    }

// --------------------------------------------------------------------------
// Traitement d'affichage du message non realise sur l'ecran d'accueil
// --------------------------------------------------------------------------
    public String traitementNonRealise(HttpServletRequest request)
    {
        String jspRetour;
        HttpSession session = request.getSession();

        String choixAction = request.getParameter("choixAction");
        String chaineIdLivreur = request.getParameter("idLivreur");

        jspRetour = "/jspAccueil.jsp";
        session.setAttribute("message", 
                             "Ecran de " + choixAction + " non réalisé");
        session.setAttribute("choixAction", choixAction);
        session.setAttribute("numeroContact", chaineIdLivreur);

        return jspRetour;
    }
}
