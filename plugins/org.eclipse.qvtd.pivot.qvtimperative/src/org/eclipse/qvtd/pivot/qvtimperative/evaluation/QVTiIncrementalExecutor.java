/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/

package org.eclipse.qvtd.pivot.qvtimperative.evaluation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.OppositePropertyCallExp;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.pivot.evaluation.tx.AbstractInvocation;
import org.eclipse.ocl.pivot.evaluation.tx.AbstractTransformer;
import org.eclipse.ocl.pivot.evaluation.tx.InvocationFailedException;
import org.eclipse.ocl.pivot.evaluation.tx.InvocationManager;
import org.eclipse.ocl.pivot.evaluation.tx.ObjectManager;
import org.eclipse.ocl.pivot.evaluation.tx.Transformer;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.internal.evaluation.tx.LazyInvocationManager;
import org.eclipse.ocl.pivot.internal.evaluation.tx.LazyObjectManager;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;

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
	public static int RUN_TIME_EVALUATOR_API_VERSION = Transformer.RUN_TIME_EVALUATOR_API_VERSION_1_1_0_1;

	protected static abstract class InterpretedInvocation extends AbstractInvocation
	{
		protected final @NonNull List<Object> theseValues;
		protected Object returnStatus;
		
		public InterpretedInvocation(@NonNull List<Object> theseValues) {
			this.theseValues = theseValues;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
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
	
	public QVTiIncrementalExecutor(@NonNull QVTiEnvironmentFactory environmentFactory, @NonNull Transformation transformation, @NonNull Mode mode) throws IOException {
		super(environmentFactory, transformation);
		this.mode = mode;
		this.transformationAnalysis = getModelManager().getTransformationAnalysis();
		this.invocationManager = new LazyInvocationManager();
		this.objectManager = new LazyObjectManager(invocationManager, mode != Mode.LAZY);
	}
	
	public QVTiIncrementalExecutor(@NonNull QVTiEnvironmentFactory environmentFactory, @NonNull URI transformationURI, @NonNull Mode mode) throws IOException {
    	this(environmentFactory, QVTbaseUtil.loadTransformation(ImperativeModel.class, environmentFactory, transformationURI, environmentFactory.keepDebug()), mode);
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
				returnStatus = QVTiIncrementalExecutor.super.internalExecuteMappingCall(mappingCall, variable2value, undecoratedVisitor);
				return returnStatus == ValueUtil.TRUE_VALUE;
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
		if ((asMapping != null) && transformationAnalysis.isHazardousRead(asMapping, navigationCallExp)) {		// null within queries
			assert sourceValue != null;
			EStructuralFeature eFeature = (EStructuralFeature)referredProperty.getESObject();
			objectManager.getting(sourceValue, eFeature);
			Object result = super.internalExecuteNavigationCallExp(navigationCallExp, referredProperty, sourceValue);
			AbstractTransformer.INVOCATIONS.println("got " + eFeature.getEContainingClass().getName() + "::" + eFeature.getName() + " for " + sourceValue + " = " + result);
			return result;
		}
		else {
			return super.internalExecuteNavigationCallExp(navigationCallExp, referredProperty, sourceValue);
		}
	}

	@Override
	public void internalExecutePropertyAssignment(@NonNull PropertyAssignment propertyAssignment, @NonNull Object sourceObject, @Nullable Object ecoreValue) {
		super.internalExecutePropertyAssignment(propertyAssignment, sourceObject, ecoreValue);
		if (mode == Mode.LAZY) {
			Mapping asMapping = QVTimperativeUtil.getContainingMapping(propertyAssignment);
			assert asMapping != null;
			if (!transformationAnalysis.isHazardousWrite(asMapping, propertyAssignment)) {
				return;
			}
		}
		Property targetProperty = propertyAssignment.getTargetProperty();
		assert targetProperty != null;
		EObject eFeature = targetProperty.getESObject();
		objectManager.assigned((EObject)sourceObject, (EStructuralFeature) eFeature, ecoreValue);
	}
	
	@Override
	public @Nullable Object internalExecuteRealizedVariable(@NonNull RealizedVariable realizedVariable, @NonNull EvaluationVisitor undecoratedVisitor) {
		Object element = super.internalExecuteRealizedVariable(realizedVariable, undecoratedVisitor);
		if ((element != null) && (mode == Mode.INCREMENTAL)) {
			throw new UnsupportedOperationException();
/*			DomainUsage domainUsage = getEvaluationEnvironment().getUsageFor(realizedVariable);
			ClassStatus classStatus = statusManager.getClassStatus(domainUsage, realizedVariable.getType(), (EObject)element);
			MappingStatus mappingStatus = findMappingStatus();
			assert mappingStatus != null;
			mappingStatus.getOutputs().add(classStatus); */
		}
		return element;
	}
}
