/**
 * <copyright>
 * 
 * Copyright (c) 2008 E.D.Willink and others.
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
 * $Id: TestExpressionImpl.java,v 1.2 2008/12/31 18:14:29 ewillink Exp $
 */
package org.eclipse.qvt.declarative.test.TestQVTBase.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.ocl.ecore.impl.OCLExpressionImpl;

import org.eclipse.qvt.declarative.test.TestQVTBase.TestExpression;
import org.eclipse.qvt.declarative.test.TestQVTBase.TestQVTBasePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Test Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class TestExpressionImpl extends OCLExpressionImpl implements TestExpression {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TestExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TestQVTBasePackage.Literals.TEST_EXPRESSION;
	}

} //TestExpressionImpl
