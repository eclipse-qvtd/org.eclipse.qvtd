/*******************************************************************************
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtp2qvts;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtcorebase.NavigationAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.analysis.DomainUsage;
import org.eclipse.qvtd.pivot.qvtcorebase.utilities.QVTcoreBaseUtil;
import org.eclipse.qvtd.pivot.schedule.ClassDatum;

/**
 * Nodes provides factory instances for creating the various forms of nodes.
 */
public class Nodes
{
	private static enum HeadableEnum { STEP, HEAD };
	private static enum NavigableEnum { UNNAVIGABLE, NAVIGABLE };

	private static @NonNull NavigableEnum asNavigable(boolean isNavigable) {
		return isNavigable ? NavigableEnum.NAVIGABLE : NavigableEnum.UNNAVIGABLE;
	}

	private static final class ComposingNodeRole extends AbstractNodeRole
	{
		private static final @NonNull ComposingNodeRole COMPOSING = new ComposingNodeRole();

		public static @NonNull ComposingNodeRole getComposingNodeRole() {
			return COMPOSING;
		}

		protected ComposingNodeRole() {
			super(Role.Phase.LOADED);
		}

		@Override
		public boolean isNavigable() {
			return true;
		}
	}

	private static final class ErrorNodeRole extends AbstractNodeRole
	{
		public static final @NonNull NodeRole ERROR = new ErrorNodeRole();

		protected ErrorNodeRole() {
			super(Role.Phase.OTHER);
		}

		@Override
		public @NonNull String getColor() {
			return ERROR_COLOR;
		}

		@Override
		public @NonNull Integer getPenwidth() {
			return HEAD_WIDTH;
		}

		@Override
		public @NonNull String getShape() {
			return "circle";
		}
	}

	private static class ExtraGuardNodeRole extends AbstractNodeRole
	{
		private static final @NonNull ExtraGuardNodeRole EXTRA_GUARD = new ExtraGuardNodeRole();

		public static @NonNull ExtraGuardNodeRole getExtraGuardNodeRole() {
			return EXTRA_GUARD;
		}

		private ExtraGuardNodeRole() {
			super(Role.Phase.PREDICATED);
		}

		@Override
		public boolean isExtraGuardVariable() {
			return true;
		}

		@Override
		public boolean isHead() {
			return true;
		}
	}

	private static final class InputNodeRole extends AbstractNodeRole
	{
		private static final @NonNull InputNodeRole CONSTANT_INPUT = new InputNodeRole(Role.Phase.CONSTANT); //, true);
		private static final @NonNull InputNodeRole LOADED_INPUT = new InputNodeRole(Role.Phase.LOADED); //, true);
		//		private static final @NonNull InputNodeRole PREDICATED_INPUT = new InputNodeRole(Role.Phase.PREDICATED); //, true);
		//		private static final @NonNull InputNodeRole REALIZED_INPUT = new InputNodeRole(Role.Phase.REALIZED); //, true);

		public static @NonNull Node createInputNode(@NonNull Region region, NodeRole.@NonNull Phase nodeRolePhase, @NonNull String name, @NonNull ClassDatumAnalysis classDatumAnalysis) {
			switch (nodeRolePhase) {
				case CONSTANT: return CONSTANT_INPUT.createNode(region, name, classDatumAnalysis);
				case LOADED: return LOADED_INPUT.createNode(region, name, classDatumAnalysis);
				//				case PREDICATED: return PREDICATED_INPUT.createNode(region, name, classDatumAnalysis);
				//				case REALIZED: return REALIZED_INPUT.createNode(region, name, classDatumAnalysis);
			}
			throw new UnsupportedOperationException();
		}

		protected InputNodeRole(@NonNull Phase phase) {
			super(phase);
		}

		@Override
		public @NonNull TypedNode createNode(@NonNull Region region, @NonNull String name, @NonNull ClassDatumAnalysis classDatumAnalysis) {
			throw new UnsupportedOperationException(); // FIXME Only used for obsolete cyclic regions.
		}

		@Override
		public @NonNull TypedNode createNode(@NonNull Region region, @NonNull String name, @NonNull TypedElement typedElement) {
			throw new UnsupportedOperationException();
		}

		@Override
		public @NonNull Integer getPenwidth() {
			return Role.HEAD_WIDTH; //isHead ? Role.HEAD_WIDTH : Role.GUARD_WIDTH;
		}

		@Override
		public boolean isHead() {
			return true;
		}
	}

	private static final class IteratorNodeRole extends AbstractNodeRole
	{
		private static final @NonNull IteratorNodeRole CONSTANT_ITERATOR = new IteratorNodeRole(Role.Phase.CONSTANT);
		private static final @NonNull IteratorNodeRole LOADED_ITERATOR = new IteratorNodeRole(Role.Phase.LOADED);
		private static final @NonNull IteratorNodeRole PREDICATED_ITERATOR = new IteratorNodeRole(Role.Phase.PREDICATED);

		public static @NonNull IteratorNodeRole getIteratorNodeRole(@NonNull Phase phase) {
			switch (phase) {
				case CONSTANT: return CONSTANT_ITERATOR;
				case LOADED: return LOADED_ITERATOR;
				case PREDICATED: return PREDICATED_ITERATOR;
			}
			throw new UnsupportedOperationException();
		}

		protected IteratorNodeRole(@NonNull Phase phase) {
			super(phase);
		}

		@Override
		public @NonNull IteratorNodeRole asPhase(@NonNull Phase phase) {
			return getIteratorNodeRole(phase);
		}

		@Override
		public boolean isInternal() {
			return true;
		}

		@Override
		public boolean isIterator() {
			return true;
		}

		@Override
		public @NonNull NodeRole merge(@NonNull NodeRole nodeRole) {
			if (nodeRole instanceof IteratorNodeRole) {
				return RegionUtil.mergeToMoreKnownPhase(this, nodeRole);
			}
			else {
				return super.merge(nodeRole);
			}
		}
	}

	private static class NullNodeRole extends AbstractNodeRole
	{
		private static final @NonNull NullNodeRole NULL = new NullNodeRole();

		private NullNodeRole() {
			super(Role.Phase.CONSTANT);
		}

		@Override
		public boolean isNull() {
			return true;
		}
	}

	private static class OperationNodeRole extends AbstractNodeRole
	{
		private static final @NonNull OperationNodeRole CONSTANT_OPERATION = new OperationNodeRole(Role.Phase.CONSTANT);
		private static final @NonNull OperationNodeRole LOADED_OPERATION = new OperationNodeRole(Role.Phase.LOADED);
		private static final @NonNull OperationNodeRole PREDICATED_OPERATION = new OperationNodeRole(Role.Phase.PREDICATED);
		private static final @NonNull OperationNodeRole REALIZED_OPERATION = new OperationNodeRole(Role.Phase.REALIZED);

		public static @NonNull Phase getOperationNodePhase(@NonNull Region region, @NonNull TypedElement typedElement, @NonNull Node... argNodes) {
			boolean isLoaded = false;
			boolean isPredicated = false;
			boolean isRealized = false;
			if (argNodes != null) {
				for (Node argNode : argNodes) {
					if (argNode.isRealized()) {
						isRealized = true;
					}
					else if (argNode.isPredicated()) {
						isPredicated = true;
					}
					else if (argNode.isLoaded()) {
						isLoaded = true;
					}
				}
			}
			if (typedElement instanceof OperationCallExp) {
				Operation asOperation = ((OperationCallExp)typedElement).getReferredOperation();
				if (QVTbaseUtil.isIdentification(asOperation)) {
					DomainUsage usage = region.getSchedulerConstants().getDomainUsage(typedElement);
					if (!usage.isInput()) {
						isRealized = true;
					}
				}
			}
			if (isRealized) {
				return Phase.REALIZED;
			}
			else if (isPredicated) {
				return Phase.PREDICATED;
			}
			else if (isLoaded) {
				return Phase.LOADED;
			}
			else {
				return Phase.CONSTANT;
			}
		}

		public static @NonNull OperationNodeRole getOperationNodeRole(@NonNull Phase phase) {
			switch (phase) {
				case CONSTANT: return CONSTANT_OPERATION;
				case LOADED: return LOADED_OPERATION;
				case PREDICATED: return PREDICATED_OPERATION;
				case REALIZED: return REALIZED_OPERATION;
			}
			throw new UnsupportedOperationException();
		}

		protected OperationNodeRole(@NonNull Phase phase) {
			super(phase);
		}

		@Override
		public @NonNull OperationNodeRole asPhase(@NonNull Phase phase) {
			return getOperationNodeRole(phase);
		}

		@Override
		public @NonNull Integer getPenwidth() {
			return LINE_WIDTH;
		}

		@Override
		public @NonNull String getShape() {
			return "ellipse";
		}

		@Override
		public boolean isExpression() {
			return true;
		}

		@Override
		public boolean isOperation() {
			return true;
		}

		@Override
		public String toString() {
			return phase + "-" + getClass().getSimpleName();
		}
	}

	private static class PatternNodeRole extends AbstractNodeRole
	{
		private static final @NonNull PatternNodeRole CONSTANT_NAVIGABLE_STEP = new PatternNodeRole(Role.Phase.CONSTANT, NavigableEnum.NAVIGABLE, HeadableEnum.STEP);
		private static final @NonNull PatternNodeRole CONSTANT_UNNAVIGABLE_STEP = new PatternNodeRole(Role.Phase.CONSTANT, NavigableEnum.UNNAVIGABLE, HeadableEnum.STEP);
		private static final @NonNull PatternNodeRole LOADED_NAVIGABLE_HEAD = new PatternNodeRole(Role.Phase.LOADED, NavigableEnum.NAVIGABLE, HeadableEnum.HEAD);
		private static final @NonNull PatternNodeRole LOADED_NAVIGABLE_STEP = new PatternNodeRole(Role.Phase.LOADED, NavigableEnum.NAVIGABLE, HeadableEnum.STEP);
		private static final @NonNull PatternNodeRole LOADED_UNNAVIGABLE_STEP = new PatternNodeRole(Role.Phase.LOADED, NavigableEnum.UNNAVIGABLE, HeadableEnum.STEP);
		private static final @NonNull PatternNodeRole PREDICATED_NAVIGABLE_HEAD = new PatternNodeRole(Role.Phase.PREDICATED, NavigableEnum.NAVIGABLE, HeadableEnum.HEAD);
		private static final @NonNull PatternNodeRole PREDICATED_NAVIGABLE_STEP = new PatternNodeRole(Role.Phase.PREDICATED, NavigableEnum.NAVIGABLE, HeadableEnum.STEP);
		private static final @NonNull PatternNodeRole PREDICATED_UNNAVIGABLE_HEAD = new PatternNodeRole(Role.Phase.PREDICATED, NavigableEnum.UNNAVIGABLE, HeadableEnum.HEAD);
		private static final @NonNull PatternNodeRole PREDICATED_UNNAVIGABLE_STEP = new PatternNodeRole(Role.Phase.PREDICATED, NavigableEnum.UNNAVIGABLE, HeadableEnum.STEP);
		private static final @NonNull PatternNodeRole REALIZED_NAVIGABLE_STEP = new PatternNodeRole(Role.Phase.REALIZED, NavigableEnum.NAVIGABLE, HeadableEnum.STEP);
		private static final @NonNull PatternNodeRole REALIZED_UNNAVIGABLE_STEP = new PatternNodeRole(Role.Phase.REALIZED, NavigableEnum.UNNAVIGABLE, HeadableEnum.STEP);
		private static final @NonNull PatternNodeRole SPECULATED_NAVIGABLE_HEAD = new PatternNodeRole(Role.Phase.SPECULATED, NavigableEnum.NAVIGABLE, HeadableEnum.HEAD);
		private static final @NonNull PatternNodeRole SPECULATED_NAVIGABLE_STEP = new PatternNodeRole(Role.Phase.SPECULATED, NavigableEnum.NAVIGABLE, HeadableEnum.STEP);
		private static final @NonNull PatternNodeRole SPECULATION_NAVIGABLE_STEP = new PatternNodeRole(Role.Phase.SPECULATION, NavigableEnum.NAVIGABLE, HeadableEnum.STEP);

		public static @NonNull PatternNodeRole getPatternNodeRole(@NonNull Phase phase, @NonNull NavigableEnum navigable, @NonNull HeadableEnum guardable) {
			switch (navigable) {
				case NAVIGABLE: {
					switch (guardable) {
						case HEAD: {
							switch (phase) {
								case LOADED: return LOADED_NAVIGABLE_HEAD;
								case PREDICATED: return PREDICATED_NAVIGABLE_HEAD;
								case SPECULATED: return SPECULATED_NAVIGABLE_HEAD;
							}
							break;
						}
						case STEP: {
							switch (phase) {
								case CONSTANT: return CONSTANT_NAVIGABLE_STEP;
								case LOADED: return LOADED_NAVIGABLE_STEP;
								case PREDICATED: return PREDICATED_NAVIGABLE_STEP;
								case REALIZED: return REALIZED_NAVIGABLE_STEP;
								case SPECULATED: return SPECULATED_NAVIGABLE_STEP;
								case SPECULATION: return SPECULATION_NAVIGABLE_STEP;
							}
							break;
						}
					}
					break;
				}
				case UNNAVIGABLE: {
					switch (guardable) {
						case HEAD: {
							switch (phase) {
								case PREDICATED: return PREDICATED_UNNAVIGABLE_HEAD;
							}
							break;
						}
						case STEP: {
							switch (phase) {
								case CONSTANT: return CONSTANT_UNNAVIGABLE_STEP;
								case LOADED: return LOADED_UNNAVIGABLE_STEP;
								case PREDICATED: return PREDICATED_UNNAVIGABLE_STEP;
								case REALIZED: return REALIZED_UNNAVIGABLE_STEP;
							}
							break;
						}
					}
					break;
				}
			}
			throw new UnsupportedOperationException();
		}

		public static @NonNull PatternNodeRole getPatternNodeRole(@NonNull Node sourceNode, @NonNull Property property) {
			Phase phase;
			switch (sourceNode.getNodeRole().getPhase()) {
				case REALIZED: phase = Phase.REALIZED; break;
				case PREDICATED: phase = Phase.PREDICATED; break;
				case LOADED: {
					boolean isDirty = sourceNode.getRegion().getSchedulerConstants().isDirty(property);
					phase = isDirty ? Phase.PREDICATED : Phase.LOADED; break;
				}
				case CONSTANT: phase = Phase.CONSTANT; break;
				default: throw new UnsupportedOperationException();
			}
			NavigableEnum navigableEnum = Nodes.asNavigable(sourceNode.isNavigable());
			return getPatternNodeRole(phase, navigableEnum, HeadableEnum.STEP);
		}

		private final @NonNull NavigableEnum navigable;
		private final @NonNull HeadableEnum guardable;

		private PatternNodeRole(@NonNull Phase phase, @NonNull NavigableEnum navigable, @NonNull HeadableEnum guardable) {
			super(phase);
			this.navigable = navigable;
			this.guardable = guardable;
		}

		@Override
		public @NonNull NodeRole asNavigable() {
			return getPatternNodeRole(phase, NavigableEnum.NAVIGABLE, guardable);
		}

		@Override
		public @NonNull PatternNodeRole asPhase(@NonNull Phase phase) {
			return getPatternNodeRole(phase, navigable, guardable);
		}

		@Override
		public @NonNull NodeRole asSpeculated() {
			return getPatternNodeRole(Phase.SPECULATED, NavigableEnum.NAVIGABLE, HeadableEnum.HEAD);
		}

		@Override
		public @NonNull NodeRole asSpeculation() {
			return getPatternNodeRole(Phase.SPECULATION, NavigableEnum.NAVIGABLE, guardable);
		}

		@Override
		public boolean isHead() {
			return guardable == HeadableEnum.HEAD;
		}

		@Override
		public boolean isNavigable() {
			return navigable == NavigableEnum.NAVIGABLE;
		}

		@Override
		public boolean isPattern() {
			return true;
		}

		@Override
		public @NonNull NodeRole merge(@NonNull NodeRole nodeRole) {
			assert nodeRole instanceof PatternNodeRole;
			Phase mergedPhase = RegionUtil.mergeToMoreKnownPhase(this, nodeRole).getPhase();
			NavigableEnum mergedNavigable;
			HeadableEnum mergedGuardable;
			if (mergedPhase == Phase.REALIZED) {
				mergedNavigable = NavigableEnum.UNNAVIGABLE;
				mergedGuardable = HeadableEnum.STEP;
			}
			else {
				mergedNavigable = Nodes.asNavigable(isNavigable() || nodeRole.isNavigable());
				mergedGuardable = (isHead() && nodeRole.isHead()) ? HeadableEnum.HEAD : HeadableEnum.STEP;
			}
			return getPatternNodeRole(mergedPhase, mergedNavigable, mergedGuardable);
		}

		@Override
		public @NonNull NodeRole resetHead() {
			return getPatternNodeRole(phase, navigable, HeadableEnum.STEP);
		}

		@Override
		public @NonNull NodeRole setHead() {
			return getPatternNodeRole(phase, navigable, HeadableEnum.HEAD);
		}

		@Override
		public String toString() {
			return phase + (isNavigable() ? "-Navigable" : "-Unnavigable") + (isHead() ? "Head-" : "Step-") + getClass().getSimpleName();
		}
	}

	// FIXME Can this be merged into PatternNodeRole ??
	private static final class PredicatedInternalNodeRole extends AbstractNodeRole
	{
		private static final @NonNull PredicatedInternalNodeRole PREDICATED_INTERNAL = new PredicatedInternalNodeRole();

		public static @NonNull PredicatedInternalNodeRole getPredicatedInternalNodeRole() {
			return PREDICATED_INTERNAL;
		}

		private PredicatedInternalNodeRole() {
			super(Role.Phase.PREDICATED);
		}

		@Override
		public boolean isInternal() {
			return true;
		}

		@Override
		public boolean isPattern() {
			return true;
		}

		@Override
		public String toString() {
			return getClass().getSimpleName();
		}
	}

	private static final class TrueNodeRole extends AbstractNodeRole
	{
		private static final @NonNull TrueNodeRole TRUE = new TrueNodeRole();

		private TrueNodeRole() {
			super(Role.Phase.CONSTANT);
		}

		@Override
		public boolean isHead() {
			return true;
		}

		@Override
		public boolean isTrue() {
			return true;
		}
	}

	private static final class UnknownNodeRole extends AbstractNodeRole
	{
		public static final @NonNull NodeRole UNKNOWN = new UnknownNodeRole();

		protected UnknownNodeRole() {
			super(Role.Phase.OTHER);
		}

		@Override
		public @NonNull String getColor() {
			return ERROR_COLOR;
		}
	}

	public static @NonNull Node createComposingNode(@NonNull Region region, @NonNull String name, @NonNull ClassDatumAnalysis classDatumAnalysis) {
		ComposingNodeRole composingNodeRole = ComposingNodeRole.getComposingNodeRole();
		return composingNodeRole.createNode(region, name, classDatumAnalysis);
	}

	public static @NonNull TypedNode createDataTypeNode(@NonNull Node sourceNode, @NonNull Property property) {
		PatternNodeRole patternNodeRole = PatternNodeRole.getPatternNodeRole(sourceNode, property);
		return patternNodeRole.createNode(sourceNode, property);
	}

	public static @NonNull TypedNode createDataTypeNode(@NonNull Node sourceNode, @NonNull NavigationCallExp navigationCallExp) {
		Property property = PivotUtil.getReferredProperty(navigationCallExp);
		PatternNodeRole patternNodeRole = PatternNodeRole.getPatternNodeRole(sourceNode, property);
		assert sourceNode.isClass();
		String name = property.getName();
		assert name != null;
		return patternNodeRole.createNode(sourceNode.getRegion(), name, navigationCallExp);
	}

	public static @NonNull Node createDataTypeNode(@NonNull Node targetNode, @NonNull NavigationAssignment navigationAssignment) {
		Role.Phase phase;
		switch (targetNode.getNodeRole().getPhase()) {
			case REALIZED: phase = Role.Phase.REALIZED; break;
			case PREDICATED: phase = Role.Phase.PREDICATED; break;
			case LOADED: phase = Role.Phase.LOADED; break;
			case CONSTANT: phase = Role.Phase.CONSTANT; break;
			default: throw new UnsupportedOperationException();
		}
		PatternNodeRole patternNodeRole = PatternNodeRole.getPatternNodeRole(phase, NavigableEnum.NAVIGABLE, HeadableEnum.STEP);
		Property property = QVTcoreBaseUtil.getTargetProperty(navigationAssignment);
		//		PatternNodeRole patternNodeRole = PatternNodeRole.getDataTypeNodeRole(targetNode, property);
		//		assert sourceNode.isClass();
		String name = property.getName();
		assert name != null;
		org.eclipse.ocl.pivot.Class type = (org.eclipse.ocl.pivot.Class)property.getType();
		assert type != null;
		TypedModel typedModel = targetNode.getClassDatumAnalysis().getTypedModel();
		Region region = targetNode.getRegion();
		ClassDatum classDatum = region.getSchedulerConstants().getClassDatum(type, typedModel);
		//				DomainUsage domainUsage = parentNode.getClassDatumAnalysis().getDomainUsage();
		ClassDatumAnalysis classDatumAnalysis = region.getSchedulerConstants().getClassDatumAnalysis(classDatum);
		return patternNodeRole.createNode(region, name, classDatumAnalysis);
	}

	public static @NonNull Node createErrorNode(@NonNull Region region, @NonNull String name, @NonNull ClassDatumAnalysis classDatumAnalysis) {
		return ErrorNodeRole.ERROR.createNode(region, name, classDatumAnalysis);
	}

	public static @NonNull TypedNode createExtraGuardNode(@NonNull Region region, @NonNull String name, @NonNull ClassDatumAnalysis classDatumAnalysis) {
		ExtraGuardNodeRole extraGuardNodeRole = ExtraGuardNodeRole.getExtraGuardNodeRole();
		return extraGuardNodeRole.createNode(region, name, classDatumAnalysis);
	}

	public static @NonNull Node createInputNode(@NonNull Region region, NodeRole.@NonNull Phase nodeRolePhase, @NonNull String name, @NonNull ClassDatumAnalysis classDatumAnalysis) {
		return InputNodeRole.createInputNode(region, nodeRolePhase, name, classDatumAnalysis);
	}

	public static @NonNull VariableNode createIteratorNode(@NonNull Variable iterator, @NonNull Node sourceNode) {
		IteratorNodeRole nodeRole = IteratorNodeRole.getIteratorNodeRole(sourceNode.getNodeRole().getPhase());
		return nodeRole.createNode(sourceNode.getRegion(), iterator);
	}

	public static @NonNull VariableNode createLetVariableNode(@NonNull Variable letVariable, @NonNull Node inNode) {
		NavigableEnum resolvedIsNavigable = asNavigable(inNode.isNavigable());
		PatternNodeRole patternNodeRole = PatternNodeRole.getPatternNodeRole(inNode.getNodeRole().getPhase(), resolvedIsNavigable, HeadableEnum.STEP);
		return patternNodeRole.createNode(inNode.getRegion(), letVariable);
	}

	public static @NonNull VariableNode createLoadedStepNode(@NonNull Region region, @NonNull VariableDeclaration stepVariable) {
		PatternNodeRole patternNodeRole = PatternNodeRole.getPatternNodeRole(Role.Phase.LOADED, NavigableEnum.NAVIGABLE, HeadableEnum.STEP);
		return patternNodeRole.createNode(region, stepVariable);
	}

	public static @NonNull TypedNode createNullNode(@NonNull Region region, @Nullable TypedElement typedElement) {
		if (typedElement != null) {
			return NullNodeRole.NULL.createNode(region, "«null»", typedElement);
		}
		else {
			return NullNodeRole.NULL.createNode(region, "«null»", region.getSchedulerConstants().getOclVoidClassDatumAnalysis());
		}
	}

	public static @NonNull VariableNode createOldNode(@NonNull Region region, @NonNull VariableDeclaration variable) {
		DomainUsage domainUsage = region.getSchedulerConstants().getDomainUsage(variable);
		boolean isEnforceable = domainUsage.isOutput() || domainUsage.isMiddle();
		Role.Phase phase = isEnforceable ? Role.Phase.PREDICATED : Role.Phase.LOADED;
		PatternNodeRole patternNodeRole = PatternNodeRole.getPatternNodeRole(phase, NavigableEnum.NAVIGABLE, HeadableEnum.STEP);
		return patternNodeRole.createNode(region, variable);
	}

	public static @NonNull TypedNode createOperationElementNode(@NonNull Region region, @NonNull String name, @NonNull ClassDatumAnalysis classDatumAnalysis, @NonNull Node sourceNode) {
		PatternNodeRole patternNodeRole = PatternNodeRole.getPatternNodeRole(sourceNode.getNodeRole().getPhase(), NavigableEnum.NAVIGABLE, HeadableEnum.STEP);
		return patternNodeRole.createNode(region, name, classDatumAnalysis);
	}

	public static @NonNull TypedNode createOperationNode(@NonNull Region region, @NonNull String name, @NonNull TypedElement typedElement, @NonNull Node... argNodes) {
		Role.Phase nodePhase = OperationNodeRole.getOperationNodePhase(region, typedElement, argNodes);
		OperationNodeRole nodeRole = OperationNodeRole.getOperationNodeRole(nodePhase);
		return nodeRole.createNode(region, name, typedElement);
	}

	public static @NonNull TypedNode createOperationParameterNode(@NonNull Region region, @NonNull String name, @NonNull ClassDatumAnalysis classDatumAnalysis) {
		PatternNodeRole patternNodeRole = PatternNodeRole.getPatternNodeRole(Role.Phase.PREDICATED, NavigableEnum.UNNAVIGABLE, HeadableEnum.HEAD);
		return patternNodeRole.createNode(region, name, classDatumAnalysis);
	}

	public static @NonNull TypedNode createOperationResultNode(@NonNull Region region, @NonNull String name, @NonNull ClassDatumAnalysis classDatumAnalysis, @NonNull Node sourceNode) {
		PatternNodeRole patternNodeRole = PatternNodeRole.getPatternNodeRole(sourceNode.getNodeRole().getPhase(), NavigableEnum.UNNAVIGABLE, HeadableEnum.STEP);
		return patternNodeRole.createNode(region, name, classDatumAnalysis);
	}

	public static @NonNull Node createPredicatedInternalClassNode(@NonNull Node parentNode, @NonNull NavigationAssignment navigationAssignment) {
		assert parentNode.isClass();
		SchedulerConstants schedulerConstants = parentNode.getRegion().getSchedulerConstants();
		Property property = QVTcoreBaseUtil.getTargetProperty(navigationAssignment);
		assert property != null;
		org.eclipse.ocl.pivot.Class type = (org.eclipse.ocl.pivot.Class)property.getType();
		assert type != null;
		TypedModel typedModel = parentNode.getClassDatumAnalysis().getTypedModel();
		ClassDatum classDatum = schedulerConstants.getClassDatum(type, typedModel);
		//				DomainUsage domainUsage = parentNode.getClassDatumAnalysis().getDomainUsage();
		ClassDatumAnalysis classDatumAnalysis = schedulerConstants.getClassDatumAnalysis(classDatum);
		String name = property.getName();
		assert name != null;
		PredicatedInternalNodeRole predicatedInternalNodeRole = PredicatedInternalNodeRole.getPredicatedInternalNodeRole();
		return predicatedInternalNodeRole.createNode(parentNode.getRegion(), name, classDatumAnalysis);
	}

	public static @NonNull TypedNode createPredicatedInternalNode(@NonNull Region region, @NonNull String name, @NonNull ClassDatumAnalysis classDatumAnalysis) {
		PredicatedInternalNodeRole predicatedInternalNodeRole = PredicatedInternalNodeRole.getPredicatedInternalNodeRole();
		return predicatedInternalNodeRole.createNode(region, name, classDatumAnalysis);
	}

	public static @NonNull TypedNode createRealizedDataTypeNode(@NonNull Node sourceNode, @NonNull Property source2targetProperty) {
		PatternNodeRole patternNodeRole = PatternNodeRole.getPatternNodeRole(Role.Phase.REALIZED, NavigableEnum.UNNAVIGABLE, HeadableEnum.STEP);
		return patternNodeRole.createNode(sourceNode, source2targetProperty);
	}

	public static @NonNull VariableNode createRealizedStepNode(@NonNull Region region, @NonNull Variable stepVariable) {
		PatternNodeRole patternNodeRole = PatternNodeRole.getPatternNodeRole(Role.Phase.REALIZED, NavigableEnum.UNNAVIGABLE, HeadableEnum.STEP);
		return patternNodeRole.createNode(region, stepVariable);
	}

	public static @NonNull TypedNode createStepNode(@NonNull String name, @NonNull CallExp callExp, @NonNull Node sourceNode, boolean isNavigable) {
		Region region = sourceNode.getRegion();
		DomainUsage domainUsage = region.getSchedulerConstants().getDomainUsage(callExp);
		boolean isMiddleOrOutput = domainUsage.isOutput() || domainUsage.isMiddle();
		boolean isDirty = false;
		if (callExp instanceof NavigationCallExp) {
			Property referredProperty = PivotUtil.getReferredProperty((NavigationCallExp)callExp);
			isDirty = region.getSchedulerConstants().isDirty(referredProperty);
		}
		Role.Phase phase = sourceNode.isPredicated() || isMiddleOrOutput || isDirty ? Role.Phase.PREDICATED : Role.Phase.LOADED;
		NavigableEnum navigableEnum = isNavigable ? NavigableEnum.NAVIGABLE : NavigableEnum.UNNAVIGABLE;
		PatternNodeRole stepNodeRole = PatternNodeRole.getPatternNodeRole(phase, navigableEnum, HeadableEnum.STEP);
		return stepNodeRole.createNode(region, name, callExp);
	}

	public static @NonNull Node createStepNode(@NonNull Region region, @NonNull TypedNode typedNode) {
		NodeRole stepNodeRole = PatternNodeRole.getPatternNodeRole(Role.Phase.PREDICATED, NavigableEnum.NAVIGABLE, HeadableEnum.STEP);
		return stepNodeRole.createNode(region, typedNode.getName(), typedNode.getClassDatumAnalysis());
	}

	public static @NonNull TypedNode createTrueNode(@NonNull Region region) {
		SchedulerConstants schedulerConstants = region.getSchedulerConstants();
		org.eclipse.ocl.pivot.Class booleanType = schedulerConstants.getStandardLibrary().getBooleanType();
		DomainUsage primitiveUsage = schedulerConstants.getDomainAnalysis().getPrimitiveUsage();
		ClassDatumAnalysis classDatumAnalysis = schedulerConstants.getClassDatumAnalysis(booleanType, ClassUtil.nonNullState(primitiveUsage.getTypedModel(null)));
		return TrueNodeRole.TRUE.createNode(region, "«true»", classDatumAnalysis);
	}

	public static @NonNull Node createUnknownNode(@NonNull Region region, @NonNull String name, @NonNull TypedElement typedElement) {
		return UnknownNodeRole.UNKNOWN.createNode(region, name, typedElement);
	}
}