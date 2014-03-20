package org.eclipse.qvtd.debug.launching;

import org.eclipse.emf.common.util.DiagnosticException;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.qvtd.debug.core.QVTiEvaluationContext;
import org.eclipse.qvtd.debug.evaluator.QVTiVMEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;

public class VMDebuggableRunnerFactory extends DebuggableRunnerFactory {
	
	public VMDebuggableRunnerFactory() {
		super();
	}

	public @NonNull QVTiEnvironmentFactory createEnvironmentFactory() {
		EPackage.Registry registry = this.packageRegistry != null ? this.packageRegistry : EPackage.Registry.INSTANCE;
		return new QVTiVMEnvironmentFactory(registry, new MetaModelManager());
	}
	
	protected @NonNull DebuggableRunner createRunner(@NonNull QVTiEvaluationContext evaluationContext, @NonNull QVTiEnvironmentFactory envFactory) {
		return new VMDebuggableRunner(evaluationContext, envFactory);
	}

	@Override
	public @NonNull VMDebuggableRunner createRunner(@NonNull QVTiEvaluationContext evaluationContext) throws DiagnosticException {
		return (VMDebuggableRunner) super.createRunner(evaluationContext);
	}
}
