/*******************************************************************************
 * Copyright (c) 2014, 2016 The University of York and Willink Transformations.
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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionLiteralExp;
import org.eclipse.ocl.pivot.CollectionLiteralPart;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.IteratorVariable;
import org.eclipse.ocl.pivot.LetVariable;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.InvokedRelationToMappingForEnforcement.InvokedEnforceableRelationDomain2CoreMapping;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtcore.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcore.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcore.CorePattern;
import org.eclipse.qvtd.pivot.qvtcore.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.NavigationAssignment;
import org.eclipse.qvtd.pivot.qvtcore.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcore.VariableAssignment;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreHelper;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreUtil;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Key;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;
import org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;

/**
 * AbstractQVTr2QVTcRelations defines the mapping from a Relation, with a nested AbstractEnforceableRelationDomain2CoreMapping
 * for each distinct enforcement of that relation and a further nested AbstractOtherRelationDomain2CoreDomain for each
 * other domain of the distinct enforcement.
 */
/*public*/ abstract class AbstractQVTr2QVTcRelations extends QVTcoreHelper
{
	/**
	 * The AbstractEnforceableRelationDomain2CoreMapping supervises the conversion of the enforced
	 * domains while enforcing a relation for a particular enforced domain.
	 */
	protected abstract class AbstractEnforceableRelationDomain2CoreMapping
	{
		/**
		 * The AbstractOtherRelationDomain2CoreDomain supervises the conversion of one of the not-enforced
		 * domains while enforcing a relation for a particular enforced domain.
		 */
		protected abstract class AbstractOtherRelationDomain2CoreDomain
		{
			// relations
			/**
			 *  The not-enforced domain being converted
			 */
			protected final @NonNull RelationDomain rOtherDomain;
			/**
			 * The name of the not-enforced domain: rOtherDomain.getName()
			 */
			protected final @NonNull String rOtherDomainName;
			/**
			 * The relations TypedModel of the not-enforced domain: rOtherDomain.getTypedModel()
			 */
			protected final @NonNull TypedModel rOtherTypedModel;
			/**
			 *  Mapping from each bound variable in the not-enforced relation domain to the TemplateExp that bindsTo it.
			 *  Excludes CollectionTemplateExp.member, CollectionTemplateExp.rest.
			 */
			protected final @NonNull Map<@NonNull Variable, @NonNull TemplateExp> rOtherBoundVariables;
			/**
			 *  Mapping from each member variable in the not-enforced relation domain to each CollectionTemplateExp that
			 *  has a  VariableExp member that refers to it.
			 */
			protected final @Nullable Map<@NonNull Variable, @NonNull List<@NonNull CollectionTemplateExp>> rOtherMemberVariables;
			/**
			 *  Mapping from each rest variable in the not-enforced relation domain to its CollectionTemplateExp.
			 */
			protected final @Nullable Map<@NonNull Variable, @NonNull CollectionTemplateExp> rOtherRestVariables;
			/**
			 *  All variables defined or referenced in this other domain
			 */
			protected final @NonNull Set<@NonNull Variable> rOtherReferredVariables;
			/**
			 *  The template expression variables (the root variables of this other domain pattern)
			 */
			protected final @NonNull List<@NonNull Variable> rOtherRootVariables;
			// core
			/**
			 * The corresponding core TypedModel of the not-enforced domain: cOtherDomain.getTypedModel()
			 */
			protected final @NonNull TypedModel cOtherTypedModel;
			/**
			 * The converted not-enforced domain.
			 */
			protected final @NonNull CoreDomain cOtherDomain;
			/**
			 * The guard pattern of the not-enforced domain: cOtherDomain.getOwnedGuardPattern().
			 */
			protected final @NonNull GuardPattern cOtherGuardPattern;
			/**
			 * The bottom pattern of the not-enforced domain: cOtherDomain.getOwnedBottomPattern().
			 */
			protected final @NonNull BottomPattern cOtherBottomPattern;

			public AbstractOtherRelationDomain2CoreDomain(@NonNull RelationDomain rOtherDomain) {
				this.rOtherDomain = rOtherDomain;
				this.rOtherDomainName = ClassUtil.nonNullState(rOtherDomain.getName());
				this.rOtherTypedModel = QVTrelationUtil.getTypedModel(rOtherDomain);
				this.rOtherBoundVariables = VariablesAnalysis.gatherBoundVariables(rOtherDomain);
				this.rOtherMemberVariables = VariablesAnalysis.gatherMemberVariables(rOtherDomain);
				this.rOtherRestVariables = VariablesAnalysis.gatherRestVariables(rOtherDomain);
				this.rOtherReferredVariables = new HashSet<>();
				VariablesAnalysis.gatherReferredVariables(rOtherReferredVariables, rOtherDomain);
				this.rOtherRootVariables = QVTrelationUtil.getRootVariables(rOtherDomain);
				//
				this.cOtherTypedModel = getCoreTypedModel(rOtherTypedModel);
				this.cOtherDomain = createCoreDomain(cOtherTypedModel, false);
				cOtherDomain.setIsCheckable(rOtherDomain.isIsCheckable());
				cOtherDomain.setIsEnforceable(false);
				this.cOtherGuardPattern = ClassUtil.nonNullState(cOtherDomain.getGuardPattern());
				this.cOtherBottomPattern = ClassUtil.nonNullState(cOtherDomain.getBottomPattern());
				//
				for (@NonNull Variable rVariable : rOtherBoundVariables.keySet()) {
					variablesAnalysis.getVariableAnalysis(rVariable).setOtherBound(cOtherDomain);
				}
				for (@NonNull Variable rVariable : rOtherReferredVariables) {
					variablesAnalysis.getVariableAnalysis(rVariable).setOtherReferred(cOtherDomain);
				}
				for (@NonNull Variable rVariable : rOtherRootVariables) {
					variablesAnalysis.getVariableAnalysis(rVariable).setIsRoot();
				}
			}

			// new
			private void mapOtherCollectionTemplateExpression(@NonNull CollectionTemplateExp cte) throws CompilerChainException {
				Variable vcte = QVTrelationUtil.getBindsTo(cte);
				Variable mvcte = variablesAnalysis.getCoreVariable(vcte);
				/**
				 * Each CollectionTemplateExp member that is not a variable
				 * converts to a VariableAssignment of a new variable the member expression.
				 *
				 * ve1:T1{tp = ve2:Collection{a++b}}		=>   a := a;
				 */
				Map<@NonNull OCLExpression, @NonNull Variable> rMember2mVariable = new HashMap<>();
				List<@NonNull OCLExpression> rMembers = QVTrelationUtil.Internal.getOwnedMembersList(cte);
				for (@NonNull OCLExpression rMember : rMembers) {
					Variable mVariable;
					if (rMember instanceof TemplateExp) {
						TemplateExp rTemplateExp = (TemplateExp)rMember;
						mapOtherTemplateExpression(rTemplateExp);
						Variable rVariable = QVTrelationUtil.getBindsTo(rTemplateExp);
						mVariable = variablesAnalysis.getCoreVariable(rVariable);
					}
					else if (rMember instanceof VariableExp) {
						Variable rVariable = QVTrelationUtil.getReferredVariable((VariableExp)rMember);
						mVariable = variablesAnalysis.getCoreVariable(rVariable);
					}
					else {
						OCLExpression mMember = mapExpression(rMember);
						mVariable = variablesAnalysis.addCoreVariable("member", mMember);
					}
					rMember2mVariable.put(rMember, mVariable);
				}
				//				CollectionTemplateExp cte = (CollectionTemplateExp) ptv;
				//				Variable vcte = ClassUtil.nonNullState(cte.getBindsTo());
				//				Variable mvcte = doRVarToMVar(vcte);
				//				PropertyCallExp pce =  createPropertyCallExp(ve1, tp);
				//				VariableAssignment a = createVariableAssignment(mvcte, pce);
				//				mb.getAssignment().add(a);


				CollectionType collectionType = QVTrelationUtil.getReferredCollectionType(cte);
				int size = rMembers.size();
				Variable rRest = cte.getRest();
				if (rRest == null) {
					/**
					 * The predicate for a CollectionTemplateExp without a rest variable is a total comparison.
					 *
					 * ve1:T1{tp = ve2:Collection{a,b}}		=>   ve2 := ve1.tp; ve2 = Collection{a,b};
					 */
					List<@NonNull CollectionLiteralPart> mParts = new ArrayList<>();
					for (@NonNull OCLExpression rMember : rMembers) {
						Variable mVariable = ClassUtil.nonNullState(rMember2mVariable.get(rMember));
						CollectionLiteralPart mItem = createCollectionItem(createVariableExp(mVariable));
						mParts.add(mItem);
					}
					CollectionLiteralExp cle = createCollectionLiteralExp(collectionType, mParts);
					variablesAnalysis.addConditionPredicate(cMiddleBottomPattern, createVariableExp(mvcte), cle);
				}
				/*				else if (collectionType.isOrdered()) {
					if (!rRest.isIsImplicit()) {
						/**
				 * The assignment for an ordered CollectionTemplateExp rest variable is a sub-collection assignment.
				 *
				 * ve1:T1{tp = ve2:Collection{a,b++c}}		=>   c := ve2->subCollection(3,ve2->size());
				 * /
						Variable mRest = variablesAnalysis.getCoreVariable(rRest);
						String opName = collectionType.isUnique() ? "subOrderedSet" : "subSequence";
						IntegerLiteralExp eStart = createIntegerLiteralExp(size);
						OCLExpression eFinish = createOperationCallExp(createVariableExp(mvcte), "size");
						OCLExpression eTail = createOperationCallExp(createVariableExp(mvcte), opName, eStart, eFinish);
						VariableAssignment aRest = createVariableAssignment(mRest, eTail);
						cMiddleBottomPattern.getAssignment().add(aRest);
					}
					/**
				 * The predicates for each ordered CollectionTemplateExp member variable is an element comparison.
				 *
				 * ve1:T1{tp = ve2:Collection{a,b++c}}		=>   a = ve2->at(1);
				 * /
					for (int i = 0; i < size; i++) {
						IntegerLiteralExp eIndex = createIntegerLiteralExp(i+1);
						OCLExpression vElement = createOperationCallExp(createVariableExp(mvcte), "at", eIndex);
						OCLExpression rMember = rMembers.get(i);
						Variable mVariable = ClassUtil.nonNullState(rMember2mVariable.get(rMember));
						variablesAnalysis.addConditionPredicate(cMiddleBottomPattern, createVariableExp(mVariable), vElement);
					}
				} */
				else {
					if (!rRest.isIsImplicit()) {
						/**
						 * The assignment for an unordered CollectionTemplateExp rest variable is a cumulative exclusion.
						 *
						 * ve1:T1{tp = ve2:Collection{a,b++c}}		=>   c := ve2->excluding(a)->excluding(b);
						 */
						Variable mRest = variablesAnalysis.getCoreVariable(rRest);
						OCLExpression exclusions = createVariableExp(mvcte);
						for (@NonNull OCLExpression rMember : rMembers) {
							Variable mVariable = ClassUtil.nonNullState(rMember2mVariable.get(rMember));
							exclusions = createOperationCallExp(exclusions, "excluding", createVariableExp(mVariable));
						}
						VariableAssignment aRest = createVariableAssignment(mRest, exclusions);
						cMiddleBottomPattern.getAssignment().add(aRest);
					}
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
						variablesAnalysis.addPredicate(cMiddleBottomPattern, eTerm);
					}
				}
			}

			// loop body of RDomainPatternToMDBottomPatternComposite
			private void mapOtherObjectTemplateExpression(@NonNull ObjectTemplateExp rTemplateExpression) throws CompilerChainException {
				Variable rTemplateVariable = QVTrelationUtil.getBindsTo(rTemplateExpression);
				for (@NonNull PropertyTemplateItem propertyTemplateItem : QVTrelationUtil.getOwnedParts(rTemplateExpression)) {
					Property partProperty = QVTrelationUtil.getReferredProperty(propertyTemplateItem);
					Variable cTemplateVariable = variablesAnalysis.getCoreVariable(rTemplateVariable);
					OCLExpression propertyTemplateValue = QVTrelationUtil.getOwnedValue(propertyTemplateItem);
					if (propertyTemplateValue instanceof VariableExp) {
						// body of RDomainPatternToMDBottomPatternSimpleSharedVarExpr and RDomainPatternToMDBottomPatternSimpleUnSharedVarExpr
						/**
						 * Each PropertyTemplateItem whose value is a simple VariableExp
						 * converts to a domain(unshared) / middle(shared) PropertyAssignment.
						 *
						 * ve1:T{tp = ve2}   =>   ve1.tp := ve2;
						 */
						Variable rVariable/*vpte*/ = QVTrelationUtil.getReferredVariable((VariableExp)propertyTemplateValue);
						Variable cVariable/*mvpte*/ = variablesAnalysis.getCoreVariable(rVariable);
						//				BottomPattern cBottomPattern = rSharedVariables.contains(rVariable) ? cMiddleBottomPattern : cEnforcedBottomPattern;
						variablesAnalysis.addNavigationPredicate(cOtherBottomPattern, rTemplateVariable, partProperty, createVariableExp(cVariable));
					}
					else if (propertyTemplateValue instanceof CollectionTemplateExp) {
						/**
						 * Each PropertyTemplateItem whose value is a CollectionTemplateExp
						 * converts to a VariableAssignment and Predicates.
						 *
						 * ve1:T1{tp = ve2:Collection{a++b}}		=>   ve2 := ve1.tp;
						 */
						CollectionTemplateExp cte = (CollectionTemplateExp)propertyTemplateValue;
						Variable vcte = QVTrelationUtil.getBindsTo(cte);
						Variable mvcte = variablesAnalysis.getCoreVariable(vcte);
						NavigationCallExp pce =  createNavigationCallExp(createVariableExp(cTemplateVariable), partProperty);
						VariableAssignment a = createVariableAssignment(mvcte, pce);
						cMiddleBottomPattern.getAssignment().add(a);
						mapOtherTemplateExpression(cte);
					}
					else if (propertyTemplateValue instanceof ObjectTemplateExp) {
						if (partProperty.isIsMany()) {
							/**
							 * Each PropertyTemplateItem whose value is an ObjectTemplateExp
							 * converts to a PropertyAssignment.
							 *
							 * ve1:T1{tp = ve2:T2{...}}   =>   ve1.tp := ve2;
							 */
							ObjectTemplateExp pte = (ObjectTemplateExp)propertyTemplateValue;
							Variable vpte = QVTrelationUtil.getBindsTo(pte);
							Variable mvpte = variablesAnalysis.getCoreVariable(vpte);
							NavigationCallExp cNavigationExp = createNavigationCallExp(createVariableExp(cTemplateVariable), partProperty);
							OperationCallExp eTerm = createOperationCallExp(cNavigationExp, "includes", createVariableExp(mvpte));
							variablesAnalysis.addPredicate(cOtherBottomPattern, eTerm);
							mapOtherTemplateExpression(pte);
						}
						else {
							/**
							 * Each PropertyTemplateItem whose value is an ObjectTemplateExp
							 * converts to a PropertyAssignment.
							 *
							 * ve1:T1{tp = ve2:T2{...}}   =>   ve1.tp := ve2;
							 */
							ObjectTemplateExp pte = (ObjectTemplateExp)propertyTemplateValue;
							Variable vpte = QVTrelationUtil.getBindsTo(pte);
							Variable mvpte = variablesAnalysis.getCoreVariable(vpte);
							variablesAnalysis.addNavigationPredicate(cOtherBottomPattern, rTemplateVariable, partProperty, createVariableExp(mvpte));
							mapOtherTemplateExpression(pte);
						}
					}
					else {
						// loop body of RDomainPatternToMDBottomPatternSimpleNonVarExpr
						/**
						 * Each PropertyTemplateItem whose value is not a TemplateExp and not a VariableExp
						 * converts to a PropertyAssignment.
						 *
						 * ve1:T{tp = me}   =>   ve1.tp := me;
						 */
						variablesAnalysis.addNavigationPredicate(cOtherBottomPattern, rTemplateVariable, partProperty, mapExpression(propertyTemplateValue));
					}
				}
			}

			// RDomainPatternToMDBottomPattern
			protected void mapOtherTemplateExpression(@NonNull TemplateExp rTemplateExpression) throws CompilerChainException {
				if (rTemplateExpression instanceof ObjectTemplateExp) {
					mapOtherObjectTemplateExpression((ObjectTemplateExp)rTemplateExpression);
				}
				else if (rTemplateExpression instanceof CollectionTemplateExp) {
					mapOtherCollectionTemplateExpression((CollectionTemplateExp)rTemplateExpression);
				}
				OCLExpression rGuardPredicate = rTemplateExpression.getWhere();
				if (rGuardPredicate != null) {
					cMiddleBottomPattern.getPredicate().add(createPredicate(mapExpression(rGuardPredicate)));
				}
			}

			public void synthesize() throws CompilerChainException {
				List<@NonNull TemplateExp> rOtherTemplateExpressions = getRootTemplateExpressions(rOtherDomain);
				for (@NonNull TemplateExp rOtherTemplateExpression : rOtherTemplateExpressions) {
					mapOtherTemplateExpression(rOtherTemplateExpression);
				}
			}
		}

		/**
		 * An ExpressionCopier deep copies an OCLExpression tree, exploiting the forward traceability of context to
		 * update references and using sibling to distinguish multiple targets.
		 */
		@SuppressWarnings("serial")
		protected class ExpressionCopier extends EcoreUtil.Copier
		{	// FIXME enforce unique names on let-variables, iterators
			@Override
			public EObject get(Object oIn) {
				if (oIn instanceof Element) {
					List<@NonNull Element> oOuts = source2targets.get(oIn);
					if (oOuts != null) {
						assert oOuts.size() == 1;
						return oOuts.get(0);
					}
					oOuts = qvtr2qvtc.getGlobalTargets((Element) oIn);
					if (oOuts != null) {
						assert oOuts.size() == 1;
						return oOuts.get(0);
					}
				}
				return super.get(oIn);
			}

			@Override
			public EObject copy(EObject oIn) {
				try {
					if (oIn instanceof IteratorVariable) {
						return variablesAnalysis.getCoreVariable((IteratorVariable)oIn);
					}
					else if (oIn instanceof LetVariable) {
						return variablesAnalysis.getCoreVariable((LetVariable)oIn);
					}
				} catch (CompilerChainException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return super.copy(oIn);
			}
		}

		// Relations
		/**
		 *  rd: The relation domain to be enforced
		 */
		protected final @NonNull RelationDomain rEnforcedDomain;
		/**
		 *  The TypedModel of the enforced domain: rEnforcedDomain.getTypedModel()
		 */
		protected final @NonNull TypedModel rEnforcedTypedModel;
		/**
		 * The name of the enforced domain: rEnforcedDomain.getName()
		 */
		protected final @NonNull String rEnforcedDomainName;
		/**
		 *  Mapping from each bound variable in the enforced relation domain to the TemplateExp that bindsTo it.
		 *  Excludes CollectionTemplateExp.member, CollectionTemplateExp.rest.
		 */
		protected final @NonNull Map<@NonNull Variable, @NonNull TemplateExp> rEnforcedBoundVariables;
		/**
		 *  Mapping from each member variable in the enforced relation domain to each CollectionTemplateExp that
		 *  has a  VariableExp member that refers to it.
		 */
		protected final @Nullable Map<@NonNull Variable, @NonNull List<@NonNull CollectionTemplateExp>> rEnforcedMemberVariables;
		/**
		 *  Mapping from each rest variable in the enforced relation domain to its CollectionTemplateExp.
		 */
		protected final @Nullable Map<@NonNull Variable, @NonNull CollectionTemplateExp> rEnforcedRestVariables;
		/**
		 *  All variables defined or referenced in the enforced relation domain
		 */
		protected final @NonNull Set<@NonNull Variable> rEnforcedReferredVariables;
		/**
		 *  te: The template expressions defining the roots of the enforced domain pattern
		 */
		protected final @NonNull List<@NonNull/*Object*/TemplateExp> rEnforcedRootTemplateExpressions;
		/**
		 *  tev: The template expression root variables (the root variables of the enforced domain pattern)
		 */
		protected final @NonNull List<@NonNull Variable> rEnforcedRootVariables;
		/**
		 * The conversion for each other domains sharing the parent of this domain
		 */
		protected final @NonNull List<@NonNull AbstractOtherRelationDomain2CoreDomain> otherDomain2coreDomains;
		/**
		 *  All variables defined in other domains
		 */
		protected final @NonNull Set<@NonNull Variable> rAllOtherBoundVariables;
		/**
		 *  All variables defined or referenced in other domains
		 */
		protected final @NonNull Set<@NonNull Variable> rAllOtherReferredVariables;
		// Core
		/**
		 *  m: The resultant mapping
		 */
		protected final @NonNull Mapping cMapping;
		/**
		 *  mg: The resultant mapping guard pattern: cMapping.getOwnedGuardPattern()
		 */
		protected final @NonNull GuardPattern cMiddleGuardPattern;
		/**
		 *  mb : The resultant mapping bottom pattern: cMapping.getOwnedBottomPattern()
		 */
		protected final @NonNull BottomPattern cMiddleBottomPattern;
		/**
		 *  mdir: The resultant enforced typed model
		 */
		protected final @NonNull TypedModel cEnforcedTypedModel;
		/**
		 *  md: The resultant enforced domain
		 */
		protected final @NonNull CoreDomain cEnforcedDomain;
		/**
		 *  dg: The resultant enforced domain guard pattern
		 */
		protected final @NonNull GuardPattern cEnforcedGuardPattern;
		/**
		 *  db: The resultant enforced domain bottom pattern
		 */
		protected final @NonNull BottomPattern cEnforcedBottomPattern;
		/**
		 *  The analysis of each viariable in the relation.
		 */
		protected final @NonNull VariablesAnalysis variablesAnalysis;
		/**
		 * tcv: The trace class variable (the middle variable identifying the middle object)
		 */
		protected final @NonNull RealizedVariable cMiddleRealizedVariable;
		/**
		 * Mapping from each relation element to its corresponding core element(s).
		 */
		private final @NonNull Map<@NonNull Element, @NonNull List<@NonNull Element>> source2targets = new HashMap<>();
		/**
		 * Mapping from each core element to its corresponding relation element.
		 */
		private final @NonNull Map<@NonNull Element, @NonNull Element> target2source = new HashMap<>();

		public AbstractEnforceableRelationDomain2CoreMapping(@NonNull RelationDomain rEnforcedDomain, @NonNull String cMappingName) throws CompilerChainException {
			this.rEnforcedDomain = rEnforcedDomain;
			//
			this.rEnforcedBoundVariables = VariablesAnalysis.gatherBoundVariables(rEnforcedDomain);
			this.rEnforcedMemberVariables = VariablesAnalysis.gatherMemberVariables(rEnforcedDomain);
			this.rEnforcedRestVariables = VariablesAnalysis.gatherRestVariables(rEnforcedDomain);
			this.rEnforcedReferredVariables = new HashSet<>();
			VariablesAnalysis.gatherReferredVariables(rEnforcedReferredVariables, rEnforcedDomain);
			this.rEnforcedRootTemplateExpressions = getRootTemplateExpressions(rEnforcedDomain);
			this.rEnforcedRootVariables = QVTrelationUtil.getRootVariables(rEnforcedDomain);
			this.rEnforcedTypedModel = QVTrelationUtil.getTypedModel(rEnforcedDomain);
			this.rEnforcedDomainName = ClassUtil.nonNullState(rEnforcedDomain.getName());
			@NonNull Type traceClass = qvtr2qvtc.getTraceClass(rRelation);
			//
			this.cEnforcedTypedModel = getCoreTypedModel(rEnforcedTypedModel);
			this.cMapping = qvtr2qvtc.createMapping(rRelation, cMappingName);
			this.cMiddleGuardPattern = ClassUtil.nonNullState(cMapping.getGuardPattern());
			this.cMiddleBottomPattern = ClassUtil.nonNullState(cMapping.getBottomPattern());
			this.cEnforcedDomain = createCoreDomain(cEnforcedTypedModel, true);
			this.cEnforcedGuardPattern = ClassUtil.nonNullState(cEnforcedDomain.getGuardPattern());
			this.cEnforcedBottomPattern = ClassUtil.nonNullState(cEnforcedDomain.getBottomPattern());
			//
			this.variablesAnalysis = new VariablesAnalysis(qvtr2qvtc, rEnforcedDomain, cEnforcedDomain, traceClass, this instanceof InvokedEnforceableRelationDomain2CoreMapping);
			this.cMiddleRealizedVariable = variablesAnalysis.getMiddleRealizedVariable();
			//			putTrace(cMiddleRealizedVariable, cMiddleBottomPattern);
			//
			this.otherDomain2coreDomains = new ArrayList<>();
			this.rAllOtherBoundVariables = new HashSet<>();
			for (@NonNull Domain rDomain : ClassUtil.nullFree(rEnforcedDomain.getRule().getDomain())) {
				if ((rDomain != rEnforcedDomain) && (rDomain instanceof RelationDomain)) {
					RelationDomain rRelationDomain = (RelationDomain)rDomain;
					otherDomain2coreDomains.add(createOtherDomain2CoreDomain(rRelationDomain));
				}
			}
			Set<@NonNull Variable> rUnsharedEnforcedDomainVariables = new HashSet<>(rEnforcedReferredVariables);
			rUnsharedEnforcedDomainVariables.removeAll(rSharedVariables);
			this.rAllOtherReferredVariables = new HashSet<>(rAllVariables);
			rAllOtherReferredVariables.removeAll(rUnsharedEnforcedDomainVariables);
			//
			for (Map.Entry<@NonNull Variable, @Nullable TypedModel> entry : rWhenVariable2rTypedModel.entrySet()) {
				TypedModel rWhenTypedModel = entry.getValue();
				if (rWhenTypedModel != null) {
					variablesAnalysis.getVariableAnalysis(entry.getKey()).setWhen(getCoreDomain(rWhenTypedModel));
				}
			}
			for (Map.Entry<@NonNull Variable, @Nullable TypedModel> entry : rWhereVariable2rTypedModel.entrySet()) {
				TypedModel rWhereTypedModel = entry.getValue();
				if (rWhereTypedModel != null) {
					variablesAnalysis.getVariableAnalysis(entry.getKey()).setWhere(getCoreDomain(rWhereTypedModel));
				}
			}
			for (@NonNull Variable rVariable : rEnforcedBoundVariables.keySet()) {
				Key rKey = qvtr2qvtc.getKeyForType(QVTrelationUtil.getType(rVariable));
				variablesAnalysis.getVariableAnalysis(rVariable).setIsEnforcedBound(rEnforcedBoundVariables.get(rVariable), rEnforcedTypedModel, rKey);
			}
			for (@NonNull Variable rVariable : rEnforcedReferredVariables) {
				variablesAnalysis.getVariableAnalysis(rVariable).setIsEnforcedReferred();
			}
			for (@NonNull Variable rVariable : rEnforcedRootVariables) {
				variablesAnalysis.getVariableAnalysis(rVariable).setIsRoot();
			}
			//
			for (Map.Entry<@NonNull Variable, @Nullable TypedModel> entry : rWhenVariable2rTypedModel.entrySet()) {
				Variable rWhenVariable = entry.getKey();
				TypedModel rWhenTypedModel = entry.getValue();
				VariableAnalysis variableAnalysis = variablesAnalysis.getVariableAnalysis(rWhenVariable);
				if (rWhenTypedModel == null) {
					OCLExpression rWhenInit = rWhenVariable.getOwnedInit();
					if (rWhenInit != null) {
						Set<@NonNull Variable> rReferredVariables = new HashSet<>();
						VariablesAnalysis.gatherReferredVariables(rReferredVariables, rWhenInit);
						for (Variable rReferredVariable : rReferredVariables) {
							VariableAnalysis referredVariableAnalysis = variablesAnalysis.basicGetVariableAnalysis(rReferredVariable);
							if (referredVariableAnalysis != null) {
								CorePattern corePattern = referredVariableAnalysis.getCorePattern();
								if (corePattern != null) {
									variableAnalysis.setPredicate(ClassUtil.nonNullState(corePattern.getArea()));	// FIXME need QVTrDomainAnalayis
								}
								break;
							}
						}
					}
				}
			}
			//
			QVTr2QVTc.VARIABLES.println(" In " + cMapping + "\n\t\t" + variablesAnalysis.toString().replace("\n", "\n\t\t"));
			for (@NonNull VariableAnalysis analysis : variablesAnalysis.getAnalyses()) {
				Variable rVariable = analysis.getRelationVariable();
				if (rVariable != null) {
					Variable cVariable = analysis.getCoreVariable();
					putTrace(cVariable, rVariable);
				}
			}
			for (@NonNull VariableAnalysis analysis : variablesAnalysis.getAnalyses()) {
				Variable rVariable = analysis.getRelationVariable();
				if (rVariable != null) {
					OCLExpression rOwnedInit = rVariable.getOwnedInit();
					if (rOwnedInit != null) {
						Variable cVariable = analysis.getCoreVariable();
						cVariable.setOwnedInit(mapExpression(rOwnedInit));
						//					variablesAnalysis.addConditionPredicate(analysis.getCorePattern(), createVariableExp(cVariable), mapExpression(rOwnedInit));
					}
				}
			}
		}

		// Quad call of RDomainPatternExprToMappingXXXX
		private void addPropertyAssignmentToMiddleBottomPattern(@NonNull Variable rTargetVariable, @NonNull Property targetProperty, @NonNull OCLExpression rExpression) throws CompilerChainException {
			Variable cTargetVariable = null;
			OCLExpression cExpression = null;
			if (rExpression instanceof ObjectTemplateExp) {
				// body of RDomainPatternExprToMappingDomainTemplateVarAssignment
				Variable rBoundVariable = ClassUtil.nonNullState(((ObjectTemplateExp)rExpression).getBindsTo());
				if (!rSharedVariables.contains(rBoundVariable)) {
					Variable cBoundVariable = variablesAnalysis.getCoreVariable(rBoundVariable);  // FIXME whenVariable(cMiddleBottomPattern, rBoundVariable);
					cExpression = createVariableExp(cBoundVariable);
					cTargetVariable = variablesAnalysis.addTraceNavigationAssignment(rBoundVariable, false);
				}
			}
			else if (rExpression instanceof VariableExp) {
				cTargetVariable = variablesAnalysis.getCoreVariable(rTargetVariable);		// getCoreVariable should do and be uniform
				Variable rReferredVariable = ClassUtil.nonNullState((Variable) ((VariableExp)rExpression).getReferredVariable());
				Variable cReferredVariable = variablesAnalysis.getCoreVariable(rReferredVariable);
				if (rSharedVariables.contains(rReferredVariable) ) {
					// body of RDomainPatternExprToMappingBottomVarAssignment
				}
				else {
					// body of RDomainPatternExprToMappingDomainVarAssignment
					if (!cEnforcedBottomPattern.getRealizedVariable().contains(cTargetVariable)) {
						// FIXME variables should have been plotted earlier
						cEnforcedBottomPattern.getRealizedVariable().add((RealizedVariable)cTargetVariable);
					}
				}
				cExpression = createVariableExp(cReferredVariable);
			}
			else {
				// body of RDomainPatternExprToMappingDomainAssignment
				cTargetVariable = variablesAnalysis.getCoreVariable(rTargetVariable);
				cExpression = mapExpression(rExpression);
			}
			if ((cTargetVariable != null) && (cExpression != null)) {
				variablesAnalysis.addNavigationAssignment(rTargetVariable, targetProperty, cExpression, false);
			}
		}

		private @NonNull CoreDomain createCoreDomain(@NonNull TypedModel cTypedModel, boolean isEnforced) {
			CoreDomain coreDomain = qvtr2qvtc.createCoreDomain(cTypedModel);
			coreDomain.setIsCheckable(false);
			coreDomain.setIsEnforceable(isEnforced);
			coreDomain.setRule(cMapping);
			return coreDomain;
		}

		protected abstract @NonNull AbstractOtherRelationDomain2CoreDomain createOtherDomain2CoreDomain(@NonNull RelationDomain rRelationDomain);

		//		protected @NonNull CoreDomain getCoreDomain(@NonNull RelationDomain rDomain) {
		//			return getCoreDomain(QVTrelationUtil.getTypedModel(rDomain));
		//		}

		protected @NonNull CoreDomain getCoreDomain(@NonNull TypedModel rTypedModel) {
			TypedModel cTypedModel = getCoreTypedModel(rTypedModel);
			for (@NonNull Domain cDomain : ClassUtil.nullFree(cMapping.getDomain())) {	// FIXME provide a Map cache
				if (QVTcoreUtil.getTypedModel(cDomain) == cTypedModel) {
					return (CoreDomain) cDomain;
				}
			}
			throw new IllegalStateException();
		}

		protected @NonNull TypedModel getCoreTypedModel(@NonNull TypedModel rTypedModel) {
			String name = PivotUtil.getName(rTypedModel);
			Iterable<org.eclipse.ocl.pivot.@NonNull Package> usedPackages = QVTrelationUtil.getUsedPackages(rTypedModel);
			for (@NonNull TypedModel cTypedModel : QVTcoreUtil.getModelParameters(cTransformation)) {
				if (name.equals(cTypedModel.getName())) {
					assert cTypedModel.getUsedPackage().equals(usedPackages);
					return cTypedModel;
				}
			}
			return ClassUtil.nonNullState(null);
		}

		protected abstract @NonNull Set<@NonNull Variable> getEnforcedBottomDomainVariables();

		//		protected abstract @NonNull Set<@NonNull Variable> getEnforcedDomainGuardVariables(@NonNull Set<@NonNull Variable> rEnforcedBottomDomainVariables);

		protected @NonNull Set<@NonNull RelationDomain> getOtherRelationDomains() {
			Set<@NonNull RelationDomain> relationDomains = new HashSet<>();
			for (@NonNull Domain relationDomain : QVTrelationUtil.getOwnedDomains(rRelation)) {
				relationDomains.add((RelationDomain) relationDomain);
			}
			relationDomains.remove(rEnforcedDomain);
			return relationDomains;
		}

		protected @NonNull List<@NonNull TemplateExp> getRootTemplateExpressions(@NonNull RelationDomain rRelationDomain) {
			List<@NonNull TemplateExp> rTemplateExpressions = new ArrayList<>();
			for (@NonNull DomainPattern rDomainPattern : QVTrelationUtil.getOwnedPatterns(rRelationDomain)) {
				rTemplateExpressions.add(QVTrelationUtil.getOwnedTemplateExpression(rDomainPattern));
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

		protected void mapEnforcedCollectionTemplateExpression(@NonNull CollectionTemplateExp rEnforcedCollectionTemplateExp, @Nullable Key key) throws CompilerChainException {
			//			Property partProperty = ClassUtil.nonNullState(propertyTemplateItem.getReferredProperty());
			//			Variable cTemplateVariable = variablesAnalysis.getCoreVariable(rTemplateVariable);
			@NonNull CollectionTemplateExp cte = rEnforcedCollectionTemplateExp;
			/**
			 * Each PropertyTemplateItem whose value is a CollectionTemplateExp
			 * converts to a VariableAssignment and Predicates.
			 *
			 * ve1:T1{tp = ve2:Collection{a++b}}		=>   ve2 := ve1.tp;
			 */
			Variable vcte = QVTrelationUtil.getBindsTo(cte);
			Variable mvcte = variablesAnalysis.getCoreVariable(vcte);
			/*			NavigationCallExp pce =  createNavigationCallExp(createVariableExp(cTemplateVariable), partProperty);
			VariableAssignment a = createVariableAssignment(mvcte, pce);
			cMiddleBottomPattern.getAssignment().add(a);
			/**
			 * Each CollectionTemplateExp member that is not a variable
			 * converts to a VariableAssignment of a new variable the member expression.
			 *
			 * ve1:T1{tp = ve2:Collection{a++b}}		=>   a := a;
			 */
			Map<@NonNull OCLExpression, @NonNull Variable> rMember2mVariable = new HashMap<>();
			List<@NonNull OCLExpression> rMembers = QVTrelationUtil.Internal.getOwnedMembersList(cte);
			for (@NonNull OCLExpression rMember : rMembers) {
				Variable mVariable;
				if (rMember instanceof TemplateExp) {
					TemplateExp rTemplateExp = (TemplateExp)rMember;
					mapEnforcedTemplateExpression(rTemplateExp);
					Variable rVariable = QVTrelationUtil.getBindsTo(rTemplateExp);
					mVariable = variablesAnalysis.getCoreVariable(rVariable);
				}
				else if (rMember instanceof VariableExp) {
					Variable rVariable = QVTrelationUtil.getReferredVariable((VariableExp)rMember);
					mVariable = variablesAnalysis.getCoreVariable(rVariable);
				}
				else {
					OCLExpression mMember = mapExpression(rMember);
					mVariable = variablesAnalysis.addCoreVariable("member", mMember);
				}
				rMember2mVariable.put(rMember, mVariable);
			}
			//				CollectionTemplateExp cte = (CollectionTemplateExp) ptv;
			//				Variable vcte = ClassUtil.nonNullState(cte.getBindsTo());
			//				Variable mvcte = doRVarToMVar(vcte);
			//				PropertyCallExp pce =  createPropertyCallExp(ve1, tp);
			//				VariableAssignment a = createVariableAssignment(mvcte, pce);
			//				mb.getAssignment().add(a);

			CollectionType collectionType = QVTrelationUtil.getReferredCollectionType(cte);
			Variable rRest = cte.getRest();
			if (rRest == null) {
				/**
				 * The predicate for a CollectionTemplateExp without a rest variable is a total comparison.
				 *
				 * ve1:T1{tp = ve2:Collection{a,b}}		=>   ve2 := ve1.tp; ve2 = Collection{a,b};
				 */
				List<@NonNull CollectionLiteralPart> mParts = new ArrayList<>();
				for (@NonNull OCLExpression rMember : rMembers) {
					Variable mVariable = ClassUtil.nonNullState(rMember2mVariable.get(rMember));
					CollectionLiteralPart mItem = createCollectionItem(createVariableExp(mVariable));
					mParts.add(mItem);
				}
				CollectionLiteralExp cle = createCollectionLiteralExp(collectionType, mParts);
				variablesAnalysis.addConditionPredicate(cMiddleBottomPattern, createVariableExp(mvcte), cle);
			}
			/*				else if (collectionType.isOrdered()) {
				if (!rRest.isIsImplicit()) {
					/**
			 * The assignment for an ordered CollectionTemplateExp rest variable is a sub-collection assignment.
			 *
			 * ve1:T1{tp = ve2:Collection{a,b++c}}		=>   c := ve2->subCollection(3,ve2->size());
			 * /
					Variable mRest = variablesAnalysis.getCoreVariable(rRest);
					String opName = collectionType.isUnique() ? "subOrderedSet" : "subSequence";
					IntegerLiteralExp eStart = createIntegerLiteralExp(size);
					OCLExpression eFinish = createOperationCallExp(createVariableExp(mvcte), "size");
					OCLExpression eTail = createOperationCallExp(createVariableExp(mvcte), opName, eStart, eFinish);
					VariableAssignment aRest = createVariableAssignment(mRest, eTail);
					cMiddleBottomPattern.getAssignment().add(aRest);
				}
				/**
			 * The predicates for each ordered CollectionTemplateExp member variable is an element comparison.
			 *
			 * ve1:T1{tp = ve2:Collection{a,b++c}}		=>   a = ve2->at(1);
			 * /
				for (int i = 0; i < size; i++) {
					IntegerLiteralExp eIndex = createIntegerLiteralExp(i+1);
					OCLExpression vElement = createOperationCallExp(createVariableExp(mvcte), "at", eIndex);
					OCLExpression rMember = rMembers.get(i);
					Variable mVariable = ClassUtil.nonNullState(rMember2mVariable.get(rMember));
					variablesAnalysis.addConditionPredicate(cMiddleBottomPattern, createVariableExp(mVariable), vElement);
				}
			} */
			else if (rRest.isIsImplicit()) {
				PropertyTemplateItem rPropertyTemplateItem = (PropertyTemplateItem) cte.eContainer();
				assert rPropertyTemplateItem != null;
				ObjectTemplateExp rObjectTemplateExp = QVTrelationUtil.getOwningObjectTemplateExp(rPropertyTemplateItem);
				Variable vote = QVTrelationUtil.getBindsTo(rObjectTemplateExp);
				Variable cvote = variablesAnalysis.getCoreVariable(vote);
				/**
				 * The assignment for a CollectionTemplateExp variable is a literal for the members and an addition of the rest.
				 *
				 * ve1:T1{tp = ve2:Collection{a,b++_}}		=>   ve1.tp += a; ve1.tp += b;
				 */
				for (@NonNull OCLExpression rMember : rMembers) {
					Variable mVariable = ClassUtil.nonNullState(rMember2mVariable.get(rMember));
					NavigationAssignment aRest = createNavigationAssignment(createVariableExp(cvote), QVTrelationUtil.getReferredProperty(rPropertyTemplateItem), createVariableExp(mVariable), true);
					cMiddleBottomPattern.getAssignment().add(aRest);
				}
			}
			else {
				/**
				 * The assignment for a CollectionTemplateExp variable is a literal for the members and an addition of the rest.
				 *
				 * ve1:T1{tp = ve2:Collection{a,b++c}}		=>   ve2 := Collection{a,b}->includingAll(c);
				 */
				List<@NonNull CollectionLiteralPart> ownedParts = new ArrayList<>();
				for (@NonNull OCLExpression rMember : rMembers) {
					Variable mVariable = ClassUtil.nonNullState(rMember2mVariable.get(rMember));
					ownedParts.add(createCollectionItem(createVariableExp(mVariable)));
				}
				OCLExpression cExpression = createCollectionLiteralExp(collectionType, ownedParts);
				Variable mRest = variablesAnalysis.getCoreVariable(rRest);
				cExpression = createOperationCallExp(cExpression, "includingAll", createVariableExp(mRest));
				VariableAssignment aRest = createVariableAssignment(mvcte, cExpression);
				cMiddleBottomPattern.getAssignment().add(aRest);
			}
		}

		// RDomainToMDBottomForEnforcement (second half)
		protected void mapEnforcedDomainPatterns() throws CompilerChainException {
			for (@NonNull TemplateExp rEnforcedRootTemplateExpression/*te*/ : rEnforcedRootTemplateExpressions) {
				mapEnforcedTemplateExpression(rEnforcedRootTemplateExpression);
			}
		}

		protected void mapEnforcedObjectTemplateExpression(@NonNull ObjectTemplateExp rEnforcedObjectTemplateExpression, @Nullable Key key) throws CompilerChainException {
			Variable rTemplateVariable/*v*/ = QVTrelationUtil.getBindsTo(rEnforcedObjectTemplateExpression);
			for (@NonNull PropertyTemplateItem pt : QVTrelationUtil.getOwnedParts(rEnforcedObjectTemplateExpression)) {
				Property partProperty = QVTrelationUtil.getReferredProperty(pt);
				OCLExpression rPartValue/*pte*/ = QVTrelationUtil.getOwnedValue(pt);
				if ((key != null) && key.getPart().contains(partProperty)) {
					//  body of RDomainToMDBottomForEnforcementOfIdentityProp
					addPropertyAssignmentToMiddleBottomPattern(rTemplateVariable, partProperty, rPartValue);
				}
				else if (rPartValue instanceof CollectionTemplateExp) {
					// body of RDomainToMDBottomForEnforcementOfNonIdentityPropObject
					CollectionTemplateExp cte = (CollectionTemplateExp)rPartValue;
					/**
					 * Each PropertyTemplateItem whose value is a CollectionTemplateExp
					 * converts to a VariableAssignment and Predicates.
					 *
					 * ve1:T1{tp = ve2:Collection{a++b}}		=>   ve2 := ve1.tp;
					 */
					/*Realized*/Variable cTemplateVariable = variablesAnalysis.getCoreVariable(rTemplateVariable);
					Variable vcte = QVTrelationUtil.getBindsTo(cte);
					Variable mvcte = variablesAnalysis.getCoreVariable(vcte);
					NavigationCallExp pce =  createNavigationCallExp(createVariableExp(cTemplateVariable), partProperty);
					VariableAssignment a = createVariableAssignment(mvcte, pce);
					cMiddleBottomPattern.getAssignment().add(a);
					mapEnforcedTemplateExpression(cte);
				}
				else if (rPartValue instanceof ObjectTemplateExp) {
					// body of RDomainToMDBottomForEnforcementOfNonIdentityPropObject
					ObjectTemplateExp ote = (ObjectTemplateExp)rPartValue;
					Variable pv = ClassUtil.nonNullState(ote.getBindsTo());
					/*Realized*/Variable cTargetVariable/*mpv*/ = variablesAnalysis.getCoreVariable(pv); //rWhenVariables.contains(pv) ? getCoreVariable(pv) : whenRealizedVariable(cEnforcedBottomPattern, pv);
					//					Variable cTemplateVariable/*mv*/ = variablesAnalysis.getCoreVariable(rTemplateVariable);
					variablesAnalysis.addNavigationAssignment(rTemplateVariable, partProperty, createVariableExp(cTargetVariable), null);
					mapEnforcedTemplateExpression(ote);
					//					Property cTargetProperty2 = qvtr2qvtc.getProperty(cMiddleRealizedVariable.getType(), cTargetVariable);
					//					variablesAnalysis.addNavigationAssignment(rMiddleRealizedVariable, cTargetProperty2, createVariableExp(cTargetVariable));
				}
				else if (rPartValue instanceof VariableExp) {
					// body of RDomainToMDBottomForEnforcementOfNonIdentityPropPrimitive
					//					Variable cTemplateVariable = variablesAnalysis.getCoreVariable(rTemplateVariable);
					//RDomainToMComposedMappingGuardrEnforcedDomain
					for (@NonNull TemplateExp rTemplateExpression : rEnforcedRootTemplateExpressions) {
						if (rTemplateExpression instanceof ObjectTemplateExp) {
							// check
							Variable rReferredVariable = QVTrelationUtil.getReferredVariable((VariableExp) rPartValue);
							if (isVarBoundToSomeOtherTemplate((ObjectTemplateExp) rTemplateExpression, rEnforcedObjectTemplateExpression, rReferredVariable)) {
								Variable cReferredVariable = variablesAnalysis.getCoreVariable(rReferredVariable);
								Property cTargetProperty = qvtr2qvtc.getProperty(cReferredVariable.getType(), cReferredVariable);
								NavigationCallExp cPropertyCallExp = createNavigationCallExp(createVariableExp(cMiddleRealizedVariable), cTargetProperty);
								variablesAnalysis.addConditionPredicate(cMiddleGuardPattern, cPropertyCallExp, createVariableExp(cReferredVariable));
								cEnforcedGuardPattern.getBindsTo().add(cReferredVariable);
							}
						}
					}
					variablesAnalysis.addNavigationAssignment(rTemplateVariable, partProperty, mapExpression(rPartValue), null);
				}
				else {
					// body of RDomainToMDBottomForEnforcementOfNonIdentityPropPrimitive
					//					Variable cTemplateVariable = variablesAnalysis.getCoreVariable(rTemplateVariable);
					//RDomainToMComposedMappingGuardrEnforcedDomain
					variablesAnalysis.addNavigationAssignment(rTemplateVariable, partProperty, mapExpression(rPartValue), null);
				}
			}
		}

		// RDomainToMDBottomForEnforcement
		private void mapEnforcedTemplateExpression(@NonNull TemplateExp rEnforcedTemplateExpression/*te*/) throws CompilerChainException {
			Variable rTemplateVariable/*v*/ = QVTrelationUtil.getBindsTo(rEnforcedTemplateExpression);
			Type rTemplateVariableType/*c*/ = QVTrelationUtil.getType(rTemplateVariable);
			Key key = qvtr2qvtc.getKeyForType(rTemplateVariableType);
			VariableAnalysis variableAnalysis = variablesAnalysis.getVariableAnalysis(rTemplateVariable);
			if (variableAnalysis.hasWhenDomain()) {
				key = null;
			}
			//			if (key == null){
			//				// Nothing to do
			//			}
			/*else*/ if (rEnforcedTemplateExpression instanceof ObjectTemplateExp) {
				mapEnforcedObjectTemplateExpression((ObjectTemplateExp)rEnforcedTemplateExpression, key);
			}
			else if (rEnforcedTemplateExpression instanceof CollectionTemplateExp) {
				mapEnforcedCollectionTemplateExpression((CollectionTemplateExp)rEnforcedTemplateExpression, key);
			}
			else {
				throw new CompilerChainException("Missing mapEnforcedTemplateExpression support " + rEnforcedTemplateExpression.eClass().getName());
			}
			// This call is wrong as the trace variable is realized, it can't be guarded.
			// This should only be done in a nested mapping or later mapping
			//doRDomainToMBottomPredicateForEnforcement(r, rd, te, predicatesWithoutVarBindings, unboundDomainVars, mb);
			/*
			 * Creates the assignment of the middle model to the L/R models
			 */
			// RDomainVarToMDBottomAssignmnetForEnforcement
			variablesAnalysis.addTraceNavigationAssignment(rTemplateVariable, false);
			OCLExpression rGuardPredicate = rEnforcedTemplateExpression.getWhere();
			if (rGuardPredicate != null) {
				cMiddleGuardPattern.getPredicate().add(createPredicate(mapExpression(rGuardPredicate)));
			}
		}

		// 15
		/*
		 * Creates a Predicate, who's ConditionExpression is an
		 * OperationCallExp:
		 * 		trace.<v.name> = v;
		 * TODO Suggest better name: RDomainPatternVariableToTracePredicate?
		 *
		private void doRDomainToMBottomPredicateForEnforcement(@NonNull Set<@NonNull Predicate> predicatesWithoutVarBindings, @NonNull Set<@NonNull Variable> unboundDomainVars) throws CompilerChainException
		{
			Set<@NonNull Variable> remainingUnBoundDomainVars = new HashSet<>(unboundDomainVars);
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
		} */

		/*
		 * The issue with this method is that all variables should have been
		 * transformed so all variable references can be correctly pointed.
		 * However, if we call it after all variable modifying relations it
		 * should work.
		 */
		// 25
		protected @NonNull OCLExpression mapExpression(@NonNull OCLExpression rExpression) {
			EcoreUtil.Copier copier = new ExpressionCopier();
			OCLExpression eOut = (OCLExpression) copier.copy(rExpression);
			copier.copyReferences();
			for (EObject eSource : copier.keySet()) {
				EObject eTarget = copier.get(eSource);
				if (eTarget != null) {
					assert eSource != null;
					putTrace((Element)eTarget, (Element)eSource);
				}
			}
			assert eOut != null;
			return eOut;
		}

		protected void mapInvocation() throws CompilerChainException {}

		// IROppositeDomainsToMappingForEnforcement
		protected void mapOtherDomainPatterns() throws CompilerChainException {
			for (@NonNull AbstractOtherRelationDomain2CoreDomain otherDomain2coreDomain : otherDomain2coreDomains) {
				otherDomain2coreDomain.synthesize();
			}
		}

		// ROppositeDomainVarsToTraceClassProps
		protected void mapOtherDomainVariables(@NonNull Set<@NonNull Variable> rDomainVariables) throws CompilerChainException {
			for (@NonNull Variable rDomainVariable : rDomainVariables) {
				//				VariableAnalysis analysis = getVariableAnalysis(rDomainVariable);
				//				TemplateExp rTemplateExp = analysis.getTemplateExp();
				//				if (dvte instanceof ObjectTemplateExp) {
				// tp=dv:T{...} => tcv.tp := dv;
				variablesAnalysis.addTraceNavigationAssignment(rDomainVariable, true);
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

		//		protected @NonNull Variable mapRealizedVariable(@NonNull Variable rVariable) {
		//			return whenRealizedVariable(cEnforcedBottomPattern, rVariable);
		//		}

		/**
		 * Transform a rule implemented by a black box into an enforcement operation
		 *
		 * @param rRelation the r
		 * @param rEnforcedDomain the rd
		 * @param cMiddleBottomPattern the mb
		 */
		// RRelImplToMBottomEnforcementOperation
		protected void mapRelationImplementation() {
			// TODO Code this when testing transformations with operational implementations.
		}

		//		protected void mapVariables(@NonNull Iterable<@NonNull Variable> rVariables, @NonNull CorePattern cPattern) {		// RVarSetToDGVarSet, RVarSetToMBVarSet
		//			for (@NonNull Variable rVariable : rVariables) {
		//				whenVariable(cPattern, rVariable);
		//			}
		//		}

		// RWhenPatternToMGuardPattern
		protected void mapWhenPattern() throws CompilerChainException {
			Pattern rWhenPattern = rRelation.getWhen();
			if (rWhenPattern != null) {
				Set<@NonNull Variable> rMiddleGuardDomainVariables = new HashSet<>(rWhenVariable2rTypedModel.keySet());
				rMiddleGuardDomainVariables.removeAll(rAllVariables);
				//
				for (@NonNull Predicate rWhenPredicate : QVTrelationUtil.getOwnedPredicates(rWhenPattern)) {
					OCLExpression rConditionExpression = QVTrelationUtil.getConditionExpression(rWhenPredicate);
					if (rConditionExpression instanceof RelationCallExp) {
						// body of RWhenRelCallToMGuard
						RelationCallExp rInvocation = (RelationCallExp)rConditionExpression;
						Relation rInvokedRelation = QVTrelationUtil.getReferredRelation(rInvocation);
						Type invokedTraceClass/*tc*/ = qvtr2qvtc.getTraceClass(rInvokedRelation);
						//
						List<@NonNull OCLExpression> rArguments = QVTrelationUtil.Internal.getOwnedArgumentsList(rInvocation);
						/*						StringBuilder s = new StringBuilder();
						for (OCLExpression rArgument : rArguments) {
							VariableExp a = (VariableExp) rArgument;
							s.append("_");
							s.append(a.getReferredVariable().getName());
						}
						String vdId = s.toString(); */
						String invokedName = "when_" + invokedTraceClass.getName()/* + vdId*/;
						Variable cCalledVariable/*vd*/ = variablesAnalysis.addCoreGuardVariable(invokedName, invokedTraceClass);	// FIXME
						List<@NonNull Variable> rParameters = qvtr2qvtc.getRootVariables(rInvokedRelation);
						int iSize = rArguments.size();
						assert iSize == rParameters.size();
						for (int i = 0; i < iSize; i++) {
							VariableExp rArgument/*ve*/ = (VariableExp) rArguments.get(i);
							Variable rParameter/*dv*/ = rParameters.get(i);
							//RWhenRelCallArgToMGuardPredicate
							Variable rArgumentVariable/*v*/ = QVTbaseUtil.getReferredVariable(rArgument);
							Variable cArgumentVariable/*mv*/ = variablesAnalysis.getCoreVariable(rArgumentVariable);
							Property cCalledProperty/*pep*/ = qvtr2qvtc.getProperty(cCalledVariable.getType(), rParameter);
							NavigationCallExp cCalledValue/*pe*/ = createNavigationCallExp(createVariableExp(cCalledVariable), cCalledProperty);
							variablesAnalysis.addConditionPredicate(cMiddleGuardPattern, cCalledValue, createVariableExp(cArgumentVariable));
						}
					}
					else {
						// body of RSimplePatternToMPattern
						OCLExpression cConditionExpression = mapExpression(rConditionExpression);
						variablesAnalysis.addPredicate(cMiddleGuardPattern, cConditionExpression);
						//						Predicate mpd = createPredicate(mapExpression(rConditionExpression));		// FIXME orphan
						//						addPredicate(composedMappingGuardPattern, cConditionExpression);
					}
				}
				//doUnsharedWhenVarsToMgVars(unsharedWhenVars, mg);
				//				mapVariables(rMiddleGuardDomainVariables, cMiddleGuardPattern);
			}
		}

		// RPredicateSetToMBPredicateSet
		protected void mapWhereBottomPredicates(@NonNull Iterable<@NonNull Predicate> rWherePredicates) throws CompilerChainException {
			for (@NonNull Predicate rWherePredicate : rWherePredicates) {
				OCLExpression rExpression = QVTrelationUtil.getConditionExpression(rWherePredicate);
				variablesAnalysis.addPredicate(cMiddleBottomPattern, mapExpression(rExpression));
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

		// RDomainToMDBottomForEnforcement (first half)
		protected void mapWhereGuardPredicates(@NonNull Set<@NonNull Predicate> rWhereGuardPredicates,  @NonNull Set<@NonNull Variable> rEnforcedBottomDomainVariables) throws CompilerChainException
		{
			Set<@NonNull Variable> nonRootEnforcedBottomDomainVariables = new HashSet<>(rEnforcedBottomDomainVariables);
			nonRootEnforcedBottomDomainVariables.removeAll(rEnforcedRootVariables);
			//
			Set<@NonNull Predicate> wherePredicatesWithVarBindings = selectPredicatesThatReferToVariables(rWhereGuardPredicates, nonRootEnforcedBottomDomainVariables);
			Set<@NonNull Predicate> remainingWherePredicatesWithoutVarBindings = new HashSet<>(rWhereGuardPredicates);
			remainingWherePredicatesWithoutVarBindings.removeAll(wherePredicatesWithVarBindings);
			// FIXME How does this do anything?
		}

		private void putTrace(@NonNull Element coreElement, @NonNull Element relationElement) {
			Element oldRelationElement = target2source.put(coreElement, relationElement);
			assert (oldRelationElement == relationElement) || (oldRelationElement == null);
			List<@NonNull Element> targets = source2targets.get(relationElement);
			if (targets == null) {
				targets = new ArrayList<>();
				source2targets.put(relationElement, targets);
			}
			targets.add(coreElement);
		}

		protected @NonNull Set<@NonNull Predicate> selectPredicatesThatReferToVariables(@NonNull Set<@NonNull Predicate> rPredicates, @NonNull Set<@NonNull Variable> rVariables) {
			Set<@NonNull Predicate> rPredicatesThatReferToVariables = new HashSet<>();
			for (@NonNull Predicate rPredicate : rPredicates) {
				//				OCLExpression conditionExpression = rPredicate.getConditionExpression();
				//				assert conditionExpression != null;
				Set<@NonNull Variable> rPredicateVariables = new HashSet<>();
				VariablesAnalysis.gatherReferredVariables(rPredicateVariables, rPredicate);
				rPredicateVariables.retainAll(rVariables);
				if (rPredicateVariables.isEmpty()) {		// FIXME smelly polarity
					rPredicatesThatReferToVariables.add(rPredicate);
				}
			}
			return rPredicatesThatReferToVariables;
		}

		/**
		 * Exploit the constructed/analyzed context to synthesize the Core constructs.
		 * @throws CompilerChainException
		 */
		protected void synthesize() throws CompilerChainException {
			Set<@NonNull Variable> rEnforcedBottomDomainVariables = getEnforcedBottomDomainVariables();
			//
			Set<@NonNull Predicate> rWhereBottomPredicates = selectPredicatesThatReferToVariables(rWherePredicates, rEnforcedBottomDomainVariables);
			Set<@NonNull Predicate> rWhereGuardPredicates = new HashSet<>(rWherePredicates);
			rWhereGuardPredicates.removeAll(rWhereBottomPredicates);
			//
			//			Set<@NonNull Variable> rEnforcedDomainGuardVariables = getEnforcedDomainGuardVariables(rEnforcedBottomDomainVariables);
			// Relation Calls
			mapWhereBottomPredicates(rWhereBottomPredicates);
			//			mapVariables(rEnforcedDomainGuardVariables, cEnforcedGuardPattern);
			//			mapVariables(rMiddleBottomDomainVariables, cMiddleBottomPattern);
			mapOtherDomainPatterns();
			// Invoked here so the variables are instantiated
			mapInvocation();			// Only for Invoked rather than Top relation
			mapOtherDomainVariables(rAllOtherReferredVariables);
			mapWhenPattern();
			mapWhereGuardPredicates(rWhereGuardPredicates, rEnforcedBottomDomainVariables);
			mapEnforcedDomainPatterns();
			if (rEnforcedMemberVariables != null) {	// FIXME mapOtherDomainVariables duploication/irregularity
				for (@NonNull Variable rMemberVariable : rEnforcedMemberVariables.keySet()) {
					variablesAnalysis.addTraceNavigationAssignment(rMemberVariable, true);
				}
			}
			mapRelationImplementation();
		}

		@Override
		public @NonNull String toString() {
			return rRelationName + "::" + rEnforcedDomainName + " => " + cMapping.getName() + "::" + cEnforcedDomain.getName();
		}
	}

	/**
	 * The overall QVTr2QVTc transformation
	 */
	protected @NonNull final QVTr2QVTc qvtr2qvtc;
	// Relations
	/**
	 * r: The relation being transformed
	 */
	protected final @NonNull Relation rRelation;
	/**
	 * The transformation containing the rRelation. i.e. rRelation.getOwningTransformation()
	 */
	protected final @NonNull RelationalTransformation rTransformation;
	/**
	 * The name of the rRelation. i.e. rRelation.getName()
	 */
	protected final @NonNull String rRelationName;
	/**
	 *  All variables that are defined or referenced in any way within the relation's containment tree.
	 *  Includes CollectionTemplateExp member/rest, Let/Iterator variables.
	 */
	protected final @NonNull Set<@NonNull Variable> rAllVariables;
	/**
	 * Mapping from each variable used as a when RelationCallExp argument to the typedModel of its corresponding argument.
	 */
	protected final @NonNull Map<@NonNull Variable, @Nullable TypedModel> rWhenVariable2rTypedModel;
	/**
	 * Mapping from each variable used as a where RelationCallExp argument to the typedModel of its corresponding argument.
	 */
	protected final @NonNull Map<@NonNull Variable, @Nullable TypedModel> rWhereVariable2rTypedModel;
	/**
	 * All when predicates that are not RelationCallExp
	 */
	protected final @NonNull Set<@NonNull Predicate> rWhenPredicates;
	/**
	 * All where predicates that are not RelationCallExp
	 */
	protected final @NonNull Set<@NonNull Predicate> rWherePredicates;
	/**
	 *  All variables defined/referenced by more than one domain. i.e. primitives
	 */
	protected final @NonNull Set<@NonNull Variable> rSharedVariables;
	// Core
	/**
	 * mt: The transformation containing the result mapping
	 */
	protected final @NonNull Transformation cTransformation;

	protected AbstractQVTr2QVTcRelations(@NonNull QVTr2QVTc qvtr2qvtc, @NonNull Relation rRelation) {
		super(qvtr2qvtc.getEnvironmentFactory());
		this.qvtr2qvtc = qvtr2qvtc;
		this.rRelation = rRelation;
		this.rTransformation = QVTrelationUtil.getTransformation(rRelation);
		this.rRelationName = PivotUtil.getName(rRelation);
		//
		this.rWhenVariable2rTypedModel = new HashMap<>();
		this.rWhenPredicates = new HashSet<>();
		Pattern rWhenPattern = rRelation.getWhen();
		if (rWhenPattern != null) {
			VariablesAnalysis.gatherReferredVariablesWithTypedModels(rWhenVariable2rTypedModel, rWhenPattern);
			// FIXME	assert rWhenPattern.getBindsTo().equals(rWhenVariables);
			//			rWhenPattern.getBindsTo().addAll(rWhenVariables);
			for (@NonNull Predicate rWhenPredicate : QVTrelationUtil.getOwnedPredicates(rWhenPattern)) {
				if (!(rWhenPredicate.getConditionExpression() instanceof RelationCallExp)) {		// FIXME Eliminate this redundant distinction
					rWhenPredicates.add(rWhenPredicate);
				}
			}
		}
		//
		this.rWhereVariable2rTypedModel = new HashMap<>();
		this.rWherePredicates = new HashSet<>();
		Pattern rWherePattern = rRelation.getWhere();
		if (rWherePattern != null) {
			VariablesAnalysis.gatherReferredVariablesWithTypedModels(rWhereVariable2rTypedModel, rWherePattern);
			// FIXME	assert rWherePattern.getBindsTo().equals(rWhereVariables);
			//			rWherePattern.getBindsTo().addAll(rWhereVariables);
			for (@NonNull Predicate rWherePredicate : QVTrelationUtil.getOwnedPredicates(rWherePattern)) {
				if (!(rWherePredicate.getConditionExpression() instanceof RelationCallExp)) {
					rWherePredicates.add(rWherePredicate);
				}
			}
		}
		//
		this.rAllVariables = new HashSet<>();
		VariablesAnalysis.gatherReferredVariables(rAllVariables, QVTrelationUtil.getOwnedDomains(rRelation));
		if (rWhenPattern != null) {
			VariablesAnalysis.gatherReferredVariables(rAllVariables, rWhenPattern);
		}
		if (rWherePattern != null) {
			VariablesAnalysis.gatherReferredVariables(rAllVariables, rWherePattern);
		}
		//
		this.rSharedVariables = VariablesAnalysis.getMiddleDomainVariables(rRelation);
		//
		this.cTransformation = qvtr2qvtc.getCoreTransformation(rTransformation);
	}

	/**
	 * Return an AbstractEnforceableRelationDomain2CoreMapping for each Core Mapping that is to be synthesized.
	 */
	protected abstract @NonNull List<@NonNull ? extends AbstractEnforceableRelationDomain2CoreMapping> analyze() throws CompilerChainException;

	protected @Nullable Iterable<@NonNull RelationCallExp> getWhenInvocations() {
		return null;
	}

	protected @Nullable Iterable<@NonNull RelationCallExp> getWhereInvocations() {
		return null;
	}

	@Override
	public @NonNull String toString() {
		return PivotUtil.getName(rTransformation) + "::" + rRelationName;
	}

	public void transform() throws CompilerChainException {
		List<@NonNull ? extends AbstractEnforceableRelationDomain2CoreMapping> enforceableRelationDomain2coreMappings = analyze();
		for (@NonNull AbstractEnforceableRelationDomain2CoreMapping enforceableRelationDomain2coreMapping : enforceableRelationDomain2coreMappings) {
			enforceableRelationDomain2coreMapping.synthesize();
			enforceableRelationDomain2coreMapping.variablesAnalysis.check();
		}
	}
}
