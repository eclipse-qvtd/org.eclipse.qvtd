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
import org.eclipse.ocl.pivot.Property;

/**
 * Edges provides factory instances for creating the various forms of edges.
 */
public class Edges
{
	private abstract static class AbstractComputationEdgeRole extends AbstractEdgeRole implements EdgeRole.Simple
	{
		protected AbstractComputationEdgeRole(@NonNull Phase phase) {
			super(phase);
		}

		@Override
		public @NonNull Edge createEdge(@NonNull Node sourceNode, @Nullable String name, @NonNull Node targetNode) {
			return new BasicEdge(this, sourceNode, name, targetNode);
		}

		@Override
		public boolean isComputation() {
			return true;
		}
	}

	private abstract static class AbstractNavigationEdgeRole extends AbstractEdgeRole implements EdgeRole.Navigation
	{
		private final boolean isNavigable;

		protected AbstractNavigationEdgeRole(@NonNull Phase phase, boolean isNavigable) {
			super(phase);
			this.isNavigable = isNavigable;
		}

		@Override
		public @NonNull NavigationEdge createEdge(@NonNull Node sourceNode, @NonNull Property source2targetProperty, @NonNull Node targetNode) {
			return BasicNavigationEdge.createEdge(this, sourceNode, source2targetProperty, targetNode);
		}

		@Override
		public @Nullable String getArrowtail() {
			return "vee";
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
		public final boolean isNavigable() {
			return isNavigable;
		}

		@Override
		public final boolean isNavigation() {
			return true;
		}

		@Override
		public @NonNull EdgeRole merge(@NonNull EdgeRole edgeRole) {
			if (edgeRole instanceof AbstractNavigationEdgeRole)
				if (phase == ((AbstractNavigationEdgeRole)edgeRole).phase) {
					if (isNavigable) {
						return this;
					}
					else if (((AbstractNavigationEdgeRole)edgeRole).isNavigable) {
						return edgeRole;
					}
				}
			return super.merge(edgeRole);
		}

		@Override
		public String toString() {
			return phase + (isNavigable ? "-NAVIGABLE-" : "-UNNAVIGABLE-") + getClass().getSimpleName();
		}
	}

	private static class CastEdgeRole extends AbstractNavigationEdgeRole
	{
		private static final @NonNull CastEdgeRole CONSTANT_NAVIGABLE_CAST = new CastEdgeRole(Role.Phase.CONSTANT, true);
		private static final @NonNull CastEdgeRole CONSTANT_UNNAVIGABLE_CAST = new CastEdgeRole(Role.Phase.CONSTANT, false);
		private static final @NonNull CastEdgeRole LOADED_NAVIGABLE_CAST = new CastEdgeRole(Role.Phase.LOADED, true);
		private static final @NonNull CastEdgeRole LOADED_UNNAVIGABLE_CAST = new CastEdgeRole(Role.Phase.LOADED, false);
		private static final @NonNull CastEdgeRole PREDICATED_NAVIGABLE_CAST = new CastEdgeRole(Role.Phase.PREDICATED, true);
		private static final @NonNull CastEdgeRole PREDICATED_UNNAVIGABLE_CAST = new CastEdgeRole(Role.Phase.PREDICATED, false);

		public static EdgeRole.@NonNull Phase getCastEdgePhase(@NonNull Node sourceNode, @NonNull Node targetNode) {
			return RegionUtil.mergeToLessKnownPhase(sourceNode.getNodeRole(), targetNode.getNodeRole()).getPhase();
		}

		public static @NonNull CastEdgeRole getCastEdgeRole(EdgeRole.@NonNull Phase phase, boolean isNavigable) {
			if (isNavigable) {
				switch (phase) {
					case CONSTANT: return CONSTANT_NAVIGABLE_CAST;
					case LOADED: return LOADED_NAVIGABLE_CAST;
					case PREDICATED: return PREDICATED_NAVIGABLE_CAST;
				}
			}
			else {
				switch (phase) {
					case CONSTANT: return CONSTANT_UNNAVIGABLE_CAST;
					case LOADED: return LOADED_UNNAVIGABLE_CAST;
					case PREDICATED: return PREDICATED_UNNAVIGABLE_CAST;
				}
			}
			throw new UnsupportedOperationException();
		}

		private CastEdgeRole(@NonNull Phase phase, boolean isNavigable) {
			super(phase, isNavigable);
		}

		@Override
		public @NonNull CastEdgeRole asPhase(@NonNull Phase phase) {
			return getCastEdgeRole(phase, isNavigable());
		}

		@Override
		public boolean isCast() {
			return true;
		}

		@Override
		public @NonNull EdgeRole merge(@NonNull EdgeRole edgeRole) {
			if (edgeRole instanceof CastEdgeRole) {
				return RegionUtil.mergeToMoreKnownPhase(this, edgeRole);
			}
			else {
				return super.merge(edgeRole);
			}
		}
	}

	private static class ExpressionEdgeRole extends AbstractComputationEdgeRole
	{
		private static final @NonNull ExpressionEdgeRole CONSTANT_EXPRESSION = new ExpressionEdgeRole(Role.Phase.CONSTANT);
		private static final @NonNull ExpressionEdgeRole LOADED_EXPRESSION = new ExpressionEdgeRole(Role.Phase.LOADED);
		private static final @NonNull ExpressionEdgeRole PREDICATED_EXPRESSION = new ExpressionEdgeRole(Role.Phase.PREDICATED);
		private static final @NonNull ExpressionEdgeRole REALIZED_EXPRESSION = new ExpressionEdgeRole(Role.Phase.REALIZED);

		private static @NonNull ExpressionEdgeRole getExpressionEdgeRole(EdgeRole.@NonNull Phase phase) {
			switch (phase) {
				case CONSTANT: return CONSTANT_EXPRESSION;
				case LOADED: return LOADED_EXPRESSION;
				case PREDICATED: return PREDICATED_EXPRESSION;
				case REALIZED: return REALIZED_EXPRESSION;
			}
			throw new UnsupportedOperationException();
		}

		private ExpressionEdgeRole(@NonNull Phase phase) {
			super(phase);
		}

		@Override
		public @NonNull ExpressionEdgeRole asPhase(@NonNull Phase phase) {
			return getExpressionEdgeRole(phase);
		}

		@Override
		public boolean isExpression() {
			return true;
		}

		@Override
		public boolean isPredicate() {
			return false;
		}

		@Override
		public @NonNull EdgeRole merge(@NonNull EdgeRole edgeRole) {
			if (edgeRole instanceof ExpressionEdgeRole) {
				return RegionUtil.mergeToMoreKnownPhase(this, edgeRole);
			}
			else {
				return super.merge(edgeRole);
			}
		}
	}

	private static class IteratedEdgeRole extends AbstractComputationEdgeRole
	{
		private static final @NonNull IteratedEdgeRole CONSTANT_ITERATED = new IteratedEdgeRole(Role.Phase.CONSTANT);
		private static final @NonNull IteratedEdgeRole LOADED_ITERATED = new IteratedEdgeRole(Role.Phase.LOADED);
		private static final @NonNull IteratedEdgeRole PREDICATED_ITERATED = new IteratedEdgeRole(Role.Phase.PREDICATED);
		private static final @NonNull IteratedEdgeRole REALIZED_ITERATED = new IteratedEdgeRole(Role.Phase.REALIZED);

		public static @NonNull IteratedEdgeRole getIteratedEdgeRole(EdgeRole.@NonNull Phase phase) {
			switch (phase) {
				case CONSTANT: return CONSTANT_ITERATED;
				case LOADED: return LOADED_ITERATED;
				case PREDICATED: return PREDICATED_ITERATED;
				case REALIZED: return REALIZED_ITERATED;
			}
			throw new UnsupportedOperationException();
		}

		private IteratedEdgeRole(@NonNull Phase phase) {
			super(phase);
		}

		@Override
		public @NonNull IteratedEdgeRole asPhase(@NonNull Phase phase) {
			return getIteratedEdgeRole(phase);
		}

		@Override
		public @NonNull EdgeRole merge(@NonNull EdgeRole edgeRole) {
			if (edgeRole instanceof IteratedEdgeRole) {
				return RegionUtil.mergeToMoreKnownPhase(this, edgeRole);
			}
			else {
				return super.merge(edgeRole);
			}
		}
	}

	private static class NavigationEdgeRole extends AbstractNavigationEdgeRole
	{
		private static final @NonNull NavigationEdgeRole CONSTANT_NAVIGABLE_NAVIGATION = new NavigationEdgeRole(Role.Phase.CONSTANT, true);
		private static final @NonNull NavigationEdgeRole CONSTANT_UNNAVIGABLE_NAVIGATION = new NavigationEdgeRole(Role.Phase.CONSTANT, false);
		private static final @NonNull NavigationEdgeRole LOADED_NAVIGABLE_NAVIGATION = new NavigationEdgeRole(Role.Phase.LOADED, true);
		private static final @NonNull NavigationEdgeRole LOADED_UNNAVIGABLE_NAVIGATION = new NavigationEdgeRole(Role.Phase.LOADED, false);
		private static final @NonNull NavigationEdgeRole PREDICATED_NAVIGABLE_NAVIGATION = new NavigationEdgeRole(Role.Phase.PREDICATED, true);
		private static final @NonNull NavigationEdgeRole PREDICATED_UNNAVIGABLE_NAVIGATION = new NavigationEdgeRole(Role.Phase.PREDICATED, false);
		private static final @NonNull NavigationEdgeRole REALIZED_NAVIGABLE_NAVIGATION = new NavigationEdgeRole(Role.Phase.REALIZED, true);

		public static EdgeRole.@NonNull Phase getNavigationEdgePhase(@NonNull Node sourceNode, @NonNull Node targetNode) {
			return RegionUtil.mergeToLessKnownPhase(sourceNode.getNodeRole(), targetNode.getNodeRole()).getPhase();
		}

		public static @NonNull NavigationEdgeRole getNavigationEdgeRole(EdgeRole.@NonNull Phase phase, boolean isNavigable) {
			if (isNavigable) {
				switch (phase) {
					case CONSTANT: return CONSTANT_NAVIGABLE_NAVIGATION;
					case LOADED: return LOADED_NAVIGABLE_NAVIGATION;
					case PREDICATED: return PREDICATED_NAVIGABLE_NAVIGATION;
					case REALIZED: return REALIZED_NAVIGABLE_NAVIGATION;
				}
			}
			else {
				switch (phase) {
					case CONSTANT: return CONSTANT_UNNAVIGABLE_NAVIGATION;
					case LOADED: return LOADED_UNNAVIGABLE_NAVIGATION;
					case PREDICATED: return PREDICATED_UNNAVIGABLE_NAVIGATION;
				}
			}
			throw new UnsupportedOperationException();
		}

		protected NavigationEdgeRole(@NonNull Phase phase, boolean isNavigable) {
			super(phase, isNavigable);
		}

		@Override
		public @NonNull NavigationEdgeRole asPhase(@NonNull Phase phase) {
			return getNavigationEdgeRole(phase, isNavigable());
		}

		@Override
		public @NonNull EdgeRole merge(@NonNull EdgeRole edgeRole) {
			if (edgeRole instanceof NavigationEdgeRole) {
				return RegionUtil.mergeToMoreKnownPhase(this, edgeRole);
			}
			else {
				return super.merge(edgeRole);
			}
		}
	}

	private static class PredicateEdgeRole extends AbstractComputationEdgeRole
	{
		private static final @NonNull PredicateEdgeRole CONSTANT_PREDICATE = new PredicateEdgeRole(Role.Phase.CONSTANT);
		private static final @NonNull PredicateEdgeRole LOADED_PREDICATE = new PredicateEdgeRole(Role.Phase.LOADED);
		private static final @NonNull PredicateEdgeRole PREDICATED_PREDICATE = new PredicateEdgeRole(Role.Phase.PREDICATED);
		private static final @NonNull PredicateEdgeRole REALIZED_PREDICATE = new PredicateEdgeRole(Role.Phase.REALIZED);

		public static @NonNull PredicateEdgeRole getPredicateEdgeRole(EdgeRole.@NonNull Phase phase) {
			switch (phase) {
				case CONSTANT: return CONSTANT_PREDICATE;
				case LOADED: return LOADED_PREDICATE;
				case PREDICATED: return PREDICATED_PREDICATE;
				case REALIZED: return REALIZED_PREDICATE;
			}
			throw new UnsupportedOperationException();
		}

		private PredicateEdgeRole(@NonNull Phase phase) {
			super(phase);
		}

		@Override
		public @NonNull PredicateEdgeRole asPhase(@NonNull Phase phase) {
			return getPredicateEdgeRole(phase);
		}

		@Override
		public boolean isExpression() {
			return true;			// FIXME
		}

		@Override
		public boolean isPredicate() {
			return true;
		}

		@Override
		public @NonNull EdgeRole merge(@NonNull EdgeRole edgeRole) {
			if (edgeRole instanceof PredicateEdgeRole) {
				return RegionUtil.mergeToMoreKnownPhase(this, edgeRole);
			}
			else {
				return super.merge(edgeRole);
			}
		}
	}

	private static final class RecursionEdgeRole extends AbstractEdgeRole implements EdgeRole.Recursion
	{
		public static final EdgeRole.@NonNull Recursion PRIMARY_RECURSION = new RecursionEdgeRole(true);
		public static final EdgeRole.@NonNull Recursion SECONDARY_RECURSION = new RecursionEdgeRole(false);

		private boolean isPrimary;

		protected RecursionEdgeRole(boolean isPrimary) {
			super(Phase.OTHER);
			this.isPrimary = isPrimary;
		}

		@Override
		public @NonNull Edge createEdge(@NonNull Node sourceNode, @NonNull Node targetNode) {
			return new BasicEdge(this, sourceNode, null, targetNode);
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

	public static @NonNull NavigationEdge createCastEdge(@NonNull Node sourceNode, @NonNull Property source2targetProperty, @NonNull Node targetNode) {
		boolean resolvedNavigation = /*isNavigable != null ? isNavigable.booleanValue() :*/ sourceNode.isNavigable();
		EdgeRole.Phase phase = CastEdgeRole.getCastEdgePhase(sourceNode, targetNode);
		CastEdgeRole edgeRole = CastEdgeRole.getCastEdgeRole(phase, resolvedNavigation);
		return edgeRole.createEdge(sourceNode, source2targetProperty, targetNode);
	}

	public static @NonNull Edge createExpressionEdge(@NonNull Node sourceNode, @Nullable String name, @NonNull Node targetNode) {
		ExpressionEdgeRole edgeRole = ExpressionEdgeRole.getExpressionEdgeRole(sourceNode.getNodeRole().getPhase());
		return edgeRole.createEdge(sourceNode, name, targetNode);
	}

	public static @NonNull Edge createIteratedEdge(@NonNull Node sourceNode,@NonNull Node targetNode) {
		IteratedEdgeRole edgeRole = IteratedEdgeRole.getIteratedEdgeRole(sourceNode.getNodeRole().getPhase());
		return edgeRole.createEdge(sourceNode, null, targetNode);
	}

	public static @NonNull NavigationEdge createNavigableNavigationEdge(@NonNull Node sourceNode, @NonNull Property source2targetProperty, @NonNull Node targetNode) {
		EdgeRole.Phase edgePhase = NavigationEdgeRole.getNavigationEdgePhase(sourceNode, targetNode);
		NavigationEdgeRole navigationEdgeRole = NavigationEdgeRole.getNavigationEdgeRole(edgePhase, true);
		return navigationEdgeRole.createEdge(sourceNode, source2targetProperty, targetNode);
	}

	public static @NonNull NavigationEdge createNavigationEdge(@NonNull Node sourceNode, @NonNull Property source2targetProperty, @NonNull Node targetNode) {
		boolean resolvedNavigation = sourceNode.isNavigable();
		EdgeRole.Phase phase = NavigationEdgeRole.getNavigationEdgePhase(sourceNode, targetNode);
		NavigationEdgeRole edgeRole = NavigationEdgeRole.getNavigationEdgeRole(phase, resolvedNavigation);
		return edgeRole.createEdge(sourceNode, source2targetProperty, targetNode);
	}

	public static @NonNull Edge createRealizedExpressionEdge(@NonNull Node sourceNode, @Nullable String name, @NonNull Node targetNode) {
		ExpressionEdgeRole edgeRole = ExpressionEdgeRole.getExpressionEdgeRole(Role.Phase.REALIZED);
		return edgeRole.createEdge(sourceNode, name, targetNode);
	}

	public static @NonNull Edge createPredicateEdge(@NonNull Node sourceNode, @Nullable String name, @NonNull Node targetNode) {
		PredicateEdgeRole edgeRole = PredicateEdgeRole.getPredicateEdgeRole(sourceNode.getNodeRole().getPhase());
		return edgeRole.createEdge(sourceNode, name, targetNode);
	}

	public static @NonNull Edge createPrimaryRecursionEdge(@NonNull Node sourceNode, @NonNull Node targetNode) {
		return RecursionEdgeRole.PRIMARY_RECURSION.createEdge(sourceNode, targetNode);
	}

	public static @NonNull NavigationEdge createRealizedNavigationEdge(@NonNull Node sourceNode, @NonNull Property source2targetProperty, @NonNull Node targetNode) {
		NavigationEdgeRole navigationEdgeRole = NavigationEdgeRole.getNavigationEdgeRole(Role.Phase.REALIZED, true);	// FIXME make REALIZED edges unnavigable
		return navigationEdgeRole.createEdge(sourceNode, source2targetProperty, targetNode);
	}

	public static @NonNull Edge createSecondaryRecursionEdge(@NonNull Node sourceNode, @NonNull Node targetNode) {
		return RecursionEdgeRole.SECONDARY_RECURSION.createEdge(sourceNode, targetNode);
	}

	public static @NonNull NavigationEdge createUnnavigableCastEdge(@NonNull Node sourceNode, @NonNull Property castProperty, @NonNull Node castNode) {
		EdgeRole.Phase phase = CastEdgeRole.getCastEdgePhase(sourceNode, castNode);
		CastEdgeRole edgeRole = CastEdgeRole.getCastEdgeRole(phase, false);
		return edgeRole.createEdge(sourceNode, castProperty, castNode);
	}

	public static @NonNull NavigationEdge createUnnavigableNavigationEdge(@NonNull Node sourceNode, @NonNull Property source2targetProperty, @NonNull Node targetNode) {
		EdgeRole.Phase edgePhase = NavigationEdgeRole.getNavigationEdgePhase(sourceNode, targetNode);
		NavigationEdgeRole navigationEdgeRole = NavigationEdgeRole.getNavigationEdgeRole(edgePhase, false);
		return navigationEdgeRole.createEdge(sourceNode, source2targetProperty, targetNode);
	}
}