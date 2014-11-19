package org.eclipse.qvtd.build.qvtrtoqvtc.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import org.eclipse.qvtd.build.qvtrtoqvtc.TraceRecord;
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

public class TopLevelRelationForMappingForEnforcement extends AbstractRule
{
	// Relations
	private static final @NonNull RelationsBindings.KeySet RELATIONS_BINDINGS = new RelationsBindings.KeySet();
	private static final @NonNull RelationsBindings.Key<Relation> RELATIONS_r = RELATIONS_BINDINGS.create((Relation)null, "r");
	private static final @NonNull RelationsBindings.Key<RelationDomain> RELATIONS_rd = RELATIONS_BINDINGS.create((RelationDomain)null, "rd");
	// Core
	private static final @NonNull CoreBindings.KeySet CORE_BINDINGS = new CoreBindings.KeySet();
	private static final @NonNull CoreBindings.Key<Mapping> CORE_m = CORE_BINDINGS.create((Mapping)null, "m");
	private static final @NonNull CoreBindings.Key<CoreDomain> CORE_md = CORE_BINDINGS.create((CoreDomain)null, "md");
	// Primitives
	private static final @NonNull PrimitivesBindings.KeySet PRIMITIVES_BINDINGS = new PrimitivesBindings.KeySet();
	private static final @NonNull PrimitivesBindings.Key<Transformation> PRIMITIVES_mt = PRIMITIVES_BINDINGS.create((Transformation)null, "mt");
	private static final @NonNull PrimitivesBindings.Key<String> PRIMITIVES_rn = PRIMITIVES_BINDINGS.create((String)null, "rn");
	private static final @NonNull PrimitivesBindings.Key<String> PRIMITIVES_dn = PRIMITIVES_BINDINGS.create((String)null, "dn");
	private static final @NonNull PrimitivesBindings.Key<String> PRIMITIVES_tmn = PRIMITIVES_BINDINGS.create((String)null, "tmn");
	private static final @NonNull PrimitivesBindings.Key<List<EObject>> PRIMITIVES_rOppositeDomains = PRIMITIVES_BINDINGS.create((List<EObject>)null, "rOppositeDomains");
	private static final @NonNull PrimitivesBindings.Key<GuardPattern> PRIMITIVES_dg = PRIMITIVES_BINDINGS.create((GuardPattern)null, "dg");
	private static final @NonNull PrimitivesBindings.Key<Set<Variable>> PRIMITIVES_domainVars = PRIMITIVES_BINDINGS.create((Set<Variable>)null, "domainVars");

	public TopLevelRelationForMappingForEnforcement(@NonNull QvtrToQvtcTransformation transformation) {
		super(transformation);
	}
	
	public @NonNull List<RelationsBindings> findInputMatches(@NonNull Resource inputModel) {
		List<RelationsBindings> loopData = new ArrayList<RelationsBindings>();
		EClass rEClass = QVTrelationFactory.eINSTANCE.createRelation().eClass();
		TreeIterator<EObject> it = inputModel.getAllContents();
		while(it.hasNext()) {
			EObject eo = it.next();
			if (eo.eClass().equals(rEClass)) {
				for (Domain rd : ((Relation)eo).getDomain()) {
					RelationsBindings bindings = new RelationsBindings(this);
					bindings.put(RELATIONS_rd, (RelationDomain)rd);
					List<EObject> rOppositeDomains = new ArrayList<EObject>(((Relation)eo).getDomain());
//					rOppositeDomains.remove(rd);
//					args.add(rOppositeDomains);
//					bindings.put(RELATIONS_xxx, rOppositeDomains);
					loopData.add(bindings);
				}
			} 
			/*
			else if(eo.eClass().getEAllSuperTypes().contains(rtEClass)) {
			}
			rn = r.getName();
			RelationDomain rd = record.getBindings().get(TopLevelRelationForMappingForEnforcement.rd);
			dn = rd.getName();
			tmn = record.getBindings().get(TopLevelRelationForMappingForEnforcement.dir).getName();
			rOppositeDomains = new HashSet<RelationDomain>(record.getBindings().get(TopLevelRelationForMappingForEnforcement.rds));
			rOppositeDomains.remove(rd);
			return true;
		}
		return false;
			*/
		}
		return loopData;
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
	
	public List<EObject> instantiateOutputElements(Map<Class<? extends EObject>, List<EObject>> outputModelElements, @NonNull CoreBindings coreBindings) {
		PrimitivesBindings primitivesBindings = coreBindings.getPrimitivesBindings();
		List<EObject> results = new ArrayList<EObject>();
		// There should't be any other mapping with the same name!
		Mapping m = QVTcoreFactory.eINSTANCE.createMapping();
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
	
//	@Override
	public boolean when(List<Object> inputElements, @NonNull RelationsBindings relationsBindings) {
		PrimitivesBindings primitivesBindings = relationsBindings.getPrimitivesBindings();
		RelationalTransformation rt;
		Relation r = null;
		RelationDomain rd = null;
		for (Object e : inputElements) {
			if (e instanceof Relation) {
				r = (Relation) e;
			} else if (e instanceof RelationDomain) {
				rd = (RelationDomain) e;
			} else if (e instanceof List) {
				@SuppressWarnings("unchecked") List<EObject> castE = (List<EObject>) e;
				primitivesBindings.put(PRIMITIVES_rOppositeDomains, castE);
			} else {
				// Exception?
				System.out.println("Wrong type for trace.");
			}
		}
		assert r != null;
		rt = (RelationalTransformation) r.getTransformation();
		RelationalTransformationToMappingTransformation rtTomtRule = new RelationalTransformationToMappingTransformation(transformation);
		RelationsBindings innerRelationsBindings = new RelationsBindings(rtTomtRule);
		CoreBindings innerCoreBindings = innerRelationsBindings.getCoreBindings();
		innerRelationsBindings.put(RelationalTransformationToMappingTransformation.RELATIONS_rt, rt);
//		TraceRecord rtTomtRecord = transformation.executeTopLevelRule(innerRelationsBindings);
		primitivesBindings.put(PRIMITIVES_mt, innerCoreBindings.get(RelationalTransformationToMappingTransformation.CORE_MT));
		if (r != null && rd != null && r.getDomain().contains(rd)
				&& r.getTransformation().equals(rt)
				&& rd.getTypedModel().getTransformation().equals(rt)) {
			relationsBindings.put(RELATIONS_r, r);
			relationsBindings.put(RELATIONS_rd, rd);
			primitivesBindings.put(PRIMITIVES_rn, r.getName());
			primitivesBindings.put(PRIMITIVES_dn, rd.getName());
			primitivesBindings.put(PRIMITIVES_tmn, rd.getTypedModel().getName());
			primitivesBindings.put(PRIMITIVES_domainVars, new HashSet<Variable>(rd.getPattern().getBindsTo()));
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public void where(@NonNull CoreBindings coreBindings) {
		PrimitivesBindings primitivesBindings = coreBindings.getPrimitivesBindings();
		GuardPattern dg = primitivesBindings.get(PRIMITIVES_dg);
		Set<Variable> domainVarsSharedWithWhen = primitivesBindings.get(PRIMITIVES_domainVars);		// FIXME never assigned
		
		// T3
		ConstrainedRule rule = new RWhenPatternToMGuardPattern(transformation);
		TraceRecord rwpTomgpRecord = new RelationsBindings(rule).getTraceRecord();
		
		
		// RWhenPatternToMGuardPattern
		rule = new RWhenPatternToMGuardPattern();
		bindings = new Bindings();
		bindings.put(RWhenPatternToMGuardPattern.r, record.getBindings().get(TopLevelRelationForMappingForEnforcement.r));
		bindings.put(RWhenPatternToMGuardPattern.mg, record.getBindings().get(TopLevelRelationForMappingForEnforcement.mg));
		TraceRecord rwpTomgpRecord = rule.creareTraceRecord(bindings);
		transformation.executeRule(rule, rwpTomgpRecord);
		
		// T4
		rule = new DomainVarsSharedWithWhenToDgVars(transformation);
		RelationsBindings innerRelationsBindings = new RelationsBindings(rule);
		TraceRecord dvswwTodvRecord = innerRelationsBindings.getTraceRecord();
		CoreBindings innerCoreBindings = dvswwTodvRecord.getCoreBindings();
		innerRelationsBindings.put(DomainVarsSharedWithWhenToDgVars.RELATIONS_domainVarsSharedWithWhen, domainVarsSharedWithWhen);
		innerCoreBindings.put(DomainVarsSharedWithWhenToDgVars.CORE_dg, dg);
		
	}
	
}
