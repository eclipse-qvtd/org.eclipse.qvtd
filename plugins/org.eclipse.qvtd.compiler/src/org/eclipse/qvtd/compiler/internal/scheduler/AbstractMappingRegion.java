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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.VariableDeclaration;

public abstract class AbstractMappingRegion extends AbstractRegion implements SimpleRegion
{
	/**
	 * The node for each navigable VariableDeclaration.
	 */
	private final @NonNull Map<VariableDeclaration, SimpleNode> variable2simpleNode = new HashMap<VariableDeclaration, SimpleNode>();

	protected AbstractMappingRegion(@NonNull SuperRegion superRegion) {
		super(superRegion);
	}
	
	public void addAssignmentEdge(@NonNull SimpleNode sourceNode, @NonNull Property source2targetProperty, @NonNull SimpleNode targetNode) {
		assert sourceNode.isClassNode();
		Edge assignmentEdge = sourceNode.getAssignmentEdge(source2targetProperty);
		if (assignmentEdge == null) {
			Edges.REALIZED.createEdge(this, sourceNode, source2targetProperty, targetNode);
		}
		else {
			assert assignmentEdge.getTarget() == targetNode;
		}
	}
	
	public void addPredicateEdge(@NonNull SimpleNode sourceNode, @NonNull Property source2targetProperty, @NonNull SimpleNode targetNode) {
		assert sourceNode.isClassNode();
		SimpleEdge predicateEdge = sourceNode.getPredicateEdge(source2targetProperty);
		if (predicateEdge == null) {
			Edges.NAVIGATION.createSimpleEdge(this, sourceNode, source2targetProperty, targetNode);
		}
		else {
			assert predicateEdge.getTarget() == targetNode;
		}
	}

	public void addVariableNode(@NonNull VariableDeclaration typedElement, @NonNull SimpleNode simpleNode) {
		variable2simpleNode.put(typedElement, simpleNode);
	}
	
	public abstract @NonNull SimpleNode createExtraGuard(@NonNull Node extraNode);
	
	/**
	 * Create a navigable path from startNode following the edges of protoPath, re-using edges and nodes where possible.
	 * Returns a mapping of the proto-edges to the created/re-used edges.
	 *
	protected @NonNull Map<SimpleEdge, SimpleEdge> createPath(@NonNull SimpleNode startNode, @NonNull List<SimpleNavigationEdge> protoPath) {
		Map<SimpleEdge, SimpleEdge> path = new HashMap<SimpleEdge, SimpleEdge>();
		SimpleRegion region = startNode.getRegion();
		SimpleNode sourceNode = startNode;
		for (SimpleNavigationEdge protoEdge : protoPath) {
			SimpleNavigationEdge edge = sourceNode.getNavigationEdge(protoEdge.getProperty());
			if (edge == null) {
				SimpleNode protoTarget = protoEdge.getTarget();
				SimpleNode targetNode = protoTarget.getNodeRole().createSimpleNode(region, protoTarget.getName(), protoTarget.getClassDatumAnalysis());
				edge = ((NavigationEdgeRole)protoEdge.getEdgeRole()).createSimpleEdge(region, sourceNode, protoEdge.getProperty(), targetNode);
			}
			sourceNode = edge.getTarget();
			path.put(protoEdge, edge);
		}
		return path;
	} */

	public @NonNull SimpleNode getReferenceNode(@NonNull VariableDeclaration variable) {
		SimpleNode node = variable2simpleNode.get(variable);
		assert node != null;
		return node;
/*		if (variable instanceof RealizedVariable) {
			return Nodes.REALIZED_VARIABLE.createNode(this, (RealizedVariable)variable);
		}
		else if (variable.eContainer() instanceof BottomPattern) {
			return Nodes.UNREALIZED_VARIABLE.createNode(this, variable);
		}
		else {
			return new GuardVariableNode(this, variable);
		} */
	}

	public @Nullable SimpleNode getSimpleNode(@NonNull TypedElement typedElement) {
		return variable2simpleNode.get(typedElement);
	}

	public abstract @NonNull SimpleNode getUnknownNode(@NonNull TypedElement typedElement);
}