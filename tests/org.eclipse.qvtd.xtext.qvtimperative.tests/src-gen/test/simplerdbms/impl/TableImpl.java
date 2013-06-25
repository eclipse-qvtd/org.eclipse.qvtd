/**
 */
package test.simplerdbms.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import test.simplerdbms.Column;
import test.simplerdbms.Key;
import test.simplerdbms.Schema;
import test.simplerdbms.SimplerdbmsPackage;
import test.simplerdbms.Table;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Table</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link test.simplerdbms.impl.TableImpl#getColumn <em>Column</em>}</li>
 *   <li>{@link test.simplerdbms.impl.TableImpl#getSchema <em>Schema</em>}</li>
 *   <li>{@link test.simplerdbms.impl.TableImpl#getTheKey <em>The Key</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TableImpl extends RModelElementImpl implements Table {
	/**
	 * The cached value of the '{@link #getColumn() <em>Column</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColumn()
	 * @generated
	 * @ordered
	 */
	protected EList<Column> column;

	/**
	 * The cached value of the '{@link #getSchema() <em>Schema</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchema()
	 * @generated
	 * @ordered
	 */
	protected Schema schema;

	/**
	 * The cached value of the '{@link #getTheKey() <em>The Key</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTheKey()
	 * @generated
	 * @ordered
	 */
	protected EList<Key> theKey;

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
		return SimplerdbmsPackage.Literals.TABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Column> getColumn() {
		if (column == null) {
			column = new EObjectResolvingEList<Column>(Column.class, this, SimplerdbmsPackage.TABLE__COLUMN);
		}
		return column;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Schema getSchema() {
		if (schema != null && schema.eIsProxy()) {
			InternalEObject oldSchema = (InternalEObject)schema;
			schema = (Schema)eResolveProxy(oldSchema);
			if (schema != oldSchema) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SimplerdbmsPackage.TABLE__SCHEMA, oldSchema, schema));
			}
		}
		return schema;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Schema basicGetSchema() {
		return schema;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSchema(Schema newSchema, NotificationChain msgs) {
		Schema oldSchema = schema;
		schema = newSchema;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SimplerdbmsPackage.TABLE__SCHEMA, oldSchema, newSchema);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSchema(Schema newSchema) {
		if (newSchema != schema) {
			NotificationChain msgs = null;
			if (schema != null)
				msgs = ((InternalEObject)schema).eInverseRemove(this, SimplerdbmsPackage.SCHEMA__TABLES, Schema.class, msgs);
			if (newSchema != null)
				msgs = ((InternalEObject)newSchema).eInverseAdd(this, SimplerdbmsPackage.SCHEMA__TABLES, Schema.class, msgs);
			msgs = basicSetSchema(newSchema, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimplerdbmsPackage.TABLE__SCHEMA, newSchema, newSchema));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Key> getTheKey() {
		if (theKey == null) {
			theKey = new EObjectWithInverseResolvingEList<Key>(Key.class, this, SimplerdbmsPackage.TABLE__THE_KEY, SimplerdbmsPackage.KEY__OWNER);
		}
		return theKey;
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
			case SimplerdbmsPackage.TABLE__SCHEMA:
				if (schema != null)
					msgs = ((InternalEObject)schema).eInverseRemove(this, SimplerdbmsPackage.SCHEMA__TABLES, Schema.class, msgs);
				return basicSetSchema((Schema)otherEnd, msgs);
			case SimplerdbmsPackage.TABLE__THE_KEY:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTheKey()).basicAdd(otherEnd, msgs);
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
			case SimplerdbmsPackage.TABLE__SCHEMA:
				return basicSetSchema(null, msgs);
			case SimplerdbmsPackage.TABLE__THE_KEY:
				return ((InternalEList<?>)getTheKey()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SimplerdbmsPackage.TABLE__COLUMN:
				return getColumn();
			case SimplerdbmsPackage.TABLE__SCHEMA:
				if (resolve) return getSchema();
				return basicGetSchema();
			case SimplerdbmsPackage.TABLE__THE_KEY:
				return getTheKey();
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
			case SimplerdbmsPackage.TABLE__COLUMN:
				getColumn().clear();
				getColumn().addAll((Collection<? extends Column>)newValue);
				return;
			case SimplerdbmsPackage.TABLE__SCHEMA:
				setSchema((Schema)newValue);
				return;
			case SimplerdbmsPackage.TABLE__THE_KEY:
				getTheKey().clear();
				getTheKey().addAll((Collection<? extends Key>)newValue);
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
			case SimplerdbmsPackage.TABLE__COLUMN:
				getColumn().clear();
				return;
			case SimplerdbmsPackage.TABLE__SCHEMA:
				setSchema((Schema)null);
				return;
			case SimplerdbmsPackage.TABLE__THE_KEY:
				getTheKey().clear();
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
			case SimplerdbmsPackage.TABLE__COLUMN:
				return column != null && !column.isEmpty();
			case SimplerdbmsPackage.TABLE__SCHEMA:
				return schema != null;
			case SimplerdbmsPackage.TABLE__THE_KEY:
				return theKey != null && !theKey.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TableImpl
