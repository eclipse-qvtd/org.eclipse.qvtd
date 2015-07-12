package org.eclipse.qvtd.cs2as.compiler.tests;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.evaluation.tx.TransformationExecutor;
import org.eclipse.ocl.pivot.evaluation.tx.Transformer;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.BasicQVTiExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiTransformationExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperative;

public class QVTiTxHelper  {
	
	final private QVTimperative qvti; 
	
	public QVTiTxHelper(@NonNull QVTimperative qvti) {
		this.qvti = qvti;
	}

	private @NonNull QVTiEnvironmentFactory getEnvironmentFactory() {
		return (QVTiEnvironmentFactory) qvti.getEnvironmentFactory();
	}
	
	public @NonNull BasicQVTiExecutor createExecutor(Transformation transformation) {
		return new BasicQVTiExecutor(getEnvironmentFactory(), transformation);
	}
	
	// FIXME why do we need this ?
	public @NonNull TransformationExecutor createTxEvaluator(Class<? extends Transformer> txClass) throws ReflectiveOperationException {
		return new QVTiTransformationExecutor(getEnvironmentFactory(), txClass);
	}	

}
