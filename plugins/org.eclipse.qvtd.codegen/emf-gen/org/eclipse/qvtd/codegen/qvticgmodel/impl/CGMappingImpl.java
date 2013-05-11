/**
 * <copyright>
 * 
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.qvtd.codegen.qvticgmodel.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.cgmodel.impl.CGTypedElementImpl;
import org.eclipse.ocl.examples.codegen.cgmodel.util.CGModelVisitor;
import org.eclipse.qvtd.codegen.qvticgmodel.CGGuardVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMapping;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCall;
import org.eclipse.qvtd.codegen.qvticgmodel.CGPredicate;
import org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation;
import org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage;
import org.eclipse.qvtd.codegen.qvticgmodel.util.QVTiCGModelVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CG Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingImpl#getTransformation <em>Transformation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingImpl#getGuardVariables <em>Guard Variables</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingImpl#getPredicates <em>Predicates</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingImpl#getRealizedVariables <em>Realized Variables</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingImpl#getAssignments <em>Assignments</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingImpl#getMappingCalls <em>Mapping Calls</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CGMappingImpl extends CGTypedElementImpl implements CGMapping {
	/**
	 * The cached value of the '{@link #getGuardVariables() <em>Guard Variables</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGuardVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<CGGuardVariable> guardVariables;

	/**
	 * The cached value of the '{@link #getPredicates() <em>Predicates</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPredicates()
	 * @generated
	 * @ordered
	 */
	protected EList<CGPredicate> predicates;

	/**
	 * The cached value of the '{@link #getRealizedVariables() <em>Realized Variables</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRealizedVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<CGRealizedVariable> realizedVariables;

	/**
	 * The cached value of the '{@link #getAssignments() <em>Assignments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssignments()
	 * @generated
	 * @ordered
	 */
	protected EList<CGPropertyAssignment> assignments;

	/**
	 * The cached value of the '{@link #getMappingCalls() <em>Mapping Calls</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappingCalls()
	 * @generated
	 * @ordered
	 */
	protected EList<CGMappingCall> mappingCalls;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CGMappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTiCGModelPackage.Literals.CG_MAPPING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGTransformation getTransformation() {
		if (eContainerFeatureID() != QVTiCGModelPackage.CG_MAPPING__TRANSFORMATION) return null;
		return (CGTransformation)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTransformation(CGTransformation newTransformation, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newTransformation, QVTiCGModelPackage.CG_MAPPING__TRANSFORMATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransformation(CGTransformation newTransformation) {
		if (newTransformation != eInternalContainer() || (eContainerFeatureID() != QVTiCGModelPackage.CG_MAPPING__TRANSFORMATION && newTransformation != null)) {
			if (EcoreUtil.isAncestor(this, newTransformation))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newTransformation != null)
				msgs = ((InternalEObject)newTransformation).eInverseAdd(this, QVTiCGModelPackage.CG_TRANSFORMATION__MAPPINGS, CGTransformation.class, msgs);
			msgs = basicSetTransformation(newTransformation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTiCGModelPackage.CG_MAPPING__TRANSFORMATION, newTransformation, newTransformation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<CGGuardVariable> getGuardVariables() {
		if (guardVariables == null) {
			guardVariables = new EObjectContainmentWithInverseEList<CGGuardVariable>(CGGuardVariable.class, this, QVTiCGModelPackage.CG_MAPPING__GUARD_VARIABLES, QVTiCGModelPackage.CG_GUARD_VARIABLE__MAPPING);
		}
		return guardVariables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<CGPredicate> getPredicates() {
		if (predicates == null) {
			predicates = new EObjectContainmentWithInverseEList<CGPredicate>(CGPredicate.class, this, QVTiCGModelPackage.CG_MAPPING__PREDICATES, QVTiCGModelPackage.CG_PREDICATE__MAPPING);
		}
		return predicates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<CGMappingCall> getMappingCalls() {
		if (mappingCalls == null) {
			mappingCalls = new EObjectContainmentWithInverseEList<CGMappingCall>(CGMappingCall.class, this, QVTiCGModelPackage.CG_MAPPING__MAPPING_CALLS, QVTiCGModelPackage.CG_MAPPING_CALL__MAPPING);
		}
		return mappingCalls;
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
			case QVTiCGModelPackage.CG_MAPPING__TRANSFORMATION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetTransformation((CGTransformation)otherEnd, msgs);
			case QVTiCGModelPackage.CG_MAPPING__GUARD_VARIABLES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getGuardVariables()).basicAdd(otherEnd, msgs);
			case QVTiCGModelPackage.CG_MAPPING__PREDICATES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getPredicates()).basicAdd(otherEnd, msgs);
			case QVTiCGModelPackage.CG_MAPPING__REALIZED_VARIABLES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRealizedVariables()).basicAdd(otherEnd, msgs);
			case QVTiCGModelPackage.CG_MAPPING__ASSIGNMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAssignments()).basicAdd(otherEnd, msgs);
			case QVTiCGModelPackage.CG_MAPPING__MAPPING_CALLS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getMappingCalls()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<CGRealizedVariable> getRealizedVariables() {
		if (realizedVariables == null) {
			realizedVariables = new EObjectContainmentWithInverseEList<CGRealizedVariable>(CGRealizedVariable.class, this, QVTiCGModelPackage.CG_MAPPING__REALIZED_VARIABLES, QVTiCGModelPackage.CG_REALIZED_VARIABLE__MAPPING);
		}
		return realizedVariables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<CGPropertyAssignment> getAssignments() {
		if (assignments == null) {
			assignments = new EObjectContainmentWithInverseEList<CGPropertyAssignment>(CGPropertyAssignment.class, this, QVTiCGModelPackage.CG_MAPPING__ASSIGNMENTS, QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__MAPPING);
		}
		return assignments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTiCGModelPackage.CG_MAPPING__TRANSFORMATION:
				return basicSetTransformation(null, msgs);
			case QVTiCGModelPackage.CG_MAPPING__GUARD_VARIABLES:
				return ((InternalEList<?>)getGuardVariables()).basicRemove(otherEnd, msgs);
			case QVTiCGModelPackage.CG_MAPPING__PREDICATES:
				return ((InternalEList<?>)getPredicates()).basicRemove(otherEnd, msgs);
			case QVTiCGModelPackage.CG_MAPPING__REALIZED_VARIABLES:
				return ((InternalEList<?>)getRealizedVariables()).basicRemove(otherEnd, msgs);
			case QVTiCGModelPackage.CG_MAPPING__ASSIGNMENTS:
				return ((InternalEList<?>)getAssignments()).basicRemove(otherEnd, msgs);
			case QVTiCGModelPackage.CG_MAPPING__MAPPING_CALLS:
				return ((InternalEList<?>)getMappingCalls()).basicRemove(otherEnd, msgs);
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
			case QVTiCGModelPackage.CG_MAPPING__TRANSFORMATION:
				return eInternalContainer().eInverseRemove(this, QVTiCGModelPackage.CG_TRANSFORMATION__MAPPINGS, CGTransformation.class, msgs);
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
			case QVTiCGModelPackage.CG_MAPPING__TRANSFORMATION:
				return getTransformation();
			case QVTiCGModelPackage.CG_MAPPING__GUARD_VARIABLES:
				return getGuardVariables();
			case QVTiCGModelPackage.CG_MAPPING__PREDICATES:
				return getPredicates();
			case QVTiCGModelPackage.CG_MAPPING__REALIZED_VARIABLES:
				return getRealizedVariables();
			case QVTiCGModelPackage.CG_MAPPING__ASSIGNMENTS:
				return getAssignments();
			case QVTiCGModelPackage.CG_MAPPING__MAPPING_CALLS:
				return getMappingCalls();
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
			case QVTiCGModelPackage.CG_MAPPING__TRANSFORMATION:
				setTransformation((CGTransformation)newValue);
				return;
			case QVTiCGModelPackage.CG_MAPPING__GUARD_VARIABLES:
				getGuardVariables().clear();
				getGuardVariables().addAll((Collection<? extends CGGuardVariable>)newValue);
				return;
			case QVTiCGModelPackage.CG_MAPPING__PREDICATES:
				getPredicates().clear();
				getPredicates().addAll((Collection<? extends CGPredicate>)newValue);
				return;
			case QVTiCGModelPackage.CG_MAPPING__REALIZED_VARIABLES:
				getRealizedVariables().clear();
				getRealizedVariables().addAll((Collection<? extends CGRealizedVariable>)newValue);
				return;
			case QVTiCGModelPackage.CG_MAPPING__ASSIGNMENTS:
				getAssignments().clear();
				getAssignments().addAll((Collection<? extends CGPropertyAssignment>)newValue);
				return;
			case QVTiCGModelPackage.CG_MAPPING__MAPPING_CALLS:
				getMappingCalls().clear();
				getMappingCalls().addAll((Collection<? extends CGMappingCall>)newValue);
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
			case QVTiCGModelPackage.CG_MAPPING__TRANSFORMATION:
				setTransformation((CGTransformation)null);
				return;
			case QVTiCGModelPackage.CG_MAPPING__GUARD_VARIABLES:
				getGuardVariables().clear();
				return;
			case QVTiCGModelPackage.CG_MAPPING__PREDICATES:
				getPredicates().clear();
				return;
			case QVTiCGModelPackage.CG_MAPPING__REALIZED_VARIABLES:
				getRealizedVariables().clear();
				return;
			case QVTiCGModelPackage.CG_MAPPING__ASSIGNMENTS:
				getAssignments().clear();
				return;
			case QVTiCGModelPackage.CG_MAPPING__MAPPING_CALLS:
				getMappingCalls().clear();
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
			case QVTiCGModelPackage.CG_MAPPING__TRANSFORMATION:
				return getTransformation() != null;
			case QVTiCGModelPackage.CG_MAPPING__GUARD_VARIABLES:
				return guardVariables != null && !guardVariables.isEmpty();
			case QVTiCGModelPackage.CG_MAPPING__PREDICATES:
				return predicates != null && !predicates.isEmpty();
			case QVTiCGModelPackage.CG_MAPPING__REALIZED_VARIABLES:
				return realizedVariables != null && !realizedVariables.isEmpty();
			case QVTiCGModelPackage.CG_MAPPING__ASSIGNMENTS:
				return assignments != null && !assignments.isEmpty();
			case QVTiCGModelPackage.CG_MAPPING__MAPPING_CALLS:
				return mappingCalls != null && !mappingCalls.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@Override
	public <R> R accept(@NonNull CGModelVisitor<R> visitor) {
		return ((QVTiCGModelVisitor<R>)visitor).visitCGMapping(this);
	}
} //CGMappingImpl
