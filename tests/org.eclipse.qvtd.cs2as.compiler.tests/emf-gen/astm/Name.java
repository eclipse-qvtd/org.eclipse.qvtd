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
package astm;

import java.lang.String;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Name</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link astm.Name#getNameString <em>Name String</em>}</li>
 * </ul>
 *
 * @see astm.AstmPackage#getName_()
 * @model
 * @generated
 */
public interface Name extends OtherSyntaxObject {
	/**
	 * Returns the value of the '<em><b>Name String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name String</em>' attribute.
	 * @see #setNameString(String)
	 * @see astm.AstmPackage#getName_NameString()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://cs2as/tests/delphi/AS/1.0!Name!nameString'"
	 * @generated
	 */
	String getNameString();

	/**
	 * Sets the value of the '{@link astm.Name#getNameString <em>Name String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name String</em>' attribute.
	 * @see #getNameString()
	 * @generated
	 */
	void setNameString(String value);

} // Name
