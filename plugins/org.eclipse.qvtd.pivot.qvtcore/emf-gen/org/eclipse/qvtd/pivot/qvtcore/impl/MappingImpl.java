/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
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
package org.eclipse.qvtd.pivot.qvtcore.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;

import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.util.Visitor;

import org.eclipse.qvtd.pivot.qvtbase.impl.RuleImpl;

import org.eclipse.qvtd.pivot.qvtcore.Area;
import org.eclipse.qvtd.pivot.qvtcore.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcore.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.MappingCall;
import org.eclipse.qvtd.pivot.qvtcore.NestedMapping;
import org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage;
import org.eclipse.qvtd.pivot.qvtcore.util.QVTcoreVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtcore.impl.MappingImpl#getGuardPattern <em>Guard Pattern</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtcore.impl.MappingImpl#getBottomPattern <em>Bottom Pattern</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtcore.impl.MappingImpl#getContext <em>Context</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtcore.impl.MappingImpl#getSpecification <em>Specification</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtcore.impl.MappingImpl#getLocal <em>Local</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtcore.impl.MappingImpl#getRefinement <em>Refinement</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtcore.impl.MappingImpl#getNestedCall <em>Nested Call</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MappingImpl extends RuleImpl implements Mapping {
	/**
	 * The cached value of the '{@link #getGuardPattern() <em>Guard Pattern</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGuardPattern()
	 * @generated
	 * @ordered
	 */
	protected GuardPattern guardPattern;

	/**
	 * The cached value of the '{@link #getBottomPattern() <em>Bottom Pattern</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBottomPattern()
	 * @generated
	 * @ordered
	 */
	protected BottomPattern bottomPattern;

	/**
	 * The cached value of the '{@link #getSpecification() <em>Specification</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecification()
	 * @generated
	 * @ordered
	 */
	protected EList<Mapping> specification;

	/**
	 * The cached value of the '{@link #getLocal() <em>Local</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocal()
	 * @generated
	 * @ordered
	 */
	protected EList<NestedMapping> local;

	/**
	 * The cached value of the '{@link #getRefinement() <em>Refinement</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefinement()
	 * @generated
	 * @ordered
	 */
	protected EList<Mapping> refinement;

	/**
	 * The cached value of the '{@link #getNestedCall() <em>Nested Call</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNestedCall()
	 * @generated
	 * @ordered
	 */
	protected EList<MappingCall> nestedCall;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTcorePackage.Literals.MAPPING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GuardPattern getGuardPattern() {
		return guardPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGuardPattern(GuardPattern newGuardPattern, NotificationChain msgs) {
		GuardPattern oldGuardPattern = guardPattern;
		guardPattern = newGuardPattern;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTcorePackage.MAPPING__GUARD_PATTERN, oldGuardPattern, newGuardPattern);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGuardPattern(GuardPattern newGuardPattern) {
		if (newGuardPattern != guardPattern) {
			NotificationChain msgs = null;
			if (guardPattern != null)
				msgs = ((InternalEObject)guardPattern).eInverseRemove(this, QVTcorePackage.GUARD_PATTERN__AREA, GuardPattern.class, msgs);
			if (newGuardPattern != null)
				msgs = ((InternalEObject)newGuardPattern).eInverseAdd(this, QVTcorePackage.GUARD_PATTERN__AREA, GuardPattern.class, msgs);
			msgs = basicSetGuardPattern(newGuardPattern, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTcorePackage.MAPPING__GUARD_PATTERN, newGuardPattern, newGuardPattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BottomPattern getBottomPattern() {
		return bottomPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBottomPattern(BottomPattern newBottomPattern, NotificationChain msgs) {
		BottomPattern oldBottomPattern = bottomPattern;
		bottomPattern = newBottomPattern;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTcorePackage.MAPPING__BOTTOM_PATTERN, oldBottomPattern, newBottomPattern);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBottomPattern(BottomPattern newBottomPattern) {
		if (newBottomPattern != bottomPattern) {
			NotificationChain msgs = null;
			if (bottomPattern != null)
				msgs = ((InternalEObject)bottomPattern).eInverseRemove(this, QVTcorePackage.BOTTOM_PATTERN__AREA, BottomPattern.class, msgs);
			if (newBottomPattern != null)
				msgs = ((InternalEObject)newBottomPattern).eInverseAdd(this, QVTcorePackage.BOTTOM_PATTERN__AREA, BottomPattern.class, msgs);
			msgs = basicSetBottomPattern(newBottomPattern, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTcorePackage.MAPPING__BOTTOM_PATTERN, newBottomPattern, newBottomPattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Mapping> getSpecification() {
		if (specification == null) {
			specification = new EObjectWithInverseResolvingEList.ManyInverse<Mapping>(Mapping.class, this, QVTcorePackage.MAPPING__SPECIFICATION, QVTcorePackage.MAPPING__REFINEMENT);
		}
		return specification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NestedMapping> getLocal() {
		if (local == null) {
			local = new EObjectContainmentWithInverseEList<NestedMapping>(NestedMapping.class, this, QVTcorePackage.MAPPING__LOCAL, QVTcorePackage.NESTED_MAPPING__CONTEXT);
		}
		return local;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mapping getContext() {
		if (eContainerFeatureID() != QVTcorePackage.MAPPING__CONTEXT) return null;
		return (Mapping)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContext(Mapping newContext, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newContext, QVTcorePackage.MAPPING__CONTEXT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContext(Mapping newContext) {
		if (newContext != eInternalContainer() || (eContainerFeatureID() != QVTcorePackage.MAPPING__CONTEXT && newContext != null)) {
			if (EcoreUtil.isAncestor(this, newContext))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newContext != null)
				msgs = ((InternalEObject)newContext).eInverseAdd(this, QVTcorePackage.MAPPING__LOCAL, Mapping.class, msgs);
			msgs = basicSetContext(newContext, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTcorePackage.MAPPING__CONTEXT, newContext, newContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Mapping> getRefinement() {
		if (refinement == null) {
			refinement = new EObjectWithInverseResolvingEList.ManyInverse<Mapping>(Mapping.class, this, QVTcorePackage.MAPPING__REFINEMENT, QVTcorePackage.MAPPING__SPECIFICATION);
		}
		return refinement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MappingCall> getNestedCall() {
		if (nestedCall == null) {
			nestedCall = new EObjectContainmentEList<MappingCall>(MappingCall.class, this, QVTcorePackage.MAPPING__NESTED_CALL);
		}
		return nestedCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Mapping> getAllMappings() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Variable> getAllVariables() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
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
			case QVTcorePackage.MAPPING__GUARD_PATTERN:
				if (guardPattern != null)
					msgs = ((InternalEObject)guardPattern).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTcorePackage.MAPPING__GUARD_PATTERN, null, msgs);
				return basicSetGuardPattern((GuardPattern)otherEnd, msgs);
			case QVTcorePackage.MAPPING__BOTTOM_PATTERN:
				if (bottomPattern != null)
					msgs = ((InternalEObject)bottomPattern).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTcorePackage.MAPPING__BOTTOM_PATTERN, null, msgs);
				return basicSetBottomPattern((BottomPattern)otherEnd, msgs);
			case QVTcorePackage.MAPPING__CONTEXT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetContext((Mapping)otherEnd, msgs);
			case QVTcorePackage.MAPPING__SPECIFICATION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSpecification()).basicAdd(otherEnd, msgs);
			case QVTcorePackage.MAPPING__LOCAL:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getLocal()).basicAdd(otherEnd, msgs);
			case QVTcorePackage.MAPPING__REFINEMENT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRefinement()).basicAdd(otherEnd, msgs);
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
			case QVTcorePackage.MAPPING__GUARD_PATTERN:
				return basicSetGuardPattern(null, msgs);
			case QVTcorePackage.MAPPING__BOTTOM_PATTERN:
				return basicSetBottomPattern(null, msgs);
			case QVTcorePackage.MAPPING__CONTEXT:
				return basicSetContext(null, msgs);
			case QVTcorePackage.MAPPING__SPECIFICATION:
				return ((InternalEList<?>)getSpecification()).basicRemove(otherEnd, msgs);
			case QVTcorePackage.MAPPING__LOCAL:
				return ((InternalEList<?>)getLocal()).basicRemove(otherEnd, msgs);
			case QVTcorePackage.MAPPING__REFINEMENT:
				return ((InternalEList<?>)getRefinement()).basicRemove(otherEnd, msgs);
			case QVTcorePackage.MAPPING__NESTED_CALL:
				return ((InternalEList<?>)getNestedCall()).basicRemove(otherEnd, msgs);
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
			case QVTcorePackage.MAPPING__CONTEXT:
				return eInternalContainer().eInverseRemove(this, QVTcorePackage.MAPPING__LOCAL, Mapping.class, msgs);
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
			case QVTcorePackage.MAPPING__GUARD_PATTERN:
				return getGuardPattern();
			case QVTcorePackage.MAPPING__BOTTOM_PATTERN:
				return getBottomPattern();
			case QVTcorePackage.MAPPING__CONTEXT:
				return getContext();
			case QVTcorePackage.MAPPING__SPECIFICATION:
				return getSpecification();
			case QVTcorePackage.MAPPING__LOCAL:
				return getLocal();
			case QVTcorePackage.MAPPING__REFINEMENT:
				return getRefinement();
			case QVTcorePackage.MAPPING__NESTED_CALL:
				return getNestedCall();
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
			case QVTcorePackage.MAPPING__GUARD_PATTERN:
				setGuardPattern((GuardPattern)newValue);
				return;
			case QVTcorePackage.MAPPING__BOTTOM_PATTERN:
				setBottomPattern((BottomPattern)newValue);
				return;
			case QVTcorePackage.MAPPING__CONTEXT:
				setContext((Mapping)newValue);
				return;
			case QVTcorePackage.MAPPING__SPECIFICATION:
				getSpecification().clear();
				getSpecification().addAll((Collection<? extends Mapping>)newValue);
				return;
			case QVTcorePackage.MAPPING__LOCAL:
				getLocal().clear();
				getLocal().addAll((Collection<? extends NestedMapping>)newValue);
				return;
			case QVTcorePackage.MAPPING__REFINEMENT:
				getRefinement().clear();
				getRefinement().addAll((Collection<? extends Mapping>)newValue);
				return;
			case QVTcorePackage.MAPPING__NESTED_CALL:
				getNestedCall().clear();
				getNestedCall().addAll((Collection<? extends MappingCall>)newValue);
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
			case QVTcorePackage.MAPPING__GUARD_PATTERN:
				setGuardPattern((GuardPattern)null);
				return;
			case QVTcorePackage.MAPPING__BOTTOM_PATTERN:
				setBottomPattern((BottomPattern)null);
				return;
			case QVTcorePackage.MAPPING__CONTEXT:
				setContext((Mapping)null);
				return;
			case QVTcorePackage.MAPPING__SPECIFICATION:
				getSpecification().clear();
				return;
			case QVTcorePackage.MAPPING__LOCAL:
				getLocal().clear();
				return;
			case QVTcorePackage.MAPPING__REFINEMENT:
				getRefinement().clear();
				return;
			case QVTcorePackage.MAPPING__NESTED_CALL:
				getNestedCall().clear();
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
			case QVTcorePackage.MAPPING__GUARD_PATTERN:
				return guardPattern != null;
			case QVTcorePackage.MAPPING__BOTTOM_PATTERN:
				return bottomPattern != null;
			case QVTcorePackage.MAPPING__CONTEXT:
				return getContext() != null;
			case QVTcorePackage.MAPPING__SPECIFICATION:
				return specification != null && !specification.isEmpty();
			case QVTcorePackage.MAPPING__LOCAL:
				return local != null && !local.isEmpty();
			case QVTcorePackage.MAPPING__REFINEMENT:
				return refinement != null && !refinement.isEmpty();
			case QVTcorePackage.MAPPING__NESTED_CALL:
				return nestedCall != null && !nestedCall.isEmpty();
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
		if (baseClass == Area.class) {
			switch (derivedFeatureID) {
				case QVTcorePackage.MAPPING__GUARD_PATTERN: return QVTcorePackage.AREA__GUARD_PATTERN;
				case QVTcorePackage.MAPPING__BOTTOM_PATTERN: return QVTcorePackage.AREA__BOTTOM_PATTERN;
				default: return -1;
			}
		}
		if (baseClass == NestedMapping.class) {
			switch (derivedFeatureID) {
				case QVTcorePackage.MAPPING__CONTEXT: return QVTcorePackage.NESTED_MAPPING__CONTEXT;
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
		if (baseClass == Area.class) {
			switch (baseFeatureID) {
				case QVTcorePackage.AREA__GUARD_PATTERN: return QVTcorePackage.MAPPING__GUARD_PATTERN;
				case QVTcorePackage.AREA__BOTTOM_PATTERN: return QVTcorePackage.MAPPING__BOTTOM_PATTERN;
				default: return -1;
			}
		}
		if (baseClass == NestedMapping.class) {
			switch (baseFeatureID) {
				case QVTcorePackage.NESTED_MAPPING__CONTEXT: return QVTcorePackage.MAPPING__CONTEXT;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return ((QVTcoreVisitor<R>)visitor).visitMapping(this);
	}
} //MappingImpl
