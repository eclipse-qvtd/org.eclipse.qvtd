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
 * $Id: TestQVTBaseFactory.java,v 1.2 2008/12/31 18:14:29 ewillink Exp $
 */
package org.eclipse.qvt.declarative.test.TestQVTBase;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvt.declarative.test.TestQVTBase.TestQVTBasePackage
 * @generated
 */
public interface TestQVTBaseFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TestQVTBaseFactory eINSTANCE = org.eclipse.qvt.declarative.test.TestQVTBase.impl.TestQVTBaseFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Test Domain</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Test Domain</em>'.
	 * @generated
	 */
	TestDomain createTestDomain();

	/**
	 * Returns a new object of class '<em>Test Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Test Expression</em>'.
	 * @generated
	 */
	TestExpression createTestExpression();

	/**
	 * Returns a new object of class '<em>Test Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Test Pattern</em>'.
	 * @generated
	 */
	TestPattern createTestPattern();

	/**
	 * Returns a new object of class '<em>Test Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Test Rule</em>'.
	 * @generated
	 */
	TestRule createTestRule();

	/**
	 * Returns a new object of class '<em>Test Transformation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Test Transformation</em>'.
	 * @generated
	 */
	TestTransformation createTestTransformation();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TestQVTBasePackage getTestQVTBasePackage();

} //TestQVTBaseFactory
