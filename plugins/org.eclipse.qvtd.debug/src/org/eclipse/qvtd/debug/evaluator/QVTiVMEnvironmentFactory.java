package org.eclipse.qvtd.debug.evaluator;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.debug.vm.IVMDebuggerShell;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.IQVTiEvaluationEnvironment;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;

public class QVTiVMEnvironmentFactory extends QVTiEnvironmentFactory
{
	private IVMDebuggerShell shell;
	private long envId = 0;
	
	public QVTiVMEnvironmentFactory(EPackage.Registry reg, @NonNull MetaModelManager metaModelManager) {
		super(reg, metaModelManager);
	}

	@Override
	public @NonNull IQVTiVMEvaluationEnvironment createEvaluationEnvironment(@NonNull IQVTiEvaluationEnvironment parent, @NonNull NamedElement operation) {
		return new QVTiVMNestedEvaluationEnvironment((IQVTiVMEvaluationEnvironment) parent, ++envId, operation);
	}

	@Override
	public boolean keepDebug() {
		return true;
	}

	public void setShell(IVMDebuggerShell shell) {
		this.shell = shell;
	}
}
