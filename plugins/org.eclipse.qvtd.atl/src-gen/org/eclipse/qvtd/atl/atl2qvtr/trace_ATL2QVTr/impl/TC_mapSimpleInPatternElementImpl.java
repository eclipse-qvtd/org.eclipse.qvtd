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
package org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.m2m.atl.common.ATL.InPattern;
import org.eclipse.m2m.atl.common.ATL.MatchedRule;

import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapSimpleInPatternElement;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapVariable;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage;

import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.TemplateVariable;

import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TC map Simple In Pattern Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapSimpleInPatternElementImpl#getAtl_atlPattern <em>Atl atl Pattern</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapSimpleInPatternElementImpl#getAtl_atlRule <em>Atl atl Rule</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapSimpleInPatternElementImpl#getInvocation_mapVariable <em>Invocation map Variable</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapSimpleInPatternElementImpl#getPrimitive_elementName <em>Primitive element Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapSimpleInPatternElementImpl#getQvtr_qvtrDomain <em>Qvtr qvtr Domain</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapSimpleInPatternElementImpl#getQvtr_qvtrDomain1 <em>Qvtr qvtr Domain1</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapSimpleInPatternElementImpl#getQvtr_qvtrPattern <em>Qvtr qvtr Pattern</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapSimpleInPatternElementImpl#getQvtr_qvtrRelation <em>Qvtr qvtr Relation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapSimpleInPatternElementImpl#getQvtr_qvtrTemplate <em>Qvtr qvtr Template</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapSimpleInPatternElementImpl#getQvtr_qvtrVariable <em>Qvtr qvtr Variable</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TC_mapSimpleInPatternElementImpl extends TI_mapSimpleInPatternElementImpl implements TC_mapSimpleInPatternElement {
	/**
	 * The cached value of the '{@link #getAtl_atlPattern() <em>Atl atl Pattern</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtl_atlPattern()
	 * @generated
	 * @ordered
	 */
	protected InPattern atl_atlPattern;

	/**
	 * The cached value of the '{@link #getAtl_atlRule() <em>Atl atl Rule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtl_atlRule()
	 * @generated
	 * @ordered
	 */
	protected MatchedRule atl_atlRule;

	/**
	 * The cached value of the '{@link #getInvocation_mapVariable() <em>Invocation map Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInvocation_mapVariable()
	 * @generated
	 * @ordered
	 */
	protected TC_mapVariable invocation_mapVariable;

	/**
	 * The default value of the '{@link #getPrimitive_elementName() <em>Primitive element Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimitive_elementName()
	 * @generated
	 * @ordered
	 */
	protected static final String PRIMITIVE_ELEMENT_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPrimitive_elementName() <em>Primitive element Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimitive_elementName()
	 * @generated
	 * @ordered
	 */
	protected String primitive_elementName = PRIMITIVE_ELEMENT_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getQvtr_qvtrDomain() <em>Qvtr qvtr Domain</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQvtr_qvtrDomain()
	 * @generated
	 * @ordered
	 */
	protected RelationDomain qvtr_qvtrDomain;

	/**
	 * The cached value of the '{@link #getQvtr_qvtrDomain1() <em>Qvtr qvtr Domain1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQvtr_qvtrDomain1()
	 * @generated
	 * @ordered
	 */
	protected RelationDomain qvtr_qvtrDomain1;

	/**
	 * The cached value of the '{@link #getQvtr_qvtrPattern() <em>Qvtr qvtr Pattern</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQvtr_qvtrPattern()
	 * @generated
	 * @ordered
	 */
	protected DomainPattern qvtr_qvtrPattern;

	/**
	 * The cached value of the '{@link #getQvtr_qvtrRelation() <em>Qvtr qvtr Relation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQvtr_qvtrRelation()
	 * @generated
	 * @ordered
	 */
	protected Relation qvtr_qvtrRelation;

	/**
	 * The cached value of the '{@link #getQvtr_qvtrTemplate() <em>Qvtr qvtr Template</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQvtr_qvtrTemplate()
	 * @generated
	 * @ordered
	 */
	protected ObjectTemplateExp qvtr_qvtrTemplate;

	/**
	 * The cached value of the '{@link #getQvtr_qvtrVariable() <em>Qvtr qvtr Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQvtr_qvtrVariable()
	 * @generated
	 * @ordered
	 */
	protected TemplateVariable qvtr_qvtrVariable;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TC_mapSimpleInPatternElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return trace_ATL2QVTrPackage.Literals.TC_MAP_SIMPLE_IN_PATTERN_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InPattern getAtl_atlPattern() {
		if (atl_atlPattern != null && atl_atlPattern.eIsProxy()) {
			InternalEObject oldAtl_atlPattern = (InternalEObject)atl_atlPattern;
			atl_atlPattern = (InPattern)eResolveProxy(oldAtl_atlPattern);
			if (atl_atlPattern != oldAtl_atlPattern) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__ATL_ATL_PATTERN, oldAtl_atlPattern, atl_atlPattern));
			}
		}
		return atl_atlPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InPattern basicGetAtl_atlPattern() {
		return atl_atlPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAtl_atlPattern(InPattern newAtl_atlPattern) {
		InPattern oldAtl_atlPattern = atl_atlPattern;
		atl_atlPattern = newAtl_atlPattern;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__ATL_ATL_PATTERN, oldAtl_atlPattern, atl_atlPattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MatchedRule getAtl_atlRule() {
		if (atl_atlRule != null && atl_atlRule.eIsProxy()) {
			InternalEObject oldAtl_atlRule = (InternalEObject)atl_atlRule;
			atl_atlRule = (MatchedRule)eResolveProxy(oldAtl_atlRule);
			if (atl_atlRule != oldAtl_atlRule) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__ATL_ATL_RULE, oldAtl_atlRule, atl_atlRule));
			}
		}
		return atl_atlRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MatchedRule basicGetAtl_atlRule() {
		return atl_atlRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAtl_atlRule(MatchedRule newAtl_atlRule) {
		MatchedRule oldAtl_atlRule = atl_atlRule;
		atl_atlRule = newAtl_atlRule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__ATL_ATL_RULE, oldAtl_atlRule, atl_atlRule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TC_mapVariable getInvocation_mapVariable() {
		return invocation_mapVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInvocation_mapVariable(TC_mapVariable newInvocation_mapVariable, NotificationChain msgs) {
		TC_mapVariable oldInvocation_mapVariable = invocation_mapVariable;
		invocation_mapVariable = newInvocation_mapVariable;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__INVOCATION_MAP_VARIABLE, oldInvocation_mapVariable, newInvocation_mapVariable);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInvocation_mapVariable(TC_mapVariable newInvocation_mapVariable) {
		if (newInvocation_mapVariable != invocation_mapVariable) {
			NotificationChain msgs = null;
			if (invocation_mapVariable != null)
				msgs = ((InternalEObject)invocation_mapVariable).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - trace_ATL2QVTrPackage.TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__INVOCATION_MAP_VARIABLE, null, msgs);
			if (newInvocation_mapVariable != null)
				msgs = ((InternalEObject)newInvocation_mapVariable).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - trace_ATL2QVTrPackage.TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__INVOCATION_MAP_VARIABLE, null, msgs);
			msgs = basicSetInvocation_mapVariable(newInvocation_mapVariable, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__INVOCATION_MAP_VARIABLE, newInvocation_mapVariable, newInvocation_mapVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPrimitive_elementName() {
		return primitive_elementName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrimitive_elementName(String newPrimitive_elementName) {
		String oldPrimitive_elementName = primitive_elementName;
		primitive_elementName = newPrimitive_elementName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__PRIMITIVE_ELEMENT_NAME, oldPrimitive_elementName, primitive_elementName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationDomain getQvtr_qvtrDomain() {
		if (qvtr_qvtrDomain != null && qvtr_qvtrDomain.eIsProxy()) {
			InternalEObject oldQvtr_qvtrDomain = (InternalEObject)qvtr_qvtrDomain;
			qvtr_qvtrDomain = (RelationDomain)eResolveProxy(oldQvtr_qvtrDomain);
			if (qvtr_qvtrDomain != oldQvtr_qvtrDomain) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__QVTR_QVTR_DOMAIN, oldQvtr_qvtrDomain, qvtr_qvtrDomain));
			}
		}
		return qvtr_qvtrDomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationDomain basicGetQvtr_qvtrDomain() {
		return qvtr_qvtrDomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQvtr_qvtrDomain(RelationDomain newQvtr_qvtrDomain) {
		RelationDomain oldQvtr_qvtrDomain = qvtr_qvtrDomain;
		qvtr_qvtrDomain = newQvtr_qvtrDomain;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__QVTR_QVTR_DOMAIN, oldQvtr_qvtrDomain, qvtr_qvtrDomain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationDomain getQvtr_qvtrDomain1() {
		if (qvtr_qvtrDomain1 != null && qvtr_qvtrDomain1.eIsProxy()) {
			InternalEObject oldQvtr_qvtrDomain1 = (InternalEObject)qvtr_qvtrDomain1;
			qvtr_qvtrDomain1 = (RelationDomain)eResolveProxy(oldQvtr_qvtrDomain1);
			if (qvtr_qvtrDomain1 != oldQvtr_qvtrDomain1) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__QVTR_QVTR_DOMAIN1, oldQvtr_qvtrDomain1, qvtr_qvtrDomain1));
			}
		}
		return qvtr_qvtrDomain1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationDomain basicGetQvtr_qvtrDomain1() {
		return qvtr_qvtrDomain1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQvtr_qvtrDomain1(RelationDomain newQvtr_qvtrDomain1) {
		RelationDomain oldQvtr_qvtrDomain1 = qvtr_qvtrDomain1;
		qvtr_qvtrDomain1 = newQvtr_qvtrDomain1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__QVTR_QVTR_DOMAIN1, oldQvtr_qvtrDomain1, qvtr_qvtrDomain1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DomainPattern getQvtr_qvtrPattern() {
		if (qvtr_qvtrPattern != null && qvtr_qvtrPattern.eIsProxy()) {
			InternalEObject oldQvtr_qvtrPattern = (InternalEObject)qvtr_qvtrPattern;
			qvtr_qvtrPattern = (DomainPattern)eResolveProxy(oldQvtr_qvtrPattern);
			if (qvtr_qvtrPattern != oldQvtr_qvtrPattern) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__QVTR_QVTR_PATTERN, oldQvtr_qvtrPattern, qvtr_qvtrPattern));
			}
		}
		return qvtr_qvtrPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DomainPattern basicGetQvtr_qvtrPattern() {
		return qvtr_qvtrPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQvtr_qvtrPattern(DomainPattern newQvtr_qvtrPattern) {
		DomainPattern oldQvtr_qvtrPattern = qvtr_qvtrPattern;
		qvtr_qvtrPattern = newQvtr_qvtrPattern;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__QVTR_QVTR_PATTERN, oldQvtr_qvtrPattern, qvtr_qvtrPattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Relation getQvtr_qvtrRelation() {
		if (qvtr_qvtrRelation != null && qvtr_qvtrRelation.eIsProxy()) {
			InternalEObject oldQvtr_qvtrRelation = (InternalEObject)qvtr_qvtrRelation;
			qvtr_qvtrRelation = (Relation)eResolveProxy(oldQvtr_qvtrRelation);
			if (qvtr_qvtrRelation != oldQvtr_qvtrRelation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__QVTR_QVTR_RELATION, oldQvtr_qvtrRelation, qvtr_qvtrRelation));
			}
		}
		return qvtr_qvtrRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Relation basicGetQvtr_qvtrRelation() {
		return qvtr_qvtrRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQvtr_qvtrRelation(Relation newQvtr_qvtrRelation) {
		Relation oldQvtr_qvtrRelation = qvtr_qvtrRelation;
		qvtr_qvtrRelation = newQvtr_qvtrRelation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__QVTR_QVTR_RELATION, oldQvtr_qvtrRelation, qvtr_qvtrRelation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectTemplateExp getQvtr_qvtrTemplate() {
		if (qvtr_qvtrTemplate != null && qvtr_qvtrTemplate.eIsProxy()) {
			InternalEObject oldQvtr_qvtrTemplate = (InternalEObject)qvtr_qvtrTemplate;
			qvtr_qvtrTemplate = (ObjectTemplateExp)eResolveProxy(oldQvtr_qvtrTemplate);
			if (qvtr_qvtrTemplate != oldQvtr_qvtrTemplate) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__QVTR_QVTR_TEMPLATE, oldQvtr_qvtrTemplate, qvtr_qvtrTemplate));
			}
		}
		return qvtr_qvtrTemplate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectTemplateExp basicGetQvtr_qvtrTemplate() {
		return qvtr_qvtrTemplate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQvtr_qvtrTemplate(ObjectTemplateExp newQvtr_qvtrTemplate) {
		ObjectTemplateExp oldQvtr_qvtrTemplate = qvtr_qvtrTemplate;
		qvtr_qvtrTemplate = newQvtr_qvtrTemplate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__QVTR_QVTR_TEMPLATE, oldQvtr_qvtrTemplate, qvtr_qvtrTemplate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateVariable getQvtr_qvtrVariable() {
		if (qvtr_qvtrVariable != null && qvtr_qvtrVariable.eIsProxy()) {
			InternalEObject oldQvtr_qvtrVariable = (InternalEObject)qvtr_qvtrVariable;
			qvtr_qvtrVariable = (TemplateVariable)eResolveProxy(oldQvtr_qvtrVariable);
			if (qvtr_qvtrVariable != oldQvtr_qvtrVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__QVTR_QVTR_VARIABLE, oldQvtr_qvtrVariable, qvtr_qvtrVariable));
			}
		}
		return qvtr_qvtrVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateVariable basicGetQvtr_qvtrVariable() {
		return qvtr_qvtrVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQvtr_qvtrVariable(TemplateVariable newQvtr_qvtrVariable) {
		TemplateVariable oldQvtr_qvtrVariable = qvtr_qvtrVariable;
		qvtr_qvtrVariable = newQvtr_qvtrVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__QVTR_QVTR_VARIABLE, oldQvtr_qvtrVariable, qvtr_qvtrVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case trace_ATL2QVTrPackage.TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__INVOCATION_MAP_VARIABLE:
				return basicSetInvocation_mapVariable(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case trace_ATL2QVTrPackage.TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__ATL_ATL_PATTERN:
				if (resolve) return getAtl_atlPattern();
				return basicGetAtl_atlPattern();
			case trace_ATL2QVTrPackage.TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__ATL_ATL_RULE:
				if (resolve) return getAtl_atlRule();
				return basicGetAtl_atlRule();
			case trace_ATL2QVTrPackage.TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__INVOCATION_MAP_VARIABLE:
				return getInvocation_mapVariable();
			case trace_ATL2QVTrPackage.TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__PRIMITIVE_ELEMENT_NAME:
				return getPrimitive_elementName();
			case trace_ATL2QVTrPackage.TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__QVTR_QVTR_DOMAIN:
				if (resolve) return getQvtr_qvtrDomain();
				return basicGetQvtr_qvtrDomain();
			case trace_ATL2QVTrPackage.TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__QVTR_QVTR_DOMAIN1:
				if (resolve) return getQvtr_qvtrDomain1();
				return basicGetQvtr_qvtrDomain1();
			case trace_ATL2QVTrPackage.TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__QVTR_QVTR_PATTERN:
				if (resolve) return getQvtr_qvtrPattern();
				return basicGetQvtr_qvtrPattern();
			case trace_ATL2QVTrPackage.TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__QVTR_QVTR_RELATION:
				if (resolve) return getQvtr_qvtrRelation();
				return basicGetQvtr_qvtrRelation();
			case trace_ATL2QVTrPackage.TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__QVTR_QVTR_TEMPLATE:
				if (resolve) return getQvtr_qvtrTemplate();
				return basicGetQvtr_qvtrTemplate();
			case trace_ATL2QVTrPackage.TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__QVTR_QVTR_VARIABLE:
				if (resolve) return getQvtr_qvtrVariable();
				return basicGetQvtr_qvtrVariable();
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
			case trace_ATL2QVTrPackage.TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__ATL_ATL_PATTERN:
				setAtl_atlPattern((InPattern)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__ATL_ATL_RULE:
				setAtl_atlRule((MatchedRule)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__INVOCATION_MAP_VARIABLE:
				setInvocation_mapVariable((TC_mapVariable)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__PRIMITIVE_ELEMENT_NAME:
				setPrimitive_elementName((String)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__QVTR_QVTR_DOMAIN:
				setQvtr_qvtrDomain((RelationDomain)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__QVTR_QVTR_DOMAIN1:
				setQvtr_qvtrDomain1((RelationDomain)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__QVTR_QVTR_PATTERN:
				setQvtr_qvtrPattern((DomainPattern)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__QVTR_QVTR_RELATION:
				setQvtr_qvtrRelation((Relation)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__QVTR_QVTR_TEMPLATE:
				setQvtr_qvtrTemplate((ObjectTemplateExp)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__QVTR_QVTR_VARIABLE:
				setQvtr_qvtrVariable((TemplateVariable)newValue);
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
			case trace_ATL2QVTrPackage.TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__ATL_ATL_PATTERN:
				setAtl_atlPattern((InPattern)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__ATL_ATL_RULE:
				setAtl_atlRule((MatchedRule)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__INVOCATION_MAP_VARIABLE:
				setInvocation_mapVariable((TC_mapVariable)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__PRIMITIVE_ELEMENT_NAME:
				setPrimitive_elementName(PRIMITIVE_ELEMENT_NAME_EDEFAULT);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__QVTR_QVTR_DOMAIN:
				setQvtr_qvtrDomain((RelationDomain)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__QVTR_QVTR_DOMAIN1:
				setQvtr_qvtrDomain1((RelationDomain)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__QVTR_QVTR_PATTERN:
				setQvtr_qvtrPattern((DomainPattern)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__QVTR_QVTR_RELATION:
				setQvtr_qvtrRelation((Relation)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__QVTR_QVTR_TEMPLATE:
				setQvtr_qvtrTemplate((ObjectTemplateExp)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__QVTR_QVTR_VARIABLE:
				setQvtr_qvtrVariable((TemplateVariable)null);
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
			case trace_ATL2QVTrPackage.TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__ATL_ATL_PATTERN:
				return atl_atlPattern != null;
			case trace_ATL2QVTrPackage.TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__ATL_ATL_RULE:
				return atl_atlRule != null;
			case trace_ATL2QVTrPackage.TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__INVOCATION_MAP_VARIABLE:
				return invocation_mapVariable != null;
			case trace_ATL2QVTrPackage.TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__PRIMITIVE_ELEMENT_NAME:
				return PRIMITIVE_ELEMENT_NAME_EDEFAULT == null ? primitive_elementName != null : !PRIMITIVE_ELEMENT_NAME_EDEFAULT.equals(primitive_elementName);
			case trace_ATL2QVTrPackage.TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__QVTR_QVTR_DOMAIN:
				return qvtr_qvtrDomain != null;
			case trace_ATL2QVTrPackage.TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__QVTR_QVTR_DOMAIN1:
				return qvtr_qvtrDomain1 != null;
			case trace_ATL2QVTrPackage.TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__QVTR_QVTR_PATTERN:
				return qvtr_qvtrPattern != null;
			case trace_ATL2QVTrPackage.TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__QVTR_QVTR_RELATION:
				return qvtr_qvtrRelation != null;
			case trace_ATL2QVTrPackage.TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__QVTR_QVTR_TEMPLATE:
				return qvtr_qvtrTemplate != null;
			case trace_ATL2QVTrPackage.TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__QVTR_QVTR_VARIABLE:
				return qvtr_qvtrVariable != null;
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
		result.append(" (primitive_elementName: ");
		result.append(primitive_elementName);
		result.append(')');
		return result.toString();
	}

} //TC_mapSimpleInPatternElementImpl
