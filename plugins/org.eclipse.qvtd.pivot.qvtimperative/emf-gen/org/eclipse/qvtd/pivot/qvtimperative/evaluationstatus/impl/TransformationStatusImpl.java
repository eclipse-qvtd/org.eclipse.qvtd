/*******************************************************************************
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.AssociationStatus;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.ClassStatus;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.EvaluationStatusPackage;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.MappingStatus;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.TransformationStatus;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.util.EvaluationStatusVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transformation Status</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.TransformationStatusImpl#getOwnedAssociationStatuses <em>Owned Association Statuses</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.TransformationStatusImpl#getOwnedClassStatuses <em>Owned Class Statuses</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.TransformationStatusImpl#getOwnedMappingStatuses <em>Owned Mapping Statuses</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TransformationStatusImpl extends EvaluationElementImpl implements TransformationStatus {
	/**
	 * The number of structural features of the '<em>Transformation Status</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TRANSFORMATION_STATUS_FEATURE_COUNT = EvaluationElementImpl.EVALUATION_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The cached value of the '{@link #getOwnedAssociationStatuses() <em>Owned Association Statuses</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedAssociationStatuses()
	 * @generated
	 * @ordered
	 */
	protected EList<AssociationStatus> ownedAssociationStatuses;

	/**
	 * The cached value of the '{@link #getOwnedClassStatuses() <em>Owned Class Statuses</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedClassStatuses()
	 * @generated
	 * @ordered
	 */
	protected EList<ClassStatus> ownedClassStatuses;

	/**
	 * The cached value of the '{@link #getOwnedMappingStatuses() <em>Owned Mapping Statuses</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedMappingStatuses()
	 * @generated
	 * @ordered
	 */
	protected EList<MappingStatus> ownedMappingStatuses;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransformationStatusImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EvaluationStatusPackage.Literals.TRANSFORMATION_STATUS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AssociationStatus> getOwnedAssociationStatuses() {
		if (ownedAssociationStatuses == null) {
			ownedAssociationStatuses = new EObjectContainmentWithInverseEList<AssociationStatus>(AssociationStatus.class, this, 0, 12);
		}
		return ownedAssociationStatuses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ClassStatus> getOwnedClassStatuses() {
		if (ownedClassStatuses == null) {
			ownedClassStatuses = new EObjectContainmentWithInverseEList<ClassStatus>(ClassStatus.class, this, 1, 8);
		}
		return ownedClassStatuses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<MappingStatus> getOwnedMappingStatuses() {
		if (ownedMappingStatuses == null) {
			ownedMappingStatuses = new EObjectContainmentWithInverseEList<MappingStatus>(MappingStatus.class, this, 2, 6);
		}
		return ownedMappingStatuses;
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
			case 0:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedAssociationStatuses()).basicAdd(otherEnd, msgs);
			case 1:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedClassStatuses()).basicAdd(otherEnd, msgs);
			case 2:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedMappingStatuses()).basicAdd(otherEnd, msgs);
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
			case 0:
				return ((InternalEList<?>)getOwnedAssociationStatuses()).basicRemove(otherEnd, msgs);
			case 1:
				return ((InternalEList<?>)getOwnedClassStatuses()).basicRemove(otherEnd, msgs);
			case 2:
				return ((InternalEList<?>)getOwnedMappingStatuses()).basicRemove(otherEnd, msgs);
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
			case 0:
				return getOwnedAssociationStatuses();
			case 1:
				return getOwnedClassStatuses();
			case 2:
				return getOwnedMappingStatuses();
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
			case 0:
				getOwnedAssociationStatuses().clear();
				getOwnedAssociationStatuses().addAll((Collection<? extends AssociationStatus>)newValue);
				return;
			case 1:
				getOwnedClassStatuses().clear();
				getOwnedClassStatuses().addAll((Collection<? extends ClassStatus>)newValue);
				return;
			case 2:
				getOwnedMappingStatuses().clear();
				getOwnedMappingStatuses().addAll((Collection<? extends MappingStatus>)newValue);
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
			case 0:
				getOwnedAssociationStatuses().clear();
				return;
			case 1:
				getOwnedClassStatuses().clear();
				return;
			case 2:
				getOwnedMappingStatuses().clear();
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
			case 0:
				return ownedAssociationStatuses != null && !ownedAssociationStatuses.isEmpty();
			case 1:
				return ownedClassStatuses != null && !ownedClassStatuses.isEmpty();
			case 2:
				return ownedMappingStatuses != null && !ownedMappingStatuses.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull EvaluationStatusVisitor<R> visitor) {
		return visitor.visitTransformationStatus(this);
	}

} //TransformationStatusImpl
