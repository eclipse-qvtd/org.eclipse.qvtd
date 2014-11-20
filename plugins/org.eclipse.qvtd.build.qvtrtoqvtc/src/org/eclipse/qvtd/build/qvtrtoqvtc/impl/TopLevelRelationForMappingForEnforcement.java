package org.eclipse.qvtd.build.qvtrtoqvtc.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.qvtd.build.qvtrtoqvtc.ConstrainedRule;
import org.eclipse.qvtd.build.qvtrtoqvtc.CoreBindings;
import org.eclipse.qvtd.build.qvtrtoqvtc.PrimitivesBindings;
import org.eclipse.qvtd.build.qvtrtoqvtc.QvtrToQvtcTransformation;
import org.eclipse.qvtd.build.qvtrtoqvtc.RelationsBindings;
import org.eclipse.qvtd.build.qvtrtoqvtc.RelationsBindings.Key;
import org.eclipse.qvtd.build.qvtrtoqvtc.utilities.TransformationTraceData;
import org.eclipse.qvtd.build.qvtrtoqvtc.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.impl.TypedModelImpl;
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
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;

public class TopLevelRelationForMappingForEnforcement extends AbstractRule
{
	// Relations
	private static final @NonNull RelationsBindings.KeySet RELATIONS_BINDINGS = new RelationsBindings.KeySet();
	private static final @NonNull RelationsBindings.Key<Relation> RELATIONS_r = RELATIONS_BINDINGS.create((Relation)null, "r");
	private static final @NonNull RelationsBindings.Key<Set<RelationDomain>> RELATIONS_rds = RELATIONS_BINDINGS.create((Set<RelationDomain>)null, "rds");
	private static final @NonNull RelationsBindings.Key<RelationDomain> RELATIONS_rd = RELATIONS_BINDINGS.create((RelationDomain)null, "rd");
	private static final @NonNull RelationsBindings.Key<TypedModel> RELATIONS_dir = RELATIONS_BINDINGS.create((TypedModel)null, "dir");;
	private static final @NonNull RelationsBindings.Key<DomainPattern> RELATIONS_dp = RELATIONS_BINDINGS.create((DomainPattern)null, "dp");
	private static final @NonNull RelationsBindings.Key<Set<Variable>> RELATIONS_domainVars = RELATIONS_BINDINGS.create((Set<Variable>)null, "domainVars");
	private static final @NonNull RelationsBindings.Key<ObjectTemplateExp> RELATIONS_te = RELATIONS_BINDINGS.create((ObjectTemplateExp)null, "te");
	private static final @NonNull RelationsBindings.Key<Variable> RELATIONS_tev = RELATIONS_BINDINGS.create((Variable)null, "tev");
	
	// Core
	private static final @NonNull CoreBindings.KeySet CORE_BINDINGS = new CoreBindings.KeySet();
	private static final @NonNull CoreBindings.Key<Mapping> CORE_m = CORE_BINDINGS.create((Mapping)null, "m");
	private static final @NonNull CoreBindings.Key<CoreDomain> CORE_md = CORE_BINDINGS.create((CoreDomain)null, "md");
	// Primitives
	private static final @NonNull PrimitivesBindings.KeySet PRIMITIVES_BINDINGS = new PrimitivesBindings.KeySet();
	private static final @NonNull PrimitivesBindings.Key<RelationalTransformation> PRIMITIVES_rt = PRIMITIVES_BINDINGS.create((RelationalTransformation)null, "rt");
	private static final @NonNull PrimitivesBindings.Key<Transformation> PRIMITIVES_mt = PRIMITIVES_BINDINGS.create((Transformation)null, "mt");
	private static final @NonNull PrimitivesBindings.Key<String> PRIMITIVES_rn = PRIMITIVES_BINDINGS.create((String)null, "rn");
	private static final @NonNull PrimitivesBindings.Key<String> PRIMITIVES_dn = PRIMITIVES_BINDINGS.create((String)null, "dn");
	private static final @NonNull PrimitivesBindings.Key<String> PRIMITIVES_tmn = PRIMITIVES_BINDINGS.create((String)null, "tmn");
	private static final @NonNull PrimitivesBindings.Key<Set<RelationDomain>> PRIMITIVES_rOppositeDomains = PRIMITIVES_BINDINGS.create((Set<RelationDomain>)null, "rOppositeDomains");
	private static final @NonNull PrimitivesBindings.Key<GuardPattern> PRIMITIVES_dg = PRIMITIVES_BINDINGS.create((GuardPattern)null, "dg");


	public TopLevelRelationForMappingForEnforcement(@NonNull QvtrToQvtcTransformation transformation) {
		super(transformation);
	}
	
	public @NonNull CoreBindings.KeySet getCoreBindingsKeys() {
		return CORE_BINDINGS;
	}

	public @NonNull PrimitivesBindings.KeySet getPrimitivesBindingsKeys() {
		return PRIMITIVES_BINDINGS;
	}

	public @NonNull RelationsBindings.KeySet getRelationsBindingsKeys() {
		return RELATIONS_BINDINGS;
	}
	
	public @NonNull List<RelationsBindings> findInputMatches(@NonNull Resource inputModel) {
		List<RelationsBindings> loopData = new ArrayList<RelationsBindings>();
		TreeIterator<EObject> it = inputModel.getAllContents();
		while(it.hasNext()) {
			EObject eo = it.next();
			if (eo instanceof Relation) {
				Relation r = (Relation) eo;
				for (Domain d : ((Relation)eo).getDomain()) {
					RelationDomain rd = (RelationDomain) d;
					if (rd.getPattern().getTemplateExpression() instanceof ObjectTemplateExp) {
						RelationsBindings bindings = new RelationsBindings(this);
						bindings.put(RELATIONS_r, r);
						@SuppressWarnings("unchecked")
						Set<RelationDomain> rds = new HashSet<RelationDomain>((Collection<? extends RelationDomain>) r.getDomain());
						bindings.put(RELATIONS_rds, rds);
						bindings.put(RELATIONS_rd, rd);
						bindings.put(RELATIONS_dir, rd.getTypedModel());
						bindings.put(RELATIONS_dp, rd.getPattern());
						Set<Variable> domainVars = new HashSet<Variable>((Collection<Variable>) rd.getPattern().getBindsTo());
						bindings.put(RELATIONS_domainVars, domainVars);
						bindings.put(RELATIONS_te, (ObjectTemplateExp)rd.getPattern().getTemplateExpression());
						bindings.put(RELATIONS_tev, rd.getPattern().getTemplateExpression().getBindsTo());
						loopData.add(bindings);
					}
				}
			} 
		}
		return loopData;
	}
	
	@Override
	public boolean when(@NonNull TransformationTraceData traceData) {
		
		Relation r = relationsBindings.get(RELATIONS_r);
		RelationalTransformation rt = (RelationalTransformation) r.getTransformation();
		RelationalTransformationToMappingTransformation rtTomtRule = new RelationalTransformationToMappingTransformation(transformation, rt);
		Rule traceRule = traceData.getRecotd(rtTomtRule.getRelationsBindings());
		if (traceRule == null)
			return false;
		
		mt = traceRule.getCoreRoot();
		/*
				
		

		primitivesBindings.put(PRIMITIVES_mt, innerCoreBindings.get(RelationalTransformationToMappingTransformation.CORE_MT));
		if (r != null && rd != null && r.getDomain().contains(rd)
				&& r.getTransformation().equals(rt)
				&& rd.getTypedModel().getTransformation().equals(rt)) {
			relationsBindings.put(RELATIONS_r, r);
			relationsBindings.put(RELATIONS_rd, rd);
			primitivesBindings.put(PRIMITIVES_rn, r.getName());
			primitivesBindings.put(PRIMITIVES_dn, rd.getName());
			primitivesBindings.put(PRIMITIVES_tmn, rd.getTypedModel().getName());
			return true;
		} else {
			return false;
		}
		*/
	}

	
	
	public List<EObject> instantiateOutputElements(Map<Class<? extends EObject>, List<EObject>> outputModelElements, @NonNull CoreBindings coreBindings) {
		PrimitivesBindings primitivesBindings = coreBindings.getPrimitivesBindings();
		List<EObject> results = new ArrayList<EObject>();
		Mapping m = null;
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
			String tmn = primitivesBindings.get(PRIMITIVES_tmn);
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
		GuardPattern dg = QVTcoreBaseFactory.eINSTANCE.createGuardPattern();

		primitivesBindings.put(PRIMITIVES_dg, dg);
		md.setGuardPattern(dg);
		record.getBindings().put(TopLevelRelationForMappingForEnforcement.dg, dg);
		BottomPattern db = QVTcoreBaseFactory.eINSTANCE.createBottomPattern();

		Variable mtev = PivotFactory.eINSTANCE.createVariable();
		db.getBindsTo().add(mtev);
		results.add(mtev);
		db.getBindsTo().add(mtev);
		record.getBindings().put(TopLevelRelationForMappingForEnforcement.mtev, mtev);
		return results;
	}
	
	
	public void setAttributes(@NonNull CoreBindings coreBindings) {
		PrimitivesBindings primitivesBindings = coreBindings.getPrimitivesBindings();
		Mapping mapping = coreBindings.get(CORE_m);
		CoreDomain coreDomain = coreBindings.get(CORE_md);
		Transformation mt = primitivesBindings.get(PRIMITIVES_mt);
		String rn = primitivesBindings.get(PRIMITIVES_rn);
		String dn = primitivesBindings.get(PRIMITIVES_dn);
		mapping.setName(rn+'_'+dn);
		mapping.setTransformation(mt);
		coreDomain.setName(dn);
		coreDomain.setIsEnforceable(true);
	}
	

	
	
	@Override
	public void where(@NonNull CoreBindings coreBindings) {
		PrimitivesBindings primitivesBindings = coreBindings.getPrimitivesBindings();
		GuardPattern dg = primitivesBindings.get(PRIMITIVES_dg);
		Set<Variable> domainVarsSharedWithWhen = primitivesBindings.get(PRIMITIVES_domainVars);		// FIXME never assigned
		
		// T3
		ConstrainedRule rule = new RWhenPatternToMGuardPattern(transformation);
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
		
	}
	
}
