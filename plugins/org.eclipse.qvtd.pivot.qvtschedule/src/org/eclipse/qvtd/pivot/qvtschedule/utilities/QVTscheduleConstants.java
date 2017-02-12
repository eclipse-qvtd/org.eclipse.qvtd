/*******************************************************************************
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtschedule.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.pivot.qvtschedule.EdgeRole;
import org.eclipse.qvtd.pivot.qvtschedule.NodeRole;
import org.eclipse.qvtd.pivot.qvtschedule.Phase;
import org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleFactory;

public class QVTscheduleConstants
{
	public static final @NonNull String BINDING_COLOR = "darkorange";
	public static final @NonNull String CONSTANT_COLOR = "black";
	public static final @NonNull String ERROR_COLOR = "red";
	public static final @NonNull String ITERATION_COLOR = "magenta";
	public static final @NonNull String LIGHT_CONSTANT_COLOR = "lightgray";
	public static final @NonNull String LIGHT_LOADED_COLOR = "lightblue1";
	public static final @NonNull String LIGHT_OTHER_COLOR = "gray";
	public static final @NonNull String LIGHT_PREDICATED_COLOR = "lightcyan1";
	public static final @NonNull String LIGHT_REALIZED_COLOR = "palegreen1";
	public static final @NonNull String LIGHT_SPECULATED_COLOR = "palegoldenrod";
	public static final @NonNull String LIGHT_SPECULATION_COLOR = "pink1";
	public static final @NonNull String LOADED_COLOR = "blue";
	public static final @NonNull String OPERATION_COLOR = "magenta";
	public static final @NonNull String ORDERING_COLOR = "brown";
	public static final @NonNull String OTHER_COLOR = "grey";
	public static final @NonNull String PREDICATED_COLOR = "cyan";
	public static final @NonNull String REALIZED_COLOR = "green3";
	public static final @NonNull String RECURSION_COLOR = "brown";
	public static final @NonNull String SPECULATED_COLOR = "darkorange";
	public static final @NonNull String SPECULATION_COLOR = "red";

	public static final @NonNull Integer HEAD_WIDTH = 8;
	public static final @NonNull Integer LINE_WIDTH = 2;



	private static final @NonNull EdgeRole CONSTANT_EDGE = createEdgeRole(Phase.CONSTANT);
	private static final @NonNull EdgeRole LOADED_EDGE = createEdgeRole(Phase.LOADED);
	private static final @NonNull EdgeRole PREDICATED_EDGE = createEdgeRole(Phase.PREDICATED);
	private static final @NonNull EdgeRole REALIZED_EDGE = createEdgeRole(Phase.REALIZED);
	private static final @NonNull EdgeRole OTHER_EDGE = createEdgeRole(Phase.OTHER);

	private static final @NonNull NodeRole CONSTANT_NODE = createNodeRole(Phase.CONSTANT);
	private static final @NonNull NodeRole LOADED_NODE = createNodeRole(Phase.LOADED);
	private static final @NonNull NodeRole PREDICATED_NODE = createNodeRole(Phase.PREDICATED);
	private static final @NonNull NodeRole REALIZED_NODE = createNodeRole(Phase.REALIZED);
	private static final @NonNull NodeRole SPECULATED_NODE = createNodeRole(Phase.SPECULATED);
	private static final @NonNull NodeRole SPECULATION_NODE = createNodeRole(Phase.SPECULATION);
	private static final @NonNull NodeRole OTHER_NODE = createNodeRole(Phase.OTHER);

	private static @NonNull EdgeRole createEdgeRole(@NonNull Phase phase) {
		EdgeRole edgeRole = QVTscheduleFactory.eINSTANCE.createEdgeRole();
		edgeRole.setPhase(phase);
		return edgeRole;
	}

	private static @NonNull NodeRole createNodeRole(@NonNull Phase phase) {
		NodeRole nodeRole = QVTscheduleFactory.eINSTANCE.createNodeRole();
		nodeRole.setPhase(phase);
		return nodeRole;
	}

	public static @NonNull EdgeRole getEdgeRole(@NonNull Phase phase) {
		switch (phase) {
			case CONSTANT: return CONSTANT_EDGE;
			case LOADED: return LOADED_EDGE;
			case PREDICATED: return PREDICATED_EDGE;
			case REALIZED: return REALIZED_EDGE;
			case OTHER: return OTHER_EDGE;
		}
		throw new UnsupportedOperationException();
	}

	public static @NonNull NodeRole getNodeRole(@NonNull Phase phase) {
		switch (phase) {
			case CONSTANT: return CONSTANT_NODE;
			case LOADED: return LOADED_NODE;
			case PREDICATED: return PREDICATED_NODE;
			case REALIZED: return REALIZED_NODE;
			case SPECULATED: return SPECULATED_NODE;
			case SPECULATION: return SPECULATION_NODE;
			case OTHER: return OTHER_NODE;
		}
		throw new UnsupportedOperationException();
	}
}