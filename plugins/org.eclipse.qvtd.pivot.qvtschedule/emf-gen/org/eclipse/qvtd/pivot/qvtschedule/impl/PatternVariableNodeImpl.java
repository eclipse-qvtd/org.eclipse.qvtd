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
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.PatternVariableNode;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.util.QVTscheduleVisitor;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

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

	public static @NonNull VariableNodeImpl create(@NonNull Role nodeRole, @NonNull Region region, @NonNull String name, @NonNull ClassDatum classDatum, @NonNull VariableDeclaration variable, boolean isMatched) {
		PatternVariableNodeImpl node = new PatternVariableNodeImpl();
		node.initialize(nodeRole, region, name, classDatum, variable);
		node.isMatched = isMatched;
		return node;
	}


	private boolean isMatched;

	@Override
	public @NonNull VariableNodeImpl createNode(@NonNull Role nodeRole, @NonNull Region region) {
		return create(nodeRole, region, QVTscheduleUtil.getName(this), QVTscheduleUtil.getClassDatum(this), getVariable(), isMatched);
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
