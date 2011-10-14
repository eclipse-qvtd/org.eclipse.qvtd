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
 * $Id: TypedModel.java,v 1.1 2008/07/23 09:57:28 qglineur Exp $
 */
package org.eclipse.qvt.declarative.emof.QVTBase;

import org.eclipse.emf.common.util.EList;

import org.eclipse.qvt.declarative.emof.EMOF.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Typed Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.emof.QVTBase.TypedModel#getDependsOn <em>Depends On</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.emof.QVTBase.TypedModel#getTransformation <em>Transformation</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.emof.QVTBase.TypedModel#getUsedPackage <em>Used Package</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.emof.QVTBase.QVTBasePackage#getTypedModel()
 * @model
 * @generated
 */
public interface TypedModel extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Depends On</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvt.declarative.emof.QVTBase.TypedModel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Depends On</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Depends On</em>' reference list.
	 * @see org.eclipse.qvt.declarative.emof.QVTBase.QVTBasePackage#getTypedModel_DependsOn()
	 * @model ordered="false"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='dependent'"
	 * @generated
	 */
	EList<TypedModel> getDependsOn();

	/**
	 * Returns the value of the '<em><b>Transformation</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvt.declarative.emof.QVTBase.Transformation#getModelParameter <em>Model Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transformation</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transformation</em>' container reference.
	 * @see #setTransformation(Transformation)
	 * @see org.eclipse.qvt.declarative.emof.QVTBase.QVTBasePackage#getTypedModel_Transformation()
	 * @see org.eclipse.qvt.declarative.emof.QVTBase.Transformation#getModelParameter
	 * @model opposite="modelParameter" required="true"
	 * @generated
	 */
	Transformation getTransformation();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.emof.QVTBase.TypedModel#getTransformation <em>Transformation</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transformation</em>' container reference.
	 * @see #getTransformation()
	 * @generated
	 */
	void setTransformation(Transformation value);

	/**
	 * Returns the value of the '<em><b>Used Package</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvt.declarative.emof.EMOF.Package}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Used Package</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Used Package</em>' reference list.
	 * @see org.eclipse.qvt.declarative.emof.QVTBase.QVTBasePackage#getTypedModel_UsedPackage()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<org.eclipse.qvt.declarative.emof.EMOF.Package> getUsedPackage();

} // TypedModel
