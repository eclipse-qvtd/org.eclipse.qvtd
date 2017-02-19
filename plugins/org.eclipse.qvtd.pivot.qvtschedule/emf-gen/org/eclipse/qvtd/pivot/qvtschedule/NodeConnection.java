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
package org.eclipse.qvtd.pivot.qvtschedule;

import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ids.IdResolver;

/**
 * @generated
 */
public interface NodeConnection extends DatumConnection<Node>
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