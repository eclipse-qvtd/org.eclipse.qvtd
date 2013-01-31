/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.qvtd.xtext.qvtrelationcst.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.xtext.base.baseCST.impl.ModelElementCSImpl;
import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.ObjectTemplateCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.PropertyTemplateCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.QVTrelationCSTPackage;
import org.eclipse.qvtd.xtext.qvtrelationcst.util.QVTrelationCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Template CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.PropertyTemplateCSImpl#getObjectTemplate <em>Object Template</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.PropertyTemplateCSImpl#getPropertyId <em>Property Id</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.PropertyTemplateCSImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.PropertyTemplateCSImpl#isOpposite <em>Opposite</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PropertyTemplateCSImpl extends ModelElementCSImpl implements PropertyTemplateCS {
	/**
	 * The cached value of the '{@link #getPropertyId() <em>Property Id</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyId()
	 * @generated
	 * @ordered
	 */
	protected Property propertyId;

	/**
	 * The cached value of the '{@link #getExpression() <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected ExpCS expression;

	/**
	 * The default value of the '{@link #isOpposite() <em>Opposite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOpposite()
	 * @generated
	 * @ordered
	 */
	protected static final boolean OPPOSITE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isOpposite() <em>Opposite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOpposite()
	 * @generated
	 * @ordered
	 */
	protected boolean opposite = OPPOSITE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertyTemplateCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTrelationCSTPackage.Literals.PROPERTY_TEMPLATE_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectTemplateCS getObjectTemplate() {
		if (eContainerFeatureID() != QVTrelationCSTPackage.PROPERTY_TEMPLATE_CS__OBJECT_TEMPLATE) return null;
		return (ObjectTemplateCS)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetObjectTemplate(ObjectTemplateCS newObjectTemplate, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newObjectTemplate, QVTrelationCSTPackage.PROPERTY_TEMPLATE_CS__OBJECT_TEMPLATE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObjectTemplate(ObjectTemplateCS newObjectTemplate) {
		if (newObjectTemplate != eInternalContainer() || (eContainerFeatureID() != QVTrelationCSTPackage.PROPERTY_TEMPLATE_CS__OBJECT_TEMPLATE && newObjectTemplate != null)) {
			if (EcoreUtil.isAncestor(this, newObjectTemplate))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newObjectTemplate != null)
				msgs = ((InternalEObject)newObjectTemplate).eInverseAdd(this, QVTrelationCSTPackage.OBJECT_TEMPLATE_CS__PROPERTY_TEMPLATES, ObjectTemplateCS.class, msgs);
			msgs = basicSetObjectTemplate(newObjectTemplate, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrelationCSTPackage.PROPERTY_TEMPLATE_CS__OBJECT_TEMPLATE, newObjectTemplate, newObjectTemplate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getPropertyId() {
		if (propertyId != null && ((EObject)propertyId).eIsProxy()) {
			InternalEObject oldPropertyId = (InternalEObject)propertyId;
			propertyId = (Property)eResolveProxy(oldPropertyId);
			if (propertyId != oldPropertyId) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTrelationCSTPackage.PROPERTY_TEMPLATE_CS__PROPERTY_ID, oldPropertyId, propertyId));
			}
		}
		return propertyId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetPropertyId() {
		return propertyId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropertyId(Property newPropertyId) {
		Property oldPropertyId = propertyId;
		propertyId = newPropertyId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrelationCSTPackage.PROPERTY_TEMPLATE_CS__PROPERTY_ID, oldPropertyId, propertyId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpCS getExpression() {
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExpression(ExpCS newExpression, NotificationChain msgs) {
		ExpCS oldExpression = expression;
		expression = newExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTrelationCSTPackage.PROPERTY_TEMPLATE_CS__EXPRESSION, oldExpression, newExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpression(ExpCS newExpression) {
		if (newExpression != expression) {
			NotificationChain msgs = null;
			if (expression != null)
				msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTrelationCSTPackage.PROPERTY_TEMPLATE_CS__EXPRESSION, null, msgs);
			if (newExpression != null)
				msgs = ((InternalEObject)newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTrelationCSTPackage.PROPERTY_TEMPLATE_CS__EXPRESSION, null, msgs);
			msgs = basicSetExpression(newExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrelationCSTPackage.PROPERTY_TEMPLATE_CS__EXPRESSION, newExpression, newExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isOpposite() {
		return opposite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOpposite(boolean newOpposite) {
		boolean oldOpposite = opposite;
		opposite = newOpposite;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrelationCSTPackage.PROPERTY_TEMPLATE_CS__OPPOSITE, oldOpposite, opposite));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTrelationCSTPackage.PROPERTY_TEMPLATE_CS__OBJECT_TEMPLATE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetObjectTemplate((ObjectTemplateCS)otherEnd, msgs);
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
			case QVTrelationCSTPackage.PROPERTY_TEMPLATE_CS__OBJECT_TEMPLATE:
				return basicSetObjectTemplate(null, msgs);
			case QVTrelationCSTPackage.PROPERTY_TEMPLATE_CS__EXPRESSION:
				return basicSetExpression(null, msgs);
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
			case QVTrelationCSTPackage.PROPERTY_TEMPLATE_CS__OBJECT_TEMPLATE:
				return eInternalContainer().eInverseRemove(this, QVTrelationCSTPackage.OBJECT_TEMPLATE_CS__PROPERTY_TEMPLATES, ObjectTemplateCS.class, msgs);
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
			case QVTrelationCSTPackage.PROPERTY_TEMPLATE_CS__OBJECT_TEMPLATE:
				return getObjectTemplate();
			case QVTrelationCSTPackage.PROPERTY_TEMPLATE_CS__PROPERTY_ID:
				if (resolve) return getPropertyId();
				return basicGetPropertyId();
			case QVTrelationCSTPackage.PROPERTY_TEMPLATE_CS__EXPRESSION:
				return getExpression();
			case QVTrelationCSTPackage.PROPERTY_TEMPLATE_CS__OPPOSITE:
				return isOpposite();
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
			case QVTrelationCSTPackage.PROPERTY_TEMPLATE_CS__OBJECT_TEMPLATE:
				setObjectTemplate((ObjectTemplateCS)newValue);
				return;
			case QVTrelationCSTPackage.PROPERTY_TEMPLATE_CS__PROPERTY_ID:
				setPropertyId((Property)newValue);
				return;
			case QVTrelationCSTPackage.PROPERTY_TEMPLATE_CS__EXPRESSION:
				setExpression((ExpCS)newValue);
				return;
			case QVTrelationCSTPackage.PROPERTY_TEMPLATE_CS__OPPOSITE:
				setOpposite((Boolean)newValue);
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
			case QVTrelationCSTPackage.PROPERTY_TEMPLATE_CS__OBJECT_TEMPLATE:
				setObjectTemplate((ObjectTemplateCS)null);
				return;
			case QVTrelationCSTPackage.PROPERTY_TEMPLATE_CS__PROPERTY_ID:
				setPropertyId((Property)null);
				return;
			case QVTrelationCSTPackage.PROPERTY_TEMPLATE_CS__EXPRESSION:
				setExpression((ExpCS)null);
				return;
			case QVTrelationCSTPackage.PROPERTY_TEMPLATE_CS__OPPOSITE:
				setOpposite(OPPOSITE_EDEFAULT);
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
			case QVTrelationCSTPackage.PROPERTY_TEMPLATE_CS__OBJECT_TEMPLATE:
				return getObjectTemplate() != null;
			case QVTrelationCSTPackage.PROPERTY_TEMPLATE_CS__PROPERTY_ID:
				return propertyId != null;
			case QVTrelationCSTPackage.PROPERTY_TEMPLATE_CS__EXPRESSION:
				return expression != null;
			case QVTrelationCSTPackage.PROPERTY_TEMPLATE_CS__OPPOSITE:
				return opposite != OPPOSITE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public <R> R accept(@NonNull BaseCSVisitor<R> visitor) {
		return ((QVTrelationCSVisitor<R>)visitor).visitPropertyTemplateCS(this);
	}
} //PropertyTemplateCSImpl
