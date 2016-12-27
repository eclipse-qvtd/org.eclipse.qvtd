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
 * A representation of the model object '<em><b>library</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link delphi.library#getPBlock <em>PBlock</em>}</li>
 * </ul>
 *
 * @see delphi.DelphiPackage#getlibrary()
 * @model
 * @generated
 */
public interface library extends file {
	/**
	 * Returns the value of the '<em><b>PBlock</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>PBlock</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>PBlock</em>' containment reference.
	 * @see #setPBlock(programBlock)
	 * @see delphi.DelphiPackage#getlibrary_PBlock()
	 * @model containment="true"
	 * @generated
	 */
	programBlock getPBlock();

	/**
	 * Sets the value of the '{@link delphi.library#getPBlock <em>PBlock</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>PBlock</em>' containment reference.
	 * @see #getPBlock()
	 * @generated
	 */
	void setPBlock(programBlock value);

} // library
