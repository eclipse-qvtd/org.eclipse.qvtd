/**
 * <copyright>
 * 
 * Copyright (c) 2018, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.qvtd.xml.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.qvtd.xml.CDATA;
import org.eclipse.qvtd.xml.XMLmodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CDATA</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class CDATAImpl extends NodeImpl implements CDATA {
	/**
	 * The number of structural features of the '<em>CDATA</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CDATA_FEATURE_COUNT = NodeImpl.NODE_FEATURE_COUNT + 0;
	/**
	 * The number of operations of the '<em>CDATA</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CDATA_OPERATION_COUNT = NodeImpl.NODE_OPERATION_COUNT + 0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CDATAImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XMLmodelPackage.Literals.CDATA;
	}

	@Override
	public String toString() {
		return "CDATA ...";
	}

} //CDATAImpl
