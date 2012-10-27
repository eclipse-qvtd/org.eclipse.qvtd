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
package org.eclipse.qvtd.xtext.qvtcorecst.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;

import org.eclipse.ocl.examples.xtext.base.baseCST.impl.TypedElementCSImpl;
import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;

import org.eclipse.qvtd.xtext.qvtcorecst.QVTcoreCSTPackage;
import org.eclipse.qvtd.xtext.qvtcorecst.RealizeableVariableCS;
import org.eclipse.qvtd.xtext.qvtcorecst.util.QVTcoreCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Realizeable Variable CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class RealizeableVariableCSImpl extends TypedElementCSImpl implements RealizeableVariableCS {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RealizeableVariableCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTcoreCSTPackage.Literals.REALIZEABLE_VARIABLE_CS;
	}

	@Override
	public <R> R accept(@NonNull BaseCSVisitor<R> visitor) {
		return ((QVTcoreCSVisitor<R>)visitor).visitRealizeableVariableCS(this);
	}
} //RealizeableVariableCSImpl
