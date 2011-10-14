/*******************************************************************************
 * Copyright (c) 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.emof.EMOF.util;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.qvt.declarative.ecore.adapters.AdaptingEObject;
import org.eclipse.qvt.declarative.ecore.mappings.EClassMap;
import org.eclipse.qvt.declarative.ecore.mappings.MappingMetaDataRegistry;

/**
 * A RedirectedAnnotationClassMap defines the abstract behaviour of the EAnnotationAdapter
 * adapting the EAnnotation created when an EMOF Elment that is represented by the
 * EAnnotation is loaded. Derived classes must implement postLoad to ensure that
 * transient aspects of the EAnnotation are adequately represented once loading completes. 
 */
public abstract class RedirectedAnnotationClassMap extends EClassMap
{
	protected final EAnnotationClassMap annotationClassMap;
	
	protected RedirectedAnnotationClassMap(EAnnotationClassMap annotationClassMap, EClass adaptingEClass) {
		super(annotationClassMap.getMappingMetaData(), EcorePackage.Literals.EANNOTATION, adaptingEClass);
		this.annotationClassMap = annotationClassMap;
	}

	@Override
	public AdaptingEObject createAdapter(MappingMetaDataRegistry mappingMetaDataRegistry, EObject ecoreObject) {
		return annotationClassMap.createAdapter(mappingMetaDataRegistry, ecoreObject);
	}

	public boolean isXmiExtension(EAnnotationAdapter adapter) {
		return false;
	}

	public abstract void postLoad(EAnnotationAdapter adapter);
}