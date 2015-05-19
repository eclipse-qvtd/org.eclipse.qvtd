/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/**
 */
package manualuml2rdbms.uml2rdbms.impl;

import manualuml2rdbms.rdbms.ForeignKey;

import manualuml2rdbms.uml.Association;

import manualuml2rdbms.uml2rdbms.AssociationToForeignKey;
import manualuml2rdbms.uml2rdbms.ClassToTable;
import manualuml2rdbms.uml2rdbms.UML2RDBMSPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Association To Foreign Key</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link manualuml2rdbms.uml2rdbms.impl.AssociationToForeignKeyImpl#getReferenced <em>Referenced</em>}</li>
 *   <li>{@link manualuml2rdbms.uml2rdbms.impl.AssociationToForeignKeyImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link manualuml2rdbms.uml2rdbms.impl.AssociationToForeignKeyImpl#getName <em>Name</em>}</li>
 *   <li>{@link manualuml2rdbms.uml2rdbms.impl.AssociationToForeignKeyImpl#getAssociation <em>Association</em>}</li>
 *   <li>{@link manualuml2rdbms.uml2rdbms.impl.AssociationToForeignKeyImpl#getForeignKey <em>Foreign Key</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AssociationToForeignKeyImpl extends ToColumnImpl implements AssociationToForeignKey {
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
		return UML2RDBMSPackage.Literals.ASSOCIATION_TO_FOREIGN_KEY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassToTable getReferenced() {
		if (referenced != null && referenced.eIsProxy()) {
			InternalEObject oldReferenced = (InternalEObject)referenced;
			referenced = (ClassToTable)eResolveProxy(oldReferenced);
			if (referenced != oldReferenced) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UML2RDBMSPackage.ASSOCIATION_TO_FOREIGN_KEY__REFERENCED, oldReferenced, referenced));
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
	public void setReferenced(ClassToTable newReferenced) {
		ClassToTable oldReferenced = referenced;
		referenced = newReferenced;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UML2RDBMSPackage.ASSOCIATION_TO_FOREIGN_KEY__REFERENCED, oldReferenced, referenced));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassToTable getOwner() {
		if (eContainerFeatureID() != UML2RDBMSPackage.ASSOCIATION_TO_FOREIGN_KEY__OWNER) return null;
		return (ClassToTable)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwner(ClassToTable newOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwner, UML2RDBMSPackage.ASSOCIATION_TO_FOREIGN_KEY__OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(ClassToTable newOwner) {
		if (newOwner != eInternalContainer() || (eContainerFeatureID() != UML2RDBMSPackage.ASSOCIATION_TO_FOREIGN_KEY__OWNER && newOwner != null)) {
			if (EcoreUtil.isAncestor(this, newOwner))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwner != null)
				msgs = ((InternalEObject)newOwner).eInverseAdd(this, UML2RDBMSPackage.CLASS_TO_TABLE__ASSOCIATIONS_TO_FOREIGN_KEYS, ClassToTable.class, msgs);
			msgs = basicSetOwner(newOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UML2RDBMSPackage.ASSOCIATION_TO_FOREIGN_KEY__OWNER, newOwner, newOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UML2RDBMSPackage.ASSOCIATION_TO_FOREIGN_KEY__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Association getAssociation() {
		if (association != null && association.eIsProxy()) {
			InternalEObject oldAssociation = (InternalEObject)association;
			association = (Association)eResolveProxy(oldAssociation);
			if (association != oldAssociation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UML2RDBMSPackage.ASSOCIATION_TO_FOREIGN_KEY__ASSOCIATION, oldAssociation, association));
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
	public void setAssociation(Association newAssociation) {
		Association oldAssociation = association;
		association = newAssociation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UML2RDBMSPackage.ASSOCIATION_TO_FOREIGN_KEY__ASSOCIATION, oldAssociation, association));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForeignKey getForeignKey() {
		if (foreignKey != null && foreignKey.eIsProxy()) {
			InternalEObject oldForeignKey = (InternalEObject)foreignKey;
			foreignKey = (ForeignKey)eResolveProxy(oldForeignKey);
			if (foreignKey != oldForeignKey) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UML2RDBMSPackage.ASSOCIATION_TO_FOREIGN_KEY__FOREIGN_KEY, oldForeignKey, foreignKey));
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
	public void setForeignKey(ForeignKey newForeignKey) {
		ForeignKey oldForeignKey = foreignKey;
		foreignKey = newForeignKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UML2RDBMSPackage.ASSOCIATION_TO_FOREIGN_KEY__FOREIGN_KEY, oldForeignKey, foreignKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UML2RDBMSPackage.ASSOCIATION_TO_FOREIGN_KEY__OWNER:
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
			case UML2RDBMSPackage.ASSOCIATION_TO_FOREIGN_KEY__OWNER:
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
			case UML2RDBMSPackage.ASSOCIATION_TO_FOREIGN_KEY__OWNER:
				return eInternalContainer().eInverseRemove(this, UML2RDBMSPackage.CLASS_TO_TABLE__ASSOCIATIONS_TO_FOREIGN_KEYS, ClassToTable.class, msgs);
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
			case UML2RDBMSPackage.ASSOCIATION_TO_FOREIGN_KEY__REFERENCED:
				if (resolve) return getReferenced();
				return basicGetReferenced();
			case UML2RDBMSPackage.ASSOCIATION_TO_FOREIGN_KEY__OWNER:
				return getOwner();
			case UML2RDBMSPackage.ASSOCIATION_TO_FOREIGN_KEY__NAME:
				return getName();
			case UML2RDBMSPackage.ASSOCIATION_TO_FOREIGN_KEY__ASSOCIATION:
				if (resolve) return getAssociation();
				return basicGetAssociation();
			case UML2RDBMSPackage.ASSOCIATION_TO_FOREIGN_KEY__FOREIGN_KEY:
				if (resolve) return getForeignKey();
				return basicGetForeignKey();
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
			case UML2RDBMSPackage.ASSOCIATION_TO_FOREIGN_KEY__REFERENCED:
				setReferenced((ClassToTable)newValue);
				return;
			case UML2RDBMSPackage.ASSOCIATION_TO_FOREIGN_KEY__OWNER:
				setOwner((ClassToTable)newValue);
				return;
			case UML2RDBMSPackage.ASSOCIATION_TO_FOREIGN_KEY__NAME:
				setName((String)newValue);
				return;
			case UML2RDBMSPackage.ASSOCIATION_TO_FOREIGN_KEY__ASSOCIATION:
				setAssociation((Association)newValue);
				return;
			case UML2RDBMSPackage.ASSOCIATION_TO_FOREIGN_KEY__FOREIGN_KEY:
				setForeignKey((ForeignKey)newValue);
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
			case UML2RDBMSPackage.ASSOCIATION_TO_FOREIGN_KEY__REFERENCED:
				setReferenced((ClassToTable)null);
				return;
			case UML2RDBMSPackage.ASSOCIATION_TO_FOREIGN_KEY__OWNER:
				setOwner((ClassToTable)null);
				return;
			case UML2RDBMSPackage.ASSOCIATION_TO_FOREIGN_KEY__NAME:
				setName(NAME_EDEFAULT);
				return;
			case UML2RDBMSPackage.ASSOCIATION_TO_FOREIGN_KEY__ASSOCIATION:
				setAssociation((Association)null);
				return;
			case UML2RDBMSPackage.ASSOCIATION_TO_FOREIGN_KEY__FOREIGN_KEY:
				setForeignKey((ForeignKey)null);
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
			case UML2RDBMSPackage.ASSOCIATION_TO_FOREIGN_KEY__REFERENCED:
				return referenced != null;
			case UML2RDBMSPackage.ASSOCIATION_TO_FOREIGN_KEY__OWNER:
				return getOwner() != null;
			case UML2RDBMSPackage.ASSOCIATION_TO_FOREIGN_KEY__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UML2RDBMSPackage.ASSOCIATION_TO_FOREIGN_KEY__ASSOCIATION:
				return association != null;
			case UML2RDBMSPackage.ASSOCIATION_TO_FOREIGN_KEY__FOREIGN_KEY:
				return foreignKey != null;
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //AssociationToForeignKeyImpl
