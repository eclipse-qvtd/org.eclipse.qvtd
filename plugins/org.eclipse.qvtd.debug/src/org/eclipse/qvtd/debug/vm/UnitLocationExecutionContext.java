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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.pivot.Environment;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.qvtd.debug.utils.IDebugEvaluationEnvironment;

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
	
	public DomainStandardLibrary getStandardLibrary() {	
		return fEnv.getOCLStandardLibrary();
	}
	
/*	public List<EStructuralFeature> getAllFeatures(EClass eClass) {
		List<EStructuralFeature> features = new ArrayList<EStructuralFeature>();
		features.addAll(eClass.getEAllStructuralFeatures());
		
		if(eClass instanceof Root) {
			for (Iterator<EStructuralFeature> it = features.iterator(); it.hasNext();) {
				EStructuralFeature feature = it.next();
				if(feature instanceof ContextualProperty) {
					it.remove();
				}
			}
		}
		
		collectIntermediateProperties(features, eClass);
		return features;
	} */

	public EvaluationEnvironment getEvalEnv() {
		return fEvalEnv;
	}

	public Object getValue(Property feature, EObject target) {
//		return fEvalEnv.navigateProperty(feature, null, target);
		throw new UnsupportedOperationException();
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
