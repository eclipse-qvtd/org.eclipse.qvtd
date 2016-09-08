/*******************************************************************************
 * Copyright (c) 2012, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtimperativecs;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.xtext.basecs.NamedElementCS;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.MappingCS#isIsDefault <em>Is Default</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.MappingCS#getOwnedDomains <em>Owned Domains</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.MappingCS#getOwnedInPathName <em>Owned In Path Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.MappingCS#getOwnedKeyExpression <em>Owned Key Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.MappingCS#getOwnedStatements <em>Owned Statements</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.MappingCS#getOwnedMiddle <em>Owned Middle</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.MappingCS#getOwnedUsesPathNames <em>Owned Uses Path Names</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getMappingCS()
 * @model
 * @generated
 */
public interface MappingCS extends NamedElementCS {
	/**
	 * Returns the value of the '<em><b>Is Default</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Default</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Default</em>' attribute.
	 * @see #setIsDefault(boolean)
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getMappingCS_IsDefault()
	 * @model default="false"
	 * @generated
	 */
	boolean isIsDefault();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.MappingCS#isIsDefault <em>Is Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Default</em>' attribute.
	 * @see #isIsDefault()
	 * @generated
	 */
	void setIsDefault(boolean value);

	/**
	 * Returns the value of the '<em><b>Owned Domains</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.xtext.qvtimperativecs.DomainCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Domains</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Domains</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getMappingCS_OwnedDomains()
	 * @model containment="true"
	 * @generated
	 */
	EList<DomainCS> getOwnedDomains();

	/**
	 * Returns the value of the '<em><b>Owned In Path Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned In Path Name</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned In Path Name</em>' containment reference.
	 * @see #setOwnedInPathName(PathNameCS)
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getMappingCS_OwnedInPathName()
	 * @model containment="true"
	 * @generated
	 */
	PathNameCS getOwnedInPathName();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.MappingCS#getOwnedInPathName <em>Owned In Path Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned In Path Name</em>' containment reference.
	 * @see #getOwnedInPathName()
	 * @generated
	 */
	void setOwnedInPathName(PathNameCS value);

	/**
	 * Returns the value of the '<em><b>Owned Key Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Key Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Key Expression</em>' containment reference.
	 * @see #setOwnedKeyExpression(ExpCS)
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getMappingCS_OwnedKeyExpression()
	 * @model containment="true"
	 * @generated
	 */
	ExpCS getOwnedKeyExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.MappingCS#getOwnedKeyExpression <em>Owned Key Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Key Expression</em>' containment reference.
	 * @see #getOwnedKeyExpression()
	 * @generated
	 */
	void setOwnedKeyExpression(ExpCS value);

	/**
	 * Returns the value of the '<em><b>Owned Statements</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.xtext.qvtimperativecs.StatementCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Statements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Statements</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getMappingCS_OwnedStatements()
	 * @model containment="true"
	 * @generated
	 */
	EList<StatementCS> getOwnedStatements();

	/**
	 * Returns the value of the '<em><b>Owned Middle</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Middle</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Middle</em>' containment reference.
	 * @see #setOwnedMiddle(DomainCS)
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getMappingCS_OwnedMiddle()
	 * @model containment="true" required="true"
	 * @generated
	 */
	DomainCS getOwnedMiddle();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.MappingCS#getOwnedMiddle <em>Owned Middle</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Middle</em>' containment reference.
	 * @see #getOwnedMiddle()
	 * @generated
	 */
	void setOwnedMiddle(DomainCS value);

	/**
	 * Returns the value of the '<em><b>Owned Uses Path Names</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.xtext.basecs.PathNameCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Uses Path Names</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Uses Path Names</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getMappingCS_OwnedUsesPathNames()
	 * @model containment="true"
	 * @generated
	 */
	EList<PathNameCS> getOwnedUsesPathNames();

} // MappingCS
