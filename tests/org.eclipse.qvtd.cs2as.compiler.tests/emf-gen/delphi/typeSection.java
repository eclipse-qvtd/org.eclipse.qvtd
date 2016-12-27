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
 * A representation of the model object '<em><b>type Section</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link delphi.typeSection#getTypeDecl <em>Type Decl</em>}</li>
 * </ul>
 *
 * @see delphi.DelphiPackage#gettypeSection()
 * @model
 * @generated
 */
public interface typeSection extends interfaceDecl, declSection {
	/**
	 * Returns the value of the '<em><b>Type Decl</b></em>' containment reference list.
	 * The list contents are of type {@link delphi.typeDecl}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Decl</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Decl</em>' containment reference list.
	 * @see delphi.DelphiPackage#gettypeSection_TypeDecl()
	 * @model containment="true"
	 * @generated
	 */
	EList<typeDecl> getTypeDecl();

} // typeSection
