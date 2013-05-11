/**
 * <copyright>
 * 
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.qvtd.codegen.qvticgmodel;

import org.eclipse.emf.ecore.EClassifier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CG Ecore Realized Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.CGEcoreRealizedVariable#getEClassifier <em>EClassifier</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGEcoreRealizedVariable()
 * @model
 * @generated
 */
public interface CGEcoreRealizedVariable extends CGRealizedVariable {
	/**
	 * Returns the value of the '<em><b>EClassifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EClassifier</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EClassifier</em>' reference.
	 * @see #setEClassifier(EClassifier)
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGEcoreRealizedVariable_EClassifier()
	 * @model resolveProxies="false" required="true"
	 * @generated
	 */
	EClassifier getEClassifier();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGEcoreRealizedVariable#getEClassifier <em>EClassifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EClassifier</em>' reference.
	 * @see #getEClassifier()
	 * @generated
	 */
	void setEClassifier(EClassifier value);

} // CGEcoreRealizedVariable
