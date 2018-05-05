/**
 * <copyright>
 *
 * Copyright (c) 2013, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.pivot.qvtschedule.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.pivot.qvtschedule.MappingNode;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.Role;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.MappingNodeImpl#isMatched <em>Matched</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class MappingNodeImpl extends NodeImpl implements MappingNode {
	/**
	 * The default value of the '{@link #isMatched() <em>Matched</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMatched()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MATCHED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isMatched() <em>Matched</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMatched()
	 * @generated
	 * @ordered
	 */
	protected boolean matched = MATCHED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.MAPPING_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isMatched() {
		return matched;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMatched(boolean newMatched) {
		boolean oldMatched = matched;
		matched = newMatched;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.MAPPING_NODE__MATCHED, oldMatched, matched));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QVTschedulePackage.MAPPING_NODE__MATCHED:
				return isMatched();
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
			case QVTschedulePackage.MAPPING_NODE__MATCHED:
				setMatched((Boolean)newValue);
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
			case QVTschedulePackage.MAPPING_NODE__MATCHED:
				setMatched(MATCHED_EDEFAULT);
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
			case QVTschedulePackage.MAPPING_NODE__MATCHED:
				return matched != MATCHED_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	private boolean isRequired = true;
	private final @NonNull List<@NonNull Element> originatingElements = new ArrayList<>();
	private @Nullable VariableDeclaration originatingVariable = null;

	@Override
	public void addOriginatingElement(@NonNull Element originatingElement) {
		assert getOwningRegion() != null; //instanceof MappingRegion;
		assert originatingElements.size() > 0;					// Should have used setOriginatingElement
		assert !(originatingElement instanceof Variable);		// Should have used setOriginatingVariable
		assert isRequired == !(originatingElement instanceof TypedElement) || ((TypedElement)originatingElement).isIsRequired();
		if (!originatingElements.contains(originatingElement)) {
			originatingElements.add(originatingElement);
		}
	}

	@Override
	public final @Nullable Element basicGetOriginatingElement() {
		return originatingElements.size() > 0 ? originatingElements.get(0) : null;
	}

	@Override
	public @Nullable VariableDeclaration basicGetOriginatingVariable() {
		return originatingVariable;
	}

	@Override
	public @NonNull Node createNode(@NonNull Role nodeRole, @NonNull Region region) {
		MappingNodeImpl node = (MappingNodeImpl)super.createNode(nodeRole,  region);
		node.isRequired = isRequired;
		node.originatingVariable = originatingVariable;
		for (@NonNull Element typedElement : originatingElements) {
			node.originatingElements.add(typedElement);
		}
		node.setMatched(matched);
		return node;
	}

	@Override
	public final @NonNull Element getOriginatingElement() {
		Element typedElement = basicGetOriginatingElement();
		return ClassUtil.nonNullState(typedElement);
	}

	@Override
	public @NonNull Iterable<@NonNull Element> getOriginatingElements() {
		return originatingElements;
	}

	@Override
	public boolean isRequired() {
		return isRequired;
	}

	@Override
	public void setOriginatingElement(@NonNull Element originatingElement) {
		assert getOwningRegion() != null; //instanceof MappingRegion;
		assert originatingElements.size() == 0;					// Should have used addOriginatingElement
		assert !(originatingElement instanceof Variable);		// Should have used setOriginatingVariable
		originatingElements.add(originatingElement);
		isRequired = !(originatingElement instanceof TypedElement) || ((TypedElement)originatingElement).isIsRequired();
	}

	@Override
	public void setOriginatingVariable(@NonNull VariableDeclaration variable) {
		assert getOwningRegion() != null; //instanceof MappingRegion;
		if (originatingVariable != null) {					// Re-initialization after a createNode
			assert originatingVariable == variable;
			assert originatingElements.size() == 1;
			assert originatingElements.contains(variable);
			assert isRequired == variable.isIsRequired();
		}
		else if (originatingElements.size() == 0) {			// Normal initialization of variable
			originatingVariable = variable;
			originatingElements.add(variable);
			isRequired = variable.isIsRequired();
		}
		else {												// Binding of a variable to its initializer
			assert !originatingElements.contains(variable);
			assert isRequired == variable.isIsRequired();
			originatingVariable = variable;
			originatingElements.add(variable);
		}
	}

	@Override
	public @NonNull String toString() {
		return super.toString();
	}
} //MappingNodeImpl
