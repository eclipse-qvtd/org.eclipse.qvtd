/**
 * <copyright>
 * 
 * Copyright (c) 2007, 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: DomainPatternImpl.java,v 1.1 2008/07/23 09:46:09 qglineur Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTRelation.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.qvt.declarative.ecore.QVTBase.impl.PatternImpl;

import org.eclipse.qvt.declarative.ecore.QVTRelation.DomainPattern;
import org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationPackage;

import org.eclipse.qvt.declarative.ecore.QVTTemplate.TemplateExp;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Domain Pattern</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTRelation.impl.DomainPatternImpl#getTemplateExpression <em>Template Expression</em>}</li>
 * </ul>
 * </p>
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
		return QVTRelationPackage.Literals.DOMAIN_PATTERN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTRelationPackage.DOMAIN_PATTERN__TEMPLATE_EXPRESSION, oldTemplateExpression, newTemplateExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTemplateExpression(TemplateExp newTemplateExpression) {
		if (newTemplateExpression != templateExpression) {
			NotificationChain msgs = null;
			if (templateExpression != null)
				msgs = ((InternalEObject)templateExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTRelationPackage.DOMAIN_PATTERN__TEMPLATE_EXPRESSION, null, msgs);
			if (newTemplateExpression != null)
				msgs = ((InternalEObject)newTemplateExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTRelationPackage.DOMAIN_PATTERN__TEMPLATE_EXPRESSION, null, msgs);
			msgs = basicSetTemplateExpression(newTemplateExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTRelationPackage.DOMAIN_PATTERN__TEMPLATE_EXPRESSION, newTemplateExpression, newTemplateExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTRelationPackage.DOMAIN_PATTERN__TEMPLATE_EXPRESSION:
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QVTRelationPackage.DOMAIN_PATTERN__TEMPLATE_EXPRESSION:
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
			case QVTRelationPackage.DOMAIN_PATTERN__TEMPLATE_EXPRESSION:
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
			case QVTRelationPackage.DOMAIN_PATTERN__TEMPLATE_EXPRESSION:
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
			case QVTRelationPackage.DOMAIN_PATTERN__TEMPLATE_EXPRESSION:
				return templateExpression != null;
		}
		return super.eIsSet(featureID);
	}

} //DomainPatternImpl
