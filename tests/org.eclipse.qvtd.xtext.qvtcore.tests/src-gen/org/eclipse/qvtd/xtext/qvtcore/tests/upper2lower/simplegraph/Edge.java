/**
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Edge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph.Edge#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph.Edge#getSource <em>Source</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph.SimplegraphPackage#getEdge()
 * @model
 * @generated
 */
public interface Edge extends Element {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph.Node#getIncoming <em>Incoming</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Node)
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph.SimplegraphPackage#getEdge_Target()
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph.Node#getIncoming
	 * @model opposite="incoming"
	 * @generated
	 */
	Node getTarget();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph.Edge#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Node value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph.Node#getOutgoing <em>Outgoing</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Node)
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph.SimplegraphPackage#getEdge_Source()
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph.Node#getOutgoing
	 * @model opposite="outgoing"
	 * @generated
	 */
	Node getSource();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph.Edge#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Node value);

} // Edge
