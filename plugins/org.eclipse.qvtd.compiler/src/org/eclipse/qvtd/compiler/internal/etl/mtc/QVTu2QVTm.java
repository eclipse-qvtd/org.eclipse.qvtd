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
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.qvtd.compiler.internal.etl.utils.MtcUtil;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcore.CoreModel;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.QVTcoreFactory;
import org.eclipse.qvtd.pivot.qvtcorebase.Area;
import org.eclipse.qvtd.pivot.qvtcorebase.Assignment;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.CorePattern;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
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

/*	    private boolean hasVariables(Area a) {
	        return !(a.getGuardPattern().getVariable().isEmpty() ||
	                a.getBottomPattern().getVariable().isEmpty() ||
	                a.getBottomPattern().getRealizedVariable().isEmpty());
	    }

	    /**
	     * A mapping is abstract if it is a local mapping that has no guard variables or predicates and so cannot execute independently of its context. 
	     *
	    private boolean isAbstract(@NonNull Mapping m) {
	        if (m.getSpecification().isEmpty())
	            return false;
	        for (Mapping refining : m.getSpecification()) {
	            for (Domain rd : refining.getDomain()) {
	                if (hasVariables((Area) rd))
	                    return false;
	            }
	            if (hasVariables(m))
	                return false;
	        }
	        return true;
	    } */

		@Override
		public @NonNull CoreModel visitCoreModel(@NonNull CoreModel mIn) {
			CoreModel mOut = super.visitCoreModel(mIn);
			mOut.setExternalURI(mIn.getExternalURI().replace(".qvtu.qvtcas", ".qvtm.qvtcas"));
			return mOut;
		}

		@Override
		public @Nullable Mapping visitMapping(@NonNull Mapping mIn) {
			if (/*isAbstract(mIn) ||*/ isFoldable(mIn)) {
				return null;
			}
			if (context.isNotNeeded(mIn)) {
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
		
		protected final @NonNull CreateVisitor createVisitor;
		private final @NonNull List<@NonNull Predicate> guardPredicates = new ArrayList<@NonNull Predicate>();
		private final @NonNull List<@NonNull Predicate> bottomPredicates = new ArrayList<@NonNull Predicate>();
		private @Nullable LinkedHashMap<@NonNull String, @NonNull MergedVariable> variableName2mergedVariables = null;
		private final @NonNull LinkedHashMap<@NonNull String, @NonNull List<@NonNull PropertyAssignment>> variableName_property2propertyAssignments = new LinkedHashMap<@NonNull String, @NonNull List<@NonNull PropertyAssignment>>();
		
		protected MergedArea(@NonNull CreateVisitor createVisitor) {
			this.createVisitor = createVisitor;
		}

		protected boolean analyze() {
			Area thisArea = getArea();
			{
				@SuppressWarnings("null")@NonNull GuardPattern thisGuardPattern = thisArea.getGuardPattern();
				guardPredicates.addAll(thisGuardPattern.getPredicate());
				gatherVariables(thisGuardPattern.getVariable(), MergedVariable.GUARD);
				@SuppressWarnings("null")@NonNull BottomPattern thisBottomPattern = thisArea.getBottomPattern();
				gatherAssignments(thisBottomPattern.getAssignment());
				bottomPredicates.addAll(thisBottomPattern.getPredicate());
				gatherVariables(thisBottomPattern.getRealizedVariable(), MergedVariable.BOTTOM);
				gatherVariables(thisBottomPattern.getVariable(), MergedVariable.BOTTOM);
			}
			for (Area childArea : getChildAreas()) {
				@SuppressWarnings("null")@NonNull GuardPattern childGuardPattern = childArea.getGuardPattern();
				guardPredicates.addAll(childGuardPattern.getPredicate());
				gatherVariables(childGuardPattern.getVariable(), MergedVariable.GUARD);
				@SuppressWarnings("null")@NonNull BottomPattern childBottomPattern = childArea.getBottomPattern();
				gatherAssignments(childBottomPattern.getAssignment());
				bottomPredicates.addAll(childBottomPattern.getPredicate());
				gatherVariables(childBottomPattern.getRealizedVariable(), MergedVariable.BOTTOM);
				gatherVariables(childBottomPattern.getVariable(), MergedVariable.BOTTOM);
			}
			for (Area parentArea : getParentAreas()) {
				@SuppressWarnings("null")@NonNull GuardPattern parentGuardPattern = parentArea.getGuardPattern();
				guardPredicates.addAll(parentGuardPattern.getPredicate());
				gatherVariables(parentGuardPattern.getVariable(), MergedVariable.GUARD);
				@SuppressWarnings("null")@NonNull BottomPattern parentBottomPattern = parentArea.getBottomPattern();
				gatherAssignments(parentBottomPattern.getAssignment());
				guardPredicates.addAll(parentBottomPattern.getPredicate());									// Hoist
				gatherVariables(parentBottomPattern.getRealizedVariable(), MergedVariable.GUARD);	// Hoist
				gatherVariables(parentBottomPattern.getVariable(), MergedVariable.GUARD);			// Hoist
			}
			for (Area siblingArea : getSiblingAreas()) {
				if (siblingArea != thisArea) {
					@SuppressWarnings("null")@NonNull GuardPattern siblingGuardPattern = siblingArea.getGuardPattern();
					guardPredicates.addAll(siblingGuardPattern.getPredicate());
					gatherVariables(siblingGuardPattern.getVariable(), MergedVariable.GUARD);
					@SuppressWarnings("null")@NonNull BottomPattern siblingBottomPattern = siblingArea.getBottomPattern();
					gatherAssignments(siblingBottomPattern.getAssignment());
					bottomPredicates.addAll(siblingBottomPattern.getPredicate());		// FIXME legacy compatibility
					gatherVariables(siblingBottomPattern.getRealizedVariable(), MergedVariable.BOTTOM);
					gatherVariables(siblingBottomPattern.getVariable(), MergedVariable.BOTTOM);		// FIXME legacy compatibility
				}
			}
			return true;
		}

		private void gatherAssignments(@NonNull Iterable</*@NonNull*/ Assignment> aIns) {
			for (Assignment aIn : aIns) {
				if (aIn instanceof VariableAssignment) {
					VariableAssignment vaIn = (VariableAssignment)aIn;
					Variable vIn = vaIn.getTargetVariable();
					String name = vIn.getName();
					assert name != null;
					MergedVariable mergedVariable = getMergedVariable(name);
					mergedVariable.addAssignment(vaIn);
				}
				else if (aIn instanceof PropertyAssignment){
					PropertyAssignment paIn = (PropertyAssignment)aIn;
					OCLExpression eIn = paIn.getSlotExpression();
					Property targetProperty = paIn.getTargetProperty();
					if ((eIn instanceof VariableExp) && (targetProperty != null)) {
						VariableDeclaration vIn = ((VariableExp)eIn).getReferredVariable();
						String key = vIn.getName() + "%" + targetProperty.toString();
						assert key != null;
						List<@NonNull PropertyAssignment> propertyAssignments = variableName_property2propertyAssignments.get(key);
						if (propertyAssignments == null) {
							propertyAssignments = new ArrayList<@NonNull PropertyAssignment>();
							variableName_property2propertyAssignments.put(key, propertyAssignments);
						}
						propertyAssignments.add(paIn);
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

		protected abstract @NonNull Area getArea();

		protected abstract @Nullable Area getArea(@NonNull Mapping uMapping);

		protected abstract @NonNull  Iterable<? extends @NonNull Area> getChildAreas();

//		public @NonNull EnvironmentFactory getEnvironmentFactory() {
//			return createVisitor.getContext().getEnvironmentFactory();
//		}

//		public @NonNull QVTu2QVTm2 getContext() {
//			return createVisitor.getContext();
//		}

		public @NonNull CreateVisitor getCreateVisitor() {
			return createVisitor;
		}

		private @NonNull MergedVariable getMergedVariable(@NonNull String name) {
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
			//
			BottomPattern mBottomPattern = QVTcoreBaseFactory.eINSTANCE.createBottomPattern();
			mArea.setBottomPattern(mBottomPattern);
			createVisitor.createAll(bottomPredicates, mBottomPattern.getPredicate());
			synthesizePropertyAssignments(mBottomPattern.getAssignment());
			if (variableName2mergedVariables != null) {
				for (MergedVariable mergedVariable : variableName2mergedVariables.values()) {		// FIXME Change to alphabetical sort
					mergedVariable.synthesize(mArea);
				}
			}
			//
			QVTu2QVTm qvtu2qvtm = createVisitor.getContext();
			for (Area uArea : Iterables.concat(getSiblingAreas(), getParentAreas(), getChildAreas())) {
				qvtu2qvtm.addTrace(uArea, mArea);
				if (uArea == getArea()) {				// FIXME Legacy compatibility
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

		private void synthesizePropertyAssignment(@NonNull List<@NonNull PropertyAssignment> propertyAssignments, @NonNull List<Assignment> uAssignments) {
			for (PropertyAssignment propertyAssignment : propertyAssignments) {
				uAssignments.add(createVisitor.create(propertyAssignment));	// FIXME merge
				// break;
			}
		}

		private void synthesizePropertyAssignments(@NonNull List</*@NoonNull*/ Assignment> uAssignments) {
			for (List<@NonNull PropertyAssignment> propertyAssignments : variableName_property2propertyAssignments.values()) {		// FIXME Change to alphabetical sort
				synthesizePropertyAssignment(propertyAssignments, uAssignments);
			}
		}
	}
	
	protected static class MergedDomain extends MergedArea
	{
		protected final @NonNull MergedMapping mergedMapping;
		protected final @NonNull CoreDomain uDomain;
		protected final @NonNull TypedModel uTypedModel;

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
		
		public MergedDomain(@NonNull CreateVisitor createVisitor, @NonNull MergedMapping mergedMapping, @NonNull CoreDomain uDomain) {
			super(createVisitor);
			this.mergedMapping = mergedMapping;
			this.uDomain = uDomain;
			this.uTypedModel = ClassUtil.nonNull(uDomain.getTypedModel());
		}

		@Override
		public boolean analyze() {
			for (Mapping childMapping : mergedMapping.getChildAreas()) {
				CoreDomain childDomain = QVTcoreBaseUtil.getDomain(childMapping, uTypedModel);
				if (childDomain != null) {
					childDomains.add(childDomain);
				}
			}
			for (Mapping parentMapping : mergedMapping.getParentAreas()) {
				CoreDomain parentDomain = QVTcoreBaseUtil.getDomain(parentMapping, uTypedModel);
				if (parentDomain != null) {
					parentDomains.add(parentDomain);
				}
			}
			for (Mapping siblingMapping : mergedMapping.getSiblingAreas()) {
				CoreDomain siblingDomain = QVTcoreBaseUtil.getDomain(siblingMapping, uTypedModel);
				if (siblingDomain != null) {
					siblingDomains.add(siblingDomain);
				}
			}
	        return super.analyze();
		}

		@Override
		protected @NonNull CoreDomain getArea() {
			return uDomain;
		}

		@Override
		protected @Nullable CoreDomain getArea(@NonNull Mapping uMapping) {
			return QVTcoreBaseUtil.getDomain(uMapping, uTypedModel);
		}

		@Override
		protected @NonNull Iterable<@NonNull CoreDomain> getChildAreas() {
			return childDomains;
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
			return uDomain.isIsEnforceable();			// FIXME all domains ??
		}

		public @NonNull CoreDomain synthesize() {
			CoreDomain mDomain = QVTcoreBaseFactory.eINSTANCE.createCoreDomain();
//			mDomain.setTypedModel(uTypedModel);
			mDomain.setName(uTypedModel.getName());
			boolean isCheckable = uDomain.isIsCheckable();
			boolean isEnforceable = uDomain.isIsEnforceable();
			for (CoreDomain domain : parentDomains) {
				if (domain.isIsCheckable()) {
					isCheckable = true;
				}
				if (domain.isIsEnforceable()) {
					isEnforceable = true;
				}
			}
			for (CoreDomain domain : siblingDomains) {
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
			return uDomain.toString();
		}
	}

	protected static class MergedMapping extends MergedArea
	{
		/**
		 * The QVTu Mapping into which contributions may merg.
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
//			uTypedModel2mergedArea.put(null, this);
//			for (Domain uDomain : uMapping.getDomain()) {
//				TypedModel uTypedModel = uDomain.getTypedModel();
//				assert uTypedModel != null;
//				uTypedModel2mergedDomain.put(uTypedModel, new MergedDomain(createVisitor, this, (CoreDomain) uDomain));
//			}
		}

		@Override
		public boolean analyze() {
        	computeChildMappings(childMappings, uMapping);
			computeSiblingMappings(siblingMappings, uMapping);
	        for (Mapping contextMapping : siblingMappings) {
	        	if (contextMapping != uMapping) {			// FIXME Legacy order
	        		computeChildMappings(childMappings, contextMapping);
	        	}
	        }
	        computeParentMappings(parentMappings, uMapping);
	        for (Mapping uMapping : Iterables.concat(siblingMappings, parentMappings, childMappings)) {
	        	for (Domain uDomain : uMapping.getDomain()) {
					TypedModel uTypedModel = uDomain.getTypedModel();
					assert uTypedModel != null;
					if (uTypedModel2mergedDomain.get(uTypedModel) == null) {
						uTypedModel2mergedDomain.put(uTypedModel, new MergedDomain(createVisitor, this, (CoreDomain) uDomain));
					}
	        	}
	        }
	        for (MergedDomain mergedDomain : uTypedModel2mergedDomain.values()) {
	        	if (!mergedDomain.analyze()) {
	        		return false;
	        	}
	        }
	        return super.analyze();
		}

		private void computeChildMappings(@NonNull List<@NonNull Mapping> childMappings, @NonNull Mapping parentMapping) {
			for (Mapping childMapping : ClassUtil.nullFree(parentMapping.getLocal())) {
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

	    private void computeSiblingMappings(@NonNull List<@NonNull Mapping> siblingMappings, @NonNull Mapping specificationMapping) {
			if (!siblingMappings.contains(specificationMapping)) {		// FIXME cannot be cyclic
				assert specificationMapping.getContext() == null : "Refined mappings cannot be local";
				siblingMappings.add(specificationMapping);
				for (Mapping refinedMapping : ClassUtil.nullFree(specificationMapping.getRefinement())) {
					computeSiblingMappings(siblingMappings, refinedMapping);
				}
			}
	    }

		@Override
		protected @NonNull Mapping getArea() {
			return uMapping;
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
		protected @NonNull Iterable<@NonNull Mapping> getParentAreas() {
			return parentMappings;
		}

		@Override
		protected @NonNull Iterable<@NonNull Mapping> getSiblingAreas() {
			return siblingMappings;
		}

//		public @NonNull AbstractMapping getMapping() {
//			return uMapping;
//		}

		public void synthesize(@NonNull Mapping mMapping) {
			mMapping.setName(uMapping.getName());
	        super.synthesize(mMapping);
	    	for (TypedModel uTypedModel : ClassUtil.nullFree(uMapping.getTransformation().getModelParameter())) {
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
			if (variable instanceof RealizedVariable) {
				this.isRealized = true;
			}
			if (variable.isIsRequired()) {
				this.isRequired = true;
			}
			List<@NonNull Variable> variables2 = variables;
			if (variables2 == null) {
				variables = variables2 = new ArrayList<@NonNull Variable>();
			}
			variables2.add(variable);
			EnvironmentFactory environmentFactory = createVisitor.getContext().getEnvironmentFactory();
			CompleteClass completeType = environmentFactory.getCompleteModel().getCompleteClass(variable.getType());
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
				for (Variable uVariable : variables2) {
					createVisitor.getContext().addTrace(uVariable, mVariable);
					createVisitor.createAll(uVariable.getOwnedComments(), mVariable.getOwnedComments());
				}
				if (assignments2 != null) {
					final Variable finalMVariable = mVariable;
					createVisitor.getContext().addUpdater(finalMVariable, new Updater()
					{
						@Override
						public void update(@NonNull UpdateVisitor updateVisitor) {
							finalMVariable.setOwnedInit(updateVisitor.copy(assignments2.get(0).getValue(), finalMVariable));
							for (VariableAssignment uVariableAssignment : assignments2) {
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
				for (VariableAssignment uVariableAssignment : assignments2) {
					createVisitor.getContext().addTrace(uVariableAssignment, mVariableAssignment);
				}
			}
		}

		@Override
		public String toString() {
			return name;
		}

/*		private void synthesizeVariableAssignments(
				@NonNull LinkedHashMap<@NonNull String, @NonNull List<@NonNull VariableAssignment>> variableName2variableAssignments,
				@NonNull LinkedHashMap<@NonNull String, @NonNull List<@NonNull Variable>> variableName2guardVariables, @NonNull List</*@NonNull* / Assignment> aOuts) {
			Set<@NonNull String> guardVariableNames = variableName2guardVariables.keySet();
			for (String name : guardVariableNames) {		// FIXME Legacy order
				List<@NonNull VariableAssignment> variableAssignments = variableName2variableAssignments.get(name);
				if (variableAssignments != null) {
//					aOuts.add(create(variableAssignments.get(0)));	// FIXME merge
				}
			}
//			for (String name : variableName2variableAssignments.keySet().removeAll(guardVariableNames)) {		// FIXME Change to alphabetical sort
//				List<@NonNull VariableAssignment> variableAssignments = variableName2variableAssignments.get(name);
//				assert variableAssignments != null;
//				aOuts.add(create(variableAssignments.get(0)));	// FIXME merge
//			}
		}

/*		private <T extends Variable> void synthesizeVariables(
				@Nullable LinkedHashMap<@NonNull String, @NonNull List<@NonNull VariableAssignment>> variableName2variableAssignments,
				@NonNull LinkedHashMap<@NonNull String, @NonNull List<@NonNull T>> name2variables, @NonNull List</*@NonNull* / T> vOuts) {
			for (String name : name2variables.keySet()) {		// FIXME Change to alphabetical sort
				List<@NonNull T> namedVariables = name2variables.get(name);
				assert namedVariables != null;
				@Nullable T bestVariable = null;
				for (T vIn : namedVariables) {
					if (bestVariable == null) {
						bestVariable = vIn;
					}
					// FIXME merge
				}
				assert bestVariable != null;
				@Nullable T vOut = createVisitor.create(bestVariable);
				assert vOut != null;
				for (T vIn : namedVariables) {
					if (vIn != bestVariable) {
						createVisitor.getContext().addTrace(vIn, vOut);
					}
				}
				if (variableName2variableAssignments != null) {
					List<@NonNull VariableAssignment> variableAssignments = variableName2variableAssignments.remove(name);
					if (variableAssignments != null) {
						
					}
				}
				vOuts.add(vOut);
			}
		} */
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

/*		@Override
		public @NonNull Mapping visitMapping(@NonNull Mapping mOut) {
	        Mapping mIn = context.equivalentSource(mOut);
	        updateChild(mOut.getGuardPattern());
	        updateChild(mOut.getBottomPattern());
	        updateAllChildren(mOut.getDomain());
//	        updateAllChildren(mOut.getLocal());
//	        updateAllReferences(mIn.getSpecification(), mOut.getSpecification());
			return mIn;
		} */
	}

	protected static interface Updater
	{
		void update(@NonNull UpdateVisitor updateVisitor);
	}
	
    /**
     * A mapping is foldable if it is a local mapping that has no guard variables or predicates and so cannot execute independently of its context. 
     */
    private static boolean isFoldable(@NonNull Mapping mapping) {
    	if (mapping.getContext() == null) {
    		return false;
    	}
        assert mapping.getSpecification().isEmpty() : " Local mappings cannot be refined.";
        if (mapping.getGuardPattern().getVariable().size() > 0) {
        	return false;
        }
        if (mapping.getGuardPattern().getPredicate().size() > 0) {
        	return false;
        }
        for (Domain d : mapping.getDomain()) {
        	CoreDomain cd = (CoreDomain)d;
            if (cd.getGuardPattern().getVariable().size() > 0) {
            	return false;
            }
            if (cd.getGuardPattern().getPredicate().size() > 0) {
            	return false;
            }
        }
        return true;
    }

	Map<Variable, Variable> refinedVars = new HashMap<Variable, Variable>();
	
	private final @NonNull Map<@NonNull Element, @NonNull Updater> element2updater = new HashMap<@NonNull Element, @NonNull Updater>();

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

	public @Nullable Updater getUpdater(@NonNull Element mElement) {
		return element2updater.get(mElement);
	}

    private boolean hasVariables(Area a) {
        return !(a.getGuardPattern().getVariable().isEmpty() ||
                a.getBottomPattern().getVariable().isEmpty() ||
                a.getBottomPattern().getRealizedVariable().isEmpty());
    }

    /**
     * Return true if the mapping can be omitted, either because it is not refined or because it contributes no variables.
     */
    private boolean isNotNeeded(Mapping m) {
        if (m.getSpecification().isEmpty())
            return false;
        for (Mapping refining : m.getSpecification()) {
            for (Domain rd : refining.getDomain()) {
                if (hasVariables((Area) rd))
                    return false;
            }
            if (hasVariables(m))
                return false;
        }
        return true;
    }

    
    
    
    /**
     * @param var
     * @param area
     */
    private boolean findAndUseAssignment(Variable var, Area area) {
        for (Assignment a : area.getBottomPattern().getAssignment()) {
            if (a instanceof VariableAssignment) {
                if (((VariableAssignment) a).getTargetVariable().equals(var)) {
                    OperationCallExp exp = MtcUtil.assignmentToOclExp(a, environmentFactory);
                    var.setOwnedInit(exp.getOwnedArguments().get(0));
                    EcoreUtil.delete(a, true);
                    return true;
                }
            }
        }
        return false;
    }

    

    /**
     * Move everything from the nested mappings to the top one
     * @param m
     */
    private void flaten(Mapping m) {
        ArrayList<EObject> temp = new ArrayList<EObject>(m.getLocal());
        Iterator<EObject> it = temp.iterator();
        while (it.hasNext()) {
            Mapping local = (Mapping) it.next();
            for (Domain nd : local.getDomain()) {
                moveToRootDomain(m, (CoreDomain) nd);
            }
            moveToOtherArea(local, m);
            EcoreUtil.delete(local);
            // After all has been flatten all predicates, assignments and inits must
            // have their references fixed.
            for (Domain d : m.getDomain()) {
                MtcUtil.fixReferences((Area) d, refinedVars);
            }
            MtcUtil.fixReferences(m, refinedVars);
        }
    }

    private Set<Mapping> getAllRefinements(Mapping m) {
        Set<Mapping> refined = new HashSet<Mapping>(m.getRefinement());
        for (Mapping rm : m.getRefinement()) {
            refined.addAll(getAllRefinements(rm));
        }
        return refined;
    }

    private CoreDomain getRootDomain(Mapping m, Domain nd) {
        for (Domain d : m.getDomain()) {
            if (d.getTypedModel().getName().equals(nd.getTypedModel().getName()))
                return (CoreDomain) d;
        }
        return null;
    }

/*    private boolean hasVariables(Area a) {
        return !(a.getGuardPattern().getVariable().isEmpty() ||
                a.getBottomPattern().getVariable().isEmpty() ||
                a.getBottomPattern().getRealizedVariable().isEmpty());
    } */

    /**
     * Delete the refined mapping if all of its refiners do not
     * @param r
     *
    private boolean isNotNeeded(Mapping m) {
        if (m.getSpecification().isEmpty())
            return false;
        for (Mapping refining : m.getSpecification()) {
            for (Domain rd : refining.getDomain()) {
                if (hasVariables((Area) rd))
                    return false;
            }
            if (hasVariables(m))
                return false;
        }
        return true;

    } */

    private void mergeAreas(Area target, Area source) {
        for (Variable gv : source.getGuardPattern().getVariable()) {
            mergeVariable(gv, target.getGuardPattern());
        }
        for (Variable bv : source.getBottomPattern().getVariable()) {
            mergeVariable(bv, target.getGuardPattern());
        }
        for (RealizedVariable brv : source.getBottomPattern().getRealizedVariable()) {
            mergeRealizedVariable(brv, target.getBottomPattern());
        }
        // Copy all predicates and assignments, might generate duplicates?
        for (Predicate p : source.getGuardPattern().getPredicate()) {
            Predicate pOut = EcoreUtil.copy(p);
            target.getGuardPattern().getPredicate().add(pOut);
        }
        for (Predicate p : source.getBottomPattern().getPredicate()) {
            Predicate pOut = EcoreUtil.copy(p);
            target.getGuardPattern().getPredicate().add(pOut);
        }
        for (Assignment as : source.getBottomPattern().getAssignment()) {
            Assignment aOut = EcoreUtil.copy(as);
            target.getBottomPattern().getAssignment().add(aOut);
        }

    }

    /**
     * Find the matching domain or create one and them merge them.
     * @param refining
     * @param rd
     */
    private void mergeDomain(Mapping refining, Domain rd) {
        CoreDomain cd = null;
        for (Domain d : refining.getDomain()) {
            if (d.getTypedModel().equals(rd.getTypedModel())) {
                cd = (CoreDomain) d;
            }
        }
        if (cd == null) {
            // We need a new domain
            cd = QVTcoreBaseFactory.eINSTANCE.createCoreDomain();
            cd.setTypedModel(rd.getTypedModel());
            cd.setName(rd.getName());
            GuardPattern dgp = QVTcoreBaseFactory.eINSTANCE.createGuardPattern();
            cd.setGuardPattern(dgp);
            BottomPattern dbp = QVTcoreBaseFactory.eINSTANCE.createBottomPattern();
            cd.setBottomPattern(dbp);
            refining.getDomain().add(cd);
        }
        mergeAreas((Area)cd, (Area)rd);
    }

    /**
     * Merging requires that variables share the name. Variables with the
     * same name should have types in the same hierarchy. The refining variable
     * is assumed to have the less abstract type.
     * @param existing
     * @param guardPattern
     */
    private void mergeRealizedVariable(RealizedVariable existing, BottomPattern target) {
        // Find a var with the same name
        RealizedVariable match = null;
        for (RealizedVariable v : target.getRealizedVariable()) {
            if (v.getName().equals(existing.getName())) {
                match = v;
                break;
            }
        }
        if (match != null) {
            Class rvClass = (Class) existing.getType();
            Class matchClass = (Class)match.getType();
            assert matchClass.getSuperClasses().contains(rvClass) || matchClass.equals(rvClass);
        } else {
            // We need to copy the variable
            match = QVTcoreBaseFactory.eINSTANCE.createRealizedVariable();
            match.setName(existing.getName());
            match.setIsImplicit(existing.isIsImplicit());
            if (match.getOwnedInit() != null) {
                match.setOwnedInit(EcoreUtil.copy(existing.getOwnedInit()));
            }
            match.setType(existing.getType());
            target.getRealizedVariable().add(match);

        }
        // References to existing must be fixed
        refinedVars.put(existing, match);
    }

    /**
     * Merge all the domains and patterns from the refined mappings into the
     * refining one.
     * Refined mappings are merged in "complexity" order, applying mappings
     * that refine the more number of mappings (or the less abstract). This
     * follows the idea that more abstract mappings will also use the more
     * abstract types for their variables and hence the merging of variables
     * by keeping the less abstract one works.
     * @param m
     */
    private void mergeRefinements(Mapping m) {
        // Recursively get all the mappings refined, so we only refine them once
        Set<Mapping> refined = getAllRefinements(m);
        List<Mapping> refinedOrdered = new ArrayList<Mapping>(refined);
        Collections.sort(refinedOrdered, new Comparator<Mapping>() {

            @Override
            public int compare(Mapping m1, Mapping m2) {
                final int BEFORE = -1;
                final int EQUAL = 0;
                final int AFTER = 1;

                if (m1 == m2) return EQUAL;

                if (m1.getRefinement().size() < m2.getRefinement().size()) return AFTER;
                if (m1.getRefinement().size() > m2.getRefinement().size()) return BEFORE;

                if (m1.getRefinement().contains(m2)) return BEFORE;
                if (m2.getRefinement().contains(m1)) return AFTER;

                return EQUAL;
            }
        });
        for (Mapping r : refinedOrdered) {
            for (Domain rd : r.getDomain()) {
                mergeDomain(m, rd);
            }
            mergeAreas(m, r);
        }
        // After all has been merged all predicates, assignments and inits must
        // have their references fixed.
        for (Domain d : m.getDomain()) {
        	MtcUtil.fixReferences((Area) d, refinedVars);
        }
        MtcUtil.fixReferences(m, refinedVars);

    }

    /**
     * Merging requires that variables share the name. Variables with the
     * same name should have types in the same hierarchy. The refining variable
     * is assumed to have the less abstract type.
     * @param existing
     * @param guardPattern
     */
    private void mergeVariable(Variable existing, GuardPattern target) {
        // Find a var with the same name
        Variable match = null;
        for (Variable v : target.getVariable()) {
            if (v.getName().equals(existing.getName())) {
                match = v;
                break;
            }
        }
        if (match != null) {
            Class vClass = (Class) existing.getType();
            Class matchClass = (Class)match.getType();
            if (matchClass.getSuperClasses().contains(vClass)) {
                refinedVars.put(existing, match);
            } else if (vClass.getSuperClasses().contains(matchClass)) {
                refinedVars.put(match, existing);
            } else {
                assert (matchClass).equals(vClass);
                refinedVars.put(existing, match);
            }
        } else {
            // We need to copy the variable
            match = PivotFactory.eINSTANCE.createVariable();
            match.setName(existing.getName());
            match.setIsImplicit(existing.isIsImplicit());
            if (match.getOwnedInit() != null) {
                match.setOwnedInit(EcoreUtil.copy(existing.getOwnedInit()));
            }
            match.setType(existing.getType());
            target.getVariable().add(match);
        }
        // REferences to rv must be fixed
        refinedVars.put(existing, match);

    }

    private void moveBottomPattern(BottomPattern source, BottomPattern target) {
        moveCorePattern(source, target);
        ArrayList<@NonNull EObject> temp = new ArrayList<@NonNull EObject>(ClassUtil.nullFree(source.getRealizedVariable()));
        Iterator<@NonNull EObject> it = temp.iterator();
        while (it.hasNext()) {
            EObject n = it.next();
            PivotUtilInternal.resetContainer(n);
            target.getRealizedVariable().add((RealizedVariable) n);
        }
        temp = new ArrayList<@NonNull EObject>(ClassUtil.nullFree(source.getAssignment()));
        it = temp.iterator();
        while (it.hasNext()) {
            EObject n = it.next();
            PivotUtilInternal.resetContainer(n);
            target.getAssignment().add((Assignment) n);
        }
    }

    private void moveCorePattern(CorePattern source, CorePattern target) {
        ArrayList<@NonNull EObject> temp = new ArrayList<@NonNull EObject>(ClassUtil.nullFree(source.getVariable()));
        Iterator<@NonNull EObject> it = temp.iterator();
        while (it.hasNext()) {
            Variable n = (Variable) it.next();
            PivotUtilInternal.resetContainer(n);
            target.getVariable().add(n);
        }
        temp = new ArrayList<@NonNull EObject>(ClassUtil.nullFree(source.getPredicate()));
        it = temp.iterator();
        while (it.hasNext()) {
            EObject p = it.next();
            PivotUtilInternal.resetContainer(p);
            target.getPredicate().add((Predicate) p);
        }
    }

    /**
     * @param source
     * @param target
     */
    private void moveToOtherArea(Area source, Area target) {
        moveCorePattern(source.getGuardPattern(), target.getGuardPattern());
        moveBottomPattern(source.getBottomPattern(), target.getBottomPattern());

    }

    /**
     * @param m
     * @param nd
     */
    private void moveToRootDomain(Mapping m, CoreDomain nd) {
        CoreDomain root_domain = getRootDomain(m, nd);
        assert root_domain != null;
        moveToOtherArea(nd, root_domain);
    }

    private void normalize(Transformation t) {

        // Flatten nested mappings
        for (Rule r : t.getRule()) {
            flaten((Mapping) r);
        }
        // Delete all not needed refined mappings
        Set<Mapping> forDeletion = new HashSet<Mapping>();
        for (Rule r : t.getRule()) {
            if (isNotNeeded((Mapping) r)) {
                forDeletion.add((Mapping) r);
            }

        }
        // Merge refinements, we only merge mappings that are not further refined
        List<Mapping> refining = new ArrayList<Mapping>();
        for (Rule r : t.getRule()) {
            Mapping m = (Mapping) r;
            if (!m.getRefinement().isEmpty() && m.getSpecification().isEmpty())
                refining.add(m);
        }
        // Sort them by # of refinings and if they are refined
        Collections.sort(refining, new Comparator<Mapping>() {

            @Override
            public int compare(Mapping m1, Mapping m2) {
                final int BEFORE = -1;
                final int EQUAL = 0;
                final int AFTER = 1;

                if (m1 == m2) return EQUAL;

                if (m1.getRefinement().size() < m2.getRefinement().size()) return BEFORE;
                if (m1.getRefinement().size() > m2.getRefinement().size()) return AFTER;

                if (m1.getRefinement().contains(m2)) return AFTER;
                if (m2.getRefinement().contains(m1)) return BEFORE;

                return EQUAL;
            }
        });
        for (Mapping m : refining) {
            mergeRefinements(m);
        }
        // Transform variable assignments to init expressions if possible
        for (Mapping m : forDeletion) {
            EcoreUtil.delete(m, true);
        }
        for (Rule r : t.getRule()) {
            for (Domain d : r.getDomain()) {
                reduceVarAssignments((Area) d);
            }
            reduceVarAssignments((Area) r);
        }

    }

    /**
     * Find any variable assignments, and if possible change them to variable
     * initializers.
     * @param r
     */
    private void reduceVarAssignments(Area area) {
        List<@NonNull Variable> move = new ArrayList<@NonNull Variable>();
        for (Variable gv : ClassUtil.nullFree(area.getGuardPattern().getVariable())) {
            if (findAndUseAssignment(gv, area)) {
                // If initialised, move it to the bottom
                move.add(gv);
            }
        }
        for (Variable v : move) {
            PivotUtilInternal.resetContainer(v);
            area.getBottomPattern().getVariable().add(v);
        }
        for (Variable bv : area.getBottomPattern().getVariable()) {
            findAndUseAssignment(bv, area);
        }

    }

}
