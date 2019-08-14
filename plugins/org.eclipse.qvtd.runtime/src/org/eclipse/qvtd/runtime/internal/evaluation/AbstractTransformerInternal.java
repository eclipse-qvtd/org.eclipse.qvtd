/*******************************************************************************
 * Copyright (c) 2016, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.runtime.internal.evaluation;


import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.PropertyId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.evaluation.EvaluationCache;
import org.eclipse.ocl.pivot.internal.values.SetValueImpl;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.SetValue;
import org.eclipse.qvtd.runtime.evaluation.AbstractObjectManager;
import org.eclipse.qvtd.runtime.evaluation.AbstractTransformer;
import org.eclipse.qvtd.runtime.evaluation.Connection;
import org.eclipse.qvtd.runtime.evaluation.DefaultInterval;
import org.eclipse.qvtd.runtime.evaluation.ExecutionVisitable;
import org.eclipse.qvtd.runtime.evaluation.ExecutionVisitor;
import org.eclipse.qvtd.runtime.evaluation.Interval;
import org.eclipse.qvtd.runtime.evaluation.InvalidEvaluationException;
import org.eclipse.qvtd.runtime.evaluation.InvocationFailedException;
import org.eclipse.qvtd.runtime.evaluation.InvocationManager;
import org.eclipse.qvtd.runtime.evaluation.ModeFactory;
import org.eclipse.qvtd.runtime.evaluation.ObjectManager;
import org.eclipse.qvtd.runtime.evaluation.TransformationExecutor;
import org.eclipse.qvtd.runtime.evaluation.Transformer;
import org.eclipse.qvtd.runtime.evaluation.TypedModelInstance;

/**
 * The abstract implementation of an auto-generated transformation provides the shared infrastructure for maintaining
 * models and deferring invocation of not-ready mapping invocations.
 */
public abstract class AbstractTransformerInternal /*extends AbstractModelManager*/ implements Transformer, ExecutionVisitable
{
	public static abstract class Incremental extends AbstractTransformerInternal
	{
		protected Incremental(@NonNull TransformationExecutor executor, @NonNull String @NonNull [] modelNames,
				@NonNull PropertyId @Nullable [] propertyIndex2propertyId, @NonNull ClassId @NonNull [] classIndex2classId, int @Nullable [] @NonNull [] classIndex2allClassIndexes) {
			super(executor, modelNames, propertyIndex2propertyId, classIndex2classId, classIndex2allClassIndexes) ;
		}

		protected Incremental(@NonNull TransformationExecutor executor, int models) {
			super(executor, models);
		}

		@Override
		@Deprecated /* @deprecated pass interval */
		protected @NonNull Connection createConnection(@NonNull String name, @NonNull TypeId typeId, boolean isStrict) {
			return createConnection(invocationManager.getRootInterval(), name, typeId, isStrict, ModeFactory.NON_INCREMENTAL);
		}

		@Override
		protected @NonNull Connection createConnection(@NonNull Interval interval, @NonNull String name, @NonNull TypeId typeId, boolean isStrict, @NonNull ModeFactory modeFactory) {
			return interval.createConnection(name, typeId, isStrict, modeFactory);
		}

		@Override
		protected @NonNull InvocationManager createInvocationManager() {
			return new IncrementalInvocationManager(executor);
		}

		@Override
		protected RuntimeModelsManager.@NonNull Model createTypedModelInstance(@NonNull String modelName) {
			return new RuntimeModelsManager.Model.Incremental(modelsManager, modelName);
		}

		@Override
		protected @NonNull ObjectManager createObjectManager() {
			return new IncrementalObjectManager((IncrementalInvocationManager)invocationManager);
		}

		@Override
		@NonNull
		public ModeFactory getModeFactory() {
			return ModeFactory.INCREMENTAL;
		}
	}

	@Deprecated // only used by exe2016/bigmde2016 tests
	private static class UnenforcedSetAccumulator extends SetValueImpl implements SetValue.Accumulator
	{
		public UnenforcedSetAccumulator(@NonNull CollectionTypeId typeId) {
			super(typeId, new ArrayList<Object>());
		}

		@Override
		@SuppressWarnings("unchecked")
		public boolean add(@Nullable Object value) {
			assert !((Collection<Object>)elements).contains(value);
			return ((Collection<Object>)elements).add(value);
		}
	}

	protected final @NonNull TransformationExecutor executor;
	/** deprecated use executor */
	@Deprecated
	protected final @NonNull Evaluator evaluator;
	protected final IdResolver.@NonNull IdResolverExtension idResolver;
	protected final RuntimeModelsManager.@NonNull Model @NonNull [] models;
	//	protected final @NonNull Map<@Nullable String, @NonNull Integer> modelIndexes = new HashMap<>();
	protected final @NonNull RuntimeModelsManager modelsManager;
	protected final boolean debugAssignments = AbstractTransformer.ASSIGNMENTS.isActive();
	protected final boolean debugCreations = AbstractTransformer.CREATIONS.isActive();
	protected final boolean debugExceptions = AbstractTransformer.EXCEPTIONS.isActive();
	protected final boolean debugGettings = AbstractTransformer.GETTINGS.isActive();
	protected final boolean debugInvocations = AbstractTransformer.INVOCATIONS.isActive();

	/**
	 * Manager for the blocked and unblocked invocations.
	 */
	protected final @NonNull InvocationManager invocationManager;

	/**
	 * Manager for the auxiliary object and property state.
	 */
	protected final @NonNull ObjectManager objectManager;

	/**
	 * Cache of operation evaluations.
	 */
	protected final @NonNull EvaluationCache evaluationCache;

	protected AbstractTransformerInternal(@NonNull TransformationExecutor executor, @NonNull String @NonNull [] modelNames,
			@NonNull PropertyId @Nullable [] propertyIndex2propertyId, @NonNull ClassId @NonNull [] classIndex2classId, int @Nullable [] @NonNull [] classIndex2allClassIndexes) {
		this(executor, modelNames.length) ;
		if (propertyIndex2propertyId != null) {
			initOpposites(propertyIndex2propertyId);
		}
		for (int i = 0; i < modelNames.length; i++) {
			TypedModelInstance model = initModel(i, modelNames[i]);
			model.initClassIds(classIndex2classId, classIndex2allClassIndexes);
		}
		initConnections();
	}

	protected AbstractTransformerInternal(@NonNull TransformationExecutor executor, int models) {
		this.executor = executor;
		this.evaluator = executor;
		this.idResolver = (IdResolver.IdResolverExtension)executor.getIdResolver();
		this.invocationManager = createInvocationManager();
		this.objectManager = createObjectManager();
		this.evaluationCache = createEvaluationCache();
		this.modelsManager = new RuntimeModelsManager(models);
		this.models = modelsManager.getModels();
	}

	@Override
	public <R> R accept(@NonNull ExecutionVisitor<R> visitor) {
		return visitor.visitTransformer(this);
	}

	/**
	 * Add eResource to the modelIndex model.
	 *
	@Override
	public void addRootObjects(@NonNull String modelName, @NonNull Resource eResource) {
		getTypedModelInstance(modelName).addRootObjects(eResource);
	} */

	/**
	 * Add eRootObjects to the modelIndex model.
	 *
	@Override
	public void addRootObjects(@NonNull String modelName, @NonNull Iterable<@NonNull ? extends Object> eRootObjects) {
		getTypedModelInstance(modelName).addRootObjects(eRootObjects);
	} */

	@Deprecated /* @deprecated pass interval */
	protected @NonNull Connection createConnection(@NonNull String name, @NonNull TypeId typeId, boolean isStrict) {
		return createConnection(invocationManager.getRootInterval(), name, typeId, isStrict, getModeFactory());
	}

	protected @NonNull Connection createConnection(@NonNull Interval interval, @NonNull String name, @NonNull TypeId typeId, boolean isStrict, @NonNull ModeFactory modeFactory) {
		return interval.createConnection(name, typeId, isStrict, modeFactory);
	}

	/**
	 * Create the evaluationCache. Creates a EvaluationCache by default.
	 */
	protected @NonNull EvaluationCache createEvaluationCache() {
		return new EvaluationCache(executor);
	}

	protected @NonNull Interval createInterval(int intervalIndex) {
		return new DefaultInterval(getInvocationManager(), intervalIndex);
	}

	/**
	 * Create the InvocationManager. Creates a LazyInvocationManager by default.
	 */
	protected @NonNull InvocationManager createInvocationManager() {
		return new LazyInvocationManager(executor);
	}

	protected RuntimeModelsManager.@NonNull Model createTypedModelInstance(@NonNull String modelName) {
		return new RuntimeModelsManager.Model(modelsManager, modelName);
	}

	@Deprecated // Use createConnection
	protected SetValue.@NonNull Accumulator createUnenforcedSetAccumulatorValue(@NonNull CollectionTypeId typeId) {
		return new UnenforcedSetAccumulator(typeId);
	}

	/**
	 * Create the ObjectManager. Creates a LazyObjectManager by default.
	 */
	protected @NonNull ObjectManager createObjectManager() {
		return new LazyObjectManager((LazyInvocationManager)invocationManager);
	}

	/**
	 * Get the elements of type from the zeroth TypedModelInstance.
	 *
	 * This obsolete method is used by some legacy tests that dispatch via allInstances()rtaher than Connections.
	 */
	@Deprecated /* @deprecated Connections should be used to aggregate model elements */
	public @NonNull Iterable<@NonNull Object> get(org.eclipse.ocl.pivot.@NonNull Class type) {
		return models[0].getObjectsOfKind(type);
	}

	@Override
	public @NonNull EvaluationCache getEvaluationCache() {
		return evaluationCache;
	}

	@Override
	public @NonNull TransformationExecutor getExecutor() {
		return executor;
	}

	@Override
	public @NonNull InvocationManager getInvocationManager() {
		return invocationManager;
	}

	public @NonNull ModeFactory getModeFactory() {
		return ModeFactory.NON_INCREMENTAL;
	}

	@Override
	public @NonNull RuntimeModelsManager getModelsManager() {
		return modelsManager;
	}

	@Override
	public @NonNull ObjectManager getObjectManager() {
		return objectManager;
	}

	/**
	 * Return all objects in the modelIndex model that conform to eClass.
	 *
    protected @NonNull <T extends EObject> List<T> getObjectsByType(int modelIndex, @NonNull EClass eClass) {
		return models[modelIndex].getObjectsByType(eClass);
	} */

	@Override
	public int getTypedModelIndex(@NonNull String targetModelName) {
		return modelsManager.getTypedModelIndex(targetModelName);
	}

	@Override
	public @NonNull TypedModelInstance getTypedModelInstance(@NonNull String modelName) {
		return modelsManager.getTypedModelInstance(modelName);
	}

	/**
	 * The default handler for an exception during mapping execution rethrows an InvocationFailedException so that the
	 * caller may organize a re-exection when the reqired memory access can succeed. Errors are rethrown and should
	 * propagate to the transformation invoker, except for AssertionError which is is absorbed if the user has configured
	 * AbstractTransformer.EXCEPTIONS to observe them on the console. All other exceptions are just absorbed since they
	 * may represent a predicate failure.
	 */
	protected boolean handleExecutionFailure(@NonNull String mappingName, @NonNull Throwable e) throws InvocationFailedException {
		if (e instanceof InvocationFailedException) {		// Normal case - premature access needs a retry later
			throw (InvocationFailedException)e;
		}
		else if (e instanceof InvalidEvaluationException) {	// Real errors are fatal
			if (debugExceptions) {
				AbstractTransformer.EXCEPTIONS.println("Execution failure in '" + mappingName + "' : " + e);
			}
			throw (InvalidEvaluationException)e;
		}
		else if (e instanceof AssertionError) {				// Debug case - assertion errors are diagnostic not catastrophic
			if (debugExceptions) {
				AbstractTransformer.EXCEPTIONS.println("Execution failure in '" + mappingName + "' : " + e);
			}
			else {
				throw (AssertionError)e;					// But if the user isn't watching them they are fatal
			}
		}
		else if (e instanceof Error) {						// Real errors are fatal
			if (debugExceptions) {
				AbstractTransformer.EXCEPTIONS.println("Execution failure in '" + mappingName + "' : " + e);
			}
			throw (Error)e;
		}
		else { 												// Other failures are just mappings whose predicates were not satisfied.
			if (e instanceof InvalidValueException) {		// Multiway branch to facilitate debugger breakpoints.
				if (debugExceptions) {
					AbstractTransformer.EXCEPTIONS.println("Execution failure in '" + mappingName + "' : " + e);
				}
			}
			else if (e instanceof NullPointerException) {
				if (debugExceptions) {
					AbstractTransformer.EXCEPTIONS.println("Execution failure in '" + mappingName + "' : " + e);
				}
			}
			else {
				if (debugExceptions) {
					AbstractTransformer.EXCEPTIONS.println("Execution failure in '" + mappingName + "' : " + e);
				}
			}
		}
		if (e instanceof Exception) {
			throw new InvalidEvaluationException((Exception)e);
		}
		throw new InvalidEvaluationException(new RuntimeException(e));
	}

	protected void initConnections() {
		Interval rootInterval = lazyCreateInterval(0);
		ModeFactory modeFactory = getModeFactory();
		for (@NonNull TypedModelInstance model : models) {
			model.initConnections(rootInterval, modeFactory);
		}
	}

	protected RuntimeModelsManager.@NonNull Model initModel(int i, @NonNull String modelName) {
		RuntimeModelsManager.Model model = createTypedModelInstance(modelName);
		modelsManager.initTypedModelInstance(i, model);
		return model;
	}

	protected void initOpposites(@NonNull PropertyId @NonNull [] propertyIndex2propertyId) {
		modelsManager.initOpposites(propertyIndex2propertyId);
	}

	protected @NonNull Interval lazyCreateInterval(int intervalIndex) {
		if (intervalIndex < 0) {
			return invocationManager.createInterval();		// Obsolete functionality
		}
		for (int i = invocationManager.getIntervalsSize(); i < intervalIndex; i++) {
			createInterval(i);
		}
		Interval interval = invocationManager.basicGetInterval(intervalIndex);
		return interval != null ? interval : createInterval(intervalIndex);
	}

	private boolean hasPreExecuted = false;

	@Override
	public void analyzeInputResources() {
		for (RuntimeModelsManager.@NonNull Model model : models) {
			model.analyzeInputResources();
		}
	}

	/*	@Override
	public void setExternalURI(@NonNull String modelName, @NonNull URI modelURI) {
		TypedModelInstance model = getTypedModelInstance(modelName);
		for (Object object : model.getRootObjects()) {
			if (object instanceof org.eclipse.ocl.pivot.Model) {
				((org.eclipse.ocl.pivot.Model)object).setExternalURI(modelURI.toString());
			}
		}
	} */

	@Override
	public boolean run() throws Exception {
		return false;
	}

	@Override
	public boolean run(int targetTypedModelIndex) throws Exception {
		return false;
	}

	public @NonNull Object throwInvalidEvaluationException(@NonNull String message, Object... bindings) {
		throw new InvalidEvaluationException(message, bindings);
	}

	/**
	 * Return the string rendering of object for use in debug messages. The default just invokes String.valueOf().
	 * Derived implementations may provide metamodel-specific content.
	 */
	protected @NonNull String toDebugString(@Nullable Object object) {
		return AbstractObjectManager.toDebugString(object);
	}
}
