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
 * A representation of the model object '<em><b>Rel Invocation Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.umlx.RelInvocationNode#isIsThen <em>Is Then</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.RelInvocationNode#getReferredRelDiagram <em>Referred Rel Diagram</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.umlx.UMLXPackage#getRelInvocationNode()
 * @generated
 */
public interface RelInvocationNode extends RelNode {
	/**
	 * Returns the value of the '<em><b>Is Then</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Then</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Then</em>' attribute.
	 * @see #setIsThen(boolean)
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getRelInvocationNode_IsThen()
	 * @generated
	 */
	boolean isIsThen();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.umlx.RelInvocationNode#isIsThen <em>Is Then</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Then</em>' attribute.
	 * @see #isIsThen()
	 * @generated
	 */
	void setIsThen(boolean value);

	/**
	 * Returns the value of the '<em><b>Referred Rel Diagram</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Rel Diagram</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Rel Diagram</em>' reference.
	 * @see #setReferredRelDiagram(RelDiagram)
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getRelInvocationNode_ReferredRelDiagram()
	 * @generated
	 */
	RelDiagram getReferredRelDiagram();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.umlx.RelInvocationNode#getReferredRelDiagram <em>Referred Rel Diagram</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Rel Diagram</em>' reference.
	 * @see #getReferredRelDiagram()
	 * @generated
	 */
	void setReferredRelDiagram(RelDiagram value);

} // RelInvocationNode
