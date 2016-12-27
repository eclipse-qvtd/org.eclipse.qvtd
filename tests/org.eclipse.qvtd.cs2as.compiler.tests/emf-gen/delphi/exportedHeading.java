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
 * A representation of the model object '<em><b>exported Heading</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link delphi.exportedHeading#getPHeading <em>PHeading</em>}</li>
 *   <li>{@link delphi.exportedHeading#getDirective <em>Directive</em>}</li>
 *   <li>{@link delphi.exportedHeading#getFHeading <em>FHeading</em>}</li>
 * </ul>
 *
 * @see delphi.DelphiPackage#getexportedHeading()
 * @model
 * @generated
 */
public interface exportedHeading extends interfaceDecl {
	/**
	 * Returns the value of the '<em><b>PHeading</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>PHeading</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>PHeading</em>' containment reference.
	 * @see #setPHeading(procedureHeading)
	 * @see delphi.DelphiPackage#getexportedHeading_PHeading()
	 * @model containment="true"
	 * @generated
	 */
	procedureHeading getPHeading();

	/**
	 * Sets the value of the '{@link delphi.exportedHeading#getPHeading <em>PHeading</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>PHeading</em>' containment reference.
	 * @see #getPHeading()
	 * @generated
	 */
	void setPHeading(procedureHeading value);

	/**
	 * Returns the value of the '<em><b>Directive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Directive</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Directive</em>' containment reference.
	 * @see #setDirective(directive)
	 * @see delphi.DelphiPackage#getexportedHeading_Directive()
	 * @model containment="true"
	 * @generated
	 */
	directive getDirective();

	/**
	 * Sets the value of the '{@link delphi.exportedHeading#getDirective <em>Directive</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Directive</em>' containment reference.
	 * @see #getDirective()
	 * @generated
	 */
	void setDirective(directive value);

	/**
	 * Returns the value of the '<em><b>FHeading</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>FHeading</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>FHeading</em>' containment reference.
	 * @see #setFHeading(functionHeading)
	 * @see delphi.DelphiPackage#getexportedHeading_FHeading()
	 * @model containment="true"
	 * @generated
	 */
	functionHeading getFHeading();

	/**
	 * Sets the value of the '{@link delphi.exportedHeading#getFHeading <em>FHeading</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>FHeading</em>' containment reference.
	 * @see #getFHeading()
	 * @generated
	 */
	void setFHeading(functionHeading value);

} // exportedHeading
