/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Horacio Hoyos - initial research
 *     E.D.Willink - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.compiler.internal.etl.mtc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.CompleteModel;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.NullLiteralExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.TracingOption;
import org.eclipse.qvtd.compiler.CompilerConstants;
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
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreDomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtcorebase.Area;
import org.eclipse.qvtd.pivot.qvtcorebase.Assignment;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.CorePattern;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.NavigationAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.OppositePropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.QVTcoreBaseFactory;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcorebase.VariableAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.analysis.DomainUsage;
import org.eclipse.qvtd.pivot.qvtcorebase.analysis.RootDomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtcorebase.utilities.QVTcoreBaseUtil;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;

import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;

/**
 * QVTm2QVTp partitions minimal unidirectional QVTc mappings into multiple mappings each of which can be executed once its predicates
 * are satisfied. Execution once started willnot deadlock.
 */
public class QVTm2QVTp extends AbstractQVTc2QVTc
{
	public static final @NonNull TracingOption PARTITIONING = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtm2qvtp/partitioning");

	/**
	 * The CreateVisitor performs the mostly 1:1 creation of the QVTp output tree from the QVTm input tree.
	 * 
	 * References are left unresolved. OCLExpressions are not copied.
	 */
    protected static abstract class AbstractPartCreateVisitor extends AbstractCreateVisitor<@NonNull QVTm2QVTp>
    {
        /**
         * The mappings using each secondary head type as identity. More than one per type requires a discriminant.
         */
        private final @NonNull Map<@NonNull Type, @NonNull List<@NonNull Partitioning>> secondaryHeadType2partitionings = new HashMap<@NonNull Type, @NonNull List<@NonNull Partitioning>>();

        protected AbstractPartCreateVisitor(@NonNull QVTm2QVTp context) {
			super(context);
		}

		private void addSecondaryHead(@NonNull RealizedVariable secondaryHead, @NonNull Partitioning partitioning) {
			Type secondaryType = secondaryHead.getType();
			assert secondaryType != null;
//			assert !context.getDomainUsageAnalysis().getUsage(secondaryHead).isMiddle();
			List<@NonNull Partitioning> partitionings = secondaryHeadType2partitionings.get(secondaryType);
			if (partitionings == null) {
				partitionings = new ArrayList<@NonNull Partitioning>();
				secondaryHeadType2partitionings.put(secondaryType, partitionings);
			}
			assert !partitionings.contains(partitioning);
			partitionings.add(partitioning);
		}

		private void discriminate(@NonNull List<@NonNull Partitioning> partitionings) throws IOException {
			Map<@NonNull Partitioning, @NonNull Map<@NonNull Property, @Nullable OCLExpression>> partitioning2property2value = new HashMap<@NonNull Partitioning, @NonNull Map<@NonNull Property, @Nullable OCLExpression>>();
			Set<@NonNull Property> commonProperties = null;
			for (@NonNull Partitioning partitioning : partitionings) {
				Map<@NonNull Property, @Nullable OCLExpression> rootPaths = partitioning.getRootPaths();
				if (rootPaths != null) {
					partitioning2property2value.put(partitioning, rootPaths);
					if (commonProperties == null) {
						commonProperties = new HashSet<@NonNull Property>(rootPaths.keySet());
					}
					else {
						commonProperties.retainAll(rootPaths.keySet());
					}
				}
			}
			assert commonProperties != null;
			if (commonProperties.isEmpty()) {
				throw new IOException("No common properties to disambiguate ");
			}
			CompleteModel completeModel = context.getEnvironmentFactory().getCompleteModel();
			List<@NonNull Property> sortedProperties = new ArrayList<@NonNull Property>(commonProperties);
			Collections.sort(sortedProperties, NameUtil.NAMEABLE_COMPARATOR);
			for (@NonNull Property property : sortedProperties) {
				boolean isDiscriminant = true;
				List<@Nullable CompleteClass> valueCompleteClasses = new ArrayList<@Nullable CompleteClass>();
				for (@NonNull Partitioning partitioning : partitionings) {
					Map<@NonNull Property, @Nullable OCLExpression> property2value = partitioning2property2value.get(partitioning);
					assert property2value != null;
					@Nullable Type type = null;
					@Nullable OCLExpression value = property2value.get(property);
					if (value instanceof VariableExp) {
						VariableDeclaration referredVariable = ((VariableExp)value).getReferredVariable();
						assert referredVariable != null;
						type = referredVariable.getType();
					}
					else if ((value != null) && !(value instanceof NullLiteralExp)) {
						type = value.getType();
					}
					@Nullable CompleteClass thisCompleteClass = type != null ? completeModel.getCompleteClass(type) : null;
					for (@Nullable CompleteClass thatCompleteClass : valueCompleteClasses) {
						if (!isDiscriminant(thisCompleteClass, thatCompleteClass)) {
							isDiscriminant = false;
							break;
						}
					}
					valueCompleteClasses.add(thisCompleteClass);
					if (!isDiscriminant) {
						break;
					}
				}
				PARTITIONING.println(valueCompleteClasses.toString());
				if (isDiscriminant) {
					for (@NonNull Partitioning partitioning : partitionings) {
						partitioning.setDiscriminant(property);
					}
					return;
				}
			}
			throw new IOException("Unable to disambiguate ");
		}

		@Override
		protected void doRules(@NonNull Transformation tIn, @NonNull Transformation tOut) {
		    //
		    //	Generate a Mapping per partitioned mapping.
		    //
		    List<@NonNull Partitioning> allPartitionings = new ArrayList<@NonNull Partitioning>();
			for (@NonNull Rule inRule : ClassUtil.nullFree(tIn.getRule())) {
				Mapping mIn = (Mapping) inRule;
				Partitioning partitioning = new Partitioning(this, mIn);
				boolean doDebug = PARTITIONING.isActive();
				StringBuilder s = doDebug ? new StringBuilder() : null;
				try {
					partitioning.analyze(s);
					RealizedVariable secondaryHead = partitioning.getSecondaryHead();
					if (secondaryHead != null) {
						addSecondaryHead(secondaryHead, partitioning);
					}
				}
				finally {
					if (s != null) {
						PARTITIONING.println(s.toString());
					}
				}
				allPartitionings.add(partitioning);
			}
			try {
				for (@NonNull List<@NonNull Partitioning> ambiguousPartitionings : secondaryHeadType2partitionings.values()) {
					if (ambiguousPartitionings.size() > 1) {
						discriminate(ambiguousPartitionings);
					}
				}
			} catch (IOException e) {
				throw new WrappedException(e);
			}
		    //
		    //	Generate a Mapping per partitioned mapping.
		    //
		    List<Rule> outRules = tOut.getRule();
			for (@NonNull Partitioning partitioning : allPartitionings) {
				outRules.addAll(partitioning.synthesize());
			}
		}

		public @NonNull QVTm2QVTp getContext() {
			return context;
		}

		/**
		 * Return true if thisCompleteClass and thatCompleteClass have no mutual conformance and so may be used to discriminate
		 * ambiguous middle types.
		 */
		private boolean isDiscriminant(@Nullable CompleteClass thisCompleteClass, @Nullable CompleteClass thatCompleteClass) {
			if (thisCompleteClass == thatCompleteClass) {
				return false;
			}
			if ((thisCompleteClass == null) || (thatCompleteClass == null)) {
				return true;
			}
			if (thisCompleteClass.conformsTo(thatCompleteClass)) {
				return false;
			}
			if (thatCompleteClass.conformsTo(thisCompleteClass)) {
				return false;
			}
			return true;
		}

		@Override
		public @NonNull BottomPattern visitBottomPattern(@NonNull BottomPattern bIn) {
			BottomPattern bOut = QVTcoreBaseFactory.eINSTANCE.createBottomPattern();
			context.addTrace(bIn, bOut);
			// BottomPattern children are provided in a partitioned-domain-specific fashion by a derived visitMapping.
	        return bOut;
	    }

		@Override
		public @NonNull CoreDomain visitCoreDomain(@NonNull CoreDomain dIn) {
			boolean isEnforceable = context.isEnforceableTransformationWide(dIn);
			assert dIn.isIsEnforceable() == isEnforceable;
			return super.visitCoreDomain(dIn);
		}

		@Override
		public @NonNull CoreModel visitCoreModel(@NonNull CoreModel mIn) {
		    @NonNull CoreModel mOut = super.visitCoreModel(mIn);
		    mOut.setExternalURI(mIn.getExternalURI().replace(".qvtm.qvtc", ".qvtp.qvtc"));
		    return mOut;
		}

		@Override
		public @NonNull GuardPattern visitGuardPattern(@NonNull GuardPattern gIn) {
			GuardPattern gOut = QVTcoreBaseFactory.eINSTANCE.createGuardPattern();
			context.addTrace(gIn, gOut);
			// GuardPattern children are provided in a partitioned-domain-specific fashion by a derived visitMapping.
	        return gOut;
	    }

		@Override
		public abstract @NonNull Mapping visitMapping(@NonNull Mapping mIn);

		@Override
		public @NonNull Transformation visitTransformation(@NonNull Transformation tIn) {
			context.getDomainUsageAnalysis().analyzeTransformation(tIn);
			return super.visitTransformation(tIn);
		}

		@Override
		public @NonNull TypedModel visitTypedModel(@NonNull TypedModel tmIn) {
			@NonNull TypedModel tmOut = super.visitTypedModel(tmIn);
			String name = tmIn.getName();
			if (name == null) {
				name = QVTimperativeUtil.MIDDLE_DOMAIN_NAME;
				tmOut.setName(name);
			}
		    return tmOut;
		}
    }

	/**
	 * The PrimaryPartCreateVisitor creates a primary mapping that services all aspects of the mapping except those secondary PropertyAssignments that
	 * could cause dependency deadlocks which are therefore serviced by secondary mappings. 
	 */
    protected static abstract class AbstractPrimaryCreateVisitor extends AbstractPartCreateVisitor
    {
		public AbstractPrimaryCreateVisitor(@NonNull QVTm2QVTp context) {
			super(context);
		}

		protected void createAllPredicatesOrAssignments(@NonNull Iterable</*@NonNull*/ Assignment> aIns,
				@NonNull List</*@NonNull*/ Predicate> pOuts, @NonNull List</*@NonNull*/ Assignment> aOuts) {
			for (Assignment aIn : aIns) {
				Element eOut = create(aIn);
				if (eOut instanceof Predicate) {
					pOuts.add((Predicate)eOut);
				}
				else if (eOut instanceof Assignment) {
					aOuts.add((Assignment)eOut);
				}
				else {
					assert eOut == null;
				}
			}
		}

		protected void createAllVariables(@NonNull Iterable</*@NonNull*/? extends Variable> vIns,
				@NonNull List</*@NonNull*/ Variable> gvOuts, @NonNull List</*@NonNull*/ Variable> bvOuts) {
			for (Variable vIn : vIns) {
				Variable vOut = create(vIn);
				assert vOut != null;
				if (vIn.getOwnedInit() != null) {
					bvOuts.add(vOut);
				}
				else {
					gvOuts.add(vOut);
				}
			}
		}

		@Override
		public @NonNull Mapping visitMapping(@NonNull Mapping mIn) {
			@NonNull Mapping mOut = QVTcoreFactory.eINSTANCE.createMapping();
			context.pushScope(mOut);
			context.addTrace(mIn, mOut);
	        mOut.setName(mIn.getName());
			mOut.setGuardPattern(create(mIn.getGuardPattern()));
			mOut.setBottomPattern(create(mIn.getBottomPattern()));
			createAll(mIn.getOwnedComments(), mOut.getOwnedComments());
			//
			// Middle domain
			//
			{
				CoreDomain dOut = QVTcoreBaseFactory.eINSTANCE.createCoreDomain();
//				System.out.println("  middle");
				context.addTrace(mIn, dOut);
				dOut.setGuardPattern(create(mIn.getGuardPattern()));
				dOut.setBottomPattern(create(mIn.getBottomPattern()));
				dOut.setIsCheckable(false);
				dOut.setIsEnforceable(true);
				GuardPattern gIn = mIn.getGuardPattern();
				createAll(gIn.getPredicate(), mOut.getGuardPattern().getPredicate());			// Colocate all predicates
				createAll(gIn.getVariable(), dOut.getGuardPattern().getVariable());
				BottomPattern bIn = mIn.getBottomPattern();
				createAllPredicatesOrAssignments(bIn.getAssignment(), mOut.getGuardPattern().getPredicate(), mOut.getBottomPattern().getAssignment());		// Colocate all assignments
				createAll(bIn.getPredicate(), mOut.getBottomPattern().getPredicate());			// Colocate all predicates
//				createAllRealizedVariables(bIn.getRealizedVariable(), dOut.getGuardPattern().getVariable(), dOut.getBottomPattern().getRealizedVariable());
				createAll(bIn.getRealizedVariable(), dOut.getBottomPattern().getRealizedVariable());
				createAllVariables(bIn.getVariable(), mOut.getGuardPattern().getVariable(), mOut.getBottomPattern().getVariable());			// Colocate all bottom variables
				mOut.getDomain().add(dOut);
			}
			//
			// Side domains
			//
			for (Domain d : ClassUtil.nullFree(mIn.getDomain())) {
				CoreDomain dIn = (CoreDomain)d;
				CoreDomain dOut = create(dIn);
				assert dOut != null;
				boolean isEnforceable = context.isEnforceableTransformationWide(d);
//				System.out.println("  " + d + " " + d.isIsEnforceable());
				assert d.isIsEnforceable() == isEnforceable;
				GuardPattern gIn = dIn.getGuardPattern();
				createAll(gIn.getPredicate(), mOut.getGuardPattern().getPredicate());			// Colocate all predicates
				createAll(gIn.getVariable(), dOut.getGuardPattern().getVariable());
				BottomPattern bIn = dIn.getBottomPattern();
				createAllPredicatesOrAssignments(bIn.getAssignment(), mOut.getGuardPattern().getPredicate(), mOut.getBottomPattern().getAssignment());		// Colocate all assignments
				createAll(bIn.getPredicate(), mOut.getGuardPattern().getPredicate());			// Colocate all predicates
				createAll(bIn.getRealizedVariable(), dOut.getBottomPattern().getRealizedVariable());
				createAllVariables(bIn.getVariable(), dOut.getGuardPattern().getVariable(), dOut.getBottomPattern().getVariable());
				mOut.getDomain().add(dOut);
			}
			context.popScope();
			return mOut;
		}
    }

	/**
	 * The SimpleCreateVisitor creates a mapping that services all aspects of the mapping without any recourse to secondaries. 
	 */
    protected static class SimpleCreateVisitor extends AbstractPrimaryCreateVisitor
    {
		public SimpleCreateVisitor(@NonNull QVTm2QVTp context) {
			super(context);
		}
    }

	/**
	 * The PrimaryPartCreateVisitor creates a primary mapping that services all aspects of the mapping except those secondary PropertyAssignments that
	 * could cause dependency deadlocks which are therefore serviced by secondary mappings. 
	 */
    protected static class PrimaryPartCreateVisitor extends AbstractPrimaryCreateVisitor
    {
    	protected final @NonNull List<@NonNull NavigationAssignment> primaryAssignments;

		public PrimaryPartCreateVisitor(@NonNull QVTm2QVTp context, @NonNull List<@NonNull NavigationAssignment> primaryAssignments) {
			super(context);
			this.primaryAssignments = primaryAssignments;
		}

		@Override
		public @Nullable Element visitOppositePropertyAssignment(@NonNull OppositePropertyAssignment paIn) {
			if (primaryAssignments.contains(paIn)) {
				return super.visitOppositePropertyAssignment(paIn);
			}
			else {
				return null;
			}
		}

		@Override
		public @Nullable Element visitPropertyAssignment(@NonNull PropertyAssignment paIn) {
			if (primaryAssignments.contains(paIn)) {
				return super.visitPropertyAssignment(paIn);
			}
			else {
				return null;
			}
		}
    }

	/**
	 * The SecondaryPartCreateVisitor creates a secondary mapping that complements a primary mapping by servicing one or more secondary PropertyAssignments that
	 * could not be performed by the primary without a deadlock hazard.
	 */
    protected static class SecondaryPartCreateVisitor extends AbstractPartCreateVisitor
    {
    	protected final @NonNull String mappingName;

    	/**
    	 * Assignments made by the primary mapping. Need to be converted to predicates in the secondary mapping.
    	 */
    	protected final @NonNull List<@NonNull NavigationAssignment> primaryAssignments;

    	/**
    	 * Assignments to be made by this secondary mapping.
    	 */
    	protected final @NonNull List<@NonNull NavigationAssignment> secondaryAssignments;

    	/**
    	 * The variables required in the guard patterns by the discriminantAssignments.
    	 */
    	protected final @NonNull Set<@NonNull Variable> guardVariables;

    	/**
    	 * The variables required in the bottom patterns by the secondaryAssignments.
    	 */
    	protected final @NonNull Set<@NonNull Variable> bottomVariables;

		public SecondaryPartCreateVisitor(@NonNull QVTm2QVTp context, @NonNull String mappingName, @NonNull RealizedVariable secondaryHead,
				@NonNull List<@NonNull NavigationAssignment> primaryAssignments, @NonNull List<@NonNull NavigationAssignment> discriminantAssignments,
				@NonNull List<@NonNull NavigationAssignment> secondaryAssignments) {
			super(context);
			this.mappingName = mappingName;
			this.primaryAssignments = primaryAssignments;
			this.secondaryAssignments = secondaryAssignments;
			assert primaryAssignments.containsAll(discriminantAssignments);
			assert Sets.intersection(Sets.newHashSet(primaryAssignments), Sets.newHashSet(secondaryAssignments)).isEmpty();
			Set<@NonNull Variable> primaryVariables = computeDirectlyReferencedVariables(primaryAssignments);
			Set<@NonNull Variable> discriminantVariables = computeDirectlyReferencedVariables(discriminantAssignments);
			Set<@NonNull Variable> secondaryVariables = computeDirectlyReferencedVariables(secondaryAssignments);
			discriminantVariables.add(secondaryHead);
			List<@NonNull Variable> indirectlyReferencedVariables = computeIndirectlyReferencedVariables(secondaryVariables, primaryAssignments);
			assert indirectlyReferencedVariables.containsAll(secondaryVariables);
			assert primaryVariables.containsAll(discriminantVariables);
			guardVariables = new HashSet<@NonNull Variable>(primaryVariables);
			guardVariables.retainAll(indirectlyReferencedVariables);
			guardVariables.addAll(discriminantVariables);
			bottomVariables = new HashSet<@NonNull Variable>(secondaryVariables);
			bottomVariables.removeAll(guardVariables);
		}

		protected <T extends Element> @NonNull T create2(@NonNull T source) {
			@SuppressWarnings("unchecked") @Nullable T target = (T) source.accept(this);
			assert target != null;
			return target;
		}

		@Override
		public @NonNull Mapping visitMapping(@NonNull Mapping mIn) {
			Map<@Nullable TypedModel, @NonNull CoreDomain> tmIn2dOut = new HashMap<@Nullable TypedModel, @NonNull CoreDomain>();
			@NonNull Mapping mOut = QVTcoreFactory.eINSTANCE.createMapping();
			context.pushScope(mOut);
			context.addTrace(mIn, mOut);
	        mOut.setName(mappingName);
			mOut.setGuardPattern(create(mIn.getGuardPattern()));
			mOut.setBottomPattern(create(mIn.getBottomPattern()));
			createAll(mIn.getOwnedComments(), mOut.getOwnedComments());
			//
			// Middle domain
			//
			{
				CoreDomain dOut = QVTcoreBaseFactory.eINSTANCE.createCoreDomain();
//				System.out.println("  middle");
				context.addTrace(mIn, dOut);
				GuardPattern gOut = create(mIn.getGuardPattern());
				BottomPattern bOut = create(mIn.getBottomPattern());
				assert (gOut != null) && (bOut != null);
				dOut.setGuardPattern(gOut);
				dOut.setBottomPattern(bOut);
				dOut.setIsCheckable(false);
				dOut.setIsEnforceable(true);
				mOut.getDomain().add(dOut);
				tmIn2dOut.put(null, dOut);
			}
			//
			// Side domains
			//
			for (Domain d : ClassUtil.nullFree(mIn.getDomain())) {
				CoreDomain dIn = (CoreDomain)d;
				CoreDomain dOut = create(dIn);
				assert dOut != null;
				boolean isEnforceable = context.isEnforceableTransformationWide(d);
				assert d.isIsEnforceable() == isEnforceable;
				mOut.getDomain().add(dOut);
				tmIn2dOut.put(dIn.getTypedModel(), dOut);
			}
			//
			//	Create the guard variables
			//
			for (@NonNull Variable vIn : guardVariables) {
				CoreDomain dOut = tmIn2dOut.get(getTypedModel(vIn));
				assert dOut != null;
				Variable vOut = create(vIn);
				dOut.getGuardPattern().getVariable().add(vOut);
			}
			//
			//	Create the bottom variables
			//
			for (@NonNull Variable vIn : bottomVariables) {
				CoreDomain dOut = tmIn2dOut.get(getTypedModel(vIn));
				assert dOut != null;
				Variable vOut = create(vIn);
				dOut.getBottomPattern().getVariable().add(vOut);
			}
			//
			//	Create the guard predicates
			//
			for (@NonNull Assignment aIn : primaryAssignments) {
				if (aIn instanceof NavigationAssignment) {
					Set<@NonNull Variable> usedVariables = new HashSet<@NonNull Variable>();
					NavigationAssignment paIn = (NavigationAssignment) aIn;
					if (paIn.getValue() instanceof VariableExp) {
						computeDirectlyReferencedVariables(paIn, usedVariables);
						if (guardVariables.containsAll(usedVariables)) {
							@NonNull Predicate pOut = QVTbaseFactory.eINSTANCE.createPredicate();
					        context.addTrace(aIn, pOut);
					        // The condition expression is copied during update once replacement variables exist.
							createAll(aIn.getOwnedComments(), pOut.getOwnedComments());
							mOut.getGuardPattern().getPredicate().add(pOut);
						}
					}
				}
			}
			//
			//	Create the bottom assignments
			//
			for (@NonNull NavigationAssignment aIn : secondaryAssignments) {
				mOut.getBottomPattern().getAssignment().add(create2(aIn));
			}
			context.popScope();
			return mOut;
		}

		private @Nullable TypedModel getTypedModel(@NonNull Variable vIn) {
			CoreDomain dIn = (CoreDomain) QVTcoreBaseUtil.getContainingDomain(vIn);
			return dIn != null ? dIn.getTypedModel() : null;
		}

		@Override
		public @Nullable Element visitPredicate(@NonNull Predicate pIn) {
			return null;
		}

		//
		//	The secondary RealizedVariables are converted to Variables
		//
		@Override
		public @NonNull Variable visitRealizedVariable(@NonNull RealizedVariable rvIn) {
			return super.visitVariable(rvIn);
		}
    }
    
    /**
     * The Partitioning breaks the mapping declarations down into a graph of Part to Part relationships.
     */
    protected static interface Part extends Nameable, Comparable<@NonNull Part>
    {
		@Nullable Set<@NonNull Part> analyzeRequiredParts();
		@Override
		@NonNull String getName() ;
    }

    protected static abstract class AbstractPart implements Part
    {
    	protected final @NonNull Partitioning partitioning;
    	
		protected AbstractPart(@NonNull Partitioning partitioning) {
			this.partitioning = partitioning;
			partitioning.addPart(this);
		}

		@Override
		public int compareTo(@NonNull Part o) {
			return getName().compareTo(o.getName());
		}

		@Override
		public @NonNull String toString() {
			return getName();
		}
    }

    protected static abstract class AssignablePart extends AbstractPart
    {
		private @Nullable OCLExpression value = null;

		protected AssignablePart(@NonNull Partitioning partitioning) {
			super(partitioning);
		}

		@Override
		public @Nullable Set<@NonNull Part> analyzeRequiredParts() {
			OCLExpression value2 = value;
			if (value2 == null) {
				return null;
			}
			return partitioning.analyzeRequiredParts(value2);
		}

		public @Nullable OCLExpression getValue() {
			return value;
		}

		public @Nullable VariablePart getVariablePartInitializer() {
			OCLExpression value2 = value;
			if (value2 == null) {
				return null;
			}
			return partitioning.basicGetVariablePart(value2);
		}

		public void setValue(@NonNull OCLExpression value) {
// FIXME			assert this.value == null;
			if (this.value != null) {
				System.err.println("Duplicate assignment to " + this + " '" + this.value + "'/ '" + value + "'");
			}
			this.value = value;
		}

		@Override
		public @NonNull String toString() {
			if (value == null) {
				return super.toString();
			}
			else {
				return super.toString() + " := " + value;
			}
		}
    }

    protected static class ComplexPart extends PropertyAssignablePart
    {
       	protected final @NonNull NavigationAssignment navigationAssignment;

		public ComplexPart(@NonNull Partitioning partitioning, @NonNull NavigationAssignment navigationAssignment) {
			super(partitioning);
			this.navigationAssignment = navigationAssignment;
		}

		@Override
		public @NonNull String getName() {
			return navigationAssignment.getSlotExpression() + "." + QVTcoreBaseUtil.getTargetProperty(navigationAssignment).getName();
		}

		@Override
		public @NonNull NavigationAssignment getNavigationAssignment() {
			return navigationAssignment;
		}
    }

    protected static class PredicatePart extends AbstractPart
    {
		private final @NonNull Predicate predicate;

		public PredicatePart(@NonNull Partitioning partitioning, @NonNull Predicate predicate) {
			super(partitioning);
			this.predicate = predicate;
		}

		@Override
		public @Nullable Set<@NonNull Part> analyzeRequiredParts() {
			return partitioning.analyzeRequiredParts(predicate);
		}

		@Override
		public @NonNull String getName() {
			return String.valueOf(predicate);
		}
    }

    protected static abstract class PropertyAssignablePart extends AssignablePart
    {
		public PropertyAssignablePart(@NonNull Partitioning partitioning) {
			super(partitioning);
		}

		public abstract @Nullable NavigationAssignment getNavigationAssignment();
    }

    /**
     * A PropertyPart captures a dependency on a property access whose source is more complex than
     * a simple navigation from a variable. These are treated as too complex for detailed analysis.
     * 
     * FIXME narrow to known source type.
     */
    protected static class PropertyPart extends AbstractPart
    {
		private final @NonNull Property property;

		public PropertyPart(@NonNull Partitioning partitioning, @NonNull Property property) {
			super(partitioning);
			this.property = property;
		}

		@Override
		public @Nullable Set<@NonNull Part> analyzeRequiredParts() {
			return null;
		}

		@Override
		public @NonNull String getName() {
			return property.getOwningClass().getName() + "::" + property.getName();
		}

		public @NonNull Property getProperty() {
			return property;
		}
    }

    /**
     * A VariablePart describes a guard/bottom/realized variable. There may be an an assignment value. There
     * may be VariablePropertyParts that are navigated from the variable. 
     */
    protected static class VariablePart extends AssignablePart
    {
    	protected final @NonNull Variable variable;
		private @Nullable Map<@NonNull Property, @NonNull VariablePropertyPart> property2part = null;

		public VariablePart(@NonNull Partitioning partitioning, @NonNull Variable variable) {
			super(partitioning);
			this.variable = variable;
			OCLExpression ownedInit = variable.getOwnedInit();
			if (ownedInit != null) {
				setValue(ownedInit);
			}
		}

		public @Nullable VariablePropertyPart basicGetPropertyPart(@NonNull Property property) {
			Map<@NonNull Property, @NonNull VariablePropertyPart> property2part2 = property2part;
			if (property2part2 == null) {
				return null;
			}
			return property2part2.get(property);
		}

		@Override
		public @NonNull String getName() {
			return String.valueOf(variable.getName());
		}

		public @NonNull VariablePropertyPart getPropertyPart(@NonNull Property property) {
			Map<@NonNull Property, @NonNull VariablePropertyPart> property2part2 = property2part;
			if (property2part2 == null) {
				property2part = property2part2 = new HashMap<@NonNull Property, @NonNull VariablePropertyPart>();
			}
			VariablePropertyPart propertyPart = property2part2.get(property);
			if (propertyPart == null) {
				propertyPart = new VariablePropertyPart(partitioning, this, property);
				property2part2.put(property, propertyPart);
			}
			return propertyPart;
		}

		public @NonNull VariablePropertyPart getPropertyPart(@NonNull NavigationAssignment navigationAssignment) {
			Property property = QVTcoreBaseUtil.getTargetProperty(navigationAssignment);
			assert property != null;
			VariablePropertyPart part = getPropertyPart(property);
			part.setNavigationAssignment(navigationAssignment);
			return part;
		}

		public @Nullable Iterable<@NonNull VariablePropertyPart> getPropertyParts() {
			return property2part != null ? property2part.values() : null;
		}

		public @NonNull Variable getVariable() {
			return variable;
		}
    }

    protected static class VariablePropertyPart extends PropertyAssignablePart
    {
    	protected final @NonNull VariablePart variablePart;
		private final @NonNull Property property;
		private @Nullable NavigationAssignment navigationAssignment = null;
		
		public VariablePropertyPart(@NonNull Partitioning partitioning, @NonNull VariablePart variablePart, @NonNull Property property) {
			super(partitioning);
			this.variablePart = variablePart;
			this.property = property;
		}

		@Override
		public @Nullable Set<@NonNull Part> analyzeRequiredParts() {
			Set<@NonNull Part> requiredParts = super.analyzeRequiredParts();
			if (requiredParts == null) {
				requiredParts = new HashSet<@NonNull Part>();
			}
			requiredParts.add(variablePart);
			return requiredParts;
		}

		@Override
		public @NonNull String getName() {
			return variablePart.getName() + "." + property.getName();
		}

		@Override
		public @Nullable NavigationAssignment getNavigationAssignment() {
			return navigationAssignment;
		}

		public void setNavigationAssignment(@NonNull NavigationAssignment navigationAssignment) {
			assert this.navigationAssignment == null : "Duplicate NavigationAssignment";
			this.navigationAssignment = navigationAssignment;
			OCLExpression value = navigationAssignment.getValue();
			assert value != null;
			setValue(value);
		}
    }

    protected static class Partitioning
    {
    	protected final @NonNull AbstractPartCreateVisitor createVisitor;
		protected final @NonNull Mapping mapping;
		private final @NonNull Map<@NonNull Variable, @NonNull VariablePart> variable2part = new HashMap<@NonNull Variable, @NonNull VariablePart>();
		private @Nullable List<@NonNull VariablePart> allBottomVariables = null;
		private @Nullable List<@NonNull VariablePart> allGuardVariables = null;
		private @Nullable List<@NonNull PredicatePart> allPredicates = null;
		private final @NonNull List<@NonNull AssignablePart> allPropertyAssignments = new ArrayList<@NonNull AssignablePart>();
		private final @NonNull List<@NonNull VariablePart> allRealizedVariables = new ArrayList<@NonNull VariablePart>();
		private @Nullable Map<@NonNull Property, @NonNull PropertyPart> allPropertyParts = null;
		private @Nullable List<@NonNull NavigationAssignment> primaryAssignments = null;
		private @Nullable RealizedVariable secondaryHead = null;
		
		/**
		 * The parts that must be available to support evaluation of each part.
		 */
		private final @NonNull Map<@NonNull Part, @Nullable Set<@NonNull Part>> part2requiredParts = new HashMap<@NonNull Part, @Nullable Set<@NonNull Part>>();
		private final @NonNull List<@NonNull Part> allParts = new ArrayList<@NonNull Part>();
		
		private final @NonNull Set<@NonNull Part> partitionedParts = new HashSet<@NonNull Part>();
		private final @NonNull Set<@NonNull Part> remainingParts = new HashSet<@NonNull Part>();
		private @Nullable Map<@NonNull List<@NonNull Part>, @NonNull List<@NonNull Part>> requiredParts2requiringParts = null;
		
		/**
		 * Property access from secondary head used to discriminate ambiguous middle type usage.
		 */
		private @Nullable Property discriminant = null;
		
		public Partitioning(@NonNull AbstractPartCreateVisitor createVisitor, @NonNull Mapping mapping) {
			this.createVisitor = createVisitor;
			this.mapping = mapping;
		}

		private void addAssignments(@NonNull BottomPattern bottomPattern) {
			for (Assignment assignment : ClassUtil.nullFree(bottomPattern.getAssignment())) {
				AssignablePart assignablePart;
				if (assignment instanceof VariableAssignment) {
					assignablePart = addVariableAssignment((VariableAssignment)assignment);
				}
				else {
					assignablePart = addNavigationAssignment((NavigationAssignment)assignment);
				}
				OCLExpression value = assignment.getValue();
				assert value != null;
				assert assignablePart.getValue() == value;
			}
		}

		private void addBottomVariables(@NonNull BottomPattern bottomPattern) {
			List<@NonNull VariablePart> allBottomVariables2 = allBottomVariables;
			for (Variable variable : ClassUtil.nullFree(bottomPattern.getVariable())) {
				VariablePart variablePart = new VariablePart(this, variable);
				if (allBottomVariables2 == null) {
					allBottomVariables = allBottomVariables2 = new ArrayList<@NonNull VariablePart>();
				}
				allBottomVariables2.add(variablePart);
				VariablePart oldVariablePart = variable2part.put(variable, variablePart);
				assert oldVariablePart == null;
			}
		}

		private void addGuardVariables(@NonNull GuardPattern guardPattern) {
			List<@NonNull VariablePart> allGuardVariables2 = allGuardVariables;
			for (Variable variable : ClassUtil.nullFree(guardPattern.getVariable())) {
				VariablePart variablePart = new VariablePart(this, variable);
				if (allGuardVariables2 == null) {
					allGuardVariables = allGuardVariables2 = new ArrayList<@NonNull VariablePart>();
				}
				allGuardVariables2.add(variablePart);
				VariablePart oldVariablePart = variable2part.put(variable, variablePart);
				assert oldVariablePart == null;
			}
		}

		private @NonNull AssignablePart addNavigationAssignment(@NonNull NavigationAssignment navigationAssignment) {
			AssignablePart assignablePart;
			OCLExpression slotExpression = navigationAssignment.getSlotExpression();
			assert slotExpression != null;
			VariablePart variablePart = basicGetVariablePart(slotExpression);
			if (variablePart != null) {
				assignablePart = variablePart.getPropertyPart(navigationAssignment);
			}
			else {
				assignablePart = new ComplexPart(this, navigationAssignment);
			}
			allPropertyAssignments.add(assignablePart);
			return assignablePart;
		}

		private void addPart(@NonNull Part part) {
			assert !part2requiredParts.containsKey(part);
			part2requiredParts.put(part, null);
			allParts.add(part);
		}

		private void addPredicates(@NonNull CorePattern corePattern) {
			List<@NonNull PredicatePart> allPredicates2 = allPredicates;
			for (Predicate predicate : ClassUtil.nullFree(corePattern.getPredicate())) {
				PredicatePart predicatePart = new PredicatePart(this, predicate);
				if (allPredicates2 == null) {
					allPredicates = allPredicates2 = new ArrayList<@NonNull PredicatePart>();
				}
				allPredicates2.add(predicatePart);
			}
		}

		private @NonNull PropertyPart addPropertyPart(@NonNull Property property) {
			Map<@NonNull Property, @NonNull PropertyPart> allPropertyParts2 = allPropertyParts;
			if (allPropertyParts2 == null) {
				allPropertyParts = allPropertyParts2 = new HashMap<@NonNull Property, @NonNull PropertyPart>();
			}
			PropertyPart propertyPart = allPropertyParts2.get(property);
			if (propertyPart == null) {
				propertyPart = new PropertyPart(this, property);
				allPropertyParts2.put(property, propertyPart);
			}
			return propertyPart;
		}

		private void addRealizedVariables(@NonNull BottomPattern bottomPattern) {
			for (RealizedVariable variable : ClassUtil.nullFree(bottomPattern.getRealizedVariable())) {
				VariablePart variablePart = new VariablePart(this, variable);
				allRealizedVariables.add(variablePart);
				VariablePart oldVariablePart = variable2part.put(variable, variablePart);
				assert oldVariablePart == null;
			}
		}

		private @NonNull VariablePart addVariableAssignment(@NonNull VariableAssignment variableAssignment) {
			Variable targetVariable = variableAssignment.getTargetVariable();
			assert targetVariable != null;
			VariablePart variablePart = variable2part.get(targetVariable);
			assert variablePart != null;
			OCLExpression value = variableAssignment.getValue();
			assert value != null;
			variablePart.setValue(value);
			return variablePart;
		}

		public void analyze(@Nullable StringBuilder s) {
			for (@NonNull Domain domain : ClassUtil.nullFree(mapping.getDomain())) {
				analyzeArea((CoreDomain)domain);
			}
			analyzeArea(mapping);
			Collections.sort(allPropertyAssignments);
			Collections.sort(allRealizedVariables);
			for (int i = 0; i < allParts.size(); i++) {			// Avoids CME
				Part part = allParts.get(i);
				part2requiredParts.put(part, part.analyzeRequiredParts());
				remainingParts.add(part);
			}
			Map<@NonNull List<@NonNull Part>, @NonNull List<@NonNull Part>> requiredParts2requiringParts = this.requiredParts2requiringParts = partition(s);
			if ((requiredParts2requiringParts != null) && (requiredParts2requiringParts.size() > 0)) {
				List<@NonNull NavigationAssignment> primaryAssignments2 = primaryAssignments = synthesizeComputePrimaryAssignments(requiredParts2requiringParts);
				secondaryHead = synthesizeComputeSecondaryHead(allRealizedVariables, primaryAssignments2);
				if (secondaryHead == null) {
					secondaryHead = synthesizeComputeSecondaryHead(allRealizedVariables, primaryAssignments2);	// FIXME debugging
				}
			}
		}

		private void analyzeArea(@NonNull Area area) {
			GuardPattern guardPattern = area.getGuardPattern();
			assert guardPattern != null;
			addGuardVariables(guardPattern);
			addPredicates(guardPattern);
			BottomPattern bottomPattern = area.getBottomPattern();
			assert bottomPattern != null;
			addBottomVariables(bottomPattern);
			addPredicates(bottomPattern);
			addRealizedVariables(bottomPattern);
			addAssignments(bottomPattern);
		}

		private @Nullable Part analyzeRequiredPart(@NonNull Element eObject) {
			if (eObject instanceof VariableExp) {
				VariableDeclaration referredVariable = ((VariableExp)eObject).getReferredVariable();
				VariablePart variablePart = variable2part.get(referredVariable);
				if (variablePart != null) {
					return variablePart;
				}
			}
			else if (eObject instanceof NavigationCallExp) {
				NavigationCallExp navigationCallExp = (NavigationCallExp)eObject;
				OCLExpression source = navigationCallExp.getOwnedSource();
				assert source != null;
				DomainUsage usage = createVisitor.getContext().domainAnalysis.getUsage(source);
				if (usage.isInput()) {
					return null;
				}
				Property property = PivotUtil.getReferredProperty(navigationCallExp);
				assert property != null;
				if (source instanceof VariableExp) {
					VariablePart variablePart = basicGetVariablePart(source);
					if (variablePart != null) {
						VariablePropertyPart propertyPart = variablePart.basicGetPropertyPart(property);
						if (propertyPart != null) {
							return propertyPart;
						}
					}
				}
				return addPropertyPart(property);
			}
			return null;
		}

		protected @Nullable Set<@NonNull Part> analyzeRequiredParts(@NonNull Element element) {
			Set<@NonNull Part> requiredParts = null;
			Part requiredPart = analyzeRequiredPart(element);
			if (requiredPart != null) {
				requiredParts = new HashSet<@NonNull Part>();
				requiredParts.add(requiredPart);
			}
			for (TreeIterator<EObject> tit = element.eAllContents(); tit.hasNext(); ) {
				EObject eObject = tit.next();
				if (eObject instanceof Element) {
					requiredPart = analyzeRequiredPart((Element)eObject);
					if (requiredPart != null) {
						if (requiredParts == null) {
							requiredParts = new HashSet<@NonNull Part>();
						}
						requiredParts.add(requiredPart);
					}
				}
			}
			return requiredParts;
		}

/*		private @Nullable AssignablePart basicGetAssignablePart(@NonNull PropertyAssignment propertyAssignment) {
			OCLExpression slotExpression = propertyAssignment.getSlotExpression();
			assert slotExpression != null;
			VariablePart variablePart = basicGetVariablePart(slotExpression);
			if (variablePart != null) {
				Property targetProperty = propertyAssignment.getTargetProperty();
				assert targetProperty != null;
				return variablePart.basicGetPropertyPart(targetProperty);
			}
			else {
				ComplexPart assignablePart = new ComplexPart(this, propertyAssignment);
				allPropertyAssignments.add(assignablePart);
				return assignablePart;
			}
		} */

		private @Nullable VariablePart basicGetVariablePart(@NonNull OCLExpression oclExpression) {
			if (!(oclExpression instanceof VariableExp)) {
				return null;
			}
			VariableDeclaration referredVariable = ((VariableExp)oclExpression).getReferredVariable();
			assert referredVariable != null;
			return variable2part.get(referredVariable);
		}

		public @Nullable Map<@NonNull Property, @Nullable OCLExpression> getRootPaths() {
			Map<@NonNull Property, @Nullable OCLExpression> property2value = null;
			List<@NonNull NavigationAssignment> primaryAssignments2 = primaryAssignments;
			RealizedVariable secondaryHead2 = secondaryHead;
			if ((secondaryHead2 != null) && (primaryAssignments2 != null)) {
				property2value = new HashMap<@NonNull Property, @Nullable OCLExpression>();
				for (@NonNull NavigationAssignment navigationAssignment : primaryAssignments2) {
					Variable leftVariable = getVariable(navigationAssignment.getSlotExpression());
					if (leftVariable == secondaryHead2) {
						Property targetProperty = QVTcoreBaseUtil.getTargetProperty(navigationAssignment);
						assert targetProperty != null;
						property2value.put(targetProperty, navigationAssignment.getValue());
					}
				}
			}
			return property2value;
		}

		public @Nullable RealizedVariable getSecondaryHead() {
			return secondaryHead;
		}

		public @Nullable Map<@NonNull List<@NonNull Part>, @NonNull List<@NonNull Part>> partition(@Nullable StringBuilder s) {
			Collections.sort(allParts);
			if (s != null) {
				s.append(mapping + "\n");
				showAllParts(s);
			}
			partitionGuardVariables(s);
			partitionBottomVariables(s);
			partitionPredicates(s);
			Set<@NonNull VariablePropertyPart> simpleRealizedPropertyParts = partitionSimpleRealizedVariables(s);
			Map<@NonNull Part, @NonNull List<@NonNull Part>> requiredPart2requiringParts = partitionRealizedPropertyParts(simpleRealizedPropertyParts);
			if (requiredPart2requiringParts != null) {
				if (s != null) {
					s.append("  partitioned parts:\n");
					s.append("   ");
					for (Part partitionedPart : partitionedParts) {
						s.append(" " + partitionedPart.getName());
					}
					s.append("\n");
					showRequiredPart2requiringParts(s, requiredPart2requiringParts);
				}
				Map<@NonNull List<@NonNull Part>, @NonNull List<@NonNull Part>> requiredParts2requiringParts = partitionRecurseCommits(requiredPart2requiringParts);
//				while (partitionRecurseCommits(requiredPart2requiringParts)) {
//					if (s != null) {
//						showCommitParts(s, requiredPart2requiringParts);
//					}
//				}
				if (s != null) {
					showRequiredParts2requiringParts(s, requiredParts2requiringParts);
				}
				return requiredParts2requiringParts;
			}
			return null;
		}

		private void partitionBottomVariables(@Nullable StringBuilder s) {
			List<@NonNull VariablePart> allBottomVariables2 = allBottomVariables;
			if (allBottomVariables2 != null) {
				Collections.sort(allBottomVariables2);
				if (s != null) s.append("  bottom variables:");
				for (VariablePart part : allBottomVariables2) {
					if (s != null) s.append(" " + part.getName());
					partitionPart(part);
				}
				if (s != null) s.append("\n");
			}
		}

		private void partitionGuardVariables(@Nullable StringBuilder s) {
			List<@NonNull VariablePart> allGuardVariables2 = allGuardVariables;
			if (allGuardVariables2 != null) {
				Collections.sort(allGuardVariables2);
				if (s != null) s.append("  guard variables:");
				for (VariablePart part : allGuardVariables2) {
					if (s != null) s.append(" " + part.getName());
					partitionPart(part);
				}
				if (s != null) s.append("\n");
			}
		}

		private void partitionPart(@NonNull Part part) {
//			Set<@NonNull Part> dependsOns = part2requiredParts.get(part);
//			if (dependsOns != null) {
//				for (Part dependsOn : dependsOns) {
//					assert partitionedParts.contains(dependsOn);
//				}
//			}
			partitionedParts.add(part);
			remainingParts.remove(part);
		}

		private void partitionPredicates(@Nullable StringBuilder s) {
			List<@NonNull PredicatePart> allPredicates2 = allPredicates;
			if (allPredicates2 == null) {
				return;
			}
			Collections.sort(allPredicates2);
			Set<@NonNull Part> predicateDependencies = null;
			for (PredicatePart predicatePart : allPredicates2) {
				Set<@NonNull Part> parts = part2requiredParts.get(predicatePart);
				if (parts != null) {
					for (Part part : parts) {
						if (!partitionedParts.contains(part)) {
							if (predicateDependencies == null) {
								predicateDependencies = new HashSet<@NonNull Part>();
							}
							predicateDependencies.add(part);
						}
					}
				}
			}
			//
			if (predicateDependencies != null) {
				if (s != null) s.append("  predicate dependencies:");
				List<@NonNull Part> predicateDependenciesList = new ArrayList<@NonNull Part>(predicateDependencies);
				Collections.sort(predicateDependenciesList);
				for (Part part : predicateDependenciesList) {
					if (s != null) s.append(" " + part.getName());
					partitionPart(part);
				}
				if (s != null) s.append("\n");
			}
			//
			if (s != null) s.append("  predicates:\n");
			for (PredicatePart part : allPredicates2) {
				if (s != null) s.append("    " + part.getName() + "\n");
				partitionPart(part);
			}
		}

		private @Nullable Map<@NonNull Part, @NonNull List<@NonNull Part>> partitionRealizedPropertyParts(@Nullable Set<@NonNull VariablePropertyPart> realizedPropertyParts) {
			Set<@NonNull Part> checkParts = part2requiredParts.keySet();
			assert partitionedParts.size() + remainingParts.size() == allParts.size();
			assert checkParts.equals(new HashSet<@NonNull Part>(allParts));
			assert checkParts.containsAll(partitionedParts);
			assert checkParts.containsAll(remainingParts);
			Map<@NonNull Part, @NonNull List<@NonNull Part>> requiredPart2requiringParts = new HashMap<@NonNull Part, @NonNull List<@NonNull Part>>();
//			dependentParts2commitParts.put(Collections.emptySet(), new ArrayList<@NonNull Part>(partitionedParts));
			for (Part remainingPart : remainingParts) {
				Set<@NonNull Part> requiredParts = part2requiredParts.get(remainingPart);
				if (requiredParts != null) {
					for (Part requiredPart : requiredParts) {
						if (!partitionedParts.contains(requiredPart)) {
							List<@NonNull Part> requiringParts = requiredPart2requiringParts.get(requiredPart);
							if (requiringParts == null) {
								requiringParts = new ArrayList<@NonNull Part>();
								requiredPart2requiringParts.put(requiredPart, requiringParts);
							}
							assert !requiringParts.contains(remainingPart);
							requiringParts.add(remainingPart);
						}
					}
//					requiredParts.removeAll(partitionedParts);
//					List<@NonNull Part> requiringParts = requiredParts2requiringParts.get(requiredParts);
//					if (requiringParts == null) {
//						requiringParts = new ArrayList<@NonNull Part>();
//						requiredParts2requiringParts.put(requiredParts, requiringParts);
//					}
//					requiringParts.add(remainingPart);
				}
			}
/*			if (realizedPropertyParts != null) {
				Set<@NonNull Part> noRequiredParts = Collections.emptySet();
				List<@NonNull Part> requiringParts = requiredParts2requiringParts.get(noRequiredParts);
				if (requiringParts == null) {				// Can be null for trivial 
					requiringParts = new ArrayList<@NonNull Part>();
					requiredParts2requiringParts.put(noRequiredParts, requiringParts);
				}
				for (VariablePropertyPart realizedPropertyPart : realizedPropertyParts) {
					if (!requiringParts.contains(realizedPropertyPart)) {
						requiringParts.add(realizedPropertyPart);
					}
				}
//				}
//				else {
//					assert remainingParts.isEmpty();
//				}
			} */
			return requiredPart2requiringParts;
		}

		private @NonNull Map<@NonNull List<@NonNull Part>, @NonNull List<@NonNull Part>> partitionRecurseCommits(@NonNull Map<@NonNull Part, @NonNull List<@NonNull Part>> requiredPart2requiringParts) {
//			List<@NonNull Part> readyCommitParts = requiredParts2requiringParts.get(Collections.emptySet());
//			if (readyCommitParts == null) {
//				return false;
//			}
			List<@NonNull Part> requiredPartsRequiredOnlyOnce = null;
			for (Part requiredPart : requiredPart2requiringParts.keySet()) {
				List<@NonNull Part> requiringParts = requiredPart2requiringParts.get(requiredPart);
				assert requiringParts != null;
				if ((requiringParts.size() == 1) && (requiredPart2requiringParts.get(requiringParts.get(0)) != null)) {
					if (requiredPartsRequiredOnlyOnce == null) {
						requiredPartsRequiredOnlyOnce = new ArrayList<@NonNull Part>();
					}
					requiredPartsRequiredOnlyOnce.add(requiredPart);
				}
/*				Set<@NonNull Part> newRequiredParts = new HashSet<@NonNull Part>(oldRequiredParts);
				if (newRequiredParts.removeAll(readyCommitParts)) {
					gotOne = true;
					List<@NonNull Part> oldCommitsList = requiredParts2requiringParts.remove(oldRequiredParts);
					assert oldCommitsList != null;
					List<@NonNull Part> newCommitsList = requiredParts2requiringParts.get(newRequiredParts);
					if (newCommitsList == null) {
						newCommitsList = new ArrayList<@NonNull Part>();
						requiredParts2requiringParts.put(newRequiredParts, newCommitsList);
					}
					for (Part oldCommit : oldCommitsList) {
						if (!newCommitsList.contains(oldCommit)) {
							newCommitsList.add(oldCommit);
						}
					}
				} */
			}
			@NonNull Map<@NonNull List<@NonNull Part>, @NonNull List<@NonNull Part>> requiredParts2requiringParts = new HashMap<@NonNull List<@NonNull Part>, @NonNull List<@NonNull Part>>();
			if (requiredPartsRequiredOnlyOnce != null) {
				for (Part requiredPart : requiredPartsRequiredOnlyOnce) {
					List<@NonNull Part> requiringParts = requiredPart2requiringParts.remove(requiredPart);
					assert (requiringParts != null) && (requiringParts.size() == 1);
					Part requiringPart = requiringParts.get(0);
					List<@NonNull Part> requiringRequiringParts = requiredPart2requiringParts.remove(requiringPart);
					if (requiringRequiringParts != null) {
						ArrayList<@NonNull Part> mergedRequiredParts = new ArrayList<@NonNull Part>();
						mergedRequiredParts.add(requiredPart);
						mergedRequiredParts.add(requiringPart);
						ArrayList<@NonNull Part> mergedRequiringParts = new ArrayList<@NonNull Part>(requiringRequiringParts);
						mergedRequiringParts.add(requiringPart);
						requiredParts2requiringParts.put(mergedRequiredParts, mergedRequiringParts);
					}
				}
			}
			for (Part requiredPart : requiredPart2requiringParts.keySet()) {
				List<@NonNull Part> requiringParts = requiredPart2requiringParts.get(requiredPart);
				assert requiringParts != null;
				requiredParts2requiringParts.put(Collections.singletonList(requiredPart), requiringParts);
			}
			return requiredParts2requiringParts;
		}

		private @Nullable Set<@NonNull VariablePropertyPart> partitionSimpleRealizedVariables(@Nullable StringBuilder s) {
			Set<@NonNull VariablePropertyPart> realizedPropertyParts = null;
			if (s != null) s.append("  realized variables:");
			for (VariablePart part : allRealizedVariables) {
				if (s != null) s.append(" " + part.getName());
				partitionPart(part);
				Iterable<@NonNull VariablePropertyPart> propertyParts = part.getPropertyParts();
				if (propertyParts != null) {
					for (VariablePropertyPart propertyPart : propertyParts) {
						VariablePart variablePart = propertyPart.getVariablePartInitializer();
//						if ((variablePart != null) && partitionedParts.contains(variablePart)) {
						if (variablePart != null) {			// Property assignments with nasty dependencies must wait till later
							if (realizedPropertyParts == null) {
								realizedPropertyParts = new HashSet<@NonNull VariablePropertyPart>();
							}
							realizedPropertyParts.add(propertyPart);
						}
					}
				}
			}
			if (s != null) s.append("\n");
			if (realizedPropertyParts != null) {
				if (s != null) s.append("  realized variable initializers:");
				for (VariablePropertyPart part : realizedPropertyParts) {
					if (s != null) s.append(" " + part.getName());
					partitionPart(part);
				}
				if (s != null) s.append("\n");
			}
			return realizedPropertyParts;
		}

		public void setDiscriminant(@NonNull Property property) {
			assert discriminant == null;
			this.discriminant = property;
		}

		private void showAllParts(@NonNull StringBuilder s) {
			for (Part part : allParts) {
				if (s != null) s.append("    " + part + " : {");
				Set<@NonNull Part> parts = part2requiredParts.get(part);
				if (parts != null) {
					List<@NonNull Part> sortedDependentParts = new ArrayList<@NonNull Part>(parts);
					Collections.sort(sortedDependentParts);
					for (Part dependentPart : sortedDependentParts) {
						if (s != null) s.append(" " + dependentPart.getName());
						assert part2requiredParts.containsKey(dependentPart);
					}
				}
				if (s != null) s.append(" }\n");
			}
		}

		private void showRequiredPart2requiringParts(@NonNull StringBuilder s, @NonNull Map<@NonNull Part, @NonNull List<@NonNull Part>> requiredPart2requiringParts) {
			s.append("  required part => requiring parts:\n");
			for (Part requiredPart : requiredPart2requiringParts.keySet()) {
				s.append("    ");
				s.append(requiredPart.getName());
				s.append(" => {");
				List<@NonNull Part> requiringParts = requiredPart2requiringParts.get(requiredPart);
				assert requiringParts != null;
				Collections.sort(requiringParts);
				for (Part requiringPart : requiringParts) {
					s.append(" " + requiringPart.getName());
				}
				s.append(" }\n");
			}
		}

		private void showRequiredParts2requiringParts(@NonNull StringBuilder s, @NonNull Map<@NonNull List<@NonNull Part>, @NonNull List<@NonNull Part>> requiredParts2requiringParts) {
			s.append("  required part => requiring parts:\n");
			for (List<@NonNull Part> requiredParts : requiredParts2requiringParts.keySet()) {
				s.append("    {");
				for (Part requiredPart : requiredParts) {
					s.append(" " + requiredPart.getName());
				}
				s.append(" } => {");
				List<@NonNull Part> requiringParts = requiredParts2requiringParts.get(requiredParts);
				assert requiringParts != null;
				Collections.sort(requiringParts);
				for (Part requiringPart : requiringParts) {
					s.append(" " + requiringPart.getName());
				}
				s.append(" }\n");
			}
		}

		public @NonNull List<@NonNull Mapping> synthesize() {
			@SuppressWarnings("unused")String name = mapping.getName();
			Map<@NonNull List<@NonNull Part>, @NonNull List<@NonNull Part>> requiredParts2requiringParts2 = requiredParts2requiringParts;
			if ((requiredParts2requiringParts2 == null) || (requiredParts2requiringParts2.size() <= 0)) {
				Mapping mOut = createVisitor.create(mapping);
				assert mOut != null;
				return Collections.singletonList(mOut);
			}
			else {
				List<@NonNull Mapping> mOuts = new ArrayList<@NonNull Mapping>();
				List<@NonNull NavigationAssignment> primaryAssignments2 = primaryAssignments;
				RealizedVariable secondaryHead2 = secondaryHead;
				assert primaryAssignments2 != null;// && (secondaryHead2 != null);
				Map<@NonNull List<@NonNull Part>, @NonNull String> dependentParts2mappingName = synthesizeComputeMappingNames(requiredParts2requiringParts2);
				QVTm2QVTp context = createVisitor.getContext();
				AbstractPartCreateVisitor refinedCreateVisitor = new PrimaryPartCreateVisitor(context, primaryAssignments2);
				Mapping mOut = refinedCreateVisitor.create(mapping);
				assert mOut != null;
				mOuts.add(mOut);
				NavigationAssignment discriminantAssignment = null;
				if (discriminant != null) {
					for (NavigationAssignment primaryAssignment : primaryAssignments2) {
						if (QVTcoreBaseUtil.getTargetProperty(primaryAssignment) == discriminant) {
							Variable slotVariable = getVariable(primaryAssignment.getSlotExpression());
							if (slotVariable == secondaryHead2) {
								discriminantAssignment = primaryAssignment;
//								primaryAssignments2.remove(discriminantAssignment);
								break;
							}
						}
					}
				}
				List<@NonNull List<@NonNull Part>> requiredPartsList = new ArrayList<@NonNull List<@NonNull Part>>(requiredParts2requiringParts2.keySet());
				Collections.sort(requiredPartsList, new Comparator<@NonNull List<@NonNull Part>>() {
					@Override
					public int compare(@NonNull List<@NonNull Part> o1, @NonNull List<@NonNull Part> o2) {
						String n1 = dependentParts2mappingName.get(o1);
						String n2 = dependentParts2mappingName.get(o2);
						return ClassUtil.safeCompareTo(n1, n2);
					}
				});
				Set<@NonNull Part> resolvedRequiringParts = new HashSet<@NonNull Part>();
				for (@NonNull List<@NonNull Part> dependentParts : requiredPartsList) {
					List<@NonNull Part> requiringParts = requiredParts2requiringParts2.get(dependentParts);
					assert requiringParts != null;
					requiringParts = new ArrayList<@NonNull Part>(requiringParts);
					requiringParts.removeAll(resolvedRequiringParts);
					if (requiringParts.size() > 0) {
						List<@NonNull NavigationAssignment> secondaryAssignments = synthesizeComputeSecondaryAssignments(requiringParts);
						String mappingName = dependentParts2mappingName.get(dependentParts);
						assert mappingName != null;
						assert (secondaryHead2 !=  null);// {
							refinedCreateVisitor = new SecondaryPartCreateVisitor(context, mappingName, secondaryHead2, primaryAssignments2,
								discriminantAssignment != null ? Collections.singletonList(discriminantAssignment) : Collections.emptyList(), secondaryAssignments);
	//					}
	//					else {
	//						refinedCreateVisitor = new FoldedSecondaryCreateVisitor(context, mappingName, secondaryAssignments);
	//					}
						mOut = refinedCreateVisitor.create(mapping);
						assert mOut != null;
						mOuts.add(mOut);
						resolvedRequiringParts.addAll(requiringParts);
					}
				}
				return mOuts;
			}
		}

		/**
		 * Return the RealizedVariable that will be the sole head of all secondary mappings.
		 * It is a RealizedVariable from which all other RealizedVariables are reachable by primaryAssignments.
		 * 
		 * FIXME This implementation requires directly rather than transitively reachable.
		 */
		private @Nullable RealizedVariable synthesizeComputeSecondaryHead(@NonNull List<@NonNull VariablePart> allRealizedVariables,
				@NonNull List<@NonNull NavigationAssignment> primaryAssignments) {
			RealizedVariable bestRealizedVariable = null;
			int bestRealizedVariableCount = 0;
//			Map<@NonNull RealizedVariable, @Nullable List<@NonNull RealizedVariable>> source2targets = new HashMap<@NonNull RealizedVariable, @Nullable List<@NonNull RealizedVariable>>();
			for (@NonNull VariablePart realizedVariablePart : allRealizedVariables) {
				RealizedVariable realizedVariable = (RealizedVariable) realizedVariablePart.getVariable();
				DomainUsage usage = createVisitor.getContext().getDomainUsageAnalysis().getUsage(realizedVariable);
				if (usage.isMiddle()) {
					int realizedVariableCount = 0;
					@NonNull Iterable<@NonNull Variable> definedVariables = computeIndirectlyDefinedVariables(Collections.singletonList(realizedVariable), primaryAssignments);
					for (@NonNull Variable definedVariable : definedVariables) {
						if (definedVariable instanceof RealizedVariable) {
							realizedVariableCount++;
						}
					}
					if ((bestRealizedVariable == null) || (realizedVariableCount >= bestRealizedVariableCount)) {
						bestRealizedVariable = realizedVariable;
						bestRealizedVariableCount = realizedVariableCount;
					}
//					source2targets.put(realizedVariable, null);
				}
			}
			if (bestRealizedVariable == null) {
				for (@NonNull VariablePart realizedVariablePart : allRealizedVariables) {
					RealizedVariable realizedVariable = (RealizedVariable) realizedVariablePart.getVariable();
					DomainUsage usage = createVisitor.getContext().getDomainUsageAnalysis().getUsage(realizedVariable);
					if (usage.isOutput()) {
						int realizedVariableCount = 0;
						@NonNull Iterable<@NonNull Variable> definedVariables = computeIndirectlyDefinedVariables(Collections.singletonList(realizedVariable), primaryAssignments);
						for (@NonNull Variable definedVariable : definedVariables) {
							if (definedVariable instanceof RealizedVariable) {
								realizedVariableCount++;
							}
						}
						if ((bestRealizedVariable == null) || (realizedVariableCount >= bestRealizedVariableCount)) {
							bestRealizedVariable = realizedVariable;
							bestRealizedVariableCount = realizedVariableCount;
						}
//						source2targets.put(realizedVariable, null);
					}
				}
			}
/*			for (@NonNull PropertyAssignment primaryAssignment : primaryAssignments) {
				Variable slotVariable = getVariable(primaryAssignment.getSlotExpression());
				if ((slotVariable != null) && source2targets.containsKey(slotVariable)) {
					Variable valueVariable = getVariable(primaryAssignment.getValue());
					if ((valueVariable != null) && source2targets.containsKey(valueVariable)) {
						List<@NonNull RealizedVariable> targets = source2targets.get(slotVariable);
						if (targets == null) {
							targets = new ArrayList<@NonNull RealizedVariable>();
							source2targets.put((RealizedVariable)slotVariable, targets);
						}
						if (!targets.contains(valueVariable)) {
							targets.add((RealizedVariable)valueVariable);
						}
					}
				}
			} */
/*			Set<@NonNull RealizedVariable> sourceVariables = source2targets.keySet();
			int sourceVariablesSizeMinusOne = sourceVariables.size() - 1;
			assert sourceVariablesSizeMinusOne >= 0;
			for (@NonNull RealizedVariable sourceVariable : sourceVariables) {
				List<@NonNull RealizedVariable> targets = source2targets.get(sourceVariable);
				if ((targets != null) && (targets.size() >= sourceVariablesSizeMinusOne)) {
					bestRealizedVariable = sourceVariable;
				}
			} */
			return bestRealizedVariable;
		}

		private @NonNull Map<@NonNull List<@NonNull Part>, @NonNull String> synthesizeComputeMappingNames(@NonNull Map<@NonNull List<@NonNull Part>, @NonNull List<@NonNull Part>> dependentParts2commitParts) {
			Map<@NonNull List<@NonNull Part>, @NonNull String> dependentParts2mappingNames = new HashMap<@NonNull List<@NonNull Part>, @NonNull String>();
			int i = 0;
			Map<@NonNull String, @NonNull List<@NonNull Part>> key2dependentParts = new HashMap<@NonNull String, @NonNull List<@NonNull Part>>();
			for (List<@NonNull Part> dependentParts : dependentParts2commitParts.keySet()) {
//				assert dependentParts !
				StringBuilder s = new StringBuilder();
				for (@NonNull Part dependentPart : dependentParts) {
					s.append("_");
					s.append(dependentPart.getName());
				}
				key2dependentParts.put(s.toString(), dependentParts);
			}
			List<@NonNull String> sortedKeys = new ArrayList<@NonNull String>(key2dependentParts.keySet());
			Collections.sort(sortedKeys);
			for (@NonNull String key : sortedKeys) {
				List<@NonNull Part> dependentParts = key2dependentParts.get(key);
				assert dependentParts != null;
				String name = mapping.getName() + i++;				// FIXME More readable name
				dependentParts2mappingNames.put(dependentParts, name);
			}
			return dependentParts2mappingNames;
		}

		private @NonNull List<@NonNull NavigationAssignment> synthesizeComputePrimaryAssignments(@NonNull Map<@NonNull List<@NonNull Part>, @NonNull List<@NonNull Part>> requiredParts2requiringParts) {
			List<@NonNull NavigationAssignment> primaryAssignments = new ArrayList<@NonNull NavigationAssignment>();
			for (@NonNull AssignablePart part : allPropertyAssignments) {
				if (part instanceof PropertyAssignablePart) {
					NavigationAssignment navigationAssignment = ((PropertyAssignablePart)part).getNavigationAssignment();
					if (navigationAssignment != null) {
						primaryAssignments.add(navigationAssignment);
					}
				}
			}
//			List<@NonNull Part> primaryCommits = dependentParts2commitParts.get(Collections.emptySet());
//			assert primaryCommits != null;
/*			for (Part primaryCommit : partitionedParts) {
				if (primaryCommit instanceof PropertyAssignablePart) {
					PropertyAssignment propertyAssignment = ((PropertyAssignablePart)primaryCommit).getPropertyAssignment();
					if (propertyAssignment != null) {
						primaryAssignments.add(propertyAssignment);
					}
				}
			} */
			for (@NonNull List<@NonNull Part> requiringParts : requiredParts2requiringParts.values()) {
				for (@NonNull Part requiringPart : requiringParts) {
					if (requiringPart instanceof PropertyAssignablePart) {
						NavigationAssignment navigationAssignment = ((PropertyAssignablePart)requiringPart).getNavigationAssignment();
						if (navigationAssignment != null) {
							primaryAssignments.remove(navigationAssignment);
						}
					}
				}
			}
			return primaryAssignments;
		}

		private @NonNull List<@NonNull NavigationAssignment> synthesizeComputeSecondaryAssignments(@NonNull List<@NonNull Part> commitParts) {
			List<@NonNull NavigationAssignment> secondaryAssignments = new ArrayList<@NonNull NavigationAssignment>();
			for (@NonNull Part secondaryCommit : commitParts) {
				if (secondaryCommit instanceof PropertyAssignablePart) {
					NavigationAssignment propertyAssignment = ((PropertyAssignablePart)secondaryCommit).getNavigationAssignment();
					if (propertyAssignment != null) {
						secondaryAssignments.add(propertyAssignment);
					}
				}
			}
			return secondaryAssignments;
		}

		@Override
		public String toString() {
			return mapping.toString();
		}
    }

	/**
	 * The UpdateVisitor resolves the references and creates the OCLExpressions omitted by the CreateVisitor..
	 */
    protected static class UpdateVisitor extends AbstractUpdateVisitor<@NonNull QVTm2QVTp>
    {
		public UpdateVisitor(@NonNull QVTm2QVTp context) {
			super(context);
		}

		@Override
		public @Nullable Object visitCoreModel(@NonNull CoreModel mOut) {
//			context.discriminate();
			return super.visitCoreModel(mOut);
		}
	}

    /**
     * Return all variables directly referenced by any of propertyAssignments.
     */
	private static @NonNull Set<@NonNull Variable> computeDirectlyReferencedVariables(@NonNull List<@NonNull NavigationAssignment> navigationAssignments) {
		Set<@NonNull Variable> usedVariables = new HashSet<@NonNull Variable>();
		for (NavigationAssignment navigationAssignment : navigationAssignments) {
			computeDirectlyReferencedVariables(navigationAssignment, usedVariables);
		}
		return usedVariables;
	}

	private static void computeDirectlyReferencedVariables(@NonNull NavigationAssignment navigationAssignment, @NonNull Set<@NonNull Variable> usedVariables) {
		for (TreeIterator<EObject> tit = navigationAssignment.eAllContents(); tit.hasNext(); ) {
			EObject eObject = tit.next();
			if (eObject instanceof VariableExp) {
				VariableDeclaration referredVariable = ((VariableExp)eObject).getReferredVariable();
				if ((referredVariable instanceof Variable) && !(referredVariable.eContainer() instanceof Transformation)) {
					usedVariables.add((Variable)referredVariable);
				}
			}
		}
	}

	/**
     * Return all variables indirectly defined byVariables using propertyAssignments. i.e. if A is defined in A.b := C, C is defined too.
     */
	private static @NonNull Iterable<@NonNull Variable> computeIndirectlyDefinedVariables(@NonNull Iterable<@NonNull Variable> byVariables, @NonNull List<@NonNull NavigationAssignment> navigationAssignments) {
		List<@NonNull Variable> variablesList = new ArrayList<@NonNull Variable>();
		Iterables.addAll(variablesList, byVariables);
		for (int i = 0; i < variablesList.size(); i++) {
			Variable usedVariable = variablesList.get(i);
			for (@NonNull NavigationAssignment navigationAssignment : navigationAssignments) {
				Variable rightVariable = getVariable(navigationAssignment.getValue());
				Variable leftVariable = getVariable(navigationAssignment.getSlotExpression());
				if ((leftVariable == usedVariable) && (rightVariable != null)) {
					if (!variablesList.contains(rightVariable)) {
						variablesList.add(rightVariable);
					}
				}
			}
		}
		return variablesList;
	}

    /**
     * Return all variables indirectly referenced byVariables using propertyAssignments. i.e. if C is referenced in A.b := C, A is referenced too.
     */
	private static @NonNull List<@NonNull Variable> computeIndirectlyReferencedVariables(@NonNull Iterable<@NonNull Variable> byVariables, @NonNull List<@NonNull NavigationAssignment> navigationAssignments) {
		List<@NonNull Variable> variablesList = new ArrayList<@NonNull Variable>();
		Iterables.addAll(variablesList, byVariables);
		for (int i = 0; i < variablesList.size(); i++) {
			Variable usedVariable = variablesList.get(i);
			for (NavigationAssignment navigationAssignment : navigationAssignments) {
				Variable rightVariable = getVariable(navigationAssignment.getValue());
				Variable leftVariable = getVariable(navigationAssignment.getSlotExpression());
				if ((rightVariable == usedVariable) && (leftVariable != null)) {
					if (!variablesList.contains(leftVariable)) {
						variablesList.add(leftVariable);
					}
				}
			}
		}
		return variablesList;
	}

	/**
	 * Return the non-null referred Variable if anExpression is a VariableExp.
	 */
	private static @Nullable Variable getVariable(@Nullable OCLExpression anExpression) {
		if (!(anExpression instanceof VariableExp)) {
			return null;
		}
		VariableDeclaration referredVariable = ((VariableExp)anExpression).getReferredVariable();
		if (!(referredVariable instanceof Variable)) {
			return null;
		}
		return (@Nullable Variable) referredVariable;
	}

	protected final @NonNull RootDomainUsageAnalysis domainAnalysis;

    /**
     * Set of all TypedModels that are enforceable for all domains in each trasformation. 
     */
    private final @NonNull Map<@NonNull Transformation, @NonNull Set<@NonNull TypedModel>> transformation2enforceableTypedModels = new HashMap<@NonNull Transformation, @NonNull Set<@NonNull TypedModel>>();

    /**
     * Create a new QVTm to QVTp transformation using an environmentFactory.
     *
     * It may be used once by invoking transform(). Repeated transform() calls are beyond the current design.
     */
    public QVTm2QVTp(@NonNull EnvironmentFactory environmentFactory) {
        super(environmentFactory);
		this.domainAnalysis = new QVTcoreDomainUsageAnalysis(environmentFactory);
	}
	
	@Override
	protected @NonNull AbstractPartCreateVisitor createCreateVisitor() {
		return new SimpleCreateVisitor(this);
	}

	@Override
	protected @NonNull UpdateVisitor createUpdateVisitor() {
		return new UpdateVisitor(this);
	}

	private @NonNull RootDomainUsageAnalysis getDomainUsageAnalysis() {
		return domainAnalysis;
	}

	private boolean isEnforceableTransformationWide(@NonNull Domain domain) {
		Transformation transformation = QVTbaseUtil.getContainingTransformation(domain);
		assert transformation != null;
		Set<@NonNull TypedModel> enforceableTypedModels = transformation2enforceableTypedModels.get(transformation);
		if (enforceableTypedModels == null) {
			enforceableTypedModels = QVTbaseUtil.getEnforceableTypedModels(transformation);
			transformation2enforceableTypedModels.put(transformation, enforceableTypedModels);
		}
		TypedModel typedModel = domain.getTypedModel();
		return enforceableTypedModels.contains(typedModel);
	}
}
