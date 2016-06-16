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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.OppositePropertyCallExp;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtcorebase.NavigationAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcorebase.utilities.QVTcoreBaseUtil;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.GraphStringBuilder;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;
import org.eclipse.qvtd.runtime.evaluation.AbstractInvocation;
import org.eclipse.qvtd.runtime.evaluation.AbstractTransformer;
import org.eclipse.qvtd.runtime.evaluation.InvocationFailedException;
import org.eclipse.qvtd.runtime.evaluation.InvocationManager;
import org.eclipse.qvtd.runtime.evaluation.ObjectManager;
import org.eclipse.qvtd.runtime.evaluation.Transformer;
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

	protected static abstract class InterpretedInvocation extends AbstractInvocation.Incremental
	{
		protected final @NonNull List<Object> theseValues;
		protected Object returnStatus;
		
		public InterpretedInvocation(@NonNull List<Object> theseValues) {
			this.theseValues = theseValues;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @Nullable Object @NonNull [] thoseValues) {
			int iMax = thoseValues.length;
			if (iMax != theseValues.size()) {
				return false;
			}
			for (int i = 0; i < iMax; i++) {
				if (!ClassUtil.safeEquals(theseValues.get(i), thoseValues[i])) {
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
	
	protected final @NonNull Mode mode;
	protected final @NonNull QVTiTransformationAnalysis transformationAnalysis;
	protected final @NonNull InvocationManager invocationManager;
	protected final @NonNull ObjectManager objectManager;
	private @Nullable InterpretedInvocation currentInvocation = null;
	
	public QVTiIncrementalExecutor(@NonNull QVTiEnvironmentFactory environmentFactory, @NonNull Transformation transformation, @NonNull Mode mode) {
		super(environmentFactory, transformation);
		this.mode = mode;
		this.transformationAnalysis = getModelManager().getTransformationAnalysis();
		boolean isLazy = mode == Mode.LAZY;
		IdResolver idResolver = environmentFactory.getIdResolver();
		this.invocationManager = isLazy ? new LazyInvocationManager(idResolver) : new IncrementalInvocationManager(idResolver);
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
	public @Nullable Object internalExecuteMappingCall(final @NonNull MappingCall mappingCall, final @NonNull Map<Variable, Object> variable2value, final @NonNull EvaluationVisitor undecoratedVisitor) {
		if (mode == Mode.LAZY) {
			Mapping asMapping = mappingCall.getReferredMapping();
			assert asMapping != null;
			if (!transformationAnalysis.isHazardous(asMapping)) {
				return QVTiIncrementalExecutor.super.internalExecuteMappingCall(mappingCall, variable2value, undecoratedVisitor);
			}
		}
		List<Object> newBoundValues = new ArrayList<Object>();
		for (MappingCallBinding binding : mappingCall.getBinding()) {
			Variable boundVariable = ClassUtil.nonNullModel(binding.getBoundVariable());
			Object valueOrValues = variable2value.get(boundVariable);
			newBoundValues.add(valueOrValues);
		}
		InterpretedInvocation invocation = new InterpretedInvocation(newBoundValues)
		{
			@Override
			public boolean execute() throws InvocationFailedException, ReflectiveOperationException {
				currentInvocation = this;
				try {
					returnStatus = QVTiIncrementalExecutor.super.internalExecuteMappingCall(mappingCall, variable2value, undecoratedVisitor);
					return returnStatus == ValueUtil.TRUE_VALUE;
				}
				finally {
					currentInvocation = null;
				}
			}

			@Override
			public String toString() {
				return mappingCall.getReferredMapping().getName() + "@" + Integer.toHexString(System.identityHashCode(this));
			}
			
		};
		AbstractTransformer.INVOCATIONS.println("invoke " + invocation);
		try {
			invocationManager.invoke(invocation, true);
		} catch (ReflectiveOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			AbstractTransformer.INVOCATIONS.println("got " + eFeature.getEContainingClass().getName() + "::" + eFeature.getName() + " for " + sourceValue + " = " + ecoreValue);
		}
		else {
			ecoreValue = super.internalExecuteNavigationCallExp(navigationCallExp, referredProperty, sourceValue);
		}
		if (mode != Mode.LAZY) {
			InterpretedInvocation currentInvocation2 = currentInvocation;
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
				Property targetProperty = QVTcoreBaseUtil.getTargetProperty(navigationAssignment);
				assert targetProperty != null;
				EStructuralFeature eFeature = (EStructuralFeature)targetProperty.getESObject();
				objectManager.assigned(sourceObject, eFeature, ecoreValue, childKey);
			}
		}
		else {
			Property targetProperty = QVTcoreBaseUtil.getTargetProperty(navigationAssignment);
			assert targetProperty != null;
			EStructuralFeature eFeature = (EStructuralFeature)targetProperty.getESObject();
			InterpretedInvocation currentInvocation2 = currentInvocation;
			assert currentInvocation2 != null;
			objectManager.assigned(currentInvocation2, sourceObject, eFeature, ecoreValue, childKey);
		}
	}
	
	@Override
	public @Nullable Object internalExecuteRealizedVariable(@NonNull RealizedVariable realizedVariable, @NonNull EvaluationVisitor undecoratedVisitor) {
		Object element = super.internalExecuteRealizedVariable(realizedVariable, undecoratedVisitor);
		if ((element != null) && (mode == Mode.INCREMENTAL)) {
			InterpretedInvocation currentInvocation2 = currentInvocation;
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
