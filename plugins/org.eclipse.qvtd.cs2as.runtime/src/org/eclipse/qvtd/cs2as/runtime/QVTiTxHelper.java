/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.cs2as.runtime;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.evaluation.TransformationExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.BasicQVTiExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperative;

public class QVTiTxHelper  {
	
	final private QVTimperative qvti; 
	
	public QVTiTxHelper(@NonNull QVTimperative qvti) {
		this.qvti = qvti;
	}

	private @NonNull QVTiEnvironmentFactory getEnvironmentFactory() {
		return (QVTiEnvironmentFactory) qvti.getEnvironmentFactory();
	}
	
	public @NonNull BasicQVTiExecutor createExecutor(Transformation transformation) {
		return new BasicQVTiExecutor(getEnvironmentFactory(), transformation);
	}
	
	// FIXME why do we need this ?
	public @NonNull QVTiTxEvaluator createTxEvaluator(Class<? extends TransformationExecutor> txClass)
			throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		return new QVTiTxEvaluator(getEnvironmentFactory().getCompleteEnvironment(), txClass);
	}	

}
