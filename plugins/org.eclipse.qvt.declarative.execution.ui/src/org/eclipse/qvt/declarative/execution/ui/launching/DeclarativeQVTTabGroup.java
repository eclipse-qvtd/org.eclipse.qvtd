package org.eclipse.qvt.declarative.execution.ui.launching;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.CommonTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.qvt.declarative.execution.ui.launching.configuration.DeclarativeQVTMainTab;

public class DeclarativeQVTTabGroup extends AbstractLaunchConfigurationTabGroup {

	public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
		ILaunchConfigurationTab[] tabs = new ILaunchConfigurationTab[] {
				new DeclarativeQVTMainTab(),
				new CommonTab()
		};

		setTabs(tabs);
	}

}
