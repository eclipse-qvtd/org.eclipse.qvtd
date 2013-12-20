package org.eclipse.qvtd.debug.stubs;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;

public interface ModelExtent {

	void setContents(List<EObject> allRootElements);

	ResourceSet getContents();

	List<EObject> getAllRootElements();

}
