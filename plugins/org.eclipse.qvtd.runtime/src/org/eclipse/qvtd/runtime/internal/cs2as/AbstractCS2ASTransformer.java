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
package org.eclipse.qvtd.runtime.internal.cs2as;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.PropertyId;
import org.eclipse.qvtd.runtime.evaluation.AbstractTransformer;


public abstract class AbstractCS2ASTransformer extends AbstractTransformer
	implements CS2ASTransformer
{

	private final List<CS2ASDiagnostic> txErrors = new ArrayList<CS2ASDiagnostic>(); 
	
	protected AbstractCS2ASTransformer(@NonNull Executor executor, @NonNull String @NonNull [] modelNames,
			@NonNull PropertyId @Nullable [] propertyIndex2propertyId, @NonNull ClassId @Nullable [] classIndex2classId, int @Nullable [] @NonNull [] classIndex2allClassIndexes) {
		super(executor, modelNames, propertyIndex2propertyId, classIndex2classId, classIndex2allClassIndexes);
	}

	protected @NonNull RuntimeException throwNull(@NonNull EObject csObject, @NonNull String message) {
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
		txErrors.add(new CS2ASDiagnostic(sourceObject, errorMessage));
	}
	
	@Override
	public List<CS2ASDiagnostic> getErrors() {
		return txErrors;
	}
}
