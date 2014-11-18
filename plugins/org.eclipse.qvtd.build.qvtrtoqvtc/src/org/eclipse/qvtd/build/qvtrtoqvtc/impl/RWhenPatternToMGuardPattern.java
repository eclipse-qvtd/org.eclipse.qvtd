package org.eclipse.qvtd.build.qvtrtoqvtc.impl;

import java.util.Set;

import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.qvtd.build.qvtrtoqvtc.Bindings;
import org.eclipse.qvtd.build.qvtrtoqvtc.ConstrainedRule;
import org.eclipse.qvtd.build.qvtrtoqvtc.QvtrToQvtcTransformation;
import org.eclipse.qvtd.build.qvtrtoqvtc.TraceRecord;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp;

public class RWhenPatternToMGuardPattern extends AbstractRule implements
		ConstrainedRule {
	
	// Relations
	public static final BindingKey<Relation> r = new BindingKey<Relation>("r");
	public static final BindingKey<Pattern> whenp = new BindingKey<Pattern>("whenp");
	public static final BindingKey<Set<Variable>> whenVars = new BindingKey<Set<Variable>>("whenVars");
	
	// Core
	public static final BindingKey<GuardPattern> mg = new BindingKey<GuardPattern>("mg");
	
	private TraceRecord record;

	
	@Override
	public void where(QvtrToQvtcTransformation transformation) {
		RWhenCallToMGuard rule = new RWhenCallToMGuard();
		Pattern rp = record.getBindings().get(RWhenPatternToMGuardPattern.whenp);
		for (Predicate pd : rp.getPredicate()) {
			if (pd.getConditionExpression() instanceof RelationCallExp) {
				RelationCallExp e = (RelationCallExp) pd.getConditionExpression();
				Bindings bindings = new Bindings();
				bindings.put(RWhenCallToMGuard.rp, rp);
				bindings.put(RWhenCallToMGuard.pd, pd);
				bindings.put(RWhenCallToMGuard.e, e);
				bindings.put(RWhenCallToMGuard.r, e.getReferredRelation());
				TraceRecord rwcTomgRecord = rule.creareTraceRecord(bindings);
				transformation.executeRule(rule, rwcTomgRecord);
			}
		}
	}

}
