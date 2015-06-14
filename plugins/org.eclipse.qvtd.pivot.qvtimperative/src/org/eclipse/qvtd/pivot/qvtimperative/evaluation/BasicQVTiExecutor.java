package org.eclipse.qvtd.pivot.qvtimperative.evaluation;

import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.pivot.internal.complete.StandardLibraryInternal;
import org.eclipse.ocl.pivot.internal.evaluation.AbstractExecutor;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;

public class BasicQVTiExecutor extends AbstractExecutor implements QVTiExecutor
{
	private static @NonNull QVTiTransformationAnalysis createTransformationAnalysis(@NonNull  QVTiEnvironmentFactory environmentFactory, @NonNull Transformation transformation) {
		QVTiTransformationAnalysis transformationAnalysis = environmentFactory.createTransformationAnalysis();
    	transformationAnalysis.analyzeTransformation(transformation);
		return transformationAnalysis;
	}

    protected final @NonNull Transformation transformation;

	public BasicQVTiExecutor(@NonNull QVTiEnvironmentFactory environmentFactory, @NonNull URI transformationURI) throws IOException {
    	this(environmentFactory, QVTbaseUtil.loadTransformation(ImperativeModel.class, environmentFactory, transformationURI, environmentFactory.keepDebug()));
    }

    public BasicQVTiExecutor(@NonNull QVTiEnvironmentFactory environmentFactory, @NonNull Transformation transformation) {
    	this(environmentFactory, transformation, createTransformationAnalysis(environmentFactory, transformation));
    }

    private BasicQVTiExecutor(@NonNull QVTiEnvironmentFactory environmentFactory, @NonNull Transformation transformation, @NonNull QVTiTransformationAnalysis transformationAnalysis) {
		super(environmentFactory, new QVTiModelManager(transformationAnalysis));
		this.transformation = transformation;
	}

	/**
	 * Adds the model.
	 */
	public void addModel(@NonNull TypedModel typedModel, @NonNull Resource resource) {
		getModelManager().addModel(typedModel, resource);
	}

	@Override
	protected @NonNull EvaluationVisitor createEvaluationVisitor() {
		if (getEvaluationEnvironment() instanceof QVTiEvaluationEnvironment) {
			IQVTiEvaluationVisitor visitor = new QVTiEvaluationVisitor(this);
	        if (environmentFactory.isEvaluationTracingEnabled()) {
	            // decorate the evaluation visitor with tracing support
	        	visitor = new QVTiTracingEvaluationVisitor(visitor);
//	        	((QVTiTracingEvaluationVisitor)visitor).setVerboseLevel(QVTiTracingEvaluationVisitor.VERBOSE_LEVEL_HIGH);
	        }
			return visitor;
		}
		else {
			return super.createEvaluationVisitor();
		}
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
	protected @NonNull EvaluationEnvironment createNestedEvaluationEnvironment(@NonNull EvaluationEnvironment evaluationEnvironment, @NonNull NamedElement executableObject) {
		if (evaluationEnvironment instanceof QVTiEvaluationEnvironment) {
			return new QVTiNestedEvaluationEnvironment((QVTiEvaluationEnvironment) evaluationEnvironment, executableObject);
		}
		else{
			return super.createNestedEvaluationEnvironment(evaluationEnvironment, executableObject);
		}
	}

	@Override
	protected @NonNull EvaluationEnvironment createRootEvaluationEnvironment(@NonNull NamedElement executableObject) {
		if (executableObject instanceof Transformation) {
			return new QVTiRootEvaluationEnvironment(this, (Transformation) executableObject);
		}
		else {
			return super.createRootEvaluationEnvironment(executableObject);
		}
	}

	public Boolean execute() {
		initializeEvaluationEnvironment(transformation);
		getRootEvaluationEnvironment();
        StandardLibraryInternal standardLibrary = environmentFactory.getStandardLibrary();
		Variable ownedContext = QVTbaseUtil.getContextVariable(standardLibrary, transformation);
		add(ownedContext, getModelManager().getTransformationInstance(transformation));
        for (TypedModel typedModel : transformation.getModelParameter()) {
        	if (typedModel != null) {
	            ownedContext = QVTbaseUtil.getContextVariable(standardLibrary, typedModel);
	            add(ownedContext, getModelManager().getTypedModelInstance(typedModel));
        	}
        }
        return executeInternal();
	}

	protected Boolean executeInternal() {
        EvaluationVisitor visitor = getEvaluationVisitor();
		return (Boolean) transformation.accept(visitor);
	}

	@Override
	public @NonNull QVTiEnvironmentFactory getEnvironmentFactory() {
		return (QVTiEnvironmentFactory) super.getEnvironmentFactory();
	}
	
	@Override
	public @NonNull QVTiModelManager getModelManager() {
		return (QVTiModelManager) modelManager;
	}
	
	public @NonNull Transformation getTransformation() {
		return transformation;
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

	public void loadModel(@NonNull String name, @NonNull URI modelURI, String contentType) {
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
