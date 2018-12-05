/*******************************************************************************
 * Copyright (c) 2016, 2018 Willink Transformations and others.
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
package example3.kiamacs;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see example3.kiamacs.KiamacsPackage
 * @generated
 */
public interface KiamacsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	KiamacsFactory eINSTANCE = example3.kiamacs.impl.KiamacsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Top CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Top CS</em>'.
	 * @generated
	 */
	TopCS createTopCS();

	/**
	 * Returns a new object of class '<em>Plus CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Plus CS</em>'.
	 * @generated
	 */
	PlusCS createPlusCS();

	/**
	 * Returns a new object of class '<em>Num CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Num CS</em>'.
	 * @generated
	 */
	NumCS createNumCS();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	KiamacsPackage getKiamacsPackage();

} //KiamacsFactory
