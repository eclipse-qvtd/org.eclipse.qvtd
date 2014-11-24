package org.eclipse.qvtd.build.qvtrtoqvtc.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Package;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.qvtd.build.qvtrtoqvtc.QvtrToQvtcTransformation;
import org.eclipse.qvtd.build.qvtrtoqvtc.RuleBindings;
import org.eclipse.qvtd.build.qvtrtoqvtc.Rule;
import org.eclipse.qvtd.build.qvtrtoqvtc.utilities.TransformationTraceData;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.QVTcoreFactory;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.QVTcoreBaseFactory;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;

public class TopLevelRelationToMappingForEnforcement extends AbstractRule
{
	
	private class SubRecord extends AbstractRule.AbstractSubRecord
	{
		
		public final @NonNull  Mapping m;
		public @Nullable String dn;
		public @Nullable String tmn;
		public final @NonNull RelationDomain rd;
		public final @NonNull TypedModel dir;
		public final @NonNull List<org.eclipse.ocl.examples.pivot.Package> up;
		public final @NonNull DomainPattern dp;
		public final @NonNull List<Variable> domainVars;
		public final @NonNull ObjectTemplateExp te;
		public final @NonNull Variable tev;
		public final @NonNull List<RelationDomain> rOppositeDomains;
		public GuardPattern mg;
		public BottomPattern mb;
		public RealizedVariable tcv;
		public ArrayList<Variable> mbVars;
		public CoreDomain md;
		
		public SubRecord(Rule rule, Mapping m, RelationDomain rd, TypedModel dir, List<Package> up,
				DomainPattern dp, List<Variable> domainVars, ObjectTemplateExp te,
				Variable tev, List<RelationDomain> rOppositeDomains) {
			super(rule);
			this.m = m;
			this.rd = rd;
			this.dir = dir;
			this.up = up;
			this.dp = dp;
			this.domainVars = domainVars;
			this.te = te;
			this.tev = tev;
			this.rOppositeDomains = rOppositeDomains;
		}

		
	}

	// Relations
	private static final @NonNull RuleBindings.KeySet RELATIONS_BINDINGS = new RuleBindings.KeySet();
	private static final @NonNull RuleBindings.Key<Relation> RELATIONS_r = RELATIONS_BINDINGS.create((Relation)null, "r");
//	private static final @NonNull RelationsBindings.Key<Set<RelationDomain>> RELATIONS_rds = RELATIONS_BINDINGS.create((Set<RelationDomain>)null, "rds");
//	private static final @NonNull RelationsBindings.Key<RelationDomain> RELATIONS_rd = RELATIONS_BINDINGS.create((RelationDomain)null, "rd");
//	private static final @NonNull RelationsBindings.Key<TypedModel> RELATIONS_dir = RELATIONS_BINDINGS.create((TypedModel)null, "dir");;
//	private static final @NonNull RelationsBindings.Key<DomainPattern> RELATIONS_dp = RELATIONS_BINDINGS.create((DomainPattern)null, "dp");
//	private static final @NonNull RelationsBindings.Key<Set<Variable>> RELATIONS_domainVars = RELATIONS_BINDINGS.create((Set<Variable>)null, "domainVars");
//	private static final @NonNull RelationsBindings.Key<ObjectTemplateExp> RELATIONS_te = RELATIONS_BINDINGS.create((ObjectTemplateExp)null, "te");
//	private static final @NonNull RelationsBindings.Key<Variable> RELATIONS_tev = RELATIONS_BINDINGS.create((Variable)null, "tev");
	
	// Core
	private static final @NonNull RuleBindings.Key<Mapping> CORE_m = RELATIONS_BINDINGS.create((Mapping)null, "m");
//	private static final @NonNull CoreBindings.Key<CoreDomain> CORE_md = CORE_BINDINGS.create((CoreDomain)null, "md");
	
	// Primitives
//	private RelationalTransformation rt;
//	private Transformation mt;
	private String rn;
//	private String dn;
//	private String tmn;
//	private Set<RelationDomain> rOppositeDomains;
//	private GuardPattern dg;

	public Transformation mt;
	private Rule executedRule;
	
	protected final @NonNull List<SubRecord> subRecords = new ArrayList<SubRecord>();
	

	public TopLevelRelationToMappingForEnforcement(@NonNull QvtrToQvtcTransformation transformation) {
		super(transformation);
	}

	// One Mapping per domain
	public void check() {
		Relation r = ruleBindings.get(RELATIONS_r);
		rn = r.getName();
		assert (r != null);
		for (Domain d : r.getDomain()) {
			RelationDomain rd = (RelationDomain) d;
			if (rd.getPattern().getTemplateExpression() instanceof ObjectTemplateExp) {
				Mapping m = QVTcoreFactory.eINSTANCE.createMapping();
				TypedModel dir = rd.getTypedModel();
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
				subRecords.add(new SubRecord(this, m, rd, dir, up, dp, domainVars, te, tev, rOppositeDomains));
			}
		}
	}
	
	public void instantiateOutput() {
		assert mt != null;
		for (SubRecord subRecord : subRecords) {
			subRecord.m.setName(rn+'_'+subRecord.dn);
			subRecord.m.setTransformation(mt);
			subRecord.mg = QVTcoreBaseFactory.eINSTANCE.createGuardPattern();
			subRecord.mg.setArea(subRecord.m);
			subRecord.mb = QVTcoreBaseFactory.eINSTANCE.createBottomPattern();
			subRecord.mb.setArea(subRecord.m);
			subRecord.tcv = QVTcoreBaseFactory.eINSTANCE.createRealizedVariable();
			subRecord.mb.getBindsTo().add(subRecord.tcv);
			subRecord.mbVars = new ArrayList<Variable>();
			subRecord.md = QVTcoreBaseFactory.eINSTANCE.createCoreDomain();
			subRecord.md.setName(subRecord.dn);
			subRecord.md.setIsEnforceable(true);
			for (org.eclipse.qvtd.build.qvtrtoqvtc.Rule.SubRecord sr : executedRule.getSubRecords()) {
				
			}
			
		}
	}

	public @NonNull RuleBindings.KeySet getRuleBindingsKeys() {
		return RELATIONS_BINDINGS;
	}
	
	public @NonNull List<? extends SubRecord> getSubRecords() {
		return subRecords;
	}
	
	@Override
	public boolean when(TransformationTraceData traceData) {
		Relation r = ruleBindings.get(RELATIONS_r);
		RelationalTransformation rt = (RelationalTransformation) r.getTransformation();
		RelationalTransformationToMappingTransformation rtTomtRule = new RelationalTransformationToMappingTransformation(transformation, rt);
		executedRule = traceData.getRecord(rtTomtRule.getRuleBindings());
		if (executedRule != null && executedRule.hasExecuted()) {
			//mt = executedRule.getCoreBindings().get(RelationalTransformationToMappingTransformation.CORE_mt);
			return true;
		}
		return false;
	}

	
	
	public List<EObject> instantiateOutputElements(Map<Class<? extends EObject>, List<EObject>> outputModelElements) {
		List<EObject> results = new ArrayList<EObject>();
/*		Mapping m = null;
		if (outputModelElements.containsKey(Mapping.class)) {
			
		}
		if (m == null) {
			m = QVTcoreFactory.eINSTANCE.createMapping();
		}
			
		
		
		results.add(m);
		coreBindings.put(CORE_m, m);
		m.setGuardPattern(QVTcoreBaseFactory.eINSTANCE.createGuardPattern());
		BottomPattern mb = QVTcoreBaseFactory.eINSTANCE.createBottomPattern();
		RealizedVariable tcv = QVTcoreBaseFactory.eINSTANCE.createRealizedVariable();
		mb.getBindsTo().add(tcv);
		record.getBindings().put(TopLevelRelationForMappingForEnforcement.tcv, tcv);
		CoreDomain md = QVTcoreBaseFactory.eINSTANCE.createCoreDomain();
		results.add(md);

		coreBindings.put(CORE_md, md);
		if (outputModelElements.containsKey(TypedModel.class)) {
			for (EObject mdir : outputModelElements.get(TypedModel.class)) {
				if (((TypedModel)mdir).getName().equals(tmn)) {
					md.setTypedModel((TypedModel) mdir);
					record.getBindings().put(TopLevelRelationForMappingForEnforcement.mdir, (TypedModel)mdir);
					break;
				}
			}
		} else {	
			// Exception?? The typed model should exist! Executing the transformation
			// rule once dosen't guarantee that all the typed models have been 
			// transformed?
		}
		dg = QVTcoreBaseFactory.eINSTANCE.createGuardPattern();
		md.setGuardPattern(dg);
		record.getBindings().put(TopLevelRelationForMappingForEnforcement.dg, dg);
		BottomPattern db = QVTcoreBaseFactory.eINSTANCE.createBottomPattern();

		Variable mtev = PivotFactory.eINSTANCE.createVariable();
		db.getBindsTo().add(mtev);
		results.add(mtev);
		db.getBindsTo().add(mtev);
		record.getBindings().put(TopLevelRelationForMappingForEnforcement.mtev, mtev); */
		return results;
	}
	

	
	
	@Override
	public void where(TransformationTraceData traceData) {
		// T3
/*		ConstrainedRule rule = new RWhenPatternToMGuardPattern(transformation);
		Rule rwpTomgpRecord = new RelationsBindings(rule).getTraceRecord();
		
		
		// RWhenPatternToMGuardPattern
		rule = new RWhenPatternToMGuardPattern();
		bindings = new Bindings();
		bindings.put(RWhenPatternToMGuardPattern.r, record.getBindings().get(TopLevelRelationForMappingForEnforcement.r));
		bindings.put(RWhenPatternToMGuardPattern.mg, record.getBindings().get(TopLevelRelationForMappingForEnforcement.mg));
		Rule rwpTomgpRecord = rule.creareTraceRecord(bindings);
		transformation.executeRule(rule, rwpTomgpRecord);
		
		// T4
		rule = new DomainVarsSharedWithWhenToDgVars(transformation);
		RelationsBindings innerRelationsBindings = new RelationsBindings(rule);
		Rule dvswwTodvRecord = innerRelationsBindings.getTraceRecord();
		CoreBindings innerCoreBindings = dvswwTodvRecord.getCoreBindings();
		innerRelationsBindings.put(DomainVarsSharedWithWhenToDgVars.RELATIONS_domainVarsSharedWithWhen, domainVarsSharedWithWhen);
		innerCoreBindings.put(DomainVarsSharedWithWhenToDgVars.CORE_dg, dg);
		*/
	}

	@Override
	@NonNull
	public Object getCoreResult() {
		throw new UnsupportedOperationException("This rule is 1 -> *, can't get single core result");
	}
	
}
