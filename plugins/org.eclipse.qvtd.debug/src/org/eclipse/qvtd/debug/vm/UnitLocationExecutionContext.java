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
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.pivot.Environment;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.VoidType;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.qvtd.debug.evaluator.IDebugEvaluationEnvironment;
import org.eclipse.qvtd.debug.evaluator.QvtRuntimeException;

public class UnitLocationExecutionContext implements VMFrameExecutionContext {

	private final Environment fEnv;
	private final IDebugEvaluationEnvironment fEvalEnv;

	UnitLocationExecutionContext(Environment environment, IDebugEvaluationEnvironment evaluationEnvironment) {
		if (environment == null || evaluationEnvironment == null) {
			throw new IllegalArgumentException();
		}
		
		fEnv = environment;
		fEvalEnv = evaluationEnvironment;
	}

	public Type getOCLType(Property feature) {
		return feature.getType();
//		return fEnv.getUMLReflection().getOCLType(feature);
	}
	
	public MetaModelManager getMetaModelManager() {	
		return fEnv.getMetaModelManager();
	}
	
	public DomainStandardLibrary getStandardLibrary() {	
		return fEnv.getOCLStandardLibrary();
	}
	
	public List<EStructuralFeature> getAllFeatures(EClass eClass) {
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
		return features;
	}

	public IDebugEvaluationEnvironment getEvalEnv() {
		return fEvalEnv;
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

/*	private void collectIntermediateProperties(List<EStructuralFeature> properties, EClass targetClass) {
		TypeInstance currentModule = fEvalEnv.getCurrentInstance();
		// check if we are in transformation execution context
		if(currentModule instanceof TransformationInstance) {
			collectIntermediateProperties(properties, targetClass, (TransformationInstance) currentModule);
		}
	} */
	
	// TODO - build a cache for all target types to avoid repeated lookups
/*	private void collectIntermediateProperties(List<EStructuralFeature> properties, EClass targetClass, TransformationInstance scopeModule) {
		Transformation transformation = scopeModule.getInstantiatedType();
		for (EStructuralFeature nextProperty : operationalTransformation.getIntermediateProperty()) {
			if(nextProperty instanceof ContextualProperty) {
				ContextualProperty ctxProperty = (ContextualProperty) nextProperty;
				if(ctxProperty.getContext().isSuperTypeOf(targetClass)) {            
		        	properties.add(ctxProperty);
				}
			}
		}

		for (TypeInstance importedModule : scopeModule.getImportedModules()) {
			if(importedModule instanceof TransformationInstance) {
				// Note: only transformation imported by <extends> have implicit module instances
				collectIntermediateProperties(properties, targetClass, (TransformationInstance) importedModule);
			}
		}
	} */
}
