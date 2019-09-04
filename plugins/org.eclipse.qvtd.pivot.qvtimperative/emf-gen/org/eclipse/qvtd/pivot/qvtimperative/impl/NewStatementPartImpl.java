/**
 * <copyright>
 *
 * Copyright (c) 2013, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.pivot.qvtimperative.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;

import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Property;

import org.eclipse.ocl.pivot.internal.NamedElementImpl;
import org.eclipse.ocl.pivot.internal.VariableDeclarationImpl;
import org.eclipse.ocl.pivot.util.Visitor;

import org.eclipse.qvtd.pivot.qvtimperative.NewStatement;
import org.eclipse.qvtd.pivot.qvtimperative.NewStatementPart;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;

import org.eclipse.qvtd.pivot.qvtimperative.util.QVTimperativeVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>New Statement Part</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.NewStatementPartImpl#getReferredProperty <em>Referred Property</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.NewStatementPartImpl#getOwnedExpression <em>Owned Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.NewStatementPartImpl#getOwningNewStatement <em>Owning New Statement</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NewStatementPartImpl extends NamedElementImpl implements NewStatementPart {
	/**
	 * The number of structural features of the '<em>New Statement Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int NEW_STATEMENT_PART_FEATURE_COUNT = NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>New Statement Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int NEW_STATEMENT_PART_OPERATION_COUNT = NamedElementImpl.NAMED_ELEMENT_OPERATION_COUNT + 0;


	/**
	 * The cached value of the '{@link #getReferredProperty() <em>Referred Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredProperty()
	 * @generated
	 * @ordered
	 */
	protected Property referredProperty;

	/**
	 * The cached value of the '{@link #getOwnedExpression() <em>Owned Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedExpression()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression ownedExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NewStatementPartImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTimperativePackage.Literals.NEW_STATEMENT_PART;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Property getReferredProperty() {
		if (referredProperty != null && referredProperty.eIsProxy()) {
			InternalEObject oldReferredProperty = (InternalEObject)referredProperty;
			referredProperty = (Property)eResolveProxy(oldReferredProperty);
			if (referredProperty != oldReferredProperty) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0, oldReferredProperty, referredProperty));
			}
		}
		return referredProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetReferredProperty() {
		return referredProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferredProperty(Property newReferredProperty) {
		Property oldReferredProperty = referredProperty;
		referredProperty = newReferredProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0, oldReferredProperty, referredProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OCLExpression getOwnedExpression() {
		return ownedExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedExpression(OCLExpression newOwnedExpression, NotificationChain msgs) {
		OCLExpression oldOwnedExpression = ownedExpression;
		ownedExpression = newOwnedExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1, oldOwnedExpression, newOwnedExpression);
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
	public void setOwnedExpression(OCLExpression newOwnedExpression) {
		if (newOwnedExpression != ownedExpression) {
			NotificationChain msgs = null;
			if (ownedExpression != null)
				msgs = ((InternalEObject)ownedExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1), null, msgs);
			if (newOwnedExpression != null)
				msgs = ((InternalEObject)newOwnedExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - (NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1), null, msgs);
			msgs = basicSetOwnedExpression(newOwnedExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1, newOwnedExpression, newOwnedExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NewStatement getOwningNewStatement() {
		if (eContainerFeatureID() != (NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2)) return null;
		return (NewStatement)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningNewStatement(NewStatement newOwningNewStatement, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningNewStatement, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningNewStatement(NewStatement newOwningNewStatement) {
		if (newOwningNewStatement != eInternalContainer() || (eContainerFeatureID() != (NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2) && newOwningNewStatement != null)) {
			if (EcoreUtil.isAncestor(this, newOwningNewStatement))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningNewStatement != null)
				msgs = ((InternalEObject)newOwningNewStatement).eInverseAdd(this, VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 4, NewStatement.class, msgs);
			msgs = basicSetOwningNewStatement(newOwningNewStatement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2, newOwningNewStatement, newOwningNewStatement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
			return basicSetOwningNewStatement((NewStatement)otherEnd, msgs);
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1:
				return basicSetOwnedExpression(null, msgs);
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2:
				return basicSetOwningNewStatement(null, msgs);
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2:
				return eInternalContainer().eInverseRemove(this, VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 4, NewStatement.class, msgs);
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0:
				if (resolve) return getReferredProperty();
			return basicGetReferredProperty();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1:
				return getOwnedExpression();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2:
				return getOwningNewStatement();
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0:
				setReferredProperty((Property)newValue);
			return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1:
				setOwnedExpression((OCLExpression)newValue);
			return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2:
				setOwningNewStatement((NewStatement)newValue);
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0:
				setReferredProperty((Property)null);
			return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1:
				setOwnedExpression((OCLExpression)null);
			return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2:
				setOwningNewStatement((NewStatement)null);
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0:
				return referredProperty != null;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1:
				return ownedExpression != null;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2:
				return getOwningNewStatement() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		if (visitor instanceof QVTimperativeVisitor) {
			return (R) ((QVTimperativeVisitor<?>)visitor).visitNewStatementPart(this);
		}
		else {
			return super.accept(visitor);
		}
	}

	@Override
	public String getName() {
		return referredProperty != null ? referredProperty.getName() : null;
	}

} //NewStatementPartImpl
