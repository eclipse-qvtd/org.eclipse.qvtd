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
import org.eclipse.qvtd.umlx.RelDomainNode;
import org.eclipse.qvtd.umlx.TxTypedModelNode;

public final class RelDomainNodeLabelGenerator extends AbstractLabelGenerator<@NonNull RelDomainNode>
{
	public static void initialize(@NonNull Registry registry) {
		registry.install(RelDomainNode.class, new RelDomainNodeLabelGenerator());
	}

	public RelDomainNodeLabelGenerator() {
		super(RelDomainNode.class);
	}

	@Override
	public void buildLabelFor(@NonNull Builder labelBuilder, @NonNull RelDomainNode object) {
		TxTypedModelNode txTypedModelNode = object.getReferredTxTypedModelNode();
		labelBuilder.appendString(txTypedModelNode != null ? txTypedModelNode.getName() : null);
	}
}