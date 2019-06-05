/*******************************************************************************
 * Copyright (c) 2016, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/**
 */
package example5.sderived.impl;

import example5.sbase.impl.SElementImpl;

import example5.sderived.SderivedPackage;
import example5.sderived.W;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>W</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class WImpl extends SElementImpl implements W {
	/**
	 * The number of structural features of the '<em>W</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int W_FEATURE_COUNT = SElementImpl.SELEMENT_FEATURE_COUNT + 0;
	/**
	 * The number of operations of the '<em>W</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int W_OPERATION_COUNT = SElementImpl.SELEMENT_OPERATION_COUNT + 0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SderivedPackage.Literals.W;
	}


} //WImpl
