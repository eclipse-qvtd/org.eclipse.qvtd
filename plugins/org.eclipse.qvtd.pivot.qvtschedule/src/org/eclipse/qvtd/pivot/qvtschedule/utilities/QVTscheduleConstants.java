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
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.EdgeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.NodeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.Region;

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
	public static final @NonNull String RETURN_NAME = "«return»";

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
}