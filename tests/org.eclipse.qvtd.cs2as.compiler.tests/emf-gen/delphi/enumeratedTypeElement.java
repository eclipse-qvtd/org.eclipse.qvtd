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
 * A representation of the model object '<em><b>enumerated Type Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link delphi.enumeratedTypeElement#getId <em>Id</em>}</li>
 *   <li>{@link delphi.enumeratedTypeElement#getLiteralExp <em>Literal Exp</em>}</li>
 * </ul>
 *
 * @see delphi.DelphiPackage#getenumeratedTypeElement()
 * @model
 * @generated
 */
public interface enumeratedTypeElement extends CSTrace {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' containment reference.
	 * @see #setId(ident)
	 * @see delphi.DelphiPackage#getenumeratedTypeElement_Id()
	 * @model containment="true"
	 * @generated
	 */
	ident getId();

	/**
	 * Sets the value of the '{@link delphi.enumeratedTypeElement#getId <em>Id</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' containment reference.
	 * @see #getId()
	 * @generated
	 */
	void setId(ident value);

	/**
	 * Returns the value of the '<em><b>Literal Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Literal Exp</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Literal Exp</em>' containment reference.
	 * @see #setLiteralExp(constExpr)
	 * @see delphi.DelphiPackage#getenumeratedTypeElement_LiteralExp()
	 * @model containment="true"
	 * @generated
	 */
	constExpr getLiteralExp();

	/**
	 * Sets the value of the '{@link delphi.enumeratedTypeElement#getLiteralExp <em>Literal Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Literal Exp</em>' containment reference.
	 * @see #getLiteralExp()
	 * @generated
	 */
	void setLiteralExp(constExpr value);

} // enumeratedTypeElement
