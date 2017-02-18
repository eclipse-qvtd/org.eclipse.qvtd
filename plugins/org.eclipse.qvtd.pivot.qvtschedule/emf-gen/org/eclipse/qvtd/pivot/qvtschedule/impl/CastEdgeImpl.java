/**
 * <copyright>
 *
 * Copyright (c) 2013, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.pivot.qvtschedule.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.pivot.qvtschedule.CastEdge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleFactory;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.util.QVTscheduleVisitor;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cast Edge</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.CastEdgeImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.CastEdgeImpl#getReferredClass <em>Referred Class</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CastEdgeImpl extends NavigableEdgeImpl implements CastEdge {
	/**
	 * The cached value of the '{@link #getReferredClass() <em>Referred Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredClass()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.ocl.pivot.Class referredClass;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CastEdgeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.CAST_EDGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QVTschedulePackage.CAST_EDGE__PROPERTY:
				return getProperty();
			case QVTschedulePackage.CAST_EDGE__REFERRED_CLASS:
				if (resolve) return getReferredClass();
				return basicGetReferredClass();
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
			case QVTschedulePackage.CAST_EDGE__REFERRED_CLASS:
				setReferredClass((org.eclipse.ocl.pivot.Class)newValue);
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
			case QVTschedulePackage.CAST_EDGE__REFERRED_CLASS:
				setReferredClass((org.eclipse.ocl.pivot.Class)null);
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
			case QVTschedulePackage.CAST_EDGE__PROPERTY:
				return getProperty() != null;
			case QVTschedulePackage.CAST_EDGE__REFERRED_CLASS:
				return referredClass != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return (R) ((QVTscheduleVisitor<?>)visitor).visitCastEdge(this);
	}

	private Property property;

	@Override
	public @NonNull NavigableEdge createEdge(@NonNull Role edgeRole, @NonNull Node sourceNode, @NonNull Node targetNode) {
		CastEdge castEdge = (CastEdge) super.createEdge(edgeRole, sourceNode, targetNode);
		castEdge.initializeProperty(QVTscheduleUtil.getProperty(this));
		return castEdge;
	}

	@Override
	public Property getProperty() {
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.eclipse.ocl.pivot.Class getReferredClass() {
		if (referredClass != null && referredClass.eIsProxy()) {
			InternalEObject oldReferredClass = (InternalEObject)referredClass;
			referredClass = (org.eclipse.ocl.pivot.Class)eResolveProxy(oldReferredClass);
			if (referredClass != oldReferredClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTschedulePackage.CAST_EDGE__REFERRED_CLASS, oldReferredClass, referredClass));
			}
		}
		return referredClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.ocl.pivot.Class basicGetReferredClass() {
		return referredClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferredClass(org.eclipse.ocl.pivot.Class newReferredClass) {
		org.eclipse.ocl.pivot.Class oldReferredClass = referredClass;
		referredClass = newReferredClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.CAST_EDGE__REFERRED_CLASS, oldReferredClass, referredClass));
	}

	@Override
	public void initializeProperty(@NonNull Property property) {
		setProperty(property);
		Property target2sourceProperty = property.getOpposite();
		if (target2sourceProperty != null) {
			Node targetNode2 = targetNode;
			assert targetNode2 != null;
			if (!targetNode2.isExplicitNull()) {
				assert (targetNode2.getNavigationEdge(target2sourceProperty) == null) || target2sourceProperty.isIsMany();
				if (!property.isIsMany() && !target2sourceProperty.isIsMany() /*&& target2sourceProperty.isIsRequired()*/) {		// FIXME do we need stronger type conformance here ??
					Role edgeRole2 = edgeRole;
					Node sourceNode2 = sourceNode;
					assert (edgeRole2 != null) && (sourceNode2 != null);
					CastEdgeImpl reverseEdge = (CastEdgeImpl) QVTscheduleFactory.eINSTANCE.createCastEdge();
					reverseEdge.initialize(edgeRole2, targetNode2, target2sourceProperty.getName(), sourceNode2);
					reverseEdge.setProperty(target2sourceProperty);
					initializeOpposite(reverseEdge);
				}
			}
		}
	}

	@Override
	public final boolean isCast() {
		return true;
	}

	@Override
	public final boolean isNavigation() {
		return true;
	}

	@Override
	public void setEdgeRole(Role edgeRole) {
		assert !edgeRole.isNew();
		super.setEdgeRole(edgeRole);
	}

	private void setProperty(@NonNull Property property) {
		this.property = property;
		setReferredClass(PivotUtil.getClass(property));
	}

	@Override
	public void setSource(@Nullable Node sourceNode) {
		assert (sourceNode == null) || !sourceNode.isExplicitNull();
		super.setSource(sourceNode);
	}

	@Override
	public void setTarget(@Nullable Node targetNode) {
		assert (targetNode == null) || !targetNode.isExplicitNull();
		super.setTarget(targetNode);
	}
} //CastEdgeImpl
