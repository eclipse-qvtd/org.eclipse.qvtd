/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.debug.vm;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.vm.VariableFinder;
import org.eclipse.ocl.examples.debug.vm.data.VMVariableData;
import org.eclipse.ocl.examples.debug.vm.evaluator.VMEvaluationEnvironment;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiModelManager;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiModelManager.QVTiTransformationInstance;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiModelManager.QVTiTypedModelInstance;

public class QVTiVariableFinder extends VariableFinder
{
	public QVTiVariableFinder(@NonNull VMEvaluationEnvironment vmEvaluationEnvironment, boolean isStoreValues) {
		super(vmEvaluationEnvironment, isStoreValues);
	}

	@Override
	public void collectChildVars(Object valueObject, @NonNull String @NonNull [] parentPath, @Nullable String containerType, @NonNull List<@NonNull VMVariableData> result) {
		if (valueObject instanceof QVTiTransformationInstance) {
			String childPath[] = new String[parentPath.length + 1];
			System.arraycopy(parentPath, 0, childPath, 0, parentPath.length);
			QVTiTransformationInstance transformationInstance = (QVTiTransformationInstance)valueObject;
			Transformation transformation = transformationInstance.getTransformation();
			for (TypedModel typedModel : transformation.getModelParameter()) {
				Variable variable = typedModel.getOwnedContext();
				String varName = typedModel.getName();
				assert varName != null;
				childPath[childPath.length - 1] = varName;
				VMVariableData elementVar = new VMVariableData(varName, createURI(childPath).toString());
				elementVar.kind = VMVariableData.MODEL_PARAMETER;
				QVTiModelManager modelManager = transformationInstance.getModelManager();
				Resource model = modelManager.getModel(typedModel);
				setValueAndType(elementVar, model, "TypedModel");
				if (fIsStoreValues) {
					elementVar.valueObject = variable;
				}
				result.add(elementVar);
			}
		}
		else if (valueObject instanceof QVTiTypedModelInstance) {
			QVTiTypedModelInstance typedModelInstance = (QVTiTypedModelInstance)valueObject;
			QVTiModelManager modelManager = typedModelInstance.getModelManager();
			TypedModel typedModel = typedModelInstance.getTypedModel();
			Resource model = modelManager.getModel(typedModel);
			super.collectChildVars(model, parentPath, containerType, result);
		}
		else {
			super.collectChildVars(valueObject, parentPath, containerType, result);
		}
	}

	@Override
	protected Object findChildObject(Object parentObj, @Nullable String optParentDeclaredType,
			@NonNull String @NonNull [] varTreePath, int pathIndex) {
		Object nextObject = null;
		String nextDeclaredType = null;
		if (parentObj instanceof QVTiTransformationInstance) {
			QVTiTransformationInstance transformationInstance = (QVTiTransformationInstance)parentObj;
			Transformation transformation = transformationInstance.getTransformation();
			TypedModel typedModel = transformation.getModelParameter(varTreePath[pathIndex]);
			QVTiModelManager modelManager = transformationInstance.getModelManager();
			nextObject = typedModel != null ? modelManager.getModel(typedModel) : null;
			nextDeclaredType = "Resource";
		}
		else if (parentObj instanceof QVTiTypedModelInstance) {
			QVTiTypedModelInstance typedModelInstance = (QVTiTypedModelInstance)parentObj;
			QVTiModelManager modelManager = typedModelInstance.getModelManager();
			TypedModel typedModel = typedModelInstance.getTypedModel();
			Resource model = modelManager.getModel(typedModel);
			return super.findChildObject(model, optParentDeclaredType, varTreePath, pathIndex);
		}
		else {
			return super.findChildObject(parentObj, optParentDeclaredType, varTreePath, pathIndex);
		}
		int nextIndex = pathIndex + 1;
		if (nextIndex < varTreePath.length) {
			if (nextObject != null) {
				// continue navigation in the hierarchy
				return findChildObject(nextObject, nextDeclaredType, varTreePath, nextIndex);
			} else {
				// we can't navigate further via the path due to <null> termination object
				return null;
			}
		}

//			this.fTargetVar = childVar;		
		return nextObject;
	}

	@Override
	protected String getDeclaredType(Object valueObject) {
		if (valueObject instanceof QVTiTransformationInstance) {
			return "qvtbaselibrary::Transformation";
//				return super.getDeclaredType(((QVTiTransformationInstance)valueObject).getTransformation());
		}
		else if (valueObject instanceof QVTiTypedModelInstance) {
			return "qvtbaselibrary::Model";
/*				QVTiTypedModelInstance typedModelInstance = (QVTiTypedModelInstance)valueObject;
				QVTiModelManager modelManager = typedModelInstance.getModelManager();
				TypedModel typedModel = typedModelInstance.getTypedModel();
				Resource model = modelManager.getModel(typedModel);
				return "Resource"; */
		}
		else {
			return super.getDeclaredType(valueObject);
		}
	}

	@Override
	protected @Nullable VMVariableData getVariable(@NonNull TypedElement variable, @Nullable Object pcObject) {
/*			EObject eContainer = variable.eContainer();
			if (eContainer instanceof Transformation) {
				Transformation transformation = (Transformation)eContainer;
				String varName = variable.getName();
				if (varName != null) {
					VMVariableData var = new VMVariableData(varName, null);
					var.valueObject = transformation;
					setValueAndType(var, transformation, "Transformation");
					return var;
				}
			}
			else if (eContainer instanceof TypedModel) {
				TypedModel typedModel = (TypedModel)eContainer;
				
				
				QVTiModelManager modelManager = (QVTiModelManager) fEvalEnv.getModelManager();
				Resource model = modelManager.getModel(typedModel);
				
				String varName = variable.getName();
				if (varName != null) {
					VMVariableData var = new VMVariableData(varName, null);
					var.valueObject = model;
					setValueAndType(var, model, "Resource");
					return var;
				}
			} */
		return super.getVariable(variable, pcObject);
	}

	@Override
	public void setValueAndType(@NonNull VMVariableData variable, @Nullable Object value, @Nullable String declaredTypeName) {
		if (value instanceof QVTiTransformationInstance) {
			super.setValueAndType(variable, ((QVTiTransformationInstance)value).getTransformation(), declaredTypeName);
		}
		else if (value instanceof QVTiTypedModelInstance) {
			QVTiTypedModelInstance typedModelInstance = (QVTiTypedModelInstance)value;
			QVTiModelManager modelManager = typedModelInstance.getModelManager();
			TypedModel typedModel = typedModelInstance.getTypedModel();
			Resource model = modelManager.getModel(typedModel);
			super.setValueAndType(variable, model, declaredTypeName);
//				Resource resource = (Resource) value;
//				EClass eClass = eObject.eClass();
//				@SuppressWarnings("null")@NonNull String strVal = String.valueOf(resource.getURI());
//				variable.value = new VMValueData(VMValueData.RESOURCE, strVal, true);
//				@SuppressWarnings("null")@NonNull String className = resource.getClass().getSimpleName();
//				variable.type = new VMTypeData(VMTypeData.RESOURCE, className, declaredTypeName);
		}
		else {
			super.setValueAndType(variable, value, declaredTypeName);
		}
	}
}