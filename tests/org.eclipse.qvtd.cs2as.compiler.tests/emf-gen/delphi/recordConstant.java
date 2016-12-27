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
 * A representation of the model object '<em><b>record Constant</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link delphi.recordConstant#getRecordField <em>Record Field</em>}</li>
 * </ul>
 *
 * @see delphi.DelphiPackage#getrecordConstant()
 * @model
 * @generated
 */
public interface recordConstant extends CSTrace {
	/**
	 * Returns the value of the '<em><b>Record Field</b></em>' containment reference list.
	 * The list contents are of type {@link delphi.recordFieldConstant}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Record Field</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Record Field</em>' containment reference list.
	 * @see delphi.DelphiPackage#getrecordConstant_RecordField()
	 * @model containment="true"
	 * @generated
	 */
	EList<recordFieldConstant> getRecordField();

} // recordConstant
