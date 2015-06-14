/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.debug.evaluator;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.debug.vm.evaluator.IVMContext;
import org.eclipse.ocl.examples.debug.vm.evaluator.VMExecutor;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.pivot.internal.complete.StandardLibraryInternal;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.debug.QVTiDebugPlugin;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.BasicQVTiExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEvaluationVisitor;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiModelManager;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiTransformationAnalysis;
import org.eclipse.qvtd.xtext.qvtimperative.utilities.QVTiXtextEvaluator;

public class QVTiVMExecutor extends BasicQVTiExecutor implements VMExecutor
{
    private static @NonNull QVTiTransformationAnalysis createTransformationAnalyis(@NonNull QVTiEnvironmentFactory environmentFactory, @NonNull Transformation transformation) {
    	QVTiTransformationAnalysis transformationAnalysis = environmentFactory.createTransformationAnalysis();
    	transformationAnalysis.analyzeTransformation(transformation);
		return transformationAnalysis;
	}

    protected final @NonNull Transformation transformation;
	protected final @NonNull IVMContext vmContext;
	private boolean suspendOnStartup = false;
	private long envId = 0;

    public QVTiVMExecutor(@NonNull IVMContext vmContext, @NonNull URI transformationURI) throws IOException {
    	this(vmContext, (QVTiEnvironmentFactory) vmContext.getEnvironmentFactory(), QVTiXtextEvaluator.loadTransformation(ImperativeModel.class, vmContext.getEnvironmentFactory(), transformationURI, vmContext.keepDebug()));
    }

    private QVTiVMExecutor(@NonNull IVMContext vmContext, @NonNull QVTiEnvironmentFactory environmentFactory, @NonNull Transformation transformation) {
    	this(vmContext, environmentFactory, transformation, createTransformationAnalyis(environmentFactory, transformation));
    }

	private QVTiVMExecutor(@NonNull IVMContext vmContext, @NonNull QVTiEnvironmentFactory environmentFactory, @NonNull Transformation transformation, @NonNull QVTiTransformationAnalysis transformationAnalysis) {
		super(environmentFactory, new QVTiModelManager(transformationAnalysis));
    	this.transformation = transformation;
		this.vmContext = vmContext;
	}

	@Override
	protected @NonNull QVTiVMEvaluationVisitor createEvaluationVisitor() {
		QVTiEvaluationVisitor evaluationVisitor = new QVTiEvaluationVisitor(this);
		return new QVTiVMEvaluationVisitor(evaluationVisitor, vmContext);
	}

    public void createModel(@NonNull String name, @NonNull URI modelURI, String contentType) {
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
	protected @NonNull QVTiVMEvaluationEnvironment createNestedEvaluationEnvironment(@NonNull EvaluationEnvironment evaluationEnvironment, @NonNull NamedElement executableObject) {
		return new QVTiVMNestedEvaluationEnvironment((QVTiVMEvaluationEnvironment) evaluationEnvironment, executableObject, ++envId);
	}

	@Override
	protected @NonNull QVTiVMEvaluationEnvironment createRootEvaluationEnvironment(@NonNull NamedElement executableObject) {
		return new QVTiVMRootEvaluationEnvironment(this, (Transformation)executableObject, ++envId);
	}

	public Boolean execute() {
		initializeEvaluationEnvironment(transformation);
		getRootEvaluationEnvironment();
        QVTiVMEvaluationVisitor visitor = (QVTiVMEvaluationVisitor) getEvaluationVisitor();
        StandardLibraryInternal standardLibrary = environmentFactory.getStandardLibrary();
		QVTiModelManager modelManager = getModelManager();
		Variable ownedContext = QVTbaseUtil.getContextVariable(standardLibrary, transformation);
		add(ownedContext, modelManager.getTransformationInstance(transformation));
        for (TypedModel typedModel : transformation.getModelParameter()) {
        	if (typedModel != null) {
	            ownedContext = QVTbaseUtil.getContextVariable(standardLibrary, typedModel);
	            add(ownedContext, modelManager.getTypedModelInstance(typedModel));
        	}
        }
        visitor.start(suspendOnStartup);
        return (Boolean) transformation.accept(visitor);
	}

	@Override
	public @NonNull Transformation getDebuggable() {
		return transformation;
	}
	
	@Override
	public @NonNull QVTiModelManager getModelManager() {
		return (QVTiModelManager) modelManager;
	}

	@Override
	public @NonNull String getPluginId() {
		return QVTiDebugPlugin.PLUGIN_ID;
	}

	public void loadModel(@NonNull String name, @NonNull URI modelURI, String contentType) {
        TypedModel typedModel = NameUtil.getNameable(transformation.getModelParameter(), name);
        if (typedModel == null) {
        	throw new IllegalStateException("Unknown TypedModel '" + name + "'");
        }
        Resource resource;
        if (contentType == null) {
        	resource = vmContext.getEnvironmentFactory().getResourceSet().getResource(modelURI, true);
        }
        else {
        	resource = vmContext.getEnvironmentFactory().getResourceSet().createResource(modelURI, contentType);
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
	public void saveModels() {
		getModelManager().saveModels();
	}

	@Override
	public void setSuspendOnStartUp(boolean suspendOnStartup) {
		this.suspendOnStartup = suspendOnStartup;
	}
}
