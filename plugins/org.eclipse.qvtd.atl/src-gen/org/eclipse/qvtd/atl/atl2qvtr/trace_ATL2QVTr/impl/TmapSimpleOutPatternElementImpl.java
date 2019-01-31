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
package org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.m2m.atl.common.ATL.MatchedRule;
import org.eclipse.m2m.atl.common.ATL.OutPattern;
import org.eclipse.m2m.atl.common.ATL.SimpleOutPatternElement;

import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOutPattern;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariable;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage;

import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.TemplateVariable;

import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;

import org.eclipse.qvtd.runtime.qvttrace.impl.ExecutionImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tmap Simple Out Pattern Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapSimpleOutPatternElementImpl#getSuccess <em>Success</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapSimpleOutPatternElementImpl#getT0elementName <em>T0element Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapSimpleOutPatternElementImpl#getT1atlElement <em>T1atl Element</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapSimpleOutPatternElementImpl#getT1atlPattern <em>T1atl Pattern</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapSimpleOutPatternElementImpl#getT1atlRule <em>T1atl Rule</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapSimpleOutPatternElementImpl#getT2qvtrDomain <em>T2qvtr Domain</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapSimpleOutPatternElementImpl#getT2qvtrPattern <em>T2qvtr Pattern</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapSimpleOutPatternElementImpl#getT2qvtrRelation <em>T2qvtr Relation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapSimpleOutPatternElementImpl#getT2qvtrTemplate <em>T2qvtr Template</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapSimpleOutPatternElementImpl#getT2qvtrVariable <em>T2qvtr Variable</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapSimpleOutPatternElementImpl#getWmapMatchedRule <em>Wmap Matched Rule</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapSimpleOutPatternElementImpl#getWmapOutPattern <em>Wmap Out Pattern</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapSimpleOutPatternElementImpl#getWmapVariable <em>Wmap Variable</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TmapSimpleOutPatternElementImpl extends ExecutionImpl implements TmapSimpleOutPatternElement {
	/**
	 * The number of structural features of the '<em>Tmap Simple Out Pattern Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TMAP_SIMPLE_OUT_PATTERN_ELEMENT_FEATURE_COUNT = ExecutionImpl.EXECUTION_FEATURE_COUNT + 13;

	/**
	 * The number of operations of the '<em>Tmap Simple Out Pattern Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TMAP_SIMPLE_OUT_PATTERN_ELEMENT_OPERATION_COUNT = ExecutionImpl.EXECUTION_OPERATION_COUNT + 0;


	/**
	 * The default value of the '{@link #getSuccess() <em>Success</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuccess()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean SUCCESS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSuccess() <em>Success</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuccess()
	 * @generated
	 * @ordered
	 */
	protected Boolean success = SUCCESS_EDEFAULT;

	/**
	 * The default value of the '{@link #getT0elementName() <em>T0element Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT0elementName()
	 * @generated
	 * @ordered
	 */
	protected static final String T0ELEMENT_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getT0elementName() <em>T0element Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT0elementName()
	 * @generated
	 * @ordered
	 */
	protected String t0elementName = T0ELEMENT_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getT1atlElement() <em>T1atl Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT1atlElement()
	 * @generated
	 * @ordered
	 */
	protected SimpleOutPatternElement t1atlElement;

	/**
	 * The cached value of the '{@link #getT1atlPattern() <em>T1atl Pattern</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT1atlPattern()
	 * @generated
	 * @ordered
	 */
	protected OutPattern t1atlPattern;

	/**
	 * The cached value of the '{@link #getT1atlRule() <em>T1atl Rule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT1atlRule()
	 * @generated
	 * @ordered
	 */
	protected MatchedRule t1atlRule;

	/**
	 * The cached value of the '{@link #getT2qvtrDomain() <em>T2qvtr Domain</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT2qvtrDomain()
	 * @generated
	 * @ordered
	 */
	protected RelationDomain t2qvtrDomain;

	/**
	 * The cached value of the '{@link #getT2qvtrPattern() <em>T2qvtr Pattern</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT2qvtrPattern()
	 * @generated
	 * @ordered
	 */
	protected DomainPattern t2qvtrPattern;

	/**
	 * The cached value of the '{@link #getT2qvtrRelation() <em>T2qvtr Relation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT2qvtrRelation()
	 * @generated
	 * @ordered
	 */
	protected Relation t2qvtrRelation;

	/**
	 * The cached value of the '{@link #getT2qvtrTemplate() <em>T2qvtr Template</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT2qvtrTemplate()
	 * @generated
	 * @ordered
	 */
	protected ObjectTemplateExp t2qvtrTemplate;

	/**
	 * The cached value of the '{@link #getT2qvtrVariable() <em>T2qvtr Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT2qvtrVariable()
	 * @generated
	 * @ordered
	 */
	protected TemplateVariable t2qvtrVariable;

	/**
	 * The cached value of the '{@link #getWmapMatchedRule() <em>Wmap Matched Rule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWmapMatchedRule()
	 * @generated
	 * @ordered
	 */
	protected TmapMatchedRule wmapMatchedRule;

	/**
	 * The cached value of the '{@link #getWmapOutPattern() <em>Wmap Out Pattern</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWmapOutPattern()
	 * @generated
	 * @ordered
	 */
	protected TmapOutPattern wmapOutPattern;

	/**
	 * The cached value of the '{@link #getWmapVariable() <em>Wmap Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWmapVariable()
	 * @generated
	 * @ordered
	 */
	protected TmapVariable wmapVariable;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TmapSimpleOutPatternElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return trace_ATL2QVTrPackage.Literals.TMAP_SIMPLE_OUT_PATTERN_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Boolean getSuccess() {
		return success;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSuccess(Boolean newSuccess) {
		Boolean oldSuccess = success;
		success = newSuccess;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 0, oldSuccess, success));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getT0elementName() {
		return t0elementName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT0elementName(String newT0elementName) {
		String oldT0elementName = t0elementName;
		t0elementName = newT0elementName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1, oldT0elementName, t0elementName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SimpleOutPatternElement getT1atlElement() {
		if (t1atlElement != null && t1atlElement.eIsProxy()) {
			InternalEObject oldT1atlElement = t1atlElement;
			t1atlElement = (SimpleOutPatternElement)eResolveProxy(oldT1atlElement);
			if (t1atlElement != oldT1atlElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 2, oldT1atlElement, t1atlElement));
			}
		}
		return t1atlElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleOutPatternElement basicGetT1atlElement() {
		return t1atlElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT1atlElement(SimpleOutPatternElement newT1atlElement) {
		SimpleOutPatternElement oldT1atlElement = t1atlElement;
		t1atlElement = newT1atlElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 2, oldT1atlElement, t1atlElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OutPattern getT1atlPattern() {
		if (t1atlPattern != null && t1atlPattern.eIsProxy()) {
			InternalEObject oldT1atlPattern = t1atlPattern;
			t1atlPattern = (OutPattern)eResolveProxy(oldT1atlPattern);
			if (t1atlPattern != oldT1atlPattern) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 3, oldT1atlPattern, t1atlPattern));
			}
		}
		return t1atlPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutPattern basicGetT1atlPattern() {
		return t1atlPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT1atlPattern(OutPattern newT1atlPattern) {
		OutPattern oldT1atlPattern = t1atlPattern;
		t1atlPattern = newT1atlPattern;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 3, oldT1atlPattern, t1atlPattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MatchedRule getT1atlRule() {
		if (t1atlRule != null && t1atlRule.eIsProxy()) {
			InternalEObject oldT1atlRule = t1atlRule;
			t1atlRule = (MatchedRule)eResolveProxy(oldT1atlRule);
			if (t1atlRule != oldT1atlRule) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 4, oldT1atlRule, t1atlRule));
			}
		}
		return t1atlRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MatchedRule basicGetT1atlRule() {
		return t1atlRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT1atlRule(MatchedRule newT1atlRule) {
		MatchedRule oldT1atlRule = t1atlRule;
		t1atlRule = newT1atlRule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 4, oldT1atlRule, t1atlRule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RelationDomain getT2qvtrDomain() {
		if (t2qvtrDomain != null && t2qvtrDomain.eIsProxy()) {
			InternalEObject oldT2qvtrDomain = (InternalEObject)t2qvtrDomain;
			t2qvtrDomain = (RelationDomain)eResolveProxy(oldT2qvtrDomain);
			if (t2qvtrDomain != oldT2qvtrDomain) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 5, oldT2qvtrDomain, t2qvtrDomain));
			}
		}
		return t2qvtrDomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationDomain basicGetT2qvtrDomain() {
		return t2qvtrDomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT2qvtrDomain(RelationDomain newT2qvtrDomain) {
		RelationDomain oldT2qvtrDomain = t2qvtrDomain;
		t2qvtrDomain = newT2qvtrDomain;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 5, oldT2qvtrDomain, t2qvtrDomain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DomainPattern getT2qvtrPattern() {
		if (t2qvtrPattern != null && t2qvtrPattern.eIsProxy()) {
			InternalEObject oldT2qvtrPattern = (InternalEObject)t2qvtrPattern;
			t2qvtrPattern = (DomainPattern)eResolveProxy(oldT2qvtrPattern);
			if (t2qvtrPattern != oldT2qvtrPattern) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 6, oldT2qvtrPattern, t2qvtrPattern));
			}
		}
		return t2qvtrPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DomainPattern basicGetT2qvtrPattern() {
		return t2qvtrPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT2qvtrPattern(DomainPattern newT2qvtrPattern) {
		DomainPattern oldT2qvtrPattern = t2qvtrPattern;
		t2qvtrPattern = newT2qvtrPattern;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 6, oldT2qvtrPattern, t2qvtrPattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Relation getT2qvtrRelation() {
		if (t2qvtrRelation != null && t2qvtrRelation.eIsProxy()) {
			InternalEObject oldT2qvtrRelation = (InternalEObject)t2qvtrRelation;
			t2qvtrRelation = (Relation)eResolveProxy(oldT2qvtrRelation);
			if (t2qvtrRelation != oldT2qvtrRelation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 7, oldT2qvtrRelation, t2qvtrRelation));
			}
		}
		return t2qvtrRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Relation basicGetT2qvtrRelation() {
		return t2qvtrRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT2qvtrRelation(Relation newT2qvtrRelation) {
		Relation oldT2qvtrRelation = t2qvtrRelation;
		t2qvtrRelation = newT2qvtrRelation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 7, oldT2qvtrRelation, t2qvtrRelation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ObjectTemplateExp getT2qvtrTemplate() {
		if (t2qvtrTemplate != null && t2qvtrTemplate.eIsProxy()) {
			InternalEObject oldT2qvtrTemplate = (InternalEObject)t2qvtrTemplate;
			t2qvtrTemplate = (ObjectTemplateExp)eResolveProxy(oldT2qvtrTemplate);
			if (t2qvtrTemplate != oldT2qvtrTemplate) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 8, oldT2qvtrTemplate, t2qvtrTemplate));
			}
		}
		return t2qvtrTemplate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectTemplateExp basicGetT2qvtrTemplate() {
		return t2qvtrTemplate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT2qvtrTemplate(ObjectTemplateExp newT2qvtrTemplate) {
		ObjectTemplateExp oldT2qvtrTemplate = t2qvtrTemplate;
		t2qvtrTemplate = newT2qvtrTemplate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 8, oldT2qvtrTemplate, t2qvtrTemplate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TemplateVariable getT2qvtrVariable() {
		if (t2qvtrVariable != null && t2qvtrVariable.eIsProxy()) {
			InternalEObject oldT2qvtrVariable = (InternalEObject)t2qvtrVariable;
			t2qvtrVariable = (TemplateVariable)eResolveProxy(oldT2qvtrVariable);
			if (t2qvtrVariable != oldT2qvtrVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 9, oldT2qvtrVariable, t2qvtrVariable));
			}
		}
		return t2qvtrVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateVariable basicGetT2qvtrVariable() {
		return t2qvtrVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT2qvtrVariable(TemplateVariable newT2qvtrVariable) {
		TemplateVariable oldT2qvtrVariable = t2qvtrVariable;
		t2qvtrVariable = newT2qvtrVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 9, oldT2qvtrVariable, t2qvtrVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TmapMatchedRule getWmapMatchedRule() {
		if (wmapMatchedRule != null && wmapMatchedRule.eIsProxy()) {
			InternalEObject oldWmapMatchedRule = (InternalEObject)wmapMatchedRule;
			wmapMatchedRule = (TmapMatchedRule)eResolveProxy(oldWmapMatchedRule);
			if (wmapMatchedRule != oldWmapMatchedRule) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 10, oldWmapMatchedRule, wmapMatchedRule));
			}
		}
		return wmapMatchedRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TmapMatchedRule basicGetWmapMatchedRule() {
		return wmapMatchedRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWmapMatchedRule(TmapMatchedRule newWmapMatchedRule) {
		TmapMatchedRule oldWmapMatchedRule = wmapMatchedRule;
		wmapMatchedRule = newWmapMatchedRule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 10, oldWmapMatchedRule, wmapMatchedRule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TmapOutPattern getWmapOutPattern() {
		if (wmapOutPattern != null && wmapOutPattern.eIsProxy()) {
			InternalEObject oldWmapOutPattern = (InternalEObject)wmapOutPattern;
			wmapOutPattern = (TmapOutPattern)eResolveProxy(oldWmapOutPattern);
			if (wmapOutPattern != oldWmapOutPattern) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 11, oldWmapOutPattern, wmapOutPattern));
			}
		}
		return wmapOutPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TmapOutPattern basicGetWmapOutPattern() {
		return wmapOutPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWmapOutPattern(TmapOutPattern newWmapOutPattern) {
		TmapOutPattern oldWmapOutPattern = wmapOutPattern;
		wmapOutPattern = newWmapOutPattern;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 11, oldWmapOutPattern, wmapOutPattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TmapVariable getWmapVariable() {
		if (wmapVariable != null && wmapVariable.eIsProxy()) {
			InternalEObject oldWmapVariable = (InternalEObject)wmapVariable;
			wmapVariable = (TmapVariable)eResolveProxy(oldWmapVariable);
			if (wmapVariable != oldWmapVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 12, oldWmapVariable, wmapVariable));
			}
		}
		return wmapVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TmapVariable basicGetWmapVariable() {
		return wmapVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWmapVariable(TmapVariable newWmapVariable) {
		TmapVariable oldWmapVariable = wmapVariable;
		wmapVariable = newWmapVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 12, oldWmapVariable, wmapVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 0:
				return getSuccess();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 1:
				return getT0elementName();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 2:
				if (resolve) return getT1atlElement();
				return basicGetT1atlElement();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 3:
				if (resolve) return getT1atlPattern();
				return basicGetT1atlPattern();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 4:
				if (resolve) return getT1atlRule();
				return basicGetT1atlRule();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 5:
				if (resolve) return getT2qvtrDomain();
				return basicGetT2qvtrDomain();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 6:
				if (resolve) return getT2qvtrPattern();
				return basicGetT2qvtrPattern();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 7:
				if (resolve) return getT2qvtrRelation();
				return basicGetT2qvtrRelation();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 8:
				if (resolve) return getT2qvtrTemplate();
				return basicGetT2qvtrTemplate();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 9:
				if (resolve) return getT2qvtrVariable();
				return basicGetT2qvtrVariable();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 10:
				if (resolve) return getWmapMatchedRule();
				return basicGetWmapMatchedRule();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 11:
				if (resolve) return getWmapOutPattern();
				return basicGetWmapOutPattern();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 12:
				if (resolve) return getWmapVariable();
				return basicGetWmapVariable();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 0:
				setSuccess((Boolean)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 1:
				setT0elementName((String)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 2:
				setT1atlElement((SimpleOutPatternElement)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 3:
				setT1atlPattern((OutPattern)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 4:
				setT1atlRule((MatchedRule)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 5:
				setT2qvtrDomain((RelationDomain)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 6:
				setT2qvtrPattern((DomainPattern)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 7:
				setT2qvtrRelation((Relation)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 8:
				setT2qvtrTemplate((ObjectTemplateExp)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 9:
				setT2qvtrVariable((TemplateVariable)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 10:
				setWmapMatchedRule((TmapMatchedRule)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 11:
				setWmapOutPattern((TmapOutPattern)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 12:
				setWmapVariable((TmapVariable)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 0:
				setSuccess(SUCCESS_EDEFAULT);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 1:
				setT0elementName(T0ELEMENT_NAME_EDEFAULT);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 2:
				setT1atlElement((SimpleOutPatternElement)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 3:
				setT1atlPattern((OutPattern)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 4:
				setT1atlRule((MatchedRule)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 5:
				setT2qvtrDomain((RelationDomain)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 6:
				setT2qvtrPattern((DomainPattern)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 7:
				setT2qvtrRelation((Relation)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 8:
				setT2qvtrTemplate((ObjectTemplateExp)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 9:
				setT2qvtrVariable((TemplateVariable)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 10:
				setWmapMatchedRule((TmapMatchedRule)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 11:
				setWmapOutPattern((TmapOutPattern)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 12:
				setWmapVariable((TmapVariable)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 0:
				return SUCCESS_EDEFAULT == null ? success != null : !SUCCESS_EDEFAULT.equals(success);
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 1:
				return T0ELEMENT_NAME_EDEFAULT == null ? t0elementName != null : !T0ELEMENT_NAME_EDEFAULT.equals(t0elementName);
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 2:
				return t1atlElement != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 3:
				return t1atlPattern != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 4:
				return t1atlRule != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 5:
				return t2qvtrDomain != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 6:
				return t2qvtrPattern != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 7:
				return t2qvtrRelation != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 8:
				return t2qvtrTemplate != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 9:
				return t2qvtrVariable != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 10:
				return wmapMatchedRule != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 11:
				return wmapOutPattern != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 12:
				return wmapVariable != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (success: ");
		result.append(success);
		result.append(", t0elementName: ");
		result.append(t0elementName);
		result.append(')');
		return result.toString();
	}


} //TmapSimpleOutPatternElementImpl
