package org.eclipse.qvtd.pivot.qvtimperative.evaluation;

import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;

/**
 * A QVTiPivotEvaluator supports loading a compiled transformation and models, performing a transformation
 * and then saving the models.
 * @see QVTiXtextEvaluator
 */
public class QVTiPivotEvaluator implements EvaluationMonitor
{
	protected final @NonNull MetaModelManager metaModelManager;
	protected final @NonNull Transformation transformation;
	protected final @NonNull QVTiEnvironmentFactory envFactory;
	protected final @NonNull QVTiEnvironment env;
	protected final @NonNull QVTiModelManager modelManager;
    private EvaluationMonitor monitor = null;
    private boolean canceled = false;

    public QVTiPivotEvaluator(@NonNull QVTiEnvironmentFactory envFactory, @NonNull Transformation transformation) {
    	this.envFactory = envFactory;
    	this.metaModelManager = envFactory.getMetaModelManager();
    	this.transformation = transformation;
    	this.env = envFactory.createEnvironment();
    	QVTiTransformationAnalysis transformationAnalysis = envFactory.createTransformationAnalysis();
    	transformationAnalysis.analyzeTransformation(transformation);
    	this.modelManager = envFactory.createModelManager(transformationAnalysis);
    }

    public QVTiPivotEvaluator(@NonNull MetaModelManager metaModelManager, @NonNull Transformation transformation) {
    	this.metaModelManager = metaModelManager;
    	this.transformation = transformation;
    	this.envFactory = new QVTiEnvironmentFactory(null, metaModelManager);
    	this.env = envFactory.createEnvironment();
    	QVTiTransformationAnalysis transformationAnalysis = envFactory.createTransformationAnalysis();
    	transformationAnalysis.analyzeTransformation(transformation);
    	this.modelManager = envFactory.createModelManager(transformationAnalysis);
    }

	/**
	 * Adds the model.
	 */
	public void addModel(@NonNull TypedModel typedModel, @NonNull Resource resource) {
		modelManager.addModel(typedModel, resource);
	}

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
        TypedModel typedModel = DomainUtil.getNamedElement(transformation.getModelParameter(), name);
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
        IQVTiEvaluationEnvironment evalEnv = envFactory.createEvaluationEnvironment(modelManager, transformation);
        QVTiEvaluationVisitor visitor = envFactory.createEvaluationVisitor(env, evalEnv);
        return (Boolean) transformation.accept(visitor);
	}

	/**
	 * Return the EvaluationMonitor to which cancel()/isCanceled() are delegated or this if no delegate specified.
	 */
	public @NonNull EvaluationMonitor getEvaluationMonitor() {
        return monitor != null ? monitor : this;
    }

	public final @NonNull QVTiEnvironment getEnvironment() {
		return env;
	}

	public final @NonNull QVTiEnvironmentFactory getEnvironmentFactory() {
		return envFactory;
	}

	public final @NonNull MetaModelManager getMetaModelManager() {
		return metaModelManager;
	}
	
	public final @NonNull QVTiModelManager getModelManager() {
		return modelManager;
	}
	
	public final @NonNull Transformation getTransformation() {
		return transformation;
	}

	public boolean isCanceled() {
		return canceled || ((monitor != null) && monitor.isCanceled());
	}

	/**
	 * Loads the modelURI and binds it to the named TypedModel.
	 */
	public void loadModel(@NonNull String name, @NonNull URI modelURI) {
        TypedModel typedModel = DomainUtil.getNamedElement(transformation.getModelParameter(), name);
        if (typedModel == null) {
        	throw new IllegalStateException("Unknown TypedModel '" + name + "'");
        }
        Resource resource = metaModelManager.getExternalResourceSet().getResource(modelURI, true);
        if (resource != null) {
        	modelManager.addModel(typedModel, resource);
        }
    }
	public void loadModel(@NonNull String name, @NonNull URI modelURI, String contentType) {
        TypedModel typedModel = DomainUtil.getNamedElement(transformation.getModelParameter(), name);
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

	public void saveModels() {
		modelManager.saveModels();
	}
	
	public void saveModels(@NonNull URI traceURI) {
		this.saveModels();
		modelManager.saveMiddleModel(traceURI);
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
