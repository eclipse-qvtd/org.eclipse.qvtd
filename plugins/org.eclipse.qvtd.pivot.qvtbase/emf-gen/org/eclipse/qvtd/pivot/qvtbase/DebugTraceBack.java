/**
 * <copyright>
 * 
 * Copyright (c) 2013, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.qvtd.pivot.qvtbase;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Element;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Debug Trace Back</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.DebugTraceBack#getOwningTransformation <em>Owning Transformation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.DebugTraceBack#getSources <em>Sources</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.DebugTraceBack#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage#getDebugTraceBack()
 * @model
 * @generated
 */
public interface DebugTraceBack extends Element {
	/**
	 * Returns the value of the '<em><b>Owning Transformation</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtbase.Transformation#getOwnedDebugTraceBacks <em>Owned Debug Trace Backs</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Transformation</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Transformation</em>' container reference.
	 * @see #setOwningTransformation(Transformation)
	 * @see org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage#getDebugTraceBack_OwningTransformation()
	 * @see org.eclipse.qvtd.pivot.qvtbase.Transformation#getOwnedDebugTraceBacks
	 * @model opposite="ownedDebugTraceBacks" required="true" transient="false"
	 * @generated
	 */
	Transformation getOwningTransformation();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtbase.DebugTraceBack#getOwningTransformation <em>Owning Transformation</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Transformation</em>' container reference.
	 * @see #getOwningTransformation()
	 * @generated
	 */
	void setOwningTransformation(Transformation value);

	/**
	 * Returns the value of the '<em><b>Sources</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Element}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sources</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage#getDebugTraceBack_Sources()
	 * @model
	 * @generated
	 */
	@NonNull EList<Element> getSources();

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Element)
	 * @see org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage#getDebugTraceBack_Target()
	 * @model required="true"
	 * @generated
	 */
	Element getTarget();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtbase.DebugTraceBack#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Element value);

} // DebugTraceBack
