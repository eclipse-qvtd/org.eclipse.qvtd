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
package org.eclipse.qvtd.codegen.qvti.naming;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.naming.ClassNameManager;
import org.eclipse.ocl.examples.codegen.naming.ExecutableNameManager;
import org.eclipse.ocl.examples.codegen.naming.GlobalNameManager;
import org.eclipse.ocl.examples.codegen.naming.NameResolution;
import org.eclipse.qvtd.codegen.qvti.java.QVTiCodeGenerator;
import org.eclipse.qvtd.codegen.qvti.java.QVTiCodeGenerator.QVTiNameManagerHelper;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMapping;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingLoop;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.EntryPointsAnalysis;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;

import com.google.common.collect.Iterables;

/**
 * QVTiGlobalNameManager supports the many QVTi-specifiic global names.
 */
public class QVTiGlobalNameManager extends GlobalNameManager
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
	private static final @NonNull String THIS_TRANSFORMER_NAME = "thisTransformer";
	private static final @NonNull String TRANSFORMATION_EXECUTION_NAME = "transformationExecution";
	private static final @NonNull String TRANSFORMATION_NAME = "transformation";

	protected @NonNull NameResolution @Nullable [] classId2AllClassIndexes;
	protected @NonNull NameResolution @Nullable [] classId2ClassId;
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
		this.classId2AllClassIndexes = null; //globalNameManager.declareEagerName(null, CLASS_ID_2_ALL_CLASS_INDEXES_);
		this.classId2ClassId = null; //globalNameManager.declareEagerName(null, CLASS_ID_2_CLASS_ID_);
		this.constructorName = globalNameManager.declareEagerName(null, CONSTRUCTOR_NAME);
		this.createFromStringName = globalNameManager.declareEagerName(null, CREATE_FROM_STRING_NAME);
		this.emptyListName = globalNameManager.declareEagerName(null, EMPTY_LIST_NAME);
		this.getSpeculationSlotStateName = globalNameManager.declareEagerName(null, GET_SPECULATION_SLOT_STATE_NAME);
		this.getSpeculationStatusName = globalNameManager.declareEagerName(null, GET_SPECULATION_STATUS_NAME);
		this.getTransformationExecutionName = globalNameManager.declareEagerName(null, GET_TRANSFORMATION_EXECUTION_NAME);
		this.inputSpeculationSlotStateName = globalNameManager.declareEagerName(null, INPUT_SPECULATION_SLOT_STATE_NAME);
		this.inputSpeculationSlotStatusName = globalNameManager.declareEagerName(null, INPUT_SPECULATION_SLOT_STATUS_NAME);
		this.invocationHashCodeName = globalNameManager.declareEagerName(null, INVOCATION_HASH_CODE_NAME);
		this.modelsName = globalNameManager.declareEagerName(null, MODELS_NAME);
		this.needsSpeculationName = globalNameManager.declareEagerName(null, NEEDS_SPECULATION_NAME);
		this.objectManagerName = globalNameManager.declareEagerName(null, OBJECT_MANAGER_NAME);
		this.oppositeIndex2PropertyIdName = globalNameManager.declareEagerName(null, OPPOSITE_INDEX_2_PROPERTY_ID_NAME);
		this.outputSpeculationSlotStateName = globalNameManager.declareEagerName(null, OUTPUT_SPECULATION_SLOT_STATE_NAME);
		this.outputSpeculationSlotStatusName = globalNameManager.declareEagerName(null, OUTPUT_SPECULATION_SLOT_STATUS_NAME);
		this.thisTransformerName = globalNameManager.declareEagerName(null, THIS_TRANSFORMER_NAME);
		this.transformationExecutionName = globalNameManager.declareEagerName(null, TRANSFORMATION_EXECUTION_NAME);
		this.transformationName = globalNameManager.declareEagerName(null, TRANSFORMATION_NAME);
	}

	public @NonNull QVTiExecutableNameManager createMappingNameManager(@NonNull ClassNameManager transformationNameManager, @NonNull CGMapping cgMapping) {
		QVTiExecutableNameManager mappingNameManager = getCodeGenerator().createMappingNameManager(transformationNameManager, cgMapping);
		assert basicGetChildNameManager(cgMapping) == mappingNameManager;
		//	we could populate the cgScope to parent NameManager now but any CSE rewrite could invalidate this premature action.
		//	addNameManager(cgScope, nestedNameManager.getParent());
		return mappingNameManager;
	}

	// reuse createLoopNameManager
	public @NonNull ExecutableNameManager createExecutableNameManager(@NonNull ClassNameManager transformationNameManager, @NonNull ExecutableNameManager parentNameManager, @NonNull CGMappingLoop cgMappingLoop) {
		ExecutableNameManager mappingLoopNameManager = getCodeGenerator().createExecutableNameManager(transformationNameManager, parentNameManager, cgMappingLoop);
		assert basicGetChildNameManager(cgMappingLoop) == mappingLoopNameManager;
		//	we could populate the cgScope to parent NameManager now but any CSE rewrite could invalidate this premature action.
		//	addNameManager(cgScope, nestedNameManager.getParent());
		return mappingLoopNameManager;
	}

	public @NonNull NameResolution getClassIndex2AllClassIndexes(int typedModelNumber) {
		assert classId2AllClassIndexes != null;
		return classId2AllClassIndexes[typedModelNumber]; //globalNameManager.declareEagerName(null, CLASS_ID_2_ALL_CLASS_INDEXES_ + typedModelNumber).getResolvedName();
	}

	public @NonNull NameResolution getClassIndex2ClassId(int typedModelNumber) {
		assert classId2ClassId != null;
		return classId2ClassId[typedModelNumber]; //globalNameManager.declareEagerName(null, CLASS_ID_2_CLASS_ID_ + typedModelNumber).getResolvedName();
	}

	@Override
	public @NonNull QVTiCodeGenerator getCodeGenerator() {
		return (QVTiCodeGenerator)super.getCodeGenerator();
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

	public @NonNull String getThisTransformerName() {
		return thisTransformerName.getResolvedName();
	}

	@Override
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
		Iterable<@NonNull TypedModel> modelParameters = QVTimperativeUtil.getModelParameters(entryPointsAnalysis.getTransformation());
		int maxTypedModelNumber = Iterables.size(modelParameters);
		NameResolution[] classId2AllClassIndexes2 = this.classId2AllClassIndexes = new @NonNull NameResolution[maxTypedModelNumber]; //globalNameManager.declareEagerName(null, CLASS_ID_2_ALL_CLASS_INDEXES_);
		NameResolution[] classId2ClassId2 = this.classId2ClassId = new @NonNull NameResolution[maxTypedModelNumber]; //globalNameManager.declareEagerName(null, CLASS_ID_2_CLASS_ID_);
		for (@SuppressWarnings("unused") @NonNull TypedModel typedModel : modelParameters) {
			classId2AllClassIndexes2[typedModelNumber] = globalNameManager.declareEagerName(null, CLASS_ID_2_ALL_CLASS_INDEXES_ + typedModelNumber);
			classId2ClassId2[typedModelNumber] = globalNameManager.declareEagerName(null, CLASS_ID_2_CLASS_ID_ + typedModelNumber);
			typedModelNumber++;
		}
	}
}
