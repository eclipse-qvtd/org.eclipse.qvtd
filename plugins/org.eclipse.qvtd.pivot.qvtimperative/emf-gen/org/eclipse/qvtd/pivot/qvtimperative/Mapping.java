/*******************************************************************************
 * Copyright (c) 2013, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.qvtd.pivot.qvtbase.Rule;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An Imperative Mapping extends the abstract declarative mapping to support
 * explicit nested invocation of mappings with bindings for the invoked mapping's
 * bound variables.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.Mapping#isIsStrict <em>Is Strict</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.Mapping#getOwnedMappingParameters <em>Owned Mapping Parameters</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.Mapping#getOwnedStatements <em>Owned Statements</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getMapping()
 * @generated
 */
public interface Mapping extends Rule {
	/**
	 * Returns the value of the '<em><b>Is Strict</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Repeated invocations of a strict Mapping are suppressed at run-time.
	 * 
	 * Repeated invocations of a not-strict Mapping are guaranteed not to occur.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Strict</em>' attribute.
	 * @see #setIsStrict(boolean)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getMapping_IsStrict()
	 * @generated
	 */
	boolean isIsStrict();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.Mapping#isIsStrict <em>Is Strict</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Strict</em>' attribute.
	 * @see #isIsStrict()
	 * @generated
	 */
	void setIsStrict(boolean value);

	/**
	 * Returns the value of the '<em><b>Owned Mapping Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtimperative.MappingParameter}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingParameter#getOwningMapping <em>Owning Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Mapping Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Mapping Parameters</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getMapping_OwnedMappingParameters()
	 * @see org.eclipse.qvtd.pivot.qvtimperative.MappingParameter#getOwningMapping
	 * @generated
	 */
	EList<MappingParameter> getOwnedMappingParameters();

	/**
	 * Returns the value of the '<em><b>Owned Statements</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtimperative.Statement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Statements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Statements</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getMapping_OwnedStatements()
	 * @generated
	 */
	EList<Statement> getOwnedStatements();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateNameIsNotNull(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateMappingParameterNamesAreUnique(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateLocalVariableNamesAreUnique(DiagnosticChain diagnostics, Map<Object, Object> context);

} // Mapping
