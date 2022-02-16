/*******************************************************************************
 * Copyright (c) 2013, 2020 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.codegen.qvti.java;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.NameResolution;
import org.eclipse.ocl.examples.codegen.cgmodel.CGNamedElement;
import org.eclipse.ocl.examples.codegen.java.JavaGlobalContext;
import org.eclipse.ocl.examples.codegen.java.JavaLocalContext;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.Property;

/**
 * A QVTiGlobalContext maintains the Java-specific global context for generation of QVTi code.
 */
public class QVTiGlobalContext extends JavaGlobalContext<@NonNull QVTiCodeGenerator>
{
	private static final @NonNull String CLASS_ID_2_CLASS_ID_ = "classIndex2classId_";
	private static final @NonNull String CLASS_ID_2_ALL_CLASS_INDEXES_ = "classIndex2allClassIndexes_";
	private static final @NonNull String CONSTRUCTOR_NAME = "constructor";
	private static final @NonNull String CREATE_FROM_STRING_NAME = "createFromString";
	private static final @NonNull String EMPTY_LIST_NAME = "emptyList";
	private static final @NonNull String GET_SPECULATION_SLOT_STATE_NAME = "getSpeculatingSlotState";
	private static final @NonNull String GET_SPECULATION_STATUS_NAME = "getSpeculationStatus";
	private static final @NonNull String GET_TRANSFORMATION_EXECUTION_NAME = "getTransformationExecution";
	private static final @NonNull String INPUT_SPECULATION_SLOT_STATE_NAME = "inputSpeculatingSlotState";
	private static final @NonNull String INPUT_SPECULATION_SLOT_STATUS_NAME = "inputSpeculatingSlotStatus";
	private static final @NonNull String INVOCATION_HASH_CODE_NAME = "invocationHashCode";
	private static final @NonNull String MODELS_NAME = "models";
	private static final @NonNull String NEEDS_SPECULATION_NAME = "needsSpeculation";
	private static final @NonNull String OBJECT_MANAGER_NAME = "objectManager";
	private static final @NonNull String OPPOSITE_INDEX_2_PROPERTY_ID_NAME = "oppositeIndex2propertyIdName";
	private static final @NonNull String OUTPUT_SPECULATION_SLOT_STATE_NAME = "outputSpeculatingSlotState";
	private static final @NonNull String OUTPUT_SPECULATION_SLOT_STATUS_NAME = "outputSpeculatingSlotStatus";
	private static final @NonNull String TRANSFORMATION_EXECUTION_NAME = "transformationExecution";
	private static final @NonNull String TRANSFORMATION_NAME = "transformation";

	/**
	 * Map from an oppositeProperty that requites a cache to the global name of that cache.
	 */
	private /*@LazyNonNull*/ Map<@NonNull Property, @NonNull String> oppositeProperty2oppositeCacheName = null;

	protected final @NonNull NameResolution classId2AllClassIndexes;
	protected final @NonNull NameResolution classId2ClassId;
	protected final @NonNull NameResolution createFromStringName;
	protected final @NonNull NameResolution constructorName;
	protected final @NonNull NameResolution emptyListName;
	protected final @NonNull NameResolution getSpeculationSlotStateName;
	protected final @NonNull NameResolution getSpeculationStatusName;
	protected final @NonNull NameResolution getTransformationExecutionName;
	protected final @NonNull NameResolution inputSpeculationSlotStateName;
	protected final @NonNull NameResolution inputSpeculationSlotStatusName;
	protected final @NonNull NameResolution invocationHashCodeName;
	protected final @NonNull NameResolution modelsName;
	protected final @NonNull NameResolution needsSpeculationName;
	protected final @NonNull NameResolution objectManagerName;
	protected final @NonNull NameResolution oppositeIndex2PropertyIdName;
	protected final @NonNull NameResolution outputSpeculationSlotStateName;
	protected final @NonNull NameResolution outputSpeculationSlotStatusName;
	protected final @NonNull NameResolution transformationExecutionName;
	protected final @NonNull NameResolution transformationName ;

	public QVTiGlobalContext(@NonNull QVTiCodeGenerator codeGenerator) {
		super(codeGenerator);
		this.classId2AllClassIndexes = globalNameManager.declareGlobalName(null, CLASS_ID_2_ALL_CLASS_INDEXES_);
		this.classId2ClassId = globalNameManager.declareGlobalName(null, CLASS_ID_2_CLASS_ID_);
		this.constructorName = globalNameManager.declareGlobalName(null, CONSTRUCTOR_NAME);
		this.createFromStringName = globalNameManager.declareGlobalName(null, CREATE_FROM_STRING_NAME);
		this.emptyListName = globalNameManager.declareGlobalName(null, EMPTY_LIST_NAME);
		this.getSpeculationSlotStateName = globalNameManager.declareGlobalName(null, GET_SPECULATION_SLOT_STATE_NAME);
		this.getSpeculationStatusName = globalNameManager.declareGlobalName(null, GET_SPECULATION_STATUS_NAME);
		this.getTransformationExecutionName = globalNameManager.declareGlobalName(null, GET_TRANSFORMATION_EXECUTION_NAME);
		this.inputSpeculationSlotStateName = globalNameManager.declareGlobalName(null, INPUT_SPECULATION_SLOT_STATE_NAME);
		this.inputSpeculationSlotStatusName = globalNameManager.declareGlobalName(null, INPUT_SPECULATION_SLOT_STATUS_NAME);
		this.invocationHashCodeName = globalNameManager.declareGlobalName(null, INVOCATION_HASH_CODE_NAME);
		this.modelsName = globalNameManager.declareGlobalName(null, MODELS_NAME);
		this.needsSpeculationName = globalNameManager.declareGlobalName(null, NEEDS_SPECULATION_NAME);
		this.objectManagerName = globalNameManager.declareGlobalName(null, OBJECT_MANAGER_NAME);
		this.oppositeIndex2PropertyIdName = globalNameManager.declareGlobalName(null, OPPOSITE_INDEX_2_PROPERTY_ID_NAME);
		this.outputSpeculationSlotStateName = globalNameManager.declareGlobalName(null, OUTPUT_SPECULATION_SLOT_STATE_NAME);
		this.outputSpeculationSlotStatusName = globalNameManager.declareGlobalName(null, OUTPUT_SPECULATION_SLOT_STATUS_NAME);
		this.transformationExecutionName = globalNameManager.declareGlobalName(null, TRANSFORMATION_EXECUTION_NAME);
		this.transformationName = globalNameManager.declareGlobalName(null, TRANSFORMATION_NAME);
	}

	public @NonNull String addOppositeProperty(@NonNull Property pivotProperty) {
		assert !pivotProperty.isIsImplicit() && !pivotProperty.isIsComposite();
		if (oppositeProperty2oppositeCacheName == null) {
			oppositeProperty2oppositeCacheName = new HashMap<@NonNull Property, @NonNull String>();
		}
		if (!oppositeProperty2oppositeCacheName.containsKey(pivotProperty)) {
			oppositeProperty2oppositeCacheName.put(pivotProperty, globalNameManager.declareGlobalName(null, "OPPOSITE_OF_" + pivotProperty.getOwningClass().getName() + "_" + pivotProperty.getName()).getResolvedName());
		}
		String name = oppositeProperty2oppositeCacheName.get(pivotProperty);
		assert name != null;
		return name;
	}

	@Override
	public @NonNull QVTiLocalContext createLocalContext(@Nullable JavaLocalContext<@NonNull ?> outerContext, @NonNull CGNamedElement cgNamedElement, @NonNull NamedElement asNamedElement) {
		return new QVTiLocalContext(this, (QVTiLocalContext)outerContext, cgNamedElement, asNamedElement);
	}

	public @NonNull String getClassIndex2allClassIndexes(int typedModelNumber) {
		return globalNameManager.declareGlobalName(null, CLASS_ID_2_ALL_CLASS_INDEXES_ + typedModelNumber).getResolvedName();
	}

	public @NonNull String getClassIndex2classId(int typedModelNumber) {
		return globalNameManager.declareGlobalName(null, CLASS_ID_2_CLASS_ID_ + typedModelNumber).getResolvedName();
	}

	public @NonNull NameResolution getClassId2ClassId() {
		return classId2ClassId;
	}

	public @NonNull NameResolution getClassId2AllClassIndexes() {
		return classId2AllClassIndexes;
	}

	public @NonNull String getConstructorName() {
		return constructorName.getResolvedName();
	}

	public @NonNull NameResolution getCreateFromStringName() {
		return createFromStringName;
	}

	public @NonNull String getEmptyListName() {
		return emptyListName.getResolvedName();
	}

	public @NonNull String getGetSpeculationSlotStateName() {
		return getSpeculationSlotStateName.getResolvedName();
	}

	public @NonNull String getGetSpeculationStatusName() {
		return getSpeculationStatusName.getResolvedName();
	}

	public @NonNull String getGetTransformationExecutionName() {
		return getTransformationExecutionName.getResolvedName();
	}

	public @NonNull String getInputSpeculationSlotStateName() {
		return inputSpeculationSlotStateName.getResolvedName();
	}

	public @NonNull String getInputSpeculationSlotStatusName() {
		return inputSpeculationSlotStatusName.getResolvedName();
	}

	public @NonNull String getInvocationHashCodeName() {
		return invocationHashCodeName.getResolvedName();
	}

	@Override
	public @NonNull QVTiLocalContext getLocalContext( @NonNull CGNamedElement cgElement) {
		return (QVTiLocalContext)super.getLocalContext(cgElement);
	}

	public @NonNull String getModelsName() {
		return modelsName.getResolvedName();
	}

	public @NonNull String getNeedsSpeculationName() {
		return needsSpeculationName.getResolvedName();
	}

	public @NonNull String getObjectManagerName() {
		return objectManagerName.getResolvedName();
	}

	public @NonNull String getOppositeIndex2PropertyIdName() {
		return oppositeIndex2PropertyIdName.getResolvedName();
	}

	public @NonNull String getOutputSpeculationSlotStateName() {
		return outputSpeculationSlotStateName.getResolvedName();
	}

	public @NonNull String getOutputSpeculationSlotStatusName() {
		return outputSpeculationSlotStatusName.getResolvedName();
	}

	public @NonNull String getOppositeIndex2propertyIdName() {
		return globalNameManager.declareGlobalName(null, OPPOSITE_INDEX_2_PROPERTY_ID_NAME).getResolvedName();
	}

	public @Nullable Map<@NonNull Property, @NonNull String> getOppositeProperties() {
		return oppositeProperty2oppositeCacheName;
	}

	public @NonNull NameResolution getTransformationNameResolution() {
		return transformationName;
	}

	public @NonNull String getTransformationExecutionName() {
		return transformationExecutionName.getResolvedName();
	}
}
