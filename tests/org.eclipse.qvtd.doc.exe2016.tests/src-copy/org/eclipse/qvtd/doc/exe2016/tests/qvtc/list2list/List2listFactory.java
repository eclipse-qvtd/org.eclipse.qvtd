/**
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list;

import org.eclipse.emf.ecore.EFactory;
import org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.impl.List2listFactoryImpl;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.List2listPackage
 * @generated
 */
public interface List2listFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	List2listFactory eINSTANCE = List2listFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>List2 List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>List2 List</em>'.
	 * @generated
	 */
	List2List createList2List();

	/**
	 * Returns a new object of class '<em>Element2 Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Element2 Element</em>'.
	 * @generated
	 */
	Element2Element createElement2Element();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	List2listPackage getList2listPackage();

} //List2listFactory
