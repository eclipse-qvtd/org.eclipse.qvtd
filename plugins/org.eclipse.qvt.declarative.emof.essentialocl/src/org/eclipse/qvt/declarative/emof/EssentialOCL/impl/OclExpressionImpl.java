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
 * $Id: OclExpressionImpl.java,v 1.1 2008/07/23 09:56:30 qglineur Exp $
 */
package org.eclipse.qvt.declarative.emof.EssentialOCL.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.qvt.declarative.emof.EMOF.impl.TypedElementImpl;

import org.eclipse.qvt.declarative.emof.EssentialOCL.EssentialOCLPackage;
import org.eclipse.qvt.declarative.emof.EssentialOCL.OclExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ocl Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class OclExpressionImpl extends TypedElementImpl implements OclExpression {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OclExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EssentialOCLPackage.Literals.OCL_EXPRESSION;
	}

} //OclExpressionImpl
