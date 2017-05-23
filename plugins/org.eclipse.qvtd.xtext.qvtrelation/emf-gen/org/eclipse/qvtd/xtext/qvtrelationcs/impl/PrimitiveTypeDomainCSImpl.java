/*******************************************************************************
 * Copyright (c) 2012, 2017 Willink Transformations and others.
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
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;
import org.eclipse.qvtd.xtext.qvtrelationcs.PrimitiveTypeDomainCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.PrimitiveTypeDomainPatternCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage;
import org.eclipse.qvtd.xtext.qvtrelationcs.util.QVTrelationCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Primitive Type Domain CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.PrimitiveTypeDomainCSImpl#getOwnedPatterns <em>Owned Patterns</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PrimitiveTypeDomainCSImpl extends AbstractDomainCSImpl implements PrimitiveTypeDomainCS {
	/**
	 * The cached value of the '{@link #getOwnedPatterns() <em>Owned Patterns</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedPatterns()
	 * @generated
	 * @ordered
	 */
	protected EList<PrimitiveTypeDomainPatternCS> ownedPatterns;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PrimitiveTypeDomainCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTrelationCSPackage.Literals.PRIMITIVE_TYPE_DOMAIN_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<PrimitiveTypeDomainPatternCS> getOwnedPatterns() {
		if (ownedPatterns == null) {
			ownedPatterns = new EObjectContainmentEList<PrimitiveTypeDomainPatternCS>(PrimitiveTypeDomainPatternCS.class, this, QVTrelationCSPackage.PRIMITIVE_TYPE_DOMAIN_CS__OWNED_PATTERNS);
		}
		return ownedPatterns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTrelationCSPackage.PRIMITIVE_TYPE_DOMAIN_CS__OWNED_PATTERNS:
				return ((InternalEList<?>)getOwnedPatterns()).basicRemove(otherEnd, msgs);
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
			case QVTrelationCSPackage.PRIMITIVE_TYPE_DOMAIN_CS__OWNED_PATTERNS:
				return getOwnedPatterns();
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
			case QVTrelationCSPackage.PRIMITIVE_TYPE_DOMAIN_CS__OWNED_PATTERNS:
				getOwnedPatterns().clear();
				getOwnedPatterns().addAll((Collection<? extends PrimitiveTypeDomainPatternCS>)newValue);
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
			case QVTrelationCSPackage.PRIMITIVE_TYPE_DOMAIN_CS__OWNED_PATTERNS:
				getOwnedPatterns().clear();
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
			case QVTrelationCSPackage.PRIMITIVE_TYPE_DOMAIN_CS__OWNED_PATTERNS:
				return ownedPatterns != null && !ownedPatterns.isEmpty();
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
	public <R> R accept(@NonNull BaseCSVisitor<R> visitor) {
		return (R) ((QVTrelationCSVisitor<?>)visitor).visitPrimitiveTypeDomainCS(this);
	}
} //PrimitiveTypeDomainCSImpl
