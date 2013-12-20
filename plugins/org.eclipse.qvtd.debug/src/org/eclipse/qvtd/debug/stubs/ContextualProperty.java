package org.eclipse.qvtd.debug.stubs;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

public interface ContextualProperty extends EStructuralFeature {

	EClass getContext();

}
