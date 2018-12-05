/*******************************************************************************
 * Copyright (c) 2012, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtrelationcs;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Domain CS</b></em>'.
 * @extends org.eclipse.ocl.pivot.utilities.Nameable
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.DomainCS#getImplementedBy <em>Implemented By</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.DomainCS#isIsCheckonly <em>Is Checkonly</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.DomainCS#isIsEnforce <em>Is Enforce</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.DomainCS#getModelId <em>Model Id</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.DomainCS#isIsReplace <em>Is Replace</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.DomainCS#getOwnedPatterns <em>Owned Patterns</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.DomainCS#getOwnedDefaultValues <em>Owned Default Values</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.DomainCS#getOwnedImplementedBy <em>Owned Implemented By</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage#getDomainCS()
 * @model
 * @generated
 */
public interface DomainCS extends AbstractDomainCS, org.eclipse.ocl.pivot.utilities.Nameable {
	/**
	 * Returns the value of the '<em><b>Implemented By</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implemented By</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implemented By</em>' attribute.
	 * @see #setImplementedBy(String)
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage#getDomainCS_ImplementedBy()
	 * @model dataType="org.eclipse.ocl.pivot.String"
	 * @generated
	 */
	String getImplementedBy();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtrelationcs.DomainCS#getImplementedBy <em>Implemented By</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implemented By</em>' attribute.
	 * @see #getImplementedBy()
	 * @generated
	 */
	void setImplementedBy(String value);

	/**
	 * Returns the value of the '<em><b>Is Checkonly</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Checkonly</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Checkonly</em>' attribute.
	 * @see #setIsCheckonly(boolean)
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage#getDomainCS_IsCheckonly()
	 * @model
	 * @generated
	 */
	boolean isIsCheckonly();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtrelationcs.DomainCS#isIsCheckonly <em>Is Checkonly</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Checkonly</em>' attribute.
	 * @see #isIsCheckonly()
	 * @generated
	 */
	void setIsCheckonly(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Enforce</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Enforce</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Enforce</em>' attribute.
	 * @see #setIsEnforce(boolean)
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage#getDomainCS_IsEnforce()
	 * @model
	 * @generated
	 */
	boolean isIsEnforce();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtrelationcs.DomainCS#isIsEnforce <em>Is Enforce</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Enforce</em>' attribute.
	 * @see #isIsEnforce()
	 * @generated
	 */
	void setIsEnforce(boolean value);

	/**
	 * Returns the value of the '<em><b>Model Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Id</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Id</em>' reference.
	 * @see #setModelId(TypedModel)
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage#getDomainCS_ModelId()
	 * @model
	 * @generated
	 */
	TypedModel getModelId();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtrelationcs.DomainCS#getModelId <em>Model Id</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model Id</em>' reference.
	 * @see #getModelId()
	 * @generated
	 */
	void setModelId(TypedModel value);

	/**
	 * Returns the value of the '<em><b>Is Replace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Replace</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Replace</em>' attribute.
	 * @see #setIsReplace(boolean)
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage#getDomainCS_IsReplace()
	 * @model
	 * @generated
	 */
	boolean isIsReplace();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtrelationcs.DomainCS#isIsReplace <em>Is Replace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Replace</em>' attribute.
	 * @see #isIsReplace()
	 * @generated
	 */
	void setIsReplace(boolean value);

	/**
	 * Returns the value of the '<em><b>Owned Patterns</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.xtext.qvtrelationcs.DomainPatternCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Patterns</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Patterns</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage#getDomainCS_OwnedPatterns()
	 * @model containment="true"
	 * @generated
	 */
	EList<DomainPatternCS> getOwnedPatterns();

	/**
	 * Returns the value of the '<em><b>Owned Default Values</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.xtext.qvtrelationcs.DefaultValueCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Default Values</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Default Values</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage#getDomainCS_OwnedDefaultValues()
	 * @model containment="true"
	 * @generated
	 */
	EList<DefaultValueCS> getOwnedDefaultValues();

	/**
	 * Returns the value of the '<em><b>Owned Implemented By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Implemented By</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Implemented By</em>' containment reference.
	 * @see #setOwnedImplementedBy(ExpCS)
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage#getDomainCS_OwnedImplementedBy()
	 * @model containment="true"
	 * @generated
	 */
	ExpCS getOwnedImplementedBy();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtrelationcs.DomainCS#getOwnedImplementedBy <em>Owned Implemented By</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Implemented By</em>' containment reference.
	 * @see #getOwnedImplementedBy()
	 * @generated
	 */
	void setOwnedImplementedBy(ExpCS value);

} // DomainCS
