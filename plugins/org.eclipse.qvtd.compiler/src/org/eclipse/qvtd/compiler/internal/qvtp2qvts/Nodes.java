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
	public static abstract class AbstractSimpleNodeRole extends AbstractNodeRole
	{
		protected AbstractSimpleNodeRole(@NonNull Phase phase) {
			super(phase);
		}

		@Override
		public @NonNull Node createNode(@NonNull Region region, @NonNull String name, @NonNull ClassDatumAnalysis classDatumAnalysis) {
			return new TypedNode(this, region, name, classDatumAnalysis);
		}

		@Override
		public @NonNull Node createNode(@NonNull Region region, @NonNull String name, @NonNull TypedElement typedElement) {
			return new TypedNode(this, region, name, typedElement);
		}
	}

	public static abstract class AbstractVariableNodeRole extends AbstractSimpleNodeRole
	{
		protected final boolean isClassNode;

		protected AbstractVariableNodeRole(@NonNull Phase phase, boolean isClassNode) {
			super(phase);
			this.isClassNode = isClassNode;
		}

		public @NonNull VariableNode createNode(@NonNull Region region, @NonNull VariableDeclaration variable) {
			assert isClassNode == !(variable.getType() instanceof DataType);
			return region.createVariableNode(this, variable);
		}

		@Override
		public boolean isClassNode() {
			//			return !(classDatumAnalysis.getClassDatum().getType() instanceof DataType);
			return isClassNode;
		}
	}

	public static final class AttributeNodeRoleFactory
	{
		private static abstract class AbstractDataTypeNodeRole extends AbstractSimpleNodeRole
		{
			private final boolean isNavigable;

			protected AbstractDataTypeNodeRole(@NonNull Phase phase, boolean isNavigable) {
				super(phase);
				this.isNavigable = isNavigable;
			}

			@Override
			public boolean isDataTypeNode() {
				return true;
			}

			@Override
			public boolean isNavigable() {
				return isNavigable;
			}

			@Override
			public String toString() {
				return phase + (isNavigable ? "-NAVIGABLE-" : "-UNNAVIGABLE-") + getClass().getSimpleName();
			}
		}

		public static class DataTypeNodeRole extends AbstractDataTypeNodeRole
		{
			private boolean isDataType;

			protected DataTypeNodeRole(@NonNull Phase phase, boolean isDataType, boolean isNavigable) {
				super(phase, isNavigable);
				this.isDataType = isDataType;
			}

			public @NonNull Node createNode(@NonNull Region region, @NonNull Node parentNode, @NonNull NavigationCallExp navigationCallExp) {
				assert parentNode.isClassNode();
				//				SchedulerConstants schedulerConstants = region.getSchedulerConstants();
				Property referredProperty = PivotUtil.getReferredProperty(navigationCallExp);
				assert referredProperty != null;
				//				Type type = navigationCallExp.getType();
				//				assert type != null;
				//				ClassDatum classDatum = schedulerConstants.getClassDatum(type);
				//				DomainUsage domainUsage = parentNode.getClassDatumAnalysis().getDomainUsage();
				//				ClassDatumAnalysis classDatumAnalysis = schedulerConstants.getClassDatumAnalysis(classDatum, domainUsage);
				String name = referredProperty.getName();
				assert name != null;
				return createNode(region, name, navigationCallExp);
			}

			public @NonNull Node createNode(@NonNull Region region, @NonNull Node parentNode, @NonNull Property property) {
				//				assert parentNode.isClassNode();  -- computed attaributes have an operation parentNode
				SchedulerConstants schedulerConstants = region.getSchedulerConstants();
				org.eclipse.ocl.pivot.Class type = (org.eclipse.ocl.pivot.Class)property.getType();
				assert type != null;
				Type elementType = QVTbaseUtil.getElementalType(type);
				TypedModel typedModel = elementType instanceof DataType ? region.getSchedulerConstants().getDomainAnalysis().getPrimitiveTypeModel() : parentNode.getClassDatumAnalysis().getTypedModel();
				//				DomainUsage usage = region.getSchedulerConstants().getDomainAnalysis().getUsage(type);
				//				assert usage != null;
				//				TypedModel typedModel = usage.getTypedModel();
				assert typedModel != null;
				ClassDatum classDatum = schedulerConstants.getClassDatum(type, typedModel);
				//				DomainUsage domainUsage = parentNode.getClassDatumAnalysis().getDomainUsage();
				ClassDatumAnalysis classDatumAnalysis = schedulerConstants.getClassDatumAnalysis(classDatum);
				String name = property.getName();
				assert name != null;
				return createNode(region, name, classDatumAnalysis);
			}

			@Override
			public boolean isMatchable() {
				return true;
			}

			@Override
			public @Nullable String getStyle() {
				return isDataType ? "rounded" : null;
			}

			@Override
			public @NonNull NodeRole merge(@NonNull NodeRole nodeRole) {
				if (nodeRole == REALIZED_DATATYPE) {
					return nodeRole;
				}
				if (getClass() != nodeRole.getClass()) {
					throw new IllegalStateException(this + " cannot be merged");
				}
				return this.compareTo(nodeRole) < 0 ? this : nodeRole;
			}
		}

		public static class ExtraGuardNodeRole extends AbstractDataTypeNodeRole
		{
			protected ExtraGuardNodeRole() {
				super(Role.Phase.PREDICATED, false);
			}

			@Override
			public boolean isExtraGuardVariable() {
				return true;
			}

			@Override
			public boolean isGuardVariable() {
				return true;
			}

			@Override
			public boolean isHead() {
				return true;
			}
		}

		public static final class RealizedDataTypeNodeRole extends AbstractDataTypeNodeRole
		{
			protected RealizedDataTypeNodeRole() {
				super(Role.Phase.REALIZED, false);
			}

			public @NonNull Node createNode(@NonNull Region region, @NonNull Node parentNode, @NonNull Property property) {
				assert parentNode.isClassNode();
				SchedulerConstants schedulerConstants = region.getSchedulerConstants();
				org.eclipse.ocl.pivot.Class type = (org.eclipse.ocl.pivot.Class)property.getType();
				assert type != null;
				Type elementType = QVTbaseUtil.getElementalType(type);
				TypedModel typedModel = elementType instanceof DataType ? region.getSchedulerConstants().getDomainAnalysis().getPrimitiveTypeModel() : parentNode.getClassDatumAnalysis().getTypedModel();
				//				DomainUsage usage = region.getSchedulerConstants().getDomainAnalysis().getUsage(type);
				//				assert usage != null;
				//				TypedModel typedModel = usage.getTypedModel();
				assert typedModel != null;
				ClassDatum classDatum = schedulerConstants.getClassDatum(type, typedModel);
				//				DomainUsage domainUsage = parentNode.getClassDatumAnalysis().getDomainUsage();
				ClassDatumAnalysis classDatumAnalysis = schedulerConstants.getClassDatumAnalysis(classDatum);
				String name = property.getName();
				assert name != null;
				return createNode(region, name, classDatumAnalysis);
			}

			@Override
			public @Nullable String getStyle() {
				return "rounded";
			}

			@Override
			public @NonNull NodeRole merge(@NonNull NodeRole nodeRole) {
				if (nodeRole.getPhase() == Phase.PREDICATED) {
					return this;
				}
				return super.merge(nodeRole);
			}

			@Override
			public String toString() {
				return getClass().getSimpleName();
			}
		}

		public static final class PredicatedInternalNodeRole extends AbstractDataTypeNodeRole
		{
			protected PredicatedInternalNodeRole() {
				super(Role.Phase.PREDICATED, false);
			}

			public @NonNull Node createNode(@NonNull Region region, @NonNull Node parentNode, @NonNull NavigationAssignment navigationAssignment) {
				assert parentNode.isClassNode();
				SchedulerConstants schedulerConstants = region.getSchedulerConstants();
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
				return createNode(region, name, classDatumAnalysis);
			}

			@Override
			public boolean isInternal() {
				return true;
			}

			/*			@Override
			public @NonNull NodeRole merge(@NonNull NodeRole nodeRole) {
				if (nodeRole.getPhase() == Phase.PREDICATED) {
					return this;
				}
				return super.merge(nodeRole);
			} */

			@Override
			public String toString() {
				return getClass().getSimpleName();
			}
		}

		private static final @NonNull DataTypeNodeRole LOADED_NAVIGABLE_DATATYPE = new DataTypeNodeRole(Role.Phase.LOADED, true, true);
		private static final @NonNull DataTypeNodeRole LOADED_UNNAVIGABLE_DATATYPE = new DataTypeNodeRole(Role.Phase.LOADED, true, false);
		private static final @NonNull DataTypeNodeRole PREDICATED_NAVIGABLE_DATATYPE = new DataTypeNodeRole(Role.Phase.PREDICATED, true, true);
		private static final @NonNull DataTypeNodeRole PREDICATED_UNNAVIGABLE_DATATYPE = new DataTypeNodeRole(Role.Phase.PREDICATED, true, false);
		public static final @NonNull PredicatedInternalNodeRole PREDICATED_CLASS = new PredicatedInternalNodeRole();

		private final @Nullable Boolean isNavigable;

		public AttributeNodeRoleFactory(@Nullable Boolean isNavigable) {
			this.isNavigable = isNavigable;
		}

		public @NonNull Node createNode(@NonNull Region region, @NonNull Node parentNode, @NonNull NavigationCallExp navigationCallExp) {
			boolean resolvedNavigable = isNavigable != null ? isNavigable.booleanValue() : parentNode.isNavigable();
			Property referredProperty = PivotUtil.getReferredProperty(navigationCallExp);
			assert referredProperty != null;
			boolean isDirty = region.getSchedulerConstants().isDirty(referredProperty);
			DataTypeNodeRole attributeNodeRole = getAttributeNodeRole(parentNode, resolvedNavigable, isDirty);
			if (attributeNodeRole != null) {
				return attributeNodeRole.createNode(parentNode.getRegion(), parentNode, navigationCallExp);
			}
			if (parentNode.isRealized()) {
				return REALIZED_DATATYPE.createNode(parentNode.getRegion(), parentNode, referredProperty);
			}
			else {
				throw new UnsupportedOperationException();
			}
		}

		public @NonNull Node createNode(@NonNull Region region, @NonNull Node parentNode, @NonNull Property property) {
			boolean resolvedNavigable = isNavigable != null ? isNavigable.booleanValue() : parentNode.isNavigable();
			boolean isDirty = region.getSchedulerConstants().isDirty(property);
			DataTypeNodeRole attributeNodeRole = getAttributeNodeRole(parentNode, resolvedNavigable, isDirty);
			if (attributeNodeRole != null) {
				return attributeNodeRole.createNode(parentNode.getRegion(), parentNode, property);
			}
			if (parentNode.isRealized()) {
				return REALIZED_DATATYPE.createNode(parentNode.getRegion(), parentNode, property);
			}
			else {
				throw new UnsupportedOperationException();
			}
		}

		private @Nullable DataTypeNodeRole getAttributeNodeRole(@NonNull Node sourceNode, boolean isNavigable, boolean isDirty) {
			if (sourceNode.isLoaded()) {
				if (!isDirty) {
					return isNavigable ? LOADED_NAVIGABLE_DATATYPE : LOADED_UNNAVIGABLE_DATATYPE;
				}
				else {
					return isNavigable ? PREDICATED_NAVIGABLE_DATATYPE : PREDICATED_UNNAVIGABLE_DATATYPE;
				}
			}
			else if (sourceNode.isPredicated()) {
				return isNavigable ? PREDICATED_NAVIGABLE_DATATYPE : PREDICATED_UNNAVIGABLE_DATATYPE;
			}
			return null;
		}
	}

	private static final class ComposingNodeRole extends AbstractSimpleNodeRole
	{
		protected ComposingNodeRole() {
			super(Role.Phase.LOADED);
		}

		@Override
		public boolean isClassNode() {
			return true;
		}

		@Override
		public boolean isNavigable() {
			return true;
		}
	}

	public static final class ElementNodeRoleFactory
	{
		private static abstract class AbstractElementNodeRole extends AbstractSimpleNodeRole
		{
			protected AbstractElementNodeRole(@NonNull Phase phase) {
				super(phase);
			}

			@Override
			public boolean isClassNode() {
				return true;
			}

			@Override
			public boolean isMatchable() {
				return true;
			}

			@Override
			public boolean isNavigable() {
				return true;
			}

			@Override
			public String toString() {
				return getClass().getSimpleName();
			}
		}

		private static final class LoadedElementNodeRole extends AbstractElementNodeRole
		{
			protected LoadedElementNodeRole() {
				super(Role.Phase.LOADED);
			}

			@Override
			public @NonNull NodeRole merge(@NonNull NodeRole nodeRole) {
				if (nodeRole.isHead()) {
					return this;
				}
				return super.merge(nodeRole);
			}
		}

		public static final class PredicatedElementNodeRole extends AbstractElementNodeRole
		{
			protected PredicatedElementNodeRole() {
				super(Role.Phase.PREDICATED);
			}

			@Override
			public @NonNull NodeRole merge(@NonNull NodeRole nodeRole) {
				if (nodeRole.isHead()) {
					return this;
				}
				if (nodeRole instanceof RealizedVariableNodeRole) {
					return nodeRole;
				}
				return super.merge(nodeRole);
			}
		}

		private static final @NonNull LoadedElementNodeRole LOADED_ELEMENT = new LoadedElementNodeRole();
		public static final @NonNull PredicatedElementNodeRole PREDICATED_ELEMENT = new PredicatedElementNodeRole();

		public @NonNull Node createNode(@NonNull Region region, @NonNull String name, @NonNull ClassDatumAnalysis classDatumAnalysis, @NonNull Node sourceNode) {
			if (sourceNode.isPredicated()) {
				return PREDICATED_ELEMENT.createNode(region, name, classDatumAnalysis);
			}
			else {
				return LOADED_ELEMENT.createNode(region, name, classDatumAnalysis);
			}
		}
	}

	private static final class ErrorNodeRole extends AbstractSimpleNodeRole
	{
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

	public static final class IteratorNodeRole extends AbstractVariableNodeRole
	{
		private static final @NonNull IteratorNodeRole CONSTANT_DATATYPE_ITERATOR = new IteratorNodeRole(Role.Phase.CONSTANT, false);
		private static final @NonNull IteratorNodeRole CONSTANT_CLASS_ITERATOR = new IteratorNodeRole(Role.Phase.CONSTANT, true);
		private static final @NonNull IteratorNodeRole LOADED_DATATYPE_ITERATOR = new IteratorNodeRole(Role.Phase.LOADED, false);
		private static final @NonNull IteratorNodeRole LOADED_CLASS_ITERATOR = new IteratorNodeRole(Role.Phase.LOADED, true);
		private static final @NonNull IteratorNodeRole PREDICATED_DATATYPE_ITERATOR = new IteratorNodeRole(Role.Phase.PREDICATED, false);
		private static final @NonNull IteratorNodeRole PREDICATED_CLASS_ITERATOR = new IteratorNodeRole(Role.Phase.PREDICATED, true);

		public static @NonNull Node createIteratorNode(@NonNull Region region, @NonNull Variable iterator, @NonNull Node sourceNode) {
			boolean resolvedIsClassNode = !(iterator.getType() instanceof DataType);
			IteratorNodeRole nodeRole = getIteratorNodeRole(sourceNode.getNodeRole().getPhase(), resolvedIsClassNode);
			return nodeRole.createNode(region, iterator);
		}

		public static @NonNull IteratorNodeRole getIteratorNodeRole(@NonNull Phase phase, boolean isClassNode) {
			if (isClassNode) {
				switch (phase) {
					case CONSTANT: return CONSTANT_CLASS_ITERATOR;
					case LOADED: return LOADED_CLASS_ITERATOR;
					case PREDICATED: return PREDICATED_CLASS_ITERATOR;
				}
			}
			else {
				switch (phase) {
					case CONSTANT: return CONSTANT_DATATYPE_ITERATOR;
					case LOADED: return LOADED_DATATYPE_ITERATOR;
					case PREDICATED: return PREDICATED_DATATYPE_ITERATOR;
				}
			}
			throw new UnsupportedOperationException();
		}

		protected IteratorNodeRole(@NonNull Phase phase, boolean isClassNode) {
			super(phase, isClassNode);
		}

		@Override
		public @NonNull IteratorNodeRole asPhase(@NonNull Phase phase) {
			return getIteratorNodeRole(phase, isClassNode());
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

	public static final class LetVariableNodeRole extends AbstractVariableNodeRole
	{
		private static final @NonNull LetVariableNodeRole CONSTANT_NAVIGABLE_DATATYPE_LET = new LetVariableNodeRole(Role.Phase.CONSTANT, true, false);
		private static final @NonNull LetVariableNodeRole CONSTANT_NAVIGABLE_CLASS_LET = new LetVariableNodeRole(Role.Phase.CONSTANT, true, true);
		private static final @NonNull LetVariableNodeRole CONSTANT_UNNAVIGABLE_DATATYPE_LET = new LetVariableNodeRole(Role.Phase.CONSTANT, false, false);
		private static final @NonNull LetVariableNodeRole CONSTANT_UNNAVIGABLE_CLASS_LET = new LetVariableNodeRole(Role.Phase.CONSTANT, false, true);
		private static final @NonNull LetVariableNodeRole LOADED_NAVIGABLE_DATATYPE_LET = new LetVariableNodeRole(Role.Phase.LOADED, true, false);
		private static final @NonNull LetVariableNodeRole LOADED_NAVIGABLE_CLASS_LET = new LetVariableNodeRole(Role.Phase.LOADED, true, true);
		private static final @NonNull LetVariableNodeRole LOADED_UNNAVIGABLE_DATATYPE_LET = new LetVariableNodeRole(Role.Phase.LOADED, false, false);
		private static final @NonNull LetVariableNodeRole LOADED_UNNAVIGABLE_CLASS_LET = new LetVariableNodeRole(Role.Phase.LOADED, false, true);
		private static final @NonNull LetVariableNodeRole PREDICATED_NAVIGABLE_DATATYPE_LET = new LetVariableNodeRole(Role.Phase.PREDICATED, true, false);
		private static final @NonNull LetVariableNodeRole PREDICATED_NAVIGABLE_CLASS_LET = new LetVariableNodeRole(Role.Phase.PREDICATED, true, true);
		private static final @NonNull LetVariableNodeRole PREDICATED_UNNAVIGABLE_DATATYPE_LET = new LetVariableNodeRole(Role.Phase.PREDICATED, false, false);
		private static final @NonNull LetVariableNodeRole PREDICATED_UNNAVIGABLE_CLASS_LET = new LetVariableNodeRole(Role.Phase.PREDICATED, false, true);

		public static @NonNull Node createLetVariableNode(@NonNull Region region, @NonNull Variable letVariable, @NonNull Node inNode) {
			//			Boolean resolvedIsClassNode = isClassNode;
			//			if (resolvedIsClassNode == null) {
			//				resolvedIsClassNode = !(letVariable.getType() instanceof DataType);
			//			}
			boolean resolvedIsClassNode = !(letVariable.getType() instanceof DataType);
			boolean resolvedIsNavigable = inNode.isNavigable();
			LetVariableNodeRole nodeRole = getLetVariableNodeRole(inNode.getNodeRole().getPhase(), resolvedIsNavigable, resolvedIsClassNode);
			return nodeRole.createNode(region, letVariable);
		}

		public static @NonNull LetVariableNodeRole getLetVariableNodeRole(@NonNull Phase phase, boolean isNavigable, boolean isClassNode) {
			if (isNavigable) {
				if (isClassNode) {
					switch (phase) {
						case CONSTANT: return CONSTANT_NAVIGABLE_CLASS_LET;
						case LOADED: return LOADED_NAVIGABLE_CLASS_LET;
						case PREDICATED: return PREDICATED_NAVIGABLE_CLASS_LET;
					}
				}
				else {
					switch (phase) {
						case CONSTANT: return CONSTANT_NAVIGABLE_DATATYPE_LET;
						case LOADED: return LOADED_NAVIGABLE_DATATYPE_LET;
						case PREDICATED: return PREDICATED_NAVIGABLE_DATATYPE_LET;
					}
				}
			}
			else {
				if (isClassNode) {
					switch (phase) {
						case CONSTANT: return CONSTANT_UNNAVIGABLE_CLASS_LET;
						case LOADED: return LOADED_UNNAVIGABLE_CLASS_LET;
						case PREDICATED: return PREDICATED_UNNAVIGABLE_CLASS_LET;
					}
				}
				else {
					switch (phase) {
						case CONSTANT: return CONSTANT_UNNAVIGABLE_DATATYPE_LET;
						case LOADED: return LOADED_UNNAVIGABLE_DATATYPE_LET;
						case PREDICATED: return PREDICATED_UNNAVIGABLE_DATATYPE_LET;
					}
				}
			}
			throw new UnsupportedOperationException();
		}

		private boolean isNavigable;

		protected LetVariableNodeRole(@NonNull Phase phase, boolean isNavigable, boolean isClassNode) {
			super(phase, isClassNode);
			this.isNavigable = isNavigable;
		}

		@Override
		public @NonNull LetVariableNodeRole asPhase(@NonNull Phase phase) {
			return getLetVariableNodeRole(phase, isNavigable(), isClassNode());
		}

		@Override
		public boolean isMatchable() {
			return true;
		}

		@Override
		public boolean isNavigable() {
			return isNavigable;
		}

		@Override
		public String toString() {
			return phase + (isNavigable ? "-Navigable-" : "-Unnavigable-") + (isClassNode ? "Class-" : "DataType-") + getClass().getSimpleName();
		}
	}

	public static class NullNodeRole extends AbstractSimpleNodeRole
	{
		protected NullNodeRole() {
			super(Role.Phase.CONSTANT);
		}

		public @NonNull Node createNode(@NonNull Region region) {
			return createNode(region, "«null»", region.getSchedulerConstants().getOclVoidClassDatumAnalysis());
		}

		public @NonNull Node createNode(@NonNull Region region, @NonNull TypedElement typedElement) {
			return createNode(region, "«null»", typedElement);
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
	}

	public static class OperationNodeRole extends AbstractSimpleNodeRole
	{
		private static final @NonNull OperationNodeRole CONSTANT_OPERATION = new OperationNodeRole(Role.Phase.CONSTANT);
		private static final @NonNull OperationNodeRole LOADED_OPERATION = new OperationNodeRole(Role.Phase.LOADED);
		private static final @NonNull OperationNodeRole PREDICATED_OPERATION = new OperationNodeRole(Role.Phase.PREDICATED);
		private static final @NonNull OperationNodeRole REALIZED_OPERATION = new OperationNodeRole(Role.Phase.REALIZED);

		public static @NonNull Node createOperationNode(@NonNull Region region, @NonNull String name, @NonNull TypedElement typedElement, @NonNull Node... argNodes) {
			Phase nodePhase = getOperationNodePhase(region, typedElement, argNodes);
			OperationNodeRole nodeRole = getOperationNodeRole(nodePhase);
			return nodeRole.createNode(region, name, typedElement);
		}

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

	public static final class ParameterNodeRoleFactory
	{
		private static final class ParameterNodeRole extends AbstractVariableNodeRole
		{
			protected ParameterNodeRole(boolean isClassNode) {
				super(Role.Phase.PREDICATED, isClassNode);
			}

			@Override
			public boolean isHead() {
				return true;
			}
		}


		private static final @NonNull ParameterNodeRole ATTRIBUTE_PARAMETER = new ParameterNodeRole(false);
		private static final @NonNull ParameterNodeRole CLASS_PARAMETER = new ParameterNodeRole(true);

		private final @Nullable Boolean isClassNode;

		public ParameterNodeRoleFactory(@Nullable Boolean isClassNode) {
			this.isClassNode = isClassNode;
		}

		public @NonNull Node createNode(@NonNull Region region, @NonNull String name, @NonNull ClassDatumAnalysis classDatumAnalysis) {
			Boolean resolvedIsClassNode = isClassNode;
			if (resolvedIsClassNode == null) {
				resolvedIsClassNode = !(classDatumAnalysis.getClassDatum().getType() instanceof DataType);
			}
			return (resolvedIsClassNode ? CLASS_PARAMETER : ATTRIBUTE_PARAMETER).createNode(region, name, classDatumAnalysis);
		}
	}

	public static class PatternNodeRole extends AbstractVariableNodeRole
	{
		private static final @NonNull PatternNodeRole LOADED_CLASS_HEAD = new PatternNodeRole(Role.Phase.LOADED, true, true, true);
		private static final @NonNull PatternNodeRole LOADED_DATATYPE_GUARD = new PatternNodeRole(Role.Phase.LOADED, false, true, false);
		private static final @NonNull PatternNodeRole LOADED_CLASS_GUARD = new PatternNodeRole(Role.Phase.LOADED, true, true, false);
		private static final @NonNull PatternNodeRole LOADED_DATATYPE_STEP = new PatternNodeRole(Role.Phase.LOADED, false, false, false);
		private static final @NonNull PatternNodeRole LOADED_CLASS_STEP = new PatternNodeRole(Role.Phase.LOADED, true, false, false);
		private static final @NonNull PatternNodeRole PREDICATED_CLASS_HEAD = new PatternNodeRole(Role.Phase.PREDICATED, true, true, true);
		private static final @NonNull PatternNodeRole PREDICATED_DATATYPE_GUARD = new PatternNodeRole(Role.Phase.PREDICATED, false, true, false);
		private static final @NonNull PatternNodeRole PREDICATED_CLASS_GUARD = new PatternNodeRole(Role.Phase.PREDICATED, true, true, false);
		private static final @NonNull PatternNodeRole REALIZED_CLASS_STEP = new PatternNodeRole(Role.Phase.REALIZED, true, false, false);
		private static final @NonNull PatternNodeRole REALIZED_DATATYPE_STEP = new PatternNodeRole(Role.Phase.REALIZED, false, false, false);

		public static @NonNull VariableNode createGuardNode(@NonNull Region region, @NonNull VariableDeclaration guardVariable) {
			DomainUsage domainUsage = region.getSchedulerConstants().getDomainUsage(guardVariable);
			boolean isEnforceable = domainUsage.isOutput() || domainUsage.isMiddle();
			boolean isClass = !(guardVariable.getType() instanceof DataType);
			PatternNodeRole patternNodeRole = getPatternNodeRole(isEnforceable ? Phase.PREDICATED : Phase.LOADED, isClass, true, false);
			return patternNodeRole.createNode(region, guardVariable);
		}

		public static @NonNull VariableNode createRealizedStepNode(@NonNull Region region, @NonNull Variable stepVariable) {
			boolean isClass = !(stepVariable.getType() instanceof DataType);
			PatternNodeRole patternNodeRole = getPatternNodeRole(Phase.REALIZED, isClass, false, false);
			return patternNodeRole.createNode(region, stepVariable);
		}

		public static @NonNull VariableNode createUnrealizedStepNode(@NonNull Region region, @NonNull VariableDeclaration stepVariable) {
			boolean isClass = !(stepVariable.getType() instanceof DataType);
			return (isClass ? LOADED_CLASS_STEP : LOADED_DATATYPE_STEP).createNode(region, stepVariable);
		}

		public static @NonNull PatternNodeRole getPatternNodeRole(@NonNull Phase phase, boolean isClass, boolean isGuard, boolean isHead) {
			if (isHead) {
				if (isClass) {
					switch (phase) {
						case LOADED: return LOADED_CLASS_HEAD;
						case PREDICATED: return PREDICATED_CLASS_HEAD;
					}
				}
				else {
					switch (phase) {
					}
				}
			}
			else if (isGuard) {
				if (isClass) {
					switch (phase) {
						case LOADED: return LOADED_CLASS_GUARD;
						case PREDICATED: return PREDICATED_CLASS_GUARD;
					}
				}
				else {
					switch (phase) {
						case LOADED: return LOADED_DATATYPE_GUARD;
						case PREDICATED: return PREDICATED_DATATYPE_GUARD;
					}
				}
			}
			else {
				if (isClass) {
					switch (phase) {
						case LOADED: return LOADED_CLASS_STEP;
						case REALIZED: return REALIZED_CLASS_STEP;
					}
				}
				else {
					switch (phase) {
						case LOADED: return LOADED_DATATYPE_STEP;
						case REALIZED: return REALIZED_DATATYPE_STEP;
					}
				}
			}
			throw new UnsupportedOperationException();
		}

		private final boolean isGuard;
		private final boolean isHead;

		private PatternNodeRole(@NonNull Phase phase, boolean isClass, boolean isGuard, boolean isHead) {
			super(phase, isClass);
			assert !(!isGuard && isHead);
			this.isGuard = isGuard;
			this.isHead = isHead;
		}

		@Override
		public @NonNull PatternNodeRole asPhase(@NonNull Phase phase) {
			return getPatternNodeRole(phase, isClassNode, isGuard, isHead);
		}

		@Override
		public boolean isGuardVariable() {
			return isGuard;
		}

		@Override
		public boolean isHead() {
			return isHead;
		}

		@Override
		public boolean isMatchable() {
			return true;
		}

		@Override
		public boolean isNavigable() {
			return isGuard;
		}

		@Override
		public @NonNull NodeRole merge(@NonNull NodeRole nodeRole) {  // FIXME Rationalize this legacy
			if (isHead) {
				if ((phase == Phase.LOADED) && (nodeRole.getPhase() == Phase.LOADED) && (nodeRole.isGuardVariable() && !nodeRole.isHead())) {
					return nodeRole;
				}
				//				if ((phase == Phase.PREDICATED) && (nodeRole.getPhase() == Phase.PREDICATED) && (nodeRole instanceof GuardNodeRole)) {
				//					return nodeRole;
				//				}
			}
			else {
				if (nodeRole.isConstant()) {
					return nodeRole;
				}
				if ((phase == nodeRole.getPhase()) && nodeRole.isHead()) {
					return this;
				}
				//				if ((phase == Phase.PREDICATED) && (nodeRole.getPhase() == Phase.PREDICATED) && nodeRole.isHead()) {
				//					return this;
				//				}
			}
			if ((phase == Phase.PREDICATED) && !nodeRole.isGuardVariable() && nodeRole.isRealized()) { //((nodeRole == REALIZED_CLASS_STEP) || (nodeRole == REALIZED_DATATYPE_STEP))) {
				return nodeRole;
			}
			return super.merge(nodeRole);
		}

		@Override
		public @NonNull NodeRole resetHead() {
			return getPatternNodeRole(phase, isClassNode, isGuard, false);
		}

		@Override
		public @NonNull NodeRole setHead() {
			return getPatternNodeRole(phase, isClassNode, isGuard, true);
		}

		@Override
		public String toString() {
			return phase + (isClassNode ? "-Class" : "-DataType") + (isHead ? "Head-" : isGuard ? "Guard-" : "Step-") + getClass().getSimpleName();
		}
	}

	public static final class PortNodeRoleFactory
	{
		private static final class PortNodeRole extends AbstractNodeRole
		{
			//			private final boolean isHead;

			protected PortNodeRole(@NonNull Phase phase) { //, boolean isHead) {
				super(phase);
				//				this.isHead = isHead;
			}

			@Override
			public @NonNull Node createNode(@NonNull Region region, @NonNull String name, @NonNull ClassDatumAnalysis classDatumAnalysis) {
				//				return new ComplexTypedNode(this, region, name, classDatumAnalysis);
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
				return true; //isHead;
			}

			//			@Override
			//			public boolean isInput() {
			//				return isHead;
			//			}

			//			@Override
			//			public boolean isNavigable() {
			//				return true;
			//			}

			//			@Override
			//			public boolean isOutput() {
			//				return !isHead;
			//			}
		}

		private static final @NonNull PortNodeRole CONSTANT_INPUT = new PortNodeRole(Role.Phase.CONSTANT); //, true);
		//		private static final @NonNull PortNodeRole CONSTANT_OUTPUT = new PortNodeRole(Role.Phase.CONSTANT, false);
		private static final @NonNull PortNodeRole LOADED_INPUT = new PortNodeRole(Role.Phase.LOADED); //, true);
		//		private static final @NonNull PortNodeRole LOADED_OUTPUT = new PortNodeRole(Role.Phase.LOADED, false);
		private static final @NonNull PortNodeRole PREDICATED_INPUT = new PortNodeRole(Role.Phase.PREDICATED); //, true);
		//		private static final @NonNull PortNodeRole PREDICATED_OUTPUT = new PortNodeRole(Role.Phase.PREDICATED, false);
		private static final @NonNull PortNodeRole REALIZED_INPUT = new PortNodeRole(Role.Phase.REALIZED); //, true);
		//		private static final @NonNull PortNodeRole REALIZED_OUTPUT = new PortNodeRole(Role.Phase.REALIZED, false);

		//		private final boolean isHead;

		public PortNodeRoleFactory(/*boolean isHead*/) {
			//			this.isHead = isHead;
		}

		public @NonNull Node createNode(@NonNull Region region, NodeRole.@NonNull Phase nodeRolePhase, @NonNull String name, @NonNull ClassDatumAnalysis classDatumAnalysis) {
			switch (nodeRolePhase) {
				case CONSTANT: return CONSTANT_INPUT.createNode(region, name, classDatumAnalysis);
				case LOADED: return LOADED_INPUT.createNode(region, name, classDatumAnalysis);
				case PREDICATED: return PREDICATED_INPUT.createNode(region, name, classDatumAnalysis);
				case REALIZED: return REALIZED_INPUT.createNode(region, name, classDatumAnalysis);
				//				case CONSTANT: return (isHead ? CONSTANT_INPUT : CONSTANT_OUTPUT).createNode(region, name, classDatumAnalysis);
				//				case LOADED: return (isHead ? LOADED_INPUT : LOADED_OUTPUT).createNode(region, name, classDatumAnalysis);
				//				case PREDICATED: return (isHead ? PREDICATED_INPUT : PREDICATED_OUTPUT).createNode(region, name, classDatumAnalysis);
				//				case REALIZED: return (isHead ? REALIZED_INPUT : REALIZED_OUTPUT).createNode(region, name, classDatumAnalysis);
				default: throw new UnsupportedOperationException();
			}
		}
	}

	private static final class RealizedVariableNodeRole extends AbstractVariableNodeRole
	{
		protected RealizedVariableNodeRole() {
			super(Role.Phase.REALIZED, true);
		}

		@Override
		public @NonNull NodeRole merge(@NonNull NodeRole nodeRole) {
			if (nodeRole.isGuardVariable() && !nodeRole.isExtraGuardVariable()) {
				return this;
			}
			if (nodeRole instanceof StepNodeRoleFactory.AbstractStepNodeRole) {
				return this;
			}
			return super.merge(nodeRole);
		}

		@Override
		public String toString() {
			return getClass().getSimpleName();
		}
	}

	public static final class StepNodeRoleFactory
	{
		private static abstract class AbstractStepNodeRole extends AbstractSimpleNodeRole
		{
			private final boolean isNavigable;

			protected AbstractStepNodeRole(@NonNull Phase phase, boolean isNavigable) {
				super(phase);
				this.isNavigable = isNavigable;
			}

			@Override
			public boolean isClassNode() {
				return true;
			}

			@Override
			public boolean isMatchable() {
				return true;
			}

			@Override
			public boolean isNavigable() {
				return isNavigable;
			}

			@Override
			public String toString() {
				return phase + (isNavigable ? "-NAVIGABLE-" : "-UNNAVIGABLE-") + getClass().getSimpleName();
			}
		}

		private static final class LoadedStepNodeRole extends AbstractStepNodeRole
		{
			protected LoadedStepNodeRole(boolean isNavigable) {
				super(Role.Phase.LOADED, isNavigable);
			}

			@Override
			public @NonNull NodeRole merge(@NonNull NodeRole nodeRole) {
				if (nodeRole.isHead()) {
					return this;
				}
				return super.merge(nodeRole);
			}
		}

		public static final class PredicatedStepNodeRole extends AbstractStepNodeRole
		{
			protected PredicatedStepNodeRole(boolean isNavigable) {
				super(Role.Phase.PREDICATED, isNavigable);
			}

			@Override
			public @NonNull NodeRole merge(@NonNull NodeRole nodeRole) {
				if (nodeRole.isHead()) {
					return this;
				}
				if (nodeRole instanceof RealizedVariableNodeRole) {
					return nodeRole;
				}
				return super.merge(nodeRole);
			}
		}

		private static final @NonNull LoadedStepNodeRole LOADED_NAVIGABLE_STEP = new LoadedStepNodeRole(true);
		private static final @NonNull LoadedStepNodeRole LOADED_UNNAVIGABLE_STEP = new LoadedStepNodeRole(false);
		private static final @NonNull PredicatedStepNodeRole PREDICATED_NAVIGABLE_STEP = new PredicatedStepNodeRole(true);
		private static final @NonNull PredicatedStepNodeRole PREDICATED_UNNAVIGABLE_STEP = new PredicatedStepNodeRole(false);

		private final @Nullable Boolean isNavigable;

		public StepNodeRoleFactory(@Nullable Boolean isNavigable) {
			this.isNavigable = isNavigable;
		}

		public @NonNull Node createNode(@NonNull Region region, @NonNull String name, @NonNull CallExp callExp, @NonNull Node sourceNode) {
			boolean resolvedNavigable = isNavigable != null ? isNavigable.booleanValue() : sourceNode.isNavigable();
			boolean isDirty = false;
			DomainUsage domainUsage = region.getSchedulerConstants().getDomainUsage(callExp);
			if (callExp instanceof NavigationCallExp) {
				Property referredProperty = PivotUtil.getReferredProperty((NavigationCallExp)callExp);
				isDirty = region.getSchedulerConstants().isDirty(referredProperty);
			}
			AbstractStepNodeRole stepNodeRole = getStepNodeRole(sourceNode, resolvedNavigable, isDirty, domainUsage.isOutput() || domainUsage.isMiddle());
			return stepNodeRole.createNode(region, name, callExp);
		}

		/*		public @NonNull Node createNode(@NonNull Region region, @NonNull Node sourceNode, @NonNull Property property) {
			boolean resolvedNavigable = isNavigable != null ? isNavigable.booleanValue() : sourceNode.isNavigable();
			boolean isDirty = false;
			DomainUsage domainUsage = region.getSchedulerConstants().getDomainUsage(property);
			isDirty = region.getSchedulerConstants().isDirty(property);
			String name = property.getName();
			assert name != null;
			AbstractStepNodeRole stepNodeRole = getStepNodeRole(sourceNode, resolvedNavigable, isDirty, domainUsage.isOutput() || domainUsage.isMiddle());
			return stepNodeRole.createNode(region, name, property);
		} */

		private @NonNull AbstractStepNodeRole getStepNodeRole(@NonNull Node sourceNode, boolean isNavigable, boolean isDirty, boolean isMiddleOrOutput) {
			if (sourceNode.isPredicated() || isMiddleOrOutput || isDirty) {
				return isNavigable ? PREDICATED_NAVIGABLE_STEP : PREDICATED_UNNAVIGABLE_STEP;
			}
			else {
				return isNavigable ? LOADED_NAVIGABLE_STEP : LOADED_UNNAVIGABLE_STEP;
			}
		}
	}

	public static final class TrueNodeRole extends AbstractSimpleNodeRole
	{
		protected TrueNodeRole() {
			super(Role.Phase.CONSTANT);
		}

		public @NonNull Node createNode(@NonNull Region region) {
			SchedulerConstants schedulerConstants = region.getSchedulerConstants();
			org.eclipse.ocl.pivot.Class booleanType = schedulerConstants.getStandardLibrary().getBooleanType();
			DomainUsage primitiveUsage = schedulerConstants.getDomainAnalysis().getPrimitiveUsage();
			ClassDatumAnalysis classDatumAnalysis = schedulerConstants.getClassDatumAnalysis(booleanType, ClassUtil.nonNullState(primitiveUsage.getTypedModel(null)));
			return createNode(region, "«true»", classDatumAnalysis);
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
		public boolean isTrue() {
			return true;
		}
	}

	private static final class UnknownNodeRole extends AbstractSimpleNodeRole
	{
		protected UnknownNodeRole() {
			super(Role.Phase.OTHER);
		}

		@Override
		public @NonNull String getColor() {
			return ERROR_COLOR;
		}
	}

	public static final @NonNull AttributeNodeRoleFactory ATTRIBUTE = new AttributeNodeRoleFactory(null);
	public static final @NonNull NodeRole COMPOSING = new ComposingNodeRole();
	public static final @NonNull ElementNodeRoleFactory ELEMENT = new ElementNodeRoleFactory();
	public static final @NonNull NodeRole ERROR = new ErrorNodeRole();
	public static final @NonNull NodeRole EXTRA_GUARD = new AttributeNodeRoleFactory.ExtraGuardNodeRole();
	public static final @NonNull PortNodeRoleFactory INPUT = new PortNodeRoleFactory(); //true);
	public static final @NonNull AttributeNodeRoleFactory NAVIGABLE_DATATYPE = new AttributeNodeRoleFactory(true);
	public static final @NonNull StepNodeRoleFactory NAVIGABLE_STEP = new StepNodeRoleFactory(true);
	public static final @NonNull NullNodeRole NULL = new NullNodeRole();
	//	public static final @NonNull PortNodeRoleFactory OUTPUT = new PortNodeRoleFactory(false);
	public static final @NonNull ParameterNodeRoleFactory PARAMETER = new ParameterNodeRoleFactory(null);
	public static final AttributeNodeRoleFactory.@NonNull RealizedDataTypeNodeRole REALIZED_DATATYPE = new AttributeNodeRoleFactory.RealizedDataTypeNodeRole();
	public static final @NonNull StepNodeRoleFactory STEP = new StepNodeRoleFactory(null);
	public static final @NonNull TrueNodeRole TRUE = new TrueNodeRole();
	public static final @NonNull NodeRole UNKNOWN = new UnknownNodeRole();
	public static final @NonNull AttributeNodeRoleFactory UNNAVIGABLE_DATATYPE = new AttributeNodeRoleFactory(false);
	public static final @NonNull StepNodeRoleFactory UNNAVIGABLE_STEP = new StepNodeRoleFactory(false);
}