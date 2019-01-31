/**
 * Copyright (c) 2015, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr;

import org.eclipse.m2m.atl.common.OCL.OclExpression;

import org.eclipse.ocl.pivot.OCLExpression;

import org.eclipse.qvtd.runtime.qvttrace.Dispatch;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dmap Ocl Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getD1atlExpression <em>D1atl Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getD2qvtrExpression <em>D2qvtr Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapBooleanExp <em>Domap Boolean Exp</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapIfExp <em>Domap If Exp</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapIntegerExp <em>Domap Integer Exp</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapNavigationOrAttributeCallExp_Helper <em>Domap Navigation Or Attribute Call Exp Helper</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapNavigationOrAttributeCallExp_Property <em>Domap Navigation Or Attribute Call Exp Property</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapOperationCallExp_Helper <em>Domap Operation Call Exp Helper</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapOperationCallExp_Operation <em>Domap Operation Call Exp Operation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapOperatorCallExp <em>Domap Operator Call Exp</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapStringExp <em>Domap String Exp</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapVariableExp <em>Domap Variable Exp</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getResult <em>Result</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getDmapOclExpression()
 * @model
 * @generated
 */
public interface DmapOclExpression extends Dispatch {
	/**
	 * Returns the value of the '<em><b>D1atl Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>D1atl Expression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>D1atl Expression</em>' reference.
	 * @see #setD1atlExpression(OclExpression)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getDmapOclExpression_D1atlExpression()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='DmapOclExpression'"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='atl'"
	 * @generated
	 */
	OclExpression getD1atlExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getD1atlExpression <em>D1atl Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>D1atl Expression</em>' reference.
	 * @see #getD1atlExpression()
	 * @generated
	 */
	void setD1atlExpression(OclExpression value);

	/**
	 * Returns the value of the '<em><b>D2qvtr Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>D2qvtr Expression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>D2qvtr Expression</em>' reference.
	 * @see #setD2qvtrExpression(OCLExpression)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getDmapOclExpression_D2qvtrExpression()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='DmapOclExpression'"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='qvtr'"
	 * @generated
	 */
	OCLExpression getD2qvtrExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getD2qvtrExpression <em>D2qvtr Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>D2qvtr Expression</em>' reference.
	 * @see #getD2qvtrExpression()
	 * @generated
	 */
	void setD2qvtrExpression(OCLExpression value);

	/**
	 * Returns the value of the '<em><b>Domap Boolean Exp</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBooleanExp#getDispatcher <em>Dispatcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domap Boolean Exp</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domap Boolean Exp</em>' containment reference.
	 * @see #setDomapBooleanExp(TmapBooleanExp)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getDmapOclExpression_DomapBooleanExp()
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBooleanExp#getDispatcher
	 * @model opposite="dispatcher" containment="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='middle'"
	 * @generated
	 */
	TmapBooleanExp getDomapBooleanExp();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapBooleanExp <em>Domap Boolean Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domap Boolean Exp</em>' containment reference.
	 * @see #getDomapBooleanExp()
	 * @generated
	 */
	void setDomapBooleanExp(TmapBooleanExp value);

	/**
	 * Returns the value of the '<em><b>Domap If Exp</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIfExp#getDispatcher <em>Dispatcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domap If Exp</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domap If Exp</em>' containment reference.
	 * @see #setDomapIfExp(TmapIfExp)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getDmapOclExpression_DomapIfExp()
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIfExp#getDispatcher
	 * @model opposite="dispatcher" containment="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='middle'"
	 * @generated
	 */
	TmapIfExp getDomapIfExp();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapIfExp <em>Domap If Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domap If Exp</em>' containment reference.
	 * @see #getDomapIfExp()
	 * @generated
	 */
	void setDomapIfExp(TmapIfExp value);

	/**
	 * Returns the value of the '<em><b>Domap Integer Exp</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIntegerExp#getDispatcher <em>Dispatcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domap Integer Exp</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domap Integer Exp</em>' containment reference.
	 * @see #setDomapIntegerExp(TmapIntegerExp)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getDmapOclExpression_DomapIntegerExp()
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIntegerExp#getDispatcher
	 * @model opposite="dispatcher" containment="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='middle'"
	 * @generated
	 */
	TmapIntegerExp getDomapIntegerExp();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapIntegerExp <em>Domap Integer Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domap Integer Exp</em>' containment reference.
	 * @see #getDomapIntegerExp()
	 * @generated
	 */
	void setDomapIntegerExp(TmapIntegerExp value);

	/**
	 * Returns the value of the '<em><b>Domap Navigation Or Attribute Call Exp Helper</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getDispatcher <em>Dispatcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domap Navigation Or Attribute Call Exp Helper</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domap Navigation Or Attribute Call Exp Helper</em>' containment reference.
	 * @see #setDomapNavigationOrAttributeCallExp_Helper(TmapNavigationOrAttributeCallExp_Helper)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getDmapOclExpression_DomapNavigationOrAttributeCallExp_Helper()
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getDispatcher
	 * @model opposite="dispatcher" containment="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='middle'"
	 * @generated
	 */
	TmapNavigationOrAttributeCallExp_Helper getDomapNavigationOrAttributeCallExp_Helper();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapNavigationOrAttributeCallExp_Helper <em>Domap Navigation Or Attribute Call Exp Helper</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domap Navigation Or Attribute Call Exp Helper</em>' containment reference.
	 * @see #getDomapNavigationOrAttributeCallExp_Helper()
	 * @generated
	 */
	void setDomapNavigationOrAttributeCallExp_Helper(TmapNavigationOrAttributeCallExp_Helper value);

	/**
	 * Returns the value of the '<em><b>Domap Navigation Or Attribute Call Exp Property</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Property#getDispatcher <em>Dispatcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domap Navigation Or Attribute Call Exp Property</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domap Navigation Or Attribute Call Exp Property</em>' containment reference.
	 * @see #setDomapNavigationOrAttributeCallExp_Property(TmapNavigationOrAttributeCallExp_Property)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getDmapOclExpression_DomapNavigationOrAttributeCallExp_Property()
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Property#getDispatcher
	 * @model opposite="dispatcher" containment="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='middle'"
	 * @generated
	 */
	TmapNavigationOrAttributeCallExp_Property getDomapNavigationOrAttributeCallExp_Property();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapNavigationOrAttributeCallExp_Property <em>Domap Navigation Or Attribute Call Exp Property</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domap Navigation Or Attribute Call Exp Property</em>' containment reference.
	 * @see #getDomapNavigationOrAttributeCallExp_Property()
	 * @generated
	 */
	void setDomapNavigationOrAttributeCallExp_Property(TmapNavigationOrAttributeCallExp_Property value);

	/**
	 * Returns the value of the '<em><b>Domap Operation Call Exp Helper</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Helper#getDispatcher <em>Dispatcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domap Operation Call Exp Helper</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domap Operation Call Exp Helper</em>' containment reference.
	 * @see #setDomapOperationCallExp_Helper(TmapOperationCallExp_Helper)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getDmapOclExpression_DomapOperationCallExp_Helper()
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Helper#getDispatcher
	 * @model opposite="dispatcher" containment="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='middle'"
	 * @generated
	 */
	TmapOperationCallExp_Helper getDomapOperationCallExp_Helper();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapOperationCallExp_Helper <em>Domap Operation Call Exp Helper</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domap Operation Call Exp Helper</em>' containment reference.
	 * @see #getDomapOperationCallExp_Helper()
	 * @generated
	 */
	void setDomapOperationCallExp_Helper(TmapOperationCallExp_Helper value);

	/**
	 * Returns the value of the '<em><b>Domap Operation Call Exp Operation</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Operation#getDispatcher <em>Dispatcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domap Operation Call Exp Operation</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domap Operation Call Exp Operation</em>' containment reference.
	 * @see #setDomapOperationCallExp_Operation(TmapOperationCallExp_Operation)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getDmapOclExpression_DomapOperationCallExp_Operation()
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Operation#getDispatcher
	 * @model opposite="dispatcher" containment="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='middle'"
	 * @generated
	 */
	TmapOperationCallExp_Operation getDomapOperationCallExp_Operation();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapOperationCallExp_Operation <em>Domap Operation Call Exp Operation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domap Operation Call Exp Operation</em>' containment reference.
	 * @see #getDomapOperationCallExp_Operation()
	 * @generated
	 */
	void setDomapOperationCallExp_Operation(TmapOperationCallExp_Operation value);

	/**
	 * Returns the value of the '<em><b>Domap Operator Call Exp</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperatorCallExp#getDispatcher <em>Dispatcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domap Operator Call Exp</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domap Operator Call Exp</em>' containment reference.
	 * @see #setDomapOperatorCallExp(TmapOperatorCallExp)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getDmapOclExpression_DomapOperatorCallExp()
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperatorCallExp#getDispatcher
	 * @model opposite="dispatcher" containment="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='middle'"
	 * @generated
	 */
	TmapOperatorCallExp getDomapOperatorCallExp();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapOperatorCallExp <em>Domap Operator Call Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domap Operator Call Exp</em>' containment reference.
	 * @see #getDomapOperatorCallExp()
	 * @generated
	 */
	void setDomapOperatorCallExp(TmapOperatorCallExp value);

	/**
	 * Returns the value of the '<em><b>Domap String Exp</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapStringExp#getDispatcher <em>Dispatcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domap String Exp</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domap String Exp</em>' containment reference.
	 * @see #setDomapStringExp(TmapStringExp)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getDmapOclExpression_DomapStringExp()
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapStringExp#getDispatcher
	 * @model opposite="dispatcher" containment="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='middle'"
	 * @generated
	 */
	TmapStringExp getDomapStringExp();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapStringExp <em>Domap String Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domap String Exp</em>' containment reference.
	 * @see #getDomapStringExp()
	 * @generated
	 */
	void setDomapStringExp(TmapStringExp value);

	/**
	 * Returns the value of the '<em><b>Domap Variable Exp</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp#getDispatcher <em>Dispatcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domap Variable Exp</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domap Variable Exp</em>' containment reference.
	 * @see #setDomapVariableExp(TmapVariableExp)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getDmapOclExpression_DomapVariableExp()
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp#getDispatcher
	 * @model opposite="dispatcher" containment="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='middle'"
	 * @generated
	 */
	TmapVariableExp getDomapVariableExp();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapVariableExp <em>Domap Variable Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domap Variable Exp</em>' containment reference.
	 * @see #getDomapVariableExp()
	 * @generated
	 */
	void setDomapVariableExp(TmapVariableExp value);

	/**
	 * Returns the value of the '<em><b>Result</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result</em>' reference.
	 * @see #setResult(ImapOclExpression)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getDmapOclExpression_Result()
	 * @model
	 * @generated
	 */
	ImapOclExpression getResult();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getResult <em>Result</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result</em>' reference.
	 * @see #getResult()
	 * @generated
	 */
	void setResult(ImapOclExpression value);

} // DmapOclExpression
