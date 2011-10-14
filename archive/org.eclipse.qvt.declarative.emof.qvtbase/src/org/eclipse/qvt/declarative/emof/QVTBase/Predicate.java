/**
 * <copyright>
 * 
 * Copyright (c) 2007, 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: Predicate.java,v 1.1 2008/07/23 09:57:28 qglineur Exp $
 */
package org.eclipse.qvt.declarative.emof.QVTBase;

import org.eclipse.qvt.declarative.emof.EMOF.Element;

import org.eclipse.qvt.declarative.emof.EssentialOCL.OclExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Predicate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.emof.QVTBase.Predicate#getConditionExpression <em>Condition Expression</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.emof.QVTBase.Predicate#getPattern <em>Pattern</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.emof.QVTBase.QVTBasePackage#getPredicate()
 * @model
 * @generated
 */
public interface Predicate extends Element {
	/**
	 * Returns the value of the '<em><b>Condition Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition Expression</em>' containment reference.
	 * @see #setConditionExpression(OclExpression)
	 * @see org.eclipse.qvt.declarative.emof.QVTBase.QVTBasePackage#getPredicate_ConditionExpression()
	 * @model containment="true" required="true"
	 * @generated
	 */
	OclExpression getConditionExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.emof.QVTBase.Predicate#getConditionExpression <em>Condition Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition Expression</em>' containment reference.
	 * @see #getConditionExpression()
	 * @generated
	 */
	void setConditionExpression(OclExpression value);

	/**
	 * Returns the value of the '<em><b>Pattern</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvt.declarative.emof.QVTBase.Pattern#getPredicate <em>Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pattern</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pattern</em>' container reference.
	 * @see #setPattern(Pattern)
	 * @see org.eclipse.qvt.declarative.emof.QVTBase.QVTBasePackage#getPredicate_Pattern()
	 * @see org.eclipse.qvt.declarative.emof.QVTBase.Pattern#getPredicate
	 * @model opposite="predicate" required="true"
	 * @generated
	 */
	Pattern getPattern();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.emof.QVTBase.Predicate#getPattern <em>Pattern</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pattern</em>' container reference.
	 * @see #getPattern()
	 * @generated
	 */
	void setPattern(Pattern value);

} // Predicate
