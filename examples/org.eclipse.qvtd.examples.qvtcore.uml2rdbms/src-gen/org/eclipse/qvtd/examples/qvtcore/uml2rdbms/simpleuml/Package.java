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
package org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Package</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Package#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.SimpleumlPackage#getPackage()
 * @model
 * @generated
 */
public interface Package extends UMLModelElement {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.PackageElement}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.PackageElement#getNamespace <em>Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.SimpleumlPackage#getPackage_Elements()
	 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.PackageElement#getNamespace
	 * @model opposite="namespace" containment="true"
	 * @generated
	 */
	EList<PackageElement> getElements();

} // Package
