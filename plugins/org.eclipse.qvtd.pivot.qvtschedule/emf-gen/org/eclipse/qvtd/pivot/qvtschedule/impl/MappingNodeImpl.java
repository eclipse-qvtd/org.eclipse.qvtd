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
package org.eclipse.qvtd.pivot.qvtschedule.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
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
 *
 * @generated
 */
public abstract class MappingNodeImpl extends NodeImpl implements MappingNode {
	/**
	 * The number of structural features of the '<em>Mapping Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MAPPING_NODE_FEATURE_COUNT = NodeImpl.NODE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Mapping Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MAPPING_NODE_OPERATION_COUNT = NodeImpl.NODE_OPERATION_COUNT + 0;

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

	private final @NonNull List<@NonNull Element> originatingElements = new ArrayList<>();
	private @Nullable VariableDeclaration originatingVariable = null;

	@Override
	public void addOriginatingElement(@NonNull Element originatingElement) {
		assert getOwningRegion() != null; //instanceof MappingRegion;
		assert originatingElements.size() > 0;					// Should have used setOriginatingElement
		assert !(originatingElement instanceof Variable);		// Should have used setOriginatingVariable
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
		MappingNodeImpl node = (MappingNodeImpl)super.createNode(nodeRole, region);
		node.originatingVariable = originatingVariable;
		for (@NonNull Element typedElement : originatingElements) {
			node.originatingElements.add(typedElement);
		}
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
	public void setOriginatingElement(@NonNull Element originatingElement) {
		assert getOwningRegion() != null; //instanceof MappingRegion;
		assert originatingElements.size() == 0;					// Should have used addOriginatingElement
		assert !(originatingElement instanceof Variable);		// Should have used setOriginatingVariable
		originatingElements.add(originatingElement);
	}

	@Override
	public void setOriginatingVariable(@NonNull VariableDeclaration variable) {
		assert getOwningRegion() != null; //instanceof MappingRegion;
		if (originatingVariable != null) {					// Re-initialization after a createNode
			assert originatingVariable == variable;
			assert originatingElements.size() == 1;
			assert originatingElements.contains(variable);
		}
		else if (originatingElements.size() == 0) {			// Normal initialization of variable
			originatingVariable = variable;
			originatingElements.add(variable);
		}
		else {												// Binding of a variable to its initializer
			assert !originatingElements.contains(variable);
			// need non-null run-time check			assert isRequired == variable.isIsRequired();
			originatingVariable = variable;
			originatingElements.add(variable);
		}
	}

	@Override
	public @NonNull String toString() {
		return super.toString();
	}
} //MappingNodeImpl
