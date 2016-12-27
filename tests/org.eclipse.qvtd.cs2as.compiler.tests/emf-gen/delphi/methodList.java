/**
 * Copyright (c)  2016 Willink Transformations, Univesity of York and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *      Adolfo Sanchez-Barbudo Herrera - initial API and implementation
 */
package delphi;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>method List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link delphi.methodList#getHeading <em>Heading</em>}</li>
 *   <li>{@link delphi.methodList#getDirective <em>Directive</em>}</li>
 * </ul>
 *
 * @see delphi.DelphiPackage#getmethodList()
 * @model
 * @generated
 */
public interface methodList extends CSTrace {
	/**
	 * Returns the value of the '<em><b>Heading</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Heading</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Heading</em>' containment reference.
	 * @see #setHeading(methodHeading)
	 * @see delphi.DelphiPackage#getmethodList_Heading()
	 * @model containment="true"
	 * @generated
	 */
	methodHeading getHeading();

	/**
	 * Sets the value of the '{@link delphi.methodList#getHeading <em>Heading</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Heading</em>' containment reference.
	 * @see #getHeading()
	 * @generated
	 */
	void setHeading(methodHeading value);

	/**
	 * Returns the value of the '<em><b>Directive</b></em>' containment reference list.
	 * The list contents are of type {@link delphi.directive}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Directive</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Directive</em>' containment reference list.
	 * @see delphi.DelphiPackage#getmethodList_Directive()
	 * @model containment="true"
	 * @generated
	 */
	EList<directive> getDirective();

} // methodList
