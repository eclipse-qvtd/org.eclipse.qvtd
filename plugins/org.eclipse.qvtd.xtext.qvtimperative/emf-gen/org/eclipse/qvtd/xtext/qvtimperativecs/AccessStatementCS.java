/**
 * <copyright>
 * 
 * Copyright (c) 2013, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.qvtd.xtext.qvtimperativecs;

import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.VariableDeclaration;

import org.eclipse.ocl.xtext.basecs.TypedElementCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Access Statement CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.AccessStatementCS#getSourceProperty <em>Source Property</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.AccessStatementCS#getSourceVariable <em>Source Variable</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getAccessStatementCS()
 * @model
 * @generated
 */
public interface AccessStatementCS extends TypedElementCS, StatementCS {
	/**
	 * Returns the value of the '<em><b>Source Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Property</em>' reference.
	 * @see #setSourceProperty(Property)
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getAccessStatementCS_SourceProperty()
	 * @model required="true"
	 * @generated
	 */
	Property getSourceProperty();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.AccessStatementCS#getSourceProperty <em>Source Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Property</em>' reference.
	 * @see #getSourceProperty()
	 * @generated
	 */
	void setSourceProperty(Property value);

	/**
	 * Returns the value of the '<em><b>Source Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Variable</em>' reference.
	 * @see #setSourceVariable(VariableDeclaration)
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getAccessStatementCS_SourceVariable()
	 * @model required="true"
	 * @generated
	 */
	VariableDeclaration getSourceVariable();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.AccessStatementCS#getSourceVariable <em>Source Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Variable</em>' reference.
	 * @see #getSourceVariable()
	 * @generated
	 */
	void setSourceVariable(VariableDeclaration value);

} // AccessStatementCS
