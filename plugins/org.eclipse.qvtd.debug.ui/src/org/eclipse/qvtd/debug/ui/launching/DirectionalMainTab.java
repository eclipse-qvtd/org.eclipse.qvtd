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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.debug.launching.QVTcLaunchConstants;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.swt.widgets.Control;

public abstract class DirectionalMainTab extends MainTab implements QVTcLaunchConstants
{
	@Override
	protected void addListeners() {
		super.addListeners();
		directionCombo.addModifyListener(new DirectionModifyListener());
	}

	@Override
	protected void initializeInternal(@NonNull ILaunchConfiguration configuration) throws CoreException {
		super.initializeInternal(configuration);
		List<String> directions = new ArrayList<String>();
		if (outputsGroup != null) {
			for (Control child : outputsGroup.getChildren()) {
				if (child instanceof ParameterRow) {
					directions.add(((ParameterRow)child).name.getText());
				}
			}
		}
		Collections.sort(directions);
		directionCombo.setItems(directions.toArray(new String[directions.size()]));
		directionCombo.setText(configuration.getAttribute(DIRECTION_KEY, "NONE"));
		modeCombo.setText(configuration.getAttribute(MODE_KEY, "CHECK"));
		partialCheckButton.setSelection(configuration.getAttribute(PARTIAL_KEY, false));
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		super.performApply(configuration);
		configuration.setAttribute(DIRECTION_KEY, directionCombo.getText());
		configuration.setAttribute(MODE_KEY, modeCombo.getText());
		configuration.setAttribute(PARTIAL_KEY, partialCheckButton.getSelection());
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		super.setDefaults(configuration);
		configuration.setAttribute(DIRECTION_KEY, "NONE");
		configuration.setAttribute(MODE_KEY, "CHECK");
		configuration.setAttribute(PARTIAL_KEY, false);
	}

	protected void setDirections(@NonNull Set<TypedModel> enforceables) {
		if (directionCombo.isDisposed()) {
			return;
		}
		String oldText = directionCombo.getText();
		String[] directionItems = new String[enforceables.size()];
		int newIndex = -1;
		int i = 0;
		for (TypedModel typedModel : enforceables) {
			String name = typedModel.getName();
			if (ClassUtil.safeEquals(name, oldText)) {
				newIndex = i;
			}
			directionItems[i++] = name;
		}
		Arrays.sort(directionItems);
		directionCombo.setItems(directionItems);
		directionCombo.select(newIndex >= 0 ? newIndex : 0);
	}

	@Override
	protected void updateDirection(@NonNull Transformation transformation) {
		Set<TypedModel> enforceables = new HashSet<TypedModel>();
		for (Rule rule : transformation.getRule()) {
			for (Domain domain : rule.getDomain()) {
				TypedModel typedModel = domain.getTypedModel();
				if (domain.isIsEnforceable()) {
					enforceables.add(typedModel);
				}
			}
		}
		setDirections(enforceables);
	}
}
