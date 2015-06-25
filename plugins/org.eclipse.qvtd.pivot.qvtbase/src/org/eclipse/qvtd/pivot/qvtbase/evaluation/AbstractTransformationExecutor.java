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
package org.eclipse.qvtd.pivot.qvtbase.evaluation;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.evaluation.ModelManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorManager;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;

public abstract class AbstractTransformationExecutor extends ExecutorManager implements TransformationExecutor
{
	protected final @NonNull EnvironmentFactoryInternal environmentFactory;
	protected final @NonNull Transformer transformer;
	
	private AbstractTransformationExecutor(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull Constructor<? extends Transformer> txConstructor) 
			throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
		super(environmentFactory.getCompleteEnvironment());
		this.environmentFactory = environmentFactory;
		transformer = ClassUtil.nonNullState(txConstructor.newInstance(this));
	}
	
	protected AbstractTransformationExecutor(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull Class<? extends Transformer> txClass) 
			throws ReflectiveOperationException {
		this(environmentFactory, ClassUtil.nonNullState(txClass.getConstructor(Executor.class)));
	}

	@Override
	public @NonNull IdResolver getIdResolver() {
		return environmentFactory.getIdResolver();
	}

	@Override
	public @NonNull ModelManager getModelManager() {
		return transformer;
	}
	
	@Override
	public @NonNull Transformer getTransformer() {
		return transformer;
	}
}