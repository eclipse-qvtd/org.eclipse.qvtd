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
 * A representation of the model object '<em><b>requires Clause</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link delphi.requiresClause#getIdList <em>Id List</em>}</li>
 * </ul>
 *
 * @see delphi.DelphiPackage#getrequiresClause()
 * @model
 * @generated
 */
public interface requiresClause extends CSTrace {
	/**
	 * Returns the value of the '<em><b>Id List</b></em>' containment reference list.
	 * The list contents are of type {@link delphi.identList}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id List</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id List</em>' containment reference list.
	 * @see delphi.DelphiPackage#getrequiresClause_IdList()
	 * @model containment="true"
	 * @generated
	 */
	EList<identList> getIdList();

} // requiresClause
