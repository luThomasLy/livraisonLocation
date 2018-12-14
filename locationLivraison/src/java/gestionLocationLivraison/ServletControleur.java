package gestionLocationLivraison;

// ==========================================================================
// ServletControleur.java : servlet d'accueil du projet locationLivraison
// ==========================================================================
import classesMetiers.Livreur;
import classesMetiers.Produit;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import jdbc.BaseDeDonnees;

public class ServletControleur extends HttpServlet
{
    private TraitementAccueil traitementAccueil;
    private TraitementModif traitementModif;
    private BaseDeDonnees base;

    @Override
    public void init()
    {
//        String url = "jdbc:mysql://localhost:8889/locationLivraison";
//        String login ="root";
//        String password = "";    
        Livreur livreur;
        
        try
        {
            //Class.forName(getInitParameter("driverJDBCSqlServer"));
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
        }
        //base = new BaseDeDonnees(getInitParameter("BDDSqlServer"));
        //base = new BaseDeDonnees(url,login,password);
        base = new BaseDeDonnees(
                "jdbc:mysql://localhost:8889/locationLivraison", "root", "");
        //base.setFormatDate(getInitParameter("formatDateSqlServer"));
        base.setFormatDate("yyyy/MM/dd");

        traitementAccueil = new TraitementAccueil(base);
        traitementModif = new TraitementModif(base);
    }

// --------------------------------------------------------------------------
// Traitement du formulaire d'accueil (index.jsp)
// --------------------------------------------------------------------------
    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response)
        throws ServletException, IOException
    {

// --------------------------------------------------------------------------
// contexte   : ServletContext pour utiliser le dispatcher.
// dispatcher : pour acceder aux jsp d'affichage.
// --------------------------------------------------------------------------
        ServletContext contexte;
        RequestDispatcher dispatcher;

// --------------------------------------------------------------------------
// idEcran    : identifiant de l'ecran reçu.
// jsp        : jsp a afficher (retournee par les methodes de Traitement.
// choixAction : action choisie sur l'ecran d'accueil.
// --------------------------------------------------------------------------
        Integer idEcran;
        String jsp;
        String choixAction;
        HttpSession session;

// --------------------------------------------------------------------------
// Indication du codage pour l'interpretation des caracteres recus par la
// requete.
// --------------------------------------------------------------------------
        request.setCharacterEncoding("UTF-8");

// --------------------------------------------------------------------------
// Recuperation du SerletContext pour dispatcher...
// --------------------------------------------------------------------------
        contexte = getServletContext();

// --------------------------------------------------------------------------
// Lecture de l'identifiant de l'ecran (champ cache ou parametre d'index.jsp)
// --------------------------------------------------------------------------
        String numeroEcran = request.getParameter("idEcran");
        idEcran = new Integer(numeroEcran);

// --------------------------------------------------------------------------
// Divers branchements suivant l'ecran qui vient d'appeler ServletControleur
// --------------------------------------------------------------------------
        switch (idEcran)
        {

// --------------------------------------------------------------------------
// On vient de l'ecran jspAccueil
// --------------------------------------------------------------------------
            case 1:
                choixAction = request.getParameter("choixAction");

                if (choixAction.compareTo("liste") == 0)
                {
                    jsp = traitementAccueil.traitementListe(request);
                }
                else
                {
                    if (choixAction.compareTo("modification") == 0)
                    {
                        jsp = traitementAccueil.traitementModif(request);
                    }    
                    else
                    {
                        jsp = traitementAccueil.traitementNonRealise(request);
                    }
                }
                break;

// --------------------------------------------------------------------------
// On vient de l'ecran jspModif
// --------------------------------------------------------------------------
            case 2:
                choixAction = request.getParameter("choixAction");

                if (choixAction.compareTo("Annuler") == 0)
                {
                    jsp = traitementModif.annulationModif(request);
                }
                else
                {
                    jsp = traitementModif.enregModif(request);
                }
                break;

            default:
                session = request.getSession();
                session.setAttribute("message", "");
                session.setAttribute("idLivreur", "");//livreur
                session.setAttribute("choixAction", "liste");

                jsp = "/jspAccueil.jsp";
        }
        dispatcher = contexte.getRequestDispatcher(jsp);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
        throws ServletException, IOException
    {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
        throws ServletException, IOException
    {
        processRequest(request, response);
    }
}
