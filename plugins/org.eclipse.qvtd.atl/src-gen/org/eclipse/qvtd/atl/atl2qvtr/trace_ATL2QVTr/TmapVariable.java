/**
 * Copyright (c) 2015, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr;

import org.eclipse.m2m.atl.common.ATL.LocatedElement;

import org.eclipse.ocl.pivot.VariableDeclaration;

import org.eclipse.qvtd.runtime.qvttrace.Execution;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tmap Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariable#getSuccess <em>Success</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariable#getT1atlVariable <em>T1atl Variable</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariable#getT2qvtrVariable <em>T2qvtr Variable</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapVariable()
 * @model
 * @generated
 */
public interface TmapVariable extends Execution {
	/**
	 * Returns the value of the '<em><b>Success</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Success</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Success</em>' attribute.
	 * @see #setSuccess(Boolean)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapVariable_Success()
	 * @model
	 * @generated
	 */
	Boolean getSuccess();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariable#getSuccess <em>Success</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Success</em>' attribute.
	 * @see #getSuccess()
	 * @generated
	 */
	void setSuccess(Boolean value);

	/**
	 * Returns the value of the '<em><b>T1atl Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>T1atl Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>T1atl Variable</em>' reference.
	 * @see #setT1atlVariable(LocatedElement)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapVariable_T1atlVariable()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='TmapVariable'"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='atl'"
	 * @generated
	 */
	LocatedElement getT1atlVariable();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariable#getT1atlVariable <em>T1atl Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>T1atl Variable</em>' reference.
	 * @see #getT1atlVariable()
	 * @generated
	 */
	void setT1atlVariable(LocatedElement value);

	/**
	 * Returns the value of the '<em><b>T2qvtr Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>T2qvtr Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>T2qvtr Variable</em>' reference.
	 * @see #setT2qvtrVariable(VariableDeclaration)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapVariable_T2qvtrVariable()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='TmapVariable'"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='qvtr'"
	 * @generated
	 */
	VariableDeclaration getT2qvtrVariable();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariable#getT2qvtrVariable <em>T2qvtr Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>T2qvtr Variable</em>' reference.
	 * @see #getT2qvtrVariable()
	 * @generated
	 */
	void setT2qvtrVariable(VariableDeclaration value);

} // TmapVariable
