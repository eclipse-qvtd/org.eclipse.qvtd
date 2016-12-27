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
 * A representation of the model object '<em><b>designator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link delphi.designator#getSubpart <em>Subpart</em>}</li>
 *   <li>{@link delphi.designator#getDesignator <em>Designator</em>}</li>
 * </ul>
 *
 * @see delphi.DelphiPackage#getdesignator()
 * @model
 * @generated
 */
public interface designator extends CSTrace {
	/**
	 * Returns the value of the '<em><b>Subpart</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subpart</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subpart</em>' containment reference.
	 * @see #setSubpart(designatorSubPart)
	 * @see delphi.DelphiPackage#getdesignator_Subpart()
	 * @model containment="true"
	 * @generated
	 */
	designatorSubPart getSubpart();

	/**
	 * Sets the value of the '{@link delphi.designator#getSubpart <em>Subpart</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Subpart</em>' containment reference.
	 * @see #getSubpart()
	 * @generated
	 */
	void setSubpart(designatorSubPart value);

	/**
	 * Returns the value of the '<em><b>Designator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Designator</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Designator</em>' containment reference.
	 * @see #setDesignator(designator)
	 * @see delphi.DelphiPackage#getdesignator_Designator()
	 * @model containment="true"
	 * @generated
	 */
	designator getDesignator();

	/**
	 * Sets the value of the '{@link delphi.designator#getDesignator <em>Designator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Designator</em>' containment reference.
	 * @see #getDesignator()
	 * @generated
	 */
	void setDesignator(designator value);

} // designator
