/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.cs2as.runtime;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.evaluation.tx.AbstractTransformer;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.PropertyId;

public abstract class CS2ASTransformationExecutor extends AbstractTransformer
	implements CS2ASTransformation
{

	private final List<EObjectDiagnostic> txErrors = new ArrayList<EObjectDiagnostic>(); 
	
	protected CS2ASTransformationExecutor(@NonNull Evaluator evaluator, @NonNull String[] modelNames,
			@Nullable PropertyId[] propertyIndex2propertyId, @Nullable ClassId[] classIndex2classId, @Nullable int[][] classIndex2allClassIndexes) {
		super(evaluator, modelNames, propertyIndex2propertyId, classIndex2classId, classIndex2allClassIndexes);
	}

	protected void throwNull(@NonNull EObject csObject, @NonNull String message) {
		throw new CS2ASException(csObject, message);
	}
	
	protected void handleLookupError(EObject sourceObject, String lookupHint) {
		handleError(sourceObject, "''" + lookupHint +"'' not found");
	}
	
	protected void handleLookupError(EObject sourceObject, EObject lookupHint) {
		handleError(sourceObject, "''" + lookupHint.toString() +"'' not found");
	}
	
	protected void handleLookupError(List<? extends EObject> sourceObjects, EObject lookupHint) {
		int hintPos = sourceObjects.indexOf(lookupHint);
		switch (hintPos)  {
			case -1:
			case 0:
					hintPos = 0; // For safety, the default will be the first one
					break;
			default:
					// We assume the element from which we report is the previous one of the lookupHint
					hintPos = hintPos -1;
		}
		
		handleError(sourceObjects.get(hintPos), "''" + lookupHint.toString() +"'' not found"); 
	}
	
	protected void handleError(EObject sourceObject, String errorMessage) {
		txErrors.add(new CS2ASDiagnostic<EObject>(sourceObject, errorMessage));
	}
	
	public List<EObjectDiagnostic> getErrors() {
		return txErrors;
	}
}
