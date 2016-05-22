/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/**
 */
package org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus;

import org.eclipse.emf.ecore.EFactory;
import org.eclipse.jdt.annotation.NonNull;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.EvaluationStatusPackage
 * @generated
 */
public interface EvaluationStatusFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EvaluationStatusFactory eINSTANCE = org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.EvaluationStatusFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Association Status</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Association Status</em>'.
	 * @generated
	 */
	@NonNull AssociationStatus createAssociationStatus();

	/**
	 * Returns a new object of class '<em>Attribute Status</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute Status</em>'.
	 * @generated
	 */
	@NonNull AttributeStatus createAttributeStatus();

	/**
	 * Returns a new object of class '<em>Class Status</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Class Status</em>'.
	 * @generated
	 */
	@NonNull ClassStatus createClassStatus();

	/**
	 * Returns a new object of class '<em>Transformation Status</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Transformation Status</em>'.
	 * @generated
	 */
	@NonNull TransformationStatus createTransformationStatus();

	/**
	 * Returns a new object of class '<em>Mapping Status</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping Status</em>'.
	 * @generated
	 */
	@NonNull MappingStatus createMappingStatus();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EvaluationStatusPackage getEvaluationStatusPackage();

} //EvaluationStatusFactory
