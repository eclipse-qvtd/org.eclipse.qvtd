/*******************************************************************************
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;
import org.eclipse.qvtd.xtext.qvtrelationcs.CollectionTemplateCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage;
import org.eclipse.qvtd.xtext.qvtrelationcs.TemplateVariableCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.util.QVTrelationCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection Template CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.CollectionTemplateCSImpl#getMemberIdentifiers <em>Member Identifiers</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.CollectionTemplateCSImpl#getRestIdentifier <em>Rest Identifier</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CollectionTemplateCSImpl extends TemplateCSImpl implements CollectionTemplateCS {
	/**
	 * The cached value of the '{@link #getMemberIdentifiers() <em>Member Identifiers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemberIdentifiers()
	 * @generated
	 * @ordered
	 */
	protected EList<TemplateVariableCS> memberIdentifiers;

	/**
	 * The cached value of the '{@link #getRestIdentifier() <em>Rest Identifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRestIdentifier()
	 * @generated
	 * @ordered
	 */
	protected Variable restIdentifier;

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
	public EList<TemplateVariableCS> getMemberIdentifiers() {
		if (memberIdentifiers == null) {
			memberIdentifiers = new EObjectContainmentEList<TemplateVariableCS>(TemplateVariableCS.class, this, QVTrelationCSPackage.COLLECTION_TEMPLATE_CS__MEMBER_IDENTIFIERS);
		}
		return memberIdentifiers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Variable getRestIdentifier() {
		if (restIdentifier != null && restIdentifier.eIsProxy()) {
			InternalEObject oldRestIdentifier = (InternalEObject)restIdentifier;
			restIdentifier = (Variable)eResolveProxy(oldRestIdentifier);
			if (restIdentifier != oldRestIdentifier) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTrelationCSPackage.COLLECTION_TEMPLATE_CS__REST_IDENTIFIER, oldRestIdentifier, restIdentifier));
			}
		}
		return restIdentifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable basicGetRestIdentifier() {
		return restIdentifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRestIdentifier(Variable newRestIdentifier) {
		Variable oldRestIdentifier = restIdentifier;
		restIdentifier = newRestIdentifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrelationCSPackage.COLLECTION_TEMPLATE_CS__REST_IDENTIFIER, oldRestIdentifier, restIdentifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTrelationCSPackage.COLLECTION_TEMPLATE_CS__MEMBER_IDENTIFIERS:
				return ((InternalEList<?>)getMemberIdentifiers()).basicRemove(otherEnd, msgs);
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
			case QVTrelationCSPackage.COLLECTION_TEMPLATE_CS__MEMBER_IDENTIFIERS:
				return getMemberIdentifiers();
			case QVTrelationCSPackage.COLLECTION_TEMPLATE_CS__REST_IDENTIFIER:
				if (resolve) return getRestIdentifier();
				return basicGetRestIdentifier();
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
			case QVTrelationCSPackage.COLLECTION_TEMPLATE_CS__MEMBER_IDENTIFIERS:
				getMemberIdentifiers().clear();
				getMemberIdentifiers().addAll((Collection<? extends TemplateVariableCS>)newValue);
				return;
			case QVTrelationCSPackage.COLLECTION_TEMPLATE_CS__REST_IDENTIFIER:
				setRestIdentifier((Variable)newValue);
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
			case QVTrelationCSPackage.COLLECTION_TEMPLATE_CS__MEMBER_IDENTIFIERS:
				getMemberIdentifiers().clear();
				return;
			case QVTrelationCSPackage.COLLECTION_TEMPLATE_CS__REST_IDENTIFIER:
				setRestIdentifier((Variable)null);
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
			case QVTrelationCSPackage.COLLECTION_TEMPLATE_CS__MEMBER_IDENTIFIERS:
				return memberIdentifiers != null && !memberIdentifiers.isEmpty();
			case QVTrelationCSPackage.COLLECTION_TEMPLATE_CS__REST_IDENTIFIER:
				return restIdentifier != null;
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
	public @Nullable <R> R accept(@NonNull BaseCSVisitor<R> visitor) {
		return (R) ((QVTrelationCSVisitor<?>)visitor).visitCollectionTemplateCS(this);
	}
} //CollectionTemplateCSImpl
