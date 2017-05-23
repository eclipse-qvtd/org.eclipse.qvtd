/**
 * Copyright (c) 2015, 2017 Willink Transformations and others.
 * ;All rights reserved. This program and the accompanying materials
 * ;are made available under the terms of the Eclipse Public License v1.0
 * ;which accompanies this distribution, and is available at
 * ;http://www.eclipse.org/legal/epl-v10.html
 * ;
 * ;Contributors:
 * ;  E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.m2m.atl.common.ATL.Module;

import org.eclipse.m2m.atl.common.OCL.OclModel;

import org.eclipse.qvtd.pivot.qvtbase.TypedModel;

import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TOcl Model2 Model Parameter from</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOclModel2ModelParameter_from#getAModule <em>AModule</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOclModel2ModelParameter_from#getOclModel <em>Ocl Model</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOclModel2ModelParameter_from#getRelTM <em>Rel TM</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOclModel2ModelParameter_from#getRelTx <em>Rel Tx</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOclModel2ModelParameter_from#getTmName <em>Tm Name</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.PATL2QVTrPackage#getTOclModel2ModelParameter_from()
 * @model
 * @generated
 */
public interface TOclModel2ModelParameter_from extends EObject {
	/**
	 * Returns the value of the '<em><b>AModule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>AModule</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>AModule</em>' reference.
	 * @see #setAModule(Module)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.PATL2QVTrPackage#getTOclModel2ModelParameter_from_AModule()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='atl'"
	 * @generated
	 */
	Module getAModule();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOclModel2ModelParameter_from#getAModule <em>AModule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>AModule</em>' reference.
	 * @see #getAModule()
	 * @generated
	 */
	void setAModule(Module value);

	/**
	 * Returns the value of the '<em><b>Ocl Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ocl Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ocl Model</em>' reference.
	 * @see #setOclModel(OclModel)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.PATL2QVTrPackage#getTOclModel2ModelParameter_from_OclModel()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='atl'"
	 * @generated
	 */
	OclModel getOclModel();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOclModel2ModelParameter_from#getOclModel <em>Ocl Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ocl Model</em>' reference.
	 * @see #getOclModel()
	 * @generated
	 */
	void setOclModel(OclModel value);

	/**
	 * Returns the value of the '<em><b>Rel TM</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rel TM</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rel TM</em>' reference.
	 * @see #setRelTM(TypedModel)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.PATL2QVTrPackage#getTOclModel2ModelParameter_from_RelTM()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='qvtr'"
	 * @generated
	 */
	TypedModel getRelTM();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOclModel2ModelParameter_from#getRelTM <em>Rel TM</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rel TM</em>' reference.
	 * @see #getRelTM()
	 * @generated
	 */
	void setRelTM(TypedModel value);

	/**
	 * Returns the value of the '<em><b>Rel Tx</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rel Tx</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rel Tx</em>' reference.
	 * @see #setRelTx(RelationalTransformation)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.PATL2QVTrPackage#getTOclModel2ModelParameter_from_RelTx()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='qvtr'"
	 * @generated
	 */
	RelationalTransformation getRelTx();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOclModel2ModelParameter_from#getRelTx <em>Rel Tx</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rel Tx</em>' reference.
	 * @see #getRelTx()
	 * @generated
	 */
	void setRelTx(RelationalTransformation value);

	/**
	 * Returns the value of the '<em><b>Tm Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tm Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tm Name</em>' attribute.
	 * @see #setTmName(String)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.PATL2QVTrPackage#getTOclModel2ModelParameter_from_TmName()
	 * @model required="true"
	 * @generated
	 */
	String getTmName();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOclModel2ModelParameter_from#getTmName <em>Tm Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tm Name</em>' attribute.
	 * @see #getTmName()
	 * @generated
	 */
	void setTmName(String value);

} // TOclModel2ModelParameter_from
