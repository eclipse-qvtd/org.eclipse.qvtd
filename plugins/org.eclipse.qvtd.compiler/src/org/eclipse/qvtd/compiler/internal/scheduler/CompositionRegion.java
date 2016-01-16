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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.schedule.utilities.GraphStringBuilder;

public class CompositionRegion extends AbstractRegion implements SimpleRegion
{
	protected final @NonNull Property parent2childrenProperty;
	protected final @NonNull TypedModel typedModel;
	protected final @NonNull SimpleNode composingNode;

	public CompositionRegion(@NonNull SuperRegion superRegion, @NonNull Property parent2childrenProperty, @NonNull TypedModel typedModel) {
		super(superRegion);
		this.parent2childrenProperty = parent2childrenProperty;
		this.typedModel = typedModel;
		org.eclipse.ocl.pivot.Class owningClass = parent2childrenProperty.getOwningClass();
		assert owningClass != null;
		this.composingNode = Nodes.COMPOSING.createSimpleNode(this, "«parent»", getSchedulerConstants().getClassDatumAnalysis(owningClass, typedModel));
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitCompositionRegion(this);
	}

	public @NonNull Node addClassDatumAnalysis(@NonNull ClassDatumAnalysis classDatumAnalysis) {
		Type type = parent2childrenProperty.getType();
		if (type instanceof CollectionType) {
			CollectionType collectionType = PivotUtil.getUnspecializedTemplateableElement((CollectionType) type);
			org.eclipse.ocl.pivot.Class elementType = classDatumAnalysis.getCompleteClass().getPrimaryClass();
			CollectionType selectedCollectionType = getSchedulerConstants().getEnvironmentFactory().getCompleteEnvironment().getCollectionType(collectionType, elementType, true,  null, null);
			ClassDatumAnalysis selectedClassDatumAnalysis = getSchedulerConstants().getClassDatumAnalysis(selectedCollectionType, classDatumAnalysis.getTypedModel());
			SimpleNode composedNode = Nodes.COMPOSED.createSimpleNode(this, "«child-" + classDatumAnalysis.getCompleteClass().getName() + "»", selectedClassDatumAnalysis);
			Edges.COMPOSITION.createEdge(this, composingNode, parent2childrenProperty, composedNode);
			Property child2parentProperty = parent2childrenProperty.getOpposite();
			if (child2parentProperty != null) {
				Edges.CONTAINER.createEdge(this, composedNode, child2parentProperty, composingNode);
			}
			return composedNode;
		}
		else {
			org.eclipse.ocl.pivot.Class elementType = classDatumAnalysis.getCompleteClass().getPrimaryClass();
			CollectionType selectedCollectionType = getSchedulerConstants().getEnvironmentFactory().getCompleteEnvironment().getSetType(elementType, true,  null, null);
			ClassDatumAnalysis selectedClassDatumAnalysis = getSchedulerConstants().getClassDatumAnalysis(selectedCollectionType, classDatumAnalysis.getTypedModel());
			SimpleNode composedNode = Nodes.COMPOSED.createSimpleNode(this, "«child-" + classDatumAnalysis.getCompleteClass().getName() + "»", selectedClassDatumAnalysis);
			Edges.COMPOSITION.createEdge(this, composingNode, parent2childrenProperty, composedNode);
			Property child2parentProperty = parent2childrenProperty.getOpposite();
			if (child2parentProperty != null) {
				Edges.CONTAINER.createEdge(this, composedNode, child2parentProperty, composingNode);
			}
			return composedNode;
		}
	}

	@Override
	protected @NonNull List<List<Node>> computeHeadNodeGroups() {
		List<List<Node>> headNodeGroups = new ArrayList<List<Node>>();
		headNodeGroups.add(Collections.<Node>singletonList(composingNode));
		return headNodeGroups;
	}

	public @NonNull Node getComposingNode() {
		return composingNode;
	}

	@SuppressWarnings("null")
	@Override
	public @NonNull String getName() {
		return parent2childrenProperty.toString().replace("::", "%");
	}

	@Override
	public boolean isCompositionRegion() {
		return true;
	}
	
	@Override
	public boolean isLateMergeable(@NonNull Region innerRegion, @NonNull Region2Depth region2depths) {
		return false;
	}

	@Override
	public void toGraph(@NonNull GraphStringBuilder s) {
		s.setLabel(getName());
		s.setColor("lightblue");
		s.setPenwidth(Role.LINE_WIDTH);
		s.pushCluster();
		for (@SuppressWarnings("null")@NonNull Node node : getNodes()) {
			s.appendNode(node);
		}
		for (@SuppressWarnings("null")@NonNull Edge edge : getEdges()) {
			s.appendEdge(edge);
		}
		s.popCluster();
	}
}