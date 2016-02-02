/**
 * <copyright>
 * 
 * Copyright (c) 2013, 2015 Willink Transformations and others.
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
package org.eclipse.qvtd.pivot.qvtbase.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.jdt.annotation.NonNull;

import org.eclipse.ocl.pivot.Element;

import org.eclipse.ocl.pivot.internal.ElementImpl;

import org.eclipse.ocl.pivot.util.Visitor;

import org.eclipse.qvtd.pivot.qvtbase.DebugTraceBack;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;

import org.eclipse.qvtd.pivot.qvtbase.util.QVTbaseVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Debug Trace Back</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.impl.DebugTraceBackImpl#getOwningTransformation <em>Owning Transformation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.impl.DebugTraceBackImpl#getSources <em>Sources</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.impl.DebugTraceBackImpl#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DebugTraceBackImpl extends ElementImpl implements DebugTraceBack {
	/**
	 * The cached value of the '{@link #getSources() <em>Sources</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSources()
	 * @generated
	 * @ordered
	 */
	protected EList<Element> sources;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected Element target;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DebugTraceBackImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTbasePackage.Literals.DEBUG_TRACE_BACK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Transformation getOwningTransformation() {
		if (eContainerFeatureID() != QVTbasePackage.DEBUG_TRACE_BACK__OWNING_TRANSFORMATION) return null;
		return (Transformation)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningTransformation(Transformation newOwningTransformation, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningTransformation, QVTbasePackage.DEBUG_TRACE_BACK__OWNING_TRANSFORMATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningTransformation(Transformation newOwningTransformation) {
		if (newOwningTransformation != eInternalContainer() || (eContainerFeatureID() != QVTbasePackage.DEBUG_TRACE_BACK__OWNING_TRANSFORMATION && newOwningTransformation != null)) {
			if (EcoreUtil.isAncestor(this, newOwningTransformation))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningTransformation != null)
				msgs = ((InternalEObject)newOwningTransformation).eInverseAdd(this, QVTbasePackage.TRANSFORMATION__OWNED_DEBUG_TRACE_BACKS, Transformation.class, msgs);
			msgs = basicSetOwningTransformation(newOwningTransformation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTbasePackage.DEBUG_TRACE_BACK__OWNING_TRANSFORMATION, newOwningTransformation, newOwningTransformation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")
	@Override
	public @NonNull EList<Element> getSources() {
		if (sources == null) {
			sources = new EObjectResolvingEList<Element>(Element.class, this, QVTbasePackage.DEBUG_TRACE_BACK__SOURCES);
		}
		return sources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Element getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (Element)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTbasePackage.DEBUG_TRACE_BACK__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTarget(Element newTarget) {
		Element oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTbasePackage.DEBUG_TRACE_BACK__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTbasePackage.DEBUG_TRACE_BACK__OWNING_TRANSFORMATION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningTransformation((Transformation)otherEnd, msgs);
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
			case QVTbasePackage.DEBUG_TRACE_BACK__OWNING_TRANSFORMATION:
				return basicSetOwningTransformation(null, msgs);
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
			case QVTbasePackage.DEBUG_TRACE_BACK__OWNING_TRANSFORMATION:
				return eInternalContainer().eInverseRemove(this, QVTbasePackage.TRANSFORMATION__OWNED_DEBUG_TRACE_BACKS, Transformation.class, msgs);
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
			case QVTbasePackage.DEBUG_TRACE_BACK__OWNING_TRANSFORMATION:
				return getOwningTransformation();
			case QVTbasePackage.DEBUG_TRACE_BACK__SOURCES:
				return getSources();
			case QVTbasePackage.DEBUG_TRACE_BACK__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case QVTbasePackage.DEBUG_TRACE_BACK__OWNING_TRANSFORMATION:
				setOwningTransformation((Transformation)newValue);
				return;
			case QVTbasePackage.DEBUG_TRACE_BACK__SOURCES:
				getSources().clear();
				getSources().addAll((Collection<? extends Element>)newValue);
				return;
			case QVTbasePackage.DEBUG_TRACE_BACK__TARGET:
				setTarget((Element)newValue);
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
			case QVTbasePackage.DEBUG_TRACE_BACK__OWNING_TRANSFORMATION:
				setOwningTransformation((Transformation)null);
				return;
			case QVTbasePackage.DEBUG_TRACE_BACK__SOURCES:
				getSources().clear();
				return;
			case QVTbasePackage.DEBUG_TRACE_BACK__TARGET:
				setTarget((Element)null);
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
			case QVTbasePackage.DEBUG_TRACE_BACK__OWNING_TRANSFORMATION:
				return getOwningTransformation() != null;
			case QVTbasePackage.DEBUG_TRACE_BACK__SOURCES:
				return sources != null && !sources.isEmpty();
			case QVTbasePackage.DEBUG_TRACE_BACK__TARGET:
				return target != null;
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
		return (R) ((QVTbaseVisitor<?>)visitor).visitDebugTraceBack(this);
	}

} //DebugTraceBackImpl
