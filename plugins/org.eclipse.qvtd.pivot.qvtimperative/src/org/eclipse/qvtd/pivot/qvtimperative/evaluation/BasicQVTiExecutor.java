/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
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
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.pivot.evaluation.tx.AbstractTransformer;
import org.eclipse.ocl.pivot.evaluation.tx.InvocationFailedException;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.internal.complete.StandardLibraryInternal;
import org.eclipse.ocl.pivot.internal.evaluation.AbstractExecutor;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.CollectionValue;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtcorebase.Area;
import org.eclipse.qvtd.pivot.qvtcorebase.Assignment;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.EnforcementOperation;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcorebase.VariableAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.utilities.QVTcoreBaseUtil;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionVariable;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingStatement;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;

public class BasicQVTiExecutor extends AbstractExecutor implements QVTiExecutor
{
    protected final @NonNull Transformation transformation;
    private @Nullable QVTiTransformationAnalysis transformationAnalysis = null;
    private @Nullable QVTiModelManager modelManager = null;

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
        TypedModel typedModel = NameUtil.getNameable(transformation.getModelParameter(), name);
        if (typedModel == null) {
        	throw new IllegalStateException("Unknown TypedModel '" + name + "'");
        }
        Resource resource = environmentFactory.getResourceSet().createResource(modelURI, contentType);
        if (resource != null) {
        	getModelManager().addModel(typedModel, resource);
        }
    }

	@Override
	protected EvaluationEnvironment.@NonNull EvaluationEnvironmentExtension createNestedEvaluationEnvironment(EvaluationEnvironment.@NonNull EvaluationEnvironmentExtension evaluationEnvironment, @NonNull NamedElement executableObject, @Nullable OCLExpression callingObject) {
		if (evaluationEnvironment instanceof QVTiEvaluationEnvironment) {
			return new QVTiNestedEvaluationEnvironment((QVTiEvaluationEnvironment) evaluationEnvironment, executableObject, callingObject);
		}
		else{
			return super.createNestedEvaluationEnvironment(evaluationEnvironment, executableObject, callingObject);
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
		//	creations
		//
		for (Domain domain : mapping.getDomain()) {
			if (domain.isIsEnforceable()) {
				CoreDomain enforceableDomain = (CoreDomain)domain;
				BottomPattern enforceableBottomPattern = enforceableDomain.getBottomPattern();
				for (RealizedVariable realizedVariable : enforceableBottomPattern.getRealizedVariable()) {
					realizedVariable.accept(undecoratedVisitor);
				}
			}
		}
		//
        // property and connection assignments
		//
		BottomPattern middleBottomPattern = mapping.getBottomPattern();
		for (Assignment assignment : middleBottomPattern.getAssignment()) {
			if (!(assignment instanceof VariableAssignment)) {
				assignment.accept(undecoratedVisitor);
			}
		}
		//
        // enforcement operations
		//
		for (Domain domain : mapping.getDomain()) {
			if (domain.isIsEnforceable()) {
				CoreDomain enforceableDomain = (CoreDomain)domain;
				BottomPattern enforceableBottomPattern = enforceableDomain.getBottomPattern();
				for (EnforcementOperation enforceOp : enforceableBottomPattern.getEnforcementOperation()) {
					enforceOp.accept(undecoratedVisitor);
				}
			}
		}
//		for (EnforcementOperation enforceOp : middleBottomPattern.getEnforcementOperation()) {
//			enforceOp.accept(undecoratedVisitor);
//		}
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
				CoreDomain checkableDomain = (CoreDomain)domain;
				GuardPattern checkableGuardPattern = checkableDomain.getGuardPattern();
				assert checkableGuardPattern.getPredicate().isEmpty();
				BottomPattern checkableBottomPattern = checkableDomain.getBottomPattern();
				assert checkableBottomPattern.getAssignment().isEmpty();
				assert checkableBottomPattern.getEnforcementOperation().isEmpty();
				assert checkableBottomPattern.getPredicate().isEmpty();
				assert checkableBottomPattern.getRealizedVariable().isEmpty();
				assert checkableBottomPattern.getVariable().isEmpty();
			}
			else {
				CoreDomain enforceableDomain = (CoreDomain)domain;
				GuardPattern enforceableGuardPattern = enforceableDomain.getGuardPattern();
				assert enforceableGuardPattern.getPredicate().isEmpty();
				BottomPattern enforceableBottomPattern = enforceableDomain.getBottomPattern();
				assert enforceableBottomPattern.getAssignment().isEmpty();
				assert enforceableBottomPattern.getPredicate().isEmpty();
				for (@NonNull Variable rVar : ClassUtil.nullFree(enforceableBottomPattern.getVariable())) {
					OCLExpression ownedInit = rVar.getOwnedInit();
					if (ownedInit != null) {
						Object initValue = ownedInit.accept(undecoratedVisitor);
						replace(rVar, initValue);
					}
				}
				for (@NonNull RealizedVariable rVar : ClassUtil.nullFree(enforceableBottomPattern.getRealizedVariable())) {
					OCLExpression ownedInit = rVar.getOwnedInit();
					if (ownedInit != null) {
						Object initValue = ownedInit.accept(undecoratedVisitor);
						replace(rVar, initValue);
					}
				}
			}
		}
		BottomPattern middleBottomPattern = mapping.getBottomPattern();
		assert middleBottomPattern.getEnforcementOperation().isEmpty();
		assert middleBottomPattern.getRealizedVariable().isEmpty();
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
				replace(rVar, accumulator);
			}
			else {
				OCLExpression ownedInit = rVar.getOwnedInit();
				if (ownedInit != null) {
					Object initValue = ownedInit.accept(undecoratedVisitor);
					replace(rVar, initValue);
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
	
	@Override
	public @NonNull QVTiModelManager getModelManager() {
		QVTiModelManager modelManager2 = modelManager;
		if (modelManager2 == null) {
			modelManager = modelManager2 = new QVTiModelManager(getTransformationAnalysis());
		}
		return modelManager2;
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

	@Override
	public @Nullable Object internalExecuteMappingCall(@NonNull MappingCall mappingCall, @NonNull Map<Variable, Object> variable2value, @NonNull EvaluationVisitor undecoratedVisitor) {
		Mapping calledMapping = mappingCall.getReferredMapping();
		if (calledMapping != null) {
			pushEvaluationEnvironment(calledMapping, mappingCall);
			try {
				for (Map.Entry<Variable,Object> entry : variable2value.entrySet()) {
					@SuppressWarnings("null")@NonNull Variable variable = entry.getKey();
					replace(variable, entry.getValue());
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
	    	AbstractTransformer.EXCEPTIONS.println("Execution failure in " + mapping.getName() + " : " + e);
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
 		MappingStatement mappingStatement = mapping.getMappingStatement();
		if (mappingStatement != null) {
			mappingStatement.accept(undecoratedVisitor);
		}
        return true;
	}
	
	@Override
	public void internalExecutePropertyAssignment(@NonNull PropertyAssignment propertyAssignment, @NonNull Object slotObject, @Nullable Object ecoreValue, @Nullable Object childKey) {
		Property targetProperty = propertyAssignment.getTargetProperty();
		targetProperty.initValue(slotObject, ecoreValue);
    	QVTiModelManager modelManager = getModelManager();
		Integer cacheIndex = modelManager.getTransformationAnalysis().getCacheIndex(propertyAssignment);
		if (cacheIndex != null) {
			modelManager.setUnnavigableOpposite(cacheIndex, slotObject, ecoreValue);
		}
	}

	@Override
	public @Nullable Object internalExecuteRealizedVariable(@NonNull RealizedVariable realizedVariable, @NonNull EvaluationVisitor undecoratedVisitor) {
        // Realized variables are in the mapping's target bottom pattern
        // and create elements in the target model. The realized variables
        // are being visited for each binding of variable in the mapping. 
        Type type = realizedVariable.getType();
        if (!(type instanceof org.eclipse.ocl.pivot.Class)) {
        	return null;
        }
        Area area = ((BottomPattern)realizedVariable.eContainer()).getArea();
        TypedModel typedModel = QVTcoreBaseUtil.getTypedModel(area);
        assert typedModel != null;
		Object element = ((org.eclipse.ocl.pivot.Class)type).createInstance();
        // Add the realize variable binding to the environment
        replace(realizedVariable, element);
        getModelManager().addModelElement(typedModel, element);
        return element;
	}

	@Override
	public @Nullable Object internalExecuteTransformation(@NonNull Transformation transformation, @NonNull EvaluationVisitor undecoratedVisitor) {
        Rule rule = NameUtil.getNameable(transformation.getRule(), QVTimperativeUtil.ROOT_MAPPING_NAME);
        if (rule == null) {
        	throw new IllegalStateException("Transformation " + transformation.getName() + " has no root mapping");
        }
        @SuppressWarnings("null")@NonNull CallExp callExp = PivotFactory.eINSTANCE.createOperationCallExp();		// FIXME TransformationCallExp
        pushEvaluationEnvironment(rule, callExp);
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
	public void loadModel(@NonNull String name, @NonNull URI modelURI) {
        TypedModel typedModel = NameUtil.getNameable(transformation.getModelParameter(), name);
        if (typedModel == null) {
        	throw new IllegalStateException("Unknown TypedModel '" + name + "'");
        }
        Resource resource = environmentFactory.getResourceSet().getResource(modelURI, true);
        if (resource != null) {
        	getModelManager().addModel(typedModel, resource);
        }
    }

	@Override
	public void loadModel(@NonNull String name, @NonNull URI modelURI, @Nullable String contentType) {
        TypedModel typedModel = NameUtil.getNameable(transformation.getModelParameter(), name);
        if (typedModel == null) {
        	throw new IllegalStateException("Unknown TypedModel '" + name + "'");
        }
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

    public Resource saveModel(@NonNull String name, @NonNull URI modelURI, String contentType, @Nullable Map<?, ?> savingOptions) throws IOException {
        TypedModel typedModel = NameUtil.getNameable(transformation.getModelParameter(), name);
        if (typedModel == null) {
        	throw new IllegalStateException("Unknown TypedModel '" + name + "'");
        }
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
