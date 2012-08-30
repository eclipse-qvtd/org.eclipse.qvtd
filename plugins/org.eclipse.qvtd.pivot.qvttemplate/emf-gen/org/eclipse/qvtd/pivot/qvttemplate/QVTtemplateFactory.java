/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.qvtd.pivot.qvttemplate;

import org.eclipse.emf.ecore.EFactory;

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
	CollectionTemplateExp createCollectionTemplateExp();

	/**
	 * Returns a new object of class '<em>Object Template Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Object Template Exp</em>'.
	 * @generated
	 */
	ObjectTemplateExp createObjectTemplateExp();

	/**
	 * Returns a new object of class '<em>Property Template Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Template Item</em>'.
	 * @generated
	 */
	PropertyTemplateItem createPropertyTemplateItem();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	QVTtemplatePackage getQVTtemplatePackage();

} //QVTtemplateFactory
