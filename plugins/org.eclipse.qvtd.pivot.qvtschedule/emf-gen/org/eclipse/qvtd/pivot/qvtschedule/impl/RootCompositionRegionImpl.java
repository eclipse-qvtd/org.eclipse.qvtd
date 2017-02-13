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

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.MultiRegion;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.RootCompositionRegion;
import org.eclipse.qvtd.pivot.qvtschedule.util.QVTscheduleVisitor;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleConstants;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.SymbolNameBuilder;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Root Composition Region</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class RootCompositionRegionImpl extends RegionImpl implements RootCompositionRegion {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RootCompositionRegionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.ROOT_COMPOSITION_REGION;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return (R) ((QVTscheduleVisitor<?>)visitor).visitRootCompositionRegion(this);
	}

	public RootCompositionRegionImpl(@NonNull MultiRegion multiRegion) {
		super(multiRegion);
	}

	@Override
	protected @NonNull SymbolNameBuilder computeSymbolName() {
		SymbolNameBuilder s = new SymbolNameBuilder();
		s.appendString(QVTscheduleUtil.ROOT_MAPPING_NAME);
		return s;
	}

	@Override
	public void createIncomingConnections() {}

	@Override
	public @NonNull List<@NonNull Node> getHeadNodes() {
		return QVTscheduleConstants.EMPTY_NODE_LIST;
	}

	@Override
	public @NonNull String getName() {
		return QVTscheduleConstants.ROOT_MAPPING_NAME;
	}

	@Override
	protected @NonNull String getSymbolNamePrefix() {
		return "r_";
	}

	@Override
	public boolean isRootCompositionRegion() {
		return true;
	}

	@Override
	public void toGraph(@NonNull GraphStringBuilder s) {
		s.setLabel(getName());
		s.setColor("lightblue");
		s.setPenwidth(QVTscheduleConstants.LINE_WIDTH);
		s.pushCluster();
		for (@NonNull Node node : getNodes()) {
			s.appendNode(node);
		}
		for (@NonNull Edge edge : getEdges()) {
			s.appendEdge(edge.getEdgeSource(), edge, edge.getEdgeTarget());
		}
		s.popCluster();
	}
} //RootCompositionRegionImpl
