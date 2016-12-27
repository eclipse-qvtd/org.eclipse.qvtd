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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>interface Heritage</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link delphi.interfaceHeritage#getIdList <em>Id List</em>}</li>
 * </ul>
 *
 * @see delphi.DelphiPackage#getinterfaceHeritage()
 * @model
 * @generated
 */
public interface interfaceHeritage extends CSTrace {
	/**
	 * Returns the value of the '<em><b>Id List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id List</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id List</em>' containment reference.
	 * @see #setIdList(identList)
	 * @see delphi.DelphiPackage#getinterfaceHeritage_IdList()
	 * @model containment="true"
	 * @generated
	 */
	identList getIdList();

	/**
	 * Sets the value of the '{@link delphi.interfaceHeritage#getIdList <em>Id List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id List</em>' containment reference.
	 * @see #getIdList()
	 * @generated
	 */
	void setIdList(identList value);

} // interfaceHeritage
