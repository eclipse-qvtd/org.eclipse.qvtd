/*******************************************************************************
 * Copyright (c) 2013, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.codegen.qvti.java;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.analyzer.GlobalNameManager;
import org.eclipse.ocl.examples.codegen.analyzer.NameResolution;
import org.eclipse.qvtd.codegen.qvti.java.QVTiCodeGenerator.QVTiNameManagerHelper;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.EntryPointsAnalysis;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;

/**
 * QVTiGlobalNameManager supports the many QVTi-specifiic global names.
 */
public class QVTiGlobalNameManager extends GlobalNameManager
{
	private static final @NonNull String CACHED_RESULT_NAME = "cachedResult";
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
	private static final @NonNull String THIS_TRANSFORMER_NAME = "thisTransformer";
	private static final @NonNull String TRANSFORMATION_EXECUTION_NAME = "transformationExecution";
	private static final @NonNull String TRANSFORMATION_NAME = "transformation";

	protected final @NonNull NameResolution cachedResultName;
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
	protected final @NonNull NameResolution thisTransformerName;
	protected final @NonNull NameResolution transformationExecutionName;
	protected final @NonNull NameResolution transformationName ;

	public QVTiGlobalNameManager(@NonNull QVTiCodeGenerator codeGenerator, @NonNull QVTiNameManagerHelper helper) {
		super(codeGenerator, helper);
		this.cachedResultName = globalNameManager.declareGlobalName(null, CACHED_RESULT_NAME);
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
		this.thisTransformerName = globalNameManager.declareGlobalName(null, THIS_TRANSFORMER_NAME);
		this.transformationExecutionName = globalNameManager.declareGlobalName(null, TRANSFORMATION_EXECUTION_NAME);
		this.transformationName = globalNameManager.declareGlobalName(null, TRANSFORMATION_NAME);
	}

	public @NonNull String getCachedResultName() {
		return cachedResultName.getResolvedName();
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

	public @NonNull String getThisTransformerName() {
		return thisTransformerName.getResolvedName();
	}

	public @NonNull NameResolution getThisTransformerNameResolution() {
		return thisTransformerName;
	}

	public @NonNull NameResolution getTransformationNameResolution() {
		return transformationName;
	}

	public @NonNull String getTransformationExecutionName() {
		return transformationExecutionName.getResolvedName();
	}

	public void reserveGlobalNames(@NonNull EntryPointsAnalysis entryPointsAnalysis) {
		int typedModelNumber = 0;
		for (@SuppressWarnings("unused") @NonNull TypedModel typedModel : QVTimperativeUtil.getModelParameters(entryPointsAnalysis.getTransformation())) {
			getClassIndex2allClassIndexes(typedModelNumber);
			getClassIndex2classId(typedModelNumber);
			typedModelNumber++;
		}
	}
}
