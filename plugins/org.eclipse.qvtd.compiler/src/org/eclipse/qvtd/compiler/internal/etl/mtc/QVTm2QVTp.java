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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.Nameable;
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
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.QVTcoreBaseFactory;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcorebase.VariableAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.analysis.RootDomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;

/**
 * The Class QVTmToQVTip.
 */
public class QVTm2QVTp extends AbstractQVTc2QVTc
{
	/**
	 * The CreateVisitor performs the mostly 1:1 creation of the QVTp output tree from the QVTm input tree.
	 * 
	 * References are left unresolved. OCLExpressions are not copied.
	 */
    protected static class CreateVisitor extends AbstractCreateVisitor<@NonNull QVTm2QVTp>
    {
		public CreateVisitor(@NonNull QVTm2QVTp context) {
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

		protected void createAllRealizedVariables(@NonNull Iterable</*@NonNull*/ RealizedVariable> rvIns,
				@NonNull List</*@NonNull*/ Variable> vOuts, @NonNull List</*@NonNull*/ RealizedVariable> rvOuts) {
			for (RealizedVariable rvIn : rvIns) {
				Element eOut = create(rvIn);
				if (eOut instanceof RealizedVariable) {
					rvOuts.add((RealizedVariable)eOut);
				}
				else if (eOut instanceof Variable) {
					vOuts.add((Variable)eOut);
				}
				else {
					assert eOut == null;
				}
			}
		}

		protected void createAllVariables(@NonNull Iterable</*@NonNull*/ Variable> vIns,
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
		protected void doRules(@NonNull Transformation tIn, @NonNull Transformation tOut) {
		    List<Rule> outRules = tOut.getRule();
		    //
		    //	Generate a Mapping per partitioned mapping.
		    //
			for (@SuppressWarnings("null")@NonNull Rule inRule : tIn.getRule()) {
				Mapping mIn = (Mapping) inRule;
				Partitioning mappingPartitioning = new Partitioning(this, mIn);
				mappingPartitioning.analyze();
				StringBuilder s = new StringBuilder();
				outRules.addAll(mappingPartitioning.synthesize(s));
				System.out.println(s.toString());
			}
		}

		public @NonNull QVTm2QVTp getContext() {
			return context;
		}

		protected String getMappingName(@NonNull Mapping mIn) {
			return mIn.getName();
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

/*		@Override
		public @Nullable Element visitMapping(@NonNull Mapping mIn) {
			Partitioning mappingPartitioning = new Partitioning(thismIn);
			mappingPartitioning.analyze();
			StringBuilder s = new StringBuilder();
			Map<Set<@NonNull Part>, @NonNull List<@NonNull Part>> dependentParts2commitParts = mappingPartitioning.partition(s);
			System.out.println(s.toString());
			if (dependentParts2commitParts == null) {
				return super.visitMapping(mIn);
			}
			else {
				for (List<@NonNull Part> commitParts : dependentParts2commitParts.values()) {
					
				}
				return super.visitMapping(mIn);
//				try {
//					return doVisitMapping_1(mIn);
//				}
//				finally {
//					context.popScope();
//				}
			}
			
		} */

		@Override
		public @NonNull Mapping visitMapping(@NonNull Mapping mIn) {
			@NonNull Mapping mOut = QVTcoreFactory.eINSTANCE.createMapping();
			context.pushScope(mOut);
			context.addTrace(mIn, mOut);
	        mOut.setName(getMappingName(mIn));;
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
				createAll(bIn.getPredicate(), mOut.getGuardPattern().getPredicate());			// Colocate all predicates
				createAllRealizedVariables(bIn.getRealizedVariable(), dOut.getGuardPattern().getVariable(), dOut.getBottomPattern().getRealizedVariable());
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
				createAllRealizedVariables(bIn.getRealizedVariable(), dOut.getGuardPattern().getVariable(), dOut.getBottomPattern().getRealizedVariable());
				createAllVariables(bIn.getVariable(), dOut.getGuardPattern().getVariable(), dOut.getBottomPattern().getVariable());
				mOut.getDomain().add(dOut);
			}
			context.popScope();
			return mOut;
		}

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
	 * The PrimaryCreateVisitor creates a primary mapping that services all aspects of the mapping except those secondary PropertyAssignments that
	 * could cause dependency deadlocks which are therefore serviced by secondary mappings. 
	 */
    protected static class PrimaryCreateVisitor extends CreateVisitor
    {
    	protected final @NonNull List<@NonNull PropertyAssignment> primaryAssignments;

		public PrimaryCreateVisitor(@NonNull QVTm2QVTp context, @NonNull List<@NonNull PropertyAssignment> primaryAssignments) {
			super(context);
			this.primaryAssignments = primaryAssignments;
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
	 * The SecondaryCreateVisitor creates a secondary mapping that complements a primary mapping by servicing one or more secondary PropertyAssignments that
	 * could not be performed by the primary without a deadlock hazard.
	 */
    protected static class SecondaryCreateVisitor extends CreateVisitor
    {
    	protected final @NonNull String mappingName;
    	
    	/**
    	 * Assignments made by the primary mapping. Need to be converted to predicates in the secondary mapping.
    	 */
    	protected final @NonNull List<@NonNull PropertyAssignment> primaryAssignments;

    	/**
    	 * Assignments to be made by this secondary mapping.
    	 */
    	protected final @NonNull List<@NonNull PropertyAssignment> secondaryAssignments;

		public SecondaryCreateVisitor(@NonNull QVTm2QVTp context, @NonNull String mappingName, @NonNull List<@NonNull PropertyAssignment> primaryAssignments, @NonNull List<@NonNull PropertyAssignment> secondaryAssignments) {
			super(context);
			this.mappingName = mappingName;
			this.primaryAssignments = primaryAssignments;
			this.secondaryAssignments = secondaryAssignments;
		}

		@Override
		protected String getMappingName(@NonNull Mapping mIn) {
			return mappingName;
		}

		@Override
		public @Nullable Element visitPropertyAssignment(@NonNull PropertyAssignment paIn) {
			if (primaryAssignments.contains(paIn)) {
				@NonNull Predicate pOut = QVTbaseFactory.eINSTANCE.createPredicate();
		        context.addTrace(paIn, pOut);
		        // The condition expression is copied during update once replacement variables exist.
				createAll(paIn.getOwnedComments(), pOut.getOwnedComments());
		        return pOut;
			}
			else if (secondaryAssignments.contains(paIn)) {
				return super.visitPropertyAssignment(paIn);
			}
			else {
				return null;
			}
		}

		//
		//	RealizedVariables are converted to Variables
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
		@Nullable Set<@NonNull Part> analyzeDependencies();
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
		public @Nullable Set<@NonNull Part> analyzeDependencies() {
			OCLExpression value2 = value;
			if (value2 == null) {
				return null;
			}
			return partitioning.analyzeDependencies(value2);
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
       	protected final @NonNull PropertyAssignment propertyAssignment;

		public ComplexPart(@NonNull Partitioning partitioning, @NonNull PropertyAssignment propertyAssignment) {
			super(partitioning);
			this.propertyAssignment = propertyAssignment;
		}

		@Override
		public @NonNull String getName() {
			return propertyAssignment.getSlotExpression() + "." + propertyAssignment.getTargetProperty().getName();
		}

		@Override
		public @NonNull PropertyAssignment getPropertyAssignment() {
			return propertyAssignment;
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
		public @Nullable Set<@NonNull Part> analyzeDependencies() {
			return partitioning.analyzeDependencies(predicate);
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

		public abstract @Nullable PropertyAssignment getPropertyAssignment();
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
		public @Nullable Set<@NonNull Part> analyzeDependencies() {
			return null;
		}

		@Override
		public @NonNull String getName() {
			return property.getOwningClass().getName() + "::" + property.getName();
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

		public @NonNull VariablePropertyPart getPropertyPart(@NonNull PropertyAssignment propertyAssignment) {
			Property property = propertyAssignment.getTargetProperty();
			assert property != null;
			VariablePropertyPart part = getPropertyPart(property);
			part.setPropertyAssignment(propertyAssignment);
			return part;
		}

		public @Nullable Iterable<@NonNull VariablePropertyPart> getPropertyParts() {
			return property2part != null ? property2part.values() : null;
		}
    }

    protected static class VariablePropertyPart extends PropertyAssignablePart
    {
    	protected final @NonNull VariablePart variablePart;
		private final @NonNull Property property;
		private @Nullable PropertyAssignment propertyAssignment = null;
		
		public VariablePropertyPart(@NonNull Partitioning partitioning, @NonNull VariablePart variablePart, @NonNull Property property) {
			super(partitioning);
			this.variablePart = variablePart;
			this.property = property;
		}

		@Override
		public @Nullable Set<@NonNull Part> analyzeDependencies() {
			Set<@NonNull Part> analyzeDependencies = super.analyzeDependencies();
			if (analyzeDependencies == null) {
				analyzeDependencies = new HashSet<@NonNull Part>();
			}
			analyzeDependencies.add(variablePart);
			return analyzeDependencies;
		}

		@Override
		public @NonNull String getName() {
			return variablePart.getName() + "." + property.getName();
		}

		@Override
		public @Nullable PropertyAssignment getPropertyAssignment() {
			return propertyAssignment;
		}

		public void setPropertyAssignment(@NonNull PropertyAssignment propertyAssignment) {
			assert this.propertyAssignment == null : "Duplicate PropertyAssignment";
			this.propertyAssignment = propertyAssignment;
			OCLExpression value = propertyAssignment.getValue();
			assert value != null;
			setValue(value);
		}
    }

    protected static class Partitioning
    {
    	protected final @NonNull CreateVisitor createVisitor;
		protected final @NonNull Mapping mapping;
		private final @NonNull Map<@NonNull Variable, @NonNull VariablePart> variable2part = new HashMap<@NonNull Variable, @NonNull VariablePart>();
		private @Nullable List<@NonNull VariablePart> allBottomVariables = null;
		private final @NonNull List<@NonNull VariablePart> allGuardVariables = new ArrayList<@NonNull VariablePart>();
		private @Nullable List<@NonNull PredicatePart> allPredicates = null;
		private final @NonNull List<@NonNull AssignablePart> allPropertyAssignments = new ArrayList<@NonNull AssignablePart>();
		private final @NonNull List<@NonNull VariablePart> allRealizedVariables = new ArrayList<@NonNull VariablePart>();
		private @Nullable Map<@NonNull Property, @NonNull PropertyPart> allPropertyParts = null;
		private final @NonNull Map<@NonNull Part, @Nullable Set<@NonNull Part>> part2parts = new HashMap<@NonNull Part, @Nullable Set<@NonNull Part>>();
		private final @NonNull List<@NonNull Part> allParts = new ArrayList<@NonNull Part>();
		
		private final @NonNull Set<@NonNull Part> partitionedParts = new HashSet<@NonNull Part>();
		private final @NonNull Set<@NonNull Part> remainingParts = new HashSet<@NonNull Part>();
		
		public Partitioning(@NonNull CreateVisitor createVisitor, @NonNull Mapping mapping) {
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
					assignablePart = addPropertyAssignment((PropertyAssignment)assignment);
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
			for (Variable variable : ClassUtil.nullFree(guardPattern.getVariable())) {
				VariablePart variablePart = new VariablePart(this, variable);
				allGuardVariables.add(variablePart);
				VariablePart oldVariablePart = variable2part.put(variable, variablePart);
				assert oldVariablePart == null;
			}
		}

		private void addPart(@NonNull Part part) {
			assert !part2parts.containsKey(part);
			part2parts.put(part, null);
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

		private @NonNull AssignablePart addPropertyAssignment(@NonNull PropertyAssignment propertyAssignment) {
			AssignablePart assignablePart;
			OCLExpression slotExpression = propertyAssignment.getSlotExpression();
			assert slotExpression != null;
			VariablePart variablePart = basicGetVariablePart(slotExpression);
			if (variablePart != null) {
				assignablePart = variablePart.getPropertyPart(propertyAssignment);
			}
			else {
				assignablePart = new ComplexPart(this, propertyAssignment);
			}
			allPropertyAssignments.add(assignablePart);
			return assignablePart;
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

		public void analyze() {
			for (Domain domain : ClassUtil.nullFree(mapping.getDomain())) {
				analyzeArea((CoreDomain)domain);
			}
			analyzeArea(mapping);
			Collections.sort(allGuardVariables);
			Collections.sort(allPropertyAssignments);
			Collections.sort(allRealizedVariables);
			for (int i = 0; i < allParts.size(); i++) {			// Avoids CME
				Part part = allParts.get(i);
				part2parts.put(part, part.analyzeDependencies());
				remainingParts.add(part);
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

		protected @Nullable Set<@NonNull Part> analyzeDependencies(@NonNull Element element) {
			Set<@NonNull Part> dependencies = null;
			Part dependency = analyzeDependency(element);
			if (dependency != null) {
				dependencies = new HashSet<@NonNull Part>();
				dependencies.add(dependency);
			}
			for (TreeIterator<EObject> tit = element.eAllContents(); tit.hasNext(); ) {
				EObject eObject = tit.next();
				if (eObject instanceof Element) {
					dependency = analyzeDependency((Element)eObject);
					if (dependency != null) {
						if (dependencies == null) {
							dependencies = new HashSet<@NonNull Part>();
						}
						dependencies.add(dependency);
					}
				}
			}
			return dependencies;
		}

		private @Nullable Part analyzeDependency(@NonNull Element eObject) {
			if (eObject instanceof VariableExp) {
				VariableDeclaration referredVariable = ((VariableExp)eObject).getReferredVariable();
				VariablePart variablePart = variable2part.get(referredVariable);
				if (variablePart != null) {
					return variablePart;
				}
			}
			else if (eObject instanceof PropertyCallExp) {
				PropertyCallExp propertyCallExp = (PropertyCallExp)eObject;
				OCLExpression source = propertyCallExp.getOwnedSource();
				Property property = propertyCallExp.getReferredProperty();
				assert property != null;
				if (source instanceof VariableExp) {
					VariablePart variablePart = basicGetVariablePart(source);
					if (variablePart != null) {
						return variablePart.getPropertyPart(property);
					}
				}
				return addPropertyPart(property);
			}
			return null;
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

		public @Nullable Map<Set<@NonNull Part>, @NonNull List<@NonNull Part>> partition(@Nullable StringBuilder s) {
			Collections.sort(allParts);
			if (s != null) {
				s.append(mapping + "\n");
				showAllParts(s);
			}
			partitionGuardVariables(s);
			partitionBottomVariables(s);
			partitionPredicates(s);
			Set<@NonNull VariablePropertyPart> realizedPropertyParts = partitionRealizedVariables(s);
			Map<Set<@NonNull Part>, @NonNull List<@NonNull Part>> dependentParts2commitParts = partitionCommitParts(realizedPropertyParts);
			if (dependentParts2commitParts != null) {
				if (s != null) {
					showCommitParts(s, dependentParts2commitParts);
				}
				while (partitionRecurseCommits(dependentParts2commitParts)) {
					if (s != null) {
						showCommitParts(s, dependentParts2commitParts);
					}
				}
			}
			return dependentParts2commitParts;
		}

		private void partitionBottomVariables(@Nullable StringBuilder s) {
			List<@NonNull VariablePart> allBottomVariables2 = allBottomVariables;
			if (allBottomVariables2 != null) {
				Collections.sort(allBottomVariables);
				if (s != null) s.append("  bottom variables:");
				for (VariablePart part : allBottomVariables2) {
					if (s != null) s.append(" " + part.getName());
					partitionPart(part);
				}
				if (s != null) s.append("\n");
			}
		}

		private @Nullable Map<Set<@NonNull Part>, @NonNull List<@NonNull Part>> partitionCommitParts(@Nullable Set<@NonNull VariablePropertyPart> realizedPropertyParts) {
			Map<Set<@NonNull Part>, @NonNull List<@NonNull Part>> dependentParts2commitParts = new HashMap<Set<@NonNull Part>, @NonNull List<@NonNull Part>>();
			for (Part commitPart : remainingParts) {
				Set<@NonNull Part> dependentParts = part2parts.get(commitPart);
				if (dependentParts != null) {
					dependentParts.removeAll(partitionedParts);
					List<@NonNull Part> commitParts = dependentParts2commitParts.get(dependentParts);
					if (commitParts == null) {
						commitParts = new ArrayList<@NonNull Part>();
						dependentParts2commitParts.put(dependentParts, commitParts);
					}
					commitParts.add(commitPart);
				}
			}
			if (realizedPropertyParts != null) {
				List<@NonNull Part> commitParts = dependentParts2commitParts.get(Collections.emptySet());
				if (commitParts != null) {				// Can be null for trivial 
					for (VariablePropertyPart realizedPropertyPart : realizedPropertyParts) {
						if (!commitParts.contains(realizedPropertyPart)) {
							commitParts.add(realizedPropertyPart);
						}
					}
				}
				else {
					assert remainingParts.isEmpty();
				}
			}
			return dependentParts2commitParts;
		}

		private void partitionGuardVariables(@Nullable StringBuilder s) {
			if (s != null) s.append("  guard variables:");
			for (VariablePart part : allGuardVariables) {
				if (s != null) s.append(" " + part.getName());
				partitionPart(part);
			}
			if (s != null) s.append("\n");
		}

		private void partitionPart(@NonNull Part part) {
			Set<@NonNull Part> dependsOns = part2parts.get(part);
			if (dependsOns != null) {
				for (Part dependsOn : dependsOns) {
					assert partitionedParts.contains(dependsOn);
				}
			}
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
				Set<@NonNull Part> parts = part2parts.get(predicatePart);
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

		private @Nullable Set<@NonNull VariablePropertyPart> partitionRealizedVariables(@Nullable StringBuilder s) {
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
						if (variablePart != null) {
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

		private boolean partitionRecurseCommits(@NonNull Map<@NonNull Set<@NonNull Part>, @NonNull List<@NonNull Part>> dependentParts2commitParts) {
			List<@NonNull Part> readyCommitParts = dependentParts2commitParts.get(Collections.emptySet());
			if (readyCommitParts == null) {
				return false;
			}
			boolean gotOne = false;
			for (Set<@NonNull Part> oldDependentParts : new ArrayList<@NonNull Set<@NonNull Part>>(dependentParts2commitParts.keySet())) {
				Set<@NonNull Part> newDependentParts = new HashSet<@NonNull Part>(oldDependentParts);
				if (newDependentParts.removeAll(readyCommitParts)) {
					gotOne = true;
					List<@NonNull Part> oldCommitsList = dependentParts2commitParts.remove(oldDependentParts);
					assert oldCommitsList != null;
					List<@NonNull Part> newCommitsList = dependentParts2commitParts.get(newDependentParts);
					if (newCommitsList == null) {
						newCommitsList = new ArrayList<@NonNull Part>();
						dependentParts2commitParts.put(newDependentParts, newCommitsList);
					}
					for (Part oldCommit : oldCommitsList) {
						if (!newCommitsList.contains(oldCommit)) {
							newCommitsList.add(oldCommit);
						}
					}
				}
			}
			return gotOne;
		}

		private void showAllParts(@NonNull StringBuilder s) {
			for (Part part : allParts) {
				if (s != null) s.append("    " + part + " : {");
				Set<@NonNull Part> parts = part2parts.get(part);
				if (parts != null) {
					List<@NonNull Part> sortedDependentParts = new ArrayList<@NonNull Part>(parts);
					Collections.sort(sortedDependentParts);
					for (Part dependentPart : sortedDependentParts) {
						if (s != null) s.append(" " + dependentPart.getName());
						assert part2parts.containsKey(dependentPart);
					}
				}
				if (s != null) s.append(" }\n");
			}
		}

		private void showCommitParts(@NonNull StringBuilder s, @NonNull Map<Set<@NonNull Part>, @NonNull List<@NonNull Part>> dependentParts2commitParts) {
			s.append("  commit parts:\n");
			for (Set<@NonNull Part> dependentParts : dependentParts2commitParts.keySet()) {
				List<@NonNull Part> sortedDependentParts = new ArrayList<@NonNull Part>(dependentParts);
				Collections.sort(sortedDependentParts);
				s.append("    {");
				for (Part dependentPart : sortedDependentParts) {
					s.append(" " + dependentPart.getName());
				}
				s.append(" } => {");
				List<@NonNull Part> commitParts = dependentParts2commitParts.get(dependentParts);
				assert commitParts != null;
				Collections.sort(commitParts);
				for (Part commitPart : commitParts) {
					s.append(" " + commitPart.getName());
				}
				s.append(" }\n");
			}
		}

		public @NonNull List<@NonNull Mapping> synthesize(@Nullable StringBuilder s) {
			Map<Set<@NonNull Part>, @NonNull List<@NonNull Part>> dependentParts2commitParts = partition(s);
			if ((dependentParts2commitParts == null) || (dependentParts2commitParts.size() <= 1)) {
				Mapping mOut = createVisitor.create(mapping);
				assert mOut != null;
				return Collections.singletonList(mOut);
			}
			else {
				List<@NonNull Mapping> mOuts = new ArrayList<@NonNull Mapping>();
				List<@NonNull PropertyAssignment> primaryAssignments = synthesizeComputePrimaryAssignments(dependentParts2commitParts);
				Map<Set<@NonNull Part>, @NonNull String> dependentParts2mappingName = synthesizeComputeMappingNames(dependentParts2commitParts);
				QVTm2QVTp context = createVisitor.getContext();
				for (Map.Entry<Set<@NonNull Part>, @NonNull List<@NonNull Part>> entry : dependentParts2commitParts.entrySet()) {
					Set<@NonNull Part> dependentParts = entry.getKey();
					CreateVisitor refinedCreateVisitor;
					if (dependentParts.isEmpty()) {
						refinedCreateVisitor = new PrimaryCreateVisitor(context, primaryAssignments);
					}
					else {
						List<@NonNull PropertyAssignment> secondaryAssignments = synthesizeComputeSecondaryAssignments(entry.getValue());
						String mappingName = dependentParts2mappingName.get(dependentParts);
						assert mappingName != null;
						refinedCreateVisitor = new SecondaryCreateVisitor(context, mappingName, primaryAssignments, secondaryAssignments);
					}
					Mapping mOut = refinedCreateVisitor.create(mapping);
					assert mOut != null;
					mOuts.add(mOut);
				}
				return mOuts;
			}
		}

		private @NonNull Map<Set<@NonNull Part>, @NonNull String> synthesizeComputeMappingNames(@NonNull Map<Set<@NonNull Part>, @NonNull List<@NonNull Part>> dependentParts2commitParts) {
			Map<Set<@NonNull Part>, @NonNull String> dependentParts2mappingNames = new HashMap<Set<@NonNull Part>, @NonNull String>();
			int i = 0;
			for (Map.Entry<Set<@NonNull Part>, @NonNull List<@NonNull Part>> entry : dependentParts2commitParts.entrySet()) {	// FIXME Stabilize order
				Set<@NonNull Part> dependentParts = entry.getKey();
				String name = mapping.getName() + i;				// FIXME More readble name
				dependentParts2mappingNames.put(dependentParts, name);
			}
			return dependentParts2mappingNames;
		}

		private @NonNull List<@NonNull PropertyAssignment> synthesizeComputePrimaryAssignments(@NonNull Map<Set<@NonNull Part>, @NonNull List<@NonNull Part>> dependentParts2commitParts) {
			List<@NonNull PropertyAssignment> primaryAssignments = new ArrayList<@NonNull PropertyAssignment>();
			List<@NonNull Part> primaryCommits = dependentParts2commitParts.get(Collections.emptySet());
			assert primaryCommits != null;
			for (Part primaryCommit : primaryCommits) {
				if (primaryCommit instanceof PropertyAssignablePart) {
					PropertyAssignment propertyAssignment = ((PropertyAssignablePart)primaryCommit).getPropertyAssignment();
					if (propertyAssignment != null) {
						primaryAssignments.add(propertyAssignment);
					}
				}
			}
			return primaryAssignments;
		}

		private @NonNull List<@NonNull PropertyAssignment> synthesizeComputeSecondaryAssignments(@NonNull List<@NonNull Part> commitParts) {
			List<@NonNull PropertyAssignment> secondaryAssignments = new ArrayList<@NonNull PropertyAssignment>();
			for (Part secondaryCommit : commitParts) {
				if (secondaryCommit instanceof PropertyAssignablePart) {
					PropertyAssignment propertyAssignment = ((PropertyAssignablePart)secondaryCommit).getPropertyAssignment();
					if (propertyAssignment != null) {
						secondaryAssignments.add(propertyAssignment);
					}
				}
			}
			return secondaryAssignments;
		}
    }

	/**
	 * The UpdateVisitor resolves the references and creates the OCLEXpressions omitted by the CreateVisitor..
	 */
    protected static class UpdateVisitor extends AbstractUpdateVisitor<@NonNull QVTm2QVTp>
    {
		public UpdateVisitor(@NonNull QVTm2QVTp context) {
			super(context);
		}

		@Override
		public @Nullable Object visitPredicate(@NonNull Predicate pOut) {
			Element pIn = context.equivalentSource(pOut);
			if (pIn instanceof PropertyAssignment) {
				return convertToPredicate((PropertyAssignment) pIn, pOut);
			}
			else {
				pOut.setConditionExpression(copy(((Predicate)pIn).getConditionExpression()));
			}
			return null;
		}
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
	protected @NonNull CreateVisitor createCreateVisitor() {
		return new CreateVisitor(this);
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
