/**
 * <copyright>
 * 
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.qvtd.codegen.qvticgmodel;

import org.eclipse.emf.ecore.EFactory;
import org.eclipse.jdt.annotation.NonNull;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage
 * @generated
 */
public interface QVTiCGModelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@NonNull QVTiCGModelFactory eINSTANCE = org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>CG Ecore Property Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Ecore Property Assignment</em>'.
	 * @generated
	 */
	@NonNull CGEcorePropertyAssignment createCGEcorePropertyAssignment();

	/**
	 * Returns a new object of class '<em>CG Ecore Realized Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Ecore Realized Variable</em>'.
	 * @generated
	 */
	@NonNull CGEcoreRealizedVariable createCGEcoreRealizedVariable();

	/**
	 * Returns a new object of class '<em>CG Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Function</em>'.
	 * @generated
	 */
	@NonNull CGFunction createCGFunction();

	/**
	 * Returns a new object of class '<em>CG Function Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Function Call Exp</em>'.
	 * @generated
	 */
	@NonNull CGFunctionCallExp createCGFunctionCallExp();

	/**
	 * Returns a new object of class '<em>CG Function Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Function Parameter</em>'.
	 * @generated
	 */
	@NonNull CGFunctionParameter createCGFunctionParameter();

	/**
	 * Returns a new object of class '<em>CG Guard Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Guard Variable</em>'.
	 * @generated
	 */
	@NonNull CGGuardVariable createCGGuardVariable();

	/**
	 * Returns a new object of class '<em>CG Property Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Property Assignment</em>'.
	 * @generated
	 */
	@NonNull CGPropertyAssignment createCGPropertyAssignment();

	/**
	 * Returns a new object of class '<em>CG Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Mapping</em>'.
	 * @generated
	 */
	@NonNull CGMapping createCGMapping();

	/**
	 * Returns a new object of class '<em>CG Transformation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Transformation</em>'.
	 * @generated
	 */
	@NonNull CGTransformation createCGTransformation();

	/**
	 * Returns a new object of class '<em>CG Typed Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Typed Model</em>'.
	 * @generated
	 */
	@NonNull CGTypedModel createCGTypedModel();

	/**
	 * Returns a new object of class '<em>CG Mapping Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Mapping Call</em>'.
	 * @generated
	 */
	@NonNull CGMappingCall createCGMappingCall();

	/**
	 * Returns a new object of class '<em>CG Mapping Call Binding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Mapping Call Binding</em>'.
	 * @generated
	 */
	@NonNull CGMappingCallBinding createCGMappingCallBinding();

	/**
	 * Returns a new object of class '<em>CG Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Predicate</em>'.
	 * @generated
	 */
	@NonNull CGPredicate createCGPredicate();

	/**
	 * Returns a new object of class '<em>CG Realized Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Realized Variable</em>'.
	 * @generated
	 */
	@NonNull CGRealizedVariable createCGRealizedVariable();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	@NonNull QVTiCGModelPackage getQVTiCGModelPackage();

} //QVTiCGmodelFactory
