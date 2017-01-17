/**
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.umlx.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.umlx.RelInvocationEdge;
import org.eclipse.qvtd.umlx.RelPatternNode;
import org.eclipse.qvtd.umlx.UMLXPackage;
import org.eclipse.qvtd.umlx.util.UMLXVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rel Invocation Edge</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.RelInvocationEdgeImpl#getReferredRelPatternNode <em>Referred Rel Pattern Node</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RelInvocationEdgeImpl extends UMLXEdgeImpl implements RelInvocationEdge {
	/**
	 * The cached value of the '{@link #getReferredRelPatternNode() <em>Referred Rel Pattern Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredRelPatternNode()
	 * @generated
	 * @ordered
	 */
	protected RelPatternNode referredRelPatternNode;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RelInvocationEdgeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLXPackage.Literals.REL_INVOCATION_EDGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RelPatternNode getReferredRelPatternNode() {
		if (referredRelPatternNode != null && referredRelPatternNode.eIsProxy()) {
			InternalEObject oldReferredRelPatternNode = (InternalEObject)referredRelPatternNode;
			referredRelPatternNode = (RelPatternNode)eResolveProxy(oldReferredRelPatternNode);
			if (referredRelPatternNode != oldReferredRelPatternNode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLXPackage.REL_INVOCATION_EDGE__REFERRED_REL_PATTERN_NODE, oldReferredRelPatternNode, referredRelPatternNode));
			}
		}
		return referredRelPatternNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelPatternNode basicGetReferredRelPatternNode() {
		return referredRelPatternNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferredRelPatternNode(RelPatternNode newReferredRelPatternNode) {
		RelPatternNode oldReferredRelPatternNode = referredRelPatternNode;
		referredRelPatternNode = newReferredRelPatternNode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLXPackage.REL_INVOCATION_EDGE__REFERRED_REL_PATTERN_NODE, oldReferredRelPatternNode, referredRelPatternNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UMLXPackage.REL_INVOCATION_EDGE__REFERRED_REL_PATTERN_NODE:
				if (resolve) return getReferredRelPatternNode();
				return basicGetReferredRelPatternNode();
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
			case UMLXPackage.REL_INVOCATION_EDGE__REFERRED_REL_PATTERN_NODE:
				setReferredRelPatternNode((RelPatternNode)newValue);
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
			case UMLXPackage.REL_INVOCATION_EDGE__REFERRED_REL_PATTERN_NODE:
				setReferredRelPatternNode((RelPatternNode)null);
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
			case UMLXPackage.REL_INVOCATION_EDGE__REFERRED_REL_PATTERN_NODE:
				return referredRelPatternNode != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull UMLXVisitor<R> visitor) {
		return visitor.visitRelInvocationEdge(this);
	}

} //RelInvocationEdgeImpl
