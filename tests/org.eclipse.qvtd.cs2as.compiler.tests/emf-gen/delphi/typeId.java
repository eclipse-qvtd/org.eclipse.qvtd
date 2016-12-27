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
 * A representation of the model object '<em><b>type Id</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link delphi.typeId#getUnitId <em>Unit Id</em>}</li>
 *   <li>{@link delphi.typeId#getId <em>Id</em>}</li>
 * </ul>
 *
 * @see delphi.DelphiPackage#gettypeId()
 * @model
 * @generated
 */
public interface typeId extends type, pointerType {
	/**
	 * Returns the value of the '<em><b>Unit Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Id</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Id</em>' containment reference.
	 * @see #setUnitId(unitId)
	 * @see delphi.DelphiPackage#gettypeId_UnitId()
	 * @model containment="true"
	 * @generated
	 */
	unitId getUnitId();

	/**
	 * Sets the value of the '{@link delphi.typeId#getUnitId <em>Unit Id</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Id</em>' containment reference.
	 * @see #getUnitId()
	 * @generated
	 */
	void setUnitId(unitId value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' containment reference.
	 * @see #setId(qualId)
	 * @see delphi.DelphiPackage#gettypeId_Id()
	 * @model containment="true"
	 * @generated
	 */
	qualId getId();

	/**
	 * Sets the value of the '{@link delphi.typeId#getId <em>Id</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' containment reference.
	 * @see #getId()
	 * @generated
	 */
	void setId(qualId value);

} // typeId
