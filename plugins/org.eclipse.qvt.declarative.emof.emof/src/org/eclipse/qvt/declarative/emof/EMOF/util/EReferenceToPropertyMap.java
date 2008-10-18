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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.qvt.declarative.ecore.mappings.AbstractFeatureElement;
import org.eclipse.qvt.declarative.ecore.mappings.EReferenceMap;
import org.eclipse.qvt.declarative.ecore.mappings.EcoreFeatureElement;
import org.eclipse.qvt.declarative.ecore.mappings.IMappingMetaDataRegistry;

public class EReferenceToPropertyMap extends EReferenceMap
{
	public EReferenceToPropertyMap(IMappingMetaDataRegistry.Install mappingMetaDataRegistry,
			EcoreFeatureElement<EReference> ecoreEStructuralFeature,
			AbstractFeatureElement<EReference> adaptingEStructuralFeature) {
		super(mappingMetaDataRegistry, ecoreEStructuralFeature,
				adaptingEStructuralFeature);
	}

	@Override
	protected Object importValue(Resource adaptingResource, EObject adaptingObject, Object adaptingValue) {
//		if (((EObject)adaptingValue).eIsProxy())	// FIXME WIP Needed to ensure save resolves xsi:type
//			((AbstractEMOFPropertyAdapter)adaptingValue).resolveProxy(adaptingObject);
		return super.importValue(adaptingResource, adaptingObject, adaptingValue);
	}
}