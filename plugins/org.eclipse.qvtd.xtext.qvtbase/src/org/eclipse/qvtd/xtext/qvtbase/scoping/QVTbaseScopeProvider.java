/*******************************************************************************
 * Copyright (c) 2011, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtbase.scoping;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.resource.EnvironmentFactoryAdapter;
import org.eclipse.ocl.xtext.base.scoping.AbstractJavaClassScope;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.qvtd.xtext.qvtbasecs.QVTbaseCSPackage;
import org.eclipse.xtext.scoping.IScope;

/**
 * This class contains custom scoping description.
 *
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#scoping
 * on how and when to use it.
 */
public class QVTbaseScopeProvider extends org.eclipse.ocl.xtext.essentialocl.scoping.EssentialOCLScopeProvider {
	@Override
	public IScope getScope(EObject context, EReference reference) {
		if (context == null) {
			return IScope.NULLSCOPE;
		}
		Resource csResource = context.eResource();
		if (csResource == null) {
			return IScope.NULLSCOPE;
		}
		EClass eReferenceType = reference.getEReferenceType();
		if (eReferenceType == QVTbaseCSPackage.Literals.JAVA_CLASS_CS) {
			if (csResource instanceof BaseCSResource) {
				AbstractJavaClassScope adapter = JavaClassScope.findAdapter((BaseCSResource)csResource);
				if (adapter == null) {
					EnvironmentFactoryAdapter environmentFactoryAdapter = EnvironmentFactoryAdapter.find(csResource);
					if (environmentFactoryAdapter == null) {
						ResourceSet csResourceSet = csResource.getResourceSet();
						if (csResourceSet != null) {
							environmentFactoryAdapter = EnvironmentFactoryAdapter.find(csResourceSet);
						}
					}
					List<@NonNull ClassLoader> classLoaders;
					if (environmentFactoryAdapter != null) {
						classLoaders = environmentFactoryAdapter.getMetamodelManager().getImplementationManager().getClassLoaders();
					}
					else {
						classLoaders = Collections.emptyList();
					}
					adapter = JavaClassScope.getAdapter((BaseCSResource)csResource, classLoaders);
				}
				return adapter;
			}
			return IScope.NULLSCOPE;
		}
		return super.getScope(context, reference);
	}

}
