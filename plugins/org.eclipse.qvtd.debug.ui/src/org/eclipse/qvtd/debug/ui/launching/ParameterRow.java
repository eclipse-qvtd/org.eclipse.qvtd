/*******************************************************************************
 * Copyright (c) 2013, 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.debug.ui.launching;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.debug.vm.ui.launching.LaunchingUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class ParameterRow extends Composite implements ModifyListener
{
	protected @NonNull MainTab mainTab;
	protected @NonNull Label name;
	protected @NonNull Text path;

	public ParameterRow(@NonNull MainTab mainTab, @NonNull Group group, int style, @NonNull String parameterName, @NonNull String parameterPath) {
		super(group, style);
		this.mainTab = mainTab;
		setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		
		createDerivedButtons();
		
		name = new Label(this, SWT.NONE);
		name.setText(parameterName);
		name.setSize(80,15);
		
		path = new Text(this, SWT.BORDER);
		path.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		path.setText(parameterPath);
		
		Button browseWS = new Button(this, SWT.NONE);
		browseWS.setText("Browse Workspace...");
		Button browseFile = new Button(this, SWT.NONE);
		browseFile.setText("Browse File...");

		path.addModifyListener(this);
		boolean isSave = (style & SWT.SAVE) != 0;
		LaunchingUtils.prepareBrowseWorkspaceButton(browseWS, name.getText(), path, isSave);
		LaunchingUtils.prepareBrowseFileSystemButton(browseFile, path, isSave);

		GridLayout gridLayout = new GridLayout(getChildren().length, false);
		gridLayout.marginHeight = 0;
		gridLayout.marginWidth = 0;
		gridLayout.verticalSpacing = 0;
		setLayout(gridLayout);
	}

	protected void createDerivedButtons() {}

	@Override
	public void modifyText(ModifyEvent e) {
		mainTab.updateLaunchConfigurationDialog();
	}
}
