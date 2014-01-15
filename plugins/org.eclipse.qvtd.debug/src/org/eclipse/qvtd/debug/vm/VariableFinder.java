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
import java.util.Collections;
import java.util.Comparator;
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
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.VoidType;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.qvtd.debug.evaluator.IDebugEvaluationEnvironment;
import org.eclipse.qvtd.debug.evaluator.QvtRuntimeException;
import org.eclipse.qvtd.debug.vm.protocol.VMResponse;
import org.eclipse.qvtd.debug.vm.protocol.VMType;
import org.eclipse.qvtd.debug.vm.protocol.VMValue;
import org.eclipse.qvtd.debug.vm.protocol.VMVariable;
import org.eclipse.qvtd.debug.vm.protocol.VMVariableRequest;
import org.eclipse.qvtd.debug.vm.protocol.VMVariableResponse;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiModelManager;

public class VariableFinder
{
	public static String computeDetail(URI variableURI, @NonNull IDebugEvaluationEnvironment fEvalEnv) {
		VariableFinder finder = new VariableFinder(fEvalEnv, false);
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
	
	public static List<EStructuralFeature> getAllFeatures(@NonNull EClass eClass) {
		List<EStructuralFeature> features = new ArrayList<EStructuralFeature>();
		features.addAll(eClass.getEAllStructuralFeatures());
/* 		if (eClass instanceof Root) {
			for (Iterator<EStructuralFeature> it = features.iterator(); it.hasNext();) {
				EStructuralFeature feature = it.next();
				if(feature instanceof ContextualProperty) {
					it.remove();
				}
			}
		}
		collectIntermediateProperties(features, eClass); */
		Collections.sort(features, new Comparator<EStructuralFeature>() {
			public int compare(EStructuralFeature var1, EStructuralFeature var2) {
				String n1 = var1.getName();
				String n2 = var2.getName();
				if (n1 == null) n1 = "";
				if (n2 == null) n2 = "";
				return n1.compareTo(n2);
			}
		});
		return features;
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
			if (typedModel != null) {
				Resource model = modelManager.getModel(typedModel);
				result.put(typedModel.getName(), model);
			}
		}
		
//		ModelInstance intermModel = currentTransformation.getAdapter(
//				TransformationInstance.InternalTransformation.class)
//				.getIntermediateExtent();
//		if(intermModel != null) {
//			result.put("_intermediate", intermModel);
//		}
		
		return result;
	}
	
	private static @NonNull String getOCLType(@NonNull EStructuralFeature feature) {
		return getOCLType(feature.getEType(), feature.isUnique(), feature.isOrdered(), feature.getLowerBound(), feature.getUpperBound());
	}
	
	private static @NonNull String getOCLType(@Nullable EClassifier eType, boolean isUnique, boolean isOrdered, int lowerBound, int upperBound) {
		StringBuilder s = new StringBuilder();
		if (eType == null) {
			s.append("null");
		}
		else if (upperBound != 1) {
			if (isUnique) {
				s.append(isOrdered ? "OrderedSet" : "Set");
			}
			else {
				s.append(isOrdered ? "Sequence" : "Bag");
			}
			s.append("(");
			s.append(eType.getName());
			DomainUtil.formatMultiplicity(s, lowerBound, upperBound);
			s.append(")");
		}
		else {
			s.append(eType.getName());
		}
		@SuppressWarnings("null")@NonNull String string = s.toString();
		return string;
	}

	public static String getRootVarName(URI variableURI) {
		if (variableURI.segmentCount() == 0) {
			throw new IllegalArgumentException();
		}
		return URI.decode(variableURI.segment(0));
	}

	static List<VMVariable> getVariables(IDebugEvaluationEnvironment evalEnv) {
		List<VMVariable> result = new ArrayList<VMVariable>();

		for (DomainTypedElement variable : evalEnv.getVariables()) {
			String varName = variable.getName();
			VMVariable var = new VMVariable();
			var.name = varName;
			if (isPredefinedVar(varName, evalEnv)) {
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
	
	private static boolean isPredefinedVar(String name, IDebugEvaluationEnvironment evalEnv) {
		if(("self".equals(name) || "result".equals(name)) && evalEnv.getOperation() != null) {
			return true;
		}
		return "this".equals(name);
	}

	public static String[] getVariablePath(URI variableURI) {
		String[] ids = new String[variableURI.segmentCount()];
		for (int i = 0; i < ids.length; i++) {
			ids[i] = URI.decode(variableURI.segment(i));
		}
		return ids;
	}

	public static URI parseURI(String variableURI) throws IllegalArgumentException {
		return URI.createURI(variableURI);
	}
	
	public static VMResponse process(@NonNull VMVariableRequest request,
			List<UnitLocation> stack, @NonNull IDebugEvaluationEnvironment fEvalEnv) {
		
		UnitLocation location = VMUtils.lookupEnvironmentByID(request.frameID, stack);
		if (location == null) {
			return VMResponse.createERROR();
		}

		String variableURIStr = request.variableURI;
		URI variableURI = parseURI(variableURIStr);

		String[] variablePath = getVariablePath(variableURI);

		VariableFinder variableManager = new VariableFinder(fEvalEnv, false);
		
		List<VMVariable> variables = new ArrayList<VMVariable>();
		variableManager.find(variablePath, request.includeChildVars, variables);

		if (variables.isEmpty()) {
			return VMResponse.createERROR();
		}

		VMVariable[] children = null;
		int size = variables.size();
		if (size > 1) {
			children = variables.subList(1, size).toArray(new VMVariable[size - 1]);
		}
		VMVariable variable0 = variables.get(0);
		return variable0 != null ? new VMVariableResponse(variable0, children) : null;
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

	public static void setValueAndType(@NonNull VMVariable variable, @Nullable Object value, @Nullable DomainType optDeclaredType, @NonNull EvaluationEnvironment evalEnv) {
		String declaredTypeName = (optDeclaredType != null) ? optDeclaredType.toString() : null;
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
		} else if (value instanceof Resource) {
			Resource resource = (Resource) value;
//			EClass eClass = eObject.eClass();
			String strVal = String.valueOf(resource.getURI());
			vmValue = new VMValue(VMValue.RESOURCE, strVal, true);
			vmType = new VMType(VMType.EOBJECT, resource.getClass().getSimpleName(), declaredTypeName);
		} else if (value instanceof EObject) {
			EObject eObject = (EObject) value;
			EClass eClass = eObject.eClass();
			String strVal = eClass.getEPackage().getName() + "::" + eClass.getName() + " @" + Integer.toHexString(System.identityHashCode(value));
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
			vmType = new VMType(VMType.COLLECTION, javaType.getSimpleName(), declaredTypeName);
			
		} else {
			// everything else we see as a data type
			String valueOf = String.valueOf(value);
			if (value.getClass().equals(String.class)) {
				valueOf = "\"" + valueOf + "\"";
			}
			vmValue = new VMValue(VMValue.PRIMITIVE, valueOf);
			vmType = new VMType(VMType.DATATYPE, value.getClass().getSimpleName(), declaredTypeName);
		}
		variable.type = vmType;
		variable.value = vmValue;
	}

	private final @NonNull IDebugEvaluationEnvironment fEvalEnv;
	private final boolean fIsStoreValues;
	private @Nullable VMVariable fTargetVar;
	private @Nullable String fRootDeclaredType;

	public VariableFinder(@NonNull IDebugEvaluationEnvironment fEvalEnv, boolean isStoreValues) {
		this.fEvalEnv = fEvalEnv;
		fIsStoreValues = isStoreValues;
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
			@SuppressWarnings("null")@NonNull EClass eClass = eObject.eClass();

			StringBuilder uriBuf = new StringBuilder();			
			List<EStructuralFeature> eAllFeatures = getAllFeatures(eClass);
			
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
				VMVariable elementVar = createFeatureVar(feature, getValue(feature, eObject), createURI(childPath).toString());
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
	
	private @NonNull VMVariable createFeatureVar(EStructuralFeature feature, Object value, String uri) {
		String varName = feature.getName();
		String declaredType = getOCLType(feature);
		
		int kind = VMVariable.ATTRIBUTE;
		if (feature instanceof EReference) {
			kind = VMVariable.REFERENCE;
		}
//		if (feature instanceof ContextualProperty) {
//			kind = VMVariable.INTERM_PROPERTY;
//		}
		
		return createVariable(varName, kind, declaredType, value, uri);
	}

	private @NonNull VMVariable createVariable(String varName, int kind, @Nullable String declaredType, Object varObj, String uri) {
		VMVariable result = new VMVariable();
		result.name = String.valueOf(varName);
		result.kind = kind;
		result.variableURI = uri;
		setValueAndType(result, varObj, declaredType, fEvalEnv);
		if (fIsStoreValues) {
			result.valueObject = varObj;
		}
		return result;
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
				Object value = getValue(eFeature, eObject);
				childVar = createFeatureVar(eFeature, value, uri.toString());
				nextObject = value;
				nextDeclaredType = getOCLType(eFeature);
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
				nextDeclaredType = "OclAny";
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
	
	private Object findStackObject(String[] varTreePath) {
		String envVarName = varTreePath[0];
		Set<DomainTypedElement> variables = fEvalEnv.getVariables();
		Object rootObj = DomainUtil.getNamedElement(variables, envVarName);
		if (rootObj instanceof Variable) {
			rootObj = fEvalEnv.getValueOf((DomainTypedElement)rootObj);
		}
		if (rootObj == null) { //&& !evalEnv.getNames().contains(envVarName)) {
			rootObj = getModelParameterVariables(fEvalEnv).get(envVarName);
			
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

	public Object getValue(EStructuralFeature feature, EObject target) {
		return /*fEvalEnv*/navigateProperty(feature, null, target);
//		throw new UnsupportedOperationException();
	}

//	@Override
	public Object navigateProperty(EStructuralFeature property, List<?> qualifiers, Object target) throws IllegalArgumentException {
/*		if(target instanceof ModuleInstance) {
			ModuleInstance moduleTarget = (ModuleInstance) target;
			EClassifier owningClassifier = QvtOperationalStdLibrary.INSTANCE.getEnvironment().getUMLReflection().getOwningClassifier(property);			
			if (owningClassifier instanceof Module) {
				target = moduleTarget.getThisInstanceOf((Module) owningClassifier);
			}
			else {
				target = moduleTarget.getThisInstanceOf(moduleTarget.getModule());
			}
		} */

		EStructuralFeature resolvedProperty = property;		

//		if (property instanceof ContextualProperty) {
//			IntermediatePropertyModelAdapter.ShadowEntry shadow = IntermediatePropertyModelAdapter.getPropertyHolder(
//														property.getEContainingClass(), (ContextualProperty)property, target);
//			target = shadow.getPropertyRuntimeOwner(target, this);
//			resolvedProperty = shadow.getProperty();
//		}
		
		// FIXME - workaround for a issue of multiple typle type instances, possibly coming from 
		// imported modules. The super impl. looks for the property by feature instance, do it
		// by name here to avoid lookup failure, IllegalArgExc...
/*		if(target instanceof Tuple<?, ?>) {
			if (target instanceof EObject) {
	            EObject etarget = (EObject) target;
	            resolvedProperty = etarget.eClass().getEStructuralFeature(property.getName());
	            if(resolvedProperty == null) { 
	            	return null;
	            }
			}
			else {
				resolvedProperty = null;
				for (EStructuralFeature feature : ((Tuple<EOperation, EStructuralFeature>) target).getTupleType().oclProperties()) {
					if (property.getName().equals(feature.getName())) {
						resolvedProperty = feature;
						break;
					}
				}
	            if(resolvedProperty == null) { 
	            	return null;
	            }
			}
		}
		else if(property.getEType() instanceof CollectionType<?, ?> && target instanceof EObject) {
			// module property of direct OCL collection type => override the super impl which coerce the result value 
			// and takes only the first element and returns from navigate call
            EObject eTarget = (EObject) target;
            if (eTarget.eClass().getEAllStructuralFeatures().contains(resolvedProperty)) {
                return eTarget.eGet(resolvedProperty, true);
            }
		} */
		
		try {
			return superNavigateProperty(resolvedProperty, qualifiers, target);
		}
		catch (IllegalArgumentException e) {
            fEvalEnv.throwQVTException(new QvtRuntimeException("Unknown property '" + property.getName() + "'", e)); //$NON-NLS-1$ //$NON-NLS-2$
			return ValuesUtil.INVALID_VALUE; //getInvalidResult();
		}
	}
	// implements the inherited specification
	public Object superNavigateProperty(EStructuralFeature property,
			List<?> qualifiers, Object target)
			throws IllegalArgumentException {

		if (target instanceof EObject) {
			EObject etarget = (EObject) target;

			if (etarget.eClass().getEAllStructuralFeatures().contains(property)) {
				if (property.getEType() instanceof VoidType) {
					// then the only instance is null; using eGet would
					// cause a ClassCastException because VoidTypeImpl
					// is neither an EClass nor an EDataType.
					return null;
				}
				return /*coerceValue(property,*/ etarget.eGet(property)/*, true)*/;
			}
    	} /*else if (target instanceof Tuple<?, ?>) {
    		@SuppressWarnings("unchecked")
    		Tuple<EOperation, EStructuralFeature> tuple = (Tuple<EOperation, EStructuralFeature>) target;
    		
    		if (tuple.getTupleType().oclProperties().contains(property)) {
    			return tuple.getValue(property);
    		}
    	} */

		throw new IllegalArgumentException();
	}
}
