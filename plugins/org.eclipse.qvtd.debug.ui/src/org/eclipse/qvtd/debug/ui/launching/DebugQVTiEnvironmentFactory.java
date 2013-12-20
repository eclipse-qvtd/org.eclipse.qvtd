package org.eclipse.qvtd.debug.ui.launching;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.qvtd.debug.utils.DebugNestedEvaluationEnvironment;
import org.eclipse.qvtd.debug.utils.IDebugEvaluationEnvironment;
import org.eclipse.qvtd.debug.vm.IQVTODebuggerShell;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;

public class DebugQVTiEnvironmentFactory extends QVTiEnvironmentFactory
{
	private IQVTODebuggerShell shell;
	
	public DebugQVTiEnvironmentFactory(EPackage.Registry reg, @NonNull MetaModelManager metaModelManager) {
		super(reg, metaModelManager);
	}

	@Override
	public @NonNull IDebugEvaluationEnvironment createEvaluationEnvironment(@NonNull EvaluationEnvironment parent) {
		return new DebugNestedEvaluationEnvironment((IDebugEvaluationEnvironment) parent);
	}

	@Override
	public boolean keepDebug() {
		return true;
	}

	public void setShell(IQVTODebuggerShell shell) {
		this.shell = shell;
	}
}
