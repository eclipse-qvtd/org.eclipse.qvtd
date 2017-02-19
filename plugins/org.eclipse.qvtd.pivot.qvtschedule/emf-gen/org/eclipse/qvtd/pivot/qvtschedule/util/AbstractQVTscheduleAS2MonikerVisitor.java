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

import java.lang.Object;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.utilities.AS2Moniker;
import org.eclipse.ocl.pivot.utilities.PivotAS2MonikerVisitor;

/**
 * An AbstractQVTscheduleAS2MonikerVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractQVTscheduleAS2MonikerVisitor
	extends PivotAS2MonikerVisitor
	implements QVTscheduleVisitor<Object>
{
	/**
	 * Initializes me with an initial value for my result.
	 *
	 * @param context my initial result value
	 */
	protected AbstractQVTscheduleAS2MonikerVisitor(@NonNull AS2Moniker context) {
		super(context);
	}

	@Override
	public @Nullable Object visitAbstractDatum(org.eclipse.qvtd.pivot.qvtschedule.@NonNull AbstractDatum object) {
		return visitElement(object);
	}

	@Override
	public @Nullable Object visitBasicMappingRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull BasicMappingRegion object) {
		return visitMappingRegion(object);
	}

	@Override
	public @Nullable Object visitCastEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull CastEdge object) {
		return visitNavigableEdge(object);
	}

	@Override
	public @Nullable Object visitClassDatum(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ClassDatum object) {
		return visitAbstractDatum(object);
	}

	@Override
	public @Nullable Object visitClassDatumAnalysis(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ClassDatumAnalysis object) {
		return visitElement(object);
	}

	@Override
	public @Nullable Object visitComposedNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ComposedNode object) {
		return visitNode(object);
	}

	@Override
	public @Nullable Object visitConnection(org.eclipse.qvtd.pivot.qvtschedule.@NonNull Connection object) {
		return visitElement(object);
	}

	@Override
	public @Nullable Object visitConnectionRole(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ConnectionRole object) {
		return visitElement(object);
	}

	@Override
	public @Nullable Object visitDatumConnection(org.eclipse.qvtd.pivot.qvtschedule.@NonNull DatumConnection<?> object) {
		return visitConnection(object);
	}

	@Override
	public @Nullable Object visitDependencyNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull DependencyNode object) {
		return visitNode(object);
	}

	@Override
	public @Nullable Object visitEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull Edge object) {
		return visitElement(object);
	}

	@Override
	public @Nullable Object visitEdgeConnection(org.eclipse.qvtd.pivot.qvtschedule.@NonNull EdgeConnection object) {
		return visitDatumConnection(object);
	}

	@Override
	public @Nullable Object visitEdgeRole(org.eclipse.qvtd.pivot.qvtschedule.@NonNull EdgeRole object) {
		return visitRole(object);
	}

	@Override
	public @Nullable Object visitErrorNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ErrorNode object) {
		return visitNode(object);
	}

	@Override
	public @Nullable Object visitExpressionEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ExpressionEdge object) {
		return visitEdge(object);
	}

	@Override
	public @Nullable Object visitInputNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull InputNode object) {
		return visitNode(object);
	}

	@Override
	public @Nullable Object visitIteratedEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull IteratedEdge object) {
		return visitEdge(object);
	}

	@Override
	public @Nullable Object visitIteratorNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull IteratorNode object) {
		return visitVariableNode(object);
	}

	@Override
	public @Nullable Object visitMappingAction(org.eclipse.qvtd.pivot.qvtschedule.@NonNull MappingAction object) {
		return visitElement(object);
	}

	@Override
	public @Nullable Object visitMappingRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull MappingRegion object) {
		return visitRegion(object);
	}

	@Override
	public @Nullable Object visitMicroMappingRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull MicroMappingRegion object) {
		return visitMappingRegion(object);
	}

	@Override
	public @Nullable Object visitMultiRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull MultiRegion object) {
		return visitElement(object);
	}

	@Override
	public @Nullable Object visitNamedMappingRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull NamedMappingRegion object) {
		return visitMappingRegion(object);
	}

	@Override
	public @Nullable Object visitNavigableEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull NavigableEdge object) {
		return visitEdge(object);
	}

	@Override
	public @Nullable Object visitNavigationEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull NavigationEdge object) {
		return visitNavigableEdge(object);
	}

	@Override
	public @Nullable Object visitNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull Node object) {
		return visitElement(object);
	}

	@Override
	public @Nullable Object visitNodeConnection(org.eclipse.qvtd.pivot.qvtschedule.@NonNull NodeConnection object) {
		return visitDatumConnection(object);
	}

	@Override
	public @Nullable Object visitNodeRole(org.eclipse.qvtd.pivot.qvtschedule.@NonNull NodeRole object) {
		return visitRole(object);
	}

	@Override
	public @Nullable Object visitNullNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull NullNode object) {
		return visitNode(object);
	}

	@Override
	public @Nullable Object visitOperationNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull OperationNode object) {
		return visitNode(object);
	}

	@Override
	public @Nullable Object visitOperationRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull OperationRegion object) {
		return visitRegion(object);
	}

	@Override
	public @Nullable Object visitPatternTypedNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull PatternTypedNode object) {
		return visitNode(object);
	}

	@Override
	public @Nullable Object visitPatternVariableNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull PatternVariableNode object) {
		return visitVariableNode(object);
	}

	@Override
	public @Nullable Object visitPredicateEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull PredicateEdge object) {
		return visitEdge(object);
	}

	@Override
	public @Nullable Object visitPropertyDatum(org.eclipse.qvtd.pivot.qvtschedule.@NonNull PropertyDatum object) {
		return visitAbstractDatum(object);
	}

	@Override
	public @Nullable Object visitRecursionEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull RecursionEdge object) {
		return visitEdge(object);
	}

	@Override
	public @Nullable Object visitRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull Region object) {
		return visitElement(object);
	}

	@Override
	public @Nullable Object visitRole(org.eclipse.qvtd.pivot.qvtschedule.@NonNull Role object) {
		return visitElement(object);
	}

	@Override
	public @Nullable Object visitRootScheduledRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull RootScheduledRegion object) {
		return visitScheduledRegion(object);
	}

	@Override
	public @Nullable Object visitScheduledRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ScheduledRegion object) {
		return visitRegion(object);
	}

	@Override
	public @Nullable Object visitSchedulerConstants(org.eclipse.qvtd.pivot.qvtschedule.@NonNull SchedulerConstants object) {
		return visitElement(object);
	}

	@Override
	public @Nullable Object visitTrueNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull TrueNode object) {
		return visitNode(object);
	}

	@Override
	public @Nullable Object visitUnknownNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull UnknownNode object) {
		return visitNode(object);
	}

	@Override
	public @Nullable Object visitVariableNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull VariableNode object) {
		return visitNode(object);
	}
}