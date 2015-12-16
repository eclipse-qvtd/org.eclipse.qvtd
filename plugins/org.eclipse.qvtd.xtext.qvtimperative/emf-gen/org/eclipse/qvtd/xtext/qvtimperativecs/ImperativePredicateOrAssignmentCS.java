/**
 * <copyright>
 * 
 * Copyright (c) 2013, 2015 Willink Transformations and others.
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

import org.eclipse.qvtd.xtext.qvtcorebasecs.PredicateOrAssignmentCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Imperative Predicate Or Assignment CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.ImperativePredicateOrAssignmentCS#isIsAccumulate <em>Is Accumulate</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getImperativePredicateOrAssignmentCS()
 * @model
 * @generated
 */
public interface ImperativePredicateOrAssignmentCS extends PredicateOrAssignmentCS {
	/**
	 * Returns the value of the '<em><b>Is Accumulate</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Accumulate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Accumulate</em>' attribute.
	 * @see #setIsAccumulate(boolean)
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getImperativePredicateOrAssignmentCS_IsAccumulate()
	 * @model default="false"
	 * @generated
	 */
	boolean isIsAccumulate();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.ImperativePredicateOrAssignmentCS#isIsAccumulate <em>Is Accumulate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Accumulate</em>' attribute.
	 * @see #isIsAccumulate()
	 * @generated
	 */
	void setIsAccumulate(boolean value);

} // ImperativePredicateOrAssignmentCS
