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

import org.eclipse.m2m.atl.common.ATL.InPattern;
import org.eclipse.m2m.atl.common.ATL.MatchedRule;
import org.eclipse.m2m.atl.common.ATL.SimpleInPatternElement;

import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.TemplateVariable;

import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;

import org.eclipse.qvtd.runtime.qvttrace.Execution;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tmap Simple In Pattern Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getT0elementName <em>T0element Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getT1atlElement <em>T1atl Element</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getT1atlPattern <em>T1atl Pattern</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getT1atlRule <em>T1atl Rule</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getT2qvtrDomain <em>T2qvtr Domain</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getT2qvtrPattern <em>T2qvtr Pattern</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getT2qvtrRelation <em>T2qvtr Relation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getT2qvtrTemplate <em>T2qvtr Template</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getT2qvtrVariable <em>T2qvtr Variable</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getWmapInPattern <em>Wmap In Pattern</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getWmapMatchedRule <em>Wmap Matched Rule</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getWmapVariable <em>Wmap Variable</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapSimpleInPatternElement()
 * @model
 * @generated
 */
public interface TmapSimpleInPatternElement extends Execution {
	/**
	 * Returns the value of the '<em><b>T0element Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>T0element Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>T0element Name</em>' attribute.
	 * @see #setT0elementName(String)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapSimpleInPatternElement_T0elementName()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='$primitive$'"
	 * @generated
	 */
	String getT0elementName();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getT0elementName <em>T0element Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>T0element Name</em>' attribute.
	 * @see #getT0elementName()
	 * @generated
	 */
	void setT0elementName(String value);

	/**
	 * Returns the value of the '<em><b>T1atl Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>T1atl Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>T1atl Element</em>' reference.
	 * @see #setT1atlElement(SimpleInPatternElement)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapSimpleInPatternElement_T1atlElement()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='TmapSimpleInPatternElement'"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='atl'"
	 * @generated
	 */
	SimpleInPatternElement getT1atlElement();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getT1atlElement <em>T1atl Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>T1atl Element</em>' reference.
	 * @see #getT1atlElement()
	 * @generated
	 */
	void setT1atlElement(SimpleInPatternElement value);

	/**
	 * Returns the value of the '<em><b>T1atl Pattern</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>T1atl Pattern</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>T1atl Pattern</em>' reference.
	 * @see #setT1atlPattern(InPattern)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapSimpleInPatternElement_T1atlPattern()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='atl'"
	 * @generated
	 */
	InPattern getT1atlPattern();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getT1atlPattern <em>T1atl Pattern</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>T1atl Pattern</em>' reference.
	 * @see #getT1atlPattern()
	 * @generated
	 */
	void setT1atlPattern(InPattern value);

	/**
	 * Returns the value of the '<em><b>T1atl Rule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>T1atl Rule</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>T1atl Rule</em>' reference.
	 * @see #setT1atlRule(MatchedRule)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapSimpleInPatternElement_T1atlRule()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='atl'"
	 * @generated
	 */
	MatchedRule getT1atlRule();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getT1atlRule <em>T1atl Rule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>T1atl Rule</em>' reference.
	 * @see #getT1atlRule()
	 * @generated
	 */
	void setT1atlRule(MatchedRule value);

	/**
	 * Returns the value of the '<em><b>T2qvtr Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>T2qvtr Domain</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>T2qvtr Domain</em>' reference.
	 * @see #setT2qvtrDomain(RelationDomain)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapSimpleInPatternElement_T2qvtrDomain()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='qvtr'"
	 * @generated
	 */
	RelationDomain getT2qvtrDomain();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getT2qvtrDomain <em>T2qvtr Domain</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>T2qvtr Domain</em>' reference.
	 * @see #getT2qvtrDomain()
	 * @generated
	 */
	void setT2qvtrDomain(RelationDomain value);

	/**
	 * Returns the value of the '<em><b>T2qvtr Pattern</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>T2qvtr Pattern</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>T2qvtr Pattern</em>' reference.
	 * @see #setT2qvtrPattern(DomainPattern)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapSimpleInPatternElement_T2qvtrPattern()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='qvtr'"
	 * @generated
	 */
	DomainPattern getT2qvtrPattern();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getT2qvtrPattern <em>T2qvtr Pattern</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>T2qvtr Pattern</em>' reference.
	 * @see #getT2qvtrPattern()
	 * @generated
	 */
	void setT2qvtrPattern(DomainPattern value);

	/**
	 * Returns the value of the '<em><b>T2qvtr Relation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>T2qvtr Relation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>T2qvtr Relation</em>' reference.
	 * @see #setT2qvtrRelation(Relation)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapSimpleInPatternElement_T2qvtrRelation()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='qvtr'"
	 * @generated
	 */
	Relation getT2qvtrRelation();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getT2qvtrRelation <em>T2qvtr Relation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>T2qvtr Relation</em>' reference.
	 * @see #getT2qvtrRelation()
	 * @generated
	 */
	void setT2qvtrRelation(Relation value);

	/**
	 * Returns the value of the '<em><b>T2qvtr Template</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>T2qvtr Template</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>T2qvtr Template</em>' reference.
	 * @see #setT2qvtrTemplate(ObjectTemplateExp)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapSimpleInPatternElement_T2qvtrTemplate()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='TmapSimpleInPatternElement'"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='qvtr'"
	 * @generated
	 */
	ObjectTemplateExp getT2qvtrTemplate();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getT2qvtrTemplate <em>T2qvtr Template</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>T2qvtr Template</em>' reference.
	 * @see #getT2qvtrTemplate()
	 * @generated
	 */
	void setT2qvtrTemplate(ObjectTemplateExp value);

	/**
	 * Returns the value of the '<em><b>T2qvtr Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>T2qvtr Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>T2qvtr Variable</em>' reference.
	 * @see #setT2qvtrVariable(TemplateVariable)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapSimpleInPatternElement_T2qvtrVariable()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='qvtr'"
	 * @generated
	 */
	TemplateVariable getT2qvtrVariable();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getT2qvtrVariable <em>T2qvtr Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>T2qvtr Variable</em>' reference.
	 * @see #getT2qvtrVariable()
	 * @generated
	 */
	void setT2qvtrVariable(TemplateVariable value);

	/**
	 * Returns the value of the '<em><b>Wmap In Pattern</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wmap In Pattern</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wmap In Pattern</em>' reference.
	 * @see #setWmapInPattern(TmapInPattern)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapSimpleInPatternElement_WmapInPattern()
	 * @model
	 * @generated
	 */
	TmapInPattern getWmapInPattern();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getWmapInPattern <em>Wmap In Pattern</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wmap In Pattern</em>' reference.
	 * @see #getWmapInPattern()
	 * @generated
	 */
	void setWmapInPattern(TmapInPattern value);

	/**
	 * Returns the value of the '<em><b>Wmap Matched Rule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wmap Matched Rule</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wmap Matched Rule</em>' reference.
	 * @see #setWmapMatchedRule(TmapMatchedRule)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapSimpleInPatternElement_WmapMatchedRule()
	 * @model
	 * @generated
	 */
	TmapMatchedRule getWmapMatchedRule();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getWmapMatchedRule <em>Wmap Matched Rule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wmap Matched Rule</em>' reference.
	 * @see #getWmapMatchedRule()
	 * @generated
	 */
	void setWmapMatchedRule(TmapMatchedRule value);

	/**
	 * Returns the value of the '<em><b>Wmap Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wmap Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wmap Variable</em>' reference.
	 * @see #setWmapVariable(TmapVariable)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapSimpleInPatternElement_WmapVariable()
	 * @model
	 * @generated
	 */
	TmapVariable getWmapVariable();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getWmapVariable <em>Wmap Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wmap Variable</em>' reference.
	 * @see #getWmapVariable()
	 * @generated
	 */
	void setWmapVariable(TmapVariable value);

} // TmapSimpleInPatternElement
