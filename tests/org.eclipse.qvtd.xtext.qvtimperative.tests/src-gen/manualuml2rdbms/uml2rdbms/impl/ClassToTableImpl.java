/*******************************************************************************
 * Copyright (c) 2015, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/**
 */
package manualuml2rdbms.uml2rdbms.impl;

import java.util.Collection;

import manualuml2rdbms.rdbms.Column;
import manualuml2rdbms.rdbms.Key;
import manualuml2rdbms.rdbms.Table;

import manualuml2rdbms.uml2rdbms.AssociationToForeignKey;
import manualuml2rdbms.uml2rdbms.ClassToTable;
import manualuml2rdbms.uml2rdbms.PackageToSchema;
import manualuml2rdbms.uml2rdbms.ToColumn;
import manualuml2rdbms.uml2rdbms.UML2RDBMSPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class To Table</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link manualuml2rdbms.uml2rdbms.impl.ClassToTableImpl#getColumn <em>Column</em>}</li>
 *   <li>{@link manualuml2rdbms.uml2rdbms.impl.ClassToTableImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link manualuml2rdbms.uml2rdbms.impl.ClassToTableImpl#getAssociationsToForeignKeys <em>Associations To Foreign Keys</em>}</li>
 *   <li>{@link manualuml2rdbms.uml2rdbms.impl.ClassToTableImpl#getName <em>Name</em>}</li>
 *   <li>{@link manualuml2rdbms.uml2rdbms.impl.ClassToTableImpl#getUmlClass <em>Uml Class</em>}</li>
 *   <li>{@link manualuml2rdbms.uml2rdbms.impl.ClassToTableImpl#getTable <em>Table</em>}</li>
 *   <li>{@link manualuml2rdbms.uml2rdbms.impl.ClassToTableImpl#getPrimaryKey <em>Primary Key</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClassToTableImpl extends FromAttributeOwnerImpl implements ClassToTable {
	/**
	 * The number of structural features of the '<em>Class To Table</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CLASS_TO_TABLE_FEATURE_COUNT = FromAttributeOwnerImpl.FROM_ATTRIBUTE_OWNER_FEATURE_COUNT + 7;

	/**
	 * The number of operations of the '<em>Class To Table</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CLASS_TO_TABLE_OPERATION_COUNT = FromAttributeOwnerImpl.FROM_ATTRIBUTE_OWNER_OPERATION_COUNT + 0;

	/**
	 * The cached value of the '{@link #getColumn() <em>Column</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColumn()
	 * @generated
	 * @ordered
	 */
	protected Column column;

	/**
	 * The cached value of the '{@link #getAssociationsToForeignKeys() <em>Associations To Foreign Keys</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociationsToForeignKeys()
	 * @generated
	 * @ordered
	 */
	protected EList<AssociationToForeignKey> associationsToForeignKeys;

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
	 * The cached value of the '{@link #getUmlClass() <em>Uml Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUmlClass()
	 * @generated
	 * @ordered
	 */
	protected manualuml2rdbms.uml.Class umlClass;

	/**
	 * The cached value of the '{@link #getTable() <em>Table</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTable()
	 * @generated
	 * @ordered
	 */
	protected Table table;

	/**
	 * The cached value of the '{@link #getPrimaryKey() <em>Primary Key</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimaryKey()
	 * @generated
	 * @ordered
	 */
	protected Key primaryKey;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassToTableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UML2RDBMSPackage.Literals.CLASS_TO_TABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Column getColumn() {
		if (column != null && column.eIsProxy()) {
			InternalEObject oldColumn = (InternalEObject)column;
			column = (Column)eResolveProxy(oldColumn);
			if (column != oldColumn) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, 1, oldColumn, column));
			}
		}
		return column;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Column basicGetColumn() {
		return column;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setColumn(Column newColumn) {
		Column oldColumn = column;
		column = newColumn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 1, oldColumn, column));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PackageToSchema getOwner() {
		if (eContainerFeatureID() != (2)) return null;
		return (PackageToSchema)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwner(PackageToSchema newOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwner, 2, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwner(PackageToSchema newOwner) {
		if (newOwner != eInternalContainer() || (eContainerFeatureID() != (2) && newOwner != null)) {
			if (EcoreUtil.isAncestor(this, newOwner))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwner != null)
				msgs = ((InternalEObject)newOwner).eInverseAdd(this, 0, PackageToSchema.class, msgs);
			msgs = basicSetOwner(newOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 2, newOwner, newOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AssociationToForeignKey> getAssociationsToForeignKeys() {
		if (associationsToForeignKeys == null) {
			associationsToForeignKeys = new EObjectContainmentWithInverseEList<AssociationToForeignKey>(AssociationToForeignKey.class, this, 3, 2);
		}
		return associationsToForeignKeys;
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
			eNotify(new ENotificationImpl(this, Notification.SET, 4, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public manualuml2rdbms.uml.Class getUmlClass() {
		if (umlClass != null && umlClass.eIsProxy()) {
			InternalEObject oldUmlClass = (InternalEObject)umlClass;
			umlClass = (manualuml2rdbms.uml.Class)eResolveProxy(oldUmlClass);
			if (umlClass != oldUmlClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, 5, oldUmlClass, umlClass));
			}
		}
		return umlClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public manualuml2rdbms.uml.Class basicGetUmlClass() {
		return umlClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUmlClass(manualuml2rdbms.uml.Class newUmlClass) {
		manualuml2rdbms.uml.Class oldUmlClass = umlClass;
		umlClass = newUmlClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 5, oldUmlClass, umlClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Table getTable() {
		if (table != null && table.eIsProxy()) {
			InternalEObject oldTable = (InternalEObject)table;
			table = (Table)eResolveProxy(oldTable);
			if (table != oldTable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, 6, oldTable, table));
			}
		}
		return table;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Table basicGetTable() {
		return table;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTable(Table newTable) {
		Table oldTable = table;
		table = newTable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 6, oldTable, table));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Key getPrimaryKey() {
		if (primaryKey != null && primaryKey.eIsProxy()) {
			InternalEObject oldPrimaryKey = (InternalEObject)primaryKey;
			primaryKey = (Key)eResolveProxy(oldPrimaryKey);
			if (primaryKey != oldPrimaryKey) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, 7, oldPrimaryKey, primaryKey));
			}
		}
		return primaryKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Key basicGetPrimaryKey() {
		return primaryKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPrimaryKey(Key newPrimaryKey) {
		Key oldPrimaryKey = primaryKey;
		primaryKey = newPrimaryKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 7, oldPrimaryKey, primaryKey));
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
			case 2:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwner((PackageToSchema)otherEnd, msgs);
			case 3:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAssociationsToForeignKeys()).basicAdd(otherEnd, msgs);
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
			case 2:
				return basicSetOwner(null, msgs);
			case 3:
				return ((InternalEList<?>)getAssociationsToForeignKeys()).basicRemove(otherEnd, msgs);
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
			case 2:
				return eInternalContainer().eInverseRemove(this, 0, PackageToSchema.class, msgs);
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
				if (resolve) return getColumn();
				return basicGetColumn();
			case 2:
				return getOwner();
			case 3:
				return getAssociationsToForeignKeys();
			case 4:
				return getName();
			case 5:
				if (resolve) return getUmlClass();
				return basicGetUmlClass();
			case 6:
				if (resolve) return getTable();
				return basicGetTable();
			case 7:
				if (resolve) return getPrimaryKey();
				return basicGetPrimaryKey();
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
			case 1:
				setColumn((Column)newValue);
				return;
			case 2:
				setOwner((PackageToSchema)newValue);
				return;
			case 3:
				getAssociationsToForeignKeys().clear();
				getAssociationsToForeignKeys().addAll((Collection<? extends AssociationToForeignKey>)newValue);
				return;
			case 4:
				setName((String)newValue);
				return;
			case 5:
				setUmlClass((manualuml2rdbms.uml.Class)newValue);
				return;
			case 6:
				setTable((Table)newValue);
				return;
			case 7:
				setPrimaryKey((Key)newValue);
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
				setColumn((Column)null);
				return;
			case 2:
				setOwner((PackageToSchema)null);
				return;
			case 3:
				getAssociationsToForeignKeys().clear();
				return;
			case 4:
				setName(NAME_EDEFAULT);
				return;
			case 5:
				setUmlClass((manualuml2rdbms.uml.Class)null);
				return;
			case 6:
				setTable((Table)null);
				return;
			case 7:
				setPrimaryKey((Key)null);
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
				return column != null;
			case 2:
				return getOwner() != null;
			case 3:
				return associationsToForeignKeys != null && !associationsToForeignKeys.isEmpty();
			case 4:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case 5:
				return umlClass != null;
			case 6:
				return table != null;
			case 7:
				return primaryKey != null;
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
		if (baseClass == ToColumn.class) {
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
		if (baseClass == ToColumn.class) {
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

} //ClassToTableImpl
