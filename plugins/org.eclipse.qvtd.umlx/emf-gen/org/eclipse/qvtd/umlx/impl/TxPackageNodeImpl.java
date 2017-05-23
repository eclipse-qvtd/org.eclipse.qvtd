/**
 * Copyright (c) 2016, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
			importAliases = new EDataTypeUniqueEList<String>(String.class, this, UMLXPackage.TX_PACKAGE_NODE__IMPORT_ALIASES);
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
		if (eContainerFeatureID() != UMLXPackage.TX_PACKAGE_NODE__OWNING_TX_DIAGRAM) return null;
		return (TxDiagram)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningTxDiagram(TxDiagram newOwningTxDiagram, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningTxDiagram, UMLXPackage.TX_PACKAGE_NODE__OWNING_TX_DIAGRAM, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningTxDiagram(TxDiagram newOwningTxDiagram) {
		if (newOwningTxDiagram != eInternalContainer() || (eContainerFeatureID() != UMLXPackage.TX_PACKAGE_NODE__OWNING_TX_DIAGRAM && newOwningTxDiagram != null)) {
			if (EcoreUtil.isAncestor(this, newOwningTxDiagram))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningTxDiagram != null)
				msgs = ((InternalEObject)newOwningTxDiagram).eInverseAdd(this, UMLXPackage.TX_DIAGRAM__OWNED_TX_PACKAGE_NODES, TxDiagram.class, msgs);
			msgs = basicSetOwningTxDiagram(newOwningTxDiagram, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLXPackage.TX_PACKAGE_NODE__OWNING_TX_DIAGRAM, newOwningTxDiagram, newOwningTxDiagram));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLXPackage.TX_PACKAGE_NODE__REFERRED_EPACKAGE, oldReferredEPackage, referredEPackage));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLXPackage.TX_PACKAGE_NODE__REFERRED_EPACKAGE, oldReferredEPackage, referredEPackage));
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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLXPackage.TX_PACKAGE_NODE__OWNING_TX_DIAGRAM:
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
			case UMLXPackage.TX_PACKAGE_NODE__OWNING_TX_DIAGRAM:
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
			case UMLXPackage.TX_PACKAGE_NODE__OWNING_TX_DIAGRAM:
				return eInternalContainer().eInverseRemove(this, UMLXPackage.TX_DIAGRAM__OWNED_TX_PACKAGE_NODES, TxDiagram.class, msgs);
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
			case UMLXPackage.TX_PACKAGE_NODE__IMPORT_ALIASES:
				return getImportAliases();
			case UMLXPackage.TX_PACKAGE_NODE__OWNING_TX_DIAGRAM:
				return getOwningTxDiagram();
			case UMLXPackage.TX_PACKAGE_NODE__REFERRED_EPACKAGE:
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
			case UMLXPackage.TX_PACKAGE_NODE__IMPORT_ALIASES:
				getImportAliases().clear();
				getImportAliases().addAll((Collection<? extends String>)newValue);
				return;
			case UMLXPackage.TX_PACKAGE_NODE__OWNING_TX_DIAGRAM:
				setOwningTxDiagram((TxDiagram)newValue);
				return;
			case UMLXPackage.TX_PACKAGE_NODE__REFERRED_EPACKAGE:
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
			case UMLXPackage.TX_PACKAGE_NODE__IMPORT_ALIASES:
				getImportAliases().clear();
				return;
			case UMLXPackage.TX_PACKAGE_NODE__OWNING_TX_DIAGRAM:
				setOwningTxDiagram((TxDiagram)null);
				return;
			case UMLXPackage.TX_PACKAGE_NODE__REFERRED_EPACKAGE:
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
			case UMLXPackage.TX_PACKAGE_NODE__IMPORT_ALIASES:
				return importAliases != null && !importAliases.isEmpty();
			case UMLXPackage.TX_PACKAGE_NODE__OWNING_TX_DIAGRAM:
				return getOwningTxDiagram() != null;
			case UMLXPackage.TX_PACKAGE_NODE__REFERRED_EPACKAGE:
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
