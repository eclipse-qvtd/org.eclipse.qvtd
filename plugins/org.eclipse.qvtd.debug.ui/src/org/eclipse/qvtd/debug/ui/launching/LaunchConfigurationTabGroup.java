/*******************************************************************************
 * Copyright (c) 2014, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     R.Dvorak and others - QVTo debugger framework
 *     E.D.Willink - revised API for OCL/QVTi debugger framework
 *******************************************************************************/
package org.eclipse.qvtd.debug.ui.launching;

import java.util.List;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.jdt.annotation.NonNull;

public abstract class LaunchConfigurationTabGroup extends AbstractLaunchConfigurationTabGroup
{
	protected void setTabs(@NonNull List<ILaunchConfigurationTab> tabList) {
		ILaunchConfigurationTab[] tabs = new ILaunchConfigurationTab[tabList.size()];
		int i = 0;
		for (ILaunchConfigurationTab tab : tabList) {
			tabs[i] = tab;
			i++;
		}
		setTabs(tabs);
	}
}
