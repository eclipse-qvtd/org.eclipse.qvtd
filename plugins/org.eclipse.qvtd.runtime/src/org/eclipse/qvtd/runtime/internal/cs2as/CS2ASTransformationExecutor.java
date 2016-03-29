package org.eclipse.qvtd.runtime.internal.cs2as;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.qvtd.runtime.evaluation.AbstractTransformationExecutor;

public class CS2ASTransformationExecutor extends AbstractTransformationExecutor {

	public CS2ASTransformationExecutor(@NonNull EnvironmentFactory environmentFactory,
			@NonNull Class<? extends CS2ASTransformer> txClass)
					throws ReflectiveOperationException {
		super(environmentFactory, txClass);
	}

	@Override
	public @NonNull CS2ASTransformer getTransformer() {
		return (CS2ASTransformer) super.getTransformer();
	}
}
