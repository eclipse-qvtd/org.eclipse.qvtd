/*******************************************************************************
 * Copyright (c) 2012, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtrelationcs.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.xtext.basecs.impl.NamedElementCSImpl;
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;
import org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage;
import org.eclipse.qvtd.xtext.qvtrelationcs.VarDeclarationIdCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.util.QVTrelationCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Var Declaration Id CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class VarDeclarationIdCSImpl extends NamedElementCSImpl implements VarDeclarationIdCS {
	/**
	 * The number of structural features of the '<em>Var Declaration Id CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int VAR_DECLARATION_ID_CS_FEATURE_COUNT = NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VarDeclarationIdCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTrelationCSPackage.Literals.VAR_DECLARATION_ID_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull BaseCSVisitor<R> visitor) {
		if (visitor instanceof QVTrelationCSVisitor) {
			return (R) ((QVTrelationCSVisitor<?>)visitor).visitVarDeclarationIdCS(this);
		}
		else {
			return super.accept(visitor);
		}
	}
} //VarDeclarationIdCSImpl
