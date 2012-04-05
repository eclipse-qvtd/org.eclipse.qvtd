/*******************************************************************************
 * Copyright (c) 2007 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.parser.qvtrelation.cst;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.cst.OperationCallExpCS;
import org.eclipse.qvt.declarative.parser.qvt.cst.IdentifierCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Domain CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.DomainCS#isCheckonly <em>Checkonly</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.DomainCS#isEnforce <em>Enforce</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.DomainCS#getModelId <em>Model Id</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.DomainCS#isReplace <em>Replace</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.DomainCS#getTemplate <em>Template</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.DomainCS#getDefaultValue <em>Default Value</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.DomainCS#getImplementedBy <em>Implemented By</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.QVTrCSTPackage#getDomainCS()
 * @model
 * @generated
 */
public interface DomainCS extends AbstractDomainCS {
	/**
	 * Returns the value of the '<em><b>Checkonly</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Checkonly</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Checkonly</em>' attribute.
	 * @see #setCheckonly(boolean)
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.QVTrCSTPackage#getDomainCS_Checkonly()
	 * @model
	 * @generated
	 */
	boolean isCheckonly();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.DomainCS#isCheckonly <em>Checkonly</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Checkonly</em>' attribute.
	 * @see #isCheckonly()
	 * @generated
	 */
	void setCheckonly(boolean value);

	/**
	 * Returns the value of the '<em><b>Enforce</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enforce</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enforce</em>' attribute.
	 * @see #setEnforce(boolean)
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.QVTrCSTPackage#getDomainCS_Enforce()
	 * @model
	 * @generated
	 */
	boolean isEnforce();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.DomainCS#isEnforce <em>Enforce</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enforce</em>' attribute.
	 * @see #isEnforce()
	 * @generated
	 */
	void setEnforce(boolean value);

	/**
	 * Returns the value of the '<em><b>Model Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Id</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Id</em>' containment reference.
	 * @see #setModelId(IdentifierCS)
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.QVTrCSTPackage#getDomainCS_ModelId()
	 * @model containment="true"
	 * @generated
	 */
	IdentifierCS getModelId();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.DomainCS#getModelId <em>Model Id</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model Id</em>' containment reference.
	 * @see #getModelId()
	 * @generated
	 */
	void setModelId(IdentifierCS value);

	/**
	 * Returns the value of the '<em><b>Replace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Replace</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Replace</em>' attribute.
	 * @see #setReplace(boolean)
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.QVTrCSTPackage#getDomainCS_Replace()
	 * @model
	 * @generated
	 */
	boolean isReplace();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.DomainCS#isReplace <em>Replace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Replace</em>' attribute.
	 * @see #isReplace()
	 * @generated
	 */
	void setReplace(boolean value);

	/**
	 * Returns the value of the '<em><b>Template</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Template</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Template</em>' containment reference.
	 * @see #setTemplate(TemplateCS)
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.QVTrCSTPackage#getDomainCS_Template()
	 * @model containment="true"
	 * @generated
	 */
	TemplateCS getTemplate();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.DomainCS#getTemplate <em>Template</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Template</em>' containment reference.
	 * @see #getTemplate()
	 * @generated
	 */
	void setTemplate(TemplateCS value);

	/**
	 * Returns the value of the '<em><b>Default Value</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.DefaultValueCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Value</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Value</em>' containment reference list.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.QVTrCSTPackage#getDomainCS_DefaultValue()
	 * @model containment="true"
	 * @generated
	 */
	EList<DefaultValueCS> getDefaultValue();

	/**
	 * Returns the value of the '<em><b>Implemented By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implemented By</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implemented By</em>' containment reference.
	 * @see #setImplementedBy(OperationCallExpCS)
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.QVTrCSTPackage#getDomainCS_ImplementedBy()
	 * @model containment="true"
	 * @generated
	 */
	OperationCallExpCS getImplementedBy();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.DomainCS#getImplementedBy <em>Implemented By</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implemented By</em>' containment reference.
	 * @see #getImplementedBy()
	 * @generated
	 */
	void setImplementedBy(OperationCallExpCS value);

} // DomainCS
