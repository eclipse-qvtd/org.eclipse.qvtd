package org.eclipse.qvtd.debug.ui.launching;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.qvtd.debug.evaluator.DebugNestedEvaluationEnvironment;
import org.eclipse.qvtd.debug.evaluator.IDebugEvaluationEnvironment;
import org.eclipse.qvtd.debug.vm.IQVTODebuggerShell;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.IQVTiEvaluationEnvironment;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;

public class DebugQVTiEnvironmentFactory extends QVTiEnvironmentFactory
{
	private IQVTODebuggerShell shell;
	private long envId = 0;
	
	public DebugQVTiEnvironmentFactory(EPackage.Registry reg, @NonNull MetaModelManager metaModelManager) {
		super(reg, metaModelManager);
	}

	@Override
	public @NonNull IDebugEvaluationEnvironment createEvaluationEnvironment(@NonNull IQVTiEvaluationEnvironment parent, @NonNull NamedElement operation) {
		return new DebugNestedEvaluationEnvironment((IDebugEvaluationEnvironment) parent, ++envId, operation);
	}

	@Override
	public boolean keepDebug() {
		return true;
	}

	public void setShell(IQVTODebuggerShell shell) {
		this.shell = shell;
	}
}
