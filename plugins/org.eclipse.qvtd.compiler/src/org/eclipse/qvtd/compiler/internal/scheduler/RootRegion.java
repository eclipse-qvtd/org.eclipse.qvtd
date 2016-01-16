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
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.utilities.FeatureFilter;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;
import org.eclipse.qvtd.pivot.schedule.utilities.GraphStringBuilder;

public class RootRegion extends AbstractRegion implements SimpleRegion
{
	protected final @NonNull Property root2childrenProperty;	
	protected final @NonNull Property others2childrenProperty;
	protected final @NonNull SimpleNode rootNode;
	protected final @NonNull SimpleNode othersNode;
	protected @Nullable SimpleNode nullNode = null;
	
	protected RootRegion(@NonNull SuperRegion superRegion) {
		super(superRegion);
		SchedulerConstants schedulerConstants = superRegion.getSchedulerConstants();
		StandardLibrary standardLibrary = schedulerConstants.getStandardLibrary();
		org.eclipse.ocl.pivot.Class collectionType = standardLibrary.getSetType();
		this.root2childrenProperty = QVTimperativeUtil.createProperty("«root»", collectionType, true);
		this.others2childrenProperty = QVTimperativeUtil.createProperty("«others»", collectionType, true);
		TypedModel primitiveTypeModel = schedulerConstants.getDomainAnalysis().getPrimitiveTypeModel();
		this.rootNode = Nodes.COMPOSING.createSimpleNode(this, "«root»", schedulerConstants.getClassDatumAnalysis(standardLibrary.getOclVoidType(), primitiveTypeModel));
		this.othersNode = Nodes.COMPOSING.createSimpleNode(this, "«container»", schedulerConstants.getClassDatumAnalysis(standardLibrary.getOclAnyType(), primitiveTypeModel));
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitRootCompositionRegion(this);
	}

	public @NonNull Node addClassDatumAnalysis(@NonNull ClassDatumAnalysis classDatumAnalysis) {
		CollectionType collectionType = PivotUtil.getUnspecializedTemplateableElement((CollectionType) root2childrenProperty.getType());
		org.eclipse.ocl.pivot.Class elementType = classDatumAnalysis.getCompleteClass().getPrimaryClass();
		CollectionType selectedCollectionType = getSchedulerConstants().getEnvironmentFactory().getCompleteEnvironment().getCollectionType(collectionType, elementType, true,  null, null);
		ClassDatumAnalysis selectedClassDatumAnalysis = getSchedulerConstants().getClassDatumAnalysis(selectedCollectionType, classDatumAnalysis.getTypedModel());
		SimpleNode childNode = Nodes.COMPOSED.createSimpleNode(this, "«child-" + classDatumAnalysis.getCompleteClass().getName() + "»", selectedClassDatumAnalysis);
		for (Property property : classDatumAnalysis.getCompleteClass().getProperties((FeatureFilter)null)) {
			Property oppositeProperty = property.getOpposite();
			if ((oppositeProperty != null) && oppositeProperty.isIsComposite()) {
				Edges.COMPOSITION.createEdge(this, childNode, property, getNullNode());
			}
		}
		Edges.COMPOSITION.createEdge(this, rootNode, root2childrenProperty, childNode);
		Edges.COMPOSITION.createEdge(this, othersNode, others2childrenProperty, childNode);
		return childNode;
	}

	@Override
	protected @NonNull List<List<Node>> computeHeadNodeGroups() {
		List<List<Node>> headNodeGroups = new ArrayList<List<Node>>();
		headNodeGroups.add(Collections.<Node>singletonList(rootNode));
		headNodeGroups.add(Collections.<Node>singletonList(othersNode));
		return headNodeGroups;
	}

	@Override
	public @NonNull String getName() {
		return QVTimperativeUtil.ROOT_MAPPING_NAME;
	}

	private @NonNull SimpleNode getNullNode() {
		SimpleNode nullNode2 = nullNode;
		if (nullNode2 == null) {
			nullNode = nullNode2 = Nodes.NULL.createSimpleNode(this);		// FIXME rootNode isNull instead
		}
		return nullNode2;
	}

	public @NonNull Node getRootNode() {
		return rootNode;
	}
	
	@Override
	public boolean isLateMergeable(@NonNull Region innerRegion, @NonNull Region2Depth region2depths) {
		return false;
	}

	@Override
	public boolean isRootRegion() {
		return true;
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