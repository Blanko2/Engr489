package fr.systerel.rodinextension.sample;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class QualProbPlugin implements BundleActivator {

	public static final String PLUGIN_ID = null;
	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		QualProbPlugin.context = bundleContext;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		QualProbPlugin.context = null;
	}

}
