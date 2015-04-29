package org.eclipse.qvtd.cs2as.compiler.qvti;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.ocl.pivot.CompleteEnvironment;
import org.eclipse.qvtd.pivot.qvtbase.evaluation.AbstractTransformationEvaluator;
import org.eclipse.qvtd.pivot.qvtbase.evaluation.TransformationExecutor;

public class QVTiTxEvaluator extends AbstractTransformationEvaluator {

	public QVTiTxEvaluator(CompleteEnvironment environment, Class<? extends TransformationExecutor> txClass)
			throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		super(environment, txClass);
	}

}
