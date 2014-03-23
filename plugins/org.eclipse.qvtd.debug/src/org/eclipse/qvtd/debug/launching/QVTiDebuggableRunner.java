package org.eclipse.qvtd.debug.launching;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.debug.launching.DebuggableRunner;
import org.eclipse.ocl.examples.debug.vm.ValidBreakpointLocator;
import org.eclipse.qvtd.debug.QVTiDebugPlugin;
import org.eclipse.qvtd.debug.core.QVTiEvaluationContext;
import org.eclipse.qvtd.debug.vm.QVTiIsBreakpointableVisitor;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;

public class QVTiDebuggableRunner extends DebuggableRunner<Transformation>
{
	public static final @NonNull ValidBreakpointLocator validBreakpointLocator = new ValidBreakpointLocator(QVTiIsBreakpointableVisitor.INSTANCE);
	
	public QVTiDebuggableRunner(@NonNull QVTiEvaluationContext evaluationContext, @NonNull QVTiEnvironmentFactory envFactory) {
		super(evaluationContext.getTransformationURI(), new QVTiInternalDebuggableExecutor(evaluationContext, envFactory));
	}

	protected @NonNull String getPluginId() {
		return QVTiDebugPlugin.PLUGIN_ID;
	}

	@Override
	public @NonNull ValidBreakpointLocator getValidBreakpointLocator() {
		return validBreakpointLocator;
	}
}