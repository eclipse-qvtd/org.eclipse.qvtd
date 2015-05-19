/*******************************************************************************
 * Copyright (c) 2012, 2014 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtcore.scoping;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.internal.scoping.Attribution;
import org.eclipse.ocl.pivot.internal.scoping.EnvironmentView;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage;
import org.eclipse.qvtd.pivot.qvtcore.attributes.MappingAttribution;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreUtil;

public class QVTcorePivotScoping
{	
	private static final class GuardVariableDisambiguator implements Comparator<Variable>
	{
		@Override
		public int compare(Variable match1, Variable match2) {
			Mapping mapping1 = QVTcoreUtil.getContainingMapping(match1);
			if (mapping1 == null) {
				return 1;				// match2 inferior			
			}
			Mapping mapping2 = QVTcoreUtil.getContainingMapping(match2);
			if (mapping2 == null) {
				return -1;				// match1 inferior			
			}
			Set<Mapping> refinedMappings1 = QVTcoreUtil.getAllRefinedMappings(mapping1);
			if (refinedMappings1.contains(mapping2)) {
				return 1;				// match2 inferior			
			}
			Set<Mapping> refinedMappings2 = QVTcoreUtil.getAllRefinedMappings(mapping2);
			if (refinedMappings2.contains(mapping1)) {
				return -1;				// match1 inferior			
			}
			return 0;
		}
	}
	public static void init() {
		Map<EClassifier, Attribution> registry = Attribution.REGISTRY;
		registry.put(QVTcorePackage.Literals.MAPPING, MappingAttribution.INSTANCE);
		EnvironmentView.addDisambiguator(Variable.class, new GuardVariableDisambiguator());
	}
}
