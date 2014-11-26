package org.eclipse.qvtd.build.qvtrtoqvtc.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.qvtd.build.qvtrtoqvtc.QvtrToQvtcTransformation;
import org.eclipse.qvtd.build.qvtrtoqvtc.Rule;
import org.eclipse.qvtd.build.qvtrtoqvtc.impl.RelationToTraceClass.SubRecord;
import org.eclipse.qvtd.pivot.qvtcore.CoreModel;
import org.eclipse.qvtd.pivot.qvtcore.QVTcoreFactory;
import org.eclipse.qvtd.pivot.qvtrelation.RelationModel;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;

public class RelationalModelToCoreModel extends AbstractRule {
	
	
	private static class Factory extends AbstractRule.Factory
	{

		@Override
		public @Nullable Rule createRule(
				@NonNull QvtrToQvtcTransformation transformation,
				@NonNull EObject eo) {
			Rule rule = null;
			if (eo instanceof RelationModel) {	
				rule = new RelationalModelToCoreModel(transformation, (RelationModel) eo);
				Rule tracedRule = transformation.getRecord(rule.getRuleBindings());
				if (tracedRule != null)
					rule = tracedRule;
			}
			return null;
		}

		@Override
		public @Nullable Rule createRule(
				@NonNull QvtrToQvtcTransformation transformation,
				@NonNull List<EObject> eos) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
	private class SubRecord {
		
	}
	
	public static final @NonNull Rule.Factory FACTORY = new Factory(); 
	
	private static final @NonNull RuleBindings.KeySet RULE_BINDINGS = new RuleBindings.KeySet();
	public static final @NonNull RuleBindings.RuleKey<RelationModel> RELATIONS_rm = RULE_BINDINGS.createRoot((RelationModel)null, "rm");

	private String rmn;
	private CoreModel cm;
	
	protected final @NonNull List<SubRecord> subRecords = new ArrayList<SubRecord>();
	
	protected RelationalModelToCoreModel(@NonNull QvtrToQvtcTransformation transformation, @NonNull RelationModel rm) {
		super(transformation);
		ruleBindings.put(RELATIONS_rm, rm);
	}
	
	@Override
	public void check() {
		RelationModel rm = ruleBindings.get(RELATIONS_rm);
		assert rm != null;
		rmn = rm.getName();
		for (org.eclipse.ocl.examples.pivot.Package p : rm.getNestedPackage()) {
			if (p instanceof RelationalTransformation) {
				subRecords.add(new SubRecord(p));
			}
		}
	}

	@Override
	@NonNull
	public Object getCoreResult() {
		
		return cm;
	}
	
	public @NonNull RuleBindings.KeySet getRuleBindingsKeys() {
		return RULE_BINDINGS;
	}
	
	@Override
	public void instantiateOutput() {
		cm = QVTcoreFactory.eINSTANCE.createCoreModel();
		assert cm != null;
		transformation.addOrphan(cm);
	}
	
	

}
