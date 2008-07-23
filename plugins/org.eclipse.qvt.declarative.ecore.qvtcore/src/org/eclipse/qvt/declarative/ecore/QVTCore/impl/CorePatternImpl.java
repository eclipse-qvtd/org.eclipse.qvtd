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
 * $Id: CorePatternImpl.java,v 1.1 2008/07/23 09:43:25 qglineur Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTCore.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.ocl.ecore.Variable;

import org.eclipse.qvt.declarative.ecore.QVTBase.Domain;
import org.eclipse.qvt.declarative.ecore.QVTBase.impl.PatternImpl;

import org.eclipse.qvt.declarative.ecore.QVTCore.Area;
import org.eclipse.qvt.declarative.ecore.QVTCore.CoreDomain;
import org.eclipse.qvt.declarative.ecore.QVTCore.CorePattern;
import org.eclipse.qvt.declarative.ecore.QVTCore.GuardPattern;
import org.eclipse.qvt.declarative.ecore.QVTCore.Mapping;
import org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage;
import org.eclipse.qvt.declarative.ecore.utils.EcoreUtils;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Core Pattern</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTCore.impl.CorePatternImpl#getVariable <em>Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CorePatternImpl extends PatternImpl implements CorePattern {
	/**
	 * The cached value of the '{@link #getVariable() <em>Variable</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariable()
	 * @generated
	 * @ordered
	 */
	protected EList<Variable> variable;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CorePatternImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTCorePackage.Literals.CORE_PATTERN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Variable> getVariable() {
		if (variable == null) {
			variable = new EObjectContainmentEList<Variable>(Variable.class, this, QVTCorePackage.CORE_PATTERN__VARIABLE);
		}
		return variable;
	}

	/**
	 * @generated NOT
	 */
	public EList<Variable> getAllVariables() {
		UniqueEList<Variable> allVariables = new UniqueEList<Variable>();
		Area area = getArea();
		if (area instanceof Mapping) {
			Mapping myMapping = (Mapping) area;
			List<Mapping> mappings = myMapping.getAllMappings();
			for (Mapping mapping : mappings) {
				addAllPatternVariables(allVariables, mapping);
				for (Domain domain : mapping.getDomain()) {
					if (domain instanceof CoreDomain) {
						addAllPatternVariables(allVariables, (CoreDomain) domain);
					}
				}			
			}			
		}
		else if (area instanceof CoreDomain) {
			CoreDomain myDomain = (CoreDomain)area;
			Mapping myMapping = (Mapping) myDomain.getRule();
			List<Mapping> mappings = myMapping.getAllMappings();
			for (Mapping mapping : mappings) {
				Domain domain = EcoreUtils.getNamedElement(mapping.getDomain(), myDomain.getName());
				if (domain instanceof CoreDomain) {
					addAllPatternVariables(allVariables, (CoreDomain) domain);
				}
			}			
		}
		return allVariables;
	}

	/**
	 * @generated NOT
	 */
	public Area getArea() {
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTCorePackage.CORE_PATTERN__VARIABLE:
				return ((InternalEList<?>)getVariable()).basicRemove(otherEnd, msgs);
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
			case QVTCorePackage.CORE_PATTERN__VARIABLE:
				return getVariable();
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
			case QVTCorePackage.CORE_PATTERN__VARIABLE:
				getVariable().clear();
				getVariable().addAll((Collection<? extends Variable>)newValue);
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
			case QVTCorePackage.CORE_PATTERN__VARIABLE:
				getVariable().clear();
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
			case QVTCorePackage.CORE_PATTERN__VARIABLE:
				return variable != null && !variable.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * @generated NOT
	 */
	protected void addAllPatternVariables(UniqueEList<Variable> allVariables, Area area) {
		GuardPattern guardPattern = area.getGuardPattern();
		if (guardPattern != null)
			allVariables.addAll(guardPattern.getVariable());
	}

} //CorePatternImpl
