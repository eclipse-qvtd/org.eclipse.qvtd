/**
 * <copyright>
 * 
 * Copyright (c) 2007, 2008 E.D.Willink and others.
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
 * $Id: QVTCSTFactory.java,v 1.2 2008/10/10 07:52:55 ewillink Exp $
 */
package org.eclipse.qvt.declarative.parser.qvt.cst;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvt.declarative.parser.qvt.cst.QVTCSTPackage
 * @generated
 */
public interface QVTCSTFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QVTCSTFactory eINSTANCE = org.eclipse.qvt.declarative.parser.qvt.cst.impl.QVTCSTFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Error Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Error Node</em>'.
	 * @generated
	 */
	ErrorNode createErrorNode();

	/**
	 * Returns a new object of class '<em>Identified CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Identified CS</em>'.
	 * @generated
	 */
	IdentifiedCS createIdentifiedCS();

	/**
	 * Returns a new object of class '<em>Identifier CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Identifier CS</em>'.
	 * @generated
	 */
	IdentifierCS createIdentifierCS();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	QVTCSTPackage getQVTCSTPackage();

} //EqvtCSTFactory
