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

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import test.simplerdbms.Column;
import test.simplerdbms.ForeignKey;
import test.simplerdbms.Key;
import test.simplerdbms.SimplerdbmsPackage;
import test.simplerdbms.Table;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Column</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link test.simplerdbms.impl.ColumnImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link test.simplerdbms.impl.ColumnImpl#getType <em>Type</em>}</li>
 *   <li>{@link test.simplerdbms.impl.ColumnImpl#getForeignKeys <em>Foreign Keys</em>}</li>
 *   <li>{@link test.simplerdbms.impl.ColumnImpl#getKey <em>Key</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ColumnImpl extends RModelElementImpl implements Column {
	/**
	 * The cached value of the '{@link #getOwner() <em>Owner</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwner()
	 * @generated
	 * @ordered
	 */
	protected Table owner;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getForeignKeys() <em>Foreign Keys</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForeignKeys()
	 * @generated
	 * @ordered
	 */
	protected EList<ForeignKey> foreignKeys;

	/**
	 * The cached value of the '{@link #getKey() <em>Key</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKey()
	 * @generated
	 * @ordered
	 */
	protected EList<Key> key;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ColumnImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SimplerdbmsPackage.Literals.COLUMN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Table getOwner() {
		if (owner != null && owner.eIsProxy()) {
			InternalEObject oldOwner = (InternalEObject)owner;
			owner = (Table)eResolveProxy(oldOwner);
			if (owner != oldOwner) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SimplerdbmsPackage.COLUMN__OWNER, oldOwner, owner));
			}
		}
		return owner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Table basicGetOwner() {
		return owner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(Table newOwner) {
		Table oldOwner = owner;
		owner = newOwner;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimplerdbmsPackage.COLUMN__OWNER, oldOwner, owner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimplerdbmsPackage.COLUMN__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ForeignKey> getForeignKeys() {
		if (foreignKeys == null) {
			foreignKeys = new EObjectWithInverseResolvingEList.ManyInverse<ForeignKey>(ForeignKey.class, this, SimplerdbmsPackage.COLUMN__FOREIGN_KEYS, SimplerdbmsPackage.FOREIGN_KEY__COLUMN);
		}
		return foreignKeys;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Key> getKey() {
		if (key == null) {
			key = new EObjectWithInverseResolvingEList.ManyInverse<Key>(Key.class, this, SimplerdbmsPackage.COLUMN__KEY, SimplerdbmsPackage.KEY__COLUMN);
		}
		return key;
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
			case SimplerdbmsPackage.COLUMN__FOREIGN_KEYS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getForeignKeys()).basicAdd(otherEnd, msgs);
			case SimplerdbmsPackage.COLUMN__KEY:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getKey()).basicAdd(otherEnd, msgs);
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
			case SimplerdbmsPackage.COLUMN__FOREIGN_KEYS:
				return ((InternalEList<?>)getForeignKeys()).basicRemove(otherEnd, msgs);
			case SimplerdbmsPackage.COLUMN__KEY:
				return ((InternalEList<?>)getKey()).basicRemove(otherEnd, msgs);
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
			case SimplerdbmsPackage.COLUMN__OWNER:
				if (resolve) return getOwner();
				return basicGetOwner();
			case SimplerdbmsPackage.COLUMN__TYPE:
				return getType();
			case SimplerdbmsPackage.COLUMN__FOREIGN_KEYS:
				return getForeignKeys();
			case SimplerdbmsPackage.COLUMN__KEY:
				return getKey();
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
			case SimplerdbmsPackage.COLUMN__OWNER:
				setOwner((Table)newValue);
				return;
			case SimplerdbmsPackage.COLUMN__TYPE:
				setType((String)newValue);
				return;
			case SimplerdbmsPackage.COLUMN__FOREIGN_KEYS:
				getForeignKeys().clear();
				getForeignKeys().addAll((Collection<? extends ForeignKey>)newValue);
				return;
			case SimplerdbmsPackage.COLUMN__KEY:
				getKey().clear();
				getKey().addAll((Collection<? extends Key>)newValue);
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
			case SimplerdbmsPackage.COLUMN__OWNER:
				setOwner((Table)null);
				return;
			case SimplerdbmsPackage.COLUMN__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case SimplerdbmsPackage.COLUMN__FOREIGN_KEYS:
				getForeignKeys().clear();
				return;
			case SimplerdbmsPackage.COLUMN__KEY:
				getKey().clear();
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
			case SimplerdbmsPackage.COLUMN__OWNER:
				return owner != null;
			case SimplerdbmsPackage.COLUMN__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case SimplerdbmsPackage.COLUMN__FOREIGN_KEYS:
				return foreignKeys != null && !foreignKeys.isEmpty();
			case SimplerdbmsPackage.COLUMN__KEY:
				return key != null && !key.isEmpty();
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
		result.append(" (type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //ColumnImpl
