package org.eclipse.qvtd.build.qvtrtoqvtc.evaluation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.qvtd.build.qvtrtoqvtc.ConstrainedRule;
import org.eclipse.qvtd.build.qvtrtoqvtc.impl.RelationToTraceClass;
import org.eclipse.qvtd.build.qvtrtoqvtc.impl.RelationalTransformationToMappingTransformation;
import org.eclipse.qvtd.build.qvtrtoqvtc.impl.TopLevelRelationForMappingForEnforcement;


public class RuleFactory {
	
		
	public RuleFactory() {
		
	}

	public List<ConstrainedRule> createTopRules() {
		List<ConstrainedRule> rules = new ArrayList<ConstrainedRule>();
		ConstrainedRule rule1 = new RelationalTransformationToMappingTransformation();
		ConstrainedRule rule2 = new RelationToTraceClass();
		ConstrainedRule rule3 = new TopLevelRelationForMappingForEnforcement();
		rules.add(rule1);
		rules.add(rule2);
		rules.add(rule3);
		return rules;
	}
	
	

}
