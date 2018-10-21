/**
 * <copyright>
 *
 * Copyright (c) 2013, 2018 Willink Transformations and others.
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

import java.util.List;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.jdt.annotation.NonNull;

import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.NonPartition;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;

import org.eclipse.qvtd.pivot.qvtschedule.util.QVTscheduleVisitor;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Non Partition</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class NonPartitionImpl extends MappingPartitionImpl implements NonPartition {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NonPartitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.NON_PARTITION;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return (R) ((QVTscheduleVisitor<?>)visitor).visitNonPartition(this);
	}

	@Override
	public List<Node> getHeadNodes() {
		return QVTscheduleUtil.Internal.getHeadNodesList(QVTscheduleUtil.getRegion(this));
	}

	@Override
	public @NonNull Iterable<@NonNull Edge> getPartialEdges() {
		return QVTscheduleUtil.getOwnedEdges(QVTscheduleUtil.getRegion(this));
	}

	@Override
	public @NonNull Iterable<@NonNull Node> getPartialNodes() {
		return QVTscheduleUtil.getOwnedNodes(QVTscheduleUtil.getRegion(this));
	}

} //NonPartitionImpl
