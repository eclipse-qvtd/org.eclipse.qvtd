/*******************************************************************************
 * Copyright (c) 2013, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.codegen.qvticgmodel.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.cgmodel.impl.CGEcorePropertyAssignmentImpl;
import org.eclipse.ocl.examples.codegen.cgmodel.util.CGModelVisitor;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMiddlePropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage;
import org.eclipse.qvtd.codegen.qvticgmodel.util.QVTiCGModelVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CG Middle Property Assignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class CGMiddlePropertyAssignmentImpl extends CGEcorePropertyAssignmentImpl implements CGMiddlePropertyAssignment {
	/**
	 * The number of structural features of the '<em>CG Middle Property Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CG_MIDDLE_PROPERTY_ASSIGNMENT_FEATURE_COUNT = CGEcorePropertyAssignmentImpl.CG_ECORE_PROPERTY_ASSIGNMENT_FEATURE_COUNT + 0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CGMiddlePropertyAssignmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTiCGModelPackage.Literals.CG_MIDDLE_PROPERTY_ASSIGNMENT;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull CGModelVisitor<R> visitor) {
		if (visitor instanceof QVTiCGModelVisitor) {
			return (R) ((QVTiCGModelVisitor<?>)visitor).visitCGMiddlePropertyAssignment(this);
		}
		else {
			return super.accept(visitor);
		}
	}

} //CGMiddlePropertyAssignmentImpl
