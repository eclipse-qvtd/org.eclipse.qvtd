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
 * A representation of the model object '<em><b>class Method List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link delphi.classMethodList#getMetod <em>Metod</em>}</li>
 * </ul>
 *
 * @see delphi.DelphiPackage#getclassMethodList()
 * @model
 * @generated
 */
public interface classMethodList extends CSTrace {
	/**
	 * Returns the value of the '<em><b>Metod</b></em>' containment reference list.
	 * The list contents are of type {@link delphi.classMethod}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metod</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metod</em>' containment reference list.
	 * @see delphi.DelphiPackage#getclassMethodList_Metod()
	 * @model containment="true"
	 * @generated
	 */
	EList<classMethod> getMetod();

} // classMethodList
