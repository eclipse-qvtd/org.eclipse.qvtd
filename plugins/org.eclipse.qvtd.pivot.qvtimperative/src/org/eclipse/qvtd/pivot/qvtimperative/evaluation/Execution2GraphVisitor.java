/*******************************************************************************
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     E.D.Willink - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.evaluation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphEdge;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphNode;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.AssociationStatus;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.AttributeStatus;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.ClassStatus;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.PropertyStatus;
import org.eclipse.qvtd.runtime.evaluation.AbstractExecutionVisitor;
import org.eclipse.qvtd.runtime.evaluation.Invocation;
import org.eclipse.qvtd.runtime.evaluation.InvocationManager;
import org.eclipse.qvtd.runtime.evaluation.ObjectManager;
import org.eclipse.qvtd.runtime.evaluation.SlotState;
import org.eclipse.qvtd.runtime.evaluation.Transformer;

import com.google.common.collect.Iterables;

public class Execution2GraphVisitor extends AbstractExecutionVisitor<String>
{
	protected static final class ExecutionEdge implements GraphEdge
	{
		private final @NonNull GraphNode sourceNode;
		private final @NonNull GraphNode targetNode;
		private final @NonNull String color;

		protected ExecutionEdge(@NonNull GraphNode sourceNode, @NonNull GraphNode targetNode, @NonNull String color) {
			this.sourceNode = sourceNode;
			this.targetNode = targetNode;
			this.color = color;
		}

		@Override
		public void appendEdgeAttributes(@NonNull GraphStringBuilder s, @NonNull GraphNode source, @NonNull GraphNode target) {
			s.setColor(color);
			s.appendAttributedEdge(source, this, target);
		}

		@Override
		public @NonNull GraphNode getSource() {
			return sourceNode;
		}

		@Override
		public @NonNull GraphNode getTarget() {
			return targetNode;
		}
	}

	protected static @NonNull String NULL_PLACEHOLDER = "\"<null>\""; //$NON-NLS-1$

	protected final @NonNull GraphStringBuilder context;
	
	private Map<AssociationStatus, String> associationId = new HashMap<AssociationStatus, String>();
	private Map<ClassStatus, String> classId = new HashMap<ClassStatus, String>();
	private Map<Invocation, GraphNode> invocation2node = new HashMap<Invocation, GraphNode>();
	private Map<Object, GraphNode> object2node = new HashMap<Object, GraphNode>();
	private Map<SlotState, GraphNode> slot2node = new HashMap<SlotState, GraphNode>();
//	private Map<String, String> propertyId2associationId = new HashMap<String, String>();
//	private Map<String, PropertyStatus> associationId2propertyStatus = new HashMap<String, PropertyStatus>();
	
	public Execution2GraphVisitor(@NonNull GraphStringBuilder s) {
		this.context = s;
	}

	protected void appendEdge(@NonNull GraphNode sourceNode, @NonNull GraphNode targetNode, @NonNull String color) {
		context.appendEdge(sourceNode, new ExecutionEdge(sourceNode, targetNode, color), targetNode);
	}

	protected @NonNull String getAssociationColor(@NonNull AssociationStatus associationStatus) {
		if (associationStatus.isIsInput()) {
			return associationStatus.isIsOutput() ? "#ccffff" : "#ccff00";
		}
		else {
			return associationStatus.isIsOutput() ? "#cc80ff" : "#cc0000";
		}
	}
	
	protected @NonNull String getAssociationId(@NonNull AssociationStatus object) {
		String id = associationId.get(object);
		if (id == null) {
			id = "a" + associationId.size()+1;
			associationId.put(object, id);
		}
		return id;
	}

	protected String getAssociationLabel(@NonNull AssociationStatus associationStatus) {
		EReference forwardReference = associationStatus.getForwardEReference();
		EReference oppositeReference = forwardReference.getEOpposite();
		String firstName = forwardReference.getName();
		String secondName = oppositeReference.getName();
		boolean swap = false;
		if (forwardReference.isMany() != oppositeReference.isMany()) {
			swap = forwardReference.isMany();
		}
		else {
			swap = firstName.compareTo(secondName) > 0;
		}
		return swap ? secondName + " / " + firstName : firstName + " / " + secondName;
	}

	protected @NonNull String getAttributeId(@NonNull AttributeStatus attributeStatus) {
		ClassStatus classStatus = attributeStatus.getOwningClassStatus();
		assert classStatus != null;
		return getClassId(classStatus) + "-" + attributeStatus.getEFeature().getName();
	}

	protected @NonNull String getClassColor(@NonNull ClassStatus classStatus) {
		if (classStatus.isIsInput()) {
			return classStatus.isIsOutput() ? "#ccffff" : "#ccff00";
		}
		else {
			return classStatus.isIsOutput() ? "#cc80ff" : "#cc0000";
		}
	}
	
	protected @NonNull String getClassId(@NonNull ClassStatus object) {
		String id = classId.get(object);
		if (id == null) {
			id = object.getType().getName() + "-" + (classId.size() + 1);
			classId.put(object, id);
		}
		return id;
	}

	protected @NonNull GraphNode getInvocationNode(@NonNull Invocation object) {
		GraphNode node = invocation2node.get(object);
		if (node == null) {
//			id = object.getReferredMappingCall().getReferredMapping().getName() + "-" + (mappingId.size() + 1);
			final String label;
			if (object instanceof EObject) {
				label = ((EObject)object).eClass().getName() + "-" + (invocation2node.size() + 1);
			}
			else {
				label = object.toString().replace("@",  "\n@");
//				label = object.getClass().getSimpleName() + "-" + (invocation2node.size() + 1);
			}
			node = new GraphNode()
			{
				@Override
				public void appendNode(@NonNull GraphStringBuilder s, @NonNull String nodeName) {
					s.setLabel(label);
					s.setShape("hexagon");
					s.setColor("orange");
//					context.appendNode(mappingId, "hexagon", "#ffcc00", 30, 150, mappingId.replace("-",  "\n"));
					s.appendAttributedNode(nodeName);
				}
			};
			invocation2node.put(object, node);
			context.appendNode(node);
		}
		return node;
	}

	protected @NonNull GraphNode getObjectNode(@NonNull Object object) {
		GraphNode node = object2node.get(object);
		if (node == null) {
//			id = object.getReferredMappingCall().getReferredMapping().getName() + "-" + (mappingId.size() + 1);
			final String label;
			if (object instanceof EObject) {
				label = ((EObject)object).eClass().getName() + "-" + (object2node.size() + 1);
			}
			else {
				label = object.toString().replace("@",  "\n@");
//				label = object.getClass().getSimpleName() + "-" + (invocation2node.size() + 1);
			}
			node = new GraphNode()
			{
				@Override
				public void appendNode(@NonNull GraphStringBuilder s, @NonNull String nodeName) {
					s.setLabel(label);
					s.setShape("rectangle");
					s.setColor("blue");
					s.appendAttributedNode(nodeName);
				}
			};
			object2node.put(object, node);
			context.appendNode(node);
		}
		return node;
	}

	protected @NonNull String getPropertyId(@NonNull PropertyStatus object) {
		if (object instanceof AssociationStatus) {
			return getAssociationId((AssociationStatus) object);
		}
		else if (object instanceof AttributeStatus) {
			return getAttributeId((AttributeStatus)object);
		}
		else {
			throw new UnsupportedOperationException();
		}
	}

	protected @NonNull GraphNode getSlotNode(SlotState.@NonNull Incremental object) {
		if (object.getValue() != null) {
			object = object.getPrimarySlotState();
		}
		GraphNode node = slot2node.get(object);
		if (node == null) {
			final EStructuralFeature eFeature = object.getEFeature();
			String label = eFeature.getName();
			if (eFeature instanceof EReference) {
				EReference eOpposite = ((EReference)eFeature).getEOpposite();
				if (eOpposite != null) {
					label += " / " + eOpposite.getName();
				}
			}
			final String finalLabel = label;
			node = new GraphNode()
			{
				@Override
				public void appendNode(@NonNull GraphStringBuilder s, @NonNull String nodeName) {
					s.setLabel(finalLabel);
					s.setShape("rectangle");
					if (eFeature instanceof EAttribute) {
						s.setStyle("rounded");
					}
					s.setColor("blue");
					s.appendAttributedNode(nodeName);
				}
			};
			slot2node.put(object, node);
			context.appendNode(node);
		}
		return node;
	}

/*	@Override
	public String visiting(@NonNull EvaluationElement visitable) {
//		append(visitable.getClass().getName());
		return null;
	} */

/*	@Override
	public @Nullable String visitAssociationStatus(@NonNull AssociationStatus object) {
		String associationId = getAssociationId(object);
		String fillColor = object.isIsError() ? "#ff0000" : getAssociationColor(object);
		String label = getAssociationLabel(object);
		context.appendNode(associationId, "rectangle", fillColor, 30, 100, label);
		for (ClassStatus classStatus : object.getFromClassStatuses()) {
			if (classStatus != null) {
				String classId = getClassId(classStatus);
				context.appendEdge(classId, associationId, "#339966", "line","diamond", "none");
			}
		}
		for (ClassStatus classStatus : object.getToClassStatuses()) {
			if (classStatus != null) {
				String classId = getClassId(classStatus);
				context.appendEdge(classId, associationId, "#339966", "line","diamond", "none");
			}
		}
		return null;
	} */

/*	@Override
	public @Nullable String visitAttributeStatus(@NonNull AttributeStatus object) {
		ClassStatus classStatus = object.getOwningClassStatus();
		assert classStatus != null;
		String classId = getClassId(classStatus);
		String attributeId = getAttributeId(object);
		String fillColor = object.isIsError() ? "#ff0000" : getClassColor(classStatus);
		EStructuralFeature eFeature = object.getEFeature();
		String label = eFeature.getName();
		EClassifier type = eFeature.getEType();
//		if (type instanceof DataType) {
//			Type behavioralType = ((DataType)type).getBehavioralClass();
//			if (behavioralType != null) {
//				type = behavioralType;
//			}
//		}
		if (type instanceof EDataType) {
			label = label + "\n" + String.valueOf(object.getObject());
		}
		context.appendNode(attributeId, "rectangle", fillColor, 30, 50, label);
		context.appendEdge(classId, attributeId, "#339966", "line","diamond", "none");
		return null;
	} */

/*	@Override
	public @Nullable String visitClassStatus(@NonNull ClassStatus object) {
		String classId = getClassId(object);
		context.appendNode(classId, "rectangle", getClassColor(object), 30, 120, classId.replace("-",  "\n"));
		for (AttributeStatus attributeStatus : object.getOwnedAttributeStatuses()) {
			attributeStatus.accept(this);
		}
		return null;
	} */

	@Override
	public @Nullable String visitInvocation(@NonNull Invocation object) {
		GraphNode invocationNode = getInvocationNode(object);
/*		context.appendNode(mappingId, "hexagon", "#ffcc00", 30, 150, mappingId.replace("-",  "\n"));
		for (ElementStatus inputStatus : object.getInputs()) {
			if (inputStatus instanceof ClassStatus) {
				ClassStatus classStatus = (ClassStatus)inputStatus;
				String classId = getClassId(classStatus);
				context.appendEdge(classId, mappingId, "#000000", "line","none", "standard");
			}
			else if (inputStatus instanceof PropertyStatus) {
				PropertyStatus propertyStatus = (PropertyStatus)inputStatus;
				String propertyId = getPropertyId(propertyStatus);
				context.appendEdge(propertyId, mappingId, "#000000", "dashed","none", "standard");
			}
		}
		for (ElementStatus outputStatus : object.getOutputs()) {
			if (outputStatus instanceof ClassStatus) {
				ClassStatus classStatus = (ClassStatus)outputStatus;
				String classId = getClassId(classStatus);
				context.appendEdge(mappingId, classId, "#000000", "line","none", "standard");
			}
			else if (outputStatus instanceof PropertyStatus) {
				PropertyStatus propertyStatus = (PropertyStatus)outputStatus;
				String propertyId = getPropertyId(propertyStatus);
				context.appendEdge(mappingId, propertyId, "#000000", "dashed","none", "standard");
			}
		} */
		return null;
	}

	@Override
	public @Nullable String visitInvocationManager(@NonNull InvocationManager object) {
//		context.open();
//			for (ClassStatus classStatus : object.getOwnedClassStatuses()) {
//				classStatus.accept(this);
//			}
//			for (MappingStatus mappingStatus : object.getOwnedMappingStatuses()) {
//				mappingStatus.accept(this);
//			}
//			for (AssociationStatus associationStatus : object.getOwnedAssociationStatuses()) {
//				associationStatus.accept(this);
//			}
//		context.close();
		return null;
	}

	@Override
	public @Nullable String visitObjectManager(@NonNull ObjectManager objectManager) {
		Set<Invocation.@NonNull Incremental> allInvocations = new HashSet<Invocation.@NonNull Incremental>();
		Set<SlotState.@NonNull Incremental> allSlots = new HashSet<SlotState.@NonNull Incremental>();
		Map<@NonNull Object, List<SlotState.@NonNull Incremental>> object2slots = new HashMap<@NonNull Object, List<SlotState.@NonNull Incremental>>();
		for (Object object : objectManager.getObjects()) {
			List<SlotState.Incremental> objectSlots = new ArrayList<SlotState.Incremental>();
			for (SlotState slotState : objectManager.getSlotStates(object)) {
				if (slotState instanceof SlotState.Incremental) {
					allSlots.add((SlotState.Incremental)slotState);
					objectSlots.add((SlotState.Incremental)slotState);
				}
			}
			object2slots.put(object, objectSlots);
		}
		for (SlotState.@NonNull Incremental slotState : allSlots) {
			Iterables.addAll(allInvocations, slotState.getSources());
			Iterables.addAll(allInvocations, slotState.getTargets());
			slotState.accept(this);
		}
		for (Invocation.@NonNull Incremental invocation : allInvocations) {
			invocation.accept(this);
			GraphNode invocationNode = getInvocationNode(invocation);
			for (Object createdObject : invocation.getCreatedObjects()) {
				GraphNode objectNode = getObjectNode(createdObject);
				appendEdge(invocationNode, objectNode, "green");
			}
		}
		for (SlotState.@NonNull Incremental slotState : allSlots) {
			GraphNode slotNode = getSlotNode(slotState);
			slotState.accept(this);
			for (Invocation invocation : slotState.getSources()) {
				appendEdge(getInvocationNode(invocation), slotNode, "green");
			}
			for (Invocation invocation : slotState.getTargets()) {
				appendEdge(slotNode, getInvocationNode(invocation), "cyan");
			}
			Iterables.addAll(allInvocations, slotState.getTargets());
		}
		for (Object object : objectManager.getObjects()) {
			GraphNode objectNode = getObjectNode(object);
			List<SlotState.@NonNull Incremental> slots = object2slots.get(object);
			if (slots != null) {
				for (SlotState.@NonNull Incremental slotState : slots) {
					GraphNode slotNode = getSlotNode(slotState);
					slotState.accept(this);
					appendEdge(objectNode, slotNode, "blue");
				}
			}
		}
		return null;
	}

	@Override
	public @Nullable String visitSlotState(@NonNull SlotState object) {
		GraphNode slotNode = getSlotNode((SlotState.@NonNull Incremental) object);
		return null;
	}

	@Override
	public @Nullable String visitTransformer(@NonNull Transformer object) {
		return null;
	}

/*	@Override
	public @Nullable String visitTransformationStatus(@NonNull TransformationStatus object) {
		context.open();
			for (ClassStatus classStatus : object.getOwnedClassStatuses()) {
				classStatus.accept(this);
			}
			for (MappingStatus mappingStatus : object.getOwnedMappingStatuses()) {
				mappingStatus.accept(this);
			}
			for (AssociationStatus associationStatus : object.getOwnedAssociationStatuses()) {
				associationStatus.accept(this);
			}
		context.close();
		return null;
	} */
}
