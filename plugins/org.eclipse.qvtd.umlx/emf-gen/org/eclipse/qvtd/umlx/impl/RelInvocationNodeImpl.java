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
import org.eclipse.qvtd.umlx.RelDiagram;
import org.eclipse.qvtd.umlx.RelInvocationNode;
import org.eclipse.qvtd.umlx.UMLXPackage;
import org.eclipse.qvtd.umlx.util.UMLXVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rel Invocation Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.RelInvocationNodeImpl#isIsThen <em>Is Then</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.RelInvocationNodeImpl#getReferredRelationNode <em>Referred Relation Node</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RelInvocationNodeImpl extends RelNodeImpl implements RelInvocationNode {
	/**
	 * The default value of the '{@link #isIsThen() <em>Is Then</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsThen()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_THEN_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isIsThen() <em>Is Then</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsThen()
	 * @generated
	 * @ordered
	 */
	protected boolean isThen = IS_THEN_EDEFAULT;

	/**
	 * The cached value of the '{@link #getReferredRelationNode() <em>Referred Relation Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredRelationNode()
	 * @generated
	 * @ordered
	 */
	protected RelDiagram referredRelationNode;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RelInvocationNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLXPackage.Literals.REL_INVOCATION_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsThen() {
		return isThen;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsThen(boolean newIsThen) {
		boolean oldIsThen = isThen;
		isThen = newIsThen;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLXPackage.REL_INVOCATION_NODE__IS_THEN, oldIsThen, isThen));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RelDiagram getReferredRelationNode() {
		if (referredRelationNode != null && referredRelationNode.eIsProxy()) {
			InternalEObject oldReferredRelationNode = (InternalEObject)referredRelationNode;
			referredRelationNode = (RelDiagram)eResolveProxy(oldReferredRelationNode);
			if (referredRelationNode != oldReferredRelationNode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLXPackage.REL_INVOCATION_NODE__REFERRED_RELATION_NODE, oldReferredRelationNode, referredRelationNode));
			}
		}
		return referredRelationNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelDiagram basicGetReferredRelationNode() {
		return referredRelationNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferredRelationNode(RelDiagram newReferredRelationNode) {
		RelDiagram oldReferredRelationNode = referredRelationNode;
		referredRelationNode = newReferredRelationNode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLXPackage.REL_INVOCATION_NODE__REFERRED_RELATION_NODE, oldReferredRelationNode, referredRelationNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UMLXPackage.REL_INVOCATION_NODE__IS_THEN:
				return isIsThen();
			case UMLXPackage.REL_INVOCATION_NODE__REFERRED_RELATION_NODE:
				if (resolve) return getReferredRelationNode();
				return basicGetReferredRelationNode();
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
			case UMLXPackage.REL_INVOCATION_NODE__IS_THEN:
				setIsThen((Boolean)newValue);
				return;
			case UMLXPackage.REL_INVOCATION_NODE__REFERRED_RELATION_NODE:
				setReferredRelationNode((RelDiagram)newValue);
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
			case UMLXPackage.REL_INVOCATION_NODE__IS_THEN:
				setIsThen(IS_THEN_EDEFAULT);
				return;
			case UMLXPackage.REL_INVOCATION_NODE__REFERRED_RELATION_NODE:
				setReferredRelationNode((RelDiagram)null);
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
			case UMLXPackage.REL_INVOCATION_NODE__IS_THEN:
				return isThen != IS_THEN_EDEFAULT;
			case UMLXPackage.REL_INVOCATION_NODE__REFERRED_RELATION_NODE:
				return referredRelationNode != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull UMLXVisitor<R> visitor) {
		return visitor.visitRelInvocationNode(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return super.toString();
	}

} //RelInvocationNodeImpl
