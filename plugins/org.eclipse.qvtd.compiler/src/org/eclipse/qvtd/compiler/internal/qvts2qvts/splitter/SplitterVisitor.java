/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvts.splitter;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.AbstractRegion;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.AbstractVisitor;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.BasicNodeConnection;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.BasicSimpleEdge;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.ClassDatumAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Edge;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.EdgeRole;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Node;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.NodeConnection;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.NodeRole;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.QVTp2QVTs;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Region;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.RootScheduledRegion;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.SimpleMappingRegion;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.SimpleNavigationEdge;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.SimpleNode;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.SimpleRegion;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.SimpleTypedNode;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.SimpleVariableNode;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Visitable;
import org.eclipse.qvtd.compiler.internal.utilities.SymbolNameBuilder;

public class SplitterVisitor extends AbstractVisitor<@Nullable Visitable>
{
	protected final @NonNull RootScheduledRegion rootRegion;
	//	protected final @NonNull MultiRegion multiRegion;
	protected final @NonNull Stage stage;
	protected final int stageNumber;
	protected final @NonNull Map<@NonNull Node, @NonNull Node> oldSourceNode2newSourceNode;
	protected final @NonNull Map<@NonNull Visitable, @NonNull Visitable> old2new = new HashMap<>();

	public SplitterVisitor(@NonNull RootScheduledRegion rootRegion, @NonNull Stage stage, int stageNumber, @NonNull Map<@NonNull Node, @NonNull Node> oldSourceNode2newSourceNode) {
		this.rootRegion = rootRegion;
		//		this.multiRegion = rootRegion.getMultiRegion();
		this.stage = stage;
		this.stageNumber = stageNumber;
		this.oldSourceNode2newSourceNode = oldSourceNode2newSourceNode;
	}

	protected <@NonNull T extends Visitable> @Nullable T basicGetNew(@NonNull Class<T> returnClass, @NonNull Visitable oldVisitable, boolean useExternals) {
		Visitable newVisitable = old2new.get(oldVisitable);
		if ((newVisitable == null) && useExternals) {
			newVisitable = oldSourceNode2newSourceNode.get(oldVisitable);
		}
		if (newVisitable == null) {
			return null;
		}
		if (!returnClass.isAssignableFrom(newVisitable.getClass())) {
			throw new ClassCastException("bad return from SplitterVisitor for " + oldVisitable.getClass().getSimpleName());
		}
		@SuppressWarnings("unchecked") T castVisitable = (T) newVisitable;
		return castVisitable;
	}

	public @NonNull AbstractRegion createRegion(@NonNull Region oldRegion) {
		AbstractRegion newRegion = create(AbstractRegion.class, oldRegion);
		/**
		 * Accumulate the mappings for sources of edges to successors.
		 */
		for (@NonNull Stage successor : stage.getSuccessors()) {
			for (@NonNull Node headNode : successor.getHeadNodes()) {
				for (@NonNull Edge edge : headNode.getIncomingEdges()) {
					Node oldSourceNode = edge.getSource();
					Node newSourceNode = basicGetNew(Node.class, oldSourceNode, false);
					if (newSourceNode != null) {
						oldSourceNode2newSourceNode.put(oldSourceNode, newSourceNode);
					}
				}
			}
		}
		return newRegion;
	}

	public void extend(@NonNull AbstractRegion stageRegion, @NonNull Stage nextStage, @NonNull Region oldRegion) {
		// TODO Auto-generated method stub

	}

	protected <@NonNull T extends Visitable> T getNew(@NonNull Class<T> returnClass, @NonNull Visitable oldVisitable) {
		Visitable newVisitable = old2new.get(oldVisitable);
		if (newVisitable == null) {
			throw new NullPointerException("null return from SplitterVisitor for " + oldVisitable.getClass().getSimpleName());
		}
		if (!returnClass.isAssignableFrom(newVisitable.getClass())) {
			throw new ClassCastException("bad return from SplitterVisitor for " + oldVisitable.getClass().getSimpleName());
		}
		@SuppressWarnings("unchecked") T castVisitable = (T) newVisitable;
		return castVisitable;
	}

	public @NonNull Stage getStage() {
		return stage;
	}

	@Override
	public @Nullable Visitable visitBasicSimpleEdge(@NonNull BasicSimpleEdge oldBasicSimpleEdge) {
		BasicSimpleEdge newBasicSimpleEdge = basicGetNew(BasicSimpleEdge.class, oldBasicSimpleEdge, false);
		if (newBasicSimpleEdge == null) {
			SimpleNode newSourceNode = basicGetNew(SimpleNode.class, oldBasicSimpleEdge.getSource(), false);
			if (newSourceNode != null) {
				EdgeRole edgeRole = oldBasicSimpleEdge.getEdgeRole();
				SimpleRegion newRegion = getNew(SimpleRegion.class, oldBasicSimpleEdge.getRegion());
				String name = oldBasicSimpleEdge.getName();
				SimpleNode newTargetNode = getNew(SimpleNode.class, oldBasicSimpleEdge.getTarget());
				newBasicSimpleEdge = new BasicSimpleEdge(edgeRole, newRegion, newSourceNode, name, newTargetNode);
			}
			else {
				newSourceNode = basicGetNew(SimpleNode.class, oldBasicSimpleEdge.getSource(), true);
				if (newSourceNode != null) {
					SimpleNode newTargetNode = getNew(SimpleNode.class, oldBasicSimpleEdge.getTarget());
					ClassDatumAnalysis classDatumAnalysis = newTargetNode.getClassDatumAnalysis();
					SymbolNameBuilder s = new SymbolNameBuilder();
					s.appendString("js_");
					s.appendName(classDatumAnalysis.getCompleteClass().getName());
					NodeConnection headConnection = new BasicNodeConnection(rootRegion, Collections.singleton(newSourceNode), s, classDatumAnalysis);
					headConnection.addPassedTargetNode(newTargetNode);
					if (QVTp2QVTs.CONNECTION_CREATION.isActive()) {
						QVTp2QVTs.CONNECTION_CREATION.println("  Head NodeConnection to " + newTargetNode);
						QVTp2QVTs.CONNECTION_CREATION.println("    from " + newSourceNode);
					}
					return headConnection;
				}
			}
		}
		return newBasicSimpleEdge;
	}

	@Override
	public @Nullable Visitable visitSimpleMappingRegion(@NonNull SimpleMappingRegion oldRegion) {
		SimpleMappingRegion newRegion = new SimpleMappingRegion(oldRegion) {
			@Override
			public @NonNull String getName() {
				return super.getName() + "_" + stageNumber;
			}
		};
		old2new.put(oldRegion, newRegion);
		for (@NonNull Node oldNode : stage.getHeadNodes()) {
			Node newNode = create(Node.class, oldNode);
			old2new.put(oldNode, newNode);
		}
		for (@NonNull Node oldNode : stage.getOtherNodes()) {
			Node newNode = create(Node.class, oldNode);
			old2new.put(oldNode, newNode);
		}
		for (@NonNull Edge oldEdge : oldRegion.getEdges()) {
			Node newSource = basicGetNew(Node.class, oldEdge.getSource(), true);
			Node newTarget = basicGetNew(Node.class, oldEdge.getTarget(), false);
			if ((newSource != null) && (newTarget != null)) {
				Visitable newEdge = create(Visitable.class, oldEdge);		// may be Connection
				old2new.put(oldEdge, newEdge);
			}
		}
		return newRegion;
	}

	@Override
	public @Nullable Visitable visitSimpleNavigationEdge(@NonNull SimpleNavigationEdge oldSimpleNavigationEdge) {
		SimpleNavigationEdge newSimpleNavigationEdge = basicGetNew(SimpleNavigationEdge.class, oldSimpleNavigationEdge, false);
		if (newSimpleNavigationEdge == null) {
			SimpleNode sourceNode = basicGetNew(SimpleNode.class, oldSimpleNavigationEdge.getSource(), true);
			if (sourceNode != null) {
				EdgeRole.Navigation edgeRole = oldSimpleNavigationEdge.getEdgeRole();
				SimpleRegion newRegion = getNew(SimpleRegion.class, oldSimpleNavigationEdge.getRegion());
				Property source2targetProperty = oldSimpleNavigationEdge.getProperty();
				SimpleNode targetNode = getNew(SimpleNode.class, oldSimpleNavigationEdge.getTarget());
				newSimpleNavigationEdge = new SimpleNavigationEdge(edgeRole, newRegion, sourceNode, source2targetProperty, targetNode);
			}
		}
		return newSimpleNavigationEdge;
	}

	@Override
	public @NonNull SimpleTypedNode visitSimpleTypedNode(@NonNull SimpleTypedNode oldSimpleTypedNode) {
		SimpleTypedNode newSimpleTypedNode = basicGetNew(SimpleTypedNode.class, oldSimpleTypedNode, true);
		if (newSimpleTypedNode == null) {
			NodeRole nodeRole = oldSimpleTypedNode.getNodeRole();
			SimpleRegion newRegion = getNew(SimpleRegion.class, oldSimpleTypedNode.getRegion());
			String name = oldSimpleTypedNode.getName();
			ClassDatumAnalysis classDatumAnalysis = oldSimpleTypedNode.getClassDatumAnalysis();
			newSimpleTypedNode = new SimpleTypedNode(nodeRole, newRegion, name, classDatumAnalysis);
			for (@NonNull TypedElement typedElement : oldSimpleTypedNode.getTypedElements()) {
				newSimpleTypedNode.addTypedElement(typedElement);
			}
		}
		return newSimpleTypedNode;
	}

	@Override
	public @NonNull SimpleVariableNode visitSimpleVariableNode(@NonNull SimpleVariableNode oldSimpleVariableNode) {
		SimpleVariableNode newSimpleVariableNode = basicGetNew(SimpleVariableNode.class, oldSimpleVariableNode, true);
		if (newSimpleVariableNode == null) {
			NodeRole nodeRole = oldSimpleVariableNode.getNodeRole();
			SimpleRegion newRegion = getNew(SimpleRegion.class, oldSimpleVariableNode.getRegion());
			@NonNull VariableDeclaration variable = oldSimpleVariableNode.getVariable();
			newSimpleVariableNode = new SimpleVariableNode(nodeRole, newRegion, variable);
		}
		return newSimpleVariableNode;
	}
}
