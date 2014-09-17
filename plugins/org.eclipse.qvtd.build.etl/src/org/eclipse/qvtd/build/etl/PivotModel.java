/*******************************************************************************
 * Copyright (c) 2013 The University of York, Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Horacio Hoyos - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.build.etl;

import java.io.IOException;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.emc.emf.CachedResourceSet;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManagerResourceSetAdapter;
import org.eclipse.ocl.examples.pivot.resource.ASResource;

/**
 * The Pivot Model extends the EmfModel to provide access to the utilities
 * provided by the OCL framework
 */
public class PivotModel extends EmfModel {
	
	private MetaModelManager metaModelManager;
	
	public PivotModel(MetaModelManager metaModelManager) {
		
		this.metaModelManager = metaModelManager;
	}
	
	@Override
	public void loadModelFromUri() throws EolModelLoadingException {
		ResourceSet resourceSet = createResourceSet();
		MetaModelManagerResourceSetAdapter.getAdapter(resourceSet, metaModelManager);
		
        // Check if global package registry contains the EcorePackage
		if (EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI) == null) {
			EPackage.Registry.INSTANCE.put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
		}
		
		determinePackagesFrom(resourceSet);
		
		// Note that AbstractEmfModel#getPackageRegistry() is not usable yet, as modelImpl is not set
		for (EPackage ep : packages) {
			String nsUri = ep.getNsURI();
			if (nsUri == null || nsUri.trim().length() == 0) {
				nsUri = ep.getName();
			}
			resourceSet.getPackageRegistry().put(nsUri, ep);
		}
		resourceSet.getPackageRegistry().put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
		
		Resource model = resourceSet.createResource(modelUri);
		if (this.readOnLoad) {
			try {
				model.load(null);
				if (expand) {
					EcoreUtil.resolveAll(model);
				}
			} catch (IOException e) {
				throw new EolModelLoadingException(e, this);
			}
		}
		modelImpl = model;
	}

}
