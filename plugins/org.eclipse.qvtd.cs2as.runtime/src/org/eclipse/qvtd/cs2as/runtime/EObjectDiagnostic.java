package org.eclipse.qvtd.cs2as.runtime;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;

public interface EObjectDiagnostic extends Diagnostic {

	/**
	 * @return the {@link EObject} on which this diagnostic applies
	 */
	EObject getEObject();
}
