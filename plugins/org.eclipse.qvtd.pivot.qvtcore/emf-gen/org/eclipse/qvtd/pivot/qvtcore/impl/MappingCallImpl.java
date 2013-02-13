/**
 * <copyright>
 *
 * Copyright (c) 2013 E.D.Willink and others.
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
package org.eclipse.qvtd.pivot.qvtcore.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ReferringElement;
import org.eclipse.ocl.examples.pivot.internal.impl.OCLExpressionImpl;
import org.eclipse.ocl.examples.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.MappingCall;
import org.eclipse.qvtd.pivot.qvtcore.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtcore.NestedMapping;
import org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage;
import org.eclipse.qvtd.pivot.qvtcore.util.QVTcoreVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtcore.impl.MappingCallImpl#getContext <em>Context</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtcore.impl.MappingCallImpl#getReferredMapping <em>Referred Mapping</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtcore.impl.MappingCallImpl#getBinding <em>Binding</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MappingCallImpl extends OCLExpressionImpl implements MappingCall {
	/**
	 * The cached value of the '{@link #getReferredMapping() <em>Referred Mapping</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredMapping()
	 * @generated
	 * @ordered
	 */
	protected Mapping referredMapping;

	/**
	 * The cached value of the '{@link #getBinding() <em>Binding</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBinding()
	 * @generated
	 * @ordered
	 */
	protected EList<MappingCallBinding> binding;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingCallImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTcorePackage.Literals.MAPPING_CALL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mapping getContext() {
		if (eContainerFeatureID() != QVTcorePackage.MAPPING_CALL__CONTEXT) return null;
		return (Mapping)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContext(Mapping newContext, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newContext, QVTcorePackage.MAPPING_CALL__CONTEXT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContext(Mapping newContext) {
		if (newContext != eInternalContainer() || (eContainerFeatureID() != QVTcorePackage.MAPPING_CALL__CONTEXT && newContext != null)) {
			if (EcoreUtil.isAncestor(this, newContext))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newContext != null)
				msgs = ((InternalEObject)newContext).eInverseAdd(this, QVTcorePackage.MAPPING__LOCAL, Mapping.class, msgs);
			msgs = basicSetContext(newContext, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTcorePackage.MAPPING_CALL__CONTEXT, newContext, newContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mapping getReferredMapping() {
		if (referredMapping != null && referredMapping.eIsProxy()) {
			InternalEObject oldReferredMapping = (InternalEObject)referredMapping;
			referredMapping = (Mapping)eResolveProxy(oldReferredMapping);
			if (referredMapping != oldReferredMapping) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTcorePackage.MAPPING_CALL__REFERRED_MAPPING, oldReferredMapping, referredMapping));
			}
		}
		return referredMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mapping basicGetReferredMapping() {
		return referredMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferredMapping(Mapping newReferredMapping) {
		Mapping oldReferredMapping = referredMapping;
		referredMapping = newReferredMapping;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTcorePackage.MAPPING_CALL__REFERRED_MAPPING, oldReferredMapping, referredMapping));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MappingCallBinding> getBinding() {
		if (binding == null) {
			binding = new EObjectContainmentWithInverseEList<MappingCallBinding>(MappingCallBinding.class, this, QVTcorePackage.MAPPING_CALL__BINDING, QVTcorePackage.MAPPING_CALL_BINDING__MAPPING_CALL);
		}
		return binding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Element getReferredElement() {
		return getReferredMapping();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTcorePackage.MAPPING_CALL__CONTEXT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetContext((Mapping)otherEnd, msgs);
			case QVTcorePackage.MAPPING_CALL__BINDING:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getBinding()).basicAdd(otherEnd, msgs);
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
			case QVTcorePackage.MAPPING_CALL__CONTEXT:
				return basicSetContext(null, msgs);
			case QVTcorePackage.MAPPING_CALL__BINDING:
				return ((InternalEList<?>)getBinding()).basicRemove(otherEnd, msgs);
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
			case QVTcorePackage.MAPPING_CALL__CONTEXT:
				return eInternalContainer().eInverseRemove(this, QVTcorePackage.MAPPING__LOCAL, Mapping.class, msgs);
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
			case QVTcorePackage.MAPPING_CALL__CONTEXT:
				return getContext();
			case QVTcorePackage.MAPPING_CALL__REFERRED_MAPPING:
				if (resolve) return getReferredMapping();
				return basicGetReferredMapping();
			case QVTcorePackage.MAPPING_CALL__BINDING:
				return getBinding();
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
			case QVTcorePackage.MAPPING_CALL__CONTEXT:
				setContext((Mapping)newValue);
				return;
			case QVTcorePackage.MAPPING_CALL__REFERRED_MAPPING:
				setReferredMapping((Mapping)newValue);
				return;
			case QVTcorePackage.MAPPING_CALL__BINDING:
				getBinding().clear();
				getBinding().addAll((Collection<? extends MappingCallBinding>)newValue);
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
			case QVTcorePackage.MAPPING_CALL__CONTEXT:
				setContext((Mapping)null);
				return;
			case QVTcorePackage.MAPPING_CALL__REFERRED_MAPPING:
				setReferredMapping((Mapping)null);
				return;
			case QVTcorePackage.MAPPING_CALL__BINDING:
				getBinding().clear();
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
			case QVTcorePackage.MAPPING_CALL__CONTEXT:
				return getContext() != null;
			case QVTcorePackage.MAPPING_CALL__REFERRED_MAPPING:
				return referredMapping != null;
			case QVTcorePackage.MAPPING_CALL__BINDING:
				return binding != null && !binding.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == NestedMapping.class) {
			switch (derivedFeatureID) {
				case QVTcorePackage.MAPPING_CALL__CONTEXT: return QVTcorePackage.NESTED_MAPPING__CONTEXT;
				default: return -1;
			}
		}
		if (baseClass == ReferringElement.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == NestedMapping.class) {
			switch (baseFeatureID) {
				case QVTcorePackage.NESTED_MAPPING__CONTEXT: return QVTcorePackage.MAPPING_CALL__CONTEXT;
				default: return -1;
			}
		}
		if (baseClass == ReferringElement.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return ((QVTcoreVisitor<R>)visitor).visitMappingCall(this);
	}
} //MappingCallImpl
