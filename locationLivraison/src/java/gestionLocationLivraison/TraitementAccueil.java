package gestionLocationLivraison;

import classesMetiers.Livreur;
import classesMetiers.Secteur;
import daoJdbcMapping.LivreurDAO;
import daoJdbcMapping.ProduitDAO;
import daoJdbcMapping.SecteurDAO;
import diversUtilitaires.Colonne;
import java.sql.SQLException;
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
        ProduitDAO produitDAO;
        
// --------------------------------------------------------------------------
// L'objet LivreurDAO est une variable locale de la methode. Elle est creee a
// chaque appel (et liberee a la fin). Il s'agit d'eviter le melange de
// donnees entre plusieurs utilisateurs. En effet, la ServletControleur est
// instanciée une fois. La classe TraitementAccueil une fois également. Si
// l'objet LivreurDAO etait declare en propriete de la classe
// TraitementAccueil, elle serait commune a tous les utilisateurs. Or, un
// objet LivreurDAO contient une propriete de type JeuResultat qui est
// modifiee a chaque lecture dans la base.
// --------------------------------------------------------------------------
        accesBase = new AccesBase(base);
        try
        {
            accesBase.getConnection();
            livreurDAO = new LivreurDAO(accesBase);
            produitDAO = new ProduitDAO(accesBase);
            
            try
            {
                //livreur
                listeLivreurs = livreurDAO.lireListe();
                listeColonnes = livreurDAO.getListeColonnes();
               
                jspRetour = "/jspListeLivreurs.jsp";
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
            session.setAttribute("idLivreur", "");//livreur
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
        Integer idLivreur;
        //Vector<Secteur> vSect = null;
        HttpSession session = request.getSession();

        AccesBase accesBase;
        //livreur
        LivreurDAO livreurDAO;
        //SecteurDAO secteurDAO;
        
        String chaineIdLivreur = request.getParameter("numeroLivreur");//Livreur
        
        accesBase = new AccesBase(base);

        try
        {
            accesBase.getConnection();
            livreurDAO = new LivreurDAO(accesBase);//livreur
            //secteurDAO = new SecteurDAO(accesBase);
            
            try
            {
                //livreur
                idLivreur = Integer.parseInt(chaineIdLivreur);
                livreur = new Livreur();
                livreur.setIdLivreur(idLivreur);
                livreurDAO.lire(livreur);
                
                //vSect = secteurDAO.lireListe();

                jspRetour = "/jspModif.jsp";
                session.setAttribute("message", "");
                session.setAttribute("livreur", livreur);
                //session.setAttribute("vSect", vSect);
                
            }
            catch (NumberFormatException e)
            {
                jspRetour = "/jspModif.jsp";
                session.setAttribute("message", e.getMessage());
                session.setAttribute("idLivreur", chaineIdLivreur);//livreur
                session.setAttribute("choixAction", "Modification");
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
            session.setAttribute("idLivreur", chaineIdLivreur);//livreur
            session.setAttribute("choixAction", "Modification");
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
        session.setAttribute("idLivreur", chaineIdLivreur);//livreur
        
        return jspRetour;
    }
}
