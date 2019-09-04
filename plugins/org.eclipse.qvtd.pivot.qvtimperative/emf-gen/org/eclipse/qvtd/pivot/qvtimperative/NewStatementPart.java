/**
 * <copyright>
 * 
 * Copyright (c) 2013, 2019 Willink Transformations and others.
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

import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Property;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>New Statement Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A NewStatementPart declares the initialization of one part of a unique shared object for a NewStatement..
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.NewStatementPart#getReferredProperty <em>Referred Property</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.NewStatementPart#getOwnedExpression <em>Owned Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.NewStatementPart#getOwningNewStatement <em>Owning New Statement</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getNewStatementPart()
 * @generated
 */
public interface NewStatementPart extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Referred Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The property identifying the part to be initialized.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Referred Property</em>' reference.
	 * @see #setReferredProperty(Property)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getNewStatementPart_ReferredProperty()
	 * @generated
	 */
	Property getReferredProperty();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.NewStatementPart#getReferredProperty <em>Referred Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Property</em>' reference.
	 * @see #getReferredProperty()
	 * @generated
	 */
	void setReferredProperty(Property value);

	/**
	 * Returns the value of the '<em><b>Owned Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The expression computing the part's value.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Expression</em>' containment reference.
	 * @see #setOwnedExpression(OCLExpression)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getNewStatementPart_OwnedExpression()
	 * @generated
	 */
	OCLExpression getOwnedExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.NewStatementPart#getOwnedExpression <em>Owned Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Expression</em>' containment reference.
	 * @see #getOwnedExpression()
	 * @generated
	 */
	void setOwnedExpression(OCLExpression value);

	/**
	 * Returns the value of the '<em><b>Owning New Statement</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtimperative.NewStatement#getOwnedParts <em>Owned Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The expression computing the part's value.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owning New Statement</em>' container reference.
	 * @see #setOwningNewStatement(NewStatement)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getNewStatementPart_OwningNewStatement()
	 * @see org.eclipse.qvtd.pivot.qvtimperative.NewStatement#getOwnedParts
	 * @generated
	 */
	NewStatement getOwningNewStatement();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.NewStatementPart#getOwningNewStatement <em>Owning New Statement</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning New Statement</em>' container reference.
	 * @see #getOwningNewStatement()
	 * @generated
	 */
	void setOwningNewStatement(NewStatement value);

} // NewStatementPart
