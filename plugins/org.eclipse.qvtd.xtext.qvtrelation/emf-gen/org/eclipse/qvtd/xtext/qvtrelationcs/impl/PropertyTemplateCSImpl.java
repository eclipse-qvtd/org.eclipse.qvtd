/*******************************************************************************
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtrelationcs.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.ocl.xtext.basecs.impl.ModelElementCSImpl;
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;
import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.ObjectTemplateCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.PropertyTemplateCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage;
import org.eclipse.qvtd.xtext.qvtrelationcs.util.QVTrelationCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Template CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.PropertyTemplateCSImpl#getObjectTemplate <em>Object Template</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.PropertyTemplateCSImpl#getPropertyId <em>Property Id</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.PropertyTemplateCSImpl#getOppositePropertyId <em>Opposite Property Id</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.PropertyTemplateCSImpl#getExpression <em>Expression</em>}</li>
 * </ul>
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
	 * The cached value of the '{@link #getOppositePropertyId() <em>Opposite Property Id</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOppositePropertyId()
	 * @generated
	 * @ordered
	 */
	protected PathNameCS oppositePropertyId;

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
		return QVTrelationCSPackage.Literals.PROPERTY_TEMPLATE_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ObjectTemplateCS getObjectTemplate() {
		if (eContainerFeatureID() != QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__OBJECT_TEMPLATE) return null;
		return (ObjectTemplateCS)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetObjectTemplate(ObjectTemplateCS newObjectTemplate, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newObjectTemplate, QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__OBJECT_TEMPLATE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setObjectTemplate(ObjectTemplateCS newObjectTemplate) {
		if (newObjectTemplate != eInternalContainer() || (eContainerFeatureID() != QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__OBJECT_TEMPLATE && newObjectTemplate != null)) {
			if (EcoreUtil.isAncestor(this, newObjectTemplate))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newObjectTemplate != null)
				msgs = ((InternalEObject)newObjectTemplate).eInverseAdd(this, QVTrelationCSPackage.OBJECT_TEMPLATE_CS__PROPERTY_TEMPLATES, ObjectTemplateCS.class, msgs);
			msgs = basicSetObjectTemplate(newObjectTemplate, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__OBJECT_TEMPLATE, newObjectTemplate, newObjectTemplate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Property getPropertyId() {
		if (propertyId != null && propertyId.eIsProxy()) {
			InternalEObject oldPropertyId = (InternalEObject)propertyId;
			propertyId = (Property)eResolveProxy(oldPropertyId);
			if (propertyId != oldPropertyId) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__PROPERTY_ID, oldPropertyId, propertyId));
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
	@Override
	public void setPropertyId(Property newPropertyId) {
		Property oldPropertyId = propertyId;
		propertyId = newPropertyId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__PROPERTY_ID, oldPropertyId, propertyId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PathNameCS getOppositePropertyId() {
		return oppositePropertyId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOppositePropertyId(PathNameCS newOppositePropertyId, NotificationChain msgs) {
		PathNameCS oldOppositePropertyId = oppositePropertyId;
		oppositePropertyId = newOppositePropertyId;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__OPPOSITE_PROPERTY_ID, oldOppositePropertyId, newOppositePropertyId);
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
	public void setOppositePropertyId(PathNameCS newOppositePropertyId) {
		if (newOppositePropertyId != oppositePropertyId) {
			NotificationChain msgs = null;
			if (oppositePropertyId != null)
				msgs = ((InternalEObject)oppositePropertyId).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__OPPOSITE_PROPERTY_ID, null, msgs);
			if (newOppositePropertyId != null)
				msgs = ((InternalEObject)newOppositePropertyId).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__OPPOSITE_PROPERTY_ID, null, msgs);
			msgs = basicSetOppositePropertyId(newOppositePropertyId, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__OPPOSITE_PROPERTY_ID, newOppositePropertyId, newOppositePropertyId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__EXPRESSION, oldExpression, newExpression);
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
	public void setExpression(ExpCS newExpression) {
		if (newExpression != expression) {
			NotificationChain msgs = null;
			if (expression != null)
				msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__EXPRESSION, null, msgs);
			if (newExpression != null)
				msgs = ((InternalEObject)newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__EXPRESSION, null, msgs);
			msgs = basicSetExpression(newExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__EXPRESSION, newExpression, newExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__OBJECT_TEMPLATE:
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
			case QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__OBJECT_TEMPLATE:
				return basicSetObjectTemplate(null, msgs);
			case QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__OPPOSITE_PROPERTY_ID:
				return basicSetOppositePropertyId(null, msgs);
			case QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__EXPRESSION:
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
			case QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__OBJECT_TEMPLATE:
				return eInternalContainer().eInverseRemove(this, QVTrelationCSPackage.OBJECT_TEMPLATE_CS__PROPERTY_TEMPLATES, ObjectTemplateCS.class, msgs);
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
			case QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__OBJECT_TEMPLATE:
				return getObjectTemplate();
			case QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__PROPERTY_ID:
				if (resolve) return getPropertyId();
				return basicGetPropertyId();
			case QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__OPPOSITE_PROPERTY_ID:
				return getOppositePropertyId();
			case QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__EXPRESSION:
				return getExpression();
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
			case QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__OBJECT_TEMPLATE:
				setObjectTemplate((ObjectTemplateCS)newValue);
				return;
			case QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__PROPERTY_ID:
				setPropertyId((Property)newValue);
				return;
			case QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__OPPOSITE_PROPERTY_ID:
				setOppositePropertyId((PathNameCS)newValue);
				return;
			case QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__EXPRESSION:
				setExpression((ExpCS)newValue);
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
			case QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__OBJECT_TEMPLATE:
				setObjectTemplate((ObjectTemplateCS)null);
				return;
			case QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__PROPERTY_ID:
				setPropertyId((Property)null);
				return;
			case QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__OPPOSITE_PROPERTY_ID:
				setOppositePropertyId((PathNameCS)null);
				return;
			case QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__EXPRESSION:
				setExpression((ExpCS)null);
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
			case QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__OBJECT_TEMPLATE:
				return getObjectTemplate() != null;
			case QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__PROPERTY_ID:
				return propertyId != null;
			case QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__OPPOSITE_PROPERTY_ID:
				return oppositePropertyId != null;
			case QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__EXPRESSION:
				return expression != null;
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
	public @Nullable <R> R accept(@NonNull BaseCSVisitor<R> visitor) {
		return (R) ((QVTrelationCSVisitor<?>)visitor).visitPropertyTemplateCS(this);
	}
} //PropertyTemplateCSImpl
