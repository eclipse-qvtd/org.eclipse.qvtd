
package org.eclipse.qvtd.xtext.qvtrelation;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class QVTrelationStandaloneSetup extends QVTrelationStandaloneSetupGenerated{

	public static void doSetup() {
		new QVTrelationStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

