/*******************************************************************************
 * Copyright (c) 2012, 2025 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtrelation.scoping;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.ParameterTypes;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.internal.scoping.Attribution;
import org.eclipse.ocl.pivot.internal.scoping.EnvironmentView;
import org.eclipse.ocl.pivot.internal.scoping.EnvironmentView.Disambiguator;
import org.eclipse.ocl.pivot.internal.scoping.Attribution.AttributionRegistryInstaller;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage;
import org.eclipse.qvtd.pivot.qvtrelation.attributes.KeyAttribution;
import org.eclipse.qvtd.pivot.qvtrelation.attributes.RelationAttribution;
import org.eclipse.qvtd.pivot.qvtrelation.attributes.RelationDomainAttribution;

public class QVTrelationPivotScoping
{
	private static final class FunctionDisambiguator extends Disambiguator<@NonNull Function>
	{
		@Override
		public int compare(@NonNull StandardLibrary standardLibrary, @NonNull Function match1, @NonNull Function match2) {
			if (isDefinitionOf(match1, match2)) {
				return 1;				// match2 inferior
			}
			if (isDefinitionOf(match2, match1)) {
				return -1;				// match1 inferior
			}
			return 0;
		}

		private boolean isDefinitionOf(@NonNull Function match1, @NonNull Function match2) {
			//				if (!match1.getName().equals(match2.getName())) {
			//					return false;
			//				}
			if (!new ParameterTypes(match1.getOwnedParameters()).equals(new ParameterTypes(match2.getOwnedParameters()))) {
				return false;			// XXX Optimize to avoid redundant construction
			}
			return (match1.getQueryExpression() != null) && (match2.getQueryExpression() == null);
		}
	}

	public static void init() {
		AttributionRegistryInstaller registryInstaller = Attribution.REGISTRY.getInstaller(QVTrelationPivotScoping.class);
		registryInstaller.install(QVTrelationPackage.Literals.KEY, KeyAttribution.INSTANCE);
		registryInstaller.install(QVTrelationPackage.Literals.RELATION, RelationAttribution.INSTANCE);
		//		registryInstaller.install(QVTrelationPackage.Literals.RELATION_CALL_EXP, RelationCallExpAttribution.INSTANCE);
		registryInstaller.install(QVTrelationPackage.Literals.RELATION_DOMAIN, RelationDomainAttribution.INSTANCE);
		EnvironmentView.addDisambiguator(Function.class, new FunctionDisambiguator());
	}
}
