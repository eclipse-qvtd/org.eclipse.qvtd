package org.eclipse.qvtd.build.qvtrtoqvtc.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.qvtd.build.qvtrtoqvtc.Bindings;
import org.eclipse.qvtd.build.qvtrtoqvtc.QvtrToQvtcTransformation;
import org.eclipse.qvtd.build.qvtrtoqvtc.TraceRecord;
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

public class TopLevelRelationForMappingForEnforcement extends AbstractRule {

	// Relations
	public static final BindingKey<Relation> r = new BindingKey<Relation>("r");
	public static final BindingKey<Set<RelationDomain>> rds = new BindingKey<Set<RelationDomain>>("rds");
	public static final BindingKey<RelationDomain> rd = new BindingKey<RelationDomain>("rd");
	public static final BindingKey<TypedModel> dir = new BindingKey<TypedModel>("dir");
	public static final BindingKey<DomainPattern> dp = new BindingKey<DomainPattern>("dp");
	public static final BindingKey<Set<Variable>> domainVars = new BindingKey<Set<Variable>>("domainVars");
	public static final BindingKey<ObjectTemplateExp> te = new BindingKey<ObjectTemplateExp>("te");
	public static final BindingKey<Variable> tev = new BindingKey<Variable>("tev");
	
	//Relation r;
	//RelationDomain rd;

	// Core
	public static final BindingKey<Mapping> m = new BindingKey<Mapping>("m");
	public static final BindingKey<GuardPattern> mg = new BindingKey<GuardPattern>("mg");
	public static final BindingKey<BottomPattern> mb = new BindingKey<BottomPattern>("mb");
	public static final BindingKey<Set<Variable>> vs = new BindingKey<Set<Variable>>("vs");
	public static final BindingKey<RealizedVariable> tcv = new BindingKey<RealizedVariable>("tcv");
	public static final BindingKey<CoreDomain> md = new BindingKey<CoreDomain>("md");
	public static final BindingKey<TypedModel> mdir = new BindingKey<TypedModel>("mdir");
	public static final BindingKey<GuardPattern> dg = new BindingKey<GuardPattern>("dg");
	public static final BindingKey<BottomPattern> db = new BindingKey<BottomPattern>("db");
	public static final BindingKey<Variable> mtev = new BindingKey<Variable>("mtev");
	
	
	//Mapping m;
	//CoreDomain md;
	
	private String rn, dn, tmn;
	private RelationalTransformation rt;
	private Set<RelationDomain> rOppositeDomains;
	private Transformation mt;
	private Set<Variable> mbVars;
	private Set<Variable> domainVarsSharedWithWhen;
	
	
	@Override
	public boolean when(QvtrToQvtcTransformation transformation) {
		Relation r = record.getBindings().get(TopLevelRelationForMappingForEnforcement.r);
		if (r.isIsTopLevel()) {
			rt = (RelationalTransformation) r.getTransformation();
			RelationalTransformationToMappingTransformation rtTomtRule = new RelationalTransformationToMappingTransformation();
			Bindings bindings = new Bindings();
			// We ony care for mt, so we only need to have been executed once
			bindings.put(RelationalTransformationToMappingTransformation.rt, rt);
			bindings.put(RelationalTransformationToMappingTransformation.rtm, rt.getModelParameter().get(0));
			TraceRecord rtTomtRecord = transformation.executeRule(rtTomtRule, bindings);
			mt = rtTomtRecord.getBindings().get(RelationalTransformationToMappingTransformation.mt);
			if (mt != null) {
				rn = r.getName();
				RelationDomain rd = record.getBindings().get(TopLevelRelationForMappingForEnforcement.rd);
				dn = rd.getName();
				tmn = record.getBindings().get(TopLevelRelationForMappingForEnforcement.dir).getName();
				rOppositeDomains = new HashSet<RelationDomain>(record.getBindings().get(TopLevelRelationForMappingForEnforcement.rds));
				rOppositeDomains.remove(rd);
				return true;
			}
		}
		return false;
	}
	
	public List<EObject> instantiateOutputElements(Map<Class<? extends EObject>, List<EObject>> outputModelElements) {
		List<EObject> results = new ArrayList<EObject>();
		// There should't be any other mapping with the same name!
		Mapping m = QVTcoreFactory.eINSTANCE.createMapping();
		results.add(m);
		record.getBindings().put(TopLevelRelationForMappingForEnforcement.m, m);
		GuardPattern mg = QVTcoreBaseFactory.eINSTANCE.createGuardPattern();
		results.add(mg);
		m.setGuardPattern(mg);
		record.getBindings().put(TopLevelRelationForMappingForEnforcement.mg, mg);
		BottomPattern mb = QVTcoreBaseFactory.eINSTANCE.createBottomPattern();
		results.add(mb);
		m.setBottomPattern(mb);
		record.getBindings().put(TopLevelRelationForMappingForEnforcement.mb, mb);
		RealizedVariable tcv = QVTcoreBaseFactory.eINSTANCE.createRealizedVariable();
		results.add(tcv);
		mb.getBindsTo().add(tcv);
		record.getBindings().put(TopLevelRelationForMappingForEnforcement.tcv, tcv);
		CoreDomain md = QVTcoreBaseFactory.eINSTANCE.createCoreDomain();
		results.add(md);
		record.getBindings().put(TopLevelRelationForMappingForEnforcement.md, md);
		if (outputModelElements.containsKey(TypedModel.class)) {
			for (EObject mdir : outputModelElements.get(TypedModel.class)) {
				if (((TypedModel)mdir).getName().equals(tmn)) {
					md.setTypedModel((TypedModel) mdir);
					record.getBindings().put(TopLevelRelationForMappingForEnforcement.mdir, mdir);
					break;
				}
			}
		} else {	
			// Exception?? The typed model should exist! Executing the transformation
			// rule once dosen't guarantee that all the typed models have been 
			// transformed?
		}
		GuardPattern dg = QVTcoreBaseFactory.eINSTANCE.createGuardPattern();
		results.add(dg);
		md.setGuardPattern(dg);
		record.getBindings().put(TopLevelRelationForMappingForEnforcement.dg, dg);
		BottomPattern db = QVTcoreBaseFactory.eINSTANCE.createBottomPattern();
		results.add(db);
		md.setBottomPattern(db);
		record.getBindings().put(TopLevelRelationForMappingForEnforcement.db, db);
		Variable mtev = PivotFactory.eINSTANCE.createVariable();
		results.add(mtev);
		db.getBindsTo().add(mtev);
		record.getBindings().put(TopLevelRelationForMappingForEnforcement.mtev, mtev);
		return results;
	}
	
	
	public void setAttributes() {
		
		record.getBindings().get(TopLevelRelationForMappingForEnforcement.m).setName(rn+'_'+dn);
		record.getBindings().get(TopLevelRelationForMappingForEnforcement.m).setTransformation(mt);
		record.getBindings().get(TopLevelRelationForMappingForEnforcement.md).setName(dn);
		record.getBindings().get(TopLevelRelationForMappingForEnforcement.md).setIsEnforceable(true);
	}
	
	@Override
	public void where(QvtrToQvtcTransformation transformation) {
		/*
		// T3
		ConstrainedRule rule = new RWhenPatternToMGuardPattern();
		RWhenPatternToMGuardPatternRecord rwpTomgpRecord = rule.creareTraceRecord();
		
		
		
		// T4
		rule = new DomainVarsSharedWithWhenToDgVars();
		DomainVarsSharedWithWhenToDgVarsRecord dvswwTodvRecord = (DomainVarsSharedWithWhenToDgVarsRecord) rule.creareTraceRecord();
		dvswwTodvRecord.setDomainVarsSharedWithWhen(domainVarsSharedWithWhen);
		dvswwTodvRecord.setDg(dg);
		*/
		
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Bindings> findInputMatches(Resource inputModel) {
		List<Bindings> matches = new ArrayList<Bindings>();
		TreeIterator<EObject> it = inputModel.getAllContents();
		while(it.hasNext()) {
			EObject eo = it.next();
			if (eo instanceof Relation) {
				Relation r = (Relation)eo;
				for (Domain d : r.getDomain()) {
					RelationDomain rd = (RelationDomain)d;
					if (rd.getPattern().getTemplateExpression() instanceof ObjectTemplateExp) {
						Bindings bindings = new Bindings();
						bindings.put(TopLevelRelationForMappingForEnforcement.r, r);
						bindings.put(TopLevelRelationForMappingForEnforcement.rds, new HashSet<RelationDomain>((Collection<? extends RelationDomain>) r.getDomain()));
						bindings.put(TopLevelRelationForMappingForEnforcement.rd, rd);
						bindings.put(TopLevelRelationForMappingForEnforcement.dir, rd.getTypedModel());
						bindings.put(TopLevelRelationForMappingForEnforcement.dp, rd.getPattern());
						bindings.put(TopLevelRelationForMappingForEnforcement.domainVars, new HashSet<Variable>((Collection<? extends Variable>) rd.getPattern().getBindsTo()));
						bindings.put(TopLevelRelationForMappingForEnforcement.te, (ObjectTemplateExp)rd.getPattern().getTemplateExpression());
						bindings.put(TopLevelRelationForMappingForEnforcement.tev, rd.getPattern().getTemplateExpression().getBindsTo());
						matches.add(bindings);
					}
				}
			}
		}
		return matches;
	}
	
	

}
