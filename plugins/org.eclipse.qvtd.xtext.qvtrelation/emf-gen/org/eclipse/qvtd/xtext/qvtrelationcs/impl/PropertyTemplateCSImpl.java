/*******************************************************************************
 * Copyright (c) 2012, 2015 Willink Transformations and others.
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
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.PropertyTemplateCSImpl#getOwningObjectTemplate <em>Owning Object Template</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.PropertyTemplateCSImpl#getPropertyId <em>Property Id</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.PropertyTemplateCSImpl#getOwnedOppositePropertyId <em>Owned Opposite Property Id</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.PropertyTemplateCSImpl#getOwnedExpression <em>Owned Expression</em>}</li>
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
	 * The cached value of the '{@link #getOwnedOppositePropertyId() <em>Owned Opposite Property Id</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedOppositePropertyId()
	 * @generated
	 * @ordered
	 */
	protected PathNameCS ownedOppositePropertyId;

	/**
	 * The cached value of the '{@link #getOwnedExpression() <em>Owned Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedExpression()
	 * @generated
	 * @ordered
	 */
	protected ExpCS ownedExpression;

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
	public ObjectTemplateCS getOwningObjectTemplate() {
		if (eContainerFeatureID() != QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__OWNING_OBJECT_TEMPLATE) return null;
		return (ObjectTemplateCS)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningObjectTemplate(ObjectTemplateCS newOwningObjectTemplate, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningObjectTemplate, QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__OWNING_OBJECT_TEMPLATE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningObjectTemplate(ObjectTemplateCS newOwningObjectTemplate) {
		if (newOwningObjectTemplate != eInternalContainer() || (eContainerFeatureID() != QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__OWNING_OBJECT_TEMPLATE && newOwningObjectTemplate != null)) {
			if (EcoreUtil.isAncestor(this, newOwningObjectTemplate))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningObjectTemplate != null)
				msgs = ((InternalEObject)newOwningObjectTemplate).eInverseAdd(this, QVTrelationCSPackage.OBJECT_TEMPLATE_CS__OWNED_PROPERTY_TEMPLATES, ObjectTemplateCS.class, msgs);
			msgs = basicSetOwningObjectTemplate(newOwningObjectTemplate, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__OWNING_OBJECT_TEMPLATE, newOwningObjectTemplate, newOwningObjectTemplate));
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
	public PathNameCS getOwnedOppositePropertyId() {
		return ownedOppositePropertyId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedOppositePropertyId(PathNameCS newOwnedOppositePropertyId, NotificationChain msgs) {
		PathNameCS oldOwnedOppositePropertyId = ownedOppositePropertyId;
		ownedOppositePropertyId = newOwnedOppositePropertyId;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__OWNED_OPPOSITE_PROPERTY_ID, oldOwnedOppositePropertyId, newOwnedOppositePropertyId);
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
	public void setOwnedOppositePropertyId(PathNameCS newOwnedOppositePropertyId) {
		if (newOwnedOppositePropertyId != ownedOppositePropertyId) {
			NotificationChain msgs = null;
			if (ownedOppositePropertyId != null)
				msgs = ((InternalEObject)ownedOppositePropertyId).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__OWNED_OPPOSITE_PROPERTY_ID, null, msgs);
			if (newOwnedOppositePropertyId != null)
				msgs = ((InternalEObject)newOwnedOppositePropertyId).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__OWNED_OPPOSITE_PROPERTY_ID, null, msgs);
			msgs = basicSetOwnedOppositePropertyId(newOwnedOppositePropertyId, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__OWNED_OPPOSITE_PROPERTY_ID, newOwnedOppositePropertyId, newOwnedOppositePropertyId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExpCS getOwnedExpression() {
		return ownedExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedExpression(ExpCS newOwnedExpression, NotificationChain msgs) {
		ExpCS oldOwnedExpression = ownedExpression;
		ownedExpression = newOwnedExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__OWNED_EXPRESSION, oldOwnedExpression, newOwnedExpression);
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
	public void setOwnedExpression(ExpCS newOwnedExpression) {
		if (newOwnedExpression != ownedExpression) {
			NotificationChain msgs = null;
			if (ownedExpression != null)
				msgs = ((InternalEObject)ownedExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__OWNED_EXPRESSION, null, msgs);
			if (newOwnedExpression != null)
				msgs = ((InternalEObject)newOwnedExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__OWNED_EXPRESSION, null, msgs);
			msgs = basicSetOwnedExpression(newOwnedExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__OWNED_EXPRESSION, newOwnedExpression, newOwnedExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__OWNING_OBJECT_TEMPLATE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningObjectTemplate((ObjectTemplateCS)otherEnd, msgs);
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
			case QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__OWNING_OBJECT_TEMPLATE:
				return basicSetOwningObjectTemplate(null, msgs);
			case QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__OWNED_OPPOSITE_PROPERTY_ID:
				return basicSetOwnedOppositePropertyId(null, msgs);
			case QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__OWNED_EXPRESSION:
				return basicSetOwnedExpression(null, msgs);
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
			case QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__OWNING_OBJECT_TEMPLATE:
				return eInternalContainer().eInverseRemove(this, QVTrelationCSPackage.OBJECT_TEMPLATE_CS__OWNED_PROPERTY_TEMPLATES, ObjectTemplateCS.class, msgs);
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
			case QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__OWNING_OBJECT_TEMPLATE:
				return getOwningObjectTemplate();
			case QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__PROPERTY_ID:
				if (resolve) return getPropertyId();
				return basicGetPropertyId();
			case QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__OWNED_OPPOSITE_PROPERTY_ID:
				return getOwnedOppositePropertyId();
			case QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__OWNED_EXPRESSION:
				return getOwnedExpression();
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
			case QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__OWNING_OBJECT_TEMPLATE:
				setOwningObjectTemplate((ObjectTemplateCS)newValue);
				return;
			case QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__PROPERTY_ID:
				setPropertyId((Property)newValue);
				return;
			case QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__OWNED_OPPOSITE_PROPERTY_ID:
				setOwnedOppositePropertyId((PathNameCS)newValue);
				return;
			case QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__OWNED_EXPRESSION:
				setOwnedExpression((ExpCS)newValue);
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
			case QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__OWNING_OBJECT_TEMPLATE:
				setOwningObjectTemplate((ObjectTemplateCS)null);
				return;
			case QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__PROPERTY_ID:
				setPropertyId((Property)null);
				return;
			case QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__OWNED_OPPOSITE_PROPERTY_ID:
				setOwnedOppositePropertyId((PathNameCS)null);
				return;
			case QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__OWNED_EXPRESSION:
				setOwnedExpression((ExpCS)null);
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
			case QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__OWNING_OBJECT_TEMPLATE:
				return getOwningObjectTemplate() != null;
			case QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__PROPERTY_ID:
				return propertyId != null;
			case QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__OWNED_OPPOSITE_PROPERTY_ID:
				return ownedOppositePropertyId != null;
			case QVTrelationCSPackage.PROPERTY_TEMPLATE_CS__OWNED_EXPRESSION:
				return ownedExpression != null;
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
	public <R> R accept(@NonNull BaseCSVisitor<R> visitor) {
		return (R) ((QVTrelationCSVisitor<?>)visitor).visitPropertyTemplateCS(this);
	}
} //PropertyTemplateCSImpl
