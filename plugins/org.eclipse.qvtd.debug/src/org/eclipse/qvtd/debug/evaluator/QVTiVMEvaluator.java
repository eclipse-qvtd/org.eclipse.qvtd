/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
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
import org.eclipse.ocl.examples.debug.vm.evaluator.IVMEvaluator;
import org.eclipse.ocl.examples.debug.vm.evaluator.IVMModelManager;
import org.eclipse.ocl.pivot.manager.MetaModelManager;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiTransformationAnalysis;
import org.eclipse.qvtd.xtext.qvtimperative.utilities.QVTiXtextEvaluator;

public class QVTiVMEvaluator implements IVMEvaluator
{
/*    public static @NonNull EObject loadContext(@NonNull MetaModelManager metaModelManager, @NonNull URI contextURI) throws IOException {
        EObject eObject = metaModelManager.getExternalResourceSet().getEObject(contextURI, true);
        if (eObject == null) {
            throw new IOException("Nothing loadable as '" + contextURI + "'");
        }
        return eObject;
	}
    
    public static @NonNull ExpressionInOCL loadExpression(@NonNull MetaModelManager metaModelManager, @NonNull URI constraintURI, boolean keepDebug) throws IOException {
        EObject eObject = metaModelManager.getASResourceSet().getEObject(constraintURI, true);
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
    
	protected final @NonNull MetaModelManager metaModelManager;
	protected final @NonNull Transformation transformation;
	protected final @NonNull QVTiVMEnvironmentFactory envFactory;
	protected final @NonNull QVTiVMEnvironment env;
	protected final @NonNull QVTiVMModelManager modelManager;
//	private @Nullable EObject context;
	private boolean suspendOnStartup = false;

//	public QVTiVMEvaluator(@NonNull QVTiEnvironmentFactory envFactory, @NonNull URI transformationURI) throws IOException {
//		super(envFactory, transformationURI);
//	}
	

    private QVTiVMEvaluator(@NonNull QVTiVMEnvironmentFactory envFactory, @NonNull Transformation transformation) {
    	this.envFactory = envFactory;
    	this.metaModelManager = envFactory.getMetaModelManager();
    	this.transformation = transformation;
    	this.env = envFactory.createEnvironment();
    	QVTiTransformationAnalysis transformationAnalysis = envFactory.createTransformationAnalysis();
    	transformationAnalysis.analyzeTransformation(transformation);
    	this.modelManager = envFactory.createModelManager(transformationAnalysis);
//    	this.modelManager = envFactory.createModelManager(metaModelManager);
    }

    public QVTiVMEvaluator(@NonNull QVTiVMEnvironmentFactory envFactory, @NonNull URI transformationURI) throws IOException {
    	this(envFactory, QVTiXtextEvaluator.loadTransformation(envFactory.getMetaModelManager(), transformationURI, envFactory.keepDebug()));
//    	context = loadContext(envFactory.getMetaModelManager(), contextURI);
    }
    
//    public QVTiVMEvaluator(@NonNull QVTiVMEnvironmentFactory envFactory, @NonNull Constraint constraint, @NonNull EObject context) throws IOException {
//    	this(envFactory, loadExpression(constraint, EcoreUtil.getURI(constraint)));
//    	this.context = context;
//    }
	public void createModel(@NonNull String name, @NonNull URI modelURI, String contentType) {
        TypedModel typedModel = ClassUtil.getNamedElement(transformation.getModelParameter(), name);
        if (typedModel == null) {
        	throw new IllegalStateException("Unknown TypedModel '" + name + "'");
        }
        Resource resource = metaModelManager.getExternalResourceSet().createResource(modelURI, contentType);
        if (resource != null) {
        	modelManager.addModel(typedModel, resource);
        }
    }

	public void dispose() {
		modelManager.dispose();
	}

	public Boolean execute() {
		Transformation transformation = getTransformation();
		IQVTiVMEvaluationEnvironment evalEnv = envFactory.createEvaluationEnvironment(modelManager, transformation);
//		Variable contextVariable = expressionInOCL.getContextVariable();
//		if (contextVariable != null) {
//			evalEnv.add(contextVariable, context);
//		}
        QVTiVMRootEvaluationVisitor visitor = envFactory.createEvaluationVisitor(env, evalEnv);
        visitor.start(suspendOnStartup);
        return (Boolean) transformation.accept(visitor);
	}

	@Override
	public @NonNull Transformation getDebuggable() {
		return getTransformation();
	}

	public final @NonNull QVTiVMEnvironment getEnvironment() {
		return env;
	}

	public final @NonNull QVTiVMEnvironmentFactory getEnvironmentFactory() {
		return envFactory;
	}

	public final @NonNull MetaModelManager getMetaModelManager() {
		return metaModelManager;
	}
	
	public final @NonNull IVMModelManager getModelManager() {
		return modelManager;
	}
	
	public @NonNull Transformation getTransformation() {
		return transformation;
	}
	public void loadModel(@NonNull String name, @NonNull URI modelURI, String contentType) {
        TypedModel typedModel = ClassUtil.getNamedElement(transformation.getModelParameter(), name);
        if (typedModel == null) {
        	throw new IllegalStateException("Unknown TypedModel '" + name + "'");
        }
        Resource resource;
        if (contentType == null) {
        	resource = metaModelManager.getExternalResourceSet().getResource(modelURI, true);
        }
        else {
        	resource = metaModelManager.getExternalResourceSet().createResource(modelURI, contentType);
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

	@Override
	public void saveModels() {}

	@Override
	public void setSuspendOnStartUp(boolean suspendOnStartup) {
		this.suspendOnStartup = suspendOnStartup;
	}
}
