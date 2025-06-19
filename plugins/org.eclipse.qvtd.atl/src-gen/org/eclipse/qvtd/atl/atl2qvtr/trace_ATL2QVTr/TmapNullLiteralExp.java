/**
 * Copyright (c) 2015, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr;

import org.eclipse.m2m.atl.common.OCL.VariableDeclaration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tmap Null Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNullLiteralExp#getDispatcher <em>Dispatcher</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNullLiteralExp#getT1varName <em>T1var Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNullLiteralExp#getT3atlVariable <em>T3atl Variable</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapNullLiteralExp()
 * @model
 * @generated
 */
public interface TmapNullLiteralExp extends ImapOclExpression {
	/**
	 * Returns the value of the '<em><b>Dispatcher</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapNullLiteralExp <em>Domap Null Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dispatcher</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dispatcher</em>' container reference.
	 * @see #setDispatcher(DmapOclExpression)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapNullLiteralExp_Dispatcher()
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapNullLiteralExp
	 * @model opposite="domapNullLiteralExp" required="true" transient="false"
	 * @generated
	 */
	DmapOclExpression getDispatcher();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNullLiteralExp#getDispatcher <em>Dispatcher</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dispatcher</em>' container reference.
	 * @see #getDispatcher()
	 * @generated
	 */
	void setDispatcher(DmapOclExpression value);

	/**
	 * Returns the value of the '<em><b>T1var Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>T1var Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>T1var Name</em>' attribute.
	 * @see #setT1varName(String)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapNullLiteralExp_T1varName()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='$primitive$'"
	 * @generated
	 */
	String getT1varName();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNullLiteralExp#getT1varName <em>T1var Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>T1var Name</em>' attribute.
	 * @see #getT1varName()
	 * @generated
	 */
	void setT1varName(String value);

	/**
	 * Returns the value of the '<em><b>T3atl Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>T3atl Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>T3atl Variable</em>' reference.
	 * @see #setT3atlVariable(VariableDeclaration)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapNullLiteralExp_T3atlVariable()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='atl'"
	 * @generated
	 */
	VariableDeclaration getT3atlVariable();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNullLiteralExp#getT3atlVariable <em>T3atl Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>T3atl Variable</em>' reference.
	 * @see #getT3atlVariable()
	 * @generated
	 */
	void setT3atlVariable(VariableDeclaration value);

} // TmapNullLiteralExp
