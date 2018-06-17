/**
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.Families2Persons;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.Families2Persons.Families2PersonsPackage
 * @generated
 */
public interface Families2PersonsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Families2PersonsFactory eINSTANCE = org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.Families2Persons.impl.Families2PersonsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Member2 Male</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Member2 Male</em>'.
	 * @generated
	 */
	Member2Male createMember2Male();

	/**
	 * Returns a new object of class '<em>Member2 Female</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Member2 Female</em>'.
	 * @generated
	 */
	Member2Female createMember2Female();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	Families2PersonsPackage getFamilies2PersonsPackage();

} //Families2PersonsFactory
