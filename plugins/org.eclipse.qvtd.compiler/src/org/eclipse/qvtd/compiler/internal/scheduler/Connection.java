/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.scheduler;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.qvtd.pivot.schedule.utilities.GraphStringBuilder;

/**
 * A Connection is a directed hyper edge between one or more source nodes in one or more regions and
 * one or more target nodes in one or more target regions.
 */
public interface Connection extends /*Edge*/ Nameable, Schedulable
{
	void addPassedTargetNode(@NonNull Node targetNode);
	void addUsedTargetNode(@NonNull Node targetNode, boolean mustBeLater);
	@Nullable Node basicGetSource(@NonNull Region sourceRegion);
	void destroy();

	/**
	 * Return a non-standard style for the arrow head. 
	 */
	@Nullable String getArrowhead();

	/**
	 * Return the color with which this edge is drawn. 
	 */
	@NonNull String getColor();
	
	@Nullable Region getCommonRegion();
	
	@NonNull ConnectionRole getConnectionRole();

	@NonNull List<Region> getIntermediateRegions();

	/**
	 * Return a formatted label to accompany the edge, or null for no label. 
	 */
	@Nullable String getLabel();
	
	@NonNull Node getSource(@NonNull Region sourceRegion);

	@NonNull Iterable<Node> getSources();

	@NonNull String getSourceDisplayNames();
	
	@NonNull Node getTarget(@NonNull Region targetRegion);

	@NonNull Iterable<Node> getTargets();
	
	@NonNull Type getType(@NonNull IdResolver idResolver);

	boolean isMandatory();

	/**
	 * Return true if this connection passes a value to a region head.
	 */
	boolean isPassed();
	boolean isPassed(@NonNull Region targetRegion);

	/**
	 * Return true if this connection is for an available value.
	 */
	boolean isUsed();
	boolean isUsed(@NonNull Node targetNode);
	
	/**
	 * Configure the region from which all consumers of this connection can be called and any intermediteRegions that must propagate this connection.
	 */
	void setCommonRegion(@NonNull Region commonRegion, @NonNull List<Region> intermediateRegions);

	void toGraph(@NonNull GraphStringBuilder s);
	void toRegionGraph(@NonNull GraphStringBuilder s);
}