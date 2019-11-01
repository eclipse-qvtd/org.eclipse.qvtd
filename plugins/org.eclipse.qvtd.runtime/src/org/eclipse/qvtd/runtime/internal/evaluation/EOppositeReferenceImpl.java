/*******************************************************************************
 * Copyright (c) 2013, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.runtime.internal.evaluation;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EReferenceImpl;
import org.eclipse.jdt.annotation.NonNull;

/**
 * EOppositeReferenceImpl is used internally to reify the missing EReference.eOpposite and so satisfy the
 * invariant that all EReferemces have a useable eOpposite. The instances should not be used
 * externally since they violate many WFRs. Only getEOpposite() is useful (and getName()/toString() for debugging).
 */
public class EOppositeReferenceImpl extends EReferenceImpl
{
	public EOppositeReferenceImpl(@NonNull EReference eReference) {
		assert eOpposite == null;
		setEOpposite(eReference);
		assert eOpposite == eReference;
	}

	@Override
	public EClass basicGetEReferenceType() {
		return eOpposite.getEContainingClass();
	}

	@Override
	public EClassifier basicGetEType() {
		return eOpposite.getEContainingClass();
	}

	@Override
	public EClass getEContainingClass() {
		return eOpposite.getEReferenceType();
	}

	@Override
	public EGenericType getEGenericType() {
		throw new UnsupportedOperationException();
	}

	@Override
	public EClass getEReferenceType() {
		return eOpposite.getEContainingClass();
	}

	@Override
	public EClassifier getEType() {
		return eOpposite.getEContainingClass();
	}

	@Override
	public String getName() {
		return "«opposite»" + eOpposite.getName();
	}

	@Override
	public String getNameGen() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isChangeable() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isContainer() {
		return eOpposite.isContainment();
	}

	@Override
	public boolean isContainment() {
		return false;
	}

	@Override
	public boolean isDerived() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isTransient() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isVolatile() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String toString() {
		return getName();
	}
}