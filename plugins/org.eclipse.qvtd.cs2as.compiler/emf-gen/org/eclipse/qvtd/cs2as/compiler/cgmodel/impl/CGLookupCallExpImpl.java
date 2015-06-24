/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/**
 */
package org.eclipse.qvtd.cs2as.compiler.cgmodel.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.ocl.examples.codegen.cgmodel.impl.CGOperationCallExpImpl;
import org.eclipse.ocl.examples.codegen.cgmodel.util.CGModelVisitor;
import org.eclipse.qvtd.cs2as.compiler.cgmodel.CGLookupCallExp;
import org.eclipse.qvtd.cs2as.compiler.cgmodel.CS2ASCGPackage;
import org.eclipse.qvtd.cs2as.compiler.cgmodel.util.CS2ASCGModelVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CG Lookup Call Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class CGLookupCallExpImpl extends CGOperationCallExpImpl implements CGLookupCallExp {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CGLookupCallExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CS2ASCGPackage.Literals.CG_LOOKUP_CALL_EXP;
	}
	
	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(CGModelVisitor<R> visitor) {
		return (R) ((CS2ASCGModelVisitor<?>)visitor).visitCGLookupCallExp(this);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	public EClassifier getEcoreClassifier() {
		return null;
	}

	// FIXME use the CGModelSpecs
	@Override
	public boolean isUnboxed() {
		return true;
	}
	
	@Override
	public boolean isBoxed() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	public boolean isEcore() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	public boolean isGlobal() {
		return false;
	}

} //CGLookupCallExpImpl
