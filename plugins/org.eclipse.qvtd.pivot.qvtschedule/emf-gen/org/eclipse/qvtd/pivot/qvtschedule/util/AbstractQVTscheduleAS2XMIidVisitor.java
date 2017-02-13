/*******************************************************************************
 * <copyright>
 *
 * Copyright (c) 2013, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * This code is auto-generated
 * from: org.eclipse.qvtd.pivot.qvtschedule/model/QVTschedule.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvtd.pivot.qvtschedule.util;

import java.lang.Boolean;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.utilities.AS2XMIid;
import org.eclipse.ocl.pivot.utilities.PivotAS2XMIidVisitor;

/**
 * An AbstractQVTscheduleAS2XMIidVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractQVTscheduleAS2XMIidVisitor
	extends PivotAS2XMIidVisitor
	implements QVTscheduleVisitor<Boolean>
{
	/**
	 * Initializes me with an initial value for my result.
	 *
	 * @param context my initial result value
	 */
	protected AbstractQVTscheduleAS2XMIidVisitor(@NonNull AS2XMIid context) {
		super(context);
	}

	@Override
	public @Nullable Boolean visitAbstractDatum(org.eclipse.qvtd.pivot.qvtschedule.@NonNull AbstractDatum object) {
		return visitElement(object);
	}

	@Override
	public @Nullable Boolean visitBasicMappingRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull BasicMappingRegion object) {
		return visitMappingRegion(object);
	}

	@Override
	public @Nullable Boolean visitCastEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull CastEdge object) {
		return visitNavigableEdge(object);
	}

	@Override
	public @Nullable Boolean visitClassDatum(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ClassDatum object) {
		return visitAbstractDatum(object);
	}

	@Override
	public @Nullable Boolean visitClassDatumAnalysis(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ClassDatumAnalysis object) {
		return visitElement(object);
	}

	@Override
	public @Nullable Boolean visitComposedNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ComposedNode object) {
		return visitNode(object);
	}

	@Override
	public @Nullable Boolean visitConnection(org.eclipse.qvtd.pivot.qvtschedule.@NonNull Connection object) {
		return visitElement(object);
	}

	@Override
	public @Nullable Boolean visitConnectionRole(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ConnectionRole object) {
		return visitElement(object);
	}

	@Override
	public @Nullable Boolean visitDatumConnection(org.eclipse.qvtd.pivot.qvtschedule.@NonNull DatumConnection<?> object) {
		return visitConnection(object);
	}

	@Override
	public @Nullable Boolean visitDependencyNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull DependencyNode object) {
		return visitNode(object);
	}

	@Override
	public @Nullable Boolean visitEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull Edge object) {
		return visitElement(object);
	}

	@Override
	public @Nullable Boolean visitEdgeConnection(org.eclipse.qvtd.pivot.qvtschedule.@NonNull EdgeConnection object) {
		return visitDatumConnection(object);
	}

	@Override
	public @Nullable Boolean visitEdgeRole(org.eclipse.qvtd.pivot.qvtschedule.@NonNull EdgeRole object) {
		return visitRole(object);
	}

	@Override
	public @Nullable Boolean visitErrorNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ErrorNode object) {
		return visitNode(object);
	}

	@Override
	public @Nullable Boolean visitExpressionEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ExpressionEdge object) {
		return visitEdge(object);
	}

	@Override
	public @Nullable Boolean visitInputNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull InputNode object) {
		return visitNode(object);
	}

	@Override
	public @Nullable Boolean visitIteratedEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull IteratedEdge object) {
		return visitEdge(object);
	}

	@Override
	public @Nullable Boolean visitIteratorNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull IteratorNode object) {
		return visitVariableNode(object);
	}

	@Override
	public @Nullable Boolean visitMappingAction(org.eclipse.qvtd.pivot.qvtschedule.@NonNull MappingAction object) {
		return visitElement(object);
	}

	@Override
	public @Nullable Boolean visitMappingRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull MappingRegion object) {
		return visitRegion(object);
	}

	@Override
	public @Nullable Boolean visitMicroMappingRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull MicroMappingRegion object) {
		return visitMappingRegion(object);
	}

	@Override
	public @Nullable Boolean visitMultiRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull MultiRegion object) {
		return visitElement(object);
	}

	@Override
	public @Nullable Boolean visitNamedMappingRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull NamedMappingRegion object) {
		return visitMappingRegion(object);
	}

	@Override
	public @Nullable Boolean visitNavigableEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull NavigableEdge object) {
		return visitEdge(object);
	}

	@Override
	public @Nullable Boolean visitNavigationEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull NavigationEdge object) {
		return visitNavigableEdge(object);
	}

	@Override
	public @Nullable Boolean visitNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull Node object) {
		return visitElement(object);
	}

	@Override
	public @Nullable Boolean visitNodeConnection(org.eclipse.qvtd.pivot.qvtschedule.@NonNull NodeConnection object) {
		return visitDatumConnection(object);
	}

	@Override
	public @Nullable Boolean visitNodeRole(org.eclipse.qvtd.pivot.qvtschedule.@NonNull NodeRole object) {
		return visitRole(object);
	}

	@Override
	public @Nullable Boolean visitNullNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull NullNode object) {
		return visitNode(object);
	}

	@Override
	public @Nullable Boolean visitOperationNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull OperationNode object) {
		return visitNode(object);
	}

	@Override
	public @Nullable Boolean visitOperationRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull OperationRegion object) {
		return visitRegion(object);
	}

	@Override
	public @Nullable Boolean visitPatternTypedNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull PatternTypedNode object) {
		return visitNode(object);
	}

	@Override
	public @Nullable Boolean visitPatternVariableNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull PatternVariableNode object) {
		return visitVariableNode(object);
	}

	@Override
	public @Nullable Boolean visitPredicateEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull PredicateEdge object) {
		return visitEdge(object);
	}

	@Override
	public @Nullable Boolean visitPropertyDatum(org.eclipse.qvtd.pivot.qvtschedule.@NonNull PropertyDatum object) {
		return visitAbstractDatum(object);
	}

	@Override
	public @Nullable Boolean visitRecursionEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull RecursionEdge object) {
		return visitEdge(object);
	}

	@Override
	public @Nullable Boolean visitRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull Region object) {
		return visitElement(object);
	}

	@Override
	public @Nullable Boolean visitRole(org.eclipse.qvtd.pivot.qvtschedule.@NonNull Role object) {
		return visitElement(object);
	}

	@Override
	public @Nullable Boolean visitRootCompositionRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull RootCompositionRegion object) {
		return visitRegion(object);
	}

	@Override
	public @Nullable Boolean visitRootScheduledRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull RootScheduledRegion object) {
		return visitScheduledRegion(object);
	}

	@Override
	public @Nullable Boolean visitScheduledRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ScheduledRegion object) {
		return visitRegion(object);
	}

	@Override
	public @Nullable Boolean visitSchedulerConstants(org.eclipse.qvtd.pivot.qvtschedule.@NonNull SchedulerConstants object) {
		return visitElement(object);
	}

	@Override
	public @Nullable Boolean visitTrueNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull TrueNode object) {
		return visitNode(object);
	}

	@Override
	public @Nullable Boolean visitUnknownNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull UnknownNode object) {
		return visitNode(object);
	}

	@Override
	public @Nullable Boolean visitVariableNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull VariableNode object) {
		return visitNode(object);
	}
}
