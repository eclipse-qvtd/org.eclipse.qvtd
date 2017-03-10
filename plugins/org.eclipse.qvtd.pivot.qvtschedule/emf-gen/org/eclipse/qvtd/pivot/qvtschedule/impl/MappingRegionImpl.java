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
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping Region</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class MappingRegionImpl extends RegionImpl implements MappingRegion {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingRegionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.MAPPING_REGION;
	}

	/**
	 * The subsets of guardVariables from which all guardVariables are to-one navigable.
	 */
	private /*@LazyNonNull*/ @Nullable List<@NonNull Node> headNodes = null;

	/*	@Override
	public void addEdge(@NonNull Edge edge) {
		assert stronglyMatchedNodes == null;
		assert unconditionalNodes == null;
		assert conditionalNodes == null;
		assert (basicGetSymbolName() == null) || !edge.isNavigation();
		super.addEdge(edge);
	} */

	/*	protected void addHeadNode(@NonNull Node headNode) {
		assert basicGetSymbolName() == null;
		if (headNodes != null) { assert !headNodes.contains(headNode); }
		getHeadNodes().add(headNode);
	} */

	/*	@Override
	public void addNode(@NonNull Node node) {
		assert stronglyMatchedNodes == null;
		assert unconditionalNodes == null;
		assert conditionalNodes == null;
		assert basicGetSymbolName() == null;
		super.addNode(node);
	} */

	@Override
	public @NonNull String getColor() {
		return "green";
	}

	@Override
	public final @NonNull List<Node> getHeadNodes() {
		List<@NonNull Node> headNodes2 = headNodes;
		assert headNodes2 != null;
		//			headNodes = headNodes2 = new ArrayList<>(); //computeHeadNodes();
		//		}
		return headNodes2;
	}

	public final @NonNull List<Node> getHeadNodes2() {
		List<@NonNull Node> headNodes2 = headNodes;
		assert headNodes2 == null;
		headNodes = headNodes2 = new ArrayList<>();
		return headNodes2;
	}

	@Override
	public void resetHead(@NonNull Node headNode) {
		boolean wasRemoved = getHeadNodes().remove(headNode);
		assert wasRemoved;
		headNode.resetHead();
	}
} //MappingRegionImpl
