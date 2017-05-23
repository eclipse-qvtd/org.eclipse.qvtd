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

import org.eclipse.m2m.atl.common.ATL.Helper;
import org.eclipse.m2m.atl.common.ATL.Module;

import org.eclipse.m2m.atl.common.OCL.OclFeatureDefinition;
import org.eclipse.m2m.atl.common.OCL.Operation;

import org.eclipse.qvtd.pivot.qvtbase.Function;

import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>THelper2 Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.THelper2Function#getADef <em>ADef</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.THelper2Function#getAFeat <em>AFeat</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.THelper2Function#getAModule <em>AModule</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.THelper2Function#getFunction <em>Function</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.THelper2Function#getHelper <em>Helper</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.THelper2Function#getOpName <em>Op Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.THelper2Function#getRelTx <em>Rel Tx</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.PATL2QVTrPackage#getTHelper2Function()
 * @model
 * @generated
 */
public interface THelper2Function extends EObject {
	/**
	 * Returns the value of the '<em><b>ADef</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>ADef</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>ADef</em>' reference.
	 * @see #setADef(OclFeatureDefinition)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.PATL2QVTrPackage#getTHelper2Function_ADef()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='THelper2Function'"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='atl'"
	 * @generated
	 */
	OclFeatureDefinition getADef();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.THelper2Function#getADef <em>ADef</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ADef</em>' reference.
	 * @see #getADef()
	 * @generated
	 */
	void setADef(OclFeatureDefinition value);

	/**
	 * Returns the value of the '<em><b>AFeat</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>AFeat</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>AFeat</em>' reference.
	 * @see #setAFeat(Operation)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.PATL2QVTrPackage#getTHelper2Function_AFeat()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='THelper2Function'"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='atl'"
	 * @generated
	 */
	Operation getAFeat();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.THelper2Function#getAFeat <em>AFeat</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>AFeat</em>' reference.
	 * @see #getAFeat()
	 * @generated
	 */
	void setAFeat(Operation value);

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
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.PATL2QVTrPackage#getTHelper2Function_AModule()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='atl'"
	 * @generated
	 */
	Module getAModule();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.THelper2Function#getAModule <em>AModule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>AModule</em>' reference.
	 * @see #getAModule()
	 * @generated
	 */
	void setAModule(Module value);

	/**
	 * Returns the value of the '<em><b>Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function</em>' reference.
	 * @see #setFunction(Function)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.PATL2QVTrPackage#getTHelper2Function_Function()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='THelper2Function'"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='qvtr'"
	 * @generated
	 */
	Function getFunction();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.THelper2Function#getFunction <em>Function</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Function</em>' reference.
	 * @see #getFunction()
	 * @generated
	 */
	void setFunction(Function value);

	/**
	 * Returns the value of the '<em><b>Helper</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Helper</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Helper</em>' reference.
	 * @see #setHelper(Helper)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.PATL2QVTrPackage#getTHelper2Function_Helper()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='THelper2Function'"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='atl'"
	 * @generated
	 */
	Helper getHelper();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.THelper2Function#getHelper <em>Helper</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Helper</em>' reference.
	 * @see #getHelper()
	 * @generated
	 */
	void setHelper(Helper value);

	/**
	 * Returns the value of the '<em><b>Op Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Op Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Op Name</em>' attribute.
	 * @see #setOpName(String)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.PATL2QVTrPackage#getTHelper2Function_OpName()
	 * @model required="true"
	 * @generated
	 */
	String getOpName();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.THelper2Function#getOpName <em>Op Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Op Name</em>' attribute.
	 * @see #getOpName()
	 * @generated
	 */
	void setOpName(String value);

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
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.PATL2QVTrPackage#getTHelper2Function_RelTx()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='qvtr'"
	 * @generated
	 */
	RelationalTransformation getRelTx();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.THelper2Function#getRelTx <em>Rel Tx</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rel Tx</em>' reference.
	 * @see #getRelTx()
	 * @generated
	 */
	void setRelTx(RelationalTransformation value);

} // THelper2Function
