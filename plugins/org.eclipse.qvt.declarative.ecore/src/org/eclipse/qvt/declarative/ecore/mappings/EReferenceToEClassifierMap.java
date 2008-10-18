/**
 * <copyright>
 * 
 * Copyright (c) 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: EReferenceToEClassifierMap.java,v 1.3 2008/10/18 18:46:43 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.mappings;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;

public class EReferenceToEClassifierMap extends EReferenceMap
{
	public EReferenceToEClassifierMap(IMappingMetaDataRegistry.Install mappingMetaDataRegistry,
			EcoreFeatureElement<EReference> ecoreEStructuralFeature,
			AbstractFeatureElement<EReference> adaptingEStructuralFeature) {
		super(mappingMetaDataRegistry, ecoreEStructuralFeature, adaptingEStructuralFeature);
	}

	@Override
	protected Object exportValue(EObject adaptingObject, Object ecoreValue) {
		if (ecoreValue instanceof EDataType)
			return super.exportValue(adaptingObject, mappingMetaDataRegistry.exportEDataType((EDataType) ecoreValue));
		else
			return super.exportValue(adaptingObject, ecoreValue);
	}

	@Override
	protected Object importValue(Resource adaptingResource, EObject adaptingObject, Object adaptingValue) {
		Object ecoreValue = super.importValue(adaptingResource, adaptingObject, adaptingValue);
		if (ecoreValue instanceof EDataType)
			return mappingMetaDataRegistry.importEDataType((EDataType) ecoreValue);
		else
			return ecoreValue;
	}
}