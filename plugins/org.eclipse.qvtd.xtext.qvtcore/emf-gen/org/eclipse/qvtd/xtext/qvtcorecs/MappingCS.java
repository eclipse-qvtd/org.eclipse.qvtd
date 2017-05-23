/*******************************************************************************
 * Copyright (c) 2012, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtcorecs;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.xtext.basecs.NamedElementCS;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecs.MappingCS#isIsAbstract <em>Is Abstract</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecs.MappingCS#getOverridden <em>Overridden</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecs.MappingCS#getOwnedComposedMappings <em>Owned Composed Mappings</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecs.MappingCS#getOwnedDomains <em>Owned Domains</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecs.MappingCS#getOwnedInPathName <em>Owned In Path Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecs.MappingCS#getOwnedMiddle <em>Owned Middle</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecs.MappingCS#getRefines <em>Refines</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.xtext.qvtcorecs.QVTcoreCSPackage#getMappingCS()
 * @model
 * @generated
 */
public interface MappingCS extends NamedElementCS {
	/**
	 * Returns the value of the '<em><b>Is Abstract</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Abstract</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Abstract</em>' attribute.
	 * @see #setIsAbstract(boolean)
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.QVTcoreCSPackage#getMappingCS_IsAbstract()
	 * @model default="false"
	 * @generated
	 */
	boolean isIsAbstract();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtcorecs.MappingCS#isIsAbstract <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Abstract</em>' attribute.
	 * @see #isIsAbstract()
	 * @generated
	 */
	void setIsAbstract(boolean value);

	/**
	 * Returns the value of the '<em><b>Overridden</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Overridden</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Overridden</em>' reference.
	 * @see #setOverridden(Mapping)
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.QVTcoreCSPackage#getMappingCS_Overridden()
	 * @model
	 * @generated
	 */
	Mapping getOverridden();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtcorecs.MappingCS#getOverridden <em>Overridden</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Overridden</em>' reference.
	 * @see #getOverridden()
	 * @generated
	 */
	void setOverridden(Mapping value);

	/**
	 * Returns the value of the '<em><b>Owned Composed Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.xtext.qvtcorecs.MappingCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Composed Mappings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Composed Mappings</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.QVTcoreCSPackage#getMappingCS_OwnedComposedMappings()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<MappingCS> getOwnedComposedMappings();

	/**
	 * Returns the value of the '<em><b>Owned Domains</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.xtext.qvtcorecs.DomainCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Domains</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Domains</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.QVTcoreCSPackage#getMappingCS_OwnedDomains()
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
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.QVTcoreCSPackage#getMappingCS_OwnedInPathName()
	 * @model containment="true"
	 * @generated
	 */
	PathNameCS getOwnedInPathName();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtcorecs.MappingCS#getOwnedInPathName <em>Owned In Path Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned In Path Name</em>' containment reference.
	 * @see #getOwnedInPathName()
	 * @generated
	 */
	void setOwnedInPathName(PathNameCS value);

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
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.QVTcoreCSPackage#getMappingCS_OwnedMiddle()
	 * @model containment="true" required="true"
	 * @generated
	 */
	DomainCS getOwnedMiddle();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtcorecs.MappingCS#getOwnedMiddle <em>Owned Middle</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Middle</em>' containment reference.
	 * @see #getOwnedMiddle()
	 * @generated
	 */
	void setOwnedMiddle(DomainCS value);

	/**
	 * Returns the value of the '<em><b>Refines</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtcore.Mapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refines</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refines</em>' reference list.
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.QVTcoreCSPackage#getMappingCS_Refines()
	 * @model
	 * @generated
	 */
	EList<Mapping> getRefines();

} // MappingCS
