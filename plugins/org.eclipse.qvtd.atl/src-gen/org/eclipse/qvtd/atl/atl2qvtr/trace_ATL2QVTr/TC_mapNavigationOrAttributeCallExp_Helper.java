/**
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr;

import org.eclipse.emf.common.util.EList;

import org.eclipse.m2m.atl.common.OCL.Attribute;
import org.eclipse.m2m.atl.common.OCL.OclExpression;

import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;

import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TC map Navigation Or Attribute Call Exp Helper</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapNavigationOrAttributeCallExp_Helper#getAtl_atlAttributes <em>Atl atl Attributes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapNavigationOrAttributeCallExp_Helper#getAtl_atlModule <em>Atl atl Module</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapNavigationOrAttributeCallExp_Helper#getAtl_atlSource <em>Atl atl Source</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapNavigationOrAttributeCallExp_Helper#getPrimitive_propertyName <em>Primitive property Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapNavigationOrAttributeCallExp_Helper#getQvtr_qvtrOperation <em>Qvtr qvtr Operation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapNavigationOrAttributeCallExp_Helper#getQvtr_qvtrSource <em>Qvtr qvtr Source</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapNavigationOrAttributeCallExp_Helper#getQvtr_qvtrSourceArgument <em>Qvtr qvtr Source Argument</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapNavigationOrAttributeCallExp_Helper#getQvtr_qvtrThisVariable <em>Qvtr qvtr This Variable</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapNavigationOrAttributeCallExp_Helper#getQvtr_qvtrTransformation <em>Qvtr qvtr Transformation</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTC_mapNavigationOrAttributeCallExp_Helper()
 * @model
 * @generated
 */
public interface TC_mapNavigationOrAttributeCallExp_Helper extends TI_mapNavigationOrAttributeCallExp_Helper {
	/**
	 * Returns the value of the '<em><b>Atl atl Attributes</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.m2m.atl.common.OCL.Attribute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Atl atl Attributes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Atl atl Attributes</em>' reference list.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTC_mapNavigationOrAttributeCallExp_Helper_Atl_atlAttributes()
	 * @model annotation="http://www.eclipse.org/qvt#Domains referredDomain='atl'"
	 * @generated
	 */
	EList<Attribute> getAtl_atlAttributes();

	/**
	 * Returns the value of the '<em><b>Atl atl Module</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Atl atl Module</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Atl atl Module</em>' reference.
	 * @see #setAtl_atlModule(org.eclipse.m2m.atl.common.ATL.Module)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTC_mapNavigationOrAttributeCallExp_Helper_Atl_atlModule()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='atl'"
	 * @generated
	 */
	org.eclipse.m2m.atl.common.ATL.Module getAtl_atlModule();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapNavigationOrAttributeCallExp_Helper#getAtl_atlModule <em>Atl atl Module</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Atl atl Module</em>' reference.
	 * @see #getAtl_atlModule()
	 * @generated
	 */
	void setAtl_atlModule(org.eclipse.m2m.atl.common.ATL.Module value);

	/**
	 * Returns the value of the '<em><b>Atl atl Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Atl atl Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Atl atl Source</em>' reference.
	 * @see #setAtl_atlSource(OclExpression)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTC_mapNavigationOrAttributeCallExp_Helper_Atl_atlSource()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='TC_mapNavigationOrAttributeCallExp_Helper'"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='atl'"
	 * @generated
	 */
	OclExpression getAtl_atlSource();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapNavigationOrAttributeCallExp_Helper#getAtl_atlSource <em>Atl atl Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Atl atl Source</em>' reference.
	 * @see #getAtl_atlSource()
	 * @generated
	 */
	void setAtl_atlSource(OclExpression value);

	/**
	 * Returns the value of the '<em><b>Primitive property Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primitive property Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primitive property Name</em>' attribute.
	 * @see #setPrimitive_propertyName(String)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTC_mapNavigationOrAttributeCallExp_Helper_Primitive_propertyName()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='$primitive$'"
	 * @generated
	 */
	String getPrimitive_propertyName();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapNavigationOrAttributeCallExp_Helper#getPrimitive_propertyName <em>Primitive property Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primitive property Name</em>' attribute.
	 * @see #getPrimitive_propertyName()
	 * @generated
	 */
	void setPrimitive_propertyName(String value);

	/**
	 * Returns the value of the '<em><b>Qvtr qvtr Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qvtr qvtr Operation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qvtr qvtr Operation</em>' reference.
	 * @see #setQvtr_qvtrOperation(Operation)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTC_mapNavigationOrAttributeCallExp_Helper_Qvtr_qvtrOperation()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='qvtr'"
	 * @generated
	 */
	Operation getQvtr_qvtrOperation();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapNavigationOrAttributeCallExp_Helper#getQvtr_qvtrOperation <em>Qvtr qvtr Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qvtr qvtr Operation</em>' reference.
	 * @see #getQvtr_qvtrOperation()
	 * @generated
	 */
	void setQvtr_qvtrOperation(Operation value);

	/**
	 * Returns the value of the '<em><b>Qvtr qvtr Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qvtr qvtr Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qvtr qvtr Source</em>' reference.
	 * @see #setQvtr_qvtrSource(VariableExp)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTC_mapNavigationOrAttributeCallExp_Helper_Qvtr_qvtrSource()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='TC_mapNavigationOrAttributeCallExp_Helper'"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='qvtr'"
	 * @generated
	 */
	VariableExp getQvtr_qvtrSource();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapNavigationOrAttributeCallExp_Helper#getQvtr_qvtrSource <em>Qvtr qvtr Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qvtr qvtr Source</em>' reference.
	 * @see #getQvtr_qvtrSource()
	 * @generated
	 */
	void setQvtr_qvtrSource(VariableExp value);

	/**
	 * Returns the value of the '<em><b>Qvtr qvtr Source Argument</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qvtr qvtr Source Argument</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qvtr qvtr Source Argument</em>' reference.
	 * @see #setQvtr_qvtrSourceArgument(OCLExpression)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTC_mapNavigationOrAttributeCallExp_Helper_Qvtr_qvtrSourceArgument()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='qvtr'"
	 * @generated
	 */
	OCLExpression getQvtr_qvtrSourceArgument();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapNavigationOrAttributeCallExp_Helper#getQvtr_qvtrSourceArgument <em>Qvtr qvtr Source Argument</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qvtr qvtr Source Argument</em>' reference.
	 * @see #getQvtr_qvtrSourceArgument()
	 * @generated
	 */
	void setQvtr_qvtrSourceArgument(OCLExpression value);

	/**
	 * Returns the value of the '<em><b>Qvtr qvtr This Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qvtr qvtr This Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qvtr qvtr This Variable</em>' reference.
	 * @see #setQvtr_qvtrThisVariable(VariableDeclaration)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTC_mapNavigationOrAttributeCallExp_Helper_Qvtr_qvtrThisVariable()
	 * @model annotation="http://www.eclipse.org/qvt#Domains referredDomain='qvtr'"
	 * @generated
	 */
	VariableDeclaration getQvtr_qvtrThisVariable();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapNavigationOrAttributeCallExp_Helper#getQvtr_qvtrThisVariable <em>Qvtr qvtr This Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qvtr qvtr This Variable</em>' reference.
	 * @see #getQvtr_qvtrThisVariable()
	 * @generated
	 */
	void setQvtr_qvtrThisVariable(VariableDeclaration value);

	/**
	 * Returns the value of the '<em><b>Qvtr qvtr Transformation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qvtr qvtr Transformation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qvtr qvtr Transformation</em>' reference.
	 * @see #setQvtr_qvtrTransformation(RelationalTransformation)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTC_mapNavigationOrAttributeCallExp_Helper_Qvtr_qvtrTransformation()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='qvtr'"
	 * @generated
	 */
	RelationalTransformation getQvtr_qvtrTransformation();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapNavigationOrAttributeCallExp_Helper#getQvtr_qvtrTransformation <em>Qvtr qvtr Transformation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qvtr qvtr Transformation</em>' reference.
	 * @see #getQvtr_qvtrTransformation()
	 * @generated
	 */
	void setQvtr_qvtrTransformation(RelationalTransformation value);

} // TC_mapNavigationOrAttributeCallExp_Helper
