/**
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * ;All rights reserved. This program and the accompanying materials
 * ;are made available under the terms of the Eclipse Public License v1.0
 * ;which accompanies this distribution, and is available at
 * ;http://www.eclipse.org/legal/epl-v10.html
 * ;
 * ;Contributors:
 * ;  E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse;

import org.eclipse.emf.ecore.EFactory;
import org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.impl.PForward2ReverseFactoryImpl;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.PForward2ReversePackage
 * @generated
 */
public interface PForward2ReverseFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PForward2ReverseFactory eINSTANCE = PForward2ReverseFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Telement2element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Telement2element</em>'.
	 * @generated
	 */
	Telement2element createTelement2element();

	/**
	 * Returns a new object of class '<em>Tempty List2empty List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tempty List2empty List</em>'.
	 * @generated
	 */
	TemptyList2emptyList createTemptyList2emptyList();

	/**
	 * Returns a new object of class '<em>Tlist2list</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tlist2list</em>'.
	 * @generated
	 */
	Tlist2list createTlist2list();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	PForward2ReversePackage getPForward2ReversePackage();

} //PForward2ReverseFactory
