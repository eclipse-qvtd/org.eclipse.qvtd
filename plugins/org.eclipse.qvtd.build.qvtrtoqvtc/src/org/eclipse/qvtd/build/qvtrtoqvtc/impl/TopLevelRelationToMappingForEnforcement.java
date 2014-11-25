package org.eclipse.qvtd.build.qvtrtoqvtc.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Package;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.qvtd.build.qvtrtoqvtc.QvtrToQvtcTransformation;
import org.eclipse.qvtd.build.qvtrtoqvtc.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.QVTcoreBaseFactory;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;

public class TopLevelRelationToMappingForEnforcement extends AbstractRule
{
	
	private static class Factory extends AbstractRule.Factory
	{
		public @Nullable Rule createRule(@NonNull QvtrToQvtcTransformation transformation, @NonNull EObject eo) {
			Rule rule = null;
			if (eo instanceof Relation) {	
				rule = new TopLevelRelationToMappingForEnforcement(transformation, (Relation) eo);
				Rule tracedRule = transformation.getRecord(rule.getRuleBindings());
				if (tracedRule != null)
					rule = tracedRule;
			}
			return rule;
		}

		@Override
		public @Nullable Rule createRule(
				@NonNull QvtrToQvtcTransformation transformation,
				@NonNull List<EObject> eos) {
			// TODO Auto-generated method stub
			return null;
		}
	}
	
	private class SubRecord 
	{
		// Relations
		@NonNull private RelationDomain rd;
		@NonNull private TypedModel dir;
		@NonNull private String tmn;
		@NonNull private String dn;
		@NonNull private List<Package> up;
		
		// Core
		@Nullable private Mapping m;
		@Nullable private GuardPattern mg;
		@Nullable private BottomPattern mb;
		@Nullable private RealizedVariable tcv;
		@Nullable private CoreDomain md;
		@Nullable private TypedModel mdir;
		@Nullable private GuardPattern dg;
		@Nullable private BottomPattern db;
		@Nullable private Variable mtev;
		
		
		public SubRecord(@NonNull RelationDomain rd, @NonNull TypedModel dir,
				@NonNull String tmn, @NonNull String dn,
				@NonNull List<Package> up) {
			this.rd = rd;
			this.dir = dir;
			this.tmn = tmn;
			this.dn = dn;
			this.up = up;
		}
		
		
		
		
	}

	// Relations
	private static final @NonNull RuleBindings.KeySet RULE_BINDINGS = new RuleBindings.KeySet();
	private static final @NonNull RuleBindings.RuleKey<Relation> RELATIONS_r = RULE_BINDINGS.createRoot((Relation)null, "r");
//	private static final @NonNull RelationsBindings.Key<Set<RelationDomain>> RELATIONS_rds = RELATIONS_BINDINGS.create((Set<RelationDomain>)null, "rds");
//	private static final @NonNull RelationsBindings.Key<RelationDomain> RELATIONS_rd = RELATIONS_BINDINGS.create((RelationDomain)null, "rd");
//	private static final @NonNull RelationsBindings.Key<TypedModel> RELATIONS_dir = RELATIONS_BINDINGS.create((TypedModel)null, "dir");;
//	private static final @NonNull RelationsBindings.Key<DomainPattern> RELATIONS_dp = RELATIONS_BINDINGS.create((DomainPattern)null, "dp");
//	private static final @NonNull RelationsBindings.Key<Set<Variable>> RELATIONS_domainVars = RELATIONS_BINDINGS.create((Set<Variable>)null, "domainVars");
//	private static final @NonNull RelationsBindings.Key<ObjectTemplateExp> RELATIONS_te = RELATIONS_BINDINGS.create((ObjectTemplateExp)null, "te");
//	private static final @NonNull RelationsBindings.Key<Variable> RELATIONS_tev = RELATIONS_BINDINGS.create((Variable)null, "tev");
	
	// Core
	//private static final @NonNull RuleBindings.RuleKey<Mapping> CORE_m = RULE_BINDINGS.create((Mapping)null, "m");
	//private static final @NonNull RuleBindings.RuleKey<GuardPattern> CORE_mg = RULE_BINDINGS.create((GuardPattern)null, "mg");
	//private static final @NonNull RuleBindings.RuleKey<BottomPattern> CORE_mb = RULE_BINDINGS.create((BottomPattern)null, "mb");
	//private static final @NonNull RuleBindings.RuleKey<RealizedVariable> CORE_tcv = RULE_BINDINGS.create((RealizedVariable)null, "tcv");
//	private static final @NonNull CoreBindings.Key<CoreDomain> CORE_md = CORE_BINDINGS.create((CoreDomain)null, "md");
	
	// Shared
	
	
	// Primitives
//	private RelationalTransformation rt;
//	private Transformation mt;
	private String rn;
//	private String dn;
//	private String tmn;
//	private Set<RelationDomain> rOppositeDomains;
//	private GuardPattern dg;

	public Transformation mt;
	
	public static final @NonNull Rule.Factory FACTORY = new Factory(); 
	
	protected final @NonNull List<SubRecord> subRecords = new ArrayList<SubRecord>();

	public TopLevelRelationToMappingForEnforcement(@NonNull QvtrToQvtcTransformation transformation,
			@NonNull Relation r) {
		super(transformation);
		ruleBindings.put(RELATIONS_r, r);
	}

	// One Mapping per domain
	public void check() {
		Relation r = ruleBindings.get(RELATIONS_r);
		rn = r.getName();
		assert (r != null);
		for (Domain d : r.getDomain()) {
			RelationDomain rd = (RelationDomain) d;
			if (rd.getPattern().getTemplateExpression() instanceof ObjectTemplateExp) {
				//Mapping m = QVTcoreFactory.eINSTANCE.createMapping();
				String dn = rd.getName();
				TypedModel dir = rd.getTypedModel();
				String tmn = dir.getName();
				List<Package> up = dir.getUsedPackage();
				DomainPattern dp = rd.getPattern();
				List<Variable> domainVars = dp.getBindsTo();
				ObjectTemplateExp te = (ObjectTemplateExp) dp.getTemplateExpression();
				Variable tev = te.getBindsTo();
				List<RelationDomain> rOppositeDomains = new ArrayList<RelationDomain>();
				Iterator<Domain> it = r.getDomain().iterator();
				while (it.hasNext()) {
					rOppositeDomains.add((RelationDomain) it.next());
				}
				rOppositeDomains.remove(rd);
				subRecords.add(new SubRecord(rd, dir, tmn, dn, up));
			}
		}
	}
	
	@Override
	@NonNull
	public Object getCoreResult() {
		throw new UnsupportedOperationException("This rule is 1 -> *, can't get single core result");
	}

	public @NonNull RuleBindings.KeySet getRuleBindingsKeys() {
		return RULE_BINDINGS;
	}
	
	public void instantiateOutput() {
		Relation r = ruleBindings.get(RELATIONS_r);
		assert (r != null) && (mt != null);
		for (SubRecord subRecord : subRecords) {
			//Mapping m = ruleBindings.get(CORE_m);
			//assert m == null;
			//m =  QVTcoreFactory.eINSTANCE.createMapping();
			//assert m != null;
			Mapping m = transformation.findMapping(rn+'_'+subRecord.dn, mt);
			assert m != null;
			subRecord.m = m;
			GuardPattern mg = transformation.findGuardPattern(m);
			assert mg != null;
			subRecord.mg = mg;
			BottomPattern mb = transformation.findBottomPattern(m);
			assert mb != null;
			subRecord.mb = mb;
			// TODO
			/* The realized variable can't be found until we have a name and a type, 
			   thus the search will return null. If we don't have the key attributes
			   we should ommit instantiation, it will happen in the where clause.
			
			RealizedVariable tcv = QVTcoreBaseFactory.eINSTANCE.createRealizedVariable();
			assert tcv != null;
			subRecord.tcv = tcv;
			*/
			CoreDomain md = transformation.findCoreDomain(subRecord.dn, m);
			assert md != null;
			subRecord.md = md;
			TypedModel mdir = null;
			// This should really be a global search
			for (TypedModel tm : mt.getModelParameter()) {
				if (tm.getName() == subRecord.tmn) {
					if (tm.getUsedPackage().equals(subRecord.up)) {
						mdir = tm;
					}
				}
			}
			assert mdir != null;
			subRecord.mdir = mdir;
			GuardPattern dg = transformation.findGuardPattern(md);
			assert dg != null;
			subRecord.dg = dg;
			BottomPattern db = transformation.findBottomPattern(md);
			assert db != null;
			subRecord.db = db;
			// Ssame as with tcv
			//Variable mtev = PivotFactory.eINSTANCE.createVariable();
			//assert mtev != null;
			//subRecord.mtev = mtev;
			
		}
	}

	
	public void setAttributes() {
		for (SubRecord subRecord : subRecords) {
			BottomPattern mb2 = subRecord.mb;
			assert mb2 != null;
			mb2.getBindsTo().add(subRecord.tcv);
		}
	}	
	
	@Override
	public boolean when() {
		Relation r = ruleBindings.get(RELATIONS_r);
		assert r != null;
		if (r.isIsTopLevel()) {
			boolean isEnforcement = false;
			for (Domain d : r.getDomain()) {
				isEnforcement |= d.isIsEnforceable();
			}
			if (isEnforcement) {
				Rule whenRule = RelationalTransformationToMappingTransformation.FACTORY.createRule(transformation, r.getTransformation());
				if (whenRule != null && whenRule.hasExecuted()) {
					mt = (Transformation) whenRule.getCoreResult();
					assert mt != null;
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public void where() {
		// T6
		for (SubRecord subRecord : subRecords) {
			List<EObject> rdSeq = new ArrayList<EObject>();
			Relation r = ruleBindings.get(RELATIONS_r);
			assert (r != null);
			rdSeq.add(r);
			rdSeq.add(subRecord.rd);
			//RelationDomainToTraceClassVar(rdSeq, tcv);
			Rule innerRule = RelationDomainToTraceClassVar.FACTORY.createRule(transformation, rdSeq);
			if (innerRule != null) {
				assert !innerRule.hasExecuted();
				transformation.executeNestedRule(innerRule);
				RealizedVariable tcv = (RealizedVariable) innerRule.getCoreResult();
				assert tcv != null;
				subRecord.tcv = tcv;
			}
		}
	}
	
}
