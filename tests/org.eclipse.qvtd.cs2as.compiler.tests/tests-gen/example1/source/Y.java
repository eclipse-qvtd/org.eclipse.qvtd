/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/**
 */
package example1.source;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Y</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link example1.source.Y#getOwnsZ <em>Owns Z</em>}</li>
 *   <li>{@link example1.source.Y#getName <em>Name</em>}</li>
 *   <li>{@link example1.source.Y#getToX <em>To X</em>}</li>
 * </ul>
 *
 * @see example1.source.SourcePackage#getY()
 * @model abstract="true"
 * @generated
 */
public interface Y extends SElement {
	/**
	 * Returns the value of the '<em><b>Owns Z</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link example1.source.Z#getToY <em>To Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owns Z</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owns Z</em>' containment reference.
	 * @see #setOwnsZ(Z)
	 * @see example1.source.SourcePackage#getY_OwnsZ()
	 * @see example1.source.Z#getToY
	 * @model opposite="toY" containment="true"
	 * @generated
	 */
	Z getOwnsZ();

	/**
	 * Sets the value of the '{@link example1.source.Y#getOwnsZ <em>Owns Z</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owns Z</em>' containment reference.
	 * @see #getOwnsZ()
	 * @generated
	 */
	void setOwnsZ(Z value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see example1.source.SourcePackage#getY_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link example1.source.Y#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>To X</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link example1.source.X#getOwnsY <em>Owns Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To X</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To X</em>' container reference.
	 * @see #setToX(X)
	 * @see example1.source.SourcePackage#getY_ToX()
	 * @see example1.source.X#getOwnsY
	 * @model opposite="ownsY" transient="false"
	 * @generated
	 */
	X getToX();

	/**
	 * Sets the value of the '{@link example1.source.Y#getToX <em>To X</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To X</em>' container reference.
	 * @see #getToX()
	 * @generated
	 */
	void setToX(X value);

} // Y
