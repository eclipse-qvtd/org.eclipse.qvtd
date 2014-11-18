package org.eclipse.qvtd.build.qvtrtoqvtc.impl;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.qvtd.build.qvtrtoqvtc.Bindings;
import org.eclipse.qvtd.build.qvtrtoqvtc.ConstrainedRule;
import org.eclipse.qvtd.build.qvtrtoqvtc.QvtrToQvtcTransformation;
import org.eclipse.qvtd.build.qvtrtoqvtc.TraceRecord;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;

public class RelationDomainToTraceClassVar extends AbstractRule {

	// Relations
	public static BindingKey<List<Element>> rdSeq = new BindingKey<List<Element>>("rdSeq");
	public static BindingKey<Relation> r = new BindingKey<Relation>("r");
	public static BindingKey<RelationDomain> d = new BindingKey<RelationDomain>("d");
	
	// Core
	public static BindingKey<RealizedVariable> tcv = new BindingKey<RealizedVariable>("tcv");
	
	String rn, dn;
	EClass tc;
	
	@Override
	public boolean when(QvtrToQvtcTransformation transformation, Resource qvtrModel) {
		ConstrainedRule rTotcRule = new RelationToTraceClass();
		List<Bindings> loopData = rTotcRule.findInputMatches(qvtrModel);
		for (TraceRecord rTotcRecord : transformation.executeRuleInLoop(rTotcRule, loopData)) {
			if(rTotcRecord.getBindings().get(RelationToTraceClass.r).equals(record.getBindings().get(RelationDomainToTraceClassVar.r))) {
				tc = rTotcRecord.getBindings().get(RelationToTraceClass.rc);
				rn = record.getBindings().get(RelationDomainToTraceClassVar.r).getName();
				dn = record.getBindings().get(RelationDomainToTraceClassVar.d).getName();
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void setAttributes() {
		record.getBindings().get(RelationDomainToTraceClassVar.tcv).setName(rn+"_"+dn+"_v");
		record.getBindings().get(RelationDomainToTraceClassVar.tcv).setType((Type) tc);
	}
	
}
