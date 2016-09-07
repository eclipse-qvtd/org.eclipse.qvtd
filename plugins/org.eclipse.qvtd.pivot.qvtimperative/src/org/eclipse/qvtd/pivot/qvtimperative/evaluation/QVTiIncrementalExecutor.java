/*******************************************************************************
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/

package org.eclipse.qvtd.pivot.qvtimperative.evaluation;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.OppositePropertyCallExp;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder;
import org.eclipse.qvtd.pivot.qvtcorebase.NavigationAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;
import org.eclipse.qvtd.runtime.evaluation.AbstractComputation;
import org.eclipse.qvtd.runtime.evaluation.AbstractInvocation;
import org.eclipse.qvtd.runtime.evaluation.AbstractTransformer;
import org.eclipse.qvtd.runtime.evaluation.Computation;
import org.eclipse.qvtd.runtime.evaluation.Invocation;
import org.eclipse.qvtd.runtime.evaluation.InvocationFailedException;
import org.eclipse.qvtd.runtime.evaluation.InvocationManager;
import org.eclipse.qvtd.runtime.evaluation.ObjectManager;
import org.eclipse.qvtd.runtime.evaluation.Transformer;
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

	public enum Mode {
		LAZY,						// EvaluationStatus is created lazily where necessary
		INCREMENTAL,				// EvaluationStatus is created for all mapping elements
		REPAIR						// EvaluationStatus is updated for all mapping elements
	};

	protected final @NonNull Mode mode;
	protected final @NonNull QVTiTransformationAnalysis transformationAnalysis;
	protected final @NonNull InvocationManager invocationManager;
	protected final @NonNull ObjectManager objectManager;
	private Invocation.@Nullable Incremental currentInvocation = null;
	private @Nullable Map<@NonNull Mapping, Invocation.@NonNull Constructor> mapping2invocationConstructor = null;
	private @Nullable Map<@NonNull Operation, Computation.@NonNull Constructor> operation2computationConstructor = null;

	public QVTiIncrementalExecutor(@NonNull QVTiEnvironmentFactory environmentFactory, @NonNull Transformation transformation, @NonNull Mode mode) {
		super(environmentFactory, transformation);
		this.mode = mode;
		this.transformationAnalysis = getModelManager().getTransformationAnalysis();
		boolean isLazy = mode == Mode.LAZY;
		this.invocationManager = isLazy ? new LazyInvocationManager() : new IncrementalInvocationManager();
		this.objectManager = isLazy ? new LazyObjectManager((LazyInvocationManager)invocationManager) : new IncrementalObjectManager((IncrementalInvocationManager)invocationManager);
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
	protected @Nullable Object internalExecuteFunctionCallExp(@NonNull OperationCallExp operationCallExp,
			@NonNull Function asFunction, @Nullable Object @NonNull [] boxedSourceAndArgumentValues) {
		Map<@NonNull Operation, Computation.@NonNull Constructor> operation2computationConstructor2 = operation2computationConstructor;
		if (operation2computationConstructor2 == null) {
			operation2computationConstructor = operation2computationConstructor2 = new HashMap<@NonNull Operation, Computation.@NonNull Constructor>();
		}
		Computation.Constructor computationConstructor = operation2computationConstructor2.get(asFunction);
		if (computationConstructor == null) {
			computationConstructor = new AbstractComputationConstructor(idResolver)
			{
				@Override
				public @NonNull Computation newInstance(@Nullable Object @NonNull [] theseValues) {
					Computation.Incremental computation = new AbstractComputation.Incremental()
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

	@Override
	public @Nullable Object internalExecuteMappingCall(final @NonNull MappingCall mappingCall, @NonNull Object @NonNull [] boundValues, final @NonNull EvaluationVisitor undecoratedVisitor) {
		Mapping asMapping = ClassUtil.nonNullState(mappingCall.getReferredMapping());
		if (mode == Mode.LAZY) {
			if (!transformationAnalysis.isHazardous(asMapping)) {
				return super.internalExecuteMappingCall(mappingCall, boundValues, undecoratedVisitor);
			}
		}
		Map<@NonNull Mapping, Invocation.@NonNull Constructor> mapping2invocationConstructor2 = mapping2invocationConstructor;
		if (mapping2invocationConstructor2 == null) {
			mapping2invocationConstructor = mapping2invocationConstructor2 = new HashMap<@NonNull Mapping, Invocation.@NonNull Constructor>();
		}
		Invocation.Constructor invocationConstructor = mapping2invocationConstructor2.get(asMapping);
		if (invocationConstructor == null) {
			invocationConstructor = new AbstractInvocationConstructor(idResolver)
			{
				@Override
				public @NonNull Invocation newInstance(@NonNull Object @NonNull [] theseValues) {
					Invocation.Incremental invocation = new AbstractInvocation.Incremental()
					{
						protected Object returnStatus;

						@Override
						public boolean execute() throws InvocationFailedException {
							currentInvocation = this;
							try {
								returnStatus = QVTiIncrementalExecutor.super.internalExecuteMappingCall(mappingCall, theseValues, undecoratedVisitor);
								return returnStatus == ValueUtil.TRUE_VALUE;
							}
							finally {
								currentInvocation = null;
							}
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

						@Override
						public String toString() {
							return mappingCall.getReferredMapping().getName() + "@" + Integer.toHexString(System.identityHashCode(this));
						}
					};
					return invocation;
				}
			};
			mapping2invocationConstructor2.put(asMapping, invocationConstructor);
		}
		Invocation invocation = invocationConstructor.getFirstInvocation(boundValues);
		if (invocation != null) {
			if (debugInvocations) {
				AbstractTransformer.INVOCATIONS.println("invoke " + invocation);
			}
			invocationManager.invoke(invocation, true);
		}
		return null;
	}

	@Override
	public @Nullable Object internalExecuteNavigationCallExp(@NonNull NavigationCallExp navigationCallExp, @NonNull Property referredProperty, @Nullable Object sourceValue) {
		if (referredProperty.isIsImplicit()) {
			QVTiModelManager modelManager = getModelManager();
			Integer cacheIndex = modelManager.getTransformationAnalysis().getCacheIndex((OppositePropertyCallExp) navigationCallExp);
			if (cacheIndex != null) {
				if (sourceValue != null) {
					Object middleOpposite = modelManager.getUnnavigableOpposite(cacheIndex, sourceValue);
					if (middleOpposite != null) {
						return middleOpposite;
					}
				}
				else {
					throw new InvalidValueException("Failed to evaluate '" + referredProperty + "'", sourceValue, navigationCallExp);
				}
			}
		}
		Mapping asMapping = QVTimperativeUtil.getContainingMapping(navigationCallExp);
		Object ecoreValue;
		if ((asMapping != null) && transformationAnalysis.isHazardousRead(asMapping, navigationCallExp)) {		// null within queries
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
				AbstractTransformer.INVOCATIONS.println("got " + eFeature.getEContainingClass().getName() + "::" + eFeature.getName() + " for " + sourceValue + " = " + ecoreValue);
			}
		}
		else {
			ecoreValue = super.internalExecuteNavigationCallExp(navigationCallExp, referredProperty, sourceValue);
		}
		if (mode != Mode.LAZY) {
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

	@Override
	public void internalExecuteNavigationAssignment(@NonNull NavigationAssignment navigationAssignment, @NonNull Object sourceObject, @Nullable Object ecoreValue, @Nullable Object childKey) {
		super.internalExecuteNavigationAssignment(navigationAssignment, sourceObject, ecoreValue, childKey);
		if (mode == Mode.LAZY) {
			Mapping asMapping = QVTimperativeUtil.getContainingMapping(navigationAssignment);
			assert asMapping != null;
			if (transformationAnalysis.isHazardousWrite(asMapping, navigationAssignment)) {
				Property targetProperty = QVTimperativeUtil.getTargetProperty(navigationAssignment);
				assert targetProperty != null;
				EStructuralFeature eFeature = (EStructuralFeature)targetProperty.getESObject();
				objectManager.assigned(sourceObject, eFeature, ecoreValue, childKey);
			}
		}
		else {
			Property targetProperty = QVTimperativeUtil.getTargetProperty(navigationAssignment);
			assert targetProperty != null;
			EStructuralFeature eFeature = (EStructuralFeature)targetProperty.getESObject();
			Invocation.Incremental currentInvocation2 = currentInvocation;
			assert currentInvocation2 != null;
			objectManager.assigned(currentInvocation2, sourceObject, eFeature, ecoreValue, childKey);
		}
	}

	@Override
	public @Nullable Object internalExecuteRealizedVariable(@NonNull RealizedVariable realizedVariable, @NonNull EvaluationVisitor undecoratedVisitor) {
		Object element = super.internalExecuteRealizedVariable(realizedVariable, undecoratedVisitor);
		if ((element != null) && (mode == Mode.INCREMENTAL)) {
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
}
