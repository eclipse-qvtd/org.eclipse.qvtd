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

import org.eclipse.m2m.atl.common.ATL.Helper;

import org.eclipse.qvtd.pivot.qvtbase.Function;

import org.eclipse.qvtd.runtime.qvttrace.Dispatch;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dmap Helper</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapHelper#getD3atlHelper <em>D3atl Helper</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapHelper#getD4qvtrFunction <em>D4qvtr Function</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapHelper#getDomapHelper_Attribute <em>Domap Helper Attribute</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapHelper#getDomapHelper_Operation <em>Domap Helper Operation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapHelper#getResult <em>Result</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapHelper#getS0global <em>S0global</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getDmapHelper()
 * @model
 * @generated
 */
public interface DmapHelper extends Dispatch {
	/**
	 * Returns the value of the '<em><b>D3atl Helper</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>D3atl Helper</em>' reference.
	 * @see #setD3atlHelper(Helper)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getDmapHelper_D3atlHelper()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='DmapHelper'"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='atl'"
	 * @generated
	 */
	Helper getD3atlHelper();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapHelper#getD3atlHelper <em>D3atl Helper</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>D3atl Helper</em>' reference.
	 * @see #getD3atlHelper()
	 * @generated
	 */
	void setD3atlHelper(Helper value);

	/**
	 * Returns the value of the '<em><b>D4qvtr Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>D4qvtr Function</em>' reference.
	 * @see #setD4qvtrFunction(Function)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getDmapHelper_D4qvtrFunction()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='DmapHelper'"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='qvtr'"
	 * @generated
	 */
	Function getD4qvtrFunction();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapHelper#getD4qvtrFunction <em>D4qvtr Function</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>D4qvtr Function</em>' reference.
	 * @see #getD4qvtrFunction()
	 * @generated
	 */
	void setD4qvtrFunction(Function value);

	/**
	 * Returns the value of the '<em><b>Domap Helper Attribute</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Attribute#getDispatcher <em>Dispatcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domap Helper Attribute</em>' containment reference.
	 * @see #setDomapHelper_Attribute(TmapHelper_Attribute)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getDmapHelper_DomapHelper_Attribute()
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Attribute#getDispatcher
	 * @model opposite="dispatcher" containment="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='middle'"
	 * @generated
	 */
	TmapHelper_Attribute getDomapHelper_Attribute();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapHelper#getDomapHelper_Attribute <em>Domap Helper Attribute</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domap Helper Attribute</em>' containment reference.
	 * @see #getDomapHelper_Attribute()
	 * @generated
	 */
	void setDomapHelper_Attribute(TmapHelper_Attribute value);

	/**
	 * Returns the value of the '<em><b>Domap Helper Operation</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Operation#getDispatcher <em>Dispatcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domap Helper Operation</em>' containment reference.
	 * @see #setDomapHelper_Operation(TmapHelper_Operation)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getDmapHelper_DomapHelper_Operation()
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Operation#getDispatcher
	 * @model opposite="dispatcher" containment="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='middle'"
	 * @generated
	 */
	TmapHelper_Operation getDomapHelper_Operation();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapHelper#getDomapHelper_Operation <em>Domap Helper Operation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domap Helper Operation</em>' containment reference.
	 * @see #getDomapHelper_Operation()
	 * @generated
	 */
	void setDomapHelper_Operation(TmapHelper_Operation value);

	/**
	 * Returns the value of the '<em><b>Result</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result</em>' reference.
	 * @see #setResult(ImapHelper)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getDmapHelper_Result()
	 * @model
	 * @generated
	 */
	ImapHelper getResult();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapHelper#getResult <em>Result</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result</em>' reference.
	 * @see #getResult()
	 * @generated
	 */
	void setResult(ImapHelper value);

	/**
	 * Returns the value of the '<em><b>S0global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>S0global</em>' attribute.
	 * @see #setS0global(Boolean)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getDmapHelper_S0global()
	 * @model
	 * @generated
	 */
	Boolean getS0global();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapHelper#getS0global <em>S0global</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>S0global</em>' attribute.
	 * @see #getS0global()
	 * @generated
	 */
	void setS0global(Boolean value);

} // DmapHelper
