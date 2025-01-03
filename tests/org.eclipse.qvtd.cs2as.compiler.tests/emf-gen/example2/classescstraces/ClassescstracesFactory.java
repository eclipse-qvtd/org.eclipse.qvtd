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
package example2.classescstraces;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see example2.classescstraces.ClassescstracesPackage
 * @generated
 */
public interface ClassescstracesFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ClassescstracesFactory eINSTANCE = example2.classescstraces.impl.ClassescstracesFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Package CS2 Package</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Package CS2 Package</em>'.
	 * @generated
	 */
	PackageCS2Package createPackageCS2Package();

	/**
	 * Returns a new object of class '<em>Class CS2 Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Class CS2 Class</em>'.
	 * @generated
	 */
	ClassCS2Class createClassCS2Class();

	/**
	 * Returns a new object of class '<em>Root CS2 Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Root CS2 Root</em>'.
	 * @generated
	 */
	RootCS2Root createRootCS2Root();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ClassescstracesPackage getClassescstracesPackage();

} //ClassescstracesFactory
