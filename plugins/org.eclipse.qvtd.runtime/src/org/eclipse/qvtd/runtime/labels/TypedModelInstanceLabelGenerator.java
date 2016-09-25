/*******************************************************************************
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.runtime.labels;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.labels.AbstractLabelGenerator;
import org.eclipse.qvtd.runtime.evaluation.TypedModelInstance;

public final class TypedModelInstanceLabelGenerator extends AbstractLabelGenerator<TypedModelInstance>
{
	public static void initialize(Registry registry) {
		registry.install(TypedModelInstance.class, new TypedModelInstanceLabelGenerator());
	}

	public TypedModelInstanceLabelGenerator() {
		super(TypedModelInstance.class);
	}

	@Override
	public void buildLabelFor(@NonNull Builder labelBuilder, @NonNull TypedModelInstance element) {
		labelBuilder.appendString(element.getName());
	}
}