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
package org.eclipse.qvtd.runtime.evaluation;

import java.lang.reflect.Constructor;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.evaluation.AbstractModelManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorManager;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.qvtd.runtime.internal.evaluation.AbstractTransformerInternal;

public abstract class AbstractTransformationExecutor extends ExecutorManager implements TransformationExecutor
{
	/**
	 * WrappedModelManager enables the unhelpful model access API to be observed without infecting the
	 * more streamlined QVTi accesses.
	 */
	private class WrappedModelManager extends AbstractModelManager
	{
		@Override
		public @NonNull Set<@NonNull ? extends Object> get(org.eclipse.ocl.pivot.@NonNull Class type) {
			return new IterableAsSet<@NonNull Object>(((AbstractTransformerInternal)transformer).get(type));
		}
	}

	protected final @NonNull EnvironmentFactory environmentFactory;
	protected final @NonNull Transformer transformer;
	private WrappedModelManager wrappedModelManager = null;

	private AbstractTransformationExecutor(@NonNull EnvironmentFactory environmentFactory, @NonNull Constructor<? extends Transformer> txConstructor)
			throws ReflectiveOperationException {
		super(environmentFactory.getCompleteEnvironment());
		this.environmentFactory = environmentFactory;
		transformer = ClassUtil.nonNullState(txConstructor.newInstance(this));
	}

	protected AbstractTransformationExecutor(@NonNull EnvironmentFactory environmentFactory, @NonNull Class<? extends Transformer> txClass)
			throws ReflectiveOperationException {
		this(environmentFactory, ClassUtil.nonNullState(txClass.getConstructor(TransformationExecutor.class)));
	}

	@Override
	public @NonNull IdResolver getIdResolver() {
		return environmentFactory.getIdResolver();
	}

	@Override
	public @NonNull WrappedModelManager getModelManager() {
		WrappedModelManager wrappedModelManager2 = wrappedModelManager ;
		if (wrappedModelManager2 == null) {
			wrappedModelManager2 = wrappedModelManager = new WrappedModelManager();
		}
		return wrappedModelManager2;
	}

	@Override
	public @NonNull Transformer getTransformer() {
		return transformer;
	}
}