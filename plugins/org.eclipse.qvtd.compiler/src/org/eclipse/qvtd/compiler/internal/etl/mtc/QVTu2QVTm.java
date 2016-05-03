/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Horacio Hoyos - initial research
 *     E.D.Willink - initial API and implementation based on MtcBroker
 ******************************************************************************/
package org.eclipse.qvtd.compiler.internal.etl.mtc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.qvtd.compiler.internal.utilities.SymbolNameBuilder;
import org.eclipse.qvtd.compiler.internal.utilities.SymbolNameReservation;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.QVTbaseFactory;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtcore.CoreModel;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.QVTcoreFactory;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreUtil;
import org.eclipse.qvtd.pivot.qvtcorebase.Area;
import org.eclipse.qvtd.pivot.qvtcorebase.Assignment;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.CorePattern;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.NavigationAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.QVTcoreBaseFactory;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcorebase.VariableAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.utilities.QVTcoreBaseUtil;

import com.google.common.collect.Iterables;

/**
 * QVTu2QVTm simplifies a QVTu transformation
 * - flattening nested mappings
 * - flattening mapping refinements
 */
public class QVTu2QVTm extends AbstractQVTc2QVTc
{
	protected static class CreateVisitor extends AbstractCreateVisitor<@NonNull QVTu2QVTm>
	{
		public CreateVisitor(@NonNull QVTu2QVTm context) {
			super(context);
		}

		public @NonNull QVTu2QVTm getContext() {
			return context;
		}

		@Override
		protected void doRules(@NonNull Transformation tIn, @NonNull Transformation tOut) {
			List<@NonNull Mapping> requiredMappings = new ArrayList<@NonNull Mapping>();
			for (@NonNull Rule rule : ClassUtil.nullFree(tIn.getRule())) {
				if (rule instanceof Mapping) {
					requiredMappings.add((Mapping)rule);
					gatherRequiredMappings((Mapping)rule, requiredMappings);
				}
			}
			createAll(requiredMappings, tOut.getRule());
		}

		private void gatherRequiredMappings(@NonNull Mapping mapping, @NonNull List<@NonNull Mapping> requiredMappings) {
			for (@NonNull Mapping localMapping : ClassUtil.nullFree(mapping.getLocal())) {
				if (!isFoldable(localMapping)) {
					requiredMappings.add(localMapping);
				}
				gatherRequiredMappings(localMapping, requiredMappings);
			}
		}

		@Override
		public @NonNull CoreModel visitCoreModel(@NonNull CoreModel mIn) {
			CoreModel mOut = super.visitCoreModel(mIn);
			mOut.setExternalURI(mIn.getExternalURI().replace(".qvtu.qvtcas", ".qvtm.qvtcas"));
			return mOut;
		}

		@Override
		public @Nullable Mapping visitMapping(@NonNull Mapping mIn) {
			assert !isFoldable(mIn);
//			if (/*isAbstract(mIn) ||*/ isFoldable(mIn)) {
//				return null;
//			}
			if (!context.isRequired(mIn)) {
				return null;
			}
			Mapping mMapping = QVTcoreFactory.eINSTANCE.createMapping();
			context.pushScope(mMapping);
			try {
				MergedMapping mergedMapping = new MergedMapping(this, mIn);
				if (!mergedMapping.analyze()) {
					return null;
				}
		        mergedMapping.synthesize(mMapping);
		        return mMapping;
			}
			finally {
				context.popScope();
			}
		}
	}

	protected abstract static class MergedArea
	{
		private static final boolean ASSIGNMENT = true;
		private static final boolean PREDICATE = false;

		protected final @NonNull CreateVisitor createVisitor;
		private final @NonNull List<@NonNull Predicate> guardPredicates = new ArrayList<@NonNull Predicate>();
		private final @NonNull List<@NonNull Predicate> bottomPredicates = new ArrayList<@NonNull Predicate>();
		private @Nullable LinkedHashMap<@NonNull String, @NonNull MergedVariable> variableName2mergedVariables = null;
		private @Nullable LinkedHashMap<@NonNull String, @NonNull List<@NonNull NavigationAssignment>> variableName_property2navigationAssignments = null;
		private @Nullable List<@NonNull NavigationAssignment> navigationAssignmentsAsPredicates = null;
		
		protected MergedArea(@NonNull CreateVisitor createVisitor) {
			this.createVisitor = createVisitor;
		}

		protected boolean analyze() {
			Area thisArea = getArea(getMapping());
			if (thisArea != null) {
				@SuppressWarnings("null")@NonNull GuardPattern thisGuardPattern = thisArea.getGuardPattern();
				guardPredicates.addAll(ClassUtil.nullFree(thisGuardPattern.getPredicate()));
				gatherVariables(thisGuardPattern.getVariable(), MergedVariable.GUARD);
				@SuppressWarnings("null")@NonNull BottomPattern thisBottomPattern = thisArea.getBottomPattern();
				gatherVariables(thisBottomPattern.getVariable(), MergedVariable.BOTTOM);
				gatherAssignments(thisBottomPattern.getAssignment(), ASSIGNMENT);
				bottomPredicates.addAll(ClassUtil.nullFree(thisBottomPattern.getPredicate()));
				gatherVariables(thisBottomPattern.getRealizedVariable(), MergedVariable.BOTTOM);
			}
			for (@NonNull Area childArea : getChildAreas()) {
				@SuppressWarnings("null")@NonNull GuardPattern childGuardPattern = childArea.getGuardPattern();
				guardPredicates.addAll(ClassUtil.nullFree(childGuardPattern.getPredicate()));
				gatherVariables(childGuardPattern.getVariable(), MergedVariable.GUARD);
				@SuppressWarnings("null")@NonNull BottomPattern childBottomPattern = childArea.getBottomPattern();
				gatherVariables(childBottomPattern.getVariable(), MergedVariable.BOTTOM);
				gatherAssignments(childBottomPattern.getAssignment(), ASSIGNMENT);
				bottomPredicates.addAll(ClassUtil.nullFree(childBottomPattern.getPredicate()));
				gatherVariables(childBottomPattern.getRealizedVariable(), MergedVariable.BOTTOM);
			}
			for (@NonNull Area parentArea : getParentAreas()) {
				assert (parentArea != thisArea);
				@SuppressWarnings("null")@NonNull GuardPattern parentGuardPattern = parentArea.getGuardPattern();
				guardPredicates.addAll(ClassUtil.nullFree(parentGuardPattern.getPredicate()));
				gatherVariables(parentGuardPattern.getVariable(), MergedVariable.GUARD);
				@SuppressWarnings("null")@NonNull BottomPattern parentBottomPattern = parentArea.getBottomPattern();
				gatherVariables(parentBottomPattern.getVariable(), MergedVariable.GUARD);			// Hoist
				gatherAssignments(parentBottomPattern.getAssignment(), PREDICATE);
				guardPredicates.addAll(ClassUtil.nullFree(parentBottomPattern.getPredicate()));									// Hoist
				gatherVariables(parentBottomPattern.getRealizedVariable(), MergedVariable.GUARD);	// Hoist
			}
			for (@NonNull Area siblingArea : getSiblingAreas()) {
				if (siblingArea != thisArea) {
					@SuppressWarnings("null")@NonNull GuardPattern siblingGuardPattern = siblingArea.getGuardPattern();
					guardPredicates.addAll(ClassUtil.nullFree(siblingGuardPattern.getPredicate()));
					gatherVariables(siblingGuardPattern.getVariable(), MergedVariable.GUARD);
					@SuppressWarnings("null")@NonNull BottomPattern siblingBottomPattern = siblingArea.getBottomPattern();
					gatherVariables(siblingBottomPattern.getVariable(), MergedVariable.BOTTOM);		// FIXME legacy compatibility
					gatherAssignments(siblingBottomPattern.getAssignment(), ASSIGNMENT);
					bottomPredicates.addAll(ClassUtil.nullFree(siblingBottomPattern.getPredicate()));		// FIXME legacy compatibility
					gatherVariables(siblingBottomPattern.getRealizedVariable(), MergedVariable.BOTTOM);
				}
			}
			return true;
		}

		protected @Nullable MergedVariable basicGetMergedVariable(@NonNull String name) {
			LinkedHashMap<@NonNull String, @NonNull MergedVariable> variableName2mergedVariables2 = variableName2mergedVariables;
			if (variableName2mergedVariables2 == null) {
				return null;
			}
			return variableName2mergedVariables2.get(name);
		}

		private void gatherAssignments(@NonNull Iterable</*@NonNull*/ Assignment> aIns, boolean asAssignment) {
			for (Assignment aIn : aIns) {
				if (aIn instanceof VariableAssignment) {
					VariableAssignment vaIn = (VariableAssignment)aIn;
					Variable vIn = vaIn.getTargetVariable();
					String name = vIn.getName();
					assert name != null;
					MergedVariable mergedVariable = getMergedVariable(name);
					mergedVariable.addAssignment(vaIn);
				}
				else if (aIn instanceof NavigationAssignment) {
					NavigationAssignment paIn = (NavigationAssignment)aIn;
					if (!asAssignment) {
						List<@NonNull NavigationAssignment> navigationAssignmentsAsPredicates2 = navigationAssignmentsAsPredicates;
						if (navigationAssignmentsAsPredicates2 == null) {
							navigationAssignmentsAsPredicates2 = navigationAssignmentsAsPredicates = new ArrayList<@NonNull NavigationAssignment>();
						}
						navigationAssignmentsAsPredicates2.add(paIn);
					}
					else {
						OCLExpression eIn = paIn.getSlotExpression();
						Property targetProperty = QVTcoreBaseUtil.getTargetProperty(paIn);
						if (eIn instanceof VariableExp) {
							VariableDeclaration vIn = ((VariableExp)eIn).getReferredVariable();
							String key = vIn.getName() + "%" + targetProperty.toString();
							assert key != null;
							LinkedHashMap<@NonNull String, @NonNull List<@NonNull NavigationAssignment>> variableName_property2navigationAssignments2 = variableName_property2navigationAssignments;
							if (variableName_property2navigationAssignments2 == null) {
								variableName_property2navigationAssignments2 = variableName_property2navigationAssignments = new LinkedHashMap<@NonNull String, @NonNull List<@NonNull NavigationAssignment>>();
							}
							List<@NonNull NavigationAssignment> navigationAssignments = variableName_property2navigationAssignments2.get(key);
							if (navigationAssignments == null) {
								navigationAssignments = new ArrayList<@NonNull NavigationAssignment>();
								variableName_property2navigationAssignments2.put(key, navigationAssignments);
							}
							navigationAssignments.add(paIn);
						}
					}
				}
			}
		}

		private <T extends Variable> void gatherVariables(@NonNull Iterable</*@NonNull*/ ? extends T> vIns, boolean isGuard) {
			for (T vIn : vIns) {
				if (vIn != null) {
					String name = vIn.getName();
					assert name != null;
					MergedVariable mergedVariable = getMergedVariable(name);
					mergedVariable.addVariable(vIn, isGuard);
				}
			}
		}

		protected abstract @Nullable Area getArea(@NonNull Mapping uMapping);

		protected abstract @NonNull  Iterable<? extends @NonNull Area> getChildAreas();

		public @NonNull CreateVisitor getCreateVisitor() {
			return createVisitor;
		}

		protected abstract @NonNull Mapping getMapping();

		protected @NonNull MergedVariable getMergedVariable(@NonNull String name) {
			LinkedHashMap<@NonNull String, @NonNull MergedVariable> variableName2mergedVariables2 = variableName2mergedVariables;
			if (variableName2mergedVariables2 == null) {
				variableName2mergedVariables = variableName2mergedVariables2 = new LinkedHashMap<@NonNull String, @NonNull MergedVariable>();
			}
			MergedVariable mergedVariable = variableName2mergedVariables2.get(name);
			if (mergedVariable == null) {
				mergedVariable = new MergedVariable(this, name);
				variableName2mergedVariables2.put(name, mergedVariable);
			}
			return mergedVariable;
		}

		protected abstract @NonNull  Iterable<? extends @NonNull Area> getParentAreas();

		protected abstract @NonNull  Iterable<? extends @NonNull Area> getSiblingAreas();

		protected boolean isEnforced() {
			return false;
		}

		protected void synthesize(@NonNull Area mArea) {
			GuardPattern mGuardPattern = QVTcoreBaseFactory.eINSTANCE.createGuardPattern();
			mArea.setGuardPattern(mGuardPattern);
			createVisitor.createAll(guardPredicates, mGuardPattern.getPredicate());
			if (navigationAssignmentsAsPredicates != null) {
				for (@NonNull NavigationAssignment paIn : navigationAssignmentsAsPredicates) {
					@NonNull Predicate pOut = QVTbaseFactory.eINSTANCE.createPredicate();
					createVisitor.getContext().addTrace(paIn, pOut);
					// The condition expression is copied during update once replacement variables exist.
					createVisitor.createAll(paIn.getOwnedComments(), pOut.getOwnedComments());
					mGuardPattern.getPredicate().add(pOut);
				}
			}
			//
			BottomPattern mBottomPattern = QVTcoreBaseFactory.eINSTANCE.createBottomPattern();
			mArea.setBottomPattern(mBottomPattern);
			createVisitor.createAll(bottomPredicates, mBottomPattern.getPredicate());
			synthesizeNavigationAssignments(mBottomPattern.getAssignment());
			if (variableName2mergedVariables != null) {
				for (@NonNull MergedVariable mergedVariable : variableName2mergedVariables.values()) {		// FIXME Change to alphabetical sort
					mergedVariable.synthesize(mArea);
				}
			}
			//
			QVTu2QVTm qvtu2qvtm = createVisitor.getContext();
			for (@NonNull Area uArea : Iterables.concat(getSiblingAreas(), getParentAreas(), getChildAreas())) {
				qvtu2qvtm.addTrace(uArea, mArea);
				if (uArea == getArea(getMapping())) {				// FIXME Legacy compatibility
					createVisitor.createAll(uArea.getOwnedComments(), mArea.getOwnedComments());
				}
				//
				@SuppressWarnings("null")@NonNull GuardPattern uGuardPattern = uArea.getGuardPattern();
				qvtu2qvtm.addTrace(uGuardPattern, mGuardPattern);
				createVisitor.createAll(uGuardPattern.getOwnedComments(), mGuardPattern.getOwnedComments());
				//
				@SuppressWarnings("null")@NonNull BottomPattern uBottomPattern = uArea.getBottomPattern();
				qvtu2qvtm.addTrace(uBottomPattern, mBottomPattern);
				createVisitor.createAll(uBottomPattern.getOwnedComments(), mArea.getOwnedComments());
			}
		}

		private void synthesizeNavigationAssignment(@NonNull List<@NonNull NavigationAssignment> navigationAssignments, @NonNull List<Assignment> uAssignments) {
			for (@NonNull NavigationAssignment navigationAssignment : navigationAssignments) {
				uAssignments.add(createVisitor.create(navigationAssignment));	// FIXME merge
				// break;
			}
		}

		private void synthesizeNavigationAssignments(@NonNull List</*@NoonNull*/ Assignment> uAssignments) {
			LinkedHashMap<@NonNull String, @NonNull List<@NonNull NavigationAssignment>> variableName_property2navigationAssignments2 = variableName_property2navigationAssignments;
			if (variableName_property2navigationAssignments2 != null) {
				for (@NonNull List<@NonNull NavigationAssignment> navigationAssignments : variableName_property2navigationAssignments2.values()) {		// FIXME Change to alphabetical sort
					synthesizeNavigationAssignment(navigationAssignments, uAssignments);
				}
			}
		}
	}
	
	protected static class MergedDomain extends MergedArea
	{
		/**
		 * The merged mapping to which this merged domain contributes.
		 */
		protected final @NonNull MergedMapping mergedMapping;
		
		/**
		 * The typed model that identifies this domain.
		 */
		protected final @NonNull TypedModel uTypedModel;
		
		/**
		 * A domain, not necessarily from the root or local mapping that has the check/enfoprce flags.
		 */
		protected final @NonNull CoreDomain uExampleDomain;
		
		/**
		 * The local domain for the local mapping., which may be null if there is no local domain.
		 */
		protected final @Nullable CoreDomain uLocalDomain;

		/**
		 * All local QVTi CoreDomains that merge up into the QVTm CoreDomain.
		 */
		private final @NonNull List<@NonNull CoreDomain> childDomains = new ArrayList<@NonNull CoreDomain>();

		/**
		 * All context QVTi CoreDomains that predicate the QVTm CoreDomain.
		 */
		private final @NonNull List<@NonNull CoreDomain> parentDomains = new ArrayList<@NonNull CoreDomain>();

		/**
		 * All refined QVTi CoreDomains (including this domain) that merge into the QVTm CoreDomain.
		 */
		private final @NonNull List<@NonNull CoreDomain> siblingDomains = new ArrayList<@NonNull CoreDomain>();
		
		public MergedDomain(@NonNull CreateVisitor createVisitor, @NonNull MergedMapping mergedMapping, @NonNull TypedModel uTypedModel, @NonNull CoreDomain uExampleDomain) {
			super(createVisitor);
			this.mergedMapping = mergedMapping;
			this.uTypedModel = uTypedModel;
			this.uExampleDomain = uExampleDomain;
			this.uLocalDomain = QVTcoreUtil.getDomain(mergedMapping.uMapping, uTypedModel);
		}

		@Override
		public boolean analyze() {
			for (@NonNull Mapping childMapping : mergedMapping.getChildAreas()) {
				CoreDomain childDomain = QVTcoreBaseUtil.getDomain(childMapping, uTypedModel);
				if (childDomain != null) {
					childDomains.add(childDomain);
				}
			}
			for (@NonNull Mapping parentMapping : mergedMapping.getParentAreas()) {
				CoreDomain parentDomain = QVTcoreBaseUtil.getDomain(parentMapping, uTypedModel);
				if (parentDomain != null) {
					parentDomains.add(parentDomain);
				}
			}
			for (@NonNull Mapping siblingMapping : mergedMapping.getSiblingAreas()) {
				CoreDomain siblingDomain = QVTcoreBaseUtil.getDomain(siblingMapping, uTypedModel);
				if (siblingDomain != null) {
					siblingDomains.add(siblingDomain);
				}
			}
	        return super.analyze();
		}

//		@Override
//		protected @NonNull CoreDomain zzgetArea() {
//			return uNonLocalDomain;
//		}

		@Override
		protected @Nullable CoreDomain getArea(@NonNull Mapping uMapping) {
			return QVTcoreBaseUtil.getDomain(uMapping, uTypedModel);
		}

		@Override
		protected @NonNull Iterable<@NonNull CoreDomain> getChildAreas() {
			return childDomains;
		}

		@Override
		protected @NonNull Mapping getMapping() {
			return mergedMapping.uMapping;
		}

		@Override
		protected @NonNull Iterable<@NonNull CoreDomain> getParentAreas() {
			return parentDomains;
		}

		@Override
		protected @NonNull Iterable<@NonNull CoreDomain> getSiblingAreas() {
			return siblingDomains;
		}

		@Override
		protected boolean isEnforced() {
			return uExampleDomain.isIsEnforceable();			// FIXME all domains ??
		}

		public @NonNull CoreDomain synthesize() {
			CoreDomain mDomain = QVTcoreBaseFactory.eINSTANCE.createCoreDomain();
//			mDomain.setTypedModel(uTypedModel);
			mDomain.setName(uTypedModel.getName());
			boolean isCheckable = uExampleDomain.isIsCheckable();
			boolean isEnforceable = uExampleDomain.isIsEnforceable();
			for (@NonNull CoreDomain domain : parentDomains) {
				if (domain.isIsCheckable()) {
					isCheckable = true;
				}
				if (domain.isIsEnforceable()) {
					isEnforceable = true;
				}
			}
			for (@NonNull CoreDomain domain : siblingDomains) {
				if (domain.isIsCheckable()) {
					isCheckable = true;
				}
				if (domain.isIsEnforceable()) {
					isEnforceable = true;
				}
			}
			mDomain.setIsCheckable(isCheckable);
			mDomain.setIsEnforceable(isEnforceable);
			synthesize(mDomain);
			return mDomain;
		}

		@Override
		public String toString() {
			return uExampleDomain.toString();
		}
	}

	protected static class MergedMapping extends MergedArea
	{
		/**
		 * The QVTu Mapping into which contributions may merge.
		 */
		protected final @NonNull Mapping uMapping;

		/**
		 * All local QVTi Mappings that merge up into the QVTm Mappings.
		 */
		private final @NonNull List<@NonNull Mapping> childMappings = new ArrayList<@NonNull Mapping>();

		/**
		 * All context QVTi Mappings that predicate the QVTm Mappings.
		 */
		private final @NonNull List<@NonNull Mapping> parentMappings = new ArrayList<@NonNull Mapping>();

		/**
		 * All refined QVTi Mappings (including this domain) that merge into the QVTm Mappings.
		 */
		private final @NonNull List<@NonNull Mapping> siblingMappings = new ArrayList<@NonNull Mapping>();
		
		/**
		 * The merge for each domain.
		 */
		private final @NonNull Map<@Nullable TypedModel, @NonNull MergedDomain> uTypedModel2mergedDomain = new HashMap<@Nullable TypedModel, @NonNull MergedDomain>();
		
		public MergedMapping(@NonNull CreateVisitor createVisitor, @NonNull Mapping uMapping) {
			super(createVisitor);
			this.uMapping = uMapping;
		}

		@Override
		public boolean analyze() {
			@SuppressWarnings("unused") String name = uMapping.getName();
        	computeChildMappings(childMappings, uMapping);
			computeSiblingMappings(siblingMappings, uMapping);
	        for (@NonNull Mapping contextMapping : siblingMappings) {
	        	if (contextMapping != uMapping) {			// FIXME Legacy order
	        		computeChildMappings(childMappings, contextMapping);
	        	}
	        }
	        computeParentMappings(parentMappings, uMapping);
	        for (@NonNull Mapping uMapping : Iterables.concat(siblingMappings, parentMappings, childMappings)) {
	        	for (@NonNull Domain uDomain : ClassUtil.nullFree(uMapping.getDomain())) {
					TypedModel uTypedModel = uDomain.getTypedModel();
					assert uTypedModel != null;
					if (uTypedModel2mergedDomain.get(uTypedModel) == null) {
						uTypedModel2mergedDomain.put(uTypedModel, new MergedDomain(createVisitor, this, uTypedModel, (@NonNull CoreDomain) uDomain));
					}
	        	}
	        }
	        for (@NonNull MergedDomain mergedDomain : uTypedModel2mergedDomain.values()) {
	        	if (!mergedDomain.analyze()) {
	        		return false;
	        	}
	        }
	        return super.analyze();
		}

		private void computeChildMappings(@NonNull List<@NonNull Mapping> childMappings, @NonNull Mapping parentMapping) {
			for (@NonNull Mapping childMapping : ClassUtil.nullFree(parentMapping.getLocal())) {
				if (isFoldable(childMapping)) {
					assert !childMappings.contains(childMapping) : "Local mappings cannot be cyclic";
					childMappings.add(childMapping);
					computeChildMappings(childMappings, childMapping);
				}
			}
		}

		private void computeParentMappings(@NonNull List<@NonNull Mapping> parentMappings, @NonNull Mapping childMapping) {
			Mapping parentMapping = childMapping.getContext();
			if (parentMapping != null) {
				assert !parentMappings.contains(parentMapping) : "Context mappings cannot be cyclic";
				computeSiblingMappings(parentMappings, parentMapping);		// All siblings of the parent are also parents. ?? folded too ??
				computeParentMappings(parentMappings, parentMapping);
			}
		}

	    private void computeSiblingMappings(@NonNull List<@NonNull Mapping> siblingMappings, @NonNull Mapping refinedMapping) {
			if (!siblingMappings.contains(refinedMapping)) {		// FIXME cannot be cyclic
				siblingMappings.add(refinedMapping);
				for (@NonNull Mapping specificationMapping : ClassUtil.nullFree(refinedMapping.getSpecification())) {
					assert refinedMapping.getContext() == null : "Local mapping cannot refine another";
					computeSiblingMappings(siblingMappings, specificationMapping);
				}
			}
	    }

		@Override
		protected @Nullable Mapping getArea(@NonNull Mapping uMapping) {
			return uMapping;
		}

		@Override
		protected @NonNull Iterable<@NonNull Mapping> getChildAreas() {
			return childMappings;
		}

		@Override
		protected @NonNull Mapping getMapping() {
			return uMapping;
		}

		@Override
		protected @NonNull MergedVariable getMergedVariable(@NonNull String name) {
			for (@NonNull MergedDomain mergedDomain : uTypedModel2mergedDomain.values()) {
				MergedVariable mergedVariable = mergedDomain.basicGetMergedVariable(name);
				if (mergedVariable != null) {
					return mergedVariable;
				}
			}
			return super.getMergedVariable(name);
		}

		@Override
		protected @NonNull Iterable<@NonNull Mapping> getParentAreas() {
			return parentMappings;
		}

		@Override
		protected @NonNull Iterable<@NonNull Mapping> getSiblingAreas() {
			return siblingMappings;
		}

		public void synthesize(@NonNull Mapping mMapping) {
			String name = createVisitor.getContext().getMappingName(uMapping);
			mMapping.setName(name);
	        super.synthesize(mMapping);
	    	Transformation uTransformation = QVTbaseUtil.getContainingTransformation(uMapping);
	    	assert uTransformation != null;
			for (@NonNull TypedModel uTypedModel : ClassUtil.nullFree(uTransformation.getModelParameter())) {
	    		MergedDomain mergedDomain = uTypedModel2mergedDomain.get(uTypedModel);
	    		if (mergedDomain != null) {
	    			CoreDomain mDomain = mergedDomain.synthesize();
					mMapping.getDomain().add(mDomain);
	    		}
	    	}
		}

		@Override
		public String toString() {
			return uMapping.toString();
		}
	}

	protected static class MergedVariable
	{
		public static final boolean GUARD = true;
		public static final boolean BOTTOM = false;
		protected final @NonNull CreateVisitor createVisitor;
		protected final @NonNull MergedArea mergedArea;
		protected final @NonNull String name;
		private boolean isGuard = BOTTOM;
		private boolean isRealized = false;
		private @Nullable CompleteClass mergedType = null;
		private boolean isRequired = false;
		private @Nullable List<@NonNull Variable> variables = null;
		private @Nullable List<@NonNull VariableAssignment> assignments = null;
		
		protected MergedVariable(@NonNull MergedArea mergedArea, @NonNull String name) {
			this.createVisitor = mergedArea.getCreateVisitor();
			this.mergedArea = mergedArea;
			this.name = name;
		}

		public void addAssignment(@NonNull VariableAssignment variableAssignment) {
			List<@NonNull VariableAssignment> assignments2 = assignments;
			if (assignments2 == null) {
				assignments = assignments2 = new ArrayList<@NonNull VariableAssignment>();
			}
			assignments2.add(variableAssignment);
		}

		public void addVariable(@NonNull Variable variable, boolean isGuard) {
			if (isGuard) {
				this.isGuard = true;
			}
			else if (variable instanceof RealizedVariable) {
				this.isRealized = true;
			}
			if (variable.isIsRequired()) {
				this.isRequired = true;
			}
			List<@NonNull Variable> variables2 = variables;
			if (variables2 == null) {
				variables = variables2 = new ArrayList<@NonNull Variable>();
			}
			assert !variables2.contains(variable);
			variables2.add(variable);
			EnvironmentFactory environmentFactory = createVisitor.getContext().getEnvironmentFactory();
			Type type = variable.getType();
			assert type != null;
			CompleteClass completeType = environmentFactory.getCompleteModel().getCompleteClass(type);
			CompleteClass mergedType2 = mergedType;
			if (mergedType2 == null) {
				mergedType = mergedType2 = completeType;
			}
			else if (completeType.conformsTo(mergedType2)) {
				mergedType = mergedType2 = completeType;
			}
			else {
				assert mergedType2.conformsTo(completeType);
			}
		}
		
		public void synthesize(@NonNull Area mArea) {
			List<@NonNull VariableAssignment> assignments2 = assignments;
			List<@NonNull Variable> variables2 = variables;
			if (variables2 != null) {
				Variable mVariable = QVTcoreBaseFactory.eINSTANCE.createRealizedVariable();
				if (isRealized) {
					RealizedVariable realizedVariable = QVTcoreBaseFactory.eINSTANCE.createRealizedVariable();
					mVariable = realizedVariable;
					mArea.getBottomPattern().getRealizedVariable().add(realizedVariable);
				}
				else {
					mVariable = PivotFactory.eINSTANCE.createVariable();
					if (isGuard) {
						mArea.getGuardPattern().getVariable().add(mVariable);
					}
					else {
						mArea.getBottomPattern().getVariable().add(mVariable);
					}
				}
				mVariable.setName(name);
				if (mergedType != null) {
					mVariable.setType(mergedType.getPrimaryClass());
				}
				mVariable.setIsRequired(isRequired);
				for (@NonNull Variable uVariable : variables2) {
					createVisitor.getContext().addTrace(uVariable, mVariable);
					createVisitor.createAll(uVariable.getOwnedComments(), mVariable.getOwnedComments());
				}
				if (assignments2 != null) {
					final Variable finalMVariable = mVariable;
					createVisitor.getContext().addUpdater(finalMVariable, new Updater()
					{
						@Override
						public void update(@NonNull UpdateVisitor updateVisitor) {
							finalMVariable.setOwnedInit(updateVisitor.createCastCopy(assignments2.get(0).getValue(), finalMVariable.getType()));
							for (@NonNull VariableAssignment uVariableAssignment : assignments2) {
								createVisitor.getContext().addTrace(uVariableAssignment, finalMVariable);
								createVisitor.createAll(uVariableAssignment.getOwnedComments(), finalMVariable.getOwnedComments());
							}
						}
					});
				}
			}
			else {
				assert assignments2 != null;
				VariableAssignment mVariableAssignment = createVisitor.create(assignments2.get(0));
				assert mVariableAssignment != null;
				for (@NonNull VariableAssignment uVariableAssignment : assignments2) {
//					createVisitor.getContext().addTrace(uVariableAssignment, mVariableAssignment);
				}
			}
		}

		@Override
		public String toString() {
			return name;
		}
	}

	protected static class UpdateVisitor extends AbstractUpdateVisitor<@NonNull QVTu2QVTm>
	{
		public UpdateVisitor(@NonNull QVTu2QVTm context) {
			super(context);
		}

		@Override
		public @Nullable Object visitVariable(@NonNull Variable mVariable) {
			Updater updater = context.getUpdater(mVariable);
			if (updater != null) {
				updater.update(this);
				return null;
			}
			else if (mVariable.eContainer() instanceof CorePattern) {
				return null;
			}
			else {
				return super.visitVariable(mVariable);
			}
		}
	}

	protected static interface Updater
	{
		void update(@NonNull UpdateVisitor updateVisitor);
	}
	
    /**
     * A local mapping may be folded into its context if it has no guard variables or predicates and so cannot execute independently of its context. 
     */
    private static boolean isFoldable(@NonNull Mapping mapping) {
    	if (mapping.getContext() == null) {
    		return false;
    	}
        assert mapping.getSpecification().isEmpty() : " Local mappings cannot be a refinement.";
        GuardPattern guardPattern = mapping.getGuardPattern();
		if (guardPattern.getVariable().size() > 0) {
        	return false;
        }
        if (guardPattern.getPredicate().size() > 0) {
        	return false;
        }
        for (Domain d : mapping.getDomain()) {
        	CoreDomain cd = (CoreDomain)d;
            guardPattern = cd.getGuardPattern();
			if (guardPattern.getVariable().size() > 0) {
            	return false;
            }
            if (guardPattern.getPredicate().size() > 0) {
            	return false;
            }
        }
        return true;
    }
	
	private final @NonNull Map<@NonNull Element, @NonNull Updater> element2updater = new HashMap<@NonNull Element, @NonNull Updater>();
	
	private final @NonNull SymbolNameReservation symbolNameReservation = new SymbolNameReservation();

    public QVTu2QVTm(@NonNull EnvironmentFactory environmentFactory) {
        super(environmentFactory);
    }

	public void addUpdater(@NonNull Element mElement, @NonNull Updater updater) {
		Updater oldUpdater = element2updater.put(mElement, updater);
		assert oldUpdater == null;
	}

	@Override
	protected @NonNull CreateVisitor createCreateVisitor() {
		return new CreateVisitor(this);
	}

	@Override
	protected @NonNull UpdateVisitor createUpdateVisitor() {
		return new UpdateVisitor(this);
	}

	/**
	 * Return a unique name for uMapping. Local mappings have a name constructed from their context and guard variable names.
	 * All mappings have their names suffixed if necessary for uniqueness.
	 */
	public @NonNull String getMappingName(@NonNull Mapping uMapping) {
		SymbolNameBuilder s = new SymbolNameBuilder();
		String name = uMapping.getName();
		if (name != null) {
			s.appendName(name);
		}
		else {
			Mapping uNamedMapping = uMapping;
			while (uNamedMapping.getContext() != null) {
				uNamedMapping = uNamedMapping.getContext();
			}
			s.appendString(String.valueOf(uNamedMapping.getName()));
			List<@NonNull String> guardVariableNames = new ArrayList<@NonNull String>();
			for (@NonNull Variable guardVariable : ClassUtil.nullFree(uMapping.getGuardPattern().getVariable())) {
				guardVariableNames.add(String.valueOf(guardVariable.getName()));
			}
			for (@NonNull Domain uDomain : ClassUtil.nullFree(uMapping.getDomain())) {
				for (@NonNull Variable guardVariable : ClassUtil.nullFree(((CoreDomain)uDomain).getGuardPattern().getVariable())) {
					guardVariableNames.add(String.valueOf(guardVariable.getName()));
				}
			}
			Collections.sort(guardVariableNames);
			for (@NonNull String guardVariableName : guardVariableNames) {
				s.appendString("_");
				s.appendString(guardVariableName);
			}
		}
		return symbolNameReservation.reserveSymbolName(s, uMapping);
	}

	public @Nullable Updater getUpdater(@NonNull Element mElement) {
		return element2updater.get(mElement);
	}

    private boolean hasVariables(Area a) {
        return !(a.getGuardPattern().getVariable().isEmpty() ||
                a.getBottomPattern().getVariable().isEmpty() ||
                a.getBottomPattern().getRealizedVariable().isEmpty());
    }

    /**
     * Return false if the mapping can be omitted, either because it is not refined or because it contributes no variables.
     */
    private boolean isRequired(@NonNull Mapping m) {
        List<@NonNull Mapping> refinements = ClassUtil.nullFree(m.getRefinement());
		if (refinements.isEmpty())
            return true;
        for (@NonNull Mapping refining : refinements) {
            for (Domain rd : refining.getDomain()) {
                if (hasVariables((Area) rd))
                    return true;
            }
            if (hasVariables(m))
                return true;
        }
        return false;
    }
}
