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
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
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
	private static enum ClassableEnum { DATATYPE, CLASS };
	private static enum GuardableEnum { STEP, GUARD, HEAD };
	private static enum NavigableEnum { UNNAVIGABLE, NAVIGABLE };

	private static @NonNull ClassableEnum asClassable(boolean isClass) {
		return isClass ? ClassableEnum.CLASS : ClassableEnum.DATATYPE;
	}

	private static @NonNull NavigableEnum asNavigable(boolean isNavigable) {
		return isNavigable ? NavigableEnum.NAVIGABLE : NavigableEnum.UNNAVIGABLE;
	}

	private static abstract class AbstractSimpleNodeRole extends AbstractNodeRole
	{
		protected AbstractSimpleNodeRole(@NonNull Phase phase) {
			super(phase);
		}

		public @NonNull TypedNode createNode(@NonNull Node sourceNode, @NonNull Property source2targetProperty) {
			Region region = sourceNode.getRegion();
			assert sourceNode.isClass();
			SchedulerConstants schedulerConstants = region.getSchedulerConstants();
			org.eclipse.ocl.pivot.Class type = (org.eclipse.ocl.pivot.Class)source2targetProperty.getType();
			assert type != null;
			Type elementType = PivotUtil.getElementalType(type);
			TypedModel typedModel = elementType instanceof DataType ? schedulerConstants.getDomainAnalysis().getPrimitiveTypeModel() : sourceNode.getClassDatumAnalysis().getTypedModel();
			assert typedModel != null;
			ClassDatum classDatum = schedulerConstants.getClassDatum(type, typedModel);
			ClassDatumAnalysis classDatumAnalysis = schedulerConstants.getClassDatumAnalysis(classDatum);
			String name = source2targetProperty.getName();
			assert name != null;
			return new TypedNode(this, region, name, classDatumAnalysis);
		}

		@Override
		public @NonNull TypedNode createNode(@NonNull Region region, @NonNull String name, @NonNull ClassDatumAnalysis classDatumAnalysis) {
			return new TypedNode(this, region, name, classDatumAnalysis);
		}

		@Override
		public @NonNull TypedNode createNode(@NonNull Region region, @NonNull String name, @NonNull TypedElement typedElement) {
			return new TypedNode(this, region, name, typedElement);
		}
	}

	private static abstract class AbstractVariableNodeRole extends AbstractSimpleNodeRole
	{
		protected final @NonNull ClassableEnum classable;

		protected AbstractVariableNodeRole(@NonNull Phase phase, @NonNull ClassableEnum classable) {
			super(phase);
			this.classable = classable;
		}

		public @NonNull VariableNode createNode(@NonNull Region region, @NonNull VariableDeclaration variable) {
			assert isClass() == !(variable.getType() instanceof DataType);
			return region.createVariableNode(this, variable);
		}

		@Override
		public boolean isClass() {
			return classable == ClassableEnum.CLASS;
		}

		@Override
		public boolean isDataType() {
			return classable == ClassableEnum.DATATYPE;
		}
	}

	private static final class ComposingNodeRole extends AbstractSimpleNodeRole
	{
		public static final @NonNull NodeRole COMPOSING = new ComposingNodeRole();

		protected ComposingNodeRole() {
			super(Role.Phase.LOADED);
		}

		@Override
		public boolean isClass() {
			return true;
		}

		@Override
		public boolean isNavigable() {
			return true;
		}
	}

	private static final class ErrorNodeRole extends AbstractSimpleNodeRole
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
			return GUARD_WIDTH;
		}

		@Override
		public @NonNull String getShape() {
			return "circle";
		}
	}

	private static class ExtraGuardNodeRole extends AbstractSimpleNodeRole
	{
		public static final @NonNull NodeRole EXTRA_GUARD = new ExtraGuardNodeRole();

		protected ExtraGuardNodeRole() {
			super(Role.Phase.PREDICATED);
		}

		@Override
		public boolean isDataType() {
			return true;
		}

		@Override
		public boolean isExtraGuardVariable() {
			return true;
		}

		@Override
		public boolean isGuard() {
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
		public @NonNull Node createNode(@NonNull Region region, @NonNull String name, @NonNull ClassDatumAnalysis classDatumAnalysis) {
			throw new UnsupportedOperationException(); // FIXME Only used for obsolete cyclic regions.
		}

		@Override

		public @NonNull Node createNode(@NonNull Region region, @NonNull String name, @NonNull TypedElement typedElement) {
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

	private static final class IteratorNodeRole extends AbstractVariableNodeRole
	{
		private static final @NonNull IteratorNodeRole CONSTANT_DATATYPE_ITERATOR = new IteratorNodeRole(Role.Phase.CONSTANT, ClassableEnum.DATATYPE);
		private static final @NonNull IteratorNodeRole CONSTANT_CLASS_ITERATOR = new IteratorNodeRole(Role.Phase.CONSTANT, ClassableEnum.CLASS);
		private static final @NonNull IteratorNodeRole LOADED_DATATYPE_ITERATOR = new IteratorNodeRole(Role.Phase.LOADED, ClassableEnum.DATATYPE);
		private static final @NonNull IteratorNodeRole LOADED_CLASS_ITERATOR = new IteratorNodeRole(Role.Phase.LOADED, ClassableEnum.CLASS);
		private static final @NonNull IteratorNodeRole PREDICATED_DATATYPE_ITERATOR = new IteratorNodeRole(Role.Phase.PREDICATED, ClassableEnum.DATATYPE);
		private static final @NonNull IteratorNodeRole PREDICATED_CLASS_ITERATOR = new IteratorNodeRole(Role.Phase.PREDICATED, ClassableEnum.CLASS);

		public static @NonNull IteratorNodeRole getIteratorNodeRole(@NonNull Phase phase, @NonNull ClassableEnum classable) {
			switch (classable) {
				case CLASS: {
					switch (phase) {
						case CONSTANT: return CONSTANT_CLASS_ITERATOR;
						case LOADED: return LOADED_CLASS_ITERATOR;
						case PREDICATED: return PREDICATED_CLASS_ITERATOR;
					}
					break;
				}
				case DATATYPE:  {
					switch (phase) {
						case CONSTANT: return CONSTANT_DATATYPE_ITERATOR;
						case LOADED: return LOADED_DATATYPE_ITERATOR;
						case PREDICATED: return PREDICATED_DATATYPE_ITERATOR;
					}
					break;
				}
			}
			throw new UnsupportedOperationException();
		}

		protected IteratorNodeRole(@NonNull Phase phase, @NonNull ClassableEnum classable) {
			super(phase, classable);
		}

		@Override
		public @NonNull IteratorNodeRole asPhase(@NonNull Phase phase) {
			return getIteratorNodeRole(phase, classable);
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

	private static final class LetVariableNodeRole extends AbstractVariableNodeRole
	{
		private static final @NonNull LetVariableNodeRole CONSTANT_NAVIGABLE_DATATYPE_LET = new LetVariableNodeRole(Role.Phase.CONSTANT, NavigableEnum.NAVIGABLE, ClassableEnum.DATATYPE);
		private static final @NonNull LetVariableNodeRole CONSTANT_NAVIGABLE_CLASS_LET = new LetVariableNodeRole(Role.Phase.CONSTANT, NavigableEnum.NAVIGABLE, ClassableEnum.CLASS);
		private static final @NonNull LetVariableNodeRole CONSTANT_UNNAVIGABLE_DATATYPE_LET = new LetVariableNodeRole(Role.Phase.CONSTANT, NavigableEnum.UNNAVIGABLE, ClassableEnum.DATATYPE);
		private static final @NonNull LetVariableNodeRole CONSTANT_UNNAVIGABLE_CLASS_LET = new LetVariableNodeRole(Role.Phase.CONSTANT, NavigableEnum.UNNAVIGABLE, ClassableEnum.CLASS);
		private static final @NonNull LetVariableNodeRole LOADED_NAVIGABLE_DATATYPE_LET = new LetVariableNodeRole(Role.Phase.LOADED, NavigableEnum.NAVIGABLE, ClassableEnum.DATATYPE);
		private static final @NonNull LetVariableNodeRole LOADED_NAVIGABLE_CLASS_LET = new LetVariableNodeRole(Role.Phase.LOADED, NavigableEnum.NAVIGABLE, ClassableEnum.CLASS);
		private static final @NonNull LetVariableNodeRole LOADED_UNNAVIGABLE_DATATYPE_LET = new LetVariableNodeRole(Role.Phase.LOADED, NavigableEnum.UNNAVIGABLE, ClassableEnum.DATATYPE);
		private static final @NonNull LetVariableNodeRole LOADED_UNNAVIGABLE_CLASS_LET = new LetVariableNodeRole(Role.Phase.LOADED, NavigableEnum.UNNAVIGABLE, ClassableEnum.CLASS);
		private static final @NonNull LetVariableNodeRole PREDICATED_NAVIGABLE_DATATYPE_LET = new LetVariableNodeRole(Role.Phase.PREDICATED, NavigableEnum.NAVIGABLE, ClassableEnum.DATATYPE);
		private static final @NonNull LetVariableNodeRole PREDICATED_NAVIGABLE_CLASS_LET = new LetVariableNodeRole(Role.Phase.PREDICATED, NavigableEnum.NAVIGABLE, ClassableEnum.CLASS);
		private static final @NonNull LetVariableNodeRole PREDICATED_UNNAVIGABLE_DATATYPE_LET = new LetVariableNodeRole(Role.Phase.PREDICATED, NavigableEnum.UNNAVIGABLE, ClassableEnum.DATATYPE);
		private static final @NonNull LetVariableNodeRole PREDICATED_UNNAVIGABLE_CLASS_LET = new LetVariableNodeRole(Role.Phase.PREDICATED, NavigableEnum.UNNAVIGABLE, ClassableEnum.CLASS);

		public static @NonNull LetVariableNodeRole getLetVariableNodeRole(@NonNull Phase phase, @NonNull NavigableEnum navigable, @NonNull ClassableEnum classable) {
			switch (navigable) {
				case NAVIGABLE: {
					switch (classable) {
						case CLASS: {
							switch (phase) {
								case CONSTANT: return CONSTANT_NAVIGABLE_CLASS_LET;
								case LOADED: return LOADED_NAVIGABLE_CLASS_LET;
								case PREDICATED: return PREDICATED_NAVIGABLE_CLASS_LET;
							}
							break;
						}
						case DATATYPE: {
							switch (phase) {
								case CONSTANT: return CONSTANT_NAVIGABLE_DATATYPE_LET;
								case LOADED: return LOADED_NAVIGABLE_DATATYPE_LET;
								case PREDICATED: return PREDICATED_NAVIGABLE_DATATYPE_LET;
							}
							break;
						}
					}
					break;
				}
				case UNNAVIGABLE: {
					switch (classable) {
						case CLASS: {
							switch (phase) {
								case CONSTANT: return CONSTANT_UNNAVIGABLE_CLASS_LET;
								case LOADED: return LOADED_UNNAVIGABLE_CLASS_LET;
								case PREDICATED: return PREDICATED_UNNAVIGABLE_CLASS_LET;
							}
							break;
						}
						case DATATYPE: {
							switch (phase) {
								case CONSTANT: return CONSTANT_UNNAVIGABLE_DATATYPE_LET;
								case LOADED: return LOADED_UNNAVIGABLE_DATATYPE_LET;
								case PREDICATED: return PREDICATED_UNNAVIGABLE_DATATYPE_LET;
							}
							break;
						}
					}
					break;
				}
			}
			throw new UnsupportedOperationException();
		}

		private @NonNull NavigableEnum navigable;

		protected LetVariableNodeRole(@NonNull Phase phase, @NonNull NavigableEnum navigable, @NonNull ClassableEnum classable) {
			super(phase, classable);
			this.navigable = navigable;
		}

		@Override
		public @NonNull LetVariableNodeRole asPhase(@NonNull Phase phase) {
			return getLetVariableNodeRole(phase, navigable, classable);
		}

		@Override
		public boolean isMatchable() {
			return true;
		}

		@Override
		public boolean isNavigable() {
			return navigable == NavigableEnum.NAVIGABLE;
		}

		@Override
		public String toString() {
			return phase + (isNavigable() ? "-Navigable-" : "-Unnavigable-") + (isClass() ? "Class-" : "DataType-") + getClass().getSimpleName();
		}
	}

	private static class NullNodeRole extends AbstractSimpleNodeRole
	{
		private static final @NonNull NullNodeRole NULL = new NullNodeRole();

		private NullNodeRole() {
			super(Role.Phase.CONSTANT);
		}

		@Override
		public @Nullable String getStyle() {
			return "rounded";
		}

		@Override
		public boolean isMatchable() {
			return true;
		}

		@Override
		public boolean isNull() {
			return true;
		}

		@Override
		public boolean isPattern() {
			return true;
		}
	}

	private static class OperationNodeRole extends AbstractSimpleNodeRole
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
		public boolean isMatchable() {
			return phase != Role.Phase.REALIZED;
		}

		@Override
		public boolean isOperation() {
			return true;
		}
	}

	private static class PatternNodeRole extends AbstractVariableNodeRole
	{
		private static final @NonNull PatternNodeRole CONSTANT_NAVIGABLE_DATATYPE_STEP = new PatternNodeRole(Role.Phase.CONSTANT, ClassableEnum.DATATYPE, NavigableEnum.NAVIGABLE, GuardableEnum.STEP);
		private static final @NonNull PatternNodeRole CONSTANT_UNNAVIGABLE_DATATYPE_STEP = new PatternNodeRole(Role.Phase.CONSTANT, ClassableEnum.DATATYPE, NavigableEnum.UNNAVIGABLE, GuardableEnum.STEP);
		private static final @NonNull PatternNodeRole LOADED_NAVIGABLE_CLASS_HEAD = new PatternNodeRole(Role.Phase.LOADED, ClassableEnum.CLASS, NavigableEnum.NAVIGABLE, GuardableEnum.HEAD);
		private static final @NonNull PatternNodeRole LOADED_NAVIGABLE_DATATYPE_GUARD = new PatternNodeRole(Role.Phase.LOADED, ClassableEnum.DATATYPE, NavigableEnum.NAVIGABLE, GuardableEnum.GUARD);
		private static final @NonNull PatternNodeRole LOADED_NAVIGABLE_CLASS_GUARD = new PatternNodeRole(Role.Phase.LOADED, ClassableEnum.CLASS, NavigableEnum.NAVIGABLE, GuardableEnum.GUARD);
		private static final @NonNull PatternNodeRole LOADED_NAVIGABLE_DATATYPE_STEP = new PatternNodeRole(Role.Phase.LOADED, ClassableEnum.DATATYPE, NavigableEnum.NAVIGABLE, GuardableEnum.STEP);
		private static final @NonNull PatternNodeRole LOADED_NAVIGABLE_CLASS_STEP = new PatternNodeRole(Role.Phase.LOADED, ClassableEnum.CLASS, NavigableEnum.NAVIGABLE, GuardableEnum.STEP);
		private static final @NonNull PatternNodeRole LOADED_UNNAVIGABLE_DATATYPE_STEP = new PatternNodeRole(Role.Phase.LOADED, ClassableEnum.DATATYPE, NavigableEnum.UNNAVIGABLE, GuardableEnum.STEP);
		private static final @NonNull PatternNodeRole LOADED_UNNAVIGABLE_CLASS_STEP = new PatternNodeRole(Role.Phase.LOADED, ClassableEnum.CLASS, NavigableEnum.UNNAVIGABLE, GuardableEnum.STEP);
		private static final @NonNull PatternNodeRole PREDICATED_NAVIGABLE_CLASS_HEAD = new PatternNodeRole(Role.Phase.PREDICATED, ClassableEnum.CLASS, NavigableEnum.NAVIGABLE, GuardableEnum.HEAD);
		private static final @NonNull PatternNodeRole PREDICATED_NAVIGABLE_DATATYPE_GUARD = new PatternNodeRole(Role.Phase.PREDICATED, ClassableEnum.DATATYPE, NavigableEnum.NAVIGABLE, GuardableEnum.GUARD);
		private static final @NonNull PatternNodeRole PREDICATED_NAVIGABLE_CLASS_GUARD = new PatternNodeRole(Role.Phase.PREDICATED, ClassableEnum.CLASS, NavigableEnum.NAVIGABLE, GuardableEnum.GUARD);
		private static final @NonNull PatternNodeRole PREDICATED_NAVIGABLE_DATATYPE_STEP = new PatternNodeRole(Role.Phase.PREDICATED, ClassableEnum.DATATYPE, NavigableEnum.NAVIGABLE, GuardableEnum.STEP);
		private static final @NonNull PatternNodeRole PREDICATED_NAVIGABLE_CLASS_STEP = new PatternNodeRole(Role.Phase.PREDICATED, ClassableEnum.CLASS, NavigableEnum.NAVIGABLE, GuardableEnum.STEP);
		private static final @NonNull PatternNodeRole PREDICATED_UNNAVIGABLE_DATATYPE_HEAD = new PatternNodeRole(Role.Phase.PREDICATED, ClassableEnum.DATATYPE, NavigableEnum.UNNAVIGABLE, GuardableEnum.HEAD);
		private static final @NonNull PatternNodeRole PREDICATED_UNNAVIGABLE_CLASS_HEAD = new PatternNodeRole(Role.Phase.PREDICATED, ClassableEnum.CLASS, NavigableEnum.UNNAVIGABLE, GuardableEnum.HEAD);
		private static final @NonNull PatternNodeRole PREDICATED_UNNAVIGABLE_DATATYPE_STEP = new PatternNodeRole(Role.Phase.PREDICATED, ClassableEnum.DATATYPE, NavigableEnum.UNNAVIGABLE, GuardableEnum.STEP);
		private static final @NonNull PatternNodeRole PREDICATED_UNNAVIGABLE_CLASS_STEP = new PatternNodeRole(Role.Phase.PREDICATED, ClassableEnum.CLASS, NavigableEnum.UNNAVIGABLE, GuardableEnum.STEP);
		private static final @NonNull PatternNodeRole REALIZED_NAVIGABLE_DATATYPE_STEP = new PatternNodeRole(Role.Phase.REALIZED, ClassableEnum.DATATYPE, NavigableEnum.NAVIGABLE, GuardableEnum.STEP);
		private static final @NonNull PatternNodeRole REALIZED_UNNAVIGABLE_CLASS_STEP = new PatternNodeRole(Role.Phase.REALIZED, ClassableEnum.CLASS, NavigableEnum.UNNAVIGABLE, GuardableEnum.STEP);
		private static final @NonNull PatternNodeRole REALIZED_UNNAVIGABLE_DATATYPE_STEP = new PatternNodeRole(Role.Phase.REALIZED, ClassableEnum.DATATYPE, NavigableEnum.UNNAVIGABLE, GuardableEnum.STEP);
		private static final @NonNull PatternNodeRole SPECULATED_NAVIGABLE_CLASS_HEAD = new PatternNodeRole(Role.Phase.SPECULATED, ClassableEnum.CLASS, NavigableEnum.NAVIGABLE, GuardableEnum.HEAD);
		private static final @NonNull PatternNodeRole SPECULATED_NAVIGABLE_CLASS_GUARD = new PatternNodeRole(Role.Phase.SPECULATED, ClassableEnum.CLASS, NavigableEnum.NAVIGABLE, GuardableEnum.GUARD);
		private static final @NonNull PatternNodeRole SPECULATION_NAVIGABLE_CLASS_STEP = new PatternNodeRole(Role.Phase.SPECULATION, ClassableEnum.CLASS, NavigableEnum.NAVIGABLE, GuardableEnum.STEP);

		public static @NonNull PatternNodeRole getDataTypeNodeRole(@NonNull Node sourceNode, @NonNull Property property) {
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
			return getPatternNodeRole(phase, ClassableEnum.DATATYPE, navigableEnum, GuardableEnum.STEP);
		}

		public static @NonNull PatternNodeRole getPatternNodeRole(@NonNull Phase phase, @NonNull ClassableEnum classable, @NonNull NavigableEnum navigable, @NonNull GuardableEnum guardable) {
			switch (navigable) {
				case NAVIGABLE: {
					switch (guardable) {
						case HEAD: {
							switch (classable) {
								case CLASS: {
									switch (phase) {
										case LOADED: return LOADED_NAVIGABLE_CLASS_HEAD;
										case PREDICATED: return PREDICATED_NAVIGABLE_CLASS_HEAD;
										case SPECULATED: return SPECULATED_NAVIGABLE_CLASS_HEAD;
									}
									break;
								}
								case DATATYPE: {
									switch (phase) {
									}
									break;
								}
							}
							break;
						}
						case GUARD: {
							switch (classable) {
								case CLASS: {
									switch (phase) {
										case LOADED: return LOADED_NAVIGABLE_CLASS_GUARD;
										case PREDICATED: return PREDICATED_NAVIGABLE_CLASS_GUARD;
										case SPECULATED: return SPECULATED_NAVIGABLE_CLASS_GUARD;
									}
									break;
								}
								case DATATYPE: {
									switch (phase) {
										case LOADED: return LOADED_NAVIGABLE_DATATYPE_GUARD;
										case PREDICATED: return PREDICATED_NAVIGABLE_DATATYPE_GUARD;
									}
									break;
								}
							}
							break;
						}
						case STEP: {
							switch (classable) {
								case CLASS: {
									switch (phase) {
										case LOADED: return LOADED_NAVIGABLE_CLASS_STEP;
										case PREDICATED: return PREDICATED_NAVIGABLE_CLASS_STEP;
										case SPECULATION: return SPECULATION_NAVIGABLE_CLASS_STEP;
									}
									break;
								}
								case DATATYPE: {
									switch (phase) {
										case CONSTANT: return CONSTANT_NAVIGABLE_DATATYPE_STEP;
										case LOADED: return LOADED_NAVIGABLE_DATATYPE_STEP;
										case PREDICATED: return PREDICATED_NAVIGABLE_DATATYPE_STEP;
										case REALIZED: return REALIZED_NAVIGABLE_DATATYPE_STEP;
									}
									break;
								}
							}
							break;
						}
					}
					break;
				}
				case UNNAVIGABLE: {
					switch (guardable) {
						case HEAD: {
							switch (classable) {
								case CLASS: {
									switch (phase) {
										case PREDICATED: return PREDICATED_UNNAVIGABLE_CLASS_HEAD;
									}
									break;
								}
								case DATATYPE: {
									switch (phase) {
										case PREDICATED: return PREDICATED_UNNAVIGABLE_DATATYPE_HEAD;
									}
									break;
								}
							}
							break;
						}
						case GUARD: {
							break;
						}
						case STEP: {
							switch (classable) {
								case CLASS: {
									switch (phase) {
										case LOADED: return LOADED_UNNAVIGABLE_CLASS_STEP;
										case PREDICATED: return PREDICATED_UNNAVIGABLE_CLASS_STEP;
										case REALIZED: return REALIZED_UNNAVIGABLE_CLASS_STEP;
									}
									break;
								}
								case DATATYPE: {
									switch (phase) {
										case CONSTANT: return CONSTANT_UNNAVIGABLE_DATATYPE_STEP;
										case LOADED: return LOADED_UNNAVIGABLE_DATATYPE_STEP;
										case PREDICATED: return PREDICATED_UNNAVIGABLE_DATATYPE_STEP;
										case REALIZED: return REALIZED_UNNAVIGABLE_DATATYPE_STEP;
									}
									break;
								}
							}
							break;
						}
					}
					break;
				}
			}
			throw new UnsupportedOperationException();
		}

		private final @NonNull NavigableEnum navigable;
		private final @NonNull GuardableEnum guardable;

		private PatternNodeRole(@NonNull Phase phase, @NonNull ClassableEnum classable, @NonNull NavigableEnum navigable, @NonNull GuardableEnum guardable) {
			super(phase, classable);
			this.navigable = navigable;
			this.guardable = guardable;
		}

		@Override
		public @NonNull NodeRole asNavigable() {
			return getPatternNodeRole(phase, classable, NavigableEnum.NAVIGABLE, guardable);
		}

		@Override
		public @NonNull PatternNodeRole asPhase(@NonNull Phase phase) {
			return getPatternNodeRole(phase, classable, navigable, guardable);
		}

		@Override
		public @NonNull NodeRole asSpeculated() {
			return getPatternNodeRole(Phase.SPECULATED, classable, NavigableEnum.NAVIGABLE, GuardableEnum.HEAD);
		}

		@Override
		public @NonNull NodeRole asSpeculation() {
			return getPatternNodeRole(Phase.SPECULATION, classable, NavigableEnum.NAVIGABLE, guardable);
		}

		@Override
		public boolean isGuard() {
			return guardable != GuardableEnum.STEP;
		}

		@Override
		public boolean isHead() {
			return guardable == GuardableEnum.HEAD;
		}

		@Override
		public boolean isMatchable() {
			return isGuard();
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
			assert isClass() == nodeRole.isClass();
			Phase mergedPhase = RegionUtil.mergeToMoreKnownPhase(this, nodeRole).getPhase();
			NavigableEnum mergedNavigable;
			GuardableEnum mergedGuardable;
			if (mergedPhase == Phase.REALIZED) {
				mergedNavigable = NavigableEnum.UNNAVIGABLE;
				mergedGuardable = GuardableEnum.STEP;
			}
			else {
				mergedNavigable = Nodes.asNavigable(isNavigable() || nodeRole.isNavigable());
				mergedGuardable = (isHead() && nodeRole.isHead()) ? GuardableEnum.HEAD : isGuard() || nodeRole.isGuard() ? GuardableEnum.GUARD : GuardableEnum.STEP;
			}
			return getPatternNodeRole(mergedPhase, classable, mergedNavigable, mergedGuardable);
		}

		@Override
		public @NonNull NodeRole resetHead() {
			return getPatternNodeRole(phase, classable, navigable, !isGuard() ? GuardableEnum.STEP : GuardableEnum.GUARD);
		}

		@Override
		public @NonNull NodeRole setHead() {
			return getPatternNodeRole(phase, classable, navigable, GuardableEnum.HEAD);
		}

		@Override
		public String toString() {
			return phase + (isNavigable() ? "-Navigable" : "-Unnavigable") + (isClass() ? "-Class" : "-DataType") + (isHead() ? "Head-" : isGuard() ? "Guard-" : "Step-") + getClass().getSimpleName();
		}
	}

	// FIXME Can this be merged into PatternNodeRole ??
	private static final class PredicatedInternalNodeRole extends AbstractSimpleNodeRole
	{
		public static final @NonNull PredicatedInternalNodeRole PREDICATED_INTERNAL_CLASS = new PredicatedInternalNodeRole();

		private PredicatedInternalNodeRole() {
			super(Role.Phase.PREDICATED);
		}

		@Override
		public boolean isDataType() {
			return true;
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

	private static final class TrueNodeRole extends AbstractSimpleNodeRole
	{
		private static final @NonNull TrueNodeRole TRUE = new TrueNodeRole();

		private TrueNodeRole() {
			super(Role.Phase.CONSTANT);
		}

		@Override
		public @Nullable String getStyle() {
			return null;
		}

		@Override
		public boolean isHead() {
			return true;
		}

		@Override
		public boolean isMatchable() {
			return true;
		}

		@Override
		public boolean isPattern() {
			return true;
		}

		@Override
		public boolean isTrue() {
			return true;
		}
	}

	private static final class UnknownNodeRole extends AbstractSimpleNodeRole
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
		return ComposingNodeRole.COMPOSING.createNode(region, name, classDatumAnalysis);
	}

	public static @NonNull TypedNode createDataTypeNode(@NonNull Node sourceNode, @NonNull Property property) {
		PatternNodeRole patternNodeRole = PatternNodeRole.getDataTypeNodeRole(sourceNode, property);
		return patternNodeRole.createNode(sourceNode, property);
	}

	public static @NonNull TypedNode createDataTypeNode(@NonNull Node sourceNode, @NonNull NavigationCallExp navigationCallExp) {
		Property property = PivotUtil.getReferredProperty(navigationCallExp);
		PatternNodeRole patternNodeRole = PatternNodeRole.getDataTypeNodeRole(sourceNode, property);
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
		PatternNodeRole patternNodeRole = PatternNodeRole.getPatternNodeRole(phase, ClassableEnum.DATATYPE, NavigableEnum.NAVIGABLE, GuardableEnum.STEP);
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

	public static @NonNull Node createExtraGuardNode(@NonNull Region region, @NonNull String name, @NonNull ClassDatumAnalysis classDatumAnalysis) {
		return ExtraGuardNodeRole.EXTRA_GUARD.createNode(region, name, classDatumAnalysis);
	}

	public static @NonNull VariableNode createGuardNode(@NonNull Region region, @NonNull VariableDeclaration variable) {
		DomainUsage domainUsage = region.getSchedulerConstants().getDomainUsage(variable);
		boolean isEnforceable = domainUsage.isOutput() || domainUsage.isMiddle();
		ClassableEnum classable = asClassable(!(variable.getType() instanceof DataType));
		Role.Phase phase = isEnforceable ? Role.Phase.PREDICATED : Role.Phase.LOADED;
		PatternNodeRole patternNodeRole = PatternNodeRole.getPatternNodeRole(phase, classable, NavigableEnum.NAVIGABLE, GuardableEnum.GUARD);
		return patternNodeRole.createNode(region, variable);
	}

	public static @NonNull Node createInputNode(@NonNull Region region, NodeRole.@NonNull Phase nodeRolePhase, @NonNull String name, @NonNull ClassDatumAnalysis classDatumAnalysis) {
		return InputNodeRole.createInputNode(region, nodeRolePhase, name, classDatumAnalysis);
	}

	public static @NonNull VariableNode createIteratorNode(@NonNull Variable iterator, @NonNull Node sourceNode) {
		ClassableEnum classable = asClassable(!(iterator.getType() instanceof DataType));
		IteratorNodeRole nodeRole = IteratorNodeRole.getIteratorNodeRole(sourceNode.getNodeRole().getPhase(), classable);
		return nodeRole.createNode(sourceNode.getRegion(), iterator);
	}

	public static @NonNull VariableNode createLetVariableNode(@NonNull Variable letVariable, @NonNull Node inNode) {
		ClassableEnum classable = asClassable(!(letVariable.getType() instanceof DataType));
		NavigableEnum resolvedIsNavigable = asNavigable(inNode.isNavigable());
		LetVariableNodeRole nodeRole = LetVariableNodeRole.getLetVariableNodeRole(inNode.getNodeRole().getPhase(), resolvedIsNavigable, classable);
		return nodeRole.createNode(inNode.getRegion(), letVariable);
	}

	public static @NonNull VariableNode createLoadedStepNode(@NonNull Region region, @NonNull VariableDeclaration stepVariable) {
		ClassableEnum classable = asClassable(!(stepVariable.getType() instanceof DataType));
		PatternNodeRole patternNodeRole = PatternNodeRole.getPatternNodeRole(Role.Phase.LOADED, classable, NavigableEnum.NAVIGABLE, GuardableEnum.STEP);
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

	public static @NonNull TypedNode createOperationElementNode(@NonNull Region region, @NonNull String name, @NonNull ClassDatumAnalysis classDatumAnalysis, @NonNull Node sourceNode) {
		PatternNodeRole patternNodeRole = PatternNodeRole.getPatternNodeRole(sourceNode.getNodeRole().getPhase(), ClassableEnum.DATATYPE, NavigableEnum.NAVIGABLE, GuardableEnum.STEP);
		return patternNodeRole.createNode(region, name, classDatumAnalysis);
	}

	public static @NonNull TypedNode createOperationNode(@NonNull Region region, @NonNull String name, @NonNull TypedElement typedElement, @NonNull Node... argNodes) {
		Role.Phase nodePhase = OperationNodeRole.getOperationNodePhase(region, typedElement, argNodes);
		OperationNodeRole nodeRole = OperationNodeRole.getOperationNodeRole(nodePhase);
		return nodeRole.createNode(region, name, typedElement);
	}

	public static @NonNull TypedNode createOperationParameterNode(@NonNull Region region, @NonNull String name, @NonNull ClassDatumAnalysis classDatumAnalysis) {
		ClassableEnum classable = asClassable(!(classDatumAnalysis.getClassDatum().getType() instanceof DataType));
		PatternNodeRole patternNodeRole = PatternNodeRole.getPatternNodeRole(Role.Phase.PREDICATED, classable, NavigableEnum.UNNAVIGABLE, GuardableEnum.HEAD);
		return patternNodeRole.createNode(region, name, classDatumAnalysis);
	}

	public static @NonNull TypedNode createOperationResultNode(@NonNull Region region, @NonNull String name, @NonNull ClassDatumAnalysis classDatumAnalysis, @NonNull Node sourceNode) {
		ClassableEnum classable = asClassable(!(classDatumAnalysis.getClassDatum().getType() instanceof DataType));
		PatternNodeRole patternNodeRole = PatternNodeRole.getPatternNodeRole(sourceNode.getNodeRole().getPhase(), classable, NavigableEnum.UNNAVIGABLE, GuardableEnum.STEP);
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
		return PredicatedInternalNodeRole.PREDICATED_INTERNAL_CLASS.createNode(parentNode.getRegion(), name, classDatumAnalysis);
	}

	public static @NonNull Node createPredicatedInternalClassNode(@NonNull Region region, @NonNull String name, @NonNull ClassDatumAnalysis classDatumAnalysis) {
		return PredicatedInternalNodeRole.PREDICATED_INTERNAL_CLASS.createNode(region, name, classDatumAnalysis);
	}

	public static @NonNull TypedNode createRealizedDataTypeNode(@NonNull Node sourceNode, @NonNull Property source2targetProperty) {
		PatternNodeRole patternNodeRole = PatternNodeRole.getPatternNodeRole(Role.Phase.REALIZED, ClassableEnum.DATATYPE, NavigableEnum.UNNAVIGABLE, GuardableEnum.STEP);
		return patternNodeRole.createNode(sourceNode, source2targetProperty);
	}

	public static @NonNull VariableNode createRealizedStepNode(@NonNull Region region, @NonNull Variable stepVariable) {
		ClassableEnum classable = asClassable(!(stepVariable.getType() instanceof DataType));
		PatternNodeRole patternNodeRole = PatternNodeRole.getPatternNodeRole(Role.Phase.REALIZED, classable, NavigableEnum.UNNAVIGABLE, GuardableEnum.STEP);
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
		ClassableEnum classable = asClassable(sourceNode.isClass());
		PatternNodeRole stepNodeRole = PatternNodeRole.getPatternNodeRole(phase, classable, navigableEnum, GuardableEnum.STEP);
		return stepNodeRole.createNode(region, name, callExp);
	}

	public static @NonNull Node createStepNode(@NonNull Region region, @NonNull TypedNode typedNode) {
		NodeRole stepNodeRole = PatternNodeRole.getPatternNodeRole(Role.Phase.PREDICATED, asClassable(typedNode.isClass()), NavigableEnum.NAVIGABLE, GuardableEnum.STEP);
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

	/*	public static @NonNull VariableNode createUnrealizedStepNode(@NonNull Region region, @NonNull VariableDeclaration stepVariable) {
	/*	SchedulerConstants schedulerConstants = region.getSchedulerConstants();
		org.eclipse.ocl.pivot.Class type = (org.eclipse.ocl.pivot.Class)stepVariable.getType();
		assert type != null;
		Type elementType = QVTbaseUtil.getElementalType(type);
		TypedModel typedModel = elementType instanceof DataType ? schedulerConstants.getDomainAnalysis().getPrimitiveTypeModel() : sourceNode.getClassDatumAnalysis().getTypedModel();
		assert typedModel != null;
		ClassDatum classDatum = schedulerConstants.getClassDatum(type, typedModel);
		ClassDatumAnalysis classDatumAnalysis = schedulerConstants.getClassDatumAnalysis(classDatum); * /
	//	throw new UnsupportedOperationException();			// FIXME experimenting
		ClassableEnum classable = asClassable(!(stepVariable.getType() instanceof DataType));
		PatternNodeRole patternNodeRole = PatternNodeRole.getPatternNodeRole(Role.Phase.LOADDED, classable, NavigableEnum.NAVIGABLE, GuardableEnum.STEP);
		return patternNodeRole.createNode(region, stepVariable);
	} */
}