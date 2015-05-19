/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/**
 */
package simpleuml2rdbms.uml;

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
 *   <li>{@link simpleuml2rdbms.uml.Classifier#getTypeOpposite <em>Type Opposite</em>}</li>
 * </ul>
 *
 * @see simpleuml2rdbms.uml.UMLPackage#getClassifier()
 * @model abstract="true"
 * @generated
 */
public interface Classifier extends PackageElement {
	/**
	 * Returns the value of the '<em><b>Type Opposite</b></em>' reference list.
	 * The list contents are of type {@link simpleuml2rdbms.uml.Attribute}.
	 * It is bidirectional and its opposite is '{@link simpleuml2rdbms.uml.Attribute#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Opposite</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Opposite</em>' reference list.
	 * @see simpleuml2rdbms.uml.UMLPackage#getClassifier_TypeOpposite()
	 * @see simpleuml2rdbms.uml.Attribute#getType
	 * @model opposite="type"
	 * @generated
	 */
	EList<Attribute> getTypeOpposite();

} // Classifier
