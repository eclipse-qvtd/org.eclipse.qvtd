package org.eclipse.qvtd.build.cs2as.qvti;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.PropertyId;
import org.eclipse.qvtd.pivot.qvtbase.evaluation.AbstractTransformationExecutor;

public abstract class CS2ASTransformationExecutor extends AbstractTransformationExecutor
{

	protected CS2ASTransformationExecutor(@NonNull Evaluator evaluator, @NonNull String[] modelNames,
			@Nullable PropertyId[] propertyIndex2propertyId, @Nullable ClassId[] classIndex2classId, @Nullable int[][] classIndex2allClassIndexes) {
		super(evaluator, modelNames, propertyIndex2propertyId, classIndex2classId, classIndex2allClassIndexes);
	}
    
	protected void throwNull(@NonNull EObject csObject, @NonNull String message) {
		throw new CS2ASException(csObject, message);
	}
}
