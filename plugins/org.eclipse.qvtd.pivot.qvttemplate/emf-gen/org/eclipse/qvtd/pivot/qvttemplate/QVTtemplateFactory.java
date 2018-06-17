/*******************************************************************************
 * Copyright (c) 2011, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvttemplate;

import org.eclipse.emf.ecore.EFactory;
import org.eclipse.jdt.annotation.NonNull;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.pivot.qvttemplate.QVTtemplatePackage
 * @generated
 */
public interface QVTtemplateFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QVTtemplateFactory eINSTANCE = org.eclipse.qvtd.pivot.qvttemplate.impl.QVTtemplateFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Collection Template Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Collection Template Exp</em>'.
	 * @generated
	 */
	@NonNull CollectionTemplateExp createCollectionTemplateExp();

	/**
	 * Returns a new object of class '<em>Object Template Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Object Template Exp</em>'.
	 * @generated
	 */
	@NonNull ObjectTemplateExp createObjectTemplateExp();

	/**
	 * Returns a new object of class '<em>Property Template Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Template Item</em>'.
	 * @generated
	 */
	@NonNull PropertyTemplateItem createPropertyTemplateItem();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	QVTtemplatePackage getQVTtemplatePackage();

} //QVTtemplateFactory
