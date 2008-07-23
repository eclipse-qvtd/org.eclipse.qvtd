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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.qvt.declarative.test.emof.HTMLStream;

/**
 * An EcoreEquivalenceHelper provides Ecore-specific assistance when comparing models.
 */
public class EcoreEquivalenceHelper extends EquivalenceHelper
{
	public static final EcoreEquivalenceHelper INSTANCE = new EcoreEquivalenceHelper(null, null);
	
	public EcoreEquivalenceHelper(HTMLStream htmlStream, PrintStream logStream) {
		super(htmlStream, logStream);
	}

	@Override
	public boolean canPartitionByName(EClass eClass) {
		return EcorePackage.eINSTANCE.getENamedElement().isSuperTypeOf(eClass);
	}

	@Override
	public String getName(EObject eObject) {
		return ((ENamedElement) eObject).getName();
	}

	@Override
	public boolean isComparable(EClass eClass, EStructuralFeature eFeature, EObject leftObject, EObject rightObject) {
		return true;
	}

	@Override
	public boolean isOrdered(EStructuralFeature feature) {
		return feature.isOrdered();
	}
}
