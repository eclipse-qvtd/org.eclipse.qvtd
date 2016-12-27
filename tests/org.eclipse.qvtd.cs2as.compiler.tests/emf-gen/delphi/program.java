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
 * A representation of the model object '<em><b>program</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link delphi.program#getParamsList <em>Params List</em>}</li>
 *   <li>{@link delphi.program#getBlock <em>Block</em>}</li>
 * </ul>
 *
 * @see delphi.DelphiPackage#getprogram()
 * @model
 * @generated
 */
public interface program extends file {
	/**
	 * Returns the value of the '<em><b>Params List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Params List</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Params List</em>' containment reference.
	 * @see #setParamsList(identList)
	 * @see delphi.DelphiPackage#getprogram_ParamsList()
	 * @model containment="true"
	 * @generated
	 */
	identList getParamsList();

	/**
	 * Sets the value of the '{@link delphi.program#getParamsList <em>Params List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Params List</em>' containment reference.
	 * @see #getParamsList()
	 * @generated
	 */
	void setParamsList(identList value);

	/**
	 * Returns the value of the '<em><b>Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Block</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Block</em>' containment reference.
	 * @see #setBlock(programBlock)
	 * @see delphi.DelphiPackage#getprogram_Block()
	 * @model containment="true"
	 * @generated
	 */
	programBlock getBlock();

	/**
	 * Sets the value of the '{@link delphi.program#getBlock <em>Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Block</em>' containment reference.
	 * @see #getBlock()
	 * @generated
	 */
	void setBlock(programBlock value);

} // program
