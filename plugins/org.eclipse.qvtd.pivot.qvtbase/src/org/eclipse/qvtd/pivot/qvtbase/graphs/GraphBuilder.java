/*******************************************************************************
 * Copyright (c) 2015, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.pivot.qvtbase.graphs;

import org.eclipse.jdt.annotation.NonNull;

public interface GraphBuilder {
	void appendEdge(@NonNull String sourceId, @NonNull String targetId, @NonNull String lineColor,
			@NonNull String lineType, @NonNull String sourceArrowType, @NonNull String targetArrowType);
	void appendEdge(@NonNull String sourceId, @NonNull String targetId, @NonNull String lineColor,
			@NonNull String lineType, @NonNull String sourceArrowType, @NonNull String targetArrowType,
			@NonNull String label);
	void appendNode(@NonNull String id, @NonNull String shapeName,
			@NonNull String fillColor, String label, @NonNull String labelColor);
	void appendNode(/*@NonNull*/ String id, @NonNull String shapeName, @NonNull String fillColor, int height, int width, String label);
	@NonNull String close();
	void open();
}
