
//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_3.8.4/xslt/JavaClass.xsl

package eticket;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/** 

 * XDoclet definition:
 * @struts:action validate="true"
 * @struts:action-forward name="success" path="/AcceptAgentConf.jsp"
 * @struts:action-forward name="fail" path="/ViewPendingAgent.jsp"
 */
public class AcceptAgentAction extends Action {

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
		HttpServletResponse response) throws Exception
		 { 
		System.out.println("In Action of accept");
			String agregno=request.getParameter("agregno");
			System.out.println(agregno);
			boolean valid=Validation.acceptAgent(agregno,getDataSource(request));
			System.out.println("After val");
			System.out.println(valid);
				
			if(valid)
					return mapping.findForward("success");
				return mapping.findForward("fail");
				
				 
	}

}
