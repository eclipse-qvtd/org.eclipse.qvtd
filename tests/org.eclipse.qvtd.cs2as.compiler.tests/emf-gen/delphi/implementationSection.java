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
 * A representation of the model object '<em><b>implementation Section</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link delphi.implementationSection#getUses <em>Uses</em>}</li>
 *   <li>{@link delphi.implementationSection#getDeclSect <em>Decl Sect</em>}</li>
 *   <li>{@link delphi.implementationSection#getExports <em>Exports</em>}</li>
 * </ul>
 *
 * @see delphi.DelphiPackage#getimplementationSection()
 * @model
 * @generated
 */
public interface implementationSection extends CSTrace {
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
	 * @see delphi.DelphiPackage#getimplementationSection_Uses()
	 * @model containment="true"
	 * @generated
	 */
	usesClause getUses();

	/**
	 * Sets the value of the '{@link delphi.implementationSection#getUses <em>Uses</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uses</em>' containment reference.
	 * @see #getUses()
	 * @generated
	 */
	void setUses(usesClause value);

	/**
	 * Returns the value of the '<em><b>Decl Sect</b></em>' containment reference list.
	 * The list contents are of type {@link delphi.declSection}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Decl Sect</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Decl Sect</em>' containment reference list.
	 * @see delphi.DelphiPackage#getimplementationSection_DeclSect()
	 * @model containment="true"
	 * @generated
	 */
	EList<declSection> getDeclSect();

	/**
	 * Returns the value of the '<em><b>Exports</b></em>' containment reference list.
	 * The list contents are of type {@link delphi.exportsStmt}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exports</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exports</em>' containment reference list.
	 * @see delphi.DelphiPackage#getimplementationSection_Exports()
	 * @model containment="true"
	 * @generated
	 */
	EList<exportsStmt> getExports();

} // implementationSection
