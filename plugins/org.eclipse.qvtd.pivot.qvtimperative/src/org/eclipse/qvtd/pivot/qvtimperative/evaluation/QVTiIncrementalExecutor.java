/*******************************************************************************
 * Copyright (c) 2015, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/

package org.eclipse.qvtd.pivot.qvtimperative.evaluation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.OppositePropertyCallExp;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.PropertyId;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.LabelUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder;
import org.eclipse.qvtd.pivot.qvtimperative.EntryPoint;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.NewStatement;
import org.eclipse.qvtd.pivot.qvtimperative.ObservableStatement;
import org.eclipse.qvtd.pivot.qvtimperative.SetStatement;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiModelsManager.QVTiTypedModelInstance;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;
import org.eclipse.qvtd.runtime.evaluation.AbstractComputation;
import org.eclipse.qvtd.runtime.evaluation.AbstractInvocation;
import org.eclipse.qvtd.runtime.evaluation.AbstractTransformer;
import org.eclipse.qvtd.runtime.evaluation.Computation;
import org.eclipse.qvtd.runtime.evaluation.Interval;
import org.eclipse.qvtd.runtime.evaluation.Invocation;
import org.eclipse.qvtd.runtime.evaluation.InvocationConstructor;
import org.eclipse.qvtd.runtime.evaluation.InvocationFailedException;
import org.eclipse.qvtd.runtime.evaluation.InvocationManager;
import org.eclipse.qvtd.runtime.evaluation.ModeFactory;
import org.eclipse.qvtd.runtime.evaluation.ObjectManager;
import org.eclipse.qvtd.runtime.evaluation.Transformer;
import org.eclipse.qvtd.runtime.evaluation.TypedModelInstance;
import org.eclipse.qvtd.runtime.internal.evaluation.AbstractComputationConstructor;
import org.eclipse.qvtd.runtime.internal.evaluation.AbstractInvocationConstructor;
import org.eclipse.qvtd.runtime.internal.evaluation.IncrementalInvocationManager;
import org.eclipse.qvtd.runtime.internal.evaluation.IncrementalObjectManager;
import org.eclipse.qvtd.runtime.internal.evaluation.LazyInvocationManager;
import org.eclipse.qvtd.runtime.internal.evaluation.LazyObjectManager;

/**
 * An evaluator implementation for OCL expressions.
 */
public class QVTiIncrementalExecutor extends BasicQVTiExecutor
{
	/**
	 * The run-time API version.
	 *
	 * @noreference this is solely for development usage.
	 */
	public static int RUN_TIME_EVALUATOR_API_VERSION = Transformer.RUN_TIME_EVALUATOR_API_VERSION_1_1_0_2;

	public static class InterpretedInvocationConstructor extends AbstractInvocationConstructor.Incremental
	{
		protected final @NonNull QVTiIncrementalExecutor executor;
		protected final @NonNull MappingCall mappingCall;
		protected final @NonNull EvaluationVisitor undecoratedVisitor;

		public InterpretedInvocationConstructor(@NonNull QVTiIncrementalExecutor executor, @NonNull Mapping asMapping,
				@NonNull MappingCall mappingCall, @NonNull EvaluationVisitor undecoratedVisitor) {
			super(executor.getInvocationManager(), QVTimperativeUtil.getName(asMapping), executor.getInvocationManager().createInterval());
			this.executor = executor;
			this.mappingCall = mappingCall;
			this.undecoratedVisitor = undecoratedVisitor;
		}

		//	@Override
		//	public @NonNull ModeFactory getModeFactory() {
		//		return ModeFactory.NON_INCREMENTAL;
		//	}

		@Override
		public @NonNull Invocation newInstance(int invocationHashCode, @NonNull Object @NonNull [] theseValues) {
			return new InterpretedInvocation(this, invocationHashCode, theseValues);
		}

		private Object internalExecuteInvocation(@NonNull InterpretedInvocation invocation, @NonNull Object @NonNull [] theseValues) {
			return executor.internalExecuteInvocation(invocation, theseValues, mappingCall, undecoratedVisitor);
		}
	}

	public static class InterpretedInvocation extends AbstractInvocation.Incremental
	{
		protected final @NonNull Object @NonNull [] theseValues;

		public InterpretedInvocation(@NonNull InterpretedInvocationConstructor constructor, int invocationHashCode, @NonNull Object @NonNull [] theseValues) {
			super(constructor, invocationHashCode);
			int iMax = theseValues.length;
			this.theseValues = new @NonNull Object[iMax];
			for (int i = 0; i < iMax; i++) {
				this.theseValues[i] = theseValues[i];
			}
		}

		@Override
		public boolean execute() throws InvocationFailedException {
			Object returnStatus = ((InterpretedInvocationConstructor)constructor).internalExecuteInvocation(this, theseValues);
			return returnStatus == ValueUtil.TRUE_VALUE;
		}

		@Override
		public @NonNull Object getBoundValue(int index) {
			return theseValues[index];
		}

		@Override
		public int getBoundValues() {
			return theseValues.length;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			int iMax = thoseValues.length;
			if (iMax != theseValues.length) {
				return false;
			}
			for (int i = 0; i < iMax; i++) {
				if (!idResolver.oclEquals(theseValues[i], thoseValues[i])) {
					return false;
				}
			}
			return true;
		}
	}

	public enum Mode {
		LAZY,						// EvaluationStatus is created lazily where necessary
		INCREMENTAL,				// EvaluationStatus is created for all mapping elements
		REPAIR						// EvaluationStatus is updated for all mapping elements
	};

	protected final @NonNull InvocationManager invocationManager;
	protected final @NonNull ObjectManager objectManager;
	private Invocation.@Nullable Incremental currentInvocation = null;
	private @Nullable Map<@NonNull Mapping, @NonNull InvocationConstructor> mapping2invocationConstructor = null;
	private @Nullable Map<@NonNull Operation, Computation.@NonNull Constructor> operation2computationConstructor = null;

	public QVTiIncrementalExecutor(@NonNull QVTiEnvironmentFactory environmentFactory, @NonNull EntryPoint entryPoint, @NonNull ModeFactory modeFactory) {
		super(environmentFactory, entryPoint, modeFactory);
		boolean isLazy = modeFactory.isLazy();
		this.invocationManager = isLazy ? new LazyInvocationManager(this) : new IncrementalInvocationManager(this);
		this.objectManager = isLazy ? new LazyObjectManager((LazyInvocationManager)invocationManager) : new IncrementalObjectManager((IncrementalInvocationManager)invocationManager);
		Set<@NonNull CompleteClass> allInstancesCompleteClasses = entryPointAnalysis.getAllInstancesCompleteClasses();
		@NonNull PropertyId @NonNull [] propertyIndex2propertyId = entryPointsAnalysis.getPropertyIndex2propertyId();
		modelsManager.initOpposites(propertyIndex2propertyId);

		for (@NonNull QVTiTypedModelInstance typedModelInstance : modelsManager.getTypedModelInstances()) {
			TypedModel typedModel = typedModelInstance.getTypedModel();
			Set<@NonNull CompleteClass> usedCompleteClasses = new HashSet<>();
			for (org.eclipse.ocl.pivot.@NonNull Class usedClass : QVTimperativeUtil.getUsedClasses(typedModel)) {
				usedCompleteClasses.add(environmentFactory.getCompleteModel().getCompleteClass(usedClass));
			}
			usedCompleteClasses.retainAll(allInstancesCompleteClasses);
			TypedModelAnalysis typedModelAnalysis = new TypedModelAnalysis(entryPointsAnalysis, typedModel, usedCompleteClasses);
			@NonNull ClassId @NonNull [] classIndex2classId = typedModelAnalysis.getClassIndex2ClassId();
			int @Nullable [] @NonNull [] classIndex2allClassIndexes = typedModelAnalysis.getClassIndex2allClassIndexes();
			typedModelInstance.initClassIds(classIndex2classId, classIndex2allClassIndexes);
			int extentClassIndex = typedModelAnalysis.getExtentClassIndex();
			if (extentClassIndex >= 0) {
				Map<@NonNull Object, Object> extentOpposites = modelsManager.getExtentOpposites();
				typedModelInstance.initExtent(extentClassIndex, extentOpposites);
			}
			//			typedModelAnalysis.toString();
		}
		initConnections();
	}

	public @NonNull String createGraph(@NonNull GraphStringBuilder s) {
		Execution2GraphVisitor execution2GraphVisitor = new Execution2GraphVisitor(s);
		invocationManager.accept(execution2GraphVisitor);
		objectManager.accept(execution2GraphVisitor);
		String string = execution2GraphVisitor.toString();
		assert string != null;
		return string;
	}

	@Override
	public @NonNull InvocationConstructor getInvocationConstructor(@NonNull MappingCall mappingCall, @NonNull EvaluationVisitor undecoratedVisitor) {
		Mapping asMapping = ClassUtil.nonNullState(mappingCall.getReferredMapping());
		Map<@NonNull Mapping, @NonNull InvocationConstructor> mapping2invocationConstructor2 = mapping2invocationConstructor;
		if (mapping2invocationConstructor2 == null) {
			mapping2invocationConstructor = mapping2invocationConstructor2 = new HashMap<>();
		}
		InvocationConstructor invocationConstructor = mapping2invocationConstructor2.get(asMapping);
		if (invocationConstructor == null) {
			invocationConstructor = new InterpretedInvocationConstructor(this, asMapping, mappingCall, undecoratedVisitor);
			mapping2invocationConstructor2.put(asMapping, invocationConstructor);
		}
		return invocationConstructor;
	}

	@Override
	public @NonNull InvocationManager getInvocationManager() {
		return invocationManager;
	}

	@Override
	public @NonNull Transformer getTransformer() {
		throw new UnsupportedOperationException("Transformer API not implemented by interpreted executor");
	}

	@Override
	public @NonNull TypedModelInstance getTypedModelInstance(@NonNull String modelName) {
		return modelsManager.getTypedModelInstance(modelName);
	}

	protected void initConnections() {
		Interval rootInterval = getInvocationManager().getRootInterval();
		//		Interval rootInterval = lazyCreateInterval(0);
		ModeFactory modeFactory = ModeFactory.NON_INCREMENTAL;// getModeFactory();
		for (@NonNull TypedModelInstance model : getModelsManager().getTypedModelInstances()) {
			model.initConnections(rootInterval, modeFactory);
		}
	}

	@Override
	protected @Nullable Object internalExecuteFunctionCallExp(@NonNull OperationCallExp operationCallExp,
			@NonNull Function asFunction, @Nullable Object @NonNull [] boxedSourceAndArgumentValues) {
		Map<@NonNull Operation, Computation.@NonNull Constructor> operation2computationConstructor2 = operation2computationConstructor;
		if (operation2computationConstructor2 == null) {
			operation2computationConstructor = operation2computationConstructor2 = new HashMap<>();
		}
		Computation.Constructor computationConstructor = operation2computationConstructor2.get(asFunction);
		if (computationConstructor == null) {
			computationConstructor = new AbstractComputationConstructor(idResolver)
			{
				@Override
				public @NonNull Computation newInstance(@Nullable Object @NonNull [] theseValues) {
					Computation.Incremental computation = new AbstractComputation.Incremental(PivotUtil.getName(asFunction))
					{
						protected Object result = QVTiIncrementalExecutor.super.internalExecuteFunctionCallExp(operationCallExp, asFunction, theseValues);

						@Override
						public @Nullable Object getResult() {
							return result;
						}

						@Override
						public boolean isEqual(@NonNull IdResolver idResolver, @Nullable Object @NonNull [] thoseValues) {
							int iMax = thoseValues.length;
							if (iMax != theseValues.length) {
								return false;
							}
							for (int i = 0; i < iMax; i++) {
								if (!idResolver.oclEquals(theseValues[i], thoseValues[i])) {
									return false;
								}
							}
							return true;
						}

						@Override
						public String toString() {
							return operationCallExp.getReferredOperation().getName() + "@" + Integer.toHexString(System.identityHashCode(this));
						}
					};
					return computation;
				}
			};
			operation2computationConstructor2.put(asFunction, computationConstructor);
		}
		Computation computation = computationConstructor.getUniqueComputation(boxedSourceAndArgumentValues);
		return computation.getResult();
	}

	private Object internalExecuteInvocation(@NonNull InterpretedInvocation invocation, @NonNull Object @NonNull [] theseValues, @NonNull MappingCall mappingCall, @NonNull EvaluationVisitor undecoratedVisitor) {
		currentInvocation = invocation;
		try {
			return super.internalExecuteMappingCall(mappingCall, theseValues, undecoratedVisitor);
		}
		finally {
			currentInvocation = null;
		}
	}

	@Override
	public @Nullable Object internalExecuteMappingCall(@NonNull MappingCall mappingCall, @NonNull Object @NonNull [] boundValues, @NonNull EvaluationVisitor undecoratedVisitor) {
		Mapping asMapping = ClassUtil.nonNullState(mappingCall.getReferredMapping());
		if (modeFactory.isLazy()) {
			if (!entryPointAnalysis.isHazardous(asMapping)) {
				return super.internalExecuteMappingCall(mappingCall, boundValues, undecoratedVisitor);
			}
		}
		InvocationConstructor invocationConstructor = getInvocationConstructor(mappingCall, undecoratedVisitor);
		invocationConstructor.invoke(boundValues);
		return null;
	}

	@Override
	public @Nullable Object internalExecuteNavigationCallExp(@NonNull NavigationCallExp navigationCallExp, @NonNull Property referredProperty, @Nullable Object sourceValue) {
		if (sourceValue == transformationExecution) {
			Property transformationExecutionProperty = getTransformationExecutionProperty(referredProperty);
			if (transformationExecutionProperty != null) {
				referredProperty = transformationExecutionProperty;
			}
		}
		if (referredProperty.isIsImplicit()) {
			QVTiModelsManager modelManager = getModelsManager();
			Integer cacheIndex = entryPointAnalysis.getCacheIndex((OppositePropertyCallExp) navigationCallExp);
			if (cacheIndex != null) {
				if (sourceValue != null) {
					return modelManager.getUnnavigableOpposite(cacheIndex, sourceValue);
				}
				else {
					throw new InvalidValueException("Failed to evaluate '" + referredProperty + "'", sourceValue, navigationCallExp);
				}
			}
		}
		Mapping asMapping = QVTimperativeUtil.basicGetContainingMapping(navigationCallExp);
		Object ecoreValue;
		//		if ((asMapping != null) && transformationAnalysis.isHazardousRead(asMapping, navigationCallExp)) {		// null within queries
		if ((asMapping != null) && isHazardous2(navigationCallExp)) {		// null within queries
			//			assert false; 		// Should use an AccessStatement
			//			assert sourceValue != null;
			if (sourceValue == null) {
				throw new InvalidValueException("Null source for '" + referredProperty + "'", sourceValue, navigationCallExp);
			}
			boolean isOpposite = false;
			EStructuralFeature eFeature = (EStructuralFeature)referredProperty.getESObject();
			if (eFeature == null) {
				assert referredProperty.isIsImplicit();
				isOpposite = true;
				eFeature = (EStructuralFeature)referredProperty.getOpposite().getESObject();
			}
			objectManager.getting(sourceValue, eFeature, isOpposite);
			ecoreValue = super.internalExecuteNavigationCallExp(navigationCallExp, referredProperty, sourceValue);
			if (debugInvocations) {
				AbstractTransformer.INVOCATIONS.println("got " + eFeature.getEContainingClass().getName() + "::" + eFeature.getName() + " for " + LabelUtil.getLabel(sourceValue) + " = " + LabelUtil.getLabel(ecoreValue));
			}
		}
		else {
			ecoreValue = super.internalExecuteNavigationCallExp(navigationCallExp, referredProperty, sourceValue);
		}
		if (!modeFactory.isLazy()) {
			Invocation.Incremental currentInvocation2 = currentInvocation;
			if (currentInvocation2 != null) {			// Null at root
				assert sourceValue != null;
				EStructuralFeature eFeature = (EStructuralFeature)referredProperty.getESObject();
				assert currentInvocation2 != null;
				objectManager.got(currentInvocation2, sourceValue, eFeature, ecoreValue);
			}
		}
		return ecoreValue;
	}

	private boolean isHazardous2(@NonNull NavigationCallExp asNavigationCallExp) {
		for (EObject eObject = asNavigationCallExp; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof ObservableStatement) {
				List<Property> observedProperties = ((ObservableStatement)eObject).getObservedProperties();
				Property navigatedProperty = PivotUtil.getReferredProperty(asNavigationCallExp);
				return observedProperties.contains(navigatedProperty);
			}
		}
		return false;
	}

	@Override
	public @Nullable Object internalExecuteNewStatement(@NonNull NewStatement asNewStatement, @NonNull EvaluationVisitor undecoratedVisitor) {
		Object element = super.internalExecuteNewStatement(asNewStatement, undecoratedVisitor);
		if ((element != null) && modeFactory.isIncremental()) {
			Invocation.Incremental currentInvocation2 = currentInvocation;
			assert currentInvocation2 != null;
			objectManager.created(currentInvocation2, element);
			/*			DomainUsage domainUsage = getEvaluationEnvironment().getUsageFor(realizedVariable);
			ClassStatus classStatus = statusManager.getClassStatus(domainUsage, realizedVariable.getType(), (EObject)element);
			MappingStatus mappingStatus = findMappingStatus();
			assert mappingStatus != null;
			mappingStatus.getOutputs().add(classStatus); */
		}
		return element;
	}

	@Override
	public void internalExecuteSetStatement(@NonNull SetStatement setStatement, @NonNull Object sourceObject, @Nullable Object ecoreValue) {
		super.internalExecuteSetStatement(setStatement, sourceObject, ecoreValue);
		if (modeFactory.isLazy()) {
			if (setStatement.isIsNotify()) {
				Property targetProperty = QVTimperativeUtil.getTargetProperty(setStatement);
				assert targetProperty != null;
				EStructuralFeature eFeature = (EStructuralFeature)targetProperty.getESObject();
				objectManager.assigned(sourceObject, eFeature, ecoreValue);
			}
		}
		else {
			Property targetProperty = QVTimperativeUtil.getTargetProperty(setStatement);
			assert targetProperty != null;
			EStructuralFeature eFeature = (EStructuralFeature)targetProperty.getESObject();
			Invocation.Incremental currentInvocation2 = currentInvocation;
			assert currentInvocation2 != null;
			objectManager.assigned(currentInvocation2, sourceObject, eFeature, ecoreValue);
		}
	}
}
