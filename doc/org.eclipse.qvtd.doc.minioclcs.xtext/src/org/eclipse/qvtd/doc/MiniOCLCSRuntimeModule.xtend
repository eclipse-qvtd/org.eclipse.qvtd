/*
 * generated by Xtext 2.10.0-SNAPSHOT
 */
package org.eclipse.qvtd.doc

import org.eclipse.qvtd.doc.linker.CS2ASLinker

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
class MiniOCLCSRuntimeModule extends AbstractMiniOCLCSRuntimeModule {
	
	override bindILinker() {
		CS2ASLinker
	}
}