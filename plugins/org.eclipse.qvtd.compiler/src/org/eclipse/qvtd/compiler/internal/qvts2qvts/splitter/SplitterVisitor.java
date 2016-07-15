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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.AbstractRegion;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.AbstractVisitor;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.BasicSimpleEdge;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.ClassDatumAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Edge;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.EdgeRole;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.MultiRegion;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Node;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.NodeRole;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Region;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.SimpleMappingRegion;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.SimpleNavigationEdge;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.SimpleNode;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.SimpleRegion;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.SimpleTypedNode;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.SimpleVariableNode;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Visitable;

public class SplitterVisitor extends AbstractVisitor<@Nullable Visitable>
{
	protected final @NonNull MultiRegion multiRegion;
	protected final @NonNull Stage stage;
	protected final int stageNumber;
	protected final @NonNull Map<@NonNull Visitable, @NonNull Visitable> old2new = new HashMap<>();

	public SplitterVisitor(@NonNull MultiRegion multiRegion, @NonNull Stage stage, int stageNumber) {
		this.multiRegion = multiRegion;
		this.stage = stage;
		this.stageNumber = stageNumber;
	}

	protected <@NonNull T extends Visitable> @Nullable T basicGetNew(@NonNull Class<T> returnClass, @NonNull Visitable oldVisitable) {
		Visitable newVisitable = old2new.get(oldVisitable);
		if (newVisitable == null) {
			return null;
		}
		if (!returnClass.isAssignableFrom(newVisitable.getClass())) {
			throw new ClassCastException("bad return from SplitterVisitor for " + oldVisitable.getClass().getSimpleName());
		}
		@SuppressWarnings("unchecked") T castVisitable = (T) newVisitable;
		return castVisitable;
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

	@Override
	public @Nullable Visitable visitBasicSimpleEdge(@NonNull BasicSimpleEdge oldBasicSimpleEdge) {
		BasicSimpleEdge newBasicSimpleEdge = basicGetNew(BasicSimpleEdge.class, oldBasicSimpleEdge);
		if (newBasicSimpleEdge == null) {
			EdgeRole edgeRole = oldBasicSimpleEdge.getEdgeRole();
			SimpleRegion newRegion = getNew(SimpleRegion.class, oldBasicSimpleEdge.getRegion());
			SimpleNode sourceNode = getNew(SimpleNode.class, oldBasicSimpleEdge.getSource());
			String name = oldBasicSimpleEdge.getName();
			SimpleNode targetNode = getNew(SimpleNode.class, oldBasicSimpleEdge.getTarget());
			newBasicSimpleEdge = new BasicSimpleEdge(edgeRole, newRegion, sourceNode, name, targetNode);
			//			for (@NonNull TypedElement typedElement : oldBasicSimpleEdge.getTypedElements()) {
			//				newBasicSimpleEdge.addTypedElement(typedElement);
			//			}
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
			Node newSource = basicGetNew(Node.class, oldEdge.getSource());
			Node newTarget = basicGetNew(Node.class, oldEdge.getTarget());
			if ((newSource != null) && (newTarget != null)) {
				Edge newEdge = create(Edge.class, oldEdge);
				old2new.put(oldEdge, newEdge);
			}
		}
		return newRegion;
	}

	@Override
	public @Nullable Visitable visitSimpleNavigationEdge(@NonNull SimpleNavigationEdge oldSimpleNavigationEdge) {
		SimpleNavigationEdge newSimpleNavigationEdge = basicGetNew(SimpleNavigationEdge.class, oldSimpleNavigationEdge);
		if (newSimpleNavigationEdge == null) {
			EdgeRole.Navigation edgeRole = oldSimpleNavigationEdge.getEdgeRole();
			SimpleRegion newRegion = getNew(SimpleRegion.class, oldSimpleNavigationEdge.getRegion());
			SimpleNode sourceNode = getNew(SimpleNode.class, oldSimpleNavigationEdge.getSource());
			Property source2targetProperty = oldSimpleNavigationEdge.getProperty();
			SimpleNode targetNode = getNew(SimpleNode.class, oldSimpleNavigationEdge.getTarget());
			newSimpleNavigationEdge = new SimpleNavigationEdge(edgeRole, newRegion, sourceNode, source2targetProperty, targetNode);
			//			for (@NonNull TypedElement typedElement : oldSimpleNavigationEdge.getTypedElements()) {
			//				newSimpleNavigationEdge.addTypedElement(typedElement);
			//			}
		}
		return newSimpleNavigationEdge;
	}

	@Override
	public @NonNull SimpleTypedNode visitSimpleTypedNode(@NonNull SimpleTypedNode oldSimpleTypedNode) {
		SimpleTypedNode newSimpleTypedNode = basicGetNew(SimpleTypedNode.class, oldSimpleTypedNode);
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
		SimpleVariableNode newSimpleVariableNode = basicGetNew(SimpleVariableNode.class, oldSimpleVariableNode);
		if (newSimpleVariableNode == null) {
			NodeRole nodeRole = oldSimpleVariableNode.getNodeRole();
			SimpleRegion newRegion = getNew(SimpleRegion.class, oldSimpleVariableNode.getRegion());
			@NonNull VariableDeclaration variable = oldSimpleVariableNode.getVariable();
			newSimpleVariableNode = new SimpleVariableNode(nodeRole, newRegion, variable);
			//		for (@NonNull TypedElement typedElement : oldSimpleVariableNode.getTypedElements()) {
			//			newSimpleVariableNode.addTypedElement(typedElement);
			//		}
		}
		return newSimpleVariableNode;
	}
}
