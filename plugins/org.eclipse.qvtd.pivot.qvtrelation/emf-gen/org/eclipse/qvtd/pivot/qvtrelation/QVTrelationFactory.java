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
package org.eclipse.qvtd.pivot.qvtrelation;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage
 * @generated
 */
public interface QVTrelationFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QVTrelationFactory eINSTANCE = org.eclipse.qvtd.pivot.qvtrelation.impl.QVTrelationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Domain Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Domain Pattern</em>'.
	 * @generated
	 */
	DomainPattern createDomainPattern();

	/**
	 * Returns a new object of class '<em>Key</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Key</em>'.
	 * @generated
	 */
	Key createKey();

	/**
	 * Returns a new object of class '<em>Opposite Property Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Opposite Property Call Exp</em>'.
	 * @generated
	 */
	OppositePropertyCallExp createOppositePropertyCallExp();

	/**
	 * Returns a new object of class '<em>Relation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Relation</em>'.
	 * @generated
	 */
	Relation createRelation();

	/**
	 * Returns a new object of class '<em>Relation Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Relation Call Exp</em>'.
	 * @generated
	 */
	RelationCallExp createRelationCallExp();

	/**
	 * Returns a new object of class '<em>Relation Domain</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Relation Domain</em>'.
	 * @generated
	 */
	RelationDomain createRelationDomain();

	/**
	 * Returns a new object of class '<em>Relation Domain Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Relation Domain Assignment</em>'.
	 * @generated
	 */
	RelationDomainAssignment createRelationDomainAssignment();

	/**
	 * Returns a new object of class '<em>Relation Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Relation Model</em>'.
	 * @generated
	 */
	RelationModel createRelationModel();

	/**
	 * Returns a new object of class '<em>Relation Implementation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Relation Implementation</em>'.
	 * @generated
	 */
	RelationImplementation createRelationImplementation();

	/**
	 * Returns a new object of class '<em>Relational Transformation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Relational Transformation</em>'.
	 * @generated
	 */
	RelationalTransformation createRelationalTransformation();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	QVTrelationPackage getQVTrelationPackage();

} //QVTrelationFactory
