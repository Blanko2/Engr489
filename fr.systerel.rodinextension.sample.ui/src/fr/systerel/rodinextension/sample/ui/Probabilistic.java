package fr.systerel.rodinextension.sample.ui;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eventb.ui.manipulation.IAttributeManipulation;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinDBException;

import fr.systerel.rodinextension.sample.QualProbPlugin;

public class Probabilistic implements IAttributeManipulation {
	
	public static IAttributeType.Boolean PROB_ATTRIBUTE = RodinCore.getBooleanAttrType(QualProbPlugin.PLUGIN_ID + ".probabilistic");
	public Probabilistic() {
		// TODO Auto-generated constructor stub
	}

	private IEvent asEvent (IRodinElement element){
		assert element instanceof IEvent;
		return (IEvent) element;
	}
	@Override
	public void setDefaultValue(IRodinElement element, IProgressMonitor monitor)
			throws RodinDBException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean hasValue(IRodinElement element, IProgressMonitor monitor)
			throws RodinDBException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getValue(IRodinElement element, IProgressMonitor monitor)
			throws CoreException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setValue(IRodinElement element, String value,
			IProgressMonitor monitor) throws RodinDBException {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeAttribute(IRodinElement element, IProgressMonitor monitor)
			throws RodinDBException {
		// TODO Auto-generated method stub

	}

	@Override
	public String[] getPossibleValues(IRodinElement element,
			IProgressMonitor monitor) {
		// TODO Auto-generated method stub
		return null;
	}

}
