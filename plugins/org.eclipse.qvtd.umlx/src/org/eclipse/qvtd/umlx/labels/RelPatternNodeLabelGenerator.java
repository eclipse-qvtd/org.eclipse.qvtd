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
import org.eclipse.qvtd.umlx.RelPatternNode;

public final class RelPatternNodeLabelGenerator extends AbstractLabelGenerator<@NonNull RelPatternNode>
{
	public static void initialize(@NonNull Registry registry) {
		registry.install(RelPatternNode.class, new RelPatternNodeLabelGenerator());
	}

	public RelPatternNodeLabelGenerator() {
		super(RelPatternNode.class);
	}

	@Override
	public void buildLabelFor(@NonNull Builder labelBuilder, @NonNull RelPatternNode object) {
		if (object.isExpression()) {
			labelBuilder.appendString(object.toString());
		}
		else {
			labelBuilder.appendString(object.getName());
		}
	}
}