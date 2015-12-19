/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtbase.utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.resource.ASResource;

/**
 * ASURIHandler resolves URI references using the externalURI of their containing resources thereby replacing
 * absolute namespace URI references by relative document URIs when the origial file was read from a document
 * than a package registration. THis avoids references to package URIs that are not installed.
 */
public final class ASURIHandler extends URIHandlerImpl.PlatformSchemeAware
{
	/**
	 * The ASResource to be saved.
	 */
	protected final @NonNull ASResource asResource;
	
	/**
	 * Map from the AS package nsURI e.g. http://www.eclipse.org/emf/2002/Ecore.oclas to resources contributing partial packages.
	 */
	private /*@LazyNonNull*/ Map<URI, List<Resource>> asURI2resources = null;
	
	public ASURIHandler(@NonNull ASResource asResource) {
		this.asResource = asResource;
	}

	private void analyzePackages(@NonNull Iterable<org.eclipse.ocl.pivot.Package> asPackages) {
		for (org.eclipse.ocl.pivot.Package asPackage : asPackages) {
			String uri = asPackage.getURI();
			if (uri != null) {
				Resource resource = asPackage.eResource();
				URI nsURI = URI.createURI(uri);
				assert nsURI != null;
				URI asURI = PivotUtilInternal.getASURI(nsURI);
				List<Resource> resources = asURI2resources.get(asURI);
				if (resources == null) {
					resources = new ArrayList<Resource>();
					asURI2resources.put(asURI, resources);
				}
				if (!resources.contains(resource)) {
					resources.add(resource);
				}
			}
			analyzePackages(asPackage.getOwnedPackages());
		}
	}

	@Override
	public URI deresolve(URI uri) {
		//
		//	Perform a lazy analysis since the ResourceSet may not be available in the constructor.
		//
		Map<URI, List<Resource>> asURI2resources2 = asURI2resources;
		if (asURI2resources2 == null) {
			asURI2resources = asURI2resources2 = new HashMap<URI, List<Resource>>();
			ResourceSet asResourceSet = asResource.getResourceSet();
			for (Resource resource : asResourceSet.getResources()) {
				for (EObject rootObject : resource.getContents()) {
					if (rootObject instanceof Model) {
						analyzePackages(((Model)rootObject).getOwnedPackages());
					}
				}
			}
		}
		//
		//	Search the resources with a package contribution for one with the matching fragment.
		//	Then prefer one with a non-null ESObject to avoid secondary Complete OCL packages..
		//
		List<Resource> resources = asURI2resources.get(uri.trimFragment());
		if (resources != null) {
			String fragment = uri.fragment();
			URI bestDeresolvedURIWithFragment = null;
			for (Resource resource : resources) {
				EObject eObject = resource.getEObject(fragment);
				if (eObject != null) {
					Model model = (Model)resource.getContents().get(0);
					URI resourceURI = URI.createURI(model.getExternalURI());
					assert resourceURI != null;
					URI asURI = PivotUtilInternal.getASURI(resourceURI);
					URI deresolvedURI = asURI.deresolve(baseURI);
					URI deresolvedURIWithFragment = deresolvedURI.appendFragment(fragment);
					bestDeresolvedURIWithFragment = deresolvedURIWithFragment;
					if ((eObject instanceof Element) && ((Element)eObject).getESObject()!= null) {
						break;		// FIXME is there a more solid way of avoiding secondary complete OCL packages
					}
				}
			}
			if (bestDeresolvedURIWithFragment != null) {
				return super.deresolve(bestDeresolvedURIWithFragment);
			}
		}
		return super.deresolve(uri);
	}
}