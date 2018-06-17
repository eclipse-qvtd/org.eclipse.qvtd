/**
 * Copyright (c) 2010, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.xtext.qvtbasecs;

import org.eclipse.emf.ecore.EFactory;
import org.eclipse.jdt.annotation.NonNull;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.xtext.qvtbasecs.QVTbaseCSPackage
 * @generated
 */
public interface QVTbaseCSFactory extends EFactory
{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QVTbaseCSFactory eINSTANCE = org.eclipse.qvtd.xtext.qvtbasecs.impl.QVTbaseCSFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Java Class CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Java Class CS</em>'.
	 * @generated
	 */
	@NonNull JavaClassCS createJavaClassCS();

	/**
	 * Returns a new object of class '<em>Qualified Package CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Qualified Package CS</em>'.
	 * @generated
	 */
	@NonNull QualifiedPackageCS createQualifiedPackageCS();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	QVTbaseCSPackage getQVTbaseCSPackage();

} //QVTbaseCSFactory
