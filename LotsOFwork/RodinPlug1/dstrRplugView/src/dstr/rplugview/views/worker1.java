package dstr.rplugview.views;
import java.util.ArrayList;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.Action;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eventb.core.ISCAxiom;
import org.eventb.core.ISCCarrierSet;
import org.eventb.core.ISCConstant;
import org.eventb.core.ISCInternalContext;
import org.eventb.core.ISCInvariant;
import org.eventb.core.ISCMachineRoot;
import org.eventb.core.ISCVariable;
import org.eventb.core.ast.FormulaFactory;
import org.rodinp.core.IAttributeValue;
import org.rodinp.core.IInternalElement;
import org.rodinp.core.IRodinDB;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.IRodinFile;
import org.rodinp.core.IRodinProject;
import org.rodinp.core.RodinCore;
import org.rodinp.core.RodinDBException;

public class worker1 {
	IRodinDB rodinDB;
	IRodinProject [] rodinProjects = new IRodinProject [10];
	ArrayList<ISCMachineRoot> result = new ArrayList<ISCMachineRoot>();
	ArrayList<Action> actions = new ArrayList<Action>();
	    
	
	public worker1() {
	rodinDB = RodinCore.getRodinDB();
	work();
	}
	public void work(){
		
	try {
		rodinProjects = rodinDB.getRodinProjects();
		for (int i = 0; i<rodinProjects.length ; i++){
			System.out.println(rodinProjects[i].getElementName());
		}
		this.setMachines();
	    ISCMachineRoot m = result.get(0);
	 
	   } catch (RodinDBException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	   }
	return;
   }
	
	public void temp(ISCMachineRoot mr) throws RodinDBException {
	ISCInvariant[] invars = mr.getSCInvariants();
		for(int i1 = 0;i1<invars.length;i1++){
	    	 System.out.println("  invariant "+ invars[i1].getPredicateString());
	    	 IRodinElement[] ielems = invars[i1].getChildren();
	    	 for(int i2 =0;i2<ielems.length; i2++){
	    		 System.out.println("    Children " + invars[i1].getPredicateString());
	    	 }
	     }
		ISCVariable[] vars = mr.getSCVariables();
		String[] svars = new String[vars.length];
	    for(int i = 0; i<vars.length;i++) {
	    	ISCVariable v = vars[i];
	    	IRodinElement[] els = v.getChildren();
	        IAttributeValue [] ats = v.getAttributeValues();

	     String t = v.getIdentifierString() +" of type "+
	    	     v.getElementType().toString() +
	    	     " with "+els.length +"  children "+ " and " +
	    	             ats.length +" attributes ";
	     for(int i1 = 0;i1<els.length;i1++){
	    	 System.out.println("  elem "+els[i1].getElementName());
	     }
	     for(int i1 = 0;i1<ats.length;i1++){
	    	 System.out.println("  ats Class.SimpleName "+ats[i1].getClass().getSimpleName()
	    			 +" toString "+ ats[i1].toString());
	     }
	     System.out.println(t);
	    }
	     return;
	
	}
	public String [] setVariabes(ISCMachineRoot mr){
		FormulaFactory formulaFactory = mr.getFormulaFactory();
		String [] svars = null;
		try {
		ISCInternalContext[] ctx = mr.getSCSeenContexts();
		int j = 0;
		
		ISCCarrierSet [] css = ctx[j].getSCCarrierSets();
		for (int i = 0 ; i< css.length; i++){
			System.out.println( " type of set = "+css[i].getType(formulaFactory). toExpression());	
			
		}
		ISCConstant[] consts = ctx[j].getSCConstants();
		for (int i = 0;i< consts.length; i++){
			System.out.println( "  const "+consts[i].getElementName() + " is of type  "+consts[i].getType(formulaFactory).toExpression());
		}
		ISCAxiom[] axs = ctx[j].getSCAxioms();
		for (int i = 0;i< axs.length; i++){
			System.out.println( "  Axiom "+axs[i].getPredicateString() );
		}
		
	    ISCVariable[] vars;
	    
			vars = mr.getSCVariables();
			for(int i = 0; vars.length > i; i++){
				System.out.println("  var "+ vars[i].getElementName()+" is of type "+
				vars[i].getType(formulaFactory).toExpression());
			}
			//temp(mr);
			
		} catch (
				RodinDBException e) {
			System.err.println("setVariables RodinDBException in worker1");	
			e.printStackTrace();
		} catch (CoreException e) {
			System.err.println("setVariables CoreException in worker1");
			e.printStackTrace();
		} finally {
		}
	    return svars;
	}
	public void setMachines() {
		try {
			for (IRodinElement element : rodinProjects[0].getChildren()) {
	          if (element instanceof IRodinFile) {
	                IInternalElement root = ((IRodinFile) element).getRoot();
	                if (root instanceof ISCMachineRoot) {
	                      result.add((ISCMachineRoot) root);
	                      this.setVariabes((ISCMachineRoot) root);
	                }
	          }
	    }
		} catch (RodinDBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		   }
		
	}
	/*
	 * make one action per machine in project
	 */
	public ArrayList<Action> makeActions(){
		System.out.println("DSTR Make "+result.size()+" Actions");
		for (int i = 0; i<result.size() ; i++){
			ISCMachineRoot mr = result.get(i);
	        final String macName = mr.getElementName();
			System.out.println("Action "+i+ " for "+ macName);
			Action action = new Action() {
				public void run() {
					System.out.println("Action for "+ macName);
				}
			};
			action.setText("Action for "+macName);
			action.setToolTipText("Tooltip "+macName);
			action.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
					getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
			action.setDescription("action for " +macName);
			actions.add(action);		
		}
		System.out.println("DSTR Made "+result.size()+" Actions");	
		return actions;
	}
	
}
