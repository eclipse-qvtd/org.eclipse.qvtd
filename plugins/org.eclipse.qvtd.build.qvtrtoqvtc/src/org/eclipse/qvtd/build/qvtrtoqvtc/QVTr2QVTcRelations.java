package org.eclipse.qvtd.build.qvtrtoqvtc;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcorebase.Area;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.QVTcoreBaseFactory;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
/*relation RDomainToMDBottomForEnforcement
{
   remainingUnBoundDomainVars: Set(essentialocl::Variable);
   predicatesWithVarBindings:Set(qvtbase::Predicate);
   remainingPredicatesWithoutVarBindings:Set(qvtbase::Predicate);
   rdSeq, rtSeq, rtdSeq: Sequence(emof::Element);
   rdtVarsSeqRest: Sequence(Set(emof::Element));
   predicatesWithoutVarBindings:Set(qvtbase::Predicate);
   unboundDomainVars:Set(essentialocl::Variable);
   tcv, mv: essentialocl::Variable;

   domain relations rdtVarsSeq:Sequence(Set(Element)) {
      rdtSet:Set(Element) {
         r:Relation{},
         rd:RelationDomain{},
         te:ObjectTemplateExp {bindsTo = v:Variable {}}
         ++ _
      }
      ++ _
   };
   enforce domain core db:BottomPattern {   -- domain bottom
      area = cd:CoreDomain {
         rule = m:Mapping {
            bottomPattern = mb:BottomPattern {
                area = m
             }
         }
      }
   };
   where {
      rdtVarsSeq->at(2) = predicatesWithoutVarBindings;
      rdtVarsSeq->at(3) = unboundDomainVars;

      remainingUnBoundDomainVars = unboundDomainVars - Set{v};
      predicatesWithVarBindings = filterOutPredicatesThatReferToVars(
                                    predicatesWithoutVarBindings, remainingUnBoundDomainVars);

      remainingPredicatesWithoutVarBindings =
            predicatesWithoutVarBindings - predicatesWithVarBindings;
      rtSeq = Sequence{r, te};
      rtdSeq = Sequence{r, te, rd};
      rdtVarsSeqRest = Sequence{rdtSet, remainingPredicatesWithoutVarBindings, remainingUnBoundDomainVars};

      RDomainToMDBottomForEnforcementOfIdentityProp(rtSeq, db);
      RDomainVarToMDBottomAssignmnetForEnforcement(rdtVarsSeq, mb);
      --RDomainToMDBottomForEnforcementOfIdentityPropObject(rdtSeq, mb);
      RDomainToMDBottomForEnforcementOfNonIdentityPropPrimitive(rtdSeq, m);
      RDomainToMDBottomForEnforcementOfNonIdentityPropObject(rdtVarsSeqRest, m);
      RDomainToMBottomPredicateForEnforcement(rdtVarsSeq, mb);
   }
} */
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;

public class QVTr2QVTcRelations {

	public void doRDomainToMDBottomForEnforcement(@NonNull Relation r, @NonNull RelationDomain rd, @NonNull ObjectTemplateExp te,
			@NonNull Set<Predicate> predicatesWithoutVarBindings, @NonNull Set<Variable> unboundDomainVars, @NonNull BottomPattern db)
	{
		// NOT-USED   tcv, mv: essentialocl::Variable;
		//
		//	Check
		//
		Variable v = te.getBindsTo();
		//
		//	Post-Check
		//
		Set<Variable> remainingUnBoundDomainVars = new HashSet<Variable>(unboundDomainVars);
		remainingUnBoundDomainVars.remove(v);
		//
		Set<Predicate> predicatesWithVarBindings = filterOutPredicatesThatReferToVars(predicatesWithoutVarBindings, remainingUnBoundDomainVars);	
		Set<Predicate> remainingPredicatesWithoutVarBindings = new HashSet<Predicate>(predicatesWithoutVarBindings);
		remainingPredicatesWithoutVarBindings.removeAll(predicatesWithVarBindings);
		//
		//	Enforce-Check
		//
		Area area = db.getArea();
		assert area instanceof CoreDomain : "Missing CoreDomain for RDomainToMDBottomForEnforcement";
		CoreDomain cd = (CoreDomain) area;
		Rule rule = cd.getRule();
		assert rule instanceof Mapping : "Missing Mapping for RDomainToMDBottomForEnforcement";
		Mapping m = (Mapping) rule;
		//
		//	Enforce-Create
		//
		BottomPattern mb = QVTcoreBaseFactory.eINSTANCE.createBottomPattern();
		mb.setArea(m);
		//
		//	then-where
		//
		doRDomainToMDBottomForEnforcementOfIdentityProp(r, te, db);
		doRDomainVarToMDBottomAssignmnetForEnforcement(r, rd, te, predicatesWithoutVarBindings, unboundDomainVars, mb);
		//RDomainToMDBottomForEnforcementOfIdentityPropObject(rdtSeq, mb);
		doRDomainToMDBottomForEnforcementOfNonIdentityPropPrimitive(r, te, rd, m);
		doRDomainToMDBottomForEnforcementOfNonIdentityPropObject(r, rd, te, remainingPredicatesWithoutVarBindings, remainingUnBoundDomainVars, m);
		doRDomainToMBottomPredicateForEnforcement(r, rd, te, predicatesWithoutVarBindings, unboundDomainVars, mb);
	}
	
	private @NonNull Set<Predicate> filterOutPredicatesThatReferToVars(@NonNull Set<Predicate> predicatesWithoutVarBindings,
			@NonNull Set<Variable> remainingUnBoundDomainVars) {
		// TODO Auto-generated method stub
		return predicatesWithoutVarBindings;		// FIXME
	}

	public void doRDomainToMDBottomForEnforcementOfIdentityProp(@NonNull Relation r, @NonNull ObjectTemplateExp te, @NonNull BottomPattern db)
	{
	}
	
	public void doRDomainVarToMDBottomAssignmnetForEnforcement(@NonNull Relation r, @NonNull RelationDomain rd, @NonNull ObjectTemplateExp te,
			@NonNull Set<Predicate> predicatesWithoutVarBindings, @NonNull Set<Variable> unboundDomainVars, @NonNull BottomPattern mb)
	{
	}
	
	public void doRDomainToMDBottomForEnforcementOfNonIdentityPropPrimitive(@NonNull Relation r, @NonNull ObjectTemplateExp te, @NonNull RelationDomain rd,
			@NonNull Mapping m)
	{
	}
	
	public void doRDomainToMDBottomForEnforcementOfNonIdentityPropObject(@NonNull Relation r, @NonNull RelationDomain rd, @NonNull ObjectTemplateExp te,
			@NonNull Set<Predicate> predicatesWithoutVarBindings, @NonNull Set<Variable> unboundDomainVars, @NonNull Mapping m)
	{
	}
	
	public void doRDomainToMBottomPredicateForEnforcement(@NonNull Relation r, @NonNull RelationDomain rd, @NonNull ObjectTemplateExp te,
			@NonNull Set<Predicate> predicatesWithoutVarBindings, @NonNull Set<Variable> unboundDomainVars, @NonNull BottomPattern mb)
	{
	}
}
