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
package org.eclipse.qvtd.debug.evaluator;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.BasicQVTiExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiIncrementalExecutor;

/**
 * A BasicQVTrExecutor supports loading a QVTr transformation as source then loading models, performing a transformation
 * and then saving the models.
 *
 * @see BasicQVTiExecutor
 */
public class BasicQVTrExecutor extends QVTiIncrementalExecutor
{
	public BasicQVTrExecutor(@NonNull QVTiEnvironmentFactory environmentFactory, @NonNull ImperativeTransformation transformation) {
		super(environmentFactory, transformation, Mode.LAZY);
	}
}
