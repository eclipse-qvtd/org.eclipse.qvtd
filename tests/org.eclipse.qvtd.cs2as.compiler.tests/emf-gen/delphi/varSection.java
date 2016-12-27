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
 * A representation of the model object '<em><b>var Section</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link delphi.varSection#getVarDecls <em>Var Decls</em>}</li>
 * </ul>
 *
 * @see delphi.DelphiPackage#getvarSection()
 * @model
 * @generated
 */
public interface varSection extends interfaceDecl, declSection {
	/**
	 * Returns the value of the '<em><b>Var Decls</b></em>' containment reference list.
	 * The list contents are of type {@link delphi.varDecl}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Var Decls</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Var Decls</em>' containment reference list.
	 * @see delphi.DelphiPackage#getvarSection_VarDecls()
	 * @model containment="true"
	 * @generated
	 */
	EList<varDecl> getVarDecls();

} // varSection
