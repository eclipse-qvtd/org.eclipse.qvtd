package org.eclipse.qvtd.debug.ui.launching;

import org.eclipse.emf.common.util.DiagnosticException;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.qvtd.debug.core.EvaluationContext;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;

public class DebugRunnerFactory extends TransformationRunnerFactory {
	
	public DebugRunnerFactory() {
		super();
	}

	public @NonNull QVTiEnvironmentFactory createEnvironmentFactory() {
		EPackage.Registry registry = this.packageRegistry != null ? this.packageRegistry : EPackage.Registry.INSTANCE;
		return new DebugQVTiEnvironmentFactory(registry, new MetaModelManager());
	}
	
	protected @NonNull TransformationRunner createRunner(@NonNull EvaluationContext evaluationContext, @NonNull QVTiEnvironmentFactory envFactory) {
		return new DebugTransformationRunner(evaluationContext, envFactory);
	}

	@Override
	public @NonNull DebugTransformationRunner createRunner(@NonNull EvaluationContext evaluationContext) throws DiagnosticException {
		return (DebugTransformationRunner) super.createRunner(evaluationContext);
	}
}
