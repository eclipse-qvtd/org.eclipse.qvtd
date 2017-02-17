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

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.utilities.TracingOption;
import org.eclipse.qvtd.pivot.qvtschedule.Connection;
import org.eclipse.qvtd.pivot.qvtschedule.ConnectionRole;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.EdgeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.NodeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.impl.ConnectionRoleImpl;

public class QVTscheduleConstants
{
	@SuppressWarnings("null")
	public static final @NonNull String PLUGIN_ID = QVTschedulePackage.class.getPackage().getName();

	public static final @NonNull TracingOption CONNECTION_CREATION = new TracingOption(PLUGIN_ID, "qvtm2qvts/connectionCreation");	// FIXME
	public static final @NonNull TracingOption CONNECTION_ROUTING = new TracingOption(PLUGIN_ID, "qvtm2qvts/connectionRouting");
	public static final @NonNull TracingOption POLLED_PROPERTIES = new TracingOption(PLUGIN_ID, "qvts2qvti/polledProperties");	// FIXME

	/** The name of the root mapping */
	public static final @NonNull String ROOT_MAPPING_NAME = "__root__";
	public static final @NonNull String MIDDLE_DOMAIN_NAME = "middle";

	public static final @NonNull String REGION_SYMBOL_NAME_PREFIX = "m_";
	public static final @NonNull String REGION_SYMBOL_NAME_SUFFIX = "";

	public static final @NonNull String EQUALS_NAME = "«equals»";
	public static final @NonNull String IF_CONDITION_NAME = "«condition»";
	public static final @NonNull String IF_ELSE_NAME = "«else»";
	public static final @NonNull String IF_THEN_NAME = "«then»";
	public static final @NonNull String LOOP_BODY_NAME = "«body»";
	public static final @NonNull String LOOP_ITERATOR_NAME = "«iterator»";

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

	public static final @NonNull List<@NonNull Connection> EMPTY_CONNECTION_LIST = Collections.emptyList();
	public static final @NonNull List<@NonNull EdgeConnection> EMPTY_EDGE_CONNECTION_LIST = Collections.emptyList();
	public static final @NonNull List<@NonNull Edge> EMPTY_EDGE_LIST = Collections.emptyList();
	public static final @NonNull List<@NonNull NavigableEdge> EMPTY_NAVIGATION_EDGE_LIST = Collections.emptyList();
	public static final @NonNull List<@NonNull Node> EMPTY_NODE_LIST = Collections.emptyList();
	public static final @NonNull Set<@NonNull MappingRegion> EMPTY_MAPPING_REGION_SET = Collections.emptySet();
	public static final @NonNull List<@NonNull NodeConnection> EMPTY_NODE_CONNECTION_LIST = Collections.emptyList();
	public static final @NonNull List<@NonNull Region> EMPTY_REGION_LIST = Collections.emptyList();
	public static final @NonNull List<@NonNull TypedElement> EMPTY_TYPED_ELEMENT_LIST = Collections.emptyList();

	//	private static final @NonNull Role CONSTANT_EDGE = createEdgeRole(Phase.CONSTANT);
	//	private static final @NonNull Role LOADED_EDGE = createEdgeRole(Phase.LOADED);
	//	private static final @NonNull Role PREDICATED_EDGE = createEdgeRole(Phase.PREDICATED);
	//	private static final @NonNull Role REALIZED_EDGE = createEdgeRole(Phase.REALIZED);
	//	private static final @NonNull Role OTHER_EDGE = createEdgeRole(Phase.OTHER);

	//	private static final @NonNull Role CONSTANT_NODE = createNodeRole(Phase.CONSTANT);
	//	private static final @NonNull Role LOADED_NODE = createNodeRole(Phase.LOADED);
	//	private static final @NonNull Role PREDICATED_NODE = createNodeRole(Phase.PREDICATED);
	//	private static final @NonNull Role REALIZED_NODE = createNodeRole(Phase.REALIZED);
	//	private static final @NonNull Role SPECULATED_NODE = createNodeRole(Phase.SPECULATED);
	//	private static final @NonNull Role SPECULATION_NODE = createNodeRole(Phase.SPECULATION);
	//	private static final @NonNull Role OTHER_NODE = createNodeRole(Phase.OTHER);

	/**
	 * A MANDATORY connection 'passes' a used input edge that must be fully computed before use. This is typically for a
	 * collection, since it is not possible to determine when a last partial addition is the last, therefore all
	 * additions must occur before any access.
	 */
	public static final @NonNull ConnectionRole MANDATORY_EDGE = new MandatoryConnectionRole(false);

	/**
	 * A MANDATORY_NODE connection 'passes' a used input node that must be fully computed before use. This is typically for a
	 * collection, since it is not possible to determine when a last partial addition is the last, therefore all
	 * additions must occur before any access.
	 */
	public static final @NonNull ConnectionRole MANDATORY_NODE = new MandatoryConnectionRole(true);

	/**
	 * A PASSED connection passes a required input. This is typically from an introducer/producer/join to
	 * a consumer's head. A value must actually be passed by the call.
	 */
	public static final @NonNull ConnectionRole PASSED = new PassedConnectionRole();

	/**
	 * A PREFERRED connection 'passes' a used input edge that is beneficially but not necessarily computed before use.
	 * If not computed before use, run-time overheads are incurred to defer reads until writes have occurred.
	 */
	public static final @NonNull ConnectionRole PREFERRED_EDGE = new PreferredConnectionRole(false);

	/**
	 * A PREFERRED_NODE connection 'passes' a used input node that is beneficially but not necessarily computed before use.
	 * If not computed before use, run-time overheads are incurred to defer reads until writes have occurred.
	 */
	public static final @NonNull ConnectionRole PREFERRED_NODE = new PreferredConnectionRole(true);


	//	private static @NonNull Role createEdgeRole(@NonNull Phase phase) {
	//		Role edgeRole = QVTscheduleFactory.eINSTANCE.createRole();
	//		edgeRole.setPhase(phase);
	//		return edgeRole;
	//	}

	//	private static @NonNull Role createNodeRole(@NonNull Phase phase) {
	//		Role nodeRole = QVTscheduleFactory.eINSTANCE.createRole();
	//		nodeRole.setPhase(phase);
	//		return nodeRole;
	//	}

	/*	public static @NonNull Role getEdgeRole(@NonNull Phase phase) {
		switch (phase) {
			case CONSTANT: return CONSTANT_EDGE;
			case LOADED: return LOADED_EDGE;
			case PREDICATED: return PREDICATED_EDGE;
			case REALIZED: return REALIZED_EDGE;
			case OTHER: return OTHER_EDGE;
		}
		throw new UnsupportedOperationException();
	} */

	/*	public static @NonNull Role getNodeRole(@NonNull Phase phase) {
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
	} */

	private static final class MandatoryConnectionRole extends ConnectionRoleImpl
	{
		public MandatoryConnectionRole(boolean isNode) {
			setNode(isNode);
		}

		@Override
		public @NonNull String getStyle() {
			return "dashed";
		}

		@Override
		public boolean isMandatory() {
			return true;
		}

		@Override
		public boolean isPreferred() {
			return true;
		}

		@Override
		public @NonNull ConnectionRole merge(@NonNull ConnectionRole connectionRole) {
			if (connectionRole.isPassed()) {
				return connectionRole;
			}
			if (connectionRole.isPreferred()) {
				return this;
			}
			return super.merge(connectionRole);
		}

		@Override
		public @NonNull String toString() {
			return "«mandatory»";
		}
	}

	private static final class PassedConnectionRole extends ConnectionRoleImpl
	{
		public PassedConnectionRole() {
			setNode(true);
		}

		@Override
		public boolean isPassed() {
			return true;
		}

		@Override
		public @NonNull ConnectionRole merge(@NonNull ConnectionRole connectionRole) {
			if (connectionRole.isMandatory()) {
				return this;
			}
			if (connectionRole.isPreferred()) {
				return this;
			}
			return super.merge(connectionRole);
		}

		@Override
		public @NonNull String toString() {
			return "«passed»";
		}
	}

	private static final class PreferredConnectionRole extends ConnectionRoleImpl
	{
		public PreferredConnectionRole(boolean isNode) {
			setNode(isNode);
		}

		@Override
		public @NonNull String getStyle() {
			return "dotted";
		}

		@Override
		public boolean isMandatory() {
			return false;
		}

		@Override
		public boolean isPreferred() {
			return true;
		}

		@Override
		public @NonNull ConnectionRole merge(@NonNull ConnectionRole connectionRole) {
			if (connectionRole.isPassed()) {
				return connectionRole;
			}
			if (connectionRole.isMandatory()) {
				return connectionRole;
			}
			return super.merge(connectionRole);
		}

		@Override
		public @NonNull String toString() {
			return "«preferred»";
		}
	}
}