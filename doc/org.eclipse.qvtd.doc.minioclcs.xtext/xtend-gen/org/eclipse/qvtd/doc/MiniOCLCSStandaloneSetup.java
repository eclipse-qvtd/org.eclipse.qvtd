/**
 * generated by Xtext 2.10.0-SNAPSHOT
 */
package org.eclipse.qvtd.doc;

import org.eclipse.qvtd.doc.MiniOCLCSStandaloneSetupGenerated;

/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
@SuppressWarnings("all")
public class MiniOCLCSStandaloneSetup extends MiniOCLCSStandaloneSetupGenerated {
  public static void doSetup() {
    MiniOCLCSStandaloneSetup _miniOCLCSStandaloneSetup = new MiniOCLCSStandaloneSetup();
    _miniOCLCSStandaloneSetup.createInjectorAndDoEMFRegistration();
  }
}
