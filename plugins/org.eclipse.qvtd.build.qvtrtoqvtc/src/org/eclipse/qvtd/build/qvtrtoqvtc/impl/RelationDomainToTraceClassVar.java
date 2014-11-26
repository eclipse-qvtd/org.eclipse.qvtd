package org.eclipse.qvtd.build.qvtrtoqvtc.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.qvtd.build.qvtrtoqvtc.QvtrToQvtcTransformation;
import org.eclipse.qvtd.build.qvtrtoqvtc.Rule;
import org.eclipse.qvtd.pivot.qvtcorebase.QVTcoreBaseFactory;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;

public class RelationDomainToTraceClassVar extends AbstractRule implements Rule {

	
	private static class Factory extends AbstractRule.Factory
	{
		public @Nullable Rule createRule(@NonNull QvtrToQvtcTransformation transformation, @NonNull EObject eo) {
			return null;
		}

		@Override
		public @Nullable Rule createRule(
				@NonNull QvtrToQvtcTransformation transformation,
				@NonNull List<EObject> eos) {
			
			Rule rule = null;
			if (eos.size() == 2) {
				Relation r = null;
				RelationDomain d = null;
				for(EObject eo : eos) {
					if (eo instanceof Relation) {	
						r = (Relation) eo;
					}
					if (eo instanceof RelationDomain) {	
						d = (RelationDomain) eo;
					}
				}
				assert (r != null) && (d != null);
				rule = new RelationDomainToTraceClassVar(transformation, r, d);
				Rule tracedRule = transformation.getRecord(rule.getRuleBindings());
				if (tracedRule != null)
					rule = tracedRule;
				
			}
			return rule;
			
		}
	}
	
	
	// Relations
	private static final @NonNull RuleBindings.KeySet RULE_BINDINGS = new RuleBindings.KeySet();
	private static final @NonNull RuleBindings.RuleKey<Relation> RELATIONS_r = RULE_BINDINGS.createRoot((Relation)null, "r");
	private static final @NonNull RuleBindings.RuleKey<RelationDomain> RELATIONS_d = RULE_BINDINGS.createRoot((RelationDomain)null, "d");
	
	// Core
	private static final @NonNull RuleBindings.RuleKey<RealizedVariable> CORE_tcv = RULE_BINDINGS.create((RealizedVariable)null, "tcv");
	
	private String rn, dn;
	private Type tc;
	
	public static final @NonNull Rule.Factory FACTORY = new Factory(); 
	
	protected final @NonNull List<SubRecord> subRecords = new ArrayList<SubRecord>();
	
	
	public RelationDomainToTraceClassVar(
			@NonNull QvtrToQvtcTransformation transformation, @NonNull Relation r,
			@NonNull RelationDomain d) {
		
		super(transformation);
		ruleBindings.put(RELATIONS_r, r);
		ruleBindings.put(RELATIONS_d, d);
	}
	
	@Override
	public void check() {
		rn = ruleBindings.get(RELATIONS_r).getName();
		dn = ruleBindings.get(RELATIONS_d).getName();
	}

	@Override
	@NonNull
	public Object getCoreResult() {
		RealizedVariable tcv = ruleBindings.get(CORE_tcv);
		assert tcv != null;
		return tcv;
	}
	
	public @NonNull RuleBindings.KeySet getRuleBindingsKeys() {
		return RULE_BINDINGS;
	}
	
	@Override
	public void instantiateOutput() {
		
		// TODO change to global search since we have name and type!
		RealizedVariable tcv = QVTcoreBaseFactory.eINSTANCE.createRealizedVariable();
		ruleBindings.put(CORE_tcv, tcv);
		tcv.setName(rn+"_"+dn+"_V");
		tcv.setType(tc);
	}
	
	@Override
	public boolean when() {
		
		Relation r = ruleBindings.get(RELATIONS_r);
		assert r != null;
		//Rule whenRule = RelationToTraceClass.FACTORY.createRule(transformation, r);
		//if (whenRule != null && whenRule.hasExecuted()) {
		//	tc = (Type) whenRule.getCoreResult();
		//	assert tc != null;
		//	return true;
		//}
		return true;
	}
	

}
