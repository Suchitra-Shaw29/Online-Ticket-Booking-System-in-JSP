//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_3.8.4/xslt/JavaClass.xsl

package eticket;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/** 
 
 * XDoclet definition:
 * @struts:action validate="true"
 * @struts:action-forward name="success" path="/allbustypes.jsp"
 * @struts:action-forward name="fail" path="/Index.jsp"
 */
public class AllBusTypeAction extends Action {

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

		ArrayList bustype=new ArrayList();
		HttpSession hs=request.getSession(false);
		 bustype=(ArrayList)hs.getAttribute("bustype");
		if(bustype!=null)
		{
		 return mapping.findForward("success");	
		}
		else
		{
			 bustype=Validation.getBusType(getDataSource(request));
		}
		if(bustype!=null)
		{
			hs.setAttribute("bustype",bustype);
		 return mapping.findForward("success");	
		}
		else
		return mapping.findForward("fail");
	}

}
