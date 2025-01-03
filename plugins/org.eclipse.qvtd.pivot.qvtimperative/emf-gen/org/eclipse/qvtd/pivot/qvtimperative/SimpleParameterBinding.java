/**
 * <copyright>
 *
 * Copyright (c) 2013, 2021 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.pivot.qvtimperative;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.ocl.pivot.OCLExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple Parameter Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A SimpleParameterBinding binds a simple parameter of an invoked Mapping to the value of an expression
 * computed by the invoker. Execution of the mapping may use the value.
 *
 * syntax: oclText[formalName uses expression;]
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.SimpleParameterBinding#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.SimpleParameterBinding#isIsCheck <em>Is Check</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getSimpleParameterBinding()
 * @generated
 */
public interface SimpleParameterBinding extends MappingParameterBinding {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The value or collection of values to bind to boundVariable
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(OCLExpression)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getSimpleParameterBinding_Value()
	 * @generated
	 */
	OCLExpression getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.SimpleParameterBinding#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(OCLExpression value);

	/**
	 * Returns the value of the '<em><b>Is Check</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether the variable initialization needs to be checked as a predicate. This is a derivation of not ownedInit.type.conformsTo(self.type).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Check</em>' attribute.
	 * @see #setIsCheck(boolean)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getSimpleParameterBinding_IsCheck()
	 * @generated
	 */
	boolean isIsCheck();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.SimpleParameterBinding#isIsCheck <em>Is Check</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Check</em>' attribute.
	 * @see #isIsCheck()
	 * @generated
	 */
	void setIsCheck(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateCompatibleTypeForCheckedValue(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateCompatibleTypeForUncheckedValue(DiagnosticChain diagnostics, Map<Object, Object> context);

} // SimpleParameterBinding
