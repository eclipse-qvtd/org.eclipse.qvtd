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

import org.eclipse.m2m.atl.common.OCL.VariableExp;

import org.eclipse.qvtd.runtime.qvttrace.Dispatch;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dmap Variable Exp referred Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapVariableExp_referredVariable#getD3atlExpression <em>D3atl Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapVariableExp_referredVariable#getD4qvtrExpression <em>D4qvtr Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapVariableExp_referredVariable#getDomapVariableExp_referredVariable_Helper <em>Domap Variable Exp referred Variable Helper</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapVariableExp_referredVariable#getDomapVariableExp_referredVariable_VariableDeclaration <em>Domap Variable Exp referred Variable Variable Declaration</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapVariableExp_referredVariable#getResult <em>Result</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapVariableExp_referredVariable#getS0global <em>S0global</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getDmapVariableExp_referredVariable()
 * @model
 * @generated
 */
public interface DmapVariableExp_referredVariable extends Dispatch {
	/**
	 * Returns the value of the '<em><b>D3atl Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>D3atl Expression</em>' reference.
	 * @see #setD3atlExpression(VariableExp)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getDmapVariableExp_referredVariable_D3atlExpression()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='DmapVariableExp_referredVariable'"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='atl'"
	 * @generated
	 */
	VariableExp getD3atlExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapVariableExp_referredVariable#getD3atlExpression <em>D3atl Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>D3atl Expression</em>' reference.
	 * @see #getD3atlExpression()
	 * @generated
	 */
	void setD3atlExpression(VariableExp value);

	/**
	 * Returns the value of the '<em><b>D4qvtr Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>D4qvtr Expression</em>' reference.
	 * @see #setD4qvtrExpression(org.eclipse.ocl.pivot.VariableExp)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getDmapVariableExp_referredVariable_D4qvtrExpression()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='DmapVariableExp_referredVariable'"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='qvtr'"
	 * @generated
	 */
	org.eclipse.ocl.pivot.VariableExp getD4qvtrExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapVariableExp_referredVariable#getD4qvtrExpression <em>D4qvtr Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>D4qvtr Expression</em>' reference.
	 * @see #getD4qvtrExpression()
	 * @generated
	 */
	void setD4qvtrExpression(org.eclipse.ocl.pivot.VariableExp value);

	/**
	 * Returns the value of the '<em><b>Domap Variable Exp referred Variable Helper</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp_referredVariable_Helper#getDispatcher <em>Dispatcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domap Variable Exp referred Variable Helper</em>' containment reference.
	 * @see #setDomapVariableExp_referredVariable_Helper(TmapVariableExp_referredVariable_Helper)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getDmapVariableExp_referredVariable_DomapVariableExp_referredVariable_Helper()
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp_referredVariable_Helper#getDispatcher
	 * @model opposite="dispatcher" containment="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='middle'"
	 * @generated
	 */
	TmapVariableExp_referredVariable_Helper getDomapVariableExp_referredVariable_Helper();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapVariableExp_referredVariable#getDomapVariableExp_referredVariable_Helper <em>Domap Variable Exp referred Variable Helper</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domap Variable Exp referred Variable Helper</em>' containment reference.
	 * @see #getDomapVariableExp_referredVariable_Helper()
	 * @generated
	 */
	void setDomapVariableExp_referredVariable_Helper(TmapVariableExp_referredVariable_Helper value);

	/**
	 * Returns the value of the '<em><b>Domap Variable Exp referred Variable Variable Declaration</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp_referredVariable_VariableDeclaration#getDispatcher <em>Dispatcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domap Variable Exp referred Variable Variable Declaration</em>' containment reference.
	 * @see #setDomapVariableExp_referredVariable_VariableDeclaration(TmapVariableExp_referredVariable_VariableDeclaration)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getDmapVariableExp_referredVariable_DomapVariableExp_referredVariable_VariableDeclaration()
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp_referredVariable_VariableDeclaration#getDispatcher
	 * @model opposite="dispatcher" containment="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='middle'"
	 * @generated
	 */
	TmapVariableExp_referredVariable_VariableDeclaration getDomapVariableExp_referredVariable_VariableDeclaration();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapVariableExp_referredVariable#getDomapVariableExp_referredVariable_VariableDeclaration <em>Domap Variable Exp referred Variable Variable Declaration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domap Variable Exp referred Variable Variable Declaration</em>' containment reference.
	 * @see #getDomapVariableExp_referredVariable_VariableDeclaration()
	 * @generated
	 */
	void setDomapVariableExp_referredVariable_VariableDeclaration(TmapVariableExp_referredVariable_VariableDeclaration value);

	/**
	 * Returns the value of the '<em><b>Result</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result</em>' reference.
	 * @see #setResult(ImapVariableExp_referredVariable)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getDmapVariableExp_referredVariable_Result()
	 * @model
	 * @generated
	 */
	ImapVariableExp_referredVariable getResult();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapVariableExp_referredVariable#getResult <em>Result</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result</em>' reference.
	 * @see #getResult()
	 * @generated
	 */
	void setResult(ImapVariableExp_referredVariable value);

	/**
	 * Returns the value of the '<em><b>S0global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>S0global</em>' attribute.
	 * @see #setS0global(Boolean)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getDmapVariableExp_referredVariable_S0global()
	 * @model
	 * @generated
	 */
	Boolean getS0global();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapVariableExp_referredVariable#getS0global <em>S0global</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>S0global</em>' attribute.
	 * @see #getS0global()
	 * @generated
	 */
	void setS0global(Boolean value);

} // DmapVariableExp_referredVariable
