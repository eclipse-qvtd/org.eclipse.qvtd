/*******************************************************************************
 * Copyright (c) 2007 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.qvt.declarative.parser.qvt.cst.IdentifiedCS;
import org.eclipse.qvt.declarative.parser.qvt.cst.IdentifierCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.CollectionTemplateCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.QVTrCSTPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection Template CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.CollectionTemplateCSImpl#getMemberIdentifier <em>Member Identifier</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.CollectionTemplateCSImpl#getReferredCollectionType <em>Referred Collection Type</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.CollectionTemplateCSImpl#getRestIdentifier <em>Rest Identifier</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CollectionTemplateCSImpl extends TemplateCSImpl implements CollectionTemplateCS {
	/**
	 * The cached value of the '{@link #getMemberIdentifier() <em>Member Identifier</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemberIdentifier()
	 * @generated
	 * @ordered
	 */
	protected EList<IdentifiedCS> memberIdentifier;

	/**
	 * The cached value of the '{@link #getReferredCollectionType() <em>Referred Collection Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredCollectionType()
	 * @generated
	 * @ordered
	 */
	protected EClassifier referredCollectionType;

	/**
	 * The cached value of the '{@link #getRestIdentifier() <em>Rest Identifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRestIdentifier()
	 * @generated
	 * @ordered
	 */
	protected IdentifierCS restIdentifier;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CollectionTemplateCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTrCSTPackage.Literals.COLLECTION_TEMPLATE_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IdentifiedCS> getMemberIdentifier() {
		if (memberIdentifier == null) {
			memberIdentifier = new EObjectContainmentEList<IdentifiedCS>(IdentifiedCS.class, this, QVTrCSTPackage.COLLECTION_TEMPLATE_CS__MEMBER_IDENTIFIER);
		}
		return memberIdentifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClassifier getReferredCollectionType() {
		if (referredCollectionType != null && referredCollectionType.eIsProxy()) {
			InternalEObject oldReferredCollectionType = (InternalEObject)referredCollectionType;
			referredCollectionType = (EClassifier)eResolveProxy(oldReferredCollectionType);
			if (referredCollectionType != oldReferredCollectionType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTrCSTPackage.COLLECTION_TEMPLATE_CS__REFERRED_COLLECTION_TYPE, oldReferredCollectionType, referredCollectionType));
			}
		}
		return referredCollectionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClassifier basicGetReferredCollectionType() {
		return referredCollectionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferredCollectionType(EClassifier newReferredCollectionType) {
		EClassifier oldReferredCollectionType = referredCollectionType;
		referredCollectionType = newReferredCollectionType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrCSTPackage.COLLECTION_TEMPLATE_CS__REFERRED_COLLECTION_TYPE, oldReferredCollectionType, referredCollectionType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IdentifierCS getRestIdentifier() {
		return restIdentifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRestIdentifier(IdentifierCS newRestIdentifier, NotificationChain msgs) {
		IdentifierCS oldRestIdentifier = restIdentifier;
		restIdentifier = newRestIdentifier;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTrCSTPackage.COLLECTION_TEMPLATE_CS__REST_IDENTIFIER, oldRestIdentifier, newRestIdentifier);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRestIdentifier(IdentifierCS newRestIdentifier) {
		if (newRestIdentifier != restIdentifier) {
			NotificationChain msgs = null;
			if (restIdentifier != null)
				msgs = ((InternalEObject)restIdentifier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTrCSTPackage.COLLECTION_TEMPLATE_CS__REST_IDENTIFIER, null, msgs);
			if (newRestIdentifier != null)
				msgs = ((InternalEObject)newRestIdentifier).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTrCSTPackage.COLLECTION_TEMPLATE_CS__REST_IDENTIFIER, null, msgs);
			msgs = basicSetRestIdentifier(newRestIdentifier, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrCSTPackage.COLLECTION_TEMPLATE_CS__REST_IDENTIFIER, newRestIdentifier, newRestIdentifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTrCSTPackage.COLLECTION_TEMPLATE_CS__MEMBER_IDENTIFIER:
				return ((InternalEList<?>)getMemberIdentifier()).basicRemove(otherEnd, msgs);
			case QVTrCSTPackage.COLLECTION_TEMPLATE_CS__REST_IDENTIFIER:
				return basicSetRestIdentifier(null, msgs);
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
			case QVTrCSTPackage.COLLECTION_TEMPLATE_CS__MEMBER_IDENTIFIER:
				return getMemberIdentifier();
			case QVTrCSTPackage.COLLECTION_TEMPLATE_CS__REFERRED_COLLECTION_TYPE:
				if (resolve) return getReferredCollectionType();
				return basicGetReferredCollectionType();
			case QVTrCSTPackage.COLLECTION_TEMPLATE_CS__REST_IDENTIFIER:
				return getRestIdentifier();
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
			case QVTrCSTPackage.COLLECTION_TEMPLATE_CS__MEMBER_IDENTIFIER:
				getMemberIdentifier().clear();
				getMemberIdentifier().addAll((Collection<? extends IdentifiedCS>)newValue);
				return;
			case QVTrCSTPackage.COLLECTION_TEMPLATE_CS__REFERRED_COLLECTION_TYPE:
				setReferredCollectionType((EClassifier)newValue);
				return;
			case QVTrCSTPackage.COLLECTION_TEMPLATE_CS__REST_IDENTIFIER:
				setRestIdentifier((IdentifierCS)newValue);
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
			case QVTrCSTPackage.COLLECTION_TEMPLATE_CS__MEMBER_IDENTIFIER:
				getMemberIdentifier().clear();
				return;
			case QVTrCSTPackage.COLLECTION_TEMPLATE_CS__REFERRED_COLLECTION_TYPE:
				setReferredCollectionType((EClassifier)null);
				return;
			case QVTrCSTPackage.COLLECTION_TEMPLATE_CS__REST_IDENTIFIER:
				setRestIdentifier((IdentifierCS)null);
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
			case QVTrCSTPackage.COLLECTION_TEMPLATE_CS__MEMBER_IDENTIFIER:
				return memberIdentifier != null && !memberIdentifier.isEmpty();
			case QVTrCSTPackage.COLLECTION_TEMPLATE_CS__REFERRED_COLLECTION_TYPE:
				return referredCollectionType != null;
			case QVTrCSTPackage.COLLECTION_TEMPLATE_CS__REST_IDENTIFIER:
				return restIdentifier != null;
		}
		return super.eIsSet(featureID);
	}

} //CollectionTemplateCSImpl
