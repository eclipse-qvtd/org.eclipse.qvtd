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

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphMLStringBuilder;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphEdge;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphNode;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.AssociationStatus;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.AttributeStatus;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.ClassStatus;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.PropertyStatus;
import org.eclipse.qvtd.runtime.evaluation.AbstractExecutionVisitor;
import org.eclipse.qvtd.runtime.evaluation.Computation;
import org.eclipse.qvtd.runtime.evaluation.Connection;
import org.eclipse.qvtd.runtime.evaluation.Execution;
import org.eclipse.qvtd.runtime.evaluation.Interval;
import org.eclipse.qvtd.runtime.evaluation.Invocation;
import org.eclipse.qvtd.runtime.evaluation.InvocationConstructor;
import org.eclipse.qvtd.runtime.evaluation.InvocationManager;
import org.eclipse.qvtd.runtime.evaluation.ObjectManager;
import org.eclipse.qvtd.runtime.evaluation.SlotState;
import org.eclipse.qvtd.runtime.evaluation.Transformer;

import com.google.common.collect.Iterables;

public class Execution2GraphVisitor extends AbstractExecutionVisitor<@Nullable Object>
{
	protected static final class ExecutionEdge implements GraphEdge
	{
		private final @NonNull GraphNode sourceNode;
		private final @NonNull GraphNode targetNode;
		private final @NonNull String color;
		private final @Nullable String style;

		protected ExecutionEdge(@NonNull GraphNode sourceNode, @NonNull GraphNode targetNode, @NonNull String color, @Nullable String style) {
			this.sourceNode = sourceNode;
			this.targetNode = targetNode;
			this.color = color;
			this.style = style;
		}

		@Override
		public void appendEdgeAttributes(@NonNull GraphStringBuilder s, @NonNull GraphNode source, @NonNull GraphNode target) {
			s.setColor(color);
			if (style != null) {
				s.setStyle(style);
			}
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

	public static void writeGraphMLfile(Transformer tx, @NonNull URI graphmlURI) {
		try {
			OutputStream outputStream = URIConverter.INSTANCE.createOutputStream(graphmlURI);
			GraphMLStringBuilder s = new GraphMLStringBuilder();
			Execution2GraphVisitor execution2GraphVisitor = new Execution2GraphVisitor(s);
			tx.accept(execution2GraphVisitor);
			outputStream.write(s.toString().getBytes());
			outputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected final @NonNull GraphStringBuilder context;

	private Map<@NonNull AssociationStatus, @NonNull String> associationId = new HashMap<>();
	private Map<@NonNull ClassStatus, @NonNull String> classId = new HashMap<>();
	private Map<@NonNull Computation, @NonNull GraphNode> computation2node = new HashMap<>();
	private Map<@NonNull Connection, @NonNull GraphNode> connection2node = new HashMap<>();
	private Map<@NonNull Interval, @NonNull GraphNode> interval2node = new HashMap<>();
	private Map<@NonNull Invocation, @NonNull GraphNode> invocation2node = new HashMap<>();
	private Map<@NonNull InvocationConstructor, @NonNull GraphNode> invocationConstructor2node = new HashMap<>();
	private Map<@NonNull Object, @NonNull GraphNode> object2node = new HashMap<>();
	private Map<@NonNull SlotState, @NonNull GraphNode> slot2node = new HashMap<>();
	//	private Map<@NonNull String, @NonNull String> propertyId2associationId = new HashMap<>();
	//	private Map<@NonNull String, @NonNull PropertyStatus> associationId2propertyStatus = new HashMap<>();

	public Execution2GraphVisitor(@NonNull GraphStringBuilder s) {
		this.context = s;
	}

	protected void appendEdge(@NonNull GraphNode sourceNode, @NonNull GraphNode targetNode, @NonNull String color, @Nullable String style) {
		context.appendEdge(sourceNode, new ExecutionEdge(sourceNode, targetNode, color, style), targetNode);
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

	protected @NonNull GraphNode getComputationNode(@NonNull Computation object) {
		GraphNode node = computation2node.get(object);
		if (node == null) {
			//			id = object.getReferredMappingCall().getReferredMapping().getName() + "-" + (mappingId.size() + 1);
			final String label = object.getName();
			//			final String label;
			//			if (object instanceof EObject) {
			//				label = ((EObject)object).eClass().getName() + "-" + (invocation2node.size() + 1);
			//			}
			//			else {
			//				label = object.toString().replace("@",  "\n@");
			//				label = object.getClass().getSimpleName() + "-" + (invocation2node.size() + 1);
			//			}
			node = new GraphNode()
			{
				@Override
				public void appendNode(@NonNull GraphStringBuilder s, @NonNull String nodeName) {
					s.setLabel(label);
					s.setShape("hexagon");
					s.setColor("brown");
					//					context.appendNode(mappingId, "hexagon", "#ffcc00", 30, 150, mappingId.replace("-",  "\n"));
					s.appendAttributedNode(nodeName);
				}
			};
			computation2node.put(object, node);
			context.appendNode(node);
		}
		return node;
	}

	protected @NonNull GraphNode getConnectionNode(@NonNull Connection object) {
		GraphNode node = connection2node.get(object);
		if (node == null) {
			final String label = object.getName();
			node = new GraphNode()
			{
				@Override
				public void appendNode(@NonNull GraphStringBuilder s, @NonNull String nodeName) {
					s.setLabel(label);
					s.setShape("ellipse");
					s.setColor("brown");
					s.appendAttributedNode(nodeName);
				}
			};
			connection2node.put(object, node);
			context.appendNode(node);
		}
		return node;
	}

	protected @NonNull GraphNode getExecutionNode(@NonNull Execution object) {
		if (object instanceof Computation) {
			return  getComputationNode((@NonNull Computation) object);
		}
		else if (object instanceof Invocation) {
			return  getInvocationNode((@NonNull Invocation) object);
		}
		else {
			throw new UnsupportedOperationException();
		}
	}

	protected @NonNull GraphNode getIntervalNode(@NonNull Interval object) {
		GraphNode node = interval2node.get(object);
		if (node == null) {
			final String label = "          " + object.getName() + "          ";
			node = new GraphNode()
			{
				@Override
				public void appendNode(@NonNull GraphStringBuilder s, @NonNull String nodeName) {
					s.setLabel(label);
					s.setShape("octagon");
					s.setColor("black");
					s.appendAttributedNode(nodeName);
				}
			};
			interval2node.put(object, node);
			context.appendNode(node);
		}
		return node;
	}

	protected @NonNull GraphNode getInvocationConstructorNode(@NonNull InvocationConstructor object) {
		GraphNode node = invocationConstructor2node.get(object);
		if (node == null) {
			final String label = object.getName();
			node = new GraphNode()
			{
				@Override
				public void appendNode(@NonNull GraphStringBuilder s, @NonNull String nodeName) {
					s.setLabel(label);
					s.setShape("hexagon");
					s.setColor("brown");
					s.appendAttributedNode(nodeName);
				}
			};
			invocationConstructor2node.put(object, node);
			context.appendNode(node);
		}
		return node;
	}

	protected @NonNull GraphNode getInvocationNode(@NonNull Invocation object) {
		GraphNode node = invocation2node.get(object);
		if (node == null) {
			//			id = object.getReferredMappingCall().getReferredMapping().getName() + "-" + (mappingId.size() + 1);
			final String label = object.getName();
			//			final String label;
			//			if (object instanceof EObject) {
			//				label = ((EObject)object).eClass().getName() + "-" + (invocation2node.size() + 1);
			//			}
			//			else {
			//				label = object.toString().replace("@",  "\n@");
			//				label = object.getClass().getSimpleName() + "-" + (invocation2node.size() + 1);
			//			}
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
			else if (eFeature instanceof EAttribute) {
				Object value = object.getValue();	// FIXME may be null for inputs, and some slots seem crooked
				String stringValue = value != null ? value.toString() : "???";
				if (stringValue.length() > 20) {
					stringValue = stringValue.substring(0, 17) + "...";
				}
				label += "  \n  " + stringValue;
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

	@Override
	public @Nullable String visitComputation(@NonNull Computation object) {
		@SuppressWarnings("unused")
		GraphNode computationNode = getComputationNode(object);
		return null;
	}

	@Override
	public @Nullable Object visitConnection(@NonNull Connection object) {
		GraphNode connectionNode = getConnectionNode(object);
		if (object instanceof Connection.Incremental) {
			for (@NonNull InvocationConstructor producer : ((Connection.Incremental)object).getAppenders()) {
				GraphNode producerNode = getInvocationConstructorNode(producer);
				appendEdge(producerNode, connectionNode, "brown", null);
			}
		}
		for (@NonNull InvocationConstructor consumer : object.getConsumers()) {
			GraphNode consumerNode = getInvocationConstructorNode(consumer);
			appendEdge(connectionNode, consumerNode, "brown", null);
		}
		int iMax = object.getValues();
		for (int i = 0; i < iMax; i++) {
			Object value = object.getValue(i);
			if (value != null) {
				GraphNode objectNode = getObjectNode(value);
				appendEdge(connectionNode, objectNode, "brown", "dotted");
				//			for (@NonNull Invocation invocation : object.getConsumers(i)) {
				//				GraphNode consumerNode = getInvocationNode(invocation);
				//			}
			}
		}
		return null;
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
	public @Nullable Object visitInterval(@NonNull Interval object) {
		GraphNode intervalNode = getIntervalNode(object);
		for (@NonNull Connection connection : object.getConnections()) {
			connection.accept(this);
			GraphNode connectionNode = getConnectionNode(connection);
			appendEdge(connectionNode, intervalNode, "black", "dashed");
		}
		return null;
	}

	@Override
	public @Nullable String visitInvocation(@NonNull Invocation object) {
		@SuppressWarnings("unused")
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
	public @Nullable Object visitInvocationConstructor(@NonNull InvocationConstructor object) {
		GraphNode invokerNode = getInvocationConstructorNode(object);
		GraphNode intervalNode = getIntervalNode(object.getInterval());
		appendEdge(invokerNode, intervalNode, "black", "dashed");
		for (@NonNull Invocation invocation : object.getInvocations()) {
			GraphNode invocationNode = getInvocationNode(invocation);
			appendEdge(invokerNode, invocationNode, "orange", "dotted");
		}
		return null;
	}

	@Override
	public @Nullable String visitInvocationManager(@NonNull InvocationManager object) {
		GraphNode previousNode = null;
		for (@NonNull InvocationConstructor invoker : object.getInvokers()) {
			invoker.accept(this);
		}
		for (@NonNull Interval interval : object.getIntervals()) {
			interval.accept(this);
			GraphNode nextNode = getIntervalNode(interval);
			if (previousNode != null) {
				appendEdge(previousNode, nextNode, "black", null);
			}
			previousNode = nextNode;
		}
		return null;
	}

	@Override
	public @Nullable String visitObjectManager(@NonNull ObjectManager objectManager) {
		Set<Execution.@NonNull Incremental> allExecutions = new HashSet<>();
		Set<SlotState.@NonNull Incremental> allSlots = new HashSet<>();
		Map<@NonNull Object, @NonNull List<SlotState.@NonNull Incremental>> object2slots = new HashMap<>();
		for (@NonNull Object object : objectManager.getObjects()) {
			List<SlotState.@NonNull Incremental> objectSlots = new ArrayList<>();
			for (@NonNull SlotState slotState : objectManager.getSlotStates(object)) {
				if (slotState instanceof SlotState.Incremental) {
					allSlots.add((SlotState.Incremental)slotState);
					objectSlots.add((SlotState.Incremental)slotState);
				}
			}
			object2slots.put(object, objectSlots);
		}
		for (SlotState.@NonNull Incremental slotState : allSlots) {
			Iterables.addAll(allExecutions, slotState.getSources());
			Iterables.addAll(allExecutions, slotState.getTargets());
			slotState.accept(this);
		}
		for (Execution.@NonNull Incremental execution : allExecutions) {
			execution.accept(this);
			GraphNode invocationNode = getExecutionNode(execution);
			for (@NonNull Object createdObject : execution.getCreatedObjects()) {
				GraphNode objectNode = getObjectNode(createdObject);
				appendEdge(invocationNode, objectNode, "green", null);
			}
		}
		for (SlotState.@NonNull Incremental slotState : allSlots) {
			GraphNode slotNode = getSlotNode(slotState);
			slotState.accept(this);
			for (@NonNull Invocation invocation : slotState.getSources()) {
				appendEdge(getInvocationNode(invocation), slotNode, "green", null);
			}
			for (@NonNull Execution invocation : slotState.getTargets()) {
				appendEdge(slotNode, getExecutionNode(invocation), "cyan", null);
			}
			Iterables.addAll(allExecutions, slotState.getTargets());
		}
		for (@NonNull Object object : objectManager.getObjects()) {
			GraphNode objectNode = getObjectNode(object);
			List<SlotState.@NonNull Incremental> slots = object2slots.get(object);
			if (slots != null) {
				for (SlotState.@NonNull Incremental slotState : slots) {
					GraphNode slotNode = getSlotNode(slotState);
					slotState.accept(this);
					appendEdge(objectNode, slotNode, "blue", null);
				}
			}
		}
		return null;
	}

	@Override
	public @Nullable String visitSlotState(@NonNull SlotState object) {
		//		GraphNode slotNode = getSlotNode((SlotState.@NonNull Incremental) object, "orange");
		return null;
	}

	@Override
	public @Nullable String visitTransformer(@NonNull Transformer transformer) {
		transformer.getInvocationManager().accept(this);
		transformer.getObjectManager().accept(this);
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
