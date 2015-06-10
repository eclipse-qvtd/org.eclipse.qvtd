/*******************************************************************************
 * Copyright (c) 2014, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     R.Dvorak and others - QVTo debugger framework
 *     E.D.Willink - revised API for OCL/QVTi debugger framework
 *******************************************************************************/
package org.eclipse.qvtd.debug.evaluator;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.debug.vm.evaluator.IVMContext;
import org.eclipse.ocl.examples.debug.vm.evaluator.IVMEvaluator;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.internal.complete.StandardLibraryInternal;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiTransformationAnalysis;
import org.eclipse.qvtd.xtext.qvtimperative.utilities.QVTiXtextEvaluator;

public class QVTiVMEvaluator implements IVMEvaluator
{
/*    public static @NonNull EObject loadContext(@NonNull MetamodelManager metamodelManager, @NonNull URI contextURI) throws IOException {
        EObject eObject = metamodelManager.getExternalResourceSet().getEObject(contextURI, true);
        if (eObject == null) {
            throw new IOException("Nothing loadable as '" + contextURI + "'");
        }
        return eObject;
	}
    
    public static @NonNull ExpressionInOCL loadExpression(@NonNull MetamodelManager metamodelManager, @NonNull URI constraintURI, boolean keepDebug) throws IOException {
        EObject eObject = metamodelManager.getASResourceSet().getEObject(constraintURI, true);
        return loadExpression(eObject, constraintURI);
	}

	public static @NonNull ExpressionInOCL loadExpression(EObject eObject, URI constraintURI)
			throws IOException {
		if (eObject == null) {
            throw new IOException("Nothing loadable as '" + constraintURI + "'");
        }
        if (!(eObject instanceof Constraint)) {
            throw new IOException("Constraint rather than " + eObject.eClass().getName() + " expected as '" + constraintURI + "'");
        }
    	OpaqueExpression specification = ((Constraint)eObject).getSpecification();
    	if (specification != null) {
    		ExpressionInOCL expressionInOCL = specification.getExpressionInOCL();
        	if (expressionInOCL != null) {
        		return expressionInOCL;
        	}
    	}
        throw new IOException("Missing OCL expression " + eObject.eClass().getName() + " expected as '" + constraintURI + "'");
	} */
    
	protected final @NonNull QVTiEnvironmentFactory environmentFactory;
	protected final @NonNull Transformation transformation;
	protected final @NonNull IVMContext vmContext;
	protected final @NonNull QVTiVMModelManager vmModelManager;
	private boolean suspendOnStartup = false;

    private QVTiVMEvaluator(@NonNull IVMContext vmContext, @NonNull Transformation transformation) {
    	this.vmContext = vmContext;
    	this.environmentFactory = (QVTiEnvironmentFactory) vmContext.getEnvironmentFactory();
    	this.transformation = transformation;
    	QVTiTransformationAnalysis transformationAnalysis = environmentFactory.createTransformationAnalysis();
    	transformationAnalysis.analyzeTransformation(transformation);
    	this.vmModelManager = new QVTiVMModelManager(transformationAnalysis);
    }

    public QVTiVMEvaluator(@NonNull IVMContext vmContext, @NonNull URI transformationURI) throws IOException {
    	this(vmContext, QVTiXtextEvaluator.loadTransformation(ImperativeModel.class, vmContext.getEnvironmentFactory(), transformationURI, vmContext.keepDebug()));
    }

    public void createModel(@NonNull String name, @NonNull URI modelURI, String contentType) {
        TypedModel typedModel = NameUtil.getNameable(transformation.getModelParameter(), name);
        if (typedModel == null) {
        	throw new IllegalStateException("Unknown TypedModel '" + name + "'");
        }
        Resource resource = vmContext.getEnvironmentFactory().getResourceSet().createResource(modelURI, contentType);
        if (resource != null) {
        	vmModelManager.addModel(typedModel, resource);
        }
    }

	public void dispose() {
		vmModelManager.dispose();
	}

	public Boolean execute() {
		Transformation transformation = getTransformation();
		QVTiVMExecutor vmExecutor = new QVTiVMExecutor(vmContext, vmModelManager);
		vmExecutor.initializeEvaluationEnvironment(transformation);
		QVTiVMEvaluationEnvironment evalEnv = vmExecutor.getRootEvaluationEnvironment();
        QVTiVMEvaluationVisitor visitor = vmExecutor.getEvaluationVisitor();
        StandardLibraryInternal standardLibrary = vmContext.getEnvironmentFactory().getStandardLibrary();
		Variable ownedContext = QVTbaseUtil.getContextVariable(standardLibrary, transformation);
		evalEnv.add(ownedContext, vmModelManager.getTransformationInstance(transformation));
        for (TypedModel typedModel : transformation.getModelParameter()) {
        	if (typedModel != null) {
	            ownedContext = QVTbaseUtil.getContextVariable(standardLibrary, typedModel);
	            evalEnv.add(ownedContext, vmModelManager.getTypedModelInstance(typedModel));
        	}
        }
        visitor.start(suspendOnStartup);
        return (Boolean) transformation.accept(visitor);
	}

	@Override
	public @NonNull Transformation getDebuggable() {
		return getTransformation();
	}

	public @NonNull QVTiEnvironmentFactory getEnvironmentFactory() {
		return environmentFactory;
	}
	
	public @NonNull Transformation getTransformation() {
		return transformation;
	}
	
	public final @NonNull QVTiVMModelManager getVMModelManager() {
		return vmModelManager;
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
        	vmModelManager.addModel(typedModel, resource);
        }
    }

	@Override
	public void saveModels() {
		vmModelManager.saveModels();
	}

	@Override
	public void setSuspendOnStartUp(boolean suspendOnStartup) {
		this.suspendOnStartup = suspendOnStartup;
	}
}
