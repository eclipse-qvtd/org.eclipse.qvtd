/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.scheduler;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.analysis.DomainUsage;
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
			throw new UnsupportedOperationException();
		}

		@Override
		public @NonNull SimpleNode createSimpleNode(@NonNull SimpleRegion region, @NonNull String name, @NonNull ClassDatumAnalysis classDatumAnalysis) {
			return new SimpleTypedNode(this, region, name, classDatumAnalysis);
		}

		@Override
		public @NonNull SimpleNode createSimpleNode(@NonNull SimpleRegion region, @NonNull String name, @NonNull TypedElement typedElement) {
			return new SimpleTypedNode(this, region, name, typedElement);
		}
	}
	
	public static abstract class AbstractVariableNodeRole extends AbstractSimpleNodeRole
	{
		protected AbstractVariableNodeRole(@NonNull Phase phase) {
			super(phase);
		}

		public @NonNull SimpleNode createSimpleNode(@NonNull SimpleRegion region, @NonNull VariableDeclaration variable) {
			return new SimpleVariableNode(this, region, variable);
		}

		@Override
		public boolean isClassNode() {
			return true;
		}
	}
	
	public static final class AttributeNodeRoleFactory
	{
		private static abstract class AbstractAttributeNodeRole extends AbstractSimpleNodeRole
		{
			protected AbstractAttributeNodeRole(@NonNull Phase phase) {
				super(phase);
			}
			
			@Override
			public boolean isAttributeNode() {
				return true;
			}
		}

		public static class AttributeNodeRole extends AbstractAttributeNodeRole
		{
			private boolean isAttribute;
			
			protected AttributeNodeRole(@NonNull Phase phase, boolean isAttribute) {
				super(phase);
				this.isAttribute = isAttribute;
			}

			public @NonNull SimpleNode createSimpleNode(@NonNull SimpleRegion region, @NonNull Node parentNode, @NonNull NavigationCallExp navigationCallExp) {
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
				return createSimpleNode(region, name, navigationCallExp);
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
			public @Nullable String getStyle() {
				return isAttribute ? "rounded" : null;
			}

			@Override
			public @NonNull NodeRole merge(@NonNull NodeRole nodeRole) {
				if (nodeRole == REALIZED_ATTRIBUTE) {
					return nodeRole;
				}
				if (getClass() != nodeRole.getClass()) {
					throw new IllegalStateException(this + " cannot be merged");
				}
				return this.compareTo(nodeRole) < 0 ? this : nodeRole;
			}
		}

		public static class ExtraGuardNodeRole extends AbstractAttributeNodeRole
		{
			protected ExtraGuardNodeRole() {
				super(Role.Phase.PREDICATED);
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
			
		public static final class RealizedAttributeNodeRole extends AbstractAttributeNodeRole
		{
			protected RealizedAttributeNodeRole() {
				super(Role.Phase.REALIZED);
			}

			public @NonNull SimpleNode createSimpleNode(@NonNull SimpleRegion region, @NonNull SimpleNode parentNode, @NonNull Property property) {
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
				return createSimpleNode(region, name, classDatumAnalysis);
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
		
		public static final class PredicatedInternalNodeRole extends AbstractAttributeNodeRole
		{
			protected PredicatedInternalNodeRole() {
				super(Role.Phase.PREDICATED);
			}

			public @NonNull SimpleNode createSimpleNode(@NonNull SimpleRegion region, @NonNull SimpleNode parentNode, @NonNull PropertyAssignment propertyAssignment) {
				assert parentNode.isClassNode();
				SchedulerConstants schedulerConstants = region.getSchedulerConstants();
				Property property = propertyAssignment.getTargetProperty();
				assert property != null;
				org.eclipse.ocl.pivot.Class type = (org.eclipse.ocl.pivot.Class)property.getType();
				assert type != null;
				TypedModel typedModel = parentNode.getClassDatumAnalysis().getTypedModel();
				ClassDatum classDatum = schedulerConstants.getClassDatum(type, typedModel);
//				DomainUsage domainUsage = parentNode.getClassDatumAnalysis().getDomainUsage();
				ClassDatumAnalysis classDatumAnalysis = schedulerConstants.getClassDatumAnalysis(classDatum);
				String name = property.getName();
				assert name != null;
				return createSimpleNode(region, name, classDatumAnalysis);
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
		
		private static final @NonNull AttributeNodeRole LOADED_ATTRIBUTE = new AttributeNodeRole(Role.Phase.LOADED, true);
		private static final @NonNull AttributeNodeRole PREDICATED_ATTRIBUTE = new AttributeNodeRole(Role.Phase.PREDICATED, true);
		public static final @NonNull PredicatedInternalNodeRole PREDICATED_CLASS = new PredicatedInternalNodeRole();

		public @NonNull SimpleNode createSimpleNode(@NonNull Region region, @NonNull SimpleNode parentNode, @NonNull NavigationCallExp navigationCallExp) {
			if (parentNode.isLoaded()) {
				Property referredProperty = PivotUtil.getReferredProperty(navigationCallExp);
				assert referredProperty != null;
				boolean isDirty = region.getSchedulerConstants().isDirty(referredProperty);
				if (!isDirty) {
					return LOADED_ATTRIBUTE.createSimpleNode(parentNode.getRegion(), parentNode, navigationCallExp);
				}
				else {
					return PREDICATED_ATTRIBUTE.createSimpleNode(parentNode.getRegion(), parentNode, navigationCallExp);
				}
			}
			else if (parentNode.isPredicated()) {
				return PREDICATED_ATTRIBUTE.createSimpleNode(parentNode.getRegion(), parentNode, navigationCallExp);
			}
			else if (parentNode.isRealized()) {
				Property referredProperty = PivotUtil.getReferredProperty(navigationCallExp);	// ??never happens
				assert referredProperty != null;
				return REALIZED_ATTRIBUTE.createSimpleNode(parentNode.getRegion(), parentNode, referredProperty);
			}
			else {
				throw new UnsupportedOperationException();
			}
		}
	}

	private static final class ComposedNodeRole extends AbstractSimpleNodeRole
	{
		protected ComposedNodeRole() {
			super(Role.Phase.LOADED);
		}

		@Override
		public boolean isClassNode() {
			return true;
		}

		@Override
		public boolean isComposed() {
			return true;
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
		public boolean isHead() {
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
		
		public @NonNull SimpleNode createSimpleNode(@NonNull SimpleRegion region, @NonNull String name, @NonNull ClassDatumAnalysis classDatumAnalysis, @NonNull SimpleNode sourceNode) {
			if (sourceNode.isPredicated()) {
				return PREDICATED_ELEMENT.createSimpleNode(region, name, classDatumAnalysis);
			}
			else {
				return LOADED_ELEMENT.createSimpleNode(region, name, classDatumAnalysis);
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
	
	public static final class GuardNodeRoleFactory
	{
		private static abstract class AbstractGuardNodeRole extends AbstractVariableNodeRole
		{
			protected AbstractGuardNodeRole(@NonNull Phase phase) {
				super(phase);
			}

			@Override
			public boolean isGuardVariable() {
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
			public @NonNull NodeRole merge(@NonNull NodeRole nodeRole) {
				if ((phase == Phase.PREDICATED) && (nodeRole == REALIZED_VARIABLE)) {
					return nodeRole;
				}
				return super.merge(nodeRole);
			}
		}

		private static final class GuardNodeRole extends AbstractGuardNodeRole
		{
			private final @NonNull HeadNodeRole headNode;
			
			protected GuardNodeRole(@NonNull Phase phase, @NonNull HeadNodeRole headNode) {
				super(phase);
				this.headNode = headNode;
			}

			@Override
			public @NonNull NodeRole setHead() {
				return headNode;
			}
		}

		private static final class HeadNodeRole extends AbstractGuardNodeRole
		{		
			protected HeadNodeRole(@NonNull Phase phase) {
				super(phase);
			}

			@Override
			public boolean isHead() {
				return true;
			}
		}
		
		private static final @NonNull HeadNodeRole LOADED_HEAD = new HeadNodeRole(Role.Phase.LOADED);
		private static final @NonNull GuardNodeRole LOADED_GUARD = new GuardNodeRole(Role.Phase.LOADED, LOADED_HEAD);
		private static final @NonNull HeadNodeRole PREDICATED_HEAD = new HeadNodeRole(Role.Phase.PREDICATED);
		private static final @NonNull GuardNodeRole PREDICATED_GUARD = new GuardNodeRole(Role.Phase.PREDICATED, PREDICATED_HEAD);
		
		public @NonNull SimpleNode createSimpleNode(@NonNull SimpleRegion region, @NonNull VariableDeclaration guardVariable) {
			DomainUsage domainUsage = region.getSchedulerConstants().getDomainUsage(guardVariable);
			boolean isEnforceable = domainUsage.isEnforceable();
			if (!isEnforceable) {
				return LOADED_GUARD.createSimpleNode(region, guardVariable);
			}
			else {
				return PREDICATED_GUARD.createSimpleNode(region, guardVariable);
			}
		}
	}

	public static final class IteratorNodeRoleFactory
	{
		private static final class IteratorNodeRole extends AbstractVariableNodeRole
		{
			protected IteratorNodeRole(@NonNull Phase phase) {
				super(phase);
			}

//			@Override
//			public boolean isHead() {
//				return true;
//			}
			
			@Override
			public boolean isInternal() {
				return true;
			}
			
			@Override
			public boolean isIterator() {
				return true;
			}
			
			@Override
			public boolean isMatchable() {
				return true;
			}

//			@Override
//			public boolean isNavigable() {
//				return true;
//			}
		}
		
		public static final @NonNull AbstractVariableNodeRole CONSTANT_ITERATOR = new IteratorNodeRole(Role.Phase.CONSTANT);
		public static final @NonNull AbstractVariableNodeRole LOADED_ITERATOR = new IteratorNodeRole(Role.Phase.LOADED);
		public static final @NonNull AbstractVariableNodeRole PREDICATED_ITERATOR = new IteratorNodeRole(Role.Phase.PREDICATED);

		public @NonNull SimpleNode createSimpleNode(@NonNull SimpleRegion region, @NonNull Variable iterator, @NonNull SimpleNode sourceNode) {
			if (sourceNode.isConstant()) {
				return CONSTANT_ITERATOR.createSimpleNode(region, iterator);
			}
			else if (sourceNode.isLoaded()) {
				return LOADED_ITERATOR.createSimpleNode(region, iterator);
			}
			else {
				return PREDICATED_ITERATOR.createSimpleNode(region, iterator);
			}
		}
	}
	
	public static final class LetNodeRoleFactory
	{		
		private static final class LetVariableNodeRole extends AbstractVariableNodeRole
		{
			private boolean isNavigable;
			
			protected LetVariableNodeRole(@NonNull Phase phase, boolean isNavigable) {
				super(phase);
				this.isNavigable = isNavigable;
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
				return phase + (isNavigable ? "-Navigable-" : "-Unnavigable-") + getClass().getSimpleName();
			}
		}
		
		public static final @NonNull AbstractVariableNodeRole CONSTANT_NAVIGABLE_LET = new LetVariableNodeRole(Role.Phase.CONSTANT, true);
		public static final @NonNull AbstractVariableNodeRole CONSTANT_UNNAVIGABLE_LET = new LetVariableNodeRole(Role.Phase.CONSTANT, false);
		public static final @NonNull AbstractVariableNodeRole LOADED_NAVIGABLE_LET = new LetVariableNodeRole(Role.Phase.LOADED, true);
		public static final @NonNull AbstractVariableNodeRole LOADED_UNNAVIGABLE_LET = new LetVariableNodeRole(Role.Phase.LOADED, false);
		public static final @NonNull AbstractVariableNodeRole PREDICATED_NAVIGABLE_LET = new LetVariableNodeRole(Role.Phase.PREDICATED, true);
		public static final @NonNull AbstractVariableNodeRole PREDICATED_UNNAVIGABLE_LET = new LetVariableNodeRole(Role.Phase.PREDICATED, false);

		public @NonNull SimpleNode createSimpleNode(@NonNull SimpleRegion region, @NonNull Variable letVariable, @NonNull SimpleNode inNode) {
			if (inNode.isNavigable()) {
				if (inNode.isConstant()) {
					return CONSTANT_NAVIGABLE_LET.createSimpleNode(region, letVariable);
				}
				else if (inNode.isLoaded()) {
					return LOADED_NAVIGABLE_LET.createSimpleNode(region, letVariable);
				}
				else {
					return PREDICATED_NAVIGABLE_LET.createSimpleNode(region, letVariable);
				}
			}
			else {
				if (inNode.isConstant()) {
					return CONSTANT_UNNAVIGABLE_LET.createSimpleNode(region, letVariable);
				}
				else if (inNode.isLoaded()) {
					return LOADED_UNNAVIGABLE_LET.createSimpleNode(region, letVariable);
				}
				else {
					return PREDICATED_UNNAVIGABLE_LET.createSimpleNode(region, letVariable);
				}
			}
		}
	}
	
	public static class NullNodeRole extends AbstractSimpleNodeRole
	{
		protected NullNodeRole() {
			super(Role.Phase.CONSTANT);
		}

		public @NonNull SimpleNode createSimpleNode(@NonNull SimpleRegion region) {
			return createSimpleNode(region, "«null»", region.getSchedulerConstants().getOclVoidClassDatumAnalysis());
		}

		public @NonNull SimpleNode createSimpleNode(@NonNull SimpleRegion region, @NonNull TypedElement typedElement) {
			return createSimpleNode(region, "«null»", typedElement);
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
	
	public static final class OperationNodeRoleFactory
	{
		private static class OperationNodeRole extends AbstractSimpleNodeRole
		{
			protected OperationNodeRole(@NonNull Phase phase) {
				super(phase);
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
		
		private static final @NonNull OperationNodeRole CONSTANT_OPERATION = new OperationNodeRole(Role.Phase.CONSTANT);
		private static final @NonNull OperationNodeRole LOADED_OPERATION = new OperationNodeRole(Role.Phase.LOADED);
		private static final @NonNull OperationNodeRole PREDICATED_OPERATION = new OperationNodeRole(Role.Phase.PREDICATED);
		private static final @NonNull OperationNodeRole REALIZED_OPERATION = new OperationNodeRole(Role.Phase.REALIZED);

		public @NonNull SimpleNode createSimpleNode(@NonNull SimpleRegion region, @NonNull String name, @NonNull TypedElement typedElement, SimpleNode... argNodes) {
			boolean isLoaded = false;
			boolean isPredicated = false;
			boolean isRealized = false;
			if (argNodes != null) {
				for (SimpleNode argNode : argNodes) {
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
			if (isRealized) {
				return REALIZED_OPERATION.createSimpleNode(region, name, typedElement);
			}
			else if (isPredicated) {
				return PREDICATED_OPERATION.createSimpleNode(region, name, typedElement);
			}
			else if (isLoaded) {
				return LOADED_OPERATION.createSimpleNode(region, name, typedElement);
			}
			else {
				return CONSTANT_OPERATION.createSimpleNode(region, name, typedElement);
			}
		}
	}
	
	private static final class ParameterNodeRole extends AbstractVariableNodeRole
	{
		protected ParameterNodeRole() {
			super(Role.Phase.PREDICATED);
		}

		@Override
		public boolean isHead() {
			return true;
		}
	}
	
	private static final class RealizedVariableNodeRole extends AbstractVariableNodeRole
	{
		protected RealizedVariableNodeRole() {
			super(Role.Phase.REALIZED);
		}
		
		@Override
		public boolean isRealizedVariable() {
			return true;
		}
		
		@Override
		public @NonNull NodeRole merge(@NonNull NodeRole nodeRole) {
			if (nodeRole instanceof GuardNodeRoleFactory.AbstractGuardNodeRole) {
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
	
/*	public static final class ResultNodeRoleFactory
	{
		private static final class ResultNodeRole extends AbstractSimpleNodeRole
		{
			protected ResultNodeRole(@NonNull Phase phase) {
				super(phase);
			}
			
			@Override
			public @Nullable String getStyle() {
				return("rounded");
			}

			@Override
			public boolean isMatchable() {
				return phase != Role.Phase.REALIZED;
			}
			
			@Override
			public boolean isResult() {
				return true;
			}
		}

		private static final @NonNull ResultNodeRole CONSTANT_RESULT = new ResultNodeRole(Role.Phase.CONSTANT);
		private static final @NonNull ResultNodeRole LOADED_RESULT = new ResultNodeRole(Role.Phase.LOADED);
		private static final @NonNull ResultNodeRole PREDICATED_RESULT = new ResultNodeRole(Role.Phase.PREDICATED);
		private static final @NonNull ResultNodeRole REALIZED_RESULT = new ResultNodeRole(Role.Phase.REALIZED);
		
		public @NonNull SimpleNode createSimpleNode(@NonNull SimpleRegion region, @NonNull String name,
				@NonNull CallExp callExp, @NonNull SimpleNode sourceNode) {
			DomainUsage domainUsage = region.getSchedulerConstants().getDomainUsage(callExp);
			if (domainUsage.isEnforceable()) {
				return REALIZED_RESULT.createSimpleNode(region, name, callExp);
			}
			else if (sourceNode.isPredicated()) {
				return PREDICATED_RESULT.createSimpleNode(region, name, callExp);
			}
			else if (sourceNode.isLoaded()) {
				return LOADED_RESULT.createSimpleNode(region, name, callExp);
			}
			else {
				return CONSTANT_RESULT.createSimpleNode(region, name, callExp);
			}
		}
	} */
	
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

		public @NonNull SimpleNode createSimpleNode(@NonNull SimpleRegion region, @NonNull String name,
				@NonNull CallExp callExp, @NonNull SimpleNode sourceNode) {
			boolean resolvedNavigable = isNavigable != null ? isNavigable.booleanValue() : sourceNode.isNavigable();
			DomainUsage domainUsage = region.getSchedulerConstants().getDomainUsage(callExp);
			if (sourceNode.isPredicated() || domainUsage.isEnforceable() ) {
				return (resolvedNavigable ? PREDICATED_NAVIGABLE_STEP : PREDICATED_UNNAVIGABLE_STEP).createSimpleNode(region, name, callExp);
			}
			else {
				boolean isDirty = false;
				if (callExp instanceof NavigationCallExp) {
					Property referredProperty = PivotUtil.getReferredProperty((NavigationCallExp)callExp);
					isDirty = region.getSchedulerConstants().isDirty(referredProperty);
				}
				if (!isDirty) {
					return (resolvedNavigable ? LOADED_NAVIGABLE_STEP : LOADED_UNNAVIGABLE_STEP).createSimpleNode(region, name, callExp);
				}
				else {
					return (resolvedNavigable ? PREDICATED_NAVIGABLE_STEP : PREDICATED_UNNAVIGABLE_STEP).createSimpleNode(region, name, callExp);
				}
			}
		}
	}
	
	public static final class TrueNodeRole extends AbstractSimpleNodeRole
	{
		protected TrueNodeRole() {
			super(Role.Phase.CONSTANT);
		}

		public @NonNull SimpleNode createSimpleNode(@NonNull SimpleRegion region) {
			SchedulerConstants schedulerConstants = region.getSchedulerConstants();
			org.eclipse.ocl.pivot.Class booleanType = schedulerConstants.getStandardLibrary().getBooleanType();
			DomainUsage primitiveUsage = schedulerConstants.getDomainAnalysis().getPrimitiveUsage();
			ClassDatumAnalysis classDatumAnalysis = schedulerConstants.getClassDatumAnalysis(booleanType, ClassUtil.nonNullState(primitiveUsage.getTypedModel()));
			return createSimpleNode(region, "«true»", classDatumAnalysis);
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
	
	private static final class UnrealizedVariableNodeRole extends AbstractVariableNodeRole
	{
		protected UnrealizedVariableNodeRole() {
			super(Role.Phase.LOADED);
		}
	}
	
	public static final @NonNull AttributeNodeRoleFactory ATTRIBUTE = new AttributeNodeRoleFactory();
	public static final @NonNull NodeRole COMPOSED = new ComposedNodeRole();
	public static final @NonNull NodeRole COMPOSING = new ComposingNodeRole();
	public static final @NonNull ElementNodeRoleFactory ELEMENT = new ElementNodeRoleFactory();
	public static final @NonNull NodeRole ERROR = new ErrorNodeRole();
	public static final @NonNull NodeRole EXTRA_GUARD = new AttributeNodeRoleFactory.ExtraGuardNodeRole();
	public static final @NonNull GuardNodeRoleFactory GUARD = new GuardNodeRoleFactory();
	public static final @NonNull IteratorNodeRoleFactory ITERATOR = new IteratorNodeRoleFactory();
	public static final @NonNull LetNodeRoleFactory LET = new LetNodeRoleFactory();
	public static final @NonNull StepNodeRoleFactory NAVIGABLE_STEP = new StepNodeRoleFactory(true);
	public static final @NonNull NullNodeRole NULL = new NullNodeRole();
	public static final @NonNull OperationNodeRoleFactory OPERATION = new OperationNodeRoleFactory();
	public static final @NonNull AbstractVariableNodeRole PARAMETER = new ParameterNodeRole();
	public static final AttributeNodeRoleFactory.@NonNull RealizedAttributeNodeRole REALIZED_ATTRIBUTE = new AttributeNodeRoleFactory.RealizedAttributeNodeRole();
	public static final @NonNull AbstractVariableNodeRole REALIZED_VARIABLE = new RealizedVariableNodeRole();
	public static final @NonNull StepNodeRoleFactory STEP = new StepNodeRoleFactory(null);
	public static final @NonNull TrueNodeRole TRUE = new TrueNodeRole();
	public static final @NonNull NodeRole UNKNOWN = new UnknownNodeRole();
	public static final @NonNull StepNodeRoleFactory UNNAVIGABLE_STEP = new StepNodeRoleFactory(false);
	public static final @NonNull AbstractVariableNodeRole UNREALIZED_VARIABLE = new UnrealizedVariableNodeRole();
}