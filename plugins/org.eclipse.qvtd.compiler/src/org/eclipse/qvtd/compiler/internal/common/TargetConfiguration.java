/*******************************************************************************
 * Copyright (c) 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.common;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.pivot.qvtbase.CompoundTargetElement;
import org.eclipse.qvtd.pivot.qvtbase.SimpleTargetElement;
import org.eclipse.qvtd.pivot.qvtbase.Target;
import org.eclipse.qvtd.pivot.qvtbase.TargetElement;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;

/**
 * A TargetConfiguration specifies the use of a Target to determine how each TypedModel is to be used during execution.
 */
public class TargetConfiguration extends TypedModelsConfiguration
{
	public static @NonNull TypedModelsConfigurations createTargetConfigurations(@NonNull String... targetNames) {
		TypedModelsConfigurations typedModelsConfigurations = new TypedModelsConfigurations();
		for (@NonNull String targetName : targetNames) {
			typedModelsConfigurations.add(new TargetConfiguration(targetName));
		}
		return typedModelsConfigurations;
	}

	private final @NonNull String targetName;


	public TargetConfiguration(@NonNull String targetName) {
		this.targetName = targetName;
	}

	protected void addTargetElement(@NonNull SimpleTargetElement simpleTargetElement) {
		TypedModelConfiguration.Mode mode;
		switch (simpleTargetElement.getKind()) {
			case INPUT: mode = TypedModelConfiguration.Mode.INPUT; break;
			case OUTPUT: mode = TypedModelConfiguration.Mode.OUTPUT; break;
			case VIA: mode = TypedModelConfiguration.Mode.INTERMEDIATE; break;
			default: mode = TypedModelConfiguration.Mode.UNUSED; break;
		}
		addTypedModelConfiguration(new TypedModelConfiguration(QVTbaseUtil.getTypedModel(simpleTargetElement), mode));
	}

	@Override
	public @NonNull String getTargetName() {
		return targetName;
	}

	@Override
	public @Nullable String reconcile(@NonNull Transformation transformation) {
		Target target = QVTbaseUtil.getOwnedTarget(transformation, targetName);
		for (@NonNull TargetElement targetElement : QVTbaseUtil.getOwnedTargetElements(target)) {
			if (targetElement instanceof CompoundTargetElement) {
				for (@NonNull SimpleTargetElement simpleTargetElement : QVTbaseUtil.getOwnedTargetElements((CompoundTargetElement)targetElement)) {
					addTargetElement(simpleTargetElement);
				}
			}
			else {
				addTargetElement((SimpleTargetElement)targetElement);
			}
		}
		for (@NonNull TypedModel typedModel : QVTbaseUtil.getModelParameters(transformation)) {
			if (!typedModel.isIsPrimitive() && !typedModel.isIsThis() && !typedModel.isIsTrace()) {
				if (basicGetTypedModelConfiguration(typedModel) == null) {
					addTypedModelConfiguration(new TypedModelConfiguration(typedModel, TypedModelConfiguration.Mode.UNUSED));
				}
			}
		}
		return super.reconcile(transformation);
	}
}
