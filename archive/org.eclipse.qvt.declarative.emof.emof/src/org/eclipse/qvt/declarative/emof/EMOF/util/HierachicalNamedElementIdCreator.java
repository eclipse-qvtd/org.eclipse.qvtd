/*******************************************************************************
 * Copyright (c) 2007 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.emof.EMOF.util;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.qvt.declarative.ecore.utils.XMIUtils;
import org.eclipse.qvt.declarative.emof.EMOF.NamedElement;

/**
 * Create hierarchical xmi:id's for NamedElement nodes of the form of
 * name.name.name using @ property_index for unnamed elements, and _index
 * for unnamed root elements
 */
public class HierachicalNamedElementIdCreator implements XMIUtils.IdCreator
{
	public HierachicalNamedElementIdCreator() {}

	public String createId(EObject eObject, Set<String> knownIds) {
		XMLResource resource = (XMLResource) eObject.eResource();
		if (resource == null)
			resource = (XMLResource) eObject.eResource();			// FIXME just for debug
	    List<String> uriFragmentPath = new ArrayList<String>();
	    for (EObject container = eObject; container != null; container = container.eContainer()) {
		    String id = resource.getID(container);
		    if (id != null) {
		    	uriFragmentPath.add(id);
		    	break;
		    }
			if (container instanceof NamedElement)
		    	uriFragmentPath.add(((NamedElement)container).getName());
		    else {
		    	EObject parent = eObject.eContainer();
	    		if (parent == null) {
		    		List<EObject> siblings = resource.getContents();
			    	uriFragmentPath.add("_" + siblings.indexOf(eObject));
		    	}
	    		else {
			    	EReference eContainmentFeature = eObject.eContainmentFeature();
			    	if (eContainmentFeature.isMany()) {
			    		List<?> siblings = (List<?>) parent.eGet(eContainmentFeature);
				    	uriFragmentPath.add("@" + eContainmentFeature.getName() + "_" + siblings.indexOf(eObject));
			    	}
			    	else
				    	uriFragmentPath.add("@" + eContainmentFeature.getName());
		    	}
		    }
	    }
	    StringBuffer resultBuffer = new StringBuffer();
	    for (ListIterator<String> i = uriFragmentPath.listIterator(uriFragmentPath.size()); i.hasPrevious(); ) {
	    	if (i.hasNext())
	    		resultBuffer.append('.');
	    	resultBuffer.append(i.previous());
	    }
	    return resultBuffer.toString();
	}
}