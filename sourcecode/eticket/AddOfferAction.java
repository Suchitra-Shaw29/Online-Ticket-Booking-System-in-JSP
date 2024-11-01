																																																																																																																																																																																																																																																																																																																																																																																																			//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_3.8.4/xslt/JavaClass.xsl

package eticket;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.DynaValidatorForm;

/** 
 
 * XDoclet definition:
 * @struts:action path="/AddOffer" name="Offer" scope="request" validate="true"
 * @struts:action-forward name="success" path="/.jsp"
 * @struts:action-forward name="fail" path="/.jsp"
 */
public class AddOfferAction extends Action {

	// --------------------------------------------------------- Instance Variables

	// --------------------------------------------------------- Methods

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)throws Exception {
		DynaValidatorForm Offer = (DynaValidatorForm) form;
		OfferBean ob=new OfferBean();
		
		ob.setOffername((String)Offer.get("offername"));
		ob.setStartdate((String)Offer.get("startdate"));
		ob.setEnddate((String)Offer.get("enddate"));
		ob.setApplfor((String)Offer.get("applfor"));
		ob.setDescr((String)Offer.get("descr"));
		boolean valid=Validation.addOffer_Form(ob,getDataSource(request));
		if(valid){
			
			return mapping.findForward("success");
		}
		return mapping.findForward("fail");
		
	}
		
		

}
