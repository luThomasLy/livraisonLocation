package gestionLivraisonLocation;

import classesMetiers.Livreur;
import classesMetiers.Secteur;
import daoJdbcMapping.*;
import java.sql.SQLException;
import java.util.Vector;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import jdbc.AccesBase;
import jdbc.BaseDeDonnees;

public class TraitementModif
{
    private BaseDeDonnees base;

// --------------------------------------------------------------------------
// Constructeur
// --------------------------------------------------------------------------
    public TraitementModif(BaseDeDonnees base)
    {
        this.base = base;
    }

// --------------------------------------------------------------------------
// Traitement d’annulation de la modification
// --------------------------------------------------------------------------
    public String annulationModif(HttpServletRequest request)
    {
        String jspRetour;

        Livreur livreur;
        HttpSession session = request.getSession();

        livreur = (Livreur) session.getAttribute("livreur");

        jspRetour = "/jspAccueil.jsp";
        session.setAttribute("message", "Modification annulée");
        //session.setAttribute("numeroContact", contact.getNumero().toString());
        session.setAttribute("numeroLivreur",livreur.getIdLivreur().toString());
        session.setAttribute("choixAction", "modification");

        return jspRetour;
    }

// --------------------------------------------------------------------------
// Enregistrement de la modification et affichage de l'ecran de confirmation
// de la modification
// --------------------------------------------------------------------------
    public String enregModif(HttpServletRequest request)
    {
        String jspRetour;

        Livreur livreur;
        Vector<Secteur> vSect;

        HttpSession session = request.getSession();
        
        AccesBase accesBase;
        LivreurDAO livreurDAO;

        livreur = (Livreur) session.getAttribute("livreur");
        vSect = (Vector<Secteur>) session.getAttribute("vSect");

        String idLvreur = request.getParameter("idLvreur");
        idLvreur = idLvreur.trim();
        if (idLvreur.compareTo("") == 0)
        {
            idLvreur = null;
        }

        String nomLivreur = request.getParameter("nomLivreur");
        nomLivreur = nomLivreur.trim();
        if (nomLivreur.compareTo("") == 0)
        {
            nomLivreur = null;
        }
        
        String prenomLivreur = request.getParameter("prenomLivreur");
        prenomLivreur = prenomLivreur.trim();
        if (prenomLivreur.compareTo("") == 0)
        {
            prenomLivreur = null;
        }
        
        String numPermisLivreur = request.getParameter("numPermisLivreur");
        numPermisLivreur = numPermisLivreur.trim();
        if (numPermisLivreur.compareTo("") == 0)
        {
            numPermisLivreur = null;
        }
        
        String adresseLivreur = request.getParameter("adresseLivreur");
        adresseLivreur = adresseLivreur.trim();
        if (adresseLivreur.compareTo("") == 0)
        {
            adresseLivreur = null;
        }

//        String codePostalLivreur = request.getParameter("codePostalLivreur");
//        codePostalLivreur = codePostalLivreur.trim();
//        if (codePostalLivreur.compareTo("") == 0)
//        {
//            codePostalLivreur = null;
//        }
        
        String villeLivreur = request.getParameter("villeLivreur");
        villeLivreur = villeLivreur.trim();
        if (villeLivreur.compareTo("") == 0)
        {
            villeLivreur = null;
        }
        
        
        String stringIdLivreur = request.getParameter("idLivreur");
        Integer idLivreur = null;
        if (stringIdLivreur.compareTo("") != 0)
        {
            idLivreur = new Integer(stringIdLivreur);
        }
        
        String stringCodePostalSecteur = request.getParameter("codePostalLivreur");
        Integer codePostalLivreur = null;
        if (stringCodePostalSecteur.compareTo("") != 0)
        {
            codePostalLivreur = new Integer(stringCodePostalSecteur);
        }

        String stringNumeroSecteur = request.getParameter("numeroSecteur");
        Integer numeroSecteur = null;
        if (stringNumeroSecteur.compareTo("") != 0)
        {
            numeroSecteur = new Integer(stringNumeroSecteur);
        }

// --------------------------------------------------------------------------
// Modification de l'objet livreur
// --------------------------------------------------------------------------
        
        livreur.setIdLivreur(idLivreur);
        livreur.setNomLivreur(nomLivreur);
        livreur.setPrenomLivreur(prenomLivreur);
        livreur.setNumPermisLivreur(numeroSecteur);
        livreur.setAdresseLivreur(adresseLivreur);
        livreur.setCodePostalLivreur(codePostalLivreur);
        livreur.setVilleLivreur(villeLivreur);
        livreur.setNumeroSecteur(numeroSecteur);

        accesBase = new AccesBase(base);

        try
        {
            accesBase.getConnection();
            livreurDAO = new LivreurDAO(accesBase);

            try
            {
                int retour = livreurDAO.modifier(livreur);
                if (retour != 0)
                {
                    jspRetour = "/jspRecap.jsp";
                    session.setAttribute("livreur", livreur);
                }
                else
                {
                    jspRetour = "/jspModif.jsp";
                    session.setAttribute("message", "Le livreur "
                                         + livreur.getIdLivreur()
                                         + " a été supprimé");
                    session.setAttribute("livreur", livreur);
                    session.setAttribute("vSect", vSect);
                }
            }
            finally
            {
                accesBase.closeConnection();
            }
        }
        catch (SQLException e)
        {
            jspRetour = "/jspModif.jsp";
            session.setAttribute("message", e.getMessage());
            session.setAttribute("livreur", livreur);
            session.setAttribute("vSect", vSect);
        }

        return jspRetour;
    }
}
