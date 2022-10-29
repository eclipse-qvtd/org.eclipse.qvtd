/*******************************************************************************
 * Copyright (c) 2015, 2022 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.evaluation;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.OppositePropertyCallExp;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.evaluation.AbstractModelManager;
import org.eclipse.ocl.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.evaluation.ModelManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.internal.complete.StandardLibraryInternal;
import org.eclipse.ocl.pivot.internal.evaluation.AbstractExecutor;
import org.eclipse.ocl.pivot.internal.messages.PivotMessagesInternal;
import org.eclipse.ocl.pivot.labels.ILabelGenerator;
import org.eclipse.ocl.pivot.library.AbstractOperation;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.LabelUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.NullValue;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtimperative.AppendParameter;
import org.eclipse.qvtd.pivot.qvtimperative.AppendParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.EntryPoint;
import org.eclipse.qvtd.pivot.qvtimperative.GuardParameter;
import org.eclipse.qvtd.pivot.qvtimperative.GuardParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.LoopParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameter;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.NewStatement;
import org.eclipse.qvtd.pivot.qvtimperative.NewStatementPart;
import org.eclipse.qvtd.pivot.qvtimperative.ObservableStatement;
import org.eclipse.qvtd.pivot.qvtimperative.SetStatement;
import org.eclipse.qvtd.pivot.qvtimperative.SimpleParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.SpeculateStatement;
import org.eclipse.qvtd.pivot.qvtimperative.Statement;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiModelsManager.QVTiTypedModelInstance;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;
import org.eclipse.qvtd.runtime.evaluation.AbstractComputation;
import org.eclipse.qvtd.runtime.evaluation.AbstractInvocation;
import org.eclipse.qvtd.runtime.evaluation.AbstractTransformer;
import org.eclipse.qvtd.runtime.evaluation.Computation;
import org.eclipse.qvtd.runtime.evaluation.Connection;
import org.eclipse.qvtd.runtime.evaluation.Interval;
import org.eclipse.qvtd.runtime.evaluation.Invocation;
import org.eclipse.qvtd.runtime.evaluation.InvocationConstructor;
import org.eclipse.qvtd.runtime.evaluation.InvocationFailedException;
import org.eclipse.qvtd.runtime.evaluation.InvocationManager;
import org.eclipse.qvtd.runtime.evaluation.ModeFactory;
import org.eclipse.qvtd.runtime.evaluation.ObjectManager;
import org.eclipse.qvtd.runtime.evaluation.SlotState;
import org.eclipse.qvtd.runtime.evaluation.SlotState.Speculating;
import org.eclipse.qvtd.runtime.evaluation.TransformationExecutor;
import org.eclipse.qvtd.runtime.evaluation.Transformer;
import org.eclipse.qvtd.runtime.evaluation.TypedModelInstance;
import org.eclipse.qvtd.runtime.internal.evaluation.AbstractComputationConstructor;
import org.eclipse.qvtd.runtime.internal.evaluation.AbstractInvocationConstructor;
import org.eclipse.qvtd.runtime.internal.evaluation.IncrementalInvocationManager;
import org.eclipse.qvtd.runtime.internal.evaluation.IncrementalObjectManager;
import org.eclipse.qvtd.runtime.internal.evaluation.LazyInvocationManager;
import org.eclipse.qvtd.runtime.internal.evaluation.LazyObjectManager;

/**
 * BasicQVTiExecutor provides the functionality for interpreted transformation execution.
 *
 * NB The API is a bit different to the CGed exector for which distict complete Java code exists for each possible entry point.
 * It is therefore possible to delay choosing the entry point until run(). In contrrast this interpreted executor conditions one of the
 * AS ImperativeTransformation EntryPoints which must be selected, albeit as default at construction time.
 */
public class BasicQVTiExecutor extends AbstractExecutor implements QVTiExecutor, TransformationExecutor
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

	public static class InterpretedInvocationConstructor extends AbstractInvocationConstructor.Incremental
	{
		private static @NonNull Interval createInterval(@NonNull InvocationManager invocationManager, Mapping asMapping) {
			Integer firstPass = asMapping.getFirstPass();
			if (firstPass != null) {
				return invocationManager.lazyCreateInterval(firstPass);
			}
			else {
				return invocationManager.createInterval();			// Legacy no-pass-numbers support
			}
		}

		protected final @NonNull BasicQVTiExecutor executor;
		protected final @NonNull MappingCall mappingCall;
		protected final @NonNull EvaluationVisitor undecoratedVisitor;

		public InterpretedInvocationConstructor(@NonNull BasicQVTiExecutor executor, @NonNull Mapping asMapping,
				@NonNull MappingCall mappingCall, @NonNull EvaluationVisitor undecoratedVisitor) {
			super(executor.getInvocationManager(), QVTimperativeUtil.getName(asMapping), createInterval(executor.getInvocationManager(), asMapping));
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

	protected class NewStatementOperation extends AbstractOperation
	{
		private final boolean isContained;

		public NewStatementOperation(boolean isContained) {
			this.isContained = isContained;
		}

		@Override
		public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
			NewStatement iNewStatement = (NewStatement) caller;
			@SuppressWarnings("null")
			org.eclipse.ocl.pivot.@NonNull Class iClass = (org.eclipse.ocl.pivot.@NonNull Class)sourceAndArgumentValues[0];
			EObject element = iClass.createInstance();
			List<NewStatementPart> iNewStatementParts = iNewStatement.getOwnedParts();
			for (int i = 0; i < iNewStatementParts.size(); i++) {
				NewStatementPart iNewStatementPart = iNewStatementParts.get(i);
				Property iProperty = iNewStatementPart.getReferredProperty();
				Object value = sourceAndArgumentValues[i+1];
				EStructuralFeature eFeature = (EStructuralFeature)iProperty.getESObject();
				element.eSet(eFeature, value);
			}
			TypedModel typedModel = iNewStatement.getReferredTypedModel();
			assert typedModel != null;
			QVTiTypedModelInstance typedModelInstance = modelsManager.getTypedModelInstance(typedModel);
			typedModelInstance.add(element, isContained);
			return element;
		}

		@Override
		public @Nullable Object dispatch(@NonNull Executor executor, @NonNull OperationCallExp callExp, @Nullable Object sourceValue) {
			throw new UnsupportedOperationException();
		}
	}

	/**
	 * Model2ModelsManager supports OCL's global single model domain accesses by redirecting to QVTi's multiple models manager..
	 */
	private class Model2ModelsManager extends AbstractModelManager implements ModelManager.ModelManagerExtension2
	{
		@Override
		public @NonNull Set<@NonNull ? extends Object> get(org.eclipse.ocl.pivot.@NonNull Class type) {
			return modelsManager.get(type);
		}

		@Override
		public @Nullable Iterable<@NonNull ? extends Object> getInstances(org.eclipse.ocl.pivot.@NonNull Class type) {
			return modelsManager.get(type);
		}

		@Override
		public @NonNull Iterable<@NonNull Object> getOpposite(@NonNull Property target2sourceProperty, @NonNull Object sourceObject) {
			return modelsManager.getOpposite(target2sourceProperty, sourceObject);
		}
	}

	protected final boolean debugExceptions = AbstractTransformer.EXCEPTIONS.isActive();
	protected final boolean debugInvocations = AbstractTransformer.INVOCATIONS.isActive();
	protected final @NonNull EntryPoint entryPoint;
	protected final @NonNull ModeFactory modeFactory;
	protected final @NonNull ImperativeTransformation transformation;
	protected final @NonNull EntryPointsAnalysis entryPointsAnalysis;
	protected final @NonNull EntryPointAnalysis entryPointAnalysis;
	protected final @NonNull InvocationManager invocationManager;
	protected final @NonNull ObjectManager objectManager;
	protected final @NonNull QVTiModelsManager modelsManager;
	private final @NonNull Map<@NonNull Mapping, @NonNull Interval> mapping2interval = new HashMap<>();
	private @Nullable EObject transformationExecution = null;
	private @Nullable ModelManager model2ModelsManager = null;
	private @Nullable Map<@NonNull Property, @Nullable Property> compileTimeProperty2runtimeProperty = null;
	private @Nullable NewStatementOperation containedNewStatementOperation = null;
	private @Nullable NewStatementOperation notContainedNewStatementOperation = null;
	private Invocation.@Nullable Incremental currentInvocation = null;
	private @Nullable Map<@NonNull Mapping, @NonNull InvocationConstructor> mapping2invocationConstructor = null;
	private @Nullable Map<@NonNull Operation, Computation.@NonNull Constructor> operation2computationConstructor = null;

	public BasicQVTiExecutor(@NonNull QVTiEnvironmentFactory environmentFactory, @NonNull ImperativeTransformation transformation, @NonNull ModeFactory modeFactory) {
		this(environmentFactory, QVTimperativeUtil.getDefaultEntryPoint(transformation), modeFactory);
	}

	public BasicQVTiExecutor(@NonNull QVTiEnvironmentFactory environmentFactory, @NonNull EntryPoint entryPoint, @NonNull ModeFactory modeFactory) {
		super(environmentFactory);
		this.entryPoint = entryPoint;
		this.modeFactory = modeFactory;
		this.transformation = QVTimperativeUtil.getContainingTransformation(entryPoint);
		this.entryPointsAnalysis = environmentFactory.createEntryPointsAnalysis(transformation);
		entryPointsAnalysis.analyzeTransformation();
		this.entryPointAnalysis = entryPointsAnalysis.getEntryPointAnalysis(entryPoint);
		if (modeFactory.isLazy()) {
			this.invocationManager = new LazyInvocationManager(this);
			this.objectManager = new LazyObjectManager((LazyInvocationManager)invocationManager);
		}
		else {
			this.invocationManager = new IncrementalInvocationManager(this);
			this.objectManager = new IncrementalObjectManager((IncrementalInvocationManager)invocationManager);
		}
		objectManager.addSpeculatedEAttributes(entryPointAnalysis.getSpeculatedEAttributes());
		this.modelsManager = environmentFactory.createModelsManager(entryPointAnalysis);
		Interval rootInterval = invocationManager.getRootInterval();
		//		ModeFactory modeFactory = ModeFactory.NON_INCREMENTAL;// getModeFactory();
		for (@NonNull TypedModelInstance model : modelsManager.getTypedModelInstances()) {
			model.initConnections(rootInterval, modeFactory);
		}
	}

	@Override
	public @Nullable Resource addInputURI(@NonNull String modelName, @NonNull URI modelURI) {
		return modelsManager.addInputURI(modelName, modelURI);
	}

	@Override
	public @NonNull Resource addOutputURI(@NonNull String modelName, @NonNull URI modelURI) {
		return modelsManager.addOutputURI(modelName, modelURI);
	}

	@Override
	public void checkModels() throws CoreException {
		StringBuilder s = null;
		ResourceSet resourceSet = environmentFactory.getResourceSet();
		for (Resource resource : resourceSet.getResources()) {
			String messages = PivotUtil.formatResourceDiagnostics(resource.getErrors(), "Errors in " + resource.getURI().toString(), "\n");
			if (messages != null) {
				if (s == null) {
					s = new StringBuilder();
				}
				s.append(messages);
			}
		}
		if (s != null) {
			IStatus status = new Status(IStatus.ERROR, "getPluginId()", s.toString());
			throw new CoreException(status);
		}
	}

	@Override
	protected EvaluationVisitor.@NonNull EvaluationVisitorExtension createEvaluationVisitor() {
		IQVTiEvaluationVisitor visitor = new QVTiEvaluationVisitor(this);
		if (environmentFactory.isEvaluationTracingEnabled()) {
			// decorate the evaluation visitor with tracing support
			visitor = new QVTiTracingEvaluationVisitor(visitor);
			//	        ((QVTiTracingEvaluationVisitor)visitor).setVerboseLevel(QVTiTracingEvaluationVisitor.VERBOSE_LEVEL_HIGH);
		}
		return visitor;
	}

	public @NonNull String createGraph(@NonNull GraphStringBuilder s) {
		Execution2GraphVisitor execution2GraphVisitor = new Execution2GraphVisitor(s);
		invocationManager.accept(execution2GraphVisitor);
		objectManager.accept(execution2GraphVisitor);
		String string = execution2GraphVisitor.toString();
		assert string != null;
		return string;
	}

	/**
	 * Return (and if necessary create) the cached NewStatement creation.
	 * @param isContained
	 */
	protected @NonNull EObject createInstance(@NonNull NewStatement iNewStatement, @NonNull EvaluationVisitor undecoratedVisitor, boolean isContained) {
		NewStatementOperation newStatementOperation;
		if (isContained) {
			newStatementOperation = containedNewStatementOperation;
			if (newStatementOperation == null) {
				newStatementOperation = containedNewStatementOperation = new NewStatementOperation(true);
			}
		}
		else {
			newStatementOperation = notContainedNewStatementOperation;
			if (newStatementOperation == null) {
				newStatementOperation = notContainedNewStatementOperation = new NewStatementOperation(false);
			}
		}
		List<NewStatementPart> iNewStatementParts = iNewStatement.getOwnedParts();
		int iMax = iNewStatementParts.size();
		@Nullable Object @NonNull [] sourceAndArgumentValues = new @Nullable Object[iMax+1];
		sourceAndArgumentValues[0] = iNewStatement.getType();
		for (int i = 0 ; i < iMax; i++) {
			NewStatementPart iNewStatementPart = iNewStatementParts.get(i);
			assert iNewStatementPart != null;
			sourceAndArgumentValues[i+1] = iNewStatementPart.getOwnedExpression().accept(undecoratedVisitor);
		}
		@NonNull EObject element = (@NonNull EObject) getCachedEvaluationResult(newStatementOperation, iNewStatement, sourceAndArgumentValues);
		return element;
	}

	@Override
	protected EvaluationEnvironment.@NonNull EvaluationEnvironmentExtension createNestedEvaluationEnvironment(EvaluationEnvironment.@NonNull EvaluationEnvironmentExtension evaluationEnvironment, @NonNull NamedElement executableObject, @Nullable Object caller) {
		if (evaluationEnvironment instanceof QVTiEvaluationEnvironment) {
			return new QVTiNestedEvaluationEnvironment((QVTiEvaluationEnvironment) evaluationEnvironment, executableObject, caller);
		}
		else{
			return super.createNestedEvaluationEnvironment(evaluationEnvironment, executableObject, caller);
		}
	}

	@Override
	protected EvaluationEnvironment.@NonNull EvaluationEnvironmentExtension createRootEvaluationEnvironment(@NonNull NamedElement executableObject) {
		if (executableObject instanceof Transformation) {
			return new QVTiRootEvaluationEnvironment(this, (Transformation) executableObject);
		}
		else {
			return super.createRootEvaluationEnvironment(executableObject);
		}
	}

	@Override
	public void dispose() {
		modelsManager.dispose();
		super.dispose();
	}

	@Override
	public Boolean execute() {
		modelsManager.analyzeInputResources();
		initializeEvaluationEnvironment(transformation);
		getRootEvaluationEnvironment();
		StandardLibraryInternal standardLibrary = environmentFactory.getStandardLibrary();
		VariableDeclaration ownedContext = QVTbaseUtil.getContextVariable(standardLibrary, transformation);
		//		add(ownedContext, modelsManager.getTransformationInstance(transformation));
		add(ownedContext, getTransformationExecution());
		for (@NonNull TypedModel typedModel : QVTimperativeUtil.getModelParameters(transformation)) {
			if (!typedModel.isIsPrimitive() && !typedModel.isIsThis() && !typedModel.isIsTrace()) {
				ownedContext = QVTbaseUtil.getContextParameter(standardLibrary, typedModel);
				add(ownedContext, modelsManager.getTypedModelInstance(typedModel));
			}
		}
		return executeInternal();
	}

	@Override
	public Boolean execute(@Nullable String targetName) throws Exception {
		if (targetName == null) {
			return execute();
		}
		throw new UnsupportedOperationException("targetName must be specified using initTargetName");
	}

	protected Boolean executeInternal() {
		return (Boolean) getEvaluationVisitor().visit(transformation);
	}

	@Override
	public @NonNull QVTiEnvironmentFactory getEnvironmentFactory() {
		return (QVTiEnvironmentFactory) super.getEnvironmentFactory();
	}

	@Override
	public @NonNull QVTiEvaluationEnvironment getEvaluationEnvironment() {
		return (QVTiEvaluationEnvironment) super.getEvaluationEnvironment();
	}

	@Override
	public @NonNull Interval getInterval(@NonNull Mapping asMapping) {
		Interval interval = mapping2interval.get(asMapping);
		return ClassUtil.nonNullState(interval);
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

	/**
	 * Gets the named TypedModel.
	 */
	@Override
	public @Nullable Resource getModel(@NonNull String name) {
		TypedModel typedModel = getTypedModel(name);
		return modelsManager.getModel(typedModel);
	}

	@Override
	public @NonNull ModelManager getModelManager() {
		ModelManager model2ModelsManager2 = model2ModelsManager;
		if (model2ModelsManager2 == null) {
			model2ModelsManager2 = model2ModelsManager = new Model2ModelsManager();
		}
		return model2ModelsManager2;
	}

	@Override
	public @NonNull QVTiModelsManager getModelsManager() {
		return modelsManager;
	}

	//	public @NonNull Collection<@NonNull EObject> getRootEObjects(@NonNull String name) {
	//		return modelsManager.getRootEObjects(getTypedModel(name));
	//	}

	public @NonNull ImperativeTransformation getTransformation() {
		return transformation;
	}

	@Override
	public @Nullable EObject getTransformationExecution() {
		if (transformationExecution == null) {
			org.eclipse.ocl.pivot.Class runtimeContextClass = QVTimperativeUtil.getRuntimeContextClass(transformation);
			EObject contextEObject = runtimeContextClass.getESObject();
			if (contextEObject instanceof EClass) {
				EClass contextEClass = (EClass) contextEObject;
				EFactory eFactory = contextEClass.getEPackage().getEFactoryInstance();
				transformationExecution = eFactory.create(contextEClass);
			}
			Map<@NonNull Property, @Nullable Property> compileTimeProperty2runtimeProperty2 = compileTimeProperty2runtimeProperty = new HashMap<>();
			org.eclipse.ocl.pivot.Class compileTimeContextClass = QVTimperativeUtil.getCompileTimeContextClass(transformation);
			for (@NonNull Property compileTimeProperty : PivotUtil.getOwnedProperties(compileTimeContextClass)) {
				if (!compileTimeProperty.isIsDerived() && !compileTimeProperty.isIsTransient() && !compileTimeProperty.isIsVolatile() && (compileTimeProperty.getOpposite() == null)) {
					Property runtimeProperty = NameUtil.getNameable(runtimeContextClass.getOwnedProperties(), compileTimeProperty.getName());
					compileTimeProperty2runtimeProperty2.put(compileTimeProperty, runtimeProperty);
				}
			}
		}
		return transformationExecution;
	}

	protected @Nullable Property getTransformationExecutionProperty(@NonNull Property compileTimeProperty) {
		return compileTimeProperty2runtimeProperty != null ? compileTimeProperty2runtimeProperty.get(compileTimeProperty) : null;
	}

	@Override
	public @NonNull Transformer getTransformer() {
		throw new UnsupportedOperationException("Transformer API not implemented by interpreted executor");
	}

	public @NonNull TypedModel getTypedModel(@NonNull String name) {
		TypedModel typedModel = NameUtil.getNameable(QVTimperativeUtil.getModelParameters(transformation), name);
		if (typedModel == null) {
			//			if (QVTbaseUtil.TRACE_TYPED_MODEL_NAME.equals(name)) {
			//				typedModel = NameUtil.getNameable(QVTimperativeUtil.getOwnedTypedModels(transformation), QVTscheduleConstants.MIDDLE_DOMAIN_NAME);		// FIXME unify name
			//			}
			//			if (typedModel == null) {
			throw new IllegalStateException("Unknown TypedModel '" + name + "'");
			//			}
		}
		return typedModel;
	}

	@Override
	public int getTypedModelIndex(@NonNull String targetModelName) {
		int index = 0;
		for (@NonNull TypedModel typedModel : QVTimperativeUtil.getModelParameters(transformation)) {
			if (targetModelName.equals(typedModel.getName())) {
				return index;
			}
			index++;
		}
		return -1;
	}

	@Override
	public @NonNull TypedModelInstance getTypedModelInstance(@NonNull String modelName) {
		return modelsManager.getTypedModelInstance(modelName);
	}

	@Override
	public @Nullable Object internalExecuteFunctionCallExp(@NonNull OperationCallExp operationCallExp,
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
						protected Object result = internalExecuteFunctionCallExpNested(operationCallExp, asFunction, theseValues);

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

	protected @Nullable Object internalExecuteFunctionCallExpNested(@NonNull OperationCallExp operationCallExp,
			@NonNull Function referredFunction, @Nullable Object @NonNull [] boxedSourceAndArgumentValues) {
		//		PivotUtil.checkExpression(expressionInOCL);
		EvaluationEnvironment nestedEvaluationEnvironment = pushEvaluationEnvironment(referredFunction, (TypedElement)operationCallExp);
		//		nestedEvaluationEnvironment.add(ClassUtil.nonNullModel(expressionInOCL.getOwnedContext()), sourceValue);
		List<Parameter> parameters = referredFunction.getOwnedParameters();
		if (!parameters.isEmpty()) {
			for (int i = 0; i < parameters.size(); i++) {
				Object value = boxedSourceAndArgumentValues[i+1];
				nestedEvaluationEnvironment.add(ClassUtil.nonNullModel(parameters.get(i)), value);
			}
		}
		try {
			OCLExpression bodyExpression = referredFunction.getQueryExpression();
			assert bodyExpression != null;
			Object result = evaluate(bodyExpression);
			assert !(result instanceof NullValue);
			return result;
		}
		catch (InvalidValueException e) {
			throw e;
		}
		catch (Exception e) {
			// This is a backstop. Library operations should catch their own exceptions
			//  and produce a better reason as a result.
			throw new InvalidValueException(e, PivotMessagesInternal.FailedToEvaluate_ERROR_, referredFunction, ILabelGenerator.Registry.INSTANCE.labelFor(null), operationCallExp);
		}
		finally {
			popEvaluationEnvironment();
		}
	}

	private Object internalExecuteInvocation(@NonNull InterpretedInvocation invocation, @NonNull Object @NonNull [] theseValues, @NonNull MappingCall mappingCall, @NonNull EvaluationVisitor undecoratedVisitor) {
		currentInvocation = invocation;
		try {
			return internalExecuteMappingCallInternal(mappingCall, theseValues, undecoratedVisitor);
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
				return internalExecuteMappingCallInternal(mappingCall, boundValues, undecoratedVisitor);
			}
		}
		InvocationConstructor invocationConstructor = getInvocationConstructor(mappingCall, undecoratedVisitor);
		invocationConstructor.invoke(boundValues);
		return null;
	}

	protected @Nullable Object internalExecuteMappingCallInternal(@NonNull MappingCall mappingCall, @NonNull Object @NonNull [] boundValues, @NonNull EvaluationVisitor undecoratedVisitor) {
		Mapping calledMapping = mappingCall.getReferredMapping();
		if (calledMapping != null) {
			pushEvaluationEnvironment(calledMapping, mappingCall);
			try {
				int index = 0;
				for (@NonNull MappingParameterBinding binding : QVTimperativeUtil.getOwnedMappingParameterBindings(mappingCall)) {
					MappingParameter boundVariable = ClassUtil.nonNullState(binding.getBoundVariable());
					Object boundValue = boundValues[index++];
					if (binding instanceof AppendParameterBinding) {	// FIXME visit the bindings
						if (!replace(boundVariable, boundValue, false)) {
							return false;
						}
					}
					else if (binding instanceof GuardParameterBinding) {
						//						if (boundValue instanceof Connection) {
						//							boundValue = ((Connection)boundValue).
						//						}
						if (!replace(boundVariable, boundValue, ((GuardParameterBinding)binding).isIsCheck())) {
							return false;
						}
					}
					else if (binding instanceof LoopParameterBinding) {
						if (!replace(boundVariable, boundValue, ((LoopParameterBinding)binding).isIsCheck())) {
							return false;
						}
					}
					else if (binding instanceof SimpleParameterBinding) {
						if (!replace(boundVariable, boundValue, ((SimpleParameterBinding)binding).isIsCheck())) {
							return false;
						}
					}
					else {
						assert false;
					}
				}
				calledMapping.accept(undecoratedVisitor);
			}
			finally {
				popEvaluationEnvironment();
			}
		}
		return true;
	}

	@Override
	public @Nullable Object internalExecuteMapping(@NonNull Mapping mapping, @NonNull EvaluationVisitor undecoratedVisitor) {
		boolean success = false;
		boolean isSpeculation = false;
		try {
			for (Statement statement : mapping.getOwnedStatements()) {
				Object result = statement.accept(undecoratedVisitor);
				if (result != Boolean.TRUE) {
					return success;
				}
			}
			success = true;
			return success;
		}
		catch (InvocationFailedException e) {
			isSpeculation = e.isSpeculation;
			throw e;
		}
		catch (Throwable e) {
			// Mapping failures are just mappings that never happened.
			if (debugExceptions) {
				AbstractTransformer.EXCEPTIONS.println("Execution failure in " + mapping.getName() + " : " + e);
			}
			throw e;
			//			return success;
		}
		finally {
			if (!isSpeculation) {
				for (@NonNull MappingParameter mappingParameter : QVTimperativeUtil.getOwnedMappingParameters(mapping)) {
					if (mappingParameter instanceof GuardParameter) {
						Property successProperty = ((GuardParameter)mappingParameter).getSuccessProperty();
						if (successProperty != null) {
							Object guardVariable = getValueOf(mappingParameter);
							if (guardVariable != null) {
								successProperty.initValue(guardVariable, success);
							}
						}
					}
				}
			}
		}
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
			ecoreValue = internalExecuteNavigationCallExpInternal(navigationCallExp, referredProperty, sourceValue);
			if (debugInvocations) {
				AbstractTransformer.INVOCATIONS.println("got " + eFeature.getEContainingClass().getName() + "::" + eFeature.getName() + " for " + LabelUtil.getLabel(sourceValue) + " = " + LabelUtil.getLabel(ecoreValue));
			}
		}
		else {
			ecoreValue = internalExecuteNavigationCallExpInternal(navigationCallExp, referredProperty, sourceValue);
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

	protected @Nullable Object internalExecuteNavigationCallExpInternal(@NonNull NavigationCallExp navigationCallExp,
			@NonNull Property referredProperty, @Nullable Object sourceValue) {
		return super.internalExecuteNavigationCallExp(navigationCallExp, referredProperty, sourceValue);
	}

	@Override
	public @Nullable Object internalExecuteNewStatement(@NonNull NewStatement iNewStatement, @NonNull EvaluationVisitor undecoratedVisitor) {

		boolean isContained = false;		// FIXME compute containment guarantee
		OCLExpression ownedExpression = iNewStatement.getOwnedExpression();
		List<NewStatementPart> ownedParts = iNewStatement.getOwnedParts();
		Object result;
		if (ownedExpression != null) {
			assert ownedParts.isEmpty();
			Object initValue = ownedExpression.accept(undecoratedVisitor);
			getEvaluationEnvironment().add(iNewStatement, initValue);
			replace(iNewStatement, initValue);
			TypedModel typedModel = iNewStatement.getReferredTypedModel();
			assert typedModel != null;
			EObject ecoreValue = (EObject) getIdResolver().ecoreValueOf(null, initValue);
			assert ecoreValue != null;
			modelsManager.getTypedModelInstance(typedModel).add(ecoreValue, isContained);
			result = ecoreValue;
		}
		else {
			// Realized variables are in the mapping's target bottom pattern
			// and create elements in the target model. The realized variables
			// are being visited for each binding of variable in the mapping.
			Type type = iNewStatement.getType();
			if (!(type instanceof org.eclipse.ocl.pivot.Class)) {
				result = null;
			}
			else {
				TypedModel typedModel = iNewStatement.getReferredTypedModel();
				assert typedModel != null;
				org.eclipse.ocl.pivot.Class iClass = (org.eclipse.ocl.pivot.Class)type;
				if (iClass.isIsAbstract()) {
					Mapping asMapping = QVTimperativeUtil.getContainingMapping(iNewStatement);
					throw new IllegalStateException("Attempted to create instance of abstract '" + iClass.getName() + "' in " + asMapping.getName());
				}
				EObject element;
				if (ownedParts.isEmpty()) {
					element = iClass.createInstance();
					QVTiTypedModelInstance typedModelInstance = modelsManager.getTypedModelInstance(typedModel);
					typedModelInstance.add(element, isContained);
				}
				else {
					element = createInstance(iNewStatement, undecoratedVisitor, isContained);
				}
				// Add the realize variable binding to the environment
				if (!replace(iNewStatement, element, false)) {
					result = null;
				}
				else {
					result =element;
				}
			}
		}
		if ((result != null) && modeFactory.isIncremental()) {
			Invocation.Incremental currentInvocation2 = currentInvocation;
			assert currentInvocation2 != null;
			objectManager.created(currentInvocation2, result);
			/*			DomainUsage domainUsage = getEvaluationEnvironment().getUsageFor(realizedVariable);
			ClassStatus classStatus = statusManager.getClassStatus(domainUsage, realizedVariable.getType(), (EObject)element);
			MappingStatus mappingStatus = findMappingStatus();
			assert mappingStatus != null;
			mappingStatus.getOutputs().add(classStatus); */
		}
		return result;
	}

	@Override
	public void internalExecuteSetStatement(@NonNull SetStatement setStatement, @NonNull Object sourceObject, @Nullable Object ecoreValue) {
		Property targetProperty = QVTimperativeUtil.getTargetProperty(setStatement);
		boolean isPartial = setStatement.isIsPartial();
		if (isPartial) {		// FIXME add Property.addValue() API
			//	assert ValueUtil.isEcore(ecoreValue);
			EStructuralFeature eTarget = (EStructuralFeature)targetProperty.getESObject();
			EStructuralFeature eFeature = eTarget;
			List<Object> eObjects = (List<Object>) ((EObject)sourceObject).eGet(eFeature);
			eObjects.add(ecoreValue);
		}
		else {
			targetProperty.initValue(sourceObject, ecoreValue);
		}
		Integer cacheIndex = entryPointsAnalysis.getCacheIndex(setStatement);
		if (cacheIndex != null) {
			modelsManager.setUnnavigableOpposite(cacheIndex, sourceObject, ecoreValue);
		}
		if (modeFactory.isLazy()) {
			if (setStatement.isIsNotify()) {
				assert targetProperty != null;
				EStructuralFeature eFeature = (EStructuralFeature)targetProperty.getESObject();
				objectManager.assigned(sourceObject, eFeature, ecoreValue, isPartial);
			}
		}
		else {
			assert targetProperty != null;
			EStructuralFeature eFeature = (EStructuralFeature)targetProperty.getESObject();
			Invocation.Incremental currentInvocation2 = currentInvocation;
			assert currentInvocation2 != null;
			objectManager.assigned(currentInvocation2, sourceObject, eFeature, ecoreValue, isPartial);
		}
	}

	@Override
	public @Nullable Boolean internalExecuteSpeculateStatement(@NonNull SpeculateStatement speculateStatement) {
		Mapping iMapping = QVTimperativeUtil.getContainingMapping(speculateStatement);
		for (@NonNull MappingParameter iMappingParameter : QVTimperativeUtil.getOwnedMappingParameters(iMapping)) {
			if (iMappingParameter instanceof GuardParameter) {
				Object thisParameter = getValueOf(iMappingParameter);
				assert thisParameter != null;
				Property successProperty = ((GuardParameter)iMappingParameter).getSuccessProperty();
				if (successProperty != null) {	// Should be exactly one, but may be nested loop handles a trace merge
					EAttribute eAttribute = (EAttribute) successProperty.getESObject();
					assert eAttribute != null;
					Speculating outputSpeculatingSlotState = objectManager.getSpeculatingSlotState(thisParameter, eAttribute);
					Boolean outputStatus = outputSpeculatingSlotState.getSpeculationStatus();
					if (outputStatus != Boolean.TRUE) {
						if (outputStatus == Boolean.FALSE) {
							outputSpeculatingSlotState.setSpeculated(false);
							//	outputSpeculatingSlotState.assigned(thisParameter, eAttribute, Boolean.FALSE, false);
							return Boolean.FALSE;
						}
						boolean needsSpeculation = false;
						for (@NonNull OCLExpression iExpression : QVTimperativeUtil.getOwnedExpressions(speculateStatement)) {
							if (iExpression instanceof PropertyCallExp) {
								PropertyCallExp iCallExpression = (PropertyCallExp)iExpression;
								OCLExpression sourceExpression = QVTimperativeUtil.getOwnedSource(iCallExpression);
								Object sourceObject = evaluate(sourceExpression);
								if (sourceObject != null) {
									Property accessProperty = QVTimperativeUtil.getReferredProperty(iCallExpression);
									EAttribute accessAttribute = (EAttribute) accessProperty.getESObject();
									assert accessAttribute != null;
									//									SlotState.Speculating inputSpeculatingSlotState = getSpeculatingSlotState(objectManager, outputSpeculatingSlotState, sourceObject, accessAttribute);
									SlotState.Speculating inputSpeculatingSlotState = objectManager.getSpeculatingSlotState(sourceObject, accessAttribute);
									Boolean inputStatus = inputSpeculatingSlotState.getSpeculationStatus();
									if (inputStatus != Boolean.TRUE) {
										if (inputStatus == Boolean.FALSE) {
											outputSpeculatingSlotState.setSpeculated(false);
											//	outputSpeculatingSlotState.assigned(thisParameter, eAttribute, Boolean.FALSE, false);
											return Boolean.FALSE;
										}
										needsSpeculation = true;
										outputSpeculatingSlotState.addInput(inputSpeculatingSlotState);
									}
								}
								else if (sourceExpression.isIsRequired()) {
									throw new InvalidValueException("null expression for speculated property source");
								}
							}
						}
						if (needsSpeculation) {
							throw new InvocationFailedException(outputSpeculatingSlotState, true);
						}
					}
					//	else {
					//	outputSpeculatingSlotState.setStatus(Boolean.TRUE);	// redundant ??
					//	outputSpeculatingSlotState.assigned(thisParameter, eAttribute, Boolean.TRUE, false);
					//	}
				}
			}
		}
		return Boolean.TRUE;
	}

	@Override
	public @Nullable Object internalExecuteTransformation(@NonNull ImperativeTransformation transformation, @NonNull EvaluationVisitor undecoratedVisitor) {
		CallExp callExp = PivotFactory.eINSTANCE.createOperationCallExp();		// FIXME TransformationCallExp
		pushEvaluationEnvironment(entryPoint, (TypedElement)callExp);
		try {
			Interval rootInterval = getInvocationManager().getRootInterval();
			mapping2interval.put(entryPoint, rootInterval);
			Iterable<@NonNull TypedModel> inputTypedModels = QVTimperativeUtil.getInputTypedModels(entryPoint);
			for (@NonNull MappingParameter mappingParameter : QVTimperativeUtil.getOwnedMappingParameters(entryPoint)) {
				if (mappingParameter instanceof AppendParameter) {
					org.eclipse.ocl.pivot.Class type = QVTimperativeUtil.getClassType(mappingParameter);
					org.eclipse.ocl.pivot.Package asPackage = PivotUtil.getContainingPackage(type);
					assert asPackage != null;
					TypedModelInstance modelInstance = null;
					for (@NonNull TypedModel asTypedModel : inputTypedModels) {
						if (asTypedModel.getUsedPackage().contains(asPackage)) {
							assert modelInstance == null;
							modelInstance = modelsManager.getTypedModelInstance(asTypedModel);
							assert modelInstance != null;
						}
					}
					Connection connection = rootInterval.createConnection(QVTimperativeUtil.getName(mappingParameter), type.getTypeId(), false, ModeFactory.NON_INCREMENTAL);
					if (modelInstance != null) {
						Iterable<@NonNull ? extends Object> objectsOfKind = modelInstance.getObjectsOfKind(type);
						for (@NonNull Object object : objectsOfKind) {
							connection.appendElement(object);
						}
					}
					getEvaluationEnvironment().add(mappingParameter, connection);
				}
			}
			entryPoint.accept(undecoratedVisitor);			// Use an outer InvocationConstructor?
			getInvocationManager().flush();
		}
		finally {
			popEvaluationEnvironment();
		}
		return true;
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
	public void replace(@NonNull TypedElement asVariable, @Nullable Object value) {
		if (value == null) {
			if (asVariable.isIsRequired()) {
				throw new InvalidValueException("Attempted to assign null value to " + asVariable);
			}
		}
		super.replace(asVariable, value);
	}

	@Override
	public boolean replace(@NonNull VariableDeclaration asVariable, @Nullable Object value, boolean checkType) {
		if (value == null) {
			if (asVariable.isIsRequired()) {
				//				throw new InvalidValueException("Attempted to assign null value to " + asVariable);
				return false;
			}
		}
		else if (checkType) {
			Type valueType = getIdResolver().getDynamicTypeOf(value);
			//			Type valueType2 = getIdResolver().getStaticTypeOf(value);
			//			Type valueType = valueType1;
			Type variableType = ClassUtil.nonNullState(asVariable.getType());
			if (!valueType.conformsTo(getStandardLibrary(), variableType)) {
				//				throw new InvalidValueException("Attempted to assign incompatible value to " + asVariable);
				return false;
			}
		}
		super.replace(asVariable, value);
		return true;
	}

	@Override
	public void saveModels(@Nullable Map<?, ?> saveOptions) throws IOException {
		modelsManager.saveModels(saveOptions);
	}

	@Override
	public void saveOutput(@NonNull String modelName, @NonNull URI uri) {
		Resource outputResource = ClassUtil.nonNullState(environmentFactory.getResourceSet().createResource(uri));
		TypedModelInstance typedModelInstance = getTypedModelInstance(modelName);
		typedModelInstance.addOutputResource(outputResource);
	}

	public void saveTransformation(URI saveURI, Map<?,?> options) throws IOException {
		XMLResource resource = (XMLResource) transformation.eResource();
		//    	new AS2ID().assignIds(resource.getResourceSet());
		((ASResource)resource).setSaveable(true);
		if (saveURI != null) {
			resource.setURI(saveURI);
		}
		resource.save(options);
	}

	@Override
	public void setContextualProperty(@NonNull String propertyName, Object value) {
		EObject transformationExecution = getTransformationExecution();
		if (transformationExecution == null) {
			throw new IllegalArgumentException("No contextual instance available");
		}
		EClass txEClass = transformationExecution.eClass();
		EStructuralFeature eStructuralFeature = txEClass.getEStructuralFeature(propertyName);
		if (eStructuralFeature == null) {
			throw new IllegalArgumentException("No '" + propertyName + "' contextual property in '" + txEClass.getName());
		}
		transformationExecution.eSet(eStructuralFeature, value);
	}

	public void setExternalURI(@NonNull String name, @NonNull URI modelURI) throws IOException {
		TypedModel typedModel = getTypedModel(name);
		Resource resource = modelsManager.getModel(typedModel);
		if (resource != null) {
			for (EObject eObject : resource.getContents()) {
				if (eObject instanceof Model) {
					((Model)eObject).setExternalURI(modelURI.toString());
				}
			}
		}
	}

	@Override
	public void setSuppressFailureDiagnosis(boolean suppressFailureDiagnosis) {}
}
