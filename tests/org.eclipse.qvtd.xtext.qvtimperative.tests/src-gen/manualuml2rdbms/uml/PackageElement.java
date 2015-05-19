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
package manualuml2rdbms.uml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Package Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link manualuml2rdbms.uml.PackageElement#getNamespace <em>Namespace</em>}</li>
 * </ul>
 *
 * @see manualuml2rdbms.uml.UMLPackage#getPackageElement()
 * @model abstract="true"
 * @generated
 */
public interface PackageElement extends UMLModelElement {
	/**
	 * Returns the value of the '<em><b>Namespace</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link manualuml2rdbms.uml.Package#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Namespace</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Namespace</em>' container reference.
	 * @see #setNamespace(manualuml2rdbms.uml.Package)
	 * @see manualuml2rdbms.uml.UMLPackage#getPackageElement_Namespace()
	 * @see manualuml2rdbms.uml.Package#getElements
	 * @model opposite="elements" transient="false"
	 * @generated
	 */
	manualuml2rdbms.uml.Package getNamespace();

	/**
	 * Sets the value of the '{@link manualuml2rdbms.uml.PackageElement#getNamespace <em>Namespace</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Namespace</em>' container reference.
	 * @see #getNamespace()
	 * @generated
	 */
	void setNamespace(manualuml2rdbms.uml.Package value);

} // PackageElement
