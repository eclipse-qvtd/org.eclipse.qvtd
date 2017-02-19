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
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatumAnalysis;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.NodeRole;
import org.eclipse.qvtd.pivot.qvtschedule.OperationNode;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.util.QVTscheduleVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class OperationNodeImpl extends NodeImpl implements OperationNode {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperationNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.OPERATION_NODE;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return (R) ((QVTscheduleVisitor<?>)visitor).visitOperationNode(this);
	}

	public static @NonNull OperationNodeImpl create(@NonNull NodeRole nodeRole, @NonNull Region region, @NonNull String name, @NonNull ClassDatumAnalysis classDatumAnalysis, boolean isMatched) {
		OperationNodeImpl node = new OperationNodeImpl();
		node.initialize(nodeRole, region, name, classDatumAnalysis);
		node.isMatched = isMatched;
		return node;
	}

	private boolean isMatched;

	@Override
	public @NonNull Node createNode(@NonNull NodeRole nodeRole, @NonNull Region region) {
		return create(nodeRole, region, getName(), getClassDatumAnalysis(), isMatched);
	}

	@Override
	public @NonNull String getShape() {
		return "ellipse";
	}

	@Override
	public boolean isExpression() {
		return true;
	}

	@Override
	public boolean isMatched() {
		return isMatched;
	}

	@Override
	public boolean isOperation() {
		return true;
	}
} //OperationNodeImpl
