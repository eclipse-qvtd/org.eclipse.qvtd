/**
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Classifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.Classifier#getTypeOpposite <em>Type Opposite</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.SimpleumlPackage#getClassifier()
 * @model abstract="true"
 * @generated
 */
public interface Classifier extends PackageElement {
	/**
	 * Returns the value of the '<em><b>Type Opposite</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.Attribute}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.Attribute#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Opposite</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Opposite</em>' reference list.
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.SimpleumlPackage#getClassifier_TypeOpposite()
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.Attribute#getType
	 * @model opposite="type"
	 * @generated
	 */
	EList<Attribute> getTypeOpposite();

} // Classifier
