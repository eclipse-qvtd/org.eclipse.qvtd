/*******************************************************************************
 * Copyright (c) 2015, 2019 Willink Transformations and others.
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
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.evaluation.AbstractModelManager;
import org.eclipse.ocl.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.evaluation.ModelManager;
import org.eclipse.ocl.pivot.internal.complete.StandardLibraryInternal;
import org.eclipse.ocl.pivot.internal.evaluation.AbstractExecutor;
import org.eclipse.ocl.pivot.internal.messages.PivotMessagesInternal;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.labels.ILabelGenerator;
import org.eclipse.ocl.pivot.library.AbstractOperation;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.NullValue;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtimperative.AppendParameter;
import org.eclipse.qvtd.pivot.qvtimperative.AppendParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.EntryPoint;
import org.eclipse.qvtd.pivot.qvtimperative.GuardParameter;
import org.eclipse.qvtd.pivot.qvtimperative.GuardParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.LoopParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameter;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.NewStatement;
import org.eclipse.qvtd.pivot.qvtimperative.NewStatementPart;
import org.eclipse.qvtd.pivot.qvtimperative.SetStatement;
import org.eclipse.qvtd.pivot.qvtimperative.SimpleParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.Statement;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiModelsManager.QVTiTypedModelInstance;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;
import org.eclipse.qvtd.runtime.evaluation.AbstractTransformer;
import org.eclipse.qvtd.runtime.evaluation.Connection;
import org.eclipse.qvtd.runtime.evaluation.Interval;
import org.eclipse.qvtd.runtime.evaluation.InvocationFailedException;
import org.eclipse.qvtd.runtime.evaluation.ModeFactory;
import org.eclipse.qvtd.runtime.evaluation.TransformationExecutor;
import org.eclipse.qvtd.runtime.evaluation.TypedModelInstance;

public abstract class BasicQVTiExecutor extends AbstractExecutor implements QVTiExecutor, TransformationExecutor
{
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
			ImperativeTypedModel typedModel = iNewStatement.getReferredTypedModel();
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
	 * WrappedModelManager enables the unhelpful model access API to be observed without infecting the
	 * more streamlined QVTi accesses.
	 */
	private class WrappedModelManager extends AbstractModelManager implements ModelManager.ModelManagerExtension2
	{
		@Override
		public @NonNull Set<@NonNull ? extends Object> get(org.eclipse.ocl.pivot.@NonNull Class type) {
			return modelsManager.get(type);
		}

		@Override
		public @NonNull Iterable<@NonNull Object> getOpposite(@NonNull Property target2sourceProperty, @NonNull Object sourceObject) {
			return modelsManager.getOpposite(target2sourceProperty, sourceObject);
		}
	}

	//	protected final @NonNull Mapping entryPoint;
	protected final @NonNull ImperativeTransformation transformation;
	protected final @NonNull EntryPointsAnalysis entryPointsAnalysis;
	protected final @NonNull EntryPointAnalysis entryPointAnalysis;
	protected final @NonNull ModeFactory modeFactory;
	protected final @NonNull QVTiModelsManager modelsManager;
	protected @Nullable EObject transformationExecution = null;
	private @Nullable WrappedModelManager wrappedModelManager = null;
	protected final boolean debugExceptions = AbstractTransformer.EXCEPTIONS.isActive();
	protected final boolean debugInvocations = AbstractTransformer.INVOCATIONS.isActive();
	private final @NonNull Map<@NonNull Mapping, @NonNull Interval> mapping2interval = new HashMap<>();
	private @Nullable Map<@NonNull Property, @Nullable Property> compileTimeProperty2runtimeProperty = null;
	private @Nullable NewStatementOperation containedNewStatementOperation = null;
	private @Nullable NewStatementOperation notContainedNewStatementOperation = null;

	public BasicQVTiExecutor(@NonNull QVTiEnvironmentFactory environmentFactory, @NonNull EntryPoint entryPoint, @NonNull ModeFactory modeFactory) {
		super(environmentFactory);
		//		this.entryPoint = entryPoint;
		this.transformation = QVTimperativeUtil.getContainingTransformation(entryPoint);
		this.entryPointsAnalysis = environmentFactory.createEntryPointsAnalysis(transformation);
		this.modeFactory = modeFactory;
		entryPointsAnalysis.analyzeTransformation();
		this.entryPointAnalysis = entryPointsAnalysis.getEntryPointAnalysis(entryPoint);
		this.modelsManager = environmentFactory.createModelsManager(entryPointAnalysis);
		for (@NonNull TypedModel typedModel : QVTimperativeUtil.getModelParameters(transformation)) {
			QVTiTypedModelInstance typedModelInstance = createTypedModelInstance((ImperativeTypedModel)typedModel);
			modelsManager.initTypedModelInstance(typedModelInstance);
		}
	}

	@Override
	public @Nullable Resource addInputURI(@NonNull String modelName, @NonNull URI modelURI) {
		ResourceSet resourceSet = environmentFactory.getResourceSet();		// FIXME get package registrations in exteranl RespurcSet
		PivotUtil.initializeLoadOptionsToSupportSelfReferences(resourceSet);
		Resource inputResource = ClassUtil.nonNullState(resourceSet.getResource(modelURI, true));
		TypedModelInstance typedModelInstance = getTypedModelInstance(modelName);
		typedModelInstance.addInputResource(inputResource);
		return inputResource;
	}

	@Override
	public @NonNull Resource addOutputURI(@NonNull String modelName, @NonNull URI modelURI) {
		ResourceSet resourceSet;
		if (PivotUtilInternal.isASURI(modelURI)) {
			resourceSet = environmentFactory.getMetamodelManager().getASResourceSet();	// Need PivotSave to allocate xmi:ids
		}
		else {
			resourceSet = environmentFactory.getResourceSet();
		}
		TypedModelInstance typedModelInstance = getTypedModelInstance(modelName);
		Resource outputResource = ClassUtil.nonNullState(resourceSet.createResource(modelURI));
		typedModelInstance.addOutputResource(outputResource);
		return outputResource;
	}

	@Override
	public void checkModels() throws CoreException {
		StringBuilder s = null;
		for (@NonNull Resource resource : environmentFactory.getResourceSet().getResources()) {
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

	protected @NonNull QVTiTypedModelInstance createTypedModelInstance(@NonNull ImperativeTypedModel typedModel) {
		return new QVTiTypedModelInstance(modelsManager, typedModel);
	}

	@Override
	public void dispose() {
		modelsManager.dispose();
		super.dispose();
	}

	@Override
	public Boolean execute(@Nullable Integer targetTypedModelIndex) {
		modelsManager.analyzeInputResources();
		initializeEvaluationEnvironment(transformation);
		getRootEvaluationEnvironment();
		StandardLibraryInternal standardLibrary = environmentFactory.getStandardLibrary();
		VariableDeclaration ownedContext = QVTbaseUtil.getContextVariable(standardLibrary, transformation);
		//		add(ownedContext, modelsManager.getTransformationInstance(transformation));
		add(ownedContext, getTransformationExecution());
		for (@NonNull ImperativeTypedModel typedModel : QVTimperativeUtil.getOwnedTypedModels(transformation)) {
			if (!typedModel.isIsPrimitive() && !typedModel.isIsThis() && !typedModel.isIsTrace()) {
				ownedContext = QVTbaseUtil.getContextVariable(standardLibrary, typedModel);
				add(ownedContext, modelsManager.getTypedModelInstance(typedModel));
			}
		}
		return executeInternal();
	}

	protected Boolean executeInternal() {
		return (Boolean) getEvaluationVisitor().visit(transformation);
	}

	//	public @NonNull EntryPointsAnalysis getEntryPointsAnalysis() {
	//		return entryPointsAnalysis;
	//	}

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

	/**
	 * Gets the named TypedModel.
	 */
	@Override
	public @Nullable Resource getModel(@NonNull String name) {
		ImperativeTypedModel typedModel = getTypedModel(name);
		return modelsManager.getModel(typedModel);
	}

	@Override
	public @NonNull WrappedModelManager getModelManager() {
		WrappedModelManager wrappedModelManager2 = wrappedModelManager;
		if (wrappedModelManager2 == null) {
			wrappedModelManager2 = wrappedModelManager = new WrappedModelManager();
		}
		return wrappedModelManager2;
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

	public @NonNull ImperativeTypedModel getTypedModel(@NonNull String name) {
		ImperativeTypedModel typedModel = NameUtil.getNameable(QVTimperativeUtil.getOwnedTypedModels(transformation), name);
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
		for (@NonNull TypedModel typedModel : QVTimperativeUtil.getOwnedTypedModels(transformation)) {
			if (targetModelName.equals(typedModel.getName())) {
				return index;
			}
			index++;
		}
		return -1;
	}

	protected @Nullable Object internalExecuteFunctionCallExp(@NonNull OperationCallExp operationCallExp,
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

	@Override
	public @Nullable Object internalExecuteMappingCall(@NonNull MappingCall mappingCall, @NonNull Object @NonNull [] boundValues, @NonNull EvaluationVisitor undecoratedVisitor) {
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

	@Override
	public @Nullable Object internalExecuteOperationCallExp(@NonNull OperationCallExp operationCallExp,
			@Nullable Object @NonNull [] boxedSourceAndArgumentValues) {
		Operation referredOperation = operationCallExp.getReferredOperation();
		if (referredOperation instanceof Function) {
			return internalExecuteFunctionCallExp(operationCallExp, (Function)referredOperation, boxedSourceAndArgumentValues);
		}
		else {
			return super.internalExecuteOperationCallExp(operationCallExp, boxedSourceAndArgumentValues);
		}
	}

	@Override
	public @Nullable Object internalExecuteNewStatement(@NonNull NewStatement iNewStatement, @NonNull EvaluationVisitor undecoratedVisitor) {
		boolean isContained = false;		// FIXME compute containment guarantee
		OCLExpression ownedExpression = iNewStatement.getOwnedExpression();
		List<NewStatementPart> ownedParts = iNewStatement.getOwnedParts();
		if (ownedExpression != null) {
			assert ownedParts.isEmpty();
			Object initValue = ownedExpression.accept(undecoratedVisitor);
			getEvaluationEnvironment().add(iNewStatement, initValue);
			replace(iNewStatement, initValue);
			ImperativeTypedModel typedModel = iNewStatement.getReferredTypedModel();
			assert typedModel != null;
			EObject ecoreValue = (EObject) getIdResolver().ecoreValueOf(null, initValue);
			assert ecoreValue != null;
			modelsManager.getTypedModelInstance(typedModel).add(ecoreValue, isContained);
			return ecoreValue;
		}
		else {
			// Realized variables are in the mapping's target bottom pattern
			// and create elements in the target model. The realized variables
			// are being visited for each binding of variable in the mapping.
			Type type = iNewStatement.getType();
			if (!(type instanceof org.eclipse.ocl.pivot.Class)) {
				return null;
			}
			ImperativeTypedModel typedModel = iNewStatement.getReferredTypedModel();
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
				return null;
			}
			return element;
		}
	}

	@Override
	public void internalExecuteSetStatement(@NonNull SetStatement setStatement, @NonNull Object slotObject, @Nullable Object ecoreValue) {
		Property targetProperty = QVTimperativeUtil.getTargetProperty(setStatement);
		if (setStatement.isIsPartial()) {		// FIXME add Property.addValue() API
			//	assert ValueUtil.isEcore(ecoreValue);
			EStructuralFeature eTarget = (EStructuralFeature)targetProperty.getESObject();
			EStructuralFeature eFeature = eTarget;
			List<Object> eObjects = (List<Object>) ((EObject)slotObject).eGet(eFeature);
			eObjects.add(ecoreValue);
		}
		else {
			targetProperty.initValue(slotObject, ecoreValue);
		}
		Integer cacheIndex = entryPointsAnalysis.getCacheIndex(setStatement);
		if (cacheIndex != null) {
			modelsManager.setUnnavigableOpposite(cacheIndex, slotObject, ecoreValue);
		}
	}

	@Override
	public @Nullable Object internalExecuteTransformation(@NonNull ImperativeTransformation transformation, @NonNull EvaluationVisitor undecoratedVisitor) {
		EntryPoint entryPoint = QVTimperativeUtil.getDefaultEntryPoint(transformation);
		CallExp callExp = PivotFactory.eINSTANCE.createOperationCallExp();		// FIXME TransformationCallExp
		pushEvaluationEnvironment(entryPoint, (TypedElement)callExp);
		try {
			Interval rootInterval = getInvocationManager().getRootInterval();
			mapping2interval.put(entryPoint, rootInterval);
			Iterable<@NonNull TypedModel> checkedTypedModels = QVTimperativeUtil.getCheckedTypedModels(entryPoint);
			for (@NonNull MappingParameter mappingParameter : QVTimperativeUtil.getOwnedMappingParameters(entryPoint)) {
				if (mappingParameter instanceof AppendParameter) {
					org.eclipse.ocl.pivot.Class type = QVTimperativeUtil.getClassType(mappingParameter);
					org.eclipse.ocl.pivot.Package asPackage = PivotUtil.getContainingPackage(type);
					assert asPackage != null;
					TypedModelInstance modelInstance = null;
					for (@NonNull TypedModel asTypedModel : checkedTypedModels) {
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
	public boolean replace(@NonNull TypedElement asVariable, @Nullable Object value, boolean checkType) {
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
		if (saveURI != null) {
			resource.setURI(saveURI);
		}
		((ASResource)resource).setSaveable(true);
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
		ImperativeTypedModel typedModel = getTypedModel(name);
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
