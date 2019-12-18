/*******************************************************************************
 * Copyright (c) 2015, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
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
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
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
	public static final @NonNull String PLUGIN_ID = QVTschedulePackage.class.getPackage().getName();

	public static final @NonNull TracingOption CONNECTION_CREATION = new TracingOption(PLUGIN_ID, "qvtm2qvts/connectionCreation");	// FIXME
	public static final @NonNull TracingOption CONNECTION_ROUTING = new TracingOption(PLUGIN_ID, "qvtm2qvts/connectionRouting");

	public static final @NonNull String EQUALS_NAME = "«equals»";
	public static final @NonNull String GLABAL_MAPPING_NAME = "«global»";
	public static final @NonNull String INCLUDES_NAME = "«includes»";
	public static final @NonNull String LOAD_MAPPING_NAME = "«load»";
	public static final @NonNull String LOOP_ITERATOR_NAME = "«iterator»";
	public static final @NonNull String ROOT_MAPPING_NAME = "«root»";
	public static final @NonNull String MIDDLE_DOMAIN_NAME = QVTbaseUtil.TRACE_TYPED_MODEL_NAME; //"middle";

	public static final @NonNull String REGION_SYMBOL_NAME_PREFIX = "m";
	public static final @NonNull String REGION_SYMBOL_NAME_SUFFIX = "";

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
	public static final @NonNull String PARTITION_COLOR = "brown";
	public static final @NonNull String PREDICATED_COLOR = "cyan";
	public static final @NonNull String REALIZED_COLOR = "green3";
	public static final @NonNull String RECURSION_COLOR = "brown";
	public static final @NonNull String REGION_COLOR = "green";
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