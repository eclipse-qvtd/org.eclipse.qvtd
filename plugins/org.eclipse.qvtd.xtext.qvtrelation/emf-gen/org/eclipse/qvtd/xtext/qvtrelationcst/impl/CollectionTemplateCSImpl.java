/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.qvtd.xtext.qvtrelationcst.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.CollectionTemplateCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.QVTrelationCSTPackage;
import org.eclipse.qvtd.xtext.qvtrelationcst.util.QVTrelationCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection Template CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.CollectionTemplateCSImpl#getMemberIdentifier <em>Member Identifier</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.CollectionTemplateCSImpl#getRestIdentifier <em>Rest Identifier</em>}</li>
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
	protected EList<ExpCS> memberIdentifier;

	/**
	 * The cached value of the '{@link #getRestIdentifier() <em>Rest Identifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRestIdentifier()
	 * @generated
	 * @ordered
	 */
	protected ExpCS restIdentifier;

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
		return QVTrelationCSTPackage.Literals.COLLECTION_TEMPLATE_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExpCS> getMemberIdentifier() {
		if (memberIdentifier == null) {
			memberIdentifier = new EObjectContainmentEList<ExpCS>(ExpCS.class, this, QVTrelationCSTPackage.COLLECTION_TEMPLATE_CS__MEMBER_IDENTIFIER);
		}
		return memberIdentifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpCS getRestIdentifier() {
		return restIdentifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRestIdentifier(ExpCS newRestIdentifier, NotificationChain msgs) {
		ExpCS oldRestIdentifier = restIdentifier;
		restIdentifier = newRestIdentifier;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTrelationCSTPackage.COLLECTION_TEMPLATE_CS__REST_IDENTIFIER, oldRestIdentifier, newRestIdentifier);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRestIdentifier(ExpCS newRestIdentifier) {
		if (newRestIdentifier != restIdentifier) {
			NotificationChain msgs = null;
			if (restIdentifier != null)
				msgs = ((InternalEObject)restIdentifier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTrelationCSTPackage.COLLECTION_TEMPLATE_CS__REST_IDENTIFIER, null, msgs);
			if (newRestIdentifier != null)
				msgs = ((InternalEObject)newRestIdentifier).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTrelationCSTPackage.COLLECTION_TEMPLATE_CS__REST_IDENTIFIER, null, msgs);
			msgs = basicSetRestIdentifier(newRestIdentifier, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrelationCSTPackage.COLLECTION_TEMPLATE_CS__REST_IDENTIFIER, newRestIdentifier, newRestIdentifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTrelationCSTPackage.COLLECTION_TEMPLATE_CS__MEMBER_IDENTIFIER:
				return ((InternalEList<?>)getMemberIdentifier()).basicRemove(otherEnd, msgs);
			case QVTrelationCSTPackage.COLLECTION_TEMPLATE_CS__REST_IDENTIFIER:
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
			case QVTrelationCSTPackage.COLLECTION_TEMPLATE_CS__MEMBER_IDENTIFIER:
				return getMemberIdentifier();
			case QVTrelationCSTPackage.COLLECTION_TEMPLATE_CS__REST_IDENTIFIER:
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
			case QVTrelationCSTPackage.COLLECTION_TEMPLATE_CS__MEMBER_IDENTIFIER:
				getMemberIdentifier().clear();
				getMemberIdentifier().addAll((Collection<? extends ExpCS>)newValue);
				return;
			case QVTrelationCSTPackage.COLLECTION_TEMPLATE_CS__REST_IDENTIFIER:
				setRestIdentifier((ExpCS)newValue);
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
			case QVTrelationCSTPackage.COLLECTION_TEMPLATE_CS__MEMBER_IDENTIFIER:
				getMemberIdentifier().clear();
				return;
			case QVTrelationCSTPackage.COLLECTION_TEMPLATE_CS__REST_IDENTIFIER:
				setRestIdentifier((ExpCS)null);
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
			case QVTrelationCSTPackage.COLLECTION_TEMPLATE_CS__MEMBER_IDENTIFIER:
				return memberIdentifier != null && !memberIdentifier.isEmpty();
			case QVTrelationCSTPackage.COLLECTION_TEMPLATE_CS__REST_IDENTIFIER:
				return restIdentifier != null;
		}
		return super.eIsSet(featureID);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(BaseCSVisitor<R> visitor) {
		return (R) visitor.getAdapter(QVTrelationCSVisitor.class).visitCollectionTemplateCS(this);
	}
} //CollectionTemplateCSImpl
