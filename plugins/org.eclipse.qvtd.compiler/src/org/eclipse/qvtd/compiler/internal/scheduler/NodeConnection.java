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
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ids.IdResolver;

/**
 * A NodeConnection supports a data connection from one or more source nodes to one or more target nodes.
 * The data connection has a data type for the elemental value transfer through the connection.
 * A passed connection may be realized by a simple transient point-to-point linkage or
 * a full buffer that accumulates all possible values. A used connection is not actually realized; it just ensures that
 * all source values exist before any target value consumes the value recomputed at the target.
 */
public interface NodeConnection extends DatumConnection
{
	void addPassedTargetNode(@NonNull Node targetNode);
//	void addSubConnection(@NonNull Connection subConnection);
	void addUsedTargetNode(@NonNull Node targetNode, boolean mustBeLater);
	@Nullable Node basicGetSource(@NonNull Region sourceRegion);
//	@Nullable Connection basicGetSuperConnection();
	
	@NonNull ClassDatumAnalysis getClassDatumAnalysis();
	
	@Nullable Region getCommonRegion();
	@NonNull ConnectionRole getConnectionRole(@NonNull Node targetNode);

	@NonNull List<@NonNull Region> getIntermediateRegions();
	@Override
	@NonNull Node getSource(@NonNull Region sourceRegion);
	@Override
	@NonNull Iterable<@NonNull Node> getSources();
	
	@NonNull Type getSourcesType(@NonNull IdResolver idResolver);
	
	@Override
	@NonNull Node getTarget(@NonNull Region targetRegion);
	@Override
	@NonNull Map<@NonNull Node, @NonNull ConnectionRole> getTargets();

	/**
	 * Return true if this connection is for an available value.
	 */
	boolean isUsed();
	boolean isUsed(@NonNull Node targetNode);

	void removeSource(@NonNull Node sourceNode);
	void removeTarget(@NonNull Node targetNode);
	
	/**
	 * Configure the region from which all consumers of this connection can be called and any intermediteRegions that must propagate this connection.
	 */
	void setCommonRegion(@NonNull Region commonRegion, @NonNull List<@NonNull Region> intermediateRegions);
}