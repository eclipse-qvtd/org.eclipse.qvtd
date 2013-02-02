/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.pivot.qvtrelation.scoping;

import java.util.Comparator;
import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.scoping.Attribution;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage;
import org.eclipse.qvtd.pivot.qvtrelation.attributes.KeyAttribution;
import org.eclipse.qvtd.pivot.qvtrelation.attributes.RelationAttribution;
import org.eclipse.qvtd.pivot.qvtrelation.attributes.RelationDomainAttribution;
import org.eclipse.qvtd.pivot.qvtrelation.attributes.RelationModelAttribution;

public class QVTrelationPivotScoping
{	
	private static final class FunctionDisambiguator implements Comparator<Function>
	{
		@SuppressWarnings("null")
		public int compare(Function match1, Function match2) {
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
			if (!match1.getParameterTypes().equals(match2.getParameterTypes())) {
				return false;
			}
			return (match1.getQueryExpression() != null) && (match2.getQueryExpression() == null);
		}
	}

	public static void init() {
		Map<EClassifier, Attribution> registry = Attribution.REGISTRY;
		registry.put(QVTrelationPackage.Literals.KEY, KeyAttribution.INSTANCE);
		registry.put(QVTrelationPackage.Literals.RELATION, RelationAttribution.INSTANCE);
		registry.put(QVTrelationPackage.Literals.RELATION_DOMAIN, RelationDomainAttribution.INSTANCE);
		registry.put(QVTrelationPackage.Literals.RELATION_MODEL, RelationModelAttribution.INSTANCE);
		EnvironmentView.addDisambiguator(Function.class, new FunctionDisambiguator());
	}
}
