/*******************************************************************************
 * Copyright (c) 2015, 2018 Willink Transformations and others.
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
package org.eclipse.qvtd.cs2as.compiler.cgmodel;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.cs2as.compiler.cgmodel.CS2ASCGFactory
 * @model kind="package"
 * @generated
 */
public interface CS2ASCGPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "cgmodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/qvt/2015/CS2AScg";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "cgmodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CS2ASCGPackage eINSTANCE = org.eclipse.qvtd.cs2as.compiler.cgmodel.impl.CS2ASCGPackageImpl.init();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.cs2as.compiler.cgmodel.CGLookupCallExp <em>CG Lookup Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Lookup Call Exp</em>'.
	 * @see org.eclipse.qvtd.cs2as.compiler.cgmodel.CGLookupCallExp
	 * @generated
	 */
	EClass getCGLookupCallExp();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CS2ASCGFactory getCS2ASCGFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.cs2as.compiler.cgmodel.impl.CGLookupCallExpImpl <em>CG Lookup Call Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.cs2as.compiler.cgmodel.impl.CGLookupCallExpImpl
		 * @see org.eclipse.qvtd.cs2as.compiler.cgmodel.impl.CS2ASCGPackageImpl#getCGLookupCallExp()
		 * @generated
		 */
		EClass CG_LOOKUP_CALL_EXP = eINSTANCE.getCGLookupCallExp();

	}

} //CS2ASCGPackage
