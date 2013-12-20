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
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;

public interface VMFrameExecutionContext {
	
	Type getOCLType(Property feature);
	
//	List<EStructuralFeature> getAllFeatures(EClass eClass);
	/**
	 * TODO - 
	 * Note: with derived properties may execute QVTO engine, throw QVTRuntimeException!!!
	 * Should be evaluated at separate thread and QVTO Evaluator, to be interruptible
	 */
	Object getValue(Property feature, EObject target);
	
	EvaluationEnvironment getEvalEnv();
	MetaModelManager getMetaModelManager();
	DomainStandardLibrary getStandardLibrary();
}