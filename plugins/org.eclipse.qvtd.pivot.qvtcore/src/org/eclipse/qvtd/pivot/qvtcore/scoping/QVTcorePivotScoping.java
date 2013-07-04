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
package org.eclipse.qvtd.pivot.qvtcore.scoping;

import java.util.Comparator;
import java.util.Set;

import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreUtil;

public class QVTcorePivotScoping
{	
	private static final class GuardVariableDisambiguator implements Comparator<Variable>
	{
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
//		Map<EClassifier, Attribution> registry = Attribution.REGISTRY;
		EnvironmentView.addDisambiguator(Variable.class, new GuardVariableDisambiguator());
	}
}
