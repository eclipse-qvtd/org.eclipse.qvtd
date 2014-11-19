/*******************************************************************************
 * Copyright (c) 2014 The University of York and Willink Transformations.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Horacio Hoyos - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.build.qvtrtoqvtc.evaluation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.build.qvtrtoqvtc.ConstrainedRule;
import org.eclipse.qvtd.build.qvtrtoqvtc.QvtrToQvtcTransformation;
import org.eclipse.qvtd.build.qvtrtoqvtc.impl.RelationToTraceClass;
import org.eclipse.qvtd.build.qvtrtoqvtc.impl.RelationalTransformationToMappingTransformation;


public class RuleFactory {
	
		
	public RuleFactory() {
		
	}

	public List<ConstrainedRule> createTopRules(@NonNull QvtrToQvtcTransformation transformation) {
		List<ConstrainedRule> rules = new ArrayList<ConstrainedRule>();
		ConstrainedRule rule1 = new RelationalTransformationToMappingTransformation(transformation);
		ConstrainedRule rule2 = new RelationToTraceClass(transformation);
		rules.add(rule1);
		rules.add(rule2);
		//ConstrainedRule rule3 = new TopLevelRelationForMappingForEnforcement(transformation);
		//rules.add(rule3);
		return rules;
	}
	
}
