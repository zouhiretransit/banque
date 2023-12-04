package web;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import metier.CreditMetierImp;
import metier.ICreditMetier;

@WebServlet(name = "cs",urlPatterns = {"*.do","*.go"})
public class ControleurServlet extends HttpServlet {
	private ICreditMetier metier;
	@Override
	public void init() throws ServletException {
		metier=new CreditMetierImp();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setAttribute("creditModel", new CreditModel());
		req.getRequestDispatcher("VueCredit.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		 * Lire les données de la requete.
		 */
		double montant=Double.parseDouble(req.getParameter("montant"));
		double taux=Double.parseDouble(req.getParameter("taux"));
		int duree=Integer.parseInt(req.getParameter("duree"));
		/*
		 * Valider les données de la requete.
		 */
		
		/*
		 * Stocker les données de le modéle.
		 */
		CreditModel cModel=new CreditModel();
		cModel.setMontant(montant);
		cModel.setTaux(taux);
		cModel.setDuree(duree);
		
		
		/*
		 * Faire appel à la couche metier pour effectuer les traitements.
		 */
		double mensualite=metier.calculerMensualitéCredit(montant, taux, duree);
		/*
		 * Stocker le resultat dans le modéle.
		 */
		cModel.setMensualite(mensualite);
		/*
		 * Stocker le modéle da,s l'objet request.
		 */
		req.setAttribute("creditModel", cModel);
		/*
		 * Faire un forward vers la vue jsp.
		 */
		req.getRequestDispatcher("VueCredit.jsp").forward(req, resp);
	}

}
