package org.eclipse.qvt.declarative.execution.ui.monitoring;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.qvt.declarative.execution.ExecutionService;
import org.eclipse.qvt.declarative.execution.ide.EclipseExecutionServiceConfigurator;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

public class ExecutionEngineMonitorViewPart extends ViewPart {

	@Override
	public void createPartControl(Composite parent) {
		EclipseExecutionServiceConfigurator.assertInitialized();
		TreeViewer viewer = new TreeViewer(parent);
		viewer.setContentProvider(new ExecutionEngineContentProvider());
		viewer.setLabelProvider(new ExecutionEngineLabelProvider());
		viewer.setInput(ExecutionService.getInstance());

	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
