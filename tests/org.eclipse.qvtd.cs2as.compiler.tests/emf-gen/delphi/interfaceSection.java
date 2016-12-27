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
 * A representation of the model object '<em><b>interface Section</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link delphi.interfaceSection#getUses <em>Uses</em>}</li>
 *   <li>{@link delphi.interfaceSection#getInterfaceDecl <em>Interface Decl</em>}</li>
 * </ul>
 *
 * @see delphi.DelphiPackage#getinterfaceSection()
 * @model
 * @generated
 */
public interface interfaceSection extends CSTrace {
	/**
	 * Returns the value of the '<em><b>Uses</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uses</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uses</em>' containment reference.
	 * @see #setUses(usesClause)
	 * @see delphi.DelphiPackage#getinterfaceSection_Uses()
	 * @model containment="true"
	 * @generated
	 */
	usesClause getUses();

	/**
	 * Sets the value of the '{@link delphi.interfaceSection#getUses <em>Uses</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uses</em>' containment reference.
	 * @see #getUses()
	 * @generated
	 */
	void setUses(usesClause value);

	/**
	 * Returns the value of the '<em><b>Interface Decl</b></em>' containment reference list.
	 * The list contents are of type {@link delphi.interfaceDecl}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interface Decl</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interface Decl</em>' containment reference list.
	 * @see delphi.DelphiPackage#getinterfaceSection_InterfaceDecl()
	 * @model containment="true"
	 * @generated
	 */
	EList<interfaceDecl> getInterfaceDecl();

} // interfaceSection
