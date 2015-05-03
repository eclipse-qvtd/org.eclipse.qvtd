/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.evaluation;

import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.pivot.internal.complete.StandardLibraryInternal;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;

/**
 * A QVTiPivotEvaluator supports loading a compiled transformation and models, performing a transformation
 * and then saving the models.
 * @see QVTiXtextEvaluator
 */
public class QVTiPivotEvaluator implements EvaluationMonitor
{
	protected final @NonNull QVTiEnvironmentFactory environmentFactory;
	protected final @NonNull Transformation transformation;
	protected final @NonNull QVTiModelManager modelManager;
    private EvaluationMonitor monitor = null;
    private boolean canceled = false;

    public QVTiPivotEvaluator(@NonNull QVTiEnvironmentFactory environmentFactory, @NonNull Transformation transformation) {
    	this.environmentFactory = environmentFactory;
    	this.transformation = transformation;
    	QVTiTransformationAnalysis transformationAnalysis = environmentFactory.createTransformationAnalysis();
    	transformationAnalysis.analyzeTransformation(transformation);
    	this.modelManager = environmentFactory.createModelManager(transformationAnalysis);
    }

	/**
	 * Adds the model.
	 */
	public void addModel(@NonNull TypedModel typedModel, @NonNull Resource resource) {
		modelManager.addModel(typedModel, resource);
	}

	@Override
	public void cancel() {
		if (monitor != null) {
			monitor.cancel();
		}
		else {
			canceled = true;
		}
	}

	/**
	 * Creates the modelURI and binds it to the named TypedModel.
	 */
	@Deprecated 
	public void createModel(@NonNull String name, @NonNull URI modelURI) {
        createModel(name, modelURI, null);
    }
	public void createModel(@NonNull String name, @NonNull URI modelURI, String contentType) {
        TypedModel typedModel = NameUtil.getNameable(transformation.getModelParameter(), name);
        if (typedModel == null) {
        	throw new IllegalStateException("Unknown TypedModel '" + name + "'");
        }
        Resource resource = environmentFactory.getResourceSet().createResource(modelURI, contentType);
        if (resource != null) {
        	modelManager.addModel(typedModel, resource);
        }
    }

	public void dispose() {
		modelManager.dispose();
	}

	public Boolean execute() {
        EvaluationEnvironment evalEnv = environmentFactory.createEvaluationEnvironment(transformation, modelManager);
        EvaluationVisitor visitor = environmentFactory.createEvaluationVisitor(evalEnv);
        StandardLibraryInternal standardLibrary = environmentFactory.getStandardLibrary();
		Variable ownedContext = QVTbaseUtil.getContextVariable(standardLibrary, transformation);
		evalEnv.add(ownedContext, modelManager.getTransformationInstance(transformation));
        for (TypedModel typedModel : transformation.getModelParameter()) {
        	if (typedModel != null) {
	            ownedContext = QVTbaseUtil.getContextVariable(standardLibrary, typedModel);
	            evalEnv.add(ownedContext, modelManager.getTypedModelInstance(typedModel));
        	}
        }
        return (Boolean) transformation.accept(visitor);
	}

	/**
	 * Return the EvaluationMonitor to which cancel()/isCanceled() are delegated or this if no delegate specified.
	 */
	public @NonNull EvaluationMonitor getEvaluationMonitor() {
        return monitor != null ? monitor : this;
    }

	public final @NonNull QVTiEnvironmentFactory getEnvironmentFactory() {
		return environmentFactory;
	}

	public final @NonNull PivotMetamodelManager getMetamodelManager() {
		return environmentFactory.getMetamodelManager();
	}
	
	public final @NonNull QVTiModelManager getModelManager() {
		return modelManager;
	}
	
	public final @NonNull Transformation getTransformation() {
		return transformation;
	}

	@Override
	public boolean isCanceled() {
		return canceled || ((monitor != null) && monitor.isCanceled());
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
        	modelManager.addModel(typedModel, resource);
        }
    }
	public void loadModel(@NonNull String name, @NonNull URI modelURI, String contentType) {
        TypedModel typedModel = NameUtil.getNameable(transformation.getModelParameter(), name);
        if (typedModel == null) {
        	throw new IllegalStateException("Unknown TypedModel '" + name + "'");
        }
        Resource resource;
        if (contentType == null) {
        	resource = environmentFactory.getResourceSet().getResource(modelURI, true);
        }
        else {
        	resource = environmentFactory.getResourceSet().createResource(modelURI, contentType);
        	try {
				resource.load(null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        if (resource != null) {
        	modelManager.addModel(typedModel, resource);
        }
    }

	public void saveModels() {
		modelManager.saveModels();
	}
	
	public void saveModels(@Nullable Map<?, ?> savingOptions) {
		modelManager.saveModels(savingOptions);
	}
	
	public void saveModels(@NonNull URI traceURI) {
		this.saveModels(traceURI, null);
	}
	
	public void saveModels(@NonNull URI traceURI, @Nullable Map<?, ?> savingOptions) {
		this.saveModels(savingOptions);
		modelManager.saveMiddleModel(traceURI, savingOptions);
	}

	public void saveTransformation(Map<?,?> options) throws IOException {
    	XMLResource resource = (XMLResource) transformation.eResource();
//    	new AS2ID().assignIds(resource.getResourceSet());
		resource.save(options);
	}

	/**
	 * Specify an EvaluationMonitor to which cancel()/isCanceled() are delegated.
	 */
	public void setEvaluationMonitor(@Nullable EvaluationMonitor monitor) {
        this.monitor = monitor;
    }
}
