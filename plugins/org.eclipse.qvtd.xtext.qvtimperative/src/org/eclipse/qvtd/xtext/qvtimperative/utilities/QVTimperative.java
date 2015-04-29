package org.eclipse.qvtd.xtext.qvtimperative.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbase;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;

public class QVTimperative extends QVTbase
{
	public QVTimperative(@NonNull QVTiEnvironmentFactory environmentFactory) {
		super(environmentFactory);
	}

	@Override
	public @NonNull QVTiEnvironmentFactory getEnvironmentFactory() {
		return (QVTiEnvironmentFactory) super.getEnvironmentFactory();
	}
}