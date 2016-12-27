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
import delphi.fieldDecl;
import delphi.fieldList;
import delphi.variantSection;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>field List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link delphi.impl.fieldListImpl#getField <em>Field</em>}</li>
 *   <li>{@link delphi.impl.fieldListImpl#getVariantSect <em>Variant Sect</em>}</li>
 * </ul>
 *
 * @generated
 */
public class fieldListImpl extends CSTraceImpl implements fieldList {
	/**
	 * The cached value of the '{@link #getField() <em>Field</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getField()
	 * @generated
	 * @ordered
	 */
	protected EList<fieldDecl> field;

	/**
	 * The cached value of the '{@link #getVariantSect() <em>Variant Sect</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariantSect()
	 * @generated
	 * @ordered
	 */
	protected variantSection variantSect;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected fieldListImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DelphiPackage.Literals.FIELD_LIST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<fieldDecl> getField() {
		if (field == null) {
			field = new EObjectContainmentEList<fieldDecl>(fieldDecl.class, this, DelphiPackage.FIELD_LIST__FIELD);
		}
		return field;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public variantSection getVariantSect() {
		return variantSect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVariantSect(variantSection newVariantSect, NotificationChain msgs) {
		variantSection oldVariantSect = variantSect;
		variantSect = newVariantSect;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.FIELD_LIST__VARIANT_SECT, oldVariantSect, newVariantSect);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariantSect(variantSection newVariantSect) {
		if (newVariantSect != variantSect) {
			NotificationChain msgs = null;
			if (variantSect != null)
				msgs = ((InternalEObject)variantSect).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.FIELD_LIST__VARIANT_SECT, null, msgs);
			if (newVariantSect != null)
				msgs = ((InternalEObject)newVariantSect).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.FIELD_LIST__VARIANT_SECT, null, msgs);
			msgs = basicSetVariantSect(newVariantSect, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.FIELD_LIST__VARIANT_SECT, newVariantSect, newVariantSect));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DelphiPackage.FIELD_LIST__FIELD:
				return ((InternalEList<?>)getField()).basicRemove(otherEnd, msgs);
			case DelphiPackage.FIELD_LIST__VARIANT_SECT:
				return basicSetVariantSect(null, msgs);
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
			case DelphiPackage.FIELD_LIST__FIELD:
				return getField();
			case DelphiPackage.FIELD_LIST__VARIANT_SECT:
				return getVariantSect();
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
			case DelphiPackage.FIELD_LIST__FIELD:
				getField().clear();
				getField().addAll((Collection<? extends fieldDecl>)newValue);
				return;
			case DelphiPackage.FIELD_LIST__VARIANT_SECT:
				setVariantSect((variantSection)newValue);
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
			case DelphiPackage.FIELD_LIST__FIELD:
				getField().clear();
				return;
			case DelphiPackage.FIELD_LIST__VARIANT_SECT:
				setVariantSect((variantSection)null);
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
			case DelphiPackage.FIELD_LIST__FIELD:
				return field != null && !field.isEmpty();
			case DelphiPackage.FIELD_LIST__VARIANT_SECT:
				return variantSect != null;
		}
		return super.eIsSet(featureID);
	}


} //fieldListImpl
