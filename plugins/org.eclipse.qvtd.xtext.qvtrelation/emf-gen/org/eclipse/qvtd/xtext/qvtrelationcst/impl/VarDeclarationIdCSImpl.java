/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.qvtd.xtext.qvtrelationcst.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;

import org.eclipse.ocl.examples.xtext.base.baseCST.impl.NamedElementCSImpl;
import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;

import org.eclipse.qvtd.xtext.qvtrelationcst.QVTrelationCSTPackage;
import org.eclipse.qvtd.xtext.qvtrelationcst.VarDeclarationIdCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.util.QVTrelationCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Var Declaration Id CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class VarDeclarationIdCSImpl extends NamedElementCSImpl implements VarDeclarationIdCS {
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
		return QVTrelationCSTPackage.Literals.VAR_DECLARATION_ID_CS;
	}

	@Override
	public <R> R accept(@NonNull BaseCSVisitor<R> visitor) {
		return ((QVTrelationCSVisitor<R>)visitor).visitVarDeclarationIdCS(this);
	}
} //VarDeclarationIdCSImpl
