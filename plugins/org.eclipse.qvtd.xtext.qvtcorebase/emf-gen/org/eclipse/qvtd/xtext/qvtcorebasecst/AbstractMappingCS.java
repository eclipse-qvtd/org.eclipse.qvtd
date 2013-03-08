/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.qvtd.xtext.qvtcorebasecst;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.examples.xtext.base.baseCST.NamedElementCS;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorebasecst.AbstractMappingCS#getDomains <em>Domains</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorebasecst.AbstractMappingCS#getIn <em>In</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorebasecst.AbstractMappingCS#getMiddle <em>Middle</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvtd.xtext.qvtcorebasecst.QVTcoreBaseCSTPackage#getAbstractMappingCS()
 * @model abstract="true"
 * @generated
 */
public interface AbstractMappingCS extends NamedElementCS {
	/**
	 * Returns the value of the '<em><b>Domains</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.xtext.qvtcorebasecst.DomainCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domains</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domains</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtcorebasecst.QVTcoreBaseCSTPackage#getAbstractMappingCS_Domains()
	 * @model containment="true"
	 * @generated
	 */
	EList<DomainCS> getDomains();

	/**
	 * Returns the value of the '<em><b>In</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In</em>' reference.
	 * @see #setIn(Transformation)
	 * @see org.eclipse.qvtd.xtext.qvtcorebasecst.QVTcoreBaseCSTPackage#getAbstractMappingCS_In()
	 * @model
	 * @generated
	 */
	Transformation getIn();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtcorebasecst.AbstractMappingCS#getIn <em>In</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>In</em>' reference.
	 * @see #getIn()
	 * @generated
	 */
	void setIn(Transformation value);

	/**
	 * Returns the value of the '<em><b>Middle</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Middle</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Middle</em>' containment reference.
	 * @see #setMiddle(DomainCS)
	 * @see org.eclipse.qvtd.xtext.qvtcorebasecst.QVTcoreBaseCSTPackage#getAbstractMappingCS_Middle()
	 * @model containment="true" required="true"
	 * @generated
	 */
	DomainCS getMiddle();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtcorebasecst.AbstractMappingCS#getMiddle <em>Middle</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Middle</em>' containment reference.
	 * @see #getMiddle()
	 * @generated
	 */
	void setMiddle(DomainCS value);

} // MappingCS
