/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     E.D.Willink - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.evaluation;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.AssociationStatus;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.AttributeStatus;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.ClassStatus;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.ElementStatus;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.EvaluationElement;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.MappingStatus;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.PropertyStatus;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.TransformationStatus;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.util.AbstractExtendingEvaluationStatusVisitor;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.GraphBuilder;

public class EvaluationStatus2GraphVisitor extends AbstractExtendingEvaluationStatusVisitor<String, GraphBuilder>
{
	protected static @NonNull String NULL_PLACEHOLDER = "\"<null>\""; //$NON-NLS-1$

	private Map<AssociationStatus, String> associationId = new HashMap<AssociationStatus, String>();
	private Map<ClassStatus, String> classId = new HashMap<ClassStatus, String>();
	private Map<MappingStatus, String> mappingId = new HashMap<MappingStatus, String>();
//	private Map<String, String> propertyId2associationId = new HashMap<String, String>();
//	private Map<String, PropertyStatus> associationId2propertyStatus = new HashMap<String, PropertyStatus>();
	
	public EvaluationStatus2GraphVisitor(@NonNull GraphBuilder context) {
		super(context);
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

	protected @NonNull String getMappingId(@NonNull MappingStatus object) {
		String id = mappingId.get(object);
		if (id == null) {
			id = object.getReferredMappingCall().getReferredMapping().getName() + "-" + (mappingId.size() + 1);
			mappingId.put(object, id);
		}
		return id;
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

	@Override
	public String visiting(@NonNull EvaluationElement visitable) {
//		append(visitable.getClass().getName());
		return null;
	}

	@Override
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
	}

	@Override
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
	}

	@Override
	public @Nullable String visitClassStatus(@NonNull ClassStatus object) {
		String classId = getClassId(object);
		context.appendNode(classId, "rectangle", getClassColor(object), 30, 120, classId.replace("-",  "\n"));
		for (AttributeStatus attributeStatus : object.getOwnedAttributeStatuses()) {
			attributeStatus.accept(this);
		}
		return null;
	}

	@Override
	public @Nullable String visitMappingStatus(@NonNull MappingStatus object) {
		String mappingId = getMappingId(object);
		context.appendNode(mappingId, "hexagon", "#ffcc00", 30, 150, mappingId.replace("-",  "\n"));
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
		}
		return null;
	}

	@Override
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
	}
}
