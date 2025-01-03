/*******************************************************************************
 * Copyright (c) 2016, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvts.splitter;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.pivot.qvtschedule.Node;

/**
 * A Stage specifies part of a multi-headed region split. It has a headNode to represent its primary content
 * and an edge that defines the entry to the stage, null fir the first stage.
 */
interface Stage
{
	void check();
	void debug();
	@NonNull Iterable<@NonNull Node> getHeadNodes();
	@Nullable Node getIteratedNode();
	@Nullable Node getIteratorNode();
	void toString(@NonNull StringBuilder s, int depth);
}