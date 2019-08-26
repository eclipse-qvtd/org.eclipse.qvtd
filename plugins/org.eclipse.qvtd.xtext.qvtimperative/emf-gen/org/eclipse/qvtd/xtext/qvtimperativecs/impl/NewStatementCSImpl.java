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
package org.eclipse.qvtd.xtext.qvtimperativecs.impl;

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
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.ocl.xtext.basecs.impl.ModelElementCSImpl;
import org.eclipse.ocl.xtext.basecs.impl.TypedElementCSImpl;
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;
import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel;
import org.eclipse.qvtd.xtext.qvtimperativecs.NewStatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.ObservableStatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage;
import org.eclipse.qvtd.xtext.qvtimperativecs.StatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.util.QVTimperativeCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>New Statement CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.NewStatementCSImpl#getObservedProperties <em>Observed Properties</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.NewStatementCSImpl#isIsContained <em>Is Contained</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.NewStatementCSImpl#getOwnedExpression <em>Owned Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.NewStatementCSImpl#getReferredTypedModel <em>Referred Typed Model</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NewStatementCSImpl extends TypedElementCSImpl implements NewStatementCS {
	/**
	 * The number of structural features of the '<em>New Statement CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int NEW_STATEMENT_CS_FEATURE_COUNT = TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 4;

	/**
	 * The cached value of the '{@link #getObservedProperties() <em>Observed Properties</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObservedProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<PathNameCS> observedProperties;

	/**
	 * The default value of the '{@link #isIsContained() <em>Is Contained</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsContained()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_CONTAINED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsContained() <em>Is Contained</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsContained()
	 * @generated
	 * @ordered
	 */
	protected boolean isContained = IS_CONTAINED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOwnedExpression() <em>Owned Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedExpression()
	 * @generated
	 * @ordered
	 */
	protected ExpCS ownedExpression;

	/**
	 * The cached value of the '{@link #getReferredTypedModel() <em>Referred Typed Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredTypedModel()
	 * @generated
	 * @ordered
	 */
	protected ImperativeTypedModel referredTypedModel;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NewStatementCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTimperativeCSPackage.Literals.NEW_STATEMENT_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<PathNameCS> getObservedProperties() {
		if (observedProperties == null) {
			observedProperties = new EObjectContainmentEList<PathNameCS>(PathNameCS.class, this, TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 0);
		}
		return observedProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsContained() {
		return isContained;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsContained(boolean newIsContained) {
		boolean oldIsContained = isContained;
		isContained = newIsContained;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 1, oldIsContained, isContained));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExpCS getOwnedExpression() {
		return ownedExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedExpression(ExpCS newOwnedExpression, NotificationChain msgs) {
		ExpCS oldOwnedExpression = ownedExpression;
		ownedExpression = newOwnedExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 2, oldOwnedExpression, newOwnedExpression);
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
	public void setOwnedExpression(ExpCS newOwnedExpression) {
		if (newOwnedExpression != ownedExpression) {
			NotificationChain msgs = null;
			if (ownedExpression != null)
				msgs = ((InternalEObject)ownedExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 2), null, msgs);
			if (newOwnedExpression != null)
				msgs = ((InternalEObject)newOwnedExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - (TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 2), null, msgs);
			msgs = basicSetOwnedExpression(newOwnedExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 2, newOwnedExpression, newOwnedExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ImperativeTypedModel getReferredTypedModel() {
		if (referredTypedModel != null && referredTypedModel.eIsProxy()) {
			InternalEObject oldReferredTypedModel = (InternalEObject)referredTypedModel;
			referredTypedModel = (ImperativeTypedModel)eResolveProxy(oldReferredTypedModel);
			if (referredTypedModel != oldReferredTypedModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 3, oldReferredTypedModel, referredTypedModel));
			}
		}
		return referredTypedModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImperativeTypedModel basicGetReferredTypedModel() {
		return referredTypedModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferredTypedModel(ImperativeTypedModel newReferredTypedModel) {
		ImperativeTypedModel oldReferredTypedModel = referredTypedModel;
		referredTypedModel = newReferredTypedModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 3, oldReferredTypedModel, referredTypedModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		return super.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 0:
				return ((InternalEList<?>)getObservedProperties()).basicRemove(otherEnd, msgs);
			case TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 2:
				return basicSetOwnedExpression(null, msgs);
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
			case TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 0:
				return getObservedProperties();
			case TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 1:
				return isIsContained();
			case TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 2:
				return getOwnedExpression();
			case TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 3:
				if (resolve) return getReferredTypedModel();
				return basicGetReferredTypedModel();
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
			case TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 0:
				getObservedProperties().clear();
				getObservedProperties().addAll((Collection<? extends PathNameCS>)newValue);
				return;
			case TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 1:
				setIsContained((Boolean)newValue);
				return;
			case TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 2:
				setOwnedExpression((ExpCS)newValue);
				return;
			case TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 3:
				setReferredTypedModel((ImperativeTypedModel)newValue);
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
			case TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 0:
				getObservedProperties().clear();
				return;
			case TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 1:
				setIsContained(IS_CONTAINED_EDEFAULT);
				return;
			case TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 2:
				setOwnedExpression((ExpCS)null);
				return;
			case TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 3:
				setReferredTypedModel((ImperativeTypedModel)null);
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
			case TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 0:
				return observedProperties != null && !observedProperties.isEmpty();
			case TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 1:
				return isContained != IS_CONTAINED_EDEFAULT;
			case TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 2:
				return ownedExpression != null;
			case TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 3:
				return referredTypedModel != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == StatementCS.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == ObservableStatementCS.class) {
			switch (derivedFeatureID) {
				case TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 0: return ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 0;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == StatementCS.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == ObservableStatementCS.class) {
			switch (baseFeatureID) {
				case ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 0: return TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 0;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull BaseCSVisitor<R> visitor) {
		try {
			return (R) ((QVTimperativeCSVisitor<?>)visitor).visitNewStatementCS(this);
		}
		catch (ClassCastException e) {
			return super.accept(visitor);
		}
	}

} //NewStatementCSImpl
