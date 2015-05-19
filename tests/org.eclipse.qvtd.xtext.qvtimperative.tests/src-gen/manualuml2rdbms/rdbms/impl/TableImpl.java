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
package manualuml2rdbms.rdbms.impl;

import java.util.Collection;

import manualuml2rdbms.rdbms.Column;
import manualuml2rdbms.rdbms.ForeignKey;
import manualuml2rdbms.rdbms.Key;
import manualuml2rdbms.rdbms.RDBMSPackage;
import manualuml2rdbms.rdbms.Schema;
import manualuml2rdbms.rdbms.Table;

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
 * An implementation of the model object '<em><b>Table</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link manualuml2rdbms.rdbms.impl.TableImpl#getColumn <em>Column</em>}</li>
 *   <li>{@link manualuml2rdbms.rdbms.impl.TableImpl#getSchema <em>Schema</em>}</li>
 *   <li>{@link manualuml2rdbms.rdbms.impl.TableImpl#getTheKey <em>The Key</em>}</li>
 *   <li>{@link manualuml2rdbms.rdbms.impl.TableImpl#getKey <em>Key</em>}</li>
 *   <li>{@link manualuml2rdbms.rdbms.impl.TableImpl#getForeignKey <em>Foreign Key</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TableImpl extends RModelElementImpl implements Table {
	/**
	 * The cached value of the '{@link #getColumn() <em>Column</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColumn()
	 * @generated
	 * @ordered
	 */
	protected EList<Column> column;

	/**
	 * The cached value of the '{@link #getTheKey() <em>The Key</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTheKey()
	 * @generated
	 * @ordered
	 */
	protected Key theKey;

	/**
	 * The cached value of the '{@link #getKey() <em>Key</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKey()
	 * @generated
	 * @ordered
	 */
	protected EList<Key> key;

	/**
	 * The cached value of the '{@link #getForeignKey() <em>Foreign Key</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForeignKey()
	 * @generated
	 * @ordered
	 */
	protected EList<ForeignKey> foreignKey;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RDBMSPackage.Literals.TABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Column> getColumn() {
		if (column == null) {
			column = new EObjectContainmentWithInverseEList<Column>(Column.class, this, RDBMSPackage.TABLE__COLUMN, RDBMSPackage.COLUMN__OWNER);
		}
		return column;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Schema getSchema() {
		if (eContainerFeatureID() != RDBMSPackage.TABLE__SCHEMA) return null;
		return (Schema)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSchema(Schema newSchema, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSchema, RDBMSPackage.TABLE__SCHEMA, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSchema(Schema newSchema) {
		if (newSchema != eInternalContainer() || (eContainerFeatureID() != RDBMSPackage.TABLE__SCHEMA && newSchema != null)) {
			if (EcoreUtil.isAncestor(this, newSchema))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSchema != null)
				msgs = ((InternalEObject)newSchema).eInverseAdd(this, RDBMSPackage.SCHEMA__TABLES, Schema.class, msgs);
			msgs = basicSetSchema(newSchema, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RDBMSPackage.TABLE__SCHEMA, newSchema, newSchema));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Key getTheKey() {
		if (theKey != null && theKey.eIsProxy()) {
			InternalEObject oldTheKey = (InternalEObject)theKey;
			theKey = (Key)eResolveProxy(oldTheKey);
			if (theKey != oldTheKey) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RDBMSPackage.TABLE__THE_KEY, oldTheKey, theKey));
			}
		}
		return theKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Key basicGetTheKey() {
		return theKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTheKey(Key newTheKey) {
		Key oldTheKey = theKey;
		theKey = newTheKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RDBMSPackage.TABLE__THE_KEY, oldTheKey, theKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Key> getKey() {
		if (key == null) {
			key = new EObjectContainmentWithInverseEList<Key>(Key.class, this, RDBMSPackage.TABLE__KEY, RDBMSPackage.KEY__OWNER);
		}
		return key;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ForeignKey> getForeignKey() {
		if (foreignKey == null) {
			foreignKey = new EObjectContainmentWithInverseEList<ForeignKey>(ForeignKey.class, this, RDBMSPackage.TABLE__FOREIGN_KEY, RDBMSPackage.FOREIGN_KEY__OWNER);
		}
		return foreignKey;
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
			case RDBMSPackage.TABLE__COLUMN:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getColumn()).basicAdd(otherEnd, msgs);
			case RDBMSPackage.TABLE__SCHEMA:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSchema((Schema)otherEnd, msgs);
			case RDBMSPackage.TABLE__KEY:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getKey()).basicAdd(otherEnd, msgs);
			case RDBMSPackage.TABLE__FOREIGN_KEY:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getForeignKey()).basicAdd(otherEnd, msgs);
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
			case RDBMSPackage.TABLE__COLUMN:
				return ((InternalEList<?>)getColumn()).basicRemove(otherEnd, msgs);
			case RDBMSPackage.TABLE__SCHEMA:
				return basicSetSchema(null, msgs);
			case RDBMSPackage.TABLE__KEY:
				return ((InternalEList<?>)getKey()).basicRemove(otherEnd, msgs);
			case RDBMSPackage.TABLE__FOREIGN_KEY:
				return ((InternalEList<?>)getForeignKey()).basicRemove(otherEnd, msgs);
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
			case RDBMSPackage.TABLE__SCHEMA:
				return eInternalContainer().eInverseRemove(this, RDBMSPackage.SCHEMA__TABLES, Schema.class, msgs);
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
			case RDBMSPackage.TABLE__COLUMN:
				return getColumn();
			case RDBMSPackage.TABLE__SCHEMA:
				return getSchema();
			case RDBMSPackage.TABLE__THE_KEY:
				if (resolve) return getTheKey();
				return basicGetTheKey();
			case RDBMSPackage.TABLE__KEY:
				return getKey();
			case RDBMSPackage.TABLE__FOREIGN_KEY:
				return getForeignKey();
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
			case RDBMSPackage.TABLE__COLUMN:
				getColumn().clear();
				getColumn().addAll((Collection<? extends Column>)newValue);
				return;
			case RDBMSPackage.TABLE__SCHEMA:
				setSchema((Schema)newValue);
				return;
			case RDBMSPackage.TABLE__THE_KEY:
				setTheKey((Key)newValue);
				return;
			case RDBMSPackage.TABLE__KEY:
				getKey().clear();
				getKey().addAll((Collection<? extends Key>)newValue);
				return;
			case RDBMSPackage.TABLE__FOREIGN_KEY:
				getForeignKey().clear();
				getForeignKey().addAll((Collection<? extends ForeignKey>)newValue);
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
			case RDBMSPackage.TABLE__COLUMN:
				getColumn().clear();
				return;
			case RDBMSPackage.TABLE__SCHEMA:
				setSchema((Schema)null);
				return;
			case RDBMSPackage.TABLE__THE_KEY:
				setTheKey((Key)null);
				return;
			case RDBMSPackage.TABLE__KEY:
				getKey().clear();
				return;
			case RDBMSPackage.TABLE__FOREIGN_KEY:
				getForeignKey().clear();
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
			case RDBMSPackage.TABLE__COLUMN:
				return column != null && !column.isEmpty();
			case RDBMSPackage.TABLE__SCHEMA:
				return getSchema() != null;
			case RDBMSPackage.TABLE__THE_KEY:
				return theKey != null;
			case RDBMSPackage.TABLE__KEY:
				return key != null && !key.isEmpty();
			case RDBMSPackage.TABLE__FOREIGN_KEY:
				return foreignKey != null && !foreignKey.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TableImpl
