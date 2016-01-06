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
import org.eclipse.ocl.pivot.Property;

/**
 * Edges provides factory instances for creating the various forms of edges.
 */
public class Edges
{	
	protected abstract static class AbstractComputationEdgeRole extends AbstractEdgeRole implements EdgeRole.Simple
	{
		protected AbstractComputationEdgeRole(@NonNull Phase phase) {
			super(phase);
		}

		@Override
		public @NonNull SimpleEdge createEdge(@NonNull SimpleRegion region, @NonNull SimpleNode sourceNode, @Nullable String name, @NonNull SimpleNode targetNode) {
			return new BasicSimpleEdge(this, region, sourceNode, name, targetNode);
		}

		@Override
		public boolean isComputation() {
			return true;
		}

		@Override
		public boolean isMergeable() {
			return true;
		}
	}
	
	protected abstract static class AbstractNavigationEdgeRole extends AbstractEdgeRole implements EdgeRole.Navigation
	{
		protected AbstractNavigationEdgeRole(@NonNull Phase phase) {
			super(phase);
		}

		@Override
		public @NonNull SimpleNavigationEdge createEdge(@NonNull SimpleRegion region, @NonNull SimpleNode sourceNode, @NonNull Property source2targetProperty, @NonNull SimpleNode targetNode) {
			return new SimpleNavigationEdge(this, region, sourceNode, source2targetProperty, targetNode);
		}
	
		@Override
		public @Nullable String getLabel(@NonNull Property source2targetProperty) {
			if (source2targetProperty.eContainer() != null) {
				return getName(source2targetProperty) + "\\n" + SchedulerConstants.getMultiplicity(source2targetProperty);
			}
			else {
				return getName(source2targetProperty);
			}
		}
	
		@SuppressWarnings("null")
		public @NonNull String getName(@NonNull Property source2targetProperty) {
			return source2targetProperty.getName();
		}

		@Override
		public boolean isMergeable() {
			return true;
		}
	
		@Override
		public boolean isNavigation() {
			return true;
		}
	}
	
	public static final class ArgumentEdgeRoleFactory
	{
		public static class ArgumentEdgeRole extends AbstractComputationEdgeRole
		{
			protected ArgumentEdgeRole(@NonNull Phase phase) {
				super(phase);
			}

			@Override
			public @NonNull String getStyle() {
				return "dashed";
			}

			@Override
			public boolean isArgument() {
				return true;
			}

			@Override
			public boolean isMergeable() {
				return true;
			}
		}

		private static final @NonNull ArgumentEdgeRole CONSTANT_ARGUMENT = new ArgumentEdgeRole(Role.Phase.CONSTANT);	
		private static final @NonNull ArgumentEdgeRole LOADED_ARGUMENT = new ArgumentEdgeRole(Role.Phase.LOADED);	
		private static final @NonNull ArgumentEdgeRole PREDICATED_ARGUMENT = new ArgumentEdgeRole(Role.Phase.PREDICATED);	
		public static final @NonNull ArgumentEdgeRole REALIZED_ARGUMENT = new ArgumentEdgeRole(Role.Phase.REALIZED);	

		public @NonNull SimpleEdge createSimpleEdge(@NonNull SimpleRegion region, @NonNull SimpleNode sourceNode, @Nullable String name, @NonNull SimpleNode targetNode) {
			if (sourceNode.isConstant()) {
				return new BasicSimpleEdge(CONSTANT_ARGUMENT, region, sourceNode, name, targetNode);
			}
			else if (sourceNode.isLoaded()) {
				return new BasicSimpleEdge(LOADED_ARGUMENT, region, sourceNode, name, targetNode);
			}
			else if (sourceNode.isPredicated()) {
				return new BasicSimpleEdge(PREDICATED_ARGUMENT, region, sourceNode, name, targetNode);
			}
			else if (sourceNode.isRealized()) {
				return new BasicSimpleEdge(REALIZED_ARGUMENT, region, sourceNode, name, targetNode);
			}
			else {
				throw new UnsupportedOperationException();
			}
		}
	}

	public static final class CastEdgeRoleFactory
	{
		private static class CastEdgeRole extends AbstractNavigationEdgeRole
		{
			protected CastEdgeRole(@NonNull Phase phase) {
				super(phase);
			}

			@Override
			public boolean isCast() {
				return true;
			}
		}

		private static final EdgeRole.@NonNull Navigation LOADED_CAST = new CastEdgeRole(Role.Phase.LOADED);
		private static final EdgeRole.@NonNull Navigation PREDICATED_CAST = new CastEdgeRole(Role.Phase.PREDICATED);

		public @NonNull SimpleEdge createSimpleEdge(@NonNull SimpleRegion region, @NonNull SimpleNode sourceNode, @NonNull Property source2targetProperty, @NonNull SimpleNode targetNode) {
			if (sourceNode.isLoaded() && targetNode.isLoaded()) {
				return new SimpleNavigationEdge(LOADED_CAST, region, sourceNode, source2targetProperty, targetNode);
			}
			else if (sourceNode.isPredicated() || targetNode.isPredicated()){
				return new SimpleNavigationEdge(PREDICATED_CAST, region, sourceNode, source2targetProperty, targetNode);
			}
			else {
				throw new UnsupportedOperationException();
			}
		}
	}

/*	private static final class ComposedOrderingEdgeRole extends AbstractEdgeRole
	{
		protected ComposedOrderingEdgeRole() {
			super(Phase.OTHER);
		}

		@Override
		public @NonNull String getColor() {
			return ORDERING_COLOR;
		}

		@Override
		public @NonNull String getStyle() {
			return "dashed";
		}

		@Override
		public boolean isComposedOrdering() {
			return true;
		}
	} */

	private static final class CompositionEdgeRole extends AbstractNavigationEdgeRole
	{
		protected CompositionEdgeRole() {
			super(Phase.LOADED);
		}

		@Override
		public boolean isComposition() {
			return true;
		}
	}

/*	private static final class ConsumedOrderingEdgeRole extends AbstractEdgeRole
	{
		protected ConsumedOrderingEdgeRole() {
			super(Phase.OTHER);
		}

		@Override
		public @NonNull String getColor() {
			return ORDERING_COLOR;
		}

		@Override
		public @NonNull String getStyle() {
			return "dashed";
		}

		@Override
		public boolean isConsumedOrdering() {
			return true;
		}
	} */

	private static final class ContainerEdgeRole extends AbstractNavigationEdgeRole
	{
		protected ContainerEdgeRole() {
			super(Phase.LOADED);
		}
		
		@Override
		public @NonNull String getLabel(@NonNull Property source2targetProperty) {
			Property opposite = source2targetProperty; //.getOpposite();
//			if (opposite != null) {
				return opposite.getName() + "\\n" + SchedulerConstants.getMultiplicity(opposite);
//			}
//			else {
//				return "oclContainer()\\n[?]";
//			}
		}
	}

	public static final class IteratedEdgeRoleFactory
	{
		private static class IteratedEdgeRole extends AbstractComputationEdgeRole
		{
			protected IteratedEdgeRole(@NonNull Phase phase) {
				super(phase);
			}

			@Override
			public boolean isCast() {
				return true;
			}

			@Override
			public boolean isMergeable() {
				return true;
			}
		}

		private static final @NonNull IteratedEdgeRole CONSTANT_ITERATED = new IteratedEdgeRole(Role.Phase.CONSTANT);
		private static final @NonNull IteratedEdgeRole LOADED_ITERATED = new IteratedEdgeRole(Role.Phase.LOADED);
		private static final @NonNull IteratedEdgeRole PREDICATED_ITERATED = new IteratedEdgeRole(Role.Phase.PREDICATED);
		private static final @NonNull IteratedEdgeRole REALIZED_ITERATED = new IteratedEdgeRole(Role.Phase.REALIZED);

		public @NonNull SimpleEdge createSimpleEdge(@NonNull SimpleRegion region, @NonNull SimpleNode sourceNode, @NonNull SimpleNode targetNode) {
			if (sourceNode.isRealized() || targetNode.isRealized()) {
				return new BasicSimpleEdge(REALIZED_ITERATED, region, sourceNode, null, targetNode);
			}
			else if (sourceNode.isPredicated() || targetNode.isPredicated()){
				return new BasicSimpleEdge(PREDICATED_ITERATED, region, sourceNode, null, targetNode);
			}
			else if (sourceNode.isLoaded() || targetNode.isLoaded()) {
				return new BasicSimpleEdge(LOADED_ITERATED, region, sourceNode, null, targetNode);
			}
			else if (sourceNode.isConstant() || targetNode.isConstant()) {
				return new BasicSimpleEdge(CONSTANT_ITERATED, region, sourceNode, null, targetNode);
			}
			else {
				throw new UnsupportedOperationException();
			}
		}
	}

	public static final class IteratingEdgeRoleFactory
	{
		private static class IteratingEdgeRole extends AbstractComputationEdgeRole
		{
			protected IteratingEdgeRole(@NonNull Phase phase) {
				super(phase);
			}

			@Override
			public boolean isCast() {
				return true;
			}

			@Override
			public boolean isMergeable() {
				return true;
			}
		}

		private static final @NonNull IteratingEdgeRole CONSTANT_ITERATING = new IteratingEdgeRole(Role.Phase.CONSTANT);
		private static final @NonNull IteratingEdgeRole LOADED_ITERATING = new IteratingEdgeRole(Role.Phase.LOADED);
		private static final @NonNull IteratingEdgeRole PREDICATED_ITERATING = new IteratingEdgeRole(Role.Phase.PREDICATED);
		private static final @NonNull IteratingEdgeRole REALIZED_ITERATING = new IteratingEdgeRole(Role.Phase.REALIZED);

		public @NonNull SimpleEdge createSimpleEdge(@NonNull SimpleRegion region, @NonNull SimpleNode sourceNode, @NonNull SimpleNode targetNode) {
			if (sourceNode.isRealized() || targetNode.isRealized()) {
				return new BasicSimpleEdge(REALIZED_ITERATING, region, sourceNode, null, targetNode);
			}
			else if (sourceNode.isPredicated() || targetNode.isPredicated()){
				return new BasicSimpleEdge(PREDICATED_ITERATING, region, sourceNode, null, targetNode);
			}
			else if (sourceNode.isLoaded() || targetNode.isLoaded()) {
				return new BasicSimpleEdge(LOADED_ITERATING, region, sourceNode, null, targetNode);
			}
			else if (sourceNode.isConstant() || targetNode.isConstant()) {
				return new BasicSimpleEdge(CONSTANT_ITERATING, region, sourceNode, null, targetNode);
			}
			else {
				throw new UnsupportedOperationException();
			}
		}
	}

	public static final class NavigationEdgeRoleFactory
	{
		private static class NavigationEdgeRole extends AbstractNavigationEdgeRole
		{
			protected NavigationEdgeRole(@NonNull Phase phase) {
				super(phase);
			}
		}

		private static final class PredicatedNavigationEdgeRole extends NavigationEdgeRole
		{
			protected PredicatedNavigationEdgeRole() {
				super(Phase.PREDICATED);
			}

			@Override
			public @NonNull EdgeRole merge(@NonNull EdgeRole edgeRole) {
				if (edgeRole == REALIZED) {
					return edgeRole;
				}
				return super.merge(edgeRole);
			}

			@Override
			public String toString() {
				return getClass().getSimpleName();
			}
		}

		private static final @NonNull NavigationEdgeRole CONSTANT_NAVIGATION = new NavigationEdgeRole(Role.Phase.CONSTANT);
		private static final @NonNull NavigationEdgeRole LOADED_NAVIGATION = new NavigationEdgeRole(Role.Phase.LOADED);
		private static final @NonNull NavigationEdgeRole PREDICATED_NAVIGATION = new PredicatedNavigationEdgeRole();

		public @NonNull SimpleEdge createSimpleEdge(@NonNull SimpleRegion region, @NonNull SimpleNode sourceNode, @NonNull Property source2targetProperty, @NonNull SimpleNode targetNode) {
			if (sourceNode.isRealized() || targetNode.isRealized()) {
//				throw new UnsupportedOperationException();
				return new SimpleNavigationEdge(REALIZED, region, sourceNode, source2targetProperty, targetNode);
			}
			else if (sourceNode.isPredicated() || targetNode.isPredicated()) {
				return new SimpleNavigationEdge(PREDICATED_NAVIGATION, region, sourceNode, source2targetProperty, targetNode);
			}
			else if (sourceNode.isLoaded() || targetNode.isLoaded()) {
				return new SimpleNavigationEdge(LOADED_NAVIGATION, region, sourceNode, source2targetProperty, targetNode);
			}
			else if (sourceNode.isConstant() || targetNode.isConstant()) {
				return new SimpleNavigationEdge(CONSTANT_NAVIGATION, region, sourceNode, source2targetProperty, targetNode);
			}
			else {
				throw new UnsupportedOperationException();
			}
		}
	}

	private static final class RealizedNavigationEdgeRole extends AbstractNavigationEdgeRole
	{
		protected RealizedNavigationEdgeRole() {
			super(Phase.REALIZED);
		}

		@Override
		public @NonNull EdgeRole merge(@NonNull EdgeRole edgeRole) {
			if (edgeRole == NavigationEdgeRoleFactory.PREDICATED_NAVIGATION) {
				return this;
			}
			return super.merge(edgeRole);
		}

		@Override
		public String toString() {
			return getClass().getSimpleName();
		}
	}

	private static final class RecursionEdgeRole extends AbstractEdgeRole implements EdgeRole.Recursion
	{
		private boolean isPrimary;
		
		protected RecursionEdgeRole(boolean isPrimary) {
			super(Phase.OTHER);
			this.isPrimary = isPrimary;
		}

		@Override
		public @NonNull Edge createEdge(@NonNull Region region, @NonNull Node sourceNode, @NonNull Node targetNode) {
			return new AbstractEdge(this, region, sourceNode, null, targetNode)
			{
				@Override
				public @NonNull Iterable<SimpleEdge> getSimpleEdges() {
					return SchedulerConstants.EMPTY_SIMPLE_EDGE_LIST;
				}
			};
		}

		@Override
		public @NonNull String getColor() {
			return RECURSION_COLOR;
		}

		@Override
		public @Nullable String getStyle() {
			return isPrimary ? super.getStyle() : "dashed";
		}

//		public boolean isPrimary() {
//			return isPrimary;
//		}

		@Override
		public boolean isRecursion() {
			return true;
		}

		@Override
		public String toString() {
			return (isPrimary ? "Primary=" : "Secondary-") + getClass().getSimpleName();
		}
	}
	
	public static final class ResultEdgeRoleFactory
	{
		protected static class ResultEdgeRole extends AbstractComputationEdgeRole
		{
			protected ResultEdgeRole(@NonNull Phase phase) {
				super(phase);
			}

			@Override
			public boolean isMergeable() {
				return true;
			}

			@Override
			public boolean isResult() {
				return true;
			}
		}

		private static final @NonNull EdgeRole CONSTANT_RESULT = new ResultEdgeRole(Role.Phase.CONSTANT);
		private static final @NonNull EdgeRole LOADED_RESULT = new ResultEdgeRole(Role.Phase.LOADED);
		private static final @NonNull EdgeRole PREDICATED_RESULT = new ResultEdgeRole(Role.Phase.PREDICATED);
		private static final @NonNull EdgeRole REALIZED_RESULT = new ResultEdgeRole(Role.Phase.REALIZED);

		public @NonNull SimpleEdge createSimpleEdge(@NonNull SimpleRegion region, @NonNull SimpleNode sourceNode, @Nullable String name, @NonNull SimpleNode targetNode) {
			if (targetNode.isConstant()) {
				return new BasicSimpleEdge(CONSTANT_RESULT, region, sourceNode, name, targetNode);
			}
			else if (targetNode.isLoaded()) {
				return new BasicSimpleEdge(LOADED_RESULT, region, sourceNode, name, targetNode);
			}
			else if (targetNode.isPredicated()) {
				return new BasicSimpleEdge(PREDICATED_RESULT, region, sourceNode, name, targetNode);
			}
			else if (targetNode.isRealized()) {
				return new BasicSimpleEdge(REALIZED_RESULT, region, sourceNode, name, targetNode);
			}
			else {
				throw new UnsupportedOperationException();
			}
		}
	}
	
	public static final @NonNull ArgumentEdgeRoleFactory ARGUMENT = new ArgumentEdgeRoleFactory();
	public static final @NonNull CastEdgeRoleFactory CAST = new CastEdgeRoleFactory();
	public static final EdgeRole.@NonNull Navigation COMPOSITION = new CompositionEdgeRole();
	public static final EdgeRole.@NonNull Navigation CONTAINER = new ContainerEdgeRole();
	public static final @NonNull IteratedEdgeRoleFactory ITERATED = new IteratedEdgeRoleFactory();		
	public static final @NonNull IteratingEdgeRoleFactory ITERATING = new IteratingEdgeRoleFactory();		
	public static final @NonNull NavigationEdgeRoleFactory NAVIGATION = new NavigationEdgeRoleFactory();

	/**
	 * A composed ordering edge defines a promoted ordering dependency upon the processing of two
	 * containment properties. The statically determinate schedule must process all of the source
	 * children before any of the target children.
	 */
//	public static final @NonNull EdgeRole COMPOSED_ORDERING = new ComposedOrderingEdgeRole();

	/**
	 * A consumed ordering edge defines a promoted ordering dependency upon the processing that exploits
	 * a particular object. The statically determinate schedule must process the source consumer before
	 * the target consumer.
	 */
//	public static final @NonNull EdgeRole CONSUMED_ORDERING = new ConsumedOrderingEdgeRole();
	
	public static final EdgeRole.@NonNull Recursion PRIMARY_RECURSION = new RecursionEdgeRole(true);	
	public static final EdgeRole.@NonNull Navigation REALIZED = new RealizedNavigationEdgeRole();
	public static final @NonNull ResultEdgeRoleFactory RESULT = new ResultEdgeRoleFactory();
	public static final EdgeRole.@NonNull Recursion SECONDARY_RECURSION = new RecursionEdgeRole(false);	
}