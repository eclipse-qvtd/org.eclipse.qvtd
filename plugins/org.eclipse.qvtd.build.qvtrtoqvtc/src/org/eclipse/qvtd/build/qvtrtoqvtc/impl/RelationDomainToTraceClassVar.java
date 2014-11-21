package org.eclipse.qvtd.build.qvtrtoqvtc.impl;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.qvtd.build.qvtrtoqvtc.CoreBindings;
import org.eclipse.qvtd.build.qvtrtoqvtc.QvtrToQvtcTransformation;
import org.eclipse.qvtd.build.qvtrtoqvtc.RelationsBindings;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;

public class RelationDomainToTraceClassVar extends AbstractRule {

	// Relations
	private static final @NonNull RelationsBindings.KeySet RELATIONS_BINDINGS = new RelationsBindings.KeySet();
	private static final @NonNull RelationsBindings.Key<List<Element>> RELATIONS_rdSeq = RELATIONS_BINDINGS.create((List<Element>)null, "rdSeq");
	private static final @NonNull RelationsBindings.Key<Relation> RELATIONS_r = RELATIONS_BINDINGS.create((Relation)null, "r");
	private static final @NonNull RelationsBindings.Key<RelationDomain> RELATIONS_d = RELATIONS_BINDINGS.create((RelationDomain)null, "d");
	
	// Core
	private static final @NonNull CoreBindings.KeySet CORE_BINDINGS = new CoreBindings.KeySet();
	private static final @NonNull CoreBindings.Key<RealizedVariable> CORE_tcv = CORE_BINDINGS.create((RealizedVariable)null, "tcv");
	
	String rn, dn;
	EClass tc;

	public RelationDomainToTraceClassVar(@NonNull QvtrToQvtcTransformation transformation) {
		super(transformation);
	}
	
	@Override
	public boolean when() {
/*		ConstrainedRule rTotcRule = new RelationToTraceClass(transformation, null);
		List<Bindings> loopData = rTotcRule.findInputMatches(qvtrModel);
		for (Rule rTotcRecord : transformation.executeRuleInLoop(rTotcRule, loopData)) {
			if(rTotcRecord.getBindings().get(RelationToTraceClass.r).equals(relationsBindings.get(RelationDomainToTraceClassVar.r))) {
				tc = rTotcRecord.getBindings().get(RelationToTraceClass.rc);
				rn = relationsBindings.get(RELATIONS_r).getName();
				dn = relationsBindings.get(RELATIONS_d).getName();
				return true;
			}
		} */
		return false;
	}
	
	@Override
	public void setAttributes() {
		RealizedVariable tcv = coreBindings.get(CORE_tcv);
		tcv.setName(rn+"_"+dn+"_v");
		tcv.setType((Type) tc);
	}
	
}
