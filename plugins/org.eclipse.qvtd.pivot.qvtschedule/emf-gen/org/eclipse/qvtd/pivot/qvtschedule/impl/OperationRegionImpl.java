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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder;
import org.eclipse.qvtd.pivot.qvtschedule.MultiRegion;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.OperationRegion;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.util.QVTscheduleVisitor;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleConstants;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.SymbolNameBuilder;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation Region</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class OperationRegionImpl extends RegionImpl implements OperationRegion {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperationRegionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.OPERATION_REGION;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return (R) ((QVTscheduleVisitor<?>)visitor).visitOperationRegion(this);
	}

	protected Operation operation;
	protected String name;
	private final @NonNull List<@NonNull Node> dependencyNodes = new ArrayList<>();
	private final @NonNull List<@NonNull Node> headNodes = new ArrayList<>();
	private Node resultNode;

	public OperationRegionImpl(@NonNull MultiRegion multiRegion, @NonNull String name, @NonNull Operation operation) {
		super(multiRegion);
		this.operation = operation;
		this.name = name;
	}

	@Override
	public void addDependencyNode(@NonNull Node dependencyNode) {
		dependencyNodes.add(dependencyNode);
	}

	@Override
	public void addHeadNode(@NonNull Node headNode) {
		headNodes.add(headNode);
	}

	@Override
	protected @NonNull SymbolNameBuilder computeSymbolName() {
		SymbolNameBuilder s = new SymbolNameBuilder();
		s.appendString("o_");
		s.appendName(name);
		return s;
	}

	@Override
	public @NonNull List<@NonNull Node> getDependencyNodes() {
		return dependencyNodes;
	}

	@Override
	public @NonNull List<@NonNull Node> getHeadNodes() {
		return headNodes;
	}

	@Override
	public @NonNull String getName() {
		return name;
	}

	public @NonNull Node getResultNode() {
		return resultNode;
	}

	@Override
	public boolean isOperationRegion() {
		return true;
	}

	@Override
	public void toGraph(@NonNull GraphStringBuilder s) {
		s.setColor(QVTscheduleConstants.OPERATION_COLOR);
		s.setPenwidth(QVTscheduleConstants.LINE_WIDTH);
		super.toGraph(s);
	}

	@Override
	public void setResultNode(@NonNull Node node) {
		this.resultNode = node;
	}
} //OperationRegionImpl
