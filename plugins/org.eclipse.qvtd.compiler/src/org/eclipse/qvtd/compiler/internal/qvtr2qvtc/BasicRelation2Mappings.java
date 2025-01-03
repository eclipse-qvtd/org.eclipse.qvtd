/*******************************************************************************
 * Copyright (c) 2014, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation (inspired by Horacio Hoyos' prototype)
 ******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtr2qvtc;

import java.util.ArrayList;
import java.util.Collections;
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
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.analysis.RelationAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.analysis.VariableAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.trace.Relation2MiddleType;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.trace.Relation2TraceClass;
import org.eclipse.qvtd.compiler.internal.usage.DomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtcore.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcore.BottomVariable;
import org.eclipse.qvtd.pivot.qvtcore.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcore.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.NavigationAssignment;
import org.eclipse.qvtd.pivot.qvtcore.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcore.VariableAssignment;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreUtil;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Key;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.DomainUsage;
import org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;
import org.eclipse.qvtd.runtime.utilities.QVTruntimeUtil;

import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;

/**
 * BasicRelation2Mappings defines the mapping from a Relation, with a nested AbstractEnforceableRelationDomain2CoreMapping
 * for each distinct enforcement of that relation and a further nested AbstractOtherRelationDomain2CoreDomain for each
 * other domain of the distinct enforcement.
 */
/*public*/ abstract class BasicRelation2Mappings extends AbstractRelation2Mappings
{
	/**
	 * The AbstractEnforceableRelationDomain2CoreMapping supervises the conversion of the enforced
	 * domains while enforcing a relation for a particular enforced domain.
	 */
	protected abstract class AbstractEnforceableRelationDomain2CoreMapping implements EnforceableRelationDomain2CoreMapping
	{
		/**
		 * The AbstractOtherRelationDomain2CoreDomain supervises the conversion of one of the not-enforced
		 * domains while enforcing a relation for a particular enforced domain.
		 */
		protected abstract class AbstractOtherRelationDomain2CoreDomain implements OtherRelationDomain2CoreDomain
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
			protected final @NonNull Map<@NonNull VariableDeclaration, @NonNull TemplateExp> rOtherBoundVariables;
			/**
			 *  Mapping from each member variable in the not-enforced relation domain to each CollectionTemplateExp that
			 *  has a  VariableExp member that refers to it.
			 */
			protected final @Nullable Map<@NonNull VariableDeclaration, @NonNull List<@NonNull CollectionTemplateExp>> rOtherMemberVariables;
			/**
			 *  Mapping from each rest variable in the not-enforced relation domain to its CollectionTemplateExp.
			 */
			protected final @Nullable Map<@NonNull VariableDeclaration, @NonNull CollectionTemplateExp> rOtherRestVariables;
			/**
			 *  All variables defined or referenced in this other domain
			 */
			protected final @NonNull Set<@NonNull VariableDeclaration> rOtherReferredVariables;
			/**
			 *  The template expression variables (the root variables of this other domain pattern)
			 */
			protected final @NonNull List<@NonNull VariableDeclaration> rOtherRootVariables;
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
				this.rOtherBoundVariables = Variables2Variables.gatherBoundVariables(rOtherDomain);
				this.rOtherMemberVariables = Variables2Variables.gatherMemberVariables(rOtherDomain);
				this.rOtherRestVariables = Variables2Variables.gatherRestVariables(rOtherDomain);
				this.rOtherReferredVariables = new HashSet<>();
				Variables2Variables.gatherReferredVariables(rOtherReferredVariables, rOtherDomain);
				this.rOtherRootVariables = QVTrelationUtil.getRootVariables(rOtherDomain);
				//
				this.cOtherTypedModel = getCoreTypedModel(rOtherTypedModel);
				this.cOtherDomain = createCoreDomain(cOtherTypedModel, false);
				cOtherDomain.setIsCheckable(rOtherDomain.isIsCheckable());
				cOtherDomain.setIsEnforceable(false);
				this.cOtherGuardPattern = ClassUtil.nonNullState(cOtherDomain.getGuardPattern());
				this.cOtherBottomPattern = ClassUtil.nonNullState(cOtherDomain.getBottomPattern());
				//
				for (@NonNull VariableDeclaration rVariable : rOtherBoundVariables.keySet()) {
					variablesAnalysis.getVariableAnalysis(rVariable).setOtherBound(rOtherTypedModel);
				}
				for (@NonNull VariableDeclaration rVariable : rOtherReferredVariables) {
					variablesAnalysis.getVariableAnalysis(rVariable).setOtherReferred(rOtherTypedModel);
				}
				for (@NonNull VariableDeclaration rVariable : rOtherRootVariables) {
					variablesAnalysis.getVariableAnalysis(rVariable).setIsRoot();
				}
			}

			// new
			private void mapOtherCollectionTemplateExpression(@NonNull CollectionTemplateExp cte) throws CompilerChainException {
				VariableDeclaration vcte = QVTrelationUtil.getBindsTo(cte);
				VariableDeclaration mvcte = variablesAnalysis.getCoreVariable(vcte);
				/**
				 * Each CollectionTemplateExp member that is not a variable
				 * converts to a VariableAssignment of a new variable the member expression.
				 *
				 * ve1:T1{tp = ve2:Collection{a++b}}		=>   a := a;
				 */
				Map<@NonNull OCLExpression, @NonNull VariableDeclaration> rMember2mVariable = new HashMap<>();
				List<@NonNull OCLExpression> rMembers = QVTrelationUtil.Internal.getOwnedMembersList(cte);
				for (@NonNull OCLExpression rMember : rMembers) {
					VariableDeclaration mVariable;
					if (rMember instanceof TemplateExp) {
						TemplateExp rTemplateExp = (TemplateExp)rMember;
						mapOtherTemplateExpression(rTemplateExp);
						VariableDeclaration rVariable = QVTrelationUtil.getBindsTo(rTemplateExp);
						mVariable = variablesAnalysis.getCoreVariable(rVariable);
					}
					else if (rMember instanceof VariableExp) {
						VariableDeclaration rVariable = QVTrelationUtil.getReferredVariable((VariableExp)rMember);
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
				VariableDeclaration rRest = cte.getRest();
				if (rRest == null) {
					/**
					 * The predicate for a CollectionTemplateExp without a rest variable is a total comparison.
					 *
					 * ve1:T1{tp = ve2:Collection{a,b}}		=>   ve2 := ve1.tp; ve2 = Collection{a,b};
					 */
					List<@NonNull CollectionLiteralPart> mParts = new ArrayList<>();
					for (@NonNull OCLExpression rMember : rMembers) {
						VariableDeclaration mVariable = ClassUtil.nonNullState(rMember2mVariable.get(rMember));
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
					if (!((Variable)rRest).isIsImplicit()) {
						/**
						 * The assignment for an unordered CollectionTemplateExp rest variable is a cumulative exclusion.
						 *
						 * ve1:T1{tp = ve2:Collection{a,b++c}}		=>   c := ve2->excluding(a)->excluding(b);
						 */
						VariableDeclaration mRest = variablesAnalysis.getCoreVariable(rRest);
						OCLExpression exclusions = createVariableExp(mvcte);
						for (@NonNull OCLExpression rMember : rMembers) {
							VariableDeclaration mVariable = ClassUtil.nonNullState(rMember2mVariable.get(rMember));
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
							VariableDeclaration mVariable = ClassUtil.nonNullState(rMember2mVariable.get(rMember));
							eTerm = createOperationCallExp(eTerm, "excluding", createVariableExp(mVariable));
						}
						OCLExpression rMember = rMembers.get(i);
						VariableDeclaration mVariable = ClassUtil.nonNullState(rMember2mVariable.get(rMember));
						eTerm = createOperationCallExp(eTerm, "includes", createVariableExp(mVariable));
						variablesAnalysis.addPredicate(cMiddleBottomPattern, eTerm);
					}
				}
			}

			// loop body of RDomainPatternToMDBottomPatternComposite
			private void mapOtherObjectTemplateExpression(@NonNull ObjectTemplateExp rTemplateExpression) throws CompilerChainException {
				VariableDeclaration rTemplateVariable = QVTrelationUtil.getBindsTo(rTemplateExpression);
				for (@NonNull PropertyTemplateItem propertyTemplateItem : QVTrelationUtil.getOwnedParts(rTemplateExpression)) {
					Property partProperty = QVTrelationUtil.getReferredProperty(propertyTemplateItem);
					VariableDeclaration cTemplateVariable = variablesAnalysis.getCoreVariable(rTemplateVariable);
					OCLExpression propertyTemplateValue = QVTrelationUtil.getOwnedValue(propertyTemplateItem);
					if (propertyTemplateValue instanceof VariableExp) {
						// body of RDomainPatternToMDBottomPatternSimpleSharedVarExpr and RDomainPatternToMDBottomPatternSimpleUnSharedVarExpr
						/**
						 * Each PropertyTemplateItem whose value is a simple VariableExp
						 * converts to a domain(unshared) / middle(shared) PropertyAssignment.
						 *
						 * ve1:T{tp = ve2}   =>   ve1.tp := ve2;
						 */
						VariableDeclaration rVariable/*vpte*/ = QVTrelationUtil.getReferredVariable((VariableExp)propertyTemplateValue);
						VariableDeclaration cVariable/*mvpte*/ = variablesAnalysis.getCoreVariable(rVariable);
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
						VariableDeclaration vcte = QVTrelationUtil.getBindsTo(cte);
						VariableDeclaration mvcte = variablesAnalysis.getCoreVariable(vcte);
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
							VariableDeclaration vpte = QVTrelationUtil.getBindsTo(pte);
							VariableDeclaration mvpte = variablesAnalysis.getCoreVariable(vpte);
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
							VariableDeclaration vpte = QVTrelationUtil.getBindsTo(pte);
							VariableDeclaration mvpte = variablesAnalysis.getCoreVariable(vpte);
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

			private void mapOverride(@NonNull Relation overridingRelation) throws CompilerChainException {
				Relation2TraceClass relation2TraceClass = relationalTransformation2tracePackage.getRelation2TraceClass(rRelation);
				Relation2TraceClass overridingRelation2TraceClass = relationalTransformation2tracePackage.getRelation2TraceClass(overridingRelation);
				Property statusProperty = relation2TraceClass.getStatusTraceProperty();
				List<@NonNull VariableDeclaration> overridingRootVariables = QVTrelationUtil.getRootVariables(QVTrelationUtil.getRelationDomain(overridingRelation, rOtherTypedModel));
				VariableDeclaration firstRootVariable = rOtherRootVariables.get(0);
				VariableDeclaration firstOverridingRootVariable = overridingRootVariables.get(0);
				org.eclipse.ocl.pivot.Class firstRootType = QVTrelationUtil.getClass(firstRootVariable);
				org.eclipse.ocl.pivot.Class firstOverridingRootType = QVTrelationUtil.getClass(firstOverridingRootVariable);
				VariableDeclaration cFirstRootVariable = variablesAnalysis.getCoreVariable(firstRootVariable);
				if (firstOverridingRootType.conformsTo(standardLibrary, firstRootType)) {									// If override can override at all
					OCLExpression predicateBody = null;
					Property traceProperty = relation2TraceClass.getTraceProperty(firstRootVariable);
					Property inverseTraceProperty = QVTrelationUtil.getOpposite(traceProperty);
					int iSize = rOtherRootVariables.size();
					if (inverseTraceProperty.isIsMany()) {
						OCLExpression overridingTraceExp = createNavigationCallExp(createVariableExp(cFirstRootVariable), inverseTraceProperty);
						OCLExpression overridingTraceExp2 = createOperationCallExp(overridingTraceExp, "selectByKind", createTypeExp(overridingRelation2TraceClass.getTraceClass()));
						if (iSize > 1) {
							//FIXME is this valid??
							//
							//	????root1.toTrace->selectByKind(roit1Trace)->select(root2 = ... and roo3 - ...)->forAll(oclIsKindOf(overrdingRoot1Type)
							//
							OCLExpression selectBody = null;
							@NonNull IteratorVariable iteratorVariable1 = createIteratorVariable("it1", relation2TraceClass.getTraceInterface(), true);
							iteratorVariable1.setIsImplicit(true);
							for (int i = 1; i < iSize; i++) {
								VariableDeclaration nextRootVariable = rOtherRootVariables.get(i);
								//							Variable nextOverridingRootVariable = overridingRootVariables.get(i);
								//							org.eclipse.ocl.pivot.Class nextRootType = QVTrelationUtil.getClass(nextRootVariable);
								//							org.eclipse.ocl.pivot.Class nextOverridingRootType = QVTrelationUtil.getClass(firstOverridingRootVariable);
								VariableDeclaration cNextRootVariable = variablesAnalysis.getCoreVariable(nextRootVariable);
								Property nextTraceProperty = relation2TraceClass.getTraceProperty(nextRootVariable);
								OCLExpression derivedTerm = createNavigationCallExp(createVariableExp(iteratorVariable1), nextTraceProperty);
								OCLExpression selectTerm = createOperationCallExp(derivedTerm, "=", createVariableExp(cNextRootVariable));
								if (selectBody != null) {
									selectBody = createOperationCallExp(selectBody, "and", selectTerm);
								}
								else {
									selectBody = selectTerm;
								}
							}
							assert selectBody != null;
							overridingTraceExp2 = createIteratorExp(overridingTraceExp2, "select", Collections.singletonList(iteratorVariable1), selectBody);
						}
						@NonNull IteratorVariable iteratorVariable2 = createIteratorVariable("it2", overridingRelation2TraceClass.getTraceClass(), true);
						iteratorVariable2.setIsImplicit(true);
						OCLExpression overridingStatusExpression = createNavigationCallExp(createVariableExp(iteratorVariable2), statusProperty);
						OCLExpression forAllBody = createOperationCallExp(overridingStatusExpression, "=", createBooleanLiteralExp(false));
						predicateBody = createIteratorExp(overridingTraceExp2, "forAll", Collections.singletonList(iteratorVariable2), forAllBody);
						if (!firstRootType.conformsTo(standardLibrary, firstOverridingRootType)) {							// If override has a derived type match
							OCLExpression overrideIsConformantExp = createOperationCallExp(createVariableExp(cFirstRootVariable), "oclIsKindOf", createTypeExp(firstOverridingRootType));
							predicateBody = createOperationCallExp(createOperationCallExp(overrideIsConformantExp, "not"), "or", predicateBody);
						}
					}
					else {
						//
						//	not root1.oclIsKindOf(overrdingRoot1Type) and not root2.oclIsKindOf(overrdingRoot2Type) and not ...
						//
						for (int i = 0; i < iSize; i++) {
							VariableDeclaration rootVariable = rOtherRootVariables.get(i);
							VariableDeclaration overridingRootVariable = overridingRootVariables.get(i);
							org.eclipse.ocl.pivot.Class overridingRootType = QVTrelationUtil.getClass(overridingRootVariable);
							VariableDeclaration cRootVariable = variablesAnalysis.getCoreVariable(rootVariable);
							OCLExpression overrideIsConformantExp = createOperationCallExp(createVariableExp(cRootVariable), "oclIsKindOf", createTypeExp(overridingRootType));
							OCLExpression predicateTerm = createOperationCallExp(overrideIsConformantExp, "not");
							if (predicateBody != null) {
								predicateBody = createOperationCallExp(predicateBody, "and", predicateTerm);
							}
							else {
								predicateBody = predicateTerm;
							}
						}
					}
					assert predicateBody != null;
					variablesAnalysis.addPredicate(cMiddleBottomPattern, predicateBody);
				}
			}

			protected void mapOverrides() throws CompilerChainException {
				Set<@NonNull Relation> allOverrides = gatherOverrides(new HashSet<@NonNull Relation>(), rRelation);
				allOverrides.remove(rRelation);
				if (!allOverrides.isEmpty()) {
					for (@NonNull Relation anOverride : allOverrides) {
						if (!anOverride.isIsAbstract()) {
							mapOverride(anOverride);
						}
					}
				}
			}


			private @NonNull Set<@NonNull Relation> gatherOverrides(@NonNull Set<@NonNull Relation> allOverrides, @NonNull Relation aRelation) {
				if (allOverrides.add(aRelation)) {
					for (@NonNull Relation anOverride : QVTrelationUtil.getOverrides(aRelation)) {
						gatherOverrides(allOverrides, anOverride);
					}
				}
				return allOverrides;
			}

			@Override
			public void synthesize() throws CompilerChainException {
				mapOverrides();
				List<@NonNull TemplateExp> rOtherTemplateExpressions = getRootTemplateExpressions(rOtherDomain);
				for (@NonNull TemplateExp rOtherTemplateExpression : rOtherTemplateExpressions) {
					mapOtherTemplateExpression(rOtherTemplateExpression);
				}
			}

			@Override
			public String toString() {
				return rRelationName + "::" + rOtherDomainName + "=>" + rEnforcedDomainName;
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
					return super.get(oIn);		// e.g. Features/Collections which are re-useable externals
				}
				else {
					return super.get(oIn);
				}
			}

			@Override
			public EObject copy(EObject oIn) {
				try {
					if (oIn instanceof IteratorVariable) {
						VariableDeclaration coreVariable = variablesAnalysis.getCoreVariable((IteratorVariable)oIn);
						putTrace(coreVariable, (IteratorVariable)oIn);
						return coreVariable;
					}
					else if (oIn instanceof LetVariable) {
						VariableDeclaration coreVariable = variablesAnalysis.getCoreVariable((LetVariable)oIn);
						putTrace(coreVariable, (LetVariable)oIn);
						return coreVariable;
					}
				} catch (IllegalStateException e) {
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
		protected final @NonNull Map<@NonNull VariableDeclaration, @NonNull TemplateExp> rEnforcedBoundVariables;
		/**
		 *  Mapping from each member variable in the enforced relation domain to each CollectionTemplateExp that
		 *  has a  VariableExp member that refers to it.
		 */
		protected final @Nullable Map<@NonNull VariableDeclaration, @NonNull List<@NonNull CollectionTemplateExp>> rEnforcedMemberVariables;
		/**
		 *  Mapping from each rest variable in the enforced relation domain to its CollectionTemplateExp.
		 */
		protected final @Nullable Map<@NonNull VariableDeclaration, @NonNull CollectionTemplateExp> rEnforcedRestVariables;
		/**
		 *  All variables defined or referenced in the enforced relation domain
		 */
		protected final @NonNull Set<@NonNull VariableDeclaration> rEnforcedReferredVariables;
		/**
		 *  te: The template expressions defining the roots of the enforced domain pattern
		 */
		protected final @NonNull List<@NonNull/*Object*/TemplateExp> rEnforcedRootTemplateExpressions;
		/**
		 *  tev: The template expression root variables (the root variables of the enforced domain pattern)
		 */
		protected final @NonNull List<@NonNull VariableDeclaration> rEnforcedRootVariables;
		/**
		 * The conversion for each other domains sharing the parent of this domain
		 */
		protected final @NonNull List<@NonNull OtherRelationDomain2CoreDomain> otherDomain2coreDomains;
		/**
		 *  All variables defined in other domains
		 */
		protected final @NonNull Set<@NonNull VariableDeclaration> rAllOtherBoundVariables;
		/**
		 *  All variables defined or referenced in other domains
		 */
		protected final @NonNull Set<@NonNull VariableDeclaration> rAllOtherReferredVariables;
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
		 *  The analysis of each variable in the relation.
		 */
		protected final @NonNull Variables2Variables variablesAnalysis;
		/**
		 * tcv: The trace class variable (the middle variable identifying the middle object)
		 */
		protected final @NonNull VariableDeclaration cMiddleVariable;
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
			this.rEnforcedBoundVariables = Variables2Variables.gatherBoundVariables(rEnforcedDomain);
			this.rEnforcedMemberVariables = Variables2Variables.gatherMemberVariables(rEnforcedDomain);
			this.rEnforcedRestVariables = Variables2Variables.gatherRestVariables(rEnforcedDomain);
			this.rEnforcedReferredVariables = new HashSet<>();
			Variables2Variables.gatherReferredVariables(rEnforcedReferredVariables, rEnforcedDomain);
			this.rEnforcedRootTemplateExpressions = getRootTemplateExpressions(rEnforcedDomain);
			this.rEnforcedRootVariables = QVTrelationUtil.getRootVariables(rEnforcedDomain);
			this.rEnforcedTypedModel = QVTrelationUtil.getTypedModel(rEnforcedDomain);
			this.rEnforcedDomainName = ClassUtil.nonNullState(rEnforcedDomain.getName());
			@NonNull Type traceClass = relationalTransformation2tracePackage.getTraceClass(rRelation);
			//
			this.cEnforcedTypedModel = getCoreTypedModel(rEnforcedTypedModel);
			this.cMapping = createCoreMapping(cMappingName);
			this.cMiddleGuardPattern = ClassUtil.nonNullState(cMapping.getGuardPattern());
			this.cMiddleBottomPattern = ClassUtil.nonNullState(cMapping.getBottomPattern());
			this.cEnforcedDomain = createCoreDomain(cEnforcedTypedModel, true);
			this.cEnforcedGuardPattern = ClassUtil.nonNullState(cEnforcedDomain.getGuardPattern());
			this.cEnforcedBottomPattern = ClassUtil.nonNullState(cEnforcedDomain.getBottomPattern());
			//
			this.variablesAnalysis = createVariablesAnalysis(rEnforcedDomain, traceClass);
			this.cMiddleVariable = variablesAnalysis.getMiddleVariable();
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
			Set<@NonNull VariableDeclaration> rUnsharedEnforcedDomainVariables = new HashSet<>(rEnforcedReferredVariables);
			rUnsharedEnforcedDomainVariables.removeAll(rSharedVariables);
			this.rAllOtherReferredVariables = new HashSet<>(rAllVariables);
			rAllOtherReferredVariables.removeAll(rUnsharedEnforcedDomainVariables);
			//
			for (Map.Entry<@NonNull VariableDeclaration, @Nullable TypedModel> entry : rWhenVariable2rTypedModel.entrySet()) {
				TypedModel rWhenTypedModel = entry.getValue();
				if (rWhenTypedModel != null) {
					variablesAnalysis.getVariableAnalysis(entry.getKey()).setWhen(rWhenTypedModel);
				}
			}
			for (Map.Entry<@NonNull VariableDeclaration, @Nullable TypedModel> entry : rWhereVariable2rTypedModel.entrySet()) {
				TypedModel rWhereTypedModel = entry.getValue();
				if (rWhereTypedModel != null) {
					variablesAnalysis.getVariableAnalysis(entry.getKey()).setWhere(rWhereTypedModel);
				}
			}
			for (@NonNull VariableDeclaration rVariable : rEnforcedBoundVariables.keySet()) {

				Key rKey = transformationAnalysis.getKeyForType(QVTrelationUtil.getType(rVariable));

				variablesAnalysis.getVariableAnalysis(rVariable).setIsEnforcedBound(rEnforcedBoundVariables.get(rVariable), rEnforcedTypedModel, rKey);
			}
			for (@NonNull VariableDeclaration rVariable : rEnforcedReferredVariables) {
				variablesAnalysis.getVariableAnalysis(rVariable).setIsEnforcedReferred();
			}
			for (@NonNull VariableDeclaration rVariable : rEnforcedRootVariables) {
				variablesAnalysis.getVariableAnalysis(rVariable).setIsRoot();
			}
			//
			for (@NonNull VariableDeclaration rVariable : rAllVariables) {
				if (rVariable instanceof Variable) {
					OCLExpression ownedInit = ((Variable)rVariable).getOwnedInit();
					if (ownedInit != null) {
						DomainUsageAnalysis domainUsageAnalysis = transformationAnalysis.getDomainUsageAnalysis();
						DomainUsage usage = domainUsageAnalysis.getUsage(rVariable);
						TypedModel rTypedModel = usage.getTypedModel(rVariable);
						if (rTypedModel != null) {
							VariableAnalysis variableAnalysis = variablesAnalysis.getVariableAnalysis(rVariable);
							variableAnalysis.setPredicate(rTypedModel);
						}
					}
				}
			}
			//
			QVTr2QVTc.VARIABLES.println(" In " + cMapping + "\n\t\t" + variablesAnalysis.toString().replace("\n", "\n\t\t"));
			for (@NonNull Variable2Variable analysis : variablesAnalysis.getAnalyses()) {
				VariableDeclaration rVariable = analysis.getRelationVariable();
				if ((rVariable != null) && !(rRelation.isIsAbstract() && analysis.isRealized())) {
					VariableDeclaration cVariable = analysis.getCoreVariable();
					putTrace(cVariable, rVariable);		// FIXME redundant / later
				}
			}
			Set<@NonNull Variable2Variable> toDo = Sets.newHashSet(variablesAnalysis.getAnalyses());
			Set<@NonNull Variable2Variable> done = new HashSet<>();
			while (toDo.size() > 0) {		// FIXME avoid need for CME proofing by scanning all variables first
				for (@NonNull Variable2Variable analysis : toDo) {
					VariableDeclaration rVariable = analysis.getRelationVariable();
					if (rVariable instanceof Variable) {
						OCLExpression rOwnedInit = ((Variable)rVariable).getOwnedInit();
						if (rOwnedInit != null) {
							VariableDeclaration cVariable = analysis.getCoreVariable();
							assert cVariable instanceof BottomVariable;
							((BottomVariable)cVariable).setOwnedInit(mapExpression(rOwnedInit));
						}
					}
				}
				done.addAll(toDo);
				toDo = Sets.newHashSet(variablesAnalysis.getAnalyses());
				toDo.removeAll(done);
			}
		}

		// Quad call of RDomainPatternExprToMappingXXXX
		private void addPropertyAssignmentToMiddleBottomPattern(@NonNull VariableDeclaration rTargetVariable, @NonNull Property targetProperty, @NonNull OCLExpression rExpression) throws CompilerChainException {
			VariableDeclaration cTargetVariable = null;
			OCLExpression cExpression = null;
			if (rExpression instanceof ObjectTemplateExp) {
				// body of RDomainPatternExprToMappingDomainTemplateVarAssignment
				VariableDeclaration rBoundVariable = ClassUtil.nonNullState(((ObjectTemplateExp)rExpression).getBindsTo());
				if (!rSharedVariables.contains(rBoundVariable)) {
					VariableDeclaration cBoundVariable = variablesAnalysis.getCoreVariable(rBoundVariable);  // FIXME whenVariable(cMiddleBottomPattern, rBoundVariable);
					cExpression = createVariableExp(cBoundVariable);
					cTargetVariable = variablesAnalysis.addTraceNavigationAssignment(rBoundVariable, false);
				}
			}
			else if (rExpression instanceof VariableExp) {
				cTargetVariable = variablesAnalysis.getCoreVariable(rTargetVariable);		// getCoreVariable should do and be uniform
				VariableDeclaration rReferredVariable = ClassUtil.nonNullState(((VariableExp)rExpression).getReferredVariable());
				VariableDeclaration cReferredVariable = variablesAnalysis.getCoreVariable(rReferredVariable);
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

		protected abstract @NonNull OtherRelationDomain2CoreDomain createOtherDomain2CoreDomain(@NonNull RelationDomain rRelationDomain);

		protected abstract @NonNull Variables2Variables createVariablesAnalysis(@NonNull RelationDomain rEnforcedDomain, @NonNull Type traceClass) throws CompilerChainException;

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

		@Override
		public @NonNull Mapping getCoreMapping() {
			return cMapping;
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

		protected abstract @NonNull Set<@NonNull VariableDeclaration> getEnforcedBottomDomainVariables();

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

		/**
		 * Return true if the referencedVariable, which is referenced by one of referencingTemplateExpression's parts
		 * is bound to the variable of some ObjectTemplateExp other than referencingTemplateExpression's within the hierrachy
		 * of searchTemplateExpression.
		 */
		private boolean isReferencedVarBoundWithTemplateExpressionHierarchy(@NonNull VariableDeclaration referencedVariable, @NonNull ObjectTemplateExp referencingTemplateExpression, @NonNull TemplateExp searchTemplateExpression) {
			if (searchTemplateExpression == referencingTemplateExpression) {
				return false;
			}
			VariableDeclaration boundVariable = searchTemplateExpression.getBindsTo();
			if (boundVariable.equals(referencedVariable)) {
				return true;
			}
			if (searchTemplateExpression instanceof ObjectTemplateExp) {
				for (@NonNull PropertyTemplateItem p : QVTrelationUtil.getOwnedParts((ObjectTemplateExp)searchTemplateExpression)) {
					OCLExpression value = p.getValue();
					if (value instanceof TemplateExp) {
						if (isReferencedVarBoundWithTemplateExpressionHierarchy(referencedVariable, referencingTemplateExpression, (TemplateExp) value)) {
							return true;
						}
					}
				}
			}
			else if (searchTemplateExpression instanceof CollectionTemplateExp) {
				for (@NonNull OCLExpression p : QVTrelationUtil.getOwnedMembers((CollectionTemplateExp)searchTemplateExpression)) {
					if (p instanceof TemplateExp) {
						if (isReferencedVarBoundWithTemplateExpressionHierarchy(referencedVariable, referencingTemplateExpression, (TemplateExp) p)) {
							return true;
						}
					}
				}
			}
			return false;
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
			VariableDeclaration vcte = QVTrelationUtil.getBindsTo(cte);
			VariableDeclaration mvcte = variablesAnalysis.getCoreVariable(vcte);
			/*			NavigationCallExp pce =  createNavigationCallExp(createVariableExp(cTemplateVariable), partProperty);
			VariableAssignment a = createVariableAssignment(mvcte, pce);
			cMiddleBottomPattern.getAssignment().add(a);
			/**
			 * Each CollectionTemplateExp member that is not a variable
			 * converts to a VariableAssignment of a new variable the member expression.
			 *
			 * ve1:T1{tp = ve2:Collection{a++b}}		=>   a := a;
			 */
			Map<@NonNull OCLExpression, @NonNull VariableDeclaration> rMember2mVariable = new HashMap<>();
			List<@NonNull OCLExpression> rMembers = QVTrelationUtil.Internal.getOwnedMembersList(cte);
			for (@NonNull OCLExpression rMember : rMembers) {
				VariableDeclaration mVariable;
				if (rMember instanceof TemplateExp) {
					TemplateExp rTemplateExp = (TemplateExp)rMember;
					mapEnforcedTemplateExpression(rTemplateExp);
					VariableDeclaration rVariable = QVTrelationUtil.getBindsTo(rTemplateExp);
					mVariable = variablesAnalysis.getCoreVariable(rVariable);
				}
				else if (rMember instanceof VariableExp) {
					VariableDeclaration rVariable = QVTrelationUtil.getReferredVariable((VariableExp)rMember);
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
			VariableDeclaration rRest = cte.getRest();
			if (rRest == null) {
				/**
				 * The predicate for a CollectionTemplateExp without a rest variable is a total comparison.
				 *
				 * ve1:T1{tp = ve2:Collection{a,b}}		=>   ve2 := ve1.tp; ve2 = Collection{a,b};
				 */
				List<@NonNull CollectionLiteralPart> mParts = new ArrayList<>();
				for (@NonNull OCLExpression rMember : rMembers) {
					VariableDeclaration mVariable = ClassUtil.nonNullState(rMember2mVariable.get(rMember));
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
			else if (((Variable)rRest).isIsImplicit()) {
				PropertyTemplateItem rPropertyTemplateItem = (PropertyTemplateItem) cte.eContainer();
				assert rPropertyTemplateItem != null;
				ObjectTemplateExp rObjectTemplateExp = QVTrelationUtil.getOwningObjectTemplateExp(rPropertyTemplateItem);
				VariableDeclaration vote = QVTrelationUtil.getBindsTo(rObjectTemplateExp);
				VariableDeclaration cvote = variablesAnalysis.getCoreVariable(vote);
				/**
				 * The assignment for a CollectionTemplateExp variable is a literal for the members and an addition of the rest.
				 *
				 * ve1:T1{tp = ve2:Collection{a,b++_}}		=>   ve1.tp += a; ve1.tp += b;
				 */
				for (@NonNull OCLExpression rMember : rMembers) {
					VariableDeclaration mVariable = ClassUtil.nonNullState(rMember2mVariable.get(rMember));
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
					VariableDeclaration mVariable = ClassUtil.nonNullState(rMember2mVariable.get(rMember));
					ownedParts.add(createCollectionItem(createVariableExp(mVariable)));
				}
				OCLExpression cExpression = createCollectionLiteralExp(collectionType, ownedParts);
				VariableDeclaration mRest = variablesAnalysis.getCoreVariable(rRest);
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
			VariableDeclaration rTemplateVariable/*v*/ = QVTrelationUtil.getBindsTo(rEnforcedObjectTemplateExpression);
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
					/*Realized*/VariableDeclaration cTemplateVariable = variablesAnalysis.getCoreVariable(rTemplateVariable);
					VariableDeclaration vcte = QVTrelationUtil.getBindsTo(cte);
					VariableDeclaration mvcte = variablesAnalysis.getCoreVariable(vcte);
					NavigationCallExp pce =  createNavigationCallExp(createVariableExp(cTemplateVariable), partProperty);
					VariableAssignment a = createVariableAssignment(mvcte, pce);
					cMiddleBottomPattern.getAssignment().add(a);
					mapEnforcedTemplateExpression(cte);
				}
				else if (rPartValue instanceof ObjectTemplateExp) {
					// body of RDomainToMDBottomForEnforcementOfNonIdentityPropObject
					ObjectTemplateExp ote = (ObjectTemplateExp)rPartValue;
					VariableDeclaration pv = ClassUtil.nonNullState(ote.getBindsTo());
					/*Realized*/VariableDeclaration cTargetVariable/*mpv*/ = variablesAnalysis.getCoreVariable(pv); //rWhenVariables.contains(pv) ? getCoreVariable(pv) : whenRealizedVariable(cEnforcedBottomPattern, pv);
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
					VariableDeclaration rPartVariable = QVTrelationUtil.getReferredVariable((VariableExp)rPartValue);
					boolean isLocallyResolved = false;		// FIXME this seems a heavyweight potential duplication
					for (@NonNull TemplateExp rTemplateExpression : rEnforcedRootTemplateExpressions) {
						//						if (rTemplateExpression instanceof TemplateExp) {
						// check
						if (isReferencedVarBoundWithTemplateExpressionHierarchy(rPartVariable, rEnforcedObjectTemplateExpression, rTemplateExpression)) {
							isLocallyResolved = true;
							//								Variable cReferredVariable = variablesAnalysis.getCoreVariable(rPartVariable);
							//								Property cTargetProperty = relationalTransformation2tracePackage.getTraceProperty(QVTrelationUtil.getType(cReferredVariable), cReferredVariable);
							//								NavigationCallExp cPropertyCallExp = createNavigationCallExp(createVariableExp(cMiddleVariable), cTargetProperty);
							//								variablesAnalysis.addConditionPredicate(cMiddleGuardPattern, cPropertyCallExp, createVariableExp(cReferredVariable));
							//								cEnforcedGuardPattern.getBindsTo().add(cReferredVariable);
							//								throw new UnsupportedOperationException();
						}
						//						}
					}
					variablesAnalysis.addNavigationAssignment(rTemplateVariable, partProperty, mapExpression(rPartValue), null);
					if (!rAllOtherReferredVariables.contains(rPartVariable) && !isLocallyResolved) {						// Avoid duplicate assignment
						variablesAnalysis.addTraceNavigationAssignment(rPartVariable, false);
					}
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
			VariableDeclaration rTemplateVariable/*v*/ = QVTrelationUtil.getBindsTo(rEnforcedTemplateExpression);
			Type rTemplateVariableType/*c*/ = QVTrelationUtil.getType(rTemplateVariable);
			Key key = transformationAnalysis.getKeyForType(rTemplateVariableType);
			Variable2Variable variableAnalysis = variablesAnalysis.getVariableAnalysis(rTemplateVariable);
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
			boolean isTopLevel = rRelation.isIsTopLevel();
			boolean isAssignment = relationAnalysis.traceIsRealized() || !rEnforcedRootVariables.contains(rTemplateVariable);
			if (!isAssignment && !isTopLevel) {
				Iterable<@NonNull RelationCallExp> incomingWhenInvocations = relationAnalysis.getIncomingWhenInvocations();
				isAssignment = (incomingWhenInvocations != null) && !Iterables.isEmpty(incomingWhenInvocations);
			}
			if (isAssignment) {
				variablesAnalysis.addTraceNavigationAssignment(rTemplateVariable, !isTopLevel);
			}
			else {
				variablesAnalysis.addTraceNavigationPredicate(rTemplateVariable);
			}
			OCLExpression rGuardPredicate = rEnforcedTemplateExpression.getWhere();
			if (rGuardPredicate != null) {
				cMiddleBottomPattern.getPredicate().add(createPredicate(mapExpression(rGuardPredicate)));
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
			@SuppressWarnings("serial")
			EcoreUtil.Copier copier = new ExpressionCopier()
			{
				@Override
				public EObject copy(EObject oIn) {
					if (oIn instanceof RelationCallExp) {
						//						throw new UnsupportedOperationException("Missing RelationCallExp support");
						try {
							RelationCallExp rInvocation = (RelationCallExp) oIn;
							VariableDeclaration cCalledVariable = mapRelationCallExp(rInvocation);
							Relation2TraceClass relation2TraceClass = relationalTransformation2tracePackage.getRelation2TraceClass(QVTrelationUtil.getReferredRelation(rInvocation));
							Property statusProperty = relation2TraceClass.getStatusTraceProperty();
							return createNavigationCallExp(createVariableExp(cCalledVariable), statusProperty);
						} catch (CompilerChainException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							return createStringLiteralExp(String.valueOf(oIn));
						}

					}
					return super.copy(oIn);
				}
			};
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

		//		protected void mapIncomingInvocation() throws CompilerChainException {}

		// IROppositeDomainsToMappingForEnforcement
		protected void mapOtherDomainPatterns() throws CompilerChainException {
			for (@NonNull OtherRelationDomain2CoreDomain otherDomain2coreDomain : otherDomain2coreDomains) {
				otherDomain2coreDomain.synthesize();
			}
		}

		// ROppositeDomainVarsToTraceClassProps
		protected void mapOtherDomainVariables(@NonNull Set<@NonNull VariableDeclaration> rDomainVariables) throws CompilerChainException {
			for (@NonNull VariableDeclaration rDomainVariable : rDomainVariables) {
				//				VariableAnalysis analysis = getVariableAnalysis(rDomainVariable);
				//				TemplateExp rTemplateExp = analysis.getTemplateExp();
				//				if (dvte instanceof ObjectTemplateExp) {
				// tp=dv:T{...} => tcv.tp := dv;
				if (rDomainVariable.eContainer() instanceof RelationalTransformation) {
					// no need to trace "this"
				}
				else if (relationAnalysis.traceIsRealized()) {
					//					OCLExpression rInit = rDomainVariable.getOwnedInit();
					//					if (rInit != null) {
					//						Variable2Variable variableAnalysis = variablesAnalysis.getVariableAnalysis(rDomainVariable);
					//						Variable cVariable = variableAnalysis.getCoreVariable();
					//						CorePattern corePattern = variableAnalysis.getCorePattern();
					//						assert corePattern != null;
					//						variablesAnalysis.addConditionPredicate(corePattern, createVariableExp(cVariable), mapExpression(rInit));
					//					}
					variablesAnalysis.addTraceNavigationAssignment(rDomainVariable, true);
				}
				else if (!QVTrelationUtil.getRootVariables(rRelation).contains(rDomainVariable)) {
					variablesAnalysis.addTraceNavigationAssignment(rDomainVariable, true);
				}
				else {
					variablesAnalysis.addTraceNavigationPredicate(rDomainVariable);
				}
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

		protected @NonNull VariableDeclaration mapRelationCallExp(@NonNull RelationCallExp rInvocation) throws CompilerChainException {
			Relation rInvokedRelation = QVTrelationUtil.getReferredRelation(rInvocation);
			RelationAnalysis rInvokedRelationAnalysis = transformationAnalysis.getRelationAnalysis(rInvokedRelation);
			List<@NonNull OCLExpression> rArguments = QVTrelationUtil.Internal.getOwnedArgumentsList(rInvocation);
			List<@NonNull VariableDeclaration> rParameters = rInvokedRelationAnalysis.getRootVariables();
			int iSize = rArguments.size();
			assert iSize == rParameters.size();
			//						if (rInvokedRelation.isIsTopLevel()) {
			Type invokedTraceClass/*tc*/ = relationalTransformation2tracePackage.getRelation2TraceClass(rInvokedRelation).getTraceInterface();
			//
			String invokedName = "when_" + invokedTraceClass.getName()/* + vdId*/;
			VariableDeclaration cCalledVariable/*vd*/ = variablesAnalysis.addCoreGuardVariable(invokedName, invokedTraceClass);	// FIXME
			for (int i = 0; i < iSize; i++) {
				OCLExpression rArgument/*ve*/ = rArguments.get(i);
				OCLExpression cReferenceValue;
				if (rArgument instanceof VariableExp) {
					//RWhenRelCallArgToMGuardPredicate
					VariableDeclaration rArgumentVariable/*v*/ = QVTbaseUtil.getReferredVariable((VariableExp)rArgument);
					VariableDeclaration cArgumentVariable/*mv*/ = variablesAnalysis.getCoreVariable(rArgumentVariable);
					cReferenceValue = createVariableExp(cArgumentVariable);
				}
				else {
					OCLExpression cArgument = mapExpression(rArgument);	// FIXME tis fails, but possibly only in m2s
					//					Variable cArgumentVariable/*mv*/ = variablesAnalysis.addCoreGuardVariable("FIXME",  cArgument.getType());
					//					variablesAnalysis.addConditionPredicate(cMiddleBottomPattern, createVariableExp(cArgumentVariable),  cArgument); //createVariableExp(cArgumentVariable));
					cReferenceValue = cArgument; //createVariableExp(cArgumentVariable);
				}
				VariableDeclaration rParameter/*dv*/ = rParameters.get(i);
				Property cCalledProperty/*pep*/ = relationalTransformation2tracePackage.getTraceProperty(QVTrelationUtil.getType(cCalledVariable), rParameter);
				NavigationCallExp cCalledValue/*pe*/ = createNavigationCallExp(createVariableExp(cCalledVariable), cCalledProperty);
				variablesAnalysis.addConditionPredicate(cMiddleGuardPattern, cCalledValue, cReferenceValue); //createVariableExp(cArgumentVariable));
			}
			return cCalledVariable;
		}

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
				Set<@NonNull VariableDeclaration> rMiddleGuardDomainVariables = new HashSet<>(rWhenVariable2rTypedModel.keySet());
				rMiddleGuardDomainVariables.removeAll(rAllVariables);
				//
				for (@NonNull Predicate rWhenPredicate : QVTrelationUtil.getOwnedPredicates(rWhenPattern)) {
					OCLExpression rConditionExpression = QVTrelationUtil.getOwnedConditionExpression(rWhenPredicate);
					mapWhenTerm(rConditionExpression);
				}
				//doUnsharedWhenVarsToMgVars(unsharedWhenVars, mg);
				//				mapVariables(rMiddleGuardDomainVariables, cMiddleGuardPattern);
			}
		}

		protected void mapWhenTerm(@NonNull OCLExpression rConditionExpression) throws CompilerChainException {
			if (rConditionExpression instanceof RelationCallExp) {
				// body of RWhenRelCallToMGuard
				mapRelationCallExp((RelationCallExp)rConditionExpression);
				//						}
				/*						else {
					Relation2TraceClass relation2DispatchClass = relationalTransformation2tracePackage.getRelation2TraceClass(rInvokedRelation).getRelation2DispatchClass();
					assert relation2DispatchClass != null;
					Type invokedSignatureClass = relationalTransformation2tracePackage.getRelation2TraceClass(rInvokedRelation).getDispatchClass();
					String invokedName = "when_" + invokedSignatureClass.getName()/* + vdId* /;
					Variable cInvocationVariable = variablesAnalysis.addCoreRealizedVariable(invokedName, invokedSignatureClass);	// FIXME
					Property cInvocationProperty = relationalTransformation2tracePackage.getRelation2TraceClass(rRelation).getInvocation2TraceProperty(rInvocation).getTraceProperty();
					variablesAnalysis.addTraceNavigationAssignment(cInvocationProperty, cInvocationVariable);
					Variable2Variable signatureVariableAnalysis = variablesAnalysis.getCoreVariableAnalysis(cInvocationVariable);
					for (int i = 0; i < iSize; i++) {
						VariableExp rArgument = (VariableExp) rArguments.get(i);
						Variable rParameter = rParameters.get(i);
						Variable cArgumentVariable = variablesAnalysis.getCoreVariable(QVTbaseUtil.getReferredVariable(rArgument));
						Property cCalledProperty = relation2DispatchClass.getTraceProperty(rParameter);
						signatureVariableAnalysis.addNavigationAssignment(cCalledProperty, createVariableExp(cArgumentVariable), false);
					}

				} */
			}
			else {
				// body of RSimplePatternToMPattern
				OCLExpression cConditionExpression = mapExpression(rConditionExpression);
				variablesAnalysis.addPredicate(cMiddleGuardPattern, cConditionExpression);
				//						Predicate mpd = createPredicate(mapExpression(rConditionExpression));		// FIXME orphan
				//						addPredicate(composedMappingGuardPattern, cConditionExpression);
			}
		}

		// RPredicateSetToMBPredicateSet
		protected void mapWhereBottomPredicates(@NonNull Iterable<@NonNull Predicate> rWherePredicates) throws CompilerChainException {
			for (@NonNull Predicate rWherePredicate : rWherePredicates) {
				OCLExpression rExpression = QVTrelationUtil.getOwnedConditionExpression(rWherePredicate);
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
		protected void mapWhereGuardPredicates(@NonNull Set<@NonNull Predicate> rWhereGuardPredicates,  @NonNull Set<@NonNull VariableDeclaration> rEnforcedBottomDomainVariables) throws CompilerChainException
		{
			Set<@NonNull VariableDeclaration> nonRootEnforcedBottomDomainVariables = new HashSet<>(rEnforcedBottomDomainVariables);
			nonRootEnforcedBottomDomainVariables.removeAll(rEnforcedRootVariables);
			//
			Set<@NonNull Predicate> wherePredicatesWithVarBindings = selectPredicatesThatReferToVariables(rWhereGuardPredicates, nonRootEnforcedBottomDomainVariables);
			Set<@NonNull Predicate> remainingWherePredicatesWithoutVarBindings = new HashSet<>(rWhereGuardPredicates);
			remainingWherePredicatesWithoutVarBindings.removeAll(wherePredicatesWithVarBindings);
			// FIXME How does this do anything?
		}

		protected void mapWherePattern() throws CompilerChainException {
			Relation2TraceClass invokingRelation2TraceClass = relationalTransformation2tracePackage.getRelation2TraceClass(rRelation);
			Pattern rWherePattern = rRelation.getWhere();
			if (rWherePattern != null) {
				//				Set<@NonNull Variable> rMiddleBottomDomainVariables = new HashSet<>(rWhenVariable2rTypedModel.keySet());
				//				rMiddleGuardDomainVariables.removeAll(rAllVariables);
				//
				for (@NonNull Predicate rWherePredicate : QVTrelationUtil.getOwnedPredicates(rWherePattern)) {
					OCLExpression rConditionExpression = QVTrelationUtil.getOwnedConditionExpression(rWherePredicate);
					if (rConditionExpression instanceof RelationCallExp) {
						RelationCallExp rInvocation = (RelationCallExp)rConditionExpression;
						Relation rInvokedRelation = QVTrelationUtil.getReferredRelation(rInvocation);
						if (rInvokedRelation.isIsTopLevel()) {
							System.out.println("where invocation of top " + rInvokedRelation + " ignored.");
						}
						else {
							RelationAnalysis rInvokedRelationAnalysis = transformationAnalysis.getRelationAnalysis(rInvokedRelation);
							//						Type invokedSignatureClass2/*tc*/ = relationalTransformation2tracePackage.getSignatureClass(rInvokedRelation);
							Relation2TraceClass invokedRelation2TraceClass = relationalTransformation2tracePackage.getRelation2TraceClass(rInvokedRelation);
							Relation2MiddleType invokedRelation2InvocationClass = invokedRelation2TraceClass.getRelation2InvocationClass();
							Type invocationClass/*tc*/ = invokedRelation2TraceClass.getInvocationClass();
							List<@NonNull OCLExpression> rArguments = QVTrelationUtil.Internal.getOwnedArgumentsList(rInvocation);
							String invokedName = "where_" + invocationClass.getName()/* + vdId*/;
							VariableDeclaration cInvocationVariable/*vd*/ = variablesAnalysis.addCoreRealizedVariable(invokedName, invocationClass);	// FIXME
							//						Property cInvocationProperty2/*pep*/ = relationalTransformation2tracePackage.getTraceProperty(rInvocation);
							Property cInvocationProperty/*pep*/ = invokingRelation2TraceClass.getInvocation2TraceProperty(rInvocation).getTraceProperty();
							variablesAnalysis.addTraceNavigationAssignment(cInvocationProperty, cInvocationVariable);
							Variable2Variable invocationVariableAnalysis = variablesAnalysis.getCoreVariableAnalysis(cInvocationVariable);
							List<@NonNull VariableDeclaration> rParameters = rInvokedRelationAnalysis.getRootVariables();
							int iSize = rArguments.size();
							assert iSize == rParameters.size();
							for (int i = 0; i < iSize; i++) {
								VariableExp rArgument = (VariableExp) rArguments.get(i);
								VariableDeclaration rParameter = rParameters.get(i);
								VariableDeclaration cArgumentVariable = variablesAnalysis.getCoreVariable(QVTbaseUtil.getReferredVariable(rArgument));
								Property cCalledProperty = invokedRelation2InvocationClass.getTraceProperty(rParameter);
								invocationVariableAnalysis.addNavigationAssignment(cCalledProperty, createVariableExp(cArgumentVariable), false);
							}
						}
					}
					else {
						// body of RSimplePatternToMPattern
						//						OCLExpression cConditionExpression = mapExpression(rConditionExpression);
						//						variablesAnalysis.addPredicate(cMiddleGuardPattern, cConditionExpression);
						//						Predicate mpd = createPredicate(mapExpression(rConditionExpression));		// FIXME orphan
						//						addPredicate(composedMappingGuardPattern, cConditionExpression);
					}
				}
				//doUnsharedWhenVarsToMgVars(unsharedWhenVars, mg);
				//				mapVariables(rMiddleGuardDomainVariables, cMiddleGuardPattern);
			}
		}

		private void putTrace(@NonNull Element coreElement, @NonNull Element relationElement) {
			Element oldRelationElement = target2source.put(coreElement, relationElement);
			assert (oldRelationElement == relationElement) || (oldRelationElement == null);
			List<@NonNull Element> targets = source2targets.get(relationElement);
			if (targets == null) {
				targets = new ArrayList<>();
				source2targets.put(relationElement, targets);
			}
			if (!targets.contains(coreElement)) {			// IteratorVariables are traced proactively
				targets.add(coreElement);
			}
		}

		protected @NonNull Set<@NonNull Predicate> selectPredicatesThatReferToVariables(@NonNull Set<@NonNull Predicate> rPredicates, @NonNull Set<@NonNull VariableDeclaration> rVariables) {
			Set<@NonNull Predicate> rPredicatesThatReferToVariables = new HashSet<>();
			for (@NonNull Predicate rPredicate : rPredicates) {
				//				OCLExpression conditionExpression = rPredicate.getConditionExpression();
				//				assert conditionExpression != null;
				Set<@NonNull VariableDeclaration> rPredicateVariables = new HashSet<>();
				Variables2Variables.gatherReferredVariables(rPredicateVariables, rPredicate);
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
			Set<@NonNull VariableDeclaration> rEnforcedBottomDomainVariables = getEnforcedBottomDomainVariables();
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
			//			mapIncomingInvocation();			// Only for Invoked rather than Top relation
			mapOtherDomainVariables(rAllOtherReferredVariables);
			mapWhenPattern();
			mapWhereGuardPredicates(rWhereGuardPredicates, rEnforcedBottomDomainVariables);
			if (!rRelation.isIsAbstract()) {
				mapEnforcedDomainPatterns();
			}
			mapWherePattern();
			if (rEnforcedMemberVariables != null) {	// FIXME mapOtherDomainVariables duplication/irregularity
				for (@NonNull VariableDeclaration rMemberVariable : rEnforcedMemberVariables.keySet()) {
					variablesAnalysis.addTraceNavigationAssignment(rMemberVariable, true);
				}
			}
			mapRelationImplementation();
			//			Rule rOverrides = rRelation.getOverrides();
			//			if (rOverrides != null) {
			//				AbstractQVTr2QVTcRelations overridesRelation2mapping = qvtr2qvtc.getRelation2Mappings(rOverride)relation2relation2mapping.get(rOverrides);
			//				if (overridesRelation2mapping != null) {
			//					Mapping cMapping = relation2mapping.get
			//				}
			//			}
		}

		@Override
		public @NonNull String toString() {
			return rRelationName + "::" + rEnforcedDomainName + " => " + cMapping.getName() + "::" + cEnforcedDomain.getName();
		}
	}

	/**
	 *  All variables that are defined or referenced in any way within the relation's containment tree.
	 *  Includes CollectionTemplateExp member/rest, Let/Iterator variables.
	 */
	protected final @NonNull Set<@NonNull VariableDeclaration> rAllVariables;

	/**
	 * Mapping from each variable used as a when RelationCallExp argument to the typedModel of its corresponding argument.
	 */
	protected final @NonNull Map<@NonNull VariableDeclaration, @Nullable TypedModel> rWhenVariable2rTypedModel;

	/**
	 * Mapping from each variable used as a where RelationCallExp argument to the typedModel of its corresponding argument.
	 */
	protected final @NonNull Map<@NonNull VariableDeclaration, @Nullable TypedModel> rWhereVariable2rTypedModel;

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
	protected final @NonNull Set<@NonNull VariableDeclaration> rSharedVariables;

	/**
	 *  All relations, including this one, that this relation overrides.
	 */
	protected final @NonNull Set<@NonNull Relation> rAllOverriddens = new HashSet<>();

	protected BasicRelation2Mappings(@NonNull RelationalTransformation2CoreTransformation relationalTransformation2coreTransformation, @NonNull RelationAnalysis relationAnalysis) {
		super(relationalTransformation2coreTransformation, relationAnalysis);
		//		assert !rRelation.isIsAbstract();
		//
		this.rWhenVariable2rTypedModel = new HashMap<>();
		this.rWhenPredicates = new HashSet<>();
		Pattern rWhenPattern = rRelation.getWhen();
		if (rWhenPattern != null) {
			Variables2Variables.gatherReferredVariablesWithTypedModels(rWhenVariable2rTypedModel, rWhenPattern);
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
			Variables2Variables.gatherReferredVariablesWithTypedModels(rWhereVariable2rTypedModel, rWherePattern);
			// FIXME	assert rWherePattern.getBindsTo().equals(rWhereVariables);
			//			rWherePattern.getBindsTo().addAll(rWhereVariables);
			for (@NonNull Predicate rWherePredicate : QVTrelationUtil.getOwnedPredicates(rWherePattern)) {
				if (!(rWherePredicate.getConditionExpression() instanceof RelationCallExp)) {
					rWherePredicates.add(rWherePredicate);
				}
			}
		}
		//
		//	Gather all non-dead, non-implicit variables
		//
		this.rAllVariables = new HashSet<>();
		Variables2Variables.gatherReferredVariables(rAllVariables, QVTrelationUtil.getOwnedDomains(rRelation));
		if (rWhenPattern != null) {
			Variables2Variables.gatherReferredVariables(rAllVariables, rWhenPattern);
		}
		if (rWherePattern != null) {
			Variables2Variables.gatherReferredVariables(rAllVariables, rWherePattern);
		}
		List<@NonNull VariableDeclaration> allVariablesList = new ArrayList<>(rAllVariables);
		for (int i = 0; i < allVariablesList.size(); i++) {
			VariableDeclaration variable = allVariablesList.get(i);
			if (variable instanceof Variable) {
				OCLExpression ownedInit = ((Variable)variable).getOwnedInit();
				if (ownedInit != null) {
					Set<@NonNull VariableDeclaration> moreVariables = new HashSet<>();
					Variables2Variables.gatherReferredVariables(moreVariables, ownedInit);
					for (@NonNull VariableDeclaration moreVariable : moreVariables) {
						if (rAllVariables.add(moreVariable)) {
							allVariablesList.add(moreVariable);
						}
					}
				}
			}
		}
		//
		this.rSharedVariables = Variables2Variables.getMiddleDomainVariables(rRelation);
		//
		gatherOverriddens(rRelation);
	}

	private void gatherOverriddens(@NonNull Relation rOverriding) {
		if (rAllOverriddens.add(rOverriding)) {
			Relation rOverridden = QVTrelationUtil.basicGetOverridden(rOverriding);
			if (rOverridden != null) {
				gatherOverriddens(rOverridden);
			}
		}
		else {
			QVTruntimeUtil.errPrintln("Override cycle for " + this + " at " + rOverriding);
		};
	}

	@Override
	public @NonNull EnforceableRelationDomain2CoreMapping getTopRelationDomain2CoreMapping(@NonNull TypedModel rEnforcedTypedModel) {
		throw new IllegalStateException();
	}

	protected @Nullable Iterable<@NonNull RelationCallExp> getWhenInvocations() {
		return null;
	}

	protected @Nullable Iterable<@NonNull RelationCallExp> getWhereInvocations() {
		return null;
	}
}
