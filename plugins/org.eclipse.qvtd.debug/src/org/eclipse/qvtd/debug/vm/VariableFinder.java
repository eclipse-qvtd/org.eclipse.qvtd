/*******************************************************************************
 * Copyright (c) 2009 R.Dvorak and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Radek Dvorak - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.debug.vm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypedElement;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.InvalidValue;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.qvtd.debug.evaluator.IDebugEvaluationEnvironment;
import org.eclipse.qvtd.debug.vm.protocol.VMResponse;
import org.eclipse.qvtd.debug.vm.protocol.VMType;
import org.eclipse.qvtd.debug.vm.protocol.VMValue;
import org.eclipse.qvtd.debug.vm.protocol.VMVariable;
import org.eclipse.qvtd.debug.vm.protocol.VMVariableRequest;
import org.eclipse.qvtd.debug.vm.protocol.VMVariableResponse;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiModelManager;

public class VariableFinder {

	private final @NonNull VMFrameExecutionContext fFeatureAccessor;
	private final boolean fIsStoreValues;
	private @Nullable VMVariable fTargetVar;
	private @Nullable String fRootDeclaredType;
	
	

	public VariableFinder(@NonNull VMFrameExecutionContext featureAccessor, boolean isStoreValues) {
		fFeatureAccessor = featureAccessor;
		fIsStoreValues = isStoreValues;
	}
	
	public static String computeDetail(URI variableURI, UnitLocationExecutionContext frameContext) {
		VariableFinder finder = new VariableFinder(frameContext, false);
		String[] variablePath = getVariablePath(variableURI);
		Object valueObject = finder.findStackObject(variablePath);
		
		if(valueObject != null) {
			try {
				return valueObject.toString();
			} catch(RuntimeException e) {
				// do nothing, empty detail will be returned
			}
		}
		return null;
	}
	
	public static VMResponse process(VMVariableRequest request,
			List<UnitLocation> stack, UnitLocationExecutionContext frameContext) {
		
		UnitLocation location = VMUtils.lookupEnvironmentByID(request.frameID, stack);
		if (location == null) {
			return VMResponse.createERROR();
		}

		String variableURIStr = request.variableURI;
		URI variableURI = parseURI(variableURIStr);

		String[] variablePath = getVariablePath(variableURI);

		VariableFinder variableManager = new VariableFinder(frameContext, false);
		
		List<VMVariable> variables = new ArrayList<VMVariable>();
		variableManager.find(variablePath, request.includeChildVars, variables);

		if (variables.isEmpty()) {
			return VMResponse.createERROR();
		}

		VMVariable[] children = null;
		if (variables.size() > 1) {
			children = variables.subList(1, variables.size()).toArray(
					new VMVariable[variables.size() - 1]);
		}

		return new VMVariableResponse(variables.get(0), children);
	}

	public void find(String[] objectPath, boolean fetchChildVariables, List<VMVariable> result) {
		if(objectPath == null) {
			throw new IllegalArgumentException("null variable path"); //$NON-NLS-1$
		}
		
		if(result == null || result.contains(null)) {
			throw new IllegalArgumentException("null result variables"); //$NON-NLS-1$
		}
		
		try {	
			Object referencedObj = findStackObject(objectPath);
			VMVariable variable = fTargetVar;

			if (variable != null) {
				result.add(variable);

				if (fetchChildVariables) {
					collectChildVars(referencedObj, objectPath, fRootDeclaredType, result);
				}
			}
		} finally {
			fTargetVar = null;
		}
	}

	
	private Object findStackObject(String[] varTreePath) {
		IDebugEvaluationEnvironment evalEnv = fFeatureAccessor.getEvalEnv();		
		String envVarName = varTreePath[0];
		Set<DomainTypedElement> variables = evalEnv.getVariables();
		Object rootObj = DomainUtil.getNamedElement(variables, envVarName);
		if (rootObj == null) { //&& !evalEnv.getNames().contains(envVarName)) {
			rootObj = getModelParameterVariables(evalEnv).get(envVarName);
			
		}
		fRootDeclaredType = "evalEnv.getTypeOf(envVarName)";
		if(rootObj != null && varTreePath.length == 1) {
			// refers to environment variable only
			String[] uri = new String[] { envVarName };
			fTargetVar = createVariable(envVarName, VMVariable.LOCAL, fRootDeclaredType, rootObj, createURI(uri).toString());
			return rootObj;
		}
		
		if(rootObj == null) {
			// can't navigate further via <null> object
			return null;
		}

		// navigate from the root object using the remaining variable path
		return findChildObject(rootObj, fRootDeclaredType, varTreePath, 1); 
	}
	
	private Object findChildObject(Object parentObj, @Nullable String optParentDeclaredType, String[] varTreePath, int pathIndex) {
		URI uri = createURI(varTreePath, pathIndex);
		// FIXME - deduce the type from actual type, ensure null is not propagated
		
		VMVariable childVar = null;
		Object nextObject = null;
		String nextDeclaredType = null;
		
		if (parentObj instanceof Resource) {
			parentObj = ((Resource)parentObj).getContents();
			nextDeclaredType = "QvtOperationalStdLibrary.INSTANCE.getElementType()";
		}
		
		if (parentObj instanceof EObject) {
			EObject eObject = (EObject) parentObj;
			EStructuralFeature eFeature = findFeature(varTreePath[pathIndex], eObject.eClass());
			if (eFeature != null) {
				Object value = this.fFeatureAccessor.getValue(eFeature, eObject);
				childVar = createFeatureVar(eFeature, value, uri.toString());
				nextObject = value;
				nextDeclaredType = "fFeatureAccessor.getOCLType(eFeature)";
			}
			
		} else if (parentObj instanceof Collection<?>) {
			Collection<?> collection = (Collection<?>) parentObj;
			int elementIndex = -1;
			try {
				elementIndex = Integer.parseInt(varTreePath[pathIndex]);
			} catch(NumberFormatException e) {
				// FIXME 
				throw new IllegalArgumentException();
			}
			
			if (elementIndex < 0 || elementIndex >= collection.size()) {
				// not valid element position in this collection
				throw new IllegalArgumentException();
			}
						
//			if (optParentDeclaredType instanceof CollectionType) {
//				CollectionType type = (CollectionType) optParentDeclaredType;
//				nextDeclaredType = "type.getElementType()";
//			} else if(nextDeclaredType == null) {
				// FIXME
				nextDeclaredType = "this.fFeatureAccessor.getStandardLibrary().getOclAny()";
//			}

			Object element = getElement(collection, elementIndex);
			
			childVar = createCollectionElementVar(elementIndex, element, nextDeclaredType, uri.toString());
			nextObject = element;
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

		this.fTargetVar = childVar;		
		return nextObject;
	}
	
	private @NonNull VMVariable createFeatureVar(EStructuralFeature feature, Object value, String uri) {
		String varName = feature.getName();
		String declaredType = "fFeatureAccessor.getOCLType(feature)";
		
		int kind = VMVariable.ATTRIBUTE;
		if (feature instanceof EReference) {
			kind = VMVariable.REFERENCE;
		}
//		if (feature instanceof ContextualProperty) {
//			kind = VMVariable.INTERM_PROPERTY;
//		}
		
		return createVariable(varName, kind, declaredType, value, uri);
	}
	
	private @NonNull VMVariable createCollectionElementVar(int elementIndex, Object element, @Nullable String elementType, String uri) {
		String varName = "[" + elementIndex + "]"; //$NON-NLS-1$ //$NON-NLS-2$
		int kind = VMVariable.COLLECTION_ELEMENT;
		return createVariable(varName, kind, elementType, element, uri);
	}
	
/*	private VMVariable createDictionaryElementVar(Object key, Object value, @Nullable String elementType, String uri) {
		String varName = String.valueOf(key);
		int kind = VMVariable.COLLECTION_ELEMENT;
		return createVariable(varName, kind, elementType, value, uri);
	} */
	
	
	private @NonNull VMVariable createVariable(String varName, int kind, @Nullable String declaredType, Object varObj, String uri) {
		VMVariable result = new VMVariable();
		result.name = String.valueOf(varName);
		result.kind = kind;
		result.variableURI = uri;
		setValueAndType(result, varObj, declaredType, fFeatureAccessor.getEvalEnv());
		if (fIsStoreValues) {
			result.valueObject = varObj;
		}
		return result;
	}

	public static URI parseURI(String variableURI) throws IllegalArgumentException {
		return URI.createURI(variableURI);
	}

	public static String[] getVariablePath(URI variableURI) {
		String[] ids = new String[variableURI.segmentCount()];
		for (int i = 0; i < ids.length; i++) {
			ids[i] = URI.decode(variableURI.segment(i));
		}
		return ids;
	}

	public static String getRootVarName(URI variableURI) {
		if (variableURI.segmentCount() == 0) {
			throw new IllegalArgumentException();
		}
		return URI.decode(variableURI.segment(0));
	}

	public static URI createURI(String[] varPath) {
		return createURI(varPath, varPath.length - 1);
	}
	
	public static URI createURI(String[] varPath, int endIndex) {
		String[] segments = new String[endIndex + 1];
		for (int i = 0; i < segments.length; i++) {
			segments[i] =  URI.encodeSegment(varPath[i], true);
		}

		return URI.createHierarchicalURI(segments, null, null);
	}
	
	public void collectChildVars(Object root, String[] parentPath, @Nullable String containerType, List<VMVariable> result) {
		String childPath[] = new String[parentPath.length + 1];
		System.arraycopy(parentPath, 0, childPath, 0, parentPath.length);
		
		if (root instanceof Resource) {
			Resource model = (Resource) root;
			root = model.getContents();
			containerType = "(EClassifier)EcoreEnvironmentFactory.INSTANCE.createEnvironment().getOCLFactory().createSetType(QvtOperationalStdLibrary.INSTANCE.getElementType())";
		}
		
		if (root instanceof EObject) {
			EObject eObject = (EObject) root;
			EClass eClass = eObject.eClass();

			StringBuilder uriBuf = new StringBuilder();			
			List<EStructuralFeature> eAllFeatures = fFeatureAccessor.getAllFeatures(eClass);
			
			List<EClass> superClasses = eClass.getEAllSuperTypes();
			for (EStructuralFeature feature : eAllFeatures) {		
				EClass owner;
				
//				if(feature.eClass() == ExpressionsPackage.eINSTANCE.getContextualProperty()) {
//					ContextualProperty ctxProperty = (ContextualProperty) feature;
//					owner = ctxProperty.getContext();
					
//					uriBuf.append('+');//.append(intermPropIndex++);
//				} else {
					owner = feature.getEContainingClass();
//				}
							
				int index = superClasses.indexOf(owner);
				uriBuf.append(index < 0 ? 0 : index);
				uriBuf.append('.').append(feature.getName());
				
				childPath[childPath.length - 1] = uriBuf.toString();
				VMVariable elementVar = createFeatureVar(feature, fFeatureAccessor.getValue(feature, eObject), createURI(childPath).toString());
				result.add(elementVar);
				
				uriBuf.setLength(0);
			}
		} else if(root instanceof Collection<?>) {
			Collection<?> elements = (Collection<?>) root;
			String elementType = "(containerType instanceof CollectionType) ? ((CollectionType) containerType) .getElementType() : fFeatureAccessor.getStandardLibrary().getOclAny()";
									
//			Dictionary<Object, Object> asDictionary = null;
//			if(root instanceof Dictionary<?, ?>) {
//				@SuppressWarnings("unchecked")
//				Dictionary<Object, Object> dict = (Dictionary<Object, Object>) root;
//				asDictionary = dict;
//				elements = asDictionary.keys();
//			}			
			
			int i = 0;
			for (Object element : elements) {
				childPath[childPath.length - 1] = String.valueOf(i);
				VMVariable elementVar;
//				if(asDictionary == null) {
					elementVar = createCollectionElementVar(i, element, elementType, createURI(childPath).toString());
//				} else {
//					Object key = element;
//					Object value = asDictionary.get(element);
//					elementVar = createDictionaryElementVar(key, value, elementType, createURI(childPath).toString());
//				}
				result.add(elementVar);
				i++;
			}
		}
	}
	
	private static EClass selectEClass(EClass eClass, int index) {
		if(index > 0) {
			EList<EClass> superClasses = eClass.getEAllSuperTypes();
			if(index < superClasses.size()) {
				return superClasses.get(index);
			}
		}
		
		return eClass;
	}

	private Object getElement(Collection<?> collection, int index) {
		if (collection instanceof EList<?>) {
			EList<?> eList = (EList<?>) collection;
			return eList.get(index);
		}

		int curr = 0;
		for (Iterator<?> it = collection.iterator(); it.hasNext();) {
			Object object = it.next();
			if (curr++ == index) {
				return object;
			}
		}
		return null;
	}

	private EStructuralFeature findFeature(String featureRef, EClass actualTarget) {
		String actualRef = featureRef.startsWith("+") ? featureRef.substring(1) : featureRef;
		boolean isIntermediate = featureRef.length() != actualRef.length();
		
		int classIndex;
		String featureName;
		try {
			int delimiterPos = actualRef.indexOf('.');
			if(delimiterPos <= 0 || delimiterPos >= actualRef.length() - 1) {
				throw new IllegalArgumentException("navigatin feature: " + actualRef);
			}
			
 			classIndex = Integer.parseInt(actualRef.substring(0, delimiterPos));
 			featureName = actualRef.substring(delimiterPos + 1);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Illegal feature reference: " + featureRef);
		}
		
		EClass featureOwner = selectEClass(actualTarget, classIndex);
		if(featureOwner == null) {
			return null;
		}
		
		if(!isIntermediate) {
			return featureOwner.getEStructuralFeature(featureName);
		}
		
//		EClass contextualPropMetaClass = ExpressionsPackage.eINSTANCE.getContextualProperty();
		
//		for (EStructuralFeature feature : actualTarget.getEAllStructuralFeatures()) {					
//			if(feature.eClass() == contextualPropMetaClass && feature.equals(feature.getName())) {
//				return feature;
//			}
//		}
		
		return null;
	}

	static List<VMVariable> getVariables(IDebugEvaluationEnvironment evalEnv) {
		List<VMVariable> result = new ArrayList<VMVariable>();

		for (DomainTypedElement variable : evalEnv.getVariables()) {
			String varName = variable.getName();
			VMVariable var = new VMVariable();
			var.name = varName;
			if(isPredefinedVar(varName, evalEnv)) {
				var.kind = VMVariable.PREDEFINED_VAR;
			}

			Object value = evalEnv.getValueOf(variable);
			DomainType declaredType = variable.getType();
			setValueAndType(var, value, declaredType, evalEnv);

			result.add(var);
		}
		
		Map<String, Resource> modelParameterVariables = getModelParameterVariables(evalEnv);
		for (String modelParam : modelParameterVariables.keySet()) {
			Resource model = modelParameterVariables.get(modelParam);
			VMVariable var = new VMVariable();
			var.name = modelParam;
			setValueAndType(var, model, model != null ? model.getURI().toString() : "$middle$", evalEnv);
			var.kind = VMVariable.MODEL_PARAMETER; 
			
			result.add(var);
		}
		return result;
	}

	public static void setValueAndType(@NonNull VMVariable variable, @Nullable Object value, @Nullable DomainType optDeclaredType, @NonNull EvaluationEnvironment evalEnv) {
		String declaredTypeName = (optDeclaredType != null) ? optDeclaredType.getName() : null;
		setValueAndType(variable, value, declaredTypeName, evalEnv);
	}

	public static void setValueAndType(@NonNull VMVariable variable, @Nullable Object value, @Nullable EClassifier optDeclaredType, @NonNull EvaluationEnvironment evalEnv) {
		String declaredTypeName = (optDeclaredType != null) ? optDeclaredType.getName() : null;
		setValueAndType(variable, value, declaredTypeName, evalEnv);
	}

	public static void setValueAndType(@NonNull VMVariable variable, @Nullable Object value, @Nullable String declaredTypeName, @NonNull EvaluationEnvironment evalEnv) {
		VMValue vmValue;
		VMType vmType;
		if (value == null) {
			vmType = new VMType(VMType.DATATYPE, "OclVoid", declaredTypeName); //$NON-NLS-1$
			vmValue = null;
		} else if (value instanceof InvalidValue) {
			vmType = new VMType(VMType.DATATYPE, "OclInvalid", declaredTypeName); //$NON-NLS-1$
			vmValue = VMValue.invalid();
		} else if (value instanceof EObject) {
			EObject eObject = (EObject) value;
			EClass eClass = eObject.eClass();
			String strVal = eClass.getName() + " @" + Integer.toHexString(System.identityHashCode(value));
			boolean hasVariables = !eClass.getEAllStructuralFeatures().isEmpty() || value instanceof Resource;
			vmValue = new VMValue(VMValue.OBJECT_REF, strVal, hasVariables);
			vmType = new VMType(VMType.EOBJECT, eClass.getName(), declaredTypeName);
		} else if (value instanceof Collection<?>) {
			Collection<?> collection = (Collection<?>) value;
			Class<?> javaType = value.getClass();

			StringBuilder strVal = new StringBuilder();
			if (declaredTypeName != null) {
				strVal.append(declaredTypeName);
			} else {
				strVal.append(javaType.getSimpleName());
			}

			strVal.append('[').append(collection.size()).append(']');
			vmValue = new VMValue(VMValue.COLLECTION_REF, strVal.toString(),
					!collection.isEmpty());
			// TODO - use mapping by runtime class to OCL type
			vmType = new VMType(VMType.COLLECTION, javaType
					.getSimpleName(), declaredTypeName);
			
		} else {
			// everything else we see as a data type
			String valueOf = String.valueOf(value);
			if (value.getClass().equals(String.class)) {
				valueOf = "\"" + valueOf + "\"";
			}
			vmValue = new VMValue(VMValue.PRIMITIVE, valueOf);
			vmType = new VMType(VMType.DATATYPE, value.getClass()
					.getSimpleName(), declaredTypeName);
		}
		variable.type = vmType;
		variable.value = vmValue;
	}
	
	private static Map<String, Resource> getModelParameterVariables(IDebugEvaluationEnvironment evalEnv) {
		IDebugEvaluationEnvironment internEvalEnv = evalEnv;
		Transformation currentModule = internEvalEnv.getTransformation();		
//		if (!(currentModule instanceof Transformation)) {
//			return Collections.emptyMap();
//		}

		Map<String, Resource> result = new HashMap<String, Resource>(2);
		Transformation currentTransformation = currentModule;
		QVTiModelManager modelManager = evalEnv.getModelManager();
		for (TypedModel typedModel : currentTransformation.getModelParameter()) {
			Resource model = modelManager.getModel(typedModel);
			result.put(typedModel.getName(), model);
		}
		
//		ModelInstance intermModel = currentTransformation.getAdapter(
//				TransformationInstance.InternalTransformation.class)
//				.getIntermediateExtent();
//		if(intermModel != null) {
//			result.put("_intermediate", intermModel);
//		}
		
		return result;
	}
	
	private static boolean isPredefinedVar(String name, IDebugEvaluationEnvironment evalEnv) {
		if(("self".equals(name) || "result".equals(name)) && evalEnv.getOperation() != null) {
			return true;
		}
		return "this".equals(name);
	}
}
