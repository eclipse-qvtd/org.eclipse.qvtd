/**
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simplerdbms.ForeignKey;

import org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simplerdbms.Key;
import org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.Association;

import org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.AssociationToForeignKey;
import org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.ClassToTable;
import org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.Simpleuml2rdbmsPackage;
import org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.UmlToRdbmsModelElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Association To Foreign Key</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.impl.AssociationToForeignKeyImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.impl.AssociationToForeignKeyImpl#getAssociation <em>Association</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.impl.AssociationToForeignKeyImpl#getForeignKey <em>Foreign Key</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.impl.AssociationToForeignKeyImpl#getKey <em>Key</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.impl.AssociationToForeignKeyImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.impl.AssociationToForeignKeyImpl#getReferenced <em>Referenced</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AssociationToForeignKeyImpl extends ToColumnImpl implements AssociationToForeignKey {
	/**
	 * The number of structural features of the '<em>Association To Foreign Key</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ASSOCIATION_TO_FOREIGN_KEY_FEATURE_COUNT = ToColumnImpl.TO_COLUMN_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Association To Foreign Key</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ASSOCIATION_TO_FOREIGN_KEY_OPERATION_COUNT = ToColumnImpl.TO_COLUMN_OPERATION_COUNT + 0;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAssociation() <em>Association</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociation()
	 * @generated
	 * @ordered
	 */
	protected Association association;

	/**
	 * The cached value of the '{@link #getForeignKey() <em>Foreign Key</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForeignKey()
	 * @generated
	 * @ordered
	 */
	protected ForeignKey foreignKey;

	/**
	 * The cached value of the '{@link #getKey() <em>Key</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKey()
	 * @generated
	 * @ordered
	 */
	protected Key key;

	/**
	 * The cached value of the '{@link #getReferenced() <em>Referenced</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferenced()
	 * @generated
	 * @ordered
	 */
	protected ClassToTable referenced;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssociationToForeignKeyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Simpleuml2rdbmsPackage.Literals.ASSOCIATION_TO_FOREIGN_KEY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 1, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Association getAssociation() {
		if (association != null && association.eIsProxy()) {
			InternalEObject oldAssociation = (InternalEObject)association;
			association = (Association)eResolveProxy(oldAssociation);
			if (association != oldAssociation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, 2, oldAssociation, association));
			}
		}
		return association;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Association basicGetAssociation() {
		return association;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAssociation(Association newAssociation) {
		Association oldAssociation = association;
		association = newAssociation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 2, oldAssociation, association));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ForeignKey getForeignKey() {
		if (foreignKey != null && foreignKey.eIsProxy()) {
			InternalEObject oldForeignKey = (InternalEObject)foreignKey;
			foreignKey = (ForeignKey)eResolveProxy(oldForeignKey);
			if (foreignKey != oldForeignKey) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, 3, oldForeignKey, foreignKey));
			}
		}
		return foreignKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForeignKey basicGetForeignKey() {
		return foreignKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setForeignKey(ForeignKey newForeignKey) {
		ForeignKey oldForeignKey = foreignKey;
		foreignKey = newForeignKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 3, oldForeignKey, foreignKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Key getKey() {
		if (key != null && key.eIsProxy()) {
			InternalEObject oldKey = (InternalEObject)key;
			key = (Key)eResolveProxy(oldKey);
			if (key != oldKey) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, 4, oldKey, key));
			}
		}
		return key;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Key basicGetKey() {
		return key;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setKey(Key newKey) {
		Key oldKey = key;
		key = newKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 4, oldKey, key));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ClassToTable getOwner() {
		if (eContainerFeatureID() != (5)) return null;
		return (ClassToTable)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwner(ClassToTable newOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwner, 5, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwner(ClassToTable newOwner) {
		if (newOwner != eInternalContainer() || (eContainerFeatureID() != (5) && newOwner != null)) {
			if (EcoreUtil.isAncestor(this, newOwner))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwner != null)
				msgs = ((InternalEObject)newOwner).eInverseAdd(this, 3, ClassToTable.class, msgs);
			msgs = basicSetOwner(newOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 5, newOwner, newOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ClassToTable getReferenced() {
		if (referenced != null && referenced.eIsProxy()) {
			InternalEObject oldReferenced = (InternalEObject)referenced;
			referenced = (ClassToTable)eResolveProxy(oldReferenced);
			if (referenced != oldReferenced) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, 6, oldReferenced, referenced));
			}
		}
		return referenced;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassToTable basicGetReferenced() {
		return referenced;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferenced(ClassToTable newReferenced) {
		ClassToTable oldReferenced = referenced;
		referenced = newReferenced;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 6, oldReferenced, referenced));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case 5:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwner((ClassToTable)otherEnd, msgs);
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
			case 5:
				return basicSetOwner(null, msgs);
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
			case 5:
				return eInternalContainer().eInverseRemove(this, 3, ClassToTable.class, msgs);
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
			case 1:
				return getName();
			case 2:
				if (resolve) return getAssociation();
				return basicGetAssociation();
			case 3:
				if (resolve) return getForeignKey();
				return basicGetForeignKey();
			case 4:
				if (resolve) return getKey();
				return basicGetKey();
			case 5:
				return getOwner();
			case 6:
				if (resolve) return getReferenced();
				return basicGetReferenced();
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
			case 1:
				setName((String)newValue);
				return;
			case 2:
				setAssociation((Association)newValue);
				return;
			case 3:
				setForeignKey((ForeignKey)newValue);
				return;
			case 4:
				setKey((Key)newValue);
				return;
			case 5:
				setOwner((ClassToTable)newValue);
				return;
			case 6:
				setReferenced((ClassToTable)newValue);
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
			case 1:
				setName(NAME_EDEFAULT);
				return;
			case 2:
				setAssociation((Association)null);
				return;
			case 3:
				setForeignKey((ForeignKey)null);
				return;
			case 4:
				setKey((Key)null);
				return;
			case 5:
				setOwner((ClassToTable)null);
				return;
			case 6:
				setReferenced((ClassToTable)null);
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
			case 1:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case 2:
				return association != null;
			case 3:
				return foreignKey != null;
			case 4:
				return key != null;
			case 5:
				return getOwner() != null;
			case 6:
				return referenced != null;
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
		if (baseClass == UmlToRdbmsModelElement.class) {
			switch (derivedFeatureID) {
				case 1: return 0;
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
		if (baseClass == UmlToRdbmsModelElement.class) {
			switch (baseFeatureID) {
				case 0: return 1;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}


} //AssociationToForeignKeyImpl
