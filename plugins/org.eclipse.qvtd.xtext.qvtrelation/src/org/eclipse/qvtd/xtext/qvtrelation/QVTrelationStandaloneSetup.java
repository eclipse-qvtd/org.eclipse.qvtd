
package org.eclipse.qvtd.xtext.qvtrelation;

import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPivotStandaloneSetup;
import org.eclipse.qvtd.xtext.qvtrelation.scoping.QVTrelationScoping;

import com.google.inject.Injector;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class QVTrelationStandaloneSetup extends QVTrelationStandaloneSetupGenerated
{
	private static Injector injector = null;	

	public static void doSetup() {
		if (injector == null) {
			injector = new QVTrelationStandaloneSetup().createInjectorAndDoEMFRegistration();
		}
	}

	public static void init() {
		QVTrelationPivotStandaloneSetup.doSetup();
		QVTrelationScoping.init();
//		QVTrelationCS2MonikerVisitor.FACTORY.getClass();
	}
	
	/**
	 * Return the Injector for this plugin.
	 */
	public static final Injector getInjector() {
		if (injector == null) {
			doSetup();
		}
		return injector;
	}

	@Override
	public Injector createInjector() {
		init();
		return super.createInjector();
	}
}

