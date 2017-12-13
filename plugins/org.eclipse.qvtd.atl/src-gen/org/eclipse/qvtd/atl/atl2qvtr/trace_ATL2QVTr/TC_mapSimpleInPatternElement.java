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

import org.eclipse.emf.ecore.EObject;

import org.eclipse.m2m.atl.common.ATL.InPattern;
import org.eclipse.m2m.atl.common.ATL.MatchedRule;
import org.eclipse.m2m.atl.common.ATL.SimpleInPatternElement;

import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.TemplateVariable;

import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TC map Simple In Pattern Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapSimpleInPatternElement#getAtl_atlElement <em>Atl atl Element</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapSimpleInPatternElement#getAtl_atlPattern <em>Atl atl Pattern</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapSimpleInPatternElement#getAtl_atlRule <em>Atl atl Rule</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapSimpleInPatternElement#getInvocation_mapVariable <em>Invocation map Variable</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapSimpleInPatternElement#getPrimitive_elementName <em>Primitive element Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapSimpleInPatternElement#getQvtr_qvtrDomain <em>Qvtr qvtr Domain</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapSimpleInPatternElement#getQvtr_qvtrDomain1 <em>Qvtr qvtr Domain1</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapSimpleInPatternElement#getQvtr_qvtrPattern <em>Qvtr qvtr Pattern</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapSimpleInPatternElement#getQvtr_qvtrRelation <em>Qvtr qvtr Relation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapSimpleInPatternElement#getQvtr_qvtrTemplate <em>Qvtr qvtr Template</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapSimpleInPatternElement#getQvtr_qvtrVariable <em>Qvtr qvtr Variable</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTC_mapSimpleInPatternElement()
 * @model
 * @generated
 */
public interface TC_mapSimpleInPatternElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Atl atl Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Atl atl Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Atl atl Element</em>' reference.
	 * @see #setAtl_atlElement(SimpleInPatternElement)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTC_mapSimpleInPatternElement_Atl_atlElement()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='TC_mapSimpleInPatternElement'"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='atl'"
	 * @generated
	 */
	SimpleInPatternElement getAtl_atlElement();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapSimpleInPatternElement#getAtl_atlElement <em>Atl atl Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Atl atl Element</em>' reference.
	 * @see #getAtl_atlElement()
	 * @generated
	 */
	void setAtl_atlElement(SimpleInPatternElement value);

	/**
	 * Returns the value of the '<em><b>Atl atl Pattern</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Atl atl Pattern</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Atl atl Pattern</em>' reference.
	 * @see #setAtl_atlPattern(InPattern)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTC_mapSimpleInPatternElement_Atl_atlPattern()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='atl'"
	 * @generated
	 */
	InPattern getAtl_atlPattern();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapSimpleInPatternElement#getAtl_atlPattern <em>Atl atl Pattern</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Atl atl Pattern</em>' reference.
	 * @see #getAtl_atlPattern()
	 * @generated
	 */
	void setAtl_atlPattern(InPattern value);

	/**
	 * Returns the value of the '<em><b>Atl atl Rule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Atl atl Rule</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Atl atl Rule</em>' reference.
	 * @see #setAtl_atlRule(MatchedRule)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTC_mapSimpleInPatternElement_Atl_atlRule()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='TC_mapSimpleInPatternElement'"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='atl'"
	 * @generated
	 */
	MatchedRule getAtl_atlRule();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapSimpleInPatternElement#getAtl_atlRule <em>Atl atl Rule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Atl atl Rule</em>' reference.
	 * @see #getAtl_atlRule()
	 * @generated
	 */
	void setAtl_atlRule(MatchedRule value);

	/**
	 * Returns the value of the '<em><b>Invocation map Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Invocation map Variable</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Invocation map Variable</em>' containment reference.
	 * @see #setInvocation_mapVariable(TC_mapVariable)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTC_mapSimpleInPatternElement_Invocation_mapVariable()
	 * @model containment="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='TC_mapSimpleInPatternElement' unique='false' upper='*'"
	 * @generated
	 */
	TC_mapVariable getInvocation_mapVariable();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapSimpleInPatternElement#getInvocation_mapVariable <em>Invocation map Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Invocation map Variable</em>' containment reference.
	 * @see #getInvocation_mapVariable()
	 * @generated
	 */
	void setInvocation_mapVariable(TC_mapVariable value);

	/**
	 * Returns the value of the '<em><b>Primitive element Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primitive element Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primitive element Name</em>' attribute.
	 * @see #setPrimitive_elementName(String)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTC_mapSimpleInPatternElement_Primitive_elementName()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='$primitive$'"
	 * @generated
	 */
	String getPrimitive_elementName();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapSimpleInPatternElement#getPrimitive_elementName <em>Primitive element Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primitive element Name</em>' attribute.
	 * @see #getPrimitive_elementName()
	 * @generated
	 */
	void setPrimitive_elementName(String value);

	/**
	 * Returns the value of the '<em><b>Qvtr qvtr Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qvtr qvtr Domain</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qvtr qvtr Domain</em>' reference.
	 * @see #setQvtr_qvtrDomain(RelationDomain)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTC_mapSimpleInPatternElement_Qvtr_qvtrDomain()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='qvtr'"
	 * @generated
	 */
	RelationDomain getQvtr_qvtrDomain();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapSimpleInPatternElement#getQvtr_qvtrDomain <em>Qvtr qvtr Domain</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qvtr qvtr Domain</em>' reference.
	 * @see #getQvtr_qvtrDomain()
	 * @generated
	 */
	void setQvtr_qvtrDomain(RelationDomain value);

	/**
	 * Returns the value of the '<em><b>Qvtr qvtr Domain1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qvtr qvtr Domain1</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qvtr qvtr Domain1</em>' reference.
	 * @see #setQvtr_qvtrDomain1(RelationDomain)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTC_mapSimpleInPatternElement_Qvtr_qvtrDomain1()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='qvtr'"
	 * @generated
	 */
	RelationDomain getQvtr_qvtrDomain1();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapSimpleInPatternElement#getQvtr_qvtrDomain1 <em>Qvtr qvtr Domain1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qvtr qvtr Domain1</em>' reference.
	 * @see #getQvtr_qvtrDomain1()
	 * @generated
	 */
	void setQvtr_qvtrDomain1(RelationDomain value);

	/**
	 * Returns the value of the '<em><b>Qvtr qvtr Pattern</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qvtr qvtr Pattern</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qvtr qvtr Pattern</em>' reference.
	 * @see #setQvtr_qvtrPattern(DomainPattern)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTC_mapSimpleInPatternElement_Qvtr_qvtrPattern()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='qvtr'"
	 * @generated
	 */
	DomainPattern getQvtr_qvtrPattern();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapSimpleInPatternElement#getQvtr_qvtrPattern <em>Qvtr qvtr Pattern</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qvtr qvtr Pattern</em>' reference.
	 * @see #getQvtr_qvtrPattern()
	 * @generated
	 */
	void setQvtr_qvtrPattern(DomainPattern value);

	/**
	 * Returns the value of the '<em><b>Qvtr qvtr Relation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qvtr qvtr Relation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qvtr qvtr Relation</em>' reference.
	 * @see #setQvtr_qvtrRelation(Relation)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTC_mapSimpleInPatternElement_Qvtr_qvtrRelation()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='qvtr'"
	 * @generated
	 */
	Relation getQvtr_qvtrRelation();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapSimpleInPatternElement#getQvtr_qvtrRelation <em>Qvtr qvtr Relation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qvtr qvtr Relation</em>' reference.
	 * @see #getQvtr_qvtrRelation()
	 * @generated
	 */
	void setQvtr_qvtrRelation(Relation value);

	/**
	 * Returns the value of the '<em><b>Qvtr qvtr Template</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qvtr qvtr Template</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qvtr qvtr Template</em>' reference.
	 * @see #setQvtr_qvtrTemplate(ObjectTemplateExp)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTC_mapSimpleInPatternElement_Qvtr_qvtrTemplate()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='TC_mapSimpleInPatternElement'"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='qvtr'"
	 * @generated
	 */
	ObjectTemplateExp getQvtr_qvtrTemplate();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapSimpleInPatternElement#getQvtr_qvtrTemplate <em>Qvtr qvtr Template</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qvtr qvtr Template</em>' reference.
	 * @see #getQvtr_qvtrTemplate()
	 * @generated
	 */
	void setQvtr_qvtrTemplate(ObjectTemplateExp value);

	/**
	 * Returns the value of the '<em><b>Qvtr qvtr Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qvtr qvtr Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qvtr qvtr Variable</em>' reference.
	 * @see #setQvtr_qvtrVariable(TemplateVariable)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTC_mapSimpleInPatternElement_Qvtr_qvtrVariable()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='TC_mapSimpleInPatternElement'"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='qvtr'"
	 * @generated
	 */
	TemplateVariable getQvtr_qvtrVariable();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapSimpleInPatternElement#getQvtr_qvtrVariable <em>Qvtr qvtr Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qvtr qvtr Variable</em>' reference.
	 * @see #getQvtr_qvtrVariable()
	 * @generated
	 */
	void setQvtr_qvtrVariable(TemplateVariable value);

} // TC_mapSimpleInPatternElement
