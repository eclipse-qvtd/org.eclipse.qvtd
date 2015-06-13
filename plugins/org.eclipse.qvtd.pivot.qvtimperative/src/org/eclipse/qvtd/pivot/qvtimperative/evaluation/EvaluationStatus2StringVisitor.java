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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.AssociationStatus;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.AttributeStatus;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.ClassStatus;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.ElementStatus;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.EvaluationElement;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.MappingStatus;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.TransformationStatus;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.util.AbstractExtendingEvaluationStatusVisitor;

public class EvaluationStatus2StringVisitor extends AbstractExtendingEvaluationStatusVisitor<String, StringBuilder>
{
	protected static @NonNull String NULL_PLACEHOLDER = "\"<null>\""; //$NON-NLS-1$

	public static String toString(@NonNull EvaluationElement evaluationElement) {
		try {
			StringBuilder s = new StringBuilder();
			EvaluationStatus2StringVisitor v = new EvaluationStatus2StringVisitor(s);
			evaluationElement.accept(v);
			return s.toString();
		}
		catch (Throwable e) {
			return e.toString();
		}
	}

	private int indentDepth = 0;;
	protected /*@NonNull*/ String prefix = "";
	private Map<ClassStatus, String> classId = new HashMap<ClassStatus, String>();
	private Map<MappingStatus, String> mappingId = new HashMap<MappingStatus, String>();
	
	public EvaluationStatus2StringVisitor(@NonNull StringBuilder context) {
		super(context);
	}

	protected void append(String string) {
		if (string != null) {
			context.append(string);
		}
		else {
			context.append(NULL_PLACEHOLDER);
		}
	}

	protected void appendClassId(@NonNull ClassStatus object) {
		String id = classId.get(object);
		if (id == null) {
			id = object.getType().getName() + ":" + (classId.size() + 1);
			classId.put(object, id);
		}
		append(id);
	}

	protected void appendMappingId(/*@NonNull*/ MappingStatus object) {
		String id = mappingId.get(object);
		if (id == null) {
			id = object.getReferredMappingCall().getReferredMapping().getName() + ":" + (mappingId.size() + 1);
			mappingId.put(object, id);
		}
		append(id);
	}
	
	protected void popIndentation() {
		indentDepth--;
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < indentDepth; i++) {
			s.append("  ");
		}
		prefix = s.toString();
	}
	
	protected void pushIndentation() {
		indentDepth++;
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < indentDepth; i++) {
			s.append("  ");
		}
		prefix = s.toString();
	}

	@Override
	public String visiting(@NonNull EvaluationElement visitable) {
		append(prefix);
		append(visitable.getClass().getName());
		return null;
	}

	@Override
	public @Nullable String visitAssociationStatus(@NonNull AssociationStatus object) {
		append(prefix);
		append(object.getForwardEReference().getName());
		append("-");
		append(object.getForwardEReference().getEOpposite().getName());
		for (MappingStatus source : object.getSources()) {
			append(" <<");
			appendMappingId(source);
		}
		for (MappingStatus target : object.getTargets()) {
			append(" >>");
			appendMappingId(target);
		}
		append("\n");
		return null;
	}

	@Override
	public @Nullable String visitAttributeStatus(@NonNull AttributeStatus object) {
		append(prefix);
		append(object.getEFeature().getName());
		for (MappingStatus source : object.getSources()) {
			append(" <<");
			appendMappingId(source);
		}
		for (MappingStatus target : object.getTargets()) {
			append(" >>");
			appendMappingId(target);
		}
		append("\n");
		return null;
	}

	@Override
	public @Nullable String visitClassStatus(@NonNull ClassStatus object) {
		append(prefix);
		appendClassId(object);
		append(" ");
		append(NameUtil.simpleNameFor(object.getEObject()).replace(" ", "_"));
		for (MappingStatus source : object.getSources()) {
			append(" <<");
			appendMappingId(source);
		}
		for (MappingStatus target : object.getTargets()) {
			append(" >>");
			appendMappingId(target);
		}
		append("\n");
		pushIndentation();
		for (AttributeStatus attributeStatus : object.getOwnedAttributeStatuses()) {
			attributeStatus.accept(this);
		}
		popIndentation();
		return null;
	}

	@Override
	public @Nullable String visitMappingStatus(@NonNull MappingStatus object) {
		append(prefix);
		appendMappingId(object);
		append("\n");
		pushIndentation();
		append(prefix);
		for (ElementStatus inputStatus : object.getInputs()) {
			append(" >>");
			if (inputStatus instanceof ClassStatus) {
				ClassStatus classStatus = (ClassStatus)inputStatus;
				appendClassId(classStatus);
			}
			else if (inputStatus instanceof AttributeStatus) {
				AttributeStatus attributeStatus = (AttributeStatus)inputStatus;
				@SuppressWarnings("null")@NonNull ClassStatus classStatus = attributeStatus.getOwningClassStatus();
				appendClassId(classStatus);
				append(":");
				append(attributeStatus.getEFeature().getName());
			}
		}
		append("\n");
		append(prefix);
		for (ElementStatus outputStatus : object.getOutputs()) {
			append(" <<");
			if (outputStatus instanceof ClassStatus) {
				ClassStatus classStatus = (ClassStatus)outputStatus;
				appendClassId(classStatus);
			}
			else if (outputStatus instanceof AttributeStatus) {
				AttributeStatus attributeStatus = (AttributeStatus)outputStatus;
				@SuppressWarnings("null")@NonNull ClassStatus classStatus = attributeStatus.getOwningClassStatus();
				appendClassId(classStatus);
				append(":");
				append(attributeStatus.getEFeature().getName());
			}
		}
		append("\n");
		popIndentation();
		return null;
	}

	@Override
	public @Nullable String visitTransformationStatus(@NonNull TransformationStatus object) {
		append("Class Statuses\n");
		pushIndentation();
		for (ClassStatus classStatus : object.getOwnedClassStatuses()) {
			classStatus.accept(this);
		}
		popIndentation();
		append("Mapping Statuses\n");
		pushIndentation();
		for (MappingStatus mappingStatus : object.getOwnedMappingStatuses()) {
			mappingStatus.accept(this);
		}
		popIndentation();
		append("\n");
		return null;
	}
}
