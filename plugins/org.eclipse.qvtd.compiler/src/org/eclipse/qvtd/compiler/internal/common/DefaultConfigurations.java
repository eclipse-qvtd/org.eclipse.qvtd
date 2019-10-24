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

import java.util.Collections;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.UniqueList;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;

/**
 * A DefaultConfigurations comprises a TypedModelsConfiguration for each checkable/enforceable TypedModel
 * as an output and all other TYpedMpdels as inputs.
 * is specifued by name and all other TYpedModels are inputs.
 *
 * This is appropriate for a multidirectional transformation with no internedfiate domains.
 */
public class DefaultConfigurations extends TypedModelsConfigurations
{

	public DefaultConfigurations() {}

	@Override
	public @Nullable String reconcile(@NonNull Transformation transformation) {
		List<@NonNull TypedModel> outputTypedModels = new UniqueList<>();
		for (@NonNull Rule rule : QVTbaseUtil.getOwnedRules(transformation)) {
			for (@NonNull Domain domain : QVTbaseUtil.getOwnedDomains(rule)) {
				if (domain.isIsCheckable() || domain.isIsEnforceable()) {
					outputTypedModels.add(QVTbaseUtil.getTypedModel(domain));
				}
			}
		}
		Collections.sort(outputTypedModels, NameUtil.NAMEABLE_COMPARATOR);
		for (final @NonNull TypedModel typedModel : outputTypedModels) {
			TypedModelsConfiguration targetConfiguration = new TypedModelsConfiguration()
			{
				@Override
				public @NonNull String getTargetName() {
					return QVTbaseUtil.getName(typedModel);
				}
			};
			targetConfiguration.addTypedModelConfiguration(new TypedModelConfiguration(typedModel, TypedModelConfiguration.Mode.OUTPUT));
			add(targetConfiguration);
		}
		return super.reconcile(transformation);
	}
}
