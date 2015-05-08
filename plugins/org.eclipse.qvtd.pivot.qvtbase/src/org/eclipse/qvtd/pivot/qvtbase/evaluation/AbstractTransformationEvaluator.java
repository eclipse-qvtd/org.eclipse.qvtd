package org.eclipse.qvtd.pivot.qvtbase.evaluation;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.CompleteEnvironment;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.evaluation.ModelManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.internal.complete.CompleteEnvironmentInternal;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorManager;
import org.eclipse.ocl.pivot.utilities.ClassUtil;

public abstract class AbstractTransformationEvaluator extends ExecutorManager implements TransformationEvaluator
{
	protected final @NonNull TransformationExecutor executor;
	
	public AbstractTransformationEvaluator(@NonNull CompleteEnvironment environment, Constructor<? extends TransformationExecutor> txConstructor) 
			throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
		super(environment);
		executor = ClassUtil.nonNullState(txConstructor.newInstance(this));
	}
	
	public AbstractTransformationEvaluator(@NonNull CompleteEnvironment environment, Class<? extends TransformationExecutor> txClass) 
			throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException , NoSuchMethodException {
		this(environment, ClassUtil.nonNullState(txClass.getConstructor(Evaluator.class)));
	}

	@Override
	public @NonNull Evaluator createNestedEvaluator() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public @NonNull TransformationExecutor getExecutor() {
		return executor;
	}

	@Override
	public @NonNull IdResolver getIdResolver() {
		return ((CompleteEnvironmentInternal)environment).getEnvironmentFactory().getIdResolver();
	}

	@Override
	public @NonNull ModelManager getModelManager() {
		return executor;
	}
}