/**
 * <copyright>
 * 
 * Copyright (c) 2007, 2008 E.D.Willink and others.
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
 * $Id: RealizedVariableImpl.java,v 1.3 2009/12/19 13:37:29 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTCore.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EParameter;

import org.eclipse.ocl.ecore.impl.VariableImpl;
import org.eclipse.ocl.utilities.Visitor;

import org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage;
import org.eclipse.qvt.declarative.ecore.QVTCore.RealizedVariable;
import org.eclipse.qvt.declarative.ecore.QVTCore.util.QVTCoreVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Realized Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class RealizedVariableImpl extends VariableImpl implements RealizedVariable {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RealizedVariableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTCorePackage.Literals.REALIZED_VARIABLE;
	}

	/**
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T, U extends Visitor<T, ?, ?, ?, ?, ?, ?, ?, ?, ?>> T accept(U v) {
		if (v instanceof QVTCoreVisitor<?>)
			return ((QVTCoreVisitor<T>) v).visitRealizedVariable(this);
		else
			return ((Visitor<T, EClassifier, ?, ?, ?, EParameter, ?, ?, ?, ?>)v).visitVariable(this);
	}

} //RealizedVariableImpl
