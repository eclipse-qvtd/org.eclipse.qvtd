/**
 * Copyright (c) 2015, 2019 Willink Transformations and others.
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

import org.eclipse.m2m.atl.common.ATL.InPattern;
import org.eclipse.m2m.atl.common.ATL.MatchedRule;
import org.eclipse.m2m.atl.common.ATL.SimpleInPatternElement;

import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement;
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
 * An implementation of the model object '<em><b>Tmap Simple In Pattern Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapSimpleInPatternElementImpl#getS0global <em>S0global</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapSimpleInPatternElementImpl#getT1elementName <em>T1element Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapSimpleInPatternElementImpl#getT3atlElement <em>T3atl Element</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapSimpleInPatternElementImpl#getT3atlPattern <em>T3atl Pattern</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapSimpleInPatternElementImpl#getT3atlRule <em>T3atl Rule</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapSimpleInPatternElementImpl#getT4qvtrDomain <em>T4qvtr Domain</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapSimpleInPatternElementImpl#getT4qvtrPattern <em>T4qvtr Pattern</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapSimpleInPatternElementImpl#getT4qvtrRelation <em>T4qvtr Relation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapSimpleInPatternElementImpl#getT4qvtrTemplate <em>T4qvtr Template</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapSimpleInPatternElementImpl#getT4qvtrVariable <em>T4qvtr Variable</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapSimpleInPatternElementImpl#getWmapInPattern <em>Wmap In Pattern</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapSimpleInPatternElementImpl#getWmapMatchedRule <em>Wmap Matched Rule</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapSimpleInPatternElementImpl#getWmapVariable <em>Wmap Variable</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TmapSimpleInPatternElementImpl extends ExecutionImpl implements TmapSimpleInPatternElement {
	/**
	 * The number of structural features of the '<em>Tmap Simple In Pattern Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TMAP_SIMPLE_IN_PATTERN_ELEMENT_FEATURE_COUNT = ExecutionImpl.EXECUTION_FEATURE_COUNT + 13;

	/**
	 * The number of operations of the '<em>Tmap Simple In Pattern Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TMAP_SIMPLE_IN_PATTERN_ELEMENT_OPERATION_COUNT = ExecutionImpl.EXECUTION_OPERATION_COUNT + 0;


	/**
	 * The default value of the '{@link #getS0global() <em>S0global</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getS0global()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean S0GLOBAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getS0global() <em>S0global</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getS0global()
	 * @generated
	 * @ordered
	 */
	protected Boolean s0global = S0GLOBAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getT1elementName() <em>T1element Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT1elementName()
	 * @generated
	 * @ordered
	 */
	protected static final String T1ELEMENT_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getT1elementName() <em>T1element Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT1elementName()
	 * @generated
	 * @ordered
	 */
	protected String t1elementName = T1ELEMENT_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getT3atlElement() <em>T3atl Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT3atlElement()
	 * @generated
	 * @ordered
	 */
	protected SimpleInPatternElement t3atlElement;

	/**
	 * The cached value of the '{@link #getT3atlPattern() <em>T3atl Pattern</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT3atlPattern()
	 * @generated
	 * @ordered
	 */
	protected InPattern t3atlPattern;

	/**
	 * The cached value of the '{@link #getT3atlRule() <em>T3atl Rule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT3atlRule()
	 * @generated
	 * @ordered
	 */
	protected MatchedRule t3atlRule;

	/**
	 * The cached value of the '{@link #getT4qvtrDomain() <em>T4qvtr Domain</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT4qvtrDomain()
	 * @generated
	 * @ordered
	 */
	protected RelationDomain t4qvtrDomain;

	/**
	 * The cached value of the '{@link #getT4qvtrPattern() <em>T4qvtr Pattern</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT4qvtrPattern()
	 * @generated
	 * @ordered
	 */
	protected DomainPattern t4qvtrPattern;

	/**
	 * The cached value of the '{@link #getT4qvtrRelation() <em>T4qvtr Relation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT4qvtrRelation()
	 * @generated
	 * @ordered
	 */
	protected Relation t4qvtrRelation;

	/**
	 * The cached value of the '{@link #getT4qvtrTemplate() <em>T4qvtr Template</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT4qvtrTemplate()
	 * @generated
	 * @ordered
	 */
	protected ObjectTemplateExp t4qvtrTemplate;

	/**
	 * The cached value of the '{@link #getT4qvtrVariable() <em>T4qvtr Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT4qvtrVariable()
	 * @generated
	 * @ordered
	 */
	protected TemplateVariable t4qvtrVariable;

	/**
	 * The cached value of the '{@link #getWmapInPattern() <em>Wmap In Pattern</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWmapInPattern()
	 * @generated
	 * @ordered
	 */
	protected TmapInPattern wmapInPattern;

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
	protected TmapSimpleInPatternElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return trace_ATL2QVTrPackage.Literals.TMAP_SIMPLE_IN_PATTERN_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Boolean getS0global() {
		return s0global;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setS0global(Boolean newS0global) {
		Boolean oldS0global = s0global;
		s0global = newS0global;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 0, oldS0global, s0global));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getT1elementName() {
		return t1elementName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT1elementName(String newT1elementName) {
		String oldT1elementName = t1elementName;
		t1elementName = newT1elementName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1, oldT1elementName, t1elementName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SimpleInPatternElement getT3atlElement() {
		if (t3atlElement != null && t3atlElement.eIsProxy()) {
			InternalEObject oldT3atlElement = t3atlElement;
			t3atlElement = (SimpleInPatternElement)eResolveProxy(oldT3atlElement);
			if (t3atlElement != oldT3atlElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 2, oldT3atlElement, t3atlElement));
			}
		}
		return t3atlElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleInPatternElement basicGetT3atlElement() {
		return t3atlElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT3atlElement(SimpleInPatternElement newT3atlElement) {
		SimpleInPatternElement oldT3atlElement = t3atlElement;
		t3atlElement = newT3atlElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 2, oldT3atlElement, t3atlElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public InPattern getT3atlPattern() {
		if (t3atlPattern != null && t3atlPattern.eIsProxy()) {
			InternalEObject oldT3atlPattern = t3atlPattern;
			t3atlPattern = (InPattern)eResolveProxy(oldT3atlPattern);
			if (t3atlPattern != oldT3atlPattern) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 3, oldT3atlPattern, t3atlPattern));
			}
		}
		return t3atlPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InPattern basicGetT3atlPattern() {
		return t3atlPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT3atlPattern(InPattern newT3atlPattern) {
		InPattern oldT3atlPattern = t3atlPattern;
		t3atlPattern = newT3atlPattern;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 3, oldT3atlPattern, t3atlPattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MatchedRule getT3atlRule() {
		if (t3atlRule != null && t3atlRule.eIsProxy()) {
			InternalEObject oldT3atlRule = t3atlRule;
			t3atlRule = (MatchedRule)eResolveProxy(oldT3atlRule);
			if (t3atlRule != oldT3atlRule) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 4, oldT3atlRule, t3atlRule));
			}
		}
		return t3atlRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MatchedRule basicGetT3atlRule() {
		return t3atlRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT3atlRule(MatchedRule newT3atlRule) {
		MatchedRule oldT3atlRule = t3atlRule;
		t3atlRule = newT3atlRule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 4, oldT3atlRule, t3atlRule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RelationDomain getT4qvtrDomain() {
		if (t4qvtrDomain != null && t4qvtrDomain.eIsProxy()) {
			InternalEObject oldT4qvtrDomain = (InternalEObject)t4qvtrDomain;
			t4qvtrDomain = (RelationDomain)eResolveProxy(oldT4qvtrDomain);
			if (t4qvtrDomain != oldT4qvtrDomain) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 5, oldT4qvtrDomain, t4qvtrDomain));
			}
		}
		return t4qvtrDomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationDomain basicGetT4qvtrDomain() {
		return t4qvtrDomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT4qvtrDomain(RelationDomain newT4qvtrDomain) {
		RelationDomain oldT4qvtrDomain = t4qvtrDomain;
		t4qvtrDomain = newT4qvtrDomain;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 5, oldT4qvtrDomain, t4qvtrDomain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DomainPattern getT4qvtrPattern() {
		if (t4qvtrPattern != null && t4qvtrPattern.eIsProxy()) {
			InternalEObject oldT4qvtrPattern = (InternalEObject)t4qvtrPattern;
			t4qvtrPattern = (DomainPattern)eResolveProxy(oldT4qvtrPattern);
			if (t4qvtrPattern != oldT4qvtrPattern) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 6, oldT4qvtrPattern, t4qvtrPattern));
			}
		}
		return t4qvtrPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DomainPattern basicGetT4qvtrPattern() {
		return t4qvtrPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT4qvtrPattern(DomainPattern newT4qvtrPattern) {
		DomainPattern oldT4qvtrPattern = t4qvtrPattern;
		t4qvtrPattern = newT4qvtrPattern;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 6, oldT4qvtrPattern, t4qvtrPattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Relation getT4qvtrRelation() {
		if (t4qvtrRelation != null && t4qvtrRelation.eIsProxy()) {
			InternalEObject oldT4qvtrRelation = (InternalEObject)t4qvtrRelation;
			t4qvtrRelation = (Relation)eResolveProxy(oldT4qvtrRelation);
			if (t4qvtrRelation != oldT4qvtrRelation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 7, oldT4qvtrRelation, t4qvtrRelation));
			}
		}
		return t4qvtrRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Relation basicGetT4qvtrRelation() {
		return t4qvtrRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT4qvtrRelation(Relation newT4qvtrRelation) {
		Relation oldT4qvtrRelation = t4qvtrRelation;
		t4qvtrRelation = newT4qvtrRelation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 7, oldT4qvtrRelation, t4qvtrRelation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ObjectTemplateExp getT4qvtrTemplate() {
		if (t4qvtrTemplate != null && t4qvtrTemplate.eIsProxy()) {
			InternalEObject oldT4qvtrTemplate = (InternalEObject)t4qvtrTemplate;
			t4qvtrTemplate = (ObjectTemplateExp)eResolveProxy(oldT4qvtrTemplate);
			if (t4qvtrTemplate != oldT4qvtrTemplate) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 8, oldT4qvtrTemplate, t4qvtrTemplate));
			}
		}
		return t4qvtrTemplate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectTemplateExp basicGetT4qvtrTemplate() {
		return t4qvtrTemplate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT4qvtrTemplate(ObjectTemplateExp newT4qvtrTemplate) {
		ObjectTemplateExp oldT4qvtrTemplate = t4qvtrTemplate;
		t4qvtrTemplate = newT4qvtrTemplate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 8, oldT4qvtrTemplate, t4qvtrTemplate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TemplateVariable getT4qvtrVariable() {
		if (t4qvtrVariable != null && t4qvtrVariable.eIsProxy()) {
			InternalEObject oldT4qvtrVariable = (InternalEObject)t4qvtrVariable;
			t4qvtrVariable = (TemplateVariable)eResolveProxy(oldT4qvtrVariable);
			if (t4qvtrVariable != oldT4qvtrVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 9, oldT4qvtrVariable, t4qvtrVariable));
			}
		}
		return t4qvtrVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateVariable basicGetT4qvtrVariable() {
		return t4qvtrVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT4qvtrVariable(TemplateVariable newT4qvtrVariable) {
		TemplateVariable oldT4qvtrVariable = t4qvtrVariable;
		t4qvtrVariable = newT4qvtrVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 9, oldT4qvtrVariable, t4qvtrVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TmapInPattern getWmapInPattern() {
		if (wmapInPattern != null && wmapInPattern.eIsProxy()) {
			InternalEObject oldWmapInPattern = (InternalEObject)wmapInPattern;
			wmapInPattern = (TmapInPattern)eResolveProxy(oldWmapInPattern);
			if (wmapInPattern != oldWmapInPattern) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 10, oldWmapInPattern, wmapInPattern));
			}
		}
		return wmapInPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TmapInPattern basicGetWmapInPattern() {
		return wmapInPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWmapInPattern(TmapInPattern newWmapInPattern) {
		TmapInPattern oldWmapInPattern = wmapInPattern;
		wmapInPattern = newWmapInPattern;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 10, oldWmapInPattern, wmapInPattern));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 11, oldWmapMatchedRule, wmapMatchedRule));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 11, oldWmapMatchedRule, wmapMatchedRule));
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
				return getS0global();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 1:
				return getT1elementName();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 2:
				if (resolve) return getT3atlElement();
				return basicGetT3atlElement();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 3:
				if (resolve) return getT3atlPattern();
				return basicGetT3atlPattern();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 4:
				if (resolve) return getT3atlRule();
				return basicGetT3atlRule();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 5:
				if (resolve) return getT4qvtrDomain();
				return basicGetT4qvtrDomain();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 6:
				if (resolve) return getT4qvtrPattern();
				return basicGetT4qvtrPattern();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 7:
				if (resolve) return getT4qvtrRelation();
				return basicGetT4qvtrRelation();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 8:
				if (resolve) return getT4qvtrTemplate();
				return basicGetT4qvtrTemplate();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 9:
				if (resolve) return getT4qvtrVariable();
				return basicGetT4qvtrVariable();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 10:
				if (resolve) return getWmapInPattern();
				return basicGetWmapInPattern();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 11:
				if (resolve) return getWmapMatchedRule();
				return basicGetWmapMatchedRule();
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
				setS0global((Boolean)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 1:
				setT1elementName((String)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 2:
				setT3atlElement((SimpleInPatternElement)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 3:
				setT3atlPattern((InPattern)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 4:
				setT3atlRule((MatchedRule)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 5:
				setT4qvtrDomain((RelationDomain)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 6:
				setT4qvtrPattern((DomainPattern)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 7:
				setT4qvtrRelation((Relation)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 8:
				setT4qvtrTemplate((ObjectTemplateExp)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 9:
				setT4qvtrVariable((TemplateVariable)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 10:
				setWmapInPattern((TmapInPattern)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 11:
				setWmapMatchedRule((TmapMatchedRule)newValue);
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
				setS0global(S0GLOBAL_EDEFAULT);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 1:
				setT1elementName(T1ELEMENT_NAME_EDEFAULT);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 2:
				setT3atlElement((SimpleInPatternElement)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 3:
				setT3atlPattern((InPattern)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 4:
				setT3atlRule((MatchedRule)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 5:
				setT4qvtrDomain((RelationDomain)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 6:
				setT4qvtrPattern((DomainPattern)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 7:
				setT4qvtrRelation((Relation)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 8:
				setT4qvtrTemplate((ObjectTemplateExp)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 9:
				setT4qvtrVariable((TemplateVariable)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 10:
				setWmapInPattern((TmapInPattern)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 11:
				setWmapMatchedRule((TmapMatchedRule)null);
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
				return S0GLOBAL_EDEFAULT == null ? s0global != null : !S0GLOBAL_EDEFAULT.equals(s0global);
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 1:
				return T1ELEMENT_NAME_EDEFAULT == null ? t1elementName != null : !T1ELEMENT_NAME_EDEFAULT.equals(t1elementName);
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 2:
				return t3atlElement != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 3:
				return t3atlPattern != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 4:
				return t3atlRule != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 5:
				return t4qvtrDomain != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 6:
				return t4qvtrPattern != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 7:
				return t4qvtrRelation != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 8:
				return t4qvtrTemplate != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 9:
				return t4qvtrVariable != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 10:
				return wmapInPattern != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 11:
				return wmapMatchedRule != null;
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
		result.append(" (s0global: ");
		result.append(s0global);
		result.append(", t1elementName: ");
		result.append(t1elementName);
		result.append(')');
		return result.toString();
	}


} //TmapSimpleInPatternElementImpl
