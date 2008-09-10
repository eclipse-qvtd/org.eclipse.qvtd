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
 * $Id: PropertyTemplateCSImpl.java,v 1.3 2008/09/10 05:23:32 ewillink Exp $
 */
package org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.cst.impl.CSTNodeImpl;
import org.eclipse.qvt.declarative.parser.qvt.cst.IdentifiedCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.PropertyTemplateCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.QVTrCSTPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Template CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.PropertyTemplateCSImpl#getPropertyId <em>Property Id</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.PropertyTemplateCSImpl#getOclExpression <em>Ocl Expression</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.PropertyTemplateCSImpl#getReferredProperty <em>Referred Property</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.PropertyTemplateCSImpl#isOpposite <em>Opposite</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PropertyTemplateCSImpl extends CSTNodeImpl implements PropertyTemplateCS {
	/**
	 * The cached value of the '{@link #getPropertyId() <em>Property Id</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyId()
	 * @generated
	 * @ordered
	 */
	protected IdentifiedCS propertyId;

	/**
	 * The cached value of the '{@link #getOclExpression() <em>Ocl Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOclExpression()
	 * @generated
	 * @ordered
	 */
	protected OCLExpressionCS oclExpression;

	/**
	 * The cached value of the '{@link #getReferredProperty() <em>Referred Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredProperty()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature referredProperty;

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
		return QVTrCSTPackage.Literals.PROPERTY_TEMPLATE_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IdentifiedCS getPropertyId() {
		return propertyId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPropertyId(IdentifiedCS newPropertyId, NotificationChain msgs) {
		IdentifiedCS oldPropertyId = propertyId;
		propertyId = newPropertyId;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTrCSTPackage.PROPERTY_TEMPLATE_CS__PROPERTY_ID, oldPropertyId, newPropertyId);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropertyId(IdentifiedCS newPropertyId) {
		if (newPropertyId != propertyId) {
			NotificationChain msgs = null;
			if (propertyId != null)
				msgs = ((InternalEObject)propertyId).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTrCSTPackage.PROPERTY_TEMPLATE_CS__PROPERTY_ID, null, msgs);
			if (newPropertyId != null)
				msgs = ((InternalEObject)newPropertyId).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTrCSTPackage.PROPERTY_TEMPLATE_CS__PROPERTY_ID, null, msgs);
			msgs = basicSetPropertyId(newPropertyId, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrCSTPackage.PROPERTY_TEMPLATE_CS__PROPERTY_ID, newPropertyId, newPropertyId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpressionCS getOclExpression() {
		return oclExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOclExpression(OCLExpressionCS newOclExpression, NotificationChain msgs) {
		OCLExpressionCS oldOclExpression = oclExpression;
		oclExpression = newOclExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTrCSTPackage.PROPERTY_TEMPLATE_CS__OCL_EXPRESSION, oldOclExpression, newOclExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOclExpression(OCLExpressionCS newOclExpression) {
		if (newOclExpression != oclExpression) {
			NotificationChain msgs = null;
			if (oclExpression != null)
				msgs = ((InternalEObject)oclExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTrCSTPackage.PROPERTY_TEMPLATE_CS__OCL_EXPRESSION, null, msgs);
			if (newOclExpression != null)
				msgs = ((InternalEObject)newOclExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTrCSTPackage.PROPERTY_TEMPLATE_CS__OCL_EXPRESSION, null, msgs);
			msgs = basicSetOclExpression(newOclExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrCSTPackage.PROPERTY_TEMPLATE_CS__OCL_EXPRESSION, newOclExpression, newOclExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EStructuralFeature getReferredProperty() {
		if (referredProperty != null && referredProperty.eIsProxy()) {
			InternalEObject oldReferredProperty = (InternalEObject)referredProperty;
			referredProperty = (EStructuralFeature)eResolveProxy(oldReferredProperty);
			if (referredProperty != oldReferredProperty) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTrCSTPackage.PROPERTY_TEMPLATE_CS__REFERRED_PROPERTY, oldReferredProperty, referredProperty));
			}
		}
		return referredProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EStructuralFeature basicGetReferredProperty() {
		return referredProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferredProperty(EStructuralFeature newReferredProperty) {
		EStructuralFeature oldReferredProperty = referredProperty;
		referredProperty = newReferredProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrCSTPackage.PROPERTY_TEMPLATE_CS__REFERRED_PROPERTY, oldReferredProperty, referredProperty));
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
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrCSTPackage.PROPERTY_TEMPLATE_CS__OPPOSITE, oldOpposite, opposite));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTrCSTPackage.PROPERTY_TEMPLATE_CS__PROPERTY_ID:
				return basicSetPropertyId(null, msgs);
			case QVTrCSTPackage.PROPERTY_TEMPLATE_CS__OCL_EXPRESSION:
				return basicSetOclExpression(null, msgs);
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
			case QVTrCSTPackage.PROPERTY_TEMPLATE_CS__PROPERTY_ID:
				return getPropertyId();
			case QVTrCSTPackage.PROPERTY_TEMPLATE_CS__OCL_EXPRESSION:
				return getOclExpression();
			case QVTrCSTPackage.PROPERTY_TEMPLATE_CS__REFERRED_PROPERTY:
				if (resolve) return getReferredProperty();
				return basicGetReferredProperty();
			case QVTrCSTPackage.PROPERTY_TEMPLATE_CS__OPPOSITE:
				return isOpposite() ? Boolean.TRUE : Boolean.FALSE;
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
			case QVTrCSTPackage.PROPERTY_TEMPLATE_CS__PROPERTY_ID:
				setPropertyId((IdentifiedCS)newValue);
				return;
			case QVTrCSTPackage.PROPERTY_TEMPLATE_CS__OCL_EXPRESSION:
				setOclExpression((OCLExpressionCS)newValue);
				return;
			case QVTrCSTPackage.PROPERTY_TEMPLATE_CS__REFERRED_PROPERTY:
				setReferredProperty((EStructuralFeature)newValue);
				return;
			case QVTrCSTPackage.PROPERTY_TEMPLATE_CS__OPPOSITE:
				setOpposite(((Boolean)newValue).booleanValue());
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
			case QVTrCSTPackage.PROPERTY_TEMPLATE_CS__PROPERTY_ID:
				setPropertyId((IdentifiedCS)null);
				return;
			case QVTrCSTPackage.PROPERTY_TEMPLATE_CS__OCL_EXPRESSION:
				setOclExpression((OCLExpressionCS)null);
				return;
			case QVTrCSTPackage.PROPERTY_TEMPLATE_CS__REFERRED_PROPERTY:
				setReferredProperty((EStructuralFeature)null);
				return;
			case QVTrCSTPackage.PROPERTY_TEMPLATE_CS__OPPOSITE:
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
			case QVTrCSTPackage.PROPERTY_TEMPLATE_CS__PROPERTY_ID:
				return propertyId != null;
			case QVTrCSTPackage.PROPERTY_TEMPLATE_CS__OCL_EXPRESSION:
				return oclExpression != null;
			case QVTrCSTPackage.PROPERTY_TEMPLATE_CS__REFERRED_PROPERTY:
				return referredProperty != null;
			case QVTrCSTPackage.PROPERTY_TEMPLATE_CS__OPPOSITE:
				return opposite != OPPOSITE_EDEFAULT;
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

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (opposite: ");
		result.append(opposite);
		result.append(')');
		return result.toString();
	}

} //PropertyTemplateCSImpl
