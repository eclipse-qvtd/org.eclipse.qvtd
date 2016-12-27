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
 * A representation of the model object '<em><b>variant Section</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link delphi.variantSection#getId <em>Id</em>}</li>
 *   <li>{@link delphi.variantSection#getTypeRef <em>Type Ref</em>}</li>
 *   <li>{@link delphi.variantSection#getRecVariants <em>Rec Variants</em>}</li>
 * </ul>
 *
 * @see delphi.DelphiPackage#getvariantSection()
 * @model
 * @generated
 */
public interface variantSection extends CSTrace {
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
	 * @see delphi.DelphiPackage#getvariantSection_Id()
	 * @model containment="true"
	 * @generated
	 */
	ident getId();

	/**
	 * Sets the value of the '{@link delphi.variantSection#getId <em>Id</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' containment reference.
	 * @see #getId()
	 * @generated
	 */
	void setId(ident value);

	/**
	 * Returns the value of the '<em><b>Type Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Ref</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Ref</em>' containment reference.
	 * @see #setTypeRef(typeId)
	 * @see delphi.DelphiPackage#getvariantSection_TypeRef()
	 * @model containment="true"
	 * @generated
	 */
	typeId getTypeRef();

	/**
	 * Sets the value of the '{@link delphi.variantSection#getTypeRef <em>Type Ref</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Ref</em>' containment reference.
	 * @see #getTypeRef()
	 * @generated
	 */
	void setTypeRef(typeId value);

	/**
	 * Returns the value of the '<em><b>Rec Variants</b></em>' containment reference list.
	 * The list contents are of type {@link delphi.recVariant}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rec Variants</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rec Variants</em>' containment reference list.
	 * @see delphi.DelphiPackage#getvariantSection_RecVariants()
	 * @model containment="true"
	 * @generated
	 */
	EList<recVariant> getRecVariants();

} // variantSection
