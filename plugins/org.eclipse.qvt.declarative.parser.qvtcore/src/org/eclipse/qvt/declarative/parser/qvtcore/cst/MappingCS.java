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
 * $Id: MappingCS.java,v 1.1 2008/07/23 10:06:41 qglineur Exp $
 */
package org.eclipse.qvt.declarative.parser.qvtcore.cst;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.cst.PathNameCS;
import org.eclipse.qvt.declarative.parser.qvt.cst.IdentifiedCS;
import org.eclipse.qvt.declarative.parser.qvt.cst.IdentifierCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.MappingCS#getComposedMappings <em>Composed Mappings</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.MappingCS#getDomains <em>Domains</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.MappingCS#getIn <em>In</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.MappingCS#getMiddle <em>Middle</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.MappingCS#getRefines <em>Refines</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.QVTcCSTPackage#getMappingCS()
 * @model
 * @generated
 */
public interface MappingCS extends IdentifiedCS {
	/**
	 * Returns the value of the '<em><b>In</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In</em>' containment reference.
	 * @see #setIn(PathNameCS)
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.QVTcCSTPackage#getMappingCS_In()
	 * @model containment="true"
	 * @generated
	 */
	PathNameCS getIn();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.MappingCS#getIn <em>In</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>In</em>' containment reference.
	 * @see #getIn()
	 * @generated
	 */
	void setIn(PathNameCS value);

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
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.QVTcCSTPackage#getMappingCS_Middle()
	 * @model containment="true" required="true"
	 * @generated
	 */
	DomainCS getMiddle();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.MappingCS#getMiddle <em>Middle</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Middle</em>' containment reference.
	 * @see #getMiddle()
	 * @generated
	 */
	void setMiddle(DomainCS value);

	/**
	 * Returns the value of the '<em><b>Refines</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvt.declarative.parser.qvt.cst.IdentifierCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refines</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refines</em>' containment reference list.
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.QVTcCSTPackage#getMappingCS_Refines()
	 * @model containment="true"
	 * @generated
	 */
	EList<IdentifierCS> getRefines();

	/**
	 * Returns the value of the '<em><b>Composed Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvt.declarative.parser.qvtcore.cst.MappingCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Composed Mappings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Composed Mappings</em>' containment reference list.
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.QVTcCSTPackage#getMappingCS_ComposedMappings()
	 * @model containment="true"
	 * @generated
	 */
	EList<MappingCS> getComposedMappings();

	/**
	 * Returns the value of the '<em><b>Domains</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvt.declarative.parser.qvtcore.cst.DomainCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domains</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domains</em>' containment reference list.
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.QVTcCSTPackage#getMappingCS_Domains()
	 * @model containment="true"
	 * @generated
	 */
	EList<DomainCS> getDomains();

} // MappingCS
