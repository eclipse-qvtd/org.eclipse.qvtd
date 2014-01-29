package org.eclipse.qvtd.pivot.qvtimperative.evaluation;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.utilities.PivotEnvironment;

public class QVTiEnvironment extends PivotEnvironment
{
	public QVTiEnvironment(@NonNull QVTiEnvironmentFactory factory, @Nullable Resource resource) {
		super(factory, resource);
	}

	public QVTiEnvironment(@NonNull QVTiEnvironment parent) {
		super(parent);
	}

	@Override
	public @NonNull QVTiEnvironmentFactory getFactory() {
		return (QVTiEnvironmentFactory) super.getFactory();
	}
}
