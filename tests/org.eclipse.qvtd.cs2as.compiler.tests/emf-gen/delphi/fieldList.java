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
 * A representation of the model object '<em><b>field List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link delphi.fieldList#getField <em>Field</em>}</li>
 *   <li>{@link delphi.fieldList#getVariantSect <em>Variant Sect</em>}</li>
 * </ul>
 *
 * @see delphi.DelphiPackage#getfieldList()
 * @model
 * @generated
 */
public interface fieldList extends CSTrace {
	/**
	 * Returns the value of the '<em><b>Field</b></em>' containment reference list.
	 * The list contents are of type {@link delphi.fieldDecl}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Field</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Field</em>' containment reference list.
	 * @see delphi.DelphiPackage#getfieldList_Field()
	 * @model containment="true"
	 * @generated
	 */
	EList<fieldDecl> getField();

	/**
	 * Returns the value of the '<em><b>Variant Sect</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variant Sect</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variant Sect</em>' containment reference.
	 * @see #setVariantSect(variantSection)
	 * @see delphi.DelphiPackage#getfieldList_VariantSect()
	 * @model containment="true"
	 * @generated
	 */
	variantSection getVariantSect();

	/**
	 * Sets the value of the '{@link delphi.fieldList#getVariantSect <em>Variant Sect</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variant Sect</em>' containment reference.
	 * @see #getVariantSect()
	 * @generated
	 */
	void setVariantSect(variantSection value);

} // fieldList
