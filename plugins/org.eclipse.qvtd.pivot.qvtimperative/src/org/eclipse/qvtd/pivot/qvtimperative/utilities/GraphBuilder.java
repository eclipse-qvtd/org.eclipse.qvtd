/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     E.D.Willink - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.utilities;

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
	void close();
	void open();
}
