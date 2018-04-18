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
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapHelper#getD1atlHelper <em>D1atl Helper</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapHelper#getD2qvtrFunction <em>D2qvtr Function</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapHelper#getDomapHelper_Attribute <em>Domap Helper Attribute</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapHelper#getDomapHelper_Operation <em>Domap Helper Operation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapHelper#getResult <em>Result</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getDmapHelper()
 * @model
 * @generated
 */
public interface DmapHelper extends Dispatch {
	/**
	 * Returns the value of the '<em><b>D1atl Helper</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>D1atl Helper</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>D1atl Helper</em>' reference.
	 * @see #setD1atlHelper(Helper)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getDmapHelper_D1atlHelper()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='DmapHelper'"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='atl'"
	 * @generated
	 */
	Helper getD1atlHelper();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapHelper#getD1atlHelper <em>D1atl Helper</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>D1atl Helper</em>' reference.
	 * @see #getD1atlHelper()
	 * @generated
	 */
	void setD1atlHelper(Helper value);

	/**
	 * Returns the value of the '<em><b>D2qvtr Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>D2qvtr Function</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>D2qvtr Function</em>' reference.
	 * @see #setD2qvtrFunction(Function)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getDmapHelper_D2qvtrFunction()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='DmapHelper'"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='qvtr'"
	 * @generated
	 */
	Function getD2qvtrFunction();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapHelper#getD2qvtrFunction <em>D2qvtr Function</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>D2qvtr Function</em>' reference.
	 * @see #getD2qvtrFunction()
	 * @generated
	 */
	void setD2qvtrFunction(Function value);

	/**
	 * Returns the value of the '<em><b>Domap Helper Attribute</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Attribute#getDispatcher <em>Dispatcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domap Helper Attribute</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
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
	 * <p>
	 * If the meaning of the '<em>Domap Helper Operation</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
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
	 * <p>
	 * If the meaning of the '<em>Result</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
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

} // DmapHelper
