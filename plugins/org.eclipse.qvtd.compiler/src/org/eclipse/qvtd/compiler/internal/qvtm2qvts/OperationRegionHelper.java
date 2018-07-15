/*******************************************************************************
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtm2qvts;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.OperationRegion;
import org.eclipse.qvtd.pivot.qvtschedule.PatternTypedNode;
import org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleFactory;
import org.eclipse.qvtd.pivot.qvtschedule.Role;

public class OperationRegionHelper extends RegionHelper<@NonNull OperationRegion>
{
	public OperationRegionHelper(@NonNull ScheduleManager scheduleManager, @NonNull OperationRegion region) {
		super(scheduleManager, region);
	}

	public @NonNull Node createOperationElementNode(@NonNull String name, @NonNull ClassDatum classDatum, @NonNull Node sourceNode) {
		Role nodeRole = getNodeRole(sourceNode);
		PatternTypedNode node = QVTscheduleFactory.eINSTANCE.createPatternTypedNode();
		node.initialize(nodeRole, region, name, classDatum);
		node.setMatched(true);
		return node;
	}

	public @NonNull Node createOperationParameterNode(@NonNull String name, @NonNull ClassDatum classDatum) {
		Role nodeRole = Role.PREDICATED;
		PatternTypedNode node = QVTscheduleFactory.eINSTANCE.createPatternTypedNode();
		node.initialize(nodeRole, region, name, classDatum);
		node.setMatched(true);
		node.setHead();
		return node;
	}

	public @NonNull Node createOperationResultNode(@NonNull String name, @NonNull ClassDatum classDatum, @NonNull Node sourceNode) {
		Role nodeRole = getNodeRole(sourceNode);
		PatternTypedNode node = QVTscheduleFactory.eINSTANCE.createPatternTypedNode();
		node.initialize(nodeRole, region, name, classDatum);
		node.setMatched(false);
		return node;
	}
}