package org.eclipse.qvtd.build.qvtrtoqvtc.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Package;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.qvtd.build.qvtrtoqvtc.QVTr2QVTcRelations;
import org.eclipse.qvtd.build.qvtrtoqvtc.QvtrToQvtcTransformation;
import org.eclipse.qvtd.build.qvtrtoqvtc.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
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
			return null;
		}
	}
	
	private class SubRecord 
	{
		// Relations
		@NonNull private RelationDomain rd;
		@SuppressWarnings("unused")
		@NonNull private TypedModel dir;
		@NonNull private String tmn;
		@NonNull private String dn;
		@NonNull private List<Package> up;
		@NonNull private ObjectTemplateExp te;
		@NonNull private Variable tev;
		@NonNull private List<RelationDomain> rOppositeDomains;
		@NonNull private List<Variable> domainVars;
		
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
		@SuppressWarnings("unused")
		@Nullable public List<Variable> mbvars;
		
		
		public SubRecord(@NonNull RelationDomain rd, @NonNull TypedModel dir,
				@NonNull String tmn, @NonNull String dn,
				@NonNull List<Package> up,@NonNull List<Variable> domainVars,
				@NonNull ObjectTemplateExp te, @NonNull Variable tev,
				@NonNull List<RelationDomain> rOppositeDomains) {
			this.rd = rd;
			this.dir = dir;
			this.tmn = tmn;
			this.dn = dn;
			this.up = up;
			this.te = te;
			this.tev = tev;
			this.domainVars = domainVars;
			this.rOppositeDomains = rOppositeDomains;
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
				assert dn != null;
				TypedModel dir = rd.getTypedModel();
				String tmn = dir.getName();
				assert tmn != null;
				List<Package> up = dir.getUsedPackage();
				assert up != null;
				DomainPattern dp = rd.getPattern();
				List<Variable> domainVars = dp.getBindsTo();
				ObjectTemplateExp te = (ObjectTemplateExp) dp.getTemplateExpression();
				Variable tev = te.getBindsTo();
				assert tev != null;
				List<RelationDomain> rOppositeDomains = new ArrayList<RelationDomain>();
				Iterator<Domain> it = r.getDomain().iterator();
				while (it.hasNext()) {
					rOppositeDomains.add((RelationDomain) it.next());
				}
				rOppositeDomains.remove(rd);
				subRecords.add(new SubRecord(rd, dir, tmn, dn, up, domainVars, te, tev, rOppositeDomains));
			}
		}
	}

	public @NonNull RuleBindings.KeySet getRuleBindingsKeys() {
		return RULE_BINDINGS;
	}
	
	public void instantiateOutput() {
		Relation r = ruleBindings.get(RELATIONS_r);
		assert (r != null) && (mt != null);
		for (SubRecord subRecord : subRecords) {
			Mapping m = transformation.findMapping(rn+'_'+subRecord.dn, mt);
			assert m != null;
			subRecord.m = m;
			GuardPattern mg = transformation.findGuardPattern(m);
			assert mg != null;
			subRecord.mg = mg;
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
						break;
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
			CoreDomain md = subRecord.md;
			assert (md != null);
			md.setTypedModel(subRecord.mdir);
			BottomPattern mb = subRecord.mb;
			RealizedVariable tcv = subRecord.tcv;
			assert (mb != null) && (tcv != null);
			mb.getBindsTo().add(tcv);
			BottomPattern db = subRecord.db;
			Variable mtev = subRecord.mtev;
			assert (db != null) && (tcv != null);
			db.getBindsTo().add(mtev);
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
				RelationalTransformation rt = (RelationalTransformation) r.getTransformation();
				assert rt != null;
				// This is the same code the factory has, and IMHO its better encapsulated by the factory.
				// The real issue is that the bindings needs a rule and to get a record (rule) we need a binding
				//Rule whenRule = RelationalTransformationToMappingTransformation.FACTORY.createRule(transformation, rt);
				RelationalTransformationToMappingTransformation whenRule = new RelationalTransformationToMappingTransformation(transformation, rt); 
				RuleBindings whenBindings = whenRule.getRuleBindings();
				RelationalTransformationToMappingTransformation whenRuleRecord = (RelationalTransformationToMappingTransformation) transformation.getRecord(whenBindings);
				if (whenRuleRecord != null && whenRuleRecord.hasExecuted()) {
					mt = (Transformation) whenRuleRecord.getCore();
					assert mt != null;
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public void where() {
		QVTr2QVTcRelations relations = new QVTr2QVTcRelations(transformation);
		Relation r = ruleBindings.get(RELATIONS_r);
		assert r != null;
		Set<Predicate> rpSet = new HashSet<Predicate>();
		Set<Variable> whereVars = new HashSet<Variable>();
		Set<Variable> whenVars = new HashSet<Variable>();
		if (r.getWhen() != null) {
			whenVars.addAll(r.getWhen().getBindsTo());
		}
		if (r.getWhere() != null) {
			rpSet.addAll(relations.rejectRelationCallPredicates(r.getWhere().getPredicate()));
			whereVars.addAll(r.getWhere().getBindsTo());
		}
		Set<Variable> allDomainVars = relations.getAllDomainVars(r);
		Set<Variable> sharedDomainVars = relations.getSharedDomainVars(r);
		Set<Variable> unsharedWhereVars = new HashSet<Variable>(whereVars);
		unsharedWhereVars.removeAll(whenVars);
		unsharedWhereVars.removeAll(allDomainVars);
		unsharedWhereVars.addAll(sharedDomainVars);
		Set<Variable> unsharedWhenVars = new HashSet<Variable>(whenVars);
		unsharedWhenVars.removeAll(allDomainVars);
		for (SubRecord subRecord : subRecords) {
			Set<Variable> oppositeDomainVars = new HashSet<Variable>();
			//= rOppositeDomains->iterate(d; vars: Set(essentialocl::Variable) = Set{} |
			// vars->union(d.oclAsType(qvtrelation::RelationDomain).pattern.bindsTo));
			for (Domain d : subRecord.rOppositeDomains) {
				if (((RelationDomain)d).getPattern() != null) {
					oppositeDomainVars.addAll(((RelationDomain)d).getPattern().getBindsTo());
				}
			}
			Set<Variable> domainBottomUnSharedVars = new HashSet<Variable>(subRecord.domainVars);
			domainBottomUnSharedVars.removeAll(whenVars);
			domainBottomUnSharedVars.removeAll(sharedDomainVars);
			Set<Predicate> predicatesWithVarBindings = relations.filterOutPredicatesThatReferToVars(rpSet, domainBottomUnSharedVars);
			Set<Predicate> predicatesWithoutVarBindings = new HashSet<Predicate>(rpSet);
			predicatesWithoutVarBindings.removeAll(predicatesWithVarBindings);
			Set<Variable> domainVarsSharedWithWhen = new HashSet<Variable>(subRecord.domainVars);
			domainVarsSharedWithWhen.retainAll(whenVars);
			Set<Variable> unboundDomainVars;
			
			RealizedVariable mtev = relations.doRVarToMRealizedVar(subRecord.tev);
			assert mtev != null;
			subRecord.mtev = mtev;
			RealizedVariable tcv = relations.doRelationDomainToTraceClassVar(r, subRecord.rd);
			assert tcv != null;
			subRecord.tcv = tcv;
			List<Variable> mbvars = relations.doRVarSetToMVarSet(new ArrayList<Variable>(unsharedWhereVars));
			subRecord.mbvars = mbvars;
			GuardPattern dg = subRecord.dg;
			assert dg != null;
			relations.doDomainVarsSharedWithWhenToDgVars(domainVarsSharedWithWhen, dg);
			// TODO implement TROppositeDomainsToMappingForEnforcement
			GuardPattern mg = subRecord.mg;
			assert mg != null;
			relations.doRWhenPatternToMGuardPattern(r, mg);
			final BottomPattern db = subRecord.db;
			assert db != null;
			relations.doRDomainToMDBottomForEnforcement(r, subRecord.rd, subRecord.te, predicatesWithoutVarBindings, domainBottomUnSharedVars, db);
			Mapping m = subRecord.m;
			assert m!= null;
			final BottomPattern mb = m.getBottomPattern();
			assert mb != null;
			subRecord.mb = mb;
			relations.doRPredicateSetToMBPredicateSet(new ArrayList<Predicate>(predicatesWithVarBindings), mb);
		}
	}
	
}
