package fr.systerel.rodinextension.sample.basis;

import org.eclipse.core.runtime.IProgressMonitor;
import org.rodinp.core.IInternalElement;
import org.rodinp.core.IInternalElementType;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinDBException;
import org.rodinp.core.basis.InternalElement;

public class Bound extends InternalElement implements IBound{

	public Bound(String name, IRodinElement parent) {
		super(name, parent);
		// TODO Auto-generated constructor stub
	}

	@Override
	public IInternalElementType<? extends IInternalElement> getElementType() {
		return IBound.ELEMENT_TYPE;
	}

	@Override
	public void setComment(String comment, IProgressMonitor monitor)
			throws RodinDBException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean hasComment() throws RodinDBException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getComment() throws RodinDBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasExpressionString() throws RodinDBException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getExpressionString() throws RodinDBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setExpressionString(String expression, IProgressMonitor monitor)
			throws RodinDBException {
		// TODO Auto-generated method stub
		
	}

}
