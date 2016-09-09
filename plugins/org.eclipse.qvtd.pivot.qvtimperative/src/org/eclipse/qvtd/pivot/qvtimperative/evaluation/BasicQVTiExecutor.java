/*******************************************************************************
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.evaluation;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.internal.complete.StandardLibraryInternal;
import org.eclipse.ocl.pivot.internal.evaluation.AbstractExecutor;
import org.eclipse.ocl.pivot.internal.messages.PivotMessagesInternal;
import org.eclipse.ocl.pivot.labels.ILabelGenerator;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.CollectionValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.NullValue;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtimperative.Assignment;
import org.eclipse.qvtd.pivot.qvtimperative.BottomPattern;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionVariable;
import org.eclipse.qvtd.pivot.qvtimperative.GuardPattern;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeDomain;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtimperative.NewStatement;
import org.eclipse.qvtd.pivot.qvtimperative.SetStatement;
import org.eclipse.qvtd.pivot.qvtimperative.Statement;
import org.eclipse.qvtd.pivot.qvtimperative.VariableAssignment;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;
import org.eclipse.qvtd.runtime.evaluation.AbstractTransformer;
import org.eclipse.qvtd.runtime.evaluation.InvocationFailedException;

public class BasicQVTiExecutor extends AbstractExecutor implements QVTiExecutor
{
	protected final @NonNull Transformation transformation;
	private @Nullable QVTiTransformationAnalysis transformationAnalysis = null;
	private @Nullable QVTiModelManager modelManager = null;
	protected final boolean debugExceptions = AbstractTransformer.EXCEPTIONS.isActive();
	protected final boolean debugInvocations = AbstractTransformer.INVOCATIONS.isActive();

	public BasicQVTiExecutor(@NonNull QVTiEnvironmentFactory environmentFactory, @NonNull Transformation transformation) {
		super(environmentFactory);
		this.transformation = transformation;
	}

	/**
	 * Adds the model.
	 */
	public void addModel(@NonNull TypedModel typedModel, @NonNull Resource resource) {
		getModelManager().addModel(typedModel, resource);
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

	@Override
	public void createModel(@NonNull String name, @NonNull URI modelURI, @Nullable String contentType) {
		TypedModel typedModel = getTypedModel(name);
		Resource resource = environmentFactory.getResourceSet().createResource(modelURI, contentType);
		if (resource != null) {
			getModelManager().addModel(typedModel, resource);
		}
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
		if (modelManager != null) {
			modelManager.dispose();
		}
		super.dispose();
	}

	protected void doCommits(@NonNull Mapping mapping, @NonNull EvaluationVisitor undecoratedVisitor) {
		//
		// property and connection assignments
		//
		BottomPattern middleBottomPattern = mapping.getBottomPattern();
		for (Assignment assignment : middleBottomPattern.getAssignment()) {
			if (!(assignment instanceof VariableAssignment)) {
				assignment.accept(undecoratedVisitor);
			}
		}
	}

	protected boolean doPredicatesAndEvaluations(@NonNull Mapping mapping, @NonNull EvaluationVisitor undecoratedVisitor) {
		//
		// middle guard predicates
		//
		GuardPattern middleGuardPattern = mapping.getGuardPattern();
		//		assert middleGuardPattern.getVariable().isEmpty();		middle guards are connection variables
		for (@NonNull Predicate predicate : ClassUtil.nullFree(middleGuardPattern.getPredicate())) {
			// If the predicate is not true, the binding is not valid
			Object result = predicate.accept(undecoratedVisitor);
			if (result != Boolean.TRUE) {
				return false;
			}
		}
		for (@NonNull Domain domain : ClassUtil.nullFree(mapping.getDomain())) {
			if (!domain.isIsEnforceable()) {
				ImperativeDomain checkableDomain = (ImperativeDomain)domain;
				GuardPattern checkableGuardPattern = checkableDomain.getGuardPattern();
				assert checkableGuardPattern.getPredicate().isEmpty();
				BottomPattern checkableBottomPattern = checkableDomain.getBottomPattern();
				assert checkableBottomPattern.getAssignment().isEmpty();
				assert checkableBottomPattern.getPredicate().isEmpty();
				//				assert checkableBottomPattern.getVariable().isEmpty();
				for (@NonNull Variable rVar : ClassUtil.nullFree(checkableBottomPattern.getVariable())) {
					OCLExpression ownedInit = rVar.getOwnedInit();
					assert ownedInit == null;
				}
			}
			else {
				ImperativeDomain enforceableDomain = (ImperativeDomain)domain;
				GuardPattern enforceableGuardPattern = enforceableDomain.getGuardPattern();
				assert enforceableGuardPattern.getPredicate().isEmpty();
				BottomPattern enforceableBottomPattern = enforceableDomain.getBottomPattern();
				assert enforceableBottomPattern.getAssignment().isEmpty();
				assert enforceableBottomPattern.getPredicate().isEmpty();
				for (@NonNull Variable rVar : ClassUtil.nullFree(enforceableBottomPattern.getVariable())) {
					OCLExpression ownedInit = rVar.getOwnedInit();
					if (ownedInit != null) {
						Object initValue = ownedInit.accept(undecoratedVisitor);
						replace(rVar, initValue, true);
					}
				}
			}
		}
		BottomPattern middleBottomPattern = mapping.getBottomPattern();
		//
		// variable declarations/initializations
		//
		for (@NonNull Variable rVar : ClassUtil.nullFree(middleBottomPattern.getVariable())) {
			if (rVar instanceof ConnectionVariable) {
				CollectionValue.Accumulator accumulator = ValueUtil.createCollectionAccumulatorValue((CollectionTypeId) rVar.getTypeId());
				OCLExpression ownedInit = rVar.getOwnedInit();
				if (ownedInit != null) {
					Object initValue = ownedInit.accept(undecoratedVisitor);
					accumulator = ValueUtil.createCollectionAccumulatorValue((CollectionTypeId) ownedInit.getTypeId());
					if (initValue != null) {
						for (Object value : (Iterable<?>)initValue) {
							accumulator.add(value);
						}
					}
				}
				else {
					accumulator = ValueUtil.createCollectionAccumulatorValue((CollectionTypeId) rVar.getTypeId());
				}
				replace(rVar, accumulator, false);
			}
			else {
				OCLExpression ownedInit = rVar.getOwnedInit();
				if (ownedInit != null) {
					Object initValue = ownedInit.accept(undecoratedVisitor);
					replace(rVar, initValue, false);
				}
			}
		}
		//
		// variable assignments
		//
		for (@NonNull Assignment assignment : ClassUtil.nullFree(middleBottomPattern.getAssignment())) {
			if (assignment instanceof VariableAssignment) {
				assignment.accept(undecoratedVisitor);
			}
		}
		//
		// middle bottom predicates
		//
		for (@NonNull Predicate predicate : ClassUtil.nullFree(middleBottomPattern.getPredicate())) {
			// If the predicate is not true, the binding is not valid
			Object result = predicate.accept(undecoratedVisitor);
			if (result != Boolean.TRUE) {
				return false;
			}
		}
		return true;
	}

	@Override
	public Boolean execute() {
		initializeEvaluationEnvironment(transformation);
		getRootEvaluationEnvironment();
		StandardLibraryInternal standardLibrary = environmentFactory.getStandardLibrary();
		Variable ownedContext = QVTbaseUtil.getContextVariable(standardLibrary, transformation);
		QVTiModelManager modelManager = getModelManager();
		add(ownedContext, modelManager.getTransformationInstance(transformation));
		for (TypedModel typedModel : transformation.getModelParameter()) {
			if (typedModel != null) {
				ownedContext = QVTbaseUtil.getContextVariable(standardLibrary, typedModel);
				add(ownedContext, modelManager.getTypedModelInstance(typedModel));
			}
		}
		return executeInternal();
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

	/**
	 * Gets the named TypedModel.
	 */
	@Override
	public @Nullable Resource getModel(@NonNull String name) {
		TypedModel typedModel = getTypedModel(name);
		return getModelManager().getModel(typedModel);
	}

	@Override
	public @NonNull QVTiModelManager getModelManager() {
		QVTiModelManager modelManager2 = modelManager;
		if (modelManager2 == null) {
			modelManager = modelManager2 = new QVTiModelManager(getTransformationAnalysis());
		}
		return modelManager2;
	}

	public @NonNull Collection<@NonNull EObject> getRootObjects(@NonNull String name) {
		return getModelManager().getRootObjects(getTypedModel(name));
	}

	public @NonNull Transformation getTransformation() {
		return transformation;
	}

	public @NonNull QVTiTransformationAnalysis getTransformationAnalysis() {
		QVTiTransformationAnalysis transformationAnalysis2 = transformationAnalysis;
		if (transformationAnalysis2 == null) {
			transformationAnalysis = transformationAnalysis2 = getEnvironmentFactory().createTransformationAnalysis();
			transformationAnalysis2.analyzeTransformation(transformation);
		}
		return transformationAnalysis2;
	}

	public @NonNull TypedModel getTypedModel(@NonNull String name) {
		TypedModel typedModel = NameUtil.getNameable(transformation.getModelParameter(), name);
		if (typedModel == null) {
			throw new IllegalStateException("Unknown TypedModel '" + name + "'");
		}
		return typedModel;
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
				for (MappingCallBinding binding : mappingCall.getBinding()) {
					Variable boundVariable = ClassUtil.nonNullState(binding.getBoundVariable());
					replace(boundVariable, boundValues[index++], !(boundVariable instanceof ConnectionVariable));
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
		try {
			//
			//	Check the predicates
			//
			if (!doPredicatesAndEvaluations(mapping, undecoratedVisitor)) {
				return false;
			}
		}
		catch (InvocationFailedException e) {
			throw e;
		}
		catch (Throwable e) {
			// Mapping failure are just mappings that never happened.
			if (debugExceptions) {
				AbstractTransformer.EXCEPTIONS.println("Execution failure in " + mapping.getName() + " : " + e);
			}
			return false;
		}
		//
		//	Perform the instance model addition and property assignment only after all expressions have been evaluated
		//	possibly throwing a not-ready exception that bypasses premature commits.
		//
		doCommits(mapping, undecoratedVisitor);
		//
		//	Invoke any corrolaries
		//
		for (Statement statement : mapping.getOwnedStatements()) {
			statement.accept(undecoratedVisitor);
		}
		return true;
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
	public @Nullable Object internalExecuteNewStatement(@NonNull NewStatement newStatement, @NonNull EvaluationVisitor undecoratedVisitor) {
		OCLExpression ownedInit = newStatement.getOwnedInit();
		if (ownedInit != null) {
			Object initValue = ownedInit.accept(undecoratedVisitor);
			getEvaluationEnvironment().add(newStatement, initValue);
			replace(newStatement, initValue);
			TypedModel typedModel = newStatement.getReferredTypedModel();
			assert typedModel != null;
			Object ecoreValue = getIdResolver().ecoreValueOf(null, initValue);
			assert ecoreValue != null;
			getModelManager().addModelElement(typedModel, ecoreValue);
			return ecoreValue;
		}
		else {
			// Realized variables are in the mapping's target bottom pattern
			// and create elements in the target model. The realized variables
			// are being visited for each binding of variable in the mapping.
			Type type = newStatement.getType();
			if (!(type instanceof org.eclipse.ocl.pivot.Class)) {
				return null;
			}
			TypedModel typedModel = newStatement.getReferredTypedModel();
			assert typedModel != null;
			Object element = ((org.eclipse.ocl.pivot.Class)type).createInstance();
			// Add the realize variable binding to the environment
			replace(newStatement, element, false);
			getModelManager().addModelElement(typedModel, element);
			return element;
		}
	}

	@Override
	public void internalExecuteSetStatement(@NonNull SetStatement setStatement, @NonNull Object slotObject, @Nullable Object ecoreValue, @Nullable Object childKey) {
		Property targetProperty = QVTimperativeUtil.getTargetProperty(setStatement);
		targetProperty.initValue(slotObject, ecoreValue);
		QVTiModelManager modelManager = getModelManager();
		Integer cacheIndex = modelManager.getTransformationAnalysis().getCacheIndex(setStatement);
		if (cacheIndex != null) {
			modelManager.setUnnavigableOpposite(cacheIndex, slotObject, ecoreValue);
		}
	}

	@Override
	public @Nullable Object internalExecuteTransformation(@NonNull Transformation transformation, @NonNull EvaluationVisitor undecoratedVisitor) {
		Rule rule = NameUtil.getNameable(transformation.getRule(), QVTimperativeUtil.ROOT_MAPPING_NAME);
		if (rule == null) {
			throw new IllegalStateException("Transformation " + transformation.getName() + " has no root mapping");
		}
		CallExp callExp = PivotFactory.eINSTANCE.createOperationCallExp();		// FIXME TransformationCallExp
		pushEvaluationEnvironment(rule, (TypedElement)callExp);
		try {
			rule.accept(undecoratedVisitor);
		}
		finally {
			popEvaluationEnvironment();
		}
		return true;
	}

	/**
	 * Loads the modelURI and binds it to the named TypedModel.
	 */
	public @Nullable Resource loadModel(@NonNull String name, @NonNull URI modelURI) {
		TypedModel typedModel = getTypedModel(name);
		Resource resource = environmentFactory.getResourceSet().getResource(modelURI, true);
		if (resource != null) {
			getModelManager().addModel(typedModel, resource);
		}
		return resource;
	}

	@Override
	public void loadModel(@NonNull String name, @NonNull URI modelURI, @Nullable String contentType) {
		TypedModel typedModel = getTypedModel(name);
		Resource resource;
		ResourceSet resourceSet = environmentFactory.getResourceSet();
		if (contentType == null) {
			resource = resourceSet.getResource(modelURI, true);
		}
		else {
			resource = resourceSet.createResource(modelURI, contentType);
			try {
				resource.load(null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (resource != null) {
			getModelManager().addModel(typedModel, resource);
		}
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
	public void replace(@NonNull TypedElement asVariable, @Nullable Object value, boolean checkType) {
		if (value == null) {
			if (asVariable.isIsRequired()) {
				throw new InvalidValueException("Attempted to assign null value to " + asVariable);
			}
		}
		else if (checkType) {
			Type valueType = getIdResolver().getDynamicTypeOf(value);
			//			Type valueType2 = getIdResolver().getStaticTypeOf(value);
			//			Type valueType = valueType1;
			Type variableType = ClassUtil.nonNullState(asVariable.getType());
			if (!valueType.conformsTo(getStandardLibrary(), variableType) && (variableType.getESObject() != EcorePackage.Literals.EOBJECT)) {	// FIXME EObject fudge for Adolfo's test models
				throw new InvalidValueException("Attempted to assign incompatible value to " + asVariable);
			}
		}
		super.replace(asVariable, value);
	}

	//	@Override
	public void saveContents() {
		getModelManager().saveContents();
	}

	public Resource saveModel(@NonNull String name, @NonNull URI modelURI, String contentType, @Nullable Map<?, ?> savingOptions) throws IOException {
		TypedModel typedModel = getTypedModel(name);
		Resource resource = getModelManager().getModel(typedModel);
		if (resource == null) {
			resource = environmentFactory.getResourceSet().createResource(modelURI, contentType);
		}
		if (resource != null) {
			resource.save(savingOptions);
		}
		return resource;
	}

	@Override
	public void saveModels() {
		getModelManager().saveModels();
	}

	public void saveModels(@Nullable Map<?, ?> savingOptions) {
		getModelManager().saveModels(savingOptions);
	}

	public void saveModels(@NonNull URI traceURI) {
		this.saveModels(traceURI, null);
	}

	public void saveModels(@NonNull URI traceURI, @Nullable Map<?, ?> savingOptions) {
		this.saveModels(savingOptions);
		getModelManager().saveMiddleModel(traceURI, savingOptions);
	}

	public void saveTransformation(Map<?,?> options) throws IOException {
		XMLResource resource = (XMLResource) transformation.eResource();
		//    	new AS2ID().assignIds(resource.getResourceSet());
		resource.save(options);
	}
}
