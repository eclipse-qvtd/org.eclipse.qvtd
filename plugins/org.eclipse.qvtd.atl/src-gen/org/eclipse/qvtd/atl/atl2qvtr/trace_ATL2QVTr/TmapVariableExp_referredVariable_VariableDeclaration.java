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

import org.eclipse.m2m.atl.common.ATL.PatternElement;

import org.eclipse.ocl.pivot.VariableDeclaration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tmap Variable Exp referred Variable Variable Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp_referredVariable_VariableDeclaration#getDispatcher <em>Dispatcher</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp_referredVariable_VariableDeclaration#getT1atlVariable <em>T1atl Variable</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp_referredVariable_VariableDeclaration#getT2qvtrVariable <em>T2qvtr Variable</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapVariableExp_referredVariable_VariableDeclaration()
 * @model
 * @generated
 */
public interface TmapVariableExp_referredVariable_VariableDeclaration extends ImapVariableExp_referredVariable {
	/**
	 * Returns the value of the '<em><b>Dispatcher</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapVariableExp_referredVariable#getDomapVariableExp_referredVariable_VariableDeclaration <em>Domap Variable Exp referred Variable Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dispatcher</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dispatcher</em>' container reference.
	 * @see #setDispatcher(DmapVariableExp_referredVariable)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapVariableExp_referredVariable_VariableDeclaration_Dispatcher()
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapVariableExp_referredVariable#getDomapVariableExp_referredVariable_VariableDeclaration
	 * @model opposite="domapVariableExp_referredVariable_VariableDeclaration" required="true" transient="false"
	 * @generated
	 */
	DmapVariableExp_referredVariable getDispatcher();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp_referredVariable_VariableDeclaration#getDispatcher <em>Dispatcher</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dispatcher</em>' container reference.
	 * @see #getDispatcher()
	 * @generated
	 */
	void setDispatcher(DmapVariableExp_referredVariable value);

	/**
	 * Returns the value of the '<em><b>T1atl Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>T1atl Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>T1atl Variable</em>' reference.
	 * @see #setT1atlVariable(PatternElement)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapVariableExp_referredVariable_VariableDeclaration_T1atlVariable()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='atl'"
	 * @generated
	 */
	PatternElement getT1atlVariable();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp_referredVariable_VariableDeclaration#getT1atlVariable <em>T1atl Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>T1atl Variable</em>' reference.
	 * @see #getT1atlVariable()
	 * @generated
	 */
	void setT1atlVariable(PatternElement value);

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
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapVariableExp_referredVariable_VariableDeclaration_T2qvtrVariable()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='qvtr'"
	 * @generated
	 */
	VariableDeclaration getT2qvtrVariable();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp_referredVariable_VariableDeclaration#getT2qvtrVariable <em>T2qvtr Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>T2qvtr Variable</em>' reference.
	 * @see #getT2qvtrVariable()
	 * @generated
	 */
	void setT2qvtrVariable(VariableDeclaration value);

} // TmapVariableExp_referredVariable_VariableDeclaration
