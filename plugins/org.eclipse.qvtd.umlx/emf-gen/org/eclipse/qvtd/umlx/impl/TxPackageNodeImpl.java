/**
 * Copyright (c) 2016, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.umlx.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.umlx.TxDiagram;
import org.eclipse.qvtd.umlx.TxPackageNode;
import org.eclipse.qvtd.umlx.UMLXPackage;
import org.eclipse.qvtd.umlx.util.UMLXVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tx Package Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.TxPackageNodeImpl#getImportAliases <em>Import Aliases</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.TxPackageNodeImpl#getOwningTxDiagram <em>Owning Tx Diagram</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.TxPackageNodeImpl#getReferredEPackage <em>Referred EPackage</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TxPackageNodeImpl extends TxNodeImpl implements TxPackageNode {
	/**
	 * The number of structural features of the '<em>Tx Package Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TX_PACKAGE_NODE_FEATURE_COUNT = TxNodeImpl.TX_NODE_FEATURE_COUNT + 3;
	/**
	 * The cached value of the '{@link #getImportAliases() <em>Import Aliases</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImportAliases()
	 * @generated
	 * @ordered
	 */
	protected EList<String> importAliases;
	/**
	 * The cached value of the '{@link #getReferredEPackage() <em>Referred EPackage</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredEPackage()
	 * @generated
	 * @ordered
	 */
	protected EPackage referredEPackage;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TxPackageNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLXPackage.Literals.TX_PACKAGE_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getImportAliases() {
		if (importAliases == null) {
			importAliases = new EDataTypeUniqueEList<String>(String.class, this, TxNodeImpl.TX_NODE_FEATURE_COUNT + 0);
		}
		return importAliases;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TxDiagram getOwningTxDiagram() {
		if (eContainerFeatureID() != (TxNodeImpl.TX_NODE_FEATURE_COUNT + 1)) return null;
		return (TxDiagram)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningTxDiagram(TxDiagram newOwningTxDiagram, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningTxDiagram, TxNodeImpl.TX_NODE_FEATURE_COUNT + 1, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningTxDiagram(TxDiagram newOwningTxDiagram) {
		if (newOwningTxDiagram != eInternalContainer() || (eContainerFeatureID() != (TxNodeImpl.TX_NODE_FEATURE_COUNT + 1) && newOwningTxDiagram != null)) {
			if (EcoreUtil.isAncestor(this, newOwningTxDiagram))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningTxDiagram != null)
				msgs = ((InternalEObject)newOwningTxDiagram).eInverseAdd(this, UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 2, TxDiagram.class, msgs);
			msgs = basicSetOwningTxDiagram(newOwningTxDiagram, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TxNodeImpl.TX_NODE_FEATURE_COUNT + 1, newOwningTxDiagram, newOwningTxDiagram));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EPackage getReferredEPackage() {
		if (referredEPackage != null && referredEPackage.eIsProxy()) {
			InternalEObject oldReferredEPackage = (InternalEObject)referredEPackage;
			referredEPackage = (EPackage)eResolveProxy(oldReferredEPackage);
			if (referredEPackage != oldReferredEPackage) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TxNodeImpl.TX_NODE_FEATURE_COUNT + 2, oldReferredEPackage, referredEPackage));
			}
		}
		return referredEPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPackage basicGetReferredEPackage() {
		return referredEPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferredEPackage(EPackage newReferredEPackage) {
		EPackage oldReferredEPackage = referredEPackage;
		referredEPackage = newReferredEPackage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TxNodeImpl.TX_NODE_FEATURE_COUNT + 2, oldReferredEPackage, referredEPackage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (importAliases: ");
		result.append(importAliases);
		result.append(')');
		return result.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TxNodeImpl.TX_NODE_FEATURE_COUNT + 1:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningTxDiagram((TxDiagram)otherEnd, msgs);
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
			case TxNodeImpl.TX_NODE_FEATURE_COUNT + 1:
				return basicSetOwningTxDiagram(null, msgs);
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
			case TxNodeImpl.TX_NODE_FEATURE_COUNT + 1:
				return eInternalContainer().eInverseRemove(this, UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 2, TxDiagram.class, msgs);
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
			case TxNodeImpl.TX_NODE_FEATURE_COUNT + 0:
				return getImportAliases();
			case TxNodeImpl.TX_NODE_FEATURE_COUNT + 1:
				return getOwningTxDiagram();
			case TxNodeImpl.TX_NODE_FEATURE_COUNT + 2:
				if (resolve) return getReferredEPackage();
				return basicGetReferredEPackage();
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
			case TxNodeImpl.TX_NODE_FEATURE_COUNT + 0:
				getImportAliases().clear();
				getImportAliases().addAll((Collection<? extends String>)newValue);
				return;
			case TxNodeImpl.TX_NODE_FEATURE_COUNT + 1:
				setOwningTxDiagram((TxDiagram)newValue);
				return;
			case TxNodeImpl.TX_NODE_FEATURE_COUNT + 2:
				setReferredEPackage((EPackage)newValue);
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
			case TxNodeImpl.TX_NODE_FEATURE_COUNT + 0:
				getImportAliases().clear();
				return;
			case TxNodeImpl.TX_NODE_FEATURE_COUNT + 1:
				setOwningTxDiagram((TxDiagram)null);
				return;
			case TxNodeImpl.TX_NODE_FEATURE_COUNT + 2:
				setReferredEPackage((EPackage)null);
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
			case TxNodeImpl.TX_NODE_FEATURE_COUNT + 0:
				return importAliases != null && !importAliases.isEmpty();
			case TxNodeImpl.TX_NODE_FEATURE_COUNT + 1:
				return getOwningTxDiagram() != null;
			case TxNodeImpl.TX_NODE_FEATURE_COUNT + 2:
				return referredEPackage != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull UMLXVisitor<R> visitor) {
		return visitor.visitTxPackageNode(this);
	}

} //TxPackageNodeImpl
