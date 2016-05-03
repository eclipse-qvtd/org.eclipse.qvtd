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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionLiteralExp;
import org.eclipse.ocl.pivot.CollectionLiteralPart;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.IntegerLiteralExp;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreHelper;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.CorePattern;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.NavigationAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.QVTcoreBaseFactory;
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
		protected abstract class AbstractOtherRelationDomain2CoreDomain 
		{
			protected final @NonNull RelationDomain rOtherDomain;		// A not-enforced domain wrt the enforced domain
			protected final @NonNull String rOtherDomainName;
			protected final @NonNull TypedModel rOtherTypedModel;
			protected final @NonNull TypedModel cOtherTypedModel;
			protected final @NonNull CoreDomain cOtherDomain;
			protected final @NonNull GuardPattern cOtherGuardPattern;
			protected final @NonNull BottomPattern cOtherBottomPattern;
			
			public AbstractOtherRelationDomain2CoreDomain(@NonNull RelationDomain rOtherDomain) {
				this.rOtherDomain = rOtherDomain;
				this.rOtherDomainName = ClassUtil.nonNullState(rOtherDomain.getName());
				this.rOtherTypedModel = ClassUtil.nonNullState(rOtherDomain.getTypedModel());
				this.cOtherTypedModel = getCoreTypedModel(rOtherTypedModel);
				this.cOtherDomain = qvtr2qvtc.whenCoreDomain(cMapping, rOtherDomainName);
				cOtherDomain.setTypedModel(cOtherTypedModel);
				cOtherDomain.setIsCheckable(rOtherDomain.isIsCheckable());
				cOtherDomain.setIsEnforceable(false);
				this.cOtherGuardPattern = ClassUtil.nonNullState(cOtherDomain.getGuardPattern());
				this.cOtherBottomPattern = ClassUtil.nonNullState(cOtherDomain.getBottomPattern());
			}

			public abstract void mapOtherDomainToDomainVariablesAndPatterns() throws CompilerChainException;
		}

		/**
		 * An ExpressionCopier deep copies an OCLExpression tree, exploiting the forward traceability of context to
		 * update references and using sibling to distinguish multiple targets.
		 */
		@SuppressWarnings("serial")
		protected class ExpressionCopier extends EcoreUtil.Copier
		{	
			@Override
			public EObject get(Object oIn) {
				if (oIn instanceof Element) {
					List<Element> oOuts = source2targets.get(oIn);
					if (oOuts != null) {
						assert oOuts.size() == 1;
						return oOuts.get(0);
					}
				}
				return super.get(oIn);
			}
		}
		
		// Relations
		protected final @NonNull RelationDomain rEnforcedDomain;					// rd: This source enforced domain
		protected final @NonNull TypedModel rEnforcedTypedModel;					// rEnforcedDomain.getTypedModel()
		protected final @NonNull String rEnforcedDomainName;						// rEnforcedDomain.getName()
		protected final @NonNull List<@NonNull Variable> rEnforcedDomainVariables;	// All variables defined or referenced in this domain
//		@Deprecated
//		protected final @NonNull /*Object*/TemplateExp rEnforcedTemplateExpression;	// te: The template expression defining the enforced domain pattern
		protected final @NonNull List<@NonNull/*Object*/TemplateExp> rEnforcedTemplateExpressions;	// te: The template expression defining the enforced domain pattern
//		@Deprecated
//		protected final @NonNull Variable rEnforcedRootVariable;					// tev: The template expression variable (the root variable of the enforced domain pattern)
		protected final @NonNull List<@NonNull Variable> rEnforcedRootVariables;					// tev: The template expression variable (the root variable of the enforced domain pattern)
		protected final @NonNull List<@NonNull AbstractOtherRelationDomain2CoreDomain> otherDomain2coreDomains;		// All other domains sharing the parent of this domain
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
		
		/**
		 * The lazily created named RealizedVariables in each CorePattern.
		 */
		private @NonNull Map<@NonNull CorePattern, @NonNull Map<@NonNull String, @NonNull RealizedVariable>> pattern2name2realizedVariable
				= new HashMap<@NonNull CorePattern, @NonNull Map<@NonNull String, @NonNull RealizedVariable>>();	
		
		/**
		 * The lazily created named RealizedVariables in each CorePattern.
		 */
		private @NonNull Map<@NonNull CorePattern, @NonNull Map<@NonNull String, @NonNull Variable>> pattern2name2variable
				= new HashMap<@NonNull CorePattern, @NonNull Map<@NonNull String, @NonNull Variable>>();	
		
		/**
		 * The lazily created RealizedVariables per Relation Variable in each CorePattern.
		 */
		private @NonNull Map<@NonNull CorePattern, @NonNull Map<@NonNull Variable, @NonNull RealizedVariable>> pattern2variable2realizedVariable
				= new HashMap<@NonNull CorePattern, @NonNull Map<@NonNull Variable, @NonNull RealizedVariable>>();

		/**
		 * The lazily created Core Variable for each Relation Variable in each CorePattern.
		 */
		private @NonNull Map<@NonNull CorePattern, @NonNull Map<@NonNull Variable, @NonNull Variable>> pattern2variable2variable
				= new HashMap<@NonNull CorePattern, @NonNull Map<@NonNull Variable, @NonNull Variable>>();

		/**
		 * The core Variable for each relation Variable in a chosen mapping.
		 */
		private final @NonNull Map<@NonNull Variable, @NonNull Variable> rVariable2cVariable = new HashMap<@NonNull Variable, @NonNull Variable>();
		
		/**
		 * The names allocated in each relation.
		 */
		private final @NonNull Map<@NonNull String, @NonNull Element> name2element = new HashMap<@NonNull String, @NonNull Element>();

		private final @NonNull Map<@NonNull Element, @NonNull List<@NonNull Element>> source2targets = new HashMap<@NonNull Element, @NonNull List<@NonNull Element>>();
		private final @NonNull Map<@NonNull Element, @NonNull Element> target2source = new HashMap<@NonNull Element, @NonNull Element>();
		
		public AbstractEnforceableRelationDomain2CoreMapping(@NonNull RelationDomain rEnforcedDomain, @NonNull String cMappingName) {
			this.rEnforcedDomain = rEnforcedDomain;
			//
//			@NonNull DomainPattern rEnforcedDomainPattern = qvtr2qvtc.getDomainPattern(rEnforcedDomain);
			this.rEnforcedDomainVariables = getDomainVariables(rEnforcedDomain);
			this.rEnforcedTemplateExpressions = getTemplateExpressions(rEnforcedDomain);
			this.rEnforcedRootVariables = getRootVariables(rEnforcedDomain);
//			this.rEnforcedTemplateExpression = /*(ObjectTemplateExp)*/ ClassUtil.nonNullState(rEnforcedDomainPattern.getTemplateExpression());
//			this.rEnforcedRootVariable = ClassUtil.nonNullState(rEnforcedTemplateExpression.getBindsTo());			
			this.rEnforcedTypedModel = ClassUtil.nonNullState(rEnforcedDomain.getTypedModel());
			@NonNull String rRelationName = ClassUtil.nonNullState(rRelation.getName());
			this.rEnforcedDomainName = ClassUtil.nonNullState(rEnforcedDomain.getName());
			@NonNull Type traceClass = qvtr2qvtc.getTraceClass(rRelation);
			//
			this.cEnforcedTypedModel = getCoreTypedModel(rEnforcedTypedModel);
			this.cMapping = qvtr2qvtc.whenMapping(rRelation, cMappingName);
			this.cMiddleGuardPattern = ClassUtil.nonNullState(cMapping.getGuardPattern());
			this.cMiddleBottomPattern = ClassUtil.nonNullState(cMapping.getBottomPattern());
			this.cEnforcedDomain = qvtr2qvtc.whenCoreDomain(cMapping, rEnforcedDomainName);
			this.cEnforcedGuardPattern = ClassUtil.nonNullState(cEnforcedDomain.getGuardPattern());
			this.cEnforcedBottomPattern = ClassUtil.nonNullState(cEnforcedDomain.getBottomPattern());
			this.cMiddleRealizedVariable = whenRealizedVariable(cMiddleBottomPattern, rRelationName+"_"+rEnforcedDomainName+"_v", traceClass);	// 42
			//
			this.otherDomain2coreDomains = new ArrayList<@NonNull AbstractOtherRelationDomain2CoreDomain>();
			this.rOtherDomainVariables = new HashSet<@NonNull Variable>();
			for (@NonNull Domain rDomain : ClassUtil.nullFree(rEnforcedDomain.getRule().getDomain())) {
				if ((rDomain != rEnforcedDomain) && (rDomain instanceof RelationDomain)) {
					RelationDomain rRelationDomain = (RelationDomain)rDomain;
					otherDomain2coreDomains.add(createOtherDomain2CoreDomain(rRelationDomain));
					rOtherDomainVariables.addAll(getDomainVariables(rRelationDomain));
				}
			}
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
					mVariable = createVariable(getSafeName(mMember, "member"), mMember);
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
			System.out.println("addPredicate " + cExpression);
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
				System.out.println("addPropertyAssignment " + cAssignment);
				cBottomPattern.getAssignment().add(cAssignment);
				return;
			}
			Property cOppositeProperty = cProperty.getOpposite();
			if ((cOppositeProperty != null) && (cExpression instanceof VariableExp) && (!cOppositeProperty.isIsMany() || (cVariable.getType() instanceof CollectionType))) {
				VariableExp cSlotVariableExp = (VariableExp)cExpression;
				NavigationAssignment cAssignment = createNavigationAssignment(cSlotVariableExp, cOppositeProperty, createVariableExp(cVariable));
				System.out.println("addPropertyAssignment " + cAssignment);
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
				if (!rSharedVariables.contains(rBoundVariable)) {
					Variable cBoundVariable = getCoreVariable(rBoundVariable);  // FIXME whenVariable(cMiddleBottomPattern, rBoundVariable);
					cTargetVariable = getCoreVariable(rTargetVariable); //getCoreRealizedVariable(rTargetVariable);
					cExpression = createVariableExp(cBoundVariable);
				}
			}
			else if (rExpression instanceof VariableExp) {
				Variable rReferredVariable = ClassUtil.nonNullState((Variable) ((VariableExp)rExpression).getReferredVariable());
				Variable cReferredVariable = getCoreVariable(rReferredVariable);
				if (rSharedVariables.contains(rReferredVariable) ) {
					// body of RDomainPatternExprToMappingBottomVarAssignment
					cTargetVariable = getCoreRealizedVariable(rTargetVariable);
				}
				else {
					// body of RDomainPatternExprToMappingDomainVarAssignment
					cTargetVariable = getCoreRealizedVariable(rTargetVariable);
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
			Variable rVariable/*vpte*/ = ClassUtil.nonNullState((Variable) e.getReferredVariable());
			Variable cVariable/*mvpte*/ = getCoreVariable(rVariable);
			BottomPattern cBottomPattern = rSharedVariables.contains(rVariable) ? cMiddleBottomPattern : cEnforcedBottomPattern;
			addPropertyAssignment(cBottomPattern, cTemplateVariable, traceProperty, createVariableExp(cVariable));
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
			OCLExpression rGuardPredicate = rTemplateExpression.getWhere();
			if (rGuardPredicate != null) {
				cMiddleBottomPattern.getPredicate().add(createPredicate(mapExpression(rGuardPredicate)));
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

		protected abstract @NonNull AbstractOtherRelationDomain2CoreDomain createOtherDomain2CoreDomain(@NonNull RelationDomain rRelationDomain);

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

		
		private @NonNull RealizedVariable getCoreRealizedVariable(@NonNull Variable rv) {		
			@NonNull /*Realized*/Variable mv = /*(RealizedVariable)*/ getCoreVariable(rv);
			return (@NonNull RealizedVariable) mv;
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
			return ClassUtil.nonNullState(rVariable2cVariable.get(rVariable));
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
		
		public @NonNull String getSafeName(@NonNull Element newElement, @NonNull String name) {
			Element oldElement = name2element.get(name);
			if (oldElement == newElement) {
				return name;
			}
			if (oldElement == null) {
				name2element.put(name, newElement);
				return name;
			}
			for (int i = 1; true; i++) {
				String newName = name + "_" + i;
				oldElement = name2element.get(newName);
				if (oldElement == null) {
					name2element.put(newName, newElement);
					return newName;
				}
			}
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
					Property cProperty = basicGetProperty(cMiddleRealizedVariable.getType(), rDomainVariable);
					if (cProperty != null) {			// null for dead variables
						Variable cVariable = getCoreVariable(rDomainVariable);
						addPropertyAssignment(cMiddleBottomPattern, cMiddleRealizedVariable, cProperty, createVariableExp(cVariable));
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
		
		// RDomainToMDBottomForEnforcement
		protected void mapEnforcedDomain(@NonNull Set<@NonNull Predicate> predicatesWithoutVarBindings,  @NonNull Set<@NonNull Variable> rEnforcedBottomDomainVariables) throws CompilerChainException
		{
			Set<@NonNull Variable> nonRootEnforcedBottomDomainVariables = new HashSet<@NonNull Variable>(rEnforcedBottomDomainVariables);
			nonRootEnforcedBottomDomainVariables.removeAll(rEnforcedRootVariables);
			//
			Set<@NonNull Predicate> predicatesWithVarBindings = selectPredicatesThatReferToVariables(predicatesWithoutVarBindings, nonRootEnforcedBottomDomainVariables);	
			Set<@NonNull Predicate> remainingPredicatesWithoutVarBindings = new HashSet<@NonNull Predicate>(predicatesWithoutVarBindings);
			remainingPredicatesWithoutVarBindings.removeAll(predicatesWithVarBindings);
			for (@NonNull TemplateExp rEnforcedTemplateExpression/*te*/ : rEnforcedTemplateExpressions) {
				mapEnforcedDomain(rEnforcedTemplateExpression);
			}
		}	
		
		// RDomainToMDBottomForEnforcement
		private void mapEnforcedDomain(@NonNull TemplateExp rEnforcedTemplateExpression/*te*/) throws CompilerChainException
		{
//			for (@NonNull TemplateExp rEnforcedTemplateExpression/*te*/ : rEnforcedTemplateExpressions) {
				Variable rTemplateVariable/*v*/ = ClassUtil.nonNullState(rEnforcedTemplateExpression.getBindsTo());
				Type rTemplateVariableType/*c*/ = ClassUtil.nonNullState(rTemplateVariable.getType());
				Key key = qvtr2qvtc.getKeyforType(rTemplateVariableType);
//				if (key == null){
//					// Nothing to do
//				}
				/*else*/ if (rEnforcedTemplateExpression instanceof ObjectTemplateExp) {
					for (@NonNull PropertyTemplateItem pt : ClassUtil.nullFree(((ObjectTemplateExp)rEnforcedTemplateExpression).getPart())) {
						Property rPartProperty = ClassUtil.nonNullState(pt.getReferredProperty());
						OCLExpression rPartValue/*pte*/ = ClassUtil.nonNullState(pt.getValue());
						if ((key != null) && key.getPart().contains(rPartProperty)) {
							//  body of RDomainToMDBottomForEnforcementOfIdentityProp
							addPropertyAssignmentToMiddleBottomPattern(rTemplateVariable, rPartProperty, rPartValue);
						}
						else if (rPartValue instanceof TemplateExp) {
							// body of RDomainToMDBottomForEnforcementOfNonIdentityPropObject
							TemplateExp pte = (TemplateExp)rPartValue;
							Variable pv = pte.getBindsTo();
							Mapping composedMapping = cMapping; //qvtr2qvtc.createMapping(); //whenMapping(rRelation, cMapping.getName()+"_for_"+pv.name);
//							GuardPattern composedMappingGuardPattern = ClassUtil.nonNullState(composedMapping.getGuardPattern());
							CoreDomain composedEnforcedDomain = cEnforcedDomain;//qvtr2qvtc.whenCoreDomain(composedMapping, rEnforcedDomainName);
//							composedEnforcedDomain.setIsEnforceable(true);
//							composedEnforcedDomain.setTypedModel(cEnforcedTypedModel);
//							GuardPattern composedEnforcedGuardPattern = composedEnforcedDomain.getGuardPattern();
							BottomPattern composedEnforcedBottomPattern = cEnforcedBottomPattern;//ClassUtil.nonNullState(composedEnforcedDomain.getBottomPattern());

							
//							/*Realized*/Variable cTargetVariable/*mpv*/ = mapRealizedVariable(pv);
							/*Realized*/Variable cTargetVariable/*mpv*/ = rWhenVariables.contains(pv) ? getCoreVariable(pv) : whenRealizedVariable(composedEnforcedBottomPattern, pv);

							Variable cTemplateVariable/*mv*/ = getCoreVariable(rTemplateVariable);
							Property cTargetProperty = getProperty(cTemplateVariable.getType(), rPartProperty);
							addPropertyAssignment(composedEnforcedBottomPattern, cTemplateVariable, cTargetProperty, createVariableExp(cTargetVariable));
// FIXME							mapEnforcedDomain(pte);
//							cMapping.getLocal().add(composedMapping);
							Property cTargetProperty2 = getProperty(cMiddleRealizedVariable.getType(), cTargetVariable);
							addPropertyAssignment(cMiddleBottomPattern, cMiddleRealizedVariable, cTargetProperty2, createVariableExp(cTargetVariable));
						}
						else {
							// body of RDomainToMDBottomForEnforcementOfNonIdentityPropPrimitive
							Mapping composedMapping = cMapping; //qvtr2qvtc.createMapping(); //whenMapping(rRelation, cMapping.getName()+"_forNonIdentityProp");
							BottomPattern composedBottomPattern = cMiddleBottomPattern; //BClassUtil.nonNullState(composedMapping.getBottomPattern());
//							composedMapping.getGuardPattern();
							GuardPattern composedMappingGuardPattern = ClassUtil.nonNullState(composedMapping.getGuardPattern());
							CoreDomain composedEnforcedDomain = cEnforcedDomain;//qvtr2qvtc.whenCoreDomain(composedMapping, rEnforcedDomainName);
							GuardPattern composedEnforcedGuardPattern = cEnforcedGuardPattern;//composedEnforcedDomain.getGuardPattern();
							// where
							@SuppressWarnings("unused")BottomPattern composedMappingBottomPattern = cMiddleBottomPattern;//ClassUtil.nonNullState(composedMapping.getBottomPattern());
							Variable cTemplateVariable = getCoreVariable(rTemplateVariable);
							//RDomainToMComposedMappingGuardrEnforcedDomain
							for (@NonNull TemplateExp rTemplateExpression : rEnforcedTemplateExpressions) {
								if ((rPartValue instanceof VariableExp) && (rTemplateExpression instanceof ObjectTemplateExp)) {
									// check
									Variable rReferredVariable = (Variable) ClassUtil.nonNullState(((VariableExp) rPartValue).getReferredVariable());
									if (isVarBoundToSomeOtherTemplate((ObjectTemplateExp) rTemplateExpression, rEnforcedTemplateExpression, rReferredVariable)) {
										Variable cReferredVariable = getCoreVariable(rReferredVariable);
										// assign
										Property cTargetProperty = getProperty(cReferredVariable.getType(), cReferredVariable);
										NavigationCallExp cPropertyCallExp = createNavigationCallExp(createVariableExp(cMiddleRealizedVariable), cTargetProperty);
										addConditionPredicate(composedMappingGuardPattern, cPropertyCallExp, createVariableExp(cReferredVariable));
//										composedEnforcedDomain.setTypedModel(cEnforcedTypedModel);
										composedEnforcedGuardPattern.getBindsTo().add(cReferredVariable);
//										composedEnforcedDomain.setGuardPattern(composedEnforcedGuardPattern);
									}
								}
								Property cTargetProperty = getProperty(cTemplateVariable.getType(), rPartProperty);
								addPropertyAssignment(composedBottomPattern, cTemplateVariable, cTargetProperty, mapExpression(rPartValue));
//								cMapping.getLocal().add(composedMapping);
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
//			}
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
			return whenRealizedVariable(cEnforcedBottomPattern, rVariable);
		}

		/**
		 * Transform a rule implemented by a black box into an enforcement operation
		 *
		 * @param rRelation the r
		 * @param rEnforcedDomain the rd
		 * @param cMiddleBottomPattern the mb
		 */
		// RRelImplToMBottomEnforcementOperation
		protected void mapRelationImplementationToEnforcementOperation() {
			
			// TODO Code this when testing transformations with operational implementations.
			
		}
		
		protected void mapVariablesToVariables(@NonNull Iterable<@NonNull Variable> rVariables, @NonNull CorePattern cPattern) {		// RVarSetToDGVarSet, RVarSetToMBVarSet
			for (@NonNull Variable rVariable : rVariables) {
				whenVariable(cPattern, rVariable);
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
							Variable vd = whenVariable(cMiddleGuardPattern, tc.getName()+vdId+"_v", tc);
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

		protected void putCoreVariable(@NonNull Variable relationVariable, @NonNull Variable coreVariable) {
//			Mapping mapping = QVTcoreUtil.getContainingMapping(coreVariable);
//			assert mapping != null;
			Variable oldVal = rVariable2cVariable.put(relationVariable, coreVariable);
			// Variables should only be traced once
			if (oldVal != null) {
				System.out.println("putCoreVariable replacing value for " + relationVariable.getName());
			}
			putTrace(coreVariable, relationVariable);
		}
		
		private void putTrace(@NonNull Element coreElement, @NonNull Element relationElement) {
			Element oldRelationElement = target2source.put(coreElement, relationElement);
			assert oldRelationElement == null;
			List<@NonNull Element> targets = source2targets.get(relationElement);
			if (targets == null) {
				targets = new ArrayList<@NonNull Element> ();
				source2targets.put(relationElement, targets);
			}
			targets.add(coreElement);
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
			return rRelation.getName() + "::" + rEnforcedDomainName + " => " + cMapping.getName() + "::" + cEnforcedDomain.getName();
		}

		/**
		 * Lazily create the RealizedVariable for a corePattern corresponding to a relationVariable.
		 */
		private @NonNull RealizedVariable whenRealizedVariable(@NonNull BottomPattern corePattern, @NonNull Variable relationVariable) {	
			Map<@NonNull Variable, @NonNull RealizedVariable> variable2realizedVariable = pattern2variable2realizedVariable.get(corePattern);
			if (variable2realizedVariable == null) {
				variable2realizedVariable = new HashMap<@NonNull Variable, @NonNull RealizedVariable>();
				pattern2variable2realizedVariable.put(corePattern, variable2realizedVariable);
			}
			RealizedVariable realizedVariable = variable2realizedVariable.get(relationVariable);
			if (realizedVariable == null) {
				String name = relationVariable.getName();
				Type type = relationVariable.getType();
				assert (name != null) && (type != null);
				realizedVariable = QVTcoreBaseFactory.eINSTANCE.createRealizedVariable();
				realizedVariable.setName(name);
				realizedVariable.setType(type);
				realizedVariable.setIsRequired(true);
				variable2realizedVariable.put(relationVariable, realizedVariable);
				corePattern.getRealizedVariable().add(realizedVariable);
				putCoreVariable(relationVariable, realizedVariable);
			}
			return realizedVariable;
		}
		
		/**
		 * Lazily create the name RealizedVariable for a corePattern with a type.
		 */
		private @NonNull RealizedVariable whenRealizedVariable(@NonNull BottomPattern corePattern, @NonNull String name, @NonNull Type type) {	
			Map<@NonNull String, @NonNull RealizedVariable> name2realizedVariable = pattern2name2realizedVariable.get(corePattern);
			if (name2realizedVariable == null) {
				name2realizedVariable = new HashMap<@NonNull String, @NonNull RealizedVariable>();
				pattern2name2realizedVariable.put(corePattern, name2realizedVariable);
			}
			RealizedVariable realizedVariable = name2realizedVariable.get(name);
			if (realizedVariable == null) {
				realizedVariable = QVTcoreBaseFactory.eINSTANCE.createRealizedVariable();
				realizedVariable.setName(name);
				realizedVariable.setType(type);
				realizedVariable.setIsRequired(true);;
				name2realizedVariable.put(name, realizedVariable);
				corePattern.getRealizedVariable().add(realizedVariable);
//				putTrace(realizedVariable, corePattern);
			}
			else {
				assert realizedVariable.getType() == type;
			}
			return realizedVariable;
		}
		
		/**
		 * Lazily create the Variable for a corePattern corresponding to a relationVariable.
		 */
		private @NonNull Variable whenVariable(@NonNull CorePattern corePattern, @NonNull Variable relationVariable) {
			String name2 = relationVariable.getName();
			Map<@NonNull Variable, @NonNull Variable> variable2variable = pattern2variable2variable.get(corePattern);
			if (variable2variable == null) {
				variable2variable = new HashMap<@NonNull Variable, @NonNull Variable>();
				pattern2variable2variable.put(corePattern, variable2variable);
			}
			Variable coreVariable = variable2variable.get(relationVariable);
			if (coreVariable == null) {
				String name = relationVariable.getName();
				Type type = relationVariable.getType();
				assert (name != null) && (type != null);
				coreVariable = PivotFactory.eINSTANCE.createVariable();
				coreVariable.setName(name);
				coreVariable.setType(type);
				coreVariable.setIsRequired(relationVariable.isIsRequired());
				variable2variable.put(relationVariable, coreVariable);
				corePattern.getVariable().add(coreVariable);
				putCoreVariable(relationVariable, coreVariable);
			}
			return coreVariable;
		}
		
		/**
		 * Lazily create the name Variable for a corePattern with a type.
		 */
		protected @NonNull Variable whenVariable(@NonNull CorePattern corePattern, @NonNull String name, @NonNull Type type) {
			Map<@NonNull String, @NonNull Variable> name2variable = pattern2name2variable.get(corePattern);
			if (name2variable == null) {
				name2variable = new HashMap<@NonNull String, @NonNull Variable>();
				pattern2name2variable.put(corePattern, name2variable);
			}
			Variable coreVariable = name2variable.get(name);
			if (coreVariable == null) {
				coreVariable = PivotFactory.eINSTANCE.createVariable();
				coreVariable.setName(name);
				coreVariable.setType(type);
				coreVariable.setIsRequired(true);
				name2variable.put(name, coreVariable);
				corePattern.getVariable().add(coreVariable);
				putTrace(coreVariable, corePattern);
			}
			else {
				assert coreVariable.getType() == type;
			}
			return coreVariable;
		}
		
		protected abstract void where() throws CompilerChainException;
	}

	protected @NonNull final QVTrToQVTc qvtr2qvtc;
	// Relations
	protected final @NonNull Relation rRelation;								// r: Parent relation of this domain
	protected final @NonNull RelationalTransformation rTransformation;			// Parent transformation of parent relation of enforced domain
	protected final @NonNull Set<@NonNull Variable> rAllBoundDomainVariables;	// ??All pattern variables declared in all domains (not CollectionTemplateExp member/rest, Let/Iterator variables)
	protected final @NonNull Set<@NonNull Variable> rWhenVariables;				// All pattern variables used in when calls
	protected final @NonNull Set<@NonNull Variable> rWhereVariables;			// All pattern variables used in where calls
	protected final @NonNull Set<@NonNull Predicate> rPredicates;				// All non-RelationCallExp predicates
	protected final @NonNull Set<@NonNull Variable> rSharedVariables;			// All pattern variables shared by more than one domain
//	protected final @NonNull Set<@NonNull Variable> rUniquePatternVariables;	// All pattern variables that bind to exactly one object
//	protected final @NonNull Set<@NonNull Variable> rNonUniquePatternVariables;	// All pattern variables that bind to more than one object, typically as a Collection iterator
	protected final @NonNull Set<@NonNull Variable> rMiddleBottomDomainVariables;
	// Core
	protected final @NonNull Transformation cTransformation;					// mt: The transformation containing the result mapping

	protected AbstractQVTr2QVTcRelations(@NonNull QVTrToQVTc qvtr2qvtc, @NonNull Relation rRelation) {
		super(qvtr2qvtc.getEnvironmentFactory());
		this.qvtr2qvtc = qvtr2qvtc;
		this.rRelation = rRelation;
		this.rTransformation = (RelationalTransformation) ClassUtil.nonNullState(rRelation.getTransformation());
		//
//		this.rUniquePatternVariables = new HashSet<@NonNull Variable>();
//		this.rNonUniquePatternVariables = new HashSet<@NonNull Variable>();
//		for (@NonNull Domain rDomain : ClassUtil.nullFree(rRelation.getDomain())) {
//			for (@NonNull DomainPattern rDomainPattern : ClassUtil.nullFree(((RelationDomain)rDomain).getPattern())) {
//				gatherPatternVariables(this.rUniquePatternVariables, this.rNonUniquePatternVariables, true, rDomainPattern.getTemplateExpression());
//			}
//		}
		this.rAllBoundDomainVariables = new HashSet<@NonNull Variable>();
		for (@NonNull Domain rDomain : ClassUtil.nullFree(rRelation.getDomain())) {
			for (@NonNull DomainPattern rDomainPattern : ClassUtil.nullFree(((RelationDomain)rDomain).getPattern())) {
				this.rAllBoundDomainVariables.addAll(ClassUtil.nullFree(rDomainPattern.getBindsTo()));
			}
		}
//		rAllBoundDomainVariables.addAll(rUniquePatternVariables);
//		rAllBoundDomainVariables.addAll(rNonUniquePatternVariables);
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
		this.rSharedVariables = qvtr2qvtc.getMiddleDomainVariables(rRelation);
		//
		this.rMiddleBottomDomainVariables = new HashSet<@NonNull Variable>(rWhereVariables);
		rMiddleBottomDomainVariables.removeAll(rWhenVariables);
		rMiddleBottomDomainVariables.removeAll(rAllBoundDomainVariables);
		rMiddleBottomDomainVariables.addAll(rSharedVariables);			// FIXME this stinks
		//
		this.cTransformation = qvtr2qvtc.getCoreTransformation(rTransformation);
	}

	protected @Nullable Property basicGetProperty(/*@NonNull*/ Type aClass, @NonNull NamedElement rNamedElement) throws CompilerChainException {
		/*@NonNull*/ String name = rNamedElement.getName();
		assert (aClass != null) && (name != null);
		CompleteClass completeClass = environmentFactory.getCompleteModel().getCompleteClass(aClass);
		return completeClass.getProperty(name);
	}
	
	/**
	 * Add each of the domain variables within templateExpression to either uniquePatternVariables or nonUniquePatternVariables
	 * according to whether the variable has a single or multiple bindings in the overall context. The isUnique parameter is
	 * propagated during the recursion as true until a collection is traversed.
	 *
	private void gatherPatternVariables(@NonNull Set<@NonNull Variable> uniquePatternVariables, @NonNull Set<@NonNull Variable> nonUniquePatternVariables,
			boolean isUnique, @NonNull TemplateExp templateExpression) {
		Variable templateVariable = ClassUtil.nonNullState(templateExpression.getBindsTo());
		(isUnique ? uniquePatternVariables : nonUniquePatternVariables).add(templateVariable);
		if (templateExpression instanceof ObjectTemplateExp) {
			for (@NonNull PropertyTemplateItem propertyTemplateItem : ClassUtil.nullFree(((ObjectTemplateExp)templateExpression).getPart())) {
				Property property = propertyTemplateItem.getReferredProperty();
				OCLExpression value = propertyTemplateItem.getValue();
				if (value instanceof TemplateExp) {
					gatherPatternVariables(uniquePatternVariables, nonUniquePatternVariables, isUnique && !property.isIsMany(), (@NonNull TemplateExp) value);
				}
			}
		}
		else if (templateExpression instanceof CollectionTemplateExp) {
			for (@NonNull OCLExpression memberExpression : ClassUtil.nullFree(((CollectionTemplateExp)templateExpression).getMember())) {
				if (memberExpression instanceof TemplateExp) {
					gatherPatternVariables(uniquePatternVariables, nonUniquePatternVariables, false, (@NonNull TemplateExp) memberExpression);
				}
			}
		}
	} */

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
