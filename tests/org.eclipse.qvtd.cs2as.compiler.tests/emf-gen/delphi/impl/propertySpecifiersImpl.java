/**
 * Copyright (c)  2016 Willink Transformations, Univesity of York and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *      Adolfo Sanchez-Barbudo Herrera - initial API and implementation
 */
package delphi.impl;

import delphi.DelphiPackage;
import delphi.constExpr;
import delphi.ident;
import delphi.propertySpecifiers;
import delphi.typeId;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>property Specifiers</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link delphi.impl.propertySpecifiersImpl#getIndex <em>Index</em>}</li>
 *   <li>{@link delphi.impl.propertySpecifiersImpl#getReadId <em>Read Id</em>}</li>
 *   <li>{@link delphi.impl.propertySpecifiersImpl#getWriteId <em>Write Id</em>}</li>
 *   <li>{@link delphi.impl.propertySpecifiersImpl#getStoreId <em>Store Id</em>}</li>
 *   <li>{@link delphi.impl.propertySpecifiersImpl#getStoreExp <em>Store Exp</em>}</li>
 *   <li>{@link delphi.impl.propertySpecifiersImpl#getDefaulExp <em>Defaul Exp</em>}</li>
 *   <li>{@link delphi.impl.propertySpecifiersImpl#getImplement <em>Implement</em>}</li>
 * </ul>
 *
 * @generated
 */
public class propertySpecifiersImpl extends CSTraceImpl implements propertySpecifiers {
	/**
	 * The cached value of the '{@link #getIndex() <em>Index</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndex()
	 * @generated
	 * @ordered
	 */
	protected constExpr index;

	/**
	 * The cached value of the '{@link #getReadId() <em>Read Id</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReadId()
	 * @generated
	 * @ordered
	 */
	protected ident readId;

	/**
	 * The cached value of the '{@link #getWriteId() <em>Write Id</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWriteId()
	 * @generated
	 * @ordered
	 */
	protected ident writeId;

	/**
	 * The cached value of the '{@link #getStoreId() <em>Store Id</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStoreId()
	 * @generated
	 * @ordered
	 */
	protected ident storeId;

	/**
	 * The cached value of the '{@link #getStoreExp() <em>Store Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStoreExp()
	 * @generated
	 * @ordered
	 */
	protected constExpr storeExp;

	/**
	 * The cached value of the '{@link #getDefaulExp() <em>Defaul Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaulExp()
	 * @generated
	 * @ordered
	 */
	protected constExpr defaulExp;

	/**
	 * The cached value of the '{@link #getImplement() <em>Implement</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplement()
	 * @generated
	 * @ordered
	 */
	protected typeId implement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected propertySpecifiersImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DelphiPackage.Literals.PROPERTY_SPECIFIERS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public constExpr getIndex() {
		return index;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIndex(constExpr newIndex, NotificationChain msgs) {
		constExpr oldIndex = index;
		index = newIndex;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.PROPERTY_SPECIFIERS__INDEX, oldIndex, newIndex);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIndex(constExpr newIndex) {
		if (newIndex != index) {
			NotificationChain msgs = null;
			if (index != null)
				msgs = ((InternalEObject)index).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.PROPERTY_SPECIFIERS__INDEX, null, msgs);
			if (newIndex != null)
				msgs = ((InternalEObject)newIndex).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.PROPERTY_SPECIFIERS__INDEX, null, msgs);
			msgs = basicSetIndex(newIndex, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.PROPERTY_SPECIFIERS__INDEX, newIndex, newIndex));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ident getReadId() {
		return readId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReadId(ident newReadId, NotificationChain msgs) {
		ident oldReadId = readId;
		readId = newReadId;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.PROPERTY_SPECIFIERS__READ_ID, oldReadId, newReadId);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReadId(ident newReadId) {
		if (newReadId != readId) {
			NotificationChain msgs = null;
			if (readId != null)
				msgs = ((InternalEObject)readId).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.PROPERTY_SPECIFIERS__READ_ID, null, msgs);
			if (newReadId != null)
				msgs = ((InternalEObject)newReadId).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.PROPERTY_SPECIFIERS__READ_ID, null, msgs);
			msgs = basicSetReadId(newReadId, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.PROPERTY_SPECIFIERS__READ_ID, newReadId, newReadId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ident getWriteId() {
		return writeId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWriteId(ident newWriteId, NotificationChain msgs) {
		ident oldWriteId = writeId;
		writeId = newWriteId;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.PROPERTY_SPECIFIERS__WRITE_ID, oldWriteId, newWriteId);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWriteId(ident newWriteId) {
		if (newWriteId != writeId) {
			NotificationChain msgs = null;
			if (writeId != null)
				msgs = ((InternalEObject)writeId).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.PROPERTY_SPECIFIERS__WRITE_ID, null, msgs);
			if (newWriteId != null)
				msgs = ((InternalEObject)newWriteId).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.PROPERTY_SPECIFIERS__WRITE_ID, null, msgs);
			msgs = basicSetWriteId(newWriteId, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.PROPERTY_SPECIFIERS__WRITE_ID, newWriteId, newWriteId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ident getStoreId() {
		return storeId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStoreId(ident newStoreId, NotificationChain msgs) {
		ident oldStoreId = storeId;
		storeId = newStoreId;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.PROPERTY_SPECIFIERS__STORE_ID, oldStoreId, newStoreId);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStoreId(ident newStoreId) {
		if (newStoreId != storeId) {
			NotificationChain msgs = null;
			if (storeId != null)
				msgs = ((InternalEObject)storeId).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.PROPERTY_SPECIFIERS__STORE_ID, null, msgs);
			if (newStoreId != null)
				msgs = ((InternalEObject)newStoreId).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.PROPERTY_SPECIFIERS__STORE_ID, null, msgs);
			msgs = basicSetStoreId(newStoreId, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.PROPERTY_SPECIFIERS__STORE_ID, newStoreId, newStoreId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public constExpr getStoreExp() {
		return storeExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStoreExp(constExpr newStoreExp, NotificationChain msgs) {
		constExpr oldStoreExp = storeExp;
		storeExp = newStoreExp;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.PROPERTY_SPECIFIERS__STORE_EXP, oldStoreExp, newStoreExp);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStoreExp(constExpr newStoreExp) {
		if (newStoreExp != storeExp) {
			NotificationChain msgs = null;
			if (storeExp != null)
				msgs = ((InternalEObject)storeExp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.PROPERTY_SPECIFIERS__STORE_EXP, null, msgs);
			if (newStoreExp != null)
				msgs = ((InternalEObject)newStoreExp).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.PROPERTY_SPECIFIERS__STORE_EXP, null, msgs);
			msgs = basicSetStoreExp(newStoreExp, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.PROPERTY_SPECIFIERS__STORE_EXP, newStoreExp, newStoreExp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public constExpr getDefaulExp() {
		return defaulExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDefaulExp(constExpr newDefaulExp, NotificationChain msgs) {
		constExpr oldDefaulExp = defaulExp;
		defaulExp = newDefaulExp;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.PROPERTY_SPECIFIERS__DEFAUL_EXP, oldDefaulExp, newDefaulExp);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaulExp(constExpr newDefaulExp) {
		if (newDefaulExp != defaulExp) {
			NotificationChain msgs = null;
			if (defaulExp != null)
				msgs = ((InternalEObject)defaulExp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.PROPERTY_SPECIFIERS__DEFAUL_EXP, null, msgs);
			if (newDefaulExp != null)
				msgs = ((InternalEObject)newDefaulExp).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.PROPERTY_SPECIFIERS__DEFAUL_EXP, null, msgs);
			msgs = basicSetDefaulExp(newDefaulExp, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.PROPERTY_SPECIFIERS__DEFAUL_EXP, newDefaulExp, newDefaulExp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public typeId getImplement() {
		return implement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetImplement(typeId newImplement, NotificationChain msgs) {
		typeId oldImplement = implement;
		implement = newImplement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.PROPERTY_SPECIFIERS__IMPLEMENT, oldImplement, newImplement);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplement(typeId newImplement) {
		if (newImplement != implement) {
			NotificationChain msgs = null;
			if (implement != null)
				msgs = ((InternalEObject)implement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.PROPERTY_SPECIFIERS__IMPLEMENT, null, msgs);
			if (newImplement != null)
				msgs = ((InternalEObject)newImplement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.PROPERTY_SPECIFIERS__IMPLEMENT, null, msgs);
			msgs = basicSetImplement(newImplement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.PROPERTY_SPECIFIERS__IMPLEMENT, newImplement, newImplement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DelphiPackage.PROPERTY_SPECIFIERS__INDEX:
				return basicSetIndex(null, msgs);
			case DelphiPackage.PROPERTY_SPECIFIERS__READ_ID:
				return basicSetReadId(null, msgs);
			case DelphiPackage.PROPERTY_SPECIFIERS__WRITE_ID:
				return basicSetWriteId(null, msgs);
			case DelphiPackage.PROPERTY_SPECIFIERS__STORE_ID:
				return basicSetStoreId(null, msgs);
			case DelphiPackage.PROPERTY_SPECIFIERS__STORE_EXP:
				return basicSetStoreExp(null, msgs);
			case DelphiPackage.PROPERTY_SPECIFIERS__DEFAUL_EXP:
				return basicSetDefaulExp(null, msgs);
			case DelphiPackage.PROPERTY_SPECIFIERS__IMPLEMENT:
				return basicSetImplement(null, msgs);
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
			case DelphiPackage.PROPERTY_SPECIFIERS__INDEX:
				return getIndex();
			case DelphiPackage.PROPERTY_SPECIFIERS__READ_ID:
				return getReadId();
			case DelphiPackage.PROPERTY_SPECIFIERS__WRITE_ID:
				return getWriteId();
			case DelphiPackage.PROPERTY_SPECIFIERS__STORE_ID:
				return getStoreId();
			case DelphiPackage.PROPERTY_SPECIFIERS__STORE_EXP:
				return getStoreExp();
			case DelphiPackage.PROPERTY_SPECIFIERS__DEFAUL_EXP:
				return getDefaulExp();
			case DelphiPackage.PROPERTY_SPECIFIERS__IMPLEMENT:
				return getImplement();
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
			case DelphiPackage.PROPERTY_SPECIFIERS__INDEX:
				setIndex((constExpr)newValue);
				return;
			case DelphiPackage.PROPERTY_SPECIFIERS__READ_ID:
				setReadId((ident)newValue);
				return;
			case DelphiPackage.PROPERTY_SPECIFIERS__WRITE_ID:
				setWriteId((ident)newValue);
				return;
			case DelphiPackage.PROPERTY_SPECIFIERS__STORE_ID:
				setStoreId((ident)newValue);
				return;
			case DelphiPackage.PROPERTY_SPECIFIERS__STORE_EXP:
				setStoreExp((constExpr)newValue);
				return;
			case DelphiPackage.PROPERTY_SPECIFIERS__DEFAUL_EXP:
				setDefaulExp((constExpr)newValue);
				return;
			case DelphiPackage.PROPERTY_SPECIFIERS__IMPLEMENT:
				setImplement((typeId)newValue);
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
			case DelphiPackage.PROPERTY_SPECIFIERS__INDEX:
				setIndex((constExpr)null);
				return;
			case DelphiPackage.PROPERTY_SPECIFIERS__READ_ID:
				setReadId((ident)null);
				return;
			case DelphiPackage.PROPERTY_SPECIFIERS__WRITE_ID:
				setWriteId((ident)null);
				return;
			case DelphiPackage.PROPERTY_SPECIFIERS__STORE_ID:
				setStoreId((ident)null);
				return;
			case DelphiPackage.PROPERTY_SPECIFIERS__STORE_EXP:
				setStoreExp((constExpr)null);
				return;
			case DelphiPackage.PROPERTY_SPECIFIERS__DEFAUL_EXP:
				setDefaulExp((constExpr)null);
				return;
			case DelphiPackage.PROPERTY_SPECIFIERS__IMPLEMENT:
				setImplement((typeId)null);
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
			case DelphiPackage.PROPERTY_SPECIFIERS__INDEX:
				return index != null;
			case DelphiPackage.PROPERTY_SPECIFIERS__READ_ID:
				return readId != null;
			case DelphiPackage.PROPERTY_SPECIFIERS__WRITE_ID:
				return writeId != null;
			case DelphiPackage.PROPERTY_SPECIFIERS__STORE_ID:
				return storeId != null;
			case DelphiPackage.PROPERTY_SPECIFIERS__STORE_EXP:
				return storeExp != null;
			case DelphiPackage.PROPERTY_SPECIFIERS__DEFAUL_EXP:
				return defaulExp != null;
			case DelphiPackage.PROPERTY_SPECIFIERS__IMPLEMENT:
				return implement != null;
		}
		return super.eIsSet(featureID);
	}


} //propertySpecifiersImpl
