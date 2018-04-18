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

import org.eclipse.ocl.pivot.ParameterVariable;

import org.eclipse.qvtd.pivot.qvtrelation.RelationModel;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;

import org.eclipse.qvtd.runtime.qvttrace.Execution;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tmap Module</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapModule#getT0txName <em>T0tx Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapModule#getT1atlModule <em>T1atl Module</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapModule#getT2_1 <em>T2 1</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapModule#getT2_2 <em>T2 2</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapModule#getT2_3 <em>T2 3</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapModule#getT2qvtrTransformation <em>T2qvtr Transformation</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapModule()
 * @model
 * @generated
 */
public interface TmapModule extends Execution {
	/**
	 * Returns the value of the '<em><b>T0tx Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>T0tx Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>T0tx Name</em>' attribute.
	 * @see #setT0txName(String)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapModule_T0txName()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='$primitive$'"
	 * @generated
	 */
	String getT0txName();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapModule#getT0txName <em>T0tx Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>T0tx Name</em>' attribute.
	 * @see #getT0txName()
	 * @generated
	 */
	void setT0txName(String value);

	/**
	 * Returns the value of the '<em><b>T1atl Module</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>T1atl Module</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>T1atl Module</em>' reference.
	 * @see #setT1atlModule(org.eclipse.m2m.atl.common.ATL.Module)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapModule_T1atlModule()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='TmapModule'"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='atl'"
	 * @generated
	 */
	org.eclipse.m2m.atl.common.ATL.Module getT1atlModule();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapModule#getT1atlModule <em>T1atl Module</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>T1atl Module</em>' reference.
	 * @see #getT1atlModule()
	 * @generated
	 */
	void setT1atlModule(org.eclipse.m2m.atl.common.ATL.Module value);

	/**
	 * Returns the value of the '<em><b>T2 1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>T2 1</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>T2 1</em>' reference.
	 * @see #setT2_1(org.eclipse.ocl.pivot.Package)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapModule_T2_1()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='qvtr'"
	 * @generated
	 */
	org.eclipse.ocl.pivot.Package getT2_1();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapModule#getT2_1 <em>T2 1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>T2 1</em>' reference.
	 * @see #getT2_1()
	 * @generated
	 */
	void setT2_1(org.eclipse.ocl.pivot.Package value);

	/**
	 * Returns the value of the '<em><b>T2 2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>T2 2</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>T2 2</em>' reference.
	 * @see #setT2_2(ParameterVariable)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapModule_T2_2()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='qvtr'"
	 * @generated
	 */
	ParameterVariable getT2_2();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapModule#getT2_2 <em>T2 2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>T2 2</em>' reference.
	 * @see #getT2_2()
	 * @generated
	 */
	void setT2_2(ParameterVariable value);

	/**
	 * Returns the value of the '<em><b>T2 3</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>T2 3</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>T2 3</em>' reference.
	 * @see #setT2_3(RelationModel)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapModule_T2_3()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='qvtr'"
	 * @generated
	 */
	RelationModel getT2_3();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapModule#getT2_3 <em>T2 3</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>T2 3</em>' reference.
	 * @see #getT2_3()
	 * @generated
	 */
	void setT2_3(RelationModel value);

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
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapModule_T2qvtrTransformation()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='TmapModule'"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='qvtr'"
	 * @generated
	 */
	RelationalTransformation getT2qvtrTransformation();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapModule#getT2qvtrTransformation <em>T2qvtr Transformation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>T2qvtr Transformation</em>' reference.
	 * @see #getT2qvtrTransformation()
	 * @generated
	 */
	void setT2qvtrTransformation(RelationalTransformation value);

} // TmapModule
