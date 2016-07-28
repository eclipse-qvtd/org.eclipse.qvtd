/*******************************************************************************
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.runtime.labels;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.labels.ILabelGenerator;

public class QVTiLabelGenerators
{
	public static void initialize(ILabelGenerator.@NonNull Registry registry) {
		TransformationInstanceLabelGenerator.initialize(registry);
		TypedModelInstanceLabelGenerator.initialize(registry);
	}
}