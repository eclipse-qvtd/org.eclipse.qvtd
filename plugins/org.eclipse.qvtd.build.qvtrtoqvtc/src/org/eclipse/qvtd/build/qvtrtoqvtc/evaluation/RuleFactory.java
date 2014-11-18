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
		//ConstrainedRule rule3 = new TopLevelRelationForMappingForEnforcement(transformation);
		rules.add(rule1);
		rules.add(rule2);
		//rules.add(rule3);
		return rules;
	}
	
	

}
