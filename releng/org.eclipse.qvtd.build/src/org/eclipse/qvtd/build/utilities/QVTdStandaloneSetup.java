/*******************************************************************************
 * Copyright (c) 2021 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.build.utilities;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePivotStandaloneSetup;

/**
 * Initializes OCL support.
 */
public class QVTdStandaloneSetup
{
	private Logger log = Logger.getLogger(getClass());
	private ResourceSet resourceSet = null;

	public QVTdStandaloneSetup() {
		log.info("Registering QVTd Resources");
		//		OCLstdlib.install();
		//		PivotPackage.eINSTANCE.getClass();
		//		Resource.Factory.Registry.INSTANCE.getProtocolToFactoryMap().put("pivot", PivotResourceFactoryImpl.INSTANCE);
		//		URIConverter.URI_MAP.put(URI.createURI(EcoreEnvironment.OCL_STANDARD_LIBRARY_NS_URI), null);
		QVTbasePivotStandaloneSetup.doSetup();
	}

	/**
	 * Install a global Package mapping from the nsURI at uriMap.from to the package obtained by loading the uriMap.to URI fragment
	 * in the resourceSet.
	 *
	public void addDynamicPackage(final Mapping uriMap) {
		final URI nsURI = URI.createURI(uriMap.getFrom());
		final URI packageURI = URI.createURI(uriMap.getTo());
		log.info("Loading '" + nsURI + "' from '" + packageURI + "'");
		if (!packageURI.hasFragment()) {
			log.error("No URI fragment specified in '" + packageURI + "'");
		}
		EPackage ePackage = (EPackage) getResourceSet().getEObject(packageURI, true);
		EPackage.Registry.INSTANCE.put(nsURI.toString(), ePackage);
	} */

	public ResourceSet getResourceSet() {
		if (resourceSet == null) {
			resourceSet = new ResourceSetImpl();
		}
		return resourceSet;
	}

	public void setResourceSet(ResourceSet resourceSet) {
		this.resourceSet = resourceSet;
	}
}
