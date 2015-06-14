package org.eclipse.qvtd.pivot.qvtimperative.evaluation;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.pivot.evaluation.ModelManager;
import org.eclipse.ocl.pivot.internal.evaluation.AbstractExecutor;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;

public class BasicQVTiExecutor extends AbstractExecutor implements QVTiExecutor
{
	public BasicQVTiExecutor(@NonNull QVTiEnvironmentFactory environmentFactory, @NonNull ModelManager modelManager) {
		super(environmentFactory, modelManager);
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

	@Override
	public @NonNull QVTiEnvironmentFactory getEnvironmentFactory() {
		return (QVTiEnvironmentFactory) super.getEnvironmentFactory();
	}
}
