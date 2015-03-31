package org.eclipse.qvtd.build.cs2as.qvti;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.PropertyId;
import org.eclipse.qvtd.pivot.qvtbase.evaluation.AbstractTransformationExecutor;
import org.eclipse.xtext.diagnostics.Diagnostic;

public abstract class CS2ASTransformationExecutor extends AbstractTransformationExecutor
{

	private final List<Diagnostic> txErrors = new ArrayList<Diagnostic>(); 
	
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
	
	protected void handleError(EObject sourceObject, String errorMessage) {
		txErrors.add(new CS2ASDiagnostic(sourceObject, errorMessage));
	}
	
	
	public List<Diagnostic> getErrors() {
		return txErrors;
	}
}
