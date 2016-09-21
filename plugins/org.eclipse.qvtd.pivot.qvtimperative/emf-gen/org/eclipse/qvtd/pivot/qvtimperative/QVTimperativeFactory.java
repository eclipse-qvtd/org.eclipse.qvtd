/*******************************************************************************
 * Copyright (c) 2013, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative;

import org.eclipse.emf.ecore.EFactory;
import org.eclipse.jdt.annotation.NonNull;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage
 * @generated
 */
public interface QVTimperativeFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QVTimperativeFactory eINSTANCE = org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativeFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Add Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Add Statement</em>'.
	 * @generated
	 */
	@NonNull AddStatement createAddStatement();

	/**
	 * Returns a new object of class '<em>Append Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Append Parameter</em>'.
	 * @generated
	 */
	@NonNull AppendParameter createAppendParameter();

	/**
	 * Returns a new object of class '<em>Append Parameter Binding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Append Parameter Binding</em>'.
	 * @generated
	 */
	@NonNull AppendParameterBinding createAppendParameterBinding();

	/**
	 * Returns a new object of class '<em>Buffer Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Buffer Statement</em>'.
	 * @generated
	 */
	@NonNull BufferStatement createBufferStatement();

	/**
	 * Returns a new object of class '<em>Check Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Check Statement</em>'.
	 * @generated
	 */
	@NonNull CheckStatement createCheckStatement();

	/**
	 * Returns a new object of class '<em>Declare Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Declare Statement</em>'.
	 * @generated
	 */
	@NonNull DeclareStatement createDeclareStatement();

	/**
	 * Returns a new object of class '<em>Guard Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Guard Parameter</em>'.
	 * @generated
	 */
	@NonNull GuardParameter createGuardParameter();

	/**
	 * Returns a new object of class '<em>Guard Parameter Binding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Guard Parameter Binding</em>'.
	 * @generated
	 */
	@NonNull GuardParameterBinding createGuardParameterBinding();

	/**
	 * Returns a new object of class '<em>Imperative Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Imperative Model</em>'.
	 * @generated
	 */
	@NonNull ImperativeModel createImperativeModel();

	/**
	 * Returns a new object of class '<em>Imperative Transformation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Imperative Transformation</em>'.
	 * @generated
	 */
	@NonNull ImperativeTransformation createImperativeTransformation();

	/**
	 * Returns a new object of class '<em>Imperative Typed Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Imperative Typed Model</em>'.
	 * @generated
	 */
	@NonNull ImperativeTypedModel createImperativeTypedModel();

	/**
	 * Returns a new object of class '<em>Loop Parameter Binding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Loop Parameter Binding</em>'.
	 * @generated
	 */
	@NonNull LoopParameterBinding createLoopParameterBinding();

	/**
	 * Returns a new object of class '<em>Loop Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Loop Variable</em>'.
	 * @generated
	 */
	@NonNull LoopVariable createLoopVariable();

	/**
	 * Returns a new object of class '<em>Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping</em>'.
	 * @generated
	 */
	@NonNull Mapping createMapping();

	/**
	 * Returns a new object of class '<em>Mapping Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping Call</em>'.
	 * @generated
	 */
	@NonNull MappingCall createMappingCall();

	/**
	 * Returns a new object of class '<em>Mapping Loop</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping Loop</em>'.
	 * @generated
	 */
	@NonNull MappingLoop createMappingLoop();

	/**
	 * Returns a new object of class '<em>New Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>New Statement</em>'.
	 * @generated
	 */
	@NonNull NewStatement createNewStatement();

	/**
	 * Returns a new object of class '<em>Set Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Statement</em>'.
	 * @generated
	 */
	@NonNull SetStatement createSetStatement();

	/**
	 * Returns a new object of class '<em>Simple Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simple Parameter</em>'.
	 * @generated
	 */
	@NonNull SimpleParameter createSimpleParameter();

	/**
	 * Returns a new object of class '<em>Simple Parameter Binding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simple Parameter Binding</em>'.
	 * @generated
	 */
	@NonNull SimpleParameterBinding createSimpleParameterBinding();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	QVTimperativePackage getQVTimperativePackage();

} //QVTimperativeFactory
