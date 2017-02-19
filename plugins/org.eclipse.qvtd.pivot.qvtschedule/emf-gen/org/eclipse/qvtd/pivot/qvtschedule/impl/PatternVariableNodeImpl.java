/**
 * <copyright>
 *
 * Copyright (c) 2013, 2017 Willink Transformations and others.
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

import org.eclipse.emf.ecore.EClass;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtschedule.NodeRole;
import org.eclipse.qvtd.pivot.qvtschedule.PatternVariableNode;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.util.QVTscheduleVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pattern Variable Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class PatternVariableNodeImpl extends VariableNodeImpl implements PatternVariableNode {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PatternVariableNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.PATTERN_VARIABLE_NODE;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return (R) ((QVTscheduleVisitor<?>)visitor).visitPatternVariableNode(this);
	}

	/*	public static @NonNull PatternNodeImpl create(@NonNull NodeRole nodeRole, @NonNull Region region, @NonNull String name, @NonNull ClassDatumAnalysis classDatumAnalysis, boolean isMatched) {
	PatternNodeImpl node = new PatternNodeImpl();
	node.initialize(nodeRole, region, name, classDatumAnalysis);
	node.isMatched = isMatched;
	return node;
} */

	public static @NonNull VariableNodeImpl create(@NonNull NodeRole nodeRole, @NonNull Region region, @NonNull VariableDeclaration variable, boolean isMatched) {
		PatternVariableNodeImpl node = new PatternVariableNodeImpl();
		node.initialize(nodeRole, region, variable);
		node.isMatched = isMatched;
		return node;
	}


	private boolean isMatched;

	@Override
	public @NonNull VariableNodeImpl createNode(@NonNull NodeRole nodeRole, @NonNull Region region) {
		return create(nodeRole, region, getVariable(), isMatched);
	}

	@Override
	public boolean isMatched() {
		return isMatched;
	}

	@Override
	public boolean isPattern() {
		return true;
	}
} //PatternVariableNodeImpl
