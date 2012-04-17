/*******************************************************************************
 * Copyright (c) 2007,2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.importer.roseuml.actions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;

/**
 * This trimmed copy of org.eclipse.gmt.umlx.xmi.util split off to avoid
 * undue QVT Rose UML dependencies on UMLX.
 */
public class XMIUtils
{
	public static interface IdCreator
	{
		public String createId(EObject eObject, Set<String> knownIds);
	}
	
	/**
	 * Create xmi:id's using the same hierarchical/URI fragment algorithm as EMOFResourceImpl
	 */
	public static class HierachicalENamedElementIdCreator implements IdCreator
	{
		public HierachicalENamedElementIdCreator() {}

		public String createId(EObject eObject, Set<String> knownIds) {
		    List<String> uriFragmentPath = new ArrayList<String>();
		    for (EObject container = eObject.eContainer(); container != null; container = eObject.eContainer()) {
		    	uriFragmentPath.add(((InternalEObject)container).eURIFragmentSegment(eObject.eContainmentFeature(), eObject));
		    	eObject = container;
		    }
		    StringBuffer result;
		    if (eObject instanceof ENamedElement)
		    	result = new StringBuffer(((ENamedElement)eObject).getName());
		    else
		    	result = new StringBuffer("_" + Integer.toString(eObject.eResource().getContents().indexOf(eObject)));
		    for (ListIterator<String> i = uriFragmentPath.listIterator(uriFragmentPath.size()); i.hasPrevious(); ) {
		    	result.append('.');
		    	result.append(i.previous());
		    }
		    return result.toString();
		}
	}
	
	public static interface IdFilter
	{
		public boolean createId(EObject eObject);
	}
		
	/**
	 * Assign an xmi:id to all objects in resource. A non-null idFilter may choose whether an xmi:id
	 * is assigned. The idCreator is responsible for providing a candidate xmi:id, which, if not unique
	 * will be suffixed until it is.
	 * 
	 * @param resource
	 * @param idCreator
	 * @param idFilter
	 */
	public static void assignIds(Resource resource, IdCreator idCreator, IdFilter idFilter) {
	    if (!(resource instanceof XMLResource))
	    	return;
	    XMLResource xmlResource = (XMLResource) resource;
       final Set<String> knownIds = new HashSet<String>(256);  // The XMLResource.getEObjectToIDMap() method is deprecated
                                                                // and the replacement slow since we need a total traversal
        final List<EObject> idLess = new ArrayList<EObject>(100);
        for (TreeIterator<EObject> iterator = resource.getAllContents(); iterator.hasNext(); ) {
            EObject eObject = iterator.next();
            String id = xmlResource.getID(eObject);
            if (id != null)
            	knownIds.add(id);
            else if ((idFilter == null) || idFilter.createId(eObject))
                idLess.add(eObject);
        }
        for (EObject eObject : idLess) {
            String id = idCreator.createId(eObject, knownIds);
            if (id != null) {
            	String uniqueId = id;
    		    for (int i = 1; knownIds.contains(uniqueId); i++)
    		    	uniqueId = id + '_' + i;
    		    xmlResource.setID(eObject, uniqueId);
            	knownIds.add(uniqueId);
            }
        }
    }
}
