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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.qvt.declarative.ecore.mappings.EAttributeOrEReference;
import org.eclipse.qvt.declarative.ecore.mappings.EClassMap;
import org.eclipse.qvt.declarative.ecore.mappings.MappingMetaDataRegistry;
import org.eclipse.qvt.declarative.emof.EMOF.EMOFPackage;

/**
 * An EMOFPropertyAdapter provides the adapting EMOF Property model element that 
 * adapts an Ecore model EStructuralFeature element maintaining the Ecore element as an
 * EAttributeOrEReference until such time as it can be determined whether an
 * EAttribute or EReference is appropriate.
 */
public class EMOFPropertyAdapter extends AbstractEMOFPropertyAdapter
{
	public EMOFPropertyAdapter(MappingMetaDataRegistry mappingMetaDataRegistry, EClassMap eClassMap, EAttributeOrEReference target) {
		super(mappingMetaDataRegistry, eClassMap, target);
	}

	/**
	 * Setting any feature that is distinctively EReference or EAttribute is intercepted
	 * to resolve the Ecore element.
	 */
	@Override public void resolveOnSet(EStructuralFeature feature, Object newValue) {
		if (feature == EMOFPackage.Literals.TYPED_ELEMENT__TYPE) {
			if (newValue != null)
				resolveTargetAsReference(((Adapter)newValue).getTarget() instanceof EClass);
		}
		else if (feature == EMOFPackage.Literals.PROPERTY__IS_COMPOSITE)
			resolveTargetAsReference(true);
		else if (feature == EMOFPackage.Literals.PROPERTY__IS_ID)
			resolveTargetAsReference(false);
		else if (feature == EMOFPackage.Literals.PROPERTY__OPPOSITE) {
			resolveTargetAsReference(true);
			((EMOFPropertyAdapter) newValue).resolveTargetAsReference(true);
		}
	}
}
