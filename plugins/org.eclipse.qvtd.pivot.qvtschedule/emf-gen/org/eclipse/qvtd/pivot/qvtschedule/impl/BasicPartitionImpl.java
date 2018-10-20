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

import java.util.Collection;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.jdt.annotation.NonNull;

import org.eclipse.ocl.pivot.util.Visitor;

import org.eclipse.qvtd.pivot.qvtschedule.BasicPartition;
import org.eclipse.qvtd.pivot.qvtschedule.MappingPartition;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;

import org.eclipse.qvtd.pivot.qvtschedule.util.QVTscheduleVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Basic Partition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.BasicPartitionImpl#getHeadNodes <em>Head Nodes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.BasicPartitionImpl#getExplicitPredecessors <em>Explicit Predecessors</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BasicPartitionImpl extends MappingPartitionImpl implements BasicPartition {
	/**
	 * The cached value of the '{@link #getHeadNodes() <em>Head Nodes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeadNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<Node> headNodes;
	/**
	 * The cached value of the '{@link #getExplicitPredecessors() <em>Explicit Predecessors</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExplicitPredecessors()
	 * @generated
	 * @ordered
	 */
	protected EList<MappingPartition> explicitPredecessors;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BasicPartitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.BASIC_PARTITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<Node> getHeadNodes() {
		if (headNodes == null) {
			headNodes = new EObjectResolvingEList<Node>(Node.class, this, QVTschedulePackage.BASIC_PARTITION__HEAD_NODES);
		}
		return headNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<MappingPartition> getExplicitPredecessors() {
		if (explicitPredecessors == null) {
			explicitPredecessors = new EObjectResolvingEList<MappingPartition>(MappingPartition.class, this, QVTschedulePackage.BASIC_PARTITION__EXPLICIT_PREDECESSORS);
		}
		return explicitPredecessors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QVTschedulePackage.BASIC_PARTITION__HEAD_NODES:
				return getHeadNodes();
			case QVTschedulePackage.BASIC_PARTITION__EXPLICIT_PREDECESSORS:
				return getExplicitPredecessors();
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
			case QVTschedulePackage.BASIC_PARTITION__HEAD_NODES:
				getHeadNodes().clear();
				getHeadNodes().addAll((Collection<? extends Node>)newValue);
				return;
			case QVTschedulePackage.BASIC_PARTITION__EXPLICIT_PREDECESSORS:
				getExplicitPredecessors().clear();
				getExplicitPredecessors().addAll((Collection<? extends MappingPartition>)newValue);
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
			case QVTschedulePackage.BASIC_PARTITION__HEAD_NODES:
				getHeadNodes().clear();
				return;
			case QVTschedulePackage.BASIC_PARTITION__EXPLICIT_PREDECESSORS:
				getExplicitPredecessors().clear();
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
			case QVTschedulePackage.BASIC_PARTITION__HEAD_NODES:
				return headNodes != null && !headNodes.isEmpty();
			case QVTschedulePackage.BASIC_PARTITION__EXPLICIT_PREDECESSORS:
				return explicitPredecessors != null && !explicitPredecessors.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return (R) ((QVTscheduleVisitor<?>)visitor).visitBasicPartition(this);
	}

} //BasicPartitionImpl
