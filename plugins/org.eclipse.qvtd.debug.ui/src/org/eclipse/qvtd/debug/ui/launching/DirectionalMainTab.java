/*******************************************************************************
 * Copyright (c) 2014, 2017 Willink Transformations and others.
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.CompilerChain;
import org.eclipse.qvtd.compiler.CompilerChain.Key;
import org.eclipse.qvtd.debug.launching.QVTcLaunchConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;

public abstract class DirectionalMainTab<TX> extends MainTab<TX> implements QVTcLaunchConstants
{
	private Composite directionGroup;
	protected Combo modeCombo;
	protected Combo directionCombo;
	protected Button viewCheckButton;

	@Override
	protected void createDirectionGroup(Group txGroup) {
		directionGroup = new Composite(txGroup, SWT.NONE);
		GridLayout gl_directionGroup = new GridLayout(5, false);
		gl_directionGroup.marginWidth = 0;
		gl_directionGroup.marginHeight = 0;
		directionGroup.setLayout(gl_directionGroup);
		directionGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));

		Label modeLabel = new Label(directionGroup, SWT.NONE);
		modeLabel.setSize(31, 15);
		modeLabel.setText("Mode");

		modeCombo = new Combo(directionGroup, SWT.NONE);
		modeCombo.setToolTipText("Whether the execution\n- checks that the output corresponds to the input\n- creates new output model elements\n- updates existing model elements where possible ");
		modeCombo.setItems(new String[] {/*CHECK_MODE,*/ ENFORCE_CREATE_MODE, /*ENFORCE_UPDATE_MODE*/});
		modeCombo.select(0);

		Label directionLabel = new Label(directionGroup, SWT.NONE);
		directionLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1));
		directionLabel.setText("Direction");

		directionCombo = new Combo(directionGroup, SWT.NONE);
		directionCombo.setToolTipText("Select enforceable output domain to choose the direction of a multi-directional transformation");
		directionCombo.setItems(new String[] {"NONE"});
		directionCombo.select(0);

		viewCheckButton = new Button(directionGroup, SWT.CHECK);
		viewCheckButton.setToolTipText("Whether the output may be a view of a larger model, or must be the whole model.");
		viewCheckButton.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1));
		viewCheckButton.setText("Partial View");
		viewCheckButton.setEnabled(false);
	}

	@Override
	public void dispose() {
		cancelCompileJob(true);
		super.dispose();
	}

	@Override
	protected @NonNull String getDirection() {
		return directionCombo.getText();
	}

	@Override
	protected void initializeInternal(@NonNull ILaunchConfiguration configuration) throws CoreException {
		super.initializeInternal(configuration);
		List<String> directions = new ArrayList<String>();
		if (newOutputsGroup != null) {
			for (Control child : newOutputsGroup.getChildren()) {
				if (child instanceof ParameterRow) {
					directions.add(((ParameterRow)child).name.getText());
				}
			}
		}
		Collections.sort(directions);
		directionCombo.setItems(directions.toArray(new String[directions.size()]));
		directionCombo.setText(configuration.getAttribute(DIRECTION_KEY, "NONE"));
		modeCombo.setText(configuration.getAttribute(MODE_KEY, ENFORCE_CREATE_MODE));
		viewCheckButton.setSelection(configuration.getAttribute(VIEW_KEY, false));
	}

	@Override
	protected void initializeOptions(@NonNull Map<@NonNull String, @Nullable Map<@NonNull Key<Object>, @Nullable Object>> options) {
		super.initializeOptions(options);
		initializeURIOption(options, CompilerChain.QVTU_STEP);
		initializeURIOption(options, CompilerChain.QVTM_STEP);
		initializeURIOption(options, CompilerChain.QVTS_STEP);
		initializeURIOption(options, CompilerChain.QVTI_STEP);
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		super.performApply(configuration);
		configuration.setAttribute(DIRECTION_KEY, directionCombo.getText());
		configuration.setAttribute(MODE_KEY, modeCombo.getText());
		configuration.setAttribute(VIEW_KEY, viewCheckButton.getSelection());
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		super.setDefaults(configuration);
		configuration.setAttribute(DIRECTION_KEY, "NONE");
		configuration.setAttribute(MODE_KEY, ENFORCE_CREATE_MODE);
		configuration.setAttribute(VIEW_KEY, false);
	}

	protected void setDirections(@NonNull Set<@NonNull String> enforceableDirectionNamees) {
		//		System.out.println("setDirections");
		if (directionCombo.isDisposed()) {
			return;
		}
		String oldText = directionCombo.getText();
		String[] directionItems = new String[enforceableDirectionNamees.size()];
		int newIndex = -1;
		int i = 0;
		for (@NonNull String name : enforceableDirectionNamees) {
			if (ClassUtil.safeEquals(name, oldText)) {
				newIndex = i;
			}
			directionItems[i++] = name;
		}
		Arrays.sort(directionItems);
		directionCombo.setItems(directionItems);
		directionCombo.select(newIndex >= 0 ? newIndex : 0);
	}
}
