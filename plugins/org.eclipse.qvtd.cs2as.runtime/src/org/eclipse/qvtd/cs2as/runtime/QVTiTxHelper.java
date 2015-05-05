package org.eclipse.qvtd.cs2as.runtime;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.evaluation.TransformationExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiPivotEvaluator;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperative;

public class QVTiTxHelper  {
	
	final private QVTimperative qvti; 
	
	public QVTiTxHelper(@NonNull QVTimperative qvti) {
		this.qvti = qvti;
	}

	private @NonNull QVTiEnvironmentFactory getEnvironmentFactory() {
		return (QVTiEnvironmentFactory) qvti.getEnvironmentFactory();
	}
	
	public @NonNull QVTiPivotEvaluator createEvaluator(Transformation transformation) {
		return new QVTiPivotEvaluator(getEnvironmentFactory(), transformation);
	}
	
	// FIXME why do we need this ?
	public @NonNull QVTiTxEvaluator createTxEvaluator(Class<? extends TransformationExecutor> txClass)
			throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		return new QVTiTxEvaluator(getEnvironmentFactory().getCompleteEnvironment(), txClass);
	}	

}
