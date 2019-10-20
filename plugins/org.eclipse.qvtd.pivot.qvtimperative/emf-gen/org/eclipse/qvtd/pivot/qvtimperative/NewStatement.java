/**
 * <copyright>
 *
 * Copyright (c) 2013, 2018 Willink Transformations and others.
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
import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>New Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A NewStatement creates an instance of a class and binds a name to it.
 * 
 * syntax: oclText[new:typedModel name : type := expression;]
 * 
 * If expression is omitted, a new instance if the tyope is created. If expression is provided, it
 * computes the 'new' object, typically a singleton supervisor fpr a QVTr key.
 * 
 * syntax: oclText[new:typedModel name : type { name1 = init1, name2 = init2 }]
 * 
 * If constructor parts are provided, a unique instance of the parameterized property names is shared
 * by all identical constructions.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.NewStatement#isIsContained <em>Is Contained</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.NewStatement#getReferredTypedModel <em>Referred Typed Model</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.NewStatement#getOwnedExpression <em>Owned Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.NewStatement#getOwnedParts <em>Owned Parts</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getNewStatement()
 * @generated
 */
public interface NewStatement extends VariableStatement, ObservableStatement {

	/**
	 * Returns the value of the '<em><b>Is Contained</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * True if the new element is guaranteed to be assigned to a container and so does not need to be tracked in the set of potential orphan elememnts to be contained at the model root.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Contained</em>' attribute.
	 * @see #setIsContained(boolean)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getNewStatement_IsContained()
	 * @generated
	 */
	boolean isIsContained();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.NewStatement#isIsContained <em>Is Contained</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Contained</em>' attribute.
	 * @see #isIsContained()
	 * @generated
	 */
	void setIsContained(boolean value);

	/**
	 * Returns the value of the '<em><b>Referred Typed Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Typed Model</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The TypedModel to which the new object is added.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Referred Typed Model</em>' reference.
	 * @see #setReferredTypedModel(TypedModel)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getNewStatement_ReferredTypedModel()
	 * @generated
	 */
	TypedModel getReferredTypedModel();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.NewStatement#getReferredTypedModel <em>Referred Typed Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Typed Model</em>' reference.
	 * @see #getReferredTypedModel()
	 * @generated
	 */
	void setReferredTypedModel(TypedModel value);

	/**
	 * Returns the value of the '<em><b>Owned Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Optional expression that constructs the new object.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Expression</em>' containment reference.
	 * @see #setOwnedExpression(OCLExpression)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getNewStatement_OwnedExpression()
	 * @generated
	 */
	OCLExpression getOwnedExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.NewStatement#getOwnedExpression <em>Owned Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Expression</em>' containment reference.
	 * @see #getOwnedExpression()
	 * @generated
	 */
	void setOwnedExpression(OCLExpression value);

	/**
	 * Returns the value of the '<em><b>Owned Parts</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtimperative.NewStatementPart}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtimperative.NewStatementPart#getOwningNewStatement <em>Owning New Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The parts that parameterize a unique shared construction.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Parts</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getNewStatement_OwnedParts()
	 * @see org.eclipse.qvtd.pivot.qvtimperative.NewStatementPart#getOwningNewStatement
	 * @generated
	 */
	EList<NewStatementPart> getOwnedParts();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateCompatibleTypeForValue(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateNonDataTypeForType(DiagnosticChain diagnostics, Map<Object, Object> context);
} // NewStatement
