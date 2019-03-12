/**
 * Copyright (c) 2016, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.umlx.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.qvtd.umlx.UMLXPackage;
import org.eclipse.qvtd.umlx.UMLXTypedElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Typed Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.UMLXTypedElementImpl#isIsMany <em>Is Many</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.UMLXTypedElementImpl#isIsNullFree <em>Is Null Free</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.UMLXTypedElementImpl#isIsOrdered <em>Is Ordered</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.UMLXTypedElementImpl#isIsRequired <em>Is Required</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.UMLXTypedElementImpl#isIsUnique <em>Is Unique</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.UMLXTypedElementImpl#getReferredEClassifier <em>Referred EClassifier</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class UMLXTypedElementImpl extends UMLXNamedElementImpl implements UMLXTypedElement {
	/**
	 * The number of structural features of the '<em>Typed Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int UMLX_TYPED_ELEMENT_FEATURE_COUNT = UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The default value of the '{@link #isIsMany() <em>Is Many</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsMany()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_MANY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsMany() <em>Is Many</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsMany()
	 * @generated
	 * @ordered
	 */
	protected boolean isMany = IS_MANY_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsNullFree() <em>Is Null Free</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsNullFree()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_NULL_FREE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isIsNullFree() <em>Is Null Free</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsNullFree()
	 * @generated
	 * @ordered
	 */
	protected boolean isNullFree = IS_NULL_FREE_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsOrdered() <em>Is Ordered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsOrdered()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ORDERED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsOrdered() <em>Is Ordered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsOrdered()
	 * @generated
	 * @ordered
	 */
	protected boolean isOrdered = IS_ORDERED_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsRequired() <em>Is Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsRequired()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_REQUIRED_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isIsRequired() <em>Is Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsRequired()
	 * @generated
	 * @ordered
	 */
	protected boolean isRequired = IS_REQUIRED_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsUnique() <em>Is Unique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsUnique()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_UNIQUE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isIsUnique() <em>Is Unique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsUnique()
	 * @generated
	 * @ordered
	 */
	protected boolean isUnique = IS_UNIQUE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getReferredEClassifier() <em>Referred EClassifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredEClassifier()
	 * @generated
	 * @ordered
	 */
	protected EClassifier referredEClassifier;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UMLXTypedElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLXPackage.Literals.UMLX_TYPED_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsMany() {
		return isMany;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsMany(boolean newIsMany) {
		boolean oldIsMany = isMany;
		isMany = newIsMany;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 0, oldIsMany, isMany));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsNullFree() {
		return isNullFree;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsNullFree(boolean newIsNullFree) {
		boolean oldIsNullFree = isNullFree;
		isNullFree = newIsNullFree;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 1, oldIsNullFree, isNullFree));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsOrdered() {
		return isOrdered;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsOrdered(boolean newIsOrdered) {
		boolean oldIsOrdered = isOrdered;
		isOrdered = newIsOrdered;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 2, oldIsOrdered, isOrdered));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsRequired() {
		return isRequired;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsRequired(boolean newIsRequired) {
		boolean oldIsRequired = isRequired;
		isRequired = newIsRequired;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 3, oldIsRequired, isRequired));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsUnique() {
		return isUnique;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsUnique(boolean newIsUnique) {
		boolean oldIsUnique = isUnique;
		isUnique = newIsUnique;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 4, oldIsUnique, isUnique));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClassifier getReferredEClassifier() {
		if (referredEClassifier != null && referredEClassifier.eIsProxy()) {
			InternalEObject oldReferredEClassifier = (InternalEObject)referredEClassifier;
			referredEClassifier = (EClassifier)eResolveProxy(oldReferredEClassifier);
			if (referredEClassifier != oldReferredEClassifier) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 5, oldReferredEClassifier, referredEClassifier));
			}
		}
		return referredEClassifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClassifier basicGetReferredEClassifier() {
		return referredEClassifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferredEClassifier(EClassifier newReferredEClassifier) {
		EClassifier oldReferredEClassifier = referredEClassifier;
		referredEClassifier = newReferredEClassifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 5, oldReferredEClassifier, referredEClassifier));
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
		result.append(" (isMany: ");
		result.append(isMany);
		result.append(", isNullFree: ");
		result.append(isNullFree);
		result.append(", isOrdered: ");
		result.append(isOrdered);
		result.append(", isRequired: ");
		result.append(isRequired);
		result.append(", isUnique: ");
		result.append(isUnique);
		result.append(')');
		return result.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 0:
				return isIsMany();
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 1:
				return isIsNullFree();
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 2:
				return isIsOrdered();
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 3:
				return isIsRequired();
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 4:
				return isIsUnique();
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 5:
				if (resolve) return getReferredEClassifier();
				return basicGetReferredEClassifier();
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
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 0:
				setIsMany((Boolean)newValue);
				return;
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 1:
				setIsNullFree((Boolean)newValue);
				return;
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 2:
				setIsOrdered((Boolean)newValue);
				return;
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 3:
				setIsRequired((Boolean)newValue);
				return;
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 4:
				setIsUnique((Boolean)newValue);
				return;
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 5:
				setReferredEClassifier((EClassifier)newValue);
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
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 0:
				setIsMany(IS_MANY_EDEFAULT);
				return;
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 1:
				setIsNullFree(IS_NULL_FREE_EDEFAULT);
				return;
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 2:
				setIsOrdered(IS_ORDERED_EDEFAULT);
				return;
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 3:
				setIsRequired(IS_REQUIRED_EDEFAULT);
				return;
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 4:
				setIsUnique(IS_UNIQUE_EDEFAULT);
				return;
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 5:
				setReferredEClassifier((EClassifier)null);
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
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 0:
				return isMany != IS_MANY_EDEFAULT;
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 1:
				return isNullFree != IS_NULL_FREE_EDEFAULT;
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 2:
				return isOrdered != IS_ORDERED_EDEFAULT;
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 3:
				return isRequired != IS_REQUIRED_EDEFAULT;
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 4:
				return isUnique != IS_UNIQUE_EDEFAULT;
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 5:
				return referredEClassifier != null;
		}
		return super.eIsSet(featureID);
	}


} //UMLXTypedElementImpl
