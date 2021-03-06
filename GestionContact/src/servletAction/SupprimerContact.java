package servletAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import actionForm.AddContactValidationForm;
import actionForm.SupprimerContactValidationForm;
import domain.DAOContact;

public class SupprimerContact extends Action {
	
	public ActionForward execute(final ActionMapping pMapping,ActionForm pForm, final HttpServletRequest pRequest,final HttpServletResponse pResponse) 
	{
			final SupprimerContactValidationForm
			lForm=(SupprimerContactValidationForm)pForm;
			
			
			final String nom = lForm.getNom();
			final String prenom = lForm.getPrenom();
			final String email = lForm.getEmail();
			final String numTel= lForm.getNumTel();
			final String rue=lForm.getRue();
			final String ville=lForm.getVille();
			final String pays=lForm.getPays();
			
			
			
			// create a new Contact
			final DAOContact lDAOContact = new DAOContact();
			final String lError = lDAOContact.SupprimerContact(nom, prenom, email, numTel, rue, ville, pays);
			System.out.println(lError);
			if(lError == null) 
			{// if no exception is raised, forward "success"
				return pMapping.findForward("success");
			}			
			else 
			{// If any exception, return the "error" forward
				return pMapping.findForward("error");
			}
	}

}
