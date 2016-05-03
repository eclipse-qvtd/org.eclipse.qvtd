/*******************************************************************************
 * Copyright (c) 2014, 2015 The University of York and Willink Transformations.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Horacio Hoyos - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtr2qvtc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.CollectionLiteralExp;
import org.eclipse.ocl.pivot.CollectionLiteralPart;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.IntegerLiteralExp;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreHelper;
import org.eclipse.qvtd.pivot.qvtcorebase.Area;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.CorePattern;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.NavigationAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcorebase.VariableAssignment;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Key;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
import org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;

/*public*/ abstract class AbstractQVTr2QVTcRelations extends QVTcoreHelper
{
	protected abstract class AbstractEnforceableRelationDomain2CoreMapping 
	{
		// Relations
		protected final @NonNull RelationDomain rEnforcedDomain;					// rd: This source enforced domain
		protected final @NonNull List<@NonNull Variable> rEnforcedDomainVariables;	// All variables defined or referenced in this domain
//		@Deprecated
//		protected final @NonNull /*Object*/TemplateExp rEnforcedTemplateExpression;	// te: The template expression defining the enforced domain pattern
		protected final @NonNull List<@NonNull/*Object*/TemplateExp> rEnforcedTemplateExpressions;	// te: The template expression defining the enforced domain pattern
//		@Deprecated
//		protected final @NonNull Variable rEnforcedRootVariable;					// tev: The template expression variable (the root variable of the enforced domain pattern)
		protected final @NonNull List<@NonNull Variable> rEnforcedRootVariables;					// tev: The template expression variable (the root variable of the enforced domain pattern)
		protected final @NonNull List<@NonNull RelationDomain> rOtherDomains;		// All other domains sharing the parent of this domain
		protected final @NonNull Set<@NonNull Variable> rOtherDomainVariables;		// All variables defined or referenced in other domains
		// Core
		protected final @NonNull Mapping cMapping;									// m: The resultant mapping
		protected final @NonNull GuardPattern cMiddleGuardPattern;					// mg: The resultant mapping guard pattern
		protected final @NonNull BottomPattern cMiddleBottomPattern;				// mb : The resultant mapping bottom pattern	
		protected final @NonNull TypedModel cEnforcedTypedModel;					// mdir: The resultant enforced typed model
		protected final @NonNull CoreDomain cEnforcedDomain;						// md: The resultant enforced domain
		protected final @NonNull GuardPattern cEnforcedGuardPattern;				// dg: The resultant enforced domain guard pattern
		protected final @NonNull BottomPattern cEnforcedBottomPattern;				// db: The resultant enforced domain bottom pattern
		protected final @NonNull RealizedVariable cMiddleRealizedVariable;		// tcv: The trace class variable (the middle variable identifying the middle object)
		
		public AbstractEnforceableRelationDomain2CoreMapping(@NonNull RelationDomain rEnforcedDomain, @NonNull String cMappingName) {
			this.rEnforcedDomain = rEnforcedDomain;
			//
//			@NonNull DomainPattern rEnforcedDomainPattern = qvtr2qvtc.getDomainPattern(rEnforcedDomain);
			this.rEnforcedDomainVariables = getDomainVariables(rEnforcedDomain);
			this.rEnforcedTemplateExpressions = getTemplateExpressions(rEnforcedDomain);
			this.rEnforcedRootVariables = getRootVariables(rEnforcedDomain);
//			this.rEnforcedTemplateExpression = /*(ObjectTemplateExp)*/ ClassUtil.nonNullState(rEnforcedDomainPattern.getTemplateExpression());
//			this.rEnforcedRootVariable = ClassUtil.nonNullState(rEnforcedTemplateExpression.getBindsTo());			
			@NonNull TypedModel rEnforcedTypedModel = ClassUtil.nonNullState(rEnforcedDomain.getTypedModel());
			@NonNull String rRelationName = ClassUtil.nonNullState(rRelation.getName());
			@NonNull String rEnforcedDomainName = ClassUtil.nonNullState(rEnforcedDomain.getName());
			@NonNull Type traceClass = qvtr2qvtc.getTraceClass(rRelation);
			//
			this.rOtherDomains = new ArrayList<@NonNull RelationDomain>();
			this.rOtherDomainVariables = new HashSet<@NonNull Variable>();
			for (@NonNull Domain rDomain : ClassUtil.nullFree(rEnforcedDomain.getRule().getDomain())) {
				if ((rDomain != rEnforcedDomain) && (rDomain instanceof RelationDomain)) {
					RelationDomain rRelationDomain = (RelationDomain)rDomain;
					rOtherDomains.add(rRelationDomain);
					rOtherDomainVariables.addAll(getDomainVariables(rRelationDomain));
				}
			}
			//
			this.cEnforcedTypedModel = getCoreTypedModel(rEnforcedTypedModel);
			this.cMapping = qvtr2qvtc.whenMapping(rRelation, cMappingName);
			this.cMiddleGuardPattern = ClassUtil.nonNullState(cMapping.getGuardPattern());
			this.cMiddleBottomPattern = ClassUtil.nonNullState(cMapping.getBottomPattern());
			this.cEnforcedDomain = qvtr2qvtc.whenCoreDomain(cMapping, rEnforcedDomainName);
			this.cEnforcedGuardPattern = ClassUtil.nonNullState(cEnforcedDomain.getGuardPattern());
			this.cEnforcedBottomPattern = ClassUtil.nonNullState(cEnforcedDomain.getBottomPattern());
			this.cMiddleRealizedVariable = qvtr2qvtc.whenRealizedVariable(cMiddleBottomPattern, rRelationName+"_"+rEnforcedDomainName+"_v", traceClass);	// 42
		}
		
		// 2
		/*public void doDomainVarsSharedWithWhenToDgVars(@NonNull Set<Variable> domainVarsSharedWithWhen, @NonNull GuardPattern dg) {
			
			List<Variable> dbVars = doRVarSetToMVarSet(new ArrayList<Variable>(domainVarsSharedWithWhen));
			dg.getBindsTo().addAll(dbVars);
		}*/

		// new
		private void addCollectionTemplateExpressionToMiddleBottom(@NonNull Variable cTemplateVariable, @NonNull Property traceProperty, @NonNull CollectionTemplateExp cte) throws CompilerChainException {
			/**
			 * Each PropertyTemplateItem whose value is a CollectionTemplateExp
			 * converts to a VariableAssignment and Predicates.
			 * 
			 * ve1:T1{tp = ve2:Collection{a++b}}		=>   ve2 := ve1.tp;
			 */
			Variable vcte = ClassUtil.nonNullState(cte.getBindsTo());
			Variable mvcte = getCoreVariable(vcte);
			NavigationCallExp pce =  createNavigationCallExp(createVariableExp(cTemplateVariable), traceProperty);
			VariableAssignment a = createVariableAssignment(mvcte, pce);
			cMiddleBottomPattern.getAssignment().add(a);
			/**
			 * Each CollectionTemplateExp member that is not a variable
			 * converts to a VariableAssignment of a new variable the member expression.
			 * 
			 * ve1:T1{tp = ve2:Collection{a++b}}		=>   a := a;
			 */
			Map<@NonNull OCLExpression, @NonNull Variable> rMember2mVariable = new HashMap<@NonNull OCLExpression, @NonNull Variable>();
			List<@NonNull OCLExpression> rMembers = ClassUtil.nullFree(cte.getMember());
			for (@NonNull OCLExpression rMember : rMembers) {
				Variable mVariable;
				if (rMember instanceof TemplateExp) {
					TemplateExp rTemplateExp = (TemplateExp)rMember;
					addTemplateExpressionToMiddleBottom(rTemplateExp);
					Variable rVariable = ClassUtil.nonNullState(rTemplateExp.getBindsTo());
					mVariable = getCoreVariable(rVariable);
				}
				else if (rMember instanceof VariableExp) {
					Variable rVariable = ClassUtil.nonNullState((Variable)((VariableExp)rMember).getReferredVariable());
					mVariable = getCoreVariable(rVariable);
				}
				else {
					OCLExpression mMember = mapExpression(rMember);
					mVariable = createVariable(qvtr2qvtc.getSafeName(rRelation, mMember, "member"), mMember);
				}
				rMember2mVariable.put(rMember, mVariable);
			}
//			CollectionTemplateExp cte = (CollectionTemplateExp) ptv;
//			Variable vcte = ClassUtil.nonNullState(cte.getBindsTo());
//			Variable mvcte = doRVarToMVar(vcte);
//			PropertyCallExp pce =  createPropertyCallExp(ve1, tp);
//			VariableAssignment a = createVariableAssignment(mvcte, pce);
//			mb.getAssignment().add(a);

			
			CollectionType collectionType = ClassUtil.nonNullState(cte.getReferredCollectionType());
			int size = rMembers.size();
			Variable rRest = cte.getRest();
			if (rRest == null) {
				/**
				 * The predicate for a CollectionTemplateExp without a rest variable is a total comparison.
				 * 
				 * ve1:T1{tp = ve2:Collection{a++b}}		=>   ve2 := ve1.tp; ve2 = Collection{a,b};
				 */
				List<@NonNull CollectionLiteralPart> mParts = new ArrayList<@NonNull CollectionLiteralPart>();
				for (@NonNull OCLExpression rMember : rMembers) {
					Variable mVariable = ClassUtil.nonNullState(rMember2mVariable.get(rMember));
					CollectionLiteralPart mItem = createCollectionItem(createVariableExp(mVariable));
					mParts.add(mItem);
				}
				CollectionLiteralExp cle = createCollectionLiteralExp(collectionType, mParts);
				addConditionPredicate(cMiddleBottomPattern, createVariableExp(mvcte), cle);
			}
			else {
				Variable mRest = getCoreVariable(rRest);
				if (collectionType.isOrdered()) {
					/**
					 * The assignment for an ordered CollectionTemplateExp rest variable is a sub-collection assignment.
					 * 
					 * ve1:T1{tp = ve2:Collection{a,b++c}}		=>   c := ve2->subCollection(3,ve2->size());
					 */
					VariableExp vRest = createVariableExp(rRest);
					String opName = collectionType.isUnique() ? "subOrderedSet" : "subSequence";
					IntegerLiteralExp eStart = createIntegerLiteralExp(size);
					OCLExpression eFinish = createOperationCallExp(createVariableExp(mvcte), "size");
					OCLExpression eTail = createOperationCallExp(createVariableExp(mvcte), opName, vRest, eStart, eFinish);
					VariableAssignment aRest = createVariableAssignment(mRest, eTail);
					cMiddleBottomPattern.getAssignment().add(aRest);
					/**
					 * The predicates for each ordered CollectionTemplateExp member variable is an element comparison.
					 * 
					 * ve1:T1{tp = ve2:Collection{a,b++c}}		=>   a = ve2->at(1);
					 */
					for (int i = 0; i < size; i++) {
						IntegerLiteralExp eIndex = createIntegerLiteralExp(i+1);
						OCLExpression vElement = createOperationCallExp(createVariableExp(mvcte), "at", eIndex);
						OCLExpression rMember = rMembers.get(i);
						Variable mVariable = ClassUtil.nonNullState(rMember2mVariable.get(rMember));
						addConditionPredicate(cMiddleBottomPattern, createVariableExp(mVariable), vElement);
					}
				}
				else { 
					/**
					 * The assignment for an unordered CollectionTemplateExp rest variable is a cumulative exclusion.
					 * 
					 * ve1:T1{tp = ve2:Collection{a,b++c}}		=>   c := ve2->excluding(a)->excluding(b);
					 */
					OCLExpression exclusions = createVariableExp(mvcte);
					for (@NonNull OCLExpression rMember : rMembers) {
						Variable mVariable = ClassUtil.nonNullState(rMember2mVariable.get(rMember));
						exclusions = createOperationCallExp(exclusions, "excluding", createVariableExp(mVariable));
					}
					VariableAssignment aRest = createVariableAssignment(mRest, exclusions);
					cMiddleBottomPattern.getAssignment().add(aRest);
					/**
					 * The predicates for each unordered CollectionTemplateExp member variable is an excluded inclusion test.
					 * 
					 * ve1:T1{tp = ve2:Collection{a,b++c}}		=>   ve2->excluding(a)->includes(b);
					 */
					for (int i = 0; i < size; i++) {
						@NonNull OCLExpression eTerm = createVariableExp(mvcte);
						for (int j = 0; j < i; j++) {
							OCLExpression rMember = rMembers.get(j);
							Variable mVariable = ClassUtil.nonNullState(rMember2mVariable.get(rMember));
							eTerm = createOperationCallExp(eTerm, "excluding", createVariableExp(mVariable));
						}
						OCLExpression rMember = rMembers.get(i);
						Variable mVariable = ClassUtil.nonNullState(rMember2mVariable.get(rMember));
						eTerm = createOperationCallExp(eTerm, "includes", createVariableExp(mVariable));
						addPredicate(cMiddleBottomPattern, eTerm);
					}
				}
			}
		}

		/**
		 * Add the predicate "cLeftExpression = cRightExpression" to cCorePattern.
		 */
		protected void addConditionPredicate(@NonNull CorePattern cCorePattern, @NonNull OCLExpression cLeftExpression, @NonNull OCLExpression cRightExpression) {
			OperationCallExp eTerm = createOperationCallExp(cLeftExpression, "=", cRightExpression);
			addPredicate(cCorePattern, eTerm);
		}

		// loop body of RDomainPatternToMDBottomPatternComposite
		private void addObjectTemplateExpressionToMiddleBottom(@NonNull Variable cTemplateVariable, @NonNull Property traceProperty, @NonNull ObjectTemplateExp pte) throws CompilerChainException {
			/**
			 * Each PropertyTemplateItem whose value is an ObjectTemplateExp
			 * converts to a PropertyAssignment.
			 * 
			 * ve1:T1{tp = ve2:T2{...}}   =>   ve1.tp := ve2;
			 */
			Variable vpte = ClassUtil.nonNullState(pte.getBindsTo());
			Variable mvpte = getCoreVariable(vpte);
			addTemplateExpressionToMiddleBottom(pte);
			addPropertyAssignment(cMiddleBottomPattern, cTemplateVariable, traceProperty, createVariableExp(mvpte));
		}
		
		protected void addPredicate(@NonNull CorePattern cCorePattern, @NonNull OCLExpression cExpression) {
			Predicate cPredicate = createPredicate(cExpression);
			cCorePattern.getPredicate().add(cPredicate);
		}
		
		/**
		 * Add the PropertyAssignment "cVariable.cProperty := cExpression" to the cBottomPattern.
		 */
		private void addPropertyAssignment(@NonNull BottomPattern cBottomPattern, @NonNull Variable cVariable, @NonNull Property cProperty, @NonNull OCLExpression cExpression) {
			if (!cProperty.isIsMany() || (cExpression.getType() instanceof CollectionType)) {
				VariableExp cSlotVariableExp = createVariableExp(cVariable);
				NavigationAssignment cAssignment = createNavigationAssignment(cSlotVariableExp, cProperty, cExpression);
				cBottomPattern.getAssignment().add(cAssignment);
				return;
			}
			Property cOppositeProperty = cProperty.getOpposite();
			if ((cOppositeProperty != null) && (cExpression instanceof VariableExp) && (!cOppositeProperty.isIsMany() || (cVariable.getType() instanceof CollectionType))) {
				VariableExp cSlotVariableExp = (VariableExp)cExpression;
				NavigationAssignment cAssignment = createNavigationAssignment(cSlotVariableExp, cOppositeProperty, createVariableExp(cVariable));
				cBottomPattern.getAssignment().add(cAssignment);
				return;
			}
			throw new IllegalStateException("Unsupported collection assign " + cVariable + "." + cProperty + ":=" + cExpression);
		}

		// Quad call of RDomainPatternExprToMappingXXXX
		private void addPropertyAssignmentToMiddleBottomPattern(@NonNull Variable rTargetVariable, @NonNull Property rTargetProperty, @NonNull OCLExpression rExpression) throws CompilerChainException {
			Variable cTargetVariable = null;
			OCLExpression cExpression = null;
			if (rExpression instanceof ObjectTemplateExp) {
				// body of RDomainPatternExprToMappingDomainTemplateVarAssignment
				Variable rBoundVariable = ClassUtil.nonNullState(((ObjectTemplateExp)rExpression).getBindsTo());
				if (!rMiddleDomainVariables.contains(rBoundVariable)) {
					Variable cBoundVariable = getCoreVariable(rBoundVariable);
					cTargetVariable = doRVarToMRealizedVar(rTargetVariable);
					cExpression = createVariableExp(cBoundVariable);
				}
			}
			else if (rExpression instanceof VariableExp) {
				Variable rReferredVariable = ClassUtil.nonNullState((Variable) ((VariableExp)rExpression).getReferredVariable());
				Variable cReferredVariable = getCoreVariable(rReferredVariable);
				if (rMiddleDomainVariables.contains(rReferredVariable) ) {
					// body of RDomainPatternExprToMappingBottomVarAssignment
					cTargetVariable = doRVarToMRealizedVar(rTargetVariable);
				}
				else {
					// body of RDomainPatternExprToMappingDomainVarAssignment
					cTargetVariable = doRVarToMRealizedVar(rTargetVariable);
					cEnforcedBottomPattern.getRealizedVariable().add((RealizedVariable)cTargetVariable);
				}
				cExpression = createVariableExp(cReferredVariable);
			}
			else {
				// body of RDomainPatternExprToMappingDomainAssignment
				cTargetVariable = getCoreVariable(rTargetVariable);
				cExpression = mapExpression(rExpression);
			}
			if ((cTargetVariable != null) && (cExpression != null)) {
				Property cTargetProperty = getProperty(cTargetVariable.getType(), rTargetProperty); 
				addPropertyAssignment(cEnforcedBottomPattern, cTargetVariable, cTargetProperty, cExpression);
			}
		}

		// body of RDomainPatternToMDBottomPatternSimpleSharedVarExpr and RDomainPatternToMDBottomPatternSimpleUnSharedVarExpr
		private void addSimpleVariableExpressionToMiddleBottom(@NonNull Variable cTemplateVariable, @NonNull Property traceProperty, @NonNull VariableExp e) {
			/**
			 * Each PropertyTemplateItem whose value is a simple VariableExp
			 * converts to a domain(unshared) / middle(shared) PropertyAssignment.
			 * 
			 * ve1:T{tp = ve2}   =>   ve1.tp := ve2;
			 */
			Variable vpte = ClassUtil.nonNullState((Variable) e.getReferredVariable());
			Variable mvpte = getCoreVariable(vpte);
			if (rMiddleDomainVariables.contains(vpte)) {
				addPropertyAssignment(cMiddleBottomPattern, cTemplateVariable, traceProperty, createVariableExp(mvpte));
			}
			else {
				addPropertyAssignment(cEnforcedBottomPattern, cTemplateVariable, traceProperty, createVariableExp(mvpte));
			}
		}
		
		// // RDomainPatternToMDBottomPattern
		protected void addTemplateExpressionToMiddleBottom(@NonNull TemplateExp rTemplateExpression) throws CompilerChainException {
			Variable rTemplateVariable = ClassUtil.nonNullState(rTemplateExpression.getBindsTo());
			if (rTemplateExpression instanceof ObjectTemplateExp) {
				for (@NonNull PropertyTemplateItem propertyTemplateItem : ClassUtil.nullFree(((ObjectTemplateExp)rTemplateExpression).getPart())) {
					Property rProperty = ClassUtil.nonNullState(propertyTemplateItem.getReferredProperty());
					Variable cTemplateVariable = getCoreVariable(rTemplateVariable);
				    Property traceProperty = getProperty(cTemplateVariable.getType(), rProperty);
					OCLExpression propertyTemplateValue = ClassUtil.nonNullState(propertyTemplateItem.getValue());
					if (propertyTemplateValue instanceof VariableExp) {
						addSimpleVariableExpressionToMiddleBottom(cTemplateVariable, traceProperty, (VariableExp)propertyTemplateValue);
					}
					else if (propertyTemplateValue instanceof CollectionTemplateExp) {
						addCollectionTemplateExpressionToMiddleBottom(cTemplateVariable, traceProperty, (CollectionTemplateExp)propertyTemplateValue);
					}
					else if (propertyTemplateValue instanceof ObjectTemplateExp) {
						addObjectTemplateExpressionToMiddleBottom(cTemplateVariable, traceProperty, (ObjectTemplateExp)propertyTemplateValue);
					}
					else {
						addSimpleNonVariableExpressionToMiddleBottom(cTemplateVariable, traceProperty, propertyTemplateValue);
					}
				}
			}
			else {
				
			}
		}

		// loop body of RDomainPatternToMDBottomPatternSimpleNonVarExpr
		private void addSimpleNonVariableExpressionToMiddleBottom(@NonNull Variable cTemplateVariable, @NonNull Property traceProperty, @NonNull OCLExpression ptv) {
			/**
			 * Each PropertyTemplateItem whose value is not a TemplateExp and not a VariableExp
			 * converts to a PropertyAssignment.
			 * 
			 * ve1:T{tp = me}   =>   ve1.tp := me;
			 */
			addPropertyAssignment(cMiddleBottomPattern, cTemplateVariable, traceProperty, mapExpression(ptv));
		}

		// 15
		/*
		 * Creates a Predicate, who's ConditionExpression is an
		 * OperationCallExp:
		 * 		trace.<v.name> = v;
		 * TODO Suggest better name: RDomainPatternVariableToTracePredicate?
		 */
		private void doRDomainToMBottomPredicateForEnforcement(@NonNull Set<@NonNull Predicate> predicatesWithoutVarBindings, @NonNull Set<@NonNull Variable> unboundDomainVars) throws CompilerChainException
		{
			Set<@NonNull Variable> remainingUnBoundDomainVars = new HashSet<@NonNull Variable>(unboundDomainVars);
			remainingUnBoundDomainVars.removeAll(rEnforcedRootVariables);
			Set<@NonNull Predicate> predicatesWithVarBindings = 
					selectPredicatesThatReferToVariables(predicatesWithoutVarBindings, remainingUnBoundDomainVars);
			mapPredicatesToPredicates(predicatesWithVarBindings);
				// assign
			for (@NonNull Variable v : rEnforcedRootVariables) {
				@NonNull Variable mv = getCoreVariable(v);
				Property pep = getProperty(cMiddleRealizedVariable.getType(), v);
				NavigationCallExp pe = createNavigationCallExp(createVariableExp(cMiddleRealizedVariable), pep);
				addConditionPredicate(cMiddleBottomPattern, pe, createVariableExp(mv));
			}
		}
		
		// 20
		private void doRDomainToMDBottomForEnforcementOfNonIdentityPropObject(@NonNull Set<@NonNull Predicate> predicatesWithoutVarBindings, @NonNull Set<@NonNull Variable> unboundDomainVars)
		{
			// check
			// FIXME not c.key.part->includes(pp)
			// when
//			RelationalTransformation rt = (RelationalTransformation) r.getTransformation();
//			assert rt != null;
//			@NonNull Transformation mt = qvtr2qvtc.getCoreTransformation(rt);
			// TODO Finish when clear about if the call should be uncommented
			// ...
		}

		// 50
		/*
		private void doUnsharedWhenVarsToMgVars(@NonNull Set<Variable> unsharedWhenVars,
				@NonNull GuardPattern mg) {
			
			List<Variable> mgVars = doRVarSetToMVarSet(new ArrayList<Variable>(unsharedWhenVars));
			mg.getBindsTo().addAll(mgVars);
		}
		*/
		
		
		/* =============  T5 ============= */
		
		// 35
		/*public @NonNull List<Variable> doRVarSetToMVarSet(@NonNull ArrayList<Variable> rvSeq) {
			
			List<Variable> mvSet = new ArrayList<Variable>();
			if (!rvSeq.isEmpty()) {
				final Variable rv = rvSeq.remove(0);
				assert rv != null;
				Variable mv = doRVarToMVar(rv);
				mvSet.add(mv);
				mvSet.addAll(doRVarSetToMVarSet(rvSeq));
			}
			return mvSet;
		}*/

		
		// 18
		/*
		 * Creates Assignments for each part of the ObjectTemplateExp
		 */
		private void doRDomainToMDBottomForEnforcementOfIdentityProp() throws CompilerChainException
		{
			for (@NonNull TemplateExp rEnforcedTemplateExpression : rEnforcedTemplateExpressions) {
				Variable v = rEnforcedTemplateExpression.getBindsTo();
				assert v != null;
				Type c = v.getType();
				assert c != null;
				Area area = cEnforcedBottomPattern.getArea();
				assert area instanceof CoreDomain : "Missing CoreDomain for doRDomainToMDBottomForEnforcementOfIdentityProp";
				CoreDomain cd = (CoreDomain) area;
				Rule rule = cd.getRule();
				assert rule instanceof Mapping : "Missing Mapping for doRDomainToMDBottomForEnforcementOfIdentityProp";
				Mapping m = (Mapping) rule;
				BottomPattern mb = m.getBottomPattern();
				assert mb != null;
				if (rEnforcedTemplateExpression instanceof ObjectTemplateExp) {
					for (@NonNull PropertyTemplateItem pt : ClassUtil.nullFree(((ObjectTemplateExp)rEnforcedTemplateExpression).getPart())) {
						final Property partProperty = ClassUtil.nonNullState(pt.getReferredProperty());
						// check relations
						Key key = qvtr2qvtc.getKeyforType(c);
						if ((key != null) && key.getPart().contains(partProperty)) {
							final OCLExpression partValue = ClassUtil.nonNullState(pt.getValue());
							addPropertyAssignmentToMiddleBottomPattern(v, partProperty, partValue);
						}
					}
				}
				else {
	//				throw new CompilerChainException("Missing doInvokedRelationToMappingForEnforcement support for CollectionTemplateExp");
					System.err.println("Missing doRDomainToMDBottomForEnforcementOfIdentityProp support for CollectionTemplateExp");			
				}
			}
		}
		
		private @NonNull /*Realized*/Variable doRVarToMRealizedVar(@NonNull Variable rv) {		
			@NonNull /*Realized*/Variable mv = /*(RealizedVariable)*/ qvtr2qvtc.getCoreVariable(cMapping, rv);
			return mv;
		}

		protected @NonNull TypedModel getCoreTypedModel(@NonNull TypedModel rTypedModel) {
			String name = ClassUtil.nonNullState(rTypedModel.getName());
			List<org.eclipse.ocl.pivot.@NonNull Package> usedPackages = ClassUtil.nullFree(rTypedModel.getUsedPackage());
			for (TypedModel tm : cTransformation.getModelParameter()) {
				if (name.equals(tm.getName())) {
					assert tm.getUsedPackage().equals(usedPackages);
					return tm;
				}
			}
			return ClassUtil.nonNullState(null);
		}
		
		protected @NonNull Variable getCoreVariable(@NonNull Variable rVariable) {			// doRVarToMVar
			return qvtr2qvtc.getCoreVariable(cMapping, rVariable);
		}

		protected @NonNull List<@NonNull Variable> getDomainVariables(@NonNull RelationDomain rRelationDomain) {
			List<@NonNull Variable> rDomainVariables = new ArrayList<@NonNull Variable>();
			for (@NonNull DomainPattern rDomainPattern : ClassUtil.nullFree(rRelationDomain.getPattern())) {
				rDomainVariables.addAll(ClassUtil.nullFree(rDomainPattern.getBindsTo()));
			}
			return rDomainVariables;
		}

		protected @NonNull List<@NonNull Variable> getRootVariables(@NonNull RelationDomain rRelationDomain) {
			List<@NonNull Variable> rRootVariables = new ArrayList<@NonNull Variable>();
			for (@NonNull DomainPattern rDomainPattern : ClassUtil.nullFree(rRelationDomain.getPattern())) {
				TemplateExp rTemplateExpression = rDomainPattern.getTemplateExpression();
				Variable rRootVariable = rTemplateExpression.getBindsTo();
				assert rRootVariable != null;
				rRootVariables.add(rRootVariable);
			}
			return rRootVariables;
		}

		protected @NonNull Set<@NonNull RelationDomain> getOtherRelationDomains() {
			Set<@NonNull RelationDomain> relationDomains = new HashSet<@NonNull RelationDomain>();
			for (@NonNull Domain relationDomain : ClassUtil.nullFree(rRelation.getDomain())) {
				relationDomains.add((RelationDomain) relationDomain);
			}
			relationDomains.remove(rEnforcedDomain);
			return relationDomains;
		}

		protected @NonNull List<@NonNull TemplateExp> getTemplateExpressions(@NonNull RelationDomain rRelationDomain) {
			List<@NonNull TemplateExp> rTemplateExpressions = new ArrayList<@NonNull TemplateExp>();
			for (@NonNull DomainPattern rDomainPattern : ClassUtil.nullFree(rRelationDomain.getPattern())) {
				TemplateExp rTemplateExpression = rDomainPattern.getTemplateExpression();
				assert rTemplateExpression != null;
				rTemplateExpressions.add(rTemplateExpression);
			}
			return rTemplateExpressions;
		}
		
		private boolean isVarBoundToSomeOtherTemplate(ObjectTemplateExp rootTe, /*Object*/TemplateExp skipTe, Variable v) {	
			if (rootTe == skipTe) {
				return false;
			}
			if (rootTe.getBindsTo().equals(v)) {
				return true;
			} else {
				boolean exists = false;
				for (PropertyTemplateItem p : rootTe.getPart()) {
					if (p.getValue() instanceof ObjectTemplateExp) {
						exists |= isVarBoundToSomeOtherTemplate((ObjectTemplateExp) p.getValue(), skipTe, v);
					}
				}
				return exists;
			}	
		}
		
		// ROppositeDomainVarsToTraceClassProps
		protected void mapDomainVariablesToMiddleVariableAssignments(@NonNull Set<@NonNull Variable> rDomainVariables) throws CompilerChainException {			
			for (@NonNull Variable rDomainVariable : rDomainVariables) {
				TemplateExp rTemplateExpression = qvtr2qvtc.getTemplateExpression(rDomainVariable);
//				if (dvte instanceof ObjectTemplateExp) {
					// tp=dv:T{...} => tcv.tp := dv;
					Variable cVariable = getCoreVariable(rDomainVariable);
					Property cProperty = getProperty(cMiddleRealizedVariable.getType(), rDomainVariable);
					addPropertyAssignment(cMiddleBottomPattern, cMiddleRealizedVariable, cProperty, createVariableExp(cVariable));
//				}
/*				else if (dvte instanceof CollectionTemplateExp) {
					// tp=dv:T{...} => tcv.tp := dv;
					Variable mdv = doRVarToMVar(dv);
//					VariableExp ve1 = createVariableExp(tcv);
					VariableExp ve2 = createVariableExp(mdv);
					VariableAssignment a = createVariableAssignment(mdv, ve2);
					mb.getAssignment().add(a);
				} */
/*				else if (dvte instanceof CollectionTemplateExp) {
					CollectionTemplateExp collectionTemplateExp = (CollectionTemplateExp)dvte;
				} */
			}
		}	
		
		// RDomainToMDBottomForEnforcement
		protected void mapEnforcedDomain(@NonNull Set<@NonNull Predicate> predicatesWithoutVarBindings,  @NonNull Set<@NonNull Variable> rEnforcedBottomDomainVariables) throws CompilerChainException
		{
			Set<@NonNull Variable> nonRootEnforcedBottomDomainVariables = new HashSet<@NonNull Variable>(rEnforcedBottomDomainVariables);
			nonRootEnforcedBottomDomainVariables.removeAll(rEnforcedRootVariables);
			//
			Set<@NonNull Predicate> predicatesWithVarBindings = selectPredicatesThatReferToVariables(predicatesWithoutVarBindings, nonRootEnforcedBottomDomainVariables);	
			Set<@NonNull Predicate> remainingPredicatesWithoutVarBindings = new HashSet<@NonNull Predicate>(predicatesWithoutVarBindings);
			remainingPredicatesWithoutVarBindings.removeAll(predicatesWithVarBindings);
			for (@NonNull TemplateExp rEnforcedTemplateExpression : rEnforcedTemplateExpressions) {
				Variable rTemplateVariable = ClassUtil.nonNullState(rEnforcedTemplateExpression.getBindsTo());
				Type rTemplateVariableType = ClassUtil.nonNullState(rTemplateVariable.getType());
				Key key = qvtr2qvtc.getKeyforType(rTemplateVariableType);
//				if (key == null){
//					// Nothing to do
//				}
				/*else*/ if (rEnforcedTemplateExpression instanceof ObjectTemplateExp) {
					for (@NonNull PropertyTemplateItem pt : ClassUtil.nullFree(((ObjectTemplateExp)rEnforcedTemplateExpression).getPart())) {
						Property rPartProperty = ClassUtil.nonNullState(pt.getReferredProperty());
						OCLExpression rPartValue = ClassUtil.nonNullState(pt.getValue());
						if ((key != null) && key.getPart().contains(rPartProperty)) {
							//  body of RDomainToMDBottomForEnforcementOfIdentityProp
							addPropertyAssignmentToMiddleBottomPattern(rTemplateVariable, rPartProperty, rPartValue);
						}
						else if (!(rPartValue instanceof TemplateExp)) {
							// body of RDomainToMDBottomForEnforcementOfNonIdentityPropPrimitive
							Mapping composedMapping = qvtr2qvtc.createMapping(); //whenMapping(rRelation, cMapping.getName()+"_forNonIdentityProp");
							BottomPattern composedBottomPattern = ClassUtil.nonNullState(composedMapping.getBottomPattern());
//							composedMapping.getGuardPattern();
							Variable cTemplateVariable = getCoreVariable(rTemplateVariable);
							//RDomainToMComposedMappingGuardrEnforcedDomain
							for (@NonNull TemplateExp rTemplateExpression : rEnforcedTemplateExpressions) {
								if ((rPartValue instanceof VariableExp) && (rTemplateExpression instanceof ObjectTemplateExp)) {
									// check
									Variable rReferredVariable = (Variable) ClassUtil.nonNullState(((VariableExp) rPartValue).getReferredVariable());
									if (isVarBoundToSomeOtherTemplate((ObjectTemplateExp) rTemplateExpression, rEnforcedTemplateExpression, rReferredVariable)) {
										String rEnforcedDomainName = ClassUtil.nonNullState(rEnforcedDomain.getName());
										TypedModel rTypedModel = rEnforcedDomain.getTypedModel();
										if (rTransformation != rTypedModel.getTransformation())
											return;
										// init
										GuardPattern composedMappingGuardPattern = ClassUtil.nonNullState(composedMapping.getGuardPattern());
										CoreDomain composedEnforcedDomain = qvtr2qvtc.whenCoreDomain(composedMapping, rEnforcedDomainName);
										GuardPattern composedEnforcedGuardPattern = composedEnforcedDomain.getGuardPattern();
										// where
										@SuppressWarnings("unused")BottomPattern composedMappingBottomPattern = ClassUtil.nonNullState(composedMapping.getBottomPattern());
										Variable cReferredVariable = getCoreVariable(rReferredVariable);
										// assign
										Property cTargetProperty = getProperty(cReferredVariable.getType(), cReferredVariable);
										NavigationCallExp cPropertyCallExp = createNavigationCallExp(createVariableExp(cMiddleRealizedVariable), cTargetProperty);
										addConditionPredicate(composedMappingGuardPattern, cPropertyCallExp, createVariableExp(cReferredVariable));
										TypedModel cTypedModel = getCoreTypedModel(rTypedModel);
										composedEnforcedDomain.setTypedModel(cTypedModel);
										composedEnforcedGuardPattern.getBindsTo().add(cReferredVariable);
										composedEnforcedDomain.setGuardPattern(composedEnforcedGuardPattern);
									}
								}
								Property cTargetProperty = getProperty(cTemplateVariable.getType(), rPartProperty);
								addPropertyAssignment(composedBottomPattern, cTemplateVariable, cTargetProperty, mapExpression(rPartValue));
								cMapping.getLocal().add(composedMapping);
							}
						}
					}
				}
				else {
	//				throw new CompilerChainException("Missing doInvokedRelationToMappingForEnforcement support for CollectionTemplateExp");
					System.err.println("Missing doRDomainToMDBottomForEnforcement support for CollectionTemplateExp");			
				}		
				// This call is wrong as the trace variable is realized, it can't be guarded.
				// This should only be done in a nested mapping or later mapping
				//doRDomainToMBottomPredicateForEnforcement(r, rd, te, predicatesWithoutVarBindings, unboundDomainVars, mb);		
				/*
				 * Creates the assignment of the middle model to the L/R models
				 */
				// RDomainVarToMDBottomAssignmnetForEnforcement
				Variable cTemplateVariable = getCoreVariable(rTemplateVariable);
				Property cTargetProperty = getProperty(cMiddleRealizedVariable.getType(), rTemplateVariable);
				addPropertyAssignment(cMiddleBottomPattern, cMiddleRealizedVariable, cTargetProperty, createVariableExp(cTemplateVariable));
			}
		}	

		/*
		 * The issue with this method is that all variables should have been
		 * transformed so all variable references can be correctly pointed.
		 * However, if we call it after all variable modifying relations it
		 * should work.
		 */
		// 25
		protected @NonNull OCLExpression mapExpression(@NonNull OCLExpression rExpression) {
//			OCLExpCopy oCLExpCopy = new OCLExpCopy(qvtr2qvtc);
			
//			return (OCLExpression) ClassUtil.nonNullState(oCLExpCopy.doSwitch(re));
			return qvtr2qvtc.copy(rExpression, null);
		}
		
		protected void mapPredicatesToPredicates(@NonNull Iterable<@NonNull Predicate> rPredicates) {	// RPredicateSetToMBPredicateSet
			for (@NonNull Predicate rPredicate : rPredicates) {
				OCLExpression rExpression = ClassUtil.nonNullState(rPredicate.getConditionExpression());
				addPredicate(cMiddleBottomPattern, mapExpression(rExpression));
			}
/*			
			// check
			if(predSeq.isEmpty()) {
				return;
			}
			Predicate rp = predSeq.remove(0);
			OCLExpression re = rp.getConditionExpression();
			assert re != null;
			// init
			@NonNull Predicate mp = createPredicate();
			// when
			@NonNull OCLExpression me = doRExpToMExp(re);
			doRPredicateSetToMBPredicateSet(predSeq, mb);
			// assign
			mp.setConditionExpression(me);
			mb.getPredicate().add(mp); */
		}
		
		protected @NonNull RealizedVariable mapRealizedVariable(@NonNull Variable rVariable) {		
			return qvtr2qvtc.whenRealizedVariable(cEnforcedBottomPattern, rVariable);
		}

		/**
		 * Transform a rule implemented by a black box into an enforcement operation
		 *
		 * @param rRelation the r
		 * @param rEnforcedDomain the rd
		 * @param cMiddleBottomPattern the mb
		 */
		// RRelImplToMBottomEnforcementOperation
		protected void mapRelationImplemantationToEnforcementOperation() {
			
			// TODO Code this when testing transformations with operational implementations.
			
		}
		
		protected void mapVariablesToVariables(@NonNull Iterable<@NonNull Variable> rVariables, @NonNull CorePattern cPattern) {		// RVarSetToDGVarSet, RVarSetToMBVarSet
			for (@NonNull Variable rVariable : rVariables) {
				qvtr2qvtc.whenVariable(cPattern, rVariable);
			}
		}
		
		// RWhenPatternToMGuardPattern
		protected void mapWhenPatternToGuardPatterns() throws CompilerChainException {			
			Pattern rWhenPattern = rRelation.getWhen();
			if (rWhenPattern != null) {
				Set<@NonNull Variable> rMiddleGuardDomainVariables = new HashSet<@NonNull Variable>(rWhenVariables);
				rMiddleGuardDomainVariables.removeAll(rAllBoundDomainVariables);
				//
				for (Predicate rWhenPredicate : rWhenPattern.getPredicate()) {
					OCLExpression rConditionExpression = ClassUtil.nonNullState(rWhenPredicate.getConditionExpression());
					if (rConditionExpression instanceof RelationCallExp) {
						// body of RWhenRelCallToMGuard
						RelationCallExp rRelationCallExp = (RelationCallExp)rConditionExpression;
						Relation rWhenRelation = ClassUtil.nonNullState(rRelationCallExp.getReferredRelation());
						Type tc = qvtr2qvtc.getTraceClass(rWhenRelation);
						// where
						StringBuilder s = new StringBuilder();
						List<@NonNull OCLExpression> rRelationCallArguments = ClassUtil.nullFree(rRelationCallExp.getArgument());
						for (OCLExpression rRelationCallArgument : rRelationCallArguments) {
							VariableExp a = (VariableExp) rRelationCallArgument;
							s.append("_");
							s.append(a.getReferredVariable().getName());
						}
						String vdId = s.toString();
						List<Domain> dseq = new ArrayList<Domain>(rWhenRelation.getDomain());
					    for (OCLExpression rRelationCallArgument : rRelationCallArguments) {
							VariableExp ve = (VariableExp) rRelationCallArgument;
							RelationDomain rRelationDomain = (RelationDomain) ClassUtil.nonNullState(dseq.get(rRelationCallArguments.indexOf(ve)));		// FIXME multi-root
							//RWhenRelCallArgToMGuardPredicate
							Variable dv = rRelationDomain.getRootVariable().get(0);
							Variable v = (Variable) ClassUtil.nonNullState(ve.getReferredVariable());
							Variable vd = qvtr2qvtc.whenVariable(cMiddleGuardPattern, tc.getName()+vdId+"_v", tc);
							Variable mv = getCoreVariable(v);
							Property pep = getProperty(vd.getType(), dv);
							NavigationCallExp pe = createNavigationCallExp(createVariableExp(vd), pep);
							addConditionPredicate(cMiddleGuardPattern, pe, createVariableExp(mv));
						}
					}
					else {
						// body of RSimplePatternToMPattern
						Predicate mpd = createPredicate(mapExpression(rConditionExpression));		// FIXME orphan
//						addPredicate(composedMappingGuardPattern, cConditionExpression);
						throw new UnsupportedOperationException("FIXME orphan");
					}
				}
				//doUnsharedWhenVarsToMgVars(unsharedWhenVars, mg);
				mapVariablesToVariables(rMiddleGuardDomainVariables, cMiddleGuardPattern);
			}
		}

		protected @NonNull Set<@NonNull Predicate> selectPredicatesThatReferToVariables(@NonNull Set<@NonNull Predicate> rPredicates, @NonNull Set<@NonNull Variable> rVariables) {
			Set<@NonNull Predicate> rPredicatesThatReferToVariables = new HashSet<@NonNull Predicate>();
			for (Predicate rPredicate : rPredicates) {
				OCLExpression conditionExpression = rPredicate.getConditionExpression();
				assert conditionExpression != null;
				Set<@NonNull Variable> rPredicateVariables = qvtr2qvtc.getVarsOfExp(conditionExpression);
				rPredicateVariables.retainAll(rVariables);
				if (rPredicateVariables.isEmpty()) {		// FIXME smelly polarity
					rPredicatesThatReferToVariables.add(rPredicate);
				}
			}
			return rPredicatesThatReferToVariables;
		}

		protected void setAttributes() {
			cMiddleBottomPattern.getRealizedVariable().add(cMiddleRealizedVariable);
			//mb.getVariable().addAll(mbvars);
			cEnforcedDomain.setTypedModel(cEnforcedTypedModel);
			cEnforcedDomain.setIsEnforceable(true);
		}

		@Override
		public @NonNull String toString() {
			return rRelation.getName() + "::" + rEnforcedDomain.getName() + " => " + cMapping.getName() + "::" + cEnforcedDomain.getName();
		}
		
		protected abstract void where() throws CompilerChainException;
	}

	protected @NonNull final QVTrToQVTc qvtr2qvtc;
	// Relations
	protected final @NonNull Relation rRelation;								// r: Parent relation of this domain
	protected final @NonNull RelationalTransformation rTransformation;			// Parent transformation of parent relation of enforced domain
	protected final @NonNull Set<@NonNull Variable> rAllBoundDomainVariables;	// All pattern variables declared in all domains (not CollectionTemplateExp member/rest, Let/Iterator variables)
	protected final @NonNull Set<@NonNull Variable> rWhenVariables;				// All pattern variables used in when calls
	protected final @NonNull Set<@NonNull Variable> rWhereVariables;			// All pattern variables used as where calls
	protected final @NonNull Set<@NonNull Predicate> rPredicates;				// All non-RelationCallExp predicates
	protected final @NonNull Set<@NonNull Variable> rMiddleDomainVariables;		// All pattern variables shared by more than one domain
	protected final @NonNull Set<@NonNull Variable> rMiddleBottomDomainVariables;
	// Core
	protected final @NonNull Transformation cTransformation;					// mt: The transformation containing the result mapping

	protected AbstractQVTr2QVTcRelations(@NonNull QVTrToQVTc qvtr2qvtc, @NonNull Relation rRelation) {
		super(qvtr2qvtc.getEnvironmentFactory());
		this.qvtr2qvtc = qvtr2qvtc;
		this.rRelation = rRelation;
		this.rTransformation = (RelationalTransformation) ClassUtil.nonNullState(rRelation.getTransformation());
		//
		this.rAllBoundDomainVariables = new HashSet<@NonNull Variable>();
		for (@NonNull Domain rDomain : ClassUtil.nullFree(rRelation.getDomain())) {
			for (@NonNull DomainPattern rDomainPattern : ClassUtil.nullFree(((RelationDomain)rDomain).getPattern())) {
				this.rAllBoundDomainVariables.addAll(ClassUtil.nullFree(rDomainPattern.getBindsTo()));
			}
		}
		//
		this.rWhenVariables = new HashSet<@NonNull Variable>();
		Pattern rWhenPattern = rRelation.getWhen();
		if (rWhenPattern != null) {
			this.rWhenVariables.addAll(ClassUtil.nullFree(rWhenPattern.getBindsTo()));
		}
		//
		this.rWhereVariables = new HashSet<@NonNull Variable>();
		this.rPredicates = new HashSet<@NonNull Predicate>();
		Pattern rWherePattern = rRelation.getWhere();
		if (rWherePattern != null) {
			this.rWhereVariables.addAll(ClassUtil.nullFree(rWherePattern.getBindsTo()));
			for (@NonNull Predicate rPredicate : ClassUtil.nullFree(rWherePattern.getPredicate())) {
				if (!(rPredicate.getConditionExpression() instanceof RelationCallExp)) {
					rPredicates.add(rPredicate);
				}
			}
		}
		//
		this.rMiddleDomainVariables = qvtr2qvtc.getMiddleDomainVariables(rRelation);
		//
		this.rMiddleBottomDomainVariables = new HashSet<@NonNull Variable>(rWhereVariables);
		rMiddleBottomDomainVariables.removeAll(rWhenVariables);
		rMiddleBottomDomainVariables.removeAll(rAllBoundDomainVariables);
		rMiddleBottomDomainVariables.addAll(rMiddleDomainVariables);			// FIXME this stinks
		//
		this.cTransformation = qvtr2qvtc.getCoreTransformation(rTransformation);
	}
	
	/* =============  Helpers ============= */

	protected @NonNull Property getProperty(/*@NonNull*/ Type aClass, @NonNull NamedElement rNamedElement) throws CompilerChainException {
		/*@NonNull*/ String name = rNamedElement.getName();
		assert (aClass != null) && (name != null);
		CompleteClass completeClass = environmentFactory.getCompleteModel().getCompleteClass(aClass);
		Property p = completeClass.getProperty(name);
		if (p != null)
			return p;
		throw new CompilerChainException("No property '" + name + "' in '" + aClass + "::" + "'");
	}

//	protected @NonNull Set<@NonNull Variable> getUnsharedWhenVars(@NonNull Set<@NonNull Variable> whenVars, @NonNull Set<@NonNull Variable> allDomainVars) {
//		Set<@NonNull Variable> unsharedWhereVars = new HashSet<@NonNull Variable>(whenVars);
//		unsharedWhereVars.removeAll(allDomainVars);
//		return unsharedWhereVars;
//	}
	
	protected void where(@NonNull Relation rRelation, @NonNull List<@NonNull ? extends AbstractEnforceableRelationDomain2CoreMapping> enforceableRelationDomain2coreMappings) throws CompilerChainException {
		for (@NonNull AbstractEnforceableRelationDomain2CoreMapping enforceableRelationDomain2coreMapping : enforceableRelationDomain2coreMappings) {
			enforceableRelationDomain2coreMapping.where();
		}
		// setAttributes() {
		for (@NonNull AbstractEnforceableRelationDomain2CoreMapping enforceableRelationDomain2coreMapping : enforceableRelationDomain2coreMappings) {
			enforceableRelationDomain2coreMapping.setAttributes();
		}
	}
}
