/*******************************************************************************
 * Copyright (c) 2013, 2015 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.codegen.qvticgmodel.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGAccumulator;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGFinalVariable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.impl.CGValuedElementImpl;
import org.eclipse.ocl.examples.codegen.cgmodel.util.CGModelVisitor;
import org.eclipse.ocl.examples.codegen.cse.AbstractPlace;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.qvtd.codegen.qvti.cse.MappingExpPlaces;
import org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMapping;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGPredicate;
import org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage;
import org.eclipse.qvtd.codegen.qvticgmodel.util.QVTiCGModelVisitor;
import org.eclipse.qvtd.codegen.utilities.QVTiEquivalenceUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CG Mapping Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingExpImpl#getAssignments <em>Assignments</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingExpImpl#getMapping <em>Mapping</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingExpImpl#getPredicates <em>Predicates</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingExpImpl#getRealizedVariables <em>Realized Variables</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingExpImpl#getBody <em>Body</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingExpImpl#getVariableAssignments <em>Variable Assignments</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingExpImpl#getConnectionAssignments <em>Connection Assignments</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingExpImpl#getOwnedAccumulators <em>Owned Accumulators</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CGMappingExpImpl extends CGValuedElementImpl implements CGMappingExp {
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
	protected EList<CGValuedElement> realizedVariables;

	/**
	 * The cached value of the '{@link #getBody() <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBody()
	 * @generated
	 * @ordered
	 */
	protected CGValuedElement body;

	/**
	 * The cached value of the '{@link #getVariableAssignments() <em>Variable Assignments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariableAssignments()
	 * @generated
	 * @ordered
	 */
	protected EList<CGFinalVariable> variableAssignments;

	/**
	 * The cached value of the '{@link #getConnectionAssignments() <em>Connection Assignments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionAssignments()
	 * @generated
	 * @ordered
	 */
	protected EList<CGConnectionAssignment> connectionAssignments;

	/**
	 * The cached value of the '{@link #getOwnedAccumulators() <em>Owned Accumulators</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedAccumulators()
	 * @generated
	 * @ordered
	 */
	protected EList<CGAccumulator> ownedAccumulators;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CGMappingExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTiCGModelPackage.Literals.CG_MAPPING_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<CGPropertyAssignment> getAssignments() {
		if (assignments == null) {
			assignments = new EObjectContainmentWithInverseEList<CGPropertyAssignment>(CGPropertyAssignment.class, this, QVTiCGModelPackage.CG_MAPPING_EXP__ASSIGNMENTS, QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__MAPPING_EXP);
		}
		return assignments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CGMapping getMapping() {
		// TODO: implement this method to return the 'Mapping' reference
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMapping(CGMapping newMapping) {
		// TODO: implement this method to set the 'Mapping' reference
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<CGPredicate> getPredicates() {
		if (predicates == null) {
			predicates = new EObjectContainmentWithInverseEList<CGPredicate>(CGPredicate.class, this, QVTiCGModelPackage.CG_MAPPING_EXP__PREDICATES, QVTiCGModelPackage.CG_PREDICATE__MAPPING_EXP);
		}
		return predicates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<CGValuedElement> getRealizedVariables() {
		if (realizedVariables == null) {
			realizedVariables = new EObjectContainmentEList<CGValuedElement>(CGValuedElement.class, this, QVTiCGModelPackage.CG_MAPPING_EXP__REALIZED_VARIABLES);
		}
		return realizedVariables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CGValuedElement getBody() {
		return body;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBody(CGValuedElement newBody, NotificationChain msgs) {
		CGValuedElement oldBody = body;
		body = newBody;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTiCGModelPackage.CG_MAPPING_EXP__BODY, oldBody, newBody);
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
	public void setBody(CGValuedElement newBody) {
		if (newBody != body) {
			NotificationChain msgs = null;
			if (body != null)
				msgs = ((InternalEObject)body).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTiCGModelPackage.CG_MAPPING_EXP__BODY, null, msgs);
			if (newBody != null)
				msgs = ((InternalEObject)newBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTiCGModelPackage.CG_MAPPING_EXP__BODY, null, msgs);
			msgs = basicSetBody(newBody, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTiCGModelPackage.CG_MAPPING_EXP__BODY, newBody, newBody));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<CGFinalVariable> getVariableAssignments() {
		if (variableAssignments == null) {
			variableAssignments = new EObjectContainmentEList<CGFinalVariable>(CGFinalVariable.class, this, QVTiCGModelPackage.CG_MAPPING_EXP__VARIABLE_ASSIGNMENTS);
		}
		return variableAssignments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<CGConnectionAssignment> getConnectionAssignments() {
		if (connectionAssignments == null) {
			connectionAssignments = new EObjectContainmentWithInverseEList<CGConnectionAssignment>(CGConnectionAssignment.class, this, QVTiCGModelPackage.CG_MAPPING_EXP__CONNECTION_ASSIGNMENTS, QVTiCGModelPackage.CG_CONNECTION_ASSIGNMENT__MAPPING_EXP);
		}
		return connectionAssignments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<CGAccumulator> getOwnedAccumulators() {
		if (ownedAccumulators == null) {
			ownedAccumulators = new EObjectContainmentEList<CGAccumulator>(CGAccumulator.class, this, QVTiCGModelPackage.CG_MAPPING_EXP__OWNED_ACCUMULATORS);
		}
		return ownedAccumulators;
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
			case QVTiCGModelPackage.CG_MAPPING_EXP__ASSIGNMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAssignments()).basicAdd(otherEnd, msgs);
			case QVTiCGModelPackage.CG_MAPPING_EXP__PREDICATES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getPredicates()).basicAdd(otherEnd, msgs);
			case QVTiCGModelPackage.CG_MAPPING_EXP__CONNECTION_ASSIGNMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getConnectionAssignments()).basicAdd(otherEnd, msgs);
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
			case QVTiCGModelPackage.CG_MAPPING_EXP__ASSIGNMENTS:
				return ((InternalEList<?>)getAssignments()).basicRemove(otherEnd, msgs);
			case QVTiCGModelPackage.CG_MAPPING_EXP__PREDICATES:
				return ((InternalEList<?>)getPredicates()).basicRemove(otherEnd, msgs);
			case QVTiCGModelPackage.CG_MAPPING_EXP__REALIZED_VARIABLES:
				return ((InternalEList<?>)getRealizedVariables()).basicRemove(otherEnd, msgs);
			case QVTiCGModelPackage.CG_MAPPING_EXP__BODY:
				return basicSetBody(null, msgs);
			case QVTiCGModelPackage.CG_MAPPING_EXP__VARIABLE_ASSIGNMENTS:
				return ((InternalEList<?>)getVariableAssignments()).basicRemove(otherEnd, msgs);
			case QVTiCGModelPackage.CG_MAPPING_EXP__CONNECTION_ASSIGNMENTS:
				return ((InternalEList<?>)getConnectionAssignments()).basicRemove(otherEnd, msgs);
			case QVTiCGModelPackage.CG_MAPPING_EXP__OWNED_ACCUMULATORS:
				return ((InternalEList<?>)getOwnedAccumulators()).basicRemove(otherEnd, msgs);
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
			case QVTiCGModelPackage.CG_MAPPING_EXP__ASSIGNMENTS:
				return getAssignments();
			case QVTiCGModelPackage.CG_MAPPING_EXP__MAPPING:
				return getMapping();
			case QVTiCGModelPackage.CG_MAPPING_EXP__PREDICATES:
				return getPredicates();
			case QVTiCGModelPackage.CG_MAPPING_EXP__REALIZED_VARIABLES:
				return getRealizedVariables();
			case QVTiCGModelPackage.CG_MAPPING_EXP__BODY:
				return getBody();
			case QVTiCGModelPackage.CG_MAPPING_EXP__VARIABLE_ASSIGNMENTS:
				return getVariableAssignments();
			case QVTiCGModelPackage.CG_MAPPING_EXP__CONNECTION_ASSIGNMENTS:
				return getConnectionAssignments();
			case QVTiCGModelPackage.CG_MAPPING_EXP__OWNED_ACCUMULATORS:
				return getOwnedAccumulators();
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
			case QVTiCGModelPackage.CG_MAPPING_EXP__ASSIGNMENTS:
				getAssignments().clear();
				getAssignments().addAll((Collection<? extends CGPropertyAssignment>)newValue);
				return;
			case QVTiCGModelPackage.CG_MAPPING_EXP__MAPPING:
				setMapping((CGMapping)newValue);
				return;
			case QVTiCGModelPackage.CG_MAPPING_EXP__PREDICATES:
				getPredicates().clear();
				getPredicates().addAll((Collection<? extends CGPredicate>)newValue);
				return;
			case QVTiCGModelPackage.CG_MAPPING_EXP__REALIZED_VARIABLES:
				getRealizedVariables().clear();
				getRealizedVariables().addAll((Collection<? extends CGValuedElement>)newValue);
				return;
			case QVTiCGModelPackage.CG_MAPPING_EXP__BODY:
				setBody((CGValuedElement)newValue);
				return;
			case QVTiCGModelPackage.CG_MAPPING_EXP__VARIABLE_ASSIGNMENTS:
				getVariableAssignments().clear();
				getVariableAssignments().addAll((Collection<? extends CGFinalVariable>)newValue);
				return;
			case QVTiCGModelPackage.CG_MAPPING_EXP__CONNECTION_ASSIGNMENTS:
				getConnectionAssignments().clear();
				getConnectionAssignments().addAll((Collection<? extends CGConnectionAssignment>)newValue);
				return;
			case QVTiCGModelPackage.CG_MAPPING_EXP__OWNED_ACCUMULATORS:
				getOwnedAccumulators().clear();
				getOwnedAccumulators().addAll((Collection<? extends CGAccumulator>)newValue);
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
			case QVTiCGModelPackage.CG_MAPPING_EXP__ASSIGNMENTS:
				getAssignments().clear();
				return;
			case QVTiCGModelPackage.CG_MAPPING_EXP__MAPPING:
				setMapping((CGMapping)null);
				return;
			case QVTiCGModelPackage.CG_MAPPING_EXP__PREDICATES:
				getPredicates().clear();
				return;
			case QVTiCGModelPackage.CG_MAPPING_EXP__REALIZED_VARIABLES:
				getRealizedVariables().clear();
				return;
			case QVTiCGModelPackage.CG_MAPPING_EXP__BODY:
				setBody((CGValuedElement)null);
				return;
			case QVTiCGModelPackage.CG_MAPPING_EXP__VARIABLE_ASSIGNMENTS:
				getVariableAssignments().clear();
				return;
			case QVTiCGModelPackage.CG_MAPPING_EXP__CONNECTION_ASSIGNMENTS:
				getConnectionAssignments().clear();
				return;
			case QVTiCGModelPackage.CG_MAPPING_EXP__OWNED_ACCUMULATORS:
				getOwnedAccumulators().clear();
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
			case QVTiCGModelPackage.CG_MAPPING_EXP__ASSIGNMENTS:
				return assignments != null && !assignments.isEmpty();
			case QVTiCGModelPackage.CG_MAPPING_EXP__MAPPING:
				return getMapping() != null;
			case QVTiCGModelPackage.CG_MAPPING_EXP__PREDICATES:
				return predicates != null && !predicates.isEmpty();
			case QVTiCGModelPackage.CG_MAPPING_EXP__REALIZED_VARIABLES:
				return realizedVariables != null && !realizedVariables.isEmpty();
			case QVTiCGModelPackage.CG_MAPPING_EXP__BODY:
				return body != null;
			case QVTiCGModelPackage.CG_MAPPING_EXP__VARIABLE_ASSIGNMENTS:
				return variableAssignments != null && !variableAssignments.isEmpty();
			case QVTiCGModelPackage.CG_MAPPING_EXP__CONNECTION_ASSIGNMENTS:
				return connectionAssignments != null && !connectionAssignments.isEmpty();
			case QVTiCGModelPackage.CG_MAPPING_EXP__OWNED_ACCUMULATORS:
				return ownedAccumulators != null && !ownedAccumulators.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull CGModelVisitor<R> visitor) {
		return (R) ((QVTiCGModelVisitor<?>)visitor).visitCGMappingExp(this);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public @Nullable TypeId getASTypeId() {
		return TypeId.BOOLEAN;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public @Nullable EClassifier getEcoreClassifier() {
		return null;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public @Nullable AbstractPlace getPlace(@NonNull Map<CGElement,AbstractPlace> element2place) {
		return MappingExpPlaces.createMappingExpPlaces(element2place, this);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public boolean isBoxed() {
		return true;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public boolean isEcore() {
		return true;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public @Nullable Boolean isEquivalentToInternal(@NonNull CGValuedElement thatValue) {
		return (getClass() == thatValue.getClass()) ? QVTiEquivalenceUtil.isEquivalent(this, (CGMappingExp)thatValue) : null;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public boolean isUnboxed() {
		return true;
	}
} //CGMappingExpImpl
