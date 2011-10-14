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
 * $Id: Transformation.java,v 1.2 2008/12/12 15:28:09 ewillink Exp $
 */
package org.eclipse.qvt.declarative.emof.QVTBase;

import org.eclipse.emf.common.util.EList;

import org.eclipse.qvt.declarative.emof.EMOF.Tag;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transformation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.emof.QVTBase.Transformation#getExtends <em>Extends</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.emof.QVTBase.Transformation#getModelParameter <em>Model Parameter</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.emof.QVTBase.Transformation#getOwnedTag <em>Owned Tag</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.emof.QVTBase.Transformation#getRule <em>Rule</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.emof.QVTBase.QVTBasePackage#getTransformation()
 * @model
 * @generated
 */
public interface Transformation extends org.eclipse.qvt.declarative.emof.EMOF.Class, org.eclipse.qvt.declarative.emof.EMOF.Package {
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
	 * @see org.eclipse.qvt.declarative.emof.QVTBase.QVTBasePackage#getTransformation_Extends()
	 * @model annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='extendedBy'"
	 * @generated
	 */
	Transformation getExtends();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.emof.QVTBase.Transformation#getExtends <em>Extends</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extends</em>' reference.
	 * @see #getExtends()
	 * @generated
	 */
	void setExtends(Transformation value);

	/**
	 * Returns the value of the '<em><b>Model Parameter</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvt.declarative.emof.QVTBase.TypedModel}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvt.declarative.emof.QVTBase.TypedModel#getTransformation <em>Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Parameter</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Parameter</em>' containment reference list.
	 * @see org.eclipse.qvt.declarative.emof.QVTBase.QVTBasePackage#getTransformation_ModelParameter()
	 * @see org.eclipse.qvt.declarative.emof.QVTBase.TypedModel#getTransformation
	 * @model opposite="transformation" containment="true"
	 * @generated
	 */
	EList<TypedModel> getModelParameter();

	/**
	 * Returns the value of the '<em><b>Owned Tag</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvt.declarative.emof.EMOF.Tag}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Tag</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Tag</em>' containment reference list.
	 * @see org.eclipse.qvt.declarative.emof.QVTBase.QVTBasePackage#getTransformation_OwnedTag()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Tag> getOwnedTag();

	/**
	 * Returns the value of the '<em><b>Rule</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvt.declarative.emof.QVTBase.Rule}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvt.declarative.emof.QVTBase.Rule#getTransformation <em>Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rule</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rule</em>' containment reference list.
	 * @see org.eclipse.qvt.declarative.emof.QVTBase.QVTBasePackage#getTransformation_Rule()
	 * @see org.eclipse.qvt.declarative.emof.QVTBase.Rule#getTransformation
	 * @model opposite="transformation" containment="true" ordered="false"
	 * @generated
	 */
	EList<Rule> getRule();

} // Transformation
