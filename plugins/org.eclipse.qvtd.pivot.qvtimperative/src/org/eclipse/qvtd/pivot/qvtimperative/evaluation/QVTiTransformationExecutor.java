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
package org.eclipse.qvtd.pivot.qvtimperative.evaluation;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.runtime.evaluation.AbstractTransformationExecutor;
import org.eclipse.qvtd.runtime.evaluation.Transformer;

public class QVTiTransformationExecutor extends AbstractTransformationExecutor
{
	public QVTiTransformationExecutor(@NonNull QVTiEnvironmentFactory environmentFactory, @NonNull Class<? extends Transformer> txClass) throws ReflectiveOperationException {
		super(environmentFactory, txClass);
	}
}