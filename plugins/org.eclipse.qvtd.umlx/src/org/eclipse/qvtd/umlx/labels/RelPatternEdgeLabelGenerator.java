/*******************************************************************************
 * Copyright (c) 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.umlx.labels;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.labels.AbstractLabelGenerator;
import org.eclipse.qvtd.umlx.RelPatternEdge;
import org.eclipse.qvtd.umlx.RelPatternNode;

public final class RelPatternEdgeLabelGenerator extends AbstractLabelGenerator<@NonNull RelPatternEdge>
{
	public static void initialize(@NonNull Registry registry) {
		registry.install(RelPatternEdge.class, new RelPatternEdgeLabelGenerator());
	}

	public RelPatternEdgeLabelGenerator() {
		super(RelPatternEdge.class);
	}

	@Override
	public void buildLabelFor(@NonNull Builder labelBuilder, @NonNull RelPatternEdge object) {
		RelPatternNode source = object.getSource();
		RelPatternNode target = object.getTarget();
		labelBuilder.appendString(source != null ? source.getName() : null);
		labelBuilder.appendString(" -> ");
		if (!target.isExpression()) {
			labelBuilder.appendString(target.getName());
		}
	}
}