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
 * $Id: Transformation.java,v 1.3 2008/12/31 17:42:29 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTBase;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transformation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTBase.Transformation#getOwnedTag <em>Owned Tag</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTBase.Transformation#getModelParameter <em>Model Parameter</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTBase.Transformation#getRule <em>Rule</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTBase.Transformation#getExtends <em>Extends</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.ecore.QVTBase.QVTBasePackage#getTransformation()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='WellFormedNsURI\r\nWellFormedNsPrefix\r\nUniqueNsURIs\r\nExtendsIsAcyclic\r\nModelParameterNamesAreCompatibleWithExtension\r\nEveryModelParameterUsedPackagesIsCompatibleWithExtension\r\nModelParameterNamesAreUnique\r\nRuleNamesAreUnique\r\nSynthesizedTypesAreOwned\r\n'"
 * @generated
 */
public interface Transformation extends EClass, EPackage {
	/**
	 * Returns the value of the '<em><b>Owned Tag</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EAnnotation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Tag</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Tag</em>' containment reference list.
	 * @see org.eclipse.qvt.declarative.ecore.QVTBase.QVTBasePackage#getTransformation_OwnedTag()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<EAnnotation> getOwnedTag();

	/**
	 * Returns the value of the '<em><b>Model Parameter</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvt.declarative.ecore.QVTBase.TypedModel}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvt.declarative.ecore.QVTBase.TypedModel#getTransformation <em>Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Parameter</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Parameter</em>' containment reference list.
	 * @see org.eclipse.qvt.declarative.ecore.QVTBase.QVTBasePackage#getTransformation_ModelParameter()
	 * @see org.eclipse.qvt.declarative.ecore.QVTBase.TypedModel#getTransformation
	 * @model opposite="transformation" containment="true"
	 * @generated
	 */
	EList<TypedModel> getModelParameter();

	/**
	 * Returns the value of the '<em><b>Rule</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvt.declarative.ecore.QVTBase.Rule}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvt.declarative.ecore.QVTBase.Rule#getTransformation <em>Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rule</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rule</em>' containment reference list.
	 * @see org.eclipse.qvt.declarative.ecore.QVTBase.QVTBasePackage#getTransformation_Rule()
	 * @see org.eclipse.qvt.declarative.ecore.QVTBase.Rule#getTransformation
	 * @model opposite="transformation" containment="true" ordered="false"
	 * @generated
	 */
	EList<Rule> getRule();

	/**
	 * Returns the value of the '<em><b>Extends</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extends</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extends</em>' reference.
	 * @see #setExtends(Transformation)
	 * @see org.eclipse.qvt.declarative.ecore.QVTBase.QVTBasePackage#getTransformation_Extends()
	 * @model annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='extendedBy'"
	 * @generated
	 */
	Transformation getExtends();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.ecore.QVTBase.Transformation#getExtends <em>Extends</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extends</em>' reference.
	 * @see #getExtends()
	 * @generated
	 */
	void setExtends(Transformation value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" nameRequired="true"
	 * @generated
	 */
	Function getFunction(String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" nameRequired="true"
	 * @generated
	 */
	TypedModel getModelParameter(String name);

} // Transformation
