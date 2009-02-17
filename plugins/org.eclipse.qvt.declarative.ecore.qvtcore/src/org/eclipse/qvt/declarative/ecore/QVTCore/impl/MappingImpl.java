/**
 * <copyright>
 * 
 * Copyright (c) 2007, 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: MappingImpl.java,v 1.2 2009/02/17 21:44:24 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTCore.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.ocl.ecore.Variable;

import org.eclipse.qvt.declarative.ecore.QVTBase.Domain;
import org.eclipse.qvt.declarative.ecore.QVTBase.Transformation;
import org.eclipse.qvt.declarative.ecore.QVTBase.impl.RuleImpl;

import org.eclipse.qvt.declarative.ecore.QVTCore.Area;
import org.eclipse.qvt.declarative.ecore.QVTCore.BottomPattern;
import org.eclipse.qvt.declarative.ecore.QVTCore.CoreDomain;
import org.eclipse.qvt.declarative.ecore.QVTCore.GuardPattern;
import org.eclipse.qvt.declarative.ecore.QVTCore.Mapping;
import org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTCore.impl.MappingImpl#getGuardPattern <em>Guard Pattern</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTCore.impl.MappingImpl#getBottomPattern <em>Bottom Pattern</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTCore.impl.MappingImpl#getSpecification <em>Specification</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTCore.impl.MappingImpl#getLocal <em>Local</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTCore.impl.MappingImpl#getContext <em>Context</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTCore.impl.MappingImpl#getRefinement <em>Refinement</em>}</li>
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
	protected EList<Mapping> local;

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
		return QVTCorePackage.Literals.MAPPING;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTCorePackage.MAPPING__GUARD_PATTERN, oldGuardPattern, newGuardPattern);
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
				msgs = ((InternalEObject)guardPattern).eInverseRemove(this, QVTCorePackage.GUARD_PATTERN__AREA, GuardPattern.class, msgs);
			if (newGuardPattern != null)
				msgs = ((InternalEObject)newGuardPattern).eInverseAdd(this, QVTCorePackage.GUARD_PATTERN__AREA, GuardPattern.class, msgs);
			msgs = basicSetGuardPattern(newGuardPattern, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTCorePackage.MAPPING__GUARD_PATTERN, newGuardPattern, newGuardPattern));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTCorePackage.MAPPING__BOTTOM_PATTERN, oldBottomPattern, newBottomPattern);
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
				msgs = ((InternalEObject)bottomPattern).eInverseRemove(this, QVTCorePackage.BOTTOM_PATTERN__AREA, BottomPattern.class, msgs);
			if (newBottomPattern != null)
				msgs = ((InternalEObject)newBottomPattern).eInverseAdd(this, QVTCorePackage.BOTTOM_PATTERN__AREA, BottomPattern.class, msgs);
			msgs = basicSetBottomPattern(newBottomPattern, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTCorePackage.MAPPING__BOTTOM_PATTERN, newBottomPattern, newBottomPattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Mapping> getSpecification() {
		if (specification == null) {
			specification = new EObjectWithInverseResolvingEList.ManyInverse<Mapping>(Mapping.class, this, QVTCorePackage.MAPPING__SPECIFICATION, QVTCorePackage.MAPPING__REFINEMENT);
		}
		return specification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Mapping> getLocal() {
		if (local == null) {
			local = new EObjectContainmentWithInverseEList<Mapping>(Mapping.class, this, QVTCorePackage.MAPPING__LOCAL, QVTCorePackage.MAPPING__CONTEXT);
		}
		return local;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mapping getContext() {
		if (eContainerFeatureID() != QVTCorePackage.MAPPING__CONTEXT) return null;
		return (Mapping)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContext(Mapping newContext, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newContext, QVTCorePackage.MAPPING__CONTEXT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContext(Mapping newContext) {
		if (newContext != eInternalContainer() || (eContainerFeatureID() != QVTCorePackage.MAPPING__CONTEXT && newContext != null)) {
			if (EcoreUtil.isAncestor(this, newContext))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newContext != null)
				msgs = ((InternalEObject)newContext).eInverseAdd(this, QVTCorePackage.MAPPING__LOCAL, Mapping.class, msgs);
			msgs = basicSetContext(newContext, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTCorePackage.MAPPING__CONTEXT, newContext, newContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Mapping> getRefinement() {
		if (refinement == null) {
			refinement = new EObjectWithInverseResolvingEList.ManyInverse<Mapping>(Mapping.class, this, QVTCorePackage.MAPPING__REFINEMENT, QVTCorePackage.MAPPING__SPECIFICATION);
		}
		return refinement;
	}

	/**
	 * @generated NOT
	 */
	public EList<Mapping> getAllMappings() {
		EList<Mapping> mappings = new UniqueEList<Mapping>();
		addAllMappings(mappings);
		return mappings;
	}

	/**
	 * @generated NOT
	 */
	public EList<Variable> getAllVariables() {
		EList<Variable> variables = getGuardPattern().getAllVariables();
		variables.addAll(getBottomPattern().getVariable());
		variables.addAll(getBottomPattern().getRealizedVariable());
		for (Domain domain : getDomain()) {
			variables.addAll(((CoreDomain)domain).getAllVariables());
		}
		return variables;
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
			case QVTCorePackage.MAPPING__GUARD_PATTERN:
				if (guardPattern != null)
					msgs = ((InternalEObject)guardPattern).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTCorePackage.MAPPING__GUARD_PATTERN, null, msgs);
				return basicSetGuardPattern((GuardPattern)otherEnd, msgs);
			case QVTCorePackage.MAPPING__BOTTOM_PATTERN:
				if (bottomPattern != null)
					msgs = ((InternalEObject)bottomPattern).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTCorePackage.MAPPING__BOTTOM_PATTERN, null, msgs);
				return basicSetBottomPattern((BottomPattern)otherEnd, msgs);
			case QVTCorePackage.MAPPING__SPECIFICATION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSpecification()).basicAdd(otherEnd, msgs);
			case QVTCorePackage.MAPPING__LOCAL:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getLocal()).basicAdd(otherEnd, msgs);
			case QVTCorePackage.MAPPING__CONTEXT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetContext((Mapping)otherEnd, msgs);
			case QVTCorePackage.MAPPING__REFINEMENT:
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
			case QVTCorePackage.MAPPING__GUARD_PATTERN:
				return basicSetGuardPattern(null, msgs);
			case QVTCorePackage.MAPPING__BOTTOM_PATTERN:
				return basicSetBottomPattern(null, msgs);
			case QVTCorePackage.MAPPING__SPECIFICATION:
				return ((InternalEList<?>)getSpecification()).basicRemove(otherEnd, msgs);
			case QVTCorePackage.MAPPING__LOCAL:
				return ((InternalEList<?>)getLocal()).basicRemove(otherEnd, msgs);
			case QVTCorePackage.MAPPING__CONTEXT:
				return basicSetContext(null, msgs);
			case QVTCorePackage.MAPPING__REFINEMENT:
				return ((InternalEList<?>)getRefinement()).basicRemove(otherEnd, msgs);
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
			case QVTCorePackage.MAPPING__CONTEXT:
				return eInternalContainer().eInverseRemove(this, QVTCorePackage.MAPPING__LOCAL, Mapping.class, msgs);
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
			case QVTCorePackage.MAPPING__GUARD_PATTERN:
				return getGuardPattern();
			case QVTCorePackage.MAPPING__BOTTOM_PATTERN:
				return getBottomPattern();
			case QVTCorePackage.MAPPING__SPECIFICATION:
				return getSpecification();
			case QVTCorePackage.MAPPING__LOCAL:
				return getLocal();
			case QVTCorePackage.MAPPING__CONTEXT:
				return getContext();
			case QVTCorePackage.MAPPING__REFINEMENT:
				return getRefinement();
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
			case QVTCorePackage.MAPPING__GUARD_PATTERN:
				setGuardPattern((GuardPattern)newValue);
				return;
			case QVTCorePackage.MAPPING__BOTTOM_PATTERN:
				setBottomPattern((BottomPattern)newValue);
				return;
			case QVTCorePackage.MAPPING__SPECIFICATION:
				getSpecification().clear();
				getSpecification().addAll((Collection<? extends Mapping>)newValue);
				return;
			case QVTCorePackage.MAPPING__LOCAL:
				getLocal().clear();
				getLocal().addAll((Collection<? extends Mapping>)newValue);
				return;
			case QVTCorePackage.MAPPING__CONTEXT:
				setContext((Mapping)newValue);
				return;
			case QVTCorePackage.MAPPING__REFINEMENT:
				getRefinement().clear();
				getRefinement().addAll((Collection<? extends Mapping>)newValue);
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
			case QVTCorePackage.MAPPING__GUARD_PATTERN:
				setGuardPattern((GuardPattern)null);
				return;
			case QVTCorePackage.MAPPING__BOTTOM_PATTERN:
				setBottomPattern((BottomPattern)null);
				return;
			case QVTCorePackage.MAPPING__SPECIFICATION:
				getSpecification().clear();
				return;
			case QVTCorePackage.MAPPING__LOCAL:
				getLocal().clear();
				return;
			case QVTCorePackage.MAPPING__CONTEXT:
				setContext((Mapping)null);
				return;
			case QVTCorePackage.MAPPING__REFINEMENT:
				getRefinement().clear();
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
			case QVTCorePackage.MAPPING__GUARD_PATTERN:
				return guardPattern != null;
			case QVTCorePackage.MAPPING__BOTTOM_PATTERN:
				return bottomPattern != null;
			case QVTCorePackage.MAPPING__SPECIFICATION:
				return specification != null && !specification.isEmpty();
			case QVTCorePackage.MAPPING__LOCAL:
				return local != null && !local.isEmpty();
			case QVTCorePackage.MAPPING__CONTEXT:
				return getContext() != null;
			case QVTCorePackage.MAPPING__REFINEMENT:
				return refinement != null && !refinement.isEmpty();
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
				case QVTCorePackage.MAPPING__GUARD_PATTERN: return QVTCorePackage.AREA__GUARD_PATTERN;
				case QVTCorePackage.MAPPING__BOTTOM_PATTERN: return QVTCorePackage.AREA__BOTTOM_PATTERN;
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
				case QVTCorePackage.AREA__GUARD_PATTERN: return QVTCorePackage.MAPPING__GUARD_PATTERN;
				case QVTCorePackage.AREA__BOTTOM_PATTERN: return QVTCorePackage.MAPPING__BOTTOM_PATTERN;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * @generated NOT
	 */
	private void addAllMappings(EList<Mapping> mappings) {
		if (!mappings.add(this))
			return;
		for (Mapping mapping : getLocal())
			if (mapping instanceof MappingImpl)
				((MappingImpl) mapping).addAllMappings(mappings);
		for (Mapping mapping : getSpecification())
			if (mapping instanceof MappingImpl)
				((MappingImpl) mapping).addAllMappings(mappings);
	}

	/**
	 * @generated NOT
	 */
	@Override
	public Transformation getTransformation() {
		Mapping context = getContext();
		if (context != null)
			return context.getTransformation();
		else
			return super.getTransformation();
	}

} //MappingImpl
