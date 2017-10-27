/**
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * ;All rights reserved. This program and the accompanying materials
 * ;are made available under the terms of the Eclipse Public License v1.0
 * ;which accompanies this distribution, and is available at
 * ;http://www.eclipse.org/legal/epl-v10.html
 * ;
 * ;Contributors:
 * ;  E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr;

import org.eclipse.m2m.atl.common.ATL.Module;

import org.eclipse.m2m.atl.common.OCL.Attribute;
import org.eclipse.m2m.atl.common.OCL.OclExpression;
import org.eclipse.m2m.atl.common.OCL.OclFeatureDefinition;
import org.eclipse.m2m.atl.common.OCL.OclType;

import org.eclipse.ocl.pivot.OCLExpression;

import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TC map Helper Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapHelper_Attribute#getAtl_atlDefinition <em>Atl atl Definition</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapHelper_Attribute#getAtl_atlExpression <em>Atl atl Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapHelper_Attribute#getAtl_atlFeature <em>Atl atl Feature</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapHelper_Attribute#getAtl_atlModule <em>Atl atl Module</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapHelper_Attribute#getAtl_atlType <em>Atl atl Type</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapHelper_Attribute#getInvocation_mapHelper_Context <em>Invocation map Helper Context</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapHelper_Attribute#getPrimitive_attributeName <em>Primitive attribute Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapHelper_Attribute#getQvtr_qvtrExpression <em>Qvtr qvtr Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapHelper_Attribute#getQvtr_qvtrTransformation <em>Qvtr qvtr Transformation</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTC_mapHelper_Attribute()
 * @model
 * @generated
 */
public interface TC_mapHelper_Attribute extends TI_mapHelper_Attribute {
	/**
	 * Returns the value of the '<em><b>Atl atl Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Atl atl Definition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Atl atl Definition</em>' reference.
	 * @see #setAtl_atlDefinition(OclFeatureDefinition)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTC_mapHelper_Attribute_Atl_atlDefinition()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='TC_mapHelper_Attribute'"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='atl'"
	 * @generated
	 */
	OclFeatureDefinition getAtl_atlDefinition();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapHelper_Attribute#getAtl_atlDefinition <em>Atl atl Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Atl atl Definition</em>' reference.
	 * @see #getAtl_atlDefinition()
	 * @generated
	 */
	void setAtl_atlDefinition(OclFeatureDefinition value);

	/**
	 * Returns the value of the '<em><b>Atl atl Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Atl atl Expression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Atl atl Expression</em>' reference.
	 * @see #setAtl_atlExpression(OclExpression)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTC_mapHelper_Attribute_Atl_atlExpression()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='TC_mapHelper_Attribute'"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='atl'"
	 * @generated
	 */
	OclExpression getAtl_atlExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapHelper_Attribute#getAtl_atlExpression <em>Atl atl Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Atl atl Expression</em>' reference.
	 * @see #getAtl_atlExpression()
	 * @generated
	 */
	void setAtl_atlExpression(OclExpression value);

	/**
	 * Returns the value of the '<em><b>Atl atl Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Atl atl Feature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Atl atl Feature</em>' reference.
	 * @see #setAtl_atlFeature(Attribute)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTC_mapHelper_Attribute_Atl_atlFeature()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='TC_mapHelper_Attribute'"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='atl'"
	 * @generated
	 */
	Attribute getAtl_atlFeature();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapHelper_Attribute#getAtl_atlFeature <em>Atl atl Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Atl atl Feature</em>' reference.
	 * @see #getAtl_atlFeature()
	 * @generated
	 */
	void setAtl_atlFeature(Attribute value);

	/**
	 * Returns the value of the '<em><b>Atl atl Module</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Atl atl Module</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Atl atl Module</em>' reference.
	 * @see #setAtl_atlModule(Module)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTC_mapHelper_Attribute_Atl_atlModule()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='atl'"
	 * @generated
	 */
	Module getAtl_atlModule();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapHelper_Attribute#getAtl_atlModule <em>Atl atl Module</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Atl atl Module</em>' reference.
	 * @see #getAtl_atlModule()
	 * @generated
	 */
	void setAtl_atlModule(Module value);

	/**
	 * Returns the value of the '<em><b>Atl atl Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Atl atl Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Atl atl Type</em>' reference.
	 * @see #setAtl_atlType(OclType)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTC_mapHelper_Attribute_Atl_atlType()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='TC_mapHelper_Attribute'"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='atl'"
	 * @generated
	 */
	OclType getAtl_atlType();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapHelper_Attribute#getAtl_atlType <em>Atl atl Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Atl atl Type</em>' reference.
	 * @see #getAtl_atlType()
	 * @generated
	 */
	void setAtl_atlType(OclType value);

	/**
	 * Returns the value of the '<em><b>Invocation map Helper Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Invocation map Helper Context</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Invocation map Helper Context</em>' containment reference.
	 * @see #setInvocation_mapHelper_Context(TC_mapHelper_Context)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTC_mapHelper_Attribute_Invocation_mapHelper_Context()
	 * @model containment="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='TC_mapHelper_Attribute' unique='false' upper='*'"
	 * @generated
	 */
	TC_mapHelper_Context getInvocation_mapHelper_Context();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapHelper_Attribute#getInvocation_mapHelper_Context <em>Invocation map Helper Context</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Invocation map Helper Context</em>' containment reference.
	 * @see #getInvocation_mapHelper_Context()
	 * @generated
	 */
	void setInvocation_mapHelper_Context(TC_mapHelper_Context value);

	/**
	 * Returns the value of the '<em><b>Primitive attribute Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primitive attribute Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primitive attribute Name</em>' attribute.
	 * @see #setPrimitive_attributeName(String)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTC_mapHelper_Attribute_Primitive_attributeName()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='$primitive$'"
	 * @generated
	 */
	String getPrimitive_attributeName();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapHelper_Attribute#getPrimitive_attributeName <em>Primitive attribute Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primitive attribute Name</em>' attribute.
	 * @see #getPrimitive_attributeName()
	 * @generated
	 */
	void setPrimitive_attributeName(String value);

	/**
	 * Returns the value of the '<em><b>Qvtr qvtr Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qvtr qvtr Expression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qvtr qvtr Expression</em>' reference.
	 * @see #setQvtr_qvtrExpression(OCLExpression)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTC_mapHelper_Attribute_Qvtr_qvtrExpression()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='TC_mapHelper_Attribute'"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='qvtr'"
	 * @generated
	 */
	OCLExpression getQvtr_qvtrExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapHelper_Attribute#getQvtr_qvtrExpression <em>Qvtr qvtr Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qvtr qvtr Expression</em>' reference.
	 * @see #getQvtr_qvtrExpression()
	 * @generated
	 */
	void setQvtr_qvtrExpression(OCLExpression value);

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
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTC_mapHelper_Attribute_Qvtr_qvtrTransformation()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='qvtr'"
	 * @generated
	 */
	RelationalTransformation getQvtr_qvtrTransformation();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapHelper_Attribute#getQvtr_qvtrTransformation <em>Qvtr qvtr Transformation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qvtr qvtr Transformation</em>' reference.
	 * @see #getQvtr_qvtrTransformation()
	 * @generated
	 */
	void setQvtr_qvtrTransformation(RelationalTransformation value);

} // TC_mapHelper_Attribute