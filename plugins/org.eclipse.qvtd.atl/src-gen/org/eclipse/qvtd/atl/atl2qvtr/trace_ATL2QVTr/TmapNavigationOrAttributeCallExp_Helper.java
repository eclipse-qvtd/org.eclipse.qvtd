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

import org.eclipse.m2m.atl.common.OCL.OclExpression;

import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.VariableExp;

import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tmap Navigation Or Attribute Call Exp Helper</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getDispatcher <em>Dispatcher</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getT0propertyName <em>T0property Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getT1atlSource <em>T1atl Source</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getT2qvtrOperation <em>T2qvtr Operation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getT2qvtrSource <em>T2qvtr Source</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getT2qvtrSourceArgument <em>T2qvtr Source Argument</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getT2qvtrTransformation <em>T2qvtr Transformation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getWmapHelper <em>Wmap Helper</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getWmapModule <em>Wmap Module</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getWmapOclExpression <em>Wmap Ocl Expression</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapNavigationOrAttributeCallExp_Helper()
 * @model
 * @generated
 */
public interface TmapNavigationOrAttributeCallExp_Helper extends ImapOclExpression {
	/**
	 * Returns the value of the '<em><b>Dispatcher</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapNavigationOrAttributeCallExp_Helper <em>Domap Navigation Or Attribute Call Exp Helper</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dispatcher</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dispatcher</em>' container reference.
	 * @see #setDispatcher(DmapOclExpression)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapNavigationOrAttributeCallExp_Helper_Dispatcher()
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapNavigationOrAttributeCallExp_Helper
	 * @model opposite="domapNavigationOrAttributeCallExp_Helper" required="true" transient="false"
	 * @generated
	 */
	DmapOclExpression getDispatcher();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getDispatcher <em>Dispatcher</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dispatcher</em>' container reference.
	 * @see #getDispatcher()
	 * @generated
	 */
	void setDispatcher(DmapOclExpression value);

	/**
	 * Returns the value of the '<em><b>T0property Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>T0property Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>T0property Name</em>' attribute.
	 * @see #setT0propertyName(String)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapNavigationOrAttributeCallExp_Helper_T0propertyName()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='$primitive$'"
	 * @generated
	 */
	String getT0propertyName();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getT0propertyName <em>T0property Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>T0property Name</em>' attribute.
	 * @see #getT0propertyName()
	 * @generated
	 */
	void setT0propertyName(String value);

	/**
	 * Returns the value of the '<em><b>T1atl Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>T1atl Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>T1atl Source</em>' reference.
	 * @see #setT1atlSource(OclExpression)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapNavigationOrAttributeCallExp_Helper_T1atlSource()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='atl'"
	 * @generated
	 */
	OclExpression getT1atlSource();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getT1atlSource <em>T1atl Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>T1atl Source</em>' reference.
	 * @see #getT1atlSource()
	 * @generated
	 */
	void setT1atlSource(OclExpression value);

	/**
	 * Returns the value of the '<em><b>T2qvtr Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>T2qvtr Operation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>T2qvtr Operation</em>' reference.
	 * @see #setT2qvtrOperation(Operation)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapNavigationOrAttributeCallExp_Helper_T2qvtrOperation()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='qvtr'"
	 * @generated
	 */
	Operation getT2qvtrOperation();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getT2qvtrOperation <em>T2qvtr Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>T2qvtr Operation</em>' reference.
	 * @see #getT2qvtrOperation()
	 * @generated
	 */
	void setT2qvtrOperation(Operation value);

	/**
	 * Returns the value of the '<em><b>T2qvtr Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>T2qvtr Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>T2qvtr Source</em>' reference.
	 * @see #setT2qvtrSource(VariableExp)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapNavigationOrAttributeCallExp_Helper_T2qvtrSource()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='qvtr'"
	 * @generated
	 */
	VariableExp getT2qvtrSource();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getT2qvtrSource <em>T2qvtr Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>T2qvtr Source</em>' reference.
	 * @see #getT2qvtrSource()
	 * @generated
	 */
	void setT2qvtrSource(VariableExp value);

	/**
	 * Returns the value of the '<em><b>T2qvtr Source Argument</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>T2qvtr Source Argument</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>T2qvtr Source Argument</em>' reference.
	 * @see #setT2qvtrSourceArgument(OCLExpression)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapNavigationOrAttributeCallExp_Helper_T2qvtrSourceArgument()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='qvtr'"
	 * @generated
	 */
	OCLExpression getT2qvtrSourceArgument();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getT2qvtrSourceArgument <em>T2qvtr Source Argument</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>T2qvtr Source Argument</em>' reference.
	 * @see #getT2qvtrSourceArgument()
	 * @generated
	 */
	void setT2qvtrSourceArgument(OCLExpression value);

	/**
	 * Returns the value of the '<em><b>T2qvtr Transformation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>T2qvtr Transformation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>T2qvtr Transformation</em>' reference.
	 * @see #setT2qvtrTransformation(RelationalTransformation)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapNavigationOrAttributeCallExp_Helper_T2qvtrTransformation()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='qvtr'"
	 * @generated
	 */
	RelationalTransformation getT2qvtrTransformation();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getT2qvtrTransformation <em>T2qvtr Transformation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>T2qvtr Transformation</em>' reference.
	 * @see #getT2qvtrTransformation()
	 * @generated
	 */
	void setT2qvtrTransformation(RelationalTransformation value);

	/**
	 * Returns the value of the '<em><b>Wmap Helper</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wmap Helper</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wmap Helper</em>' reference.
	 * @see #setWmapHelper(DmapHelper)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapNavigationOrAttributeCallExp_Helper_WmapHelper()
	 * @model
	 * @generated
	 */
	DmapHelper getWmapHelper();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getWmapHelper <em>Wmap Helper</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wmap Helper</em>' reference.
	 * @see #getWmapHelper()
	 * @generated
	 */
	void setWmapHelper(DmapHelper value);

	/**
	 * Returns the value of the '<em><b>Wmap Module</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wmap Module</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wmap Module</em>' reference.
	 * @see #setWmapModule(TmapModule)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapNavigationOrAttributeCallExp_Helper_WmapModule()
	 * @model
	 * @generated
	 */
	TmapModule getWmapModule();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getWmapModule <em>Wmap Module</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wmap Module</em>' reference.
	 * @see #getWmapModule()
	 * @generated
	 */
	void setWmapModule(TmapModule value);

	/**
	 * Returns the value of the '<em><b>Wmap Ocl Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wmap Ocl Expression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wmap Ocl Expression</em>' reference.
	 * @see #setWmapOclExpression(DmapOclExpression)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapNavigationOrAttributeCallExp_Helper_WmapOclExpression()
	 * @model
	 * @generated
	 */
	DmapOclExpression getWmapOclExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getWmapOclExpression <em>Wmap Ocl Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wmap Ocl Expression</em>' reference.
	 * @see #getWmapOclExpression()
	 * @generated
	 */
	void setWmapOclExpression(DmapOclExpression value);

} // TmapNavigationOrAttributeCallExp_Helper
