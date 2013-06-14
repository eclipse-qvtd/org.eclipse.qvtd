package org.eclipse.qvtd.pivot.qvtimperative.evaluation;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.evaluation.PivotEvaluationEnvironment;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.utilities.PivotEnvironment;
import org.eclipse.ocl.examples.pivot.utilities.PivotEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;

/**
 * A QVTiPivotEvaluator supports loading a compiled transformation and models, performing a transformation
 * and then saving the models.
 * @see QVTiXtextEvaluator
 */
public class QVTiPivotEvaluator
{
	protected final @NonNull MetaModelManager metaModelManager;
	protected final @NonNull Transformation transformation;
	protected final @NonNull PivotEnvironmentFactory envFactory;
	protected final @NonNull PivotEnvironment env;
	protected final @NonNull QVTiModelManager modelManager;
    private boolean traceEvaluation = false;
    
    public QVTiPivotEvaluator(@NonNull MetaModelManager metaModelManager, @NonNull Transformation transformation) {
    	this.metaModelManager = metaModelManager;
    	this.transformation = transformation;
    	this.envFactory = new PivotEnvironmentFactory(null, metaModelManager);
    	this.env = envFactory.createEnvironment();
    	QVTiTransformationAnalysis transformationAnalysis = new QVTiTransformationAnalysis(metaModelManager);
    	transformationAnalysis.analyzeTransformation(transformation);
    	this.modelManager = new QVTiModelManager(transformationAnalysis);
    }

	/**
	 * Adds the model.
	 */
	public void addModel(@NonNull TypedModel typedModel, @NonNull Resource resource) {
		modelManager.addModel(typedModel, resource);
	}

	/**
	 * Creates the modelURI and binds it to the named TypedModel.
	 */
	public void createModel(@NonNull String name, @NonNull URI modelURI) {
        TypedModel typedModel = DomainUtil.getNamedElement(transformation.getModelParameter(), name);
        if (typedModel == null) {
        	throw new IllegalStateException("Unknown TypedModel '" + name + "'");
        }
        Resource resource = metaModelManager.getExternalResourceSet().createResource(modelURI);
        if (resource != null) {
        	modelManager.addModel(typedModel, resource);
        }
    }

	public void dispose() {
		modelManager.dispose();
	}

	public Boolean execute() {
        PivotEvaluationEnvironment evalEnv = envFactory.createEvaluationEnvironment();
        QVTiEvaluationVisitor visitor = new QVTiLMEvaluationVisitor(env, evalEnv, modelManager);
        if (isEvaluationTracingEnabled()) {
            // decorate the evaluation visitor with tracing support
        	visitor = new QVTiTracingEvaluationVisitor(visitor);
        }
        return (Boolean) transformation.accept(visitor);
	}

	public final @NonNull PivotEnvironment getEnvironment() {
		return env;
	}

	public final @NonNull PivotEnvironmentFactory getEnvironmentFactory() {
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

	/**
     * Queries whether tracing of evaluation is enabled.  Tracing
     * logs the progress of evaluation to the console, which may
     * be of use in diagnosing problems.
     * <p>
     * In an Eclipse environment, tracing is also enabled by turning on the
     * <tt>org.eclipse.ocl/debug/evaluation</tt> debug option. 
     * </p>
     * 
     * @return whether evaluation tracing is enabled
     * 
     * @see #setEvaluationTracingEnabled(boolean)
     */
	public final boolean isEvaluationTracingEnabled() {
        return traceEvaluation;
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

	public void saveModels() {
		modelManager.saveModels();
	}
	
	public void saveModels(@NonNull URI traceURI) {
		this.saveModels();
		modelManager.saveMiddleModel(traceURI);
	}

	/**
     * Sets whether tracing of evaluation is enabled.  Tracing logs
     * the progress of parsing to the console, which may be of use in diagnosing
     * problems.
     * <p>
     * In an Eclipse environment, tracing is also enabled by turning on the
     * <tt>org.eclipse.ocl/debug/evaluation</tt> debug option. 
     * </p>
     * 
     * param b whether evaluation tracing is enabled
     * 
     * @see #isEvaluationTracingEnabled()
     */
    public void setEvaluationTracingEnabled(boolean b) {
        traceEvaluation = b;
    }
}
