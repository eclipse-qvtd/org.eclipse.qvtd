/**
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.umlx;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rel Diagram</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.umlx.RelDiagram#isIsTop <em>Is Top</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.umlx.UMLXPackage#getRelDiagram()
 * @generated
 */
public interface RelDiagram extends UMLXDiagram {

	/**
	 * Returns the value of the '<em><b>Is Top</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Top</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Top</em>' attribute.
	 * @see #setIsTop(boolean)
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getRelDiagram_IsTop()
	 * @generated
	 */
	boolean isIsTop();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.umlx.RelDiagram#isIsTop <em>Is Top</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Top</em>' attribute.
	 * @see #isIsTop()
	 * @generated
	 */
	void setIsTop(boolean value);
} // RelDiagram
