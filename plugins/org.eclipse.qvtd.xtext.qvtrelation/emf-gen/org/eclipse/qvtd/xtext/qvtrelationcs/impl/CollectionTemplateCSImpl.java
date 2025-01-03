/*******************************************************************************
 * Copyright (c) 2012, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtrelationcs.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;
import org.eclipse.ocl.xtext.essentialoclcs.impl.ExpCSImpl;
import org.eclipse.qvtd.xtext.qvtrelationcs.CollectionTemplateCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.ElementTemplateCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage;
import org.eclipse.qvtd.xtext.qvtrelationcs.TemplateVariableCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.util.QVTrelationCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection Template CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.CollectionTemplateCSImpl#getOwnedMemberIdentifiers <em>Owned Member Identifiers</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.CollectionTemplateCSImpl#getOwnedRestIdentifier <em>Owned Rest Identifier</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CollectionTemplateCSImpl extends TemplateCSImpl implements CollectionTemplateCS {
	/**
	 * The number of structural features of the '<em>Collection Template CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int COLLECTION_TEMPLATE_CS_FEATURE_COUNT = TemplateCSImpl.TEMPLATE_CS_FEATURE_COUNT + 2;

	/**
	 * The cached value of the '{@link #getOwnedMemberIdentifiers() <em>Owned Member Identifiers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedMemberIdentifiers()
	 * @generated
	 * @ordered
	 */
	protected EList<TemplateVariableCS> ownedMemberIdentifiers;

	/**
	 * The cached value of the '{@link #getOwnedRestIdentifier() <em>Owned Rest Identifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedRestIdentifier()
	 * @generated
	 * @ordered
	 */
	protected ElementTemplateCS ownedRestIdentifier;

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
		return QVTrelationCSPackage.Literals.COLLECTION_TEMPLATE_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TemplateVariableCS> getOwnedMemberIdentifiers() {
		if (ownedMemberIdentifiers == null) {
			ownedMemberIdentifiers = new EObjectContainmentEList<TemplateVariableCS>(TemplateVariableCS.class, this, ExpCSImpl.EXP_CS_FEATURE_COUNT + 3);
		}
		return ownedMemberIdentifiers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ElementTemplateCS getOwnedRestIdentifier() {
		return ownedRestIdentifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedRestIdentifier(ElementTemplateCS newOwnedRestIdentifier, NotificationChain msgs) {
		ElementTemplateCS oldOwnedRestIdentifier = ownedRestIdentifier;
		ownedRestIdentifier = newOwnedRestIdentifier;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpCSImpl.EXP_CS_FEATURE_COUNT + 4, oldOwnedRestIdentifier, newOwnedRestIdentifier);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwnedRestIdentifier(ElementTemplateCS newOwnedRestIdentifier) {
		if (newOwnedRestIdentifier != ownedRestIdentifier) {
			NotificationChain msgs = null;
			if (ownedRestIdentifier != null)
				msgs = ((InternalEObject)ownedRestIdentifier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (ExpCSImpl.EXP_CS_FEATURE_COUNT + 4), null, msgs);
			if (newOwnedRestIdentifier != null)
				msgs = ((InternalEObject)newOwnedRestIdentifier).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - (ExpCSImpl.EXP_CS_FEATURE_COUNT + 4), null, msgs);
			msgs = basicSetOwnedRestIdentifier(newOwnedRestIdentifier, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpCSImpl.EXP_CS_FEATURE_COUNT + 4, newOwnedRestIdentifier, newOwnedRestIdentifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExpCSImpl.EXP_CS_FEATURE_COUNT + 3:
				return ((InternalEList<?>)getOwnedMemberIdentifiers()).basicRemove(otherEnd, msgs);
			case ExpCSImpl.EXP_CS_FEATURE_COUNT + 4:
				return basicSetOwnedRestIdentifier(null, msgs);
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
			case ExpCSImpl.EXP_CS_FEATURE_COUNT + 3:
				return getOwnedMemberIdentifiers();
			case ExpCSImpl.EXP_CS_FEATURE_COUNT + 4:
				return getOwnedRestIdentifier();
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
			case ExpCSImpl.EXP_CS_FEATURE_COUNT + 3:
				getOwnedMemberIdentifiers().clear();
				getOwnedMemberIdentifiers().addAll((Collection<? extends TemplateVariableCS>)newValue);
				return;
			case ExpCSImpl.EXP_CS_FEATURE_COUNT + 4:
				setOwnedRestIdentifier((ElementTemplateCS)newValue);
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
			case ExpCSImpl.EXP_CS_FEATURE_COUNT + 3:
				getOwnedMemberIdentifiers().clear();
				return;
			case ExpCSImpl.EXP_CS_FEATURE_COUNT + 4:
				setOwnedRestIdentifier((ElementTemplateCS)null);
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
			case ExpCSImpl.EXP_CS_FEATURE_COUNT + 3:
				return ownedMemberIdentifiers != null && !ownedMemberIdentifiers.isEmpty();
			case ExpCSImpl.EXP_CS_FEATURE_COUNT + 4:
				return ownedRestIdentifier != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull BaseCSVisitor<R> visitor) {
		if (visitor instanceof QVTrelationCSVisitor) {
			return (R) ((QVTrelationCSVisitor<?>)visitor).visitCollectionTemplateCS(this);
		}
		else {
			return super.accept(visitor);
		}
	}
} //CollectionTemplateCSImpl
