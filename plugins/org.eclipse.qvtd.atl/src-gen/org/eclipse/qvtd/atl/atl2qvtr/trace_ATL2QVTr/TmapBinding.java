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

import org.eclipse.m2m.atl.common.ATL.Binding;
import org.eclipse.m2m.atl.common.ATL.SimpleOutPatternElement;

import org.eclipse.m2m.atl.common.OCL.OclExpression;

import org.eclipse.ocl.pivot.OCLExpression;

import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;

import org.eclipse.qvtd.runtime.qvttrace.Execution;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tmap Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBinding#getT0propertyName <em>T0property Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBinding#getT1atlBinding <em>T1atl Binding</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBinding#getT1atlExpression <em>T1atl Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBinding#getT1atlOutPatternElement <em>T1atl Out Pattern Element</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBinding#getT2qvtrExpression <em>T2qvtr Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBinding#getT2qvtrPart <em>T2qvtr Part</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBinding#getT2qvtrTemplate <em>T2qvtr Template</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBinding#getWmapOclExpression <em>Wmap Ocl Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBinding#getWmapSimpleOutPatternElement <em>Wmap Simple Out Pattern Element</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapBinding()
 * @model
 * @generated
 */
public interface TmapBinding extends Execution {
	/**
	 * Returns the value of the '<em><b>T0property Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>T0property Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>T0property Name</em>' attribute.
	 * @see #setT0propertyName(String)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapBinding_T0propertyName()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='$primitive$'"
	 * @generated
	 */
	String getT0propertyName();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBinding#getT0propertyName <em>T0property Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>T0property Name</em>' attribute.
	 * @see #getT0propertyName()
	 * @generated
	 */
	void setT0propertyName(String value);

	/**
	 * Returns the value of the '<em><b>T1atl Binding</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>T1atl Binding</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>T1atl Binding</em>' reference.
	 * @see #setT1atlBinding(Binding)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapBinding_T1atlBinding()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='TmapBinding'"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='atl'"
	 * @generated
	 */
	Binding getT1atlBinding();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBinding#getT1atlBinding <em>T1atl Binding</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>T1atl Binding</em>' reference.
	 * @see #getT1atlBinding()
	 * @generated
	 */
	void setT1atlBinding(Binding value);

	/**
	 * Returns the value of the '<em><b>T1atl Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>T1atl Expression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>T1atl Expression</em>' reference.
	 * @see #setT1atlExpression(OclExpression)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapBinding_T1atlExpression()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='atl'"
	 * @generated
	 */
	OclExpression getT1atlExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBinding#getT1atlExpression <em>T1atl Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>T1atl Expression</em>' reference.
	 * @see #getT1atlExpression()
	 * @generated
	 */
	void setT1atlExpression(OclExpression value);

	/**
	 * Returns the value of the '<em><b>T1atl Out Pattern Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>T1atl Out Pattern Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>T1atl Out Pattern Element</em>' reference.
	 * @see #setT1atlOutPatternElement(SimpleOutPatternElement)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapBinding_T1atlOutPatternElement()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='atl'"
	 * @generated
	 */
	SimpleOutPatternElement getT1atlOutPatternElement();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBinding#getT1atlOutPatternElement <em>T1atl Out Pattern Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>T1atl Out Pattern Element</em>' reference.
	 * @see #getT1atlOutPatternElement()
	 * @generated
	 */
	void setT1atlOutPatternElement(SimpleOutPatternElement value);

	/**
	 * Returns the value of the '<em><b>T2qvtr Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>T2qvtr Expression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>T2qvtr Expression</em>' reference.
	 * @see #setT2qvtrExpression(OCLExpression)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapBinding_T2qvtrExpression()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='qvtr'"
	 * @generated
	 */
	OCLExpression getT2qvtrExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBinding#getT2qvtrExpression <em>T2qvtr Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>T2qvtr Expression</em>' reference.
	 * @see #getT2qvtrExpression()
	 * @generated
	 */
	void setT2qvtrExpression(OCLExpression value);

	/**
	 * Returns the value of the '<em><b>T2qvtr Part</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>T2qvtr Part</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>T2qvtr Part</em>' reference.
	 * @see #setT2qvtrPart(PropertyTemplateItem)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapBinding_T2qvtrPart()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='TmapBinding'"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='qvtr'"
	 * @generated
	 */
	PropertyTemplateItem getT2qvtrPart();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBinding#getT2qvtrPart <em>T2qvtr Part</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>T2qvtr Part</em>' reference.
	 * @see #getT2qvtrPart()
	 * @generated
	 */
	void setT2qvtrPart(PropertyTemplateItem value);

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
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapBinding_T2qvtrTemplate()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='qvtr'"
	 * @generated
	 */
	ObjectTemplateExp getT2qvtrTemplate();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBinding#getT2qvtrTemplate <em>T2qvtr Template</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>T2qvtr Template</em>' reference.
	 * @see #getT2qvtrTemplate()
	 * @generated
	 */
	void setT2qvtrTemplate(ObjectTemplateExp value);

	/**
	 * Returns the value of the '<em><b>Wmap Ocl Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wmap Ocl Expression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wmap Ocl Expression</em>' reference.
	 * @see #setWmapOclExpression(DmapOclExpression)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapBinding_WmapOclExpression()
	 * @model
	 * @generated
	 */
	DmapOclExpression getWmapOclExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBinding#getWmapOclExpression <em>Wmap Ocl Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wmap Ocl Expression</em>' reference.
	 * @see #getWmapOclExpression()
	 * @generated
	 */
	void setWmapOclExpression(DmapOclExpression value);

	/**
	 * Returns the value of the '<em><b>Wmap Simple Out Pattern Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wmap Simple Out Pattern Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wmap Simple Out Pattern Element</em>' reference.
	 * @see #setWmapSimpleOutPatternElement(TmapSimpleOutPatternElement)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapBinding_WmapSimpleOutPatternElement()
	 * @model
	 * @generated
	 */
	TmapSimpleOutPatternElement getWmapSimpleOutPatternElement();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBinding#getWmapSimpleOutPatternElement <em>Wmap Simple Out Pattern Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wmap Simple Out Pattern Element</em>' reference.
	 * @see #getWmapSimpleOutPatternElement()
	 * @generated
	 */
	void setWmapSimpleOutPatternElement(TmapSimpleOutPatternElement value);

} // TmapBinding
