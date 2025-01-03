/*******************************************************************************
 * Copyright (c) 2016, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/**
 */
package example2.classes;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link example2.classes.Operation#getOwnedParameters <em>Owned Parameters</em>}</li>
 *   <li>{@link example2.classes.Operation#getOwnedExpressions <em>Owned Expressions</em>}</li>
 * </ul>
 *
 * @see example2.classes.ClassesPackage#getOperation()
 * @model
 * @generated
 */
public interface Operation extends NamedElement, TypedElement {
	/**
	 * Returns the value of the '<em><b>Owned Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link example2.classes.Parameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Parameters</em>' containment reference list.
	 * @see example2.classes.ClassesPackage#getOperation_OwnedParameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<Parameter> getOwnedParameters();

	/**
	 * Returns the value of the '<em><b>Owned Expressions</b></em>' containment reference list.
	 * The list contents are of type {@link example2.classes.CallExp}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Expressions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Expressions</em>' containment reference list.
	 * @see example2.classes.ClassesPackage#getOperation_OwnedExpressions()
	 * @model containment="true"
	 * @generated
	 */
	EList<CallExp> getOwnedExpressions();

} // Operation
