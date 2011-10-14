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
package org.eclipse.qvt.declarative.test.emof.tools;

import java.io.PrintStream;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.qvt.declarative.ecore.adapters.AdaptingEObject;
import org.eclipse.qvt.declarative.emof.EMOF.EMOFPackage;
import org.eclipse.qvt.declarative.emof.EssentialOCL.EssentialOCLPackage;
import org.eclipse.qvt.declarative.test.emof.HTMLStream;

/**
 * An EMOFEquivalenceHelper provides EMOF-specific assistance when comparing models.
 */
public class EMOFEquivalenceHelper extends EquivalenceHelper
{
	public static final EMOFEquivalenceHelper INSTANCE = new EMOFEquivalenceHelper(null, null);
	
	private EMOFEquivalenceHelper(HTMLStream htmlStream, PrintStream logStream) {
		super(htmlStream, logStream);
	}
	
	@Override
	public boolean canPartitionByName(EClass eClass) {
		return EMOFPackage.eINSTANCE.getNamedElement().isSuperTypeOf(eClass);
	}

	@Override
	public String getName(EObject eObject) {
		return ((ENamedElement)((AdaptingEObject)eObject).getTarget()).getName();
	}

	@Override
	public boolean isComparable(EClass eClass, EStructuralFeature eFeature, EObject leftObject, EObject rightObject) {
		//
		//	Suppress comparison of Property features not available in the Ecore mapping
		//
		if (EMOFPackage.Literals.PROPERTY.isSuperTypeOf(eClass)) {
			EObject leftEcoreObject = leftObject instanceof AdaptingEObject ? ((AdaptingEObject) leftObject).getTarget() : null;
			EObject rightEcoreObject = rightObject instanceof AdaptingEObject ? ((AdaptingEObject) rightObject).getTarget() : null;
			if ((leftEcoreObject instanceof EReference) && (rightEcoreObject instanceof EReference)) {
				if (eFeature == EMOFPackage.Literals.PROPERTY__IS_ID)
					return false;
			}
			if ((leftEcoreObject instanceof EAttribute) && (rightEcoreObject instanceof EAttribute)) {
				if ((eFeature == EMOFPackage.Literals.PROPERTY__OPPOSITE)
				 || (eFeature == EMOFPackage.Literals.PROPERTY__IS_COMPOSITE))
					return false;
			}
		}
		//
		// Workaround 215110#1 MDT-OCL's ExpressionInOcl is not an ETypedElement
		//
		if (EssentialOCLPackage.Literals.EXPRESSION_IN_OCL.isSuperTypeOf(eClass)) {
			if ((eFeature == EMOFPackage.Literals.TYPED_ELEMENT__TYPE)
			 || (eFeature == EMOFPackage.Literals.NAMED_ELEMENT__NAME)) {
				return false;
			}			
		}
		return true;
	}

	@Override
	public boolean isOrdered(EStructuralFeature feature) {
		return feature.isOrdered();
	}
}
