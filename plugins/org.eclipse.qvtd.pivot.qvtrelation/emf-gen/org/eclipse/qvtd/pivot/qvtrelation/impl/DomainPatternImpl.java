/*******************************************************************************
 * Copyright (c) 2011, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtrelation.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtbase.impl.PatternImpl;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.util.QVTrelationVisitor;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Domain Pattern</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtrelation.impl.DomainPatternImpl#getRelationDomain <em>Relation Domain</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtrelation.impl.DomainPatternImpl#getTemplateExpression <em>Template Expression</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DomainPatternImpl extends PatternImpl implements DomainPattern {
	/**
	 * The cached value of the '{@link #getTemplateExpression() <em>Template Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTemplateExpression()
	 * @generated
	 * @ordered
	 */
	protected TemplateExp templateExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DomainPatternImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTrelationPackage.Literals.DOMAIN_PATTERN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RelationDomain getRelationDomain() {
		if (eContainerFeatureID() != QVTrelationPackage.DOMAIN_PATTERN__RELATION_DOMAIN) return null;
		return (RelationDomain)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRelationDomain(RelationDomain newRelationDomain, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newRelationDomain, QVTrelationPackage.DOMAIN_PATTERN__RELATION_DOMAIN, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRelationDomain(RelationDomain newRelationDomain) {
		if (newRelationDomain != eInternalContainer() || (eContainerFeatureID() != QVTrelationPackage.DOMAIN_PATTERN__RELATION_DOMAIN && newRelationDomain != null)) {
			if (EcoreUtil.isAncestor(this, newRelationDomain))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRelationDomain != null)
				msgs = ((InternalEObject)newRelationDomain).eInverseAdd(this, QVTrelationPackage.RELATION_DOMAIN__PATTERN, RelationDomain.class, msgs);
			msgs = basicSetRelationDomain(newRelationDomain, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrelationPackage.DOMAIN_PATTERN__RELATION_DOMAIN, newRelationDomain, newRelationDomain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TemplateExp getTemplateExpression() {
		return templateExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTemplateExpression(TemplateExp newTemplateExpression, NotificationChain msgs) {
		TemplateExp oldTemplateExpression = templateExpression;
		templateExpression = newTemplateExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTrelationPackage.DOMAIN_PATTERN__TEMPLATE_EXPRESSION, oldTemplateExpression, newTemplateExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTemplateExpression(TemplateExp newTemplateExpression) {
		if (newTemplateExpression != templateExpression) {
			NotificationChain msgs = null;
			if (templateExpression != null)
				msgs = ((InternalEObject)templateExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTrelationPackage.DOMAIN_PATTERN__TEMPLATE_EXPRESSION, null, msgs);
			if (newTemplateExpression != null)
				msgs = ((InternalEObject)newTemplateExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTrelationPackage.DOMAIN_PATTERN__TEMPLATE_EXPRESSION, null, msgs);
			msgs = basicSetTemplateExpression(newTemplateExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrelationPackage.DOMAIN_PATTERN__TEMPLATE_EXPRESSION, newTemplateExpression, newTemplateExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTrelationPackage.DOMAIN_PATTERN__RELATION_DOMAIN:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetRelationDomain((RelationDomain)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTrelationPackage.DOMAIN_PATTERN__RELATION_DOMAIN:
				return basicSetRelationDomain(null, msgs);
			case QVTrelationPackage.DOMAIN_PATTERN__TEMPLATE_EXPRESSION:
				return basicSetTemplateExpression(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case QVTrelationPackage.DOMAIN_PATTERN__RELATION_DOMAIN:
				return eInternalContainer().eInverseRemove(this, QVTrelationPackage.RELATION_DOMAIN__PATTERN, RelationDomain.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QVTrelationPackage.DOMAIN_PATTERN__RELATION_DOMAIN:
				return getRelationDomain();
			case QVTrelationPackage.DOMAIN_PATTERN__TEMPLATE_EXPRESSION:
				return getTemplateExpression();
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
			case QVTrelationPackage.DOMAIN_PATTERN__RELATION_DOMAIN:
				setRelationDomain((RelationDomain)newValue);
				return;
			case QVTrelationPackage.DOMAIN_PATTERN__TEMPLATE_EXPRESSION:
				setTemplateExpression((TemplateExp)newValue);
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
			case QVTrelationPackage.DOMAIN_PATTERN__RELATION_DOMAIN:
				setRelationDomain((RelationDomain)null);
				return;
			case QVTrelationPackage.DOMAIN_PATTERN__TEMPLATE_EXPRESSION:
				setTemplateExpression((TemplateExp)null);
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
			case QVTrelationPackage.DOMAIN_PATTERN__RELATION_DOMAIN:
				return getRelationDomain() != null;
			case QVTrelationPackage.DOMAIN_PATTERN__TEMPLATE_EXPRESSION:
				return templateExpression != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return (R) ((QVTrelationVisitor<?>)visitor).visitDomainPattern(this);
	}
} //DomainPatternImpl
